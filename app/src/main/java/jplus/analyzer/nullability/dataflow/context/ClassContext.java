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

package jplus.analyzer.nullability.dataflow.context;

import jplus.analyzer.nullability.dataflow.InitState;
import jplus.analyzer.nullability.context.adapter.InvocationDeclarationContext;
import jplus.analyzer.nullability.dataflow.NullState;
import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClassContext implements Context {

    private SymbolTable classSymbolTable;

    private SymbolTable instanceSymbolTable;

    private SymbolTable staticSymbolTable;

    private final Map<String, InvocationDeclarationContext> ctorNameToContextMap;

    private final Map<String, InitState> fieldInitState = new HashMap<>();

    private final Map<SymbolInfo, InitState> fieldCtorInitState = new HashMap<>();

    public ClassContext(SymbolTable classSymbolTable, Map<String, InvocationDeclarationContext> ctorNameToContextMap) {
        this.classSymbolTable = classSymbolTable;
        this.instanceSymbolTable = classSymbolTable.getEnclosingSymbolTable(SymbolTable.INSTANCE_NS);
        this.staticSymbolTable = classSymbolTable.getEnclosingSymbolTable(SymbolTable.STATIC_NS);
        this.ctorNameToContextMap = ctorNameToContextMap;

        initFieldCtorNullState();
    }

    private void initFieldCtorNullState() {
        SymbolTable mergedSymbolTable = getMergedInstanceAndStaticSymbolTable();
        mergedSymbolTable.findSymbolInfoByType(List.of(TypeInfo.Type.Reference)).stream()
                .filter(fieldInfo -> !fieldInfo.getTypeInfo().isNullable() && fieldInfo.getNullState() != NullState.NON_NULL)
                //.peek(fieldInfo -> System.err.println("[ClassContext] fieldInfo = " + fieldInfo))
                //.forEach(symbolInfo -> fieldCtorInitState.put(symbolInfo, InitState.INIT));
                .forEach(symbolInfo -> fieldCtorInitState.put(symbolInfo, InitState.UNKNOWN));

        //System.err.println("[ClassContext] fieldCtorInitState = " + fieldCtorInitState);
    }

    private SymbolTable getMergedInstanceAndStaticSymbolTable() {
        SymbolTable mergedSymbolTable = instanceSymbolTable.copy();
        mergedSymbolTable.merge(staticSymbolTable);
        return mergedSymbolTable;
    }

    public void update(FieldContext fieldCtx) {
        fieldInitState.put(fieldCtx.getName(), fieldCtx.getInitState());
    }

    public void merge(ConstructorContext ctor) {
        for (var e : fieldCtorInitState.entrySet()) {
            e.setValue(
                    InitState.meet(e.getValue(), ctor.get(e.getKey().getSymbol()))
            );
        }
    }

    public SymbolTable getClassSymbolTable() {
        return classSymbolTable;
    }

    public SymbolTable getInstanceSymbolTable() {
        return instanceSymbolTable;
    }

    public SymbolTable getStaticSymbolTable() {
        return staticSymbolTable;
    }

    public Optional<InvocationDeclarationContext> getCtorDefContext(String methodName) {
        return Optional.ofNullable(ctorNameToContextMap.get(methodName));
    }

    public void integrateFieldInitResults() {
        for (Map.Entry<String, InitState> entry : fieldInitState.entrySet()) {
            String field = entry.getKey();
            InitState initState = entry.getValue();

            if (initState == InitState.INIT) {
                var fieldSymbolInfoOpt = fieldCtorInitState.entrySet().stream()
                        .filter(_entry -> _entry.getKey().getSymbol().equals(field))
                        .map(Map.Entry::getKey)
                        .findFirst();

                if (fieldSymbolInfoOpt.isPresent()) {
                    fieldCtorInitState.put(fieldSymbolInfoOpt.get(), InitState.INIT);
                }
            }
        }
    }

    public boolean hasUninitializedNonNullField() {

        return fieldCtorInitState.values().stream()
                .anyMatch(initState -> initState == InitState.UNINIT || initState == InitState.UNKNOWN);
    }

    public List<SymbolInfo> getUninitializedFieldList() {

        return fieldCtorInitState.entrySet().stream()
                .filter(entry -> entry.getValue() == InitState.UNINIT || entry.getValue() == InitState.UNKNOWN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public void updateNonNullFieldNullState() {
        SymbolTable mergedSymbolTable = getMergedInstanceAndStaticSymbolTable();
        mergedSymbolTable.findSymbolInfoByType(List.of(TypeInfo.Type.Reference)).stream()
                .filter(fieldInfo -> !fieldInfo.getTypeInfo().isNullable() && fieldInfo.getNullState() != NullState.NON_NULL)
                .forEach(fieldInfo -> {
                    var initState = fieldCtorInitState.get(fieldInfo.getSymbol());
                    var updated = fieldInfo.toBuilder().nullState(NullState.NON_NULL).build();
                    if (initState == InitState.INIT) {
                        if (fieldInfo.isStatic()) {
                            staticSymbolTable.declare(fieldInfo.getSymbol(), updated);
                        } else {
                            staticSymbolTable.declare(fieldInfo.getSymbol(), updated);
                        }
                    }
                });
    }

    @Override
    public String toString() {
        return "ClassContext{" +
                "fieldInitState=" + fieldInitState +
                "fieldCtorInitState=" + fieldCtorInitState +
                '}';
    }
}
