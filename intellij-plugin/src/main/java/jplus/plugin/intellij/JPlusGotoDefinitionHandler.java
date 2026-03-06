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

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiReference;
import com.jetbrains.cef.remote.thrift.annotation.Nullable;

public class JPlusGotoDefinitionHandler implements GotoDeclarationHandler {

    @Override
    public @Nullable PsiElement[] getGotoDeclarationTargets(
            @Nullable PsiElement sourceElement, int offset, Editor editor) {

        if (sourceElement == null) {
            System.err.println("[JPlusGotoDefinitionHandler]getGotoDeclarationTargets called with null sourceElement at offset " + offset);
            return PsiElement.EMPTY_ARRAY;
        }

        System.err.println("[JPlusGotoDefinitionHandler]GotoDeclaration triggered for element: " + sourceElement.getText()
                + " at offset " + offset + " in file " + sourceElement.getContainingFile().getName());

        PsiReference ref = sourceElement.getReference();
        if (ref != null) {

            System.err.println("[JPlusGotoDefinitionHandler]Found reference for element: " + sourceElement.getText() + "(" + sourceElement.getClass().getSimpleName() + "), resolving...");
            PsiElement resolved = ref.resolve();
            if (resolved != null) {
                System.err.println("[JPlusGotoDefinitionHandler]Reference resolved to: " + resolved.getText()
                        + " in file " + resolved.getContainingFile().getName());
                return new PsiElement[]{resolved};
            } else {
                System.err.println("[JPlusGotoDefinitionHandler]Reference could not be resolved for element: " + sourceElement.getText());
            }
        } else {
            System.err.println("[JPlusGotoDefinitionHandler]No reference found for element: " + sourceElement.getText());
        }

        return PsiElement.EMPTY_ARRAY;
    }
    
    /*@Override
    public  @Nullable PsiElement[] getGotoDeclarationTargets(
            @Nullable PsiElement sourceElement, int offset, Editor editor) {

        if (sourceElement == null) return PsiElement.EMPTY_ARRAY;

        PsiReference ref = sourceElement.getReference();
        if (ref != null) {
            PsiElement resolved = ref.resolve();
            if (resolved != null) {
                return new PsiElement[]{resolved};
            }
        }

        return PsiElement.EMPTY_ARRAY;
    }*/

    @Override
    public @Nullable String getActionText(@Nullable com.intellij.openapi.actionSystem.DataContext context) {
        return "Go to Definition";
    }
}