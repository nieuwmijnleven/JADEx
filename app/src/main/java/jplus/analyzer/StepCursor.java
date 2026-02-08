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

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class StepCursor {

    private static final StepCursor EMPTY = new StepCursor(Collections.emptyList());

    private final Deque<CursorState> stack = new ArrayDeque<>();
    private ResolvedChain.Step lastConsumed = null;

    private static final class CursorState {
        final List<ResolvedChain.Step> steps;
        int index = 0;

        CursorState(List<ResolvedChain.Step> steps) {
            this.steps = steps;
        }

        boolean hasNext() {
            return index < steps.size();
        }

        ResolvedChain.Step peek() {
            return steps.get(index);
        }

        ResolvedChain.Step next() {
            return steps.get(index++);
        }
    }

    public StepCursor(List<ResolvedChain.Step> steps) {
        Objects.requireNonNull(steps);
        stack.push(new CursorState(steps));
    }

    public static StepCursor empty() {
        return EMPTY;
    }

    public boolean hasNext() {
        skipChainSteps();
        return !stack.isEmpty();
    }

    public Optional<ResolvedChain.Step> peek() {
        skipChainSteps();
        if (stack.isEmpty()) return Optional.empty();
        return Optional.of(stack.peek().peek());
    }

    public Optional<ResolvedChain.Step> peekPrev() {
        return Optional.ofNullable(lastConsumed);
    }

    public ResolvedChain.Step consume() {
        skipChainSteps();
        if (stack.isEmpty()) throw new IllegalStateException("No more steps");

        CursorState current = stack.peek();
        ResolvedChain.Step step = current.next();

        if (step.kind == ResolvedChain.Kind.CHAIN) {
            if (step.childChain != null && !step.childChain.getSteps().isEmpty()) {
                stack.push(new CursorState(step.childChain.getSteps()));
            }
            return consume();
        }

        lastConsumed = step;

        if (step.childChain != null && !step.childChain.getSteps().isEmpty()) {
            stack.push(new CursorState(step.childChain.getSteps()));
        }

        return step;
    }

    public int position() {
        int pos = 0;
        for (CursorState s : stack) pos += s.index;
        return pos;
    }

    private void skipChainSteps() {
        while (!stack.isEmpty()) {
            CursorState current = stack.peek();
            while (current.hasNext() && current.peek().kind == ResolvedChain.Kind.CHAIN) {
                ResolvedChain.Step chainStep = current.next();
                if (chainStep.childChain != null && !chainStep.childChain.getSteps().isEmpty()) {
                    stack.push(new CursorState(chainStep.childChain.getSteps()));
                }
            }
            if (!current.hasNext()) stack.pop();
            else break;
        }
    }
}
