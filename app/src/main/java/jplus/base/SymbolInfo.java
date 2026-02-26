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

import jplus.analyzer.nullability.dataflow.NullState;
import jplus.generator.TextChangeRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolInfo {
    private final String symbol;
    private final TypeInfo typeInfo;
    private final NullState nullState;
    private final TextChangeRange range;
    private final String originalText;
    private final List<Modifier> modifierList;

    private ResolvingStatus resolvingStatus = ResolvingStatus.RESOLVED;
    private SymbolTable symbolTable;

    public enum ResolvingStatus {
        RESOLVING,
        RESOLVED,
        UNRESOLVED
    }

    public SymbolInfo(String symbol, TypeInfo typeInfo, NullState nullState, TextChangeRange range, String originalText, List<Modifier> modifierList, SymbolTable symbolTable) {
        this.symbol = symbol;
        this.typeInfo = typeInfo;
        this.nullState = nullState;
        this.range = range;
        this.originalText = originalText;
        this.modifierList = modifierList;
        this.symbolTable = symbolTable;
    }

    public SymbolInfo(String symbol, TypeInfo typeInfo, TextChangeRange range, String originalText, List<Modifier> modifierList, SymbolTable symbolTable) {
        //this(symbol, typeInfo, typeInfo.isNullable() ? NullState.UNKNOWN : NullState.NON_NULL, range, originalText, modifierList, symbolTable);
        this(symbol, typeInfo, NullState.UNKNOWN, range, originalText, modifierList, symbolTable);
    }

    public SymbolInfo(String symbol, TypeInfo typeInfo, TextChangeRange range, String originalText, List<Modifier> modifierList) {
        this(symbol, typeInfo, NullState.UNKNOWN, range, originalText, modifierList, null);
    }

    public SymbolInfo(SymbolInfo other) {
        this.symbol = other.symbol;
        this.typeInfo = other.typeInfo;
        this.nullState = other.nullState;
        this.range = other.range;
        this.originalText = other.originalText;
        this.modifierList = other.modifierList;
        this.symbolTable = other.symbolTable;
    }

    public static SymbolInfo from(SymbolInfo other) {
        return new SymbolInfo(other);
    }

    public Builder toBuilder() {
        return new Builder()
                .symbol(this.symbol)
                .typeInfo(this.typeInfo)
                .nullState(this.nullState)
                .originalText(this.originalText)
                .range(this.range)
                .modifierList(this.modifierList)
                .symbolTable(this.symbolTable);
    }

    public String getSymbol() {
        return symbol;
    }

    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    public NullState getNullState() {
        return nullState;
    }

    public TextChangeRange getRange() {
        return range;
    }

    public String getOriginalText() {
        return originalText;
    }

    public List<Modifier> getModifierList() {
        return Collections.unmodifiableList(modifierList());
    }

    private List<Modifier> modifierList() {
        return (modifierList != null) ? modifierList : List.of();
    }

    public boolean isStatic() {
        return modifierList().contains(Modifier.STATIC);
    }

    public boolean isFinal() {
        return modifierList().contains(Modifier.FINAL);
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public ResolvingStatus getResolvingStatus() {
        return resolvingStatus;
    }

    public void setResolvingStatus(ResolvingStatus resolvingStatus) {
        this.resolvingStatus = resolvingStatus;
    }

    @Override
    public String toString() {
        return "SymbolInfo{" +
                "symbol=" + symbol +
                ", typeInfo=" + typeInfo +
                ", nullState=" + nullState +
                ", modifierList=" + modifierList +
//                ", range=" + range +
//                ", originalText='" + originalText + '\'' +
                '}';
    }

    public static class Builder {
        private String symbol;
        private TypeInfo typeInfo;
        private NullState nullState;
        private TextChangeRange range;
        private String originalText;
        private List modifierList;

        private SymbolTable symbolTable;

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder typeInfo(TypeInfo typeInfo) {
            this.typeInfo = typeInfo;
            return this;
        }

        public Builder nullState(NullState nullState) {
            this.nullState = nullState;
            return this;
        }

        public Builder range(TextChangeRange range) {
            this.range = range;
            return this;
        }

        public Builder originalText(String originalText) {
            this.originalText = originalText;
            return this;
        }

        public Builder modifierList(List modifierList) {
            this.modifierList = modifierList;
            return this;
        }

        public Builder symbolTable(SymbolTable symbolTable) {
            this.symbolTable = symbolTable;
            return this;
        }
        public SymbolInfo build() {
            //return new SymbolInfo(symbol, typeInfo, (nullState == null ? (typeInfo.isNullable() ? NullState.UNKNOWN : NullState.NON_NULL) : nullState), range, originalText, modifierList, symbolTable);
            return new SymbolInfo(symbol, typeInfo, (nullState == null ? NullState.UNKNOWN : nullState), range, originalText, modifierList, symbolTable);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
