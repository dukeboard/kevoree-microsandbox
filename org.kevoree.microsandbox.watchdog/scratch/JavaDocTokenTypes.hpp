#ifndef INC_JavaDocTokenTypes_hpp_
#define INC_JavaDocTokenTypes_hpp_

/* $ANTLR 2.7.2: "javadoclex.g" -> "JavaDocTokenTypes.hpp"$ */
struct JavaDocTokenTypes {
	enum {
		EOF_ = 1,
		JAVADOC_OPEN = 4,
		JAVADOC_CLOSE = 5,
		PARAM = 6,
		EXCEPTION = 7,
		ID = 8,
		STAR = 9,
		NEWLINE = 10,
		NULL_TREE_LOOKAHEAD = 3
	};
};
#endif /*INC_JavaDocTokenTypes_hpp_*/
