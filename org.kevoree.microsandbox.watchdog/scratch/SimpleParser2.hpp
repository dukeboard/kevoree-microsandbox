#ifndef INC_SimpleParser2_hpp_
#define INC_SimpleParser2_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "parser2.g" -> "SimpleParser2.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "SimpleParser2TokenTypes.hpp"
#include <antlr/LLkParser.hpp>

#line 5 "parser2.g"

/* empty header */

#line 16 "SimpleParser2.hpp"
class SimpleParser2 : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public SimpleParser2TokenTypes
{
#line 1 "parser2.g"
#line 20 "SimpleParser2.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	SimpleParser2(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return SimpleParser2::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return SimpleParser2::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return SimpleParser2::tokenNames;
	}
	public: void simple();
	public: void x();
	public: void a();
	public: void b();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 9;
#else
	enum {
		NUM_TOKENS = 9
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
};

#endif /*INC_SimpleParser2_hpp_*/
