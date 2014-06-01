/* $ANTLR 2.7.2: "column.g" -> "P.cpp"$ */
#include "P.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 7 "column.g"

#include "L.hpp"

	int main( void )
	{
		try
		{
			L lexer(cin);
			lexer.set_tabsize(8);

			P parser(lexer);

			parser.start();
		}
		catch( exception& e )
		{
			cerr << "exception: " << e.what() << endl;
		}
	}

#line 28 "P.cpp"
P::P(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

P::P(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

P::P(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

P::P(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

P::P(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void P::start() {
	ANTLR_USE_NAMESPACE(antlr)RefToken  t = ANTLR_USE_NAMESPACE(antlr)nullToken;
	
	try {      // for error handling
		{ // ( ... )*
		for (;;) {
			if (((LA(1) >= WS && LA(1) <= NL))) {
				{ // ( ... )*
				for (;;) {
					if ((LA(1) == WS || LA(1) == NB)) {
						{
						switch ( LA(1)) {
						case WS:
						{
							match(WS);
							break;
						}
						case NB:
						{
							break;
						}
						default:
						{
							throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
						}
						}
						}
						t = LT(1);
						match(NB);
#line 31 "column.g"
						cout << "\"" <<  t->getText() << "\""
											<< " line " << t->getLine() << " col " << t->getColumn()
												<< endl;
									
#line 88 "P.cpp"
					}
					else {
						goto _loop20279;
					}
					
				}
				_loop20279:;
				} // ( ... )*
				match(NL);
			}
			else {
				goto _loop20280;
			}
			
		}
		_loop20280:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void P::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* P::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"WS",
	"NB",
	"NL",
	0
};

const unsigned long P::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet P::_tokenSet_0(_tokenSet_0_data_,4);


