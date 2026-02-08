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

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.PsiVariable;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.jetbrains.cef.remote.thrift.annotation.Nullable;
import jplus.plugin.intellij.util.JPlusUtil;
import org.jetbrains.annotations.NotNull;

public class JPlusPsiReference extends PsiReferenceBase<PsiElement> {

    public JPlusPsiReference(@NotNull PsiElement element, TextRange range) {
        super(element, range);
    }

    @Override
    public @Nullable PsiElement resolve() {
        Project project = myElement.getProject();
        PsiFile jplusPsiFile = myElement.getContainingFile();
        String symbol = getValue();

//        var javaFile = JPlusUtil.createJavaPsiFromJPlus(project, jplusPsiFile);
        PsiJavaFile javaFile = (PsiJavaFile) PsiFileFactory.getInstance(project)
                .createFileFromText("Temp.java", JavaFileType.INSTANCE, jplusPsiFile.getText());
//        if (javaFile == null) return null;
//        int newOffset = JPlusUtil.findNewOffset(jplusPsiFile.getText(), javaFile.getText(), myElement.getTextRange().getStartOffset());
        int offset = myElement.getTextOffset();

        PsiElement deReferencedElement = JPlusUtil.findCorrespondingPsiElement(javaFile, offset);
        if (deReferencedElement == null || !(deReferencedElement instanceof PsiIdentifier)) return null;

        PsiElement resolved = PsiTreeUtil.getParentOfType(deReferencedElement, false, PsiJavaCodeReferenceElement.class);
        if (resolved != null) {
            var refElement = (PsiJavaCodeReferenceElement) resolved;
            String qualfiedName = refElement.getQualifiedName();
            String packageName = javaFile.getPackageName();
            if (packageName.length() > 0 && !qualfiedName.startsWith(packageName)) {
                PsiClass psiClass = JavaPsiFacade.getInstance(project).findClass(qualfiedName, GlobalSearchScope.allScope(project));
                if (psiClass != null) return psiClass;
            }
            resolved = resolved.getReference().resolve();
        } else {
            resolved = PsiTreeUtil.getParentOfType(deReferencedElement, false, PsiClass.class, PsiMethod.class, PsiField.class, PsiVariable.class);
        }

        if (resolved == null) return null;

        if (resolved instanceof PsiNamedElement psiNamedElement) {
            return new PsiNamedElementWrapper(psiNamedElement, jplusPsiFile);
        } else {
            return new PsiElementWrapper(resolved, jplusPsiFile);
        }
    }
}
