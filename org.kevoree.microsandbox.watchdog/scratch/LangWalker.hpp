#ifndef INC_LangWalker_hpp_
#define INC_LangWalker_hpp_

#include <antlr/config.hpp>
#include "LangParserTokenTypes.hpp"
/* $ANTLR 2.7.2: "treewalk.g" -> "LangWalker.hpp"$ */
#include <antlr/TreeParser.hpp>

#line 1 "treewalk.g"

#include <iostream>

#line 14 "LangWalker.hpp"
class LangWalker : public ANTLR_USE_NAMESPACE(antlr)TreeParser, public LangParserTokenTypes
{
#line 1 "treewalk.g"
#line 18 "LangWalker.hpp"
public:
	LangWalker();
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
	int getNumTokens() const
	{
		return LangWalker::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return LangWalker::tokenNames[type];
	}
	public: void block(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 19;
#else
	enum {
		NUM_TOKENS = 19
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_LangWalker_hpp_*/
