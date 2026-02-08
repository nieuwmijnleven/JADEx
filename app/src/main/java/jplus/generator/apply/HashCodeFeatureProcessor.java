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
import jplus.util.Utils;

public class HashCodeFeatureProcessor implements ApplyFeatureProcessor {
    @Override
    public void process(ApplyFeatureProcessingContext context) {
        if (context.hasProcessed("hashcode")) return;

        String methodSymbol = "^hashCode$_";
        if (context.getClassSymbolTable().contains(methodSymbol, TypeInfo.Type.Method)) {
            return;
        }

        StringBuilder generatedText = new StringBuilder();
        generatedText.append("\n@Override\n");
        generatedText.append("public int hashCode() {\n");
        generatedText.append(context.getIndentation()).append("return ").append("java.util.Objects.hash(").append(String.join(", ", context.getFieldList())).append(");\n");
        generatedText.append("}\n");

        context.appendMethodPartText(generatedText.toString());
//        ApplyFeatureProcessor.super.process(context);
        context.addProcessedAction("hashcode");
    }
}
