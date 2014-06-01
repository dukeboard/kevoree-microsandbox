// $ANTLR 2.7.2: "TinyBasic.g" -> "TinyBasicLexer.java"$

	package tinybasic;
	import java.util.*;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class TinyBasicLexer extends antlr.CharScanner implements TinyBasicLexerTokenTypes, TokenStream
 {
public TinyBasicLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public TinyBasicLexer(Reader in) {
	this(new CharBuffer(in));
}
public TinyBasicLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public TinyBasicLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("metafileoff", this), new Integer(137));
	literals.put(new ANTLRHashString("zoom", this), new Integer(149));
	literals.put(new ANTLRHashString("ival$", this), new Integer(225));
	literals.put(new ANTLRHashString("exp", this), new Integer(192));
	literals.put(new ANTLRHashString("srq", this), new Integer(159));
	literals.put(new ANTLRHashString("disable", this), new Integer(157));
	literals.put(new ANTLRHashString("time", this), new Integer(211));
	literals.put(new ANTLRHashString("call", this), new Integer(99));
	literals.put(new ANTLRHashString("case", this), new Integer(77));
	literals.put(new ANTLRHashString("option", this), new Integer(91));
	literals.put(new ANTLRHashString("next", this), new Integer(72));
	literals.put(new ANTLRHashString("rectangle", this), new Integer(144));
	literals.put(new ANTLRHashString("dround$", this), new Integer(221));
	literals.put(new ANTLRHashString("endif", this), new Integer(67));
	literals.put(new ANTLRHashString("end", this), new Integer(54));
	literals.put(new ANTLRHashString("abort", this), new Integer(162));
	literals.put(new ANTLRHashString("errl", this), new Integer(190));
	literals.put(new ANTLRHashString("abs", this), new Integer(184));
	literals.put(new ANTLRHashString("tab", this), new Integer(103));
	literals.put(new ANTLRHashString("circle", this), new Integer(134));
	literals.put(new ANTLRHashString("unzoom", this), new Integer(150));
	literals.put(new ANTLRHashString("binary", this), new Integer(109));
	literals.put(new ANTLRHashString("tan", this), new Integer(210));
	literals.put(new ANTLRHashString("then", this), new Integer(64));
	literals.put(new ANTLRHashString("program", this), new Integer(53));
	literals.put(new ANTLRHashString("loc", this), new Integer(125));
	literals.put(new ANTLRHashString("dround", this), new Integer(189));
	literals.put(new ANTLRHashString("picture", this), new Integer(142));
	literals.put(new ANTLRHashString("select", this), new Integer(76));
	literals.put(new ANTLRHashString("until", this), new Integer(74));
	literals.put(new ANTLRHashString("print", this), new Integer(120));
	literals.put(new ANTLRHashString("to", this), new Integer(70));
	literals.put(new ANTLRHashString("and", this), new Integer(177));
	literals.put(new ANTLRHashString("not", this), new Integer(178));
	literals.put(new ANTLRHashString("return", this), new Integer(87));
	literals.put(new ANTLRHashString("pen", this), new Integer(141));
	literals.put(new ANTLRHashString("using", this), new Integer(126));
	literals.put(new ANTLRHashString("pause", this), new Integer(95));
	literals.put(new ANTLRHashString("endwhen", this), new Integer(169));
	literals.put(new ANTLRHashString("discard", this), new Integer(161));
	literals.put(new ANTLRHashString("sequential", this), new Integer(116));
	literals.put(new ANTLRHashString("mod", this), new Integer(234));
	literals.put(new ANTLRHashString("andb", this), new Integer(214));
	literals.put(new ANTLRHashString("open", this), new Integer(110));
	literals.put(new ANTLRHashString("output", this), new Integer(112));
	literals.put(new ANTLRHashString("retry", this), new Integer(163));
	literals.put(new ANTLRHashString("when", this), new Integer(166));
	literals.put(new ANTLRHashString("date$", this), new Integer(220));
	literals.put(new ANTLRHashString("base", this), new Integer(92));
	literals.put(new ANTLRHashString("chr$", this), new Integer(219));
	literals.put(new ANTLRHashString("exit", this), new Integer(88));
	literals.put(new ANTLRHashString("atn", this), new Integer(187));
	literals.put(new ANTLRHashString("do", this), new Integer(73));
	literals.put(new ANTLRHashString("event", this), new Integer(156));
	literals.put(new ANTLRHashString("len", this), new Integer(198));
	literals.put(new ANTLRHashString("function", this), new Integer(56));
	literals.put(new ANTLRHashString("organization", this), new Integer(115));
	literals.put(new ANTLRHashString("orb", this), new Integer(215));
	literals.put(new ANTLRHashString("timer", this), new Integer(124));
	literals.put(new ANTLRHashString("with", this), new Integer(84));
	literals.put(new ANTLRHashString("out", this), new Integer(94));
	literals.put(new ANTLRHashString("@", this), new Integer(132));
	literals.put(new ANTLRHashString("library", this), new Integer(78));
	literals.put(new ANTLRHashString("set", this), new Integer(123));
	literals.put(new ANTLRHashString("redim", this), new Integer(96));
	literals.put(new ANTLRHashString("beep", this), new Integer(82));
	literals.put(new ANTLRHashString("elseif", this), new Integer(66));
	literals.put(new ANTLRHashString("global", this), new Integer(81));
	literals.put(new ANTLRHashString("clear", this), new Integer(135));
	literals.put(new ANTLRHashString("screen", this), new Integer(145));
	literals.put(new ANTLRHashString("sqr", this), new Integer(209));
	literals.put(new ANTLRHashString("input", this), new Integer(108));
	literals.put(new ANTLRHashString("fract", this), new Integer(193));
	literals.put(new ANTLRHashString("recsize", this), new Integer(119));
	literals.put(new ANTLRHashString("poke", this), new Integer(97));
	literals.put(new ANTLRHashString("close", this), new Integer(104));
	literals.put(new ANTLRHashString("ival", this), new Integer(197));
	literals.put(new ANTLRHashString("gpib", this), new Integer(160));
	literals.put(new ANTLRHashString("margin", this), new Integer(127));
	literals.put(new ANTLRHashString("or", this), new Integer(176));
	literals.put(new ANTLRHashString("outin", this), new Integer(113));
	literals.put(new ANTLRHashString("access", this), new Integer(111));
	literals.put(new ANTLRHashString("val$", this), new Integer(230));
	literals.put(new ANTLRHashString("if", this), new Integer(63));
	literals.put(new ANTLRHashString("record", this), new Integer(130));
	literals.put(new ANTLRHashString("min", this), new Integer(202));
	literals.put(new ANTLRHashString("xor", this), new Integer(175));
	literals.put(new ANTLRHashString("metafileon", this), new Integer(136));
	literals.put(new ANTLRHashString("by", this), new Integer(71));
	literals.put(new ANTLRHashString("address", this), new Integer(129));
	literals.put(new ANTLRHashString("font", this), new Integer(140));
	literals.put(new ANTLRHashString("data", this), new Integer(106));
	literals.put(new ANTLRHashString("normal", this), new Integer(146));
	literals.put(new ANTLRHashString("randomize", this), new Integer(98));
	literals.put(new ANTLRHashString("brush", this), new Integer(133));
	literals.put(new ANTLRHashString("enter", this), new Integer(153));
	literals.put(new ANTLRHashString("upc$", this), new Integer(229));
	literals.put(new ANTLRHashString("goto", this), new Integer(86));
	literals.put(new ANTLRHashString("int", this), new Integer(196));
	literals.put(new ANTLRHashString("for", this), new Integer(68));
	literals.put(new ANTLRHashString("ubound", this), new Integer(212));
	literals.put(new ANTLRHashString("ellipse", this), new Integer(138));
	literals.put(new ANTLRHashString("get_event", this), new Integer(194));
	literals.put(new ANTLRHashString("dim", this), new Integer(80));
	literals.put(new ANTLRHashString("lwc$", this), new Integer(226));
	literals.put(new ANTLRHashString("loop", this), new Integer(75));
	literals.put(new ANTLRHashString("time$", this), new Integer(228));
	literals.put(new ANTLRHashString("restore", this), new Integer(122));
	literals.put(new ANTLRHashString("notb", this), new Integer(216));
	literals.put(new ANTLRHashString("condensed", this), new Integer(147));
	literals.put(new ANTLRHashString("sub", this), new Integer(55));
	literals.put(new ANTLRHashString("pi", this), new Integer(204));
	literals.put(new ANTLRHashString("val", this), new Integer(213));
	literals.put(new ANTLRHashString("asc", this), new Integer(186));
	literals.put(new ANTLRHashString("inchr$", this), new Integer(224));
	literals.put(new ANTLRHashString("gosub", this), new Integer(85));
	literals.put(new ANTLRHashString("errn$", this), new Integer(223));
	literals.put(new ANTLRHashString("instr", this), new Integer(195));
	literals.put(new ANTLRHashString("line", this), new Integer(152));
	literals.put(new ANTLRHashString("errl$", this), new Integer(222));
	literals.put(new ANTLRHashString("stop", this), new Integer(165));
	literals.put(new ANTLRHashString("continue", this), new Integer(164));
	literals.put(new ANTLRHashString("max", this), new Integer(201));
	literals.put(new ANTLRHashString("random", this), new Integer(117));
	literals.put(new ANTLRHashString("rpt$", this), new Integer(227));
	literals.put(new ANTLRHashString("shiftb", this), new Integer(217));
	literals.put(new ANTLRHashString("on", this), new Integer(90));
	literals.put(new ANTLRHashString("log", this), new Integer(200));
	literals.put(new ANTLRHashString("sin", this), new Integer(208));
	literals.put(new ANTLRHashString("zonewidth", this), new Integer(128));
	literals.put(new ANTLRHashString("signed", this), new Integer(207));
	literals.put(new ANTLRHashString("prompt", this), new Integer(131));
	literals.put(new ANTLRHashString("lgt", this), new Integer(199));
	literals.put(new ANTLRHashString("else", this), new Integer(65));
	literals.put(new ANTLRHashString("sgn", this), new Integer(206));
	literals.put(new ANTLRHashString("in", this), new Integer(167));
	literals.put(new ANTLRHashString("let", this), new Integer(89));
	literals.put(new ANTLRHashString("peek", this), new Integer(203));
	literals.put(new ANTLRHashString("rnd", this), new Integer(205));
	literals.put(new ANTLRHashString("cause", this), new Integer(154));
	literals.put(new ANTLRHashString("xorb", this), new Integer(218));
	literals.put(new ANTLRHashString("use", this), new Integer(168));
	literals.put(new ANTLRHashString("cos", this), new Integer(188));
	literals.put(new ANTLRHashString("enable", this), new Integer(158));
	literals.put(new ANTLRHashString("read", this), new Integer(121));
	literals.put(new ANTLRHashString("errn", this), new Integer(191));
	literals.put(new ANTLRHashString("acos", this), new Integer(185));
	literals.put(new ANTLRHashString("display", this), new Integer(148));
	literals.put(new ANTLRHashString("deletefile", this), new Integer(107));
	literals.put(new ANTLRHashString("div", this), new Integer(233));
	literals.put(new ANTLRHashString("close_basic", this), new Integer(151));
	literals.put(new ANTLRHashString("chain", this), new Integer(83));
	literals.put(new ANTLRHashString("polyline", this), new Integer(143));
	literals.put(new ANTLRHashString("error", this), new Integer(155));
	literals.put(new ANTLRHashString("stream", this), new Integer(118));
	literals.put(new ANTLRHashString("append", this), new Integer(114));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '(':
				{
					mLPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mRPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mLBRACK(true);
					theRetToken=_returnToken;
					break;
				}
				case ']':
				{
					mRBRACK(true);
					theRetToken=_returnToken;
					break;
				}
				case ':':
				{
					mCOLON(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mEQ(true);
					theRetToken=_returnToken;
					break;
				}
				case '/':
				{
					mSLASH(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mPLUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '-':
				{
					mMINUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mSTAR(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case '#':
				{
					mPOUND(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\u000c':  case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				case '\n':  case '\r':
				{
					mEOL(true);
					theRetToken=_returnToken;
					break;
				}
				case '!':
				{
					mSL_COMMENT(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mCHAR_LITERAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mSTR_CONST(true);
					theRetToken=_returnToken;
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					mIDENT(true);
					theRetToken=_returnToken;
					break;
				}
				case '.':  case '0':  case '1':  case '2':
				case '3':  case '4':  case '5':  case '6':
				case '7':  case '8':  case '9':
				{
					mINT_CONST(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='<') && (LA(2)=='>')) {
						mNE_COMP(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='=')) {
						mGE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='=')) {
						mLE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (LA(2)=='b')) {
						mBINARY_INTEGER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (LA(2)=='o')) {
						mOCTAL_INTEGER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (LA(2)=='h')) {
						mHEXADECIMAL_INTEGER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='&') && (true)) {
						mAMPERSAND(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mLT(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mAMPERSAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMPERSAND;
		int _saveIndex;
		
		match('&');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACK;
		int _saveIndex;
		
		match('[');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACK;
		int _saveIndex;
		
		match(']');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		int _saveIndex;
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQ;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNE_COMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NE_COMP;
		int _saveIndex;
		
		match("<>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSLASH(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SLASH;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GE;
		int _saveIndex;
		
		match(">=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GT;
		int _saveIndex;
		
		match(">");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LE;
		int _saveIndex;
		
		match("<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LT;
		int _saveIndex;
		
		match('<');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPOUND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = POUND;
		int _saveIndex;
		
		match('#');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBINARY_INTEGER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BINARY_INTEGER;
		int _saveIndex;
		
		match("&b");
		{
		int _cnt19931=0;
		_loop19931:
		do {
			switch ( LA(1)) {
			case '0':
			{
				match('0');
				break;
			}
			case '1':
			{
				match('1');
				break;
			}
			default:
			{
				if ( _cnt19931>=1 ) { break _loop19931; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt19931++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOCTAL_INTEGER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OCTAL_INTEGER;
		int _saveIndex;
		
		match("&o");
		{
		int _cnt19934=0;
		_loop19934:
		do {
			if (((LA(1) >= '0' && LA(1) <= '7'))) {
				matchRange('0','7');
			}
			else {
				if ( _cnt19934>=1 ) { break _loop19934; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt19934++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mHEXADECIMAL_INTEGER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEXADECIMAL_INTEGER;
		int _saveIndex;
		
		match("&h");
		{
		int _cnt19937=0;
		_loop19937:
		do {
			switch ( LA(1)) {
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':
			{
				matchRange('a','f');
				break;
			}
			default:
			{
				if ( _cnt19937>=1 ) { break _loop19937; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt19937++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\u000c':
		{
			match('\f');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEOL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EOL;
		int _saveIndex;
		
		{
		if ((LA(1)=='\r') && (LA(2)=='\n')) {
			match("\r\n");
		}
		else if ((LA(1)=='\r') && (true)) {
			match('\r');
		}
		else if ((LA(1)=='\n')) {
			match('\n');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( inputState.guessing==0 ) {
			newline();
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;
		
		match('!');
		{
		_loop19945:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				{
				match(_tokenSet_0);
				}
			}
			else {
				break _loop19945;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
						_ttype = Token.SKIP;
						//newline();
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHAR_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHAR_LITERAL;
		int _saveIndex;
		
		match('\'');
		{
		boolean synPredMatched19949 = false;
		if (((LA(1)=='<'))) {
			int _m19949 = mark();
			synPredMatched19949 = true;
			inputState.guessing++;
			try {
				{
				mESCc(false);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19949 = false;
			}
			rewind(_m19949);
			inputState.guessing--;
		}
		if ( synPredMatched19949 ) {
			mESCc(false);
		}
		else if ((_tokenSet_1.member(LA(1)))) {
			matchNot('\'');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESCc(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESCc;
		int _saveIndex;
		
		match('<');
		{
		int _cnt19960=0;
		_loop19960:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt19960>=1 ) { break _loop19960; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt19960++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTR_CONST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STR_CONST;
		int _saveIndex;
		
		_saveIndex=text.length();
		match('"');
		text.setLength(_saveIndex);
		{
		_loop19957:
		do {
			boolean synPredMatched19953 = false;
			if (((LA(1)=='<') && (LA(2)=='<') && ((LA(3) >= '0' && LA(3) <= '9')) && (_tokenSet_2.member(LA(4))) && (_tokenSet_2.member(LA(5))) && ((LA(6) >= '\u0003' && LA(6) <= '\u00ff')))) {
				int _m19953 = mark();
				synPredMatched19953 = true;
				inputState.guessing++;
				try {
					{
					mESCs(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched19953 = false;
				}
				rewind(_m19953);
				inputState.guessing--;
			}
			if ( synPredMatched19953 ) {
				mESCs(false);
			}
			else {
				boolean synPredMatched19955 = false;
				if (((LA(1)=='"') && (LA(2)=='"'))) {
					int _m19955 = mark();
					synPredMatched19955 = true;
					inputState.guessing++;
					try {
						{
						mESCqs(false);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched19955 = false;
					}
					rewind(_m19955);
					inputState.guessing--;
				}
				if ( synPredMatched19955 ) {
					mESCqs(false);
				}
				else if ((_tokenSet_3.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')) && (true) && (true) && (true) && (true)) {
					{
					match(_tokenSet_3);
					}
				}
				else {
					break _loop19957;
				}
				}
			} while (true);
			}
			_saveIndex=text.length();
			match('"');
			text.setLength(_saveIndex);
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	protected final void mESCs(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESCs;
		int _saveIndex;
		
		match("<<");
		{
		int _cnt19963=0;
		_loop19963:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt19963>=1 ) { break _loop19963; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt19963++;
		} while (true);
		}
		match(">>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESCqs(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESCqs;
		int _saveIndex;
		
		match('"');
		_saveIndex=text.length();
		match('"');
		text.setLength(_saveIndex);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEX_DIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEX_DIGIT;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			matchRange('0','9');
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':
		{
			matchRange('a','f');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mVOCAB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = VOCAB;
		int _saveIndex;
		
		matchRange('\3','\377');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDENT;
		int _saveIndex;
		
		{
		matchRange('a','z');
		}
		{
		_loop19971:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '.':
			{
				match('.');
				break;
			}
			default:
			{
				break _loop19971;
			}
			}
		} while (true);
		}
		{
		switch ( LA(1)) {
		case '$':
		{
			match('$');
			if ( inputState.guessing==0 ) {
				
									if(new String(text.getBuffer(),_begin,text.length()-_begin).substring(0,2).toLowerCase().equals("fn")){
										_ttype=STR_FN;
									} else {
										_ttype=STR_VAR;
									}
								
			}
			break;
		}
		case '%':
		{
			match('%');
			if ( inputState.guessing==0 ) {
				
									if(new String(text.getBuffer(),_begin,text.length()-_begin).substring(0,2).toLowerCase().equals("fn")){
										_ttype=INT_FN;
									} else {
										_ttype=INT_VAR;
									}
								
			}
			break;
		}
		case '#':
		{
			match('#');
			if ( inputState.guessing==0 ) {
				
									if(new String(text.getBuffer(),_begin,text.length()-_begin).substring(0,2).toLowerCase().equals("fn")){
										_ttype=FLT_FN;
									} else {
										_ttype=FLT_VAR;
									}
								
			}
			break;
		}
		default:
			{
				if ( inputState.guessing==0 ) {
					
										if(new String(text.getBuffer(),_begin,text.length()-_begin).substring(0,2).toLowerCase().equals("fn")){
											_ttype=FLT_FN;
										//} else {
										//	_ttype=FLT_VAR;
										}
									
				}
			}
		}
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINT_CONST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT_CONST;
		int _saveIndex;
		boolean isDecimal=false;
		
		switch ( LA(1)) {
		case '.':
		{
			match('.');
			if ( inputState.guessing==0 ) {
				_ttype = DOT;
			}
			{
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				{
				int _cnt19976=0;
				_loop19976:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						if ( _cnt19976>=1 ) { break _loop19976; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt19976++;
				} while (true);
				}
				{
				if ((LA(1)=='e')) {
					mEXPONENT(false);
				}
				else {
				}
				
				}
				{
				if ((LA(1)=='d'||LA(1)=='f')) {
					mFLT_SUFFIX(false);
				}
				else {
				}
				
				}
				if ( inputState.guessing==0 ) {
					_ttype = FLT_CONST;
				}
			}
			else {
			}
			
			}
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			{
			switch ( LA(1)) {
			case '0':
			{
				match('0');
				if ( inputState.guessing==0 ) {
					isDecimal = true;
				}
				{
				switch ( LA(1)) {
				case 'x':
				{
					{
					match('x');
					}
					{
					int _cnt19983=0;
					_loop19983:
					do {
						if ((_tokenSet_4.member(LA(1))) && (true) && (true) && (true) && (true) && (true)) {
							mHEX_DIGIT(false);
						}
						else {
							if ( _cnt19983>=1 ) { break _loop19983; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
						_cnt19983++;
					} while (true);
					}
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				{
					{
					int _cnt19985=0;
					_loop19985:
					do {
						if (((LA(1) >= '0' && LA(1) <= '7'))) {
							matchRange('0','7');
						}
						else {
							if ( _cnt19985>=1 ) { break _loop19985; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
						_cnt19985++;
					} while (true);
					}
					break;
				}
				default:
					{
					}
				}
				}
				break;
			}
			case '1':  case '2':  case '3':  case '4':
			case '5':  case '6':  case '7':  case '8':
			case '9':
			{
				{
				matchRange('1','9');
				}
				{
				_loop19988:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						break _loop19988;
					}
					
				} while (true);
				}
				if ( inputState.guessing==0 ) {
					isDecimal=true;
				}
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			{
			if ((LA(1)=='l')) {
				{
				match('l');
				}
			}
			else if (((_tokenSet_5.member(LA(1))))&&(isDecimal)) {
				{
				switch ( LA(1)) {
				case '.':
				{
					match('.');
					{
					_loop19993:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							matchRange('0','9');
						}
						else {
							break _loop19993;
						}
						
					} while (true);
					}
					{
					if ((LA(1)=='e')) {
						mEXPONENT(false);
					}
					else {
					}
					
					}
					{
					if ((LA(1)=='d'||LA(1)=='f')) {
						mFLT_SUFFIX(false);
					}
					else {
					}
					
					}
					break;
				}
				case 'e':
				{
					mEXPONENT(false);
					{
					if ((LA(1)=='d'||LA(1)=='f')) {
						mFLT_SUFFIX(false);
					}
					else {
					}
					
					}
					break;
				}
				case 'd':  case 'f':
				{
					mFLT_SUFFIX(false);
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					_ttype = FLT_CONST;
				}
			}
			else {
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXPONENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXPONENT;
		int _saveIndex;
		
		{
		match('e');
		}
		{
		switch ( LA(1)) {
		case '+':
		{
			match('+');
			break;
		}
		case '-':
		{
			match('-');
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		int _cnt20001=0;
		_loop20001:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt20001>=1 ) { break _loop20001; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt20001++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mFLT_SUFFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FLT_SUFFIX;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'f':
		{
			match('f');
			break;
		}
		case 'd':
		{
			match('d');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[8];
		data[0]=-9224L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-1152922054362660872L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 4899634919602388992L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-17179869192L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 287948901175001088L, 541165879296L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 70368744177664L, 481036337152L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
