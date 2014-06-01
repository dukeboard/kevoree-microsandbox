#ifndef INC_ExprParserTokenTypes_hpp_
#define INC_ExprParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "expr.g" -> "ExprParserTokenTypes.hpp"$ */
struct ExprParserTokenTypes {
	enum {
		EOF_ = 1,
		ASSIGN = 4,
		PLUS_MINUS = 5,
		MULT_DIV = 6,
		ID = 7,
		LPAREN = 8,
		COMMA = 9,
		RPAREN = 10,
		INT = 11,
		CHAR_LITERAL = 12,
		STRING_LITERAL = 13,
		WS_ = 14,
		ESC = 15,
		DIGIT = 16,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_ExprParserTokenTypes_hpp_*/
