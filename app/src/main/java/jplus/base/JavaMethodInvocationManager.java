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

import jplus.generator.TextChangeRange;
import jplus.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JavaMethodInvocationManager {
    private final String source;
    private final Map<SymbolTable, Map<String, MethodInvocationInfo>> invocationMapInSymbolTable = new HashMap<>();

    public JavaMethodInvocationManager(String source) {
        this.source = source;
    }

    public void addInvocationInfo(SymbolTable symbolTable, MethodInvocationInfo invocationInfo) {
        var invocationMap = invocationMapInSymbolTable.computeIfAbsent(symbolTable, (k) -> new HashMap<>());
        invocationMap.put(invocationInfo.source, invocationInfo);
    }

    public MethodInvocationInfo getInvocationInfo(SymbolTable symbolTable, String invocationCode) {
        return Optional.ofNullable(invocationMapInSymbolTable.get(symbolTable)).orElseThrow().get(invocationCode);
    }

    public Optional<MethodInvocationInfo> findInvocationInfo(SymbolTable symbolTable, TextChangeRange range) {
        return Optional.ofNullable(invocationMapInSymbolTable.get(symbolTable)).stream()
                .flatMap(methodInvocationInfoMap -> methodInvocationInfoMap.entrySet().stream())
                .map(Map.Entry::getValue)
                .filter(invocationInfo -> {
                    TextChangeRange invocationCodeRange = Utils.computeTextChangeRange(source, invocationInfo.startPos, invocationInfo.endPos - 1);
                    return invocationCodeRange.equals(range);
                })
                .findFirst();
    }
}
