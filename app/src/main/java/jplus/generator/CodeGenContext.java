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

import jplus.editor.FragmentedText;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CodeGenContext {
    private static final ThreadLocal<Deque<CodeGenContext>> stackLocal = ThreadLocal.withInitial(ArrayDeque::new);

    private FragmentedText fragmentedText;

    private final Set<SourceMappingEntry> sourceMappingEntrySet = new HashSet<>();

    private boolean semanticMode = false;

    private boolean immutableMode = false;

    private CodeGenContext() {}

    public static CodeGenContext current() {
        Deque<CodeGenContext> stack = stackLocal.get();
        return stack.peek(); // 현재 top
    }

    public static void push() {
        stackLocal.get().push(new CodeGenContext());
    }

    public static void pop() {
        stackLocal.get().pop();
    }

    public FragmentedText getFragmentedText() {
        return fragmentedText;
    }

    public void setFragmentedText(FragmentedText fragmentedText) {
        this.fragmentedText = fragmentedText;
    }

    public boolean isSemanticMode() {
        return semanticMode;
    }

    public void setSemanticMode(boolean semanticMode) {
        this.semanticMode = semanticMode;
    }

    public boolean isImmutableMode() {
        return immutableMode;
    }

    public void setImmutableMode(boolean immutableMode) {
        this.immutableMode = immutableMode;
    }

    public void addSourceMappingEntry(SourceMappingEntry entry) {
        sourceMappingEntrySet.add(entry);
    }

    public void addSourceMappingEntrySet(Set<SourceMappingEntry> entrySet) {
        sourceMappingEntrySet.addAll(entrySet);
    }

    public Set<SourceMappingEntry> getSourceMapping() {
        return sourceMappingEntrySet;
    }

    public void reset() {
        sourceMappingEntrySet.clear();
    }
}
