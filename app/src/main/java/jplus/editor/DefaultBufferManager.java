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

package jplus.editor;

public class DefaultBufferManager implements BufferManager {
    private final StringBuilder originalBuffer;
    private final StringBuilder addBuffer;

    private int absStart;

    public DefaultBufferManager(String original, int absStart) {
        this.originalBuffer = new StringBuilder(original);
        this.addBuffer = new StringBuilder();
        this.absStart = absStart;
    }

    public DefaultBufferManager(String original) {
        this(original, 0);
    }

    @Override
    public int add(String text) {
        int start = absStart + addBuffer.length();
        addBuffer.append(text);
        return start;
    }

    @Override
    public String getOriginal() {
        return originalBuffer.toString();
    }

    @Override
    public char charAt(BufferType buffer, int start) {
        int relStart = start - absStart;
        return buffer == BufferType.ORIGINAL ? charAtFromOriginalBuffer(relStart)
                                             : charAtFromAddBuffer(relStart);
    }

    private char charAtFromAddBuffer(int relStart) {
        if (relStart < 0 || relStart >= addBuffer.length()) throw new IndexOutOfBoundsException();
        return addBuffer.charAt(relStart);
    }

    private char charAtFromOriginalBuffer(int relStart) {
        if (relStart < 0 || relStart >= originalBuffer.length()) throw new IndexOutOfBoundsException();
        return originalBuffer.charAt(relStart);
    }

    @Override
    public String substring(BufferType buffer, int start, int length) {
        int relStart = start - absStart;
        return buffer == BufferType.ORIGINAL ? substringFromOrignalBufffer(relStart, length)
                                             : substringFromAddBuffer(relStart, length);
    }

    private String substringFromAddBuffer(int relStart, int length) {
        if (relStart < 0 || relStart + length > addBuffer.length()) throw new IndexOutOfBoundsException();
        return addBuffer.substring(relStart, relStart + length);
    }

    private String substringFromOrignalBufffer(int relStart, int length) {
        if (relStart < 0 || relStart + length > originalBuffer.length()) throw new IndexOutOfBoundsException();
        return originalBuffer.substring(relStart, relStart + length);
    }
}
