// $ANTLR 2.7.2: "java.g" -> "JavaLexer.cs"$

	// Generate header specific to lexer CSharp file
	using System;
	using Stream                          = System.IO.Stream;
	using TextReader                      = System.IO.TextReader;
	using Hashtable                       = System.Collections.Hashtable;
	
	using TokenStreamException            = antlr.TokenStreamException;
	using TokenStreamIOException          = antlr.TokenStreamIOException;
	using TokenStreamRecognitionException = antlr.TokenStreamRecognitionException;
	using CharStreamException             = antlr.CharStreamException;
	using CharStreamIOException           = antlr.CharStreamIOException;
	using ANTLRException                  = antlr.ANTLRException;
	using CharScanner                     = antlr.CharScanner;
	using InputBuffer                     = antlr.InputBuffer;
	using ByteBuffer                      = antlr.ByteBuffer;
	using CharBuffer                      = antlr.CharBuffer;
	using Token                           = antlr.Token;
	using CommonToken                     = antlr.CommonToken;
	using RecognitionException            = antlr.RecognitionException;
	using NoViableAltForCharException     = antlr.NoViableAltForCharException;
	using MismatchedCharException         = antlr.MismatchedCharException;
	using TokenStream                     = antlr.TokenStream;
	using LexerSharedInputState           = antlr.LexerSharedInputState;
	using BitSet                          = antlr.collections.impl.BitSet;
	
	public 	class JavaLexer : antlr.CharScanner	, TokenStream
	 {
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int BLOCK = 4;
		public const int MODIFIERS = 5;
		public const int OBJBLOCK = 6;
		public const int SLIST = 7;
		public const int CTOR_DEF = 8;
		public const int METHOD_DEF = 9;
		public const int VARIABLE_DEF = 10;
		public const int INSTANCE_INIT = 11;
		public const int STATIC_INIT = 12;
		public const int TYPE = 13;
		public const int CLASS_DEF = 14;
		public const int INTERFACE_DEF = 15;
		public const int PACKAGE_DEF = 16;
		public const int ARRAY_DECLARATOR = 17;
		public const int EXTENDS_CLAUSE = 18;
		public const int IMPLEMENTS_CLAUSE = 19;
		public const int PARAMETERS = 20;
		public const int PARAMETER_DEF = 21;
		public const int LABELED_STAT = 22;
		public const int TYPECAST = 23;
		public const int INDEX_OP = 24;
		public const int POST_INC = 25;
		public const int POST_DEC = 26;
		public const int METHOD_CALL = 27;
		public const int EXPR = 28;
		public const int ARRAY_INIT = 29;
		public const int IMPORT = 30;
		public const int UNARY_MINUS = 31;
		public const int UNARY_PLUS = 32;
		public const int CASE_GROUP = 33;
		public const int ELIST = 34;
		public const int FOR_INIT = 35;
		public const int FOR_CONDITION = 36;
		public const int FOR_ITERATOR = 37;
		public const int EMPTY_STAT = 38;
		public const int FINAL = 39;
		public const int ABSTRACT = 40;
		public const int STRICTFP = 41;
		public const int SUPER_CTOR_CALL = 42;
		public const int CTOR_CALL = 43;
		public const int TK_package = 44;
		public const int SEMI = 45;
		public const int TK_import = 46;
		public const int LBRACK = 47;
		public const int RBRACK = 48;
		public const int TK_void = 49;
		public const int TK_boolean = 50;
		public const int TK_byte = 51;
		public const int TK_char = 52;
		public const int TK_short = 53;
		public const int TK_int = 54;
		public const int TK_float = 55;
		public const int TK_long = 56;
		public const int TK_double = 57;
		public const int IDENT = 58;
		public const int DOT = 59;
		public const int STAR = 60;
		public const int TK_private = 61;
		public const int TK_public = 62;
		public const int TK_protected = 63;
		public const int TK_static = 64;
		public const int TK_transient = 65;
		public const int TK_native = 66;
		public const int TK_threadsafe = 67;
		public const int TK_synchronized = 68;
		public const int TK_volatile = 69;
		public const int TK_class = 70;
		public const int TK_extends = 71;
		public const int TK_interface = 72;
		public const int LCURLY = 73;
		public const int RCURLY = 74;
		public const int COMMA = 75;
		public const int TK_implements = 76;
		public const int LPAREN = 77;
		public const int RPAREN = 78;
		public const int TK_this = 79;
		public const int TK_super = 80;
		public const int ASSIGN = 81;
		public const int TK_throws = 82;
		public const int COLON = 83;
		public const int TK_if = 84;
		public const int TK_else = 85;
		public const int TK_for = 86;
		public const int TK_while = 87;
		public const int TK_do = 88;
		public const int TK_break = 89;
		public const int TK_continue = 90;
		public const int TK_return = 91;
		public const int TK_switch = 92;
		public const int TK_throw = 93;
		public const int TK_case = 94;
		public const int TK_default = 95;
		public const int TK_try = 96;
		public const int TK_finally = 97;
		public const int TK_catch = 98;
		public const int PLUS_ASSIGN = 99;
		public const int MINUS_ASSIGN = 100;
		public const int STAR_ASSIGN = 101;
		public const int DIV_ASSIGN = 102;
		public const int MOD_ASSIGN = 103;
		public const int SR_ASSIGN = 104;
		public const int BSR_ASSIGN = 105;
		public const int SL_ASSIGN = 106;
		public const int BAND_ASSIGN = 107;
		public const int BXOR_ASSIGN = 108;
		public const int BOR_ASSIGN = 109;
		public const int QUESTION = 110;
		public const int LOR = 111;
		public const int LAND = 112;
		public const int BOR = 113;
		public const int BXOR = 114;
		public const int BAND = 115;
		public const int NOT_EQUAL = 116;
		public const int EQUAL = 117;
		public const int LTHAN = 118;
		public const int GTHAN = 119;
		public const int LTE = 120;
		public const int GTE = 121;
		public const int TK_instanceof = 122;
		public const int SL = 123;
		public const int SR = 124;
		public const int BSR = 125;
		public const int PLUS = 126;
		public const int MINUS = 127;
		public const int DIV = 128;
		public const int MOD = 129;
		public const int INC = 130;
		public const int DEC = 131;
		public const int BNOT = 132;
		public const int LNOT = 133;
		public const int TK_true = 134;
		public const int TK_false = 135;
		public const int TK_null = 136;
		public const int TK_new = 137;
		public const int NUM_INT = 138;
		public const int CHAR_LITERAL = 139;
		public const int STRING_LITERAL = 140;
		public const int NUM_FLOAT = 141;
		public const int NUM_LONG = 142;
		public const int NUM_DOUBLE = 143;
		public const int WS = 144;
		public const int SL_COMMENT = 145;
		public const int ML_COMMENT = 146;
		public const int ESC = 147;
		public const int HEX_DIGIT = 148;
		public const int VOCAB = 149;
		public const int EXPONENT = 150;
		public const int FLOAT_SUFFIX = 151;
		
		public JavaLexer(Stream ins) : this(new ByteBuffer(ins))
		{
		}
		
		public JavaLexer(TextReader r) : this(new CharBuffer(r))
		{
		}
		
		public JavaLexer(InputBuffer ib)		 : this(new LexerSharedInputState(ib))
		{
		}
		
		public JavaLexer(LexerSharedInputState state) : base(state)
		{
			initialize();
		}
		private void initialize()
		{
			caseSensitiveLiterals = true;
			setCaseSensitive(true);
			literals = new Hashtable();
			literals.Add("byte", 51);
			literals.Add("public", 62);
			literals.Add("case", 94);
			literals.Add("short", 53);
			literals.Add("break", 89);
			literals.Add("while", 87);
			literals.Add("new", 137);
			literals.Add("instanceof", 122);
			literals.Add("implements", 76);
			literals.Add("synchronized", 68);
			literals.Add("float", 55);
			literals.Add("package", 44);
			literals.Add("return", 91);
			literals.Add("throw", 93);
			literals.Add("null", 136);
			literals.Add("threadsafe", 67);
			literals.Add("protected", 63);
			literals.Add("class", 70);
			literals.Add("throws", 82);
			literals.Add("do", 88);
			literals.Add("strictfp", 41);
			literals.Add("super", 80);
			literals.Add("transient", 65);
			literals.Add("native", 66);
			literals.Add("interface", 72);
			literals.Add("final", 39);
			literals.Add("if", 84);
			literals.Add("double", 57);
			literals.Add("volatile", 69);
			literals.Add("catch", 98);
			literals.Add("try", 96);
			literals.Add("int", 54);
			literals.Add("for", 86);
			literals.Add("extends", 71);
			literals.Add("boolean", 50);
			literals.Add("char", 52);
			literals.Add("private", 61);
			literals.Add("default", 95);
			literals.Add("false", 135);
			literals.Add("this", 79);
			literals.Add("static", 64);
			literals.Add("abstract", 40);
			literals.Add("continue", 90);
			literals.Add("finally", 97);
			literals.Add("else", 85);
			literals.Add("import", 46);
			literals.Add("void", 49);
			literals.Add("switch", 92);
			literals.Add("true", 134);
			literals.Add("long", 56);
		}
		
		public new Token nextToken()			//throws TokenStreamException
		{
			Token theRetToken = null;
tryAgain:
			for (;;)
			{
				Token _token = null;
				int _ttype = Token.INVALID_TYPE;
				resetText();
				try     // for char stream error handling
				{
					try     // for lexical error handling
					{
						switch ( LA(1) )
						{
						case '?':
						{
							mQUESTION(true);
							theRetToken = returnToken_;
							break;
						}
						case '(':
						{
							mLPAREN(true);
							theRetToken = returnToken_;
							break;
						}
						case ')':
						{
							mRPAREN(true);
							theRetToken = returnToken_;
							break;
						}
						case '[':
						{
							mLBRACK(true);
							theRetToken = returnToken_;
							break;
						}
						case ']':
						{
							mRBRACK(true);
							theRetToken = returnToken_;
							break;
						}
						case '{':
						{
							mLCURLY(true);
							theRetToken = returnToken_;
							break;
						}
						case '}':
						{
							mRCURLY(true);
							theRetToken = returnToken_;
							break;
						}
						case ':':
						{
							mCOLON(true);
							theRetToken = returnToken_;
							break;
						}
						case ',':
						{
							mCOMMA(true);
							theRetToken = returnToken_;
							break;
						}
						case '~':
						{
							mBNOT(true);
							theRetToken = returnToken_;
							break;
						}
						case ';':
						{
							mSEMI(true);
							theRetToken = returnToken_;
							break;
						}
						case '\t':  case '\n':  case '\u000c':  case '\r':
						case ' ':
						{
							mWS(true);
							theRetToken = returnToken_;
							break;
						}
						case '\'':
						{
							mCHAR_LITERAL(true);
							theRetToken = returnToken_;
							break;
						}
						case '"':
						{
							mSTRING_LITERAL(true);
							theRetToken = returnToken_;
							break;
						}
						case '$':  case 'A':  case 'B':  case 'C':
						case 'D':  case 'E':  case 'F':  case 'G':
						case 'H':  case 'I':  case 'J':  case 'K':
						case 'L':  case 'M':  case 'N':  case 'O':
						case 'P':  case 'Q':  case 'R':  case 'S':
						case 'T':  case 'U':  case 'V':  case 'W':
						case 'X':  case 'Y':  case 'Z':  case '_':
						case 'a':  case 'b':  case 'c':  case 'd':
						case 'e':  case 'f':  case 'g':  case 'h':
						case 'i':  case 'j':  case 'k':  case 'l':
						case 'm':  case 'n':  case 'o':  case 'p':
						case 'q':  case 'r':  case 's':  case 't':
						case 'u':  case 'v':  case 'w':  case 'x':
						case 'y':  case 'z':
						{
							mIDENT(true);
							theRetToken = returnToken_;
							break;
						}
						case '.':  case '0':  case '1':  case '2':
						case '3':  case '4':  case '5':  case '6':
						case '7':  case '8':  case '9':
						{
							mNUM_INT(true);
							theRetToken = returnToken_;
							break;
						}
						default:
							if ((LA(1)=='>') && (LA(2)=='>') && (LA(3)=='>') && (LA(4)=='='))
							{
								mBSR_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='>') && (LA(2)=='>') && (LA(3)=='=')) {
								mSR_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='>') && (LA(2)=='>') && (LA(3)=='>') && (true)) {
								mBSR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='<') && (LA(2)=='<') && (LA(3)=='=')) {
								mSL_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='=') && (LA(2)=='=')) {
								mEQUAL(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='!') && (LA(2)=='=')) {
								mNOT_EQUAL(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='/') && (LA(2)=='=')) {
								mDIV_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='+') && (LA(2)=='=')) {
								mPLUS_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='+') && (LA(2)=='+')) {
								mINC(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='-') && (LA(2)=='=')) {
								mMINUS_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='-') && (LA(2)=='-')) {
								mDEC(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='*') && (LA(2)=='=')) {
								mSTAR_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='%') && (LA(2)=='=')) {
								mMOD_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='>') && (LA(2)=='>') && (true)) {
								mSR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='>') && (LA(2)=='=')) {
								mGTE(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='<') && (LA(2)=='<') && (true)) {
								mSL(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='<') && (LA(2)=='=')) {
								mLTE(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='^') && (LA(2)=='=')) {
								mBXOR_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='|') && (LA(2)=='=')) {
								mBOR_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='|') && (LA(2)=='|')) {
								mLOR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='&') && (LA(2)=='=')) {
								mBAND_ASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='&') && (LA(2)=='&')) {
								mLAND(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='/') && (LA(2)=='/')) {
								mSL_COMMENT(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='/') && (LA(2)=='*')) {
								mML_COMMENT(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='=') && (true)) {
								mASSIGN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='!') && (true)) {
								mLNOT(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='/') && (true)) {
								mDIV(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='+') && (true)) {
								mPLUS(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='-') && (true)) {
								mMINUS(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='*') && (true)) {
								mSTAR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='%') && (true)) {
								mMOD(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='>') && (true)) {
								mGTHAN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='<') && (true)) {
								mLTHAN(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='^') && (true)) {
								mBXOR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='|') && (true)) {
								mBOR(true);
								theRetToken = returnToken_;
							}
							else if ((LA(1)=='&') && (true)) {
								mBAND(true);
								theRetToken = returnToken_;
							}
						else
						{
							if (LA(1)==EOF_CHAR) { uponEOF(); returnToken_ = makeToken(Token.EOF_TYPE); }
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						break; }
						if ( null==returnToken_ ) goto tryAgain; // found SKIP token
						_ttype = returnToken_.Type;
						returnToken_.Type = _ttype;
						return returnToken_;
					}
					catch (RecognitionException e) {
							throw new TokenStreamRecognitionException(e);
					}
				}
				catch (CharStreamException cse) {
					if ( cse is CharStreamIOException ) {
						throw new TokenStreamIOException(((CharStreamIOException)cse).io);
					}
					else {
						throw new TokenStreamException(cse.Message);
					}
				}
			}
		}
		
	public void mQUESTION(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = QUESTION;
		
		match('?');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLPAREN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LPAREN;
		
		match('(');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mRPAREN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = RPAREN;
		
		match(')');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLBRACK(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LBRACK;
		
		match('[');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mRBRACK(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = RBRACK;
		
		match(']');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLCURLY(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LCURLY;
		
		match('{');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mRCURLY(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = RCURLY;
		
		match('}');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOLON(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COLON;
		
		match(':');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOMMA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COMMA;
		
		match(',');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ASSIGN;
		
		match('=');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mEQUAL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = EQUAL;
		
		match("==");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLNOT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LNOT;
		
		match('!');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBNOT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BNOT;
		
		match('~');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mNOT_EQUAL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = NOT_EQUAL;
		
		match("!=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mDIV(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DIV;
		
		match('/');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mDIV_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DIV_ASSIGN;
		
		match("/=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mPLUS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = PLUS;
		
		match('+');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mPLUS_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = PLUS_ASSIGN;
		
		match("+=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mINC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INC;
		
		match("++");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mMINUS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = MINUS;
		
		match('-');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mMINUS_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = MINUS_ASSIGN;
		
		match("-=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mDEC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DEC;
		
		match("--");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSTAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STAR;
		
		match('*');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSTAR_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STAR_ASSIGN;
		
		match("*=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mMOD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = MOD;
		
		match('%');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mMOD_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = MOD_ASSIGN;
		
		match("%=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SR;
		
		match(">>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSR_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SR_ASSIGN;
		
		match(">>=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBSR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BSR;
		
		match(">>>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBSR_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BSR_ASSIGN;
		
		match(">>>=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mGTE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = GTE;
		
		match(">=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mGTHAN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = GTHAN;
		
		match(">");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SL;
		
		match("<<");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSL_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SL_ASSIGN;
		
		match("<<=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLTE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LTE;
		
		match("<=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLTHAN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LTHAN;
		
		match('<');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBXOR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BXOR;
		
		match('^');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBXOR_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BXOR_ASSIGN;
		
		match("^=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBOR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BOR;
		
		match('|');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBOR_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BOR_ASSIGN;
		
		match("|=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLOR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LOR;
		
		match("||");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBAND(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BAND;
		
		match('&');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBAND_ASSIGN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BAND_ASSIGN;
		
		match("&=");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLAND(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LAND;
		
		match("&&");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSEMI(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SEMI;
		
		match(';');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mWS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WS;
		
		{ // ( ... )+
		int _cnt22675=0;
		for (;;)
		{
			switch ( LA(1) )
			{
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
			case '\n':  case '\r':
			{
				{
					if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true))
					{
						match("\r\n");
					}
					else if ((LA(1)=='\r') && (true) && (true) && (true)) {
						match('\r');
					}
					else if ((LA(1)=='\n')) {
						match('\n');
					}
					else
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
				}
				newline();
				break;
			}
			default:
			{
				if (_cnt22675 >= 1) { goto _loop22675_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			break; }
			_cnt22675++;
		}
_loop22675_breakloop:		;
		}    // ( ... )+
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSL_COMMENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SL_COMMENT;
		
		match("//");
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_0_.member(LA(1))))
				{
					{
						match(tokenSet_0_);
					}
				}
				else
				{
					goto _loop22679_breakloop;
				}
				
			}
_loop22679_breakloop:			;
		}    // ( ... )*
		{
			switch ( LA(1) )
			{
			case '\n':
			{
				match('\n');
				break;
			}
			case '\r':
			{
				match('\r');
				{
					if ((LA(1)=='\n'))
					{
						match('\n');
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
		}
		_ttype = Token.SKIP; newline();
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mML_COMMENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ML_COMMENT;
		
		match("/*");
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0003' && LA(3) <= '\uffff')) && ((LA(4) >= '\u0003' && LA(4) <= '\uffff')))
				{
					match('\r');
					match('\n');
					newline();
				}
				else if (((LA(1)=='*') && ((LA(2) >= '\u0003' && LA(2) <= '\uffff')) && ((LA(3) >= '\u0003' && LA(3) <= '\uffff')))&&( LA(2)!='/' )) {
					match('*');
				}
				else if ((LA(1)=='\r') && ((LA(2) >= '\u0003' && LA(2) <= '\uffff')) && ((LA(3) >= '\u0003' && LA(3) <= '\uffff')) && (true)) {
					match('\r');
					newline();
				}
				else if ((LA(1)=='\n')) {
					match('\n');
					newline();
				}
				else if ((tokenSet_1_.member(LA(1)))) {
					{
						match(tokenSet_1_);
					}
				}
				else
				{
					goto _loop22685_breakloop;
				}
				
			}
_loop22685_breakloop:			;
		}    // ( ... )*
		match("*/");
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCHAR_LITERAL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CHAR_LITERAL;
		
		match('\'');
		{
			if ((LA(1)=='\\'))
			{
				mESC(false);
			}
			else if ((tokenSet_2_.member(LA(1)))) {
				matchNot('\'');
			}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
		}
		match('\'');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mESC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ESC;
		
		match('\\');
		{
			switch ( LA(1) )
			{
			case 'n':
			{
				match('n');
				break;
			}
			case 'r':
			{
				match('r');
				break;
			}
			case 't':
			{
				match('t');
				break;
			}
			case 'b':
			{
				match('b');
				break;
			}
			case 'f':
			{
				match('f');
				break;
			}
			case '"':
			{
				match('"');
				break;
			}
			case '\'':
			{
				match('\'');
				break;
			}
			case '\\':
			{
				match('\\');
				break;
			}
			case 'u':
			{
				{ // ( ... )+
				int _cnt22695=0;
				for (;;)
				{
					if ((LA(1)=='u'))
					{
						match('u');
					}
					else
					{
						if (_cnt22695 >= 1) { goto _loop22695_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
					}
					
					_cnt22695++;
				}
_loop22695_breakloop:				;
				}    // ( ... )+
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			{
				matchRange('0','3');
				{
					if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\uffff')) && (true) && (true))
					{
						matchRange('0','7');
						{
							if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\uffff')) && (true) && (true))
							{
								matchRange('0','7');
							}
							else if (((LA(1) >= '\u0003' && LA(1) <= '\uffff')) && (true) && (true) && (true)) {
							}
							else
							{
								throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
							}
							
						}
					}
					else if (((LA(1) >= '\u0003' && LA(1) <= '\uffff')) && (true) && (true) && (true)) {
					}
					else
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
				}
				break;
			}
			case '4':  case '5':  case '6':  case '7':
			{
				matchRange('4','7');
				{
					if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\uffff')) && (true) && (true))
					{
						matchRange('0','7');
					}
					else if (((LA(1) >= '\u0003' && LA(1) <= '\uffff')) && (true) && (true) && (true)) {
					}
					else
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSTRING_LITERAL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STRING_LITERAL;
		
		match('"');
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)=='\\'))
				{
					mESC(false);
				}
				else if ((tokenSet_3_.member(LA(1)))) {
					{
						match(tokenSet_3_);
					}
				}
				else
				{
					goto _loop22691_breakloop;
				}
				
			}
_loop22691_breakloop:			;
		}    // ( ... )*
		match('"');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mHEX_DIGIT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HEX_DIGIT;
		
		{
			switch ( LA(1) )
			{
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':
			{
				matchRange('A','F');
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
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mVOCAB(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = VOCAB;
		
		matchRange('\x3','\xff');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mIDENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = IDENT;
		
		{
			switch ( LA(1) )
			{
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
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '$':
			{
				match('$');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		{    // ( ... )*
			for (;;)
			{
				switch ( LA(1) )
				{
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
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':
				{
					matchRange('A','Z');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					matchRange('0','9');
					break;
				}
				case '$':
				{
					match('$');
					break;
				}
				default:
				{
					goto _loop22705_breakloop;
				}
				 }
			}
_loop22705_breakloop:			;
		}    // ( ... )*
		_ttype = testLiteralsTable(_ttype);
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mNUM_INT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = NUM_INT;
		Token f1 = null;
		Token f2 = null;
		Token f3 = null;
		Token f4 = null;
		bool isDecimal=false; Token t=null;
		
		switch ( LA(1) )
		{
		case '.':
		{
			match('.');
			_ttype = DOT;
			{
				if (((LA(1) >= '0' && LA(1) <= '9')))
				{
					{ // ( ... )+
					int _cnt22709=0;
					for (;;)
					{
						if (((LA(1) >= '0' && LA(1) <= '9')))
						{
							matchRange('0','9');
						}
						else
						{
							if (_cnt22709 >= 1) { goto _loop22709_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
						}
						
						_cnt22709++;
					}
_loop22709_breakloop:					;
					}    // ( ... )+
					{
						if ((LA(1)=='E'||LA(1)=='e'))
						{
							mEXPONENT(false);
						}
						else {
						}
						
					}
					{
						if ((LA(1)=='D'||LA(1)=='F'||LA(1)=='d'||LA(1)=='f'))
						{
							mFLOAT_SUFFIX(true);
							f1 = returnToken_;
							t=f1;
						}
						else {
						}
						
					}
					
									if (t != null && t.getText().ToUpper().IndexOf('F')>=0) {
						_ttype = NUM_FLOAT;
									}
									else {
						_ttype = NUM_DOUBLE; // assume double
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
				switch ( LA(1) )
				{
				case '0':
				{
					match('0');
					isDecimal = true;
					{
						switch ( LA(1) )
						{
						case 'X':  case 'x':
						{
							{
								switch ( LA(1) )
								{
								case 'x':
								{
									match('x');
									break;
								}
								case 'X':
								{
									match('X');
									break;
								}
								default:
								{
									throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
								}
								 }
							}
							{ // ( ... )+
							int _cnt22716=0;
							for (;;)
							{
								if ((tokenSet_4_.member(LA(1))) && (true) && (true) && (true))
								{
									mHEX_DIGIT(false);
								}
								else
								{
									if (_cnt22716 >= 1) { goto _loop22716_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
								}
								
								_cnt22716++;
							}
_loop22716_breakloop:							;
							}    // ( ... )+
							break;
						}
						case '0':  case '1':  case '2':  case '3':
						case '4':  case '5':  case '6':  case '7':
						{
							{ // ( ... )+
							int _cnt22718=0;
							for (;;)
							{
								if (((LA(1) >= '0' && LA(1) <= '7')))
								{
									matchRange('0','7');
								}
								else
								{
									if (_cnt22718 >= 1) { goto _loop22718_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
								}
								
								_cnt22718++;
							}
_loop22718_breakloop:							;
							}    // ( ... )+
							break;
						}
						default:
							{
							}
						break; }
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
					{    // ( ... )*
						for (;;)
						{
							if (((LA(1) >= '0' && LA(1) <= '9')))
							{
								matchRange('0','9');
							}
							else
							{
								goto _loop22721_breakloop;
							}
							
						}
_loop22721_breakloop:						;
					}    // ( ... )*
					isDecimal=true;
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				 }
			}
			{
				if ((LA(1)=='L'||LA(1)=='l'))
				{
					{
						switch ( LA(1) )
						{
						case 'l':
						{
							match('l');
							break;
						}
						case 'L':
						{
							match('L');
							break;
						}
						default:
						{
							throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
						}
						 }
					}
					_ttype = NUM_LONG;
				}
				else if (((LA(1)=='.'||LA(1)=='D'||LA(1)=='E'||LA(1)=='F'||LA(1)=='d'||LA(1)=='e'||LA(1)=='f'))&&(isDecimal)) {
					{
						switch ( LA(1) )
						{
						case '.':
						{
							match('.');
							{    // ( ... )*
								for (;;)
								{
									if (((LA(1) >= '0' && LA(1) <= '9')))
									{
										matchRange('0','9');
									}
									else
									{
										goto _loop22726_breakloop;
									}
									
								}
_loop22726_breakloop:								;
							}    // ( ... )*
							{
								if ((LA(1)=='E'||LA(1)=='e'))
								{
									mEXPONENT(false);
								}
								else {
								}
								
							}
							{
								if ((LA(1)=='D'||LA(1)=='F'||LA(1)=='d'||LA(1)=='f'))
								{
									mFLOAT_SUFFIX(true);
									f2 = returnToken_;
									t=f2;
								}
								else {
								}
								
							}
							break;
						}
						case 'E':  case 'e':
						{
							mEXPONENT(false);
							{
								if ((LA(1)=='D'||LA(1)=='F'||LA(1)=='d'||LA(1)=='f'))
								{
									mFLOAT_SUFFIX(true);
									f3 = returnToken_;
									t=f3;
								}
								else {
								}
								
							}
							break;
						}
						case 'D':  case 'F':  case 'd':  case 'f':
						{
							mFLOAT_SUFFIX(true);
							f4 = returnToken_;
							t=f4;
							break;
						}
						default:
						{
							throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
						}
						 }
					}
					
								if (t != null && t.getText().ToUpper().IndexOf('F') >= 0) {
					_ttype = NUM_FLOAT;
								}
					else {
						           	_ttype = NUM_DOUBLE; // assume double
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
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mEXPONENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = EXPONENT;
		
		{
			switch ( LA(1) )
			{
			case 'e':
			{
				match('e');
				break;
			}
			case 'E':
			{
				match('E');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		{
			switch ( LA(1) )
			{
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
		{ // ( ... )+
		int _cnt22734=0;
		for (;;)
		{
			if (((LA(1) >= '0' && LA(1) <= '9')))
			{
				matchRange('0','9');
			}
			else
			{
				if (_cnt22734 >= 1) { goto _loop22734_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22734++;
		}
_loop22734_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mFLOAT_SUFFIX(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = FLOAT_SUFFIX;
		
		switch ( LA(1) )
		{
		case 'f':
		{
			match('f');
			break;
		}
		case 'F':
		{
			match('F');
			break;
		}
		case 'd':
		{
			match('d');
			break;
		}
		case 'D':
		{
			match('D');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		 }
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = new long[2048];
		data[0]=-9224L;
		for (int i = 1; i<=1023; i++) { data[i]=-1L; }
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = new long[2048];
		data[0]=-4398046520328L;
		for (int i = 1; i<=1023; i++) { data[i]=-1L; }
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = new long[2048];
		data[0]=-549755813896L;
		data[1]=-268435457L;
		for (int i = 2; i<=1023; i++) { data[i]=-1L; }
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = new long[2048];
		data[0]=-17179869192L;
		data[1]=-268435457L;
		for (int i = 2; i<=1023; i++) { data[i]=-1L; }
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = new long[1025];
		data[0]=287948901175001088L;
		data[1]=541165879422L;
		for (int i = 2; i<=1024; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	
}
