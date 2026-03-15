/*
 * JADEx - Java Advanced Development Extension
 * ...
 */

package jplus.plugin.intellij.listener;

import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskType;
import com.intellij.openapi.project.Project;
import jplus.plugin.intellij.gradle.JadexPathManager;
import org.jetbrains.plugins.gradle.util.GradleConstants;

public class JadexGradleSyncListener
        implements ExternalSystemTaskNotificationListener {

    @Override
    public void onSuccess(ExternalSystemTaskId id) {
        // Gradle sync 태스크 완료 시에만 처리
        if (!id.getProjectSystemId().equals(GradleConstants.SYSTEM_ID)) return;
        if (!id.getType().equals(ExternalSystemTaskType.RESOLVE_PROJECT)) return;

        Project project = id.findProject();
        if (project == null) return;

        JadexPathManager.refresh(project);
    }
}