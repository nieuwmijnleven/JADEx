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

import jplus.base.Modifier;
import jplus.base.SymbolInfo;
import jplus.base.TypeInfo;
import jplus.util.CodeGenUtils;
import jplus.util.Utils;

import java.util.EnumSet;

public class GetterFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("getter")) return;

        for (String fieldName : context.getFieldList()) {
            System.err.println("[GetterFeatureProcessor] fieldName = " + fieldName);
            String methodName = "get" + Utils.convertToPascalCase(fieldName);
            String methodSymbol = "^" + methodName + "$_";
            if (context.getClassSymbolTable().contains(methodSymbol, TypeInfo.Type.Method)) {
                continue;
            }

            SymbolInfo symbolInfo = context.getClassSymbolTable().resolve(fieldName);
            System.err.println("[GetterFeatureProcessor] typeInfo = " + symbolInfo.getTypeInfo());
            String simpleTypeName = CodeGenUtils.getSimpleTypeName(symbolInfo.getTypeInfo());

            EnumSet<Modifier> excluded = EnumSet.of(Modifier.STATIC);
            if (CodeGenUtils.hasAnyModifiers(symbolInfo, excluded)) {
                continue;
            }

            StringBuilder methodPartText = new StringBuilder();
            methodPartText.append("\n");
            methodPartText.append("public ").append(simpleTypeName).append(" ").append(methodName).append("() {\n");
            methodPartText.append(context.getIndentation()).append("return ").append(fieldName).append(";\n");
            methodPartText.append("}\n");

            context.appendMethodPartText(methodPartText.toString());
        }
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("getter");
    }
}