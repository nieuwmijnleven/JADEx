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

package jplus.generator;

import jplus.base.JPlus25Parser;
import jplus.base.JPlus25Parser.ApplyDeclarationContext;
import jplus.base.JPlus25Parser.ExpressionNameContext;
import jplus.base.JPlus25Parser.FieldAccessContext;
import jplus.base.JPlus25Parser.MethodInvocationContext;
import jplus.base.JPlus25Parser.NullCoalescingExpressionContext;
import jplus.base.JPlus25Parser.PrimaryNoNewArrayContext;
import jplus.base.JPlus25Parser.UnannTypeContext;
import jplus.editor.FragmentedText;
import jplus.util.ParserUtils;
import jplus.util.Utils;

import java.util.Optional;

public class SemanticCodeGenDelegate extends BasicCodeGenDelegate {
    public SemanticCodeGenDelegate(JPlusParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public String getText() {
        if (processed) return updatedContextString;
        processed = true;

        /*if (ctx instanceof JPlus25Parser.OrdinaryCompilationUnitContext ordCompUnitCtx) {
            return processOrdinaryCompilationUnit(ordCompUnitCtx);
        } else*/

        if (ctx instanceof ApplyDeclarationContext applyDeclarationCtx) {
            return replaceApplyStatementWithComment(applyDeclarationCtx);
        } else if (ctx instanceof UnannTypeContext unannTypeCtx && unannTypeCtx.unannReferenceType() != null) {
            return replaceNullType(unannTypeCtx);
        } else if (ctx instanceof NullCoalescingExpressionContext nullCoalescingCtx && nullCoalescingCtx.ELVIS() != null) {
            return replaceElvisOperator(nullCoalescingCtx);
        } else if (ctx instanceof PrimaryNoNewArrayContext primaryNoNewArrayCtx) {
            return processPrimaryNoNewArray(primaryNoNewArrayCtx);
        } else if (ctx instanceof ExpressionNameContext expressionNameCtx) {
            return processExpressionName(expressionNameCtx);
        } else if (ctx instanceof FieldAccessContext fieldAccessCtx) {
            return processFieldAccess(fieldAccessCtx);
        } else if (ctx instanceof MethodInvocationContext methodInvocationCtx) {
            return processMethodInvocation(methodInvocationCtx);
        }

        return processDefaultText();
    }

    private String processMethodInvocation(MethodInvocationContext methodInvocationCtx) {
        ensureChildTextInitialized();

        //String replaced = Utils.getTokenString(methodInvocationCtx).replace("?.", ".");
        String replaced = forceUpdateContextString(methodInvocationCtx).replace("?.", ".");
        //System.err.println("[processMethodInvocation] replaced = " + replaced);

        return updateContextString(methodInvocationCtx, replaced);
    }

    private String processFieldAccess(FieldAccessContext fieldAccessCtx) {
        ensureChildTextInitialized();

        String replaced = Utils.getTokenString(fieldAccessCtx).replace("?.", ".");
        //System.err.println("[processFieldAccess] replaced = " + replaced);
        return updateContextString(fieldAccessCtx, replaced);
    }

    private String processExpressionName(ExpressionNameContext expressionNameCtx) {
        ensureChildTextInitialized();

        String replaced = Utils.getTokenString(expressionNameCtx).replace("?.", ".");
        //System.err.println("[ExpressionNameContext] replaced = " + replaced);
        return updateContextString(expressionNameCtx, replaced);
    }

    @Override
    protected String replaceElvisOperator(NullCoalescingExpressionContext ctx) {
        //System.err.println("[replaceElvisOperator] contextString = " + Utils.getTokenString(ctx));
        ensureChildTextInitialized();

        //String conditionalOrExpressionString = Utils.getTokenString(ctx.conditionalOrExpression());
        String conditionalOrExpressionString = ctx.conditionalOrExpression().getText();
        //String rhsExpressionString = ctx.nullCoalescingExpression() != null ? Utils.getTokenString(ctx.nullCoalescingExpression()) : Utils.getTokenString(ctx.lambdaExpression());
        String rhsExpressionString = ctx.nullCoalescingExpression() != null ? ctx.nullCoalescingExpression().getText() : Utils.getTokenString(ctx.lambdaExpression());

        String replaced = "jext.util.JextUtils.__elvis(" + conditionalOrExpressionString + ", " + rhsExpressionString + ")";

        //System.err.println("[replaceElvisOperator] replaced = " + replaced);
        return updateContextString(ctx, replaced);
    }

    private String processPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
        ensureChildTextInitialized();

        String replaced = Utils.getTokenString(ctx).replace("?.", ".");
        //System.err.println("[processPrimaryNoNewArray] replaced = " + replaced);
        return updateContextString(ctx, replaced);
    }

    @Override
    protected String processDefaultText() {
        ensureChildTextInitialized();

        if (ctx instanceof JPlus25Parser.Start_Context) {

            FragmentedText fragmentedText = getCurrentFragmentedText();
            //System.err.println("debugString = " + fragmentedText.debugString());
            
            return this.updatedContextString = fragmentedText.toString();

        } else {

            return forceUpdateContextString(ctx);
        }
    }
}
