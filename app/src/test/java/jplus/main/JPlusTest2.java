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

class JPlusTest2 {
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
    void testApplySetter() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplySetter.jadex", "AI9XnBZYPAS+g3pgFUl2gyU4Hy4=");
    }

    @Test
    void testApplyGetter() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyGetter.jadex", "ZM2zRHO13D3dd1ZDx5SrXFYmAAw=");
    }

    @Test
    void testApplyGenerics() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyGenerics.jadex", "+/4v6RX8SbSYHBql2aQy87lncoo=");
    }



    @Test
    void testApplyHashCode() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyHashCode.jadex", "yimHzYkGIf5flOxTIOwshpaJKRw=");
    }

    @Test
    void testApplyEquals() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyEquals.jadex", "CHfFbjOu6qiOSCz+80W22I1BQKU=");
    }

    @Test
    void testApplyEquality() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyEquality.jadex", "1KK08WyBnAezAYfFUsiqU7P+KQ4=");
    }

    @Test
    void testApplyToBuilder() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyToBuilder.jadex", "LKuG/V0en6trUBQ+0Nt7tJv0HgI=");
    }

    @Test
    void testApplyData() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyData.jadex", "ZLBhmlf2Uyi0wJwyLrUYK5VzoXg=");
    }

    @Test
    void testNullableMethodParamAnnotation() throws Exception {
        Project project = new Project(Path.of("./src/test/files/NullableAnnotation"));
        JPlusProcessor processor = new JPlusProcessor(project, "jplus.example", "UserMethodParamAnnotationForCodeGenerator");
        processor.process();
        System.err.println("[ParseTreeString] " + processor.getParseTreeString());
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
                "Error: (line:26, column:8) The method(getStreet_ExpressionName) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:26, column:15) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:30, column:64) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:38, column:8) The method(getStreet_ExpressionName_AddressStreetNullsatey) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:42, column:8) The method(getStreet_FieldAccess) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:42, column:34) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:46, column:8) The method(getStreet_FieldAccess_AddressNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:46, column:35) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:50, column:8) The method(getStreet_FieldAccess_StreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:54, column:8) The method(getStreet_FieldAccess_AddressStreetNullsatey) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:58, column:8) The method(getStreet_MethodInvocation_Primary_AddressNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:58, column:35) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:62, column:8) The method(getStreet_MethodInvocation_Primary_StreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:66, column:8) The method(getStreet_MethodInvocation_Primary_AddressStreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:70, column:8) The method(getStreet_MethodInvocation_ExpressionName) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:70, column:15) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:74, column:8) The method(getStreet_MethodInvocation_ExpressionName_AddressNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:74, column:15) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:78, column:8) The method(getStreet_MethodInvocation_ExpressionName_StreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:82, column:8) The method(getStreet_MethodInvocation_ExpressionName_AddressStreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:86, column:8) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:90, column:8) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:102, column:8) The method(getStreet_TypeNameFieldAccess) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:102, column:76) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:106, column:8) The method(getStreet_TypeNameFieldAccess_AddressNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:106, column:91) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:110, column:8) The method(getStreet_TypeNameFieldAccess_StreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:114, column:8) The method(getStreet_TypeNameFieldAccess_AddressStreetNullsatey) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:118, column:8) The method(getStreet_MethodInvocation_TypeNamePrimary) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:118, column:90) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:122, column:8) The method(getStreet_MethodInvocation_TypeNamePrimary_AddressNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:122, column:35) street is a nullable variable. But it directly accesses name(). Consider using null-safe operator(?.).\n" +
                "Error: (line:126, column:8) The method(getStreet_MethodInvocation_TypeNamePrimary_StreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:130, column:8) The method(getStreet_MethodInvocation_TypeNamePrimary_AddressStreetNullsafety) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:138, column:8) The method(getStreet_FieldAccess_WithParenthesis) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:138, column:35) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:142, column:8) The method(getStreet_FieldAccess_WithParenthesis_UtilStreet) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:142, column:36) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:146, column:75) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:150, column:8) The method(createUserWithChaining) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:150, column:75) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:150, column:95) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:154, column:89) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:158, column:8) The method(createUserWithQualifiedClassNameAndChaining) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:158, column:89) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:158, column:109) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:163, column:281) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:164, column:8) The method(createUserArrayWithChaining) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:164, column:40) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:168, column:8) The method(createUserArrayWithInitializer) is declared to return a non-null value, but this return statement may return null.\n" +
                "Error: (line:168, column:258) street is a nullable variable. But it directly accesses name. Consider using null-safe operator(?.).\n" +
                "Error: (line:202, column:118) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:203, column:104) The 1st argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:203, column:132) The 1st argument of the jplus.example.AddressAnnotation constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:206, column:28) The 1st argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator.updateAddress() is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:208, column:68) The 2nd argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator constructor is a non-nullable variable, but a null value is assigned to it.\n" +
                "Error: (line:208, column:88) The 1st argument of the jplus.example.UserMethodParamAnnotationForCodeGenerator.updateAddress() is a non-nullable variable, but a null value is assigned to it.\n", outContent.toString());
    }

    @Test
    void testApplyConstructorWithNo() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyConstructorWithNo.jadex", "X5+8jG/MIhwipBw37T/M5PpwsX0=");
    }

    @Test
    void testApplyConstructorWithAll() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyConstructorWithAll.jadex", "zFeIuh0X6S2B5dSN7Kz2VLwNsnA=");
    }

    @Test
    void testApplyConstructorWithRequired() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyConstructorWithRequired.jadex", "NUU1aora2gCnyF4Y9mA569SkFLs=");
    }

    @Test
    void testApplyToString() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyToString.jadex", "InZTbRqN4OgYBBjhv8X8h1mzXOY=");
    }

    @Test
    void testApplyBuilder() throws Exception {
        checkGeneratedCode("./src/test/samples/generics/ApplyBuilder.jadex", "Yrti0j4cuyyLTEQPBk7mTgaxoSA=");
    }

    private void checkGeneratedCode(String fileName, String expected) throws Exception {
        Path filePath = Path.of(fileName);
        Path parentDirectory = filePath.getParent();
        String className = Utils.getFileNameWithoutExtension(filePath);
        System.err.println("[checkGeneratedCode] parentDirectory = " + parentDirectory.toString());
        System.err.println("[checkGeneratedCode] className = " + className);

        Project project = new Project(parentDirectory);
        JPlusProcessor processor = new JPlusProcessor(project, "", className);
        processor.process();

        //String parseTreeString = processor.getParseTreeString();
        //String hashString = getHashString(parseTreeString);
        //System.err.println("hashString = " + hashString);

        processor.analyzeSymbols();

        var issues = processor.checkNullability();
        if (!issues.isEmpty()) {
            issues.forEach(nullabilityIssue -> {
                System.out.printf("Error: (line:%d, column:%d) %s\n", nullabilityIssue.line(), nullabilityIssue.column(), nullabilityIssue.message());
            });
            fail();
        }

        String generatedJavaCode = processor.generateJavaCode();
        System.err.println("[BoilerplateCodeGeneration] = " + generatedJavaCode);

        /*processor = new JPlusProcessor(generatedJavaCode);
        processor.process();

        String parseTreeString = processor.getParseTreeString();
        String hashString = getHashString(parseTreeString);*/

        String hashString = getHashString(generatedJavaCode);

        assertEquals(expected, hashString);
    }

    private String getHashString(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
        byte[] hash = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
        String hashString = Base64.getEncoder().encodeToString(hash);
        return hashString;
    }
}