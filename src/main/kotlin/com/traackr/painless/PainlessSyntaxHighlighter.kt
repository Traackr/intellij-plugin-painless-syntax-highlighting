package com.traackr.painless

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class PainlessSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        // Text attribute keys (private as they're only used internally)
        private val KEYWORD = createTextAttributesKey("PAINLESS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        private val PRIMITIVE_TYPE = createTextAttributesKey("PAINLESS_PRIMITIVE_TYPE", DefaultLanguageHighlighterColors.KEYWORD)
        private val DEF_TYPE = createTextAttributesKey("PAINLESS_DEF_TYPE", DefaultLanguageHighlighterColors.KEYWORD)
        private val NUMBER = createTextAttributesKey("PAINLESS_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        private val STRING = createTextAttributesKey("PAINLESS_STRING", DefaultLanguageHighlighterColors.STRING)
        private val BOOLEAN = createTextAttributesKey("PAINLESS_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD)
        private val NULL = createTextAttributesKey("PAINLESS_NULL", DefaultLanguageHighlighterColors.KEYWORD)
        private val REGEX = createTextAttributesKey("PAINLESS_REGEX", DefaultLanguageHighlighterColors.STRING)
        private val LINE_COMMENT = createTextAttributesKey("PAINLESS_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val BLOCK_COMMENT = createTextAttributesKey("PAINLESS_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        private val OPERATOR = createTextAttributesKey("PAINLESS_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        private val BRACES = createTextAttributesKey("PAINLESS_BRACES", DefaultLanguageHighlighterColors.BRACES)
        private val BRACKETS = createTextAttributesKey("PAINLESS_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        private val PARENTHESES = createTextAttributesKey("PAINLESS_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
        private val COMMA = createTextAttributesKey("PAINLESS_COMMA", DefaultLanguageHighlighterColors.COMMA)
        private val SEMICOLON = createTextAttributesKey("PAINLESS_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
        private val DOT = createTextAttributesKey("PAINLESS_DOT", DefaultLanguageHighlighterColors.DOT)
        private val IDENTIFIER = createTextAttributesKey("PAINLESS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        private val BAD_CHARACTER = createTextAttributesKey("PAINLESS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        // Arrays for each token type
        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val PRIMITIVE_TYPE_KEYS = arrayOf(PRIMITIVE_TYPE)
        private val DEF_TYPE_KEYS = arrayOf(DEF_TYPE)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val STRING_KEYS = arrayOf(STRING)
        private val BOOLEAN_KEYS = arrayOf(BOOLEAN)
        private val NULL_KEYS = arrayOf(NULL)
        private val REGEX_KEYS = arrayOf(REGEX)
        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val BLOCK_COMMENT_KEYS = arrayOf(BLOCK_COMMENT)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val BRACES_KEYS = arrayOf(BRACES)
        private val BRACKETS_KEYS = arrayOf(BRACKETS)
        private val PARENTHESES_KEYS = arrayOf(PARENTHESES)
        private val COMMA_KEYS = arrayOf(COMMA)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
        private val DOT_KEYS = arrayOf(DOT)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val BAD_CHARACTER_KEYS = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer(): Lexer = PainlessLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            PainlessTokenTypes.KEYWORD -> KEYWORD_KEYS
            PainlessTokenTypes.PRIMITIVE_TYPE -> PRIMITIVE_TYPE_KEYS
            PainlessTokenTypes.DEF_TYPE -> DEF_TYPE_KEYS
            PainlessTokenTypes.NUMBER -> NUMBER_KEYS
            PainlessTokenTypes.STRING -> STRING_KEYS
            PainlessTokenTypes.BOOLEAN -> BOOLEAN_KEYS
            PainlessTokenTypes.NULL_LITERAL -> NULL_KEYS
            PainlessTokenTypes.REGEX_LITERAL -> REGEX_KEYS
            PainlessTokenTypes.LINE_COMMENT -> LINE_COMMENT_KEYS
            PainlessTokenTypes.BLOCK_COMMENT -> BLOCK_COMMENT_KEYS
            PainlessTokenTypes.OPERATOR -> OPERATOR_KEYS
            PainlessTokenTypes.LBRACE, PainlessTokenTypes.RBRACE -> BRACES_KEYS
            PainlessTokenTypes.LBRACKET, PainlessTokenTypes.RBRACKET -> BRACKETS_KEYS
            PainlessTokenTypes.LPAREN, PainlessTokenTypes.RPAREN -> PARENTHESES_KEYS
            PainlessTokenTypes.COMMA -> COMMA_KEYS
            PainlessTokenTypes.SEMICOLON -> SEMICOLON_KEYS
            PainlessTokenTypes.DOT -> DOT_KEYS
            PainlessTokenTypes.IDENTIFIER -> IDENTIFIER_KEYS
            PainlessTokenTypes.DOLLAR -> IDENTIFIER_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHARACTER_KEYS
            else -> EMPTY_KEYS
        }
    }
}
