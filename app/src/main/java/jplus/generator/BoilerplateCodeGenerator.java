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

package jplus.generator;

import jplus.base.JPlus25Parser.ApplyBlockContext;
import jplus.base.JPlus25Parser.ApplyDeclarationContext;
import jplus.base.JPlus25Parser.ApplyFeatureListContext;
import jplus.base.JPlus25Parser.ApplyStatementContext;
import jplus.base.JPlus25ParserBaseVisitor;
import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.generator.apply.ApplyFeature;
import jplus.generator.apply.ApplyFeatureProcessingContext;
import jplus.generator.apply.ApplyFeatureProcessor;
import jplus.generator.apply.ApplyStatement;
import jplus.generator.apply.BuilderFeatureProcessor;
import jplus.generator.apply.ConstructorFeatureProcessor;
import jplus.generator.apply.DataFeatureProcessor;
import jplus.generator.apply.EqualityFeatureProcessor;
import jplus.generator.apply.EqualsFeatureProcessor;
import jplus.generator.apply.GetterFeatureProcessor;
import jplus.generator.apply.HashCodeFeatureProcessor;
import jplus.generator.apply.SetterFeatureProcessor;
import jplus.generator.apply.ToBuilderFeatureProcessor;
import jplus.generator.apply.ToStringFeatureProcessor;
import jplus.editor.FragmentedText;
import jplus.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoilerplateCodeGenerator extends JPlus25ParserBaseVisitor<Void> {

    private final SymbolTable symbolTable;
    private final FragmentedText fragmentedText;
    private final List<ApplyStatement> applyStatementList = new ArrayList<>();
    private final Map<String, ApplyFeatureProcessor> strategyMap = new HashMap<>();
    private final Map<String, Set<String>> processedClassActionMap = new HashMap<>();
    private final Map<String, ApplyFeatureProcessingContext> processedClassActionContextMap = new HashMap<>();

    public BoilerplateCodeGenerator(SymbolTable symbolTable, FragmentedText fragmentedText) {
        this.symbolTable = symbolTable;
        this.fragmentedText = fragmentedText;
        registerStrategies();
    }

    private void registerStrategies() {
        strategyMap.put("getter", new GetterFeatureProcessor());
        strategyMap.put("setter", new SetterFeatureProcessor());
        strategyMap.put("equals", new EqualsFeatureProcessor());
        strategyMap.put("equality", new EqualityFeatureProcessor());
        strategyMap.put("constructor", new ConstructorFeatureProcessor());
        strategyMap.put("tostring", new ToStringFeatureProcessor());
        strategyMap.put("hashcode", new HashCodeFeatureProcessor());
        strategyMap.put("builder", new BuilderFeatureProcessor());
        strategyMap.put("tobuilder", new ToBuilderFeatureProcessor());
        strategyMap.put("data", new DataFeatureProcessor());
    }

    // ---------- Visitor Override ----------

    @Override
    public Void visitApplyDeclaration(ApplyDeclarationContext ctx) {
        if (ctx.applyStatement() != null) {
            handleApplyStatement(ctx.applyStatement());
        } else if (ctx.applyBlock() != null) {
            handleApplyBlock(ctx.applyBlock());
        }
        return null;
    }

    // ---------- Apply Statement Handling ----------

    private void handleApplyStatement(ApplyStatementContext ctx) {
        ApplyStatement applyStatement = getApplyStatement("^TopLevelClass$", ctx.applyFeatureList());
        applyStatementList.add(applyStatement);
    }

    private void handleApplyBlock(ApplyBlockContext ctx) {
        ctx.applyBlockEntry().forEach(entry -> {
            String qualifiedName = Utils.getTokenString(entry.qualifiedName());
            ApplyStatement applyStatement = getApplyStatement(qualifiedName, entry.applyFeatureList());
            applyStatementList.add(applyStatement);
        });
    }

    private ApplyStatement getApplyStatement(String className, ApplyFeatureListContext ctx) {
        ApplyStatement applyStatement = new ApplyStatement(className);
        ctx.applyFeature().forEach(featureCtx -> {
            String action = Utils.getTokenString(featureCtx.identifier());
            ApplyFeature feature = new ApplyFeature(action);

            if (featureCtx.applyFeatureArgs() != null) {
                featureCtx.applyFeatureArgs().identifier()
                        .forEach(idCtx -> feature.addArgument(Utils.getTokenString(idCtx)));
            }

            applyStatement.addApplyFeature(feature);
        });
        return applyStatement;
    }

    // ---------- Code Generation ----------

    public String generate() {
        String topLevelClass = symbolTable.resolve("^TopLevelClass$").getSymbol();

        applyStatementList.stream()
                .filter(stmt -> "^TopLevelClass$".equals(stmt.getQualifiedName()))
                .findFirst()
                .ifPresent(stmt -> stmt.setQualifiedName(topLevelClass));

        int baseIndent = 4;
        for (ApplyStatement applyStatement : applyStatementList) {
            String qualifiedName = applyStatement.getQualifiedName();
            String[] classNames = qualifiedName.split("\\.");
            String targetClass = classNames[classNames.length - 1];

            SymbolTable enclosingSymbolTable = symbolTable;
            for (int i = 0; i < classNames.length - 1; ++i) {
                if (enclosingSymbolTable.resolve(classNames[i]) == null) {
                    throw new IllegalStateException(classNames[i] + " is not found in SymbolTable");
                }
                enclosingSymbolTable = enclosingSymbolTable.getEnclosingSymbolTable(classNames[i]);
            }

            //System.err.println("targetClass = " + targetClass);
            //System.err.println("enclosingSymbolTable = " + enclosingSymbolTable);
            SymbolInfo targetClassSymbolInfo = enclosingSymbolTable.resolve(targetClass);
            //System.err.println("targetClassSymbolInfo = " + targetClassSymbolInfo);
            TextChangeRange range = targetClassSymbolInfo.getRange();
            String classText = targetClassSymbolInfo.getOriginalText();
            TextChangeRange methodRange = new TextChangeRange(
                    range.endLine(), range.inclusiveEndIndex(),
                    range.endLine(), range.inclusiveEndIndex()
            );

            SymbolTable classSymbolTable = enclosingSymbolTable.getEnclosingSymbolTable(targetClass);
            //System.err.println("[CodeGenerator] classSymbolTable = " + classSymbolTable);

            List<String> fieldList = classSymbolTable.findSymbolsByType(List.of(TypeInfo.Type.Primitive, TypeInfo.Type.Reference, TypeInfo.Type.TypeParameter));
            List<String> primitiveTypeFieldList = classSymbolTable.findSymbolsByType(List.of(TypeInfo.Type.Primitive));
            List<String> referenceTypeFieldList = classSymbolTable.findSymbolsByType(List.of(TypeInfo.Type.Reference, TypeInfo.Type.TypeParameter));

            if (fieldList.isEmpty()) continue;

            int indent = classSymbolTable.resolve(fieldList.get(0)).getRange().startIndex();
            if (topLevelClass.equals(targetClass)) {
                baseIndent = indent;
            }
            String indentation = Utils.indent(" ", baseIndent);
            String doubleIndentation = Utils.indent(" ", baseIndent * 2);

            SymbolInfo symbolInfo = classSymbolTable.resolve(fieldList.get(fieldList.size()-1));
//            boolean isNullable = symbolInfo.getTypeInfo().isNullable();
            int constructorIndent = symbolInfo.getRange().startIndex();
            int endLine = symbolInfo.getRange().endLine();
            int endIndex = symbolInfo.getRange().inclusiveEndIndex() + 1;
            TextChangeRange constructorRange = new TextChangeRange(endLine, endIndex, endLine, endIndex);

            ApplyFeatureProcessingContext context = processedClassActionContextMap.computeIfAbsent(qualifiedName, k -> {
                return ApplyFeatureProcessingContext.builder()
                        .qualifiedName(qualifiedName)
                        .targetClass(targetClass)
                        .targetClassTypeInfo(targetClassSymbolInfo.getTypeInfo())
                        .classSymbolTable(classSymbolTable)
                        .fieldList(fieldList)
                        .primitiveFields(primitiveTypeFieldList)
                        .referenceFields(referenceTypeFieldList)
                        .processedActionList(processedClassActionMap.computeIfAbsent(qualifiedName, key -> new HashSet<>()))
                        .indentation(indentation)
                        .constructorPartText(new StringBuilder())
                        .methodPartText(new StringBuilder())
                        .build();
            });

            for (ApplyFeature feature : applyStatement.getFeatureList()) {
                String action = feature.getAction();
                ApplyFeatureProcessor processor = strategyMap.get(action.toLowerCase());
                if (processor == null) throw new IllegalArgumentException("Unsupported action: " + action + " in feature " + feature + " at class " + qualifiedName);

                context.setFeature(feature);
                processor.process(context);
            }

            String replacedText = "";
            if (context.getMethodPartText().length() > 0) {
                replacedText = Utils.indentLines(context.getMethodPartText(), indent) + Utils.indentLines("\n}", indent - baseIndent);
                fragmentedText.update(methodRange, replacedText);
            }

            if (context.getConstructorPartText().length() > 0) {
                replacedText = Utils.indentLines(context.getConstructorPartText(), constructorIndent) + "\n";
                fragmentedText.update(constructorRange, replacedText);
            }
        }

        return fragmentedText.toString();
    }
}