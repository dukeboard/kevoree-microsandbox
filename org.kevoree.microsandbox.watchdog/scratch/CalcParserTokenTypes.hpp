#ifndef INC_CalcParserTokenTypes_hpp_
#define INC_CalcParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "calc.g" -> "CalcParserTokenTypes.hpp"$ */
struct CalcParserTokenTypes {
	enum {
		EOF_ = 1,
		PLUS = 4,
		SEMI = 5,
		STAR = 6,
		INT = 7,
		WS_ = 8,
		LPAREN = 9,
		RPAREN = 10,
		DIGIT = 11,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_CalcParserTokenTypes_hpp_*/
