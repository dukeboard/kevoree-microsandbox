// $ANTLR 2.7.2: "javadocparse.g" -> "DemoJavaDocParser.cs"$

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
	
	public 	class DemoJavaDocParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int JAVADOC_OPEN = 4;
		public const int JAVADOC_CLOSE = 5;
		public const int PARAM = 6;
		public const int EXCEPTION = 7;
		public const int ID = 8;
		public const int STAR = 9;
		public const int NEWLINE = 10;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected DemoJavaDocParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public DemoJavaDocParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected DemoJavaDocParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public DemoJavaDocParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public DemoJavaDocParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void content() //throws RecognitionException, TokenStreamException
{
		
		Token  p = null;
		Token  e = null;
		
		try {      // for error handling
			{    // ( ... )*
				for (;;)
				{
					switch ( LA(1) )
					{
					case PARAM:
					{
						p = LT(1);
						match(PARAM);
						Console.Out.WriteLine("found: "+p.getText());
						break;
					}
					case EXCEPTION:
					{
						e = LT(1);
						match(EXCEPTION);
						Console.Out.WriteLine("found: "+e.getText());
						break;
					}
					default:
					{
						goto _loop22430_breakloop;
					}
					 }
				}
_loop22430_breakloop:				;
			}    // ( ... )*
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
		@"""JAVADOC_OPEN""",
		@"""JAVADOC_CLOSE""",
		@"""PARAM""",
		@"""EXCEPTION""",
		@"""ID""",
		@"""STAR""",
		@"""NEWLINE"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	
}
