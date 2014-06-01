/* $ANTLR 2.7.2: "expr.g" -> "ExprParser.cpp"$ */
#include "ExprParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 5 "expr.g"

#include <iostream>

#line 11 "ExprParser.cpp"
ExprParser::ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

ExprParser::ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

ExprParser::ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

ExprParser::ExprParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

ExprParser::ExprParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void ExprParser::expr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		assignExpr();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE);
		expr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		} else {
			throw;
		}
	}
	returnAST = expr_AST;
}

void ExprParser::assignExpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST assignExpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		addExpr();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{
		if ((LA(1) == ASSIGN)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp2_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp2_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp2_AST);
			}
			match(ASSIGN);
			assignExpr();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else if ((LA(1) == ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE || LA(1) == COMMA || LA(1) == RPAREN)) {
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		
		}
		assignExpr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
	returnAST = assignExpr_AST;
}

void ExprParser::addExpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST addExpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  pm = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST pm_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST me_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		multExpr();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PLUS_MINUS)) {
				try {      // for error handling
					pm = LT(1);
					if ( inputState->guessing == 0 ) {
						pm_AST = astFactory->create(pm);
						astFactory->makeASTRoot(currentAST, pm_AST);
					}
					match(PLUS_MINUS);
					multExpr();
					if (inputState->guessing==0) {
						me_AST = returnAST;
						astFactory->addASTChild( currentAST, returnAST );
					}
				}
				catch ( ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex ) {
					if (inputState->guessing==0) {
#line 35 "expr.g"
						
											std::cout << "Caught error in addExpr" << std::endl;
											reportError(ex.toString()); 
										
#line 142 "ExprParser.cpp"
					} else {
						throw;
					}
				}
			}
			else {
				goto _loop20299;
			}
			
		}
		_loop20299:;
		} // ( ... )*
		addExpr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_2);
		} else {
			throw;
		}
	}
	returnAST = addExpr_AST;
}

void ExprParser::multExpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST multExpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		postfixExpr();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == MULT_DIV)) {
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp3_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp3_AST);
				}
				match(MULT_DIV);
				postfixExpr();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else {
				goto _loop20302;
			}
			
		}
		_loop20302:;
		} // ( ... )*
		multExpr_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_3);
		} else {
			throw;
		}
	}
	returnAST = multExpr_AST;
}

void ExprParser::postfixExpr() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST postfixExpr_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  id = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  id2 = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST id2_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		bool synPredMatched20305 = false;
		if (((LA(1) == ID))) {
			int _m20305 = mark();
			synPredMatched20305 = true;
			inputState->guessing++;
			try {
				{
				match(ID);
				match(LPAREN);
				}
			}
			catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& pe) {
				synPredMatched20305 = false;
			}
			rewind(_m20305);
			inputState->guessing--;
		}
		if ( synPredMatched20305 ) {
			id2 = LT(1);
			if ( inputState->guessing == 0 ) {
				id2_AST = astFactory->create(id2);
				astFactory->makeASTRoot(currentAST, id2_AST);
			}
			match(ID);
			{
			if ((LA(1) == LPAREN)) {
				parenArgs();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else if ((_tokenSet_4.member(LA(1)))) {
			}
			else {
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			
			}
			postfixExpr_AST = currentAST.root;
		}
		else if ((_tokenSet_5.member(LA(1)))) {
			atom();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			postfixExpr_AST = currentAST.root;
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_4);
		} else {
			throw;
		}
	}
	returnAST = postfixExpr_AST;
}

void ExprParser::parenArgs() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST parenArgs_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		match(LPAREN);
		{
		if ((_tokenSet_5.member(LA(1)))) {
			assignExpr();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					assignExpr();
					if (inputState->guessing==0) {
						astFactory->addASTChild( currentAST, returnAST );
					}
				}
				else {
					goto _loop20310;
				}
				
			}
			_loop20310:;
			} // ( ... )*
		}
		else if ((LA(1) == RPAREN)) {
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		
		}
		match(RPAREN);
		parenArgs_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_4);
		} else {
			throw;
		}
	}
	returnAST = parenArgs_AST;
}

void ExprParser::atom() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST atom_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case ID:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp7_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp7_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp7_AST);
			}
			match(ID);
			atom_AST = currentAST.root;
			break;
		}
		case INT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp8_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp8_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp8_AST);
			}
			match(INT);
			atom_AST = currentAST.root;
			break;
		}
		case CHAR_LITERAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp9_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp9_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp9_AST);
			}
			match(CHAR_LITERAL);
			atom_AST = currentAST.root;
			break;
		}
		case STRING_LITERAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp10_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp10_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp10_AST);
			}
			match(STRING_LITERAL);
			atom_AST = currentAST.root;
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			assignExpr();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(RPAREN);
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
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_4);
		} else {
			throw;
		}
	}
	returnAST = atom_AST;
}

void ExprParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
	factory.setMaxNodeType(16);
}
const char* ExprParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"ASSIGN",
	"PLUS_MINUS",
	"MULT_DIV",
	"ID",
	"LPAREN",
	"COMMA",
	"RPAREN",
	"INT",
	"CHAR_LITERAL",
	"STRING_LITERAL",
	"WS_",
	"ESC",
	"DIGIT",
	0
};

const unsigned long ExprParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long ExprParser::_tokenSet_1_data_[] = { 1538UL, 0UL, 0UL, 0UL };
// EOF COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_1(_tokenSet_1_data_,4);
const unsigned long ExprParser::_tokenSet_2_data_[] = { 1554UL, 0UL, 0UL, 0UL };
// EOF ASSIGN COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_2(_tokenSet_2_data_,4);
const unsigned long ExprParser::_tokenSet_3_data_[] = { 1586UL, 0UL, 0UL, 0UL };
// EOF ASSIGN PLUS_MINUS COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_3(_tokenSet_3_data_,4);
const unsigned long ExprParser::_tokenSet_4_data_[] = { 1650UL, 0UL, 0UL, 0UL };
// EOF ASSIGN PLUS_MINUS MULT_DIV COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_4(_tokenSet_4_data_,4);
const unsigned long ExprParser::_tokenSet_5_data_[] = { 14720UL, 0UL, 0UL, 0UL };
// ID LPAREN INT CHAR_LITERAL STRING_LITERAL 
const ANTLR_USE_NAMESPACE(antlr)BitSet ExprParser::_tokenSet_5(_tokenSet_5_data_,4);


