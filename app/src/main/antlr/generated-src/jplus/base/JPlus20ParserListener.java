// Generated from JPlus20Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JPlus20Parser}.
 */
public interface JPlus20ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#start_}.
	 * @param ctx the parse tree
	 */
	void enterStart_(JPlus20Parser.Start_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#start_}.
	 * @param ctx the parse tree
	 */
	void exitStart_(JPlus20Parser.Start_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JPlus20Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JPlus20Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(JPlus20Parser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(JPlus20Parser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedMethodIdentifier(JPlus20Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedMethodIdentifier(JPlus20Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeyword(JPlus20Parser.ContextualKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeyword(JPlus20Parser.ContextualKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForTypeIdentifier(JPlus20Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForTypeIdentifier(JPlus20Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus20Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus20Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JPlus20Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JPlus20Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(JPlus20Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(JPlus20Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(JPlus20Parser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(JPlus20Parser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(JPlus20Parser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(JPlus20Parser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(JPlus20Parser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(JPlus20Parser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(JPlus20Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(JPlus20Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#coit}.
	 * @param ctx the parse tree
	 */
	void enterCoit(JPlus20Parser.CoitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#coit}.
	 * @param ctx the parse tree
	 */
	void exitCoit(JPlus20Parser.CoitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(JPlus20Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(JPlus20Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(JPlus20Parser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(JPlus20Parser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(JPlus20Parser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(JPlus20Parser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(JPlus20Parser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(JPlus20Parser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(JPlus20Parser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(JPlus20Parser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(JPlus20Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(JPlus20Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(JPlus20Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(JPlus20Parser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(JPlus20Parser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(JPlus20Parser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(JPlus20Parser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(JPlus20Parser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(JPlus20Parser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(JPlus20Parser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(JPlus20Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(JPlus20Parser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(JPlus20Parser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(JPlus20Parser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(JPlus20Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(JPlus20Parser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(JPlus20Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(JPlus20Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(JPlus20Parser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(JPlus20Parser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void enterModuleName(JPlus20Parser.ModuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void exitModuleName(JPlus20Parser.ModuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(JPlus20Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(JPlus20Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(JPlus20Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(JPlus20Parser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(JPlus20Parser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(JPlus20Parser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(JPlus20Parser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(JPlus20Parser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(JPlus20Parser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(JPlus20Parser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JPlus20Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JPlus20Parser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterOrdinaryCompilationUnit(JPlus20Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitOrdinaryCompilationUnit(JPlus20Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterModularCompilationUnit(JPlus20Parser.ModularCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitModularCompilationUnit(JPlus20Parser.ModularCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JPlus20Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JPlus20Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(JPlus20Parser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(JPlus20Parser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JPlus20Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JPlus20Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(JPlus20Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(JPlus20Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(JPlus20Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(JPlus20Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(JPlus20Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(JPlus20Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(JPlus20Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(JPlus20Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterApplyDeclaration(JPlus20Parser.ApplyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitApplyDeclaration(JPlus20Parser.ApplyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplyStatement(JPlus20Parser.ApplyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplyStatement(JPlus20Parser.ApplyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlock(JPlus20Parser.ApplyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlock(JPlus20Parser.ApplyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureList(JPlus20Parser.ApplyFeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureList(JPlus20Parser.ApplyFeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeature(JPlus20Parser.ApplyFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeature(JPlus20Parser.ApplyFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureArgs(JPlus20Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureArgs(JPlus20Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlockEntry(JPlus20Parser.ApplyBlockEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlockEntry(JPlus20Parser.ApplyBlockEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JPlus20Parser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JPlus20Parser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelClassOrInterfaceDeclaration(JPlus20Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelClassOrInterfaceDeclaration(JPlus20Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(JPlus20Parser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(JPlus20Parser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(JPlus20Parser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(JPlus20Parser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(JPlus20Parser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(JPlus20Parser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JPlus20Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JPlus20Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(JPlus20Parser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(JPlus20Parser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(JPlus20Parser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(JPlus20Parser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(JPlus20Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(JPlus20Parser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(JPlus20Parser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(JPlus20Parser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassExtends(JPlus20Parser.ClassExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassExtends(JPlus20Parser.ClassExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void enterClassImplements(JPlus20Parser.ClassImplementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void exitClassImplements(JPlus20Parser.ClassImplementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(JPlus20Parser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(JPlus20Parser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void enterClassPermits(JPlus20Parser.ClassPermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void exitClassPermits(JPlus20Parser.ClassPermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JPlus20Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JPlus20Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JPlus20Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JPlus20Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(JPlus20Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(JPlus20Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JPlus20Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JPlus20Parser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(JPlus20Parser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(JPlus20Parser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(JPlus20Parser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(JPlus20Parser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JPlus20Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JPlus20Parser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JPlus20Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JPlus20Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JPlus20Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JPlus20Parser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(JPlus20Parser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(JPlus20Parser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(JPlus20Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(JPlus20Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(JPlus20Parser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(JPlus20Parser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(JPlus20Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(JPlus20Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void enterUCOIT(JPlus20Parser.UCOITContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void exitUCOIT(JPlus20Parser.UCOITContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(JPlus20Parser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(JPlus20Parser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(JPlus20Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(JPlus20Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(JPlus20Parser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(JPlus20Parser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(JPlus20Parser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(JPlus20Parser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JPlus20Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JPlus20Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(JPlus20Parser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(JPlus20Parser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(JPlus20Parser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(JPlus20Parser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(JPlus20Parser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(JPlus20Parser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(JPlus20Parser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(JPlus20Parser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(JPlus20Parser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(JPlus20Parser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JPlus20Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JPlus20Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JPlus20Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JPlus20Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityParameter(JPlus20Parser.VariableArityParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityParameter(JPlus20Parser.VariableArityParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(JPlus20Parser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(JPlus20Parser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void enterThrowsT(JPlus20Parser.ThrowsTContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void exitThrowsT(JPlus20Parser.ThrowsTContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(JPlus20Parser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(JPlus20Parser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(JPlus20Parser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(JPlus20Parser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JPlus20Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JPlus20Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(JPlus20Parser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(JPlus20Parser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(JPlus20Parser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(JPlus20Parser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JPlus20Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JPlus20Parser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(JPlus20Parser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(JPlus20Parser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(JPlus20Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(JPlus20Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(JPlus20Parser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(JPlus20Parser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(JPlus20Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(JPlus20Parser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(JPlus20Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(JPlus20Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(JPlus20Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(JPlus20Parser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(JPlus20Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(JPlus20Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(JPlus20Parser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(JPlus20Parser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(JPlus20Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(JPlus20Parser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(JPlus20Parser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(JPlus20Parser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(JPlus20Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(JPlus20Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordDeclaration(JPlus20Parser.RecordDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordDeclaration(JPlus20Parser.RecordDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(JPlus20Parser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(JPlus20Parser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(JPlus20Parser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(JPlus20Parser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(JPlus20Parser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(JPlus20Parser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityRecordComponent(JPlus20Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityRecordComponent(JPlus20Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentModifier(JPlus20Parser.RecordComponentModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentModifier(JPlus20Parser.RecordComponentModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void enterRecordBody(JPlus20Parser.RecordBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void exitRecordBody(JPlus20Parser.RecordBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordBodyDeclaration(JPlus20Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordBodyDeclaration(JPlus20Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompactConstructorDeclaration(JPlus20Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompactConstructorDeclaration(JPlus20Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(JPlus20Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(JPlus20Parser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(JPlus20Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(JPlus20Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(JPlus20Parser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(JPlus20Parser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceExtends(JPlus20Parser.InterfaceExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceExtends(JPlus20Parser.InterfaceExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void enterInterfacePermits(JPlus20Parser.InterfacePermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void exitInterfacePermits(JPlus20Parser.InterfacePermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(JPlus20Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(JPlus20Parser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(JPlus20Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(JPlus20Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(JPlus20Parser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(JPlus20Parser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(JPlus20Parser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(JPlus20Parser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(JPlus20Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(JPlus20Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(JPlus20Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(JPlus20Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceDeclaration(JPlus20Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceDeclaration(JPlus20Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceBody(JPlus20Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceBody(JPlus20Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceMemberDeclaration(JPlus20Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceMemberDeclaration(JPlus20Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementDeclaration(JPlus20Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementDeclaration(JPlus20Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementModifier(JPlus20Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementModifier(JPlus20Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(JPlus20Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(JPlus20Parser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(JPlus20Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(JPlus20Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(JPlus20Parser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(JPlus20Parser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(JPlus20Parser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(JPlus20Parser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(JPlus20Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(JPlus20Parser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JPlus20Parser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JPlus20Parser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JPlus20Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JPlus20Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(JPlus20Parser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(JPlus20Parser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(JPlus20Parser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(JPlus20Parser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(JPlus20Parser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(JPlus20Parser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JPlus20Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JPlus20Parser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(JPlus20Parser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(JPlus20Parser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JPlus20Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JPlus20Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(JPlus20Parser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(JPlus20Parser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JPlus20Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JPlus20Parser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalClassOrInterfaceDeclaration(JPlus20Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalClassOrInterfaceDeclaration(JPlus20Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JPlus20Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JPlus20Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableType(JPlus20Parser.LocalVariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableType(JPlus20Parser.LocalVariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(JPlus20Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(JPlus20Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JPlus20Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JPlus20Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(JPlus20Parser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(JPlus20Parser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(JPlus20Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(JPlus20Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JPlus20Parser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JPlus20Parser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(JPlus20Parser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(JPlus20Parser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(JPlus20Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(JPlus20Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JPlus20Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JPlus20Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JPlus20Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JPlus20Parser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(JPlus20Parser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(JPlus20Parser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(JPlus20Parser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(JPlus20Parser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(JPlus20Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(JPlus20Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(JPlus20Parser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(JPlus20Parser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JPlus20Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JPlus20Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(JPlus20Parser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(JPlus20Parser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchRule(JPlus20Parser.SwitchRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchRule(JPlus20Parser.SwitchRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(JPlus20Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(JPlus20Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(JPlus20Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(JPlus20Parser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void enterCaseConstant(JPlus20Parser.CaseConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void exitCaseConstant(JPlus20Parser.CaseConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JPlus20Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JPlus20Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(JPlus20Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(JPlus20Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JPlus20Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JPlus20Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JPlus20Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JPlus20Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(JPlus20Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(JPlus20Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(JPlus20Parser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(JPlus20Parser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(JPlus20Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(JPlus20Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JPlus20Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JPlus20Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(JPlus20Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(JPlus20Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(JPlus20Parser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(JPlus20Parser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(JPlus20Parser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(JPlus20Parser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(JPlus20Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(JPlus20Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JPlus20Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JPlus20Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JPlus20Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JPlus20Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JPlus20Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JPlus20Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JPlus20Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JPlus20Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(JPlus20Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(JPlus20Parser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JPlus20Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JPlus20Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(JPlus20Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(JPlus20Parser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JPlus20Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JPlus20Parser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(JPlus20Parser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(JPlus20Parser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JPlus20Parser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JPlus20Parser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JPlus20Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JPlus20Parser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(JPlus20Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(JPlus20Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(JPlus20Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(JPlus20Parser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(JPlus20Parser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(JPlus20Parser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(JPlus20Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(JPlus20Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableAccess(JPlus20Parser.VariableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableAccess(JPlus20Parser.VariableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JPlus20Parser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JPlus20Parser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(JPlus20Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(JPlus20Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void enterTypePattern(JPlus20Parser.TypePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void exitTypePattern(JPlus20Parser.TypePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JPlus20Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JPlus20Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JPlus20Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JPlus20Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(JPlus20Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(JPlus20Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNA(JPlus20Parser.PNNAContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNA(JPlus20Parser.PNNAContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassLiteral(JPlus20Parser.ClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassLiteral(JPlus20Parser.ClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(JPlus20Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(JPlus20Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedClassInstanceCreationExpression(JPlus20Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedClassInstanceCreationExpression(JPlus20Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceTypeToInstantiate(JPlus20Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceTypeToInstantiate(JPlus20Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(JPlus20Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(JPlus20Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(JPlus20Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(JPlus20Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithoutInitializer(JPlus20Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithoutInitializer(JPlus20Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithInitializer(JPlus20Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithInitializer(JPlus20Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(JPlus20Parser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(JPlus20Parser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(JPlus20Parser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(JPlus20Parser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(JPlus20Parser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(JPlus20Parser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(JPlus20Parser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(JPlus20Parser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(JPlus20Parser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(JPlus20Parser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(JPlus20Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(JPlus20Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(JPlus20Parser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(JPlus20Parser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(JPlus20Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(JPlus20Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void enterPfE(JPlus20Parser.PfEContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void exitPfE(JPlus20Parser.PfEContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JPlus20Parser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JPlus20Parser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(JPlus20Parser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(JPlus20Parser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(JPlus20Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(JPlus20Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JPlus20Parser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JPlus20Parser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(JPlus20Parser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(JPlus20Parser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(JPlus20Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(JPlus20Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(JPlus20Parser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(JPlus20Parser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JPlus20Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JPlus20Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JPlus20Parser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JPlus20Parser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(JPlus20Parser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(JPlus20Parser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JPlus20Parser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JPlus20Parser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JPlus20Parser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JPlus20Parser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(JPlus20Parser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(JPlus20Parser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(JPlus20Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(JPlus20Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(JPlus20Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(JPlus20Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(JPlus20Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(JPlus20Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(JPlus20Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(JPlus20Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullCoalescingExpression(JPlus20Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullCoalescingExpression(JPlus20Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(JPlus20Parser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(JPlus20Parser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JPlus20Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JPlus20Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JPlus20Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JPlus20Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(JPlus20Parser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(JPlus20Parser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JPlus20Parser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JPlus20Parser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(JPlus20Parser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(JPlus20Parser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(JPlus20Parser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(JPlus20Parser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(JPlus20Parser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(JPlus20Parser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(JPlus20Parser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(JPlus20Parser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterType(JPlus20Parser.LambdaParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterType(JPlus20Parser.LambdaParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(JPlus20Parser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(JPlus20Parser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpression(JPlus20Parser.SwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpression(JPlus20Parser.SwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus20Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(JPlus20Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus20Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(JPlus20Parser.ConstantExpressionContext ctx);
}