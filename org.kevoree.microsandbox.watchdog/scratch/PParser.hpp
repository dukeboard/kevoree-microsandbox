#ifndef INC_PParser_hpp_
#define INC_PParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "P.g" -> "PParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "PParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

#line 1 "P.g"

#include "Main.hpp"
#include <string>
#include <iostream>

#line 18 "PParser.hpp"
class PParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public PParserTokenTypes
{
#line 12 "P.g"

public:
	void traceOut(ANTLR_USE_NAMESPACE(std)string rname) /*throws TokenStreamException*/  {
		ANTLR_USE_NAMESPACE(std)cout << "exit " << rname << "; LT(1)=" << LT(1) << ANTLR_USE_NAMESPACE(std)endl;
	}
	void traceIn(ANTLR_USE_NAMESPACE(std)string rname) /*throws TokenStreamException*/  {
		ANTLR_USE_NAMESPACE(std)cout << "enter " << rname << "; LT(1)=" << LT(1) << ANTLR_USE_NAMESPACE(std)endl;
	}
/*
	public void consume() throws IOException {
		try {
			System.out.println(LT(1));
		}
		catch (IOException ignore) {}
		super.consume();
	}
*/
#line 22 "PParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	PParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	PParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	PParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	PParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	PParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return PParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return PParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return PParser::tokenNames;
	}
	public: void startRule();
	public: void decl();
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
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
};

#endif /*INC_PParser_hpp_*/
