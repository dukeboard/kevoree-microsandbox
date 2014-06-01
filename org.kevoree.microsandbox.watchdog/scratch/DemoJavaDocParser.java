// $ANTLR 2.7.2: "javadocparse.g" -> "DemoJavaDocParser.java"$

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

public class DemoJavaDocParser extends antlr.LLkParser       implements DemoJavaDocParserTokenTypes
 {

protected DemoJavaDocParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public DemoJavaDocParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected DemoJavaDocParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public DemoJavaDocParser(TokenStream lexer) {
  this(lexer,1);
}

public DemoJavaDocParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void content() throws RecognitionException, TokenStreamException {
		
		Token  p = null;
		Token  e = null;
		
		try {      // for error handling
			{
			_loop18812:
			do {
				switch ( LA(1)) {
				case PARAM:
				{
					p = LT(1);
					match(PARAM);
					System.out.println("found: "+p.getText());
					break;
				}
				case EXCEPTION:
				{
					e = LT(1);
					match(EXCEPTION);
					System.out.println("found: "+e.getText());
					break;
				}
				default:
				{
					break _loop18812;
				}
				}
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"JAVADOC_OPEN",
		"JAVADOC_CLOSE",
		"PARAM",
		"EXCEPTION",
		"ID",
		"STAR",
		"NEWLINE"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	
	}
