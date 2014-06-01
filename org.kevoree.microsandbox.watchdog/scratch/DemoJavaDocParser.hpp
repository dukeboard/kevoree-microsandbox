#ifndef INC_DemoJavaDocParser_hpp_
#define INC_DemoJavaDocParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "javadocparse.g" -> "DemoJavaDocParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "DemoJavaDocParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class DemoJavaDocParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public DemoJavaDocParserTokenTypes
{
#line 1 "javadocparse.g"
#line 15 "DemoJavaDocParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	DemoJavaDocParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return DemoJavaDocParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return DemoJavaDocParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return DemoJavaDocParser::tokenNames;
	}
	public: void content();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 11;
#else
	enum {
		NUM_TOKENS = 11
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_DemoJavaDocParser_hpp_*/
