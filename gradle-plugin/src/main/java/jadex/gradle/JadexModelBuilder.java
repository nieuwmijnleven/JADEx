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

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.tooling.provider.model.ToolingModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JadexModelBuilder implements ToolingModelBuilder {

    private static final Logger log = LoggerFactory.getLogger(JadexModelBuilder.class);

    @Override
    public boolean canBuild(String modelName) {
        return modelName.equals(JadexModel.class.getName());
    }

    @Override
    public Object buildAll(String modelName, Project project) {
        JadexExtension ext = project.getExtensions()
                .getByType(JadexExtension.class);

        String projectDir = project.getProjectDir().getAbsolutePath();

        String pluginVersion = resolvePluginVersion(project);

        String javaHome       = resolveJavaHome(project);
        String javaVersion    = resolveJavaVersion(javaHome);
        List<String> javaSrcDirs = resolveJavaSrcDirs(project);
        List<String> classPath   = resolveClassPath(project);

        log.debug("JADEx projectDir: {}", projectDir);
        log.debug("JADEx pluginVersion: {}", pluginVersion);
        log.debug("JADEx javaHome: {}", javaHome);
        log.debug("JADEx javaVersion: {}", javaVersion);
        log.debug("JADEx javaSrcDirs: {}", javaSrcDirs);
        log.debug("JADEx classPath: {}", classPath);

        return new JadexModelImpl(
                projectDir,
                pluginVersion,
                ext.getSourceDir(),
                ext.getOutputDir(),
                javaHome,
                javaVersion,
                javaSrcDirs,
                classPath
        );
    }

    private String resolvePluginVersion(Project project) {
        return project.getBuildscript()
                .getConfigurations()
                .getByName("classpath")
                .getResolvedConfiguration()
                .getResolvedArtifacts()
                .stream()
                .filter(artifact -> artifact.getModuleVersion()
                        .getId()
                        .getModule()
                        .getGroup()
                        .equals("io.github.nieuwmijnleven.jadex"))
                .map(artifact -> artifact.getModuleVersion()
                        .getId()
                        .getVersion())
                .findFirst()
                .orElse("unknown");
    }

    private String resolveJavaHome(Project project) {

        try {
            String toolchainHome = resolveFromToolchain(project);
            if (toolchainHome != null) return toolchainHome;
        } catch (Exception e) {
            log.debug("Toolchain resolution failed, falling back", e);
        }

        return resolveFromGradleJvm();
    }

    private String resolveFromToolchain(Project project) {

        return project.getTasks()
                .withType(org.gradle.api.tasks.compile.JavaCompile.class)
                .stream()
                .findFirst()
                .map(task -> task.getJavaCompiler()
                        .map(compiler -> compiler.getMetadata()
                                .getInstallationPath()
                                .getAsFile()
                                .getAbsolutePath())
                        .getOrNull())
                .orElse(null);
    }

    private String resolveFromGradleJvm() {

        String javaHome = System.getProperty("java.home");
        File javac = new File(javaHome, "bin/javac");

        if (!javac.exists()) {

            File parent = new File(javaHome).getParentFile();
            if (parent != null && new File(parent, "bin/javac").exists()) {
                return parent.getAbsolutePath();
            }
        }

        return javaHome;
    }

    private String resolveJavaVersion(String javaHome) {
        // release file parsing (JDK 9+)
        String version = resolveFromReleaseFile(javaHome);
        if (version != null) return version;

        // java -XshowSettings:property
        version = resolveFromJavaProcess(javaHome);
        if (version != null) return version;

        // javaHome path parsing
        version = resolveFromPath(javaHome);
        if (version != null) return version;

        // java.version
        return System.getProperty("java.version", "unknown");
    }

    private String resolveFromReleaseFile(String javaHome) {
        Path releaseFile = Path.of(javaHome, "release");
        if (!Files.exists(releaseFile)) return null;

        try {
            return Files.lines(releaseFile)
                    .filter(line -> line.startsWith("JAVA_VERSION="))
                    .map(line -> line.replace("JAVA_VERSION=", "")
                            .replace("\"", "")
                            .trim())
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            log.debug("Failed to read release file: {}", releaseFile, e);
            return null;
        }
    }

    private String resolveFromJavaProcess(String javaHome) {
        try {
            String javaBin = javaHome + "/bin/java";
            ProcessBuilder pb = new ProcessBuilder(javaBin, "-XshowSettings:property");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            return new String(process.getInputStream().readAllBytes())
                    .lines()
                    .filter(line -> line.contains("java.specification.version "))
                    .map(line -> line.split("=")[1].trim())
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            log.debug("Failed to resolve Java version from process", e);
            return null;
        }
    }

    private String resolveFromPath(String javaHome) {
        // example: /home/user/.sdkman/candidates/java/17.0.9-tem
        //          /home/user/.jdks/openjdk-21.0.1
        //          C:\Program Files\Java\jdk-17.0.9
        java.util.regex.Matcher matcher = java.util.regex.Pattern
                .compile("(1\\.\\d+\\.\\d+[_\\d]*|\\d{1,2}\\.\\d+\\.\\d+)")
                .matcher(javaHome);
        return matcher.find() ? matcher.group(1) : null;
    }

    private List<String> resolveJavaSrcDirs(Project project) {
        try {
            // Java 플러그인의 SourceSet에서 main 소스 디렉토리 수집
            JavaPluginExtension javaExtension = project.getExtensions()
                    .findByType(JavaPluginExtension.class);

            if (javaExtension == null) {
                log.debug("Java plugin not applied, skipping javaSrcDirs");
                return List.of();
            }

            return javaExtension.getSourceSets()
                    .getByName(SourceSet.MAIN_SOURCE_SET_NAME)  // "main"
                    .getJava()
                    .getSrcDirs()
                    .stream()
                    .filter(File::exists)  // 실제 존재하는 디렉토리만
                    .map(File::getAbsolutePath)
                    .toList();

        } catch (Exception e) {
            log.warn("Failed to resolve javaSrcDirs", e);
            return List.of();
        }
    }

    private List<String> resolveClassPath(Project project) {
        try {
            JavaPluginExtension javaExtension = project.getExtensions()
                    .findByType(JavaPluginExtension.class);

            if (javaExtension == null) {
                log.debug("Java plugin not applied, skipping classPath");
                return List.of();
            }

            SourceSet mainSourceSet = javaExtension.getSourceSets()
                    .getByName(SourceSet.MAIN_SOURCE_SET_NAME);

            List<String> classPath = new ArrayList<>();

            mainSourceSet.getCompileClasspath()
                    .filter(File::exists)
                    .forEach(file -> classPath.add(file.getAbsolutePath()));

            mainSourceSet.getOutput()
                    .getClassesDirs()
                    .filter(File::exists)
                    .forEach(file -> classPath.add(file.getAbsolutePath()));

            return classPath.stream().distinct().toList();

        } catch (Exception e) {
            log.warn("Failed to resolve classPath", e);
            return List.of();
        }
    }
}