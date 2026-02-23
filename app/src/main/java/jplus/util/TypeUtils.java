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

package jplus.util;

import jplus.base.TypeInfo;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import java.util.List;
import java.util.stream.Collectors;

public class TypeUtils {

    public static TypeInfo fromTypeMirror(TypeMirror typeMirror, Element originalElement) {
        if (typeMirror == null) {
            return new TypeInfo("unknown", false, TypeInfo.Type.Unknown);
        }

        switch (typeMirror.getKind()) {
            case DECLARED:
                DeclaredType declaredType = (DeclaredType) typeMirror;
                Element declaration = declaredType.asElement();

                boolean isClassDecl = originalElement != null && (originalElement.getKind().isClass() || originalElement.getKind().isInterface());

                if (isClassDecl) {

                    String className = ((TypeElement) declaredType.asElement()).getQualifiedName().toString();

                    List<String> typeParams = ((TypeElement) declaration)
                            .getTypeParameters()
                            .stream()
                            .map(TypeParameterElement::getSimpleName)
                            .map(Object::toString)
                            .toList();

                    boolean isGeneric = !((TypeElement)declaration).getTypeParameters().isEmpty();

                    return new TypeInfo(className, false, isGeneric, TypeInfo.Type.Class, null, typeParams, List.of());
                } else {
                    String referenceTypeName = ((TypeElement) declaredType.asElement()).getQualifiedName().toString();

                    //System.err.println("[fromTypeMirror] referenceTypeName = " + referenceTypeName);

                    boolean isNullable = typeMirror.getAnnotationMirrors().stream()
                            .map(annotationMirror -> annotationMirror.getAnnotationType().toString())
                            .anyMatch(annName -> annName.endsWith(".Nullable") /*|| annName.equals("org.jspecify.annotations.Nullable")*/);

                    //System.err.println("[fromTypeMirror] isNullable = " + isNullable);

                    List<TypeInfo> typeArgs = declaredType.getTypeArguments()
                            .stream()
                            .map(tm -> TypeUtils.fromTypeMirror(tm, originalElement))
                            .collect(Collectors.toList());

                    boolean isGeneric = !((TypeElement)declaration).getTypeParameters().isEmpty();

                    return new TypeInfo(referenceTypeName, isNullable, isGeneric, TypeInfo.Type.Reference, null, List.of(), typeArgs);
                }

            case TYPEVAR:
                TypeVariable typeVar = (TypeVariable) typeMirror;
                return new TypeInfo(typeVar.asElement().getSimpleName().toString(),
                        false, TypeInfo.Type.TypeParameter);

            case ARRAY:
                ArrayType arrayType = (ArrayType) typeMirror;
                TypeInfo component = fromTypeMirror(arrayType.getComponentType(), originalElement);
                return TypeInfo.builder().name(component.getName() + "[]")
                            .isNullable(false)
                            .type(TypeInfo.Type.Array)
                            .elementType(component)
                            .build();

            case BOOLEAN: case INT: case LONG: case FLOAT: case DOUBLE: case CHAR: case BYTE: case SHORT:
                return new TypeInfo(typeMirror.toString(), false, TypeInfo.Type.Primitive);

            case NULL:
                return new TypeInfo(
                        "null",
                        true,
                        TypeInfo.Type.Null
                );

            default:
                String typeName = (typeMirror instanceof DeclaredType dt) ? dt.asElement().toString() : typeMirror.toString();

                if ("void".equals(typeName)) {
                    return new TypeInfo(typeName, false, TypeInfo.Type.Void);
                }

                return new TypeInfo(typeName, false, TypeInfo.Type.Unknown);
        }
    }


    public static String getTypeName(TypeMirror type) {
        switch (type.getKind()) {
            case DECLARED:
                DeclaredType declared = (DeclaredType) type;
                String rawType = ((TypeElement) declared.asElement()).getQualifiedName().toString();
                
                List<? extends TypeMirror> typeArgs = declared.getTypeArguments();
                if (!typeArgs.isEmpty()) {
                    String args = typeArgs.stream()
                                          .map(TypeUtils::getTypeName)
                                          .collect(Collectors.joining(","));
                    return rawType + "<" + args + ">";
                } else {
                    return rawType;
                }

            case TYPEVAR:
                TypeVariable typeVar = (TypeVariable) type;
                return typeVar.asElement().getSimpleName().toString();

            case ARRAY:
                ArrayType arrayType = (ArrayType) type;
                return getTypeName(arrayType.getComponentType()) + "[]";

            default:
                return type.toString(); // primitive, wildcard 등
        }
    }

    public static List<String> getTypeParameters(TypeMirror type) {
        if (type.getKind() == TypeKind.DECLARED) {
            DeclaredType declared = (DeclaredType) type;
            return declared.getTypeArguments().stream()
                           .map(TypeUtils::getTypeName)
                           .collect(Collectors.toList());
        }
        return List.of();
    }
}
