#ifndef INC_PParserTokenTypes_hpp_
#define INC_PParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "P.g" -> "PParserTokenTypes.hpp"$ */
struct PParserTokenTypes {
	enum {
		EOF_ = 1,
		INT = 4,
		ID = 5,
		COMMA = 6,
		SEMI = 7,
		INCLUDE = 8,
		STRING = 9,
		WS_ = 10,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_PParserTokenTypes_hpp_*/
