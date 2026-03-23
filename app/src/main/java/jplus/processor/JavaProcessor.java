/*
 * JADEx - Java Advanced Development Extension
 *
 * Copyright (C) 2026 Cheol Jeon <nieuwmijnleven@outlook.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 only,
 * as published by the Free Software Foundation.
 *
 * Alternatively, this software may be used under a commercial license
 * from Cheol Jeon.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU General Public License version 2 for more details:
 * <https://www.gnu.org/licenses/old-licenses/gpl-2.0.html>.
 *
 * For commercial licensing, please contact <nieuwmijnleven@outlook.com>.
 *
 * Contributors to this project must sign a Contributor License Agreement (CLA)
 * granting Cheol Jeon the right to relicense their contributions under
 * a commercial license. See the CLA file in the project root for details.
 */

package jplus.processor;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.Trees;
import jplus.analyzer.JavaSymbolAnalyzer;
import jplus.base.JavaMethodInvocationManager;
import jplus.base.MethodInvocationInfo;
import jplus.base.Project;
import jplus.base.SymbolTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class JavaProcessor {

    private static final Logger log = LoggerFactory.getLogger(JavaProcessor.class);

    private static final Object COMPILER_LOCK = new Object();
    private static JavaCompiler cachedCompilerRef;

    private final Project project;

    private List<InMemoryJavaFile> javaFiles;
    private String source;
    private SymbolTable globalSymbolTable;
    private List<JavaSymbolAnalyzer> symbolAnalyzerList;
    private boolean symbolsAnalyzed = false;

    private JavacTask task;
    private Iterable<? extends CompilationUnitTree> asts;
    private Trees trees;
    private Elements elements;
    private Types types;

    private Map<String, MethodInvocationInfo> methodInvocationInfoMap;

    public JavaProcessor(Project project, String source) {
        this(project, source, new SymbolTable(null));
    }

    public JavaProcessor(Project project, String source, SymbolTable globalSymbolTable) {
        this.project = project;
        this.source = source;
        this.globalSymbolTable = globalSymbolTable;
        this.javaFiles = new ArrayList<>();
        this.symbolAnalyzerList = new ArrayList<>();
        InMemoryJavaFile file = new InMemoryJavaFile("Source", this.source);
        javaFiles.add(file);
    }

    public JavaProcessor(Project project, List<InMemoryJavaFile> javaFiles, SymbolTable globalSymbolTable) {
        this.project = project;
        this.source = javaFiles.getFirst().getContent();
        this.javaFiles = javaFiles;
        this.globalSymbolTable = globalSymbolTable;
        this.symbolAnalyzerList = new ArrayList<>();
    }

    public JavaProcessor(Project project, Path filePath) throws Exception {
        this(project, Files.readString(filePath, StandardCharsets.UTF_8));
    }

    private JavaCompiler getOrLoadJavaCompiler() {

        if (cachedCompilerRef != null) {
            JavaCompiler cached = cachedCompilerRef;
            if (cached != null) return cached;
        }

        synchronized (COMPILER_LOCK) {

            if (cachedCompilerRef != null) {
                JavaCompiler cached = cachedCompilerRef;
                if (cached != null) return cached;
            }

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            if (compiler == null && project != null && project.getJdkHome() != null) {
                compiler = loadJavaCompilerFromJdkHome();
            }

            if (compiler == null) {
                throw new IllegalStateException(
                        "No Java compiler available. Ensure a JDK (not JRE) is used.");
            }

            cachedCompilerRef = compiler;
            return compiler;
        }
    }

    private JavaCompiler loadJavaCompilerFromJdkHome() {
        Path jdkHome = Path.of(project.getJdkHome());

        Path javacBin = jdkHome.resolve("bin").resolve(
                System.getProperty("os.name").toLowerCase().contains("win") ? "javac.exe" : "javac"
        );

        if (!Files.exists(javacBin)) {
            throw new IllegalStateException(
                    "javac not found in JDK home: " + jdkHome + ". Ensure a JDK (not JRE) is installed.");
        }

        // JDK 9+: java modules
        return loadFromModularJdk();
    }

    private JavaCompiler loadFromModularJdk() {

        try {
            ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();

            JavaCompiler compiler = ServiceLoader.load(JavaCompiler.class, platformClassLoader)
                    .findFirst()
                    .orElse(null);
            if (compiler != null) return compiler;

            Class<?> javacClass = Class.forName(
                    "com.sun.tools.javac.api.JavacTool", true, platformClassLoader);
            return (JavaCompiler) javacClass.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load JavaCompiler", e);
        }
    }

    public List<Diagnostic<? extends JavaFileObject>> process() throws Exception {

        JavaCompiler compiler = getOrLoadJavaCompiler();

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        List<String> options = new ArrayList<>();
        options.add("-XDcompilePolicy=simple");
        options.add("-proc:none");
        options.add("-g:none");
        //options.add("-implicit:none");
        options.add("-Xlint:none");

        if (project != null) {
            // source path
            List<File> sourcePathDirs = project.getSourceDirs().stream()
                    .map(Path::toFile)
                    .toList();
            fileManager.setLocation(javax.tools.StandardLocation.SOURCE_PATH, sourcePathDirs);

            // classpath
            List<File> classPathDirs = project.getJavaClassPath().stream()
                    .map(Path::toFile)
                    .toList();

            if (!classPathDirs.isEmpty()) {
                List<File> mergedClassPathDirs = new ArrayList<>();

                fileManager.getLocation(javax.tools.StandardLocation.CLASS_PATH).forEach(mergedClassPathDirs::add);
                mergedClassPathDirs.addAll(classPathDirs);
                ////log.debug("classPathDirs = " + mergedClassPathDirs);

                fileManager.setLocation(javax.tools.StandardLocation.CLASS_PATH, mergedClassPathDirs);
            }
        }

        //log.debug("task before");
        task = (JavacTask) compiler.getTask(
                null,
                fileManager,
                diagnostics,
                options,
                null,
                javaFiles
        );

        //log.debug("task after");

        //log.debug("task.parse()");
        asts = task.parse();
        
        //log.debug("task.analyze()");
        task.analyze();
        
        //log.debug("Trees.instance(task)");
        trees = Trees.instance(task);
        
        //log.debug("task.getElements()");
        elements = task.getElements();
        
        //log.debug("task.getTypes()");
        types = task.getTypes();

        return diagnostics.getDiagnostics();
    }

    public void analyzeSymbols() {
        if (trees == null) {
            throw new IllegalStateException("Call process() first.");
        }

        int k = 0;
        for (CompilationUnitTree ast : asts) {
            String source = javaFiles.get(k).getContent();
            JavaSymbolAnalyzer javaSymbolAnalyzer = new JavaSymbolAnalyzer(source, ast, trees, globalSymbolTable, elements, types);
            javaSymbolAnalyzer.scan(ast, null);
            symbolAnalyzerList.add(javaSymbolAnalyzer);
            ++k;
        }
    }

    public String getSource() {
        return source;
    }

    public List<SymbolTable> getSymbolTable() {
        return symbolAnalyzerList.stream().map(JavaSymbolAnalyzer::getTopLevelSymbolTable).toList();
    }

    public SymbolTable getGlobalSymbolTable() { return globalSymbolTable; }

    public List<JavaMethodInvocationManager> getMethodInvocationManager() {
        return symbolAnalyzerList.stream().map(JavaSymbolAnalyzer::getJavaMethodInvocationManager).toList();
    }
}
