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

package jplus.plugin.intellij.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiLocalVariable;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.PsiReferenceExpression;
import com.intellij.psi.PsiVariable;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import jplus.plugin.intellij.util.JPlusUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JADExPsiReference extends PsiReferenceBase<PsiElement> {

    public JADExPsiReference(@NotNull PsiElement element) {
        super(element);
    }

    @Override
    public PsiElement resolve() {

        Project project = myElement.getProject();
        PsiFile jadexPsiFile = myElement.getContainingFile();

        PsiJavaFile javaFile = JPlusUtil.createJavaPsiFromJPlus(project, jadexPsiFile, true);
        if (javaFile == null) return null;

        String currentFQN = javaFile.getClasses()[0].getQualifiedName();

        int mapOffset = JPlusUtil.findMapOffset(jadexPsiFile.getText(), javaFile.getText(), myElement.getTextRange().getStartOffset());
        PsiElement javaPsiElement = JPlusUtil.findCorrespondingPsiElement(javaFile, mapOffset);

        if (javaPsiElement == null) return null;

        if (!(javaPsiElement instanceof PsiIdentifier)) {

            var javaPsiElementOpt =
                PsiTreeUtil.getChildrenOfTypeAsList(javaPsiElement, PsiIdentifier.class).stream()
                          .filter(psiIdentifier -> Objects.equals(psiIdentifier.getText(), myElement.getText()))
                        .findFirst();

            if (javaPsiElementOpt.isEmpty()) return null;

            javaPsiElement = javaPsiElementOpt.get();
        }

        var resolved = resolveReferencePsiElement(jadexPsiFile, javaFile, javaPsiElement, currentFQN, PsiReferenceExpression.class);
        if (resolved != null) return resolved;

        return resolveReferencePsiElement(jadexPsiFile, javaFile, javaPsiElement, currentFQN, PsiJavaCodeReferenceElement.class);
    }

    private PsiElement resolveReferencePsiElement(PsiFile jadexPsiFile, PsiJavaFile javaFile, PsiElement javaPsiElement, String currentFQN, Class<? extends PsiElement> psiReferenceClass) {
        var referenceExpression =
                PsiTreeUtil.getParentOfType(javaPsiElement, psiReferenceClass);
        if (referenceExpression == null) return null;

        var reference = referenceExpression.getReference();
        if (reference == null) return null;

        PsiElement resolved = reference.resolve();
        if (resolved == null) return null;

        return handleResolved(jadexPsiFile, javaFile, currentFQN, resolved);
    }

    private PsiElement handleResolved(PsiFile jadexPsiFile, PsiJavaFile javaFile, String currentFQN, PsiElement resolved) {
        String qualifiedName = getResolvedFQN(resolved);
        if (qualifiedName == null || !qualifiedName.startsWith(currentFQN)) {
            return resolved;
        }

        int jadexMapOffset = JPlusUtil.findMapOffset(javaFile.getText(), jadexPsiFile.getText(), resolved.getTextRange().getStartOffset());
        return JPlusUtil.findCorrespondingPsiElement(jadexPsiFile, jadexMapOffset);
    }

    private String getResolvedFQN(PsiElement resolved) {

        if (resolved instanceof PsiClass psiClass) {
            return psiClass.getQualifiedName();
        }

        if (resolved instanceof PsiMethod psiMethod) {
            PsiClass clazz = psiMethod.getContainingClass();
            return clazz != null ? clazz.getQualifiedName() + "." + psiMethod.getName() : null;
        }

        if (resolved instanceof PsiField psiField) {
            PsiClass clazz = psiField.getContainingClass();
            return clazz != null ? clazz.getQualifiedName() + "." + psiField.getName() : null;
        }

        if (resolved instanceof PsiVariable psiVariable) {
            PsiElement scope = psiVariable.getParent();
            String name = psiVariable.getName();

            if (psiVariable instanceof PsiParameter) {

                PsiMethod method = PsiTreeUtil.getParentOfType(psiVariable, PsiMethod.class);
                if (method != null) {
                    PsiClass clazz = method.getContainingClass();
                    String classFQN = clazz != null ? clazz.getQualifiedName() : null;
                    return classFQN != null ? classFQN + "." + method.getName() + "." + name : method.getName() + "." + name;
                }
            } else if (psiVariable instanceof PsiLocalVariable) {

                PsiMethod method = PsiTreeUtil.getParentOfType(psiVariable, PsiMethod.class);
                if (method != null) {
                    PsiClass clazz = method.getContainingClass();
                    String classFQN = clazz != null ? clazz.getQualifiedName() : null;
                    return classFQN != null ? classFQN + "." + method.getName() + "." + name : method.getName() + "." + name;
                }
            }

            return name;
        }

        return null;
    }
}
