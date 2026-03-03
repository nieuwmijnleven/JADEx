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

import jplus.analyzer.ResolvedChain;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SymbolTableTest {

    @Test
    void copy() {
        SymbolTable parent = new SymbolTable(null);
        SymbolTable table = new SymbolTable(parent);
        SymbolInfo info = SymbolInfo.builder().symbol("x").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("x", info);

        SymbolTable copy = table.copy();
        assertNotSame(table, copy);
        assertEquals("x", copy.resolve("x").getSymbol());
    }

    @Test
    void declare() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("y").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("y", info);
        assertEquals(info, table.resolve("y"));
    }

    @Test
    void setSuperClassTable() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable superTable = new SymbolTable(null);
        table.setSuperClassTable(superTable);
        assertSame(superTable, table.getSuperClassTable());
        assertTrue(table.hasSuperClassTable());
    }

    @Test
    void addSuperInterfaceTable() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable iface = new SymbolTable(null);
        table.addSuperInterfaceTable(iface);
        assertEquals(1, table.getSuperInterfaceTables().size());
        assertTrue(table.getSuperInterfaceTables().contains(iface));
    }

    @Test
    void resolve() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("a").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("a", info);
        assertEquals(info, table.resolve("a"));
        assertNull(table.resolve("b"));
    }

    @Test
    void contains() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("v").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("v", info);
        assertTrue(table.contains("v", TypeInfo.Type.Primitive));
        assertFalse(table.contains("v", TypeInfo.Type.Method));
    }

    @Test
    void containsInCurrent() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("v").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("v", info);
        assertTrue(table.containsInCurrent("v", TypeInfo.Type.Primitive));
        assertFalse(table.containsInCurrent("v", TypeInfo.Type.Method));
    }

    @Test
    void isEmpty() {
        SymbolTable table = new SymbolTable(null);
        assertTrue(table.isEmpty());
        SymbolInfo info = SymbolInfo.builder().symbol("v").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("v", info);
        assertFalse(table.isEmpty());
    }

    @Test
    void isDeadContextAndSetDeadContext() {
        SymbolTable table = new SymbolTable(null);
        assertFalse(table.isDeadContext());
        table.setDeadContext(true);
        assertTrue(table.isDeadContext());
    }

    @Test
    void mergeDeadContext() {
        SymbolTable table = new SymbolTable(null);
        table.setDeadContext(false);
        table.mergeDeadContext(true);
        assertTrue(table.isDeadContext());
    }

    @Test
    void getParent() {
        SymbolTable parent = new SymbolTable(null);
        SymbolTable table = new SymbolTable(parent);
        assertSame(parent, table.getParent());
    }

    @Test
    void addEnclosingSymbolTable() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable child = new SymbolTable(null);
        assertSame(child, table.addEnclosingSymbolTable("child", child));
    }

    @Test
    void getEnclosingSymbolTable() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable child = table.getEnclosingSymbolTable(SymbolTable.STATIC_NS);
        assertNotNull(child);
        assertEquals(SymbolTable.ExecutionContext.STATIC, child.getContext());
    }

    @Test
    void addResolvedChainAndGetResolvedChains() {
        SymbolTable table = new SymbolTable(null);
        ResolvedChain chain = new ResolvedChain();
        table.addResolvedChain(chain);
        List<ResolvedChain> chains = table.getResolvedChains();
        assertEquals(1, chains.size());
        assertSame(chain, chains.getFirst());
    }

    @Test
    void findSymbolsByType() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info1 = SymbolInfo.builder().symbol("a").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        SymbolInfo info2 = SymbolInfo.builder().symbol("b").typeInfo(new TypeInfo("MyClass", false, TypeInfo.Type.Class)).build();
        table.declare("a", info1);
        table.declare("b", info2);

        List<String> vars = table.findSymbolsByType(List.of(TypeInfo.Type.Primitive));
        assertEquals(1, vars.size());
        assertEquals("a", vars.getFirst());
    }

    @Test
    void findSymbolInfoByType() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info1 = SymbolInfo.builder().symbol("a").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        SymbolInfo info2 = SymbolInfo.builder().symbol("b").typeInfo(new TypeInfo("MyClass", false, TypeInfo.Type.Class)).build();
        table.declare("a", info1);
        table.declare("b", info2);

        List<SymbolInfo> result = table.findSymbolInfoByType(List.of(TypeInfo.Type.Primitive));
        assertEquals(1, result.size());
        assertEquals("a", result.getFirst().getSymbol());
    }

    @Test
    void promoteLocalSymbolsAndTransplantLocalSymbols() {
        SymbolTable parent = new SymbolTable(null);
        SymbolTable table = new SymbolTable(parent);
        SymbolInfo info = SymbolInfo.builder().symbol("x").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("x", info);

        SymbolTable promoted = table.promoteLocalSymbols();
        assertEquals("x", promoted.resolve("x").getSymbol());

        SymbolTable target = new SymbolTable(null);
        SymbolTable transplanted = table.transplantLocalSymbols(target);
        assertEquals("x", transplanted.resolve("x").getSymbol());
    }

    @Test
    void testToString() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("x").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("x", info);
        String str = table.toString();
        assertTrue(str.contains("x"));
    }

    // 나머지 메서드들은 resolve 관련 기능이나 iterator/keyIterator 정도만 단순 검증
    @Test
    void iteratorAndKeyIterator() {
        SymbolTable table = new SymbolTable(null);
        SymbolInfo info = SymbolInfo.builder().symbol("x").typeInfo(new TypeInfo("int", false, TypeInfo.Type.Primitive)).build();
        table.declare("x", info);

        assertTrue(table.iterator().hasNext());
        assertTrue(table.keyIterator().hasNext());
    }

    @Test
    void getEnclosingSymbolTables() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable child = new SymbolTable(null);
        table.addEnclosingSymbolTable("child", child);
        assertEquals(1, table.getEnclosingSymbolTables().size());
    }

    @Test
    void findLowContextSymbolTable() {
        SymbolTable table = new SymbolTable(null);
        SymbolTable child = new SymbolTable(null);
        table.addEnclosingSymbolTable("child", child);
        assertNotNull(table.findLowContextSymbolTable("unknown"));
    }
}