// $ANTLR 2.7.2: "instr.g" -> "InstrTreeWalker.java"$

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class InstrTreeWalker extends antlr.TreeParser       implements InstrParserTokenTypes
 {

	/** walk list of hidden tokens in order, printing them out */
	public static void dumpHidden(antlr.CommonHiddenStreamToken t) {
	  for ( ; t!=null ; t=InstrMain.filter.getHiddenAfter(t) ) {
	    System.out.print(t.getText());
	  }
	}

	private void pr(AST p) {
		System.out.print(p.getText());
		dumpHidden(
			((antlr.CommonASTWithHiddenTokens)p).getHiddenAfter()
		);
	}
public InstrTreeWalker() {
	tokenNames = _tokenNames;
}

	public final void slist(AST _t) throws RecognitionException {
		
		AST slist_AST_in = (AST)_t;
		
		try {      // for error handling
			dumpHidden(InstrMain.filter.getInitialHiddenToken());
			{
			int _cnt18782=0;
			_loop18782:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					stat(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt18782>=1 ) { break _loop18782; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt18782++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void stat(AST _t) throws RecognitionException {
		
		AST stat_AST_in = (AST)_t;
		AST i = null;
		AST t = null;
		AST e = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LBRACE:
			{
				AST __t18784 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,LBRACE);
				_t = _t.getFirstChild();
				pr(tmp17_AST_in);
				{
				int _cnt18786=0;
				_loop18786:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						stat(_t);
						_t = _retTree;
					}
					else {
						if ( _cnt18786>=1 ) { break _loop18786; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt18786++;
				} while (true);
				}
				AST tmp18_AST_in = (AST)_t;
				match(_t,RBRACE);
				_t = _t.getNextSibling();
				pr(tmp18_AST_in);
				_t = __t18784;
				_t = _t.getNextSibling();
				break;
			}
			case TK_if:
			{
				AST __t18787 = _t;
				i = _t==ASTNULL ? null :(AST)_t;
				match(_t,TK_if);
				_t = _t.getFirstChild();
				pr(i);
				expr(_t);
				_t = _retTree;
				t = (AST)_t;
				match(_t,TK_then);
				_t = _t.getNextSibling();
				pr(t);
				stat(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TK_else:
				{
					e = (AST)_t;
					match(_t,TK_else);
					_t = _t.getNextSibling();
					pr(e);
					stat(_t);
					_t = _retTree;
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
				_t = __t18787;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t18789 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				AST tmp20_AST_in = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				pr(tmp20_AST_in); pr(tmp19_AST_in);
				expr(_t);
				_t = _retTree;
				AST tmp21_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getNextSibling();
				pr(tmp21_AST_in);
				_t = __t18789;
				_t = _t.getNextSibling();
				break;
			}
			case CALL:
			{
				call(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void expr(AST _t) throws RecognitionException {
		
		AST expr_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PLUS:
			{
				AST __t18791 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				pr(tmp22_AST_in);
				expr(_t);
				_t = _retTree;
				_t = __t18791;
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST __t18792 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				pr(tmp23_AST_in);
				expr(_t);
				_t = _retTree;
				_t = __t18792;
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
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void call(AST _t) throws RecognitionException {
		
		AST call_AST_in = (AST)_t;
		
		try {      // for error handling
			
					// add instrumentation about call; manually call rule
					callDumpInstrumentation(call_AST_in);
					
			AST __t18794 = _t;
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
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			case PLUS:
			case STAR:
			case INT:
			{
				expr(_t);
				_t = _retTree;
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
					  System.out.print(tmp30_AST_in.getText());
					  System.out.print("}"); // close {...} of instrumentation
					  dumpHidden(
						((antlr.CommonASTWithHiddenTokens)tmp30_AST_in).getHiddenAfter()
					  );
					
			_t = __t18794;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
/** Dump instrumentation for a call statement.
 *  The reference to rule expr prints out the arg
 *  and then at the end of this rule, we close the
 *  generated called to dbg.invoke().
 */
	public final void callDumpInstrumentation(AST _t) throws RecognitionException {
		
		AST callDumpInstrumentation_AST_in = (AST)_t;
		AST id = null;
		AST e = null;
		
		try {      // for error handling
			AST __t18797 = _t;
			AST tmp31_AST_in = (AST)_t;
			match(_t,CALL);
			_t = _t.getFirstChild();
			id = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			System.out.print("{dbg.invoke(\""+id.getText()+"\", \"");
			AST tmp32_AST_in = (AST)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			case PLUS:
			case STAR:
			case INT:
			{
				e = _t==ASTNULL ? null : (AST)_t;
				expr(_t);
				_t = _retTree;
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
			System.out.print("\"); ");
			_t = __t18797;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"CALL",
		"LBRACE",
		"RBRACE",
		"\"if\"",
		"\"then\"",
		"\"else\"",
		"ID",
		"ASSIGN",
		"SEMI",
		"PLUS",
		"STAR",
		"INT",
		"LPAREN",
		"RPAREN",
		"WS",
		"SL_COMMENT",
		"DIGIT"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2224L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	
