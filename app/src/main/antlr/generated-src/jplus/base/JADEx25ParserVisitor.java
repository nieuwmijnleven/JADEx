// Generated from JADEx25Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JADEx25Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JADEx25ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#start_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_(JADEx25Parser.Start_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JADEx25Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JADEx25Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedMethodIdentifier(JADEx25Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeyword(JADEx25Parser.ContextualKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForTypeIdentifier(JADEx25Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForUnqualifiedMethodIdentifier(JADEx25Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JADEx25Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JADEx25Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(JADEx25Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(JADEx25Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(JADEx25Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(JADEx25Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#coit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoit(JADEx25Parser.CoitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JADEx25Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JADEx25Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(JADEx25Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(JADEx25Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(JADEx25Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(JADEx25Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JADEx25Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(JADEx25Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JADEx25Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(JADEx25Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JADEx25Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(JADEx25Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JADEx25Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(JADEx25Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(JADEx25Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(JADEx25Parser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(JADEx25Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(JADEx25Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(JADEx25Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(JADEx25Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(JADEx25Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JADEx25Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryCompilationUnit(JADEx25Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#simpleCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCompilationUnit(JADEx25Parser.SimpleCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classMemberDeclarationNoMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclarationNoMethod(JADEx25Parser.ClassMemberDeclarationNoMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularCompilationUnit(JADEx25Parser.ModularCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JADEx25Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(JADEx25Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JADEx25Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(JADEx25Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(JADEx25Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(JADEx25Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(JADEx25Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#moduleImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleImportDeclaration(JADEx25Parser.ModuleImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyDeclaration(JADEx25Parser.ApplyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(JADEx25Parser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlock(JADEx25Parser.ApplyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureList(JADEx25Parser.ApplyFeatureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeature(JADEx25Parser.ApplyFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureArgs(JADEx25Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlockEntry(JADEx25Parser.ApplyBlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JADEx25Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelClassOrInterfaceDeclaration(JADEx25Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JADEx25Parser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JADEx25Parser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JADEx25Parser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JADEx25Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(JADEx25Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(JADEx25Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JADEx25Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(JADEx25Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtends(JADEx25Parser.ClassExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassImplements(JADEx25Parser.ClassImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(JADEx25Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPermits(JADEx25Parser.ClassPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JADEx25Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JADEx25Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(JADEx25Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JADEx25Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(JADEx25Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(JADEx25Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JADEx25Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JADEx25Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JADEx25Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(JADEx25Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(JADEx25Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(JADEx25Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(JADEx25Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#uCOIT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUCOIT(JADEx25Parser.UCOITContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(JADEx25Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(JADEx25Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(JADEx25Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(JADEx25Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JADEx25Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(JADEx25Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(JADEx25Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JADEx25Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(JADEx25Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JADEx25Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JADEx25Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JADEx25Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityParameter(JADEx25Parser.VariableArityParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(JADEx25Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#throwsT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsT(JADEx25Parser.ThrowsTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(JADEx25Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(JADEx25Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JADEx25Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(JADEx25Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(JADEx25Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JADEx25Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(JADEx25Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(JADEx25Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(JADEx25Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JADEx25Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(JADEx25Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(JADEx25Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(JADEx25Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(JADEx25Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JADEx25Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(JADEx25Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(JADEx25Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(JADEx25Parser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JADEx25Parser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JADEx25Parser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JADEx25Parser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityRecordComponent(JADEx25Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentModifier(JADEx25Parser.RecordComponentModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBody(JADEx25Parser.RecordBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBodyDeclaration(JADEx25Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompactConstructorDeclaration(JADEx25Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(JADEx25Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(JADEx25Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(JADEx25Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtends(JADEx25Parser.InterfaceExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfacePermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePermits(JADEx25Parser.InterfacePermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(JADEx25Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(JADEx25Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(JADEx25Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(JADEx25Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(JADEx25Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(JADEx25Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceDeclaration(JADEx25Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceBody(JADEx25Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceMemberDeclaration(JADEx25Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementDeclaration(JADEx25Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementModifier(JADEx25Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JADEx25Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JADEx25Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(JADEx25Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(JADEx25Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JADEx25Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JADEx25Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JADEx25Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(JADEx25Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(JADEx25Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(JADEx25Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JADEx25Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(JADEx25Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JADEx25Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(JADEx25Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JADEx25Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalClassOrInterfaceDeclaration(JADEx25Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JADEx25Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#localVariableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableType(JADEx25Parser.LocalVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JADEx25Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JADEx25Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(JADEx25Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(JADEx25Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JADEx25Parser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(JADEx25Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(JADEx25Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JADEx25Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JADEx25Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(JADEx25Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(JADEx25Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(JADEx25Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(JADEx25Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JADEx25Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(JADEx25Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchRule(JADEx25Parser.SwitchRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JADEx25Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JADEx25Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#caseConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseConstant(JADEx25Parser.CaseConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#casePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasePattern(JADEx25Parser.CasePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(JADEx25Parser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JADEx25Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(JADEx25Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JADEx25Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JADEx25Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(JADEx25Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(JADEx25Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(JADEx25Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JADEx25Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JADEx25Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(JADEx25Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(JADEx25Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(JADEx25Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForDeclaration(JADEx25Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JADEx25Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JADEx25Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JADEx25Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JADEx25Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(JADEx25Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JADEx25Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(JADEx25Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JADEx25Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(JADEx25Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JADEx25Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JADEx25Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(JADEx25Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JADEx25Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(JADEx25Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JADEx25Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#variableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAccess(JADEx25Parser.VariableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JADEx25Parser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JADEx25Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePattern(JADEx25Parser.TypePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#recordPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordPattern(JADEx25Parser.RecordPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#componentPatternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPatternList(JADEx25Parser.ComponentPatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#componentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPattern(JADEx25Parser.ComponentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedPattern(JADEx25Parser.UnnamedPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JADEx25Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JADEx25Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayLiteral}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayLiteral(JADEx25Parser.PrimaryNoNewArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayClassLiteral}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayClassLiteral(JADEx25Parser.PrimaryNoNewArrayClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayThis}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayThis(JADEx25Parser.PrimaryNoNewArrayThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedThis}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedThis(JADEx25Parser.PrimaryNoNewArrayQualifiedThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayParenExpression}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayParenExpression(JADEx25Parser.PrimaryNoNewArrayParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayClassInstanceCreation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayClassInstanceCreation(JADEx25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprQualifiedClassInstanceCreation(JADEx25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayQualifiedClassInstanceCreation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JADEx25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayFieldAccess}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayFieldAccess(JADEx25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperFieldAccess}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperFieldAccess(JADEx25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperFieldAccess}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperFieldAccess(JADEx25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayAccess}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayAccess(JADEx25Parser.PrimaryNoNewArrayArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayCreationWithInitAccess}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayCreationWithInitAccess(JADEx25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayMethodInvocation(JADEx25Parser.PrimaryNoNewArrayMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprMethodInvocation(JADEx25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayTypeMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayTypeMethodInvocation(JADEx25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayMethodInvocation(JADEx25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperMethodInvocation(JADEx25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperMethodInvocation(JADEx25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayExprMethodReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayExprMethodReference(JADEx25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayMethodReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayMethodReference(JADEx25Parser.PrimaryNoNewArrayArrayMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayTypeMethodReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayTypeMethodReference(JADEx25Parser.PrimaryNoNewArrayTypeMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArraySuperMethodReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArraySuperMethodReference(JADEx25Parser.PrimaryNoNewArraySuperMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayQualifiedSuperMethodReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayQualifiedSuperMethodReference(JADEx25Parser.PrimaryNoNewArrayQualifiedSuperMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayConstructorReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayConstructorReference(JADEx25Parser.PrimaryNoNewArrayConstructorReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArrayArrayConstructorReference}
	 * labeled alternative in {@link JADEx25Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArrayArrayConstructorReference(JADEx25Parser.PrimaryNoNewArrayArrayConstructorReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAClassInstanceCreation}
	 * labeled alternative in {@link JADEx25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAClassInstanceCreation(JADEx25Parser.PNNAClassInstanceCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAFieldAccess}
	 * labeled alternative in {@link JADEx25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAFieldAccess(JADEx25Parser.PNNAFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAArrayAccess}
	 * labeled alternative in {@link JADEx25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAArrayAccess(JADEx25Parser.PNNAArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAMethodInvocation}
	 * labeled alternative in {@link JADEx25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAMethodInvocation(JADEx25Parser.PNNAMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pNNAMethodReference}
	 * labeled alternative in {@link JADEx25Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNAMethodReference(JADEx25Parser.PNNAMethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(JADEx25Parser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(JADEx25Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedClassInstanceCreationExpression(JADEx25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeToInstantiate(JADEx25Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JADEx25Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(JADEx25Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithoutInitializer(JADEx25Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithInitializer(JADEx25Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(JADEx25Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(JADEx25Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(JADEx25Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(JADEx25Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(JADEx25Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(JADEx25Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(JADEx25Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(JADEx25Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#pfE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfE(JADEx25Parser.PfEContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JADEx25Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(JADEx25Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(JADEx25Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JADEx25Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(JADEx25Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(JADEx25Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JADEx25Parser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JADEx25Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JADEx25Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(JADEx25Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JADEx25Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JADEx25Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JADEx25Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(JADEx25Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(JADEx25Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(JADEx25Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(JADEx25Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpression(JADEx25Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JADEx25Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JADEx25Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JADEx25Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(JADEx25Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JADEx25Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JADEx25Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JADEx25Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(JADEx25Parser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(JADEx25Parser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterType(JADEx25Parser.LambdaParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JADEx25Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(JADEx25Parser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JADEx25Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(JADEx25Parser.ConstantExpressionContext ctx);
}