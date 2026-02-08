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
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.util.CodeGenUtils;
import jplus.util.Utils;

import java.util.EnumSet;

public class SetterFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("setter")) return;

        SymbolTable classSymbolTable = context.getClassSymbolTable();
        for (String fieldName : context.getFieldList()) {
            SymbolInfo symbolInfo = classSymbolTable.resolve(fieldName);
            TypeInfo typeInfo = symbolInfo.getTypeInfo();
            System.err.println("[GetterFeatureProcessor] typeInfo = " + typeInfo);
            String simpleTypeName = CodeGenUtils.getSimpleTypeName(typeInfo);

            EnumSet<Modifier> excluded = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
            if (CodeGenUtils.hasAnyModifiers(symbolInfo, excluded)) {
                continue;
            }

            String methodName = "set" + Utils.convertToPascalCase(fieldName);
            String methodSymbol = "^" + methodName + "$_" + typeInfo.getName();
            if (classSymbolTable.contains(methodSymbol, TypeInfo.Type.Method)) {
                continue;
            }

            StringBuffer methodPartText = new StringBuffer();
            methodPartText.append("\n");
            methodPartText.append("public ").append("void").append(" ").append(methodName).append("(").append(simpleTypeName).append(" ").append(fieldName).append(")").append(" {\n");
            methodPartText.append(context.getIndentation()).append("this.").append(fieldName).append(" = ").append(fieldName).append(";\n").append("}\n");

            context.appendMethodPartText(methodPartText.toString());
        }
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("setter");
    }
}
