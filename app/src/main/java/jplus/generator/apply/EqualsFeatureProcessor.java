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
import jplus.util.CodeGenUtils;
import jplus.util.CodeUtils;
import jplus.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class EqualsFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("equals")) return;

        String methodSymbol = "^equals$_Object";
        if (context.getClassSymbolTable().contains(methodSymbol, TypeInfo.Type.Method)) {
            return;
        }

        List<String> primitiveTypeFieldList = context.getPrimitiveFields();
        List<String> referenceTypeFieldList = context.getReferenceFields();
        if (primitiveTypeFieldList.isEmpty() && referenceTypeFieldList.isEmpty()) {
            context.appendMethodPartText("true;\n");
        } else {
            String className = CodeGenUtils.getSimpleTypeNameWithGenericWildcard(context.getTargetClassTypeInfo());
            String instanceName = Utils.convertToCamelCase(context.getTargetClass());

            List<String> equalityChecks = new ArrayList<>();
            for (String primitiveTypeField : primitiveTypeFieldList) {
                equalityChecks.add(primitiveTypeField + " == " + instanceName + "." + primitiveTypeField);
            }

            for (String referenceTypeField : referenceTypeFieldList) {
                equalityChecks.add("java.util.Objects.equals(" + referenceTypeField + ", " + instanceName + "." + referenceTypeField + ")");
            }

            StringBuilder generatedText = new StringBuilder();
            String indentation = context.getIndentation();
            String doubleIndentation = indentation.repeat(2);

            generatedText.append("\n@Override\n");
            generatedText.append("public boolean equals(").append("Object o").append(") {\n");
            generatedText.append(indentation).append("if (this == o) return true;\n");
            generatedText.append(indentation).append("if (o == null || getClass() != o.getClass()) return false;\n");
            generatedText.append(indentation).append(className).append(" ").append(instanceName).append(" = ").append("(").append(className).append(") o;\n");

            generatedText.append(indentation).append("return ");
            generatedText.append(String.join("\n" + doubleIndentation + "&& ", equalityChecks));
            generatedText.append(";\n");
            generatedText.append("}\n");

            context.appendMethodPartText(generatedText.toString());
        }

//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("equals");
    }
}
