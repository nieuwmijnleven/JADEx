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

// JadexProjectSettings.java
@State(
    name = "JadexProjectSettings",
    storages = @Storage("jadex.xml")  // .idea/jadex.xml
)
public class JadexProjectSettings
        implements PersistentStateComponent<JadexProjectSettings.State> {

    public static class State {
        public String sourceDir = null;
        public String outputDir = null;
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

    public void update(ResolvedPaths paths) {
        if (paths == null) {
            state.sourceDir = null;
            state.outputDir = null;
        } else {
            state.sourceDir = paths.getSourceDir();
            state.outputDir = paths.getOutputDir();
        }
    }

    public boolean hasGradleConfig() {
        return state.sourceDir != null;
    }

    public String getSourceDir() { return state.sourceDir; }
    public String getOutputDir() { return state.outputDir; }
}