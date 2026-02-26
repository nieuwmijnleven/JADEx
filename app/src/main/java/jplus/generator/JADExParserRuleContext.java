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

package jplus.generator;

import org.antlr.v4.runtime.ParserRuleContext;

public class JADExParserRuleContext extends ParserRuleContext {
    private final CodeGenDelegate basicDelegate = new BasicCodeGenDelegate(this);
    private final CodeGenDelegate semanticDelegate = new SemanticCodeGenDelegate(this);

    public JADExParserRuleContext() {}

    public JADExParserRuleContext(ParserRuleContext parent, int invokingStateNumber) {
        super(parent, invokingStateNumber);
    }

    @Override
    public String getText() {
        return isSemanticMode() ? semanticDelegate.getText()
                                : basicDelegate.getText();
    }

    private boolean isSemanticMode() {
        return CodeGenContext.current().isSemanticMode();
    }
}