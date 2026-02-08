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

import jplus.generator.SourceMappingEntry;
import jplus.generator.TextChangeRange;
import jplus.util.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class FragmentedText {
    private final BufferManager bufferManager;
    private final TextChangeRange originalRange;
    private final List<Fragment> fragments = new ArrayList<>();

    static final class TextRef {
        BufferType bufType;
        int start;
        int length;

        public TextRef(BufferType bufType, int start, int length) {
            this.bufType = bufType;
            this.start = start;
            this.length = length;
        }

        @Override
        public String toString() {
            return "TextRef{" +
                    "bufType=" + bufType +
                    ", start=" + start +
                    ", length=" + length +
                    '}';
        }
    }

    static final class Fragment {
        TextChangeRange range;
        TextRef ref;
        boolean fixed;
        List<Fragment> priors;

        Fragment(TextChangeRange range, TextRef ref, boolean fixed, List<Fragment> priors) {
            this.range = Objects.requireNonNull(range);
            this.ref = Objects.requireNonNull(ref);
            this.fixed = fixed;
            this.priors = new ArrayList<>(
                    Objects.requireNonNull(priors)
            );
        }

        Fragment(TextChangeRange range, TextRef ref, boolean fixed) {
            this(range, ref, fixed, List.of());
        }

        public Fragment(Fragment other) {
            this.range = other.range;
            this.ref = other.ref;
            this.fixed = other.fixed;
            this.priors = other.priors;
        }

        public static Fragment from(Fragment other) {
            return new Fragment(other);
        }

        @Override
        public String toString() {
            return "Fragment{" +
                    "range=" + range +
                    ", ref='" + ref + '\'' +
                    ", fixed=" + fixed +
                    ", priors=" + priors +
                    '}';
        }
    }

    public FragmentedText(TextChangeRange range, String original) {
        this.bufferManager = new DefaultBufferManager(original);
        this.originalRange = range;
        this.fragments.add(new Fragment(range, new TextRef(BufferType.ORIGINAL, 0, original.length()), false));
    }

    public FragmentedText(String original) {
        this(Utils.computeTextChangeRange(original, 0, original.length() - 1), original);
    }

    public String getOriginalText() {
        return bufferManager.getOriginal();
    }

    public Optional<String> findFragmentByRange(TextChangeRange range) {
        //System.err.println("[findFragmentedText] range = " + range);
        for (Fragment f : fragments) {
            Optional<String> found = find(f, range);
            if (found.isPresent()) return found;
        }
        return Optional.empty();
    }

    private String getTextFromRef(TextRef ref) {
        return bufferManager.substring(ref.bufType, ref.start, ref.length);
    }

    private Optional<String> find(Fragment f, TextChangeRange range) {
        if (range.equals(f.range)) {
            return Optional.of(getTextFromRef(f.ref));
        }

        Deque<Fragment> deque = new ArrayDeque<>(f.priors);
        while (!deque.isEmpty()) {
            Fragment prior = deque.removeFirst();
            if (range.equals(prior.range)) {
                return Optional.of(getTextFromRef(prior.ref));
            }
            deque.addAll(prior.priors);
        }
        return Optional.empty();
    }

    public String projectOn(TextChangeRange textChangeRange, String string) {
        FragmentedText temp = new FragmentedText(textChangeRange, string);
        for (Fragment fragment : fragments) {
            if (textChangeRange.contains(fragment.range)) {
                temp.update(fragment.range, getTextFromRef(fragment.ref));
            }
        }
        return temp.toString();
    }

    public void appendTextFromEndParenthesis(String text) {
        String originalText = getOriginalText();
        int endParenIndex = originalText.lastIndexOf("}");
        System.err.println("[appendTextFromEndParenthesis] originalRange = " + originalRange);
        if (endParenIndex != -1) {
            var endRange = rangeFrom(endParenIndex, endParenIndex);
            update(endRange, text);
        }
    }

    public void update(TextChangeRange textChangeRange, String replace) {
        splitOverlappingFragment(textChangeRange);
        replace(textChangeRange, replace);
    }

    //split overlap range
    private void splitOverlappingFragment(TextChangeRange target) {
        for (int i = 0; i < fragments.size(); ++i) {
            Fragment f = fragments.get(i);

            if (target.equals(f.range)) {
                break;
            }

            if (!target.overlaps(f.range) || f.fixed) {
                continue;
            }

            int fragmentStart = toIndex(f.range.startLine(), f.range.startIndex());
            int fragmentEnd = toIndex(f.range.endLine(), f.range.inclusiveEndIndex());

            int rangeStart = toIndex(target.startLine(), target.startIndex());
            int rangeEnd = toIndex(target.endLine(), target.inclusiveEndIndex());

            int overlapStart = Math.max(rangeStart, fragmentStart);
            int overlapEnd = Math.min(rangeEnd, fragmentEnd);

            if (overlapStart > fragmentStart) {
                fragments.add(i++, new Fragment(rangeFrom(fragmentStart, overlapStart - 1), new TextRef(BufferType.ORIGINAL, fragmentStart, overlapStart - fragmentStart), false));
            }

            if (overlapEnd < fragmentEnd) {
                fragments.add(i + 1, new Fragment(rangeFrom(overlapEnd + 1, fragmentEnd), new TextRef(BufferType.ORIGINAL, overlapEnd + 1, fragmentEnd - overlapEnd), false));
            }

            Fragment prior = Fragment.from(f);
            f.range = rangeFrom(overlapStart, overlapEnd);
            f.ref = new TextRef(BufferType.ORIGINAL, overlapStart, overlapEnd - overlapStart + 1);
            f.fixed = false;
            f.priors = new ArrayList<>(List.of(prior));
        }
    }

    private TextChangeRange rangeFrom(int start, int end) {
        return Utils.getRangeFromStartIndexAndEndIndex(getOriginalText(), this.originalRange, start, end);
    }

    private int toIndex(int line, int col) {
        return Utils.getIndexFromLineColumn(getOriginalText(), this.originalRange, line, col);
    }

    private void replace(TextChangeRange range, String replacement) {
        boolean replaced = false;

        for (int i = 0; i < fragments.size(); ++i) {
            Fragment f = fragments.get(i);

            if (!range.contains(f.range)) continue;

            if (!replaced) {
                Fragment prior = Fragment.from(f);
                f.range = range;
                f.ref = new TextRef(BufferType.ADD, bufferManager.add(replacement), replacement.length());
                f.fixed = true;
                f.priors = new ArrayList<>(List.of(prior));
                replaced = true;
            } else {
                Fragment prev = fragments.get(i - 1);
                prev.priors.add(fragments.remove(i--));
            }
        }

        if (!replaced) {
            throw new IllegalStateException("No nodes were affected by the given range:" + range);
        }
    }

    private SourceMappingEntry buildSourceMapForPrior(SourceMappingEntry entry, Fragment prior, int skipOffset) {
        int currentLine = entry.getTransformedRange().startLine();
        int currentCol = entry.getTransformedRange().startIndex();
        //System.err.println("[buildSourceMapForPrior] entry = " + entry);
        //System.err.println("[buildSourceMapForPrior] source = " + entry.getSource());
        //System.err.println("[buildSourceMapForPrior] prior = " + prior);

        char[] charArray = entry.getSource().toCharArray();
        int length = Math.min(skipOffset, charArray.length);
        for (int offset = 0; offset < length; ++offset) {
            char c = charArray[offset];
            if (c == '\n') {
                currentLine++;
                currentCol = 0;
            } else {
                currentCol++;
            }
        }

        //calculate text range
        int startLine = currentLine;
        int startCol = currentCol;
        int endLine;
        int endCol;

        //System.err.println("[buildSourceMapForPrior] prior text = " + getTextFromRef(prior.ref));
        for (int i = 0; i < prior.ref.length; i++) {
            char c = bufferManager.charAt(prior.ref.bufType, prior.ref.start + i);
            if (c == '\n') {
                currentLine++;
                currentCol = 0;
            } else {
                currentCol++;
            }
        }

        //endLine = Math.min(currentLine, entry.getTransformedRange().endLine());
        //endCol = Math.min(currentCol, entry.getTransformedRange().inclusiveEndIndex());endLine = Math.min(currentLine, entry.getTransformedRange().endLine());
        endLine = currentLine;
        endCol = (currentCol > 0) ? currentCol - 1 : currentCol;

        TextChangeRange newRange = new TextChangeRange(startLine, startCol, endLine, endCol);
        return new SourceMappingEntry(getTextFromRef(prior.ref), prior.range, newRange);
    }

    public Set<SourceMappingEntry> buildSourceMap() {
        Set<SourceMappingEntry> mapping = new HashSet<>();

        int currentLine = originalRange.startLine();
        int currentCol = originalRange.startIndex();

        for (Fragment f : fragments) {
            int transformedStartLine = currentLine;
            int transformedStartCol = currentCol;

            for (int i = 0; i < f.ref.length; i++) {
                char c = bufferManager.charAt(f.ref.bufType, f.ref.start + i);
                if (c == '\n') {
                    currentLine++;
                    currentCol = 0;
                } else {
                    currentCol++;
                }
            }

            int transformedEndLine = currentLine;
            int transformedEndCol = (currentCol > 0) ? currentCol - 1 : currentCol;

            SourceMappingEntry entry = new SourceMappingEntry(
                    getTextFromRef(f.ref),
                    f.range,
                    new TextChangeRange(
                            transformedStartLine,
                            transformedStartCol,
                            transformedEndLine,
                            transformedEndCol
                    ));
            mapping.add(entry);

            int offset = 0;
            for (Fragment p : f.priors) {
                traversePrior(p, offset, entry, mapping);
                offset += p.ref.length;
            }
        }

        return mapping;
    }

    void traversePrior(
            Fragment fragment,
            int offsetInParent,
            SourceMappingEntry entry,
            Set<SourceMappingEntry> mapping
    ) {
        SourceMappingEntry priorEntry = buildSourceMapForPrior(entry, fragment, offsetInParent);
        mapping.add(priorEntry);

        int childOffset = 0;
        for (Fragment child : fragment.priors) {
            traversePrior(
                    child,
                    offsetInParent + childOffset,
                    entry,
                    mapping
            );
            childOffset += child.ref.length;
        }
    }

    public String debugString() {
        StringBuilder sb = new StringBuilder();
        for (Fragment f : fragments) {
            sb.append("[")
                    .append(f.range)
                    .append(f.fixed ? " FIXED" : "")
                    .append("]:\n")
                    .append(getTextFromRef(f.ref))
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        if (fragments.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Fragment f : fragments) {
            sb.append(getTextFromRef(f.ref));
        }
        return sb.toString();
    }
}
