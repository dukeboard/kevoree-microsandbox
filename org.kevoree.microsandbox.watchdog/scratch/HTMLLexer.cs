// $ANTLR 2.7.2: "html.g" -> "HTMLLexer.cs"$

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
	
	public 	class HTMLLexer : antlr.CharScanner	, TokenStream
	 {
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int PCDATA = 4;
		public const int DOCTYPE = 5;
		public const int OHTML = 6;
		public const int CHTML = 7;
		public const int OHEAD = 8;
		public const int CHEAD = 9;
		public const int ISINDEX = 10;
		public const int BASE = 11;
		public const int META = 12;
		public const int LINK = 13;
		public const int OTITLE = 14;
		public const int CTITLE = 15;
		public const int OSCRIPT = 16;
		public const int CSCRIPT = 17;
		public const int OSTYLE = 18;
		public const int CSTYLE = 19;
		public const int OBODY = 20;
		public const int CBODY = 21;
		public const int HR = 22;
		public const int IMG = 23;
		public const int BFONT = 24;
		public const int BR = 25;
		public const int OH1 = 26;
		public const int CH1 = 27;
		public const int OH2 = 28;
		public const int CH2 = 29;
		public const int OH3 = 30;
		public const int CH3 = 31;
		public const int OH4 = 32;
		public const int CH4 = 33;
		public const int OH5 = 34;
		public const int CH5 = 35;
		public const int OH6 = 36;
		public const int CH6 = 37;
		public const int OADDRESS = 38;
		public const int CADDRESS = 39;
		public const int OPARA = 40;
		public const int CPARA = 41;
		public const int OULIST = 42;
		public const int CULIST = 43;
		public const int OOLIST = 44;
		public const int COLIST = 45;
		public const int ODLIST = 46;
		public const int CDLIST = 47;
		public const int OLITEM = 48;
		public const int CLITEM = 49;
		public const int ODTERM = 50;
		public const int CDTERM = 51;
		public const int ODDEF = 52;
		public const int ODIR = 53;
		public const int CDIR = 54;
		public const int OMENU = 55;
		public const int CMENU = 56;
		public const int OPRE = 57;
		public const int CPRE = 58;
		public const int ODIV = 59;
		public const int CDIV = 60;
		public const int OCENTER = 61;
		public const int CCENTER = 62;
		public const int OBQUOTE = 63;
		public const int CBQUOTE = 64;
		public const int OFORM = 65;
		public const int CFORM = 66;
		public const int OTABLE = 67;
		public const int CTABLE = 68;
		public const int OCAP = 69;
		public const int CCAP = 70;
		public const int O_TR = 71;
		public const int C_TR = 72;
		public const int O_TH_OR_TD = 73;
		public const int C_TH_OR_TD = 74;
		public const int OTTYPE = 75;
		public const int CTTYPE = 76;
		public const int OITALIC = 77;
		public const int CITALIC = 78;
		public const int OBOLD = 79;
		public const int CBOLD = 80;
		public const int OUNDER = 81;
		public const int CUNDER = 82;
		public const int OSTRIKE = 83;
		public const int CSTRIKE = 84;
		public const int OBIG = 85;
		public const int CBIG = 86;
		public const int OSMALL = 87;
		public const int CSMALL = 88;
		public const int OSUB = 89;
		public const int CSUB = 90;
		public const int OSUP = 91;
		public const int CSUP = 92;
		public const int OEM = 93;
		public const int CEM = 94;
		public const int OSTRONG = 95;
		public const int CSTRONG = 96;
		public const int ODFN = 97;
		public const int CDFN = 98;
		public const int OCODE = 99;
		public const int CCODE = 100;
		public const int OSAMP = 101;
		public const int CSAMP = 102;
		public const int OKBD = 103;
		public const int CKBD = 104;
		public const int OVAR = 105;
		public const int CVAR = 106;
		public const int OCITE = 107;
		public const int CCITE = 108;
		public const int INPUT = 109;
		public const int OSELECT = 110;
		public const int CSELECT = 111;
		public const int SELOPT = 112;
		public const int OTAREA = 113;
		public const int CTAREA = 114;
		public const int OANCHOR = 115;
		public const int CANCHOR = 116;
		public const int OAPPLET = 117;
		public const int APARM = 118;
		public const int CAPPLET = 119;
		public const int OFONT = 120;
		public const int CFONT = 121;
		public const int OMAP = 122;
		public const int AREA = 123;
		public const int CMAP = 124;
		public const int CDDEF = 125;
		public const int CDIR_OR_CDIV = 126;
		public const int OSTRIKE_OR_OSTRONG = 127;
		public const int CST_LEFT_FACTORED = 128;
		public const int CSUB_OR_CSUP = 129;
		public const int CFORM_OR_CFONT = 130;
		public const int BFONT_OR_BASE = 131;
		public const int COMMENT_DATA = 132;
		public const int COMMENT = 133;
		public const int WS = 134;
		public const int ATTR = 135;
		public const int WORD = 136;
		public const int STRING = 137;
		public const int WSCHARS = 138;
		public const int SPECIAL = 139;
		public const int HEXNUM = 140;
		public const int INT = 141;
		public const int HEXINT = 142;
		public const int DIGIT = 143;
		public const int HEXDIGIT = 144;
		public const int LCLETTER = 145;
		public const int UNDEFINED_TOKEN = 146;
		
		public HTMLLexer(Stream ins) : this(new ByteBuffer(ins))
		{
		}
		
		public HTMLLexer(TextReader r) : this(new CharBuffer(r))
		{
		}
		
		public HTMLLexer(InputBuffer ib)		 : this(new LexerSharedInputState(ib))
		{
		}
		
		public HTMLLexer(LexerSharedInputState state) : base(state)
		{
			initialize();
		}
		private void initialize()
		{
			caseSensitiveLiterals = true;
			setCaseSensitive(false);
			literals = new Hashtable();
		}
		
		public new Token nextToken()			//throws TokenStreamException
		{
			Token theRetToken = null;
tryAgain:
			for (;;)
			{
				Token _token = null;
				int _ttype = Token.INVALID_TYPE;
				setCommitToPath(false);
				int _m;
				_m = mark();
				resetText();
				try     // for char stream error handling
				{
					try     // for lexical error handling
					{
						if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='t'))
						{
							mCHTML(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='e')) {
							mCHEAD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='o')) {
							mCBODY(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='i')) {
							mCTITLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='c')) {
							mCSCRIPT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='e') && (LA(4)=='t')) {
							mMETA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='l') && (LA(3)=='i') && (LA(4)=='n')) {
							mLINK(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='1')) {
							mCH1(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='2')) {
							mCH2(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='3')) {
							mCH3(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='4')) {
							mCH4(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='5')) {
							mCH5(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='6')) {
							mCH6(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='d')) {
							mCADDRESS(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p') && (LA(4)=='>')) {
							mCPARA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='u') && (LA(4)=='l')) {
							mCULIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='l') && (LA(3)=='i') && (tokenSet_0_.member(LA(4)))) {
							mOLITEM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='l')) {
							mCDLIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='t')) {
							mCDTERM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='d')) {
							mCDDEF(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='i') && (LA(4)=='r')) {
							mODIR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='i')) {
							mCDIR_OR_CDIV(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='i') && (LA(4)=='v')) {
							mODIV(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='e') && (LA(4)=='n')) {
							mOMENU(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='m') && (LA(4)=='e')) {
							mCMENU(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p'||LA(3)=='x') && (LA(4)=='m'||LA(4)=='r')) {
							mCPRE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='e')) {
							mCCENTER(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='l')) {
							mCBQUOTE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='a')) {
							mCTABLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='a')) {
							mCCAP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='r')) {
							mC_TR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='d'||LA(4)=='h')) {
							mC_TH_OR_TD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='t')) {
							mCTTYPE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='>')) {
							mCBOLD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='u') && (LA(4)=='>')) {
							mCUNDER(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='t') && (LA(4)=='r')) {
							mOSTRIKE_OR_OSTRONG(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='t')) {
							mCST_LEFT_FACTORED(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='t') && (LA(4)=='y')) {
							mOSTYLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='i')) {
							mCBIG(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='m')) {
							mCSMALL(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='u') && (LA(4)=='b')) {
							mOSUB(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='u') && (LA(4)=='p')) {
							mOSUP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='u')) {
							mCSUB_OR_CSUP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='f')) {
							mCDFN(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='o')) {
							mCCODE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='a')) {
							mCSAMP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='i')) {
							mCCITE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='e')) {
							mCSELECT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='e')) {
							mCTAREA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='>')) {
							mCANCHOR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='p')) {
							mCAPPLET(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='f') && (LA(3)=='o') && (LA(4)=='r')) {
							mOFORM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='f') && (LA(3)=='o') && (LA(4)=='n')) {
							mOFONT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='m') && (LA(4)=='a')) {
							mCMAP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='!') && (LA(3)=='d')) {
							mDOCTYPE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='t')) {
							mOHTML(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='e')) {
							mOHEAD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='o')) {
							mOBODY(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='i')) {
							mOTITLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='c')) {
							mOSCRIPT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='s')) {
							mISINDEX(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='1')) {
							mOH1(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='2')) {
							mOH2(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='3')) {
							mOH3(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='4')) {
							mOH4(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='5')) {
							mOH5(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='6')) {
							mOH6(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='d')) {
							mOADDRESS(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='p') && (tokenSet_0_.member(LA(3)))) {
							mOPARA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='u') && (LA(3)=='l')) {
							mOULIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='o') && (LA(3)=='l')) {
							mOOLIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='o')) {
							mCOLIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='l')) {
							mCLITEM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='l')) {
							mODLIST(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='t')) {
							mODTERM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='d')) {
							mODDEF(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='p'||LA(2)=='x') && (LA(3)=='m'||LA(3)=='r')) {
							mOPRE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='e')) {
							mOCENTER(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='l')) {
							mOBQUOTE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='r')) {
							mHR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='a')) {
							mOTABLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='a')) {
							mOCAP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='r')) {
							mO_TR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='d'||LA(3)=='h')) {
							mO_TH_OR_TD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='t')) {
							mOTTYPE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='>')) {
							mOITALIC(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='i')) {
							mCITALIC(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='>')) {
							mOBOLD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='u') && (LA(3)=='>')) {
							mOUNDER(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='i')) {
							mOBIG(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='m')) {
							mOSMALL(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='e')) {
							mCEM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='f')) {
							mODFN(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='o')) {
							mOCODE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='a')) {
							mOSAMP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='k')) {
							mCKBD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='v')) {
							mCVAR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='i')) {
							mOCITE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='n')) {
							mINPUT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='e')) {
							mOSELECT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='e')) {
							mOTAREA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='o') && (LA(3)=='p')) {
							mSELOPT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='a') && (tokenSet_1_.member(LA(3)))) {
							mOANCHOR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='m')) {
							mIMG(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='p')) {
							mOAPPLET(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='p') && (LA(3)=='a')) {
							mAPARM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='f')) {
							mCFORM_OR_CFONT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='a')) {
							mBFONT_OR_BASE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='r')) {
							mBR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='a')) {
							mOMAP(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='r')) {
							mAREA(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='!') && (LA(3)=='-')) {
							mCOMMENT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='e')) {
							mOEM(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='k')) {
							mOKBD(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='<') && (LA(2)=='v')) {
							mOVAR(true);
							theRetToken = returnToken_;
						}
						else if ((tokenSet_2_.member(LA(1)))) {
							mPCDATA(true);
							theRetToken = returnToken_;
						}
						else
						{
							if (LA(1)==EOF_CHAR) { uponEOF(); returnToken_ = makeToken(Token.EOF_TYPE); }
									else
					{
					commit();
					try {mUNDEFINED_TOKEN(false);}
					catch(RecognitionException e)
					{
						// catastrophic failure
						reportError(e);
						consume();
					}
					goto tryAgain;
				}
						}
						
						commit();
						if ( null==returnToken_ ) goto tryAgain; // found SKIP token
						_ttype = returnToken_.Type;
						_ttype = testLiteralsTable(_ttype);
						returnToken_.Type = _ttype;
						return returnToken_;
					}
					catch (RecognitionException e) {
						if (!getCommitToPath())
						{
							rewind(_m);
							resetText();
							try {mUNDEFINED_TOKEN(false);}
							catch(RecognitionException ee) {
								// horrendous failure: error in filter rule
								reportError(ee);
								consume();
							}
						}
						else
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
		
	public void mDOCTYPE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DOCTYPE;
		
		match("<!doctype");
		mWS(false);
		match("html");
		mWS(false);
		match("public");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				break;
			}
			case '"':  case '\'':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		mSTRING(false);
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				break;
			}
			case '"':  case '\'':  case '>':
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
			switch ( LA(1) )
			{
			case '"':  case '\'':
			{
				mSTRING(false);
				{
					switch ( LA(1) )
					{
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						mWS(false);
						break;
					}
					case '>':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					 }
				}
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mWS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WS;
		
		{ // ( ... )+
		int _cnt22089=0;
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
			case '\n':
			{
				match('\n');
				newline();
				break;
			}
			default:
				if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true))
				{
					match("\r\n");
					newline();
				}
				else if ((LA(1)=='\r') && (true) && (true) && (true)) {
					match('\r');
					newline();
				}
			else
			{
				if (_cnt22089 >= 1) { goto _loop22089_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			break; }
			_cnt22089++;
		}
