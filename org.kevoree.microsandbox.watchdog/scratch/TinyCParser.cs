// $ANTLR 2.7.2: "tinyc.g" -> "TinyCParser.cs"$

using antlr;

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
	
	class TinyCMain {
		public static void Main(string[] args) {
			try {
				TinyCLexer lexer = new TinyCLexer(new ByteBuffer(Console.OpenStandardInput()));
				TinyCParser parser = new TinyCParser(lexer);
				parser.program();
			} catch(Exception e) {
				Console.Error.WriteLine("exception: "+e);
			}
		}
	}

	public 	class TinyCParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int TK_int = 4;
		public const int TK_char = 5;
		public const int TK_if = 6;
		public const int TK_else = 7;
		public const int TK_while = 8;
		public const int WS = 9;
		public const int SL_COMMENT = 10;
		public const int ML_COMMENT = 11;
		public const int LPAREN = 12;
		public const int RPAREN = 13;
		public const int LCURLY = 14;
		public const int RCURLY = 15;
		public const int STAR = 16;
		public const int PLUS = 17;
		public const int ASSIGN = 18;
		public const int SEMI = 19;
		public const int COMMA = 20;
		public const int CHAR_LITERAL = 21;
		public const int STRING_LITERAL = 22;
		public const int ESC = 23;
		public const int DIGIT = 24;
		public const int INT = 25;
		public const int ID = 26;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected TinyCParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public TinyCParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected TinyCParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public TinyCParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public TinyCParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void program() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID))
					{
						declaration();
					}
					else
					{
						goto _loop17922_breakloop;
					}
					
				}
_loop17922_breakloop:				;
			}    // ( ... )*
			match(Token.EOF_TYPE);
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_0_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void declaration() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			bool synPredMatched17925 = false;
			if (((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID)))
			{
				int _m17925 = mark();
				synPredMatched17925 = true;
				inputState.guessing++;
				try {
					{
						variable();
					}
				}
				catch (RecognitionException)
				{
					synPredMatched17925 = false;
				}
				rewind(_m17925);
				inputState.guessing--;
			}
			if ( synPredMatched17925 )
			{
				variable();
			}
			else if ((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID)) {
				function();
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void variable() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			type();
			declarator();
			match(SEMI);
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void function() //throws RecognitionException, TokenStreamException
{
		
		Token  id = null;
		
		try {      // for error handling
			type();
			id = LT(1);
			match(ID);
			match(LPAREN);
			{
				switch ( LA(1) )
				{
				case TK_int:
				case TK_char:
				case ID:
				{
					formalParameter();
					{    // ( ... )*
						for (;;)
						{
							if ((LA(1)==COMMA))
							{
								match(COMMA);
								formalParameter();
							}
							else
							{
								goto _loop17931_breakloop;
							}
							
						}
_loop17931_breakloop:						;
					}    // ( ... )*
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
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void declarator() //throws RecognitionException, TokenStreamException
{
		
		Token  id = null;
		Token  id2 = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_2_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void type() //throws RecognitionException, TokenStreamException
{
		
		Token  id = null;
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_3_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void formalParameter() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			type();
			declarator();
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_4_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void block() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(LCURLY);
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_5_.member(LA(1))))
					{
						statement();
					}
					else
					{
						goto _loop17937_breakloop;
					}
					
				}
_loop17937_breakloop:				;
			}    // ( ... )*
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void statement() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case TK_if:
			{
				match(TK_if);
				match(LPAREN);
				expr();
				match(RPAREN);
				statement();
				{
					if ((LA(1)==TK_else))
					{
						match(TK_else);
						statement();
					}
					else if ((tokenSet_6_.member(LA(1)))) {
					}
					else
					{
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
				bool synPredMatched17940 = false;
				if (((LA(1)==TK_int||LA(1)==TK_char||LA(1)==ID)))
				{
					int _m17940 = mark();
					synPredMatched17940 = true;
					inputState.guessing++;
					try {
						{
							declaration();
						}
					}
					catch (RecognitionException)
					{
						synPredMatched17940 = false;
					}
					rewind(_m17940);
					inputState.guessing--;
				}
				if ( synPredMatched17940 )
				{
					declaration();
				}
				else if ((tokenSet_7_.member(LA(1)))) {
					expr();
					match(SEMI);
				}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			break; }
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_6_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			assignExpr();
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_8_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void assignExpr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			aexpr();
			{
				switch ( LA(1) )
				{
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
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_8_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void aexpr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			mexpr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==PLUS))
					{
						match(PLUS);
						mexpr();
					}
					else
					{
						goto _loop17947_breakloop;
					}
					
				}
_loop17947_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_9_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void mexpr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			atom();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==STAR))
					{
						match(STAR);
						atom();
					}
					else
					{
						goto _loop17950_breakloop;
					}
					
				}
_loop17950_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_10_);
			}
			else
			{
				throw;
			}
		}
	}
	
	public void atom() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_11_);
			}
			else
			{
				throw;
			}
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
		@"""int""",
		@"""char""",
		@"""if""",
		@"""else""",
		@"""while""",
		@"""WS""",
		@"""SL_COMMENT""",
		@"""ML_COMMENT""",
		@"""'('""",
		@"""')'""",
		@"""LCURLY""",
		@"""RCURLY""",
		@"""STAR""",
		@"""PLUS""",
		@"""ASSIGN""",
		@"""SEMI""",
		@"""COMMA""",
		@"""CHAR_LITERAL""",
		@"""STRING_LITERAL""",
		@"""ESC""",
		@"""DIGIT""",
		@"""INT""",
		@"""an identifier"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 107004402L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { 1581056L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { 67174400L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { 1056768L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { 106971504L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	private static long[] mk_tokenSet_6_()
	{
		long[] data = { 107004400L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_6_ = new BitSet(mk_tokenSet_6_());
	private static long[] mk_tokenSet_7_()
	{
		long[] data = { 106954752L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_7_ = new BitSet(mk_tokenSet_7_());
	private static long[] mk_tokenSet_8_()
	{
		long[] data = { 532480L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_8_ = new BitSet(mk_tokenSet_8_());
	private static long[] mk_tokenSet_9_()
	{
		long[] data = { 794624L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_9_ = new BitSet(mk_tokenSet_9_());
	private static long[] mk_tokenSet_10_()
	{
		long[] data = { 925696L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_10_ = new BitSet(mk_tokenSet_10_());
	private static long[] mk_tokenSet_11_()
	{
		long[] data = { 991232L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_11_ = new BitSet(mk_tokenSet_11_());
	
}
