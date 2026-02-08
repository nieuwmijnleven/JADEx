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

import jplus.base.TypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToStringFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("tostring")) return;

        String methodSymbol = "^toString$_";
        if (context.getClassSymbolTable().contains(methodSymbol, TypeInfo.Type.Method)) {
            return;
        }

        String toString = "\n@Override\n";
        toString += "public String toString() {\n";
        toString += context.getIndentation() + "return \"" + context.getTargetClass() + "{\"";

        List<String> lines = new ArrayList<>();
        for (String fieldName : context.getFieldList()) {
            lines.add("\"" + fieldName + "=\"" + " + " + fieldName);
        }
        toString += lines.stream().collect(Collectors.joining("+ \", \" + ", " + ", " + "));
        toString += "\"}\";\n";
        toString += "}\n";
        context.appendMethodPartText(toString);
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("tostring");
    }
}
