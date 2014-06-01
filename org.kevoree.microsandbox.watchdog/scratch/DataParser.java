// $ANTLR 2.7.2: "data.g" -> "DataParser.java"$

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

public class DataParser extends antlr.LLkParser       implements DataParserTokenTypes
 {

protected DataParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public DataParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected DataParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public DataParser(TokenStream lexer) {
  this(lexer,1);
}

public DataParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void file() throws RecognitionException, TokenStreamException {
		
		Token  sh = null;
		Token  st = null;
		
		try {      // for error handling
			{
			int _cnt17994=0;
			_loop17994:
			do {
				switch ( LA(1)) {
				case SHORT:
				{
					sh = LT(1);
					match(SHORT);
					System.out.println(sh.getText());
					break;
				}
				case STRING:
				{
					st = LT(1);
					match(STRING);
					System.out.println("\""+st.getText()+"\"");
					break;
				}
				default:
				{
					if ( _cnt17994>=1 ) { break _loop17994; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				}
				_cnt17994++;
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
		"SHORT",
		"STRING"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	
	}
