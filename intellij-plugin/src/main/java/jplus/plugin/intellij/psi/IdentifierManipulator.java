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

package jplus.plugin.intellij.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class IdentifierManipulator extends AbstractElementManipulator<IdentifierPsiElement> {

    @Override
    public IdentifierPsiElement handleContentChange(@NotNull IdentifierPsiElement psiElement,
                                                    @NotNull TextRange range,
                                                    String newContent) throws IncorrectOperationException {
        String oldText = psiElement.getText();
        String newText = oldText.substring(0, range.getStartOffset()) +
                         newContent +
                         oldText.substring(range.getEndOffset());

        return (IdentifierPsiElement) psiElement.setName(newText);
    }

    @Override
    public @NotNull TextRange getRangeInElement(@NotNull IdentifierPsiElement element) {
        return new TextRange(0, element.getTextLength());
    }
}