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

package jplus.plugin.intellij.gradle;

import com.intellij.openapi.project.Project;
import jadex.gradle.JadexModel;
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings;
import org.jetbrains.plugins.gradle.settings.GradleSettings;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JadexPathResolver {

    private final GradleModelResolver gradleResolver = new GradleModelResolver();

    public static JadexPathResolver getInstance(Project project) {
        return project.getService(JadexPathResolver.class);
    }

    public void invalidateCache() {
        gradleResolver.invalidateCache();
    }

    private boolean hasBuildGradle(File dir) {
        return new File(dir, "build.gradle").exists()
                || new File(dir, "build.gradle.kts").exists();
    }

    private File findBuildGradle(File dir) {
        File buildGradle = new File(dir, "build.gradle");
        if (buildGradle.exists()) return buildGradle;

        File buildGradleKts = new File(dir, "build.gradle.kts");
        if (buildGradleKts.exists()) return buildGradleKts;

        return null;
    }

    private boolean containsJadexPlugin(File buildGradle) {
        try {
            String content = Files.readString(buildGradle.toPath());
            return content.contains("jadex");
        } catch (IOException e) {
            return false;
        }
    }

    private List<File> getbuildGradleDirList(Project project) {

        List<File> result = new ArrayList<>();

        GradleSettings gradleSettings = GradleSettings.getInstance(project);
        for (GradleProjectSettings projectSettings : gradleSettings.getLinkedProjectsSettings()) {

            File rootProjectDir = new File(projectSettings.getExternalProjectPath());
            System.out.println("[GradleModelResolver] rootProjectDir = " + rootProjectDir);
            if (hasBuildGradle(rootProjectDir) && containsJadexPlugin(findBuildGradle(rootProjectDir))) {
                result.add(rootProjectDir);
            }

            for (String modulePath : projectSettings.getModules()) {
                System.out.println("[GradleModelResolver] modulePath = " + modulePath);
                File moduleDir = new File(modulePath);
                if (hasBuildGradle(moduleDir) && containsJadexPlugin(findBuildGradle(moduleDir))) {
                    result.add(moduleDir);
                }
            }
        }

        return result;
    }

    public List<ResolvedPaths> resolve(Project project) {

        var resultList = new ArrayList<ResolvedPaths>();

        var buildGradleDirList = getbuildGradleDirList(project);
        for (File buildGradleDir : buildGradleDirList) {

            System.out.println("[JadexPathResolver] buildGradleDir = " + buildGradleDir);

            JadexModel model = gradleResolver.resolve(buildGradleDir);
            if (model != null) {

                resultList.add(
                        new ResolvedPaths(
                            buildGradleDir.getAbsolutePath(),
                            model.getSourceDir(),
                            model.getOutputDir()
                        )
                );
            }

        }

        return resultList;
    }
}
