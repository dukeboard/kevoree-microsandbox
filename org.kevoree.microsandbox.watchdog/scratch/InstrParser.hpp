#ifndef INC_InstrParser_hpp_
#define INC_InstrParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "instr.g" -> "InstrParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "InstrParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

#line 1 "instr.g"

#include "antlr/CommonASTWithHiddenTokens.hpp"
#include "antlr/TokenStreamHiddenTokenFilter.hpp"
#include <iostream>

#line 18 "InstrParser.hpp"
class InstrParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public InstrParserTokenTypes
{
#line 1 "instr.g"
#line 22 "InstrParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	InstrParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return InstrParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return InstrParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return InstrParser::tokenNames;
	}
	public: void slist();
	public: void stat();
	public: void expr();
	public: void call();
	public: void mexpr();
	public: void atom();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 21;
#else
	enum {
		NUM_TOKENS = 21
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
	static const unsigned long _tokenSet_2_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_2;
	static const unsigned long _tokenSet_3_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_3;
	static const unsigned long _tokenSet_4_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_4;
	static const unsigned long _tokenSet_5_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_5;
};

#endif /*INC_InstrParser_hpp_*/
