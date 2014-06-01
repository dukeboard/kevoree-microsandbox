/* $ANTLR 2.7.2: "instr.g" -> "InstrTreeWalker.cpp"$ */
#include "InstrTreeWalker.hpp"
#include <antlr/Token.hpp>
#include <antlr/AST.hpp>
#include <antlr/NoViableAltException.hpp>
#include <antlr/MismatchedTokenException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/BitSet.hpp>
#line 1 "instr.g"
#line 11 "InstrTreeWalker.cpp"
InstrTreeWalker::InstrTreeWalker()
	: ANTLR_USE_NAMESPACE(antlr)TreeParser() {
}

void InstrTreeWalker::slist(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST slist_AST_in = _t;
	
	try {      // for error handling
#line 117 "instr.g"
		dumpHidden(filter->getInitialHiddenToken());
#line 22 "InstrTreeWalker.cpp"
		{ // ( ... )+
		int _cnt21081=0;
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_tokenSet_0.member(_t->getType()))) {
				stat(_t);
				_t = _retTree;
			}
			else {
				if ( _cnt21081>=1 ) { goto _loop21081; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);}
			}
			
			_cnt21081++;
		}
		_loop21081:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void InstrTreeWalker::stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST stat_AST_in = _t;
	ANTLR_USE_NAMESPACE(antlr)RefAST i = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST t = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST e = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case LBRACE:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21083 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp17_AST_in = _t;
			match(_t,LBRACE);
			_t = _t->getFirstChild();
#line 121 "instr.g"
			pr(tmp17_AST_in);
#line 67 "InstrTreeWalker.cpp"
			{ // ( ... )+
			int _cnt21085=0;
			for (;;) {
				if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
					_t = ASTNULL;
				if ((_tokenSet_0.member(_t->getType()))) {
					stat(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt21085>=1 ) { goto _loop21085; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);}
				}
				
				_cnt21085++;
			}
			_loop21085:;
			}  // ( ... )+
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp18_AST_in = _t;
			match(_t,RBRACE);
			_t = _t->getNextSibling();
#line 121 "instr.g"
			pr(tmp18_AST_in);
#line 90 "InstrTreeWalker.cpp"
			_t = __t21083;
			_t = _t->getNextSibling();
			break;
		}
		case TK_if:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21086 = _t;
			i = (_t == ASTNULL) ? ANTLR_USE_NAMESPACE(antlr)nullAST : _t;
			match(_t,TK_if);
			_t = _t->getFirstChild();
#line 122 "instr.g"
			pr(i);
#line 103 "InstrTreeWalker.cpp"
			expr(_t);
			_t = _retTree;
			t = _t;
			match(_t,TK_then);
			_t = _t->getNextSibling();
#line 122 "instr.g"
			pr(t);
#line 111 "InstrTreeWalker.cpp"
			stat(_t);
			_t = _retTree;
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case TK_else:
			{
				e = _t;
				match(_t,TK_else);
				_t = _t->getNextSibling();
#line 122 "instr.g"
				pr(e);
#line 125 "InstrTreeWalker.cpp"
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
			_t = __t21086;
			_t = _t->getNextSibling();
			break;
		}
		case ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21088 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp19_AST_in = _t;
			match(_t,ASSIGN);
			_t = _t->getFirstChild();
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp20_AST_in = _t;
			match(_t,ID);
			_t = _t->getNextSibling();
#line 123 "instr.g"
			pr(tmp20_AST_in); pr(tmp19_AST_in);
#line 155 "InstrTreeWalker.cpp"
			expr(_t);
			_t = _retTree;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp21_AST_in = _t;
			match(_t,SEMI);
			_t = _t->getNextSibling();
#line 123 "instr.g"
			pr(tmp21_AST_in);
#line 163 "InstrTreeWalker.cpp"
			_t = __t21088;
			_t = _t->getNextSibling();
			break;
		}
		case CALL:
		{
			call(_t);
			_t = _retTree;
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

void InstrTreeWalker::expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case PLUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21090 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp22_AST_in = _t;
			match(_t,PLUS);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
#line 128 "instr.g"
			pr(tmp22_AST_in);
#line 205 "InstrTreeWalker.cpp"
			expr(_t);
			_t = _retTree;
			_t = __t21090;
			_t = _t->getNextSibling();
			break;
		}
		case STAR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21091 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp23_AST_in = _t;
			match(_t,STAR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
#line 129 "instr.g"
			pr(tmp23_AST_in);
#line 222 "InstrTreeWalker.cpp"
			expr(_t);
			_t = _retTree;
			_t = __t21091;
			_t = _t->getNextSibling();
			break;
		}
		case INT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp24_AST_in = _t;
			match(_t,INT);
			_t = _t->getNextSibling();
