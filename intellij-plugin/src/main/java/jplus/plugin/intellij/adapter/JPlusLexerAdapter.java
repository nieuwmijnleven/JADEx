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

package jplus.plugin.intellij.adapter;

import com.intellij.lang.Language;
import jplus.base.JPlus25Lexer;
import jplus.base.JPlus25Parser;
import jplus.plugin.intellij.JPlus25IntellijLexer;
import jplus.plugin.intellij.JPlusLanguage;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.v4.runtime.Lexer;

public class JPlusLexerAdapter extends ANTLRLexerAdaptor {

    static {
        initializeElementTypeFactory();
    }

    public static void initializeElementTypeFactory() {
        PSIElementTypeFactory.defineLanguageIElementTypes(
                JPlusLanguage.INSTANCE,
                JPlus25Lexer.tokenNames,
                JPlus25Parser.ruleNames
        );
    }

    /**
     * Constructs a new instance of {@link ANTLRLexerAdaptor} with
     * the specified {@link Language} and underlying ANTLR {@link
     * Lexer}.
     *
     * @param language The language.
     * @param lexer    The underlying ANTLR lexer.
     */
    public JPlusLexerAdapter() {
        super(JPlusLanguage.INSTANCE, new JPlus25IntellijLexer(null));
    }

//    @Override
//    public @Nullable IElementType getTokenType(int antlrTokenType) {
//        if (antlrTokenType == Token.EOF) {
//            return JPlusTokenTypes.BAD_TOKEN_TYPE;
//        }
//
//        IElementType tokenType = super.getTokenType(antlrTokenType);
//        return (tokenType != null) ? tokenType : JPlusTokenTypes.BAD_TOKEN_TYPE;
//    }
}
