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

package jplus.analyzer.util;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor14;
import java.util.List;
import java.util.stream.Collectors;

public class CleanTypePrinter extends SimpleTypeVisitor14<String, Void> {

    @Override
    protected String defaultAction(TypeMirror t, Void v) {
        // 기본적으로 annotation 은 toString 에 섞여 있으므로
        // 문자열에서 annotation 을 제거해야 한다.
        return removeAnnotations(t.toString());
    }

    @Override
    public String visitDeclared(DeclaredType t, Void v) {
        StringBuilder sb = new StringBuilder();

        // 선언 타입 이름
        sb.append(t.asElement().toString());

        List<? extends TypeMirror> args = t.getTypeArguments();
        if (!args.isEmpty()) {
            sb.append("<");
            sb.append(
                args.stream()
                    .map(this::print)
                    .collect(Collectors.joining(","))
            );
            sb.append(">");
        }

        return sb.toString();
    }

    @Override
    public String visitArray(ArrayType t, Void v) {
        return print(t.getComponentType()) + "[]";
    }

    @Override
    public String visitTypeVariable(TypeVariable t, Void v) {
        return t.toString(); // T
    }

    @Override
    public String visitWildcard(WildcardType t, Void v) {
        StringBuilder sb = new StringBuilder("?");

        TypeMirror ext = t.getExtendsBound();
        TypeMirror sup = t.getSuperBound();

        if (ext != null) {
            sb.append(" extends ").append(print(ext));
        } else if (sup != null) {
            sb.append(" super ").append(print(sup));
        }

        return sb.toString();
    }

    @Override
    public String visitIntersection(IntersectionType t, Void v) {
        return t.getBounds().stream()
                .map(this::print)
                .collect(Collectors.joining(" & "));
    }

    public String print(TypeMirror t) {
        return t.accept(this, null);
    }

    /** 
     * 문자열에 섞인 annotation 을 제거하는 정규식 (중첩 가능)
     * "@xxx(...)" 전체를 지운다.
     */
    private static String removeAnnotations(String raw) {
        // 패키지 단위 annotation, 중첩 annotation 포함 제거
        return raw.replaceAll("@\\p{L}[\\p{L}0-9_.$]*(\\([^()]*\\))?\\s*", "");
    }
}
