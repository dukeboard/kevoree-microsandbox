/* $ANTLR 2.7.2: "treewalk.g" -> "LangParser.cpp"$ */
#include "LangParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "treewalk.g"
#line 8 "LangParser.cpp"
LangParser::LangParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

LangParser::LangParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

LangParser::LangParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

LangParser::LangParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

LangParser::LangParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void LangParser::block() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST block_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		match(LCURLY);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_0.member(LA(1)))) {
				statement();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else {
				goto _loop21555;
			}
			
		}
		_loop21555:;
		} // ( ... )*
		match(RCURLY);
		block_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 22 "treewalk.g"
		block_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(BLOCK,"BLOCK"))->add(block_AST)));
#line 58 "LangParser.cpp"
		currentAST.root = block_AST;
		if ( block_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			block_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = block_AST->getFirstChild();
		else
			currentAST.child = block_AST;
		currentAST.advanceChildToEnd();
		block_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
	returnAST = block_AST;
}

void LangParser::statement() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST statement_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST b_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case ID:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp3_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp3_AST);
			match(ID);
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp4_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp4_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp4_AST);
			match(ASSIGN);
			expr();
			astFactory->addASTChild( currentAST, returnAST );
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case TK_if:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp6_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp6_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp6_AST);
			match(TK_if);
			match(LPAREN);
			expr();
			astFactory->addASTChild( currentAST, returnAST );
			match(RPAREN);
			statement();
			astFactory->addASTChild( currentAST, returnAST );
			{
			if ((LA(1) == TK_else)) {
				match(TK_else);
				statement();
				astFactory->addASTChild( currentAST, returnAST );
			}
			else if ((_tokenSet_1.member(LA(1)))) {
			}
			else {
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_while:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp10_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp10_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp10_AST);
			match(TK_while);
			match(LPAREN);
			expr();
			astFactory->addASTChild( currentAST, returnAST );
			match(RPAREN);
			statement();
			astFactory->addASTChild( currentAST, returnAST );
			statement_AST = currentAST.root;
			break;
		}
		case LCURLY:
		{
			block();
			b_AST = returnAST;
#line 30 "treewalk.g"
			statement_AST = b_AST;
#line 149 "LangParser.cpp"
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
		consumeUntil(_tokenSet_1);
	}
	returnAST = statement_AST;
}

void LangParser::expr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  id = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case ID:
		{
			id = LT(1);
			id_AST = astFactory->create(id);
			match(ID);
			expr_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 37 "treewalk.g"
			expr_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(EXPR,"EXPR"))->add(id_AST)));
#line 183 "LangParser.cpp"
			currentAST.root = expr_AST;
			if ( expr_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
				expr_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
				  currentAST.child = expr_AST->getFirstChild();
			else
				currentAST.child = expr_AST;
			currentAST.advanceChildToEnd();
			break;
		}
		case INT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp13_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			tmp13_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp13_AST);
			match(INT);
			expr_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 38 "treewalk.g"
			expr_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(EXPR,"EXPR"))->add(expr_AST)));
#line 202 "LangParser.cpp"
			currentAST.root = expr_AST;
			if ( expr_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
				expr_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
				  currentAST.child = expr_AST->getFirstChild();
			else
				currentAST.child = expr_AST;
			currentAST.advanceChildToEnd();
			expr_AST = currentAST.root;
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
		consumeUntil(_tokenSet_2);
	}
	returnAST = expr_AST;
}

void LangParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
	factory.setMaxNodeType(18);
}
const char* LangParser::tokenNames[] = {
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

const unsigned long LangParser::_tokenSet_0_data_[] = { 17568UL, 0UL, 0UL, 0UL };
// LCURLY ID "if" "while" 
const ANTLR_USE_NAMESPACE(antlr)BitSet LangParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long LangParser::_tokenSet_1_data_[] = { 25824UL, 0UL, 0UL, 0UL };
// LCURLY RCURLY ID "if" "else" "while" 
const ANTLR_USE_NAMESPACE(antlr)BitSet LangParser::_tokenSet_1(_tokenSet_1_data_,4);
const unsigned long LangParser::_tokenSet_2_data_[] = { 4608UL, 0UL, 0UL, 0UL };
// SEMI RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet LangParser::_tokenSet_2(_tokenSet_2_data_,4);


