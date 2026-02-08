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

import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UnresolvedReferenceScanner {

    private final SymbolTable symbolTable;
    private final String packageName;

    public static class UnresolvedReferenceInfo {
        public String className;

        public String packageName;

        public String getFullyQualifiedName() {
            return packageName + "." + className;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof UnresolvedReferenceInfo info)) return false;
            return Objects.equals(className, info.className) && Objects.equals(packageName, info.packageName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(className, packageName);
        }

        @Override
        public String toString() {
            return "UnresolvedReferenceInfo{" +
                    "className='" + className + '\'' +
                    ", packageName='" + packageName + '\'' +
                    '}';
        }
    }

    public UnresolvedReferenceScanner(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.packageName = symbolTable.resolve("^PackageName$").getSymbol();
        //System.err.println("[UnresolvedReferenceScanner] packageName = " + this.packageName);
    }

    public List<UnresolvedReferenceInfo> findUnresolvedReference() {
        Set<UnresolvedReferenceInfo> unresolvedReferenceInfoList = new HashSet<>();
        for (SymbolInfo unresolved : findUnresolvedSymbols()) {
            UnresolvedReferenceInfo info = new UnresolvedReferenceInfo();
            info.className = unresolved.getTypeInfo().getName();
            info.packageName = this.packageName;
            unresolvedReferenceInfoList.add(info);
        }
        //System.err.println("[UnresolvedReferenceScanner] unresolvedReferenceInfoList = " + unresolvedReferenceInfoList);
        return unresolvedReferenceInfoList.stream().toList();
    }

    private List<SymbolInfo> findUnresolvedSymbols() {
        List<SymbolInfo> unresolved = new ArrayList<>();
        Deque<SymbolTable> deque = new LinkedList<>();
        deque.add(symbolTable);
        while (!deque.isEmpty()) {
            SymbolTable table = deque.removeFirst();
            for (SymbolInfo symbolInfo : table) {
                if (checkUnresolvedSymbol(symbolInfo)) {
                    //System.err.println("[UnresolvedReferenceScanner] symbolInfo = " + symbolInfo);
                    unresolved.add(symbolInfo);
                }
            }
            deque.addAll(table.getEnclosingSymbolTables());
        }
        return unresolved;
    }

    private boolean checkUnresolvedSymbol(@NonNull SymbolInfo symbolInfo) {
        if ("<error>".equals(symbolInfo.getSymbol())) return false;
        if ("<any>".equals(symbolInfo.getTypeInfo().getName())) return false;
        return symbolInfo.getTypeInfo().getType() == TypeInfo.Type.Unknown;
    }
}
