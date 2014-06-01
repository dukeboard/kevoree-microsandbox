/* $ANTLR 2.7.2: "treewalk.g" -> "LangWalker.cpp"$ */
#include "LangWalker.hpp"
#include <antlr/Token.hpp>
#include <antlr/AST.hpp>
#include <antlr/NoViableAltException.hpp>
#include <antlr/MismatchedTokenException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/BitSet.hpp>
#line 1 "treewalk.g"
#line 11 "LangWalker.cpp"
LangWalker::LangWalker()
	: ANTLR_USE_NAMESPACE(antlr)TreeParser() {
}

void LangWalker::block(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST block_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21560 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp14_AST_in = _t;
		match(_t,BLOCK);
		_t = _t->getFirstChild();
		{ // ( ... )+
		int _cnt21562=0;
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_tokenSet_0.member(_t->getType()))) {
				stat(_t);
				_t = _retTree;
			}
			else {
				if ( _cnt21562>=1 ) { goto _loop21562; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);}
			}
			
			_cnt21562++;
		}
		_loop21562:;
		}  // ( ... )+
		_t = __t21560;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void LangWalker::stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST stat_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case TK_if:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21564 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp15_AST_in = _t;
			match(_t,TK_if);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			stat(_t);
			_t = _retTree;
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case BLOCK:
			case ASSIGN:
			case TK_if:
			case TK_while:
			case EXPR:
			{
				stat(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21564;
			_t = _t->getNextSibling();
			break;
		}
		case TK_while:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21566 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp16_AST_in = _t;
			match(_t,TK_while);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			stat(_t);
			_t = _retTree;
			_t = __t21566;
			_t = _t->getNextSibling();
			break;
		}
		case EXPR:
		{
			expr(_t);
			_t = _retTree;
			break;
		}
		case BLOCK:
		{
			block(_t);
			_t = _retTree;
			break;
		}
		case ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21567 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp17_AST_in = _t;
			match(_t,ASSIGN);
			_t = _t->getFirstChild();
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp18_AST_in = _t;
			match(_t,ID);
			_t = _t->getNextSibling();
			expr(_t);
			_t = _retTree;
			_t = __t21567;
			_t = _t->getNextSibling();
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
}

void LangWalker::expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST_in = _t;
	ANTLR_USE_NAMESPACE(antlr)RefAST a = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST b = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21569 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp19_AST_in = _t;
		match(_t,EXPR);
		_t = _t->getFirstChild();
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ID:
		{
			a = _t;
			match(_t,ID);
			_t = _t->getNextSibling();
#line 54 "treewalk.g"
			std::cout << "found ID "<<a->getText() << std::endl;
#line 173 "LangWalker.cpp"
			break;
		}
		case INT:
		{
			b = _t;
			match(_t,INT);
			_t = _t->getNextSibling();
#line 55 "treewalk.g"
			std::cout << "found INT "<<b->getText() << std::endl;
#line 183 "LangWalker.cpp"
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		_t = __t21569;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void LangWalker::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* LangWalker::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"BLOCK",
	"LCURLY",
	"RCURLY",
	"ID",
	"ASSIGN",
	"SEMI",
	"\"if\"",
	"LPAREN",
	"RPAREN",
	"\"else\"",
	"\"while\"",
	"INT",
	"EXPR",
	"WS_",
	"DIGIT",
	0
};

const unsigned long LangWalker::_tokenSet_0_data_[] = { 83216UL, 0UL, 0UL, 0UL };
// BLOCK ASSIGN "if" "while" EXPR 
const ANTLR_USE_NAMESPACE(antlr)BitSet LangWalker::_tokenSet_0(_tokenSet_0_data_,4);


