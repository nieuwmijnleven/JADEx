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

package jplus.base;

import jplus.analyzer.ResolvedChain;
import jplus.generator.TextChangeRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SymbolTable implements Iterable<SymbolInfo> {

    public static final String STATIC_NS = "^static$";
    public static final String INSTANCE_NS = "^instance$";

    private SymbolTable superClassTable;

    private List<SymbolTable> superInterfaceTables = new ArrayList<>();

    private final ExecutionContext context;

    private boolean deadContext;

    private SymbolTable parent;

    private Map<String, SymbolInfo> symbolMap = new HashMap<>();

    private Map<String, SymbolTable> enclosing = new HashMap<>();

    private List<ResolvedChain> resolvedChains = new ArrayList<>();

    private Map<String, SymbolInfo> ifContextMap = new HashMap<>();

    public enum ExecutionContext {
        STATIC,
        INSTANCE;
    }

    /*enum TableKind {
        CLASS,
        METHOD,
        BLOCK
    }*/

    public SymbolTable(SymbolTable parent, ExecutionContext context) {
        this.parent = parent;
        this.context = context;
    }

    public SymbolTable(SymbolTable parent) {
        this(parent, ExecutionContext.INSTANCE);
    }

    public SymbolTable copy() {
        return copy(false);
    }

    public SymbolTable copy(boolean parentCopy) {
        SymbolTable parent = parentCopy ? this.parent.copy() : this.parent;
        SymbolTable replica = new SymbolTable(parent, this.context);

        replica.symbolMap = new HashMap<>();
        for (var e : this.symbolMap.entrySet()) {
            replica.symbolMap.put(e.getKey(), e.getValue().toBuilder().symbolTable(replica).build());
        }

        replica.resolvedChains = new ArrayList<>(this.resolvedChains);
//        for (ResolvedChain chain : this.resolvedChains) {
//            copy.resolvedChains.add(chain.deepCopy());
//        }

        replica.enclosing = new HashMap<>();
        for (var e : this.enclosing.entrySet()) {
            SymbolTable childCopy = e.getValue().copy();
            childCopy.parent = replica;
            replica.enclosing.put(e.getKey(), childCopy);
        }

        replica.setDeadContext(deadContext);

        return replica;
    }

    private void declareInternal(String name, SymbolInfo symbolInfo) {
        symbolMap.put(name, symbolInfo);
    }

    public void declare(String name, SymbolInfo symbolInfo) {
        if (isClassContext()) {
            if (symbolInfo.isStatic()) {
                getEnclosingSymbolTable(STATIC_NS)
                        .declareInternal(name, symbolInfo);
            } else {
                getEnclosingSymbolTable(INSTANCE_NS)
                        .declareInternal(name, symbolInfo);
            }
        } else {
            declareInternal(name, symbolInfo);
        }
    }

    private boolean isClassContext() {
        return containsInCurrent("^ClassDef$", TypeInfo.Type.Class);
    }


    /*public SymbolInfo resolve(String name) {
        SymbolInfo symbolInfo = symbolMap.get(name);
        if (symbolInfo == null && parent != null) {
            symbolInfo = parent.resolve(name);
        }
        return symbolInfo;
    }*/
    public void setSuperClassTable(SymbolTable superClassTable) {
        this.superClassTable = superClassTable;
    }

    public boolean hasSuperClassTable() {
        return this.superClassTable != null;
    }

    public SymbolTable getSuperClassTable() {
        return superClassTable;
    }

    public void addSuperInterfaceTable(SymbolTable superInterfaceTable) {
        superInterfaceTables.add(superInterfaceTable);
    }

    public List<SymbolTable> getSuperInterfaceTables() {
        return Collections.unmodifiableList(this.superInterfaceTables);
    }

    public SymbolInfo resolve(String name) {

        SymbolInfo symbolInfo = resolveInCurrentContextPath(name);
        if (symbolInfo != null) {
            return symbolInfo;
        }

        symbolInfo = resolveInSuperContextPath(name);
        if (symbolInfo != null) {
            return symbolInfo;
        }

        return null;
    }

    public SymbolInfo resolveInCurrentContextPath(String name) {

        SymbolInfo symbolInfo = resolveInCurrentContextPathInternal(name);
        if (symbolInfo != null) {
            return symbolInfo;
        }

        if (parent != null) {
            return parent.resolveInCurrentContextPath(name);
        }

        return null;
    }

    public SymbolInfo resolveInCurrentContextPathInternal(String name) {
        SymbolInfo local = symbolMap.get(name);
        if (local != null) return local;

        if (!isClassContext()) return null;

        //System.err.println("[resolve] symbol = " + name);
        if (context == ExecutionContext.INSTANCE) {
            SymbolTable instanceNS = enclosing.get(INSTANCE_NS);
            //System.err.println("[resolve][instance] isClassContext symbol = " + name);
            if (instanceNS != null) {
                SymbolInfo inst = instanceNS.resolveInCurrent(name);
                if (inst != null) return inst;
            }
        }

        SymbolTable staticNS = enclosing.get(STATIC_NS);
        if (staticNS != null) {
            //System.err.println("[resolve][static] isClassContext symbol = " + name);
            SymbolInfo stat = staticNS.resolveInCurrent(name);
            if (stat != null) return stat;
        }

        return null;
    }

    public SymbolInfo resolveInSuperContextPath(String name) {

        if (superClassTable != null) {
            var symbolInfo = superClassTable.resolve(name);
            if (symbolInfo != null) return symbolInfo;
        }

        if (!superInterfaceTables.isEmpty()) {
            for (var superInterfaceTable : superInterfaceTables) {
                var symbolInfo = superInterfaceTable.resolve(name);
                if (symbolInfo != null) return symbolInfo;
            }
        }

        return null;
    }

    public SymbolInfo resolveInCurrent(String name) {
        SymbolInfo local = symbolMap.get(name);
        if (local != null) return local;

        if (superClassTable != null) {
            var symbolInfo = superClassTable.resolve(name);
            if (symbolInfo != null) return symbolInfo;
        }

        if (!superInterfaceTables.isEmpty()) {
            for (var superInterfaceTable : superInterfaceTables) {
                var symbolInfo = superInterfaceTable.resolve(name);
                if (symbolInfo != null) return symbolInfo;
            }
        }

        if (!isClassContext()) return null;

        //System.err.println("[resolve] symbol = " + name);
        if (context == ExecutionContext.INSTANCE) {
            SymbolTable instanceNS = enclosing.get(INSTANCE_NS);
            //System.err.println("[resolve][instance] isClassContext symbol = " + name);
            if (instanceNS != null) {
                SymbolInfo inst = instanceNS.resolveInCurrent(name);
                if (inst != null) return inst;
            }
        }

        SymbolTable staticNS = enclosing.get(STATIC_NS);
        if (staticNS != null) {
            //System.err.println("[resolve][static] isClassContext symbol = " + name);
            SymbolInfo stat = staticNS.resolveInCurrent(name);
            if (stat != null) return stat;
        }

        return null;
    }

    private SymbolInfo resolveInCurrentInternal(String name, EnumSet<TypeInfo.Type> type) {
        SymbolInfo symbolInfo = symbolMap.get(name);
        if (symbolInfo == null) return null;
        return type.contains(symbolInfo.getTypeInfo().getType()) ? symbolInfo : null;
    }

    public Optional<SymbolInfo> resolveInCurrent(String name, EnumSet<TypeInfo.Type> type) {
        return Optional.ofNullable(resolveInCurrentInternal(name, type));
    }

    @Override
    public Iterator<SymbolInfo> iterator() {
        return symbolMap.values().iterator();
    }

    public Iterator<String> keyIterator() {
        return symbolMap.keySet().iterator();
    }

    public List<SymbolTable> getEnclosingSymbolTables() {
        return enclosing.values().stream().toList();
    }

    public void merge(SymbolTable table) {
        table.symbolMap.forEach((symbol, symbolInfo) -> symbolMap.put(symbol, symbolInfo.toBuilder().symbolTable(this).build()));
        //table.enclosing.forEach(enclosing::putIfAbsent);
        //mergeDeadContext(table.isDeadContext());
    }

    public boolean isEmpty() {
        return symbolMap.isEmpty();
    }

    public boolean isDeadContext() {
        return deadContext;
    }

    public void setDeadContext(boolean deadContext) {
        this.deadContext = deadContext;
    }

    public void mergeDeadContext(boolean deadContext) {
        this.deadContext |= deadContext;
    }

    public boolean contains(String symbol, TypeInfo.Type type) {
        SymbolInfo symbolInfo = resolve(symbol);
        if (symbolInfo != null && symbolInfo.getTypeInfo().getType() == type) {
            return true;
        }
        return false;
    }

    public boolean contains(String symbol, EnumSet<TypeInfo.Type> types) {
        SymbolInfo symbolInfo = resolve(symbol);
        if (symbolInfo == null) return false;

        return types.contains(symbolInfo.getTypeInfo().getType());
    }

    public boolean containsInCurrent(String symbol, TypeInfo.Type type) {
        SymbolInfo symbolInfo = symbolMap.get(symbol);
        if (symbolInfo != null && symbolInfo.getTypeInfo().getType() == type) {
            return true;
        }
        return false;
    }

    public boolean containsInCurrent(String symbol, EnumSet<TypeInfo.Type> types) {
        SymbolInfo symbolInfo = resolveInCurrent(symbol);
        if (symbolInfo == null) return false;

        return types.contains(symbolInfo.getTypeInfo().getType());
    }

    public List<String> findSymbolsByType(List<TypeInfo.Type> typeList) {

        var allSymbolMap = symbolMap;

        if (isClassContext()) {
            allSymbolMap = new HashMap<>();
            getEnclosingSymbolTable(INSTANCE_NS).symbolMap.forEach(allSymbolMap::putIfAbsent);
            getEnclosingSymbolTable(STATIC_NS).symbolMap.forEach(allSymbolMap::putIfAbsent);
        }

        return allSymbolMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(symbolInfo -> typeList.contains(symbolInfo.getTypeInfo().getType()))
                .sorted(
                        Comparator
                                .comparingInt((SymbolInfo s) -> s.getRange().startLine())
                                .thenComparingInt(s -> s.getRange().startIndex())
                )
                .map(SymbolInfo::getSymbol)
                .toList();
    }

    public List<SymbolInfo> findSymbolInfoByType(List<TypeInfo.Type> typeList) {

        var allSymbolMap = symbolMap;

        if (isClassContext()) {
            allSymbolMap = new HashMap<>();
            getEnclosingSymbolTable(INSTANCE_NS).symbolMap.forEach(allSymbolMap::putIfAbsent);
            getEnclosingSymbolTable(STATIC_NS).symbolMap.forEach(allSymbolMap::putIfAbsent);
        }

        return allSymbolMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(symbolInfo -> typeList.contains(symbolInfo.getTypeInfo().getType()))
                .sorted(
                        Comparator
                                .comparingInt((SymbolInfo s) -> s.getRange().startLine())
                                .thenComparingInt(s -> s.getRange().startIndex())
                )
                .toList();
    }

    public SymbolTable getParent() {
        return parent;
    }

    public SymbolTable addEnclosingSymbolTable(String name, SymbolTable symbolTable) {
        if (symbolTable == null) throw new IllegalArgumentException();
        enclosing.put(name, symbolTable);
        return symbolTable;
    }

    public SymbolTable getEnclosingSymbolTable(String name) {
        return enclosing.computeIfAbsent(name, s -> {
            if (STATIC_NS.equals(name)) {
                return new SymbolTable(this, ExecutionContext.STATIC);
            }
            if (INSTANCE_NS.equals(name)) {
                return new SymbolTable(this, ExecutionContext.INSTANCE);
            }
            return new SymbolTable(this, this.context);
        });
    }

    public void addResolvedChain(ResolvedChain chain) {
        resolvedChains.add(chain);
    }

    public List<ResolvedChain> getResolvedChains() {
        return Collections.unmodifiableList(resolvedChains);
    }

    private boolean compareResolvedChainRange(ResolvedChain chain, TextChangeRange range) {
        return Optional.ofNullable(chain.last())
                .map(step -> step.range.equals(range))
                .orElse(false);
    }

    private Optional<ResolvedChain> findResolvedChildChain(ResolvedChain chain, TextChangeRange range) {
        if (compareResolvedChainRange(chain, range)) {
            return Optional.of(chain);
        }

        for (ResolvedChain.Step step : chain.getSteps()) {
            if (step.kind == ResolvedChain.Kind.CHAIN) {
                var result = findResolvedChildChain(step.childChain, range);
                if (result.isPresent()) return result;
            }
        }

        return Optional.empty();
    }

    public Optional<ResolvedChain> findResolvedChain(TextChangeRange range) {
        for (ResolvedChain resolvedChain : resolvedChains) {
            var result = findResolvedChildChain(resolvedChain, range);
            if (result.isPresent()) return result;
        }

        return findResolvedPlusChain(range);
    }

    private Optional<ResolvedChain> findResolvedPlusChain(TextChangeRange range) {
        for (ResolvedChain resolvedChain : resolvedChains) {
            if (resolvedChain.isEmpty()) continue;

            var firstStep = resolvedChain.first();
            var lastStep = resolvedChain.last();

            TextChangeRange totalRange = new TextChangeRange(firstStep.range.startLine(), firstStep.range.startIndex(), lastStep.range.endLine(), lastStep.range.inclusiveEndIndex());

            if (totalRange.equals(range)) return Optional.of(resolvedChain);
        }

        return Optional.empty();
    }

    private boolean compareResolvedQualifierChain(ResolvedChain chain, TextChangeRange range) {
        return Optional.ofNullable(chain.qualifierLast())
                .map(step -> step.range.equals(range))
                .orElse(false);
    }

    private Optional<ResolvedChain> findResolvedChildQualifierChain(ResolvedChain chain, TextChangeRange range) {
        if (compareResolvedQualifierChain(chain, range)) {
            return Optional.of(chain);
        }

        for (ResolvedChain.Step step : chain.getSteps()) {
            if (step.kind == ResolvedChain.Kind.CHAIN) {
                var result = findResolvedChildQualifierChain(step.childChain, range);
                if (result.isPresent()) return result;
            }
        }

        return Optional.empty();
    }

    public Optional<ResolvedChain> findResolvedQualifierChain(TextChangeRange range) {
        for (ResolvedChain resolvedChain : resolvedChains) {
            var result = findResolvedChildQualifierChain(resolvedChain, range);
            if (result.isPresent()) return result;
        }

        return Optional.empty();
    }

    public SymbolTable promoteLocalSymbols() {
        //SymbolTable replica = parent.copy();
        SymbolTable replica = parent;

        //replica.symbolMap = new HashMap<>();
        for (var e : this.symbolMap.entrySet()) {
            replica.symbolMap.put(e.getKey(), e.getValue().toBuilder().symbolTable(replica).build());
        }

        replica.setDeadContext(isDeadContext());

        return replica;
    }

    public SymbolTable transplantLocalSymbols(SymbolTable table) {
        //SymbolTable replica = parent.copy();
        //SymbolTable replica = parent;

        //table.symbolMap = new HashMap<>();
        for (var e : this.symbolMap.entrySet()) {
            table.symbolMap.put(e.getKey(), e.getValue().toBuilder().symbolTable(table).build());
        }

        //table.setDeadContext(isDeadContext());

        return table;
    }

    public SymbolTable findLowContextSymbolTable(String name) {
        if (!symbolMap.containsKey(name)) {
            SymbolTable found = null;
            for (SymbolTable symbolTable : enclosing.values()) {
                if ((found = symbolTable.findLowContextSymbolTable(name)) != null) {
                    return found;
                }
            }
            return new SymbolTable(null);
        }
        return enclosing.get(name);
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                //"parent=" + parent +
                ", symbolMap=" + symbolMap +
                ", enclosing=" + enclosing +
                '}';
    }
}
