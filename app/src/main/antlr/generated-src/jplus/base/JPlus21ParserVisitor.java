// Generated from JPlus21Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPlus21Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPlus21ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#start_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_(JPlus21Parser.Start_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JPlus21Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JPlus21Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedMethodIdentifier(JPlus21Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeyword(JPlus21Parser.ContextualKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForTypeIdentifier(JPlus21Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus21Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JPlus21Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JPlus21Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(JPlus21Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(JPlus21Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(JPlus21Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(JPlus21Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#coit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoit(JPlus21Parser.CoitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JPlus21Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JPlus21Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(JPlus21Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(JPlus21Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(JPlus21Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(JPlus21Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JPlus21Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(JPlus21Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JPlus21Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(JPlus21Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JPlus21Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(JPlus21Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JPlus21Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(JPlus21Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(JPlus21Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(JPlus21Parser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(JPlus21Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(JPlus21Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(JPlus21Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(JPlus21Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(JPlus21Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(JPlus21Parser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JPlus21Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryCompilationUnit(JPlus21Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularCompilationUnit(JPlus21Parser.ModularCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JPlus21Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(JPlus21Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JPlus21Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(JPlus21Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(JPlus21Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(JPlus21Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(JPlus21Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyDeclaration(JPlus21Parser.ApplyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(JPlus21Parser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlock(JPlus21Parser.ApplyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureList(JPlus21Parser.ApplyFeatureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeature(JPlus21Parser.ApplyFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureArgs(JPlus21Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlockEntry(JPlus21Parser.ApplyBlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JPlus21Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelClassOrInterfaceDeclaration(JPlus21Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JPlus21Parser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JPlus21Parser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JPlus21Parser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JPlus21Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(JPlus21Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(JPlus21Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JPlus21Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(JPlus21Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtends(JPlus21Parser.ClassExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassImplements(JPlus21Parser.ClassImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(JPlus21Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPermits(JPlus21Parser.ClassPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JPlus21Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JPlus21Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(JPlus21Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JPlus21Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(JPlus21Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(JPlus21Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JPlus21Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JPlus21Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JPlus21Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(JPlus21Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(JPlus21Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(JPlus21Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(JPlus21Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#uCOIT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUCOIT(JPlus21Parser.UCOITContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(JPlus21Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(JPlus21Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(JPlus21Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(JPlus21Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JPlus21Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(JPlus21Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(JPlus21Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JPlus21Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(JPlus21Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JPlus21Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JPlus21Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JPlus21Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityParameter(JPlus21Parser.VariableArityParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(JPlus21Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#throwsT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsT(JPlus21Parser.ThrowsTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(JPlus21Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(JPlus21Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JPlus21Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(JPlus21Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(JPlus21Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JPlus21Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(JPlus21Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(JPlus21Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(JPlus21Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JPlus21Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(JPlus21Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(JPlus21Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(JPlus21Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(JPlus21Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JPlus21Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(JPlus21Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(JPlus21Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(JPlus21Parser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JPlus21Parser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JPlus21Parser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JPlus21Parser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityRecordComponent(JPlus21Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentModifier(JPlus21Parser.RecordComponentModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBody(JPlus21Parser.RecordBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBodyDeclaration(JPlus21Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompactConstructorDeclaration(JPlus21Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(JPlus21Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(JPlus21Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(JPlus21Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtends(JPlus21Parser.InterfaceExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfacePermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePermits(JPlus21Parser.InterfacePermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(JPlus21Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(JPlus21Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(JPlus21Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(JPlus21Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(JPlus21Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(JPlus21Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceDeclaration(JPlus21Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceBody(JPlus21Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceMemberDeclaration(JPlus21Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementDeclaration(JPlus21Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementModifier(JPlus21Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JPlus21Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JPlus21Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(JPlus21Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(JPlus21Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JPlus21Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JPlus21Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JPlus21Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(JPlus21Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(JPlus21Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(JPlus21Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JPlus21Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(JPlus21Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JPlus21Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(JPlus21Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JPlus21Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalClassOrInterfaceDeclaration(JPlus21Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JPlus21Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#localVariableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableType(JPlus21Parser.LocalVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JPlus21Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JPlus21Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(JPlus21Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(JPlus21Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JPlus21Parser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(JPlus21Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(JPlus21Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JPlus21Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JPlus21Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(JPlus21Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(JPlus21Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(JPlus21Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(JPlus21Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JPlus21Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(JPlus21Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchRule(JPlus21Parser.SwitchRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JPlus21Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JPlus21Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#caseConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseConstant(JPlus21Parser.CaseConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#casePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasePattern(JPlus21Parser.CasePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(JPlus21Parser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JPlus21Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(JPlus21Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JPlus21Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JPlus21Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(JPlus21Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(JPlus21Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(JPlus21Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JPlus21Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JPlus21Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(JPlus21Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(JPlus21Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(JPlus21Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForDeclaration(JPlus21Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JPlus21Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JPlus21Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JPlus21Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JPlus21Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(JPlus21Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JPlus21Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(JPlus21Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JPlus21Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(JPlus21Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JPlus21Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JPlus21Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(JPlus21Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JPlus21Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(JPlus21Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JPlus21Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#variableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAccess(JPlus21Parser.VariableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JPlus21Parser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JPlus21Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePattern(JPlus21Parser.TypePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#recordPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordPattern(JPlus21Parser.RecordPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#patternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternList(JPlus21Parser.PatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JPlus21Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JPlus21Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(JPlus21Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNA(JPlus21Parser.PNNAContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(JPlus21Parser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(JPlus21Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedClassInstanceCreationExpression(JPlus21Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeToInstantiate(JPlus21Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JPlus21Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(JPlus21Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithoutInitializer(JPlus21Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithInitializer(JPlus21Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(JPlus21Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(JPlus21Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(JPlus21Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(JPlus21Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(JPlus21Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(JPlus21Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(JPlus21Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(JPlus21Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#pfE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfE(JPlus21Parser.PfEContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JPlus21Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(JPlus21Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(JPlus21Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JPlus21Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(JPlus21Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(JPlus21Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JPlus21Parser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JPlus21Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JPlus21Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(JPlus21Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JPlus21Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JPlus21Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JPlus21Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(JPlus21Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(JPlus21Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(JPlus21Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(JPlus21Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpression(JPlus21Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JPlus21Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JPlus21Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JPlus21Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(JPlus21Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JPlus21Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JPlus21Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JPlus21Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(JPlus21Parser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(JPlus21Parser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterType(JPlus21Parser.LambdaParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JPlus21Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(JPlus21Parser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus21Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(JPlus21Parser.ConstantExpressionContext ctx);
}