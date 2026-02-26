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
import jplus.base.JADEx25Lexer;
import jplus.base.JADEx25Parser;
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
                    JADEx25Lexer.COMMENT,
                    JADEx25Lexer.LINE_COMMENT);

    public static final TokenSet WHITESPACES =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25Lexer.WS);

    public static final TokenSet STRING_LITERALS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25Lexer.StringLiteral);

    public static final TokenSet KEYWORDS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25Lexer.ABSTRACT,
                    JADEx25Lexer.APPLY,
                    JADEx25Lexer.ASSERT,
                    JADEx25Lexer.BOOLEAN,
                    JADEx25Lexer.BREAK,
                    JADEx25Lexer.BYTE,
                    JADEx25Lexer.CASE,
                    JADEx25Lexer.CATCH,
                    JADEx25Lexer.CHAR,
                    JADEx25Lexer.CLASS,
                    JADEx25Lexer.CONST,
                    JADEx25Lexer.CONTINUE,
                    JADEx25Lexer.DEFAULT,
                    JADEx25Lexer.DO,
                    JADEx25Lexer.DOUBLE,
                    JADEx25Lexer.ELSE,
                    JADEx25Lexer.ENUM,
                    JADEx25Lexer.EXTENDS,
                    JADEx25Lexer.FINAL,
                    JADEx25Lexer.FINALLY,
                    JADEx25Lexer.FLOAT,
                    JADEx25Lexer.FOR,
                    JADEx25Lexer.IF,
                    JADEx25Lexer.GOTO,
                    JADEx25Lexer.IMPLEMENTS,
                    JADEx25Lexer.IMPORT,
                    JADEx25Lexer.INSTANCEOF,
                    JADEx25Lexer.INT,
                    JADEx25Lexer.INTERFACE,
                    JADEx25Lexer.LONG,
                    JADEx25Lexer.NATIVE,
                    JADEx25Lexer.NEW,
                    JADEx25Lexer.PACKAGE,
                    JADEx25Lexer.PRIVATE,
                    JADEx25Lexer.PROTECTED,
                    JADEx25Lexer.PUBLIC,
                    JADEx25Lexer.RETURN,
                    JADEx25Lexer.SHORT,
                    JADEx25Lexer.STATIC,
                    JADEx25Lexer.STRICTFP,
                    JADEx25Lexer.SUPER,
                    JADEx25Lexer.SWITCH,
                    JADEx25Lexer.SYNCHRONIZED,
                    JADEx25Lexer.THIS,
                    JADEx25Lexer.THROW,
                    JADEx25Lexer.THROWS,
                    JADEx25Lexer.TRANSIENT,
                    JADEx25Lexer.TRY,
                    JADEx25Lexer.VOID,
                    JADEx25Lexer.VOLATILE,
                    JADEx25Lexer.WHILE,
                    JADEx25Lexer.UNDER_SCORE
            );

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = JADEx25Parser.class)int ruleIndex){
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }
    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = JADEx25Lexer.class)int ruleIndex){
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}
