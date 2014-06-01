/* $ANTLR 2.7.2: "javadocparse.g" -> "DemoJavaDocParser.cpp"$ */
#include "DemoJavaDocParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 5 "javadocparse.g"

#include <iostream>

#line 11 "DemoJavaDocParser.cpp"
DemoJavaDocParser::DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

DemoJavaDocParser::DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

DemoJavaDocParser::DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

DemoJavaDocParser::DemoJavaDocParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

DemoJavaDocParser::DemoJavaDocParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void DemoJavaDocParser::content() {
	ANTLR_USE_NAMESPACE(antlr)RefToken  p = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefToken  e = ANTLR_USE_NAMESPACE(antlr)nullToken;
	
	try {      // for error handling
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case PARAM:
			{
				p = LT(1);
				match(PARAM);
#line 16 "javadocparse.g"
				std::cout << "found: " << p->getText() << std::endl;
#line 51 "DemoJavaDocParser.cpp"
				break;
			}
			case EXCEPTION:
			{
				e = LT(1);
				match(EXCEPTION);
#line 18 "javadocparse.g"
				std::cout << "found: " << e->getText() << std::endl;
#line 60 "DemoJavaDocParser.cpp"
				break;
			}
			default:
			{
				goto _loop21111;
			}
			}
		}
		_loop21111:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void DemoJavaDocParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* DemoJavaDocParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"JAVADOC_OPEN",
	"JAVADOC_CLOSE",
	"PARAM",
	"EXCEPTION",
	"ID",
	"STAR",
	"NEWLINE",
	0
};

const unsigned long DemoJavaDocParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet DemoJavaDocParser::_tokenSet_0(_tokenSet_0_data_,4);


