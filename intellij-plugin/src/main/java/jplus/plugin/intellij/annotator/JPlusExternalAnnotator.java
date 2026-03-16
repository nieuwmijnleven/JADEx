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

package jplus.plugin.intellij.annotator;

import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.util.ui.update.MergingUpdateQueue;
import com.intellij.util.ui.update.Update;
import jplus.analyzer.nullability.issue.NullabilityIssue;
import jplus.analyzer.nullability.issue.Severity;
import jplus.plugin.intellij.JPlusFile;
import jplus.processor.JPlusProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class JPlusExternalAnnotator
        extends ExternalAnnotator<JPlusAnnotationInput, JPlusAnnotationResult> {

    private static final ConcurrentHashMap<String, jplus.base.Project> projectCache = new ConcurrentHashMap<>();

    @Override
    public @Nullable JPlusAnnotationInput collectInformation(
            @NotNull PsiFile file
    ) {
        if (!(file instanceof JPlusFile)) return null;

        String filePath = file.getVirtualFile().getPath();

        Project ideaProject = file.getProject();
        Module module = ModuleUtilCore.findModuleForFile(file.getVirtualFile(), ideaProject);

        String moduleKey = module != null ? module.getName() : ideaProject.getName();
        jplus.base.Project jplusProject = projectCache.computeIfAbsent(
                moduleKey,
                k -> JPlusIntelliJProjectUtil.buildJPlusProject(ideaProject, module)
        );

        String packageName = JPlusIntelliJProjectUtil.resolvePackageName(ideaProject, file);
        String className = file.getVirtualFile().getNameWithoutExtension();

        return new JPlusAnnotationInput(
                jplusProject,
                packageName,
                className
        );
    }

    @Override
    public @Nullable JPlusAnnotationResult doAnnotate(
            JPlusAnnotationInput input
    ) {

        ProgressIndicatorProvider.checkCanceled();

        try {

            JPlusProcessor processor =
                    new JPlusProcessor(
                            input.project(),
                            input.packageName(),
                            input.className()
                    );

            ProgressIndicatorProvider.checkCanceled();
            if (!processor.canParse()) return null;

            ProgressIndicatorProvider.checkCanceled();
            var diagnostics = processor.process();

            ProgressIndicatorProvider.checkCanceled();
            processor.analyzeSymbols();

            ProgressIndicatorProvider.checkCanceled();
            List<NullabilityIssue> issues = processor.checkNullability();

            return new JPlusAnnotationResult(diagnostics, issues);

        } catch (ProcessCanceledException pce) {
            throw pce;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void apply(
            @NotNull PsiFile file,
            JPlusAnnotationResult result,
            @NotNull com.intellij.lang.annotation.AnnotationHolder holder
    ) {
        if (result == null) return;

        for (var diagnostic : result.diagnostics()) {
            holder.newAnnotation(
                            HighlightSeverity.ERROR,
                            diagnostic.message()
                    )
                    .range(TextRange.create((int)diagnostic.start(), (int)diagnostic.end()))
                    .create();
        }

        for (NullabilityIssue issue : result.issues()) {
            holder.newAnnotation(
                            convertSeverity(issue.severity()),
                            issue.message()
                    )
                    .range(TextRange.create(issue.offset(), issue.offset()))
                    .create();
        }
    }

    public static void clearProjectCache() {
        projectCache.clear();
    }

    private HighlightSeverity convertSeverity(Severity severity) {

        return switch(severity) {
            case Severity.WARNING -> HighlightSeverity.WARNING;
            case Severity.INFO -> HighlightSeverity.INFORMATION;
            case Severity.ERROR -> HighlightSeverity.ERROR;
            default ->  HighlightSeverity.WARNING;
        };
    }
}
