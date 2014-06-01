#ifndef INC_CalcTreeWalker_hpp_
#define INC_CalcTreeWalker_hpp_

#include <antlr/config.hpp>
#include "CalcParserTokenTypes.hpp"
/* $ANTLR 2.7.2: "calc.g" -> "CalcTreeWalker.hpp"$ */
#include <antlr/TreeParser.hpp>

class CalcTreeWalker : public ANTLR_USE_NAMESPACE(antlr)TreeParser, public CalcParserTokenTypes
{
#line 1 "calc.g"
#line 13 "CalcTreeWalker.hpp"
public:
	CalcTreeWalker();
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
	int getNumTokens() const
	{
		return CalcTreeWalker::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return CalcTreeWalker::tokenNames[type];
	}
	public: float  expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 12;
#else
	enum {
		NUM_TOKENS = 12
	};
#endif
	
};

#endif /*INC_CalcTreeWalker_hpp_*/
