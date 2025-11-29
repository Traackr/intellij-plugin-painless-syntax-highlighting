package com.traackr.painless

import com.intellij.lang.Language

object PainlessLanguage : Language("Painless") {
    private fun readResolve(): Any = PainlessLanguage

    override fun getDisplayName(): String = "Painless"
}
