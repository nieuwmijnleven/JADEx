// Generated from JPlus22Parser.g4 by ANTLR 4.12.0
package jplus.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JPlus22Parser}.
 */
public interface JPlus22ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#start_}.
	 * @param ctx the parse tree
	 */
	void enterStart_(JPlus22Parser.Start_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#start_}.
	 * @param ctx the parse tree
	 */
	void exitStart_(JPlus22Parser.Start_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JPlus22Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JPlus22Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(JPlus22Parser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(JPlus22Parser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedMethodIdentifier(JPlus22Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedMethodIdentifier(JPlus22Parser.UnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeyword(JPlus22Parser.ContextualKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#contextualKeyword}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeyword(JPlus22Parser.ContextualKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForTypeIdentifier(JPlus22Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForTypeIdentifier(JPlus22Parser.ContextualKeywordMinusForTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus22Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#contextualKeywordMinusForUnqualifiedMethodIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitContextualKeywordMinusForUnqualifiedMethodIdentifier(JPlus22Parser.ContextualKeywordMinusForUnqualifiedMethodIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JPlus22Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JPlus22Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(JPlus22Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(JPlus22Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(JPlus22Parser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(JPlus22Parser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(JPlus22Parser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(JPlus22Parser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(JPlus22Parser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(JPlus22Parser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(JPlus22Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(JPlus22Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#coit}.
	 * @param ctx the parse tree
	 */
	void enterCoit(JPlus22Parser.CoitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#coit}.
	 * @param ctx the parse tree
	 */
	void exitCoit(JPlus22Parser.CoitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(JPlus22Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(JPlus22Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(JPlus22Parser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(JPlus22Parser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(JPlus22Parser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(JPlus22Parser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(JPlus22Parser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(JPlus22Parser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(JPlus22Parser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(JPlus22Parser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(JPlus22Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(JPlus22Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(JPlus22Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(JPlus22Parser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(JPlus22Parser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(JPlus22Parser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(JPlus22Parser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(JPlus22Parser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(JPlus22Parser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(JPlus22Parser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(JPlus22Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(JPlus22Parser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(JPlus22Parser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(JPlus22Parser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(JPlus22Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(JPlus22Parser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(JPlus22Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(JPlus22Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(JPlus22Parser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(JPlus22Parser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void enterModuleName(JPlus22Parser.ModuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#moduleName}.
	 * @param ctx the parse tree
	 */
	void exitModuleName(JPlus22Parser.ModuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(JPlus22Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(JPlus22Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(JPlus22Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(JPlus22Parser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(JPlus22Parser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(JPlus22Parser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(JPlus22Parser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(JPlus22Parser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(JPlus22Parser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(JPlus22Parser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(JPlus22Parser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(JPlus22Parser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JPlus22Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JPlus22Parser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterOrdinaryCompilationUnit(JPlus22Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#ordinaryCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitOrdinaryCompilationUnit(JPlus22Parser.OrdinaryCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterModularCompilationUnit(JPlus22Parser.ModularCompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#modularCompilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitModularCompilationUnit(JPlus22Parser.ModularCompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JPlus22Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JPlus22Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(JPlus22Parser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(JPlus22Parser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JPlus22Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JPlus22Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(JPlus22Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(JPlus22Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(JPlus22Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(JPlus22Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(JPlus22Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(JPlus22Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(JPlus22Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(JPlus22Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterApplyDeclaration(JPlus22Parser.ApplyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitApplyDeclaration(JPlus22Parser.ApplyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplyStatement(JPlus22Parser.ApplyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplyStatement(JPlus22Parser.ApplyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlock(JPlus22Parser.ApplyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyBlock}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlock(JPlus22Parser.ApplyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureList(JPlus22Parser.ApplyFeatureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyFeatureList}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureList(JPlus22Parser.ApplyFeatureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeature(JPlus22Parser.ApplyFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyFeature}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeature(JPlus22Parser.ApplyFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void enterApplyFeatureArgs(JPlus22Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyFeatureArgs}.
	 * @param ctx the parse tree
	 */
	void exitApplyFeatureArgs(JPlus22Parser.ApplyFeatureArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void enterApplyBlockEntry(JPlus22Parser.ApplyBlockEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#applyBlockEntry}.
	 * @param ctx the parse tree
	 */
	void exitApplyBlockEntry(JPlus22Parser.ApplyBlockEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JPlus22Parser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JPlus22Parser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelClassOrInterfaceDeclaration(JPlus22Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#topLevelClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelClassOrInterfaceDeclaration(JPlus22Parser.TopLevelClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(JPlus22Parser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(JPlus22Parser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(JPlus22Parser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(JPlus22Parser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(JPlus22Parser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(JPlus22Parser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JPlus22Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JPlus22Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(JPlus22Parser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(JPlus22Parser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(JPlus22Parser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(JPlus22Parser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(JPlus22Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(JPlus22Parser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(JPlus22Parser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(JPlus22Parser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassExtends(JPlus22Parser.ClassExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassExtends(JPlus22Parser.ClassExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void enterClassImplements(JPlus22Parser.ClassImplementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classImplements}.
	 * @param ctx the parse tree
	 */
	void exitClassImplements(JPlus22Parser.ClassImplementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(JPlus22Parser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(JPlus22Parser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void enterClassPermits(JPlus22Parser.ClassPermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classPermits}.
	 * @param ctx the parse tree
	 */
	void exitClassPermits(JPlus22Parser.ClassPermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JPlus22Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JPlus22Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JPlus22Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JPlus22Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(JPlus22Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(JPlus22Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JPlus22Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JPlus22Parser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(JPlus22Parser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(JPlus22Parser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(JPlus22Parser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(JPlus22Parser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JPlus22Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JPlus22Parser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JPlus22Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JPlus22Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JPlus22Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JPlus22Parser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(JPlus22Parser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(JPlus22Parser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(JPlus22Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(JPlus22Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(JPlus22Parser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(JPlus22Parser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(JPlus22Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(JPlus22Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void enterUCOIT(JPlus22Parser.UCOITContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#uCOIT}.
	 * @param ctx the parse tree
	 */
	void exitUCOIT(JPlus22Parser.UCOITContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(JPlus22Parser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(JPlus22Parser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(JPlus22Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(JPlus22Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(JPlus22Parser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(JPlus22Parser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(JPlus22Parser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(JPlus22Parser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JPlus22Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JPlus22Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(JPlus22Parser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(JPlus22Parser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(JPlus22Parser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(JPlus22Parser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(JPlus22Parser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(JPlus22Parser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(JPlus22Parser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(JPlus22Parser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(JPlus22Parser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(JPlus22Parser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JPlus22Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JPlus22Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JPlus22Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JPlus22Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityParameter(JPlus22Parser.VariableArityParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableArityParameter}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityParameter(JPlus22Parser.VariableArityParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(JPlus22Parser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(JPlus22Parser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void enterThrowsT(JPlus22Parser.ThrowsTContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#throwsT}.
	 * @param ctx the parse tree
	 */
	void exitThrowsT(JPlus22Parser.ThrowsTContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(JPlus22Parser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(JPlus22Parser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(JPlus22Parser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(JPlus22Parser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JPlus22Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JPlus22Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(JPlus22Parser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(JPlus22Parser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(JPlus22Parser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(JPlus22Parser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JPlus22Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JPlus22Parser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(JPlus22Parser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(JPlus22Parser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(JPlus22Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(JPlus22Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(JPlus22Parser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(JPlus22Parser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(JPlus22Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(JPlus22Parser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(JPlus22Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(JPlus22Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(JPlus22Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(JPlus22Parser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(JPlus22Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(JPlus22Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(JPlus22Parser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(JPlus22Parser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(JPlus22Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(JPlus22Parser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(JPlus22Parser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(JPlus22Parser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(JPlus22Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(JPlus22Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordDeclaration(JPlus22Parser.RecordDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordDeclaration(JPlus22Parser.RecordDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(JPlus22Parser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(JPlus22Parser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(JPlus22Parser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(JPlus22Parser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(JPlus22Parser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(JPlus22Parser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void enterVariableArityRecordComponent(JPlus22Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableArityRecordComponent}.
	 * @param ctx the parse tree
	 */
	void exitVariableArityRecordComponent(JPlus22Parser.VariableArityRecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentModifier(JPlus22Parser.RecordComponentModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordComponentModifier}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentModifier(JPlus22Parser.RecordComponentModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void enterRecordBody(JPlus22Parser.RecordBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordBody}.
	 * @param ctx the parse tree
	 */
	void exitRecordBody(JPlus22Parser.RecordBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordBodyDeclaration(JPlus22Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordBodyDeclaration(JPlus22Parser.RecordBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompactConstructorDeclaration(JPlus22Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompactConstructorDeclaration(JPlus22Parser.CompactConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(JPlus22Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(JPlus22Parser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(JPlus22Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(JPlus22Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(JPlus22Parser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(JPlus22Parser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceExtends(JPlus22Parser.InterfaceExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceExtends}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceExtends(JPlus22Parser.InterfaceExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void enterInterfacePermits(JPlus22Parser.InterfacePermitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfacePermits}.
	 * @param ctx the parse tree
	 */
	void exitInterfacePermits(JPlus22Parser.InterfacePermitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(JPlus22Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(JPlus22Parser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(JPlus22Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(JPlus22Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(JPlus22Parser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(JPlus22Parser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(JPlus22Parser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(JPlus22Parser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(JPlus22Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(JPlus22Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(JPlus22Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(JPlus22Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceDeclaration(JPlus22Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotationInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceDeclaration(JPlus22Parser.AnnotationInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceBody(JPlus22Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotationInterfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceBody(JPlus22Parser.AnnotationInterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceMemberDeclaration(JPlus22Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotationInterfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceMemberDeclaration(JPlus22Parser.AnnotationInterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementDeclaration(JPlus22Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementDeclaration(JPlus22Parser.AnnotationInterfaceElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationInterfaceElementModifier(JPlus22Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotationInterfaceElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationInterfaceElementModifier(JPlus22Parser.AnnotationInterfaceElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(JPlus22Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(JPlus22Parser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(JPlus22Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(JPlus22Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(JPlus22Parser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(JPlus22Parser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(JPlus22Parser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(JPlus22Parser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(JPlus22Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(JPlus22Parser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JPlus22Parser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JPlus22Parser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JPlus22Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JPlus22Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(JPlus22Parser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(JPlus22Parser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(JPlus22Parser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(JPlus22Parser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(JPlus22Parser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(JPlus22Parser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JPlus22Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JPlus22Parser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(JPlus22Parser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(JPlus22Parser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JPlus22Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JPlus22Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(JPlus22Parser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(JPlus22Parser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JPlus22Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JPlus22Parser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalClassOrInterfaceDeclaration(JPlus22Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#localClassOrInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalClassOrInterfaceDeclaration(JPlus22Parser.LocalClassOrInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JPlus22Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JPlus22Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableType(JPlus22Parser.LocalVariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#localVariableType}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableType(JPlus22Parser.LocalVariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(JPlus22Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(JPlus22Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JPlus22Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JPlus22Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(JPlus22Parser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(JPlus22Parser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(JPlus22Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(JPlus22Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JPlus22Parser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JPlus22Parser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(JPlus22Parser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(JPlus22Parser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(JPlus22Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(JPlus22Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JPlus22Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JPlus22Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JPlus22Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JPlus22Parser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(JPlus22Parser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(JPlus22Parser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(JPlus22Parser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(JPlus22Parser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(JPlus22Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(JPlus22Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(JPlus22Parser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(JPlus22Parser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JPlus22Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JPlus22Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(JPlus22Parser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(JPlus22Parser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchRule(JPlus22Parser.SwitchRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchRule(JPlus22Parser.SwitchRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(JPlus22Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(JPlus22Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(JPlus22Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(JPlus22Parser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void enterCaseConstant(JPlus22Parser.CaseConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#caseConstant}.
	 * @param ctx the parse tree
	 */
	void exitCaseConstant(JPlus22Parser.CaseConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void enterCasePattern(JPlus22Parser.CasePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#casePattern}.
	 * @param ctx the parse tree
	 */
	void exitCasePattern(JPlus22Parser.CasePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(JPlus22Parser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(JPlus22Parser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JPlus22Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JPlus22Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(JPlus22Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(JPlus22Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JPlus22Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JPlus22Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JPlus22Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JPlus22Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(JPlus22Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(JPlus22Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(JPlus22Parser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(JPlus22Parser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(JPlus22Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(JPlus22Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JPlus22Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JPlus22Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(JPlus22Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(JPlus22Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(JPlus22Parser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(JPlus22Parser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(JPlus22Parser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(JPlus22Parser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(JPlus22Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(JPlus22Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForDeclaration(JPlus22Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#enhancedForDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForDeclaration(JPlus22Parser.EnhancedForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JPlus22Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JPlus22Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JPlus22Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JPlus22Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JPlus22Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JPlus22Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JPlus22Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JPlus22Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(JPlus22Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(JPlus22Parser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JPlus22Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JPlus22Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(JPlus22Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(JPlus22Parser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JPlus22Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JPlus22Parser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(JPlus22Parser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(JPlus22Parser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JPlus22Parser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JPlus22Parser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JPlus22Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JPlus22Parser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(JPlus22Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(JPlus22Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(JPlus22Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(JPlus22Parser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(JPlus22Parser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(JPlus22Parser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(JPlus22Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(JPlus22Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableAccess(JPlus22Parser.VariableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableAccess(JPlus22Parser.VariableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JPlus22Parser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JPlus22Parser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(JPlus22Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(JPlus22Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void enterTypePattern(JPlus22Parser.TypePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typePattern}.
	 * @param ctx the parse tree
	 */
	void exitTypePattern(JPlus22Parser.TypePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void enterRecordPattern(JPlus22Parser.RecordPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#recordPattern}.
	 * @param ctx the parse tree
	 */
	void exitRecordPattern(JPlus22Parser.RecordPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#componentPatternList}.
	 * @param ctx the parse tree
	 */
	void enterComponentPatternList(JPlus22Parser.ComponentPatternListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#componentPatternList}.
	 * @param ctx the parse tree
	 */
	void exitComponentPatternList(JPlus22Parser.ComponentPatternListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#componentPattern}.
	 * @param ctx the parse tree
	 */
	void enterComponentPattern(JPlus22Parser.ComponentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#componentPattern}.
	 * @param ctx the parse tree
	 */
	void exitComponentPattern(JPlus22Parser.ComponentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 */
	void enterUnnamedPattern(JPlus22Parser.UnnamedPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unnamedPattern}.
	 * @param ctx the parse tree
	 */
	void exitUnnamedPattern(JPlus22Parser.UnnamedPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JPlus22Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JPlus22Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JPlus22Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JPlus22Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(JPlus22Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(JPlus22Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void enterPNNA(JPlus22Parser.PNNAContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#pNNA}.
	 * @param ctx the parse tree
	 */
	void exitPNNA(JPlus22Parser.PNNAContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassLiteral(JPlus22Parser.ClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassLiteral(JPlus22Parser.ClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(JPlus22Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(JPlus22Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedClassInstanceCreationExpression(JPlus22Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unqualifiedClassInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedClassInstanceCreationExpression(JPlus22Parser.UnqualifiedClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceTypeToInstantiate(JPlus22Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#classOrInterfaceTypeToInstantiate}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceTypeToInstantiate(JPlus22Parser.ClassOrInterfaceTypeToInstantiateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(JPlus22Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(JPlus22Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(JPlus22Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(JPlus22Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithoutInitializer(JPlus22Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithoutInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithoutInitializer(JPlus22Parser.ArrayCreationExpressionWithoutInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpressionWithInitializer(JPlus22Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayCreationExpressionWithInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpressionWithInitializer(JPlus22Parser.ArrayCreationExpressionWithInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(JPlus22Parser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(JPlus22Parser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(JPlus22Parser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(JPlus22Parser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(JPlus22Parser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(JPlus22Parser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(JPlus22Parser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(JPlus22Parser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(JPlus22Parser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(JPlus22Parser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(JPlus22Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(JPlus22Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(JPlus22Parser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(JPlus22Parser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(JPlus22Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(JPlus22Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void enterPfE(JPlus22Parser.PfEContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#pfE}.
	 * @param ctx the parse tree
	 */
	void exitPfE(JPlus22Parser.PfEContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JPlus22Parser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JPlus22Parser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(JPlus22Parser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(JPlus22Parser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(JPlus22Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(JPlus22Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JPlus22Parser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JPlus22Parser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(JPlus22Parser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(JPlus22Parser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(JPlus22Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(JPlus22Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(JPlus22Parser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(JPlus22Parser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JPlus22Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JPlus22Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JPlus22Parser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JPlus22Parser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(JPlus22Parser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(JPlus22Parser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JPlus22Parser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JPlus22Parser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JPlus22Parser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JPlus22Parser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(JPlus22Parser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(JPlus22Parser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(JPlus22Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(JPlus22Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(JPlus22Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(JPlus22Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(JPlus22Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(JPlus22Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(JPlus22Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(JPlus22Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullCoalescingExpression(JPlus22Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#nullCoalescingExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullCoalescingExpression(JPlus22Parser.NullCoalescingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(JPlus22Parser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(JPlus22Parser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JPlus22Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JPlus22Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JPlus22Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JPlus22Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(JPlus22Parser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(JPlus22Parser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JPlus22Parser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JPlus22Parser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(JPlus22Parser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(JPlus22Parser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(JPlus22Parser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(JPlus22Parser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(JPlus22Parser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(JPlus22Parser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(JPlus22Parser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(JPlus22Parser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterType(JPlus22Parser.LambdaParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaParameterType}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterType(JPlus22Parser.LambdaParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(JPlus22Parser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(JPlus22Parser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpression(JPlus22Parser.SwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpression(JPlus22Parser.SwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPlus22Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(JPlus22Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPlus22Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(JPlus22Parser.ConstantExpressionContext ctx);
}