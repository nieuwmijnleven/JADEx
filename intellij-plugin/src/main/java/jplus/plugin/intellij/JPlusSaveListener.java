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

import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

public class JPlusSaveListener implements FileDocumentManagerListener {

    private final Project project;
    private final JPlusFileService fileService;

    public JPlusSaveListener(Project project) {
        this.project = project;
        this.fileService = new JPlusFileService(project);
    }

    @Override
    public void beforeDocumentSaving(@NotNull com.intellij.openapi.editor.Document document) {
//        VirtualFile file = FileDocumentManager.getInstance().getFile(document);
//        if (file != null && file.getName().endsWith(".jplus")) {
//            fileService.compileAndWriteToJava(file, document.getText());
//        }

        VirtualFile file = FileDocumentManager.getInstance().getFile(document);
        if (file == null || !file.getName().endsWith(".jadex")) return;

        String text = document.getText();

        new Task.Backgroundable(project, "Jadex Compile", false) {

            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                indicator.setIndeterminate(true);
                indicator.setText("Compiling " + file.getName());

                PsiFile psiFile = ReadAction.compute(() -> PsiManager.getInstance(project).findFile(file));
                if (psiFile == null) return;

                fileService.compileAndWriteToJava(psiFile, file, text, indicator);
            }
        }.queue();
    }
}
