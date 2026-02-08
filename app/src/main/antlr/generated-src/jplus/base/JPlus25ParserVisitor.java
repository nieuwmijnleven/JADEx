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
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPlus25Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPlus25ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#start_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_(JPlus25Parser.Start_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JPlus25Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JPlus25Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedMethodIdentifier(JPlus25Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeyword(JPlus25Parser.ContextualKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForTypeIdentifier(JPlus25Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus25Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JPlus25Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JPlus25Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(JPlus25Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(JPlus25Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(JPlus25Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(JPlus25Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#coit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoit(JPlus25Parser.CoitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JPlus25Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JPlus25Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(JPlus25Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(JPlus25Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(JPlus25Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(JPlus25Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JPlus25Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(JPlus25Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JPlus25Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(JPlus25Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JPlus25Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(JPlus25Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JPlus25Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(JPlus25Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(JPlus25Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(JPlus25Parser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(JPlus25Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(JPlus25Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(JPlus25Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(JPlus25Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(JPlus25Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JPlus25Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryCompilationUnit(JPlus25Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#simpleCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCompilationUnit(JPlus25Parser.SimpleCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classMemberDeclarationNoMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclarationNoMethod(JPlus25Parser.ClassMemberDeclarationNoMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularCompilationUnit(JPlus25Parser.ModularCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JPlus25Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(JPlus25Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JPlus25Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(JPlus25Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(JPlus25Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(JPlus25Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(JPlus25Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#moduleImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleImportDeclaration(JPlus25Parser.ModuleImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyDeclaration(JPlus25Parser.ApplyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(JPlus25Parser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlock(JPlus25Parser.ApplyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureList(JPlus25Parser.ApplyFeatureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeature(JPlus25Parser.ApplyFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureArgs(JPlus25Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlockEntry(JPlus25Parser.ApplyBlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JPlus25Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelClassOrInterfaceDeclaration(JPlus25Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JPlus25Parser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JPlus25Parser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JPlus25Parser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JPlus25Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(JPlus25Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(JPlus25Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JPlus25Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(JPlus25Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtends(JPlus25Parser.ClassExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassImplements(JPlus25Parser.ClassImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(JPlus25Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPermits(JPlus25Parser.ClassPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JPlus25Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JPlus25Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(JPlus25Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JPlus25Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(JPlus25Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(JPlus25Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JPlus25Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JPlus25Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JPlus25Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(JPlus25Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(JPlus25Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(JPlus25Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(JPlus25Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#uCOIT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUCOIT(JPlus25Parser.UCOITContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(JPlus25Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(JPlus25Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(JPlus25Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(JPlus25Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JPlus25Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(JPlus25Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(JPlus25Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JPlus25Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(JPlus25Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JPlus25Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JPlus25Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JPlus25Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityParameter(JPlus25Parser.VariableArityParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(JPlus25Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#throwsT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsT(JPlus25Parser.ThrowsTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(JPlus25Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(JPlus25Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JPlus25Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(JPlus25Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(JPlus25Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JPlus25Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(JPlus25Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(JPlus25Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(JPlus25Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JPlus25Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(JPlus25Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(JPlus25Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(JPlus25Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(JPlus25Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JPlus25Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(JPlus25Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(JPlus25Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(JPlus25Parser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JPlus25Parser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JPlus25Parser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JPlus25Parser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityRecordComponent(JPlus25Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentModifier(JPlus25Parser.RecordComponentModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBody(JPlus25Parser.RecordBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBodyDeclaration(JPlus25Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompactConstructorDeclaration(JPlus25Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(JPlus25Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(JPlus25Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(JPlus25Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtends(JPlus25Parser.InterfaceExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfacePermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePermits(JPlus25Parser.InterfacePermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(JPlus25Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(JPlus25Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(JPlus25Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(JPlus25Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(JPlus25Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(JPlus25Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceDeclaration(JPlus25Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceBody(JPlus25Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceMemberDeclaration(JPlus25Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementDeclaration(JPlus25Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementModifier(JPlus25Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JPlus25Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JPlus25Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(JPlus25Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(JPlus25Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JPlus25Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JPlus25Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JPlus25Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(JPlus25Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(JPlus25Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(JPlus25Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JPlus25Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(JPlus25Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JPlus25Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(JPlus25Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JPlus25Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalClassOrInterfaceDeclaration(JPlus25Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JPlus25Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#localVariableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableType(JPlus25Parser.LocalVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JPlus25Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JPlus25Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(JPlus25Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(JPlus25Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JPlus25Parser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(JPlus25Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(JPlus25Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JPlus25Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JPlus25Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(JPlus25Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(JPlus25Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(JPlus25Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(JPlus25Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JPlus25Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(JPlus25Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchRule(JPlus25Parser.SwitchRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JPlus25Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JPlus25Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#caseConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseConstant(JPlus25Parser.CaseConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#casePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasePattern(JPlus25Parser.CasePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(JPlus25Parser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JPlus25Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(JPlus25Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JPlus25Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JPlus25Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(JPlus25Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(JPlus25Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(JPlus25Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JPlus25Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JPlus25Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(JPlus25Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(JPlus25Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(JPlus25Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForDeclaration(JPlus25Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JPlus25Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JPlus25Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JPlus25Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JPlus25Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(JPlus25Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JPlus25Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(JPlus25Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JPlus25Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(JPlus25Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JPlus25Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JPlus25Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(JPlus25Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JPlus25Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(JPlus25Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JPlus25Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#variableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAccess(JPlus25Parser.VariableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JPlus25Parser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JPlus25Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePattern(JPlus25Parser.TypePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#recordPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordPattern(JPlus25Parser.RecordPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#componentPatternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPatternList(JPlus25Parser.ComponentPatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#componentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPattern(JPlus25Parser.ComponentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedPattern(JPlus25Parser.UnnamedPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JPlus25Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JPlus25Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayLiteral(JPlus25Parser.PrimaryNoNewArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayClassLiteral}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayClassLiteral(JPlus25Parser.PrimaryNoNewArrayClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayThis(JPlus25Parser.PrimaryNoNewArrayThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedThis}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedThis(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayParenExpression}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayParenExpression(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayFieldAccess(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperFieldAccess(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperFieldAccess(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayAccess(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayCreationWithInitAccess}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayCreationWithInitAccess(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayTypeMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayTypeMethodInvocation(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperMethodInvocation(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperMethodInvocation(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprMethodReference(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayMethodReference(JPlus25Parser.PrimaryNoNewArrayArrayMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayTypeMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayTypeMethodReference(JPlus25Parser.PrimaryNoNewArrayTypeMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperMethodReference(JPlus25Parser.PrimaryNoNewArraySuperMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperMethodReference(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayConstructorReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayConstructorReference}
	 * labeled alternative in {@link JPlus25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayConstructorReference(JPlus25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAClassInstanceCreation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAClassInstanceCreation(JPlus25Parser.PNNAClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAFieldAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAFieldAccess(JPlus25Parser.PNNAFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAArrayAccess}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAArrayAccess(JPlus25Parser.PNNAArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAMethodInvocation}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAMethodInvocation(JPlus25Parser.PNNAMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAMethodReference}
	 * labeled alternative in {@link JPlus25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAMethodReference(JPlus25Parser.PNNAMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(JPlus25Parser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(JPlus25Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedClassInstanceCreationExpression(JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeToInstantiate(JPlus25Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JPlus25Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(JPlus25Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithoutInitializer(JPlus25Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithInitializer(JPlus25Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(JPlus25Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(JPlus25Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(JPlus25Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(JPlus25Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(JPlus25Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(JPlus25Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(JPlus25Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(JPlus25Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#pfE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfE(JPlus25Parser.PfEContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JPlus25Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(JPlus25Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(JPlus25Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JPlus25Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(JPlus25Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(JPlus25Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JPlus25Parser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JPlus25Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JPlus25Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(JPlus25Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JPlus25Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JPlus25Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JPlus25Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(JPlus25Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(JPlus25Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(JPlus25Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(JPlus25Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpression(JPlus25Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JPlus25Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JPlus25Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JPlus25Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(JPlus25Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JPlus25Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JPlus25Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JPlus25Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(JPlus25Parser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(JPlus25Parser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterType(JPlus25Parser.LambdaParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JPlus25Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(JPlus25Parser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus25Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(JPlus25Parser.ConstantExpressionContext ctx);
}