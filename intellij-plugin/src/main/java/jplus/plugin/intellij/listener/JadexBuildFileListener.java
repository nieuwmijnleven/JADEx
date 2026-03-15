package jplus.plugin.intellij.listener;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileContentChangeEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import jplus.plugin.intellij.gradle.JadexPathManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JadexBuildFileListener implements BulkFileListener {

    private final Project project;

    public JadexBuildFileListener(Project project) {
        this.project = project;
    }

    @Override
    public void after(@NotNull List<? extends VFileEvent> events) {
        for (VFileEvent event : events) {
            if (!(event instanceof VFileContentChangeEvent)) continue;

            String fileName = event.getFile().getName();
            if (!fileName.equals("build.gradle")
                    && !fileName.equals("build.gradle.kts")) continue;

            JadexPathManager.refresh(project);
            return;
        }
    }
}