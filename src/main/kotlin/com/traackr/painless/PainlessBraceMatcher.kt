package com.traackr.painless

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class PainlessBraceMatcher : PairedBraceMatcher {
    companion object {
        private val PAIRS = arrayOf(
            BracePair(PainlessTokenTypes.LBRACE, PainlessTokenTypes.RBRACE, true),
            BracePair(PainlessTokenTypes.LBRACKET, PainlessTokenTypes.RBRACKET, false),
            BracePair(PainlessTokenTypes.LPAREN, PainlessTokenTypes.RPAREN, false)
        )
    }

    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}
