// $ANTLR 2.7.2: "html.g" -> "HTMLLexer.java"$

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

public class HTMLLexer extends antlr.CharScanner implements HTMLTokenTypes, TokenStream
 {
public HTMLLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public HTMLLexer(Reader in) {
	this(new CharBuffer(in));
}
public HTMLLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public HTMLLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(false);
	literals = new Hashtable();
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		setCommitToPath(false);
		int _m;
		_m = mark();
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='t')) {
					mCHTML(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='e')) {
					mCHEAD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='o')) {
					mCBODY(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='i')) {
					mCTITLE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='c')) {
					mCSCRIPT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='e') && (LA(4)=='t')) {
					mMETA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='l') && (LA(3)=='i') && (LA(4)=='n')) {
					mLINK(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='1')) {
					mCH1(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='2')) {
					mCH2(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='3')) {
					mCH3(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='4')) {
					mCH4(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='5')) {
					mCH5(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='h') && (LA(4)=='6')) {
					mCH6(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='d')) {
					mCADDRESS(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p') && (LA(4)=='>')) {
					mCPARA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='u') && (LA(4)=='l')) {
					mCULIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='l') && (LA(3)=='i') && (_tokenSet_0.member(LA(4)))) {
					mOLITEM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='l')) {
					mCDLIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='t')) {
					mCDTERM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='d')) {
					mCDDEF(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='i') && (LA(4)=='r')) {
					mODIR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='i')) {
					mCDIR_OR_CDIV(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='i') && (LA(4)=='v')) {
					mODIV(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='e') && (LA(4)=='n')) {
					mOMENU(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='m') && (LA(4)=='e')) {
					mCMENU(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p'||LA(3)=='x') && (LA(4)=='m'||LA(4)=='r')) {
					mCPRE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='e')) {
					mCCENTER(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='l')) {
					mCBQUOTE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='a')) {
					mCTABLE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='a')) {
					mCCAP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='r')) {
					mC_TR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='d'||LA(4)=='h')) {
					mC_TH_OR_TD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='t')) {
					mCTTYPE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='>')) {
					mCBOLD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='u') && (LA(4)=='>')) {
					mCUNDER(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='t') && (LA(4)=='r')) {
					mOSTRIKE_OR_OSTRONG(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='t')) {
					mCST_LEFT_FACTORED(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='t') && (LA(4)=='y')) {
					mOSTYLE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='b') && (LA(4)=='i')) {
					mCBIG(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='m')) {
					mCSMALL(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='u') && (LA(4)=='b')) {
					mOSUB(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='u') && (LA(4)=='p')) {
					mOSUP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='u')) {
					mCSUB_OR_CSUP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='d') && (LA(4)=='f')) {
					mCDFN(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='o')) {
					mCCODE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='a')) {
					mCSAMP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='c') && (LA(4)=='i')) {
					mCCITE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='s') && (LA(4)=='e')) {
					mCSELECT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='e')) {
					mCTAREA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='>')) {
					mCANCHOR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='a') && (LA(4)=='p')) {
					mCAPPLET(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='f') && (LA(3)=='o') && (LA(4)=='r')) {
					mOFORM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='f') && (LA(3)=='o') && (LA(4)=='n')) {
					mOFONT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='m') && (LA(4)=='a')) {
					mCMAP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='!') && (LA(3)=='d')) {
					mDOCTYPE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='t')) {
					mOHTML(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='e')) {
					mOHEAD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='o')) {
					mOBODY(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='i')) {
					mOTITLE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='c')) {
					mOSCRIPT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='s')) {
					mISINDEX(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='1')) {
					mOH1(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='2')) {
					mOH2(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='3')) {
					mOH3(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='4')) {
					mOH4(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='5')) {
					mOH5(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='6')) {
					mOH6(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='d')) {
					mOADDRESS(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='p') && (_tokenSet_0.member(LA(3)))) {
					mOPARA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='u') && (LA(3)=='l')) {
					mOULIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='o') && (LA(3)=='l')) {
					mOOLIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='o')) {
					mCOLIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='l')) {
					mCLITEM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='l')) {
					mODLIST(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='t')) {
					mODTERM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='d')) {
					mODDEF(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='p'||LA(2)=='x') && (LA(3)=='m'||LA(3)=='r')) {
					mOPRE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='e')) {
					mOCENTER(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='l')) {
					mOBQUOTE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='h') && (LA(3)=='r')) {
					mHR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='a')) {
					mOTABLE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='a')) {
					mOCAP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='r')) {
					mO_TR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='d'||LA(3)=='h')) {
					mO_TH_OR_TD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='t')) {
					mOTTYPE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='>')) {
					mOITALIC(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='i')) {
					mCITALIC(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='>')) {
					mOBOLD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='u') && (LA(3)=='>')) {
					mOUNDER(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='i')) {
					mOBIG(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='m')) {
					mOSMALL(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='e')) {
					mCEM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='d') && (LA(3)=='f')) {
					mODFN(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='o')) {
					mOCODE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='a')) {
					mOSAMP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='k')) {
					mCKBD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='v')) {
					mCVAR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='c') && (LA(3)=='i')) {
					mOCITE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='n')) {
					mINPUT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='s') && (LA(3)=='e')) {
					mOSELECT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='e')) {
					mOTAREA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='o') && (LA(3)=='p')) {
					mSELOPT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='a') && (_tokenSet_1.member(LA(3)))) {
					mOANCHOR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='i') && (LA(3)=='m')) {
					mIMG(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='p')) {
					mOAPPLET(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='p') && (LA(3)=='a')) {
					mAPARM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='f')) {
					mCFORM_OR_CFONT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='a')) {
					mBFONT_OR_BASE(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='b') && (LA(3)=='r')) {
					mBR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='m') && (LA(3)=='a')) {
					mOMAP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='a') && (LA(3)=='r')) {
					mAREA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='!') && (LA(3)=='-')) {
					mCOMMENT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='e')) {
					mOEM(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='k')) {
					mOKBD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='v')) {
					mOVAR(true);
					theRetToken=_returnToken;
				}
				else if ((_tokenSet_2.member(LA(1)))) {
					mPCDATA(true);
					theRetToken=_returnToken;
				}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {
					commit();
					try {mUNDEFINED_TOKEN(false);}
					catch(RecognitionException e) {
						// catastrophic failure
						reportError(e);
						consume();
					}
					continue tryAgain;
				}
				}
				
				commit();
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				if ( !getCommitToPath() ) {
					rewind(_m);
					resetText();
					try {mUNDEFINED_TOKEN(false);}
					catch(RecognitionException ee) {
						// horrendous failure: error in filter rule
						reportError(ee);
						consume();
					}
					continue tryAgain;
				}
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

	public final void mDOCTYPE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOCTYPE;
		int _saveIndex;
		
		match("<!doctype");
		mWS(false);
		match("html");
		mWS(false);
		match("public");
		{
		switch ( LA(1)) {
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
		switch ( LA(1)) {
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
		switch ( LA(1)) {
		case '"':  case '\'':
		{
			mSTRING(false);
			{
			switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		int _cnt18471=0;
		_loop18471:
		do {
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
			case '\n':
			{
				match('\n');
				newline();
				break;
			}
			default:
				if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true)) {
					match("\r\n");
					newline();
				}
				else if ((LA(1)=='\r') && (true) && (true) && (true)) {
					match('\r');
					newline();
				}
			else {
				if ( _cnt18471>=1 ) { break _loop18471; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt18471++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSTRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STRING;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '"':
		{
			match('"');
			{
			_loop18486:
			do {
				if ((_tokenSet_3.member(LA(1)))) {
					matchNot('"');
				}
				else {
					break _loop18486;
				}
				
			} while (true);
			}
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			{
			_loop18488:
			do {
				if ((_tokenSet_4.member(LA(1)))) {
					matchNot('\'');
				}
				else {
					break _loop18488;
				}
				
			} while (true);
			}
			match('\'');
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
	
	public final void mOHTML(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OHTML;
		int _saveIndex;
		
		match("<html>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHTML(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHTML;
		int _saveIndex;
		
		match("</html>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOHEAD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OHEAD;
		int _saveIndex;
		
		match("<head>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHEAD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHEAD;
		int _saveIndex;
		
		match("</head>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOBODY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OBODY;
		int _saveIndex;
		
		match("<body");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18283:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18283;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mATTR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ATTR;
		int _saveIndex;
		
		mWORD(false);
		{
		switch ( LA(1)) {
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
		switch ( LA(1)) {
		case '=':
		{
			match('=');
			{
			switch ( LA(1)) {
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
			switch ( LA(1)) {
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
				switch ( LA(1)) {
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
				switch ( LA(1)) {
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
			switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCBODY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CBODY;
		int _saveIndex;
		
		match("</body>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOTITLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OTITLE;
		int _saveIndex;
		
		match("<title>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCTITLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CTITLE;
		int _saveIndex;
		
		match("</title>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSCRIPT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSCRIPT;
		int _saveIndex;
		
		match("<script>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCSCRIPT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CSCRIPT;
		int _saveIndex;
		
		match("</script>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mISINDEX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ISINDEX;
		int _saveIndex;
		
		match("<isindex");
		mWS(false);
		mATTR(false);
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMETA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = META;
		int _saveIndex;
		
		match("<meta");
		mWS(false);
		{
		int _cnt18292=0;
		_loop18292:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18292>=1 ) { break _loop18292; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18292++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLINK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LINK;
		int _saveIndex;
		
		match("<link");
		mWS(false);
		{
		int _cnt18295=0;
		_loop18295:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18295>=1 ) { break _loop18295; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18295++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH1;
		int _saveIndex;
		
		match("<h1");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH1;
		int _saveIndex;
		
		match("</h1>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH2;
		int _saveIndex;
		
		match("<h2");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH2;
		int _saveIndex;
		
		match("</h2>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH3;
		int _saveIndex;
		
		match("<h3");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH3;
		int _saveIndex;
		
		match("</h3>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH4(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH4;
		int _saveIndex;
		
		match("<h4");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH4(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH4;
		int _saveIndex;
		
		match("</h4>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH5(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH5;
		int _saveIndex;
		
		match("<h5");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH5(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH5;
		int _saveIndex;
		
		match("</h5>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOH6(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OH6;
		int _saveIndex;
		
		match("<h6");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCH6(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CH6;
		int _saveIndex;
		
		match("</h6>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOADDRESS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OADDRESS;
		int _saveIndex;
		
		match("<address>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCADDRESS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CADDRESS;
		int _saveIndex;
		
		match("</address>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOPARA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPARA;
		int _saveIndex;
		
		match("<p");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCPARA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CPARA;
		int _saveIndex;
		
		match("</p>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOULIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OULIST;
		int _saveIndex;
		
		match("<ul");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCULIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CULIST;
		int _saveIndex;
		
		match("</ul>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOOLIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OOLIST;
		int _saveIndex;
		
		match("<ol");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLIST;
		int _saveIndex;
		
		match("</ol>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOLITEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OLITEM;
		int _saveIndex;
		
		match("<li");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCLITEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CLITEM;
		int _saveIndex;
		
		match("</li>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODLIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODLIST;
		int _saveIndex;
		
		match("<dl");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCDLIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CDLIST;
		int _saveIndex;
		
		match("</dl>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODTERM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODTERM;
		int _saveIndex;
		
		match("<dt>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCDTERM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CDTERM;
		int _saveIndex;
		
		match("</dt>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODDEF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODDEF;
		int _saveIndex;
		
		match("<dd>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCDDEF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CDDEF;
		int _saveIndex;
		
		match("</dd>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODIR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODIR;
		int _saveIndex;
		
		match("<dir>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCDIR_OR_CDIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CDIR_OR_CDIV;
		int _saveIndex;
		
		match("</di");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODIV;
		int _saveIndex;
		
		match("<div");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOMENU(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OMENU;
		int _saveIndex;
		
		match("<menu>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCMENU(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CMENU;
		int _saveIndex;
		
		match("</menu>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOPRE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPRE;
		int _saveIndex;
		
		{
		if ((LA(1)=='<') && (LA(2)=='p')) {
			match("<pre>");
		}
		else if ((LA(1)=='<') && (LA(2)=='x')) {
			match("<xmp>");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		if ((LA(1)=='\n')) {
			match('\n');
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCPRE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CPRE;
		int _saveIndex;
		
		if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='p')) {
			match("</pre>");
		}
		else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='x')) {
			match("</xmp>");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOCENTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OCENTER;
		int _saveIndex;
		
		match("<center>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCCENTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CCENTER;
		int _saveIndex;
		
		match("</center>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOBQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OBQUOTE;
		int _saveIndex;
		
		match("<blockquote>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCBQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CBQUOTE;
		int _saveIndex;
		
		match("</blockquote>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mHR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HR;
		int _saveIndex;
		
		match("<hr");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18353:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18353;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOTABLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OTABLE;
		int _saveIndex;
		
		match("<table");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18357:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18357;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCTABLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CTABLE;
		int _saveIndex;
		
		match("</table>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOCAP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OCAP;
		int _saveIndex;
		
		match("<caption");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18362:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18362;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCCAP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CCAP;
		int _saveIndex;
		
		match("</caption>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mO_TR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = O_TR;
		int _saveIndex;
		
		match("<tr");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18367:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18367;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mC_TR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = C_TR;
		int _saveIndex;
		
		match("</tr>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mO_TH_OR_TD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = O_TH_OR_TD;
		int _saveIndex;
		
		{
		if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='h')) {
			match("<th");
		}
		else if ((LA(1)=='<') && (LA(2)=='t') && (LA(3)=='d')) {
			match("<td");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18373:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18373;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mC_TH_OR_TD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = C_TH_OR_TD;
		int _saveIndex;
		
		if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='h')) {
			match("</th>");
		}
		else if ((LA(1)=='<') && (LA(2)=='/') && (LA(3)=='t') && (LA(4)=='d')) {
			match("</td>");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOTTYPE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OTTYPE;
		int _saveIndex;
		
		match("<tt>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCTTYPE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CTTYPE;
		int _saveIndex;
		
		match("</tt>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOITALIC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OITALIC;
		int _saveIndex;
		
		match("<i>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCITALIC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CITALIC;
		int _saveIndex;
		
		match("</i>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOBOLD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OBOLD;
		int _saveIndex;
		
		match("<b>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCBOLD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CBOLD;
		int _saveIndex;
		
		match("</b>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOUNDER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OUNDER;
		int _saveIndex;
		
		match("<u>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCUNDER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CUNDER;
		int _saveIndex;
		
		match("</u>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
/** Left-factor <strike> and <strong> to reduce lookahead */
	public final void mOSTRIKE_OR_OSTRONG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSTRIKE_OR_OSTRONG;
		int _saveIndex;
		
		match("<str");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCST_LEFT_FACTORED(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CST_LEFT_FACTORED;
		int _saveIndex;
		
		match("</st");
		{
		if ((LA(1)=='r') && (LA(2)=='i')) {
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
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSTYLE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSTYLE;
		int _saveIndex;
		
		match("<style>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOBIG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OBIG;
		int _saveIndex;
		
		match("<big>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCBIG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CBIG;
		int _saveIndex;
		
		match("</big>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSMALL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSMALL;
		int _saveIndex;
		
		match("<small>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCSMALL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CSMALL;
		int _saveIndex;
		
		match("</small>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSUB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSUB;
		int _saveIndex;
		
		match("<sub>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSUP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSUP;
		int _saveIndex;
		
		match("<sup>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCSUB_OR_CSUP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CSUB_OR_CSUP;
		int _saveIndex;
		
		match("</su");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OEM;
		int _saveIndex;
		
		match("<em>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CEM;
		int _saveIndex;
		
		match("</em>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mODFN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ODFN;
		int _saveIndex;
		
		match("<dfn>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCDFN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CDFN;
		int _saveIndex;
		
		match("</dfn>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOCODE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OCODE;
		int _saveIndex;
		
		match("<code>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCCODE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CCODE;
		int _saveIndex;
		
		match("</code>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSAMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSAMP;
		int _saveIndex;
		
		match("<samp>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCSAMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CSAMP;
		int _saveIndex;
		
		match("</samp>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOKBD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OKBD;
		int _saveIndex;
		
		match("<kbd>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCKBD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CKBD;
		int _saveIndex;
		
		match("</kbd>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOVAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OVAR;
		int _saveIndex;
		
		match("<var>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCVAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CVAR;
		int _saveIndex;
		
		match("</var>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOCITE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OCITE;
		int _saveIndex;
		
		match("<cite>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCCITE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CCITE;
		int _saveIndex;
		
		match("</cite>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINPUT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INPUT;
		int _saveIndex;
		
		match("<input");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18413:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18413;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOSELECT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OSELECT;
		int _saveIndex;
		
		match("<select");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18417:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18417;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCSELECT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CSELECT;
		int _saveIndex;
		
		match("</select>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOTAREA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OTAREA;
		int _saveIndex;
		
		match("<textarea");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18422:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18422;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCTAREA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CTAREA;
		int _saveIndex;
		
		match("</textarea>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSELOPT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SELOPT;
		int _saveIndex;
		
		match("<option");
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			{
			_loop18427:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					mATTR(false);
				}
				else {
					break _loop18427;
				}
				
			} while (true);
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOANCHOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OANCHOR;
		int _saveIndex;
		
		match("<a");
		mWS(false);
		{
		int _cnt18430=0;
		_loop18430:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18430>=1 ) { break _loop18430; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18430++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCANCHOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CANCHOR;
		int _saveIndex;
		
		match("</a>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIMG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IMG;
		int _saveIndex;
		
		match("<img");
		mWS(false);
		{
		int _cnt18434=0;
		_loop18434:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18434>=1 ) { break _loop18434; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18434++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOAPPLET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OAPPLET;
		int _saveIndex;
		
		match("<applet");
		mWS(false);
		{
		int _cnt18437=0;
		_loop18437:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18437>=1 ) { break _loop18437; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18437++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCAPPLET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CAPPLET;
		int _saveIndex;
		
		match("</applet>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAPARM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = APARM;
		int _saveIndex;
		
		match("<param");
		mWS(false);
		{
		int _cnt18441=0;
		_loop18441:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18441>=1 ) { break _loop18441; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18441++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOFORM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OFORM;
		int _saveIndex;
		
		match("<form");
		mWS(false);
		{
		int _cnt18444=0;
		_loop18444:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18444>=1 ) { break _loop18444; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18444++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOFONT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OFONT;
		int _saveIndex;
		
		match("<font");
		mWS(false);
		{
		int _cnt18447=0;
		_loop18447:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18447>=1 ) { break _loop18447; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18447++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCFORM_OR_CFONT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CFORM_OR_CFONT;
		int _saveIndex;
		
		match("</fo");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBFONT_OR_BASE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BFONT_OR_BASE;
		int _saveIndex;
		
		match("<base");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BR;
		int _saveIndex;
		
		match("<br");
		{
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOMAP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OMAP;
		int _saveIndex;
		
		match("<map");
		mWS(false);
		mATTR(false);
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCMAP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CMAP;
		int _saveIndex;
		
		match("</map>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAREA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AREA;
		int _saveIndex;
		
		match("<area");
		mWS(false);
		{
		int _cnt18458=0;
		_loop18458:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				mATTR(false);
			}
			else {
				if ( _cnt18458>=1 ) { break _loop18458; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18458++;
		} while (true);
		}
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPCDATA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PCDATA;
		int _saveIndex;
		
		{
		int _cnt18462=0;
		_loop18462:
		do {
			if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true)) {
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
			else if ((_tokenSet_6.member(LA(1)))) {
				{
				match(_tokenSet_6);
				}
			}
			else {
				if ( _cnt18462>=1 ) { break _loop18462; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18462++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mCOMMENT_DATA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT_DATA;
		int _saveIndex;
		
		{
		_loop18466:
		do {
			if (((LA(1)=='-') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0003' && LA(3) <= '\u00ff')) && ((LA(4) >= '\u0003' && LA(4) <= '\u00ff')))&&(!(LA(2)=='-' && LA(3)=='>'))) {
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
			else if ((_tokenSet_7.member(LA(1)))) {
				{
				match(_tokenSet_7);
				}
			}
			else {
				break _loop18466;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		Token c=null;
		
		match("<!--");
		mCOMMENT_DATA(true);
		c=_returnToken;
		match("-->");
		{
		if ((_tokenSet_1.member(LA(1)))) {
			mWS(false);
		}
		else {
		}
		
		}
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mWORD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WORD;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
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
		{
		int _cnt18483=0;
		_loop18483:
		do {
			if (((LA(1) >= 'a' && LA(1) <= 'z')) && (_tokenSet_8.member(LA(2))) && (true) && (true)) {
				mLCLETTER(false);
			}
			else if ((LA(1)=='.') && (_tokenSet_8.member(LA(2))) && (true) && (true)) {
				match('.');
			}
			else if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGIT(false);
			}
			else {
				if ( _cnt18483>=1 ) { break _loop18483; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18483++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT;
		int _saveIndex;
		
		{
		int _cnt18494=0;
		_loop18494:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGIT(false);
			}
			else {
				if ( _cnt18494>=1 ) { break _loop18494; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18494++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEXNUM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEXNUM;
		int _saveIndex;
		
		match('#');
		mHEXINT(false);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLCLETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LCLETTER;
		int _saveIndex;
		
		matchRange('a','z');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGIT;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mWSCHARS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WSCHARS;
		int _saveIndex;
		
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSPECIAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SPECIAL;
		int _saveIndex;
		
		switch ( LA(1)) {
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEXINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEXINT;
		int _saveIndex;
		
		{
		int _cnt18497=0;
		_loop18497:
		do {
			if ((_tokenSet_9.member(LA(1))) && (_tokenSet_10.member(LA(2))) && (true) && (true)) {
				mHEXDIGIT(false);
			}
			else {
				if ( _cnt18497>=1 ) { break _loop18497; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt18497++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mHEXDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = HEXDIGIT;
		int _saveIndex;
		
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
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNDEFINED_TOKEN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNDEFINED_TOKEN;
		int _saveIndex;
		
		if ((LA(1)=='<') && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
			match('<');
			{
			_loop18503:
			do {
				if ((_tokenSet_11.member(LA(1)))) {
					matchNot('>');
				}
				else {
					break _loop18503;
				}
				
			} while (true);
			}
			match('>');
			{
			_loop18506:
			do {
				if ((LA(1)=='\n'||LA(1)=='\r')) {
					{
					if ((LA(1)=='\r') && (LA(2)=='\n') && (true) && (true)) {
						match("\r\n");
					}
					else if ((LA(1)=='\r') && (true) && (true) && (true)) {
						match('\r');
					}
					else if ((LA(1)=='\n')) {
						match('\n');
					}
					else {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					
					}
					newline();
				}
				else {
					break _loop18506;
				}
				
			} while (true);
			}
			System.err.println("invalid tag: "+new String(text.getBuffer(),_begin,text.length()-_begin));
		}
		else if ((LA(1)=='\n'||LA(1)=='\r') && (true) && (true) && (true)) {
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
			newline();
		}
		else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true) && (true) && (true)) {
			matchNot(EOF_CHAR);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 4611686022722364928L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 4294977024L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=-5764607540214104072L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
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
		long[] data = new long[8];
		data[0]=-549755813896L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 70368744177664L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[8];
		data[0]=-5764607540214113288L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[8];
		data[0]=-35184372098056L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 7205548439294191104L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 287948901175001088L, 541165879296L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 4899705292641543680L, 576460743713488896L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[8];
		data[0]=-4611686018427387912L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	
	}
