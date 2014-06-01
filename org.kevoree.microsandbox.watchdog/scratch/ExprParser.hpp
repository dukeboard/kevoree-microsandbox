#ifndef INC_ExprParser_hpp_
#define INC_ExprParser_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "expr.g" -> "ExprParser.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "ExprParserTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

class ExprParser : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public ExprParserTokenTypes
{
#line 1 "expr.g"
#line 15 "ExprParser.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	ExprParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return ExprParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return ExprParser::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return ExprParser::tokenNames;
	}
	public: void expr();
	public: void assignExpr();
	public: void addExpr();
	public: void multExpr();
	public: void postfixExpr();
	public: void parenArgs();
	public: void atom();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 17;
#else
	enum {
		NUM_TOKENS = 17
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

#endif /*INC_ExprParser_hpp_*/
