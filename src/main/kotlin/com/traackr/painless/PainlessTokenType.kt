package com.traackr.painless

import com.intellij.psi.tree.IElementType

class PainlessTokenType(private val name: String) : IElementType(name, PainlessLanguage) {
    override fun toString(): String = "PainlessTokenType.$name"
}
