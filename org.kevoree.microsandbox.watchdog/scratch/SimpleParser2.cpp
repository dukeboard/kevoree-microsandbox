/* $ANTLR 2.7.2: "parser2.g" -> "SimpleParser2.cpp"$ */
#include "SimpleParser2.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "parser2.g"
#line 8 "SimpleParser2.cpp"
SimpleParser2::SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

SimpleParser2::SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,3)
{
}

SimpleParser2::SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

SimpleParser2::SimpleParser2(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,3)
{
}

SimpleParser2::SimpleParser2(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,3)
{
}

void SimpleParser2::simple() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt21504=0;
		for (;;) {
			if ((LA(1) == C || LA(1) == D)) {
				x();
			}
			else {
				if ( _cnt21504>=1 ) { goto _loop21504; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt21504++;
		}
		_loop21504:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void SimpleParser2::x() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case C:
		{
			a();
			break;
		}
		case D:
		{
			b();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void SimpleParser2::a() {
	
	try {      // for error handling
		match(C);
		match(B);
		match(A);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void SimpleParser2::b() {
	
	try {      // for error handling
		match(D);
		match(B);
		match(A);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void SimpleParser2::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* SimpleParser2::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"WS_",
	"A",
	"B",
	"C",
	"D",
	0
};

const unsigned long SimpleParser2::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet SimpleParser2::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long SimpleParser2::_tokenSet_1_data_[] = { 386UL, 0UL, 0UL, 0UL };
// EOF C D 
const ANTLR_USE_NAMESPACE(antlr)BitSet SimpleParser2::_tokenSet_1(_tokenSet_1_data_,4);


