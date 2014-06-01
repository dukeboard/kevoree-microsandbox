// $ANTLR 2.7.2: "instr.g" -> "InstrParser.cs"$

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
	
	public 	class InstrParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int CALL = 4;
		public const int LBRACE = 5;
		public const int RBRACE = 6;
		public const int TK_if = 7;
		public const int TK_then = 8;
		public const int TK_else = 9;
		public const int ID = 10;
		public const int ASSIGN = 11;
		public const int SEMI = 12;
		public const int PLUS = 13;
		public const int STAR = 14;
		public const int INT = 15;
		public const int LPAREN = 16;
		public const int RPAREN = 17;
		public const int WS = 18;
		public const int SL_COMMENT = 19;
		public const int DIGIT = 20;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
			initializeFactory();
		}
		
		
		protected InstrParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public InstrParser(TokenBuffer tokenBuf) : this(tokenBuf,2)
		{
		}
		
		protected InstrParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public InstrParser(TokenStream lexer) : this(lexer,2)
		{
		}
		
		public InstrParser(ParserSharedInputState state) : base(state,2)
		{
			initialize();
		}
		
	public void slist() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST slist_AST = null;
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22358=0;
			for (;;)
			{
				if ((LA(1)==LBRACE||LA(1)==TK_if||LA(1)==ID))
				{
					stat();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else
				{
					if (_cnt22358 >= 1) { goto _loop22358_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22358++;
			}
_loop22358_breakloop:			;
			}    // ( ... )+
			slist_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_0_);
		}
		returnAST = slist_AST;
	}
	
	public void stat() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stat_AST = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case LBRACE:
			{
				AST tmp1_AST = null;
				tmp1_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp1_AST);
				match(LBRACE);
				{ // ( ... )+
				int _cnt22361=0;
				for (;;)
				{
					if ((LA(1)==LBRACE||LA(1)==TK_if||LA(1)==ID))
					{
						stat();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else
					{
						if (_cnt22361 >= 1) { goto _loop22361_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
					}
					
					_cnt22361++;
				}
_loop22361_breakloop:				;
				}    // ( ... )+
				AST tmp2_AST = null;
				tmp2_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp2_AST);
				match(RBRACE);
				stat_AST = currentAST.root;
				break;
			}
			case TK_if:
			{
				AST tmp3_AST = null;
				tmp3_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp3_AST);
				match(TK_if);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(TK_then);
				stat();
				astFactory.addASTChild(currentAST, returnAST);
				{
					if ((LA(1)==TK_else) && (LA(2)==LBRACE||LA(2)==TK_if||LA(2)==ID))
					{
						AST tmp5_AST = null;
						tmp5_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp5_AST);
						match(TK_else);
						stat();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else if ((tokenSet_1_.member(LA(1))) && (tokenSet_2_.member(LA(2)))) {
					}
					else
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					
				}
				stat_AST = currentAST.root;
				break;
			}
			default:
				if ((LA(1)==ID) && (LA(2)==ASSIGN))
				{
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp6_AST);
					match(ID);
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp7_AST);
					match(ASSIGN);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp8_AST = null;
					tmp8_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp8_AST);
					match(SEMI);
					stat_AST = currentAST.root;
				}
				else if ((LA(1)==ID) && (LA(2)==LPAREN)) {
					call();
					astFactory.addASTChild(currentAST, returnAST);
					stat_AST = currentAST.root;
				}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			break; }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_1_);
		}
		returnAST = stat_AST;
	}
	
	public void expr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_AST = null;
		
		try {      // for error handling
			mexpr();
			astFactory.addASTChild(currentAST, returnAST);
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==PLUS))
					{
						AST tmp9_AST = null;
						tmp9_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp9_AST);
						match(PLUS);
						mexpr();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else
					{
						goto _loop22365_breakloop;
					}
					
				}
_loop22365_breakloop:				;
			}    // ( ... )*
			expr_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
		returnAST = expr_AST;
	}
	
	public void call() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST call_AST = null;
		
		try {      // for error handling
			AST tmp10_AST = null;
			tmp10_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp10_AST);
			match(ID);
			AST tmp11_AST = null;
			tmp11_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp11_AST);
			match(LPAREN);
			{
				switch ( LA(1) )
				{
				case ID:
				case INT:
				{
					expr();
					astFactory.addASTChild(currentAST, returnAST);
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
			AST tmp12_AST = null;
			tmp12_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp12_AST);
			match(RPAREN);
			AST tmp13_AST = null;
			tmp13_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp13_AST);
			match(SEMI);
			call_AST = (AST)currentAST.root;
			call_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CALL,"CALL")).add(call_AST));
			currentAST.root = call_AST;
			if ( (null != call_AST) && (null != call_AST.getFirstChild()) )
				currentAST.child = call_AST.getFirstChild();
			else
				currentAST.child = call_AST;
			currentAST.advanceChildToEnd();
			call_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_1_);
		}
		returnAST = call_AST;
	}
	
	public void mexpr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST mexpr_AST = null;
		
		try {      // for error handling
			atom();
			astFactory.addASTChild(currentAST, returnAST);
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==STAR))
					{
						AST tmp14_AST = null;
						tmp14_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp14_AST);
						match(STAR);
						atom();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else
					{
						goto _loop22368_breakloop;
					}
					
				}
_loop22368_breakloop:				;
			}    // ( ... )*
			mexpr_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_4_);
		}
		returnAST = mexpr_AST;
	}
	
	public void atom() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST atom_AST = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case INT:
			{
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(INT);
				atom_AST = currentAST.root;
				break;
			}
			case ID:
			{
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(ID);
				atom_AST = currentAST.root;
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
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
		returnAST = atom_AST;
	}
	
	private void initializeFactory()
	{
		if (astFactory == null)
		{
			astFactory = new ASTFactory();
		}
		initializeASTFactory( astFactory );
	}
	static public void initializeASTFactory( ASTFactory factory )
	{
		factory.setMaxNodeType(20);
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""CALL""",
		@"""LBRACE""",
		@"""RBRACE""",
		@"""if""",
		@"""then""",
		@"""else""",
		@"""ID""",
		@"""ASSIGN""",
		@"""SEMI""",
		@"""PLUS""",
		@"""STAR""",
		@"""INT""",
		@"""LPAREN""",
		@"""RPAREN""",
		@"""WS""",
		@"""SL_COMMENT""",
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
		long[] data = { 1762L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { 102114L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { 135424L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { 143616L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { 160000L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	
}
