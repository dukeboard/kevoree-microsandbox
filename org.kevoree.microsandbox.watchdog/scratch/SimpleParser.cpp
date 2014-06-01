/* $ANTLR 2.7.2: "parser1.g" -> "SimpleParser.cpp"$ */
#include "SimpleParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "parser1.g"
#line 8 "SimpleParser.cpp"
SimpleParser::SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

SimpleParser::SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

SimpleParser::SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

SimpleParser::SimpleParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

SimpleParser::SimpleParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void SimpleParser::simple() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt21496=0;
		for (;;) {
			if ((LA(1) == A)) {
				x();
			}
			else {
				if ( _cnt21496>=1 ) { goto _loop21496; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt21496++;
		}
		_loop21496:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		} else {
			throw;
		}
	}
}

void SimpleParser::x() {
	
	try {      // for error handling
		bool synPredMatched21499 = false;
		if (((LA(1) == A))) {
			int _m21499 = mark();
			synPredMatched21499 = true;
			inputState->guessing++;
			try {
				{
				a();
				}
			}
			catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& pe) {
				synPredMatched21499 = false;
			}
			rewind(_m21499);
			inputState->guessing--;
		}
		if ( synPredMatched21499 ) {
			a();
		}
		else if ((LA(1) == A)) {
			b();
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
}

void SimpleParser::a() {
	
	try {      // for error handling
		match(A);
		match(B);
		match(C);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
}

void SimpleParser::b() {
	
	try {      // for error handling
		match(A);
		match(B);
		match(D);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
}

void SimpleParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* SimpleParser::tokenNames[] = {
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

const unsigned long SimpleParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet SimpleParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long SimpleParser::_tokenSet_1_data_[] = { 34UL, 0UL, 0UL, 0UL };
// EOF A 
const ANTLR_USE_NAMESPACE(antlr)BitSet SimpleParser::_tokenSet_1(_tokenSet_1_data_,4);


