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

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.externalSystem.ExternalSystemModulePropertyManager;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;

import com.intellij.openapi.module.Module;
import com.jetbrains.cef.remote.thrift.annotation.Nullable;
import jplus.plugin.intellij.annotator.JPlusIntelliJProjectUtil;
import jplus.plugin.intellij.settings.JadexProjectSettings;
import jplus.processor.JPlusProcessor;
import jplus.util.CodeGenUtils;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public final class JPlusUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JPlusUtil.class);

    private JPlusUtil() {}

    public static PsiJavaFile createJavaPsiFromJPlus(Project project, PsiFile jplusFile, boolean checkParsible) {

        Project ideaProject = jplusFile.getProject();

        //Module module = ModuleUtilCore.findModuleForFile(jplusFile.getVirtualFile(), ideaProject);
        Module module = ModuleUtilCore.findModuleForPsiElement(jplusFile);
        jplus.base.Project jplusProject = JPlusUtil.buildJadexProject(ideaProject, module);

        JPlusProcessor processor = new JPlusProcessor(jplusProject, jplusFile.getText());

        if (checkParsible && !processor.canParse()) return null;

        //String javaText = processor.compile();
        String javaText = processor.transformJADExToJava();
        LOG.debug("[createJavaPsiFromJPlus] javaText = " + javaText);

        return (PsiJavaFile) PsiFileFactory.getInstance(project)
                .createFileFromText("Temp.java", JavaFileType.INSTANCE, javaText);
    }

    public static PsiJavaFile createJavaPsiFromJADExForCodeCompletion(Project project, PsiFile jplusFile, int originalOffset, boolean checkParsible) {

        Project ideaProject = jplusFile.getProject();

        //Module module = ModuleUtilCore.findModuleForFile(jplusFile.getVirtualFile(), ideaProject);
        Module module = ModuleUtilCore.findModuleForPsiElement(jplusFile);
        jplus.base.Project jplusProject = JPlusUtil.buildJadexProject(ideaProject, module);

        JPlusProcessor processor = new JPlusProcessor(jplusProject, jplusFile.getText());

        if (checkParsible && !processor.canParse()) return null;

        LOG.debug("[createJavaPsiFromJADExForCodeCompletion] JadexText = " + jplusFile.getText());

        String javaText = processor.transformJADExToJava();

        javaText =
                javaText.transform( s -> s.replace("?.", "."))
                        .transform(s -> s.replace("?:", "? :"));

        LOG.debug("[createJavaPsiFromJADExForCodeCompletion] javaText = " + javaText);

        return (PsiJavaFile) PsiFileFactory.getInstance(project)
                .createFileFromText("Temp.java", JavaFileType.INSTANCE, javaText);
    }

    public static jplus.base.Project buildJadexProject(com.intellij.openapi.project.Project ideaProject, Module module) {

        var jadexProjectSetting = JadexProjectSettings.getInstance(ideaProject);
        String moduleDir = getModuleDir(module);

        if (!jadexProjectSetting.hasGradleConfig(moduleDir)) return null;

        List<Path> sourceDirs =
                jadexProjectSetting.getJavaSrcDirs(moduleDir)
                        .stream()
                        .map(Path::of)
                        .toList();

        List<Path> classPath =
                jadexProjectSetting.getClassPath(moduleDir)
                        .stream()
                        .map(Path::of)
                        .toList();

        LOG.debug("sourceDirs = " + sourceDirs);
        LOG.debug("classPath = " + classPath);

        var jadexProject = new jplus.base.Project(sourceDirs, classPath);

        //jplusProject = jplusProject.withJavaClassPathEntry(resolveJSpecifyJarPath());
        jadexProjectSetting.getJavaHome(moduleDir)
                .ifPresent(
                        jdkHome -> jadexProject.setJdkHome(jdkHome)
                );

        return jadexProject;
    }

    public static String getModuleDir(Project project, VirtualFile file) {

        Module module = ModuleUtil.findModuleForFile(file, project);
        return getModuleDir(module);
    }

    public static String getModuleDir(Module module) {

        if (module == null) return null;

        return ExternalSystemModulePropertyManager
                .getInstance(module)
                .getLinkedProjectPath();
    }

    public static int findMapOffset(String oldText, String newText, int oldOffset) {
        DiffMatchPatch dmp = new DiffMatchPatch();
        LinkedList<DiffMatchPatch.Diff> diffs = dmp.diffMain(oldText, newText);
//        dmp.diffCleanupSemantic(diffs);

        int newOffset = dmp.diffXIndex(diffs, oldOffset);
//        System.out.printf("old offset %d -> new offset %d\n", oldOffset, newOffset);
        return newOffset;
    }

    public static @Nullable PsiElement findCorrespondingPsiElement(PsiFile file, int offset) {
        return file.findElementAt(offset);
    }
}