_loop22089_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSTRING(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STRING;
		
		switch ( LA(1) )
		{
		case '"':
		{
			match('"');
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_3_.member(LA(1))))
					{
						matchNot('"');
					}
					else
					{
						goto _loop22104_breakloop;
					}
					
				}
_loop22104_breakloop:				;
			}    // ( ... )*
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_4_.member(LA(1))))
					{
						matchNot('\'');
					}
					else
					{
						goto _loop22106_breakloop;
					}
					
				}
_loop22106_breakloop:				;
			}    // ( ... )*
			match('\'');
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
	
	public void mOHTML(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OHTML;
		
		match("<html>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCHTML(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CHTML;
		
		match("</html>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOHEAD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OHEAD;
		
		match("<head>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCHEAD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CHEAD;
		
		match("</head>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOBODY(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OBODY;
		
		match("<body");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21901_breakloop;
						}
						
					}
_loop21901_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mATTR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ATTR;
		
		mWORD(false);
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				break;
			}
			case '.':  case '=':  case '>':  case 'a':
			case 'b':  case 'c':  case 'd':  case 'e':
			case 'f':  case 'g':  case 'h':  case 'i':
			case 'j':  case 'k':  case 'l':  case 'm':
			case 'n':  case 'o':  case 'p':  case 'q':
			case 'r':  case 's':  case 't':  case 'u':
			case 'v':  case 'w':  case 'x':  case 'y':
			case 'z':
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
			switch ( LA(1) )
			{
			case '=':
			{
				match('=');
				{
					switch ( LA(1) )
					{
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						mWS(false);
						break;
					}
					case '"':  case '#':  case '\'':  case '-':
					case '.':  case '0':  case '1':  case '2':
					case '3':  case '4':  case '5':  case '6':
					case '7':  case '8':  case '9':  case 'a':
					case 'b':  case 'c':  case 'd':  case 'e':
					case 'f':  case 'g':  case 'h':  case 'i':
					case 'j':  case 'k':  case 'l':  case 'm':
					case 'n':  case 'o':  case 'p':  case 'q':
					case 'r':  case 's':  case 't':  case 'u':
					case 'v':  case 'w':  case 'x':  case 'y':
					case 'z':
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
					switch ( LA(1) )
					{
					case '.':  case 'a':  case 'b':  case 'c':
					case 'd':  case 'e':  case 'f':  case 'g':
					case 'h':  case 'i':  case 'j':  case 'k':
					case 'l':  case 'm':  case 'n':  case 'o':
					case 'p':  case 'q':  case 'r':  case 's':
					case 't':  case 'u':  case 'v':  case 'w':
					case 'x':  case 'y':  case 'z':
					{
						mWORD(false);
						{
							switch ( LA(1) )
							{
							case '%':
							{
								match('%');
								break;
							}
							case '\t':  case '\n':  case '\r':  case ' ':
							case '.':  case '>':  case 'a':  case 'b':
							case 'c':  case 'd':  case 'e':  case 'f':
							case 'g':  case 'h':  case 'i':  case 'j':
							case 'k':  case 'l':  case 'm':  case 'n':
							case 'o':  case 'p':  case 'q':  case 'r':
							case 's':  case 't':  case 'u':  case 'v':
							case 'w':  case 'x':  case 'y':  case 'z':
							{
								break;
							}
							default:
							{
								throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
							}
							 }
						}
						break;
					}
					case '-':  case '0':  case '1':  case '2':
					case '3':  case '4':  case '5':  case '6':
					case '7':  case '8':  case '9':
					{
						{
							switch ( LA(1) )
							{
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
						mINT(false);
						break;
					}
					case '"':  case '\'':
					{
						mSTRING(false);
						break;
					}
					case '#':
					{
						mHEXNUM(false);
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
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						mWS(false);
						break;
					}
					case '.':  case '>':  case 'a':  case 'b':
					case 'c':  case 'd':  case 'e':  case 'f':
					case 'g':  case 'h':  case 'i':  case 'j':
					case 'k':  case 'l':  case 'm':  case 'n':
					case 'o':  case 'p':  case 'q':  case 'r':
					case 's':  case 't':  case 'u':  case 'v':
					case 'w':  case 'x':  case 'y':  case 'z':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					 }
				}
				break;
			}
			case '.':  case '>':  case 'a':  case 'b':
			case 'c':  case 'd':  case 'e':  case 'f':
			case 'g':  case 'h':  case 'i':  case 'j':
			case 'k':  case 'l':  case 'm':  case 'n':
			case 'o':  case 'p':  case 'q':  case 'r':
			case 's':  case 't':  case 'u':  case 'v':
			case 'w':  case 'x':  case 'y':  case 'z':
			{
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
	
	public void mCBODY(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CBODY;
		
		match("</body>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOTITLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OTITLE;
		
		match("<title>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCTITLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CTITLE;
		
		match("</title>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSCRIPT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSCRIPT;
		
		match("<script>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCSCRIPT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CSCRIPT;
		
		match("</script>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mISINDEX(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ISINDEX;
		
		match("<isindex");
		mWS(false);
		mATTR(false);
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mMETA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = META;
		
		match("<meta");
		mWS(false);
		{ // ( ... )+
		int _cnt21910=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt21910 >= 1) { goto _loop21910_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt21910++;
		}
_loop21910_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mLINK(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LINK;
		
		match("<link");
		mWS(false);
		{ // ( ... )+
		int _cnt21913=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt21913 >= 1) { goto _loop21913_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt21913++;
		}
_loop21913_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH1(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH1;
		
		match("<h1");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH1(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH1;
		
		match("</h1>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH2(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH2;
		
		match("<h2");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH2(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH2;
		
		match("</h2>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH3(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH3;
		
		match("<h3");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH3(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH3;
		
		match("</h3>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH4(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH4;
		
		match("<h4");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH4(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH4;
		
		match("</h4>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH5(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH5;
		
		match("<h5");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH5(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH5;
		
		match("</h5>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOH6(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OH6;
		
		match("<h6");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCH6(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CH6;
		
		match("</h6>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOADDRESS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OADDRESS;
		
		match("<address>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCADDRESS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CADDRESS;
		
		match("</address>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOPARA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OPARA;
		
		match("<p");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCPARA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CPARA;
		
		match("</p>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOULIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OULIST;
		
		match("<ul");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCULIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CULIST;
		
		match("</ul>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOOLIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OOLIST;
		
		match("<ol");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOLIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COLIST;
		
		match("</ol>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOLITEM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OLITEM;
		
		match("<li");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCLITEM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CLITEM;
		
		match("</li>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODLIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODLIST;
		
		match("<dl");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCDLIST(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CDLIST;
		
		match("</dl>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODTERM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODTERM;
		
		match("<dt>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCDTERM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CDTERM;
		
		match("</dt>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODDEF(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODDEF;
		
		match("<dd>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCDDEF(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CDDEF;
		
		match("</dd>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODIR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODIR;
		
		match("<dir>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCDIR_OR_CDIV(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CDIR_OR_CDIV;
		
		match("</di");
		{
			switch ( LA(1) )
			{
			case 'r':
			{
				match('r');
				_ttype = CDIR;
				break;
			}
			case 'v':
			{
				match('v');
				_ttype = CDIV;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODIV(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODIV;
		
		match("<div");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOMENU(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OMENU;
		
		match("<menu>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCMENU(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CMENU;
		
		match("</menu>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOPRE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OPRE;
		
		{
			if ((LA(1)=='<') && (LA(2)=='p'))
			{
				match("<pre>");
			}
			else if ((LA(1)=='<') && (LA(2)=='x')) {
				match("<xmp>");
			}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
		}
		{
			if ((LA(1)=='\n'))
			{
				match('\n');
			}
			else {
			}
			
		}
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCPRE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CPRE;
		
		if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p'))
		{
			match("</pre>");
		}
		else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='x')) {
			match("</xmp>");
		}
		else
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOCENTER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OCENTER;
		
		match("<center>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCCENTER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CCENTER;
		
		match("</center>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOBQUOTE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OBQUOTE;
		
		match("<blockquote>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCBQUOTE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CBQUOTE;
		
		match("</blockquote>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mHR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HR;
		
		match("<hr");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21971_breakloop;
						}
						
					}
_loop21971_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOTABLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OTABLE;
		
		match("<table");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21975_breakloop;
						}
						
					}
_loop21975_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCTABLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CTABLE;
		
		match("</table>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOCAP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OCAP;
		
		match("<caption");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21980_breakloop;
						}
						
					}
_loop21980_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCCAP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CCAP;
		
		match("</caption>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mO_TR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = O_TR;
		
		match("<tr");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21985_breakloop;
						}
						
					}
_loop21985_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mC_TR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = C_TR;
		
		match("</tr>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mO_TH_OR_TD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = O_TH_OR_TD;
		
		{
			if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='h'))
			{
				match("<th");
			}
			else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='d')) {
				match("<td");
			}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
		}
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop21991_breakloop;
						}
						
					}
_loop21991_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mC_TH_OR_TD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = C_TH_OR_TD;
		
		if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='h'))
		{
			match("</th>");
		}
		else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='d')) {
			match("</td>");
		}
		else
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOTTYPE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OTTYPE;
		
		match("<tt>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCTTYPE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CTTYPE;
		
		match("</tt>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOITALIC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OITALIC;
		
		match("<i>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCITALIC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CITALIC;
		
		match("</i>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOBOLD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OBOLD;
		
		match("<b>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCBOLD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CBOLD;
		
		match("</b>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOUNDER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OUNDER;
		
		match("<u>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCUNDER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CUNDER;
		
		match("</u>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
/** Left-factor <strike> and <strong> to reduce lookahead */
	public void mOSTRIKE_OR_OSTRONG(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSTRIKE_OR_OSTRONG;
		
		match("<str");
		{
			switch ( LA(1) )
			{
			case 'i':
			{
				match("ike");
				_ttype = OSTRIKE;
				break;
			}
			case 'o':
			{
				match("ong");
				_ttype = OSTRONG;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCST_LEFT_FACTORED(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CST_LEFT_FACTORED;
		
		match("</st");
		{
			if ((LA(1)=='r') && (LA(2)=='i'))
			{
				match("rike");
				_ttype = CSTRIKE;
			}
			else if ((LA(1)=='r') && (LA(2)=='o')) {
				match("rong");
				_ttype = CSTRONG;
			}
			else if ((LA(1)=='y')) {
				match("yle");
				_ttype = CSTYLE;
			}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSTYLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSTYLE;
		
		match("<style>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOBIG(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OBIG;
		
		match("<big>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCBIG(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CBIG;
		
		match("</big>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSMALL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSMALL;
		
		match("<small>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCSMALL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CSMALL;
		
		match("</small>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSUB(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSUB;
		
		match("<sub>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSUP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSUP;
		
		match("<sup>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCSUB_OR_CSUP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CSUB_OR_CSUP;
		
		match("</su");
		{
			switch ( LA(1) )
			{
			case 'b':
			{
				match('b');
				_ttype = CSUB;
				break;
			}
			case 'p':
			{
				match('p');
				_ttype = CSUP;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOEM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OEM;
		
		match("<em>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCEM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CEM;
		
		match("</em>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mODFN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ODFN;
		
		match("<dfn>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCDFN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CDFN;
		
		match("</dfn>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOCODE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OCODE;
		
		match("<code>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCCODE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CCODE;
		
		match("</code>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSAMP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSAMP;
		
		match("<samp>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCSAMP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CSAMP;
		
		match("</samp>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOKBD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OKBD;
		
		match("<kbd>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCKBD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CKBD;
		
		match("</kbd>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOVAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OVAR;
		
		match("<var>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCVAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CVAR;
		
		match("</var>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOCITE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OCITE;
		
		match("<cite>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCCITE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CCITE;
		
		match("</cite>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mINPUT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INPUT;
		
		match("<input");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop22031_breakloop;
						}
						
					}
_loop22031_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOSELECT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OSELECT;
		
		match("<select");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop22035_breakloop;
						}
						
					}
_loop22035_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCSELECT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CSELECT;
		
		match("</select>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOTAREA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OTAREA;
		
		match("<textarea");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop22040_breakloop;
						}
						
					}
_loop22040_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCTAREA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CTAREA;
		
		match("</textarea>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mSELOPT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SELOPT;
		
		match("<option");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				{    // ( ... )*
					for (;;)
					{
						if ((tokenSet_5_.member(LA(1))))
						{
							mATTR(false);
						}
						else
						{
							goto _loop22045_breakloop;
						}
						
					}
_loop22045_breakloop:					;
				}    // ( ... )*
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOANCHOR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OANCHOR;
		
		match("<a");
		mWS(false);
		{ // ( ... )+
		int _cnt22048=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22048 >= 1) { goto _loop22048_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22048++;
		}
_loop22048_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCANCHOR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CANCHOR;
		
		match("</a>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mIMG(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = IMG;
		
		match("<img");
		mWS(false);
		{ // ( ... )+
		int _cnt22052=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22052 >= 1) { goto _loop22052_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22052++;
		}
_loop22052_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOAPPLET(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OAPPLET;
		
		match("<applet");
		mWS(false);
		{ // ( ... )+
		int _cnt22055=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22055 >= 1) { goto _loop22055_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22055++;
		}
_loop22055_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCAPPLET(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CAPPLET;
		
		match("</applet>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mAPARM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = APARM;
		
		match("<param");
		mWS(false);
		{ // ( ... )+
		int _cnt22059=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22059 >= 1) { goto _loop22059_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22059++;
		}
_loop22059_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOFORM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OFORM;
		
		match("<form");
		mWS(false);
		{ // ( ... )+
		int _cnt22062=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22062 >= 1) { goto _loop22062_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22062++;
		}
_loop22062_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOFONT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OFONT;
		
		match("<font");
		mWS(false);
		{ // ( ... )+
		int _cnt22065=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22065 >= 1) { goto _loop22065_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22065++;
		}
_loop22065_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCFORM_OR_CFONT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CFORM_OR_CFONT;
		
		match("</fo");
		{
			switch ( LA(1) )
			{
			case 'r':
			{
				match("rm");
				_ttype = CFORM;
				break;
			}
			case 'n':
			{
				match("nt");
				_ttype = CFONT;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBFONT_OR_BASE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BFONT_OR_BASE;
		
		match("<base");
		{
			switch ( LA(1) )
			{
			case 'f':
			{
				match("font");
				mWS(false);
				mATTR(false);
				_ttype = BFONT;
				break;
			}
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				_ttype = BASE;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BR;
		
		match("<br");
		{
			switch ( LA(1) )
			{
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(false);
				mATTR(false);
				break;
			}
			case '>':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mOMAP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OMAP;
		
		match("<map");
		mWS(false);
		mATTR(false);
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCMAP(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CMAP;
		
		match("</map>");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mAREA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = AREA;
		
		match("<area");
		mWS(false);
		{ // ( ... )+
		int _cnt22076=0;
		for (;;)
		{
			if ((tokenSet_5_.member(LA(1))))
			{
				mATTR(false);
			}
			else
			{
				if (_cnt22076 >= 1) { goto _loop22076_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22076++;
		}
_loop22076_breakloop:		;
		}    // ( ... )+
		match('>');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mPCDATA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = PCDATA;
		
		{ // ( ... )+
		int _cnt22080=0;
		for (;;)
		{
			if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true))
			{
				match('\r');
				match('\n');
				newline();
			}
			else if ((LA(1)=='\r') && (true) && (true) && (true)) {
				match('\r');
				newline();
			}
			else if ((LA(1)=='\n')) {
				match('\n');
				newline();
			}
			else if ((tokenSet_6_.member(LA(1)))) {
				{
					match(tokenSet_6_);
				}
			}
			else
			{
				if (_cnt22080 >= 1) { goto _loop22080_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22080++;
		}
_loop22080_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mCOMMENT_DATA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COMMENT_DATA;
		
		{    // ( ... )*
			for (;;)
			{
				if (((LA(1)=='-') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0003' && LA(3) <= '\u00ff')) && ((LA(4) >= '\u0003' && LA(4) <= '\u00ff')))&&(!(LA(2)=='-' && LA(3)=='>')))
				{
					match('-');
				}
				else if ((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0003' && LA(3) <= '\u00ff')) && ((LA(4) >= '\u0003' && LA(4) <= '\u00ff'))) {
					match('\r');
					match('\n');
					newline();
				}
				else if ((LA(1)=='\r') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0003' && LA(3) <= '\u00ff')) && ((LA(4) >= '\u0003' && LA(4) <= '\u00ff'))) {
					match('\r');
					newline();
				}
				else if ((LA(1)=='\n')) {
					match('\n');
					newline();
				}
				else if ((tokenSet_7_.member(LA(1)))) {
					{
						match(tokenSet_7_);
					}
				}
				else
				{
					goto _loop22084_breakloop;
				}
				
			}
_loop22084_breakloop:			;
		}    // ( ... )*
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOMMENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COMMENT;
		Token c = null;
		
		match("<!--");
		mCOMMENT_DATA(true);
		c = returnToken_;
		match("-->");
		{
			if ((tokenSet_1_.member(LA(1))))
			{
				mWS(false);
			}
			else {
			}
			
		}
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mWORD(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WORD;
		
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
				mLCLETTER(false);
				break;
			}
			case '.':
			{
				match('.');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		{ // ( ... )+
		int _cnt22101=0;
		for (;;)
		{
			if (((LA(1) >= 'a' && LA(1) <= 'z')) && (tokenSet_8_.member(LA(2))) && (true) && (true))
			{
				mLCLETTER(false);
			}
			else if ((LA(1)=='.') && (tokenSet_8_.member(LA(2))) && (true) && (true)) {
				match('.');
			}
			else if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGIT(false);
			}
			else
			{
				if (_cnt22101 >= 1) { goto _loop22101_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22101++;
		}
_loop22101_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mINT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INT;
		
		{ // ( ... )+
		int _cnt22112=0;
		for (;;)
		{
			if (((LA(1) >= '0' && LA(1) <= '9')))
			{
				mDIGIT(false);
			}
			else
			{
				if (_cnt22112 >= 1) { goto _loop22112_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22112++;
		}
_loop22112_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mHEXNUM(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HEXNUM;
		
		match('#');
		mHEXINT(false);
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mLCLETTER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = LCLETTER;
		
		matchRange('a','z');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mDIGIT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DIGIT;
		
		matchRange('0','9');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mWSCHARS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WSCHARS;
		
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
		case '\n':
		{
			match('\n');
			break;
		}
		case '\r':
		{
			match('\r');
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
	
	protected void mSPECIAL(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIAL;
		
		switch ( LA(1) )
		{
		case '<':
		{
			match('<');
			break;
		}
		case '~':
		{
			match('~');
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
	
	protected void mHEXINT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HEXINT;
		
		{ // ( ... )+
		int _cnt22115=0;
		for (;;)
		{
			if ((tokenSet_9_.member(LA(1))) && (tokenSet_10_.member(LA(2))) && (true) && (true))
			{
				mHEXDIGIT(false);
			}
			else
			{
				if (_cnt22115 >= 1) { goto _loop22115_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt22115++;
		}
_loop22115_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mHEXDIGIT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HEXDIGIT;
		
		switch ( LA(1) )
		{
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
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mUNDEFINED_TOKEN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = UNDEFINED_TOKEN;
		
		if ((LA(1)=='<') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')))
		{
			match('<');
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_11_.member(LA(1))))
					{
						matchNot('>');
					}
					else
					{
						goto _loop22121_breakloop;
					}
					
				}
_loop22121_breakloop:				;
			}    // ( ... )*
			match('>');
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)=='\n'||LA(1)=='\r'))
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
					}
					else
					{
						goto _loop22124_breakloop;
					}
					
				}
_loop22124_breakloop:				;
			}    // ( ... )*
			Console.Error.WriteLine("invalid tag: "+text.ToString(_begin, text.Length-_begin));
		}
		else if ((LA(1)=='\n'||LA(1)=='\r') && (true) && (true) && (true)) {
			{
				if ((LA(1)=='\r') && (LA(2)=='\n'))
				{
					match("\r\n");
				}
				else if ((LA(1)=='\r') && (true)) {
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
		}
		else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true) && (true) && (true)) {
			matchNot(EOF/*_CHAR*/);
		}
		else
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
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
		long[] data = { 4611686022722364928L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 4294977024L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = new long[8];
		data[0]=-5764607540214104072L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = new long[8];
		data[0]=-17179869192L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = new long[8];
		data[0]=-549755813896L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { 70368744177664L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	private static long[] mk_tokenSet_6_()
	{
		long[] data = new long[8];
		data[0]=-5764607540214113288L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_6_ = new BitSet(mk_tokenSet_6_());
	private static long[] mk_tokenSet_7_()
	{
		long[] data = new long[8];
		data[0]=-35184372098056L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_7_ = new BitSet(mk_tokenSet_7_());
	private static long[] mk_tokenSet_8_()
	{
		long[] data = { 7205548439294191104L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_8_ = new BitSet(mk_tokenSet_8_());
	private static long[] mk_tokenSet_9_()
	{
		long[] data = { 287948901175001088L, 541165879296L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_9_ = new BitSet(mk_tokenSet_9_());
	private static long[] mk_tokenSet_10_()
	{
		long[] data = { 4899705292641543680L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_10_ = new BitSet(mk_tokenSet_10_());
	private static long[] mk_tokenSet_11_()
	{
		long[] data = new long[8];
		data[0]=-4611686018427387912L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_11_ = new BitSet(mk_tokenSet_11_());
	
}
