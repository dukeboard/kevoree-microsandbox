/* $ANTLR 2.7.2: "data.g" -> "DataParser.cpp"$ */
#include "DataParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 5 "data.g"

#include <iostream>

#line 11 "DataParser.cpp"
DataParser::DataParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

DataParser::DataParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

DataParser::DataParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

DataParser::DataParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

DataParser::DataParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void DataParser::file() {
	ANTLR_USE_NAMESPACE(antlr)RefToken  sh = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefToken  st = ANTLR_USE_NAMESPACE(antlr)nullToken;
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20288=0;
		for (;;) {
			switch ( LA(1)) {
			case SHORT:
			{
				sh = LT(1);
				match(SHORT);
#line 11 "data.g"
				std::cout << sh->getText() << std::endl;
#line 52 "DataParser.cpp"
				break;
			}
			case STRING:
			{
				st = LT(1);
				match(STRING);
#line 12 "data.g"
				std::cout << "\"" << st->getText() << "\"" << std::endl;
#line 61 "DataParser.cpp"
				break;
			}
			default:
			{
				if ( _cnt20288>=1 ) { goto _loop20288; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			}
			_cnt20288++;
		}
		_loop20288:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void DataParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* DataParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"SHORT",
	"STRING",
	0
};

const unsigned long DataParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet DataParser::_tokenSet_0(_tokenSet_0_data_,4);


