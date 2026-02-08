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

package jplus.analyzer.nullability;

import jplus.analyzer.ResolvedChain;
import jplus.analyzer.StepCursor;
import jplus.analyzer.nullability.context.adapter.InvocationDeclarationContext;
import jplus.analyzer.nullability.context.adapter.MethodInvocationSignatureContextAdapter;
import jplus.analyzer.nullability.context.adapter.PNNAContextAdapter;
import jplus.analyzer.nullability.context.adapter.PrimaryNoNewArrayContextAdapter;
import jplus.analyzer.nullability.context.adapter.PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter;
import jplus.analyzer.nullability.context.adapter.SwitchExprStmtContext;
import jplus.analyzer.nullability.dataflow.InitState;
import jplus.analyzer.nullability.dataflow.context.ClassContext;
import jplus.analyzer.nullability.dataflow.context.ConstructorContext;
import jplus.analyzer.nullability.dataflow.context.Context;
import jplus.analyzer.nullability.dataflow.context.FieldContext;
import jplus.analyzer.nullability.dataflow.context.MethodContext;
import jplus.analyzer.nullability.dataflow.context.SwitchContext;
import jplus.analyzer.nullability.dataflow.NullState;
import java.lang.Void;
import jplus.base.JPlus25Parser;
import jplus.base.JPlus25ParserBaseVisitor;
import jplus.base.JavaMethodInvocationManager;
import jplus.base.MethodInvocationInfo;
import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.generator.SourceMappingEntry;
import jplus.generator.TextChangeRange;
import jplus.util.CodeUtils;
import jplus.util.MethodUtils;
import jplus.util.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jspecify.annotations.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class NullabilityChecker extends JPlus25ParserBaseVisitor<Void> {

    private final SymbolTable globalSymbolTable;
    private final Set<SourceMappingEntry> sourceMappingEntrySet;
    private final JavaMethodInvocationManager methodInvocationManager;
    private SymbolTable currentSymbolTable;
    private final Set<TextChangeRange> consumedExpressions = new HashSet<>();

    private final Deque<Context> contextStack = new ArrayDeque<>();
    private final Deque<ClassContext> classContextStack = new ArrayDeque<>();

    private final Deque<ConstructorContext> constructorContextStack = new ArrayDeque<>();
    private final Deque<SwitchContext> switchContextStack = new ArrayDeque<>();

    private final Deque<SymbolTable> ifContextStack = new ArrayDeque<>();

    private String originalText;
    private String packageName;
    private boolean hasPassed = true;

    public record NullabilityIssue(int line, int column, int offset, String message) implements Comparable<NullabilityIssue> {

        @Override
        public int compareTo(NullabilityIssue other) {
            return Integer.compare(this.offset, other.offset);
        }

        @Override
        public String toString() {
            return String.format("Error: (line:%d, column:%d) %s", line, column, message);
        }
    }

    public NullabilityChecker(SymbolTable globalSymbolTable, Set<SourceMappingEntry> sourceMappingEntrySet, JavaMethodInvocationManager methodInvocationManager) {
        this.globalSymbolTable = globalSymbolTable;
        this.sourceMappingEntrySet = sourceMappingEntrySet;
        this.methodInvocationManager = methodInvocationManager;
        this.currentSymbolTable = globalSymbolTable;
    }

    private final Set<NullabilityIssue> issues = new HashSet<>();

    public Set<NullabilityIssue> getIssues() {
        return issues;
    }

    private void enterSymbolTable(String symbol) {
        currentSymbolTable = currentSymbolTable.getEnclosingSymbolTable(symbol);
    }

    private void exitSymbolTable() {
        currentSymbolTable = currentSymbolTable.getParent();
    }

    private void reportIssue(Token token, String msg) {
        issues.add(new NullabilityIssue(token.getLine(), token.getCharPositionInLine(), token.getStartIndex(), msg));
        hasPassed = false;
    }

    private void reportIssue(int line, int column, int offset, String msg) {
        issues.add(new NullabilityIssue(line, column, offset, msg));
        hasPassed = false;
    }

    @Override
    public Void visitStart_(JPlus25Parser.Start_Context ctx) {
        this.originalText = ctx.start.getInputStream().toString();
        return super.visitStart_(ctx);
    }

    @Override
    public Void visitPackageDeclaration(JPlus25Parser.PackageDeclarationContext ctx) {
        this.packageName = ctx.identifier().stream().map(Utils::getTokenString).collect(Collectors.joining("."));
        //System.err.println("[NullabilityChecker] packageName = " + packageName);
        return super.visitPackageDeclaration(ctx);
    }

    @Override
    public Void visitTopLevelClassOrInterfaceDeclaration(JPlus25Parser.TopLevelClassOrInterfaceDeclarationContext ctx) {
        String className = getClassName(ctx.classDeclaration().normalClassDeclaration());
        //System.err.println("className = " + className);

        SymbolInfo classSymbolInfo = getClassSymbolInfo(className);
        currentSymbolTable = classSymbolInfo.getSymbolTable();
        //System.err.println("currentSymbolTable = " + currentSymbolTable);
        return super.visitTopLevelClassOrInterfaceDeclaration(ctx);
    }

    private SymbolInfo getClassSymbolInfo(String className) {
        SymbolInfo classSymbolInfo = globalSymbolTable.resolveInCurrent(className);
        if (classSymbolInfo == null) {
            throw new IllegalStateException("Symbol not found: " + className);
        }
        return classSymbolInfo;
    }

    private String getClassName(JPlus25Parser.NormalClassDeclarationContext ctx) {
        String className = Utils.getTokenString(ctx.typeIdentifier());
        if (this.packageName != null) {
            className = this.packageName + "." + className;
        }
        return className;
    }

    @Override
    public Void visitClassDeclaration(JPlus25Parser.ClassDeclarationContext ctx) {

        String typeName = null;

        List<JPlus25Parser.ClassBodyDeclarationContext> classBodyDefCtxList = null;
        Map<String, InvocationDeclarationContext> ctorNameToContextMap = null;

        if (ctx.normalClassDeclaration() != null) {
            typeName = Utils.getTokenString(ctx.normalClassDeclaration().typeIdentifier());
            //System.err.println("[NullabilityChecker][ClassDecl] className = " + typeName);

            classBodyDefCtxList = ctx.normalClassDeclaration().classBody().classBodyDeclaration();
            ctorNameToContextMap = getMethodNameToContextMap(getCtorDefListFromNormalClass(classBodyDefCtxList));
        } else if (ctx.enumDeclaration() != null) {
            typeName = Utils.getTokenString(ctx.enumDeclaration().typeIdentifier());
            //System.err.println("[NullabilityChecker][ClassDecl] enumName = " + typeName);

            classBodyDefCtxList = ctx.enumDeclaration().enumBody().enumBodyDeclarations().classBodyDeclaration();
            ctorNameToContextMap = getMethodNameToContextMap(getCtorDefListFromEnum(classBodyDefCtxList));
        } else if (ctx.recordDeclaration() != null) {
            typeName = Utils.getTokenString(ctx.recordDeclaration().typeIdentifier());
            //System.err.println("[NullabilityChecker][ClassDecl] recordName = " + typeName);

            classBodyDefCtxList = ctx.recordDeclaration().recordBody().recordBodyDeclaration().stream().map(JPlus25Parser.RecordBodyDeclarationContext::classBodyDeclaration).toList();
            ctorNameToContextMap = getMethodNameToContextMap(getCtorDefListFromRecord(ctx.recordDeclaration().recordBody().recordBodyDeclaration()));
        }

        //System.err.println("[NullabilityChecker][ClassDecl] classBodyDefCtxList = " + classBodyDefCtxList.stream().map(Utils::getTokenString).toList());
        //System.err.println("[NullabilityChecker][ClassDecl] ctorNameToContextMap = " + ctorNameToContextMap);

        if (typeName == null) {
            return null;
        }

        enterSymbolTable(typeName);

        ClassContext classContext = new ClassContext(currentSymbolTable, ctorNameToContextMap);
        classContextStack.push(classContext);

        try {
            for (var classBodyDeclarationContext : classBodyDefCtxList) {

                if (classBodyDeclarationContext.classMemberDeclaration() != null) {
                    var fieldDefCtx = classBodyDeclarationContext.classMemberDeclaration().fieldDeclaration();
                    if (fieldDefCtx != null) {
                        visit(fieldDefCtx);
                    }
                } else if (classBodyDeclarationContext.constructorDeclaration() != null) {
                    var ctorDefCtx = classBodyDeclarationContext.constructorDeclaration();
                    visit(ctorDefCtx);
                }
            }

        } finally {
            //System.err.println("[ClassDef] ClassContext = " + classContext);

            classContext.integrateFieldInitResults();
            if (classContext.hasUninitializedNonNullField()) {
                for (SymbolInfo fieldInfo : classContext.getUninitializedFieldList()) {
                    reportIssue(
                            fieldInfo.getRange().startLine(),
                            fieldInfo.getRange().startIndex(),
                            Utils.getIndexFromLineColumn(originalText, Utils.computeTextChangeRange(originalText, 0, originalText.length() - 1), fieldInfo.getRange().startLine(), fieldInfo.getRange().startIndex()),
                            String.format("Non-null field '%s' is not initialized in one or more constructors of class '%s'", fieldInfo.getSymbol(), typeName)
                    );
                }
            }

            classContext.updateNonNullFieldNullState();
            classContextStack.pop();
        }


        var saved = currentSymbolTable.copy();

        try {
            var classBodyDef = ctx.normalClassDeclaration().classBody().classBodyDeclaration();
            for (var classBodyDeclarationContext : classBodyDef) {

                if (classBodyDeclarationContext.classMemberDeclaration() != null) {

                    var methodDefCtx = classBodyDeclarationContext.classMemberDeclaration().methodDeclaration();
                    if (methodDefCtx != null) {

                        currentSymbolTable = saved.copy();
                        visit(methodDefCtx);
                    }
                }
            }
        } finally {
            exitSymbolTable();
        }

        return null;
    }

    private List<InvocationDeclarationContext> getCtorDefListFromEnum(List<JPlus25Parser.ClassBodyDeclarationContext> enumDeclarationContexts) {

        List<InvocationDeclarationContext> enumDefList = new ArrayList<>();

        for (var enumDeclarationContext : enumDeclarationContexts) {

            if (enumDeclarationContext.constructorDeclaration() == null) continue;
            enumDefList.add(InvocationDeclarationContext.from(enumDeclarationContext.constructorDeclaration()));
        }

        return enumDefList;
    }

    private List<InvocationDeclarationContext> getCtorDefListFromNormalClass(List<JPlus25Parser.ClassBodyDeclarationContext> classBodyDeclarationContexts) {

        List<InvocationDeclarationContext> normalClassDefList = new ArrayList<>();

        for (var normalClassDeclarationContext : classBodyDeclarationContexts) {
            if (normalClassDeclarationContext.constructorDeclaration() == null) continue;

            normalClassDefList.add(InvocationDeclarationContext.from(normalClassDeclarationContext.constructorDeclaration()));
        }

        return normalClassDefList;
    }

    private List<InvocationDeclarationContext> getCtorDefListFromRecord(List<JPlus25Parser.RecordBodyDeclarationContext> recordBodyDeclarationContexts) {

        List<InvocationDeclarationContext> ctorDefList = new ArrayList<>();
        for (var recordBodyDeclarationContext : recordBodyDeclarationContexts) {

            if (recordBodyDeclarationContext.classBodyDeclaration().constructorDeclaration() == null) continue;
            ctorDefList.add(InvocationDeclarationContext.from(recordBodyDeclarationContext.classBodyDeclaration().constructorDeclaration()));
        }

        return ctorDefList;
    }

    private Map<String, InvocationDeclarationContext> getMethodNameToContextMap(List<InvocationDeclarationContext> invokeDefCtx) {

        Map<String, InvocationDeclarationContext> methodNameToCtor = new HashMap<>();

        for (var invokeDef : invokeDefCtx) {
            List<String> typeNameList = getTypeNamesFromParameterList(invokeDef.formalParameterList());
            String methodSymbol = "^" + invokeDef.methodName() + "$~" + String.join("~", typeNameList);
            methodNameToCtor.put(methodSymbol, invokeDef);
        }

        return methodNameToCtor;
    }

    @Override
    public Void visitConstructorDeclaration(JPlus25Parser.ConstructorDeclarationContext ctx) {
        //currentSymbolTable = currentSymbolTable.copy(true);
        return processInvocationDeclaration(InvocationDeclarationContext.from(ctx));
    }

    @Override
    public Void visitMethodDeclaration(JPlus25Parser.MethodDeclarationContext ctx) {
        //currentSymbolTable = currentSymbolTable.copy();
        return processInvocationDeclaration(InvocationDeclarationContext.from(ctx));
    }

    private List<String> extractParameterTypes(List<JPlus25Parser.FormalParameterContext> params) {
        return params.stream()
                .map(this::extractParameterType)
                .toList();
    }

    private String extractParameterType(JPlus25Parser.FormalParameterContext param) {
        boolean nullable = isNullable(param);
        String type = Utils.getTokenString(param.unannType());

        return nullable ? type + "?" : type;
    }

    private boolean isNullable(JPlus25Parser.FormalParameterContext param) {
        if (param.variableModifier() == null) {
            return false;
        }

        return param.variableModifier().stream()
                .anyMatch(vm ->
                        "@Nullable".equals(Utils.getTokenString(vm.annotation()))
                );
    }


    private List<String> getTypeNamesFromParameterList(JPlus25Parser.FormalParameterListContext ctx) {
        if (ctx == null) return List.of();
        return extractParameterTypes(ctx.formalParameter());
    }

    private Void processInvocationDeclaration(InvocationDeclarationContext ctx) {
        List<String> typeNameList = getTypeNamesFromParameterList(ctx.formalParameterList());
        String methodSymbol = "^" + ctx.methodName() + "$~" + String.join("~", typeNameList);

        //System.err.println("[processInvocationDeclaration] currentSymbolTable = " + currentSymbolTable);
        //System.err.println("[processInvocationDeclaration] methodSymbol = " + methodSymbol);
        //SymbolInfo methodSymbolInfo = currentSymbolTable.resolveInCurrent(methodSymbol);
        SymbolInfo methodSymbolInfo = currentSymbolTable.resolve(methodSymbol);

        /*SymbolInfo methodSymbolInfo = currentSymbolTable.getEnclosingSymbolTable(SymbolTable.INSTANCE_NS).resolveInCurrent(methodSymbol);
        if (ctx.modifiers().contains(Modifier.STATIC)) {
            methodSymbolInfo = currentSymbolTable.getEnclosingSymbolTable(SymbolTable.STATIC_NS).resolveInCurrent(methodSymbol);
        }*/

        if (methodSymbolInfo == null) {
            //throw new IllegalStateException("cannot find the symbol(" + methodSymbol + ")");
            return null;
        }

        enterSymbolTable(methodSymbolInfo.getSymbol());
        contextStack.push(new MethodContext(ctx.methodName(), methodSymbolInfo));
        try {
            return super.visitChildren(ctx.originalContext());
        } finally {
            contextStack.pop();
            exitSymbolTable();
        }
    }

    @Override
    public Void visitLambdaExpression(JPlus25Parser.LambdaExpressionContext ctx) {
        log("[LambdaExpression] contextString = " + Utils.getTokenString(ctx));
        log("[LambdaExpression] startOffset = " + ctx.start.getStartIndex());

        String lambdaSymbol = "^lambda$" + ctx.start.getStartIndex();
        enterSymbolTable(lambdaSymbol);
        try {
            log("[LambdaExpression] lambdaSymboTable = " + currentSymbolTable);
            return super.visitLambdaExpression(ctx);
        } finally {
            exitSymbolTable();
        }
    }

    public SymbolTable getCurrentSymbolTable() {
        return currentSymbolTable.copy();
    }

    @Override
    public Void visitFieldDeclaration(JPlus25Parser.FieldDeclarationContext ctx) {
        for (var decl : ctx.variableDeclaratorList().variableDeclarator()) {
            String symbol = Utils.getTokenString(decl.variableDeclaratorId());
            //System.err.println("[NullabilityChecker][FieldDecl] symbol = " + symbol);


            //System.err.println("[NullabilityChecker][FieldDecl] currentSymbolTable = " + currentSymbolTable);
            SymbolInfo symbolInfo = currentSymbolTable.resolve(symbol);
            //System.err.println("[NullabilityChecker][FieldDecl] symbolInfo = " + symbolInfo);

            TypeInfo typeInfo = symbolInfo.getTypeInfo();

            if (decl.variableInitializer() != null) {

                NullState rhsState = evalRHS(decl.variableInitializer(), currentSymbolTable);
                if (!typeInfo.isNullable() && rhsState != NullState.NON_NULL) {
                    reportIssue(ctx.getStart(), symbol + " is a non-nullable variable. But null value is assigned to it.");
                }

                SymbolInfo updated = symbolInfo.toBuilder()
                        .nullState(rhsState)
                        .build();

                //currentSymbolTable.declare(symbol, updated);
                symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
                //System.err.println("[NullabilityChecker][FieldDecl] updated symbolInfo = " + currentSymbolTable.resolve(symbol));

                /*if (rhsState == NullState.NON_NULL) {
                    ClassContext classContext = classContextStack.peek();
                    classContext.update(new FieldContext(symbol, InitState.INIT));
                }*/

                ClassContext classContext = classContextStack.peek();
                classContext.update(new FieldContext(symbol, InitState.INIT));

            } else {
                if (!typeInfo.isNullable() && typeInfo.getType() == TypeInfo.Type.Reference) {
                    SymbolInfo updated = symbolInfo.toBuilder()
                            .nullState(NullState.UNKNOWN)
                            .build();

                    //currentSymbolTable.declare(symbol, updated);
                    symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
                    //System.err.println("[NullabilityChecker][FieldDecl] updated symbolInfo = " + currentSymbolTable.resolve(symbol));
                }

                ClassContext classContext = classContextStack.peek();
                classContext.update(new FieldContext(symbol, InitState.UNINIT));
            }
        }

        return super.visitFieldDeclaration(ctx);
    }

    NullState evalRHS(ParserRuleContext ctx, SymbolTable symbolTable) {
        if (ctx == null) return NullState.UNKNOWN;

        System.err.println("[evalInitializer] line(" + ctx.start.getLine() + ") contextString: " + Utils.getTokenString(ctx));

        var conditionalExprResult = symbolTable.resolveInCurrent("^ConditionalExpression$" + ctx.start.getStartIndex());
        if (conditionalExprResult != null) {
            //System.err.println("[evalInitializer] conditionalExprResult = " + conditionalExprResult.getNullState());
            return conditionalExprResult.getNullState();
        }

        var switchExprResult = symbolTable.resolveInCurrent("^SwitchExpression$" + ctx.start.getStartIndex());
        if (switchExprResult != null) {
            //System.err.println("[evalInitializer] switchExprResult = " + switchExprResult.getNullState());
            return switchExprResult.getNullState();
        }

        System.err.println("[evalInitializer] resolvedChains: " + symbolTable.getResolvedChains());

        var ctxRange = Utils.getTextChangeRange(originalText, ctx);
        System.err.println("[evalInitializer] original range = " + ctxRange);

        var mappedRangeOpt = findTransformedRange(ctxRange);
        if (mappedRangeOpt.isEmpty()) {
            return NullState.UNKNOWN;
        }

        System.err.println("[evalInitializer] mapped range = " + mappedRangeOpt.get());

        var resolvedChainOpt = symbolTable.findResolvedChain(mappedRangeOpt.get());
        if (resolvedChainOpt.isEmpty()) {
            return NullState.UNKNOWN;
        }

        System.err.println("[evalInitializer] findResolvedChain = " + resolvedChainOpt.get());

        var cursor = resolvedChainOpt.get().stepCursor();
        if (!cursor.hasNext()) {
            return NullState.UNKNOWN;
        }

        return computeChainNullability(ctx, symbolTable, cursor);
    }

    private NullState computeChainNullability(ParserRuleContext ctx, SymbolTable symbolTable, StepCursor cursor) {
        ResolvedChain.Step root = cursor.consume();

        while (root.typeInfo.getType() == TypeInfo.Type.Unknown) {
            log("[computeChainNullability] skip = " + root);
            root = cursor.consume();
        }

        log("[computeChainNullability] root = " + root);

        if (root.typeInfo.getType() == TypeInfo.Type.Null) {
            return NullState.NULL;
        }

        if (root.kind == ResolvedChain.Kind.LITERAL || root.kind == ResolvedChain.Kind.NEW || root.kind == ResolvedChain.Kind.METHOD) {
            return NullState.NON_NULL;
        }

        NullState nullState = NullState.UNKNOWN;
        boolean rootReported = false;
        if (root.kind == ResolvedChain.Kind.ARRAY_ACCESS) {
            if (root.typeInfo.getType() == TypeInfo.Type.Primitive) nullState = NullState.NON_NULL;
            else nullState = NullState.UNKNOWN;
        } else if (root.kind == ResolvedChain.Kind.METHOD) {
            nullState = root.nullable ? NullState.UNKNOWN : NullState.NON_NULL;
        } else {
            SymbolInfo rootInfo = symbolTable.resolve(root.symbol);
            log("[computeChainNullability] currentSymbolTable = " + symbolTable);
            log("[computeChainNullability] rootInfo = " + rootInfo);

            if (rootInfo != null) {
                nullState = rootInfo.getNullState();

                /*if (!rootInfo.getTypeInfo().isNullable() && nullState == NullState.UNKNOWN) {
                    reportIssue(ctx.start, root.symbol + " may be null. Consider checking for null or using null-safe operator(?.) before accessing.");
                    rootReported = true;
                }*/
            } else {
                if (root.typeInfo.getType() != TypeInfo.Type.Unknown) {
                    nullState = root.nullable ? NullState.UNKNOWN : NullState.NON_NULL;
                }
            }
        }

        log("[computeChainNullability] nullState = " + nullState);

        var prevStep = root;
        while (cursor.hasNext()) {
            var step = cursor.consume();

            /*if (prevStep.nullable && nullState == NullState.NULL) {
                reportIssue(ctx.start, String.format(
                        "%s is null. Accessing %s may cause NPE.",
                        prevStep.symbol,
                        step.symbol + ((step.kind == ResolvedChain.Kind.METHOD) ? "()" : "")
                ));
                return NullState.NULL;
            } else if (nullState == NullState.UNKNOWN && !rootReported) {
                reportIssue(ctx.start, String.format(
                        "%s is a nullable variable. Accessing %s may cause NPE. Consider using null-safe operator(?.).",
                        prevStep.symbol,
                        step.symbol + ((step.kind == ResolvedChain.Kind.METHOD) ? "()" : "")
                ));
            }*/

            if (step.typeInfo.isNullable()) {
                nullState = NullState.UNKNOWN;
            }

            prevStep = step;
        }

        return nullState;
    }

    @Override
    public Void visitBlock(JPlus25Parser.BlockContext ctx) {
        var saved = currentSymbolTable;
        enterSymbolTable("^block$");
        try {
            return super.visitBlock(ctx);
        } finally {
            saved.mergeDeadContext(currentSymbolTable.isDeadContext());
            exitSymbolTable();
        }
    }

    @Override
    public Void visitConstructorBody(JPlus25Parser.ConstructorBodyContext ctx) {
        var saved = currentSymbolTable;
        enterSymbolTable("^block$");
        constructorContextStack.push(new ConstructorContext());
        try {
            return super.visitConstructorBody(ctx);
        } finally {
            ClassContext classContext = classContextStack.peek();
            classContext.merge(constructorContextStack.pop());
            saved.mergeDeadContext(currentSymbolTable.isDeadContext());
            exitSymbolTable();
        }
    }

    private SymbolTable resolveClassSymbolTable(SymbolInfo symbolInfo) {
        SymbolTable symbolTable = symbolInfo.getSymbolTable();
        //System.err.println("[resolveClassSymbolTable] symbolTable = " + symbolTable);
        if (symbolInfo.getTypeInfo().getType() != TypeInfo.Type.Class) {
            SymbolInfo classSymbolInfo = globalSymbolTable.resolveInCurrent(symbolInfo.getTypeInfo().getName());
            if (classSymbolInfo != null) {
                symbolTable = classSymbolInfo.getSymbolTable();
                symbolInfo = classSymbolInfo;
            }
        }

        String classSymbol;
        if(symbolTable.containsInCurrent("^TopLevelClass$", EnumSet.of(TypeInfo.Type.Class)) ) {
            classSymbol = symbolTable.resolveInCurrent("^TopLevelClass$").getSymbol();
        } else {
            classSymbol = symbolInfo.getSymbol();
        }

        SymbolTable classSymbolTable = symbolTable.getEnclosingSymbolTable(classSymbol);
        log("[resolveClassSymbolTable] enclosingSymbolTable = " + classSymbolTable);
        return classSymbolTable;
    }

    private TextChangeRange getCodeRange(ParserRuleContext ctx) {
        String code = Utils.getTokenString(ctx);
        log("[getCodeRange] code: " + code);

        TextChangeRange codeRange = Utils.getTextChangeRange(originalText, ctx);
        log("[getCodeRange] codeRange: " + codeRange);

        return codeRange;
    }

    private Optional<TextChangeRange> findTransformedRange(TextChangeRange instanceRange) {
        return sourceMappingEntrySet.stream()
                .filter(entry -> Objects.equals(instanceRange, entry.getOriginalRange()))
                //.peek(entry -> log("[findTransformedRange] originalRange = " + entry.getOriginalRange() + ", transformedRange = " + entry.getTransformedRange()))
                .map(SourceMappingEntry::getTransformedRange)
                .findFirst();
    }

    private Optional<SymbolInfo> resolveClassSymbol(MethodInvocationInfo info) {
        return Optional.ofNullable(info.receiver)
                .map(className -> currentSymbolTable.resolve(className));
    }

    private Optional<SymbolInfo> resolveMethod(SymbolTable classSymbolTable, MethodInvocationInfo info) {
//        System.err.println("[resolveMethod] classSymbolTable = " + classSymbolTable);
//        System.err.println("[resolveMethod] classSymbolTable.hasSuperClassTable() = " + classSymbolTable.hasSuperClassTable());
//        System.err.println("[resolveMethod] classSymbolTable.superClassTable() = " + classSymbolTable.getSuperClassTable());
//        System.err.println("[resolveMethod] classSymbolTable.superIntefaceTable() = " + classSymbolTable.getSuperInterfaceTables());

        String methodName = resolveMethodName(info);
        List<String> candidates = MethodUtils.getCandidates(methodName, info.paramTypes);
        candidates.forEach(c -> log("[InstanceCreationExpression] candidate = " + c));

        for (String candidate : candidates) {
            //Optional<SymbolInfo> methodSymbolInfo = classSymbolTable.resolveInCurrent(candidate);
            //Optional<SymbolInfo> methodSymbolInfo = classSymbolTable.resolveInCurrent(candidate, EnumSet.of(TypeInfo.Type.Constructor, TypeInfo.Type.Method));

            //var methodSymbolInfo = classSymbolTable.resolveInCurrent(candidate);
            var methodSymbolInfo = classSymbolTable.resolve(candidate);
            System.err.println("[resolveMethod] methodSymbolInfo = " + methodSymbolInfo);
            
            if (methodSymbolInfo != null) return Optional.of(methodSymbolInfo);
        }

        return Optional.empty();
    }

    private String resolveMethodName(MethodInvocationInfo info) {
        return Objects.equals(info.receiver, info.methodName) ? "constructor" : info.methodName;
    }

    private void validateMethodArguments(
            MethodInvocationSignatureContextAdapter ctx,
            MethodInvocationInfo info,
            SymbolInfo methodSymbolInfo
    ) {
        String methodName = resolveMethodName(info);
        //String rawParamTypes = methodSymbolInfo.getSymbol().substring(("^" + methodName + "$_").length());
        String rawParamTypes = methodSymbolInfo.getSymbol().substring(("^" + methodName + "$~").length());
        String[] paramTypes = rawParamTypes.isEmpty() ? new String[0] : rawParamTypes.split("~");

        List<JPlus25Parser.ExpressionContext> argumentList = Optional.ofNullable(ctx.argumentList()).map(argList -> argList.expression()).orElseGet(() -> new ArrayList<>());

//        if (argumentList.size() != paramTypes.length) {
//            throw new IllegalStateException("The number of arguments is not equal. argumentList.size() = " + argumentList.size() + ", paramTypes.length = " + paramTypes.length);
//        }

        int fixedVariableCnt = paramTypes.length;
        if (fixedVariableCnt > 0 && info.hasVarArgs) {
            --fixedVariableCnt;
        }

        for (int i = 0; i < fixedVariableCnt; i++) {

            System.err.println("[validateMethodArguments] argument = " + Utils.getTokenString(argumentList.get(i)));

            visit(argumentList.get(i));

            NullState argState = evalRHS(argumentList.get(i), currentSymbolTable);

            System.err.println("[validateMethodArguments] paramType = " + paramTypes[i]);
            System.err.println("[validateMethodArguments] argState = " + argState);

            if (isInvalidNullAssignment(paramTypes[i], argState)) {
                reportInvalidNull(ctx.originalContext(), info, i + 1);
            }
        }

        for (int i = fixedVariableCnt; i < argumentList.size(); ++i) {

            visit(argumentList.get(i));

            NullState argState = evalRHS(argumentList.get(i), currentSymbolTable);
//            if (argState != NullState.NON_NULL) {
            if (isInvalidNullAssignment(paramTypes[fixedVariableCnt], argState)) {
                reportInvalidNull(ctx.originalContext(), info, i + 1);
            }
        }

    }

    private boolean isInvalidNullAssignment(@NonNull String argType, NullState argState) {

        if (argType.endsWith("?")) return false;

        return argState == NullState.NULL || argState == NullState.UNKNOWN;
    }

    private void reportInvalidNull(
            ParserRuleContext ctx,
            MethodInvocationInfo info,
            int argIndex
    ) {
        String suffix = getOrdinalSuffix(argIndex);
        String msg = String.format("The %s argument of the %s is a non-nullable variable, but a null value is assigned to it.", argIndex + suffix, info.getInvocationInfoMessage());

        reportIssue(ctx.start, msg);
    }



    private void log(String msg) {
        System.err.println(msg);
    }

    @Override
    public Void visitUnqualifiedClassInstanceCreationExpression(JPlus25Parser.UnqualifiedClassInstanceCreationExpressionContext ctx) {

        TextChangeRange codeRange = getCodeRange(ctx);
        if (consumedExpressions.contains(codeRange)) {
            return null;
        }

        Optional<TextChangeRange> transformedRange = findTransformedRange(codeRange);
        if (transformedRange.isEmpty()) {
            throw new IllegalStateException("cannot find a mapping java code range.");
            //return super.visitUnqualifiedClassInstanceCreationExpression(ctx);
        }

        /*Optional<ResolvedChain> chain = currentSymbolTable.findResolvedChain(transformedRange.get());
        if (chain.isPresent()) {
            // 이미 PrimaryNoNewArray에서 처리됨
            return null;
        }*/

        Optional<MethodInvocationInfo> invocationInfo = methodInvocationManager.findInvocationInfo(currentSymbolTable, transformedRange.get());
        if (invocationInfo.isEmpty()) {
            throw new IllegalStateException("cannot find a method invocation info." + transformedRange.get());
        }

        invocationInfo.ifPresent(info -> {
            log("[InstanceCreationExpression] InvocationInfo = " + info);

            Optional<SymbolInfo> classSymbolInfo = resolveClassSymbol(info);
            if (classSymbolInfo.isEmpty()) {
                throw new IllegalStateException("cannot find a symbolinfo related to the symbol(" + info.receiver + ")");
            }
            ////System.err.println("[InstanceCreationExpression] symbolInfo = " + classSymbolInfo.get());
            //System.err.println("[UnqualifiedClass] classSymbolInfo = " + classSymbolInfo.get());

            SymbolTable classSymbolTable = resolveClassSymbolTable(classSymbolInfo.get());
            //System.err.println("[UnqualifiedClass] classSymbolTable = " + classSymbolTable);
            Optional<SymbolInfo> constructorSymbol = resolveMethod(classSymbolTable, info);
            if (constructorSymbol.isEmpty()) {
                throw new IllegalStateException("cannot find a mapping constructor.");
            }

            validateMethodArguments(MethodInvocationSignatureContextAdapter.from(ctx), info, constructorSymbol.get());
        });

        return super.visitUnqualifiedClassInstanceCreationExpression(ctx);
    }


    private static String getOrdinalSuffix(int number) {
        if (number % 100 >= 11 && number % 100 <= 13) {
            return "th";
        }

        return switch (number % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

    @Override
    public Void visitLocalVariableDeclaration(JPlus25Parser.LocalVariableDeclarationContext ctx) {

        //System.err.println("[LocalVariableDeclaration] line(" + ctx.start.getLine() + ") contextString: " + Utils.getTokenString(ctx));

        var variableDeclarator = ctx.variableDeclaratorList().variableDeclarator();
        for (var decl : variableDeclarator) {

            String symbol = Utils.getTokenString(decl.variableDeclaratorId());
            System.err.println("[NullabilityChecker][LocalVariable] symbol = " + symbol);

            System.err.println("[NullabilityChecker][LocalVariable] currentSymbolTable = " + currentSymbolTable);
            System.err.println("[NullabilityChecker][LocalVariable] currentSymbolTable.parent = " + currentSymbolTable.getParent());
            System.err.println("[NullabilityChecker][LocalVariable] currentSymbolTable.parent = " + currentSymbolTable.getParent().getParent());

            SymbolInfo symbolInfo = currentSymbolTable.resolve(symbol);
            System.err.println("[NullabilityChecker][LocalVariable] symbolInfo = " + symbolInfo);

            TypeInfo typeInfo = symbolInfo.getTypeInfo();

            if (decl.variableInitializer() != null) {

                visit(decl.variableInitializer());

                NullState rhsState = evalRHS(decl.variableInitializer(), currentSymbolTable);
                System.err.println("[NullabilityChecker][LocalVariable] rhsState = " + rhsState);

                if (!typeInfo.isNullable() && rhsState == NullState.NULL) {
                    reportIssue(ctx.getStart(), symbol + " is a non-nullable variable. But null value is assigned to it.");
                }

                if (typeInfo.getType() != TypeInfo.Type.Primitive && !typeInfo.isNullable() && rhsState == NullState.UNKNOWN) {
                    reportIssue(ctx.getStart(), String.format("%s is a non-nullable variable. But nullable value is assigned to it. Change the type to %s? or add a null check.", symbol, CodeUtils.getSimpleName(typeInfo.getName())));
                }

                SymbolInfo updated = symbolInfo.toBuilder()
                        .nullState(rhsState)
                        .build();

                //currentSymbolTable.declare(symbol, updated);
                symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
                //System.err.println("[NullabilityChecker][LocalVariable] updated symbolInfo = " + currentSymbolTable.resolve(symbol));
            } else {

                if (!typeInfo.isNullable() && typeInfo.getType() == TypeInfo.Type.Reference) {

                    SymbolInfo updated = symbolInfo.toBuilder()
                            .nullState(NullState.UNKNOWN)
                            .build();

                    symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
                    //System.err.println("[NullabilityChecker][LocalVariable] updated symbolInfo = " + currentSymbolTable.resolve(symbol));

                    reportIssue(
                            ctx.getStart(),
                            String.format("Variable '%s' might not have been initialized.", symbol)
                    );
                }
            }
        }

        //return super.visitLocalVariableDeclaration(ctx);
        return null;
    }

    @Override
    public Void visitAssignment(JPlus25Parser.AssignmentContext ctx) {


        //System.err.println("[NullabilityChecker][Assignment] contextString = " + Utils.getTokenString(ctx));

        String symbol = Utils.getTokenString(ctx.leftHandSide());

        //System.err.println("[NullabilityChecker][Assignment]symbol = " + symbol);
        //System.err.println("[NullabilityChecker][Assignment]currentSymbolTable = " + currentSymbolTable);

        SymbolInfo symbolInfo = currentSymbolTable.resolve(symbol);
        if (symbolInfo == null) {
            var symbolInfoOpt = resolveSymbolInfo(ctx.leftHandSide());
            if (symbolInfoOpt.isPresent()) {
                symbolInfo = symbolInfoOpt.get();
                log("[NullabilityChecker][Assignment] symbolInfo = " + symbolInfo);
            } else {
                //throw new IllegalStateException(String.format("There is no symbolInfo(%s).", symbol));
                log(String.format("There is no symbolInfo(%s).", symbol));
                //return super.visitAssignment(ctx);
                return null;
            }
        }

        TypeInfo typeInfo = symbolInfo.getTypeInfo();

        visit(ctx.expression());

        NullState rhsState = evalRHS(ctx.expression(), currentSymbolTable);
        log("[NullabilityChecker][Assignment] rhsState = " + rhsState);
        if (typeInfo.getType() == TypeInfo.Type.Reference && !typeInfo.isNullable() && rhsState != NullState.NON_NULL) {
            reportIssue(ctx.getStart(), symbol + " is a non-nullable variable. But null value is assigned to it.");
        }

        SymbolInfo updated = symbolInfo.toBuilder()
                .nullState(rhsState)
                .build();

        if (!ifContextStack.isEmpty()) {
            System.err.println("isIfContext");
            //currentSymbolTable.putIfContext(symbolInfo.getSymbol(), updated);
            var ifContext = ifContextStack.peek();
            ifContext.declare(symbolInfo.getSymbol(), updated.toBuilder().symbolTable(ifContext).build());

            currentSymbolTable.declare(symbolInfo.getSymbol(), updated.toBuilder().symbolTable(currentSymbolTable).build());
            /*if (currentSymbolTable.containsInCurrent(symbolInfo.getSymbol(), symbolInfo.getTypeInfo().getType())) {
                currentSymbolTable.declare(symbolInfo.getSymbol(), updated.toBuilder().symbolTable(currentSymbolTable).build());
                System.err.println("[NullabilityChecker][Assignment] updated symbolInfo = " + currentSymbolTable.resolve(symbolInfo.getSymbol()));
            } else {
                currentSymbolTable.putIfContext(symbolInfo.getSymbol(), updated);
            }*/
        } else {
            symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
        }

        //currentSymbolTable.declare(symbol, updated);
        //System.err.println("[NullabilityChecker][Assignment] updated symbolInfo = " + updated.getSymbolTable().resolve(symbolInfo.getSymbol()));
        //System.err.println("[NullabilityChecker][Assignment] updated symbolTable = " + updated.getSymbolTable());


        var constructorContext = constructorContextStack.peek();
        if (constructorContext != null) {
            //constructorContext.put(updated.getSymbol(), InitState.INIT);
            constructorContext.put(symbolInfo.getSymbol(), InitState.INIT);
        }
        //System.err.println("[constructorContext] " + constructorContext);

        //return super.visitAssignment(ctx);
        return null;
    }

    private Optional<SymbolInfo> resolveSymbolInfo(ParserRuleContext ctx) {
        //System.err.println("[resolveSymbolInfo] line(" + ctx.start.getLine() + ") contextString: " + Utils.getTokenString(ctx));
        //System.err.println("[resolveSymbolInfo] resolvedChains: " + currentSymbolTable.getResolvedChains());

        var ctxRange = Utils.getTextChangeRange(originalText, ctx);
        //System.err.println("[resolveSymbolInfo] original range = " + ctxRange);

        var mappedRangeOpt = findTransformedRange(ctxRange);
        if (mappedRangeOpt.isEmpty()) {
            return Optional.empty();
        }

        //System.err.println("[resolveSymbolInfo] mapped range = " + mappedRangeOpt.get());

        var resolvedChainOpt = currentSymbolTable.findResolvedChain(mappedRangeOpt.get());
        if (resolvedChainOpt.isEmpty()) {
            return Optional.empty();
        }

        //System.err.println("[resolveSymbolInfo] findResolvedChain = " + resolvedChainOpt.get());

        SymbolInfo symbolInfo = null;
        var cursor = resolvedChainOpt.get().stepCursor();

        SymbolTable symbolTable = currentSymbolTable;
        while (cursor.hasNext()) {
            var step = cursor.consume();
            log("[resolvedSymbolInfo] step = " + step.symbol);
            /*if ("this".equals(step.symbol)) {
                var symInfo = globalSymbolTable.resolveInCurrent(step.typeInfo.getName());
                symbolTable = symInfo.getSymbolTable().getEnclosingSymbolTable(symInfo.getSymbol());
                continue;
            }*/

            if (step.kind == ResolvedChain.Kind.IDENTIFIER || step.kind == ResolvedChain.Kind.FIELD) {
                log("[resolvedSymbolInfo] symbolTable = " + symbolTable);
                symbolInfo = symbolTable.resolve(step.symbol);
                log("[resolvedSymbolInfo] symbolInfo = " + symbolInfo);

                if (cursor.hasNext() && List.of(TypeInfo.Type.Class, TypeInfo.Type.Reference).contains(symbolInfo.getTypeInfo().getType())) {
                    var classSymbolInfo = globalSymbolTable.resolveInCurrent(symbolInfo.getTypeInfo().getName());
                    symbolTable = classSymbolInfo.getSymbolTable().getEnclosingSymbolTable(classSymbolInfo.getSymbol());
                }
                //symbolTable = symbolInfo.getSymbolTable().getEnclosingSymbolTable(symbolInfo.getSymbol());
            }
        }

        return Optional.ofNullable(symbolInfo);
    }

    @Override
    public Void visitIfThenStatement(JPlus25Parser.IfThenStatementContext ctx) {

        SymbolTable entry = currentSymbolTable.copy();

        //System.err.println("[IfThenElseStatement] line(" + ctx.expression().start.getLine() + ") = " + Utils.getTokenString(ctx.expression()));

        var conditionResult = new ConditionVisitor(this, entry.copy()).visit(ctx.expression());

        System.err.println("[IfThenElse][then] whenTrue SymbolTable(" + ctx.getStart().getLine() + ") = " + conditionResult.whenTrue);
        System.err.println("[IfThenElse][else] whenFalse SymbolTable(" + ctx.getStart().getLine() + ") = " + conditionResult.whenFalse);

        currentSymbolTable = conditionResult.whenTrue;
        enterSymbolTable("^then$" + ctx.getStart().getLine());

        conditionResult.whenTrue.transplantLocalSymbols(currentSymbolTable);
        ifContextStack.push(new SymbolTable(null));

        visit(ctx.statement());

        var deltaSymbolTable = ifContextStack.pop();
        var whenTrue = currentSymbolTable.promoteLocalSymbols();

        deltaSymbolTable.transplantLocalSymbols(whenTrue);

        exitSymbolTable();

        System.err.println("[IfThenElse][then] whenTrue SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        if (!ifContextStack.isEmpty()) {
            deltaSymbolTable.transplantLocalSymbols(ifContextStack.peek());
        }

        if (whenTrue.isDeadContext() && conditionResult.whenFalse.isDeadContext()) {
            currentSymbolTable = entry;
        } else if (whenTrue.isDeadContext()) {
            currentSymbolTable = conditionResult.whenFalse;
        } else if (conditionResult.whenFalse.isDeadContext()) {
            currentSymbolTable = whenTrue;
        } else {
            currentSymbolTable = join(whenTrue, conditionResult.whenFalse);
        }

        return null;
    }

    @Override
    public Void visitIfThenElseStatement(JPlus25Parser.IfThenElseStatementContext ctx) {

        SymbolTable entry = currentSymbolTable.copy();

        //System.err.println("[IfThenElseStatement] line(" + ctx.expression().start.getLine() + ") = " + Utils.getTokenString(ctx.expression()));

        var conditionResult = new ConditionVisitor(this, entry.copy()).visit(ctx.expression());

        //System.err.println("[IfThenElse][then] whenTrue SymbolTable = " + conditionResult.whenTrue);
        //System.err.println("[IfThenElse][else] whenFalse SymbolTable = " + conditionResult.whenFalse);

        currentSymbolTable = conditionResult.whenTrue;
        enterSymbolTable("^then$" + ctx.getStart().getLine());

        conditionResult.whenTrue.transplantLocalSymbols(currentSymbolTable);
        ifContextStack.push(new SymbolTable(null));

        visit(ctx.statementNoShortIf());

        var trueDeltaSymbolTable = ifContextStack.pop();
        var whenTrue = currentSymbolTable.promoteLocalSymbols();

        trueDeltaSymbolTable.transplantLocalSymbols(whenTrue);

        exitSymbolTable();

        System.err.println("[IfThenElse][then] whenTrue SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        currentSymbolTable = conditionResult.whenFalse;
        enterSymbolTable("^else$" + ctx.getStart().getLine());

        conditionResult.whenFalse.transplantLocalSymbols(currentSymbolTable);
        ifContextStack.push(new SymbolTable(null));

        visit(ctx.statement());

        var falseDeltaSymbolTable = ifContextStack.pop();
        var whenFalse = currentSymbolTable.promoteLocalSymbols();

        falseDeltaSymbolTable.transplantLocalSymbols(whenFalse);
        System.err.println("[IfThenElse][else] whenFalse falseDeltaSymbolTable(" + ctx.getStart().getLine() + ") = " + falseDeltaSymbolTable);

        exitSymbolTable();

        System.err.println("[IfThenElse][else] whenFalse SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        var joinedDeltaSymbolTable = join(trueDeltaSymbolTable, falseDeltaSymbolTable);
        if (!ifContextStack.isEmpty()) {
            joinedDeltaSymbolTable.transplantLocalSymbols(ifContextStack.peek());
        }

        if (whenTrue.isDeadContext() && whenFalse.isDeadContext()) {
            currentSymbolTable = entry;
        } else if (whenTrue.isDeadContext()) {
            currentSymbolTable = whenFalse;
        } else if (whenFalse.isDeadContext()) {
            currentSymbolTable = whenTrue;
        } else {
            currentSymbolTable = join(whenTrue, whenFalse);
        }

        System.err.println("[IfThenElse][join] SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        return null;
    }

    @Override
    public Void visitIfThenElseStatementNoShortIf(JPlus25Parser.IfThenElseStatementNoShortIfContext ctx) {

        SymbolTable entry = currentSymbolTable.copy();

        //System.err.println("[IfThenElseStatement] line(" + ctx.expression().start.getLine() + ") = " + Utils.getTokenString(ctx.expression()));

        var conditionResult = new ConditionVisitor(this, entry.copy()).visit(ctx.expression());

        //System.err.println("[IfThenElse][then] whenTrue SymbolTable = " + conditionResult.whenTrue);
        //System.err.println("[IfThenElse][else] whenFalse SymbolTable = " + conditionResult.whenFalse);

        currentSymbolTable = conditionResult.whenTrue;
        enterSymbolTable("^then$" + ctx.getStart().getLine());

        conditionResult.whenTrue.transplantLocalSymbols(currentSymbolTable);
        ifContextStack.push(new SymbolTable(null));

        visit(ctx.statementNoShortIf(0));

        var trueDeltaSymbolTable = ifContextStack.pop();
        var whenTrue = currentSymbolTable.promoteLocalSymbols();

        trueDeltaSymbolTable.transplantLocalSymbols(whenTrue);

        exitSymbolTable();

        System.err.println("[IfThenElse][then] whenTrue SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        currentSymbolTable = conditionResult.whenFalse;
        enterSymbolTable("^else$" + ctx.getStart().getLine());

        conditionResult.whenFalse.transplantLocalSymbols(currentSymbolTable);
        ifContextStack.push(new SymbolTable(null));

        visit(ctx.statementNoShortIf(1));

        var falseDeltaSymbolTable = ifContextStack.pop();
        var whenFalse = currentSymbolTable.promoteLocalSymbols();

        falseDeltaSymbolTable.transplantLocalSymbols(whenFalse);
        System.err.println("[IfThenElse][else] whenFalse falseDeltaSymbolTable(" + ctx.getStart().getLine() + ") = " + falseDeltaSymbolTable);

        exitSymbolTable();

        System.err.println("[IfThenElse][else] whenFalse SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        var joinedDeltaSymbolTable = join(trueDeltaSymbolTable, falseDeltaSymbolTable);
        if (!ifContextStack.isEmpty()) {
            joinedDeltaSymbolTable.transplantLocalSymbols(ifContextStack.peek());
        }

        if (whenTrue.isDeadContext() && whenFalse.isDeadContext()) {
            currentSymbolTable = entry;
        } else if (whenTrue.isDeadContext()) {
            currentSymbolTable = whenFalse;
        } else if (whenFalse.isDeadContext()) {
            currentSymbolTable = whenTrue;
        } else {
            currentSymbolTable = join(whenTrue, whenFalse);
        }

        System.err.println("[IfThenElse][join] SymbolTable(" + ctx.getStart().getLine() + ") = " + currentSymbolTable);

        return null;
    }

    SymbolTable join(SymbolTable a, SymbolTable b) {
        if (a.isDeadContext()) return b;
        if (b.isDeadContext()) return a;

        SymbolTable joined = a.copy();

        // a ∪ b
        Set<String> symbols = new HashSet<>();

        a.keyIterator().forEachRemaining(symbols::add);
        b.keyIterator().forEachRemaining(symbols::add);

        for (String symbol : symbols) {
            var sa = a.resolveInCurrent(symbol);
            var sb = b.resolveInCurrent(symbol);

            if (sa == null) {
                joined.declare(symbol, sb);
                continue;
            }

            if (sb == null) {
                joined.declare(symbol, sa);
                continue;
            }


            NullState ns = NullState.join(sa.getNullState(), sb.getNullState());

            joined.declare(
                    symbol,
                    sa.toBuilder().nullState(ns).symbolTable(joined).build()
            );
        }

        return joined;
    }

    @Override
    public Void visitYieldStatement(JPlus25Parser.YieldStatementContext ctx) {
        if (!switchContextStack.isEmpty()) {
            var nullState = evalRHS(ctx.expression(), currentSymbolTable);
            switchContextStack.peek().addNullState(Utils.getTokenString(ctx.expression()), nullState);
        }
        return super.visitYieldStatement(ctx);
    }

    @Override
    public Void visitSwitchExpression(JPlus25Parser.SwitchExpressionContext ctx) {

        return processSwitchBlock(SwitchExprStmtContext.from(ctx));
    }

    @Override
    public Void visitSwitchStatement(JPlus25Parser.SwitchStatementContext ctx) {

        return processSwitchBlock(SwitchExprStmtContext.from(ctx));
    }

    private Void processSwitchBlock(SwitchExprStmtContext ctx) {

        var selectorScope = currentSymbolTable;

        var selector = ctx.expression();
        if (selector != null) {

            var conditionNullState = evalRHS(ctx.expression(), currentSymbolTable);
            if (!hasNullCase(ctx) && conditionNullState != NullState.NON_NULL) {

                reportIssue(
                        ctx.getStart(),
                        String.format("Switch selector expression(%s) is nullable; this may cause a NullPointerException.", Utils.getTokenString(ctx.expression()))
                );
            }
        }


        var switchExprNullState = NullState.UNKNOWN;
        //var saved = currentSymbolTable.copy();
        enterSymbolTable("^block$" + ctx.getStart().getLine());

        var switchRuleList = ctx.switchBlock().switchRule();
        if (switchRuleList != null) {
            switchExprNullState = processSwitchRule(switchRuleList, selector, selectorScope);
        }

        var switchBlkStmtGrpList = ctx.switchBlock().switchBlockStatementGroup();
        if (switchBlkStmtGrpList != null) {
            processSwitchBlkStmtGrp(switchBlkStmtGrpList, selector, selectorScope);
        }

        exitSymbolTable();

        var symbol = "^SwitchExpression$" + + ctx.getStart().getStartIndex();
        currentSymbolTable.declare(
                symbol,
                SymbolInfo.builder()
                        .symbol(symbol)
                        .typeInfo(TypeInfo.builder()
                                .name("^SwitchExpression$")
                                .type(TypeInfo.Type.Null)
                                .build())
                        .nullState(switchExprNullState)
                        .build()
        );

        return null;
    }

    private boolean hasNullCase(SwitchExprStmtContext ctx) {
        var switchLabelListInSwitchRule = ctx.switchBlock().switchRule().stream().map(JPlus25Parser.SwitchRuleContext::switchLabel).toList();
        var switchLabelListInswitchBlkStmtGrp = ctx.switchBlock().switchBlockStatementGroup().stream().map(JPlus25Parser.SwitchBlockStatementGroupContext::switchLabel).flatMap(switchLabelList -> switchLabelList.stream()).toList();

        var switchLabelList = new ArrayList<JPlus25Parser.SwitchLabelContext>();
        switchLabelList.addAll(switchLabelListInSwitchRule);
        switchLabelList.addAll(switchLabelListInswitchBlkStmtGrp);

        return hasNullCase(switchLabelList);
    }

    private void processSwitchBlkStmtGrp(List<JPlus25Parser.SwitchBlockStatementGroupContext> switchBlkStmtGrpList, JPlus25Parser.ExpressionContext selector, SymbolTable selectorScope) {

        for (var switchBlkStmtGrpCtx : switchBlkStmtGrpList) {
            enterSymbolTable("^block$" + switchBlkStmtGrpCtx.switchLabel().stream().map(Utils::getTokenString).map(tokenStr -> tokenStr.replaceAll("case\\s+", "").replace(" ", "")).collect(Collectors.joining("")));
            //System.err.println("[SwitchStatement] enclosing = " + "^block$" + switchBlkStmtGrpCtx.switchLabel().stream().map(Utils::getTokenString).map(tokenStr -> tokenStr.replaceAll("case\\s+", "").replace(" ", "")).collect(Collectors.joining("")));

            for (var switchLabelCtx : switchBlkStmtGrpCtx.switchLabel()) {
                for (var caseConstCtx : switchLabelCtx.caseConstant()) {
                    if (isNullLiteral(caseConstCtx)) {
                        //System.err.println("[SwitchStatement] case null");
                        updateNullState(selector, currentSymbolTable, NullState.NULL);

                        //System.err.println("[SwitchStatement] currentSymbolTable = " + currentSymbolTable);
                        break;
                    }
                }
            }

            if (switchBlkStmtGrpCtx.blockStatements() != null) visit(switchBlkStmtGrpCtx.blockStatements());

            exitSymbolTable();
        }
    }

    private boolean isNullLiteral(JPlus25Parser.CaseConstantContext ctx) {
        var expr = ctx.conditionalExpression();
        if (expr == null) return false;

        // simplest safe check
        return "null".equals(Utils.getTokenString(expr));
    }

    private boolean hasNullCase(List<JPlus25Parser.SwitchLabelContext> switchLabelCtxList) {
        for (var switchLabelCtx : switchLabelCtxList) {
            if (switchLabelCtx.NullLiteral() != null) {
                return true;
            }
        }
        return false;
    }

    private NullState processSwitchRule(List<JPlus25Parser.SwitchRuleContext> switchRuleList, JPlus25Parser.ExpressionContext selector, SymbolTable selectorScope) {

        var switchContext = new SwitchContext();
        switchContextStack.push(switchContext);

        for (var switchRuleCtx : switchRuleList) {
            enterSymbolTable("^block$" + Utils.getTokenString(switchRuleCtx.switchLabel()).replaceAll("case\\s+", "").replace(" ", ""));
            //System.err.println("[SwitchStatement] enclosing = " + "^block$" + Utils.getTokenString(switchRuleCtx.switchLabel()).replaceAll("case\\s+", "").replace(" ", ""));

            var casePatternList = switchRuleCtx.switchLabel().casePattern();
            if (casePatternList != null) {
                for (var casePatternCtx : casePatternList) {

                    var typePattern = casePatternCtx.pattern().typePattern();
                    var recordPattern = casePatternCtx.pattern().recordPattern();

                    if (typePattern != null) {
                        var varDefIdCtx = typePattern.localVariableDeclaration().variableDeclaratorList().variableDeclarator(0).variableDeclaratorId();
                        var symbol = Utils.getTokenString(varDefIdCtx);

                        var symbolInfo = currentSymbolTable.resolveInCurrent(symbol);
                        //System.err.println("[SwitchStatement] resolvedChaining = " + currentSymbolTable.getResolvedChains());

                        //System.err.println("[SwitchStatement] symbolTable = " + currentSymbolTable);
                        //System.err.println("[SwitchStatement] symbolInfo = " + symbolInfo);

                        currentSymbolTable.declare(
                                symbol,
                                symbolInfo.toBuilder()
                                        .nullState(NullState.NON_NULL)
                                        .build()
                        );

                        //System.err.println("[SwitchStatement] updated symbolInfo = " + currentSymbolTable.resolve(symbol));

                        var guard = switchRuleCtx.switchLabel().guard();
                        if (guard != null) {
                            var guardNullState = evalRHS(guard, currentSymbolTable);
                            if (guardNullState != NullState.NON_NULL) {
                                reportIssue(
                                        guard.start,
                                        String.format("Possible NullPointerException in switch guard expression(%s).", Utils.getTokenString(guard))
                                );
                            }
                        }

                    } else if (recordPattern != null) {

                    }
                }
            }

            if (switchRuleCtx.switchLabel().NullLiteral() != null) {
                //updateNullState(selector, selectorScope, NullState.NULL);
                updateNullState(selector, currentSymbolTable, NullState.NULL);
            }

            if (switchRuleCtx.expression() != null) {
                visit(switchRuleCtx.expression());

                var caseNullState = evalRHS(switchRuleCtx.expression(), currentSymbolTable);
                switchContext.addNullState(Utils.getTokenString(switchRuleCtx.expression()), caseNullState);
            }

            if (switchRuleCtx.block() != null) {
                visit(switchRuleCtx.block());
            }

            if (switchRuleCtx.throwStatement() != null) {
                visit(switchRuleCtx.throwStatement());
            }

            exitSymbolTable();
        }

        try {
            //System.err.println("[processSwitchRule] switchContext = " + switchContext);
            return switchContext.join();
        } finally {
            switchContextStack.pop();
        }
    }

    @Override
    public Void visitConditionalExpression(JPlus25Parser.ConditionalExpressionContext ctx) {

        if (ctx.expression() == null) {
            return super.visitNullCoalescingExpression(ctx.nullCoalescingExpression());
        }

        SymbolTable entry = currentSymbolTable.copy();
//
//        SymbolTable thenTable = before.copy();
//        currentSymbolTable = thenTable;
//
//        SymbolTable elseTable = before.copy();

        var conditionResult = new ConditionVisitor(this, entry).visit(ctx.nullCoalescingExpression());
        System.err.println("[ConditionalExpression] line(" + ctx.start.getLine() + ", " + ctx.start.getStartIndex() + "), contextString = " + Utils.getTokenString(ctx) + ", conditionResult = " + conditionResult);

        currentSymbolTable = conditionResult.whenTrue;
        visit(ctx.expression());

        currentSymbolTable = conditionResult.whenFalse;
        Void elseResult =
                (ctx.conditionalExpression() != null)
                        ? visit(ctx.conditionalExpression())
                        : visit(ctx.lambdaExpression());

        //currentSymbolTable = join(before, join(conditionResult.whenTrue, conditionResult.whenFalse));
        //currentSymbolTable = join(conditionResult.whenTrue, conditionResult.whenFalse);

        if (conditionResult.whenTrue.isDeadContext() && conditionResult.whenFalse.isDeadContext()) {
            //currentSymbolTable = new SymbolTable(null);
            currentSymbolTable = entry;
        } else if (conditionResult.whenTrue.isDeadContext()) {
            //currentSymbolTable = conditionResult.whenFalse;
        } else if (conditionResult.whenFalse.isDeadContext()) {
            currentSymbolTable = conditionResult.whenTrue;
        } else {
            //currentSymbolTable = join(before, join(thenTable, elseTable));
            //currentSymbolTable = join(conditionResult.whenTrue, conditionResult.whenFalse);
            currentSymbolTable = join(conditionResult.whenTrue, currentSymbolTable);
        }

        var expr1 = ctx.expression();
        var expr2 = (ctx.conditionalExpression() != null)
                ? ctx.conditionalExpression()
                : ctx.lambdaExpression();

        var expr1NullState = evalRHS(expr1, conditionResult.whenTrue);
        //System.err.println("[ConditionalExpression] expr1NullState: " + expr1NullState);

        var expr2NullState = evalRHS(expr2, conditionResult.whenFalse);
        //System.err.println("[ConditionalExpression] expr2NullState: " + expr2NullState);

        var joinedNullState = NullState.join(expr1NullState, expr2NullState);
        //System.err.println("[ConditionalExpression] joinedNullState: " + expr2NullState);

        currentSymbolTable.declare(
                "^ConditionalExpression$" + ctx.start.getStartIndex(),
                SymbolInfo.builder()
                        .symbol("^ConditionalExpression$" + ctx.start.getStartIndex())
                        .typeInfo(TypeInfo.builder()
                                .name("^ConditionalExpression$")
                                .type(TypeInfo.Type.Null)
                                .build())
                        .nullState(joinedNullState).build()
        );

        return null;
    }

    NullState updateNullState(ParserRuleContext ctx, SymbolTable symbolTable, NullState nullState) {
        System.err.println("[updateNullState] line(" + ctx.start.getLine() + ") contextString: " + Utils.getTokenString(ctx));
        //System.err.println("[updateNullState] resolvedChains: " + symbolTable.getResolvedChains());

        var ctxRange = Utils.getTextChangeRange(originalText, ctx);
        //System.err.println("[updateNullState] original range = " + ctxRange);

        var mappedRangeOpt = findTransformedRange(ctxRange);
        if (mappedRangeOpt.isEmpty()) {
            return NullState.UNKNOWN;
        }

        //System.err.println("[updateNullState] mapped range = " + mappedRangeOpt.get());

        var resolvedChainOpt = symbolTable.findResolvedChain(mappedRangeOpt.get());
        if (resolvedChainOpt.isEmpty()) {

            var parent = symbolTable.getParent();
            while(parent != null && resolvedChainOpt.isEmpty()) {
                resolvedChainOpt = parent.findResolvedChain(mappedRangeOpt.get());
                parent = parent.getParent();
            }

            if (parent == null) return NullState.UNKNOWN;
        }

        //System.err.println("[updateNullState] findResolvedChain = " + resolvedChainOpt.get());

        var resolvedChain = resolvedChainOpt.get();
        if (resolvedChain.isEmpty()) {
            return NullState.UNKNOWN;
        }

        //System.err.println("[updateNullState] resolvedChain = " + resolvedChain);

        var prevNullState = NullState.UNKNOWN;
        var step = resolvedChain.first();
        SymbolInfo symbolInfo = symbolTable.resolve(step.symbol);
        System.err.println("[updateNullState] step.symbol = " + step.symbol);
        System.err.println("[updateNullState] symbolInfo = " + symbolInfo);

        if (symbolInfo != null) {
            prevNullState = symbolInfo.getNullState();
            SymbolInfo updated = symbolInfo.toBuilder()
                    .nullState(nullState)
                    .build();
            System.err.println("[updateNullState] updated = " + updated);

            symbolTable.declare(symbolInfo.getSymbol(), updated);
            System.err.println("[updateNullState] updated symbolInfo = " + symbolTable.resolveInCurrent(symbolInfo.getSymbol()));
        }

        return prevNullState;
    }

    private List<ParseTree> getDereferenceLeaves(ParseTree node) {
        if (node instanceof JPlus25Parser.EqualityExpressionContext) {
            return List.of(node);
        }

        List<ParseTree> leaves = new ArrayList<>();
        for (int i = 0; i < node.getChildCount(); i++) {
            leaves.addAll(getDereferenceLeaves(node.getChild(i)));
        }
        return leaves;
    }

    @Override
    public Void visitReturnStatement(JPlus25Parser.ReturnStatementContext ctx) {
        //System.err.println("[ReturnStatement] contextString: " + Utils.getTokenString(ctx));

        currentSymbolTable.setDeadContext(true);

        if (ctx.expression() != null) {

            MethodContext methodContext = (MethodContext) contextStack.peek();
            //System.err.println("[ReturnStatement] methodContext: " + methodContext);

            var returnType = methodContext.getMethodSymbolInfo().getTypeInfo().getReturnTypeInfo().getType();

            if (returnType == TypeInfo.Type.Void) {
                return null;
            }

            if (returnType == TypeInfo.Type.Primitive) {
                return visit(ctx.expression());
            }

            NullState nullState = evalRHS(ctx.expression(), currentSymbolTable);
            //System.err.println("[ReturnStatement] nullState: " + nullState);

            //System.err.println("[ReturnStatement] resolvedChains: " + currentSymbolTable.getResolvedChains());
            //System.err.println("[ReturnStatement] original range = " + Utils.getTextChangeRange(originalText, ctx.expression()));

            findTransformedRange(Utils.getTextChangeRange(originalText, ctx.expression())).ifPresent(range -> {
                //System.err.println("[ReturnStatement] mapped range = " + range);
                //System.err.println("[ReturnStatement] findResolvedChain = " + currentSymbolTable.findResolvedChain(range));

                currentSymbolTable.findResolvedChain(range)
                        .ifPresent(chain -> handleMethodReturn(ctx, methodContext, chain, nullState));
            });
        }

        return super.visitReturnStatement(ctx);
    }

    private void handleMethodReturn(JPlus25Parser.ReturnStatementContext ctx, MethodContext methodContext, ResolvedChain chain, NullState nullState) {
        var methodSymbolInfo = methodContext.getMethodSymbolInfo();
        var step = chain.last();

        if (!methodSymbolInfo.getTypeInfo().getReturnTypeInfo().isNullable() && (step.nullable || nullState != NullState.NON_NULL)) {
            reportIssue(
                    ctx.start,
                    String.format("The method(%s) is declared to return a non-null value, but this return statement may return null.", methodContext.getMethodName())
            );
        }
    }

    @Override
    public Void visitThrowStatement(JPlus25Parser.ThrowStatementContext ctx) {
        currentSymbolTable.setDeadContext(true);
        return super.visitThrowStatement(ctx);
    }

    @Override
    public Void visitEnhancedForStatement(JPlus25Parser.EnhancedForStatementContext ctx) {

        //visit(ctx.enhancedForDeclaration().localVariableDeclaration());

        String symbol = Utils.getTokenString(ctx.enhancedForDeclaration().localVariableDeclaration().variableDeclaratorList().variableDeclarator().get(0).variableDeclaratorId());

        SymbolInfo symbolInfo = currentSymbolTable.resolveInCurrent(symbol);
        SymbolInfo updated = symbolInfo.toBuilder()
                .nullState(NullState.NON_NULL)
                .build();

        //symbolInfo.getSymbolTable()symbolInfo.getSymbolTable().declare(symbolInfo.getSymbol(), updated);
        currentSymbolTable.declare(symbolInfo.getSymbol(), updated);

        return visit(ctx.statement());
    }

    @Override
    public Void visitEqualityExpression(JPlus25Parser.EqualityExpressionContext ctx) {
        if (ctx.NOTEQUAL() != null) {
            String variableName = Utils.getTokenString(ctx.equalityExpression());
            String value = Utils.getTokenString(ctx.relationalExpression());
            if ("null".equals(value)) {
                SymbolInfo symbolInfo = currentSymbolTable.resolve(variableName);
                if (symbolInfo != null) {
                    TypeInfo typeInfo = symbolInfo.getTypeInfo();
                    if (typeInfo.isNullable()) {
                        TypeInfo newTypeInfo = typeInfo.toBuilder()
                                                    .isNullable(false)
                                                    .build();

                        SymbolInfo newSymbolInfo = symbolInfo.toBuilder()
                                                            .typeInfo(newTypeInfo)
                                                            .build();

                        currentSymbolTable.declare(variableName, newSymbolInfo);
                    }
                }
            }
        }

        return super.visitEqualityExpression(ctx);
    }

    @Override
    public Void visitAdditiveExpression(JPlus25Parser.AdditiveExpressionContext ctx) {
        ////System.err.println("[AdditiveExpression] line(" + ctx.start.getLine() + ") contextString: " + Utils.getTokenString(ctx));
        ////System.err.println("[AdditiveExpression] resolvedChains: " + currentSymbolTable.getResolvedChains());

        if (ctx.additiveExpression() == null) {
            return super.visitAdditiveExpression(ctx);
        }

        visit(ctx.additiveExpression());
        visit(ctx.multiplicativeExpression());

        return null;
    }

    @Override
    public Void visitExplicitConstructorInvocation(JPlus25Parser.ExplicitConstructorInvocationContext ctx) {
        //System.err.println("[ExplicitConstructorInvocation] resolvedChains: " + currentSymbolTable.getResolvedChains());
        //System.err.println("[ExplicitConstructorInvocation] original range = " + Utils.getTextChangeRange(originalText, ctx));

        //System.err.println("[ExplicitConstructorInvocation] contextString = " + Utils.getTokenString(ctx));

        findTransformedRange(Utils.getTextChangeRange(originalText, ctx))
                .ifPresent(range -> {
                    //System.err.println("[ExplicitConstructorInvocation] mapped range = " + range);
                    //System.err.println("[ExplicitConstructorInvocation] findResolvedChain = " + currentSymbolTable.findResolvedChain(new TextChangeRange(range.startLine(), range.startIndex(), range.endLine(), range.inclusiveEndIndex() - 1)));

                    currentSymbolTable.findResolvedChain(new TextChangeRange(range.startLine(), range.startIndex(), range.endLine(), range.inclusiveEndIndex() - 1))
                        .ifPresent(chain -> { if (ctx.THIS() != null) handleExplicitConstructorInvocation(ctx, chain); });
        });

        return null;
    }

    private void handleExplicitConstructorInvocation(JPlus25Parser.ExplicitConstructorInvocationContext ctx, ResolvedChain chain) {
        String methodSymbol = "^constructor$~" + String.join("~", chain.first().invocationInfo.paramTypes);
        //System.err.println("[handleExplicitConstructorInvocation] methodSymbol = " + methodSymbol);

        String simpleMethodSymbol = "^constructor$~" + String.join("~", chain.first().invocationInfo.paramTypes.stream().map(CodeUtils::getSimpleName).toList());
        //System.err.println("[handleExplicitConstructorInvocation] methodSymbol = " + methodSymbol);

        var classContext = classContextStack.peek();
        classContextStack.peek().getCtorDefContext(simpleMethodSymbol)
                .ifPresent(invocationDefCtx -> {
                    //System.err.println("[handleExplicitConstructorInvocation] invoke this()");

                    var saved = currentSymbolTable;

                    currentSymbolTable =
                            classContext.getClassSymbolTable()
                                    .getEnclosingSymbolTable(methodSymbol)
                                    .getEnclosingSymbolTable("^block$");

                    //System.err.println("[handleExplicitConstructorInvocation] currentSymbolTable = " + currentSymbolTable);

                    try {
                        var constructorBody = (JPlus25Parser.ConstructorBodyContext) invocationDefCtx.invocationBody();

                        if (constructorBody.blockStatements(0) != null) visit(constructorBody.blockStatements(0));
                        if (constructorBody.explicitConstructorInvocation() != null) visit(constructorBody.explicitConstructorInvocation());
                        if (constructorBody.blockStatements(1) != null) visit(constructorBody.blockStatements(1));
                    } finally {
                        currentSymbolTable = saved;
                    }
                });
    }

    @Override
    public Void visitMethodInvocation(JPlus25Parser.MethodInvocationContext ctx) {
        TextChangeRange invocationCodeRange = getCodeRange(ctx);
        //System.err.println("[MethodInvocation] invocationCodeRange: " + invocationCodeRange);

        return processMethodInvocation(ctx);
    }

    private Void processMethodInvocation(JPlus25Parser.MethodInvocationContext ctx) {
        //System.err.println("[MethodInvocation] resolvedChains: " + currentSymbolTable.getResolvedChains());
        //System.err.println("[MethodInvocation] original range = " + Utils.getTextChangeRange(originalText, ctx));

        findTransformedRange(Utils.getTextChangeRange(originalText, ctx)).ifPresent(range -> {
            //System.err.println("[MethodInvocation] mapped range = " + range);
            //System.err.println("[MethodInvocation] findResolvedChain = " + currentSymbolTable.findResolvedChain(range));

            currentSymbolTable.findResolvedChain(range)
                    .ifPresentOrElse(chain -> handleMethodInvocation(ctx, chain),
                            () -> currentSymbolTable.findResolvedQualifierChain(range)
                                        .ifPresent(chain -> handleMethodInvocation(ctx, chain))
                    );
        });

        //return super.visitMethodInvocation(ctx);
        return null;
    }

    private void handleMethodInvocation(JPlus25Parser.MethodInvocationContext ctx, ResolvedChain chain) {
        StepCursor cursor = chain.stepCursor();

        //methodName '(' argumentList? ')'
        if (ctx.methodName() != null) {
            processImplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
            return;
        }

        //expressionName ('.'|'?.') typeArguments? identifier '(' argumentList? ')'
        if (ctx.expressionName() != null) {
            handleExpressionName(ctx.expressionName(), cursor);
            processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
            return;
        }

        //primary ('.'|'?.') typeArguments? identifier '(' argumentList? ')'
        if (ctx.primary() != null) {
            super.visitPrimary(ctx.primary());
            //handlePrimaryNoNewArray();

            StepCursor qualifierLastCursor = new StepCursor(List.of(chain.qualifierLast(), chain.last()));
            qualifierLastCursor.consume();

            processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), qualifierLastCursor);
            return;
        }

        //typeName '.' typeArguments? identifier '(' argumentList? ')'
        if (ctx.typeName() != null) {
            processTypeName(ctx.typeName(), cursor);

            //typeName '.' 'super' '.' typeArguments? identifier '(' argumentList? ')'
            if (ctx.SUPER() != null) {
                cursor.consume();
            }

            processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
        }

        //'super' '.' typeArguments? identifier '(' argumentList? ')'
        if (ctx.SUPER() != null) {
            cursor.consume();
            processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
        }
    }

    @Override
    public Void visitPostfixExpression(JPlus25Parser.PostfixExpressionContext ctx) {
        if (ctx.expressionName() != null) {
            //System.err.println("[PostfixExpression] chaining = " + currentSymbolTable.getResolvedChains());
            //System.err.println("[PostfixExpression] findResolvedChain = " + currentSymbolTable.findResolvedChain(Utils.getTextChangeRange(originalText, ctx)));

            currentSymbolTable.findResolvedChain(Utils.getTextChangeRange(originalText, ctx)).ifPresent(chain -> processExpressionNameContext(getExpressionNameList(ctx.expressionName()), chain.stepCursor()));
            return null;
        }

        return super.visitPostfixExpression(ctx);
    }

    private Optional<ResolvedChain> findPrimaryNoNewArrayChain(JPlus25Parser.PrimaryNoNewArrayContext ctx) {
        //System.err.println("[PrimaryNoNewArray] line(" + ctx.start.getLine() + ") contextString = " + Utils.getTokenString(ctx));
        //System.err.println("[PrimaryNoNewArray] line(" + ctx.start.getLine() + ") chaining = " + currentSymbolTable.getResolvedChains());

        TextChangeRange originalRange = Utils.getTextChangeRange(originalText, ctx);
        //System.err.println("[PrimaryNoNewArray] original range = " + originalRange);

        return findTransformedRange(originalRange)
                .map(mappedRange -> {
                    //System.err.println("[PrimaryNoNewArray] mapped range = " + mappedRange);
                    Optional<ResolvedChain> chain = currentSymbolTable.findResolvedChain(mappedRange);
                    //System.err.println("[PrimaryNoNewArray] findResolvedChain = " + chain);
                    return chain.orElseGet(() -> currentSymbolTable.findResolvedQualifierChain(mappedRange).orElse(null));
                });
    }

    private void withPrimaryNoNewArrayChain(JPlus25Parser.PrimaryNoNewArrayContext ctx, Consumer<ResolvedChain> chainConsumer) {
        findPrimaryNoNewArrayChain(ctx).ifPresent(chainConsumer);
    }

    @Override
    public Void visitPrimaryNoNewArrayThis(JPlus25Parser.PrimaryNoNewArrayThisContext ctx) {
        //'this' pNNA? #primaryNoNewArrayThis
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> PrimaryNoNewArrayThis(PrimaryNoNewArrayContextAdapter.from(ctx), resolvedChain.stepCursor()));
        return null;
    }

    @Override
    public Void visitPrimaryNoNewArrayQualifiedThis(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx) {
        //typeName '.' 'this' pNNA?
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayQualifiedThis(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayQualifiedThis(JPlus25Parser.PrimaryNoNewArrayQualifiedThisContext ctx, StepCursor cursor) {
        processTypeName(ctx.typeName(), cursor);
        PrimaryNoNewArrayThis(PrimaryNoNewArrayContextAdapter.from(ctx), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayClassInstanceCreationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handleUnqualifiedClassInstanceCreationExpression(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter.from(ctx), resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayClassInstanceCreation(ctx);
        return null;
    }

    @Override
    public Void visitPrimaryNoNewArrayExprQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handleExprQualifiedClassInstanceCreation(ctx, resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayClassInstanceCreation(ctx);
        return null;
    }

    /*@Override
    public Void visitPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayArrayQualifiedClassInstanceCreation(ctx, resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayArrayQualifiedClassInstanceCreation(ctx);
        return null;
    }

    private void handlePrimaryNoNewArrayArrayQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayArrayQualifiedClassInstanceCreationContext ctx, StepCursor cursor) {
        //ResolvedChain.Step step = cursor.consume();
        //if (!step.symbol.equals(Utils.getTokenString(ctx.arrayCreationExpression()))) throw new IllegalStateException();

        cursor.consume(); //skip: arrayCreationExpression

        handleUnqualifiedClassInstanceCreationExpression(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter.from(ctx), cursor);

    }*/

    /*@Override
    public Void visitPrimaryNoNewArrayArrayFieldAccess(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayArrayFieldAccess(ctx, resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayArrayFieldAccess(ctx);
        return null;
    }

    private void handlePrimaryNoNewArrayArrayFieldAccess(JPlus25Parser.PrimaryNoNewArrayArrayFieldAccessContext ctx, StepCursor cursor) {
        cursor.consume(); //skip: arrayCreationExpression

        ResolvedChain.Step step = cursor.consume();
        if (!step.symbol.equals(Utils.getTokenString(ctx.identifier()))) throw new IllegalStateException();

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }*/

    @Override
    public Void visitPrimaryNoNewArrayExprMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayExprMethodInvocation(ctx, resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayExprMethodInvocation(ctx);
        return null;

    }

    private void handlePrimaryNoNewArrayExprMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx, StepCursor cursor) {
        handleExpressionName(ctx.expressionName(), cursor);
        handlePrimaryNoNewArrayMethodInvocation(ctx, cursor);
    }

    @Override
    public Void visitPrimaryNoNewArraySuperFieldAccess(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArraySuperFieldAccess(ctx, resolvedChain.stepCursor()));
        //return super.visitPrimaryNoNewArrayExprMethodInvocation(ctx);
        return null;
    }

    private void handlePrimaryNoNewArraySuperFieldAccess(JPlus25Parser.PrimaryNoNewArraySuperFieldAccessContext ctx, StepCursor cursor) {
        ResolvedChain.Step step = cursor.consume();
        if (!step.symbol.equals(ctx.SUPER().toString())) throw new IllegalStateException();

        step = cursor.consume();
        if (!step.symbol.equals(Utils.getTokenString(ctx.identifier()))) throw new IllegalStateException();

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayQualifiedSuperFieldAccess(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayQualifiedSuperFieldAccess(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayQualifiedSuperFieldAccess(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperFieldAccessContext ctx, StepCursor cursor) {
        processTypeName(ctx.typeName(), cursor);

        ResolvedChain.Step step = cursor.consume();
        if (!step.symbol.equals(ctx.SUPER().toString())) throw new IllegalStateException();

        step = cursor.consume();
        if (!step.symbol.equals(Utils.getTokenString(ctx.identifier()))) throw new IllegalStateException();

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayArrayAccess(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayArrayAccess(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayArrayAccess(JPlus25Parser.PrimaryNoNewArrayArrayAccessContext ctx, StepCursor cursor) {
        //need dataflow
        //expressionName '[' expression ']' pNNA?
        //must handle the front part of `expressionName '[' expression ']'`
        ResolvedChain.Step step = cursor.consume();
        log("[handlePrimaryNoNewArrayArrayAccess] step.symbol = " + step.symbol);

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayArrayCreationWithInitAccess(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayArrayCreationWithInitAccess(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayArrayCreationWithInitAccess(JPlus25Parser.PrimaryNoNewArrayArrayCreationWithInitAccessContext ctx, StepCursor cursor) {
        //arrayCreationExpressionWithInitializer '[' expression ']' pNNA?
        //must handle `arrayCreationExpressionWithInitializer '[' expression ']'`
        //so must add the support for `arrayCreationExpressionWithInitializer '[' expression ']'`in symbol analyzer.

        ResolvedChain.Step step = cursor.consume();
        log("[PrimaryNoNewArrayArrayCreationWithInitAccess] step.symbol = " + step.symbol);

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> processImplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), resolvedChain.stepCursor()));
        return null;
    }

    private void processImplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter ctx, StepCursor cursor) {
        var currentStep = cursor.consume();
        System.err.println("[handlePrimaryNoNewArrayMethodInvocation] currentStep = " + currentStep);

        String methodName = Utils.getTokenString(ctx.methodName());
        System.err.println("[handlePrimaryNoNewArrayMethodInvocation] methodName = " + methodName);

        //if (!Objects.equals(methodName, currentStep.symbol)) throw new IllegalStateException();

        while (!Objects.equals(methodName, currentStep.symbol) && cursor.hasNext()) {
            currentStep = cursor.consume();
        }

        System.err.println("[processImplicitReceiverMethodInvocationSignature] currentStep = " + currentStep);

        //if (!cursor.hasNext()) throw new IllegalStateException();

        System.err.println("[handlePrimaryNoNewArrayMethodInvocation] methodInvocationInfo = " + currentStep.invocationInfo);

        TypeInfo receiverTypeInfo = currentSymbolTable.resolve("^TopLevelClass$").getTypeInfo();
        if (currentStep.invocationInfo.isStatic()) {
            receiverTypeInfo = globalSymbolTable.resolveInCurrent(currentStep.invocationInfo.receiver).getTypeInfo();
        }
        System.err.println("[handlePrimaryNoNewArrayMethodInvocation] receiverTypeInfo = " + receiverTypeInfo);

        validateMethodArgumentNullability(ctx, receiverTypeInfo.getName(), currentStep);

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    private void handlePrimaryNoNewArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayExprMethodInvocationContext ctx, StepCursor cursor) {
        var prevStep = cursor.peekPrev().orElseThrow(() -> new IllegalStateException("A ExpressionName rule needed."));
        var currentStep = cursor.consume();

        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] prevStep = " + prevStep);
        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] currentStep = " + currentStep);

        String receiverName = prevStep.symbol;
        String methodName = Utils.getTokenString(ctx.identifier());
        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] methodName = " + methodName);

        if (!Objects.equals(methodName, currentStep.symbol)) throw new IllegalStateException();

        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] methodInvocationInfo = " + currentStep.invocationInfo);

        TypeInfo receiverTypeInfo = prevStep.typeInfo;
        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] receiverTypeInfo = " + receiverTypeInfo);

        SymbolInfo symbolInfo = currentSymbolTable.resolve(receiverName);
        NullState nullState = NullState.UNKNOWN;
        if (symbolInfo != null) {
            //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] symbolInfo = " + symbolInfo);
            nullState = symbolInfo.getNullState();
        }
        //System.err.println("[handlePrimaryNoNewArrayMethodInvocation] nullState = " + nullState);

        //check instance nullability
        boolean useNullsafeOperator = (ctx.NULLSAFE() != null);
        if (receiverTypeInfo.isNullable() && nullState != NullState.NON_NULL && !useNullsafeOperator) {
            reportIssue(
                    ctx.getStart(),
                    String.format("%s is a nullable variable. But it directly accesses %s(). Consider using null-safe operator(?.).", receiverName, methodName)
            );
        }

        validateMethodArgumentNullability(MethodInvocationSignatureContextAdapter.from(ctx), receiverTypeInfo.getName(), currentStep);

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayTypeMethodInvocation(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayTypeMethodInvocation(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayTypeMethodInvocation(JPlus25Parser.PrimaryNoNewArrayTypeMethodInvocationContext ctx, StepCursor cursor) {
        processTypeName(ctx.typeName(), cursor);
        processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
    }

    private void processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter ctx, StepCursor cursor) {
        var prevStep = cursor.peekPrev().orElseThrow(() -> new IllegalStateException("A TypeName rule needed."));
        var currentStep = cursor.consume();

        System.err.println("[handlePrimaryNoNewArrayTypeMethodInvocation] prevStep = " + prevStep);
        System.err.println("[handlePrimaryNoNewArrayTypeMethodInvocation] currentStep = " + currentStep);

        String methodName = Utils.getTokenString(ctx.identifier());
        System.err.println("[handlePrimaryNoNewArrayTypeMethodInvocation] methodName = " + methodName);

        if (!Objects.equals(methodName, currentStep.symbol)) throw new IllegalStateException();

        System.err.println("[handlePrimaryNoNewArrayTypeMethodInvocation] methodInvocationInfo = " + currentStep.invocationInfo);

        TypeInfo receiverTypeInfo = prevStep.typeInfo;
        System.err.println("[handlePrimaryNoNewArrayTypeMethodInvocation] receiverTypeInfo = " + receiverTypeInfo);

        //check instance nullability
        boolean useNullsafeOperator = (ctx.NULLSAFE() != null);
        boolean isReceiverNullable = receiverTypeInfo.isNullable();

        var receiverSymInfo = currentSymbolTable.resolve(prevStep.symbol);

        if (receiverSymInfo != null) {  //NullState

            if (receiverSymInfo.getNullState() != NullState.NON_NULL && !useNullsafeOperator) {
                reportIssue(
                        ctx.getStart(),
                        String.format("%s is a nullable variable. But it directly accesses %s(). Consider using null-safe operator(?.).", prevStep.symbol, methodName)
                );
            }
        } else {  //TypeCheck

            if (isReceiverNullable && !useNullsafeOperator) {
                reportIssue(
                        ctx.getStart(),
                        String.format("%s is a nullable variable. But it directly accesses %s(). Consider using null-safe operator(?.).", prevStep.symbol, methodName)
                );
            }
        }

        validateMethodArgumentNullability(ctx, receiverTypeInfo.getName(), currentStep);

        //ExpressionResult exprResult = new ExpressionResult(currentStep.typeInfo, NullState.UNKNOWN);

        //handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    /*@Override
    public Void visitPrimaryNoNewArrayArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayArrayMethodInvocation(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayArrayMethodInvocation(JPlus25Parser.PrimaryNoNewArrayArrayMethodInvocationContext ctx, StepCursor cursor) {
        //skip: arrayCreationExpression
        cursor.consume();

        processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
    }*/

    private void handleExprQualifiedClassInstanceCreation(JPlus25Parser.PrimaryNoNewArrayExprQualifiedClassInstanceCreationContext ctx, StepCursor cursor) {
        handleExpressionName(ctx.expressionName(), cursor);
        handleUnqualifiedClassInstanceCreationExpression(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter.from(ctx), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArraySuperMethodInvocation(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArraySuperMethodInvocation(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArraySuperMethodInvocation(JPlus25Parser.PrimaryNoNewArraySuperMethodInvocationContext ctx, StepCursor cursor) {
        //'super' '.' typeArguments? identifier '(' argumentList? ')' pNNA?
        //skip: super
        cursor.consume();
        processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
    }


    @Override
    public Void visitPrimaryNoNewArrayQualifiedSuperMethodInvocation(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayQualifiedSuperMethodInvocation(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayQualifiedSuperMethodInvocation(JPlus25Parser.PrimaryNoNewArrayQualifiedSuperMethodInvocationContext ctx, StepCursor cursor) {
        processTypeName(ctx.typeName(), cursor);
        //skip: super
        cursor.consume();
        processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
    }

    @Override
    public Void visitPrimaryNoNewArrayExprMethodReference(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx) {
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayprimaryNoNewArrayExprMethodReference(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayprimaryNoNewArrayExprMethodReference(JPlus25Parser.PrimaryNoNewArrayExprMethodReferenceContext ctx, StepCursor cursor) {
        //expressionName '::' typeArguments? identifier pNNA?
        handleExpressionName(ctx.expressionName(), cursor);
    }


    @Override
    public Void visitPrimaryNoNewArrayParenExpression(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx) {
        //'(' expression ')' pNNA?
        withPrimaryNoNewArrayChain(ctx, resolvedChain -> handlePrimaryNoNewArrayParenExpression(ctx, resolvedChain.stepCursor()));
        return null;
    }

    private void handlePrimaryNoNewArrayParenExpression(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx, StepCursor cursor) {
        handleExpressionWithParenthesis(ctx, cursor);
    }

    private void handleExpressionWithParenthesis(JPlus25Parser.PrimaryNoNewArrayParenExpressionContext ctx, StepCursor cursor) {
        log("[handleExpressionWithParenthesis] expression = " + Utils.getTokenString(ctx.expression()));
        log("[handleExpressionWithParenthesis] step = " + cursor.peek());

        super.visitExpression(ctx.expression());

        if (ctx.pNNA() != null) {

            String pnnaSymbol = Utils.getTokenString(ctx.pNNA()).replaceAll("^\\.", "");
            log("[handleExpressionWithParenthesis] pnnaSymbol = " + pnnaSymbol);

            while(cursor.hasNext()) {

                var step = cursor.peek().orElseThrow(IllegalStateException::new);

                var isMethodStep = step.kind == ResolvedChain.Kind.METHOD;
                if (isMethodStep) {
                    if (pnnaSymbol.startsWith(step.symbol)) break;
                } else {
                    if (Objects.equals(pnnaSymbol, step.symbol)) break;
                }

                log("[handleExpressionWithParenthesis] cursor.peek() = " + cursor.peek().orElseThrow(IllegalStateException::new).symbol);

                cursor.consume();
            }

            handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
        }
    }

    private void processTypeName(JPlus25Parser.TypeNameContext ctx, StepCursor cursor) {
        processPackageName(ctx.packageName(), cursor);
        processTypeIdentifier(ctx.typeIdentifier(), cursor);
    }

    private void processTypeIdentifier(JPlus25Parser.TypeIdentifierContext ctx, StepCursor cursor) {
        if (ctx == null) return;

        var step = cursor.consume();
        if (!Objects.equals(step.symbol, Utils.getTokenString(ctx))) throw new IllegalStateException();
    }

    private void processPackageName(JPlus25Parser.PackageNameContext ctx, StepCursor cursor) {
        if (ctx == null) return;

        var step = cursor.consume();
        if (!Objects.equals(step.symbol, Utils.getTokenString(ctx.identifier()))) throw new IllegalStateException();

        processPackageName(ctx.packageName(), cursor);
    }

    private void handleUnqualifiedClassInstanceCreationExpression(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter ctx, StepCursor cursor) {
        consumedExpressions.add(Utils.getTextChangeRange(originalText, ctx.unqualifiedClassInstanceCreationExpression()));
        log("[consumedExpressions] " + consumedExpressions);

        cursor.peekPrev().ifPresent(prevStep -> {
            if (prevStep.typeInfo.isNullable() && ctx.NULLSAFE() == null) {
                reportIssue(
                        ctx.getStart(),
                        String.format("%s is a nullable variable. But it directly accesses %s. Consider using null-safe operator(?.).", prevStep.typeInfo.getName(), Utils.getTokenString(ctx.unqualifiedClassInstanceCreationExpression()))
                );
            }
        });

        var curStep = cursor.consume();
        log("[unqualifiedClassInstanceCreationExpression] currentStep = " + curStep);

        String typeName = curStep.typeInfo.getName();
        //String typeName = currentStep.invocationInfo.typeInfo.getName();
        log("[unqualifiedClassInstanceCreationExpression] typeName = " + typeName);

        validateMethodArgumentNullability(MethodInvocationSignatureContextAdapter.from(ctx), typeName, curStep);

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);

        super.visitUnqualifiedClassInstanceCreationExpression(ctx.unqualifiedClassInstanceCreationExpression());
    }

    private void PrimaryNoNewArrayThis(PrimaryNoNewArrayContextAdapter ctx, StepCursor cursor) {
        //System.err.println("[handleThisPrimary]");
        processThis(ctx, cursor);
    }

    private void processThis(PrimaryNoNewArrayContextAdapter ctx, StepCursor cursor) {

        ResolvedChain.Step step = cursor.consume();
        while (!step.symbol.equals(ctx.THIS().toString()) && cursor.hasNext()) {
            step = cursor.consume();
        }

        System.err.println("[processThis] step = " + step);

        if (!cursor.hasNext()) throw new IllegalStateException();

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    private void handlePNNA(PNNAContextAdapter ctx, StepCursor cursor) {
        if (ctx == null) return;

        log("[handlePNNA] original context = " + ctx.originalContext().getClass().getSimpleName());
        log("[handlePNNA] context string = " + Utils.getTokenString(ctx.originalContext()));
        var originalCtx = ctx.originalContext();
        if (originalCtx instanceof JPlus25Parser.PNNAClassInstanceCreationContext instanceCreationContext) {
            processPNNAClassInstanceCreation(instanceCreationContext, cursor);
        } else if (originalCtx instanceof JPlus25Parser.PNNAFieldAccessContext fieldAccessContext) {
            processPNNAFieldAccessContext(fieldAccessContext, cursor);
        } else if (originalCtx instanceof JPlus25Parser.PNNAArrayAccessContext arrayAccessContext) {
            processPNNAArrayAccessContext(arrayAccessContext);
        } else if (originalCtx instanceof JPlus25Parser.PNNAMethodInvocationContext methodInvocationContext) {
            processPNNAMethodInvocationContext(methodInvocationContext, cursor);
        } else if (originalCtx instanceof JPlus25Parser.PNNAMethodReferenceContext methodReferenceContext) {
            processPNNAMethodReferenceContext(methodReferenceContext);
        }

        handlePNNA(PNNAContextAdapter.from(ctx.pNNA()), cursor);
    }

    private void processPNNAMethodReferenceContext(JPlus25Parser.PNNAMethodReferenceContext methodReferenceContext) {
    }

    private void processPNNAMethodInvocationContext(JPlus25Parser.PNNAMethodInvocationContext ctx, StepCursor cursor) {
        processExplicitReceiverMethodInvocationSignature(MethodInvocationSignatureContextAdapter.from(ctx), cursor);
        if (ctx.argumentList() != null) super.visitChildren(ctx.argumentList());
    }

    private void processPNNAArrayAccessContext(JPlus25Parser.PNNAArrayAccessContext arrayAccessContext) {
    }

    private void processPNNAFieldAccessContext(JPlus25Parser.PNNAFieldAccessContext ctx, StepCursor cursor) {
        ResolvedChain.Step prevStep = cursor.peekPrev().orElse(null);
        //System.err.println("[processPNNAFieldAccessContext] prevStep = " + prevStep);

        if (isUnsafeNullableAccess(PNNAContextAdapter.from(ctx), prevStep)) {
            reportIssue(
                    ctx.start,
                    prevStep.symbol + " is a nullable variable. But it directly accesses "
                            + Utils.getTokenString(ctx.identifier()) + ". Consider using null-safe operator(?.)."
            );
        }

        cursor.consume();
    }

    private void processPNNAClassInstanceCreation(JPlus25Parser.PNNAClassInstanceCreationContext instanceCreationContext, StepCursor cursor) {
        handleUnqualifiedClassInstanceCreationExpression(PrimaryNoNewArrayUnqualifiedClassInstanceCreationContextAdapter.from(instanceCreationContext), cursor);
    }

    private boolean isUnsafeNullableAccess(PNNAContextAdapter ctx, ResolvedChain.Step prevStep) {
        return prevStep != null
                && prevStep.typeInfo.isNullable()
                && ctx.NULLSAFE() == null;
    }

    private void handleExpressionName(JPlus25Parser.ExpressionNameContext ctx, StepCursor cursor) {
        var expressionNameList = getExpressionNameList(ctx);
        processExpressionNameContext(expressionNameList, cursor);
    }

    private void validateMethodArgumentNullability(MethodInvocationSignatureContextAdapter ctx, String typeName, ResolvedChain.Step invocationStep) {
        globalSymbolTable
            .resolveInCurrent(typeName, EnumSet.of(TypeInfo.Type.Class))
            .ifPresent(receiverClassSymbolInfo -> {
                //System.err.println("[handleExpressionNameInternal] receiverClassSymbolInfo = " + receiverClassSymbolInfo);

                //check method parameter nullability
                SymbolTable classSymbolTable = resolveReceiverClassContextSymbolTable(receiverClassSymbolInfo);
                if (!classSymbolTable.isEmpty()) {
                    SymbolInfo methodSymbolInfo = resolveMethod(classSymbolTable, invocationStep.invocationInfo).orElseThrow(() -> new IllegalStateException("cannot find a mapping method."));

                    validateMethodArguments(ctx, invocationStep.invocationInfo, methodSymbolInfo);
                }
            });
    }

    private SymbolTable resolveReceiverClassContextSymbolTable(SymbolInfo receiverClassSymbolInfo) {
        SymbolTable symbolTable = receiverClassSymbolInfo.getSymbolTable();
        return symbolTable.getEnclosingSymbolTable(receiverClassSymbolInfo.getSymbol());
    }

    private void processExpressionNameContext(List<JPlus25Parser.ExpressionNameContext> expressionNameList, StepCursor cursor) {

        ResolvedChain.Step prevStep = null;
        SymbolInfo prevSymbolInfo = null;

        SymbolTable symbolTable = currentSymbolTable;
        SymbolInfo symbolInfo = null;

        for (JPlus25Parser.ExpressionNameContext ctx : expressionNameList) {

            var step = cursor.consume();
            var rangeOpt = findTransformedRange(Utils.getTextChangeRange(originalText, ctx));
            while (rangeOpt.isPresent() && !rangeOpt.get().contains(step.range)) {
                System.err.println("[processExpressionNameContext] skip step = " + step);

                //System.err.println("[processExpressionNameContext] jplus range = " + rangeOpt.get());
                System.err.println("[processExpressionNameContext] step range = " + step.range);
                step = cursor.consume();
            }

            String identifier = Utils.getTokenString(ctx.identifier());
            System.err.println("[processExpressionNameContext] step.symbol = " + step.symbol);
            if (!identifier.equals(step.symbol)) throw new IllegalStateException();

            System.err.println("[processExpressionNameContext] line(" + ctx.start.getLine() + ")" );


            if (step.kind == ResolvedChain.Kind.IDENTIFIER || step.kind == ResolvedChain.Kind.FIELD) {
                log("[processExpressionNameContext] symbolTable = " + symbolTable);
                symbolInfo = symbolTable.resolve(step.symbol);
                log("[processExpressionNameContext] symbolInfo = " + symbolInfo);

                if (cursor.hasNext() && symbolInfo != null && List.of(TypeInfo.Type.Class, TypeInfo.Type.Reference).contains(symbolInfo.getTypeInfo().getType())) {
                    var classSymbolInfo = globalSymbolTable.resolveInCurrent(symbolInfo.getTypeInfo().getName());
                    symbolTable = classSymbolInfo.getSymbolTable().getEnclosingSymbolTable(classSymbolInfo.getSymbol());
                }
                //symbolTable = symbolInfo.getSymbolTable().getEnclosingSymbolTable(symbolInfo.getSymbol());
            }


            if (prevStep != null && prevStep.typeInfo.isNullable() && ctx.NULLSAFE() == null && symbolInfo != null && symbolInfo.getNullState() != NullState.NON_NULL) {
                reportIssue(
                        ctx.start,
                        prevStep.symbol + " is a nullable variable. But it directly accesses "
                                + identifier + ". Consider using null-safe operator(?.)."
                );
            }

            prevStep = step;
            prevSymbolInfo = symbolInfo;
        }
    }

    private List<JPlus25Parser.ExpressionNameContext> getExpressionNameList(JPlus25Parser.ExpressionNameContext ctx) {
        Deque<JPlus25Parser.ExpressionNameContext> expressionNameContextDeque = new ArrayDeque<>();
        JPlus25Parser.ExpressionNameContext current = ctx;
        expressionNameContextDeque.addFirst(current);
        while (current.expressionName() != null) {
            current = current.expressionName();
            expressionNameContextDeque.addFirst(current);
        }
        return expressionNameContextDeque.stream().toList();
    }

    public boolean hasPassed() {
        return hasPassed;
    }
}
