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

import jplus.generator.TextChangeRange;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FragmentedTextTest {

    @Test
    void getOriginalText() {
        String text = "Hello World\nLine2";
        FragmentedText ft = new FragmentedText(text);

        assertEquals(text, ft.getOriginalText());
        assertEquals(text, ft.toString());
    }

    @Test
    void findFragmentByRange() {
        String text = "abcdef";
        FragmentedText ft = new FragmentedText(text);

        TextChangeRange range = new TextChangeRange(1, 0, 1, text.length() - 1);
        Optional<String> found = ft.findFragmentByRange(range);

        assertTrue(found.isPresent());
        assertEquals(text, found.get());

        TextChangeRange missingRange = new TextChangeRange(1, 0, 1, 2);
        assertTrue(ft.findFragmentByRange(missingRange).isEmpty());
    }

    @Test
    void projectOn() {
        String text = "Hello";
        FragmentedText ft = new FragmentedText(text);

        String projected = "      World";
        TextChangeRange targetRange = new TextChangeRange(1, 0, 1, projected.length() - 1);
        String projectedText = ft.projectOn(targetRange, projected);

        assertTrue(Objects.equals(ft.toString(), "Hello"));
        assertTrue(Objects.equals(projectedText, "Hello World"));
    }

    @Test
    void appendTextFromEndParenthesis() {
        String text = "line1\nline2\n}";
        FragmentedText ft = new FragmentedText(text);

        ft.appendTextFromEndParenthesis("APPEND");
        String updated = ft.toString();
        assertTrue(updated.endsWith("APPEND"));
    }

    @Test
    void update() {
        String text = "abcdefgh";
        FragmentedText ft = new FragmentedText(text);

        TextChangeRange range = new TextChangeRange(1, 2, 1, 5); // cdef
        ft.update(range, "XYZ");

        String result = ft.toString();
        assertTrue(result.contains("XYZ"));
        assertTrue(result.contains("ab"));
        assertTrue(result.contains("gh"));

        TextChangeRange invalidRange = new TextChangeRange(2, 0, 2, 2);
        assertThrows(IllegalStateException.class, () -> ft.update(invalidRange, "X"));
    }

    @Test
    void buildSourceMap() {
        String text = "abc\ndef";
        FragmentedText ft = new FragmentedText(text);

        Set<?> sourceMap = ft.buildSourceMap();
        assertFalse(sourceMap.isEmpty());

        sourceMap.forEach(entry -> assertNotNull(entry));
    }

    @Test
    void traversePrior() {
        String text = "abc";
        FragmentedText ft = new FragmentedText(text);

        Set<?> sourceMap = ft.buildSourceMap();
        assertFalse(sourceMap.isEmpty());
    }

    @Test
    void debugString() {
        String text = "Hello\nWorld";
        FragmentedText ft = new FragmentedText(text);

        String debug = ft.debugString();
        assertTrue(debug.contains("Hello"));
        assertTrue(debug.contains("World"));
    }

    @Test
    void testToString() {
        String text = "Line1\nLine2";
        FragmentedText ft = new FragmentedText(text);

        assertEquals(text, ft.toString());
    }
}