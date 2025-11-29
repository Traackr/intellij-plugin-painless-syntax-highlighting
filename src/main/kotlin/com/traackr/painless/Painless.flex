package com.traackr.painless;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.traackr.painless.PainlessTokenTypes.*;

%%

%{
  public _PainlessLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _PainlessLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

// Whitespace
EOL=\R
WHITE_SPACE=\s+

// Comments
LINE_COMMENT="//"[^\r\n]*
BLOCK_COMMENT="/"\*([^*]|\*+[^*/])*\*+"/"

// Keywords
KEYWORD_IF="if"
KEYWORD_ELSE="else"
KEYWORD_WHILE="while"
KEYWORD_DO="do"
KEYWORD_FOR="for"
KEYWORD_IN="in"
KEYWORD_CONTINUE="continue"
KEYWORD_BREAK="break"
KEYWORD_RETURN="return"
KEYWORD_NEW="new"
KEYWORD_TRY="try"
KEYWORD_CATCH="catch"
KEYWORD_THROW="throw"
KEYWORD_THIS="this"
KEYWORD_INSTANCEOF="instanceof"

// Primitive types
TYPE_BOOLEAN="boolean"
TYPE_BYTE="byte"
TYPE_SHORT="short"
TYPE_CHAR="char"
TYPE_INT="int"
TYPE_LONG="long"
TYPE_FLOAT="float"
TYPE_DOUBLE="double"
TYPE_DEF="def"
TYPE_VOID="void"

// Boolean literals
LITERAL_TRUE="true"
LITERAL_FALSE="false"
LITERAL_NULL="null"

// Numeric literals
OCTAL=0[0-7]+[lL]?
HEX=0[xX][0-9a-fA-F]+[lL]?
INTEGER=(0|[1-9][0-9]*)[lLfFdD]?
DECIMAL=(0|[1-9][0-9]*)(\.[0-9]+)?([eE][+\-]?[0-9]+)?[fFdD]?

// String literals
STRING_DOUBLE=\"([^\"\\]|\\.)*\"
STRING_SINGLE='([^'\\]|\\.)*'

// Regex literal - simplified pattern
REGEX=\/([^\/\n\\]|\\.)+\/[cilmsUux]*

// Identifiers
IDENTIFIER=[_a-zA-Z][_a-zA-Z0-9]*

%%

<YYINITIAL> {
  // Whitespace and comments
  {WHITE_SPACE}       { return WHITE_SPACE; }
  {LINE_COMMENT}      { return LINE_COMMENT; }
  {BLOCK_COMMENT}     { return BLOCK_COMMENT; }

  // Keywords
  {KEYWORD_IF}        { return KEYWORD; }
  {KEYWORD_ELSE}      { return KEYWORD; }
  {KEYWORD_WHILE}     { return KEYWORD; }
  {KEYWORD_DO}        { return KEYWORD; }
  {KEYWORD_FOR}       { return KEYWORD; }
  {KEYWORD_IN}        { return KEYWORD; }
  {KEYWORD_CONTINUE}  { return KEYWORD; }
  {KEYWORD_BREAK}     { return KEYWORD; }
  {KEYWORD_RETURN}    { return KEYWORD; }
  {KEYWORD_NEW}       { return KEYWORD; }
  {KEYWORD_TRY}       { return KEYWORD; }
  {KEYWORD_CATCH}     { return KEYWORD; }
  {KEYWORD_THROW}     { return KEYWORD; }
  {KEYWORD_THIS}      { return KEYWORD; }
  {KEYWORD_INSTANCEOF} { return KEYWORD; }

  // Primitive types
  {TYPE_BOOLEAN}      { return PRIMITIVE_TYPE; }
  {TYPE_BYTE}         { return PRIMITIVE_TYPE; }
  {TYPE_SHORT}        { return PRIMITIVE_TYPE; }
  {TYPE_CHAR}         { return PRIMITIVE_TYPE; }
  {TYPE_INT}          { return PRIMITIVE_TYPE; }
  {TYPE_LONG}         { return PRIMITIVE_TYPE; }
  {TYPE_FLOAT}        { return PRIMITIVE_TYPE; }
  {TYPE_DOUBLE}       { return PRIMITIVE_TYPE; }
  {TYPE_DEF}          { return DEF_TYPE; }
  {TYPE_VOID}         { return PRIMITIVE_TYPE; }

  // Boolean and null literals
  {LITERAL_TRUE}      { return BOOLEAN; }
  {LITERAL_FALSE}     { return BOOLEAN; }
  {LITERAL_NULL}      { return NULL_LITERAL; }

  // Operators - multi-character first (order matters!)
  ">>>="              { return OPERATOR; }
  ">>>"               { return OPERATOR; }
  "<<="               { return OPERATOR; }
  ">>="               { return OPERATOR; }
  "<<"                { return OPERATOR; }
  ">>"                { return OPERATOR; }
  "==="               { return OPERATOR; }
  "!=="               { return OPERATOR; }
  "==~"               { return OPERATOR; }
  "=~"                { return OPERATOR; }
  "?:"                { return OPERATOR; }
  "?."                { return OPERATOR; }
  "->"                { return OPERATOR; }
  "::"                { return OPERATOR; }
  "++"                { return OPERATOR; }
  "--"                { return OPERATOR; }
  "&&"                { return OPERATOR; }
  "||"                { return OPERATOR; }
  "<="                { return OPERATOR; }
  ">="                { return OPERATOR; }
  "=="                { return OPERATOR; }
  "!="                { return OPERATOR; }
  "+="                { return OPERATOR; }
  "-="                { return OPERATOR; }
  "*="                { return OPERATOR; }
  "/="                { return OPERATOR; }
  "%="                { return OPERATOR; }
  "&="                { return OPERATOR; }
  "|="                { return OPERATOR; }
  "^="                { return OPERATOR; }

  // Single-character operators
  "+"                 { return OPERATOR; }
  "-"                 { return OPERATOR; }
  "*"                 { return OPERATOR; }
  "/"                 { return OPERATOR; }
  "%"                 { return OPERATOR; }
  "<"                 { return OPERATOR; }
  ">"                 { return OPERATOR; }
  "="                 { return OPERATOR; }
  "!"                 { return OPERATOR; }
  "&"                 { return OPERATOR; }
  "|"                 { return OPERATOR; }
  "^"                 { return OPERATOR; }
  "~"                 { return OPERATOR; }
  "?"                 { return OPERATOR; }
  ":"                 { return OPERATOR; }

  // Delimiters
  "{"                 { return LBRACE; }
  "}"                 { return RBRACE; }
  "["                 { return LBRACKET; }
  "]"                 { return RBRACKET; }
  "("                 { return LPAREN; }
  ")"                 { return RPAREN; }
  "."                 { return DOT; }
  ","                 { return COMMA; }
  ";"                 { return SEMICOLON; }
  "$"                 { return DOLLAR; }

  // Literals - order matters for numeric matching
  {REGEX}             { return REGEX_LITERAL; }
  {HEX}               { return NUMBER; }
  {OCTAL}             { return NUMBER; }
  {DECIMAL}           { return NUMBER; }
  {INTEGER}           { return NUMBER; }
  {STRING_DOUBLE}     { return STRING; }
  {STRING_SINGLE}     { return STRING; }

  // Identifiers (must be last to not shadow keywords)
  {IDENTIFIER}        { return IDENTIFIER; }
}

// Fallback for any unmatched character
[^]                   { return BAD_CHARACTER; }
