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

package jplus.plugin.intellij.annotator;

import com.intellij.execution.CantRunException;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.LibraryOrderEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEntry;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.jetbrains.cef.remote.thrift.annotation.Nullable;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class JPlusIntelliJProjectUtil {

    public static jplus.base.Project buildJPlusProject(com.intellij.openapi.project.Project ideaProject, Module module) {
        List<Path> sourceDirs = new ArrayList<>();

        for (VirtualFile root : ProjectRootManager.getInstance(ideaProject).getContentSourceRoots()) {
            sourceDirs.add(Path.of(root.getPath()));
        }

        JavaParameters params = new JavaParameters();
        try {
            params.configureByModule(module, JavaParameters.JDK_AND_CLASSES_AND_PROVIDED);
        } catch (CantRunException e) {
            throw new RuntimeException(e);
        }

        List<Path> classPathList = params.getClassPath().getPathList().stream()
                .map(s -> s.replaceAll("!/$", ""))
                .map(Path::of)
                .toList();
        System.err.println("classPathList = " + classPathList);

        var jplusProject = new jplus.base.Project(sourceDirs, classPathList);

        jplusProject = jplusProject.withJavaClassPathEntry(resolveJSpecifyJarPath());
        jplusProject.setJdkHome(getJdkHome(ideaProject));

        return jplusProject;
    }

    public static String resolvePackageName(com.intellij.openapi.project.Project ideaProject, PsiFile file) {
        VirtualFile vFile = file.getVirtualFile();
        if (vFile == null) return null;

        VirtualFile sourceRoot =
                ProjectRootManager.getInstance(ideaProject)
                        .getFileIndex()
                        .getSourceRootForFile(vFile);

        if (sourceRoot == null) return null;

        String relative =
                vFile.getParent().getPath()
                        .substring(sourceRoot.getPath().length());

        if (relative.startsWith("/")) relative = relative.substring(1);
        if (relative.isEmpty()) return null;

        return relative.replace('/', '.');
    }

    private static @Nullable String getJdkHome(Project ideaProject) {
        Sdk sdk = ProjectRootManager.getInstance(ideaProject).getProjectSdk();
        return sdk.getHomePath();
    }

    private static Path resolveJSpecifyJarPath() {
        return Path.of(PathManager.getPluginsPath())
                .resolve("intellij-plugin")
                .resolve("lib/jspecify-1.0.0.jar");
    }
}
