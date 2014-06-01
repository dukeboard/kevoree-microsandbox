// $ANTLR 2.7.2: "data.g" -> "DataParser.cs"$

	// Generate the header common to all output files.
	using System;
	
	using TokenBuffer              = antlr.TokenBuffer;
	using TokenStreamException     = antlr.TokenStreamException;
	using TokenStreamIOException   = antlr.TokenStreamIOException;
	using ANTLRException           = antlr.ANTLRException;
	using LLkParser = antlr.LLkParser;
	using Token                    = antlr.Token;
	using TokenStream              = antlr.TokenStream;
	using RecognitionException     = antlr.RecognitionException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using ParserSharedInputState   = antlr.ParserSharedInputState;
	using BitSet                   = antlr.collections.impl.BitSet;
	
	public 	class DataParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int SHORT = 4;
		public const int STRING = 5;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected DataParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public DataParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected DataParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public DataParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public DataParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void file() //throws RecognitionException, TokenStreamException
{
		
		Token  sh = null;
		Token  st = null;
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt21612=0;
			for (;;)
			{
				switch ( LA(1) )
				{
				case SHORT:
				{
					sh = LT(1);
					match(SHORT);
					Console.Out.WriteLine(sh.getText());
					break;
				}
				case STRING:
				{
					st = LT(1);
					match(STRING);
					Console.Out.WriteLine(@""""+st.getText()+@"""");
					break;
				}
				default:
				{
					if (_cnt21612 >= 1) { goto _loop21612_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				break; }
				_cnt21612++;
			}
_loop21612_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_0_);
		}
	}
	
	private void initializeFactory()
	{
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""SHORT""",
		@"""STRING"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	
}
