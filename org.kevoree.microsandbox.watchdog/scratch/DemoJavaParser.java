// $ANTLR 2.7.2: "javaparse.g" -> "DemoJavaParser.java"$

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

public class DemoJavaParser extends antlr.LLkParser       implements DemoJavaParserTokenTypes
 {

protected DemoJavaParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public DemoJavaParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected DemoJavaParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public DemoJavaParser(TokenStream lexer) {
  this(lexer,1);
}

public DemoJavaParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void input() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt19131=0;
			_loop19131:
			do {
				if ((LA(1)==JAVADOC_OPEN||LA(1)==INT)) {
					{
					switch ( LA(1)) {
					case JAVADOC_OPEN:
					{
						javadoc();
						break;
					}
					case INT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(INT);
					match(ID);
					match(SEMI);
				}
				else {
					if ( _cnt19131>=1 ) { break _loop19131; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19131++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
	}
	
	public final void javadoc() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(JAVADOC_OPEN);
			
					DemoJavaDocParser jdocparser = new DemoJavaDocParser(getInputState());
					jdocparser.content();
					
			match(JAVADOC_CLOSE);
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
		"JAVADOC_OPEN",
		"JAVADOC_CLOSE",
		"\"int\"",
		"ID",
		"SEMI",
		"WS"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 64L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
