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

import com.sun.source.tree.MethodTree;
import com.sun.source.util.Trees;
import com.sun.source.util.TreePath;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;
import java.util.List;

public class MethodUtils {

    public static boolean isExplicitConstructor(MethodTree methodTree, Trees trees, TreePath path) {
        // 생성자 이름 검사
        if (!methodTree.getName().contentEquals("<init>")) {
            return false;
        }

        Element element = trees.getElement(path);
        if (!(element instanceof ExecutableElement ee)) {
            return false;
        }

        // 생성자인지 검사
        if (ee.getKind() != ElementKind.CONSTRUCTOR) {
            return false;
        }

        // ⭐ 핵심: 소스에 명시적으로 작성된 생성자인가?
        return !ee.isDefault();
    }

    public static List<String> getCandidates(String methodName, List<String> paramTypes) {
        List<String> candidates = new ArrayList<>();
        if (paramTypes.isEmpty()) {
            return List.of("^" + methodName + "$~");
        }

        generateCandidates(paramTypes, 0, "^"+ methodName + "$", candidates);
        return candidates;
    }

    private static void generateCandidates(List<String> paramTypes, int index, String generated, List<String> candidates) {
        if (paramTypes.size() == index) {
            candidates.add(generated);
            return;
        }

        String paramType = paramTypes.get(index);
        generateCandidates(paramTypes, index + 1, generated + "~" + paramType, candidates);
        generateCandidates(paramTypes, index + 1, generated + "~" + paramType + "?", candidates);
    }
}
