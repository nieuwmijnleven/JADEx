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

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConvertToJPlusAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (file == null || !file.getName().endsWith(".java")) {
            ApplicationManager.getApplication().invokeLater(() ->
                Messages.showErrorDialog(project, "Please select a Java file.", "Invalid File")
            );
            return;
        }

        String content;
        try {
            content = new String(file.contentsToByteArray(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ApplicationManager.getApplication().invokeLater(() ->
                Messages.showErrorDialog(project, "Failed to read file: " + ex.getMessage(), "Error")
            );
            return;
        }

        String newFileName = file.getNameWithoutExtension() + ".jadex";

        WriteCommandAction.runWriteCommandAction(project, () -> {
            try {
                VirtualFile newFile = file.getParent().createChildData(this, newFileName);
                newFile.setBinaryContent(content.getBytes(StandardCharsets.UTF_8));

                ApplicationManager.getApplication().invokeLater(() -> {
                    FileEditorManager.getInstance(project).openFile(newFile, true);
                });
            } catch (IOException ex) {
                ApplicationManager.getApplication().invokeLater(() ->
                    Messages.showErrorDialog(project, "Failed to create Jadex file: " + ex.getMessage(), "Error")
                );
            }
        });
    }

//    @Override
//    public void update(AnActionEvent e) {
//        System.err.println("actionPlace = " + e.getPlace());
//        if (ActionPlaces.PROJECT_VIEW_POPUP.equals(e.getPlace())) {
//            e.getPresentation().setText("Convert Java File to JPlus");
////            Language language = e.getData(CommonDataKeys.LANGUAGE);
////            System.out.println("language = " + language);
////            e.getPresentation().setEnabledAndVisible(file != null && file.getName().endsWith(".java"));
//        }

//    }
}
