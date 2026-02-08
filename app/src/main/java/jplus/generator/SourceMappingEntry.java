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

public class SourceMappingEntry {
    private String source;
    private TextChangeRange originalRange;
    private TextChangeRange transformedRange;

    public SourceMappingEntry(String source, TextChangeRange originalRange, TextChangeRange transformedRange) {
        this.source = source;
        this.originalRange = originalRange;
        this.transformedRange = transformedRange;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public TextChangeRange getOriginalRange() {
        return originalRange;
    }

    public void setOriginalRange(TextChangeRange originalRange) {
        this.originalRange = originalRange;
    }

    public TextChangeRange getTransformedRange() {
        return transformedRange;
    }

    public void setTransformedRange(TextChangeRange transformedRange) {
        this.transformedRange = transformedRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceMappingEntry sourceMappingEntry = (SourceMappingEntry) o;
        return java.util.Objects.equals(originalRange, sourceMappingEntry.originalRange)
            && java.util.Objects.equals(transformedRange, sourceMappingEntry.transformedRange);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(originalRange, transformedRange);
    }

    @Override
    public String toString() {
        return originalRange + " -> " + transformedRange;
    }
}