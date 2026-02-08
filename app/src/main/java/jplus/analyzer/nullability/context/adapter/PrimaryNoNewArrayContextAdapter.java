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

public interface PrimaryNoNewArrayContextAdapter {

    ParserRuleContext originalContext();
    JPlus25Parser.ExpressionNameContext expressionName();
    ParserRuleContext identifier();
    JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression();
    JPlus25Parser.PNNAContext pNNA();
    TerminalNode THIS();
    TerminalNode LPAREN();
    TerminalNode NULLSAFE();
    Token getStart();

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayContext ctx) {
        if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayLiteralContext primaryNoNewArrayLiteral) {
            return from(primaryNoNewArrayLiteral);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayClassLiteralContext primaryNoNewArrayClassLiteral) {
            return from(primaryNoNewArrayClassLiteral);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayThisContext primaryNoNewArrayThis) {
            return from(primaryNoNewArrayThis);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext primaryNoNewArrayQualifiedThis) {
            return from(primaryNoNewArrayQualifiedThis);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayParenExpressionContext primaryNoNewArrayParenExpression) {
            return from(primaryNoNewArrayParenExpression);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext primaryNoNewArrayClassInstanceCreation) {
            return from(primaryNoNewArrayClassInstanceCreation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext primaryNoNewArrayExprQualifiedClassInstanceCreation) {
            return from(primaryNoNewArrayExprQualifiedClassInstanceCreation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext primaryNoNewArrayArrayQualifiedClassInstanceCreation) {
            return from(primaryNoNewArrayArrayQualifiedClassInstanceCreation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext primaryNoNewArrayArrayFieldAccess) {
            return from(primaryNoNewArrayArrayFieldAccess);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext primaryNoNewArraySuperFieldAccess) {
            return from(primaryNoNewArraySuperFieldAccess);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext primaryNoNewArrayQualifiedSuperFieldAccess) {
            return from(primaryNoNewArrayQualifiedSuperFieldAccess);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayAccessContext primaryNoNewArrayArrayAccess) {
            return from(primaryNoNewArrayArrayAccess);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext primaryNoNewArrayArrayCreationWithInitAccess) {
            return from(primaryNoNewArrayArrayCreationWithInitAccess);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext primaryNoNewArrayMethodInvocation) {
            return from(primaryNoNewArrayMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext primaryNoNewArrayExprMethodInvocation) {
            return from(primaryNoNewArrayExprMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext primaryNoNewArrayTypeMethodInvocation) {
            return from(primaryNoNewArrayTypeMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext primaryNoNewArrayArrayMethodInvocation) {
            return from(primaryNoNewArrayArrayMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext primaryNoNewArraySuperMethodInvocation) {
            return from(primaryNoNewArraySuperMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext primaryNoNewArrayQualifiedSuperMethodInvocation) {
            return from(primaryNoNewArrayQualifiedSuperMethodInvocation);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext primaryNoNewArrayExprMethodReference) {
            return from(primaryNoNewArrayExprMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext primaryNoNewArrayArrayMethodReference) {
            return from(primaryNoNewArrayArrayMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext primaryNoNewArrayTypeMethodReference) {
            return from(primaryNoNewArrayTypeMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext primaryNoNewArraySuperMethodReference) {
            return from(primaryNoNewArraySuperMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext primaryNoNewArrayTypeMethodReference) {
            return from(primaryNoNewArrayTypeMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext primaryNoNewArraySuperMethodReference) {
            return from(primaryNoNewArraySuperMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext primaryNoNewArrayQualifiedSuperMethodReference) {
            return from(primaryNoNewArrayQualifiedSuperMethodReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext primaryNoNewArrayConstructorReference) {
            return from(primaryNoNewArrayConstructorReference);
        } else if (ctx instanceof JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext primaryNoNewArrayArrayConstructorReference) {
            return from(primaryNoNewArrayArrayConstructorReference);
        }

        return null;
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayLiteralContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayClassLiteralContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayThisContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return ctx.THIS(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return ctx.THIS(); }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return ctx.expressionName(); }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return ctx.expressionName(); }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return ctx.NULLSAFE(); }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return ctx.identifier(); }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }

    static PrimaryNoNewArrayContextAdapter from(JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext ctx) {
        return new PrimaryNoNewArrayContextAdapter() {
            public ParserRuleContext originalContext() { return ctx; }
            public JPlus25Parser.ExpressionNameContext expressionName() { return null; }
            public ParserRuleContext identifier() { return null; }
            public JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext unqualifiedClassInstanceCreationExpression() { return null; }
            public JPlus25Parser.PNNAContext pNNA() { return ctx.pNNA(); }
            public TerminalNode THIS() { return null; }
            public TerminalNode LPAREN() { return null; }
            public TerminalNode NULLSAFE() { return null; }
            public Token getStart() { return ctx.start; }
        };
    }
}
