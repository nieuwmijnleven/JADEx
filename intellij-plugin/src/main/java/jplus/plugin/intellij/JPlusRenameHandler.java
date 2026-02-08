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

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.refactoring.rename.RenameDialog;
import com.intellij.refactoring.rename.RenameHandler;
import com.intellij.refactoring.rename.RenameProcessor;
import jplus.plugin.intellij.psi.PsiElementWrapper;
import jplus.plugin.intellij.util.JPlusUtil;
import org.jetbrains.annotations.NotNull;

public class JPlusRenameHandler implements RenameHandler {
    
    @Override
    public void invoke(@NotNull Project project, @NotNull PsiElement[] elements, DataContext dataContext) {
//        if (elements.length != 1) return;
//        PsiElement element = elements[0];
//
//        RenameDialog dialog = new RenameDialog(project, element, element.getContext(), null);
//        dialog.show();
//
//        if (dialog.isOK()) {
//            String newName = dialog.getNewName();
//
//            RenameProcessor processor = new RenameProcessor(project, element, newName, true, true);
//            processor.run();
//        }
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, PsiFile file, DataContext dataContext) {
        PsiJavaFile psiJavaFile = JPlusUtil.createJavaPsiFromJPlus(project, file);
        PsiElement element = psiJavaFile.findElementAt(editor.getCaretModel().getOffset());
        if (element == null) return;

        RenameDialog dialog = new RenameDialog(project, element, element.getContext(), editor);
        dialog.show();

        if (dialog.isOK()) {
            String newName = dialog.getNewName();

            PsiElement target = new PsiElementWrapper(element, file);
            RenameProcessor processor = new RenameProcessor(project, target, newName, true, true);
            processor.run();
        }

    }

    @Override
    public boolean isAvailableOnDataContext(@NotNull DataContext dataContext) {
        return true;
    }

//    @Override
//    public void invoke(@NotNull Project project, Editor editor, PsiFile file, DataContext dataContext) {
//        PsiElement element = file.findElementAt(editor.getCaretModel().getOffset());
//        invoke(project, new PsiElement[]{element}, dataContext);
//    }
}