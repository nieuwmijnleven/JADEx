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

package jplus.analyzer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StepCursorTest {

    // 편리하게 기본 Step 생성
    private ResolvedChain.Step normalStep() {
        return new ResolvedChain.Step(
                ResolvedChain.Kind.FIELD, // CHAIN이 아닌 kind
                "symbol",
                null,      // typeInfo
                false,     // nullable
                false,     // nullSafety
                null,      // range
                null,      // invocationInfo
                null       // childChain
        );
    }

    private ResolvedChain.Step chainStep(ResolvedChain child) {
        return new ResolvedChain.Step(
                ResolvedChain.Kind.CHAIN,
                "chain",
                null,
                false,
                false,
                null,
                null,
                child
        );
    }

    @Test
    void emptyCursor() {
        StepCursor cursor = StepCursor.empty();

        assertFalse(cursor.hasNext());
        assertTrue(cursor.peek().isEmpty());
        assertTrue(cursor.peekPrev().isEmpty());
        assertThrows(IllegalStateException.class, cursor::consume);
    }

    @Test
    void linearHasNextAndConsume() {
        ResolvedChain.Step a = normalStep();
        ResolvedChain.Step b = normalStep();
        StepCursor cursor = new StepCursor(List.of(a, b));

        assertTrue(cursor.hasNext());
        assertSame(a, cursor.consume());
        assertTrue(cursor.hasNext());
        assertSame(b, cursor.consume());
        assertFalse(cursor.hasNext());
    }

    @Test
    void peekDoesNotAdvance() {
        ResolvedChain.Step a = normalStep();
        ResolvedChain.Step b = normalStep();
        StepCursor cursor = new StepCursor(List.of(a, b));

        assertSame(a, cursor.peek().orElseThrow());
        assertSame(a, cursor.peek().orElseThrow()); // 반복 peek에서도 동일
        assertSame(a, cursor.consume());
        assertSame(b, cursor.peek().orElseThrow());
    }

    @Test
    void peekPrevTracksLastConsumed() {
        ResolvedChain.Step a = normalStep();
        ResolvedChain.Step b = normalStep();
        StepCursor cursor = new StepCursor(List.of(a, b));

        assertTrue(cursor.peekPrev().isEmpty());

        cursor.consume();
        assertSame(a, cursor.peekPrev().orElseThrow());

        cursor.consume();
        assertSame(b, cursor.peekPrev().orElseThrow());
    }

    @Test
    void consumeFlattensSingleLevelChain() {
        ResolvedChain.Step x = normalStep();
        ResolvedChain.Step y = normalStep();
        ResolvedChain inner = new ResolvedChain();
        inner.addStep(x);
        inner.addStep(y);

        StepCursor cursor = new StepCursor(List.of(
                normalStep(),
                chainStep(inner)
        ));

        assertEquals(1, countSteps(cursor)); // normal + x + y
    }

    @Test
    void positionLinear() {
        StepCursor cursor = new StepCursor(List.of(
                normalStep(),
                normalStep(),
                normalStep()
        ));

        assertEquals(0, cursor.position());

        cursor.consume();
        assertEquals(1, cursor.position());

        cursor.consume();
        assertEquals(2, cursor.position());
    }

    // helper
    private int countSteps(StepCursor cursor) {
        int count = 0;
        while (cursor.hasNext()) {
            cursor.consume();
            count++;
        }
        return count;
    }
}