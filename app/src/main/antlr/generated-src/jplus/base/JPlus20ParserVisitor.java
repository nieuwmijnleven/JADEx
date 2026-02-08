// Generated from JPlus20Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPlus20Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPlus20ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#start_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_(JPlus20Parser.Start_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JPlus20Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JPlus20Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedMethodIdentifier(JPlus20Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeyword(JPlus20Parser.ContextualKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForTypeIdentifier(JPlus20Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus20Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JPlus20Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JPlus20Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(JPlus20Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(JPlus20Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(JPlus20Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(JPlus20Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#coit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoit(JPlus20Parser.CoitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JPlus20Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JPlus20Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(JPlus20Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(JPlus20Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(JPlus20Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(JPlus20Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JPlus20Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(JPlus20Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JPlus20Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(JPlus20Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JPlus20Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(JPlus20Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JPlus20Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(JPlus20Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(JPlus20Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(JPlus20Parser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(JPlus20Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(JPlus20Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(JPlus20Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(JPlus20Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(JPlus20Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JPlus20Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryCompilationUnit(JPlus20Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularCompilationUnit(JPlus20Parser.ModularCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JPlus20Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(JPlus20Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JPlus20Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(JPlus20Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(JPlus20Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(JPlus20Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(JPlus20Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyDeclaration(JPlus20Parser.ApplyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(JPlus20Parser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlock(JPlus20Parser.ApplyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureList(JPlus20Parser.ApplyFeatureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeature(JPlus20Parser.ApplyFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureArgs(JPlus20Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlockEntry(JPlus20Parser.ApplyBlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JPlus20Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelClassOrInterfaceDeclaration(JPlus20Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JPlus20Parser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JPlus20Parser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JPlus20Parser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JPlus20Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(JPlus20Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(JPlus20Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JPlus20Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(JPlus20Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtends(JPlus20Parser.ClassExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassImplements(JPlus20Parser.ClassImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(JPlus20Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPermits(JPlus20Parser.ClassPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JPlus20Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JPlus20Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(JPlus20Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JPlus20Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(JPlus20Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(JPlus20Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JPlus20Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JPlus20Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JPlus20Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(JPlus20Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(JPlus20Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(JPlus20Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(JPlus20Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#uCOIT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUCOIT(JPlus20Parser.UCOITContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(JPlus20Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(JPlus20Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(JPlus20Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(JPlus20Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JPlus20Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(JPlus20Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(JPlus20Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JPlus20Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(JPlus20Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JPlus20Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JPlus20Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JPlus20Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityParameter(JPlus20Parser.VariableArityParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(JPlus20Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#throwsT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsT(JPlus20Parser.ThrowsTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(JPlus20Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(JPlus20Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JPlus20Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(JPlus20Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(JPlus20Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JPlus20Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(JPlus20Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(JPlus20Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(JPlus20Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JPlus20Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(JPlus20Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(JPlus20Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(JPlus20Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(JPlus20Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JPlus20Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(JPlus20Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(JPlus20Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(JPlus20Parser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JPlus20Parser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JPlus20Parser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JPlus20Parser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityRecordComponent(JPlus20Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentModifier(JPlus20Parser.RecordComponentModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBody(JPlus20Parser.RecordBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBodyDeclaration(JPlus20Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompactConstructorDeclaration(JPlus20Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(JPlus20Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(JPlus20Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(JPlus20Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtends(JPlus20Parser.InterfaceExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfacePermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePermits(JPlus20Parser.InterfacePermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(JPlus20Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(JPlus20Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(JPlus20Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(JPlus20Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(JPlus20Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(JPlus20Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceDeclaration(JPlus20Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceBody(JPlus20Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceMemberDeclaration(JPlus20Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementDeclaration(JPlus20Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementModifier(JPlus20Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JPlus20Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JPlus20Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(JPlus20Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(JPlus20Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JPlus20Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JPlus20Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JPlus20Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(JPlus20Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(JPlus20Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(JPlus20Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JPlus20Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(JPlus20Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JPlus20Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(JPlus20Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JPlus20Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalClassOrInterfaceDeclaration(JPlus20Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JPlus20Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#localVariableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableType(JPlus20Parser.LocalVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JPlus20Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JPlus20Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(JPlus20Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(JPlus20Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JPlus20Parser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(JPlus20Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(JPlus20Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JPlus20Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JPlus20Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(JPlus20Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(JPlus20Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(JPlus20Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(JPlus20Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JPlus20Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(JPlus20Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchRule(JPlus20Parser.SwitchRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JPlus20Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JPlus20Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#caseConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseConstant(JPlus20Parser.CaseConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JPlus20Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(JPlus20Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JPlus20Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JPlus20Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(JPlus20Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(JPlus20Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(JPlus20Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JPlus20Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JPlus20Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(JPlus20Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(JPlus20Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(JPlus20Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JPlus20Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JPlus20Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JPlus20Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JPlus20Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(JPlus20Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JPlus20Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(JPlus20Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JPlus20Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(JPlus20Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JPlus20Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JPlus20Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(JPlus20Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JPlus20Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(JPlus20Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JPlus20Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#variableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAccess(JPlus20Parser.VariableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JPlus20Parser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JPlus20Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePattern(JPlus20Parser.TypePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JPlus20Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JPlus20Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(JPlus20Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNA(JPlus20Parser.PNNAContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(JPlus20Parser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(JPlus20Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedClassInstanceCreationExpression(JPlus20Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeToInstantiate(JPlus20Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JPlus20Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(JPlus20Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithoutInitializer(JPlus20Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithInitializer(JPlus20Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(JPlus20Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(JPlus20Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(JPlus20Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(JPlus20Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(JPlus20Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(JPlus20Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(JPlus20Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(JPlus20Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#pfE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfE(JPlus20Parser.PfEContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JPlus20Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(JPlus20Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(JPlus20Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JPlus20Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(JPlus20Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(JPlus20Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JPlus20Parser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JPlus20Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JPlus20Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(JPlus20Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JPlus20Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JPlus20Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JPlus20Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(JPlus20Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(JPlus20Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(JPlus20Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(JPlus20Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpression(JPlus20Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JPlus20Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JPlus20Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JPlus20Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(JPlus20Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JPlus20Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JPlus20Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JPlus20Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(JPlus20Parser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(JPlus20Parser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterType(JPlus20Parser.LambdaParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JPlus20Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(JPlus20Parser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus20Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(JPlus20Parser.ConstantExpressionContext ctx);
}