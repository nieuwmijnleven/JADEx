package jplus.plugin.intellij.listener;

import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.Alarm;
import jplus.plugin.intellij.annotator.JadexAnnotatorState;
import org.jetbrains.annotations.NotNull;

public class JadexDocumentListener implements DocumentListener {

    private final Project project;
    private final Alarm alarm;
    private static final int DELAY_MS = 2000;

    public JadexDocumentListener(@NotNull Project project) {
        this.project = project;
        this.alarm = new Alarm(Alarm.ThreadToUse.SWING_THREAD, project); // project를 Disposable로 연동
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        var jadexAnnotatorState = JadexAnnotatorState.getInstance(project);
        jadexAnnotatorState.onTypingStarted();

        alarm.cancelAllRequests();
        alarm.addRequest(() -> {
            jadexAnnotatorState.onTypingFinished();
            reopenAnnotator(event.getDocument());
        }, DELAY_MS);
    }

    private void reopenAnnotator(Document document) {
        VirtualFile file = FileDocumentManager.getInstance().getFile(document);
        if (file == null) return;

        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        if (psiFile != null) {
            DaemonCodeAnalyzer.getInstance(project).restart(psiFile);
        }
    }
}