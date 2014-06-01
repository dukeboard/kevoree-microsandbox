/* $ANTLR 2.7.2: "P.g" -> "PParser.cpp"$ */
#include "PParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "P.g"
#line 8 "PParser.cpp"
PParser::PParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

PParser::PParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

PParser::PParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

PParser::PParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

PParser::PParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void PParser::startRule() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt21511=0;
		for (;;) {
			if ((LA(1) == INT)) {
				decl();
			}
			else {
				if ( _cnt21511>=1 ) { goto _loop21511; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt21511++;
		}
		_loop21511:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void PParser::decl() {
	ANTLR_USE_NAMESPACE(antlr)RefToken  a = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefToken  b = ANTLR_USE_NAMESPACE(antlr)nullToken;
	
	try {      // for error handling
		match(INT);
		a = LT(1);
		match(ID);
#line 35 "P.g"
		ANTLR_USE_NAMESPACE(std)cout << "decl " << a->getText() << ANTLR_USE_NAMESPACE(std)endl;
#line 69 "PParser.cpp"
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				b = LT(1);
				match(ID);
#line 36 "P.g"
				ANTLR_USE_NAMESPACE(std)cout << "decl " << b->getText() << ANTLR_USE_NAMESPACE(std)endl;
#line 78 "PParser.cpp"
			}
			else {
				goto _loop21514;
			}
			
		}
		_loop21514:;
		} // ( ... )*
		match(SEMI);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void PParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* PParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"\"int\"",
	"ID",
	"COMMA",
	"SEMI",
	"INCLUDE",
	"STRING",
	"WS_",
	0
};

const unsigned long PParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet PParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long PParser::_tokenSet_1_data_[] = { 18UL, 0UL, 0UL, 0UL };
// EOF "int" 
const ANTLR_USE_NAMESPACE(antlr)BitSet PParser::_tokenSet_1(_tokenSet_1_data_,4);


