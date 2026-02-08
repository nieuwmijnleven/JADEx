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

import java.util.HashMap;
import java.util.Map;

public class ConstructorContext implements Context {

    private Map<String, InitState> initStateMap = new HashMap<>();

    public void put(String field, InitState initState) {
        initStateMap.put(field, initState);
    }

    public InitState get(String field) {
        return initStateMap.getOrDefault(field, InitState.UNINIT);
    }

    @Override
    public String toString() {
        return "ConstructorContext{" +
                "initStateMap=" + initStateMap +
                '}';
    }
}
