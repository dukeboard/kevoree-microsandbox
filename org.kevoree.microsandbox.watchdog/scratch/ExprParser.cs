// $ANTLR 2.7.2: "expr.g" -> "ExprParser.cs"$

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
	using AST                      = antlr.collections.AST;
	using ASTPair                  = antlr.ASTPair;
	using ASTFactory               = antlr.ASTFactory;
	using ASTArray                 = antlr.collections.impl.ASTArray;
	
	public 	class ExprParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int ASSIGN = 4;
		public const int PLUS_MINUS = 5;
		public const int MULT_DIV = 6;
		public const int ID = 7;
		public const int LPAREN = 8;
		public const int COMMA = 9;
		public const int RPAREN = 10;
		public const int INT = 11;
		public const int CHAR_LITERAL = 12;
		public const int STRING_LITERAL = 13;
		public const int WS = 14;
		public const int ESC = 15;
		public const int DIGIT = 16;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
			initializeFactory();
		}
		
		
		protected ExprParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public ExprParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected ExprParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public ExprParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public ExprParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void expr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST expr_AST = null;
		
		try {      // for error handling
			assignExpr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, (AST)returnAST);
			}
			match(Token.EOF_TYPE);
			expr_AST = (antlr.CommonAST)currentAST.root;
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
		returnAST = expr_AST;
	}
	
	public void assignExpr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST assignExpr_AST = null;
		
		try {      // for error handling
			addExpr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, (AST)returnAST);
			}
			{
				if ((LA(1)==ASSIGN))
				{
					antlr.CommonAST tmp2_AST = null;
					tmp2_AST = (antlr.CommonAST) astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, (AST)tmp2_AST);
					match(ASSIGN);
					assignExpr();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, (AST)returnAST);
					}
				}
				else if ((LA(1)==EOF||LA(1)==COMMA||LA(1)==RPAREN)) {
				}
				else
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			assignExpr_AST = (antlr.CommonAST)currentAST.root;
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
		returnAST = assignExpr_AST;
	}
	
	public void addExpr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST addExpr_AST = null;
		Token  pm = null;
		antlr.CommonAST pm_AST = null;
		antlr.CommonAST me_AST = null;
		
		try {      // for error handling
			multExpr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, (AST)returnAST);
			}
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==PLUS_MINUS))
					{
						try        // for error handling
						{
							pm = LT(1);
							pm_AST = (antlr.CommonAST) astFactory.create(pm);
							astFactory.makeASTRoot(currentAST, (AST)pm_AST);
							match(PLUS_MINUS);
							multExpr();
							if (0 == inputState.guessing)
							{
								me_AST = (antlr.CommonAST)returnAST;
								astFactory.addASTChild(currentAST, (AST)returnAST);
							}
						}
						catch ( RecognitionException ex )
						{
							if (0 == inputState.guessing)
							{
								
													Console.Out.WriteLine("Caught error in addExpr");
													reportError(ex.Message); 
												
							}
							else
							{
								throw;
							}
						}
					}
					else
					{
						goto _loop21623_breakloop;
					}
					
				}
_loop21623_breakloop:				;
			}    // ( ... )*
			addExpr_AST = (antlr.CommonAST)currentAST.root;
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
		returnAST = addExpr_AST;
	}
	
	public void multExpr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST multExpr_AST = null;
		
		try {      // for error handling
			postfixExpr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, (AST)returnAST);
			}
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==MULT_DIV))
					{
						antlr.CommonAST tmp3_AST = null;
						tmp3_AST = (antlr.CommonAST) astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, (AST)tmp3_AST);
						match(MULT_DIV);
						postfixExpr();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, (AST)returnAST);
						}
					}
					else
					{
						goto _loop21626_breakloop;
					}
					
				}
