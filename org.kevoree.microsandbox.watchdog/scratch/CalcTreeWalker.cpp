/* $ANTLR 2.7.2: "calc.g" -> "CalcTreeWalker.cpp"$ */
#include "CalcTreeWalker.hpp"
#include <antlr/Token.hpp>
#include <antlr/AST.hpp>
#include <antlr/NoViableAltException.hpp>
#include <antlr/MismatchedTokenException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/BitSet.hpp>
#line 1 "calc.g"
#line 11 "CalcTreeWalker.cpp"
CalcTreeWalker::CalcTreeWalker()
	: ANTLR_USE_NAMESPACE(antlr)TreeParser() {
}

float  CalcTreeWalker::expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
#line 56 "calc.g"
	float r;
#line 19 "CalcTreeWalker.cpp"
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST_in = _t;
	ANTLR_USE_NAMESPACE(antlr)RefAST i = ANTLR_USE_NAMESPACE(antlr)nullAST;
#line 56 "calc.g"
	
		float a,b;
		r=0;
	
#line 27 "CalcTreeWalker.cpp"
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case PLUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t20272 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp5_AST_in = _t;
			match(_t,PLUS);
			_t = _t->getFirstChild();
			a=expr(_t);
			_t = _retTree;
			b=expr(_t);
			_t = _retTree;
			_t = __t20272;
			_t = _t->getNextSibling();
#line 61 "calc.g"
			r = a+b;
#line 47 "CalcTreeWalker.cpp"
			break;
		}
		case STAR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t20273 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp6_AST_in = _t;
			match(_t,STAR);
			_t = _t->getFirstChild();
			a=expr(_t);
			_t = _retTree;
			b=expr(_t);
			_t = _retTree;
			_t = __t20273;
			_t = _t->getNextSibling();
#line 62 "calc.g"
			r = a*b;
#line 64 "CalcTreeWalker.cpp"
			break;
		}
		case INT:
		{
			i = _t;
			match(_t,INT);
			_t = _t->getNextSibling();
#line 63 "calc.g"
			r = atof(i->getText().c_str());
#line 74 "CalcTreeWalker.cpp"
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
	return r;
}

void CalcTreeWalker::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* CalcTreeWalker::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"PLUS",
	"SEMI",
	"STAR",
	"INT",
	"WS_",
	"LPAREN",
	"RPAREN",
	"DIGIT",
	0
};



