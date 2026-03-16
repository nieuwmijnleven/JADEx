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

package jplus.plugin.intellij.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import jplus.plugin.intellij.gradle.ResolvedPaths;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// JadexProjectSettings.java
@State(
        name = "JadexProjectSettings",
        storages = @Storage("jadex.xml")
)
public class JadexProjectSettings
        implements PersistentStateComponent<JadexProjectSettings.State> {

    public static class State {
        // ResolvedPaths 대신 sourceDir, outputDir을 별도 Map으로 분리
        public Map<String, String> sourceDirMap = new HashMap<>();
        public Map<String, String> outputDirMap = new HashMap<>();
    }

    private State state = new State();

    public static JadexProjectSettings getInstance(Project project) {
        return project.getService(JadexProjectSettings.class);
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull State state) {
        this.state = state;
    }

    public void update(List<ResolvedPaths> paths) {
        state.sourceDirMap = new HashMap<>();
        state.outputDirMap = new HashMap<>();
        paths.forEach(resolvedPaths -> {
            state.sourceDirMap.put(resolvedPaths.getModuleDir(), resolvedPaths.getSourceDir());
            state.outputDirMap.put(resolvedPaths.getModuleDir(), resolvedPaths.getOutputDir());
        });
    }

    public boolean hasGradleConfig(String moduleDir) {
        return moduleDir != null && state.sourceDirMap.containsKey(moduleDir);
    }

    public Optional<String> getSourceDir(String moduleDir) {
        return Optional.ofNullable(state.sourceDirMap.get(moduleDir));
    }

    public Optional<String> getOutputDir(String moduleDir) {
        return Optional.ofNullable(state.outputDirMap.get(moduleDir));
    }
}