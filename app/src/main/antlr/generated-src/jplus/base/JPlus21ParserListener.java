// Generated from JPlus21Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JPlus21Parser}.
 */
public interface JPlus21ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#start_}.
	 * @param ctx the parse tree
	 */
	void enterStart_(JPlus21Parser.Start_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#start_}.
	 * @param ctx the parse tree
	 */
	void exitStart_(JPlus21Parser.Start_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JPlus21Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JPlus21Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(JPlus21Parser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(JPlus21Parser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedMethodIdentifier(JPlus21Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedMethodIdentifier(JPlus21Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeyword(JPlus21Parser.ContextualKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeyword(JPlus21Parser.ContextualKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForTypeIdentifier(JPlus21Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForTypeIdentifier(JPlus21Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus21Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus21Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JPlus21Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JPlus21Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(JPlus21Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(JPlus21Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(JPlus21Parser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(JPlus21Parser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(JPlus21Parser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(JPlus21Parser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(JPlus21Parser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(JPlus21Parser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(JPlus21Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(JPlus21Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#coit}.
	 * @param ctx the parse tree
	 */
	void enterCoit(JPlus21Parser.CoitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#coit}.
	 * @param ctx the parse tree
	 */
	void exitCoit(JPlus21Parser.CoitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(JPlus21Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(JPlus21Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(JPlus21Parser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(JPlus21Parser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(JPlus21Parser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(JPlus21Parser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(JPlus21Parser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(JPlus21Parser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(JPlus21Parser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(JPlus21Parser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(JPlus21Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(JPlus21Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(JPlus21Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(JPlus21Parser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(JPlus21Parser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(JPlus21Parser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(JPlus21Parser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(JPlus21Parser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(JPlus21Parser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(JPlus21Parser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(JPlus21Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(JPlus21Parser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(JPlus21Parser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(JPlus21Parser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(JPlus21Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(JPlus21Parser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(JPlus21Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(JPlus21Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(JPlus21Parser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(JPlus21Parser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void enterModuleName(JPlus21Parser.ModuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void exitModuleName(JPlus21Parser.ModuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(JPlus21Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(JPlus21Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(JPlus21Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(JPlus21Parser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(JPlus21Parser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(JPlus21Parser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(JPlus21Parser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(JPlus21Parser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(JPlus21Parser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(JPlus21Parser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(JPlus21Parser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(JPlus21Parser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JPlus21Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JPlus21Parser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterOrdinaryCompilationUnit(JPlus21Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitOrdinaryCompilationUnit(JPlus21Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterModularCompilationUnit(JPlus21Parser.ModularCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitModularCompilationUnit(JPlus21Parser.ModularCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JPlus21Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JPlus21Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(JPlus21Parser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(JPlus21Parser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JPlus21Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JPlus21Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(JPlus21Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(JPlus21Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(JPlus21Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(JPlus21Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(JPlus21Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(JPlus21Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(JPlus21Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(JPlus21Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterApplyDeclaration(JPlus21Parser.ApplyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitApplyDeclaration(JPlus21Parser.ApplyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplyStatement(JPlus21Parser.ApplyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplyStatement(JPlus21Parser.ApplyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlock(JPlus21Parser.ApplyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlock(JPlus21Parser.ApplyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureList(JPlus21Parser.ApplyFeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureList(JPlus21Parser.ApplyFeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeature(JPlus21Parser.ApplyFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeature(JPlus21Parser.ApplyFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureArgs(JPlus21Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureArgs(JPlus21Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlockEntry(JPlus21Parser.ApplyBlockEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlockEntry(JPlus21Parser.ApplyBlockEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JPlus21Parser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JPlus21Parser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelClassOrInterfaceDeclaration(JPlus21Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelClassOrInterfaceDeclaration(JPlus21Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(JPlus21Parser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(JPlus21Parser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(JPlus21Parser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(JPlus21Parser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(JPlus21Parser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(JPlus21Parser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JPlus21Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JPlus21Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(JPlus21Parser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(JPlus21Parser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(JPlus21Parser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(JPlus21Parser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(JPlus21Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(JPlus21Parser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(JPlus21Parser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(JPlus21Parser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassExtends(JPlus21Parser.ClassExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassExtends(JPlus21Parser.ClassExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void enterClassImplements(JPlus21Parser.ClassImplementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void exitClassImplements(JPlus21Parser.ClassImplementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(JPlus21Parser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(JPlus21Parser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void enterClassPermits(JPlus21Parser.ClassPermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void exitClassPermits(JPlus21Parser.ClassPermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JPlus21Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JPlus21Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JPlus21Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JPlus21Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(JPlus21Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(JPlus21Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JPlus21Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JPlus21Parser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(JPlus21Parser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(JPlus21Parser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(JPlus21Parser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(JPlus21Parser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JPlus21Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JPlus21Parser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JPlus21Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JPlus21Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JPlus21Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JPlus21Parser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(JPlus21Parser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(JPlus21Parser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(JPlus21Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(JPlus21Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(JPlus21Parser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(JPlus21Parser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(JPlus21Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(JPlus21Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void enterUCOIT(JPlus21Parser.UCOITContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void exitUCOIT(JPlus21Parser.UCOITContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(JPlus21Parser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(JPlus21Parser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(JPlus21Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(JPlus21Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(JPlus21Parser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(JPlus21Parser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(JPlus21Parser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(JPlus21Parser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JPlus21Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JPlus21Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(JPlus21Parser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(JPlus21Parser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(JPlus21Parser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(JPlus21Parser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(JPlus21Parser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(JPlus21Parser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(JPlus21Parser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(JPlus21Parser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(JPlus21Parser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(JPlus21Parser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JPlus21Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JPlus21Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JPlus21Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JPlus21Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityParameter(JPlus21Parser.VariableArityParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityParameter(JPlus21Parser.VariableArityParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(JPlus21Parser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(JPlus21Parser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void enterThrowsT(JPlus21Parser.ThrowsTContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void exitThrowsT(JPlus21Parser.ThrowsTContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(JPlus21Parser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(JPlus21Parser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(JPlus21Parser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(JPlus21Parser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JPlus21Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JPlus21Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(JPlus21Parser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(JPlus21Parser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(JPlus21Parser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(JPlus21Parser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JPlus21Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JPlus21Parser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(JPlus21Parser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(JPlus21Parser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(JPlus21Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(JPlus21Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(JPlus21Parser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(JPlus21Parser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(JPlus21Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(JPlus21Parser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(JPlus21Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(JPlus21Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(JPlus21Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(JPlus21Parser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(JPlus21Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(JPlus21Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(JPlus21Parser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(JPlus21Parser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(JPlus21Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(JPlus21Parser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(JPlus21Parser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(JPlus21Parser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(JPlus21Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(JPlus21Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordDeclaration(JPlus21Parser.RecordDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordDeclaration(JPlus21Parser.RecordDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(JPlus21Parser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(JPlus21Parser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(JPlus21Parser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(JPlus21Parser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(JPlus21Parser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(JPlus21Parser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityRecordComponent(JPlus21Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityRecordComponent(JPlus21Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentModifier(JPlus21Parser.RecordComponentModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentModifier(JPlus21Parser.RecordComponentModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void enterRecordBody(JPlus21Parser.RecordBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void exitRecordBody(JPlus21Parser.RecordBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordBodyDeclaration(JPlus21Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordBodyDeclaration(JPlus21Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompactConstructorDeclaration(JPlus21Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompactConstructorDeclaration(JPlus21Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(JPlus21Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(JPlus21Parser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(JPlus21Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(JPlus21Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(JPlus21Parser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(JPlus21Parser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceExtends(JPlus21Parser.InterfaceExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceExtends(JPlus21Parser.InterfaceExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void enterInterfacePermits(JPlus21Parser.InterfacePermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void exitInterfacePermits(JPlus21Parser.InterfacePermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(JPlus21Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(JPlus21Parser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(JPlus21Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(JPlus21Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(JPlus21Parser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(JPlus21Parser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(JPlus21Parser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(JPlus21Parser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(JPlus21Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(JPlus21Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(JPlus21Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(JPlus21Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceDeclaration(JPlus21Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceDeclaration(JPlus21Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceBody(JPlus21Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceBody(JPlus21Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceMemberDeclaration(JPlus21Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceMemberDeclaration(JPlus21Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementDeclaration(JPlus21Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementDeclaration(JPlus21Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementModifier(JPlus21Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementModifier(JPlus21Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(JPlus21Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(JPlus21Parser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(JPlus21Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(JPlus21Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(JPlus21Parser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(JPlus21Parser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(JPlus21Parser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(JPlus21Parser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(JPlus21Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(JPlus21Parser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JPlus21Parser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JPlus21Parser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JPlus21Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JPlus21Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(JPlus21Parser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(JPlus21Parser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(JPlus21Parser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(JPlus21Parser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(JPlus21Parser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(JPlus21Parser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JPlus21Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JPlus21Parser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(JPlus21Parser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(JPlus21Parser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JPlus21Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JPlus21Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(JPlus21Parser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(JPlus21Parser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JPlus21Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JPlus21Parser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalClassOrInterfaceDeclaration(JPlus21Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalClassOrInterfaceDeclaration(JPlus21Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JPlus21Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JPlus21Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableType(JPlus21Parser.LocalVariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableType(JPlus21Parser.LocalVariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(JPlus21Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(JPlus21Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JPlus21Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JPlus21Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(JPlus21Parser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(JPlus21Parser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(JPlus21Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(JPlus21Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JPlus21Parser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JPlus21Parser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(JPlus21Parser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(JPlus21Parser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(JPlus21Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(JPlus21Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JPlus21Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JPlus21Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JPlus21Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JPlus21Parser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(JPlus21Parser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(JPlus21Parser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(JPlus21Parser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(JPlus21Parser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(JPlus21Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(JPlus21Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(JPlus21Parser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(JPlus21Parser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JPlus21Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JPlus21Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(JPlus21Parser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(JPlus21Parser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchRule(JPlus21Parser.SwitchRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchRule(JPlus21Parser.SwitchRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(JPlus21Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(JPlus21Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(JPlus21Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(JPlus21Parser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void enterCaseConstant(JPlus21Parser.CaseConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void exitCaseConstant(JPlus21Parser.CaseConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void enterCasePattern(JPlus21Parser.CasePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void exitCasePattern(JPlus21Parser.CasePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(JPlus21Parser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(JPlus21Parser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JPlus21Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JPlus21Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(JPlus21Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(JPlus21Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JPlus21Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JPlus21Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JPlus21Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JPlus21Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(JPlus21Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(JPlus21Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(JPlus21Parser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(JPlus21Parser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(JPlus21Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(JPlus21Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JPlus21Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JPlus21Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(JPlus21Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(JPlus21Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(JPlus21Parser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(JPlus21Parser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(JPlus21Parser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(JPlus21Parser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(JPlus21Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(JPlus21Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForDeclaration(JPlus21Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForDeclaration(JPlus21Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JPlus21Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JPlus21Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JPlus21Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JPlus21Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JPlus21Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JPlus21Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JPlus21Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JPlus21Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(JPlus21Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(JPlus21Parser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JPlus21Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JPlus21Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(JPlus21Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(JPlus21Parser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JPlus21Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JPlus21Parser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(JPlus21Parser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(JPlus21Parser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JPlus21Parser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JPlus21Parser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JPlus21Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JPlus21Parser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(JPlus21Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(JPlus21Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(JPlus21Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(JPlus21Parser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(JPlus21Parser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(JPlus21Parser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(JPlus21Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(JPlus21Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableAccess(JPlus21Parser.VariableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableAccess(JPlus21Parser.VariableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JPlus21Parser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JPlus21Parser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(JPlus21Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(JPlus21Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void enterTypePattern(JPlus21Parser.TypePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void exitTypePattern(JPlus21Parser.TypePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void enterRecordPattern(JPlus21Parser.RecordPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void exitRecordPattern(JPlus21Parser.RecordPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#patternList}.
	 * @param ctx the parse tree
	 */
	void enterPatternList(JPlus21Parser.PatternListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#patternList}.
	 * @param ctx the parse tree
	 */
	void exitPatternList(JPlus21Parser.PatternListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JPlus21Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JPlus21Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JPlus21Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JPlus21Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(JPlus21Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(JPlus21Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNA(JPlus21Parser.PNNAContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNA(JPlus21Parser.PNNAContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassLiteral(JPlus21Parser.ClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassLiteral(JPlus21Parser.ClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(JPlus21Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(JPlus21Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedClassInstanceCreationExpression(JPlus21Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedClassInstanceCreationExpression(JPlus21Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceTypeToInstantiate(JPlus21Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceTypeToInstantiate(JPlus21Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(JPlus21Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(JPlus21Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(JPlus21Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(JPlus21Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithoutInitializer(JPlus21Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithoutInitializer(JPlus21Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithInitializer(JPlus21Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithInitializer(JPlus21Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(JPlus21Parser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(JPlus21Parser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(JPlus21Parser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(JPlus21Parser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(JPlus21Parser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(JPlus21Parser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(JPlus21Parser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(JPlus21Parser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(JPlus21Parser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(JPlus21Parser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(JPlus21Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(JPlus21Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(JPlus21Parser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(JPlus21Parser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(JPlus21Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(JPlus21Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void enterPfE(JPlus21Parser.PfEContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void exitPfE(JPlus21Parser.PfEContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JPlus21Parser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JPlus21Parser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(JPlus21Parser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(JPlus21Parser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(JPlus21Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(JPlus21Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JPlus21Parser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JPlus21Parser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(JPlus21Parser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(JPlus21Parser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(JPlus21Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(JPlus21Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(JPlus21Parser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(JPlus21Parser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JPlus21Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JPlus21Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JPlus21Parser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JPlus21Parser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(JPlus21Parser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(JPlus21Parser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JPlus21Parser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JPlus21Parser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JPlus21Parser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JPlus21Parser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(JPlus21Parser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(JPlus21Parser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(JPlus21Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(JPlus21Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(JPlus21Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(JPlus21Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(JPlus21Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(JPlus21Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(JPlus21Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(JPlus21Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullCoalescingExpression(JPlus21Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullCoalescingExpression(JPlus21Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(JPlus21Parser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(JPlus21Parser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JPlus21Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JPlus21Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JPlus21Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JPlus21Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(JPlus21Parser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(JPlus21Parser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JPlus21Parser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JPlus21Parser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(JPlus21Parser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(JPlus21Parser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(JPlus21Parser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(JPlus21Parser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(JPlus21Parser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(JPlus21Parser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(JPlus21Parser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(JPlus21Parser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterType(JPlus21Parser.LambdaParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterType(JPlus21Parser.LambdaParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(JPlus21Parser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(JPlus21Parser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpression(JPlus21Parser.SwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpression(JPlus21Parser.SwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus21Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(JPlus21Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus21Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(JPlus21Parser.ConstantExpressionContext ctx);
}