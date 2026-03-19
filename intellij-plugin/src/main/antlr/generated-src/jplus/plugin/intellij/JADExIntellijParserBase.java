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

package jplus.plugin.intellij;

import org.antlr.v4.runtime.*;

import java.util.List;

public abstract class JADExIntellijParserBase extends Parser {

    public JADExIntellijParserBase(TokenStream input){
	super(input);
    }

    public boolean DoLastRecordComponent() {
	ParserRuleContext ctx = this.getContext();
	if (!(ctx instanceof JADExIntellijParser.RecordComponentListContext)) {
	    return true; // or throw if this is an unexpected state
	}

	JADExIntellijParser.RecordComponentListContext tctx = (JADExIntellijParser.RecordComponentListContext) ctx;
	List<JADExIntellijParser.RecordComponentContext> rcs = tctx.recordComponent();
	if (rcs.isEmpty()) return true;

	int count = rcs.size();
	for (int c = 0; c < count; ++c) {
	    JADExIntellijParser.RecordComponentContext rc = rcs.get(c);
	    if (rc.ELLIPSIS() != null && c + 1 < count)
		return false;
	}
	return true;
    }

    public boolean IsNotIdentifierAssign()
    {
	var la = this._input.LA(1);
	    // If not identifier, return true because it can't be
	    // "identifier = ..."
	switch (la) {
	    case JADExIntellijParser.IDENTIFIER:
	    case JADExIntellijParser.MODULE:
	    case JADExIntellijParser.OPEN:
	    case JADExIntellijParser.REQUIRES:
	    case JADExIntellijParser.EXPORTS:
	    case JADExIntellijParser.OPENS:
	    case JADExIntellijParser.TO:
	    case JADExIntellijParser.USES:
	    case JADExIntellijParser.PROVIDES:
	    case JADExIntellijParser.WHEN:
	    case JADExIntellijParser.WITH:
	    case JADExIntellijParser.TRANSITIVE:
	    case JADExIntellijParser.YIELD:
	    case JADExIntellijParser.SEALED:
	    case JADExIntellijParser.PERMITS:
	    case JADExIntellijParser.RECORD:
	    case JADExIntellijParser.VAR:
		break;
	    default:
		return true;
	}
	var la2 = this._input.LA(2);
	if (la2 != JADExIntellijParser.ASSIGN) return true;
	return false;
    }
}
