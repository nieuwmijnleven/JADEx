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

import jplus.base.JADEx25Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public interface AssignmentContextAdapter {

    ParserRuleContext originalContext();
    JADEx25Parser.ExpressionContext expression();
    Token getStart();

    static AssignmentContextAdapter from(JADEx25Parser.FieldDeclarationContext ctx, JADEx25Parser.ExpressionContext exprCtx) {
        return new AssignmentContextAdapter() {

            @Override
            public ParserRuleContext originalContext() { return ctx; }

            @Override
            public JADEx25Parser.ExpressionContext expression() {
                return exprCtx;
            }

            @Override
            public Token getStart() { return ctx.start; }
        };
    }

    static AssignmentContextAdapter from(JADEx25Parser.LocalVariableDeclarationContext ctx, JADEx25Parser.ExpressionContext exprCtx) {
        return new AssignmentContextAdapter() {

            @Override
            public ParserRuleContext originalContext() { return ctx; }

            @Override
            public JADEx25Parser.ExpressionContext expression() {
                return exprCtx;
            }

            @Override
            public Token getStart() { return ctx.start; }
        };
    }

    static AssignmentContextAdapter from(JADEx25Parser.AssignmentContext ctx, JADEx25Parser.ExpressionContext exprCtx) {
        return new AssignmentContextAdapter() {

            @Override
            public ParserRuleContext originalContext() { return ctx; }

            @Override
            public JADEx25Parser.ExpressionContext expression() {
                return exprCtx;
            }

            @Override
            public Token getStart() { return ctx.start; }
        };
    }

}
