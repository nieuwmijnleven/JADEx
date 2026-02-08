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

package jplus.processor;

import jplus.analyzer.nullability.NullabilityChecker;
import jplus.base.SymbolTable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectProcessor {
    private final Path sourceDir;
    private final SymbolTable globalSymbolTable;
    private final Map<Path, JPlusProcessor> jPlusProcessorMap = new HashMap<>();

    public ProjectProcessor(Path sourceDir) {
        if (!sourceDir.toFile().isDirectory()) {
            throw new IllegalArgumentException("The argument must be the path of a source directory.");
        }
        this.sourceDir = sourceDir;
        this.globalSymbolTable = new SymbolTable(null);
    }

    public SymbolTable buildSymbolTable() throws IOException {
        Files.walk(sourceDir)
            .filter(path -> path.toString().endsWith(".jplus"))
            .forEach(path -> {
                JPlusProcessor jPlusProcessor = null;
                try {
                    jPlusProcessor = new JPlusProcessor(null, path, globalSymbolTable);
                    jPlusProcessor.process();
                    jPlusProcessor.analyzeSymbols();
                    jPlusProcessorMap.put(path, jPlusProcessor);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        return globalSymbolTable;
    }

    public List<NullabilityChecker.NullabilityIssue> checkNullability(Path sourcePath) {
        JPlusProcessor processor = jPlusProcessorMap.get(sourcePath);
        if (processor == null) {
            throw new IllegalArgumentException("There is no analyzed source file : " + sourcePath.toAbsolutePath());
        }
        return processor.checkNullability();
    }

}
