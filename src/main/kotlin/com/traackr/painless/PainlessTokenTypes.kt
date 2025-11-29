package com.traackr.painless

import com.intellij.psi.tree.TokenSet

object PainlessTokenTypes {
    // Comments
    @JvmField val LINE_COMMENT = PainlessTokenType("LINE_COMMENT")
    @JvmField val BLOCK_COMMENT = PainlessTokenType("BLOCK_COMMENT")

    // Keywords
    @JvmField val KEYWORD = PainlessTokenType("KEYWORD")

    // Types
    @JvmField val PRIMITIVE_TYPE = PainlessTokenType("PRIMITIVE_TYPE")
    @JvmField val DEF_TYPE = PainlessTokenType("DEF_TYPE")

    // Literals
    @JvmField val NUMBER = PainlessTokenType("NUMBER")
    @JvmField val STRING = PainlessTokenType("STRING")
    @JvmField val BOOLEAN = PainlessTokenType("BOOLEAN")
    @JvmField val NULL_LITERAL = PainlessTokenType("NULL_LITERAL")
    @JvmField val REGEX_LITERAL = PainlessTokenType("REGEX_LITERAL")

    // Operators
    @JvmField val OPERATOR = PainlessTokenType("OPERATOR")

    // Delimiters
    @JvmField val LBRACE = PainlessTokenType("LBRACE")
    @JvmField val RBRACE = PainlessTokenType("RBRACE")
    @JvmField val LBRACKET = PainlessTokenType("LBRACKET")
    @JvmField val RBRACKET = PainlessTokenType("RBRACKET")
    @JvmField val LPAREN = PainlessTokenType("LPAREN")
    @JvmField val RPAREN = PainlessTokenType("RPAREN")
    @JvmField val DOT = PainlessTokenType("DOT")
    @JvmField val COMMA = PainlessTokenType("COMMA")
    @JvmField val SEMICOLON = PainlessTokenType("SEMICOLON")
    @JvmField val DOLLAR = PainlessTokenType("DOLLAR")

    // Identifiers
    @JvmField val IDENTIFIER = PainlessTokenType("IDENTIFIER")

    // Token sets for syntax highlighting
    @JvmField val COMMENTS = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT)
    @JvmField val STRINGS = TokenSet.create(STRING)
    @JvmField val KEYWORDS = TokenSet.create(KEYWORD)
    @JvmField val NUMBERS = TokenSet.create(NUMBER)
    @JvmField val BRACES = TokenSet.create(LBRACE, RBRACE)
    @JvmField val BRACKETS = TokenSet.create(LBRACKET, RBRACKET)
    @JvmField val PARENTHESES = TokenSet.create(LPAREN, RPAREN)
}
