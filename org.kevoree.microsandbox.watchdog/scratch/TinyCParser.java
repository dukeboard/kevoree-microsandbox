// $ANTLR 2.7.2: "tinyc.g" -> "TinyCParser.java"$

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

import java.io.*;

class Main {
	public static void main(String[] args) {
		try {
			TinyCLexer lexer = new TinyCLexer(new DataInputStream(System.in));
			TinyCParser parser = new TinyCParser(lexer);
			parser.program();
		} catch(Exception e) {
			System.err.println("exception: "+e);
		}
	}
}

public class TinyCParser extends antlr.LLkParser       implements TinyCParserTokenTypes
 {

protected TinyCParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public TinyCParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected TinyCParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public TinyCParser(TokenStream lexer) {
  this(lexer,1);
}

public TinyCParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void program() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			_loop20107:
			do {
				if ((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID)) {
					declaration();
				}
				else {
					break _loop20107;
				}
				
			} while (true);
			}
			match(Token.EOF_TYPE);
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
	}
	
	public final void declaration() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			boolean synPredMatched20110 = false;
			if (((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID))) {
				int _m20110 = mark();
				synPredMatched20110 = true;
				inputState.guessing++;
				try {
					{
					variable();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched20110 = false;
				}
				rewind(_m20110);
				inputState.guessing--;
			}
			if ( synPredMatched20110 ) {
				variable();
			}
			else if ((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID)) {
				function();
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
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
	}
	
	public final void variable() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			type();
			declarator();
			match(SEMI);
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
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		
		try {      // for error handling
			type();
			id = LT(1);
			match(ID);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case TK_int:
			case TK_char:
			case ID:
			{
				formalParameter();
				{
				_loop20116:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						formalParameter();
					}
					else {
						break _loop20116;
					}
					
				} while (true);
				}
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
			match(RPAREN);
			block();
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
	}
	
	public final void declarator() throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		Token  id2 = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				id = LT(1);
				match(ID);
				break;
			}
			case STAR:
			{
				match(STAR);
				id2 = LT(1);
				match(ID);
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
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void type() throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_int:
			{
				match(TK_int);
				break;
			}
			case TK_char:
			{
				match(TK_char);
				break;
			}
			case ID:
			{
				id = LT(1);
				match(ID);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
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
	}
	
	public final void formalParameter() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			type();
			declarator();
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
	}
	
	public final void block() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LCURLY);
			{
			_loop20122:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					statement();
				}
				else {
					break _loop20122;
				}
				
			} while (true);
			}
			match(RCURLY);
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
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_if:
			{
				match(TK_if);
				match(LPAREN);
				expr();
				match(RPAREN);
				statement();
				{
				if ((LA(1)==TK_else)) {
					match(TK_else);
					statement();
				}
				else if ((_tokenSet_6.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			case TK_while:
			{
				match(TK_while);
				match(LPAREN);
				expr();
				match(RPAREN);
				statement();
				break;
			}
			case LCURLY:
			{
				block();
				break;
			}
			default:
				boolean synPredMatched20125 = false;
				if (((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID))) {
					int _m20125 = mark();
					synPredMatched20125 = true;
					inputState.guessing++;
					try {
						{
						declaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched20125 = false;
					}
					rewind(_m20125);
					inputState.guessing--;
				}
				if ( synPredMatched20125 ) {
					declaration();
				}
				else if ((_tokenSet_7.member(LA(1)))) {
					expr();
					match(SEMI);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_6);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			assignExpr();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void assignExpr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			aexpr();
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				match(ASSIGN);
				assignExpr();
				break;
			}
			case RPAREN:
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void aexpr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			mexpr();
			{
			_loop20132:
			do {
				if ((LA(1)==PLUS)) {
					match(PLUS);
					mexpr();
				}
				else {
					break _loop20132;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_9);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void mexpr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			atom();
			{
			_loop20135:
			do {
				if ((LA(1)==STAR)) {
					match(STAR);
					atom();
				}
				else {
					break _loop20135;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_10);
			} else {
			  throw ex;
			}
		}
	}
	
	public final void atom() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				match(ID);
				break;
			}
			case INT:
			{
				match(INT);
				break;
			}
			case CHAR_LITERAL:
			{
				match(CHAR_LITERAL);
				break;
			}
			case STRING_LITERAL:
			{
				match(STRING_LITERAL);
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
				consumeUntil(_tokenSet_11);
			} else {
			  throw ex;
			}
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"int\"",
		"\"char\"",
		"\"if\"",
		"\"else\"",
		"\"while\"",
		"WS",
		"SL_COMMENT",
		"ML_COMMENT",
		"'('",
		"')'",
		"LCURLY",
		"RCURLY",
		"STAR",
		"PLUS",
		"ASSIGN",
		"SEMI",
		"COMMA",
		"CHAR_LITERAL",
		"STRING_LITERAL",
		"ESC",
		"DIGIT",
		"INT",
		"an identifier"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 107004402L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 1581056L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 67174400L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1056768L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 106971504L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 107004400L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 106954752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 532480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 794624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 925696L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 991232L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	
	}
