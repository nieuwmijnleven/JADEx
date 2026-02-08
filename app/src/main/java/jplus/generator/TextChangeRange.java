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

import java.util.Objects;

public record TextChangeRange(int startLine, int startIndex, int endLine, int inclusiveEndIndex) {

    public static final TextChangeRange EMPTY = new TextChangeRange(0, 0,Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static TextChangeRange copyFrom(final TextChangeRange range) {
        return new TextChangeRange(range.startLine, range.startIndex, range.endLine, range.inclusiveEndIndex);
    }

    public boolean isEmpty() {
        return endLine < startLine;
    }

    public boolean contains(TextChangeRange other) {
        return this.startLine() <= other.startLine()
                && this.endLine() >= other.endLine()
                && (this.startLine() != other.startLine() || this.startIndex() <= other.startIndex())
                && (this.endLine() != other.endLine() || this.inclusiveEndIndex() >= other.inclusiveEndIndex());
    }

    public boolean overlaps(TextChangeRange other) {
        return !(this.endLine() < other.startLine() ||
                this.startLine() > other.endLine() ||
                (this.endLine() == other.startLine() && this.inclusiveEndIndex() < other.startIndex()) ||
                (this.startLine() == other.endLine() && this.startIndex() > other.inclusiveEndIndex()));
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextChangeRange)) return false;
        TextChangeRange that = (TextChangeRange) o;
        return this.startLine() == that.startLine()
                && this.startIndex() == that.startIndex()
                && this.endLine() == that.endLine()
                && this.inclusiveEndIndex() == that.inclusiveEndIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(startLine(), startIndex(), endLine(), inclusiveEndIndex());
    }*/

    @Override
    public String toString() {
        return "TextChangeRange{" +
                "startLine=" + startLine +
                ", startIndex=" + startIndex +
                ", endLine=" + endLine +
                ", inclusiveEndIndex=" + inclusiveEndIndex +
                '}';
    }
}