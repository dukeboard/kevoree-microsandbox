#ifndef INC_DataParser_hpp_
#define INC_DataParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "data.g" -> "DataParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "DataParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class DataParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public DataParserTokenTypes
{
#line 1 "data.g"
#line 15 "DataParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	DataParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	DataParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	DataParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	DataParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	DataParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return DataParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return DataParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return DataParser::tokenNames;
	}
	public: void file();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 6;
#else
	enum {
		NUM_TOKENS = 6
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_DataParser_hpp_*/
