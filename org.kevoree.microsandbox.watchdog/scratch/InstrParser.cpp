/* $ANTLR 2.7.2: "instr.g" -> "InstrParser.cpp"$ */
#include "InstrParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "instr.g"
#line 8 "InstrParser.cpp"
InstrParser::InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

InstrParser::InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,2)
{
}

InstrParser::InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

InstrParser::InstrParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,2)
{
}

InstrParser::InstrParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,2)
{
}

void InstrParser::slist() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST slist_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt21039=0;
		for (;;) {
			if ((LA(1) == LBRACE || LA(1) == TK_if || LA(1) == ID)) {
				stat();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				if ( _cnt21039>=1 ) { goto _loop21039; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt21039++;
		}
		_loop21039:;
		}  // ( ... )+
		slist_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
	returnAST = slist_AST;
}

void InstrParser::stat() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST stat_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case LBRACE:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp1_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp1_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp1_AST);
			match(LBRACE);
			{ // ( ... )+
			int _cnt21042=0;
			for (;;) {
				if ((LA(1) == LBRACE || LA(1) == TK_if || LA(1) == ID)) {
					stat();
					astFactory->addASTChild( currentAST, returnAST );
				}
				else {
					if ( _cnt21042>=1 ) { goto _loop21042; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt21042++;
			}
			_loop21042:;
			}  // ( ... )+
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp2_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp2_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp2_AST);
			match(RBRACE);
			stat_AST = currentAST.root;
			break;
		}
		case TK_if:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp3_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp3_AST);
			match(TK_if);
			expr();
			astFactory->addASTChild( currentAST, returnAST );
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp4_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp4_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp4_AST);
			match(TK_then);
			stat();
			astFactory->addASTChild( currentAST, returnAST );
			{
			if ((LA(1) == TK_else) && (LA(2) == LBRACE || LA(2) == TK_if || LA(2) == ID)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp5_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp5_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp5_AST);
				match(TK_else);
				stat();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_2.member(LA(2)))) {
			}
			else {
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			
			}
			stat_AST = currentAST.root;
			break;
		}
		default:
			if ((LA(1) == ID) && (LA(2) == ASSIGN)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp6_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp6_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp6_AST);
				match(ID);
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp7_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp7_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp7_AST);
				match(ASSIGN);
				expr();
				astFactory->addASTChild( currentAST, returnAST );
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp8_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp8_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp8_AST);
				match(SEMI);
				stat_AST = currentAST.root;
			}
			else if ((LA(1) == ID) && (LA(2) == LPAREN)) {
				call();
				astFactory->addASTChild( currentAST, returnAST );
				stat_AST = currentAST.root;
			}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
	returnAST = stat_AST;
}

void InstrParser::expr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		mexpr();
		astFactory->addASTChild( currentAST, returnAST );
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PLUS)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp9_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp9_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp9_AST);
				match(PLUS);
				mexpr();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				goto _loop21046;
			}
			
		}
		_loop21046:;
		} // ( ... )*
		expr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
	returnAST = expr_AST;
}

void InstrParser::call() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST call_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp10_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		tmp10_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp10_AST);
		match(ID);
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp11_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		tmp11_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp11_AST);
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ID:
		case INT:
		{
			expr();
			astFactory->addASTChild( currentAST, returnAST );
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp12_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		tmp12_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp12_AST);
		match(RPAREN);
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp13_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		tmp13_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp13_AST);
		match(SEMI);
		call_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 44 "instr.g"
		call_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(CALL,"CALL"))->add(call_AST)));
#line 248 "InstrParser.cpp"
		currentAST.root = call_AST;
		if ( call_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			call_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = call_AST->getFirstChild();
		else
			currentAST.child = call_AST;
		currentAST.advanceChildToEnd();
		call_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
	returnAST = call_AST;
}

void InstrParser::mexpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST mexpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		atom();
		astFactory->addASTChild( currentAST, returnAST );
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == STAR)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp14_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp14_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp14_AST);
				match(STAR);
				atom();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				goto _loop21049;
			}
			
		}
		_loop21049:;
		} // ( ... )*
		mexpr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
	returnAST = mexpr_AST;
}

void InstrParser::atom() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST atom_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case INT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp15_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp15_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp15_AST);
			match(INT);
			atom_AST = currentAST.root;
			break;
		}
		case ID:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp16_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp16_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp16_AST);
			match(ID);
			atom_AST = currentAST.root;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
	returnAST = atom_AST;
}

void InstrParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
	factory.setMaxNodeType(20);
}
const char* InstrParser::tokenNames[] = {
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

const unsigned long InstrParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long InstrParser::_tokenSet_1_data_[] = { 1762UL, 0UL, 0UL, 0UL };
// EOF LBRACE RBRACE "if" "else" ID 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_1(_tokenSet_1_data_,4);
const unsigned long InstrParser::_tokenSet_2_data_[] = { 102114UL, 0UL, 0UL, 0UL };
// EOF LBRACE RBRACE "if" "else" ID ASSIGN INT LPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_2(_tokenSet_2_data_,4);
const unsigned long InstrParser::_tokenSet_3_data_[] = { 135424UL, 0UL, 0UL, 0UL };
// "then" SEMI RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_3(_tokenSet_3_data_,4);
const unsigned long InstrParser::_tokenSet_4_data_[] = { 143616UL, 0UL, 0UL, 0UL };
// "then" SEMI PLUS RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_4(_tokenSet_4_data_,4);
const unsigned long InstrParser::_tokenSet_5_data_[] = { 160000UL, 0UL, 0UL, 0UL };
// "then" SEMI PLUS STAR RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet InstrParser::_tokenSet_5(_tokenSet_5_data_,4);


