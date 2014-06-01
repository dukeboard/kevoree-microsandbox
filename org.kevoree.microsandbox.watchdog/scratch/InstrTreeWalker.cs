// $ANTLR 2.7.2: "instr.g" -> "InstrTreeWalker.cs"$

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
	
	
	public 	class InstrTreeWalker : antlr.TreeParser
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
		
		
	/** walk list of hidden tokens in order, printing them out */
	public static void dumpHidden(antlr.CommonHiddenStreamToken t) {
	  for ( ; t!=null ; t=InstrMain.filter.getHiddenAfter(t) ) {
	    Console.Error.Write(t.getText());
	  }
	}

	private void pr(AST p) {
		Console.Out.Write(p.getText());
		dumpHidden(
			((antlr.CommonASTWithHiddenTokens)p).getHiddenAfter()
		);
	}
		public InstrTreeWalker()
		{
			tokenNames = tokenNames_;
		}
		
	public void slist(AST _t) //throws RecognitionException
{
		
		AST slist_AST_in = (AST)_t;
		
		try {      // for error handling
			dumpHidden(InstrMain.filter.getInitialHiddenToken());
			{ // ( ... )+
			int _cnt22400=0;
			for (;;)
			{
				if (_t == null)
					_t = ASTNULL;
				if ((tokenSet_0_.member(_t.Type)))
				{
					stat(_t);
					_t = retTree_;
				}
				else
				{
					if (_cnt22400 >= 1) { goto _loop22400_breakloop; } else { throw new NoViableAltException(_t);; }
				}
				
				_cnt22400++;
			}
_loop22400_breakloop:			;
			}    // ( ... )+
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
	}
	
	public void stat(AST _t) //throws RecognitionException
{
		
		AST stat_AST_in = (AST)_t;
		AST i = null;
		AST t = null;
		AST e = null;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case LBRACE:
			{
				AST __t22402 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,LBRACE);
				_t = _t.getFirstChild();
				pr(tmp17_AST_in);
				{ // ( ... )+
				int _cnt22404=0;
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((tokenSet_0_.member(_t.Type)))
					{
						stat(_t);
						_t = retTree_;
					}
					else
					{
						if (_cnt22404 >= 1) { goto _loop22404_breakloop; } else { throw new NoViableAltException(_t);; }
					}
					
					_cnt22404++;
				}
_loop22404_breakloop:				;
				}    // ( ... )+
				AST tmp18_AST_in = (AST)_t;
				match(_t,RBRACE);
				_t = _t.getNextSibling();
				pr(tmp18_AST_in);
				_t = __t22402;
				_t = _t.getNextSibling();
				break;
			}
			case TK_if:
			{
				AST __t22405 = _t;
				i = (ASTNULL == _t) ? null : (AST)_t;
				match(_t,TK_if);
				_t = _t.getFirstChild();
				pr(i);
				expr(_t);
				_t = retTree_;
				t = (AST)_t;
				match(_t,TK_then);
				_t = _t.getNextSibling();
				pr(t);
				stat(_t);
				_t = retTree_;
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case TK_else:
					{
						e = (AST)_t;
						match(_t,TK_else);
						_t = _t.getNextSibling();
						pr(e);
						stat(_t);
						_t = retTree_;
						break;
					}
					case 3:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					 }
				}
				_t = __t22405;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t22407 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				AST tmp20_AST_in = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				pr(tmp20_AST_in); pr(tmp19_AST_in);
				expr(_t);
				_t = retTree_;
				AST tmp21_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getNextSibling();
				pr(tmp21_AST_in);
				_t = __t22407;
				_t = _t.getNextSibling();
				break;
			}
			case CALL:
			{
				call(_t);
				_t = retTree_;
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
	}
	
	public void expr(AST _t) //throws RecognitionException
{
		
		AST expr_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case PLUS:
			{
				AST __t22409 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				pr(tmp22_AST_in);
				expr(_t);
				_t = retTree_;
				_t = __t22409;
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST __t22410 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				pr(tmp23_AST_in);
				expr(_t);
				_t = retTree_;
				_t = __t22410;
				_t = _t.getNextSibling();
				break;
			}
			case INT:
			{
				AST tmp24_AST_in = (AST)_t;
				match(_t,INT);
				_t = _t.getNextSibling();
				pr(tmp24_AST_in);
				break;
			}
			case ID:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				pr(tmp25_AST_in);
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
	}
	
	public void call(AST _t) //throws RecognitionException
{
		
		AST call_AST_in = (AST)_t;
		
		try {      // for error handling
			
					// add instrumentation about call; manually call rule
					callDumpInstrumentation(call_AST_in);
					
			AST __t22412 = _t;
			AST tmp26_AST_in = (AST)_t;
			match(_t,CALL);
			_t = _t.getFirstChild();
			AST tmp27_AST_in = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			pr(tmp27_AST_in);
			AST tmp28_AST_in = (AST)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			pr(tmp28_AST_in);
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case ID:
				case PLUS:
				case STAR:
				case INT:
				{
					expr(_t);
					_t = retTree_;
					break;
				}
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				 }
			}
			AST tmp29_AST_in = (AST)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			pr(tmp29_AST_in);
			AST tmp30_AST_in = (AST)_t;
			match(_t,SEMI);
			_t = _t.getNextSibling();
			
					  // print SEMI manually; need '}' between it and whitespace
					  Console.Error.Write(tmp30_AST_in.getText());
					  Console.Error.Write("}"); // close {...} of instrumentation
					  dumpHidden(
						((antlr.CommonASTWithHiddenTokens)tmp30_AST_in).getHiddenAfter()
					  );
					
			_t = __t22412;
			_t = _t.getNextSibling();
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
	}
	
/** Dump instrumentation for a call statement.
 *  The reference to rule expr prints out the arg
 *  and then at the end of this rule, we close the
 *  generated called to dbg.invoke().
 */
	public void callDumpInstrumentation(AST _t) //throws RecognitionException
{
		
		AST callDumpInstrumentation_AST_in = (AST)_t;
		AST id = null;
		AST e = null;
		
		try {      // for error handling
			AST __t22415 = _t;
			AST tmp31_AST_in = (AST)_t;
			match(_t,CALL);
			_t = _t.getFirstChild();
			id = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			Console.Error.Write("{dbg.invoke(\""+id.getText()+"\", \"");
			AST tmp32_AST_in = (AST)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case ID:
				case PLUS:
				case STAR:
				case INT:
				{
					e = _t==ASTNULL ? null : (AST)_t;
					expr(_t);
					_t = retTree_;
					break;
				}
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				 }
			}
			AST tmp33_AST_in = (AST)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			AST tmp34_AST_in = (AST)_t;
			match(_t,SEMI);
			_t = _t.getNextSibling();
			Console.Error.Write("\"); ");
			_t = __t22415;
			_t = _t.getNextSibling();
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
		long[] data = { 2224L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
}

