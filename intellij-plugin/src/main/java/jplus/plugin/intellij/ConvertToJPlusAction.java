package jplus.plugin.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.externalSystem.ExternalSystemModulePropertyManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import jplus.plugin.intellij.settings.JadexProjectSettings;
import jplus.plugin.intellij.util.JPlusUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertToJPlusAction extends AnAction {

    private static final Pattern PACKAGE_PATTERN =
            Pattern.compile("^\\s*package\\s+([\\w.]+)\\s*;", Pattern.MULTILINE);

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
        VirtualFile targetDir = resolveTargetDir(project, file, content);

        if (targetDir == null) {
            ApplicationManager.getApplication().invokeLater(() ->
                    Messages.showErrorDialog(project, "Failed to resolve target directory.", "Error")
            );
            return;
        }

        VirtualFile finalTargetDir = targetDir;
        WriteCommandAction.runWriteCommandAction(project, () -> {
            try {
                VirtualFile newFile = finalTargetDir.createChildData(this, newFileName);
                newFile.setBinaryContent(content.getBytes(StandardCharsets.UTF_8));

                if (hasGradleConfig(project, JPlusUtil.getModuleDir(project, file))) file.delete(this);

                ApplicationManager.getApplication().invokeLater(() ->
                        FileEditorManager.getInstance(project).openFile(newFile, true)
                );
            } catch (IOException ex) {
                ApplicationManager.getApplication().invokeLater(() ->
                        Messages.showErrorDialog(project, "Failed to create Jadex file: " + ex.getMessage(), "Error")
                );
            }
        });
    }

    private boolean hasGradleConfig(Project project, String moduleDir) {

        JadexProjectSettings settings = JadexProjectSettings.getInstance(project);
        return settings.hasGradleConfig(moduleDir);
    }

    private VirtualFile resolveTargetDir(Project project, VirtualFile file, String content) {

        String moduleDir = JPlusUtil.getModuleDir(project, file);
        if (moduleDir == null) return file.getParent();

        JadexProjectSettings settings = JadexProjectSettings.getInstance(project);

        if (!settings.hasGradleConfig(moduleDir)) return file.getParent();

        String sourceDir = settings.getSourceDir(moduleDir).orElseThrow();
        String packageName = extractPackageName(content);
        String packagePath = packageName.replace('.', '/');

        Path targetPath = Path.of(moduleDir, sourceDir, packagePath);
        System.out.println("[resolveTargetDir] targetPath = " + targetPath);

        try {
            Files.createDirectories(targetPath);
        } catch (IOException ex) {
            return null;
        }

        return LocalFileSystem.getInstance()
                .refreshAndFindFileByIoFile(targetPath.toFile());
    }

    private String extractPackageName(String content) {
        Matcher matcher = PACKAGE_PATTERN.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}