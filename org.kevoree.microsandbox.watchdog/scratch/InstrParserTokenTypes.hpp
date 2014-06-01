#ifndef INC_InstrParserTokenTypes_hpp_
#define INC_InstrParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "instr.g" -> "InstrParserTokenTypes.hpp"$ */
struct InstrParserTokenTypes {
	enum {
		EOF_ = 1,
		CALL = 4,
		LBRACE = 5,
		RBRACE = 6,
		TK_if = 7,
		TK_then = 8,
		TK_else = 9,
		ID = 10,
		ASSIGN = 11,
		SEMI = 12,
		PLUS = 13,
		STAR = 14,
		INT = 15,
		LPAREN = 16,
		RPAREN = 17,
		WS_ = 18,
		SL_COMMENT = 19,
		DIGIT = 20,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_InstrParserTokenTypes_hpp_*/
