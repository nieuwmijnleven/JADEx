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

import jplus.analyzer.nullability.dataflow.NullState;
import jplus.editor.TextChangeRange;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SymbolInfoTest {

    @Test
    void from() {
        SymbolInfo original = new SymbolInfo("a", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "a", List.of());
        SymbolInfo copy = SymbolInfo.from(original);

        assertEquals(original.getSymbol(), copy.getSymbol());
        assertEquals(original.getTypeInfo(), copy.getTypeInfo());
        assertEquals(original.getOriginalText(), copy.getOriginalText());
    }

    @Test
    void toBuilder() {
        SymbolInfo original = new SymbolInfo("x", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "x", List.of());
        SymbolInfo modified = original.toBuilder().symbol("y").build();

        assertEquals("y", modified.getSymbol());
        assertEquals(original.getTypeInfo(), modified.getTypeInfo());
        assertEquals(original.getOriginalText(), modified.getOriginalText());
        assertEquals("x", original.getSymbol()); // 원본 유지
    }

    @Test
    void getSymbol() {
        SymbolInfo info = new SymbolInfo("symbolName", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "symbolName", List.of());
        assertEquals("symbolName", info.getSymbol());
    }

    @Test
    void getTypeInfo() {
        TypeInfo typeInfo = new TypeInfo("String", false, TypeInfo.Type.Class);
        SymbolInfo info = new SymbolInfo("s", typeInfo, null, "s", List.of());
        assertEquals(typeInfo, info.getTypeInfo());
    }

    @Test
    void getNullState() {
        SymbolInfo info = new SymbolInfo("n", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, null, List.of());
        assertEquals(NullState.UNKNOWN, info.getNullState());
    }

//    @Test
//    void getRange() {
//        TextChangeRange range = new TextChangeRange(1, 0, 1, 3);
//        SymbolInfo info = new SymbolInfo("r", new TypeInfo("int", false, TypeInfo.Type.Primitive), range, "r", List.of());
//        assertEquals(range, info.getRange());
//    }

    @Test
    void getOriginalText() {
        SymbolInfo info = new SymbolInfo("o", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "original", List.of());
        assertEquals("original", info.getOriginalText());
    }

    @Test
    void getModifierList() {
        SymbolInfo info = new SymbolInfo("m", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "m", List.of(Modifier.STATIC));
        List<Modifier> modifiers = info.getModifierList();
        assertTrue(modifiers.contains(Modifier.STATIC));
        assertThrows(UnsupportedOperationException.class, () -> modifiers.add(Modifier.FINAL));
    }

    @Test
    void isStatic() {
        SymbolInfo info = new SymbolInfo("s", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "s", List.of(Modifier.STATIC));
        assertTrue(info.isStatic());
    }

    @Test
    void isFinal() {
        SymbolInfo info = new SymbolInfo("f", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "f", List.of(Modifier.FINAL));
        assertTrue(info.isFinal());
    }

    @Test
    void getSymbolTable() {
        SymbolInfo info = new SymbolInfo("t", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "t", List.of());
        SymbolTable table = new SymbolTable(null);
        info.setSymbolTable(table);
        assertEquals(table, info.getSymbolTable());
    }

    @Test
    void setSymbolTable() {
        SymbolInfo info = new SymbolInfo("t", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "t", List.of());
        SymbolTable table = new SymbolTable(null);
        info.setSymbolTable(table);
        assertEquals(table, info.getSymbolTable());
    }

    @Test
    void getResolvingStatus() {
        SymbolInfo info = new SymbolInfo("rs", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "rs", List.of());
        assertEquals(SymbolInfo.ResolvingStatus.RESOLVED, info.getResolvingStatus());
    }

    @Test
    void setResolvingStatus() {
        SymbolInfo info = new SymbolInfo("rs", new TypeInfo("int", false, TypeInfo.Type.Primitive), null, "rs", List.of());
        info.setResolvingStatus(SymbolInfo.ResolvingStatus.UNRESOLVED);
        assertEquals(SymbolInfo.ResolvingStatus.UNRESOLVED, info.getResolvingStatus());
    }

    @Test
    void builder() {
        SymbolInfo info = SymbolInfo.builder()
                .symbol("b")
                .typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive))
                .build();
        assertEquals("b", info.getSymbol());
        assertEquals("int", info.getTypeInfo().getName());
    }
}