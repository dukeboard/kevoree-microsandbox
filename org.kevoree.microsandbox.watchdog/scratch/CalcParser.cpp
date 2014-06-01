/* $ANTLR 2.7.2: "calc.g" -> "CalcParser.cpp"$ */
#include "CalcParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "calc.g"
#line 8 "CalcParser.cpp"
CalcParser::CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

CalcParser::CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

CalcParser::CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

CalcParser::CalcParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

CalcParser::CalcParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void CalcParser::expr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		mexpr();
		astFactory->addASTChild( currentAST, returnAST );
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PLUS)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp1_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp1_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp1_AST);
				match(PLUS);
				mexpr();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				goto _loop20255;
			}
			
		}
		_loop20255:;
		} // ( ... )*
		match(SEMI);
		expr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
	returnAST = expr_AST;
}

void CalcParser::mexpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST mexpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		atom();
		astFactory->addASTChild( currentAST, returnAST );
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == STAR)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				tmp3_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp3_AST);
				match(STAR);
				atom();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				goto _loop20258;
			}
			
		}
		_loop20258:;
		} // ( ... )*
		mexpr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
	returnAST = mexpr_AST;
}

void CalcParser::atom() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST atom_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp4_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		tmp4_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp4_AST);
		match(INT);
		atom_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_2);
	}
	returnAST = atom_AST;
}

void CalcParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
	factory.setMaxNodeType(11);
}
const char* CalcParser::tokenNames[] = {
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

const unsigned long CalcParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet CalcParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long CalcParser::_tokenSet_1_data_[] = { 48UL, 0UL, 0UL, 0UL };
// PLUS SEMI 
const ANTLR_USE_NAMESPACE(antlr)BitSet CalcParser::_tokenSet_1(_tokenSet_1_data_,4);
const unsigned long CalcParser::_tokenSet_2_data_[] = { 112UL, 0UL, 0UL, 0UL };
// PLUS SEMI STAR 
const ANTLR_USE_NAMESPACE(antlr)BitSet CalcParser::_tokenSet_2(_tokenSet_2_data_,4);


