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

import jplus.base.MethodInvocationInfo;
import jplus.base.TypeInfo;
import jplus.generator.TextChangeRange;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public final class ResolvedChain {

    public enum Kind {
        IDENTIFIER,
        FIELD,
        METHOD,
        EXPRESSION,
        LAMBDA_EXPRESSION,
        CONDITIONAL_EXPRESSION,

        NEW,
        LITERAL,

        ARRAY_ACCESS,
        CHAIN
    }

    public static final class Step {
        //public final Element element;      // field / method / variable
        public final Kind kind;
        public final String symbol;
        public final TypeInfo typeInfo;     // 이 step의 결과 타입
        public final boolean nullable;      // 선언상 nullable
        public final boolean nullSafety;
        public final TextChangeRange range; // 소스 위치
        public final MethodInvocationInfo invocationInfo;
        public final ResolvedChain childChain;

        public Step(Kind kind,
                    String symbol,
                    TypeInfo typeInfo,
                    boolean nullable,
                    boolean nullSafety,
                    TextChangeRange range,
                    MethodInvocationInfo invocationInfo,
                    ResolvedChain childChain) {
            this.kind = kind;
            this.symbol = symbol;
            this.typeInfo = typeInfo;
            this.nullable = nullable;
            this.nullSafety = nullSafety;
            this.range = range;
            this.invocationInfo = invocationInfo;
            this.childChain = childChain;
        }

        @Override
        public String toString() {
            return "Step{" +
                    "kind=" + kind +
                    ", symbol=" + symbol +
                    ", typeInfo=" + typeInfo +
                    ", nullable=" + nullable +
                    ", nullSafety=" + nullSafety +
                    ", range=" + range +
                    ", invocationInfo=" + invocationInfo +
                    ", childChain=" + childChain +
                    '}';
        }

        public static class Builder {
            private Kind kind;
            private String symbol;
            private TypeInfo typeInfo;
            private boolean nullable;
            private boolean nullSafety;
            private TextChangeRange range;
            private MethodInvocationInfo invocationInfo;
            private ResolvedChain childChain;

            public Builder kind(Kind kind) {
                this.kind = kind;
                return this;
            }

            public Builder symbol(String symbol) {
                this.symbol = symbol;
                return this;
            }

            public Builder typeInfo(TypeInfo typeInfo) {
                this.typeInfo = typeInfo;
                return this;
            }

            public Builder nullable(boolean nullable) {
                this.nullable = nullable;
                return this;
            }

            public Builder nullSafety(boolean nullsafety) {
                this.nullSafety = nullSafety;
                return this;
            }

            public Builder range(TextChangeRange range) {
                this.range = range;
                return this;
            }

            public Builder invocationInfo(MethodInvocationInfo invocationInfo) {
                this.invocationInfo = invocationInfo;
                return this;
            }

            public Builder childChain(ResolvedChain childChain) {
                this.childChain = childChain;
                return this;
            }

            public Step build() {
                return new Step(kind, symbol, typeInfo, nullable, nullSafety, range, invocationInfo, childChain);
            }
        }

        public static  Builder builder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return new Builder()
                    .kind(this.kind)
                    .symbol(this.symbol)
                    .typeInfo(this.typeInfo)
                    .nullable(this.nullable)
                    .nullSafety(this.nullSafety)
                    .range(this.range)
                    .invocationInfo(this.invocationInfo)
                    .childChain(this.childChain);
        }
    }

    private final List<Step> steps = new ArrayList<>();

    public void addStep(Step step) {
        steps.add(step);
    }

    public List<Step> getSteps() {
        return List.copyOf(steps);
    }

    public boolean isEmpty() {
        return steps.isEmpty();
    }

    public boolean hasQualifier() {
        return steps.size() >= 2;
    }

    public Step qualifierLast() {
        return hasQualifier() ? steps.get(steps.size() - 2) : null;
    }

    public Step first() {
        return !steps.isEmpty() ? steps.get(0) : null;
    }

    public Step last() {
        return !steps.isEmpty() ? steps.get(steps.size() - 1) : null;
    }

    public void updateLastStep(UnaryOperator<Step> updater) {
        if (steps.isEmpty()) {
            throw new IllegalStateException("No step to update");
        }

        int last = steps.size() - 1;
        steps.set(last, updater.apply(steps.get(last)));
    }

    public ResolvedChain extractReceiverChain() {
        if (steps.isEmpty()) return null;

        Step last = last();

        // method 호출이 아닌 경우 receiver 개념 없음
        if (last.kind != ResolvedChain.Kind.METHOD) {
            return null;
        }

        // qualifier가 없으면 receiver 없음 (static call or implicit this)
        if (steps.size() < 2) {
            return null;
        }

        ResolvedChain receiver = new ResolvedChain();
        for (int i = 0; i < steps.size() - 1; i++) {
            receiver.addStep(steps.get(i));
        }

        return receiver;
    }

    public Step extractReceiverLastStep() {
        ResolvedChain receiver = extractReceiverChain();
        return receiver != null ? receiver.last() : null;
    }

    public StepCursor stepCursor() {
        return new StepCursor(steps);
    }

    public StepCursor qualifierCursor() {
        if (steps.size() < 2) {
            return StepCursor.empty();
        }
        return new StepCursor(steps.subList(0, steps.size() - 1));
    }

    @Override
    public String toString() {
        return "ResolvedChain{" +
                "steps=" + steps +
                '}';
    }
}
