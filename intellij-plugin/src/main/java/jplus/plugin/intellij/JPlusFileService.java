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

import com.intellij.codeInsight.daemon.impl.DaemonCodeAnalyzerEx;
import com.intellij.codeInsight.daemon.impl.DaemonCodeAnalyzerImpl;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import jplus.plugin.intellij.annotator.JPlusIntelliJProjectUtil;
import jplus.processor.JPlusProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JPlusFileService {

    private final Project project;

    public JPlusFileService(Project project) {
        this.project = project;
    }

    public void compileAndWriteToJava(PsiFile file, VirtualFile jplusFile, String jplusCode, ProgressIndicator indicator) {

        try {

            Project ideaProject = file.getProject();

            Module module = ModuleUtilCore.findModuleForFile(file.getVirtualFile(), ideaProject);
            jplus.base.Project jplusProject = JPlusIntelliJProjectUtil.buildJPlusProject(ideaProject, module);

            JPlusProcessor processor = new JPlusProcessor(jplusProject, jplusCode);

            indicator.setText("Parsing");
            processor.process();

            indicator.setText("Analyzing Symbols");
            processor.analyzeSymbols();

            //var issues = processor.checkNullability();
//            if (!issues.isEmpty()) {
//                System.err.println("Nullability check failed.");
//                return;
//            }

            indicator.setText("Generating Java");
            String javaCode = processor.generateJavaCode();
            //System.out.println("javaCode = " + javaCode);

            indicator.setText("Writing file");

            Path jplusPath = Paths.get(jplusFile.getPath());
            String javaFileName = jplusPath.getFileName().toString().replaceFirst("\\.jadex$", ".java");
            Path javaFilePath = jplusPath.resolveSibling(javaFileName);

            Path sourceRoot = jplusProject.getSourceDirs().get(0);
            ApplicationManager.getApplication().invokeLater(() -> {
                WriteCommandAction.runWriteCommandAction(project, () -> {
                    try {
                        var jadexRuntime = sourceRoot.resolve("jadex/runtime/SafeAccess.java").toFile();
                        LocalFileSystem.getInstance().refreshAndFindFileByIoFile(jadexRuntime);

                        VirtualFile javaVirtualFile = LocalFileSystem.getInstance()
                                .findFileByPath(javaFilePath.toString());
                        if (javaVirtualFile == null) {
                            javaVirtualFile = jplusFile.getParent().createChildData(this, javaFileName);
                        }

                        PsiFile psiFile = PsiManager.getInstance(project).findFile(javaVirtualFile);
                        if (psiFile != null) {
                            var doc = PsiDocumentManager.getInstance(project).getDocument(psiFile);
                            if (doc != null) {
                                doc.setText(javaCode);
                                PsiDocumentManager.getInstance(project).commitDocument(doc);
                                FileDocumentManager.getInstance().saveDocument(doc);
                            }
                        } else {
                            javaVirtualFile.setBinaryContent(javaCode.getBytes());
                        }

//                    FileDocumentManager.getInstance().saveAllDocuments();
                        System.out.println("JADEx compiled -> " + javaFilePath);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
