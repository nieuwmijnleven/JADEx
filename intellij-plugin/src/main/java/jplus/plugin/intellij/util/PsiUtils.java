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

package jplus.plugin.intellij.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.SmartList;
import jplus.plugin.intellij.psi.NormalClassDeclarationPsiElement;

import java.util.ArrayList;
import java.util.List;

public class PsiUtils {

    private PsiUtils() {}

    public static List<String> getClassNameList(PsiElement element) {
        List<String> classNameList = new ArrayList<>();
        getClassList(element, "", classNameList);
        return classNameList;
    }

    private static void getClassList(PsiElement element, String currentClassName, List<String> result) {
        if (element == null) return;

        var klass = NormalClassDeclarationPsiElement.class;
        for (PsiElement child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (klass.isInstance(child)) {
                var castedChild = klass.cast(child);
                String className = castedChild.getName();
                currentClassName += (currentClassName.length() > 0) ? "." + className : className;
                result.add(currentClassName);
            }

            getClassList(child, currentClassName, result);
        }
    }


}
