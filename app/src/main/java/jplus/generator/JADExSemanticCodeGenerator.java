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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import java.util.stream.IntStream;

public class JADExSemanticCodeGenerator extends JADExBasicCodeGenerator {

    public JADExSemanticCodeGenerator(TokenStream tokens) {
        super(tokens);
    }

    private void replaceToken(ParserRuleContext ctx, int targetTokenType, String replacement) {
        IntStream.rangeClosed(ctx.start.getTokenIndex(), ctx.stop.getTokenIndex())
                .forEach(tokenIdx -> {

                    var token = rewriter.getTokenStream().get(tokenIdx);
                    if (token.getChannel() == Token.DEFAULT_CHANNEL
                            && token.getType() == targetTokenType) {

                        rewriter.replace(tokenIdx, replacement);
                    }
                });
    }

    @Override
    public Void visitMemberReferenceExpression(JADExParser.MemberReferenceExpressionContext ctx) {

        super.visitChildren(ctx);
        replaceToken(ctx, JADExParser.NULLSAFE, ".");

        return NOTHING;
    }

    @Override
    public Void visitElvisExpression(JADExParser.ElvisExpressionContext ctx) {

        super.visitChildren(ctx);

        var conditionExpr = ctx.expression(0);
        var fallbackExpr = ctx.expression(1);

        rewriter.insertBefore(conditionExpr.start, "jext.util.JextUtils.__elvis(");
        rewriter.replace(ctx.bop.getTokenIndex(), ",");
        rewriter.insertAfter(fallbackExpr.stop, ")");

        return NOTHING;
    }
}
