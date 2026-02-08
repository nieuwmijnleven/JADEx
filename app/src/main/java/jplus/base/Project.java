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

package jplus.base;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Project {

    /** Java source roots (.java, .jplus) */
    private final List<Path> sourceDirs;

    /** Java classpath entries (.class directories or .jar files) */
    private final List<Path> javaClassPath;

    private String jdkHome;

    public Project(Path srcDir) {
        Objects.requireNonNull(srcDir, "srcDir");
        this.sourceDirs = List.of(srcDir);
        this.javaClassPath = List.of();
    }

    public Project(List<Path> sourceDirs) {
        Objects.requireNonNull(sourceDirs, "sourceDirs");
        if (sourceDirs.isEmpty()) {
            throw new IllegalArgumentException("sourceDirs must not be empty");
        }

        this.sourceDirs = List.copyOf(sourceDirs);
        this.javaClassPath = List.of();
    }

    public Project(List<Path> sourceDirs, List<Path> javaClassPath) {
        Objects.requireNonNull(sourceDirs, "sourceDirs");
        Objects.requireNonNull(javaClassPath, "javaClassPath");

        if (sourceDirs.isEmpty()) {
            throw new IllegalArgumentException("sourceDirs must not be empty");
        }

        this.sourceDirs = List.copyOf(sourceDirs);
        this.javaClassPath = List.copyOf(javaClassPath);
    }

    public void setJdkHome(String jdkHome) {
        this.jdkHome = jdkHome;
    }

    public String getJdkHome() {
        return jdkHome;
    }

    public List<Path> getSourceDirs() {
        return sourceDirs;
    }

    public Path getSrcDir() {
        return sourceDirs.get(0);
    }

    public Project withSourceDir(Path srcDir) {
        Objects.requireNonNull(srcDir, "srcDir");

        List<Path> newDirs = new ArrayList<>(this.sourceDirs);
        newDirs.add(srcDir);
        return new Project(newDirs, this.javaClassPath);
    }

    public String buildJavaSourcePath() {
        return sourceDirs.stream()
                .map(Path::toAbsolutePath)
                .map(Path::toString)
                .collect(Collectors.joining(File.pathSeparator));
    }

    public List<Path> getJavaClassPath() {
        return javaClassPath;
    }

    public Project withJavaClassPathEntry(Path entry) {
        Objects.requireNonNull(entry, "entry");

        List<Path> newCp = new ArrayList<>(this.javaClassPath);
        newCp.add(entry);
        return new Project(this.sourceDirs, newCp);
    }

    public String buildJavaClassPath() {
        return javaClassPath.stream()
                .map(Path::toAbsolutePath)
                .map(Path::toString)
                .collect(Collectors.joining(File.pathSeparator));
    }
}
