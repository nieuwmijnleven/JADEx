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

import jplus.analyzer.UnresolvedReferenceScanner;
import jplus.analyzer.nullability.NullabilityChecker;
import jplus.analyzer.nullability.issue.NullabilityIssue;
import jplus.base.JADEx25Lexer;
import jplus.base.JADEx25Parser;
import jplus.base.Project;
import jplus.base.SymbolTable;
import jplus.editor.FragmentedText;
import jplus.generator.BoilerplateCodeGenerator;
import jplus.generator.CodeGenContext;
import jplus.generator.JADExParserRuleContext;
import jplus.generator.SourceMappingEntry;
import jplus.util.Utils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JPlusProcessor {

    private final Project project;
    private final String originalText;

    private JADEx25Parser parser;
    private JADExParserRuleContext parseTree;
    private Set<SourceMappingEntry> sourceMappingEntrySet;

    private JavaProcessor javaProcessor;
    private final SymbolTable globalSymbolTable;
    private SymbolTable symbolTable;

    private String className;
    private String packageName;

    private boolean processed = false;
    private boolean nullabilityChecked = false;
    private boolean symbolsAnalyzed = false;

    public JPlusProcessor(Project project, String originalText, SymbolTable globalSymbolTable) {
        this.project = project;
        this.originalText = originalText;
        this.globalSymbolTable = globalSymbolTable;
    }

    public JPlusProcessor(Project project, String packageName, String className) throws Exception {
        this(
                project,
                Files.readString(
                        resolveSourceFile(project, packageName, className),
                        StandardCharsets.UTF_8
                ),
                new SymbolTable(null)
        );
    }

    public JPlusProcessor(Project project, String originalText) {
        this(project, originalText, new SymbolTable(null));
    }

    public JPlusProcessor(Project project, Path filePath) throws Exception {
        this(project, Files.readString(filePath, StandardCharsets.UTF_8), new SymbolTable(null));
    }

    public JPlusProcessor(Project project, Path filePath, SymbolTable globalSymbolTable) throws Exception {
        this(project, Files.readString(filePath, StandardCharsets.UTF_8), globalSymbolTable);
    }

    private static Path resolveSourceFile(Project project, String packageName, String className) {
        if (project == null) {
            throw new IllegalStateException("Project is null");
        }

        String relativePath =
                (packageName == null || packageName.isBlank())
                        ? className + ".jadex"
                        : packageName.replace('.', '/') + "/" + className + ".jadex";

        for (Path srcDir : project.getSourceDirs()) {
            Path candidate = srcDir.resolve(relativePath);
            if (Files.exists(candidate)) {
                return candidate;
            }
        }

        throw new IllegalStateException(
                "Cannot find source file: " +
                        (packageName == null ? className : packageName + "." + className)
        );
    }

    // --------------------------------------------------------------
    // Main processing pipeline
    // --------------------------------------------------------------

    public void process() throws Exception {
        if (processed) return;

        CodeGenContext.push();
        try {
            CharStream input = CharStreams.fromString(originalText);
            JADEx25Lexer lexer = new JADEx25Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new JADEx25Parser(tokens);

            parseTree = parser.start_();
            processed = true;

            generateRuntime();
            runInitialJavaProcessing();
        } finally {
            CodeGenContext.pop();
        }
    }

    private void generateRuntime() {

        Utils.createJavaFile(
                project.getSourceDirs().get(0).toString(),
                "jadex.runtime",
                "SafeAccess",
                """
                        package jadex.runtime;
                        
                        import java.util.function.Supplier;
                        
                        public final class SafeAccess<T> {
                        
                            @FunctionalInterface
                            public interface CheckedFunction<T, R> {
                                R apply(T value) throws Exception;
                            }
                        
                            @FunctionalInterface
                            public interface CheckedSupplier<T> {
                                T get() throws Exception;
                            }
                        
                            private sealed interface State<T> permits Present, Empty, Failed {}
                        
                            private static final class Present<T> implements State<T> {
                                final T value;
                                Present(T value) { this.value = value; }
                            }
                        
                            private static final class Empty<T> implements State<T> {}
                        
                            private static final class Failed<T> implements State<T> {
                                final Exception exception;
                                Failed(Exception exception) { this.exception = exception; }
                            }
                        
                            private final State<T> state;
                        
                            private SafeAccess(State<T> state) {
                                this.state = state;
                            }
                        
                            // Static factory methods
                            public static <T> SafeAccess<T> ofNullable(T value) {
                                return value == null ? new SafeAccess<>(new Empty<>())
                                        : new SafeAccess<>(new Present<>(value));
                            }
                        
                            public static <T> SafeAccess<T> ofChecked(CheckedSupplier<T> supplier) {
                                try {
                                    T value = supplier.get();
                                    return ofNullable(value);
                                } catch (Exception e) {
                                    return new SafeAccess<>(new Failed<>(e));
                                }
                            }
                        
                            public <U> SafeAccess<U> map(CheckedFunction<? super T, ? extends U> mapper) {
                                if (state instanceof Empty) {
                                    return new SafeAccess<>(new Empty<>());
                                }
                                if (state instanceof Failed f) {
                                    return new SafeAccess<>(new Failed<>(f.exception));
                                }
                                try {
                                    U result = mapper.apply(((Present<T>) state).value);
                                    return result == null ? new SafeAccess<>(new Empty<>())
                                            : new SafeAccess<>(new Present<>(result));
                                } catch (RuntimeException e) {
                                    throw e;
                                } catch (Exception e) {
                                    return new SafeAccess<>(new Failed<>(e));
                                }
                            }
                        
                            // terminal: get
                            public T get() {
                                return switch (state) {
                                    case Present<T> p -> p.value;
                                    case Empty<T> e -> null;
                                    case Failed<T> f -> sneakyThrow(f.exception);
                                };
                            }
                        
                            // terminal: orElse
                            public T orElse(T other) {
                                return switch (state) {
                                    case Present<T> p -> p.value;
                                    case Empty<T> e -> other;
                                    case Failed<T> f -> sneakyThrow(f.exception);
                                };
                            }
                        
                            public T orElseGet(Supplier<? extends T> supplier) {
                                return switch (state) {
                                    case Present<T> p -> p.value;
                                    case Empty<T> e -> supplier.get();
                                    case Failed<T> f -> sneakyThrow(f.exception);
                                };
                            }
                        
                            // isPresent (optional)
                            public boolean isPresent() {
                                return state instanceof Present;
                            }
                        
                            // sneakyThrow helper
                            @SuppressWarnings("unchecked")
                            private static <E extends Throwable, R> R sneakyThrow(Throwable e) throws E {
                                throw (E) e;
                            }
                        }
                        """
        );
    }

    // --------------------------------------------------------------
    // Java intermediate code generation (no boilerplate)
    // --------------------------------------------------------------

    private String generateJavaCodeForSemanticMode() {
        assertProcessed();
        CodeGenContext ctx = CodeGenContext.current();
        if (ctx != null) ctx.setFragmentedText(new FragmentedText(originalText));
        ctx.setSemanticMode(true);

        try {
            return parseTree.getText();
        } finally {
            ctx.setSemanticMode(false);
        }
    }

    private void runInitialJavaProcessing() throws Exception {

        String javaCode = generateJavaCodeForSemanticMode();
        System.err.println("[JPlusProcessor][runInitialJavaProcessing] javaCode = " + javaCode);

        CodeGenContext ctx = CodeGenContext.current();
        sourceMappingEntrySet = ctx.getFragmentedText().buildSourceMap();

        String jextUtilsClass = "package jext.util;\n" +
                "\n" +
                "public final class JextUtils {\n" +
                "\n" +
                "    private JextUtils() {}\n" +
                "\n" +
                "    public static <T> T __elvis(T... args) { return null; }\n" +
                "}";

        List<InMemoryJavaFile> inMemoryJavaFiles = new ArrayList<>();
        inMemoryJavaFiles.add(new InMemoryJavaFile("source", javaCode));
        inMemoryJavaFiles.add(new InMemoryJavaFile("JextUtils", jextUtilsClass));

        //javaProcessor = new JavaProcessor(javaCode, globalSymbolTable);
        javaProcessor = new JavaProcessor(project, inMemoryJavaFiles, globalSymbolTable);
        //System.err.println("[JPlusProcessor][runInitialJavaProcessing] javaProcessor.process()");
        javaProcessor.process();
    }

    public String getProcessedJavaCode() {
        return javaProcessor.getSource();
    }

    public String getParseTreeString() {
        if (parseTree == null) {
            throw new IllegalStateException("Call process() first.");
        }
        return parseTree.toStringTree(parser);
    }

    // --------------------------------------------------------------
    // Symbol Analysis (recursive unresolved resolution)
    // --------------------------------------------------------------

    public void analyzeSymbols() throws Exception {
        assertProcessed();
        if (symbolsAnalyzed) return;

        javaProcessor.analyzeSymbols();
        symbolsAnalyzed = true;

        updateSymbolInfoFrom(javaProcessor);
        resolveAllUnresolvedReferences();
    }

    private void updateSymbolInfoFrom(JavaProcessor processor) {
        symbolTable = processor.getSymbolTable().get(0);
        className = symbolTable.resolve("^TopLevelClass$").getSymbol();
        packageName = symbolTable.resolve("^PackageName$").getSymbol();
    }

    private List<UnresolvedReferenceScanner.UnresolvedReferenceInfo> collectUnresolvedReferenceInfo(List<SymbolTable> symbolTableList) {
        List<UnresolvedReferenceScanner.UnresolvedReferenceInfo> allUnresolvedReferenceInfoList = new ArrayList<>();
        for (SymbolTable symbolTable : symbolTableList) {
            UnresolvedReferenceScanner scanner = new UnresolvedReferenceScanner(symbolTable);
            List<UnresolvedReferenceScanner.UnresolvedReferenceInfo> unresolvedReferenceInfoList = scanner.findUnresolvedReference();
            //unresolvedReferenceInfoList.forEach(unsolvedType -> System.err.println("[UnresolvedReferenceScanner] unsolvedType = " + unsolvedType.className));
            allUnresolvedReferenceInfoList.addAll(unresolvedReferenceInfoList);
        }
        return allUnresolvedReferenceInfoList;
    }

    private void resolveAllUnresolvedReferences() throws Exception {
        List<InMemoryJavaFile> inMemoryJavaFiles = new ArrayList<>();
        inMemoryJavaFiles.add(new InMemoryJavaFile(getFullyQualifiedName(), javaProcessor.getSource()));

        symbolsAnalyzed = false;
        while(true) {
            var unresolvedList = collectUnresolvedReferenceInfo(javaProcessor.getSymbolTable());
            if (unresolvedList.isEmpty()) break;

            for (var unresolved : unresolvedList) {
                JPlusProcessor dependency = new JPlusProcessor(project, unresolved.packageName, unresolved.className);
                dependency.process();
                //String javaCode = dependency.generateJavaCodeForSemanticMode();
                String javaCode = dependency.getProcessedJavaCode();
                ////System.err.println("[resolveAllUnresolvedReferences] javaCode = " + javaCode);
                inMemoryJavaFiles.add(new InMemoryJavaFile(unresolved.getFullyQualifiedName(), javaCode));
            }

            javaProcessor = new JavaProcessor(project, inMemoryJavaFiles, globalSymbolTable);
            javaProcessor.process();
            javaProcessor.analyzeSymbols();
            symbolTable = javaProcessor.getSymbolTable().get(0);
        }
        symbolsAnalyzed = true;
    }

    public List<NullabilityIssue> checkNullability() {
        assertAnalyzed();

        NullabilityChecker nullabilityChecker = new NullabilityChecker(globalSymbolTable, sourceMappingEntrySet, javaProcessor.getMethodInvocationManager().get(0));
        nullabilityChecker.visit(parseTree);
        nullabilityChecked = true;
        return nullabilityChecker.getIssues().stream().sorted().toList();
    }

    public String generateJavaCode() {
        //if (!symbolsAnalyzed || !nullabilityChecked) {
        if (!symbolsAnalyzed) {
            //throw new IllegalStateException("Must perform nullability check and symbol analysis first.");
            throw new IllegalStateException("Must perform symbol analysis first.");
        }

        CodeGenContext.push();
        String generated = null;
        try {
            CodeGenContext.current().setSemanticMode(false);
            CodeGenContext.current().setFragmentedText(new FragmentedText(originalText));

            generated = parseTree.getText();
        } finally {
            CodeGenContext.pop();
        }

        //System.err.println("[generateJavaCode] javaCode = " + generated);

        int startIndex = parseTree.start.getStartIndex();
        String startWhiteSpace = originalText.substring(0, startIndex);
        String fullyGenerated = startWhiteSpace + generated;
        ////System.err.println("fullyGenerated = " + fullyGenerated);

        FragmentedText fragmentedText = new FragmentedText(fullyGenerated);
        BoilerplateCodeGenerator generator = new BoilerplateCodeGenerator(symbolTable, fragmentedText);
        generator.visit(parseTree);
        return generator.generate();
    }

    public String compile() {
        try {
            process();
            analyzeSymbols();
            checkNullability();
            return generateJavaCode();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    // --------------------------------------------------------------
    // Assertions
    // --------------------------------------------------------------

    private void assertProcessed() {
        if (!processed) throw new IllegalStateException("Call process() first.");
    }

    private void assertAnalyzed() {
        if (!symbolsAnalyzed) throw new IllegalStateException("analyzeSymbol() not called.");
    }

    public String getClassName() {
        assertAnalyzed();
        return className;
    }

    public String getPackageName() {
        assertAnalyzed();
        return packageName;
    }

    public String getFullyQualifiedName() {
        assertAnalyzed();
        return packageName == null ? className : packageName + "." + className;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public SymbolTable getGlobalSymbolTable() {
        return globalSymbolTable;
    }
}
