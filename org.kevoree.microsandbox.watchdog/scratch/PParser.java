// $ANTLR 2.7.2: "P.g" -> "PParser.java"$

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

public class PParser extends antlr.LLkParser       implements PParserTokenTypes
 {

	public void traceOut(String rname) throws TokenStreamException  {
		System.out.println("exit "+rname+"; LT(1)="+LT(1));
	}
	public void traceIn(String rname) throws TokenStreamException  {
		System.out.println("enter "+rname+"; LT(1)="+LT(1));
	}
/*
	public void consume() throws IOException {
		try {
			System.out.println(LT(1));
		}
		catch (IOException ignore) {}
		super.consume();
	}
*/

protected PParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public PParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected PParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public PParser(TokenStream lexer) {
  this(lexer,1);
}

public PParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void startRule() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt19615=0;
			_loop19615:
			do {
				if ((LA(1)==INT)) {
					decl();
				}
				else {
					if ( _cnt19615>=1 ) { break _loop19615; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19615++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
	}
	
	public final void decl() throws RecognitionException, TokenStreamException {
		
		Token  a = null;
		Token  b = null;
		
		try {      // for error handling
			match(INT);
			a = LT(1);
			match(ID);
			System.out.println("decl "+a.getText());
			{
			_loop19618:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					b = LT(1);
					match(ID);
					System.out.println("decl "+b.getText());
				}
				else {
					break _loop19618;
				}
				
			} while (true);
			}
			match(SEMI);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"int\"",
		"ID",
		"COMMA",
		"SEMI",
		"INCLUDE",
		"STRING",
		"WS"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 18L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
