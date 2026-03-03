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

package jplus.base;

import jplus.editor.TextChangeRange;
import jplus.util.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaMethodInvocationManagerTest {

    @Test
    void addInvocationInfo() {
        String source = "obj.run();";
        JavaMethodInvocationManager manager =
                new JavaMethodInvocationManager(source);

        SymbolTable symbolTable = new SymbolTable(null);

        MethodInvocationInfo info = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("run")
                .modifierList(List.of())
                .source("obj.run()")
                .startPos(0)
                .endPos(9)
                .build();

        manager.addInvocationInfo(symbolTable, info);

        MethodInvocationInfo result =
                manager.getInvocationInfo(symbolTable, "obj.run()");

        assertNotNull(result);
        assertEquals("run", result.methodName);
    }

    @Test
    void getInvocationInfo() {
        String source = "obj.run();";
        JavaMethodInvocationManager manager =
                new JavaMethodInvocationManager(source);

        SymbolTable symbolTable = new SymbolTable(null);

        MethodInvocationInfo info = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("run")
                .modifierList(List.of())
                .source("obj.run()")
                .startPos(0)
                .endPos(9)
                .build();

        manager.addInvocationInfo(symbolTable, info);

        MethodInvocationInfo result =
                manager.getInvocationInfo(symbolTable, "obj.run()");

        assertEquals(info, result);

        // 존재하지 않는 symbolTable 조회 시 예외 발생
        SymbolTable otherTable = new SymbolTable(null);
        assertThrows(Exception.class,
                () -> manager.getInvocationInfo(otherTable, "obj.run()"));
    }

    @Test
    void findInvocationInfo() {
        String source = "obj.run();";
        JavaMethodInvocationManager manager =
                new JavaMethodInvocationManager(source);

        SymbolTable symbolTable = new SymbolTable(null);

        MethodInvocationInfo info = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("run")
                .modifierList(List.of())
                .source("obj.run()")
                .startPos(0)
                .endPos(9)
                .build();

        manager.addInvocationInfo(symbolTable, info);

        TextChangeRange correctRange =
                Utils.computeTextChangeRange(source, 0, 8);

        Optional<MethodInvocationInfo> found =
                manager.findInvocationInfo(symbolTable, correctRange);

        assertTrue(found.isPresent());
        assertEquals("run", found.get().methodName);

        // 다른 범위는 empty
        TextChangeRange wrongRange =
                Utils.computeTextChangeRange(source, 2, 5);

        Optional<MethodInvocationInfo> notFound =
                manager.findInvocationInfo(symbolTable, wrongRange);

        assertTrue(notFound.isEmpty());
    }
}