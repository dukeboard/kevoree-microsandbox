// $ANTLR 2.7.2: "calc.g" -> "CalcTreeWalker.cs"$

	// Generate header specific to the tree-parser CSharp file
	using System;
	
	using TreeParser = antlr.TreeParser;
	using Token                    = antlr.Token;
	using AST                      = antlr.collections.AST;
	using RecognitionException     = antlr.RecognitionException;
	using ANTLRException           = antlr.ANTLRException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using BitSet                   = antlr.collections.impl.BitSet;
	using ASTPair                  = antlr.ASTPair;
	using ASTFactory               = antlr.ASTFactory;
	using ASTArray                 = antlr.collections.impl.ASTArray;
	
	
	public 	class CalcTreeWalker : antlr.TreeParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int PLUS = 4;
		public const int SEMI = 5;
		public const int STAR = 6;
		public const int INT = 7;
		public const int WS = 8;
		public const int LPAREN = 9;
		public const int RPAREN = 10;
		public const int DIGIT = 11;
		
		public CalcTreeWalker()
		{
			tokenNames = tokenNames_;
		}
		
	public float  expr(AST _t) //throws RecognitionException
{
		float r;
		
		AST expr_AST_in = (AST)_t;
		AST i = null;
		
			float a,b;
			r=0;
		
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case PLUS:
			{
				AST __t21607 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = retTree_;
				b=expr(_t);
				_t = retTree_;
				_t = __t21607;
				_t = _t.getNextSibling();
				r = a+b;
				break;
			}
			case STAR:
			{
				AST __t21608 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = retTree_;
				b=expr(_t);
				_t = retTree_;
				_t = __t21608;
				_t = _t.getNextSibling();
				r = a*b;
				break;
			}
			case INT:
			{
				i = (AST)_t;
				match(_t,INT);
				_t = _t.getNextSibling();
				r = Convert.ToSingle(i.getText());
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
		return r;
	}
	
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""PLUS""",
		@"""SEMI""",
		@"""STAR""",
		@"""INT""",
		@"""WS""",
		@"""LPAREN""",
		@"""RPAREN""",
		@"""DIGIT"""
	};
	
}

