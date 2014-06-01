#ifndef INC_LangParserTokenTypes_hpp_
#define INC_LangParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "treewalk.g" -> "LangParserTokenTypes.hpp"$ */
struct LangParserTokenTypes {
	enum {
		EOF_ = 1,
		BLOCK = 4,
		LCURLY = 5,
		RCURLY = 6,
		ID = 7,
		ASSIGN = 8,
		SEMI = 9,
		TK_if = 10,
		LPAREN = 11,
		RPAREN = 12,
		TK_else = 13,
		TK_while = 14,
		INT = 15,
		EXPR = 16,
		WS_ = 17,
		DIGIT = 18,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_LangParserTokenTypes_hpp_*/
