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

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.ModuleListener;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModuleChangeListener implements ModuleListener {

    @Override
    public void modulesAdded(@NotNull Project project, @NotNull List<? extends Module> modules) {
        JPlusExternalAnnotator.clearProjectCache();
    }

    @Override
    public void moduleRemoved(@NotNull Project project, @NotNull Module module) {
        JPlusExternalAnnotator.clearProjectCache();
    }
}