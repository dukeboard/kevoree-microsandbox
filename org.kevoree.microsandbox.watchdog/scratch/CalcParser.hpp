#ifndef INC_CalcParser_hpp_
#define INC_CalcParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "calc.g" -> "CalcParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "CalcParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class CalcParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public CalcParserTokenTypes
{
#line 1 "calc.g"
#line 15 "CalcParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	CalcParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return CalcParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return CalcParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return CalcParser::tokenNames;
	}
	public: void expr();
	public: void mexpr();
	public: void atom();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 12;
#else
	enum {
		NUM_TOKENS = 12
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
	static const unsigned long _tokenSet_2_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_2;
};

#endif /*INC_CalcParser_hpp_*/
