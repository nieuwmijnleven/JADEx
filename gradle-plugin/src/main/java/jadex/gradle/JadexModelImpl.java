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

import java.util.List;

public class JadexModelImpl implements JadexModel {
    private static final long serialVersionUID = 1L;

    private final String projectDir;

    private final String pluginVersion;
    private final String sourceDir;
    private final String outputDir;

    private final String javaHome;
    private final String javaVersion;
    private final List<String> javaSrcDirs;
    private final List<String> classPath;

    public JadexModelImpl(String projectDir, String pluginVersion, String sourceDir, String outputDir, String javaHome, String javaVersion, List<String> javaSrcDirs, List<String> classPath) {
        this.projectDir = projectDir;
        this.pluginVersion = pluginVersion;
        this.sourceDir = sourceDir;
        this.outputDir = outputDir;
        this.javaHome = javaHome;
        this.javaVersion = javaVersion;
        this.javaSrcDirs = javaSrcDirs;
        this.classPath = classPath;
    }

    @Override
    public String getProjectDir() { return projectDir; }

    @Override
    public String getPluginVersion() { return pluginVersion; }

    @Override
    public String getSourceDir() { return sourceDir; }

    @Override
    public String getOutputDir() { return outputDir; }

    @Override
    public String getJavaHome() { return javaHome; }

    @Override
    public String getJavaVersion() { return javaVersion; }

    @Override
    public List<String> getJavaSrcDirs() { return javaSrcDirs; }

    @Override
    public List<String> getClassPath() { return classPath; }
}