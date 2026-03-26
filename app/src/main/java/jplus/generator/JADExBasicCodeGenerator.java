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

import jplus.base.JADExParser;
import jplus.base.JADExParser.TypeTypeContext;
import jplus.base.JADExParserBaseVisitor;
import jplus.generator.context.adapter.TypeContextAdapter;
import jplus.util.Utils;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.RuleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JADExBasicCodeGenerator extends JADExParserBaseVisitor<Void> {

    private static final Logger LOG = LoggerFactory.getLogger(JADExBasicCodeGenerator.class);

    private static final String SAFE_ACCESS_FQCN = "jadex.runtime.SafeAccess"; // Fully Qualified Class Name

    protected static final Void NOTHING = null;

    protected final TokenStreamRewriter rewriter;

    private boolean isReadOnlyMode;

    private int varIdx = 0;

    public JADExBasicCodeGenerator(TokenStream tokens) {
        this.rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    protected void afterVisit(RuleNode node, Void result) {
        postProcess(node, result);
    }

    private void postProcess(RuleNode node, Void result) {

    }

    // replace nullable mark (?)

    @Override
    public Void visitTypeType(TypeTypeContext ctx) {
        replaceNullType(TypeContextAdapter.from(ctx));
        return NOTHING;
    }

    @Override
    public Void visitResource(JADExParser.ResourceContext ctx) {
        replaceNullType(TypeContextAdapter.from(ctx));
        return NOTHING;
    }

    protected void replaceNullType(TypeContextAdapter ctx) {

        if (ctx.QUESTION() == null) return;

        boolean hasNullableAnnotation =
                ctx.annotation().stream()
                        .anyMatch(anno -> {
                            String text = anno.getText();
                            return text.equals("@Nullable")
                                    || text.endsWith(".Nullable");
                        });

        rewriter.delete(ctx.QUESTION().getSymbol());

        if (!hasNullableAnnotation || ctx.classOrInterfaceType() != null) {

            rewriter.insertBefore(
                    ctx.classOrInterfaceType().start,
                    "@org.jspecify.annotations.Nullable "
            );
        }
    }

    // replace ?. chaining with SafeAccess

    @Override
    public Void visitMemberReferenceExpression(JADExParser.MemberReferenceExpressionContext ctx) {
        super.visitChildren(ctx);

        if (isChainRoot(ctx)) {
            if (containsSafeAccess(ctx)) {
                LOG.debug("containsSafeAccess  = " + Utils.getTokenString(ctx));
                String transformed = transformToSafeAccess(ctx, ".orElse(null)");
                LOG.debug("transformed  = " + transformed);
                rewriter.replace(ctx.start, ctx.stop, transformed);
                return NOTHING;
            }
        }

        return NOTHING;
    }

    private boolean isChainRoot(JADExParser.MemberReferenceExpressionContext ctx) {
        return !(ctx.getParent() instanceof JADExParser.MemberReferenceExpressionContext);
    }

    private boolean containsSafeAccess(JADExParser.ExpressionContext ctx) {

        var current = ctx;
        while (current instanceof JADExParser.MemberReferenceExpressionContext mref) {

            if (Objects.equals("?.", mref.bop.getText())) return true;

            current = mref.expression();
        }

        return false;
    }

    private String transformToSafeAccess(JADExParser.MemberReferenceExpressionContext ctx, String terminalOp) {
        List<AccessPart> parts = new ArrayList<>();
        JADExParser.ExpressionContext current = ctx;

        while (current instanceof JADExParser.MemberReferenceExpressionContext mref) {

            String op = mref.bop.getText();
            String member = rewriter.getText(mref.getChild(2).getSourceInterval());

            parts.add(0, new AccessPart(op, member));

            current = mref.expression();
        }

        String rootText = rewriter.getText(current.getSourceInterval());
        LOG.debug("rootText = " + rootText);

        StringBuilder sb = new StringBuilder();
        sb.append(SAFE_ACCESS_FQCN).append(".ofNullable(").append(rootText).append(")");

        //int varIdx = 0;
        for (int i = 0; i < parts.size(); i++) {
            AccessPart part = parts.get(i);

            if (part.op.equals("?.")) {
                String tVar = "t" + (varIdx++);
                sb.append(".map(").append(tVar).append(" -> ").append(tVar).append(".").append(part.member);

                while (i + 1 < parts.size() && parts.get(i + 1).op.equals(".")) {
                    i++;
                    sb.append(".").append(parts.get(i).member);
                }
                sb.append(")");
            } else {
                int insertPos = sb.lastIndexOf(")");
                sb.insert(insertPos, "." + part.member);
            }
        }

        sb.append(terminalOp);
        return sb.toString();
    }

    private static class AccessPart {
        final String op;
        final String member;
        AccessPart(String op, String member) { this.op = op; this.member = member; }
    }

    @Override
    public Void visitElvisExpression(JADExParser.ElvisExpressionContext ctx) {
        // 1. 자식(LHS)을 먼저 방문하여 s1?.length()를 SafeAccess...orElse(null)로 변환시킴
        super.visitChildren(ctx);

        JADExParser.ExpressionContext lhs = ctx.expression(0);
        JADExParser.ExpressionContext rhs = ctx.expression(1);

        // 2. 이미 변환된(하위 방문 완료된) 텍스트를 가져옴
        String conditionText = rewriter.getText(lhs.getSourceInterval());
        String fallbackText = rewriter.getText(rhs.getSourceInterval());

        String replacement;
        // 3. 만약 LHS가 이미 SafeAccess로 변환되어 ".orElse(null)"로 끝난다면
        // 중복 래핑하지 않고 해당 부분만 .orElseGet(...)으로 교체
        if (conditionText.contains(SAFE_ACCESS_FQCN) && conditionText.endsWith(".orElse(null)")) {
            replacement = conditionText.substring(0, conditionText.length() - ".orElse(null)".length())
                    + String.format(".orElseGet(() -> %s)", fallbackText);
        } else {
            // 일반적인 식인 경우에만 전체를 감쌈
            replacement = String.format(
                    "%s.ofNullable(%s).orElseGet(() -> %s)",
                    SAFE_ACCESS_FQCN,
                    conditionText,
                    fallbackText
            );
        }

        rewriter.replace(ctx.start, ctx.stop, replacement);
        return NOTHING;
    }

    // apply

    @Override
    public Void visitApplyDeclaration(JADExParser.ApplyDeclarationContext ctx) {

        checkIfReadonlyMode(ctx);
        replaceApplyStatementWithComment(ctx);

        return NOTHING;
    }

    protected void checkIfReadonlyMode(JADExParser.ApplyDeclarationContext applyDeclarationCtx) {

        if (!(applyDeclarationCtx.applyStatement() instanceof JADExParser.ApplyStatementContext applyStmtCtx)) return;

        for (var applyFeatureContext : applyStmtCtx.applyFeatureList().applyFeature()) {

            if (
                    "readonly".equalsIgnoreCase(
                            Utils.getTokenString(applyFeatureContext.identifier())
                    )
            ) {

                isReadOnlyMode = true;

                LOG.debug("readonly feature detected.");
                break;
            }
        }
    }

    private Void replaceApplyStatementWithComment(JADExParser.ApplyDeclarationContext ctx) {

        String replacement =
                rewriter.getText(ctx.getSourceInterval())
                        .transform(s -> s.replaceFirst("^", "//"))
                        .transform(s -> s.replaceAll("\n", "\n//"));

        rewriter.replace(ctx.start, ctx.stop, replacement);

        return NOTHING;
    }

    @Override
    public Void visitClassBodyDeclaration(JADExParser.ClassBodyDeclarationContext ctx) {

        super.visitChildren(ctx);

        if (!isReadOnlyMode
            || ctx.memberDeclaration().fieldDeclaration() == null
        ) {
            return NOTHING;
        }

        var hasMutable = false;
        var hasFinal = false;

        for (var modifierContext : ctx.modifier()) {

            var ciModifier = modifierContext.classOrInterfaceModifier();
            if (ciModifier == null) continue;

            if (ciModifier.MUTABLE() != null) {

                hasMutable = true;

                var mutableTokenIndex = ciModifier.MUTABLE().getSymbol().getTokenIndex();
                rewriter.delete(mutableTokenIndex, mutableTokenIndex + 1);
            }

            if (ciModifier.FINAL() != null) {
                hasFinal = true;
            }
        }

        if (!hasMutable && !hasFinal) {
            rewriter.insertBefore(ctx.memberDeclaration().start, "final ");
        }

        return NOTHING;
    }

    @Override
    public Void visitLocalVariableDeclaration(JADExParser.LocalVariableDeclarationContext ctx) {

        super.visitChildren(ctx);

        if (!isReadOnlyMode) return NOTHING;

        var hasMutable = false;
        var hasFinal = false;

        for (var modifier : ctx.variableModifier()) {

                if (modifier.MUTABLE() != null) {

                    hasMutable = true;

                    var mutableTokenIndex = modifier.MUTABLE().getSymbol().getTokenIndex();
                    rewriter.delete(mutableTokenIndex, mutableTokenIndex + 1);
                }

                if (modifier.FINAL() != null) {
                    hasFinal = true;
                }
        }

        if (!hasMutable && !hasFinal) {

            rewriter.insertBefore(
                    ctx.VAR() != null ? ctx.VAR().getSymbol() : ctx.typeType().start,
                    "final "
            );
        }

        return NOTHING;
    }

    @Override
    public Void visitFormalParameter(JADExParser.FormalParameterContext ctx) {

        super.visitChildren(ctx);

        if (!isReadOnlyMode) return NOTHING;

        var hasMutable = false;
        var hasFinal = false;

        for (var modifier : ctx.variableModifier()) {

            if (modifier.MUTABLE() != null) {

                hasMutable = true;

                var mutableTokenIndex = modifier.MUTABLE().getSymbol().getTokenIndex();
                rewriter.delete(mutableTokenIndex, mutableTokenIndex + 1);
            }

            if (modifier.FINAL() != null) {
                hasFinal = true;
            }
        }

        if (!hasMutable && !hasFinal) {

            rewriter.insertBefore(
                    ctx.typeType().start,
                    "final "
            );
        }

        return NOTHING;
    }

    public String getText() {
        return rewriter.getText();
    }
}