_loop21626_breakloop:				;
			}    // ( ... )*
			multExpr_AST = (antlr.CommonAST)currentAST.root;
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
		returnAST = multExpr_AST;
	}
	
	public void postfixExpr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST postfixExpr_AST = null;
		Token  id = null;
		antlr.CommonAST id_AST = null;
		Token  id2 = null;
		antlr.CommonAST id2_AST = null;
		
		try {      // for error handling
			bool synPredMatched21629 = false;
			if (((LA(1)==ID)))
			{
				int _m21629 = mark();
				synPredMatched21629 = true;
				inputState.guessing++;
				try {
					{
						match(ID);
						match(LPAREN);
					}
				}
				catch (RecognitionException)
				{
					synPredMatched21629 = false;
				}
				rewind(_m21629);
				inputState.guessing--;
			}
			if ( synPredMatched21629 )
			{
				id2 = LT(1);
				id2_AST = (antlr.CommonAST) astFactory.create(id2);
				astFactory.makeASTRoot(currentAST, (AST)id2_AST);
				match(ID);
				{
					if ((LA(1)==LPAREN))
					{
						parenArgs();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, (AST)returnAST);
						}
					}
					else if ((tokenSet_4_.member(LA(1)))) {
					}
					else
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					
				}
				postfixExpr_AST = (antlr.CommonAST)currentAST.root;
			}
			else if ((tokenSet_5_.member(LA(1)))) {
				atom();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, (AST)returnAST);
				}
				postfixExpr_AST = (antlr.CommonAST)currentAST.root;
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
				consumeUntil(tokenSet_4_);
			}
			else
			{
				throw;
			}
		}
		returnAST = postfixExpr_AST;
	}
	
	public void parenArgs() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST parenArgs_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			{
				if ((tokenSet_5_.member(LA(1))))
				{
					assignExpr();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, (AST)returnAST);
					}
					{    // ( ... )*
						for (;;)
						{
							if ((LA(1)==COMMA))
							{
								match(COMMA);
								assignExpr();
								if (0 == inputState.guessing)
								{
									astFactory.addASTChild(currentAST, (AST)returnAST);
								}
							}
							else
							{
								goto _loop21634_breakloop;
							}
							
						}
_loop21634_breakloop:						;
					}    // ( ... )*
				}
				else if ((LA(1)==RPAREN)) {
				}
				else
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			match(RPAREN);
			parenArgs_AST = (antlr.CommonAST)currentAST.root;
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
		returnAST = parenArgs_AST;
	}
	
	public void atom() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		antlr.CommonAST atom_AST = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case ID:
			{
				antlr.CommonAST tmp7_AST = null;
				tmp7_AST = (antlr.CommonAST) astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, (AST)tmp7_AST);
				match(ID);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case INT:
			{
				antlr.CommonAST tmp8_AST = null;
				tmp8_AST = (antlr.CommonAST) astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, (AST)tmp8_AST);
				match(INT);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case CHAR_LITERAL:
			{
				antlr.CommonAST tmp9_AST = null;
				tmp9_AST = (antlr.CommonAST) astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, (AST)tmp9_AST);
				match(CHAR_LITERAL);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case STRING_LITERAL:
			{
				antlr.CommonAST tmp10_AST = null;
				tmp10_AST = (antlr.CommonAST) astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, (AST)tmp10_AST);
				match(STRING_LITERAL);
				atom_AST = (antlr.CommonAST)currentAST.root;
				break;
			}
			case LPAREN:
			{
				match(LPAREN);
				assignExpr();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, (AST)returnAST);
				}
				match(RPAREN);
				atom_AST = (antlr.CommonAST)currentAST.root;
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
				consumeUntil(tokenSet_4_);
			}
			else
			{
				throw;
			}
		}
		returnAST = atom_AST;
	}
	
	public new antlr.CommonAST getAST()
	{
		return (antlr.CommonAST) returnAST;
	}
	
	private void initializeFactory()
	{
		if (astFactory == null)
		{
			astFactory = new ASTFactory("antlr.CommonAST");
		}
		initializeASTFactory( astFactory );
	}
	static public void initializeASTFactory( ASTFactory factory )
	{
		factory.setMaxNodeType(16);
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""ASSIGN""",
		@"""PLUS_MINUS""",
		@"""MULT_DIV""",
		@"""ID""",
		@"""LPAREN""",
		@"""COMMA""",
		@"""RPAREN""",
		@"""INT""",
		@"""CHAR_LITERAL""",
		@"""STRING_LITERAL""",
		@"""WS""",
		@"""ESC""",
		@"""DIGIT"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 1538L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { 1554L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { 1586L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { 1650L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { 14720L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	
}
