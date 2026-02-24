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
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import jplus.analyzer.nullability.NullabilityChecker;
import jplus.analyzer.nullability.issue.NullabilityIssue;
import jplus.analyzer.nullability.issue.Severity;
import jplus.plugin.intellij.JPlusFile;
import jplus.processor.JPlusProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JPlusExternalAnnotator
        extends ExternalAnnotator<JPlusAnnotationInput, JPlusAnnotationResult> {

    @Override
    public @Nullable JPlusAnnotationInput collectInformation(
            @NotNull PsiFile file
    ) {
        if (!(file instanceof JPlusFile)) return null;

        Project ideaProject = file.getProject();

        Module module = ModuleUtilCore.findModuleForFile(file.getVirtualFile(), ideaProject);
        jplus.base.Project jplusProject = JPlusIntelliJProjectUtil.buildJPlusProject(ideaProject, module);

        String className = file.getVirtualFile().getNameWithoutExtension();

        String packageName = JPlusIntelliJProjectUtil.resolvePackageName(ideaProject, file);

        return new JPlusAnnotationInput(
                file.getText(),
                packageName,
                className,
                jplusProject
        );
    }

    @Override
    public @Nullable JPlusAnnotationResult doAnnotate(
            JPlusAnnotationInput input
    ) {
        ProgressIndicator indicator = ProgressManager.getInstance().getProgressIndicator();

        try {

            JPlusProcessor processor =
                    new JPlusProcessor(
                            input.project(),
                            input.packageName(),
                            input.className()
                    );

            if (indicator != null) {
                indicator.setText("Jadex: Processing");
                indicator.setIndeterminate(false);
                indicator.setFraction(0.1);
            }

            processor.process();

            if (indicator != null) {
                indicator.checkCanceled();
                indicator.setText("Jadex: Analyzing symbols");
                indicator.setFraction(0.4);
            }

            processor.analyzeSymbols();

            if (indicator != null) {
                indicator.checkCanceled();
                indicator.setText("Jadex: Checking nullability");
                indicator.setFraction(0.6);
            }

            List<NullabilityIssue> issues = processor.checkNullability();

            if (indicator != null) {
                indicator.setFraction(1.0);
            }

            return new JPlusAnnotationResult(issues);
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

        for (NullabilityIssue issue : result.issues()) {
            holder.newAnnotation(
                            convertSeverity(issue.severity()),
                            issue.message()
                    )
                    .range(TextRange.create(issue.offset(), issue.offset()))
                    .create();
        }
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
