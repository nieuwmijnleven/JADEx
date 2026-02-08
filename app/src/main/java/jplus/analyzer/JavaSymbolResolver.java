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

import jplus.analyzer.nullability.dataflow.NullState;
import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.util.TypeUtils;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// JavaSymbolResolver
public class JavaSymbolResolver {

    private final SymbolTable globalSymbolTable;
    private final Elements elements;
    private final Types types;
    private final Map<String, SymbolInfo> cache = new HashMap<>();

    public JavaSymbolResolver(SymbolTable globalSymbolTable, Elements elements, Types types) {
        this.globalSymbolTable = globalSymbolTable;
        this.elements = elements;
        this.types = types;
    }

    public SymbolInfo resolveClass(String qualifiedName) {
        if (cache.containsKey(qualifiedName)) {
            return cache.get(qualifiedName);
        }

        if (globalSymbolTable.contains(qualifiedName, TypeInfo.Type.Class)) {
            return globalSymbolTable.resolveInCurrent(qualifiedName);
        }

        TypeElement clazz = elements.getTypeElement(qualifiedName);
        if (clazz == null) {
            return null;
        }

        boolean isJavaApi =
                qualifiedName.startsWith("java.")
                || qualifiedName.startsWith("javax.")
                || qualifiedName.startsWith("jakarta."); //this must be changed

        List<String> typeParams = clazz.getTypeParameters().stream()
                .map(TypeParameterElement::getSimpleName)
                .map(Object::toString)
                .toList();

        List<TypeInfo> typeArgs = List.of();

        TypeInfo classTypeInfo = TypeInfo.builder()
                .name(qualifiedName)
                .isNullable(false)
                .isGeneric(!typeParams.isEmpty())
                .type(TypeInfo.Type.Class)
                .typeParameters(typeParams)
                .typeArguments(typeArgs)
                .build();

        //System.err.println(classTypeInfo);

        SymbolTable topLevelSymbolTable = new SymbolTable(globalSymbolTable);
        SymbolInfo classSymbolInfo = SymbolInfo.builder()
                .symbol(qualifiedName)
                .typeInfo(classTypeInfo)
                .nullState(NullState.NON_NULL)
                .symbolTable(topLevelSymbolTable)
                .build();
        globalSymbolTable.declare(qualifiedName, classSymbolInfo);

        topLevelSymbolTable.declare("^PackageName$", classSymbolInfo.toBuilder().symbol(getPackageName(clazz)).build());
        topLevelSymbolTable.declare("^TopLevelClass$", classSymbolInfo);
        topLevelSymbolTable.declare(qualifiedName, classSymbolInfo);

        cache.put(qualifiedName, classSymbolInfo);

        SymbolTable classSymbolTable = topLevelSymbolTable.getEnclosingSymbolTable(qualifiedName);

        // Field Declaration
        for (Element element : clazz.getEnclosedElements()) {
            if (element.getKind() == ElementKind.FIELD) {
                VariableElement field = (VariableElement) element;

                TypeInfo fieldTypeInfo = TypeUtils.fromTypeMirror(field.asType(), field);

                SymbolInfo fieldSymbolInfo = SymbolInfo.builder()
                        .symbol(field.getSimpleName().toString())
                        .typeInfo(fieldTypeInfo)
                        .symbolTable(classSymbolTable)
                        .build();

                classSymbolTable.declare(fieldSymbolInfo.getSymbol(), fieldSymbolInfo);
            }
        }

        // Method Declaration
        SymbolTable methodSymbolTable = new SymbolTable(classSymbolTable);

        for (Element element : clazz.getEnclosedElements()) {
            if (element.getKind() == ElementKind.CONSTRUCTOR || element.getKind() == ElementKind.METHOD) {

                ExecutableElement methodElement = (ExecutableElement) element;
                List<String> typeNameList = new ArrayList<>();

                for (VariableElement parameter : methodElement.getParameters()) {
                    TypeMirror typeMirror = parameter.asType();
                    TypeInfo typeInfo = TypeUtils.fromTypeMirror(typeMirror, parameter);

                    String typeNameWithNullability = typeInfo.getFullname() + (isJavaApi ? "?" : (typeInfo.isNullable() ? "?" : ""));
                    typeNameList.add(typeNameWithNullability);

                    SymbolInfo symbolInfo = SymbolInfo.builder()
                            .symbol(parameter.getSimpleName().toString())
                            .typeInfo(typeInfo)
                            .nullState(!typeInfo.isNullable() ? NullState.NON_NULL : NullState.UNKNOWN)
                            .symbolTable(methodSymbolTable)
                            .build();

                    methodSymbolTable.declare(symbolInfo.getSymbol(), symbolInfo);
                }

                //String methodName = methodElement.toString();
                String methodName = methodElement.getSimpleName().toString();
                TypeInfo.Type type = TypeInfo.Type.Method;
                if (methodName.equals("<init>")) {
                    methodName = "constructor";
                    type = TypeInfo.Type.Constructor;
                }

                String symbolName = "^" + methodName + "$~" + String.join("~", typeNameList);
                //System.err.println("[method] symbolName = " + symbolName);

                TypeInfo typeInfo = new TypeInfo(symbolName, false, type);
                SymbolInfo symbolInfo = SymbolInfo.builder()
                        .symbol(symbolName)
                        .typeInfo(typeInfo)
                        .nullState(NullState.NON_NULL)
                        .symbolTable(classSymbolTable)
                        .build();

                classSymbolTable.declare(symbolName, symbolInfo);
                classSymbolTable.addEnclosingSymbolTable(symbolName, methodSymbolTable);
            }
        }

        processSuperClass(clazz, classSymbolTable);

        return classSymbolInfo;
    }

    private void processSuperClass(TypeElement clazz, SymbolTable classSymbolTable) {

        String qualifiedName = clazz.getQualifiedName().toString();

        if ("java.lang.Object".equals(qualifiedName)) {
            return;
        }

        // 슈퍼 클래스 처리
        TypeMirror superClassMirror = clazz.getSuperclass();
        if (superClassMirror.getKind() == TypeKind.DECLARED) {

            TypeElement superClassElement = (TypeElement) types.asElement(superClassMirror);
            String superClassFQName = superClassElement.getQualifiedName().toString();

            var superClassSymInfo = resolveClass(superClassFQName);

            classSymbolTable.setSuperClassTable(
                    superClassSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0)
            );

            processSuperClass(superClassElement, superClassSymInfo.getSymbolTable().getEnclosingSymbolTables().get(0));
        } else {
            SymbolInfo objectClassSymInfo = resolveClass("java.lang.Object");
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
        var superInterfaceSymInfo = resolveClass(interfaceFQName);

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

    private String getPackageName(TypeElement clazz) {
        PackageElement pkg = elements.getPackageOf(clazz);
        return pkg.isUnnamed() ? "" : pkg.getQualifiedName().toString();
    }
}
