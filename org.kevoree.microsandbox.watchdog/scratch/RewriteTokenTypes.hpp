#ifndef INC_RewriteTokenTypes_hpp_
#define INC_RewriteTokenTypes_hpp_

/* $ANTLR 2.7.2: "rewrite.g" -> "RewriteTokenTypes.hpp"$ */
struct RewriteTokenTypes {
	enum {
		EOF_ = 1,
		START = 4,
		ID = 5,
		LETTER = 6,
		EXPR = 7,
		INT = 8,
		WS_ = 9,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_RewriteTokenTypes_hpp_*/
