#ifndef INC_DemoJavaParser_hpp_
#define INC_DemoJavaParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "javaparse.g" -> "DemoJavaParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "DemoJavaParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class DemoJavaParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public DemoJavaParserTokenTypes
{
#line 1 "javaparse.g"
#line 15 "DemoJavaParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	DemoJavaParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return DemoJavaParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return DemoJavaParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return DemoJavaParser::tokenNames;
	}
	public: void input();
	public: void javadoc();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 10;
#else
	enum {
		NUM_TOKENS = 10
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
};

#endif /*INC_DemoJavaParser_hpp_*/
