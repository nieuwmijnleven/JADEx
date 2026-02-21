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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPlusSymbolTableTest {
    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(originalOut));
    }

    @Test
    void testSymbolResolver() throws Exception {
        Project project = new Project(Path.of("./src/test/files/SymbolResolver"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "User");
        processor.process();
//        System.err.println(processor.getParseTreeString());
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
//                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.getLine(), nullabilityIssue.getColumn(), nullabilityIssue.getMessage());
            });
        }

        assertEquals("Error: (line:16, column:8) The method(getStreet) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:16, column:15) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:27, column:44) The 2nd argument of the jplus.example.User constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:28, column:30) The 1st argument of the jplus.example.User constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:28, column:48) The 1st argument of the jplus.example.Address constructor is a non-nullable variable, but a null value is assigned to it.\n", outContent.toString());
    }

    @Test
    void testNullableAnnotation() throws Exception {
        Project project = new Project(Path.of("./src/test/files/NullableAnnotation"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "UserAnnotation");
        processor.process();
//        System.err.println(processor.getParseTreeString());
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
//                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.getLine(), nullabilityIssue.getColumn(), nullabilityIssue.getMessage());
            });
        }

        assertEquals("Error: (line:16, column:8) The method(getStreet) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:16, column:15) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:27, column:64) The 2nd argument of the jplus.example.UserAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:28, column:50) The 1st argument of the jplus.example.UserAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:28, column:78) The 1st argument of the jplus.example.AddressAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n", outContent.toString());
    }
    @Test
    void testNullableConstructorParamAnnotation() throws Exception {
        Project project = new Project(Path.of("./src/test/files/NullableAnnotation"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "UserConstructorParamAnnotation");
        processor.process();
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
        }

        assertEquals("Error: (line:13, column:8) this.address is a non-nullable variable. But nullable value is assigned to it. Change the type to AddressAnnotation? or add a null check.\n" +
                "Error: (line:18, column:8) The method(getStreet) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:18, column:15) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:30, column:82) The 1st argument of the jplus.example.UserConstructorParamAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:30, column:110) The 1st argument of the jplus.example.AddressAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n", outContent.toString());
    }

    @Test
    void testNullableMethodParamAnnotation() throws Exception {
        Project project = new Project(Path.of("./src/test/files/NullableAnnotation"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "UserMethodParamAnnotation");
        processor.process();
//        System.err.println(processor.getParseTreeString());
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
        }

        assertEquals("Error: (line:22, column:8) The method(getStreet) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:22, column:15) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:33, column:86) The 2nd argument of the jplus.example.UserMethodParamAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:34, column:72) The 1st argument of the jplus.example.UserMethodParamAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:34, column:100) The 1st argument of the jplus.example.AddressAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:37, column:28) The 1st argument of the jplus.example.UserMethodParamAnnotation.updateAddress() is a non-nullable variable, but a null value is assigned to it.\n", outContent.toString());
    }

    @Test
    void testTryCatchBlock() throws Exception {
        Project project = new Project(Path.of("./src/test/files/SymbolResolver"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "TryCatchBlock");
        processor.process();
//        System.err.println(processor.getParseTreeString());
        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
        }

        assertEquals("", outContent.toString());
    }


    @Test
    void testConvertJavaWithNullableAnnotation() throws Exception {
//        JPlusProcessor processor = new JPlusProcessor(Path.of("./src/test/files/NullableAnnotation/User.jadex"));
////        processor.addSrcDirPath(Path.of("./src/test/files/NullableAnnotation"));
//        processor.process();
////        System.err.println(processor.getParseTreeString());
//        String javaCode = processor.generateJavaCodeWithoutBoilerplate();
//        System.err.println(javaCode);
//
//        JavaProcessor javaProcessor = new JavaProcessor(javaCode);
//        javaProcessor.process();
//        javaProcessor.analyzeSymbols();


    }
}
