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

package jplus.analyzer.nullability;

import jplus.analyzer.nullability.dataflow.NullState;
import jplus.base.JPlus25Parser;
import jplus.base.JPlus25ParserBaseVisitor;
import jplus.base.SymbolTable;
import jplus.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

class ConditionVisitor
    extends JPlus25ParserBaseVisitor<ConditionResult> {

    private final NullabilityChecker nullabilityChecker;

    private final SymbolTable before;

    ConditionVisitor(NullabilityChecker nullabilityChecker) {
        this.nullabilityChecker = nullabilityChecker;
        this.before = nullabilityChecker.getCurrentSymbolTable();
    }

    ConditionVisitor(NullabilityChecker nullabilityChecker, SymbolTable before) {
        this.nullabilityChecker = nullabilityChecker;
        this.before = before;
    }

    @Override
    public ConditionResult visitEqualityExpression(JPlus25Parser.EqualityExpressionContext ctx) {
        // base case
        if (ctx.EQUAL() == null && ctx.NOTEQUAL() == null) {
            return visit(ctx.relationalExpression());
        }

        SymbolTable thenTable = before.copy();
        SymbolTable elseTable = before.copy();

        NullState rhsState = nullabilityChecker.evalRHS(ctx.relationalExpression(), before);
        if (rhsState != NullState.NULL) {
            return new ConditionResult(thenTable, elseTable);
        }

        var lhs = extractLValue(ctx.equalityExpression());
        System.err.println("[ConditionVisitor][visitEqualityExpression] lhs = " + Utils.getTokenString(lhs));
        if (lhs == null) {
            return new ConditionResult(thenTable, elseTable);
        }

        if (ctx.NOTEQUAL() != null) {
            System.err.println("[ConditionVisitor][visitEqualityExpression] NotEqual");
            nullabilityChecker.updateNullState(lhs, thenTable, NullState.NON_NULL);
            nullabilityChecker.updateNullState(lhs, elseTable, NullState.NULL);

            strengthenReceiver(lhs, thenTable);
        }

        if (ctx.EQUAL() != null) {
            System.err.println("[ConditionVisitor][visitEqualityExpression] equal");
            nullabilityChecker.updateNullState(lhs, thenTable, NullState.NULL);
            nullabilityChecker.updateNullState(lhs, elseTable, NullState.NON_NULL);

            strengthenReceiver(lhs, thenTable);
            strengthenReceiver(lhs, elseTable);
        }

        return new ConditionResult(thenTable, elseTable);
    }

    void strengthenReceiver(ParserRuleContext lhs, SymbolTable thenTable) {
        ParserRuleContext recv = null;

        if (lhs instanceof JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext m) {
            recv = m.expressionName();
        }

        if (lhs instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext t) {
            recv = t.typeName();
        }

        if (recv != null) {
            nullabilityChecker.updateNullState(recv, thenTable, NullState.NON_NULL);
        }
    }

    ParserRuleContext extractLValue(ParseTree expr) {
        System.err.println("[extractLValue] expr = " + expr.getClass().getSimpleName());
        if (expr == null) return null;

        if (expr instanceof JPlus25Parser.EqualityExpressionContext eq) {
            return extractLValue(eq.relationalExpression());
        }

        if (expr instanceof JPlus25Parser.RelationalExpressionContext re) {
            return extractLValue(re.shiftExpression());
        }

        if (expr instanceof JPlus25Parser.ShiftExpressionContext se) {
            return extractLValue(se.additiveExpression(0));
        }

        if (expr instanceof JPlus25Parser.AdditiveExpressionContext ae) {
            return extractLValue(ae.multiplicativeExpression());
        }

        if (expr instanceof JPlus25Parser.MultiplicativeExpressionContext me) {
            return extractLValue(me.unaryExpression(0));
        }

        if (expr instanceof JPlus25Parser.UnaryExpressionContext ue) {
            if (ue.unaryExpression() != null) return null;
            return extractLValue(ue.unaryExpressionNotPlusMinus());
        }

        if (expr instanceof JPlus25Parser.UnaryExpressionNotPlusMinusContext uenpm) {
            return extractLValue(uenpm.postfixExpression());
        }

        if (expr instanceof JPlus25Parser.ExpressionNameContext exprNm) {
            return exprNm;
        }

        if (expr instanceof JPlus25Parser.PrimaryContext primary) {
            // primaryNoNewArray
            if (primary.primaryNoNewArray() != null)
                return extractLValue(primary.primaryNoNewArray());

            // arrayCreationExpression
            if (primary.arrayCreationExpression() != null)
                return primary.arrayCreationExpression();
        }

        if (expr instanceof JPlus25Parser.PrimaryNoNewArrayContext p) {
            // this / Type.this
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayThisContext) return p;
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext) return p;

            if (p instanceof JPlus25Parser.PrimaryNoNewArrayLiteralContext literal) {
                if (literal.literal() != null && literal.literal().NullLiteral() != null)
                    return literal;
                return null;
            }

            if (p instanceof JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayAccessContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext) {
                return p;
            }

            if (p instanceof JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }

            if (p instanceof JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext
                    || p instanceof JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext) {
                return p;
            }

            if (p instanceof JPlus25Parser.PrimaryNoNewArrayParenExpressionContext paren) {
                return extractLValue(paren.expression());
            }
        }

        if (expr instanceof JPlus25Parser.PostfixExpressionContext post) {
            if (post.expressionName() != null) return extractLValue(post.expressionName());
            if (post.primary() != null) return extractLValue(post.primary());
            return null;
        }

        if (expr instanceof JPlus25Parser.ArrayCreationExpressionContext array) {
            return array;
        }

        return null;
    }


    boolean returnsReferenceType(ParserRuleContext methodCall) {
        //Type returnType = resolveMethodType(methodCall);
        //return returnType != null && !returnType.isPrimitive();
        return true;
    }

    @Override
    public ConditionResult visitRelationalExpression(JPlus25Parser.RelationalExpressionContext ctx) {

        if (ctx.INSTANCEOF() != null) {
            System.err.println("[InstanceOf]");
            SymbolTable t = before.copy();
            SymbolTable f = before.copy();

            var target = extractLValue(ctx.relationalExpression());
            if (target != null) {
                nullabilityChecker.updateNullState(target, t, NullState.NON_NULL);
            }

            return new ConditionResult(t, f);
        }

        if (ctx.LT() != null || ctx.GT() != null
                || ctx.LE() != null || ctx.GE() != null) {

            SymbolTable t = before.copy();
            SymbolTable f = before.copy();

            var lhs = extractLValue(ctx.relationalExpression());
            if (lhs != null) {
                nullabilityChecker.updateNullState(lhs, t, NullState.NON_NULL);
                nullabilityChecker.updateNullState(lhs, f, NullState.NON_NULL);

                strengthenReceiver(lhs, t);
                strengthenReceiver(lhs, f);
            }

            return new ConditionResult(t, f);
        }

        return new ConditionResult(before.copy(), before.copy());
    }

    @Override
    public ConditionResult visitConditionalAndExpression(JPlus25Parser.ConditionalAndExpressionContext ctx
    ) {
        //if (ctx.conditionalAndExpression() == null) {
        if (ctx.inclusiveOrExpression(1) == null) {
            return visit(ctx.inclusiveOrExpression(0));
        }

        ConditionResult left =
                visit(ctx.inclusiveOrExpression(0));

        ConditionResult right =
                new ConditionVisitor(nullabilityChecker, left.whenTrue.copy())
                        .visit(ctx.inclusiveOrExpression(1));

        return new ConditionResult(
                right.whenTrue,
                nullabilityChecker.join(left.whenFalse, right.whenFalse)
        );
    }


    @Override
    public ConditionResult visitConditionalOrExpression(JPlus25Parser.ConditionalOrExpressionContext ctx
    ) {
        if (ctx.conditionalAndExpression(1) == null) {
            return visit(ctx.conditionalAndExpression(0));
        }

        ConditionResult left =
                visit(ctx.conditionalAndExpression(0));

        ConditionResult right =
                new ConditionVisitor(nullabilityChecker, left.whenFalse.copy())
                        .visit(ctx.conditionalAndExpression(1));

        return new ConditionResult(
                nullabilityChecker.join(left.whenTrue, right.whenTrue),
                right.whenFalse
        );
    }
}
