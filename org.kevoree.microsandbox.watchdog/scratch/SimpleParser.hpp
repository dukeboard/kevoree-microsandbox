#ifndef INC_SimpleParser_hpp_
#define INC_SimpleParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "parser1.g" -> "SimpleParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "SimpleParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

#line 5 "parser1.g"

/* empty header */

#line 16 "SimpleParser.hpp"
class SimpleParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public SimpleParserTokenTypes
{
#line 1 "parser1.g"
#line 20 "SimpleParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	SimpleParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return SimpleParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return SimpleParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return SimpleParser::tokenNames;
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

#endif /*INC_SimpleParser_hpp_*/
