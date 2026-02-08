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

public interface MethodInvocationSignatureContextAdapter {

    ParserRuleContext originalContext();
    JPlus25Parser.IdentifierContext identifier();
    JPlus25Parser.MethodNameContext methodName();
    JPlus25Parser.ArgumentListContext argumentList();
    JPlus25Parser.PNNAContext pNNA();
    TerminalNode NULLSAFE();
    Token getStart();

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
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

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }

            @Override
            public TerminalNode NULLSAFE() {
                return null;
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return ctx.pNNA();
            }

            @Override
            public Token getStart() {
                return ctx.start;
            }
        };
    }

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.MethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return ctx.methodName();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return null;
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

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return null;
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return ctx.methodName();
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return null;
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

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
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

    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PNNAMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
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

    //JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext
    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return ctx.identifier();
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
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

    //UnqualifiedClassInstanceCreationExpressionContext
    static MethodInvocationSignatureContextAdapter from(JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return null;
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
            }

            @Override
            public JPlus25Parser.PNNAContext pNNA() {
                return null;
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

    //PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter
    static MethodInvocationSignatureContextAdapter from(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter ctx) {
        return new MethodInvocationSignatureContextAdapter() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx.originalContext();
            }

            @Override
            public JPlus25Parser.IdentifierContext identifier() {
                return null;
            }

            @Override
            public JPlus25Parser.MethodNameContext methodName() {
                return null;
            }

            @Override
            public JPlus25Parser.ArgumentListContext argumentList() {
                return ctx.argumentList();
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
                return ctx.getStart();
            }
        };
    }

}
