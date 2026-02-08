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

import jplus.base.JPlus25Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public interface PNNAContextAdapter {

    ParserRuleContext originalContext();
    JPlus25Parser.ExpressionContext expression();
    ParserRuleContext identifier();
    JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression();
    JPlus25Parser.ArgumentListContext argumentList();
    JPlus25Parser.PNNAContext pNNA();
    TerminalNode LPAREN();
    TerminalNode NULLSAFE();
    Token getStart();

    static PNNAContextAdapter from(JPlus25Parser.PNNAContext ctx) {
        if (ctx instanceof JPlus25Parser.PNNAClassInstanceCreationContext instanceCreationContext) {
            return from(instanceCreationContext);
        } else if (ctx instanceof JPlus25Parser.PNNAFieldAccessContext fieldAccessContext) {
            return from(fieldAccessContext);
        } else if (ctx instanceof JPlus25Parser.PNNAArrayAccessContext arrayAccessContext) {
            return from(arrayAccessContext);
        } else if (ctx instanceof JPlus25Parser.PNNAMethodInvocationContext methodInvocationContext) {
            return from(methodInvocationContext);
        } else if (ctx instanceof JPlus25Parser.PNNAMethodReferenceContext methodReferenceContext) {
            return from(methodReferenceContext);
        }

        return null;
    }

    static PNNAContextAdapter from(JPlus25Parser.PNNAClassInstanceCreationContext ctx) {
        return new PNNAContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionContext expression() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return ctx.unqualifiedClassInstanceCreationExpression(); }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return null;
            }

            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static PNNAContextAdapter from(JPlus25Parser.PNNAFieldAccessContext ctx) {
        return new PNNAContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionContext expression() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.ArgumentListContext argumentList() {
                return null;
            }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static PNNAContextAdapter from(JPlus25Parser.PNNAArrayAccessContext ctx) {
        return new PNNAContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionContext expression() { return ctx.expression(); }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return null;
            }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PNNAContextAdapter from(JPlus25Parser.PNNAMethodInvocationContext ctx) {
        return new PNNAContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionContext expression() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static PNNAContextAdapter from(JPlus25Parser.PNNAMethodReferenceContext ctx) {
        return new PNNAContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionContext expression() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.ArgumentListContext argumentList() {
                return null;
            }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }
}
