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

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodInvocationInfoTest {

    @Test
    void isStatic() {
        MethodInvocationInfo staticInfo = MethodInvocationInfo.builder()
                .receiver("MyClass")
                .methodName("doWork")
                .modifierList(List.of(Modifier.STATIC))
                .build();

        MethodInvocationInfo nonStaticInfo = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("doWork")
                .modifierList(List.of(Modifier.PUBLIC))
                .build();

        assertTrue(staticInfo.isStatic());
        assertFalse(nonStaticInfo.isStatic());
    }

    @Test
    void builder() {
        MethodInvocationInfo info = MethodInvocationInfo.builder()
                .receiver("obj")
                .typeInfo(null)
                .methodName("sum")
                .args(List.of("1", "2"))
                .argTypes(List.of("int", "int"))
                .paramTypes(List.of("int", "int"))
                .returnType("int")
                .hasVarArgs(false)
                .modifierList(List.of(Modifier.PUBLIC))
                .source("obj.sum(1,2)")
                .startPos(5)
                .endPos(15)
                .build();

        assertEquals("obj", info.receiver);
        assertEquals("sum", info.methodName);
        assertEquals(List.of("1", "2"), info.args);
        assertEquals(List.of("int", "int"), info.argTypes);
        assertEquals(List.of("int", "int"), info.paramTypes);
        assertEquals("int", info.returnType);
        assertFalse(info.hasVarArgs);
        assertEquals(5, info.startPos);
        assertEquals(15, info.endPos);
    }

    @Test
    void getInvocationInfoMessage() {
        // 일반 메서드 호출
        MethodInvocationInfo normal = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("run")
                .modifierList(List.of())
                .build();

        assertEquals("obj.run()", normal.getInvocationInfoMessage());

        // 생성자 케이스 (receiver == methodName)
        MethodInvocationInfo constructor = MethodInvocationInfo.builder()
                .receiver("MyClass")
                .methodName("MyClass")
                .modifierList(List.of())
                .build();

        assertEquals("MyClass constructor", constructor.getInvocationInfoMessage());
    }

    @Test
    void testToString() {
        MethodInvocationInfo info = MethodInvocationInfo.builder()
                .receiver("obj")
                .methodName("test")
                .modifierList(List.of())
                .build();

        String result = info.toString();

        assertTrue(result.contains("MethodInvocationInfo"));
        assertTrue(result.contains("obj"));
        assertTrue(result.contains("test"));
    }
}