#ifndef INC_JavaTokenTypes_hpp_
#define INC_JavaTokenTypes_hpp_

/* $ANTLR 2.7.2: "javalex.g" -> "JavaTokenTypes.hpp"$ */
struct JavaTokenTypes {
	enum {
		EOF_ = 1,
		JAVADOC_OPEN = 4,
		JAVADOC_CLOSE = 5,
		INT = 6,
		ID = 7,
		SEMI = 8,
		WS_ = 9,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_JavaTokenTypes_hpp_*/
