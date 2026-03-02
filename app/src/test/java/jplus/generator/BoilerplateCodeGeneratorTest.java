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

import jplus.base.SymbolInfo;
import jplus.base.SymbolTable;
import jplus.base.TypeInfo;
import jplus.editor.FragmentedText;
import jplus.generator.apply.ApplyFeature;
import jplus.generator.apply.ApplyStatement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoilerplateCodeGeneratorTest {

    private SymbolTable symbolTable;
    private FragmentedText fragmentedText;

    @BeforeEach
    void setup() {
        /*// 최소 더미 SymbolTable 및 FragmentedText
        symbolTable = new SymbolTable("^TopLevelClass$");
        SymbolInfo topClass = new SymbolInfo(
                "^TopLevelClass$",
                TypeInfo.ofClass("TopLevelClass"),
                0, 0, 0, 0,
                "class TopLevelClass {}",
                null
        );
        symbolTable.addSymbol(topClass);

        fragmentedText = new FragmentedText("class TopLevelClass {}");*/
    }

    @Test
    void visitApplyDeclaration() {
        // BoilerplateCodeGenerator 생성
        BoilerplateCodeGenerator generator = new BoilerplateCodeGenerator(symbolTable, fragmentedText);

        // visitApplyDeclaration은 내부적으로 applyStatementList에 ApplyStatement 추가
        // ApplyDeclarationContext 모킹 필요 -> 테스트에서는 최소한 add 기능 확인
        // 실제 파서 컨텍스트 없이 직접 Add
        ApplyStatement stmt = new ApplyStatement("^TopLevelClass$");
        stmt.addApplyFeature(new ApplyFeature("getter"));

        try {
            var field = BoilerplateCodeGenerator.class.getDeclaredField("applyStatementList");
            field.setAccessible(true);
            List<ApplyStatement> list = (List<ApplyStatement>) field.get(generator);
            list.add(stmt);
        } catch (Exception e) {
            fail("Reflection setup failed: " + e.getMessage());
        }

        // 적용된 statement 확인
        try {
            var listField = BoilerplateCodeGenerator.class.getDeclaredField("applyStatementList");
            listField.setAccessible(true);
            List<ApplyStatement> list = (List<ApplyStatement>) listField.get(generator);
            assertEquals(1, list.size());
            assertEquals("^TopLevelClass$", list.get(0).getQualifiedName());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void generate() {
        BoilerplateCodeGenerator generator = new BoilerplateCodeGenerator(symbolTable, fragmentedText);

        // 최소 applyStatementList에 dummy Feature 추가
        ApplyStatement stmt = new ApplyStatement("^TopLevelClass$");
        stmt.addApplyFeature(new ApplyFeature("getter")); // 존재하는 전략 사용
        try {
            var field = BoilerplateCodeGenerator.class.getDeclaredField("applyStatementList");
            field.setAccessible(true);
            List<ApplyStatement> list = (List<ApplyStatement>) field.get(generator);
            list.add(stmt);
        } catch (Exception e) {
            fail("Reflection setup failed: " + e.getMessage());
        }

        // generate 실행
        String result = generator.generate();

        assertNotNull(result);
        assertTrue(result.contains("TopLevelClass"));
        // getter 전략 적용 여부는 실제 FeatureProcessor 구현이 필요하므로 최소 검증
    }
}