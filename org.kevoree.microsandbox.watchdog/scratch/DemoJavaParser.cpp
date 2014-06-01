/* $ANTLR 2.7.2: "javaparse.g" -> "DemoJavaParser.cpp"$ */
#include "DemoJavaParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 5 "javaparse.g"

#include "DemoJavaDocParser.hpp"

#line 11 "DemoJavaParser.cpp"
DemoJavaParser::DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

DemoJavaParser::DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

DemoJavaParser::DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

DemoJavaParser::DemoJavaParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

DemoJavaParser::DemoJavaParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void DemoJavaParser::input() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt21306=0;
		for (;;) {
			if ((LA(1) == JAVADOC_OPEN || LA(1) == INT)) {
				{
				switch ( LA(1)) {
				case JAVADOC_OPEN:
				{
					javadoc();
					break;
				}
				case INT:
				{
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(INT);
				match(ID);
				match(SEMI);
			}
			else {
				if ( _cnt21306>=1 ) { goto _loop21306; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt21306++;
		}
		_loop21306:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void DemoJavaParser::javadoc() {
	
	try {      // for error handling
		match(JAVADOC_OPEN);
#line 20 "javaparse.g"
		
				DemoJavaDocParser jdocparser(getInputState());
				jdocparser.content();
				
#line 90 "DemoJavaParser.cpp"
		match(JAVADOC_CLOSE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void DemoJavaParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* DemoJavaParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"JAVADOC_OPEN",
	"JAVADOC_CLOSE",
	"\"int\"",
	"ID",
	"SEMI",
	"WS_",
	0
};

const unsigned long DemoJavaParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet DemoJavaParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long DemoJavaParser::_tokenSet_1_data_[] = { 64UL, 0UL, 0UL, 0UL };
// "int" 
const ANTLR_USE_NAMESPACE(antlr)BitSet DemoJavaParser::_tokenSet_1(_tokenSet_1_data_,4);