#line 130 "instr.g"
			pr(tmp24_AST_in);
#line 236 "InstrTreeWalker.cpp"
			break;
		}
		case ID:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp25_AST_in = _t;
			match(_t,ID);
			_t = _t->getNextSibling();
#line 131 "instr.g"
			pr(tmp25_AST_in);
#line 246 "InstrTreeWalker.cpp"
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

void InstrTreeWalker::call(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST call_AST_in = _t;
	
	try {      // for error handling
#line 134 "instr.g"
		
				// add instrumentation about call; manually call rule
				callDumpInstrumentation(call_AST_in);
				
#line 272 "InstrTreeWalker.cpp"
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21093 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp26_AST_in = _t;
		match(_t,CALL);
		_t = _t->getFirstChild();
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp27_AST_in = _t;
		match(_t,ID);
		_t = _t->getNextSibling();
#line 138 "instr.g"
		pr(tmp27_AST_in);
#line 282 "InstrTreeWalker.cpp"
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp28_AST_in = _t;
		match(_t,LPAREN);
		_t = _t->getNextSibling();
#line 139 "instr.g"
		pr(tmp28_AST_in);
#line 288 "InstrTreeWalker.cpp"
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ID:
		case PLUS:
		case STAR:
		case INT:
		{
			expr(_t);
			_t = _retTree;
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp29_AST_in = _t;
		match(_t,RPAREN);
		_t = _t->getNextSibling();
#line 139 "instr.g"
		pr(tmp29_AST_in);
#line 317 "InstrTreeWalker.cpp"
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp30_AST_in = _t;
		match(_t,SEMI);
		_t = _t->getNextSibling();
#line 141 "instr.g"
		
				  // print SEMI manually; need '}' between it and whitespace
				  std::cout << tmp30_AST_in->getText();
				  std::cout << "}"; // close {...} of instrumentation
				  dumpHidden(
					(ANTLR_USE_NAMESPACE(antlr)RefCommonASTWithHiddenTokens(tmp30_AST_in))->getHiddenAfter()
				  );
				
#line 330 "InstrTreeWalker.cpp"
		_t = __t21093;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

/** Dump instrumentation for a call statement.
 *  The reference to rule expr prints out the arg
 *  and then at the end of this rule, we close the
 *  generated called to dbg.invoke().
 */
void InstrTreeWalker::callDumpInstrumentation(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST callDumpInstrumentation_AST_in = _t;
	ANTLR_USE_NAMESPACE(antlr)RefAST id = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST e = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21096 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp31_AST_in = _t;
		match(_t,CALL);
		_t = _t->getFirstChild();
		id = _t;
		match(_t,ID);
		_t = _t->getNextSibling();
#line 159 "instr.g"
		std::cout << "{dbg.invoke(\"" << id->getText() << "\", \"";
#line 362 "InstrTreeWalker.cpp"
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp32_AST_in = _t;
		match(_t,LPAREN);
		_t = _t->getNextSibling();
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ID:
		case PLUS:
		case STAR:
		case INT:
		{
			e = (_t == ASTNULL) ? ANTLR_USE_NAMESPACE(antlr)nullAST : _t;
			expr(_t);
			_t = _retTree;
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp33_AST_in = _t;
		match(_t,RPAREN);
		_t = _t->getNextSibling();
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp34_AST_in = _t;
		match(_t,SEMI);
		_t = _t->getNextSibling();
#line 161 "instr.g"
		std::cout << "\"); ";
#line 398 "InstrTreeWalker.cpp"
		_t = __t21096;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void InstrTreeWalker::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* InstrTreeWalker::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"CALL",
	"LBRACE",
	"RBRACE",
	"\"if\"",
	"\"then\"",
	"\"else\"",
	"ID",
	"ASSIGN",
	"SEMI",
	"PLUS",
	"STAR",
	"INT",
	"LPAREN",
	"RPAREN",
	"WS_",
	"SL_COMMENT",
	"DIGIT",
	0
};

const unsigned long InstrTreeWalker::_tokenSet_0_data_[] = { 2224UL, 0UL, 0UL, 0UL };
// CALL LBRACE "if" ASSIGN 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrTreeWalker::_tokenSet_0(_tokenSet_0_data_,4);


