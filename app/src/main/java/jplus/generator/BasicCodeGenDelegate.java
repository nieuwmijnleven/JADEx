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

import jplus.analyzer.nullability.context.adapter.PNNAContextAdapter;
import jplus.analyzer.nullability.context.adapter.PrimaryNoNewArrayContextAdapter;
import jplus.base.JADEx25Parser;
import jplus.base.JADEx25Parser.ApplyDeclarationContext;
import jplus.base.JADEx25Parser.ExpressionNameContext;
import jplus.base.JADEx25Parser.FieldAccessContext;
import jplus.base.JADEx25Parser.MethodInvocationContext;
import jplus.base.JADEx25Parser.NullCoalescingExpressionContext;
import jplus.base.JADEx25Parser.PrimaryNoNewArrayContext;
import jplus.base.JADEx25Parser.UnannTypeContext;
import jplus.editor.FragmentedText;
import jplus.util.ParserUtils;
import jplus.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicCodeGenDelegate implements CodeGenDelegate {

    protected boolean processed = false;

    protected String updatedContextString = "";

    protected final JADExParserRuleContext ctx;

    public BasicCodeGenDelegate(JADExParserRuleContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public String getText() {

        if (processed) return updatedContextString;
        processed = true;

        return switch (ctx) {

            case ApplyDeclarationContext applyDeclarationCtx -> {
                checkImmutableMode(applyDeclarationCtx);
                yield replaceApplyStatementWithComment(applyDeclarationCtx);
            }

            case JADEx25Parser.FieldDeclarationContext fieldDeclCtx
                    -> processFieldDeclarationContext(fieldDeclCtx);

            case JADEx25Parser.LocalVariableDeclarationContext locDeclCtx
                    -> processLocalVariableDeclarationContext(locDeclCtx);

            case UnannTypeContext unannTypeCtx when unannTypeCtx.unannReferenceType() != null
                    -> replaceNullType(unannTypeCtx);

            case NullCoalescingExpressionContext nullCoalescingCtx when nullCoalescingCtx.ELVIS() != null
                    -> replaceElvisOperator(nullCoalescingCtx);

            case PrimaryNoNewArrayContext primaryNoNewArrayCtx
                    -> processPrimaryNoNewArray(primaryNoNewArrayCtx);

            case ExpressionNameContext expressionNameCtx
                    -> processExpressionName(expressionNameCtx);

            case FieldAccessContext fieldAccessCtx
                    -> processFieldAccess(fieldAccessCtx);

            case MethodInvocationContext methodInvocationCtx
                    -> processMethodInvocation(methodInvocationCtx);

            default -> processDefaultText();
        };
    }

    /*protected String processOrdinaryCompilationUnit(JADEx25Parser.OrdinaryCompilationUnitContext ordCompUnitCtx) {
        String replaced = "";

        if (ordCompUnitCtx.packageDeclaration() != null) {
            replaced += Utils.getTokenString(ordCompUnitCtx.packageDeclaration());
            replaced += "\n\n";
        }

        for (var importDeclarationContext : ordCompUnitCtx.importDeclaration()) {
            replaced += Utils.getTokenString(importDeclarationContext) + "\n";
        }
        if (!ordCompUnitCtx.importDeclaration().isEmpty()) replaced += "\n";

        replaced += "import jadex.runtime.SafeAccess;\n";
        replaced += "import org.jspecify.annotations.Nullable;\n";
        replaced += "\n";

        for (var applyDeclarationContext : ordCompUnitCtx.applyDeclaration()) {
            replaced += Utils.getTokenString(applyDeclarationContext) + "\n";
        }
        if (!ordCompUnitCtx.applyDeclaration().isEmpty()) replaced += "\n";

        for (var topLevelClassOrInterfaceDeclarationContext : ordCompUnitCtx.topLevelClassOrInterfaceDeclaration()) {
            replaced += topLevelClassOrInterfaceDeclarationContext.getText();
        }

        return updateContextString(ordCompUnitCtx, replaced);
    }*/

    protected void checkImmutableMode(ApplyDeclarationContext applyDeclarationCtx) {

        if (!(applyDeclarationCtx.applyStatement() instanceof JADEx25Parser.ApplyStatementContext applyStmtCtx)) return;

        for (var applyFeatureContext : applyStmtCtx.applyFeatureList().applyFeature()) {

            if ( "immutability".equalsIgnoreCase(Utils.getTokenString(applyFeatureContext.identifier())) ) {

                var codeGenCtx = CodeGenContext.current();
                codeGenCtx.setImmutableMode(true);

                System.err.println("immutability feature detected. Setting mutable mode.");
                break;
            }
        }
    }

    protected String processFieldDeclarationContext(JADEx25Parser.FieldDeclarationContext fieldDeclCtx) {

        var codeGenCtx = CodeGenContext.current();
        if (!codeGenCtx.isImmutableMode()) {
            return processDefaultText();
        }

        ensureChildTextInitialized();

        List<String> modifierList = new ArrayList<>();

        boolean hasFinal = false;
        boolean hasMutable = false;

        for (var fieldModifierContext : fieldDeclCtx.fieldModifier()) {

            if (fieldModifierContext.MUTABLE() != null) {
                hasMutable = true;
                //updateContextString(fieldModifierContext, "");

                var modifierRange = Utils.getTextChangeRange(getOriginalText(), fieldModifierContext);
                var mutableModifierRange = new TextChangeRange(modifierRange.startLine(), modifierRange.startIndex(), modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1);

                //updateContextString(locVarModifierContext, "");
                updateFragmentedText(mutableModifierRange, "");

                continue;
            }

            if (fieldModifierContext.FINAL() != null) hasFinal = true;
            modifierList.add(Utils.getTokenString(fieldModifierContext));
        }

        if (!hasMutable && !hasFinal) {
            modifierList.add("final");

            TextChangeRange modifierRange = null;
            TextChangeRange finalModifierRange = null;
            if (!fieldDeclCtx.fieldModifier().isEmpty()) {
                modifierRange = Utils.getTextChangeRange(getOriginalText(), fieldDeclCtx.fieldModifier().getLast());
                finalModifierRange = new TextChangeRange(modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1, modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1);

                updateFragmentedText(finalModifierRange, " final ");
            } else {
//                modifierRange = Utils.getTextChangeRange(getOriginalText(), fieldDeclCtx);
//                finalModifierRange = new TextChangeRange(modifierRange.startLine(), modifierRange.startIndex(), modifierRange.startLine(), modifierRange.startIndex());
                updateContextString(fieldDeclCtx.unannType(), "final " + Utils.getTokenString(fieldDeclCtx.unannType()));
            }
        }

        String replaced =
                modifierList.stream()
                        .collect(Collectors.joining(" "));
        replaced += " ";

        //replaced += Utils.getTokenString(fieldDeclCtx.unannType());

//        if (fieldDeclCtx.unannType().unannReferenceType() != null) {
//            replaced += replaceNullType(fieldDeclCtx.unannType());
//        } else {
//            replaced += Utils.getTokenString(fieldDeclCtx.unannType());
//        }
        replaced += Utils.getTokenString(fieldDeclCtx.unannType());
        replaced += " ";

        replaced += fieldDeclCtx.variableDeclaratorList().getText();
        replaced += ";";

        return updateContextString(fieldDeclCtx, replaced);
    }

    protected String processLocalVariableDeclarationContext(JADEx25Parser.LocalVariableDeclarationContext locDeclCtx) {

        var codeGenCtx = CodeGenContext.current();
        if (!codeGenCtx.isImmutableMode()) {
            return processDefaultText();
        }

        ensureChildTextInitialized();

        List<String> modifierList = new ArrayList<>();

        boolean hasFinal = false;
        boolean hasMutable = false;

        for (var locVarModifierContext : locDeclCtx.variableModifier()) {

            if (locVarModifierContext.MUTABLE() != null) {
                hasMutable = true;
                var modifierRange = Utils.getTextChangeRange(getOriginalText(), locVarModifierContext);
                var mutableModifierRange = new TextChangeRange(modifierRange.startLine(), modifierRange.startIndex(), modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1);

                //updateContextString(locVarModifierContext, "");
                updateFragmentedText(mutableModifierRange, "");
                continue;
            }

            if (locVarModifierContext.FINAL() != null) hasFinal = true;
            modifierList.add(Utils.getTokenString(locVarModifierContext));
        }

        if (!hasMutable && !hasFinal) {
            modifierList.add("final");

            TextChangeRange modifierRange = null;
            TextChangeRange finalModifierRange = null;
            if (!locDeclCtx.variableModifier().isEmpty()) {
                modifierRange = Utils.getTextChangeRange(getOriginalText(), locDeclCtx.variableModifier().getLast());
                finalModifierRange = new TextChangeRange(modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1, modifierRange.endLine(), modifierRange.inclusiveEndIndex() + 1);

                updateFragmentedText(finalModifierRange, " final ");
            } else {
                //updateContextString(locDeclCtx, Utils.getTokenString(locDeclCtx));
                //modifierRange = Utils.getTextChangeRange(getOriginalText(), locDeclCtx.localVariableType());
                //finalModifierRange = new TextChangeRange(modifierRange.startLine(), modifierRange.startIndex() - 1, modifierRange.startLine(), modifierRange.startIndex() - 1);

                updateContextString(locDeclCtx.localVariableType(), "final " + Utils.getTokenString(locDeclCtx.localVariableType()));
            }
        }

        String replaced =
                modifierList.stream()
                        .collect(Collectors.joining(" "));
        replaced += " ";

        replaced += Utils.getTokenString(locDeclCtx.localVariableType());
        replaced += " ";

        replaced += locDeclCtx.variableDeclaratorList().getText();

        return updateContextString(locDeclCtx, replaced);
    }

    private String processMethodInvocation(MethodInvocationContext methodInvocationCtx) {
        //System.err.println("[processMethodInvocation] contextString = " + Utils.getTokenString(methodInvocationCtx));

        ensureChildTextInitialized();

        if (methodInvocationCtx.primary() != null) {
            String primaryPart = methodInvocationCtx.primary().getText();
            //System.err.println("[processMethodInvocation] primaryPart = " + primaryPart);
            //System.err.println("[processMethodInvocation] contextString = " + Utils.getTokenString(methodInvocationCtx.primary()));
            String replaced = primaryPart;
            if (!ParserUtils.usesNullSafety(methodInvocationCtx.primary())) {
                String methodPart = getMethodPart(methodInvocationCtx);
                if (methodInvocationCtx.NULLSAFE() != null) {
                    replaced = replaceNullsafeOperatorWithOptionalIfPresent(methodInvocationCtx, primaryPart, methodPart);
                } else {
                    replaced = primaryPart + "." + methodPart;
                }
            }
            return updateContextString(methodInvocationCtx, replaced);
        } else if (methodInvocationCtx.expressionName() != null) {
            String expressionNamePart = methodInvocationCtx.expressionName().getText();
            String replaced = expressionNamePart;

            if (!ParserUtils.usesNullSafety(methodInvocationCtx.expressionName())) {
                String methodPart = getMethodPart(methodInvocationCtx);
                if (methodInvocationCtx.NULLSAFE() != null) {
                    replaced = replaceNullsafeOperatorWithOptionalIfPresent(methodInvocationCtx, expressionNamePart, methodPart);
                } else {
                    replaced = expressionNamePart + "." + methodPart;
                }
            }
            return updateContextString(methodInvocationCtx, replaced);
        }

        return forceUpdateContextString(methodInvocationCtx);
    }

    private String processFieldAccess(FieldAccessContext fieldAccessCtx) {
        if (fieldAccessCtx.primary() != null) {
            String primaryPart = fieldAccessCtx.primary().getText();
            String replaced = primaryPart;
            if (!ParserUtils.usesNullSafety(fieldAccessCtx.primary())) {
                String identifierPart = Utils.getTokenString(fieldAccessCtx.identifier());
                if (fieldAccessCtx.NULLSAFE() != null) {
                    replaced = replaceNullsafeOperator(fieldAccessCtx, primaryPart, identifierPart);
                } else {
                    replaced = primaryPart + "." + identifierPart;
                }
            }
            return updateContextString(fieldAccessCtx, replaced);
        }
        return processDefaultText();
    }

    private String processExpressionName(ExpressionNameContext expressionNameCtx) {
        String replaced = Utils.getTokenString(expressionNameCtx);
        if (ParserUtils.usesNullSafety(expressionNameCtx)) {
            replaced = processNullsafety(expressionNameCtx, expressionNameCtx.getParent());
        }
        //System.err.println("[ExpressionNameContext] replaced = " + replaced);
        return updateContextString(expressionNameCtx, replaced);
    }

    protected void ensureChildTextInitialized() {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ctx.getChild(i).getText();
        }
    }

    private String processPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
        ensureChildTextInitialized();

        String replaced = Utils.getTokenString(ctx);
        //System.err.println("[processPrimaryNoNewArray] before replaced = " + replaced);
        if (ParserUtils.usesNullSafety(ctx)) {
            replaced = replaceBaseWithOptional(PrimaryNoNewArrayContextAdapter.from(ctx), Optional.ofNullable(ctx.getParent()).map(ParserRuleContext::getParent).orElse(null));
        }
        //System.err.println("[processPrimaryNoNewArray] replaced = " + replaced);
        return updateContextString(ctx, replaced);
    }

    private String getBase(PrimaryNoNewArrayContextAdapter ctx) {
        ensureChildTextInitialized();
        String contextString = Utils.getTokenString(ctx.originalContext());
//        String contextString = ctx.getText();
        int pnnaPartIndex = contextString.length();
        if (ctx.pNNA() != null) {
            String pnnaPart = Utils.getTokenString(ctx.pNNA());
            pnnaPartIndex = contextString.indexOf(pnnaPart);
        }

        return contextString.substring(0, pnnaPartIndex);
    }

    private String getBase(PNNAContextAdapter ctx) {
        ensureChildTextInitialized();
        String contextString = Utils.getTokenString(ctx.originalContext());
//        String contextString = ctx.getText();
        int pnnaPartIndex = contextString.length();
        if (ctx.pNNA() != null) {
            String pnnaPart = Utils.getTokenString(ctx.pNNA());
            pnnaPartIndex = contextString.indexOf(pnnaPart);
        }

        String base = contextString.substring(0, pnnaPartIndex);
        return base.replaceAll("^(\\.|\\?\\.)", "");
    }

    private String processNullsafety(ExpressionNameContext ctx, ParserRuleContext ruleCtx) {
        Deque<ExpressionNameContext> expressionNameContextDeque = new ArrayDeque<>();
        ExpressionNameContext current = ctx;
        expressionNameContextDeque.addFirst(current);
        while (current.expressionName() != null) {
            current = current.expressionName();
            expressionNameContextDeque.addFirst(current);
        }

        String identifier = Utils.getTokenString(expressionNameContextDeque.removeFirst().identifier());
        //System.err.println("[processNullSafety] identifier = " + identifier);
        //String replaced = "java.util.Optional.ofNullable(" + identifier;
        String replaced = "jadex.runtime.SafeAccess.ofNullable(" + identifier;
        //String replaced = "SafeAccess.ofNullable(" + identifier;
        int i = 0;
        while (!expressionNameContextDeque.isEmpty()) {
            String curTVar = "t" + i;
            var expressionNameContext = expressionNameContextDeque.removeFirst();
            String member = Utils.getTokenString(expressionNameContext.identifier());
            //System.err.println("[processNullSafety] member = " + member);
            if (expressionNameContext.NULLSAFE() != null) {
                replaced += ").map(" + curTVar + " -> " + curTVar + "." + member;
                ++i;
            } else {
                replaced += "." + member;
            }
        }

        if (ruleCtx instanceof MethodInvocationContext miCtx) {
            String method = getMethodPart(miCtx);
            //System.err.println("[processNullsafety] method = " + method);

            String curTVar = "t" + i;
            replaced += ").ifPresent(" + curTVar + " -> " + curTVar + "." + method + ")";
            return replaced;
        } else if (ruleCtx instanceof PrimaryNoNewArrayContext pnnaCtx) {
            String contextString = Utils.getTokenString(pnnaCtx);
            String remainderPart = contextString.substring(Utils.getTokenString(ctx).length()).replaceAll("^(\\.|\\?\\.)", "");
            //System.err.println("[processNullsafety] remainderPart = " + remainderPart);
            String curTVar = "t" + i;
            var pnnaCtxAdapter = PrimaryNoNewArrayContextAdapter.from(pnnaCtx);
            if (pnnaCtxAdapter.NULLSAFE() != null) {
                replaced += ").map(" + curTVar + " -> " + curTVar + "." + remainderPart;
                ++i;
            } else {
                replaced += "." + remainderPart;
            }
        }

        replaced += ").orElse(null)";
        return replaced;
    }

    protected String updateContextString(ParserRuleContext ctx, String replaced) {
        TextChangeRange range = Utils.getTextChangeRange(getOriginalText(), ctx);
        //_getParent().ifPresent(parent -> parent.addTextChangeRange(range, replaced));
        //System.err.println("[updateContextString] before debugString = " + getDebugString());
        updateFragmentedText(range, replaced);
        //System.err.println("[updateContextString] after debugString = " + getDebugString());
        this.updatedContextString = replaced;
        return replaced;
    }

    protected String forceUpdateContextString(ParserRuleContext ctx) {
        //System.err.println("[forceUpdateContextString] ParserRuleContext = " + ctx.getClass().getSimpleName());
        TextChangeRange range = Utils.getTextChangeRange(getOriginalText(), ctx);
        String contextString = Utils.getTokenString(ctx);
        String replaced = projectUpdatesOn(range, contextString);
        //System.err.println("[forceUpdateContextString] contextString = " + contextString);
        //System.err.println("[forceUpdateContextString] replaced = " + replaced);
        return updateContextString(ctx, replaced);
    }

    protected String replaceApplyStatementWithComment(ApplyDeclarationContext ApplyDeclarationCtx) {

        TextChangeRange range = Utils.getTextChangeRange(getOriginalText(), ApplyDeclarationCtx);

        String replaced =
                Utils.getTokenString(ApplyDeclarationCtx)
                        .transform(s -> s.replaceFirst("^", "//"))
                        .transform(s -> s.replaceAll("\n", "\n//"));

        updateFragmentedText(range, replaced);
        this.updatedContextString = replaced;

        return null;
    }

    protected String replaceNullType(UnannTypeContext ctx) {
        String unannTypeText = Utils.getTokenString(ctx);
        if (ctx.QUESTION() != null) {
            String replaced = "@org.jspecify.annotations.Nullable " + unannTypeText.substring(0, unannTypeText.length()-1);
            //String replaced = "@Nullable " + unannTypeText.substring(0, unannTypeText.length()-1);
            return updateContextString(ctx, replaced);
        }
        return unannTypeText;
    }

    protected String replaceElvisOperator(NullCoalescingExpressionContext ctx) {
        //System.err.println("[replaceElvisOperator] contextString = " + Utils.getTokenString(ctx));
        ensureChildTextInitialized();

        Optional<String> conditionalOrExpressionString = getRangeText(ctx.conditionalOrExpression());
        Optional<String> rhsExpressionString = getRhsExpressionRangeText(ctx);

        String replaced;
        if (ParserUtils.usesNullSafety(ctx)) {
            replaced = conditionalOrExpressionString.orElse("null");
            replaced = replaced.replace("orElse(null)", "orElseGet(() -> " + rhsExpressionString.orElse("null") + ")");
        } else {
            //replaced = "java.util.Optional.ofNullable(";
            replaced = "jadex.runtime.SafeAccess.ofNullable(";
            //replaced = "SafeAccess.ofNullable(";
            replaced += conditionalOrExpressionString.orElse("null") + ")";
            replaced += ".orElseGet(() -> " + rhsExpressionString.orElse("null") + ")";
        }

        //System.err.println("[replaceElvisOperator] replaced = " + replaced);
        return updateContextString(ctx, replaced);
    }

    protected Optional<String> getRangeText(ParserRuleContext ctx) {
        TextChangeRange range = Utils.getTextChangeRange(getOriginalText(), ctx);
        return getRangeFragmentedText(range);
    }

    protected Optional<String> getRhsExpressionRangeText(NullCoalescingExpressionContext ctx) {
        if (ctx.nullCoalescingExpression() != null) {
            return getRangeText(ctx.nullCoalescingExpression());
        } else if (ctx.lambdaExpression() != null) {
            return getRangeText(ctx.lambdaExpression());
        }
        return Optional.empty();
    }

    private Optional<String> getRangeFragmentedText(TextChangeRange range) {
        FragmentedText fragmentedText = getCurrentFragmentedText();
        return fragmentedText.findFragmentByRange(range);
    }

    protected FragmentedText getCurrentFragmentedText() {
        CodeGenContext codeGenContext = CodeGenContext.current();
        FragmentedText fragmentedText = codeGenContext.getFragmentedText();
        return fragmentedText;
    }

    private String replaceBaseWithOptional(PrimaryNoNewArrayContextAdapter ctx, ParserRuleContext ruleCtx) {
        if (ctx.expressionName() != null && ParserUtils.usesNullSafety(ctx.expressionName())) {
            return ctx.expressionName().getText();
        }

        String base = getBase(ctx);
        //System.err.println("[replaceBaseWithOptional] base = " + base);
        //System.err.println("[replaceBaseWithOptional] ruleCtx = " + ruleCtx.getClass().getSimpleName());

        if (ctx.NULLSAFE() != null) {
            String[] tokens = base.split("\\?\\.");
            String instance = tokens[0];
            String member = tokens[1];

            //System.err.println("[replaceBaseWithOptional] instance = " + instance);
            //System.err.println("[replaceBaseWithOptional] member = " + member);

            //return "java.util.Optional.ofNullable(" + instance + ").map(t0 -> t0." + member +  replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 1, ruleCtx);
            return "jadex.runtime.SafeAccess.ofNullable(" + instance + ").map(t0 -> t0." + member +  replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 1, ruleCtx);
            //return "SafeAccess.ofNullable(" + instance + ").map(t0 -> t0." + member +  replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 1, ruleCtx);
        }

        //return "java.util.Optional.ofNullable(" + base + replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 0, ruleCtx);
        return "jadex.runtime.SafeAccess.ofNullable(" + base + replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 0, ruleCtx);
        //return "SafeAccess.ofNullable(" + base + replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), 0, ruleCtx);
    }

    private String replacePNNAWithOptional(PNNAContextAdapter ctx, int index, ParserRuleContext ruleCtx) {
        if (ctx == null) {
            String replaced = "";

            if (ruleCtx instanceof FieldAccessContext faCtx) {
                String member = Utils.getTokenString(faCtx.identifier());
                if (faCtx.NULLSAFE() != null) {
                    String curTVar = "t" + index;
                    replaced = ").map(" + curTVar + " -> " + curTVar + "." + member;
                } else {
                    replaced = "." + member;
                }
            } else if (ruleCtx instanceof MethodInvocationContext miCtx) {
                String method = getMethodPart(miCtx);
                //System.err.println("[replacePNNAWithOptional] method = " + method);

                String curTVar = "t" + index;
                replaced += ").ifPresent(" + curTVar + " -> " + curTVar + "." + method + ")";
                return replaced;
            }

            return replaced + ").orElse(null)";
        }

        String member = getBase(ctx);
        //System.err.println("[replaceNullsafeOperator] member = " + member);

        String curTVar = "t" + index;
        if (ctx.NULLSAFE() != null) {
            return ").map(" + curTVar + " -> " + curTVar + "." + member + replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), index + 1, ruleCtx);
        } else {
            return "." + member + replacePNNAWithOptional(PNNAContextAdapter.from(ctx.pNNA()), index, ruleCtx);
        }
    }

    private String getMethodPart(MethodInvocationContext miCtx) {
        String typeArgument = Utils.getTokenString(miCtx.typeArguments());
        String identifier = Utils.getTokenString(miCtx.identifier());
        String argumentList = Optional.ofNullable(miCtx.argumentList()).map(ParserRuleContext::getText).orElse("");

        String methodPart = typeArgument + identifier + "(" + argumentList + ")";
        //System.err.println("[getMethodPart] methodPart = " + methodPart);
        return methodPart;
    }

    private String replaceNullsafeOperator(ParserRuleContext ctx, String lhs, String rhs) {
        //String replaced = "java.util.Optional.ofNullable(" + lhs + ").map(t0 -> t0." + rhs + ").orElse(null)";
        String replaced = "jadex.runtime.SafeAccess.ofNullable(" + lhs + ").map(t0 -> t0." + rhs + ").orElse(null)";
        //String replaced = "SafeAccess.ofNullable(" + lhs + ").map(t0 -> t0." + rhs + ").orElse(null)";
        return updateContextString(ctx, replaced);
    }

    private String replaceNullsafeOperatorWithOptionalIfPresent(ParserRuleContext ctx, String lhs, String rhs) {
        //String replaced = "java.util.Optional.ofNullable(" + lhs + ").ifPresent(t0 -> t0." + rhs + ")";
        String replaced = "jadex.runtime.SafeAccess.ofNullable(" + lhs + ").ifPresent(t0 -> t0." + rhs + ")";
        //String replaced = "SafeAccess.ofNullable(" + lhs + ").ifPresent(t0 -> t0." + rhs + ")";
        return updateContextString(ctx, replaced);
    }

    private String projectUpdatesOn(TextChangeRange range, String contextString) {
        FragmentedText fragmentedText = getCurrentFragmentedText();
        return fragmentedText.projectOn(range, contextString);
    }

    private String getOriginalText() {
        FragmentedText fragmentedText = getCurrentFragmentedText();
        return fragmentedText.getOriginalText();
    }

    private void updateFragmentedText(TextChangeRange range, String replaced) {
        FragmentedText fragmentedText = getCurrentFragmentedText();
        fragmentedText.update(range, replaced);
    }

    private Object getDebugString() {
        FragmentedText fragmentedText = getCurrentFragmentedText();
        return fragmentedText.debugString();
    }

    protected String processDefaultText() {
        ensureChildTextInitialized();

        if (ctx instanceof JADEx25Parser.Start_Context) {

            FragmentedText fragmentedText = getCurrentFragmentedText();
            //System.err.println("debugString = " + fragmentedText.debugString());

            return this.updatedContextString = fragmentedText.toString();

        } else {

            return forceUpdateContextString(ctx);
        }
    }
}
