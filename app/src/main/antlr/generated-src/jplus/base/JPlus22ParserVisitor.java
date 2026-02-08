// Generated from JPlus22Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPlus22Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPlus22ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#start_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_(JPlus22Parser.Start_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JPlus22Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(JPlus22Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedMethodIdentifier(JPlus22Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeyword(JPlus22Parser.ContextualKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForTypeIdentifier(JPlus22Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus22Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JPlus22Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(JPlus22Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(JPlus22Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(JPlus22Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(JPlus22Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(JPlus22Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#coit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoit(JPlus22Parser.CoitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(JPlus22Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(JPlus22Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(JPlus22Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(JPlus22Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(JPlus22Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(JPlus22Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(JPlus22Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(JPlus22Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(JPlus22Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(JPlus22Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(JPlus22Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(JPlus22Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(JPlus22Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(JPlus22Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(JPlus22Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#moduleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleName(JPlus22Parser.ModuleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(JPlus22Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(JPlus22Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(JPlus22Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(JPlus22Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(JPlus22Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(JPlus22Parser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JPlus22Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryCompilationUnit(JPlus22Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularCompilationUnit(JPlus22Parser.ModularCompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JPlus22Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(JPlus22Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JPlus22Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(JPlus22Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(JPlus22Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(JPlus22Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(JPlus22Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyDeclaration(JPlus22Parser.ApplyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(JPlus22Parser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlock(JPlus22Parser.ApplyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureList(JPlus22Parser.ApplyFeatureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeature(JPlus22Parser.ApplyFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyFeatureArgs(JPlus22Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyBlockEntry(JPlus22Parser.ApplyBlockEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JPlus22Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelClassOrInterfaceDeclaration(JPlus22Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(JPlus22Parser.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#moduleDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDirective(JPlus22Parser.ModuleDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#requiresModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresModifier(JPlus22Parser.RequiresModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JPlus22Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(JPlus22Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(JPlus22Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(JPlus22Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(JPlus22Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtends(JPlus22Parser.ClassExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassImplements(JPlus22Parser.ClassImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(JPlus22Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPermits(JPlus22Parser.ClassPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JPlus22Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JPlus22Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(JPlus22Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JPlus22Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(JPlus22Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(JPlus22Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JPlus22Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JPlus22Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JPlus22Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(JPlus22Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(JPlus22Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(JPlus22Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(JPlus22Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#uCOIT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUCOIT(JPlus22Parser.UCOITContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(JPlus22Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(JPlus22Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(JPlus22Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(JPlus22Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JPlus22Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(JPlus22Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(JPlus22Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JPlus22Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(JPlus22Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(JPlus22Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JPlus22Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JPlus22Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityParameter(JPlus22Parser.VariableArityParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(JPlus22Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#throwsT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsT(JPlus22Parser.ThrowsTContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(JPlus22Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(JPlus22Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JPlus22Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(JPlus22Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(JPlus22Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(JPlus22Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(JPlus22Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(JPlus22Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(JPlus22Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(JPlus22Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(JPlus22Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(JPlus22Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(JPlus22Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(JPlus22Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(JPlus22Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(JPlus22Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(JPlus22Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordDeclaration(JPlus22Parser.RecordDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordHeader(JPlus22Parser.RecordHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordComponentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentList(JPlus22Parser.RecordComponentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponent(JPlus22Parser.RecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArityRecordComponent(JPlus22Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponentModifier(JPlus22Parser.RecordComponentModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBody(JPlus22Parser.RecordBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordBodyDeclaration(JPlus22Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompactConstructorDeclaration(JPlus22Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(JPlus22Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(JPlus22Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(JPlus22Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceExtends(JPlus22Parser.InterfaceExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfacePermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfacePermits(JPlus22Parser.InterfacePermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(JPlus22Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(JPlus22Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(JPlus22Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(JPlus22Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(JPlus22Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(JPlus22Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceDeclaration(JPlus22Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceBody(JPlus22Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceMemberDeclaration(JPlus22Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementDeclaration(JPlus22Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationInterfaceElementModifier(JPlus22Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(JPlus22Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(JPlus22Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(JPlus22Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(JPlus22Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(JPlus22Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JPlus22Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JPlus22Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(JPlus22Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(JPlus22Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(JPlus22Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JPlus22Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(JPlus22Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JPlus22Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(JPlus22Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JPlus22Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalClassOrInterfaceDeclaration(JPlus22Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JPlus22Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#localVariableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableType(JPlus22Parser.LocalVariableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JPlus22Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JPlus22Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(JPlus22Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(JPlus22Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JPlus22Parser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(JPlus22Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(JPlus22Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JPlus22Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JPlus22Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(JPlus22Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(JPlus22Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(JPlus22Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(JPlus22Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JPlus22Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(JPlus22Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchRule(JPlus22Parser.SwitchRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(JPlus22Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(JPlus22Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#caseConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseConstant(JPlus22Parser.CaseConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#casePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasePattern(JPlus22Parser.CasePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(JPlus22Parser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JPlus22Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(JPlus22Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JPlus22Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JPlus22Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(JPlus22Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(JPlus22Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(JPlus22Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JPlus22Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(JPlus22Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(JPlus22Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(JPlus22Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(JPlus22Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForDeclaration(JPlus22Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JPlus22Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JPlus22Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JPlus22Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JPlus22Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(JPlus22Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JPlus22Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(JPlus22Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JPlus22Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(JPlus22Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JPlus22Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JPlus22Parser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(JPlus22Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(JPlus22Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(JPlus22Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(JPlus22Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#variableAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAccess(JPlus22Parser.VariableAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JPlus22Parser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(JPlus22Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePattern(JPlus22Parser.TypePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#recordPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordPattern(JPlus22Parser.RecordPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#componentPatternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPatternList(JPlus22Parser.ComponentPatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#componentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentPattern(JPlus22Parser.ComponentPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedPattern(JPlus22Parser.UnnamedPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JPlus22Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JPlus22Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(JPlus22Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#pNNA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPNNA(JPlus22Parser.PNNAContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(JPlus22Parser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(JPlus22Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedClassInstanceCreationExpression(JPlus22Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceTypeToInstantiate(JPlus22Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(JPlus22Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(JPlus22Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithoutInitializer(JPlus22Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpressionWithInitializer(JPlus22Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(JPlus22Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(JPlus22Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(JPlus22Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(JPlus22Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(JPlus22Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(JPlus22Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(JPlus22Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(JPlus22Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#pfE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfE(JPlus22Parser.PfEContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JPlus22Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(JPlus22Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(JPlus22Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JPlus22Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(JPlus22Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(JPlus22Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JPlus22Parser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JPlus22Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JPlus22Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(JPlus22Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JPlus22Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JPlus22Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JPlus22Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(JPlus22Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(JPlus22Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(JPlus22Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(JPlus22Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpression(JPlus22Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JPlus22Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JPlus22Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JPlus22Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(JPlus22Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JPlus22Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(JPlus22Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(JPlus22Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterList(JPlus22Parser.LambdaParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(JPlus22Parser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameterType(JPlus22Parser.LambdaParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(JPlus22Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(JPlus22Parser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPlus22Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(JPlus22Parser.ConstantExpressionContext ctx);
}