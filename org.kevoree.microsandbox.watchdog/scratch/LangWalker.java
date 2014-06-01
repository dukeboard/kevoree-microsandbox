// $ANTLR 2.7.2: "treewalk.g" -> "LangWalker.java"$

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


public class LangWalker extends antlr.TreeParser       implements LangParserTokenTypes
 {
public LangWalker() {
	tokenNames = _tokenNames;
}

	public final void block(AST _t) throws RecognitionException {
		
		AST block_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20154 = _t;
			AST tmp14_AST_in = (AST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			{
			int _cnt20156=0;
			_loop20156:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					stat(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt20156>=1 ) { break _loop20156; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt20156++;
			} while (true);
			}
			_t = __t20154;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void stat(AST _t) throws RecognitionException {
		
		AST stat_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TK_if:
			{
				AST __t20158 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,TK_if);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				stat(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case BLOCK:
				case ASSIGN:
				case TK_if:
				case TK_while:
				case EXPR:
				{
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
				_t = __t20158;
				_t = _t.getNextSibling();
				break;
			}
			case TK_while:
			{
				AST __t20160 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,TK_while);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				stat(_t);
				_t = _retTree;
				_t = __t20160;
				_t = _t.getNextSibling();
				break;
			}
			case EXPR:
			{
				expr(_t);
				_t = _retTree;
				break;
			}
			case BLOCK:
			{
				block(_t);
				_t = _retTree;
				break;
			}
			case ASSIGN:
			{
				AST __t20161 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				AST tmp18_AST_in = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				expr(_t);
				_t = _retTree;
				_t = __t20161;
				_t = _t.getNextSibling();
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
		AST a = null;
		AST b = null;
		
		try {      // for error handling
			AST __t20163 = _t;
			AST tmp19_AST_in = (AST)_t;
			match(_t,EXPR);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				a = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				System.out.println("found ID "+a.getText());
				break;
			}
			case INT:
			{
				b = (AST)_t;
				match(_t,INT);
				_t = _t.getNextSibling();
				System.out.println("found INT "+b.getText());
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t20163;
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
		"BLOCK",
		"LCURLY",
		"RCURLY",
		"ID",
		"ASSIGN",
		"SEMI",
		"\"if\"",
		"LPAREN",
		"RPAREN",
		"\"else\"",
		"\"while\"",
		"INT",
		"EXPR",
		"WS",
		"DIGIT"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 83216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	
