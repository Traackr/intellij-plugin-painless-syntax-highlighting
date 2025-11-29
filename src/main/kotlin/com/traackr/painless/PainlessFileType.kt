package com.traackr.painless

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class PainlessFileType private constructor() : LanguageFileType(PainlessLanguage) {
    companion object {
        @JvmField
        val INSTANCE = PainlessFileType()
    }

    override fun getName(): String = "Painless"

    override fun getDescription(): String = "Elasticsearch Painless script"

    override fun getDefaultExtension(): String = "painless"

    override fun getIcon(): Icon = PainlessIcons.FILE
}
