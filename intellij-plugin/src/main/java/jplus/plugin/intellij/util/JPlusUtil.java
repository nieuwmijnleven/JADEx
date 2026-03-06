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
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;

import com.intellij.openapi.module.Module;
import com.jetbrains.cef.remote.thrift.annotation.Nullable;
import jplus.plugin.intellij.annotator.JPlusIntelliJProjectUtil;
import jplus.processor.JPlusProcessor;
import jplus.util.CodeGenUtils;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;

import java.util.LinkedList;

public class JPlusUtil {

    private JPlusUtil() {}

    private static final String DUMMY_IDENTIFIER = "IntellijIdeaRulezzz";

    public static PsiJavaFile createJavaPsiFromJPlus(Project project, PsiFile jplusFile, boolean checkParsible) {

        Project ideaProject = jplusFile.getProject();

        //Module module = ModuleUtilCore.findModuleForFile(jplusFile.getVirtualFile(), ideaProject);
        Module module = ModuleUtilCore.findModuleForPsiElement(jplusFile);
        jplus.base.Project jplusProject = JPlusIntelliJProjectUtil.buildJPlusProject(ideaProject, module);

        JPlusProcessor processor = new JPlusProcessor(jplusProject, jplusFile.getText());

        if (checkParsible && !processor.canParse()) return null;

        //String javaText = processor.compile();
        String javaText = processor.transformJADExToJava();
        System.err.println("[createJavaPsiFromJPlus] javaText = " + javaText);

        return (PsiJavaFile) PsiFileFactory.getInstance(project)
                .createFileFromText("Temp.java", JavaFileType.INSTANCE, javaText);
    }

    private static String checkAndAppendIntellijIdealRulezzz(@NlsSafe String text, int offset) {
        if (text == null || offset < 0 || offset > text.length()) {
            throw new IllegalArgumentException("Invalid text or offset");
        }

        // offset 이후의 텍스트
        String trailingText = text.substring(offset);

        // 이미 dummy identifier가 포함되어 있는지 확인
        if (trailingText.startsWith(DUMMY_IDENTIFIER)) {
            return text; // 이미 존재하면 그대로 반환
        }

        // 없으면 offset 뒤에 붙여서 반환
        return text.substring(0, offset) + "." + DUMMY_IDENTIFIER + trailingText;
    }

    public static PsiJavaFile createJavaPsiFromJADExForCodeCompletion(Project project, PsiFile jplusFile, int originalOffset, boolean checkParsible) {

        Project ideaProject = jplusFile.getProject();

        //Module module = ModuleUtilCore.findModuleForFile(jplusFile.getVirtualFile(), ideaProject);
        Module module = ModuleUtilCore.findModuleForPsiElement(jplusFile);
        jplus.base.Project jplusProject = JPlusIntelliJProjectUtil.buildJPlusProject(ideaProject, module);

        JPlusProcessor processor = new JPlusProcessor(jplusProject, jplusFile.getText());

        if (checkParsible && !processor.canParse()) return null;

        System.err.println("[createJavaPsiFromJPlus] JadexText = " + jplusFile.getText());
        //String javaText = processor.compile();
        String javaText = processor.transformJADExToJava();

        int mapOffset = CodeGenUtils.getMapOffset(javaText, jplusFile.getText(), originalOffset);
        javaText = checkAndAppendIntellijIdealRulezzz(javaText, mapOffset);

        System.err.println("[createJavaPsiFromJPlus] javaText = " + javaText);

        return (PsiJavaFile) PsiFileFactory.getInstance(project)
                .createFileFromText("Temp.java", JavaFileType.INSTANCE, javaText);
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
