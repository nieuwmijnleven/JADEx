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

package jplus.plugin.intellij.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.model.psi.PsiSymbolDeclaration;
import com.intellij.model.psi.PsiSymbolReference;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiInvalidElementAccessException;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;

public class PsiElementWrapper implements PsiElement {

    protected final PsiElement psiElement;
    protected final PsiFile psiFile;

    public PsiElementWrapper(PsiElement psiElement, PsiFile psiFile) {
        this.psiElement = psiElement;
        this.psiFile = psiFile;
    }

    public PsiElement getSourceElement() {
        return psiElement;
    }

    @Contract(pure = true)
    @Override
    public @NotNull Project getProject() throws PsiInvalidElementAccessException {
        return psiElement.getProject();
    }

    @Contract(pure = true)
    @Override
    public @NotNull Language getLanguage() {
        return psiElement.getLanguage();
    }

    @Contract(pure = true)
    @Override
    public PsiManager getManager() {
        return psiElement.getManager();
    }

    @Contract(pure = true)
    @Override
    public @NotNull PsiElement @NotNull [] getChildren() {
        return psiElement.getChildren();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getParent() {
        return psiElement.getParent();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getFirstChild() {
        return psiElement.getFirstChild();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getLastChild() {
        return psiElement.getLastChild();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getNextSibling() {
        return psiElement.getNextSibling();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getPrevSibling() {
        return psiElement.getPrevSibling();
    }

    @Contract(pure = true)
    @Override
    public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
        return (psiFile != null) ? psiFile : psiElement.getContainingFile();
    }

//    public PsiFile setContainingFile(PsiFile psiFlie) throws PsiInvalidElementAccessException {
//        return this.psiFile = psiFile;
//    }

    @Contract(pure = true)
    @Override
    public TextRange getTextRange() {
        return psiElement.getTextRange();
    }

    @Contract(pure = true)
    @Override
    public @NotNull TextRange getTextRangeInParent() {
        return psiElement.getTextRangeInParent();
    }

    @Contract(pure = true)
    @Override
    public int getStartOffsetInParent() {
        return psiElement.getStartOffsetInParent();
    }

    @Contract(pure = true)
    @Override
    public int getTextLength() {
        return psiElement.getTextLength();
    }

    @Contract(pure = true)
    @Override
    public @Nullable PsiElement findElementAt(int i) {
        return psiElement.findElementAt(i);
    }

    @Contract(pure = true)
    @Override
    public @Nullable PsiReference findReferenceAt(int i) {
        return psiElement.findReferenceAt(i);
    }

    @Contract(pure = true)
    @Override
    public int getTextOffset() {
        return psiElement.getTextOffset();
    }

    @Contract(pure = true)
    @Override
    public @NlsSafe String getText() {
        return psiElement.getText();
    }

    @Contract(pure = true)
    @Override
    public char @NotNull [] textToCharArray() {
        return psiElement.textToCharArray();
    }

    @Contract(pure = true)
    @Override
    public PsiElement getNavigationElement() {
        return new PsiElementWrapper(psiElement.getNavigationElement(), psiFile);
    }

    @Contract(pure = true)
    @Override
    public PsiElement getOriginalElement() {
        return psiElement.getOriginalElement();
    }

    @Contract(pure = true)
    @Override
    public boolean textMatches(@NotNull @NonNls CharSequence charSequence) {
        return psiElement.textMatches(charSequence);
    }

    @Contract(pure = true)
    @Override
    public boolean textMatches(@NotNull PsiElement psiElement) {
        return this.psiElement.textMatches(psiElement);
    }

    @Contract(pure = true)
    @Override
    public boolean textContains(char c) {
        return psiElement.textContains(c);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor psiElementVisitor) {
        psiElement.accept(psiElementVisitor);
    }

    @Override
    public void acceptChildren(@NotNull PsiElementVisitor psiElementVisitor) {
        psiElement.acceptChildren(psiElementVisitor);
    }

    @Override
    public PsiElement copy() {
        return psiElement.copy();
    }

    @Override
    public PsiElement add(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        return this.psiElement.add(psiElement);
    }

    @Override
    public PsiElement addBefore(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement1) throws IncorrectOperationException {
        return this.psiElement.addBefore(psiElement, psiElement1);
    }

    @Override
    public PsiElement addAfter(@NotNull PsiElement psiElement, @Nullable PsiElement psiElement1) throws IncorrectOperationException {
        return this.psiElement.addAfter(psiElement, psiElement1);
    }

    @Deprecated
    @Override
    public void checkAdd(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        this.psiElement.checkAdd(psiElement);
    }

    @Override
    public PsiElement addRange(PsiElement psiElement, PsiElement psiElement1) throws IncorrectOperationException {
        return this.psiElement.addRange(psiElement, psiElement1);
    }

    @Override
    public PsiElement addRangeBefore(@NotNull PsiElement psiElement, @NotNull PsiElement psiElement1, PsiElement psiElement2) throws IncorrectOperationException {
        return this.psiElement.addRangeBefore(psiElement, psiElement1, psiElement2);
    }

    @Override
    public PsiElement addRangeAfter(PsiElement psiElement, PsiElement psiElement1, PsiElement psiElement2) throws IncorrectOperationException {
        return this.psiElement.addRangeAfter(psiElement, psiElement1, psiElement2);
    }

    @Override
    public void delete() throws IncorrectOperationException {
        psiElement.delete();
    }

    @Deprecated
    @Override
    public void checkDelete() throws IncorrectOperationException {
        psiElement.checkDelete();
    }

    @Override
    public void deleteChildRange(PsiElement psiElement, PsiElement psiElement1) throws IncorrectOperationException {
        this.psiElement.deleteChildRange(psiElement, psiElement1);
    }

    @Override
    public PsiElement replace(@NotNull PsiElement psiElement) throws IncorrectOperationException {
        return this.psiElement.replace(psiElement);
    }

    @Contract(pure = true)
    @Override
    public boolean isValid() {
        return psiElement.isValid();
    }

    @Contract(pure = true)
    @Override
    public boolean isWritable() {
        return psiElement.isWritable();
    }

    @ApiStatus.Experimental
    @ApiStatus.OverrideOnly
    @Override
    public @NotNull Collection<? extends @NotNull PsiSymbolDeclaration> getOwnDeclarations() {
        return Collections.emptyList();
    }

    @ApiStatus.Experimental
    @ApiStatus.OverrideOnly
    @Override
    public @NotNull Collection<? extends @NotNull PsiSymbolReference> getOwnReferences() {
        return Collections.emptyList();
    }

    @Contract(pure = true)
    @Override
    public @Nullable PsiReference getReference() {
        return psiElement.getReference();
    }

    @Contract(pure = true)
    @Override
    public PsiReference @NotNull [] getReferences() {
        return psiElement.getReferences();
    }

    @Contract(pure = true)
    @Override
    public <T> @Nullable T getCopyableUserData(@NotNull Key<T> key) {
        return psiElement.getCopyableUserData(key);
    }

    @Override
    public <T> void putCopyableUserData(@NotNull Key<T> key, @Nullable T t) {
        psiElement.putCopyableUserData(key, t);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor psiScopeProcessor, @NotNull ResolveState resolveState, @Nullable PsiElement psiElement, @NotNull PsiElement psiElement1) {
        return this.psiElement.processDeclarations(psiScopeProcessor, resolveState, psiElement, psiElement1);
    }

    @Contract(pure = true)
    @Override
    public @Nullable PsiElement getContext() {
        return psiElement.getContext();
    }

    @Contract(pure = true)
    @Override
    public boolean isPhysical() {
        return psiElement.isPhysical();
    }

    @Contract(pure = true)
    @Override
    public @NotNull GlobalSearchScope getResolveScope() {
        return psiElement.getResolveScope();
    }

    @Contract(pure = true)
    @Override
    public @NotNull SearchScope getUseScope() {
        return psiElement.getUseScope();
    }

    @Contract(pure = true)
    @Override
    public ASTNode getNode() {
        return psiElement.getNode();
    }

    @Override
    @Contract(pure = true)
    public @NonNls String toString() {
        return psiElement.toString();
    }

    @Contract(pure = true)
    @Override
    public boolean isEquivalentTo(PsiElement psiElement) {
        return this.psiElement.isEquivalentTo(psiElement);
    }

    @Override
    public <T> @Nullable T getUserData(@NotNull Key<T> key) {
        return psiElement.getUserData(key);
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T t) {
        psiElement.putUserData(key, t);
    }

    @Override
    public Icon getIcon(int i) {
        return psiElement.getIcon(i);
    }
}
