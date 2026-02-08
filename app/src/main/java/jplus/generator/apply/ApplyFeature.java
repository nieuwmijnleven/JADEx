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

package jplus.generator.apply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyFeature {
    private final String action;
    private final List<String> argumentList;

    public ApplyFeature(String action) {
        this.action = action;
        this.argumentList = new ArrayList<>();
    }

    public ApplyFeature(String action, List<String> argumentList) {
        this(action);
        this.argumentList.addAll(argumentList);
    }

    public void addArgument(String argument) {
        argumentList.add(argument);
    }

    public String getAction() {
        return action;
    }

    public List<String> getArgumentList() {
        return Collections.unmodifiableList(argumentList);
    }

    @Override
    public String toString() {
        return "ApplyFeature{" +
                "action='" + action + '\'' +
                ", argumentList=" + argumentList +
                '}';
    }
}
