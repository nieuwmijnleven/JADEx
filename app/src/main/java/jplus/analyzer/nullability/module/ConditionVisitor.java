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

package jplus.analyzer.nullability.module;

import jplus.analyzer.nullability.NullabilityChecker;
import jplus.analyzer.nullability.dataflow.NullState;
import jplus.base.JADEx25Parser.AdditiveExpressionContext;
import jplus.base.JADEx25Parser.ArrayCreationExpressionContext;
import jplus.base.JADEx25Parser.ConditionalAndExpressionContext;
import jplus.base.JADEx25Parser.ConditionalOrExpressionContext;
import jplus.base.JADEx25Parser.EqualityExpressionContext;
import jplus.base.JADEx25Parser.ExpressionNameContext;
import jplus.base.JADEx25Parser.MultiplicativeExpressionContext;
import jplus.base.JADEx25Parser.PostfixExpressionContext;
import jplus.base.JADEx25Parser.PrimaryContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayAccessContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayFieldAccessContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayMethodReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayClassInstanceCreationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayConstructorReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayExprMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayExprMethodReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayLiteralContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayParenExpressionContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayQualifiedThisContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArraySuperFieldAccessContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArraySuperMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArraySuperMethodReferenceContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayThisContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayTypeMethodInvocationContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayTypeMethodReferenceContext;
import jplus.base.JADEx25Parser.RelationalExpressionContext;
import jplus.base.JADEx25Parser.ShiftExpressionContext;
import jplus.base.JADEx25Parser.UnaryExpressionContext;
import jplus.base.JADEx25Parser.UnaryExpressionNotPlusMinusContext;
import jplus.base.JADEx25ParserBaseVisitor;
import jplus.base.SymbolTable;
import jplus.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class ConditionVisitor extends JADEx25ParserBaseVisitor<ConditionResult> {

    private final NullabilityChecker nullabilityChecker;

    private final SymbolTable before;

    public ConditionVisitor(NullabilityChecker nullabilityChecker) {
        this.nullabilityChecker = nullabilityChecker;
        this.before = nullabilityChecker.getCurrentSymbolTable();
    }

    public ConditionVisitor(NullabilityChecker nullabilityChecker, SymbolTable before) {
        this.nullabilityChecker = nullabilityChecker;
        this.before = before;
    }

    @Override
    public ConditionResult visitEqualityExpression(EqualityExpressionContext ctx) {
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

        if (lhs instanceof PrimaryNoNewArrayExprMethodInvocationContext m) {
            recv = m.expressionName();
        }

        if (lhs instanceof PrimaryNoNewArrayTypeMethodInvocationContext t) {
            recv = t.typeName();
        }

        if (recv != null) {
            nullabilityChecker.updateNullState(recv, thenTable, NullState.NON_NULL);
        }
    }

    ParserRuleContext extractLValue(ParseTree expr) {
        System.err.println("[extractLValue] expr = " + expr.getClass().getSimpleName());
        if (expr == null) return null;

        if (expr instanceof EqualityExpressionContext eq) {
            return extractLValue(eq.relationalExpression());
        }

        if (expr instanceof RelationalExpressionContext re) {
            return extractLValue(re.shiftExpression());
        }

        if (expr instanceof ShiftExpressionContext se) {
            return extractLValue(se.additiveExpression(0));
        }

        if (expr instanceof AdditiveExpressionContext ae) {
            return extractLValue(ae.multiplicativeExpression());
        }

        if (expr instanceof MultiplicativeExpressionContext me) {
            return extractLValue(me.unaryExpression(0));
        }

        if (expr instanceof UnaryExpressionContext ue) {
            if (ue.unaryExpression() != null) return null;
            return extractLValue(ue.unaryExpressionNotPlusMinus());
        }

        if (expr instanceof UnaryExpressionNotPlusMinusContext uenpm) {
            return extractLValue(uenpm.postfixExpression());
        }

        if (expr instanceof ExpressionNameContext exprNm) {
            return exprNm;
        }

        if (expr instanceof PrimaryContext primary) {
            // primaryNoNewArray
            if (primary.primaryNoNewArray() != null)
                return extractLValue(primary.primaryNoNewArray());

            // arrayCreationExpression
            if (primary.arrayCreationExpression() != null)
                return primary.arrayCreationExpression();
        }

        if (expr instanceof PrimaryNoNewArrayContext p) {
            // this / Type.this
            if (p instanceof PrimaryNoNewArrayThisContext) return p;
            if (p instanceof PrimaryNoNewArrayQualifiedThisContext) return p;

            if (p instanceof PrimaryNoNewArrayLiteralContext literal) {
                if (literal.literal() != null && literal.literal().NullLiteral() != null)
                    return literal;
                return null;
            }

            if (p instanceof PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext
                    || p instanceof PrimaryNoNewArrayClassInstanceCreationContext
                    || p instanceof PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext
                    || p instanceof PrimaryNoNewArrayArrayCreationWithInitAccessContext
                    || p instanceof PrimaryNoNewArrayArrayAccessContext
                    || p instanceof PrimaryNoNewArrayArrayFieldAccessContext
                    || p instanceof PrimaryNoNewArraySuperFieldAccessContext
                    || p instanceof PrimaryNoNewArrayQualifiedSuperFieldAccessContext) {
                return p;
            }

            if (p instanceof PrimaryNoNewArrayMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof PrimaryNoNewArrayExprMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof PrimaryNoNewArrayTypeMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof PrimaryNoNewArrayArrayMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof PrimaryNoNewArraySuperMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }
            if (p instanceof PrimaryNoNewArrayQualifiedSuperMethodInvocationContext m) {
                if (returnsReferenceType(m)) return m;
                return null;
            }

            if (p instanceof PrimaryNoNewArrayExprMethodReferenceContext
                    || p instanceof PrimaryNoNewArrayArrayMethodReferenceContext
                    || p instanceof PrimaryNoNewArrayTypeMethodReferenceContext
                    || p instanceof PrimaryNoNewArraySuperMethodReferenceContext
                    || p instanceof PrimaryNoNewArrayQualifiedSuperMethodReferenceContext
                    || p instanceof PrimaryNoNewArrayConstructorReferenceContext
                    || p instanceof PrimaryNoNewArrayArrayConstructorReferenceContext) {
                return p;
            }

            if (p instanceof PrimaryNoNewArrayParenExpressionContext paren) {
                return extractLValue(paren.expression());
            }
        }

        if (expr instanceof PostfixExpressionContext post) {
            if (post.expressionName() != null) return extractLValue(post.expressionName());
            if (post.primary() != null) return extractLValue(post.primary());
            return null;
        }

        if (expr instanceof ArrayCreationExpressionContext array) {
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
    public ConditionResult visitRelationalExpression(RelationalExpressionContext ctx) {

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
    public ConditionResult visitConditionalAndExpression(ConditionalAndExpressionContext ctx
    ) {
        //if (ctx.conditionalAndExpression() == null) {
        if (ctx.inclusiveOrExpression(1) == null) {
            return visit(ctx.inclusiveOrExpression(0));
        }

        ConditionResult left =
                visit(ctx.inclusiveOrExpression(0));

        ConditionResult right =
                new ConditionVisitor(nullabilityChecker, left.whenTrue().copy())
                        .visit(ctx.inclusiveOrExpression(1));

        return new ConditionResult(
                right.whenTrue(),
                nullabilityChecker.join(left.whenFalse(), right.whenFalse())
        );
    }


    @Override
    public ConditionResult visitConditionalOrExpression(ConditionalOrExpressionContext ctx
    ) {
        if (ctx.conditionalAndExpression(1) == null) {
            return visit(ctx.conditionalAndExpression(0));
        }

        ConditionResult left =
                visit(ctx.conditionalAndExpression(0));

        ConditionResult right =
                new ConditionVisitor(nullabilityChecker, left.whenFalse().copy())
                        .visit(ctx.conditionalAndExpression(1));

        return new ConditionResult(
                nullabilityChecker.join(left.whenTrue(), right.whenTrue()),
                right.whenFalse()
        );
    }
}
