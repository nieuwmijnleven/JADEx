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

// Generated from JPlus25Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JPlus25Parser}.
 */
public interface JPlus25ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#start_}.
	 * @param ctx the parse tree
	 */
	void enterStart_(JPlus25Parser.Start_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#start_}.
	 * @param ctx the parse tree
	 */
	void exitStart_(JPlus25Parser.Start_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JPlus25Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JPlus25Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(JPlus25Parser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(JPlus25Parser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedMethodIdentifier(JPlus25Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedMethodIdentifier(JPlus25Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeyword(JPlus25Parser.ContextualKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeyword(JPlus25Parser.ContextualKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForTypeIdentifier(JPlus25Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForTypeIdentifier(JPlus25Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus25Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus25Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JPlus25Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JPlus25Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(JPlus25Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(JPlus25Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(JPlus25Parser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(JPlus25Parser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(JPlus25Parser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(JPlus25Parser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(JPlus25Parser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(JPlus25Parser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(JPlus25Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(JPlus25Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#coit}.
	 * @param ctx the parse tree
	 */
	void enterCoit(JPlus25Parser.CoitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#coit}.
	 * @param ctx the parse tree
	 */
	void exitCoit(JPlus25Parser.CoitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(JPlus25Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(JPlus25Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(JPlus25Parser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(JPlus25Parser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(JPlus25Parser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(JPlus25Parser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(JPlus25Parser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(JPlus25Parser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(JPlus25Parser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(JPlus25Parser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(JPlus25Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(JPlus25Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(JPlus25Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(JPlus25Parser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(JPlus25Parser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(JPlus25Parser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(JPlus25Parser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(JPlus25Parser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(JPlus25Parser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(JPlus25Parser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(JPlus25Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(JPlus25Parser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(JPlus25Parser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(JPlus25Parser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(JPlus25Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(JPlus25Parser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(JPlus25Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(JPlus25Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(JPlus25Parser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(JPlus25Parser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void enterModuleName(JPlus25Parser.ModuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void exitModuleName(JPlus25Parser.ModuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(JPlus25Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(JPlus25Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(JPlus25Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(JPlus25Parser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(JPlus25Parser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(JPlus25Parser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(JPlus25Parser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(JPlus25Parser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(JPlus25Parser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(JPlus25Parser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JPlus25Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JPlus25Parser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterOrdinaryCompilationUnit(JPlus25Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitOrdinaryCompilationUnit(JPlus25Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#simpleCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCompilationUnit(JPlus25Parser.SimpleCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#simpleCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCompilationUnit(JPlus25Parser.SimpleCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classMemberDeclarationNoMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclarationNoMethod(JPlus25Parser.ClassMemberDeclarationNoMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classMemberDeclarationNoMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclarationNoMethod(JPlus25Parser.ClassMemberDeclarationNoMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterModularCompilationUnit(JPlus25Parser.ModularCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitModularCompilationUnit(JPlus25Parser.ModularCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JPlus25Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JPlus25Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(JPlus25Parser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(JPlus25Parser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JPlus25Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JPlus25Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(JPlus25Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(JPlus25Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(JPlus25Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(JPlus25Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(JPlus25Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(JPlus25Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(JPlus25Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(JPlus25Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#moduleImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleImportDeclaration(JPlus25Parser.ModuleImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#moduleImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleImportDeclaration(JPlus25Parser.ModuleImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterApplyDeclaration(JPlus25Parser.ApplyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitApplyDeclaration(JPlus25Parser.ApplyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplyStatement(JPlus25Parser.ApplyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplyStatement(JPlus25Parser.ApplyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlock(JPlus25Parser.ApplyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlock(JPlus25Parser.ApplyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureList(JPlus25Parser.ApplyFeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureList(JPlus25Parser.ApplyFeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeature(JPlus25Parser.ApplyFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeature(JPlus25Parser.ApplyFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureArgs(JPlus25Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureArgs(JPlus25Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlockEntry(JPlus25Parser.ApplyBlockEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlockEntry(JPlus25Parser.ApplyBlockEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JPlus25Parser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JPlus25Parser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelClassOrInterfaceDeclaration(JPlus25Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelClassOrInterfaceDeclaration(JPlus25Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(JPlus25Parser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(JPlus25Parser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(JPlus25Parser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(JPlus25Parser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(JPlus25Parser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(JPlus25Parser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JPlus25Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JPlus25Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(JPlus25Parser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(JPlus25Parser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(JPlus25Parser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(JPlus25Parser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(JPlus25Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(JPlus25Parser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(JPlus25Parser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(JPlus25Parser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassExtends(JPlus25Parser.ClassExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassExtends(JPlus25Parser.ClassExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void enterClassImplements(JPlus25Parser.ClassImplementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void exitClassImplements(JPlus25Parser.ClassImplementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(JPlus25Parser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(JPlus25Parser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void enterClassPermits(JPlus25Parser.ClassPermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void exitClassPermits(JPlus25Parser.ClassPermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JPlus25Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JPlus25Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JPlus25Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JPlus25Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(JPlus25Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(JPlus25Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JPlus25Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JPlus25Parser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(JPlus25Parser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(JPlus25Parser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(JPlus25Parser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(JPlus25Parser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JPlus25Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JPlus25Parser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JPlus25Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JPlus25Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JPlus25Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JPlus25Parser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(JPlus25Parser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(JPlus25Parser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(JPlus25Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(JPlus25Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(JPlus25Parser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(JPlus25Parser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(JPlus25Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(JPlus25Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void enterUCOIT(JPlus25Parser.UCOITContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void exitUCOIT(JPlus25Parser.UCOITContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(JPlus25Parser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(JPlus25Parser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(JPlus25Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(JPlus25Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(JPlus25Parser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(JPlus25Parser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(JPlus25Parser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(JPlus25Parser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JPlus25Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JPlus25Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(JPlus25Parser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(JPlus25Parser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(JPlus25Parser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(JPlus25Parser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(JPlus25Parser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(JPlus25Parser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(JPlus25Parser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(JPlus25Parser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(JPlus25Parser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(JPlus25Parser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JPlus25Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JPlus25Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JPlus25Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JPlus25Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityParameter(JPlus25Parser.VariableArityParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityParameter(JPlus25Parser.VariableArityParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(JPlus25Parser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(JPlus25Parser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void enterThrowsT(JPlus25Parser.ThrowsTContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void exitThrowsT(JPlus25Parser.ThrowsTContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(JPlus25Parser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(JPlus25Parser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(JPlus25Parser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(JPlus25Parser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JPlus25Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JPlus25Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(JPlus25Parser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(JPlus25Parser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(JPlus25Parser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(JPlus25Parser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JPlus25Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JPlus25Parser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(JPlus25Parser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(JPlus25Parser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(JPlus25Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(JPlus25Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(JPlus25Parser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(JPlus25Parser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(JPlus25Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(JPlus25Parser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(JPlus25Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(JPlus25Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(JPlus25Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(JPlus25Parser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(JPlus25Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(JPlus25Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(JPlus25Parser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(JPlus25Parser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(JPlus25Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(JPlus25Parser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(JPlus25Parser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(JPlus25Parser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(JPlus25Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(JPlus25Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordDeclaration(JPlus25Parser.RecordDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordDeclaration(JPlus25Parser.RecordDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(JPlus25Parser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(JPlus25Parser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(JPlus25Parser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(JPlus25Parser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(JPlus25Parser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(JPlus25Parser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityRecordComponent(JPlus25Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityRecordComponent(JPlus25Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentModifier(JPlus25Parser.RecordComponentModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentModifier(JPlus25Parser.RecordComponentModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void enterRecordBody(JPlus25Parser.RecordBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void exitRecordBody(JPlus25Parser.RecordBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordBodyDeclaration(JPlus25Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordBodyDeclaration(JPlus25Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompactConstructorDeclaration(JPlus25Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompactConstructorDeclaration(JPlus25Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(JPlus25Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(JPlus25Parser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(JPlus25Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(JPlus25Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(JPlus25Parser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(JPlus25Parser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceExtends(JPlus25Parser.InterfaceExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceExtends(JPlus25Parser.InterfaceExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void enterInterfacePermits(JPlus25Parser.InterfacePermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void exitInterfacePermits(JPlus25Parser.InterfacePermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(JPlus25Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(JPlus25Parser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(JPlus25Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(JPlus25Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(JPlus25Parser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(JPlus25Parser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(JPlus25Parser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(JPlus25Parser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(JPlus25Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(JPlus25Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(JPlus25Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(JPlus25Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceDeclaration(JPlus25Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceDeclaration(JPlus25Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceBody(JPlus25Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceBody(JPlus25Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceMemberDeclaration(JPlus25Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceMemberDeclaration(JPlus25Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementDeclaration(JPlus25Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementDeclaration(JPlus25Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementModifier(JPlus25Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementModifier(JPlus25Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(JPlus25Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(JPlus25Parser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(JPlus25Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(JPlus25Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(JPlus25Parser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(JPlus25Parser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(JPlus25Parser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(JPlus25Parser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(JPlus25Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(JPlus25Parser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JPlus25Parser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JPlus25Parser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JPlus25Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JPlus25Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(JPlus25Parser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(JPlus25Parser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(JPlus25Parser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(JPlus25Parser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(JPlus25Parser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(JPlus25Parser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JPlus25Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JPlus25Parser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(JPlus25Parser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(JPlus25Parser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JPlus25Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JPlus25Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(JPlus25Parser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(JPlus25Parser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JPlus25Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JPlus25Parser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalClassOrInterfaceDeclaration(JPlus25Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalClassOrInterfaceDeclaration(JPlus25Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JPlus25Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JPlus25Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableType(JPlus25Parser.LocalVariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableType(JPlus25Parser.LocalVariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(JPlus25Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(JPlus25Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JPlus25Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JPlus25Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(JPlus25Parser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(JPlus25Parser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(JPlus25Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(JPlus25Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JPlus25Parser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JPlus25Parser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(JPlus25Parser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(JPlus25Parser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(JPlus25Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(JPlus25Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JPlus25Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JPlus25Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JPlus25Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JPlus25Parser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(JPlus25Parser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(JPlus25Parser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(JPlus25Parser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(JPlus25Parser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(JPlus25Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(JPlus25Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(JPlus25Parser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(JPlus25Parser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JPlus25Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JPlus25Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(JPlus25Parser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(JPlus25Parser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchRule(JPlus25Parser.SwitchRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchRule(JPlus25Parser.SwitchRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(JPlus25Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(JPlus25Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(JPlus25Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(JPlus25Parser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void enterCaseConstant(JPlus25Parser.CaseConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void exitCaseConstant(JPlus25Parser.CaseConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void enterCasePattern(JPlus25Parser.CasePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void exitCasePattern(JPlus25Parser.CasePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(JPlus25Parser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(JPlus25Parser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JPlus25Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JPlus25Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(JPlus25Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(JPlus25Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JPlus25Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JPlus25Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JPlus25Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JPlus25Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(JPlus25Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(JPlus25Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(JPlus25Parser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(JPlus25Parser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(JPlus25Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(JPlus25Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JPlus25Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JPlus25Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(JPlus25Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(JPlus25Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(JPlus25Parser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(JPlus25Parser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(JPlus25Parser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(JPlus25Parser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(JPlus25Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(JPlus25Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForDeclaration(JPlus25Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForDeclaration(JPlus25Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JPlus25Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JPlus25Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JPlus25Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JPlus25Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JPlus25Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JPlus25Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JPlus25Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JPlus25Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(JPlus25Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(JPlus25Parser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JPlus25Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JPlus25Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(JPlus25Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(JPlus25Parser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JPlus25Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JPlus25Parser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(JPlus25Parser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(JPlus25Parser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JPlus25Parser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JPlus25Parser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JPlus25Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JPlus25Parser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(JPlus25Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(JPlus25Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(JPlus25Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(JPlus25Parser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(JPlus25Parser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(JPlus25Parser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(JPlus25Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(JPlus25Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableAccess(JPlus25Parser.VariableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableAccess(JPlus25Parser.VariableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JPlus25Parser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JPlus25Parser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(JPlus25Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(JPlus25Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void enterTypePattern(JPlus25Parser.TypePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void exitTypePattern(JPlus25Parser.TypePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void enterRecordPattern(JPlus25Parser.RecordPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void exitRecordPattern(JPlus25Parser.RecordPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#componentPatternList}.
	 * @param ctx the parse tree
	 */
	void enterComponentPatternList(JPlus25Parser.ComponentPatternListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#componentPatternList}.
	 * @param ctx the parse tree
	 */
	void exitComponentPatternList(JPlus25Parser.ComponentPatternListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#componentPattern}.
	 * @param ctx the parse tree
	 */
	void enterComponentPattern(JPlus25Parser.ComponentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#componentPattern}.
	 * @param ctx the parse tree
	 */
	void exitComponentPattern(JPlus25Parser.ComponentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 */
	void enterUnnamedPattern(JPlus25Parser.UnnamedPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 */
	void exitUnnamedPattern(JPlus25Parser.UnnamedPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JPlus25Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JPlus25Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JPlus25Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JPlus25Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayLiteral(JPlus25Parser.PrimaryNoNewArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayLiteral(JPlus25Parser.PrimaryNoNewArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayClassLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayClassLiteral(JPlus25Parser.PrimaryNoNewArrayClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayClassLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayClassLiteral(JPlus25Parser.PrimaryNoNewArrayClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayThis(JPlus25Parser.PrimaryNoNewArrayThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayThis(JPlus25Parser.PrimaryNoNewArrayThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayQualifiedThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayQualifiedThis(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayQualifiedThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayQualifiedThis(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayParenExpression}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayParenExpression(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayParenExpression}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayParenExpression(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayExprQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayExprQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayExprQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayExprQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayFieldAccess(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayFieldAccess(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArraySuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArraySuperFieldAccess(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArraySuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArraySuperFieldAccess(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayQualifiedSuperFieldAccess(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayQualifiedSuperFieldAccess(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayAccess(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayAccess(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayCreationWithInitAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayCreationWithInitAccess(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayCreationWithInitAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayCreationWithInitAccess(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayExprMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayExprMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayExprMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayExprMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayTypeMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayTypeMethodInvocation(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayTypeMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayTypeMethodInvocation(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArraySuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArraySuperMethodInvocation(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArraySuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArraySuperMethodInvocation(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayQualifiedSuperMethodInvocation(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayQualifiedSuperMethodInvocation(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayExprMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayExprMethodReference(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayExprMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayExprMethodReference(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayMethodReference(JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayMethodReference(JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayTypeMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayTypeMethodReference(JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayTypeMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayTypeMethodReference(JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArraySuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArraySuperMethodReference(JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArraySuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArraySuperMethodReference(JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayQualifiedSuperMethodReference(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayQualifiedSuperMethodReference(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArrayArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArrayArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArrayArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArrayArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pNNAClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNAClassInstanceCreation(JPlus25Parser.PNNAClassInstanceCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pNNAClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNAClassInstanceCreation(JPlus25Parser.PNNAClassInstanceCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pNNAFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNAFieldAccess(JPlus25Parser.PNNAFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pNNAFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNAFieldAccess(JPlus25Parser.PNNAFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pNNAArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNAArrayAccess(JPlus25Parser.PNNAArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pNNAArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNAArrayAccess(JPlus25Parser.PNNAArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pNNAMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNAMethodInvocation(JPlus25Parser.PNNAMethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pNNAMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNAMethodInvocation(JPlus25Parser.PNNAMethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pNNAMethodReference}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNAMethodReference(JPlus25Parser.PNNAMethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pNNAMethodReference}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNAMethodReference(JPlus25Parser.PNNAMethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassLiteral(JPlus25Parser.ClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassLiteral(JPlus25Parser.ClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(JPlus25Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(JPlus25Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedClassInstanceCreationExpression(JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedClassInstanceCreationExpression(JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceTypeToInstantiate(JPlus25Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceTypeToInstantiate(JPlus25Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(JPlus25Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(JPlus25Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(JPlus25Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(JPlus25Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithoutInitializer(JPlus25Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithoutInitializer(JPlus25Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithInitializer(JPlus25Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithInitializer(JPlus25Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(JPlus25Parser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(JPlus25Parser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(JPlus25Parser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(JPlus25Parser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(JPlus25Parser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(JPlus25Parser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(JPlus25Parser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(JPlus25Parser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(JPlus25Parser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(JPlus25Parser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(JPlus25Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(JPlus25Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(JPlus25Parser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(JPlus25Parser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(JPlus25Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(JPlus25Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void enterPfE(JPlus25Parser.PfEContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void exitPfE(JPlus25Parser.PfEContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JPlus25Parser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JPlus25Parser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(JPlus25Parser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(JPlus25Parser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(JPlus25Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(JPlus25Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JPlus25Parser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JPlus25Parser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(JPlus25Parser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(JPlus25Parser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(JPlus25Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(JPlus25Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(JPlus25Parser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(JPlus25Parser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JPlus25Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JPlus25Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JPlus25Parser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JPlus25Parser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(JPlus25Parser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(JPlus25Parser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JPlus25Parser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JPlus25Parser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JPlus25Parser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JPlus25Parser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(JPlus25Parser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(JPlus25Parser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(JPlus25Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(JPlus25Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(JPlus25Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(JPlus25Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(JPlus25Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(JPlus25Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(JPlus25Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(JPlus25Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullCoalescingExpression(JPlus25Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullCoalescingExpression(JPlus25Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(JPlus25Parser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(JPlus25Parser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JPlus25Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JPlus25Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JPlus25Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JPlus25Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(JPlus25Parser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(JPlus25Parser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JPlus25Parser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JPlus25Parser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(JPlus25Parser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(JPlus25Parser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(JPlus25Parser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(JPlus25Parser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(JPlus25Parser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(JPlus25Parser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(JPlus25Parser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(JPlus25Parser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterType(JPlus25Parser.LambdaParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterType(JPlus25Parser.LambdaParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(JPlus25Parser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(JPlus25Parser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpression(JPlus25Parser.SwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpression(JPlus25Parser.SwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus25Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(JPlus25Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus25Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(JPlus25Parser.ConstantExpressionContext ctx);
}