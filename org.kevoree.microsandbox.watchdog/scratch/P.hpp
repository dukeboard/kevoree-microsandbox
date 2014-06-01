#ifndef INC_P_hpp_
#define INC_P_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "column.g" -> "P.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "PTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class P : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public PTokenTypes
{
#line 1 "column.g"
#line 15 "P.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	P(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	P(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	P(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	P(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	P(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return P::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return P::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return P::tokenNames;
	}
	public: void start();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 7;
#else
	enum {
		NUM_TOKENS = 7
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_P_hpp_*/
