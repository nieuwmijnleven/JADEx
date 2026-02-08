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

package jplus.analyzer;

import com.sun.source.tree.*;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import jplus.analyzer.nullability.dataflow.NullState;
import jplus.analyzer.util.CleanTypePrinter;
import jplus.base.JavaMethodInvocationManager;
import jplus.base.MethodInvocationInfo;
import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.generator.TextChangeRange;
import jplus.util.MethodUtils;
import jplus.util.TypeUtils;
import jplus.util.Utils;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JavaSymbolAnalyzer extends TreePathScanner<Void, Void> {

    private final String source;
    private final CompilationUnitTree ast;
    private final Trees trees;
    private final SymbolTable globalSymbolTable;
    private final SymbolTable topLevelSymbolTable;
    private SymbolTable currentSymbolTable;

    private final Elements elements;
    private final Types types;

    private String packageName;

    private final JavaMethodInvocationManager javaMethodInvocationManager;
    private final JavaSymbolResolver resolver;

    final class ExpressionChainBuilder {

        private final Trees trees;
        private final Types types;
        private final JavaSymbolResolver resolver;
        private final CompilationUnitTree ast;
        private final String source;
        private final JavaMethodInvocationManager invocationManager;

        ExpressionChainBuilder(
                Trees trees,
                Types types,
                JavaSymbolResolver resolver,
                CompilationUnitTree ast,
                String source,
                JavaMethodInvocationManager invocationManager
        ) {
            this.trees = trees;
            this.types = types;
            this.resolver = resolver;
            this.ast = ast;
            this.source = source;
            this.invocationManager = invocationManager;
        }

        public ResolvedChain build(ExpressionTree expr) {
            ResolvedChain chain = new ResolvedChain();
            visit(expr, chain);
            return chain;
        }

        private void visit(ExpressionTree expr, ResolvedChain chain) {
            if (expr instanceof ParenthesizedTree p) {
                ResolvedChain child = new ResolvedChain();
                visit(p.getExpression(), child);
                chain.addStep(new ResolvedChain.Step(
                        ResolvedChain.Kind.CHAIN,
                        expr.toString(),
                        child.last() != null ? child.last().typeInfo : null,
                        child.last() != null ? child.last().typeInfo.isNullable() : false,
                        false,
                        computeRange(expr),
                        null,
                        child
                ));

                return;
            }

            //if (expr instanceof BinaryTree bt && bt.getKind() == Tree.Kind.PLUS) {
            if (expr instanceof BinaryTree bt && (bt.getKind() != Tree.Kind.EQUAL_TO && bt.getKind() != Tree.Kind.NOT_EQUAL_TO && bt.getKind() != Tree.Kind.GREATER_THAN && bt.getKind() != Tree.Kind.GREATER_THAN_EQUAL && bt.getKind() != Tree.Kind.LESS_THAN && bt.getKind() != Tree.Kind.LESS_THAN_EQUAL)) {

                visit(bt.getLeftOperand(), chain);

                visit(bt.getRightOperand(), chain);

                return;
            }

            while (true) {
                /*if (expr instanceof ParenthesizedTree p) {
                    expr = p.getExpression();
                } else*/
                if (expr instanceof TypeCastTree c) {
                    expr = c.getExpression();
                } else if (expr instanceof UnaryTree u) {
                    expr = u.getExpression();
                } else {
                    break;
                }
            }

            if (expr instanceof ArrayAccessTree aa) {

                visit(aa.getExpression(), chain);

                ResolvedChain.Step lastStep = chain.last();
                if (lastStep != null && lastStep.typeInfo.getType() == TypeInfo.Type.Array) {
                    TypeInfo elementType = lastStep.typeInfo.getElementType();
                    String indexedSymbol = lastStep.symbol + "[" + aa.getIndex().toString() + "]";

                    chain.updateLastStep(step -> step.toBuilder()
                            .kind(ResolvedChain.Kind.ARRAY_ACCESS)
                            .symbol(indexedSymbol)
                            .typeInfo(elementType)
                            .nullable(elementType.isNullable())
                            .range(computeRange(aa))
                            .build());
                }
                return;
            }

            /*if (expr instanceof ConditionalExpressionTree ct) {
                visit(ct.getTrueExpression(), chain);
                visit(ct.getFalseExpression(), chain);
                return;
            }*/

            if (expr instanceof AssignmentTree at) {
                visit(at.getExpression(), chain);

                TreePath path = TreePath.getPath(ast, at);
                TypeMirror tm = trees.getTypeMirror(path);
                Element e = trees.getElement(path);
                TypeInfo ti = TypeUtils.fromTypeMirror(tm, e);

                chain.addStep(new ResolvedChain.Step(
                        ResolvedChain.Kind.EXPRESSION,
                        at.toString(),
                        ti,
                        ti.isNullable(),
                        false,
                        computeRange(at),
                        null,
                        null
                ));
                return;
            }

            if (expr instanceof LiteralTree lt) {
                Object value = lt.getValue();

                TreePath path = TreePath.getPath(ast, lt);
                Element element = trees.getElement(path);
                TypeMirror tm = trees.getTypeMirror(path);
                TypeInfo ti = TypeUtils.fromTypeMirror(tm, element);

                chain.addStep(new ResolvedChain.Step(
                        ResolvedChain.Kind.LITERAL,
                        String.valueOf(value),
                        ti,
                        false,
                        false,
                        computeRange(lt),
                        null,
                        null
                ));
                return;
            }

            if (expr instanceof LambdaExpressionTree lambda) {

                TreePath path = TreePath.getPath(ast, lambda);
                TypeMirror typeMirror = trees.getTypeMirror(path);
                Element element = trees.getElement(path);
                TypeInfo ti = TypeUtils.fromTypeMirror(typeMirror, element);

                chain.addStep(new ResolvedChain.Step(
                        ResolvedChain.Kind.LAMBDA_EXPRESSION,
                        lambda.toString(),
                        ti,
                        ti.isNullable(),
                        false,
                        computeRange(lambda),
                        null,
                        null
                ));

                Tree body = lambda.getBody();
                if (body instanceof ExpressionTree bodyExpr) {

                    build(bodyExpr);
                } else if (body instanceof BlockTree block) {

                    for (StatementTree stmt : block.getStatements()) {
                        if (stmt instanceof ExpressionTree stmtExpr) {
                            build(stmtExpr);
                        }
                    }
                }

                return;
            }


            if (expr instanceof IdentifierTree id) {
                handleIdentifier(id, chain);
            } else if (expr instanceof MemberSelectTree ms) {
                visit(ms.getExpression(), chain);
                handleMemberSelect(ms, chain);
            } else if (expr instanceof MethodInvocationTree mi) {
                handleMethodInvocation(mi, chain);
            } else if (expr instanceof NewClassTree nc) {
                handleNewClass(nc, chain);
            } else if (expr instanceof NewArrayTree na) {
                handleNewArray(na, chain);
            }
        }

        private void handleIdentifier(IdentifierTree id, ResolvedChain chain) {
            Element e = trees.getElement(TreePath.getPath(ast, id));
            if (e == null) return;

            TypeInfo ti = TypeUtils.fromTypeMirror(e.asType(), e);
            //System.err.println("[IdentifierTree] ti = " + ti);
            //System.err.println("[IdentifierTree] IdentifierTree = " + id.toString());

            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.IDENTIFIER,
                    id.getName().toString(),
                    ti,
                    ti.isNullable(),
                    false,
                    computeRange(id),
                    null,
                    null
            ));
        }

        private void handleMemberSelect(MemberSelectTree ms, ResolvedChain chain) {
            Element e = trees.getElement(TreePath.getPath(ast, ms));
            if (e == null) return;

            TypeInfo ti = TypeUtils.fromTypeMirror(e.asType(), e);
            //System.err.println("[MemberSelect] ti = " + ti);
            //System.err.println("[MemberSelect] MemberSelect = " + ms.toString());


            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.FIELD,
                    ms.getIdentifier().toString(),
                    ti,
                    ti.isNullable(),
                    false,
                    computeRange(ms),
                    null,
                    null
            ));
        }

        private void handleMethodInvocation(MethodInvocationTree mi, ResolvedChain chain) {
            ExpressionTree select = mi.getMethodSelect();

            if (select instanceof MemberSelectTree ms) {
                // obj.method()
                visit(ms.getExpression(), chain);
                addMethodStep(ms, mi, chain);
            } else if (select instanceof IdentifierTree id) {
                Element e = trees.getElement(TreePath.getPath(ast, id));
                if (!(e instanceof ExecutableElement method)) return;

                if (method.getModifiers().contains(Modifier.STATIC)) {
                    addStaticMethodStep(id, mi, method, chain);
                } else {
                    addImplicitThisMethodStep(id, mi, method, chain);
                }

                //addImplicitThisMethodStep(id, mi, chain);
            } else {
                visit(select, chain);
            }

            for (var argument : mi.getArguments()) {
                buildChain(argument);
            }
        }

        private void addImplicitThisMethodStep(
                IdentifierTree id,
                MethodInvocationTree mi,
                ExecutableElement method,
                ResolvedChain chain
        ) {
//            Element e = trees.getElement(TreePath.getPath(ast, mi));
//            if (!(e instanceof ExecutableElement method)) return;

            TypeMirror ret = method.getReturnType();
            TypeInfo ti = TypeUtils.fromTypeMirror(ret, method);

            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.METHOD,
                    method.getSimpleName().toString(),
                    ti,
                    ti.isNullable(),
                    false,
                    computeRange(mi),
                    buildMethodInvocationInfo(
                            mi,
                            "this",   // receiver
                            method.getSimpleName().toString()
                    ),
                    null
            ));
        }

        private void addStaticMethodStep(
                IdentifierTree id,
                MethodInvocationTree mi,
                ExecutableElement method,
                ResolvedChain chain
        ) {
            TypeMirror ret = method.getReturnType();
            TypeInfo ti = TypeUtils.fromTypeMirror(ret, method);

            TypeElement owner = (TypeElement) method.getEnclosingElement();

            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.METHOD,
                    method.getSimpleName().toString(),
                    ti,
                    ti.isNullable(),
                    true,
                    computeRange(mi),
                    buildMethodInvocationInfo(
                            mi,
                            owner.getQualifiedName().toString(), // or null
                            method.getSimpleName().toString()
                    ),
                    null
            ));
        }

        private void handleNewClass(NewClassTree nc, ResolvedChain chain) {
            TreePath path = trees.getPath(ast, nc);
            Element element = trees.getElement(path);
            TypeMirror typeMirror = trees.getTypeMirror(path);
            TypeInfo ti = buildTypeInfo(typeMirror, element);

            String qualifiedName = getQualifiedName(nc);
            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.NEW,
                    qualifiedName,
                    ti,
                    ti.isNullable(),
                    false,
                    computeRange(nc),
                    buildMethodInvocationInfo(nc, qualifiedName, qualifiedName),
                    null
            ));

            for (var arg: nc.getArguments()) {
                buildChain(arg);
            }
        }

        private void handleNewArray(NewArrayTree na, ResolvedChain chain) {
            TreePath path = trees.getPath(ast, na);
            Element element = trees.getElement(path);
            TypeMirror typeMirror = trees.getTypeMirror(path);

            TypeInfo arrayType = buildTypeInfo(typeMirror, element);

            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.IDENTIFIER,
                    na.toString(),    // "new T[]{ ... }"
                    arrayType,
                    arrayType.isNullable(),
                    false,
                    computeRange(na),
                    null,
                    null
            ));

            if (na.getInitializers() != null) {
                for (var initializer : na.getInitializers()) {
                    build(initializer); // visit()를 재귀적으로 호출해서 Step 생성
                }
            }
        }

        private void addMethodStep(
                MemberSelectTree ms,
                MethodInvocationTree mi,
                ResolvedChain chain
        ) {
            Element e = trees.getElement(TreePath.getPath(ast, mi));
            if (!(e instanceof ExecutableElement method)) return;

            TypeMirror ret = method.getReturnType();

            TypeInfo ti = TypeUtils.fromTypeMirror(ret, method);

            chain.addStep(new ResolvedChain.Step(
                    ResolvedChain.Kind.METHOD,
                    method.getSimpleName().toString(),
                    ti,
                    ti.isNullable(),
                    false,
                    computeRange(mi),
                    buildMethodInvocationInfo(mi, resolveReceiverType(chain), method.getSimpleName().toString()),
                    null
            ));
        }

        private String resolveReceiverType(ResolvedChain chain) {
            return (chain.last() != null) ? chain.last().typeInfo.getName() : null;
        }
    }

    @Override
    public Void visitInstanceOf(InstanceOfTree node, Void unused) {
        buildChain(node.getExpression());
        return super.visitInstanceOf(node, unused);
    }

    @Override
    public Void visitExpressionStatement(ExpressionStatementTree node, Void unused) {
        buildChain(node.getExpression());
        return super.visitExpressionStatement(node, unused);
    }

    private void buildChain(ExpressionTree expr) {
        ExpressionChainBuilder chainBuilder = new ExpressionChainBuilder(
                trees, types, resolver, ast, source, javaMethodInvocationManager
        );
        ResolvedChain chain = chainBuilder.build(expr);
        currentSymbolTable.addResolvedChain(chain);
    }

    public JavaSymbolAnalyzer(String source, CompilationUnitTree ast, Trees trees, SymbolTable globalSymbolTable, Elements elements, Types types) {
        this.source = source;
        this.ast = ast;
        this.trees = trees;
        this.elements = elements;
        this.types = types;
        this.globalSymbolTable = globalSymbolTable;
        this.topLevelSymbolTable = new SymbolTable(globalSymbolTable);
        this.currentSymbolTable = topLevelSymbolTable;
        this.javaMethodInvocationManager = new JavaMethodInvocationManager(source);
        this.resolver = new JavaSymbolResolver(globalSymbolTable, elements, types);
    }

    public SymbolTable getTopLevelSymbolTable() {
        return topLevelSymbolTable;
    }

    public JavaMethodInvocationManager getJavaMethodInvocationManager() {
        return javaMethodInvocationManager;
    }

    @Override
    public Void visitPackage(PackageTree node, Void unused) {
        this.packageName = node.getPackageName().toString();
        return super.visitPackage(node, unused);
    }

    private void enterSymbolTable(String symbol) {
        currentSymbolTable = currentSymbolTable.getEnclosingSymbolTable(symbol);
    }

    private void enterSymbolTable(String symbol, SymbolTable table) {
        currentSymbolTable = currentSymbolTable.addEnclosingSymbolTable(symbol, table);
    }

    private void exitSymbolTable() {
        currentSymbolTable = currentSymbolTable.getParent();
    }

    @Override
    public Void visitClass(ClassTree node, Void unused) {
        SymbolInfo classSymbolInfo = createClassSymbolInfo(node);
        if (topLevelSymbolTable.isEmpty()) {
            currentSymbolTable.declare("^PackageName$", classSymbolInfo.toBuilder().symbol(this.packageName).build());
            currentSymbolTable.declare("^TopLevelClass$", classSymbolInfo);
        }
        declareClassSymbol(classSymbolInfo);
        //System.err.println("[JavaSymbolAnalyzer] currentSymbolTable = " + currentSymbolTable);
        //System.err.println("[JavaSymbolAnalyzer] classSymbolInfo = " + classSymbolInfo);

        //System.err.println("[JavaSymbolAnalyzer] node.getSimpleName().toString() = " + node.getSimpleName().toString());
        enterSymbolTable(node.getSimpleName().toString());

        currentSymbolTable.declare("^ClassDef$", classSymbolInfo);

        currentSymbolTable.declare(classSymbolInfo.getSymbol(), classSymbolInfo);
        currentSymbolTable.declare(classSymbolInfo.getTypeInfo().getName(), classSymbolInfo);

        currentSymbolTable
                .getEnclosingSymbolTable(SymbolTable.INSTANCE_NS)
                .declare("this", classSymbolInfo);

        Element element = trees.getElement(getCurrentPath());
        if (element instanceof TypeElement typeElement) {

            processSuperClass(typeElement, currentSymbolTable);
        }

        for (Tree member : node.getMembers()) {
            if (member instanceof VariableTree var) visitField(var, getCurrentPath());
        }

        try {
            return super.visitClass(node, unused);
        } finally {
            exitSymbolTable();
        }
    }

    private void processSuperClass(TypeElement clazz, SymbolTable classSymbolTable) {

        String qualifiedName = clazz.getQualifiedName().toString();

        if ("java.lang.Object".equals(qualifiedName)) {
            return;
        }

        TypeMirror superClassMirror = clazz.getSuperclass();
        if (superClassMirror.getKind() == TypeKind.DECLARED) {

            TypeElement superClassElement = (TypeElement) types.asElement(superClassMirror);
            String superClassFQName = superClassElement.getQualifiedName().toString();

            var superClassSymInfo = resolver.resolveClass(superClassFQName);

            classSymbolTable.setSuperClassTable(
                    superClassSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0)
            );

            processSuperClass(superClassElement, superClassSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0));
        } else {
            SymbolInfo objectClassSymInfo = resolver.resolveClass("java.lang.Object");
            classSymbolTable.setSuperClassTable(
                    objectClassSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0)
            );
        }

        List<? extends TypeMirror> superInterfaceMirrorList = clazz.getInterfaces();
        for (TypeMirror superInterfaceMirror : superInterfaceMirrorList) {
            if (superInterfaceMirror.getKind() == TypeKind.DECLARED) {
                TypeElement superInterfaceElement = (TypeElement) types.asElement(superInterfaceMirror);
                processInterface(superInterfaceElement, classSymbolTable);
            }
        }
    }

    private void processInterface(TypeElement interfaceElement, SymbolTable classSymbolTable) {

        String interfaceFQName = interfaceElement.getQualifiedName().toString();
        var superInterfaceSymInfo = resolver.resolveClass(interfaceFQName);

        classSymbolTable.addSuperInterfaceTable(
                superInterfaceSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0)
        );

        List<? extends TypeMirror> parentInterfaces = interfaceElement.getInterfaces();
        for (TypeMirror parentInterfaceMirror : parentInterfaces) {
            if (parentInterfaceMirror.getKind() == TypeKind.DECLARED) {
                TypeElement parentInterfaceElement = (TypeElement) types.asElement(parentInterfaceMirror);
                processInterface(parentInterfaceElement, superInterfaceSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0));
            }
        }
    }

    private SymbolInfo createClassSymbolInfo(ClassTree node) {
        TreePath path = getCurrentPath();
        Element element = trees.getElement(path);
        TypeMirror typeMirror = trees.getTypeMirror(path);

        TypeInfo typeInfo = TypeUtils.fromTypeMirror(typeMirror, element);

        return SymbolInfo.builder()
                .symbol(node.getSimpleName().toString())
                .typeInfo(typeInfo)
                .symbolTable(currentSymbolTable)
                .range(computeRange(node))
                .originalText(computeRangeText(node))
                .nullState(NullState.NON_NULL)
                .modifierList(convertModifiers(node.getModifiers().getFlags()))
                .build();
    }

    private void declareClassSymbol(SymbolInfo classSymbolInfo) {
        String typeName = classSymbolInfo.getTypeInfo().getName();
        String simpleName = classSymbolInfo.getSymbol();
        currentSymbolTable.declare(simpleName, classSymbolInfo);
        //currentSymbolTable.declare("this", classSymbolInfo);
        globalSymbolTable.declare(typeName, classSymbolInfo);
    }

    private void visitField(VariableTree node, TreePath classPath) {
        TreePath path = new TreePath(classPath, node);
        Element element = trees.getElement(path);
        TypeMirror typeMirror = trees.getTypeMirror(path);
        TypeInfo typeInfo = buildTypeInfo(typeMirror, element);

        SymbolInfo fieldSymbolInfo = createSymbolInfo(node.getName().toString(), node.getModifiers().getFlags(), typeInfo, node, currentSymbolTable);
        //System.err.println("[JavaSymbolAnalyzer] fieldSymbolInfo = " + fieldSymbolInfo);

        currentSymbolTable.declare(fieldSymbolInfo.getSymbol(), fieldSymbolInfo);
        //System.err.println("[JavaSymbolAnalyzer] currentSymbolTable = " + currentSymbolTable);
        //System.err.println("[JavaSymbolAnalyzer] currentSymbolTable.instanceTable = " + currentSymbolTable.getEnclosingSymbolTable(SymbolTable.INSTANCE_NS));

        ExpressionTree initializer = node.getInitializer();
        if (initializer != null) {
            buildChain(initializer);
        }
    }

    private TypeInfo buildTypeInfo(TypeMirror typeMirror, Element originalElement) {

        TypeInfo typeInfo = TypeUtils.fromTypeMirror(typeMirror, originalElement);
        resolver.resolveClass(typeInfo.getName());

        return typeInfo;
    }

    private List<jplus.base.Modifier> convertModifiers(Iterable<Modifier> modifiers) {
        List<jplus.base.Modifier> result = new ArrayList<>();
        for (Modifier m : modifiers) result.add(jplus.base.Modifier.valueOf(m.toString().toUpperCase()));
        return result;
    }

    private SymbolInfo createSymbolInfo(String name, Iterable<Modifier> modifiers, TypeInfo typeInfo, Tree node, SymbolTable table) {
        return new SymbolInfo(name, typeInfo, computeRange(node), computeRangeText(node), convertModifiers(modifiers), table);
    }

    private TextChangeRange computeRange(Tree node) {
        int start = getSourceStartPosition(node);
        int end = getSourceEndPosition(node);

        try {
            return Utils.computeTextChangeRange(source, start, end - 1);
        } catch(IllegalArgumentException iae) {
            //System.err.println(iae.getMessage());
            return TextChangeRange.EMPTY;
        }
    }

    private String computeRangeText(Tree node) {
        int start = getSourceStartPosition(node);
        int end = getSourceEndPosition(node);
        return (start < end) ? source.substring(start, end) : "";
    }

    private int getSourceStartPosition(Tree node) {
        return (int) trees.getSourcePositions().getStartPosition(ast, node);
    }

    private int getSourceEndPosition(Tree node) {
        int endPos = (int) trees.getSourcePositions().getEndPosition(ast, node);
        return endPos < getSourceStartPosition(node) ? getSourceStartPosition(node) + 1 : endPos;
    }

    private String getQualifiedName(Tree node) {
        TreePath path = trees.getPath(ast, node);
        if (path != null) {
            TypeMirror tm = trees.getTypeMirror(path);
            if (tm instanceof DeclaredType dt && dt.asElement() instanceof TypeElement te) {
                return te.getQualifiedName().toString();
            }
        }

        if (node instanceof MemberSelectTree mst) {
            return mst.toString();
        }

        if (node instanceof IdentifierTree idt) {
            return idt.getName().toString();
        }

        return node.toString();
    }

    @Override
    public Void visitIdentifier(IdentifierTree node, Void unused) {
        buildChain(node);
        return super.visitIdentifier(node, unused);
    }

    @Override
    public Void visitMemberSelect(MemberSelectTree node, Void unused) {

        buildChain(node);

        return super.visitMemberSelect(node, unused);
    }

    @Override
    public Void visitNewClass(NewClassTree node, Void unused) {

        buildChain(node);

        String qualifiedName = getQualifiedName(node);

        JavaSymbolResolver resolver = new JavaSymbolResolver(globalSymbolTable, elements, types);
        SymbolInfo symbolInfo = resolver.resolveClass(qualifiedName);
        //System.err.println("[NewClass] symbolInfo = " + symbolInfo);

        MethodInvocationInfo info = buildMethodInvocationInfo(node, qualifiedName, qualifiedName);
        javaMethodInvocationManager.addInvocationInfo(currentSymbolTable, info);
        //System.err.println("[NewClass] methodInvocationInfo = " + info);

        for (ExpressionTree arg : node.getArguments()) {
            buildChain(arg);
        }

        return super.visitNewClass(node, unused);
    }

    @Override
    public Void visitNewArray(NewArrayTree node, Void unused) {

        buildChain(node);

        return super.visitNewArray(node, unused);
    }

    @Override
    public Void visitAssignment(AssignmentTree node, Void unused) {
        ExpressionTree lhs = node.getVariable();
        buildChain(lhs);

        ExpressionTree rhs = node.getExpression();
        buildChain(rhs);

        return super.visitAssignment(node, unused);
    }

    @Override
    public Void visitLambdaExpression(LambdaExpressionTree node, Void unused) {

        SymbolTable lambdaSymbolTable = new SymbolTable(currentSymbolTable);

        String lamdaSymbol = "^lambda$" + getSourceStartPosition(node);
        enterSymbolTable(lamdaSymbol, lambdaSymbolTable);
        try {
            for (VariableTree param : node.getParameters()) {
                TreePath paramPath = new TreePath(getCurrentPath(), param);
                Element e = trees.getElement(paramPath);
                TypeMirror tm = trees.getTypeMirror(paramPath);

                TypeInfo ti = TypeUtils.fromTypeMirror(tm, e);
                SymbolInfo si = SymbolInfo.builder()
                        .symbol(param.getName().toString())
                        .typeInfo(ti)
                        .symbolTable(lambdaSymbolTable)
                        .range(computeRange(param))
                        .nullState(NullState.NON_NULL)
                        .originalText(param.toString())
                        .build();

                lambdaSymbolTable.declare(si.getSymbol(), si);
            }

            Tree body = node.getBody();
            if (body instanceof ExpressionTree et) {
                buildChain(et);
            } else if (body instanceof BlockTree bt) {
                scan(bt, unused);
            }

            return null;

        } finally {
            exitSymbolTable();
        }
    }

    private MethodInvocationInfo buildMethodInvocationInfo(Tree node, String receiver, String methodName) {
        List<? extends ExpressionTree> args;
        if (node instanceof MethodInvocationTree mit) {
            args = mit.getArguments();
        } else if (node instanceof NewClassTree nct) {
            args = nct.getArguments();
        } else {
            args = List.of();
        }

        List<String> argStrings = args.stream().map(Object::toString).toList();
        List<String> argTypes = args.stream()
                .map(arg -> {
                    TypeMirror tm = trees.getTypeMirror(trees.getPath(ast, arg));
                    return tm != null ? tm.toString() : "unknown";
                })
                .toList();

        TreePath path = trees.getPath(ast, node);
        Element element = trees.getElement(path);
        TypeMirror typeMirror = trees.getTypeMirror(path);

        MethodInvocationInfo.Builder builder = MethodInvocationInfo.builder()
                .receiver(receiver)
                .typeInfo(buildTypeInfo(typeMirror, element))
                .methodName(methodName)
                .args(argStrings)
                .argTypes(argTypes)
                .source(computeRangeText(node))
                .startPos(getSourceStartPosition(node))
                .endPos(getSourceEndPosition(node));

        if (element instanceof ExecutableElement method) {

            var modifiers = method.getModifiers();
            builder.modifierList(convertModifiers(method.getModifiers()));

            if (receiver != null && modifiers.contains(Modifier.STATIC)) {
                resolver.resolveClass(receiver);
            }
        }

//        TreePath path = trees.getPath(ast, node);
        if (path != null) {
            Element e = trees.getElement(path);
            if (e instanceof ExecutableElement ee) {
                //CleanTypePrinter printer = new CleanTypePrinter();
                //List<String> paramTypes = ((ExecutableType) ee.asType()).getParameterTypes().stream().map(printer::print).toList();
                List<String> paramTypes = ((ExecutableType) ee.asType()).getParameterTypes().stream().map(t -> TypeUtils.fromTypeMirror(t, e)).map(TypeInfo::getFullname).toList();
                builder.paramTypes(paramTypes).returnType(((ExecutableType) ee.asType()).getReturnType().toString()).hasVarArgs(ee.isVarArgs());
            }
        }

        return builder.build();
    }

    @Override
    public Void visitYield(YieldTree node, Void unused) {
        buildChain(node.getValue());
        return super.visitYield(node, unused);
    }

    @Override
    public Void visitSwitchExpression(SwitchExpressionTree node, Void unused) {
        //buildChain(node);

        buildChain(node.getExpression());

        //SymbolTable switchSymbolTable = new SymbolTable(currentSymbolTable);
        //currentSymbolTable = currentSymbolTable.getEnclosingSymbolTable("^block$");

        enterSymbolTable("^block$" + computeRange(node).startLine());

        for (CaseTree _case : node.getCases()) {

            enterSymbolTable("^block$" + _case.getLabels().toString().replace(" ", ""));

            for (var label : _case.getLabels()) {
                //System.err.println("label = " + label + ", " + label.getClass().getSimpleName());
                if (label instanceof PatternCaseLabelTree patternLabel) {
                    // BindingPatternTree로 캐스팅 가능
                    if (patternLabel.getPattern() instanceof BindingPatternTree binding) {
                        VariableTree var = binding.getVariable();
                        visitVariable(var, unused);
                    }

                    var guard = _case.getGuard();
                    if (guard != null) buildChain(guard);

                    //TreePath path = trees.getPath(ast, guard);
                    //scan(path, null);

                } else if (label instanceof DefaultCaseLabelTree defaultLabel) {

                } else if (label instanceof ConstantCaseLabelTree constantLabel) {
                    buildChain(constantLabel.getConstantExpression());
                }
            }

            Tree body = _case.getBody();
            if (body != null) {
                //System.err.println("body = " + body + ", " + body.getClass().getSimpleName());

                //TreePath path = trees.getPath(ast, body);
                //scan(path, null);


                if (body instanceof BlockTree block) {
                    visitBlock(block, null);
                }

                if (body instanceof ExpressionTree expr) {
                    buildChain(expr);
                }

                if (body instanceof ExpressionStatementTree exprStmt) {
                    visitExpressionStatement(exprStmt, null);
                }
            }

            exitSymbolTable();
        }

        exitSymbolTable();

        return super.visitSwitchExpression(node, unused);
    }

    @Override
    public Void visitSwitch(SwitchTree node, Void unused) {

        buildChain(node.getExpression());

        //SymbolTable switchSymbolTable = new SymbolTable(currentSymbolTable);
        //currentSymbolTable = currentSymbolTable.getEnclosingSymbolTable("^block$");

        enterSymbolTable("^block$" + computeRange(node).startLine());

        for (CaseTree _case : node.getCases()) {

            if (_case.getBody() != null) {

                enterSymbolTable("^block$" + _case.getLabels().toString().replace(" ", ""));

                for (var label : _case.getLabels()) {
                    //System.err.println("label = " + label + ", " + label.getClass().getSimpleName());
                    if (label instanceof PatternCaseLabelTree patternLabel) {

                        if (patternLabel.getPattern() instanceof BindingPatternTree binding) {
                            VariableTree var = binding.getVariable();
                            visitVariable(var, unused);
                        }

                        var guard = _case.getGuard();
                        if (guard != null) buildChain(guard);

                        //TreePath path = trees.getPath(ast, guard);
                        //scan(path, null);

                    } else if (label instanceof DefaultCaseLabelTree defaultLabel) {

                    } else if (label instanceof ConstantCaseLabelTree constantLabel) {
                        buildChain(constantLabel.getConstantExpression());
                    }
                }

                Tree body = _case.getBody();
                if (body != null) {
                    //System.err.println("body = " + body + ", " + body.getClass().getSimpleName());

                    //TreePath path = trees.getPath(ast, body);
                    //scan(path, null);

                    if (body instanceof BlockTree block) {
                        visitBlock(block, null);
                    }

                    if (body instanceof ExpressionTree expr) {
                        buildChain(expr);
                    }

                    if (body instanceof ExpressionStatementTree exprStmt) {
                        visitExpressionStatement(exprStmt, null);
                    }
                }
            } else {
                var scopeName = "^block$" + (_case.getExpressions().isEmpty() ? "default" : _case.getExpressions().toString().replace(" ", ""));

                //System.err.println("[JavaSymbol][Switch] expressions = " + scopeName);

                enterSymbolTable(scopeName);

                _case.getExpressions().forEach(this::buildChain);

                for (var statement : _case.getStatements()) {
                    //System.err.println("[JavaSymbol][Switch] statememt = " + statement.getClass().getSimpleName());
//                    if (statement instanceof ExpressionStatementTree exprStmt) {
//                        buildChain(exprStmt.getExpression());
//                    }
                    TreePath path = trees.getPath(ast, statement);
                    scan(path, null);
                }
            }

            exitSymbolTable();
        }

        exitSymbolTable();
        return null;
    }

    @Override
    public Void visitMethod(MethodTree node, Void unused) {
        if (node.getReturnType() == null) {
            ////System.err.println("Constructor: " + node.getName());
            return visitConstructorDeclaration(node, unused);
        } else {
            ////System.err.println("method: " + node.getName());
            return visitMethodDeclaration(node, unused);
        }
    }

    private Void visitConstructorDeclaration(MethodTree node, Void unused) {
        return processCallable(node, unused);
    }

    private Void visitMethodDeclaration(MethodTree node, Void unused) {
        return processCallable(node, unused);
    }

    private Void processCallable(MethodTree node, Void unused) {

        SymbolTable methodSymbolTable = new SymbolTable(currentSymbolTable);
        List<String> typeNameList = new ArrayList<>();
        List<String> simpleTypeNameList = new ArrayList<>();

        String qualifiedClassName = currentSymbolTable.resolve("^ClassDef$")
                                                    .getTypeInfo()
                                                    .getName();

        boolean isJavaApi =
                qualifiedClassName.startsWith("java.")
                        || qualifiedClassName.startsWith("javax.")
                        || qualifiedClassName.startsWith("jakarta."); //this must be changed


        for (VariableTree param : node.getParameters()) {

            Element element = trees.getElement(TreePath.getPath(ast, param));
            //TypeMirror typeMirror = trees.getTypeMirror(TreePath.getPath(ast, param.getType()));
            TypeMirror typeMirror = element.asType();
            TypeInfo typeInfo = buildTypeInfo(typeMirror, element);
            //System.err.println("[method] typeInfo = " + typeInfo);

            //String typeNameWithNullability = typeInfo.getFullname() + (typeInfo.isNullable() ? "?" : "");
            String typeNameWithNullability = typeInfo.getFullname() + (isJavaApi ? "?" : (typeInfo.isNullable() ? "?" : ""));
            //System.err.println("[method] typeNameWithNullability = " + typeNameWithNullability);
            //String simpleTypeNameWithNullability = param.getType().toString().replace(", ", ",") + (typeInfo.isNullable() ? "?" : "");
            String simpleTypeNameWithNullability = param.getType().toString().replace(", ", ",") + (isJavaApi ? "?" : (typeInfo.isNullable() ? "?" : ""));
            ////System.err.println("[method] simpleTypeNameWithNullability = " + simpleTypeNameWithNullability);
            typeNameList.add(typeNameWithNullability);
            simpleTypeNameList.add(simpleTypeNameWithNullability);

            SymbolInfo symbolInfo = SymbolInfo.builder()
                    .symbol(param.getName().toString())
                    .typeInfo(typeInfo)
                    .range(computeRange(node))
                    .originalText(param.toString())
                    .modifierList(convertModifiers(param.getModifiers().getFlags()))
                    .nullState(!typeInfo.isNullable() ? NullState.NON_NULL : NullState.UNKNOWN)
                    .symbolTable(methodSymbolTable)
                    .build();

            methodSymbolTable.declare(symbolInfo.getSymbol(), symbolInfo);
        }

        // ---------- method/constructor symbol name 구성 ----------
        String methodName = node.getName().toString();
        TypeInfo.Type type = TypeInfo.Type.Method;
        if (methodName.equals("<init>")) {
            if (!MethodUtils.isExplicitConstructor(node, trees, getCurrentPath())) {
                return super.visitMethod(node, unused);
            }
            methodName = "constructor";
            type = TypeInfo.Type.Constructor;
        }

        String symbolName = "^" + methodName + "$~" + String.join("~", typeNameList);
        ////System.err.println("[method] symbolName = " + symbolName);
        String symbolNameWithSimpleTypeName = "^" + methodName + "$~" + String.join("~", simpleTypeNameList);
        ////System.err.println("[method] symbolNameWithSimpleTypeName = " + symbolNameWithSimpleTypeName);

        boolean isNullableReturn = node.getModifiers().getAnnotations().stream()
                .map(a -> a.getAnnotationType().toString())
                .anyMatch(name ->
                        name.endsWith(".Nullable")
                                || name.equals("org.jspecify.annotations.Nullable")
                );
        //System.err.println("[processCallable] isNullableReturn = " + isNullableReturn);


        TypeInfo returnTypeInfo;
        if (type == TypeInfo.Type.Constructor) {

            returnTypeInfo = TypeInfo.builder()
                    .name("void")
                    .isNullable(false)
                    .type(TypeInfo.Type.Void)
                    .build();
        } else {

            TypeMirror returnTypeMirror = trees.getTypeMirror(TreePath.getPath(ast, node.getReturnType()));
            Element returnTypeElement = trees.getElement(TreePath.getPath(ast, node.getReturnType()));
            returnTypeInfo = buildTypeInfo(returnTypeMirror, returnTypeElement);
            returnTypeInfo = returnTypeInfo.toBuilder().isNullable(isNullableReturn).build();
        }

        TypeInfo typeInfo = new TypeInfo(symbolName, isNullableReturn, type, returnTypeInfo);

        SymbolInfo symbolInfo =
                SymbolInfo.builder()
                        .symbol(symbolName)
                        .typeInfo(typeInfo)
                        .originalText(computeRangeText(node))
                        .range(computeRange(node))
                        .nullState(NullState.NON_NULL)
                        .modifierList(convertModifiers(node.getModifiers().getFlags()))
                        .symbolTable(currentSymbolTable)
                        .build();

                //new SymbolInfo(symbolName, typeInfo, computeRange(node), computeRangeText(node), convertModifiers(node.getModifiers().getFlags()), currentSymbolTable);

        currentSymbolTable.declare(symbolName, symbolInfo);
        currentSymbolTable.declare(symbolNameWithSimpleTypeName, symbolInfo);
        //System.err.println("[method] symbolInfo = "  + symbolInfo);
        //System.err.println("[method] currentSymbolTable = "  + currentSymbolTable);

        enterSymbolTable(symbolName, methodSymbolTable);
        try {
            return super.visitMethod(node, unused);
        } finally {
            exitSymbolTable();
        }
    }

    @Override
    public Void visitVariable(VariableTree node, Void p) {
        //TreePath path = getCurrentPath();
        TreePath path = trees.getPath(ast, node);
        Element element = trees.getElement(path);

        final EnumSet localKindSet = EnumSet.of(ElementKind.LOCAL_VARIABLE, ElementKind.RESOURCE_VARIABLE, ElementKind.BINDING_VARIABLE);
        if (element == null || !localKindSet.contains(element.getKind())) {
            return super.visitVariable(node, p);
        }

        ExpressionTree initializer = node.getInitializer();
        if (initializer != null) {
            buildChain(initializer);
        }

        return handleLocalVariable(node, p);
    }

    @Override
    public Void visitReturn(ReturnTree node, Void unused) {
        buildChain(node.getExpression());
        return super.visitReturn(node, unused);
    }

    private Void handleLocalVariable(VariableTree node, Void unused) {
        //TypeMirror typeMirror = trees.getTypeMirror(getCurrentPath());
        TreePath typePath = TreePath.getPath(ast, node.getType());
        Element element = trees.getElement(TreePath.getPath(ast, node));
        TypeMirror typeMirror = trees.getTypeMirror(typePath);
        //TypeMirror typeMirror = element.asType();

        TypeInfo typeInfo = buildTypeInfo(typeMirror, element);

        boolean isNullable = node.getModifiers().getAnnotations().stream()
                .map(a -> a.getAnnotationType().toString())
                .anyMatch(name ->
                        name.endsWith(".Nullable")
                                || name.equals("org.jspecify.annotations.Nullable")
                );

        System.err.println("[handleLocalVariable] contextString = " + node.toString());
        //System.err.println("[handleLocalVariable] isNullable = " + isNullable);

        typeInfo = typeInfo.toBuilder().isNullable(isNullable).build();
        System.err.println("[handleLocalVariable] typeInfo = " + typeInfo);

        SymbolInfo symbolInfo = SymbolInfo.builder()
                .symbol(node.getName().toString())
                .typeInfo(typeInfo)
                .modifierList(convertModifiers(node.getModifiers().getFlags()))
                .symbolTable(currentSymbolTable)
                .nullState(!typeInfo.isNullable() ? NullState.NON_NULL : NullState.UNKNOWN)
                .originalText(computeRangeText(node))
                .range(computeRange(node))
                .build();

        currentSymbolTable.declare(symbolInfo.getSymbol(), symbolInfo);
        System.err.println("[handleLocalVariable] currentSymbolTable = " + currentSymbolTable);

        return super.visitVariable(node, unused);
    }

    @Override
    public Void visitTry(TryTree tryTree, Void unused) {
        return super.visitTry(tryTree, unused);
    }

    /*@Override
    public Void visitEnhancedForLoop(EnhancedForLoopTree node, Void unused) {

        super.visitEnhancedForLoop(node, unused);

        var variableTree = node.getVariable();
        handleLocalVariable(variableTree, unused);

        var symbol = variableTree.getName().toString();
        var symbolInfo = currentSymbolTable.resolveInCurrent(symbol);
        //System.err.println("[EnhancedForLoop] symbolInfo = " + symbolInfo);

        currentSymbolTable.declare(
                symbol,
                symbolInfo.toBuilder()
                        .nullState(NullState.NON_NULL)
                        .build()
        );

        //return super.visitEnhancedForLoop(node, unused);
        return null;
    }*/

    @Override
    public Void visitMethodInvocation(MethodInvocationTree node, Void unused) {

        buildChain(node);

        //System.err.println("[JavaSymbolAnalyzer] code = " + node.getMethodSelect().toString());

        //SymbolInfo ownerType = resolveExpressionChain(node.getMethodSelect());
        SymbolInfo ownerType = buildResolvedChain(
                node.getMethodSelect() instanceof MemberSelectTree mst
                        ? mst.getExpression()
                        : node.getMethodSelect()
        );
        //System.err.println("[JavaSymbolAnalyzer] ownerType = " + ownerType);

        Element e = trees.getElement(getCurrentPath());
        if (e instanceof ExecutableElement method) {

            String methodName = method.getSimpleName().toString();
            //System.err.println("[JavaSymbolAnalyzer] methodName = " + methodName);

            MethodInvocationInfo info =
                    buildMethodInvocationInfo(
                            node,
                            ownerType != null ? ownerType.getSymbol() : null,
                            methodName
                    );

            for (ExpressionTree arg : node.getArguments()) {
                buildChain(arg);
            }

            javaMethodInvocationManager.addInvocationInfo(currentSymbolTable, info);
            //System.err.println("[JavaSymbolAnalyzer] methodInvocationInfo = " + info);
        }

        return super.visitMethodInvocation(node, unused);
    }

    @Override
    public Void visitBinary(BinaryTree node, Void unused) {
        buildChain(node.getLeftOperand());
        buildChain(node.getRightOperand());

        buildChain((node));

        return super.visitBinary(node, unused);
    }

    @Override
    public Void visitConditionalExpression(ConditionalExpressionTree node, Void unused) {
        buildChain(node.getTrueExpression());
        buildChain(node.getFalseExpression());

        return super.visitConditionalExpression(node, unused);
    }

    @Override
    public Void visitIf(IfTree node, Void unused) {

        scan(node.getCondition(), null);


        enterSymbolTable("^then$" + computeRange(node).startLine());

        scan(node.getThenStatement(), null);

        exitSymbolTable();


        enterSymbolTable("^else$" + computeRange(node).startLine());

        scan(node.getElseStatement(), null);

        exitSymbolTable();


        return null;
    }

    public SymbolInfo buildResolvedChain(ExpressionTree expr) {

        Element e = trees.getElement(TreePath.getPath(ast, expr));

        if (expr instanceof IdentifierTree) {

            if (e instanceof TypeElement type) {
                //System.err.println("[resolveExpressionChain] identifer = " + type.getQualifiedName().toString());
                return resolver.resolveClass(type.getQualifiedName().toString());
            }

            if (e instanceof VariableElement var) {
                TypeMirror varType = var.asType();

                if (varType.getKind() == TypeKind.DECLARED) {
                    TypeElement varTypeElement = (TypeElement) types.asElement(varType);
                    SymbolInfo typeSymbol = resolver.resolveClass(varTypeElement.getQualifiedName().toString());
                    //System.err.println("[resolveExpressionChain] identifier (variable) = " + var.getSimpleName() + ", type = " + varTypeElement.getQualifiedName());
                    //System.err.println("[resolveExpressionChain] typeSymbol = " + typeSymbol);

                    SymbolTable parentTable = currentSymbolTable;
                    typeSymbol = typeSymbol.toBuilder()
                            .symbolTable(parentTable)
                            .build();
                    return typeSymbol;
                }
            }

            return null;
        }

        if (expr instanceof MemberSelectTree mst) {

            SymbolInfo ownerType = buildResolvedChain(mst.getExpression());

            if (e == null) return ownerType;

            if (e instanceof VariableElement field) {
                TypeMirror fieldType = field.asType();
                TypeElement fieldTypeElement = (TypeElement) types.asElement(fieldType);

                //System.err.println("[resolveExpressionChain] field = " + field);
                //System.err.println("[resolveExpressionChain] fieldType = " + fieldTypeElement.getQualifiedName().toString());
                return resolver.resolveClass(fieldTypeElement.getQualifiedName().toString());
            }

            if (e instanceof ExecutableElement method) {

                TypeMirror returnType = method.getReturnType();
                //System.err.println("[resolveExpressionChain] returnType = " + returnType.toString());

                if (TypeKind.VOID == returnType.getKind()) {
                    //System.err.println("[resolveExpressionChain] method returns void: " + method.getSimpleName());
                    return null;
                }

                if (returnType.getKind().isPrimitive()) {
                    //System.err.println("[resolveExpressionChain] method returns primitive: " + returnType);
                    return null;
                }

                if (returnType.getKind() == TypeKind.DECLARED) {
                    TypeElement returnTypeElement = (TypeElement) types.asElement(returnType);
                    return resolver.resolveClass(returnTypeElement.getQualifiedName().toString());
                }

                if (returnType.getKind() == TypeKind.TYPEVAR) {
                    TypeVariable tv = (TypeVariable) returnType;

                    TypeMirror upperBound = tv.getUpperBound();

                    if (upperBound.getKind() == TypeKind.DECLARED) {
                        TypeElement boundElement = (TypeElement) types.asElement(upperBound);
                        return resolver.resolveClass(boundElement.getQualifiedName().toString());
                    }

                    return null;
                }

                if (returnType.getKind() == TypeKind.ARRAY) {
                    ArrayType at = (ArrayType) returnType;
                    TypeMirror component = at.getComponentType();

                    if (component.getKind() == TypeKind.DECLARED) {
                        TypeElement componentElement = (TypeElement) types.asElement(component);
                        return resolver.resolveClass(componentElement.getQualifiedName().toString());
                    }
                }

                return null;
            }
        }

        return null;
    }

    @Override
    public Void visitBlock(BlockTree node, Void unused) {
        ////System.err.println("[visitBlock] invoked");
        enterSymbolTable("^block$");
        try {
            return super.visitBlock(node, unused);
        } finally {
            exitSymbolTable();
        }
    }

}