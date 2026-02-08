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

import java.util.List;
import java.util.Objects;

public class MethodInvocationInfo {
    public final String receiver;
    public final TypeInfo typeInfo;
    public final String methodName;

    public final List<String> args;
    public final List<String> argTypes;
    public final List<String> paramTypes;
    public final String returnType;
    public final boolean hasVarArgs;
    private final List<Modifier> modifierList;

    public final String source;
    public final int startPos;
    public final int endPos;

    public MethodInvocationInfo(String receiver, TypeInfo typeInfo, String methodName, List<String> args, List<String> argTypes, List<String> paramTypes, String returnType, boolean hasVarArgs, List<Modifier> modifierList, String source, int startPos, int endPos) {
        this.receiver = receiver;
        this.typeInfo = typeInfo;
        this.methodName = methodName;
        this.args = args;
        this.argTypes = argTypes;
        this.paramTypes = paramTypes;
        this.returnType = returnType;
        this.hasVarArgs = hasVarArgs;
        this.modifierList = modifierList;
        this.source = source;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public boolean isStatic() {
        return modifierList.contains(Modifier.STATIC);
    }
    
    public static class Builder {
        private String receiver;
        private TypeInfo typeInfo;
        private String methodName;
        private List<String> args;
        private List<String> argTypes;
        private List<String> paramTypes;
        private String returnType;
        private boolean hasVarArgs;
        private List<Modifier> modifierList;
        private String source;
        private int startPos;
        private int endPos;
    
        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder typeInfo(TypeInfo typeInfo) {
            this.typeInfo = typeInfo;
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }
    
        public Builder args(List<String> args) {
            this.args = args;
            return this;
        }
    
        public Builder argTypes(List<String> argTypes) {
            this.argTypes = argTypes;
            return this;
        }

        public Builder paramTypes(List<String> paramTypes) {
            this.paramTypes = paramTypes;
            return this;
        }
    
        public Builder returnType(String returnType) {
            this.returnType = returnType;
            return this;
        }

        public Builder hasVarArgs(boolean hasVarArgs) {
            this.hasVarArgs = hasVarArgs;
            return this;
        }

        public Builder modifierList(List<Modifier> modifierList) {
            this.modifierList = modifierList;
            return this;
        }
    
        public Builder source(String source) {
            this.source = source;
            return this;
        }
    
        public Builder startPos(int startPos) {
            this.startPos = startPos;
            return this;
        }
    
        public Builder endPos(int endPos) {
            this.endPos = endPos;
            return this;
        }
    
        public MethodInvocationInfo build() {
            return new MethodInvocationInfo(receiver, typeInfo, methodName, args, argTypes, paramTypes, returnType, hasVarArgs, modifierList, source, startPos, endPos);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public String getInvocationInfoMessage() {
        if (Objects.equals(receiver, methodName)) {
            return receiver + " constructor";
        }
        return receiver + "." + methodName + "()";
    }

    @Override
    public String toString() {
        return "MethodInvocationInfo{" +
                "instanceName='" + receiver + '\'' +
                ", typeInfo='" + typeInfo + '\'' +
                ", methodName='" + methodName + '\'' +
                ", args=" + args +
                ", argTypes=" + argTypes +
                ", paramTypes=" + paramTypes +
                ", returnType='" + returnType + '\'' +
                ", hasVarArgs=" + hasVarArgs +
                ", modifierList=" + modifierList +
                ", source ='" + source + '\'' +
                ", startPos=" + startPos +
                ", endPos=" + endPos +
                '}';
    }
}