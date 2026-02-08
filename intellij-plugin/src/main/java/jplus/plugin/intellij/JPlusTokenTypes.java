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
import jplus.base.JPlus25Lexer;
import jplus.base.JPlus20Parser;
import jplus.base.JPlus25Parser;
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
                    JPlus25Lexer.COMMENT,
                    JPlus25Lexer.LINE_COMMENT);

    public static final TokenSet WHITESPACES =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JPlus25Lexer.WS);

    public static final TokenSet STRING_LITERALS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JPlus25Lexer.StringLiteral);

    public static final TokenSet KEYWORDS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JPlus25Lexer.ABSTRACT,
                    JPlus25Lexer.APPLY,
                    JPlus25Lexer.ASSERT,
                    JPlus25Lexer.BOOLEAN,
                    JPlus25Lexer.BREAK,
                    JPlus25Lexer.BYTE,
                    JPlus25Lexer.CASE,
                    JPlus25Lexer.CATCH,
                    JPlus25Lexer.CHAR,
                    JPlus25Lexer.CLASS,
                    JPlus25Lexer.CONST,
                    JPlus25Lexer.CONTINUE,
                    JPlus25Lexer.DEFAULT,
                    JPlus25Lexer.DO,
                    JPlus25Lexer.DOUBLE,
                    JPlus25Lexer.ELSE,
                    JPlus25Lexer.ENUM,
                    JPlus25Lexer.EXTENDS,
                    JPlus25Lexer.FINAL,
                    JPlus25Lexer.FINALLY,
                    JPlus25Lexer.FLOAT,
                    JPlus25Lexer.FOR,
                    JPlus25Lexer.IF,
                    JPlus25Lexer.GOTO,
                    JPlus25Lexer.IMPLEMENTS,
                    JPlus25Lexer.IMPORT,
                    JPlus25Lexer.INSTANCEOF,
                    JPlus25Lexer.INT,
                    JPlus25Lexer.INTERFACE,
                    JPlus25Lexer.LONG,
                    JPlus25Lexer.NATIVE,
                    JPlus25Lexer.NEW,
                    JPlus25Lexer.PACKAGE,
                    JPlus25Lexer.PRIVATE,
                    JPlus25Lexer.PROTECTED,
                    JPlus25Lexer.PUBLIC,
                    JPlus25Lexer.RETURN,
                    JPlus25Lexer.SHORT,
                    JPlus25Lexer.STATIC,
                    JPlus25Lexer.STRICTFP,
                    JPlus25Lexer.SUPER,
                    JPlus25Lexer.SWITCH,
                    JPlus25Lexer.SYNCHRONIZED,
                    JPlus25Lexer.THIS,
                    JPlus25Lexer.THROW,
                    JPlus25Lexer.THROWS,
                    JPlus25Lexer.TRANSIENT,
                    JPlus25Lexer.TRY,
                    JPlus25Lexer.VOID,
                    JPlus25Lexer.VOLATILE,
                    JPlus25Lexer.WHILE,
                    JPlus25Lexer.UNDER_SCORE
            );

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = JPlus25Parser.class)int ruleIndex){
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }
    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = JPlus25Lexer.class)int ruleIndex){
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}
