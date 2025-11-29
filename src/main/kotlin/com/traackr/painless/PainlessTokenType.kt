package com.traackr.painless

import com.intellij.psi.tree.IElementType

class PainlessTokenType(debugName: String) : IElementType(debugName, PainlessLanguage) {
    override fun toString(): String = "PainlessTokenType.$debugName"
}
