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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TypeInfo {
    private final String name;
    private final boolean isNullable;
    private final boolean isGeneric;
    private final Type type;
    private final TypeInfo returnTypeInfo;
    private final List<String> typeParameters;
    private final List<TypeInfo> typeArguments;
    private final TypeInfo elementType;

    public enum Type {
        Class,
        Method,
        Reference,
        Null,
        Primitive,
        Constructor,
        Unknown,
        Void,
        Array,
        TypeParameter,
        TypeArgument
    }

    public TypeInfo(String name, boolean isNullable, boolean isGeneric, Type type, TypeInfo returnTypeInfo, List<String> typeParameters, List<TypeInfo> typeArguments, TypeInfo elementType) {
        this.name = name;
        this.isNullable = isNullable;
        this.isGeneric = isGeneric;
        this.type = type;
        this.returnTypeInfo = returnTypeInfo;
        this.typeParameters = typeParameters;
        this.typeArguments = typeArguments;
        this.elementType = elementType;
    }

    public TypeInfo(String name, boolean isNullable, boolean isGeneric, Type type, TypeInfo returnTypeInfo, List<String> typeParameters, List<TypeInfo> typeArguments) {
        this(name, isNullable, isGeneric, type, returnTypeInfo, typeParameters, typeArguments, null);
    }

    public TypeInfo(String name, boolean isNullable, Type type) {
        this(name, isNullable, false, type, null, List.of(), List.of(), null);
    }

    public TypeInfo(String name, boolean isNullable, Type type, TypeInfo returnTypeInfo) {
        this(name, isNullable, false, type, returnTypeInfo, List.of(), List.of(), null);
    }

    public TypeInfo(TypeInfo other) {
        this.name = other.name;
        this.isNullable = other.isNullable;
        this.isGeneric = other.isGeneric;
        this.type = other.type;
        this.returnTypeInfo = other.returnTypeInfo;
        this.typeParameters = other.typeParameters;
        this.typeArguments = other.typeArguments;
        this.elementType = other.elementType;
    }

    public static TypeInfo from(TypeInfo other) {
        return new TypeInfo(other);
    }

    public Builder toBuilder() {
        return TypeInfo.builder()
                .name(this.name)
                .isNullable(this.isNullable)
                .isGeneric(this.isGeneric)
                .type(this.type)
                .returnTypeInfo(this.returnTypeInfo)
                .typeParameters(this.typeParameters)
                .typeArguments(this.typeArguments)
                .elementType(this.elementType);
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return isGeneric() ? name + "<" + getTypeArguments().stream().map(TypeInfo::getFullname).collect(Collectors.joining(",")) + ">" : name;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public List<String> getTypeParameters() {
        return Collections.unmodifiableList(typeParameters);
    }

    public List<TypeInfo> getTypeArguments() {
        return Collections.unmodifiableList(typeArguments);
    }

    public TypeInfo getElementType() {
        return elementType;
    }

    public Type getType() {
        return type;
    }

    public TypeInfo getReturnTypeInfo() {
        return returnTypeInfo;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "name='" + name + '\'' +
                ", isNullable=" + isNullable +
                ", isGeneric=" + isGeneric +
                ", type=" + type +
                ", returnTypeInfo=" + returnTypeInfo +
                ", typeParameters=" + typeParameters +
                ", typeArguments=" + typeArguments +
                '}';
    }

    public static class Builder {
        private String name;
        private boolean isNullable;
        private boolean isGeneric;
        private Type type;
        private TypeInfo returnTypeInfo;
        private List<String> typeParameters = List.of();
        private List<TypeInfo> typeArguments = List.of();
        private TypeInfo elementType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder isNullable(boolean isNullable) {
            this.isNullable = isNullable;
            return this;
        }

        public Builder isGeneric(boolean isGeneric) {
            this.isGeneric = isGeneric;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder returnTypeInfo(TypeInfo returnTypeInfo) {
            this.returnTypeInfo = returnTypeInfo;
            return this;
        }

        public Builder typeParameters(List<String> typeParameters) {
            this.typeParameters = typeParameters;
            return this;
        }

        public Builder typeArguments(List<TypeInfo> typeArguments) {
            this.typeArguments = typeArguments;
            return this;
        }

        public Builder elementType(TypeInfo elementType) {
            this.elementType = elementType;
            return this;
        }

        public TypeInfo build() {
            return new TypeInfo(name, isNullable, isGeneric, type, returnTypeInfo, typeParameters, typeArguments, elementType);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
