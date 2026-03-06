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
                    JADEx25IntellijLexer.COMMENT,
                    JADEx25IntellijLexer.LINE_COMMENT);

    public static final TokenSet WHITESPACES =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25IntellijLexer.WS);

    public static final TokenSet STRING_LITERALS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25IntellijLexer.StringLiteral);

    public static final TokenSet KEYWORDS =
            PSIElementTypeFactory.createTokenSet(
                    JPlusLanguage.INSTANCE,
                    JADEx25IntellijLexer.ABSTRACT,
                    JADEx25IntellijLexer.APPLY,
                    JADEx25IntellijLexer.ASSERT,
                    JADEx25IntellijLexer.BOOLEAN,
                    JADEx25IntellijLexer.BREAK,
                    JADEx25IntellijLexer.BYTE,
                    JADEx25IntellijLexer.CASE,
                    JADEx25IntellijLexer.CATCH,
                    JADEx25IntellijLexer.CHAR,
                    JADEx25IntellijLexer.CLASS,
                    JADEx25IntellijLexer.CONST,
                    JADEx25IntellijLexer.CONTINUE,
                    JADEx25IntellijLexer.DEFAULT,
                    JADEx25IntellijLexer.DO,
                    JADEx25IntellijLexer.DOUBLE,
                    JADEx25IntellijLexer.ELSE,
                    JADEx25IntellijLexer.ENUM,
                    JADEx25IntellijLexer.EXTENDS,
                    JADEx25IntellijLexer.FINAL,
                    JADEx25IntellijLexer.FINALLY,
                    JADEx25IntellijLexer.FLOAT,
                    JADEx25IntellijLexer.FOR,
                    JADEx25IntellijLexer.IF,
                    JADEx25IntellijLexer.GOTO,
                    JADEx25IntellijLexer.IMPLEMENTS,
                    JADEx25IntellijLexer.IMPORT,
                    JADEx25IntellijLexer.INSTANCEOF,
                    JADEx25IntellijLexer.INT,
                    JADEx25IntellijLexer.INTERFACE,
                    JADEx25IntellijLexer.LONG,
                    JADEx25IntellijLexer.MUTABLE,
                    JADEx25IntellijLexer.NATIVE,
                    JADEx25IntellijLexer.NEW,
                    JADEx25IntellijLexer.PACKAGE,
                    JADEx25IntellijLexer.PRIVATE,
                    JADEx25IntellijLexer.PROTECTED,
                    JADEx25IntellijLexer.PUBLIC,
                    JADEx25IntellijLexer.RETURN,
                    JADEx25IntellijLexer.SHORT,
                    JADEx25IntellijLexer.STATIC,
                    JADEx25IntellijLexer.STRICTFP,
                    JADEx25IntellijLexer.SUPER,
                    JADEx25IntellijLexer.SWITCH,
                    JADEx25IntellijLexer.SYNCHRONIZED,
                    JADEx25IntellijLexer.THIS,
                    JADEx25IntellijLexer.THROW,
                    JADEx25IntellijLexer.THROWS,
                    JADEx25IntellijLexer.TRANSIENT,
                    JADEx25IntellijLexer.TRY,
                    JADEx25IntellijLexer.VOID,
                    JADEx25IntellijLexer.VOLATILE,
                    JADEx25IntellijLexer.WHILE,
                    JADEx25IntellijLexer.UNDER_SCORE
            );

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = JADEx25Parser.class)int ruleIndex){
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }
    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = JADEx25IntellijLexer.class)int ruleIndex){
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}
