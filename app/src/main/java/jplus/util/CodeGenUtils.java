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

package jplus.util;

import jplus.base.Modifier;
import jplus.base.SymbolInfo;
import jplus.base.TypeInfo;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;

import java.util.EnumSet;
import java.util.stream.Collectors;

public final class CodeGenUtils {

    private CodeGenUtils() {}

    public static String getSimpleTypeName(TypeInfo typeInfo) {
        String base = CodeUtils.getSimpleName(typeInfo.getName());
        if (!typeInfo.isGeneric()) {
            return base;
        }

        String typeArgumentString = getGenericTypeArgumentString(typeInfo);
        return base + typeArgumentString;
    }

    public static String getGenericTypeArgumentString(TypeInfo typeInfo) {
        if (!typeInfo.isGeneric()) return "";

        if (typeInfo.getType() == TypeInfo.Type.Class) {
            return typeInfo.getTypeParameters().stream().collect(Collectors.joining(",", "<", ">"));
        }
        return typeInfo.getTypeArguments().stream().map(TypeInfo::getName).collect(Collectors.joining(",", "<", ">"));
    }

    public static String getSimpleTypeNameWithGenericWildcard(TypeInfo typeInfo) {
        String base = CodeUtils.getSimpleName(typeInfo.getName());
        if (!typeInfo.isGeneric()) {
            return base;
        }
        return base + "<?>";
    }

    public static int mapOffsetFromTransformedToOriginal(
            String originalText,
            String transformedText,
            int offsetInTransformed) {

        DiffMatchPatch dmp = new DiffMatchPatch();
        return dmp.diffXIndex(dmp.diffMain(transformedText, originalText), offsetInTransformed);
    }

    public static boolean hasAnyModifiers(SymbolInfo symbolInfo, EnumSet<Modifier> modifiers) {
        return symbolInfo.getModifierList().stream().anyMatch(modifiers::contains);
    }
}
