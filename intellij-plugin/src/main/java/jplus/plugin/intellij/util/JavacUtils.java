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

package jplus.plugin.intellij.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.ProjectJdkTable;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.roots.ProjectRootManager;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JavacUtils {

    /**
     * IntelliJ 프로젝트에서 JavacTool(JavaCompiler)을 가져옵니다.
     * null이면 JDK가 없는 것입니다.
     */

    public static Sdk getProjectJdk(Project project) {
        // ProjectRootManager를 통해 Project SDK 확인
        Sdk projectSdk = ProjectRootManager.getInstance(project).getProjectSdk();
        if (projectSdk == null || !(projectSdk.getSdkType() instanceof JavaSdk)) {
            throw new IllegalStateException("Project SDK is not a Java SDK");
        }
        return projectSdk;
    }

    public static String getJdkHomePath(Project project) {
        Sdk sdk = getProjectJdk(project);
        String homePath = sdk.getHomePath();
        if (homePath == null) {
            throw new IllegalStateException("JDK home path is null");
        }
        return homePath;
    }

    public static JavaCompiler getCompiler(Project intelliJProject) {
        Sdk projectSdk = getProjectJdk(intelliJProject);
        if (projectSdk == null || !(projectSdk.getSdkType() instanceof JavaSdk)) {
            throw new IllegalStateException("Project SDK is not a Java SDK");
        }

        // JDK home 디렉토리
        String jdkHomePath = projectSdk.getHomePath();
        if (jdkHomePath == null) {
            throw new IllegalStateException("JDK home path is null");
        }

        // JavacTool 직접 로드
        try {
            ClassLoader jdkClassLoader = new java.net.URLClassLoader(
                    new java.net.URL[]{new java.io.File(jdkHomePath + "/lib/tools.jar").toURI().toURL()},
                    ToolProvider.class.getClassLoader()
            );
            Class<?> javacClass = Class.forName("com.sun.tools.javac.api.JavacTool", true, jdkClassLoader);
            return (JavaCompiler) javacClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JavacTool from JDK", e);
        }
    }
}
