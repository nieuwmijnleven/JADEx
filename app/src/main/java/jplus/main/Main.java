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

package jplus.main;

import jplus.base.Project;
import jplus.processor.JPlusProcessor;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.println("Usage: JADEx <java file>");
//            return;
//        }

        //Path filePath = Path.of(args[0]);
        //String className = Utils.getFileNameWithoutExtension(filePath);

        List<Path> srcDirList = List.of(Path.of("/home/user/OnTheGoDatabase/onthego.database/app/src/main/java"));
        //List<Path> srcDirList = List.of(Path.of("/home/user/JPlus/app/src/main/java"));

        List<Path> classPathList = List.of("/home/user/OnTheGoDatabase/onthego.database/app/build/classes/java/main", "/home/user/JPlus/intellij-plugin/build/idea-sandbox/IC-2025.1.4.1/plugins/intellij-plugin/lib/jspecify-1.0.0.jar").stream().map(Path::of).toList();
        //List<Path> classPathList = List.of("/home/user/JPlus/app/out/production/classes", "/home/user/.gradle/caches/modules-2/files-2.1/org.antlr/antlr4/4.12.0/860de2cce023b8175245fa8232b078513a0741d1/antlr4-4.12.0.jar", "/home/user/.gradle/caches/modules-2/files-2.1/org.antlr/antlr4-runtime/4.12.0/dd105cf6ac9f7417b3782c178f6dbd06bf75df57/antlr4-runtime-4.12.0.jar", "/home/user/.gradle/caches/modules-2/files-2.1/org.jspecify/jspecify/1.0.0/7425a601c1c7ec76645a78d22b8c6a627edee507/jspecify-1.0.0.jar", "/home/user/.gradle/caches/modules-2/files-2.1/org.abego.treelayout/org.abego.treelayout.core/1.0.3/457216e8e6578099ae63667bb1e4439235892028/org.abego.treelayout.core-1.0.3.jar").stream().map(Path::of).toList();


        //String className = "SimpleConsole";
        String className = "Database";

        //String className = "SQLParser";
        //String className = "SQLProcessor";
        //String className = "SQLScanner";

        //String className = "StandardTable";

        //String className = "StandardTablespaceManager";

        //String className = "BPlusTreeIndex";

        //String className = "NullabilityChecker";

        Project project = new Project(srcDirList, classPathList);
        //JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.console", className);
        JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.core.database", className);
        //JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.core.sqlprocessor", className);

        //JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.core.table", className);
        //JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.core.tablespace.manager", className);

        //JPlusProcessor processor = new JPlusProcessor(project, "onthego.database.core.index", className);

        //JPlusProcessor processor = new JPlusProcessor(project, "jplus.analyzer.nullability", className);

        processor.process();

//        JPlusProcessor processor = new JPlusProcessor(Path.of(args[0]));
//        processor.process();
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
            return;
        }

        String javaCode = processor.generateJavaCode();
        System.out.println(javaCode);
    }
}
