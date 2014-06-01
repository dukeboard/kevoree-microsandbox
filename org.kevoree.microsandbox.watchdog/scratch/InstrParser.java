// $ANTLR 2.7.2: "instr.g" -> "InstrParser.java"$

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

public class InstrParser extends antlr.LLkParser       implements InstrParserTokenTypes
 {

protected InstrParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public InstrParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected InstrParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public InstrParser(TokenStream lexer) {
  this(lexer,2);
}

public InstrParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void slist() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST slist_AST = null;
		
		try {      // for error handling
			{
			int _cnt18740=0;
			_loop18740:
			do {
				if ((LA(1)==LBRACE||LA(1)==TK_if||LA(1)==ID)) {
					stat();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt18740>=1 ) { break _loop18740; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt18740++;
			} while (true);
			}
			slist_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
		returnAST = slist_AST;
	}
	
	public final void stat() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stat_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LBRACE:
			{
				AST tmp1_AST = null;
				tmp1_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp1_AST);
				match(LBRACE);
				{
				int _cnt18743=0;
				_loop18743:
				do {
					if ((LA(1)==LBRACE||LA(1)==TK_if||LA(1)==ID)) {
						stat();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt18743>=1 ) { break _loop18743; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt18743++;
				} while (true);
				}
				AST tmp2_AST = null;
				tmp2_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp2_AST);
				match(RBRACE);
				stat_AST = (AST)currentAST.root;
				break;
			}
			case TK_if:
			{
				AST tmp3_AST = null;
				tmp3_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp3_AST);
				match(TK_if);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(TK_then);
				stat();
				astFactory.addASTChild(currentAST, returnAST);
				{
				if ((LA(1)==TK_else) && (LA(2)==LBRACE||LA(2)==TK_if||LA(2)==ID)) {
					AST tmp5_AST = null;
					tmp5_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp5_AST);
					match(TK_else);
					stat();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_2.member(LA(2)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				stat_AST = (AST)currentAST.root;
				break;
			}
			default:
				if ((LA(1)==ID) && (LA(2)==ASSIGN)) {
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp6_AST);
					match(ID);
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp7_AST);
					match(ASSIGN);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp8_AST = null;
					tmp8_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp8_AST);
					match(SEMI);
					stat_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==ID) && (LA(2)==LPAREN)) {
					call();
					astFactory.addASTChild(currentAST, returnAST);
					stat_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
		returnAST = stat_AST;
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_AST = null;
		
		try {      // for error handling
			mexpr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop18747:
			do {
				if ((LA(1)==PLUS)) {
					AST tmp9_AST = null;
					tmp9_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp9_AST);
					match(PLUS);
					mexpr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop18747;
				}
				
			} while (true);
			}
			expr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_3);
		}
		returnAST = expr_AST;
	}
	
	public final void call() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST call_AST = null;
		
		try {      // for error handling
			AST tmp10_AST = null;
			tmp10_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp10_AST);
			match(ID);
			AST tmp11_AST = null;
			tmp11_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp11_AST);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ID:
			case INT:
			{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp12_AST = null;
			tmp12_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp12_AST);
			match(RPAREN);
			AST tmp13_AST = null;
			tmp13_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp13_AST);
			match(SEMI);
			call_AST = (AST)currentAST.root;
			call_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CALL,"CALL")).add(call_AST));
			currentAST.root = call_AST;
			currentAST.child = call_AST!=null &&call_AST.getFirstChild()!=null ?
				call_AST.getFirstChild() : call_AST;
			currentAST.advanceChildToEnd();
			call_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
		returnAST = call_AST;
	}
	
	public final void mexpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST mexpr_AST = null;
		
		try {      // for error handling
			atom();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop18750:
			do {
				if ((LA(1)==STAR)) {
					AST tmp14_AST = null;
					tmp14_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp14_AST);
					match(STAR);
					atom();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop18750;
				}
				
			} while (true);
			}
			mexpr_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_4);
		}
		returnAST = mexpr_AST;
	}
	
	public final void atom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST atom_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			{
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(INT);
				atom_AST = (AST)currentAST.root;
				break;
			}
			case ID:
			{
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(ID);
				atom_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
		returnAST = atom_AST;
	}
	
	
	public static final String[] _tokenNames = {
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
		"WS",
		"SL_COMMENT",
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
		long[] data = { 1762L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 102114L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 135424L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 143616L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 160000L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
