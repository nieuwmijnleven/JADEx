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

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class BuilderFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("builder")) return;

        if (context.getClassSymbolTable().contains("Builder", TypeInfo.Type.Class)) {
            return;
        }

        String methodName = "^builder$_";
        if (context.getClassSymbolTable().contains(methodName, TypeInfo.Type.Method)) {
            return;
        }

        ConstructorFeatureProcessor processor = new ConstructorFeatureProcessor();
        processor.processAllArgsConstructor(context);

        String indentation = context.getIndentation();
        String doubleIndentation = indentation.repeat(2);

        TypeInfo targetClassTypeInfo = context.getTargetClassTypeInfo();
        System.err.println("[BuilderFeatureProcessor] targetClassTypeInfo = " + targetClassTypeInfo);
        String targetClassTypeName = CodeGenUtils.getSimpleTypeName(targetClassTypeInfo);
        System.err.println("[BuilderFeatureProcessor] targetClassTypeName = " + targetClassTypeName);
        String typeArgumentString = CodeGenUtils.getGenericTypeArgumentString(targetClassTypeInfo);
        System.err.println("[BuilderFeatureProcessor] typeArgumentString = " + typeArgumentString);


        String builderTypeName = "Builder" + typeArgumentString;
        String builder = "\npublic static class " + builderTypeName + " {";
        List<String> fieldDeclarations = new ArrayList<>();
        List<String> methodDeclarations = new ArrayList<>();
        List<String> nonStaticFieldList = new ArrayList<>();
        for (String fieldName : context.getFieldList()) {
            SymbolInfo symbolInfo = context.getClassSymbolTable().resolve(fieldName);
            TypeInfo typeInfo = symbolInfo.getTypeInfo();

            EnumSet<Modifier> excluded = EnumSet.of(Modifier.STATIC);
            if (CodeGenUtils.hasAnyModifiers(symbolInfo, excluded)) {
                continue;
            }

            String simpleTypeName = CodeGenUtils.getSimpleTypeName(typeInfo);

            fieldDeclarations.add(indentation + "private " + simpleTypeName + " " + fieldName + ";");
            methodDeclarations.add(indentation + "public " + builderTypeName + " " + fieldName + "(" + simpleTypeName + " " + fieldName + ") {\n" +
                    doubleIndentation + "this." + fieldName + " = " + fieldName + ";\n" +
                    doubleIndentation + "return this;\n" +
                    indentation + "}"
            );

            nonStaticFieldList.add(fieldName);
        }

        builder += fieldDeclarations.stream().collect(Collectors.joining("\n", "\n", "\n"));
        builder += methodDeclarations.stream().collect(Collectors.joining("\n\n", "\n", "\n"));
        builder += "\n" + indentation + "public " + targetClassTypeName + " build() {\n";
        builder += doubleIndentation + "return new " + targetClassTypeName + "(" + nonStaticFieldList.stream().collect(Collectors.joining(", ")) + ");\n";
        builder += indentation + "}\n";
        builder += "}\n";

        builder += "\npublic static " + getTypeArgumentString(typeArgumentString) + builderTypeName + " builder() {\n";
        builder += indentation + "return new " + builderTypeName + "();\n";
        builder += "}\n";

        context.appendMethodPartText(builder);
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("builder");
    }

    private String getTypeArgumentString(String typeArgumentString) {
        return typeArgumentString + (!typeArgumentString.isEmpty() ? " " : "");
    }
}
