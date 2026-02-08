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

import java.util.EnumSet;

public class ToBuilderFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("tobuilder")) return;

        String methodName = "^toBuilder$_";
        if (context.getClassSymbolTable().contains(methodName, TypeInfo.Type.Method)) {
            return;
        }

        if (!context.getClassSymbolTable().contains("Builder", TypeInfo.Type.Class) || !context.hasProcessed("builder")) {
            new BuilderFeatureProcessor().process(context);
        }

        String indentation = context.getIndentation();
        String doubleIndentation = indentation.repeat(2);

        TypeInfo targetClassTypeInfo = context.getTargetClassTypeInfo();
        System.err.println("[ToBuilderFeatureProcessor] targetClassTypeInfo = " + targetClassTypeInfo);
        String typeArgumentString = CodeGenUtils.getGenericTypeArgumentString(targetClassTypeInfo);
        System.err.println("[ToBuilderFeatureProcessor] typeArgumentString = " + typeArgumentString);


        String builderTypeName = "Builder" + typeArgumentString;
        String builder = "\npublic " + builderTypeName + " toBuilder() {\n";
        builder += indentation + "return new Builder" + typeArgumentString + "()";

        for (String fieldName : context.getFieldList()) {
            SymbolInfo symbolInfo = context.getClassSymbolTable().resolve(fieldName);

            EnumSet<Modifier> excluded = EnumSet.of(Modifier.STATIC);
            if (CodeGenUtils.hasAnyModifiers(symbolInfo, excluded)) {
                continue;
            }

            builder += "\n" + doubleIndentation + "." + fieldName + "(this." + fieldName + ")";
        }

        builder += ";\n}\n";

        context.appendMethodPartText(builder);
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("tobuilder");
    }
}
