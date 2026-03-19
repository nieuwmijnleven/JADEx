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

package jplus.plugin.intellij;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import jplus.plugin.intellij.adapter.JPlusLexerAdapter;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.intellij.lang.annotations.MagicConstant;

import java.util.List;

public class JPlusTokenTypes {
    public static IElementType BAD_TOKEN_TYPE = new IElementType("BAD_TOKEN", JPlusLanguage.INSTANCE);

    static {
        JPlusLexerAdapter.initializeElementTypeFactory();
    }

    public static final List<TokenIElementType> TOKEN_ELEMENT_TYPES =
            PSIElementTypeFactory.getTokenIElementTypes(JPlusLanguage.INSTANCE);
    public static final List<RuleIElementType> RULE_ELEMENT_TYPES =
            PSIElementTypeFactory.getRuleIElementTypes(JPlusLanguage.INSTANCE);

    public static final TokenSet COMMENTS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADExIntellijLexer.COMMENT,
                    JADExIntellijLexer.LINE_COMMENT);

    public static final TokenSet WHITESPACES =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADExIntellijLexer.WS);

    public static final TokenSet STRING_LITERALS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADExIntellijLexer.STRING_LITERAL);

    public static final TokenSet KEYWORDS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADExIntellijLexer.ABSTRACT,
                    JADExIntellijLexer.APPLY,
                    JADExIntellijLexer.ASSERT,
                    JADExIntellijLexer.BOOLEAN,
                    JADExIntellijLexer.BREAK,
                    JADExIntellijLexer.BYTE,
                    JADExIntellijLexer.CASE,
                    JADExIntellijLexer.CATCH,
                    JADExIntellijLexer.CHAR,
                    JADExIntellijLexer.CLASS,
                    JADExIntellijLexer.CONST,
                    JADExIntellijLexer.CONTINUE,
                    JADExIntellijLexer.DEFAULT,
                    JADExIntellijLexer.DO,
                    JADExIntellijLexer.DOUBLE,
                    JADExIntellijLexer.ELSE,
                    JADExIntellijLexer.ENUM,
                    JADExIntellijLexer.EXTENDS,
                    JADExIntellijLexer.FINAL,
                    JADExIntellijLexer.FINALLY,
                    JADExIntellijLexer.FLOAT,
                    JADExIntellijLexer.FOR,
                    JADExIntellijLexer.IF,
                    JADExIntellijLexer.GOTO,
                    JADExIntellijLexer.IMPLEMENTS,
                    JADExIntellijLexer.IMPORT,
                    JADExIntellijLexer.INSTANCEOF,
                    JADExIntellijLexer.INT,
                    JADExIntellijLexer.INTERFACE,
                    JADExIntellijLexer.LONG,
                    JADExIntellijLexer.MUTABLE,
                    JADExIntellijLexer.NATIVE,
                    JADExIntellijLexer.NEW,
                    JADExIntellijLexer.PACKAGE,
                    JADExIntellijLexer.PRIVATE,
                    JADExIntellijLexer.PROTECTED,
                    JADExIntellijLexer.PUBLIC,
                    JADExIntellijLexer.RETURN,
                    JADExIntellijLexer.SHORT,
                    JADExIntellijLexer.STATIC,
                    JADExIntellijLexer.STRICTFP,
                    JADExIntellijLexer.SUPER,
                    JADExIntellijLexer.SWITCH,
                    JADExIntellijLexer.SYNCHRONIZED,
                    JADExIntellijLexer.THIS,
                    JADExIntellijLexer.THROW,
                    JADExIntellijLexer.THROWS,
                    JADExIntellijLexer.TRANSIENT,
                    JADExIntellijLexer.TRY,
                    JADExIntellijLexer.VOID,
                    JADExIntellijLexer.VOLATILE,
                    JADExIntellijLexer.WHILE,
                    JADExIntellijLexer.UNDER_SCORE
            );

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = JADExIntellijParser.class)int ruleIndex){
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }
    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = JADExIntellijLexer.class)int ruleIndex){
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}
