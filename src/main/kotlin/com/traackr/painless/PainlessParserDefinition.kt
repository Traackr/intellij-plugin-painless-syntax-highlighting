package com.traackr.painless

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class PainlessParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(PainlessLanguage)
    }

    override fun createLexer(project: Project?): Lexer = PainlessLexerAdapter()

    override fun createParser(project: Project?): PsiParser = PainlessParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = PainlessTokenTypes.COMMENTS

    override fun getStringLiteralElements(): TokenSet = PainlessTokenTypes.STRINGS

    override fun createElement(node: ASTNode?): PsiElement {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile = PainlessFile(viewProvider)
}
