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

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import jadex.gradle.JadexModel;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GradleModelResolver {

    private JadexModel cachedModel = null;
    private long cacheTimestamp = 0;
    private static final long CACHE_TTL_MS = 20_000;

    public void invalidateCache() {
        cachedModel = null;
        cacheTimestamp = 0;
    }

    public JadexModel resolve(Project project) {

        if (isCacheValid()) {
            return cachedModel;
        }

//        System.out.println("[GradleModelResolver] hasGradlePlugin = " + hasGradlePlugin(project));
//        if (!hasGradlePlugin(project)) {
//            return null;
//        }

        return fetchViaToolingApi(project);
    }

    private boolean isCacheValid() {
        return cachedModel != null
            && (System.currentTimeMillis() - cacheTimestamp) < CACHE_TTL_MS;
    }

    private boolean hasGradlePlugin(Project project) {
        ModuleManager moduleManager = ModuleManager.getInstance(project);

        for (Module module : moduleManager.getModules()) {
            // 모듈의 루트 경로 가져오기
            String moduleDirPath = ModuleUtil.getModuleDirPath(module);
            File moduleDir = new File(moduleDirPath);

            File buildGradle = findBuildGradle(moduleDir);
            if (buildGradle != null && containsJadexPlugin(buildGradle)) {
                return true;
            }
        }
        return false;
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

    private JadexModel fetchViaToolingApi(Project project) {

        String basePath = project.getBasePath();
        System.out.println("[GradleModelResolver] basePath = " + basePath);
        if (basePath == null) return cachedModel;

        GradleConnector connector = GradleConnector.newConnector()
                .forProjectDirectory(new File(basePath));

        try (ProjectConnection connection = connector.connect()) {

            JadexModel model = connection.getModel(JadexModel.class);
            cachedModel = model;
            cacheTimestamp = System.currentTimeMillis();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            return cachedModel;
        }
    }
}