// $ANTLR 2.7.2: "javaparse.g" -> "DemoJavaParser.cs"$

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
	
	public 	class DemoJavaParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int JAVADOC_OPEN = 4;
		public const int JAVADOC_CLOSE = 5;
		public const int INT = 6;
		public const int ID = 7;
		public const int SEMI = 8;
		public const int WS = 9;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected DemoJavaParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public DemoJavaParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected DemoJavaParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public DemoJavaParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public DemoJavaParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void input() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22749=0;
			for (;;)
			{
				if ((LA(1)==JAVADOC_OPEN||LA(1)==INT))
				{
					{
						switch ( LA(1) )
						{
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
				else
				{
					if (_cnt22749 >= 1) { goto _loop22749_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22749++;
			}
_loop22749_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_0_);
		}
	}
	
	public void javadoc() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(JAVADOC_OPEN);
			
						DemoJavaDocParser jdocparser = new DemoJavaDocParser(getInputState());
						jdocparser.content();
					
			match(JAVADOC_CLOSE);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_1_);
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
		@"""int""",
		@"""ID""",
		@"""SEMI""",
		@"""WS"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 64L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	
}
