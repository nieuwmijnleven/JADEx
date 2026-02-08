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
import jplus.util.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JPlusTest9 {
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
    void testDataFlowInitialState() throws Exception {
        checkNullability(
                "./src/test/files/NullabilityDataflowAnalysis",
                "jplus.example",
                "DataFlowInitialState",
                "Error: (line:6, column:8) Variable 'u' might not have been initialized.\n" +
                        "Error: (line:15, column:12) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n" +
                        "Error: (line:20, column:16) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n" +
                        "Error: (line:24, column:16) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n" +
                        "Error: (line:42, column:12) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n" +
                        "Error: (line:47, column:16) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n"
        );
    }

    @Test
    void testStaticFieldInitialization() throws Exception {
        checkNullability(
                "./src/test/files/NullabilityDataflowAnalysis",
                "jplus.example",
                "StaticFieldInitialization",
                ""
        );
    }

    @Test
    void testConstructors() throws Exception {
        checkNullability(
                "./src/test/files/NullableAnnotation",
                "jplus.example",
                "Constructors",
                ""
        );
    }

    @Test
    void testSwitch() throws Exception {
        checkNullability(
                "./src/test/files/NullableAnnotation",
                "jplus.example",
                "Switch",
                "Error: (line:17, column:8) Switch selector expression(selector) is nullable; this may cause a NullPointerException.\n" +
                        "Error: (line:18, column:46) The 1st argument of the jplus.example.Switch.println() is a non-nullable variable, but a null value is assigned to it.\n" +
                        "Error: (line:19, column:23) The 1st argument of the jplus.example.Switch.println() is a non-nullable variable, but a null value is assigned to it.\n" +
                        "Error: (line:24, column:46) The 1st argument of the jplus.example.Switch.println() is a non-nullable variable, but a null value is assigned to it.\n" +
                        "Error: (line:25, column:41) The 1st argument of the jplus.example.Switch.println() is a non-nullable variable, but a null value is assigned to it.\n" +
                        "Error: (line:42, column:16) The 1st argument of the jplus.example.Switch.println() is a non-nullable variable, but a null value is assigned to it.\n" +
                        "Error: (line:42, column:24) s is a nullable variable. But it directly accesses length(). Consider using null-safe operator(?.).\n" +
                        "Error: (line:49, column:8) result is a non-nullable variable. But nullable value is assigned to it. Change the type to String? or add a null check.\n"
        );
    }

    private void checkNullability(String srcPath, String packageName, String className, String expected) throws Exception {
        Project project = new Project(Path.of(srcPath));
        JPlusProcessor processor = new JPlusProcessor(project, packageName, className);

        processor.process();
        System.err.println("[ParseTreeString] = " + processor.getParseTreeString());

        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
                System.err.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
        }

        assertEquals(expected, outContent.toString());
    }

    private String getHashString(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
        byte[] hash = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
        String hashString = Base64.getEncoder().encodeToString(hash);
        return hashString;
    }
}
