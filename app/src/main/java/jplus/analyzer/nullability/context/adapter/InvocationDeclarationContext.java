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
import jplus.base.Modifier;
import jplus.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.EnumSet;

public interface InvocationDeclarationContext {

    ParserRuleContext originalContext();
    JPlus25Parser.FormalParameterListContext formalParameterList();
    ParserRuleContext invocationBody();
    EnumSet<Modifier> modifiers();
    String methodName();

    static InvocationDeclarationContext from(JPlus25Parser.MethodDeclarationContext ctx) {
        return new InvocationDeclarationContext() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.FormalParameterListContext formalParameterList() {
                return ctx.methodHeader().methodDeclarator().formalParameterList();
            }

            @Override
            public ParserRuleContext invocationBody() {
                return ctx.methodBody().block();
            }

            @Override
            public EnumSet<Modifier> modifiers() {
                EnumSet<Modifier> modifierEnumSet = EnumSet.noneOf(Modifier.class);
                for (JPlus25Parser.MethodModifierContext methodModifierContext : ctx.methodModifier()) {
                    modifierEnumSet.add(Modifier.valueOf(methodModifierContext.toString().toUpperCase()));
                }
                return modifierEnumSet;
            }

            @Override
            public String methodName() {
                return Utils.getTokenString(ctx.methodHeader().methodDeclarator().identifier());
            }
        };
    }

    static InvocationDeclarationContext from(JPlus25Parser.ConstructorDeclarationContext ctx) {
        return new InvocationDeclarationContext() {
            @Override
            public ParserRuleContext originalContext() {
                return ctx;
            }

            @Override
            public JPlus25Parser.FormalParameterListContext formalParameterList() {
                return ctx.constructorDeclarator().formalParameterList();
            }

            @Override
            public ParserRuleContext invocationBody() {
                return ctx.constructorBody();
            }

            @Override
            public EnumSet<Modifier> modifiers() {
                EnumSet<Modifier> modifierEnumSet = EnumSet.noneOf(Modifier.class);
                for (JPlus25Parser.ConstructorModifierContext constructorModifierContext: ctx.constructorModifier()) {
                    modifierEnumSet.add(Modifier.valueOf(constructorModifierContext.toString().toUpperCase()));
                }
                return modifierEnumSet;
            }

            @Override
            public String methodName() {
                return "constructor";
            }
        };
    }
}
