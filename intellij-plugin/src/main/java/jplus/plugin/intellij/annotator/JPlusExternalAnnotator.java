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
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import jplus.analyzer.nullability.issue.NullabilityIssue;
import jplus.analyzer.nullability.issue.Severity;
import jplus.plugin.intellij.JPlusFile;
import jplus.plugin.intellij.util.JPlusUtil;
import jplus.processor.JPlusProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class JPlusExternalAnnotator
        extends ExternalAnnotator<JPlusAnnotationInput, JPlusAnnotationResult> {

    private static final Logger LOG = Logger.getInstance(JPlusExternalAnnotator.class);

    private static final ConcurrentHashMap<String, jplus.base.Project> projectCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, JPlusAnnotationResult> resultCache = new ConcurrentHashMap<>();

    public @Nullable JPlusAnnotationInput collectInformation(@NotNull PsiFile file, @NotNull Editor editor, boolean hasErrors) {
        LOG.debug("collectInformation called: " + file.getName());

        if (hasErrors || !(file instanceof JPlusFile jadexPsiFile)) return null;

        Project ideaProject = file.getProject();

        if (DumbService.isDumb(ideaProject)) return null;

        if (!JadexAnnotatorState.getInstance(ideaProject).isEnabled()) return null;

        VirtualFile vf = file.getVirtualFile();
        if (vf != null) {
            Document docOnDisk = FileDocumentManager.getInstance().getDocument(vf);
            if (docOnDisk != null &&
                    FileDocumentManager.getInstance().isDocumentUnsaved(docOnDisk)) {
                LOG.debug("collectInformation skipped (unsaved): " + file.getName());
                return null;
            }
        }

        FileEditorManager editorManager = FileEditorManager.getInstance(ideaProject);
        Editor selectedEditor = editorManager.getSelectedTextEditor();

        if (selectedEditor == null || !selectedEditor.equals(editor)) {
            return null;
        }

        PsiDocumentManager docManager = PsiDocumentManager.getInstance(ideaProject);
        Document doc = docManager.getCachedDocument(jadexPsiFile);

        if (doc != null && !docManager.isCommitted(doc)) return null;

        Module module = ModuleUtilCore.findModuleForFile(file.getVirtualFile(), ideaProject);

        String moduleKey = module != null ? module.getName() : ideaProject.getName();
        jplus.base.Project jplusProject = projectCache.computeIfAbsent(
                moduleKey,
                k -> JPlusUtil.buildJadexProject(ideaProject, module)
        );

        if (jplusProject == null) return null;

        String packageName = JPlusIntelliJProjectUtil.resolvePackageName(ideaProject, file);
        String className = file.getVirtualFile().getNameWithoutExtension();
        String contentHash = Integer.toHexString(doc.getText().hashCode());

        return new JPlusAnnotationInput(
                jplusProject,
                packageName,
                className,
                contentHash
        );
    }

    @Override
    public @Nullable JPlusAnnotationResult doAnnotate(
            JPlusAnnotationInput input
    ) {
        LOG.debug("doAnnotate called");

        String key = input.packageName() + "." + input.className() + ":" + input.contentHash();
        if (resultCache.containsKey(key)) return resultCache.get(key);

        ProgressIndicatorProvider.checkCanceled();

        try {
            JPlusProcessor processor = new JPlusProcessor(
                    input.project(), input.packageName(), input.className()
            );
            LOG.debug("processor created");

            ProgressIndicatorProvider.checkCanceled();
            boolean canParse = processor.canParse();
            LOG.debug("canParse = " + canParse);
            if (!canParse) return null;

            ProgressIndicatorProvider.checkCanceled();
            var diagnostics = processor.process();
            LOG.debug("process done, diagnostics = " + diagnostics.size());

            ProgressIndicatorProvider.checkCanceled();
            processor.analyzeSymbols();
            LOG.debug("analyzeSymbols done");

            ProgressIndicatorProvider.checkCanceled();
            List<NullabilityIssue> issues = processor.checkNullability();
            LOG.debug("checkNullability done, issues = " + issues.size());

            var result = new JPlusAnnotationResult(diagnostics, issues);
            resultCache.put(key, result);

            return result;

        } catch (ProcessCanceledException pce) {
            LOG.warn("doAnnotate cancelled by PCE");  // ← PCE도 잠깐 찍고 rethrow
            throw pce;
        } catch (Exception e) {
            LOG.warn("doAnnotate failed", e);
            return null;
        }
    }

    @Override
    public void apply(
            @NotNull PsiFile file,
            JPlusAnnotationResult result,
            @NotNull com.intellij.lang.annotation.AnnotationHolder holder
    ) {
        LOG.debug("apply called");
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
