#ifndef INC_DemoJavaDocParserTokenTypes_hpp_
#define INC_DemoJavaDocParserTokenTypes_hpp_

/* $ANTLR 2.7.2: "javadocparse.g" -> "DemoJavaDocParserTokenTypes.hpp"$ */
struct DemoJavaDocParserTokenTypes {
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
#endif /*INC_DemoJavaDocParserTokenTypes_hpp_*/
