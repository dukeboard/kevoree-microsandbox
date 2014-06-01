// $ANTLR 2.7.2: "expr.g" -> "ExprParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

import java.io.*;

public class ExprParser extends antlr.LLkParser       implements ExprParserTokenTypes
 {

protected ExprParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExprParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected ExprParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExprParser(TokenStream lexer) {
  this(lexer,1);
}

public ExprParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST expr_AST = null;
		
		try {      // for error handling
			assignExpr();
			astFactory.addASTChild(currentAST, returnAST);
			match(Token.EOF_TYPE);
			expr_AST = (antlr.CommonAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_AST;
	}
	
	public final void assignExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST assignExpr_AST = null;
		
		try {      // for error handling
			addExpr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==ASSIGN)) {
				antlr.CommonAST tmp2_AST = null;
				tmp2_AST = (antlr.CommonAST)astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp2_AST);
				match(ASSIGN);
				assignExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==EOF||LA(1)==COMMA||LA(1)==RPAREN)) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			assignExpr_AST = (antlr.CommonAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		returnAST = assignExpr_AST;
	}
	
	public final void addExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST addExpr_AST = null;
		Token  pm = null;
		antlr.CommonAST pm_AST = null;
		antlr.CommonAST me_AST = null;
		
		try {      // for error handling
			multExpr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop18005:
			do {
				if ((LA(1)==PLUS_MINUS)) {
					try {      // for error handling
						pm = LT(1);
						pm_AST = (antlr.CommonAST)astFactory.create(pm);
						astFactory.makeASTRoot(currentAST, pm_AST);
						match(PLUS_MINUS);
						multExpr();
						me_AST = (antlr.CommonAST)returnAST;
						astFactory.addASTChild(currentAST, returnAST);
					}
					catch ( RecognitionException ex ) {
						if (inputState.guessing==0) {
							
												System.out.println("Caught error in addExpr");
												reportError(ex.toString()); 
											
						} else {
							throw ex ;
						}
					}
				}
				else {
					break _loop18005;
				}
				
			} while (true);
			}
			addExpr_AST = (antlr.CommonAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = addExpr_AST;
	}
	
	public final void multExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST multExpr_AST = null;
		
		try {      // for error handling
			postfixExpr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop18008:
			do {
				if ((LA(1)==MULT_DIV)) {
					antlr.CommonAST tmp3_AST = null;
					tmp3_AST = (antlr.CommonAST)astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp3_AST);
					match(MULT_DIV);
					postfixExpr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop18008;
				}
				
			} while (true);
			}
			multExpr_AST = (antlr.CommonAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = multExpr_AST;
	}
	
	public final void postfixExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST postfixExpr_AST = null;
		Token  id = null;
		antlr.CommonAST id_AST = null;
		Token  id2 = null;
		antlr.CommonAST id2_AST = null;
		
		try {      // for error handling
			boolean synPredMatched18011 = false;
			if (((LA(1)==ID))) {
				int _m18011 = mark();
				synPredMatched18011 = true;
				inputState.guessing++;
				try {
					{
					match(ID);
					match(LPAREN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched18011 = false;
				}
				rewind(_m18011);
				inputState.guessing--;
			}
			if ( synPredMatched18011 ) {
				id2 = LT(1);
				id2_AST = (antlr.CommonAST)astFactory.create(id2);
				astFactory.makeASTRoot(currentAST, id2_AST);
				match(ID);
				{
				if ((LA(1)==LPAREN)) {
					parenArgs();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_4.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				postfixExpr_AST = (antlr.CommonAST)currentAST.root;
			}
			else if ((_tokenSet_5.member(LA(1)))) {
				atom();
				astFactory.addASTChild(currentAST, returnAST);
				postfixExpr_AST = (antlr.CommonAST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = postfixExpr_AST;
	}
	
	public final void parenArgs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST parenArgs_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			{
			if ((_tokenSet_5.member(LA(1)))) {
				assignExpr();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop18016:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						assignExpr();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop18016;
					}
					
				} while (true);
				}
			}
			else if ((LA(1)==RPAREN)) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			match(RPAREN);
			parenArgs_AST = (antlr.CommonAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = parenArgs_AST;
	}
	
	public final void atom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST atom_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				antlr.CommonAST tmp7_AST = null;
				tmp7_AST = (antlr.CommonAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(ID);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case INT:
			{
				antlr.CommonAST tmp8_AST = null;
				tmp8_AST = (antlr.CommonAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp8_AST);
				match(INT);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case CHAR_LITERAL:
			{
				antlr.CommonAST tmp9_AST = null;
				tmp9_AST = (antlr.CommonAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(CHAR_LITERAL);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case STRING_LITERAL:
			{
				antlr.CommonAST tmp10_AST = null;
				tmp10_AST = (antlr.CommonAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(STRING_LITERAL);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case LPAREN:
			{
				match(LPAREN);
				assignExpr();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = atom_AST;
	}
	
	
	public static final String[] _tokenNames = {
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
		"WS",
		"ESC",
		"DIGIT"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 1538L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 1554L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 1586L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1650L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 14720L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
