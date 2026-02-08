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

package jplus.plugin.intellij;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.util.Icons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class JPlusFileType extends LanguageFileType {
    public static final JPlusFileType INSTANCE = new JPlusFileType();
    
    protected JPlusFileType() {
        super(JPlusLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Jadex";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Jadex";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "Jadex";
    }

    @Override
    public Icon getIcon() {
        return Icons.JAVA_OUTSIDE_SOURCE_ICON;
    }
}
