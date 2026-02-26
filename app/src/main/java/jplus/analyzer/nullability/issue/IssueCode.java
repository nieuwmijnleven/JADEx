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

package jplus.analyzer.nullability.issue;

public enum IssueCode {
    NULLABLE_DEREFERENCE(Severity.WARNING),
    PRIMITIVE_RESULT_SAFE_NAVIGATION_REQUIRES_ELVIS(Severity.WARNING),
    //PRIMITIVE_RESULT_SAFE_NAVIGATION_REQUIRES_ELVIS(Severity.ERROR),
    UNINITIALIZED_NONNULL_VARIABLE(Severity.WARNING),
    UNINITIALIZED_NONNULL_FIELD(Severity.WARNING),
    UNINITIALIZED_FINAL_FIELD(Severity.WARNING),
    //UNINITIALIZED_FINAL_FIELD(Severity.ERROR),
    NULL_ASSIGNMENT_TO_NONNULL_VARIABLE(Severity.WARNING),
    NULLABLE_ASSIGNMENT_TO_NONNULL_VARIABLE(Severity.WARNING),
    NULL_ARGUMENT_TO_NONNULL_PARAMETER(Severity.WARNING),
    NULLABLE_SWITCH_SELECTOR(Severity.WARNING),
    NULLABLE_SWITCH_GUARD(Severity.WARNING),
    NULL_RETURN_IN_NONNULL_METHOD(Severity.WARNING),
    REASSIGN_TO_FINAL(Severity.WARNING),
    //REASSIGN_TO_FINAL(Severity.ERROR),
    DEREFERENCE_OF_UNINITIALIZED_VARIABLE(Severity.WARNING);
    //DEREFERENCE_OF_UNINITIALIZED_VARIABLE(Severity.ERROR);

    private final Severity severity;

    IssueCode(Severity severity) {
        this.severity = severity;
    }

    public Severity getSeverity() {
        return severity;
    }
}