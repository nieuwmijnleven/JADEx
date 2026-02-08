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

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.VariableTree;
import jplus.generator.TextChangeRange;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.lang.reflect.AnnotatedType;

public class CodeUtils {
    private CodeUtils() {}

    public static String replaceNullsafeOperator(ParserRuleContext ctx) {
        String tokenString = Utils.getTokenString(ctx).replace("?.", ".");
        String variableName = tokenString.split("\\.")[0];

        String replaced = "(" +
                "((" + variableName + ")!=null)?" +
                "(" + tokenString + "):" +
                "null" +
                ")";

        return replaced;
    }

    public static String getSimpleReturnTypeName(TypeMirror type) {
        if (type == null) return "unknown";

        switch (type.getKind()) {
            case VOID:
                return "void";

            case BOOLEAN: case BYTE: case SHORT: case INT:
            case LONG: case CHAR: case FLOAT: case DOUBLE:
                return type.toString(); // primitive simple name 그대로

            case ARRAY:
                ArrayType at = (ArrayType) type;
                return getSimpleReturnTypeName(at.getComponentType()) + "[]";

            case DECLARED:
                DeclaredType dt = (DeclaredType) type;
                Element e = dt.asElement();
                if (e instanceof TypeElement te) {
                    return te.getSimpleName().toString(); // ★ 핵심
                }
                return type.toString();

            default:
                return type.toString(); // TYPEVAR, WILDCARD 등
        }
    }

    public static String getSimpleName(String fqn) {
        if (fqn == null || fqn.isEmpty()) return fqn;
        int lastDot = fqn.lastIndexOf('.');
        return lastDot >= 0 ? fqn.substring(lastDot + 1) : fqn;
    }

    public static boolean canHaveDefaultConstructor(ClassTree classTree) {
        boolean hasExplicitConstructor = classTree.getMembers().stream()
                .anyMatch(m -> m instanceof MethodTree mt && mt.getName().contentEquals("<init>"));
        if (hasExplicitConstructor) return false;

        boolean hasUninitializedFinal = classTree.getMembers().stream()
                .filter(m -> m instanceof VariableTree)
                .map(m -> (VariableTree)m)
                .anyMatch(vt -> vt.getModifiers().getFlags().contains(Modifier.FINAL) && vt.getInitializer() == null);
        if (hasUninitializedFinal) return false;

        return true;
    }
}
