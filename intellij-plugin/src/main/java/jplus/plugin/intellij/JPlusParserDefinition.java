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

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import jplus.base.JADEx25Parser;
import jplus.plugin.intellij.adapter.JPlusLexerAdapter;
import jplus.plugin.intellij.adapter.JPlusParserAdapter;
import jplus.plugin.intellij.psi.ApplyBlockPsiElement;
import jplus.plugin.intellij.psi.ApplyStatementPsiElement;
import jplus.plugin.intellij.psi.MethodPsiElement;
import jplus.plugin.intellij.psi.NormalClassDeclarationPsiElement;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

public class JPlusParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE =
            new IFileElementType(JPlusLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new JPlusLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new JPlusParserAdapter();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return JPlusTokenTypes.WHITESPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return JPlusTokenTypes.COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return JPlusTokenTypes.STRING_LITERALS;
    }

    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        IElementType iElementType = node.getElementType();
        if (iElementType instanceof TokenIElementType) {
            return new ANTLRPsiNode(node);
        }

        if (!(iElementType instanceof RuleIElementType)) {
            return new ANTLRPsiNode(node);
        }

        RuleIElementType ruleElementType = (RuleIElementType)iElementType;
        switch (ruleElementType.getRuleIndex()) {
            case JADEx25Parser.RULE_applyBlock:
                return new ApplyBlockPsiElement(node);
            case JADEx25Parser.RULE_applyStatement:
                return new ApplyStatementPsiElement(node);
            case JADEx25Parser.RULE_methodDeclaration:
                return new MethodPsiElement(node, ruleElementType);
            case JADEx25Parser.RULE_normalClassDeclaration:
                return new NormalClassDeclarationPsiElement(node);
        }

        return new ANTLRPsiNode(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider fileViewProvider) {
        return new JPlusFile(fileViewProvider);
    }
}
