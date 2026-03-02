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

package jplus.base;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeInfoTest {

    @Test
    void from() {
        TypeInfo original = new TypeInfo("T", true, TypeInfo.Type.TypeParameter);
        TypeInfo copy = TypeInfo.from(original);

        assertNotNull(copy);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.isNullable(), copy.isNullable());
        assertEquals(original.getType(), copy.getType());
    }

    @Test
    void toBuilder() {
        TypeInfo original = new TypeInfo("List", false, TypeInfo.Type.Class);
        TypeInfo modified = original.toBuilder()
                .isGeneric(true)
                .typeArguments(List.of(new TypeInfo("String", false, TypeInfo.Type.Class)))
                .build();

        assertEquals("List<String>", modified.getFullname());
        assertTrue(modified.isGeneric());
        assertEquals(original.getName(), modified.getName());
    }

    @Test
    void getName() {
        TypeInfo type = new TypeInfo("Integer", false, TypeInfo.Type.Class);
        assertEquals("Integer", type.getName());
    }

    @Test
    void getFullname() {
        TypeInfo stringType = new TypeInfo("String", false, TypeInfo.Type.Class);
        TypeInfo listType = TypeInfo.builder()
                .name("List")
                .isGeneric(true)
                .type(TypeInfo.Type.Class)
                .typeArguments(List.of(stringType))
                .build();

        assertEquals("List<String>", listType.getFullname());

        // Non-generic type
        TypeInfo simpleType = new TypeInfo("int", false, TypeInfo.Type.Primitive);
        assertEquals("int", simpleType.getFullname());
    }

    @Test
    void isNullable() {
        TypeInfo nullable = new TypeInfo("String", true, TypeInfo.Type.Class);
        TypeInfo nonNullable = new TypeInfo("int", false, TypeInfo.Type.Primitive);

        assertTrue(nullable.isNullable());
        assertFalse(nonNullable.isNullable());
    }

    @Test
    void isGeneric() {
        TypeInfo generic = TypeInfo.builder()
                .name("List")
                .isGeneric(true)
                .type(TypeInfo.Type.Class)
                .build();

        TypeInfo nonGeneric = new TypeInfo("String", false, TypeInfo.Type.Class);

        assertTrue(generic.isGeneric());
        assertFalse(nonGeneric.isGeneric());
    }

    @Test
    void getTypeParameters() {
        List<String> params = List.of("T", "K");
        TypeInfo type = TypeInfo.builder()
                .name("Map")
                .typeParameters(params)
                .type(TypeInfo.Type.Class)
                .build();

        assertEquals(params, type.getTypeParameters());
    }

    @Test
    void getTypeArguments() {
        TypeInfo stringType = new TypeInfo("String", false, TypeInfo.Type.Class);
        TypeInfo intType = new TypeInfo("Integer", false, TypeInfo.Type.Class);

        TypeInfo mapType = TypeInfo.builder()
                .name("Map")
                .isGeneric(true)
                .type(TypeInfo.Type.Class)
                .typeArguments(List.of(stringType, intType))
                .build();

        assertEquals(2, mapType.getTypeArguments().size());
        assertEquals("String", mapType.getTypeArguments().get(0).getName());
        assertEquals("Integer", mapType.getTypeArguments().get(1).getName());
    }

    @Test
    void getElementType() {
        TypeInfo element = new TypeInfo("String", false, TypeInfo.Type.Class);
        TypeInfo array = TypeInfo.builder()
                .name("String[]")
                .type(TypeInfo.Type.Array)
                .elementType(element)
                .build();

        assertEquals(element, array.getElementType());
        assertEquals(TypeInfo.Type.Array, array.getType());
    }

    @Test
    void getType() {
        TypeInfo type = new TypeInfo("int", false, TypeInfo.Type.Primitive);
        assertEquals(TypeInfo.Type.Primitive, type.getType());
    }

    @Test
    void getReturnTypeInfo() {
        TypeInfo returnType = new TypeInfo("int", false, TypeInfo.Type.Primitive);
        TypeInfo method = TypeInfo.builder()
                .name("compute")
                .type(TypeInfo.Type.Method)
                .returnTypeInfo(returnType)
                .build();

        assertEquals(returnType, method.getReturnTypeInfo());
    }

    @Test
    void testToString() {
        TypeInfo type = TypeInfo.builder()
                .name("List")
                .isGeneric(true)
                .type(TypeInfo.Type.Class)
                .typeArguments(List.of(new TypeInfo("String", false, TypeInfo.Type.Class)))
                .build();

        String str = type.toString();
        assertTrue(str.contains("List"));
        assertTrue(str.contains("isGeneric=true"));
        assertTrue(str.contains("String"));
    }

    @Test
    void builder() {
        TypeInfo type = TypeInfo.builder()
                .name("Custom")
                .isNullable(true)
                .isGeneric(true)
                .type(TypeInfo.Type.Class)
                .typeParameters(List.of("T"))
                .typeArguments(List.of(new TypeInfo("String", false, TypeInfo.Type.Class)))
                .elementType(new TypeInfo("String", false, TypeInfo.Type.Class))
                .build();

        assertEquals("Custom", type.getName());
        assertTrue(type.isNullable());
        assertTrue(type.isGeneric());
        assertEquals(TypeInfo.Type.Class, type.getType());
        assertEquals(List.of("T"), type.getTypeParameters());
        assertEquals(1, type.getTypeArguments().size());
        assertEquals("String", type.getTypeArguments().get(0).getName());
        assertEquals("String", type.getElementType().getName());
    }
}