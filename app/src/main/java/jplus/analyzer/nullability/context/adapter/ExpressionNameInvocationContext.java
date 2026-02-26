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

package jplus.analyzer.nullability.context.adapter;

import jplus.base.JADEx25Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public interface ExpressionNameInvocationContext {

    ParserRuleContext originalContext();
    JADEx25Parser.ExpressionNameContext expressionName();
    ParserRuleContext identifier();
    JADEx25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression();
    JADEx25Parser.PNNAContext pNNA();
    TerminalNode LPAREN();
    TerminalNode NULLSAFE();
    Token getStart();

    static ExpressionNameInvocationContext from(JADEx25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx) {
        return new ExpressionNameInvocationContext() {
            public ParserRuleContext originalContext() { return ctx; }
            public JADEx25Parser.ExpressionNameContext expressionName() { return ctx.expressionName(); }
            public ParserRuleContext identifier() { return null; }
            public JADEx25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return ctx.unqualifiedClassInstanceCreationExpression(); }
            public JADEx25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static ExpressionNameInvocationContext from(JADEx25Parser.MethodInvocationContext ctx) {
        return new ExpressionNameInvocationContext() {
            public ParserRuleContext originalContext() { return ctx; }
            public JADEx25Parser.ExpressionNameContext expressionName() { return ctx.expressionName(); }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JADEx25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JADEx25Parser.PNNAContext pNNA() { return null; }
            public TerminalNode LPAREN() { return ctx.LPAREN(); }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }
}
