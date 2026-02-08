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

package jplus.plugin.intellij;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.JavaCompletionContributor;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import jplus.plugin.intellij.psi.ApplyBlockPsiElement;
import jplus.plugin.intellij.psi.ApplyStatementPsiElement;
import jplus.plugin.intellij.util.JPlusUtil;
import jplus.plugin.intellij.util.PsiUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class JPlusCompletionContributor extends CompletionContributor {

    private static final List<String> APPLY_KEYWORDS = Arrays.asList(
            "getter", "setter", "data", "equality", "constructor", "builder", "tostring", "equals", "hashcode"
    );

    public JPlusCompletionContributor() {
        extend(CompletionType.BASIC, JPlusPatterns.psiElement(), new CompletionProvider<>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                Project project = parameters.getPosition().getProject();
                PsiElement psiElement = parameters.getPosition();
                PsiFile jplusFile = psiElement.getContainingFile();

                collectApplyCandidates(psiElement, result);

                PsiJavaFile javaPsiFile = (PsiJavaFile) PsiFileFactory.getInstance(project)
                        .createFileFromText("Temp.java", JavaFileType.INSTANCE, jplusFile.getText());
                if (javaPsiFile != null) {
                    invokeJavaCompletion(javaPsiFile, parameters, result);
                }
            }
        });
    }

    private void collectApplyCandidates(PsiElement element, CompletionResultSet result) {
        PsiElement parent = element.getParent();
        if (parent == null) return;

        boolean isInAppyStatement = PsiTreeUtil.getParentOfType(element, ApplyStatementPsiElement.class) != null;
        boolean isInAppyBlock = PsiTreeUtil.getParentOfType(element, ApplyBlockPsiElement.class) != null;
        boolean isInApply = isInAppyStatement || isInAppyBlock;
        if (!isInApply) return;

        if (isInAppyBlock) {
            PsiFile file = element.getContainingFile();
            PsiUtils.getClassNameList(file).forEach(className -> {
                result.addElement(LookupElementBuilder.create(className));
            });
        }

        for (String keyword : APPLY_KEYWORDS) {
            result.addElement(LookupElementBuilder.create(keyword));
        }
    }

    private void invokeJavaCompletion(PsiFile javaPsiFile,
                                      CompletionParameters originalParameters,
                                      CompletionResultSet result) {
        PsiElement javaElementAtCursor = javaPsiFile.findElementAt(originalParameters.getOffset());
        CompletionParameters javaParams = originalParameters.withPosition(javaElementAtCursor, originalParameters.getOffset());

        JavaCompletionContributor javaContributor = new JavaCompletionContributor();
        javaContributor.fillCompletionVariants(javaParams, result);
    }
}
