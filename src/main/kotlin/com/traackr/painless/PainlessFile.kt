package com.traackr.painless

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class PainlessFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PainlessLanguage) {
    override fun getFileType(): FileType = PainlessFileType.INSTANCE

    override fun toString(): String = "Painless File"
}
