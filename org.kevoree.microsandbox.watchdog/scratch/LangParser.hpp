#ifndef INC_LangParser_hpp_
#define INC_LangParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "treewalk.g" -> "LangParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "LangParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

#line 1 "treewalk.g"

#include <iostream>

#line 16 "LangParser.hpp"
class LangParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public LangParserTokenTypes
{
#line 1 "treewalk.g"
#line 20 "LangParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	LangParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	LangParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	LangParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	LangParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	LangParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return LangParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return LangParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return LangParser::tokenNames;
	}
	public: void block();
	public: void statement();
	public: void expr();
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
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
	static const unsigned long _tokenSet_2_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_2;
};

#endif /*INC_LangParser_hpp_*/
