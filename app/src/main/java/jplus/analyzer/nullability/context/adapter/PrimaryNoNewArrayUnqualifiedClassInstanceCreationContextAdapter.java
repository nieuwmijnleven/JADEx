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

public interface PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter {

    ParserRuleContext originalContext();
    JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression();
    JPlus25Parser.ArgumentListContext argumentList();
    TerminalNode NULLSAFE();
    JPlus25Parser.PNNAContext pNNA();
    Token getStart();

    static PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter from(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() {
                return ctx.unqualifiedClassInstanceCreationExpression();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.unqualifiedClassInstanceCreationExpression().argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter from(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() {
                return ctx.unqualifiedClassInstanceCreationExpression();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.unqualifiedClassInstanceCreationExpression().argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return ctx.NULLSAFE();
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() {
                return ctx.unqualifiedClassInstanceCreationExpression();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.unqualifiedClassInstanceCreationExpression().argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter from(JPlus25Parser.PNNAClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() {
                return ctx.unqualifiedClassInstanceCreationExpression();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.unqualifiedClassInstanceCreationExpression().argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter from(ExpressionNameInvocationContext ctx) {
        return new PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx.originalContext();
            }

            @Override
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() {
                return ctx.unqualifiedClassInstanceCreationExpression();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.unqualifiedClassInstanceCreationExpression().argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public Token getStart() {
                return ctx.getStart();
            }
        };
    }
}
