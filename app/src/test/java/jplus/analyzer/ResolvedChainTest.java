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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResolvedChainTest {

    @Test
    void addStep() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step = ResolvedChain.Step.builder()
                .kind(ResolvedChain.Kind.IDENTIFIER)
                .symbol("x")
                .build();

        chain.addStep(step);
        assertEquals(1, chain.getSteps().size());
        assertEquals(step, chain.getSteps().get(0));
    }

    @Test
    void getSteps() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step1 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("a").build();
        ResolvedChain.Step step2 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("b").build();

        chain.addStep(step1);
        chain.addStep(step2);

        List<ResolvedChain.Step> steps = chain.getSteps();
        assertEquals(2, steps.size());
        assertEquals(step1, steps.get(0));
        assertEquals(step2, steps.get(1));
    }

    @Test
    void isEmpty() {
        ResolvedChain chain = new ResolvedChain();
        assertTrue(chain.isEmpty());

        chain.addStep(ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("x").build());
        assertFalse(chain.isEmpty());
    }

    @Test
    void hasQualifier() {
        ResolvedChain chain = new ResolvedChain();
        chain.addStep(ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("x").build());
        assertFalse(chain.hasQualifier());

        chain.addStep(ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("foo").build());
        assertTrue(chain.hasQualifier());
    }

    @Test
    void qualifierLast() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step1 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("x").build();
        ResolvedChain.Step step2 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("foo").build();
        chain.addStep(step1);
        chain.addStep(step2);

        assertEquals(step1, chain.qualifierLast());
    }

    @Test
    void first() {
        ResolvedChain chain = new ResolvedChain();
        assertNull(chain.first());

        ResolvedChain.Step step = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("a").build();
        chain.addStep(step);
        assertEquals(step, chain.first());
    }

    @Test
    void last() {
        ResolvedChain chain = new ResolvedChain();
        assertNull(chain.last());

        ResolvedChain.Step step = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("a").build();
        chain.addStep(step);
        assertEquals(step, chain.last());
    }

    @Test
    void updateLastStep() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("old").build();
        chain.addStep(step);

        chain.updateLastStep(s -> s.toBuilder().symbol("new").build());
        assertEquals("new", chain.last().symbol);

        // Exception test
        ResolvedChain emptyChain = new ResolvedChain();
        assertThrows(IllegalStateException.class, () -> emptyChain.updateLastStep(s -> s));
    }

    @Test
    void extractReceiverChain() {
        ResolvedChain chain = new ResolvedChain();
        // method 없는 경우
        assertNull(chain.extractReceiverChain());

        ResolvedChain.Step step1 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("obj").build();
        ResolvedChain.Step step2 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("doSomething").build();
        chain.addStep(step1);
        chain.addStep(step2);

        ResolvedChain receiver = chain.extractReceiverChain();
        assertNotNull(receiver);
        assertEquals(1, receiver.getSteps().size());
        assertEquals(step1, receiver.last());
    }

    @Test
    void extractReceiverLastStep() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step1 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("obj").build();
        ResolvedChain.Step step2 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("doSomething").build();
        chain.addStep(step1);
        chain.addStep(step2);

        ResolvedChain.Step lastReceiverStep = chain.extractReceiverLastStep();
        assertEquals(step1, lastReceiverStep);

        ResolvedChain emptyChain = new ResolvedChain();
        assertNull(emptyChain.extractReceiverLastStep());
    }

    @Test
    void stepCursor() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("x").build();
        chain.addStep(step);

        var cursor = chain.stepCursor();
        assertNotNull(cursor);
        assertEquals(true, cursor.hasNext());
        assertNotNull(cursor.consume());
        assertEquals(false, cursor.hasNext());
    }

    @Test
    void qualifierCursor() {
        ResolvedChain chain = new ResolvedChain();
        assertNotNull(chain.qualifierCursor()); // empty cursor

        ResolvedChain.Step step1 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("a").build();
        ResolvedChain.Step step2 = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.METHOD).symbol("b").build();
        chain.addStep(step1);
        chain.addStep(step2);

        var cursor = chain.qualifierCursor();
        assertNotNull(cursor);
        assertEquals(true, cursor.hasNext());
        assertNotNull(cursor.consume());
        assertEquals(false, cursor.hasNext());
    }

    @Test
    void testToString() {
        ResolvedChain chain = new ResolvedChain();
        ResolvedChain.Step step = ResolvedChain.Step.builder().kind(ResolvedChain.Kind.IDENTIFIER).symbol("x").build();
        chain.addStep(step);

        String str = chain.toString();
        assertTrue(str.contains("steps"));
        assertTrue(str.contains("x"));
    }
}