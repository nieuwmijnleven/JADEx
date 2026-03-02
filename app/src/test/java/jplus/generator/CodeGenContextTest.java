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

package jplus.generator;

import jplus.editor.FragmentedText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CodeGenContextTest {

    @AfterEach
    void cleanup() {
        // 테스트 후 ThreadLocal 스택 초기화
        while (CodeGenContext.current() != null) {
            CodeGenContext.pop();
        }
    }

    @Test
    void current() {
        assertNull(CodeGenContext.current());
        CodeGenContext.push();
        assertNotNull(CodeGenContext.current());
    }

    @Test
    void push() {
        CodeGenContext.push();
        CodeGenContext ctx1 = CodeGenContext.current();
        assertNotNull(ctx1);

        CodeGenContext.push();
        CodeGenContext ctx2 = CodeGenContext.current();
        assertNotNull(ctx2);
        assertNotSame(ctx1, ctx2);
    }

    @Test
    void pop() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();
        assertNotNull(ctx);

        CodeGenContext.pop();
        assertNull(CodeGenContext.current());
    }

    @Test
    void getFragmentedText() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        FragmentedText ft = new FragmentedText("Hello");
        ctx.setFragmentedText(ft);

        assertEquals(ft, ctx.getFragmentedText());
    }

    @Test
    void setFragmentedText() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        FragmentedText ft = new FragmentedText("World");
        ctx.setFragmentedText(ft);

        assertSame(ft, ctx.getFragmentedText());
    }

    @Test
    void isSemanticMode() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        assertFalse(ctx.isSemanticMode());
        ctx.setSemanticMode(true);
        assertTrue(ctx.isSemanticMode());
    }

    @Test
    void setSemanticMode() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        ctx.setSemanticMode(true);
        assertTrue(ctx.isSemanticMode());

        ctx.setSemanticMode(false);
        assertFalse(ctx.isSemanticMode());
    }

    @Test
    void isImmutableMode() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        assertFalse(ctx.isImmutableMode());
        ctx.setImmutableMode(true);
        assertTrue(ctx.isImmutableMode());
    }

    @Test
    void setImmutableMode() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        ctx.setImmutableMode(true);
        assertTrue(ctx.isImmutableMode());

        ctx.setImmutableMode(false);
        assertFalse(ctx.isImmutableMode());
    }

    @Test
    void addSourceMappingEntry() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        SourceMappingEntry entry = new SourceMappingEntry("src", null, null);
        ctx.addSourceMappingEntry(entry);

        assertTrue(ctx.getSourceMapping().contains(entry));
        assertEquals(1, ctx.getSourceMapping().size());
    }

    @Test
    void addSourceMappingEntrySet() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        Set<SourceMappingEntry> set = new HashSet<>();
        SourceMappingEntry entry1 = new SourceMappingEntry("a", null, null);
        SourceMappingEntry entry2 = new SourceMappingEntry("b", null, null);
        set.add(entry1);
        set.add(entry2);

        ctx.addSourceMappingEntrySet(set);
        assertEquals(2, ctx.getSourceMapping().size());
        assertTrue(ctx.getSourceMapping().contains(entry1));
        assertTrue(ctx.getSourceMapping().contains(entry2));
    }

    @Test
    void getSourceMapping() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        assertTrue(ctx.getSourceMapping().isEmpty());

        SourceMappingEntry entry = new SourceMappingEntry("src", null, null);
        ctx.addSourceMappingEntry(entry);

        assertFalse(ctx.getSourceMapping().isEmpty());
        assertEquals(1, ctx.getSourceMapping().size());
    }

    @Test
    void reset() {
        CodeGenContext.push();
        CodeGenContext ctx = CodeGenContext.current();

        SourceMappingEntry entry = new SourceMappingEntry("src", null, null);
        ctx.addSourceMappingEntry(entry);

        assertFalse(ctx.getSourceMapping().isEmpty());

        ctx.reset();
        assertTrue(ctx.getSourceMapping().isEmpty());
    }
}