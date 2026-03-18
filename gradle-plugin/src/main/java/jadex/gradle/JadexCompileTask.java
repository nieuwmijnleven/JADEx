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

package jadex.gradle;

import jplus.base.Project;
import jplus.base.SymbolTable;
import jplus.processor.JPlusProcessor;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.FileTree;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class JadexCompileTask extends DefaultTask {

    private File sourceDir;
    private File outputDir;

    @InputFiles
    public FileTree getSources() {
        return getProject().fileTree(sourceDir, spec -> spec.include("**/*.jadex"));
    }

    @OutputDirectory
    public File getOutputDir() {
        return outputDir;
    }

    public void setSourceDir(File sourceDir) {
        this.sourceDir = sourceDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    @TaskAction
    public void compile() {

        List<Path> javaClassPath = getProject()
                .getConfigurations()
                .getByName("compileClasspath")
                .getFiles()
                .stream()
                .map(File::toPath)
                .collect(Collectors.toList());

        getLogger().lifecycle("javaClassPath: " + javaClassPath);

        SourceSetContainer sourceSets =
                (SourceSetContainer) getProject().getProperties().get("sourceSets");

        SourceSet mainSourceSet = sourceSets.getByName("main");

        List<Path> sourceDirs =
                mainSourceSet.getJava().getSrcDirs()
                        .stream()
                        .map(File::toPath)
                        .toList();

        getLogger().lifecycle("[JADEx] sourceDirs = " + sourceDirs);

        Project jadexProject = new Project(sourceDirs, javaClassPath);

        FileTree files = getSources();

        for (File file : files) {

            Path sourceBase = sourceDir.toPath();
            Path filePath = file.toPath();

            Path relativePath = sourceBase.relativize(filePath);

            String className = file.getName().replace(".jadex", "");

            Path parent = relativePath.getParent();
            String packageName = null;

            if (parent != null) {
                packageName = parent.toString()
                        .replace(File.separatorChar, '.');
            }

            Path outputPath = outputDir.toPath()
                    .resolve(relativePath)
                    .normalize();

            File output = outputPath
                    .resolveSibling(className + ".java")
                    .toFile();

            runCompiler(jadexProject, file, output, packageName, className);
        }
    }

    private void runCompiler(Project jadexProject, File input, File output, String packageName, String className) {

        getLogger().lifecycle("Compiling JADEx: " + input.getName());

        try {
            String originalText = Files.readString(input.toPath(), StandardCharsets.UTF_8);

            JPlusProcessor processor = new JPlusProcessor(
                    jadexProject,
                    packageName,
                    className,
                    originalText,
                    new SymbolTable(null)
            );

            if (!processor.canParse()) {
                throw new GradleException(
                        "JADEx compilation failed: " + input.getName()
                );
            }

            String javaCode = processor.compile();
            if (javaCode == null) {
                throw new GradleException(
                        "JADEx compilation failed: " + input.getName()
                );
            }

            if (!output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }

            Files.writeString(output.toPath(), javaCode, StandardCharsets.UTF_8);

            getLogger().lifecycle("Generated Java: " + output.getAbsolutePath());

        } catch (GradleException e) {
            throw e;
        } catch (Exception e) {
            throw new GradleException(
                    "Failed to compile " + input.getName() + ": " + e.getMessage(), e
            );
        }
    }
}