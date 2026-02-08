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

import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.refactoring.listeners.RefactoringElementListener;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.usageView.UsageInfo;
import jplus.plugin.intellij.context.JPlusContext;
import jplus.plugin.intellij.psi.PsiElementWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class JPlusRenameProcessor extends RenamePsiElementProcessor {

    @Override
    public boolean canProcessElement(@NotNull PsiElement element) {
        System.err.println("canProcessElement = " + element.getClass().getSimpleName());
        return element.getLanguage().isKindOf(JavaLanguage.INSTANCE) || !element.isPhysical();
    }

    @Override
    public @NotNull PsiElement substituteElementToRename(@NotNull PsiElement element, @Nullable Editor editor) {
        System.out.println("substituteElementToRename = " + element.getClass().getSimpleName());
        if (editor != null) {
            Project project = element.getProject();
            Document doc = editor.getDocument();
            PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(doc);

            JPlusContext.getInstance().setProject(project);
            JPlusContext.getInstance().setJPlusFile(element.getContainingFile());

            if (element instanceof PsiElementWrapper javaElement) {
                return javaElement.getSourceElement();
            }
        }
        return element;
    }

    @Override
    public void renameElement(
            @NotNull PsiElement element,
            @NotNull String newName,
            @NotNull UsageInfo[] usages,
            @Nullable RefactoringElementListener listener
    ) {
        System.err.println("renameElement = " + element.getClass().getSimpleName());
        if (!(element instanceof PsiNamedElement)) {
            System.err.println("Not a PsiNamedElement: " + element);
            return;
        }

        Project project = JPlusContext.getInstance().getProject();
        System.err.println("project = " + project);

        PsiJavaFile javaPsiFile = (PsiJavaFile) element.getContainingFile();
        performInMemoryRename(project, javaPsiFile, (PsiNamedElement) element, newName);

        String newJavaCode = javaPsiFile.getText();
        System.out.println("newJavaCode = " + newJavaCode);

        String newJPlusCode = newJavaCode;

        PsiFile jplusFile = JPlusContext.getInstance().getJPlusFile();
        System.err.println("jadexFile = " + jplusFile);
        if (jplusFile == null) return;

        Document jplusDoc = PsiDocumentManager.getInstance(project).getDocument(jplusFile);
        if (jplusDoc != null) {
            ApplicationManager.getApplication().runWriteAction(() -> {
                jplusDoc.setText(newJPlusCode);
                PsiDocumentManager.getInstance(project).commitDocument(jplusDoc);
            });
        }

        if (listener != null) listener.elementRenamed(element);
    }

    private void performInMemoryRename(Project project,
                                       PsiJavaFile javaPsiFile,
                                       PsiNamedElement element,
                                       String newName) {

        ApplicationManager.getApplication().runWriteAction(() -> {
            // reference rename
            Collection<PsiReference> refs = ReferencesSearch.search(element, element.getUseScope()).findAll();
            for (PsiReference ref : refs) {
                try {
                    ref.handleElementRename(newName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            PsiElement[] psiElements = PsiTreeUtil.collectElements(javaPsiFile, psiElement -> psiElement instanceof PsiReference);
            for (PsiElement refElement : psiElements) {
                PsiReference ref = (PsiReference) refElement;
                PsiElement resolved = ref.resolve();
                if (resolved != null && resolved.isEquivalentTo(element)) {
                    try {
                        ref.handleElementRename(newName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            // identifier rename
            element.setName(newName);

            PsiDocumentManager.getInstance(project).commitAllDocuments();
        });
    }


    private @Nullable PsiElement findCorrespondingJavaElement(PsiJavaFile javaPsiFile, int offset) {
        return javaPsiFile.findElementAt(offset);
    }
}
