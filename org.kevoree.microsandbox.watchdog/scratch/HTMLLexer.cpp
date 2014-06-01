/* $ANTLR 2.7.2: "html.g" -> "HTMLLexer.cpp"$ */
#include "HTMLLexer.hpp"
#include <antlr/CharBuffer.hpp>
#include <antlr/TokenStreamException.hpp>
#include <antlr/TokenStreamIOException.hpp>
#include <antlr/TokenStreamRecognitionException.hpp>
#include <antlr/CharStreamException.hpp>
#include <antlr/CharStreamIOException.hpp>
#include <antlr/NoViableAltForCharException.hpp>

#line 1 "html.g"
#line 13 "HTMLLexer.cpp"
HTMLLexer::HTMLLexer(ANTLR_USE_NAMESPACE(std)istream& in)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(new ANTLR_USE_NAMESPACE(antlr)CharBuffer(in),false)
{
	initLiterals();
}

HTMLLexer::HTMLLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(ib,false)
{
	initLiterals();
}

HTMLLexer::HTMLLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(state,false)
{
	initLiterals();
}

void HTMLLexer::initLiterals()
{
}

ANTLR_USE_NAMESPACE(antlr)RefToken HTMLLexer::nextToken()
{
	ANTLR_USE_NAMESPACE(antlr)RefToken theRetToken;
	for (;;) {
		ANTLR_USE_NAMESPACE(antlr)RefToken theRetToken;
		int _ttype = ANTLR_USE_NAMESPACE(antlr)Token::INVALID_TYPE;
		setCommitToPath(false);
		int _m;
		_m = mark();
		resetText();
		try {   // for lexical and char stream error handling
			if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('t'))) {
				mCHTML(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('e'))) {
				mCHEAD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('b')) && (LA(4) == static_cast<unsigned char>('o'))) {
				mCBODY(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('i'))) {
				mCTITLE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('c'))) {
				mCSCRIPT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('m')) && (LA(3) == static_cast<unsigned char>('e')) && (LA(4) == static_cast<unsigned char>('t'))) {
				mMETA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('l')) && (LA(3) == static_cast<unsigned char>('i')) && (LA(4) == static_cast<unsigned char>('n'))) {
				mLINK(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('1'))) {
				mCH1(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('2'))) {
				mCH2(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('3'))) {
				mCH3(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('4'))) {
				mCH4(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('5'))) {
				mCH5(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('h')) && (LA(4) == static_cast<unsigned char>('6'))) {
				mCH6(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('a')) && (LA(4) == static_cast<unsigned char>('d'))) {
				mCADDRESS(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('p')) && (LA(4) == static_cast<unsigned char>('>'))) {
				mCPARA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('u')) && (LA(4) == static_cast<unsigned char>('l'))) {
				mCULIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('l')) && (LA(3) == static_cast<unsigned char>('i')) && (_tokenSet_0.member(LA(4)))) {
				mOLITEM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('d')) && (LA(4) == static_cast<unsigned char>('l'))) {
				mCDLIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('d')) && (LA(4) == static_cast<unsigned char>('t'))) {
				mCDTERM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('d')) && (LA(4) == static_cast<unsigned char>('d'))) {
				mCDDEF(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('i')) && (LA(4) == static_cast<unsigned char>('r'))) {
				mODIR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('d')) && (LA(4) == static_cast<unsigned char>('i'))) {
				mCDIR_OR_CDIV(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('i')) && (LA(4) == static_cast<unsigned char>('v'))) {
				mODIV(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('m')) && (LA(3) == static_cast<unsigned char>('e')) && (LA(4) == static_cast<unsigned char>('n'))) {
				mOMENU(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('m')) && (LA(4) == static_cast<unsigned char>('e'))) {
				mCMENU(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('p') || LA(3) == static_cast<unsigned char>('x')) && (LA(4) == static_cast<unsigned char>('m') || LA(4) == static_cast<unsigned char>('r'))) {
				mCPRE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('c')) && (LA(4) == static_cast<unsigned char>('e'))) {
				mCCENTER(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('b')) && (LA(4) == static_cast<unsigned char>('l'))) {
				mCBQUOTE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('a'))) {
				mCTABLE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('c')) && (LA(4) == static_cast<unsigned char>('a'))) {
				mCCAP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('r'))) {
				mC_TR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('d') || LA(4) == static_cast<unsigned char>('h'))) {
				mC_TH_OR_TD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('t'))) {
				mCTTYPE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('b')) && (LA(4) == static_cast<unsigned char>('>'))) {
				mCBOLD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('u')) && (LA(4) == static_cast<unsigned char>('>'))) {
				mCUNDER(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('r'))) {
				mOSTRIKE_OR_OSTRONG(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('t'))) {
				mCST_LEFT_FACTORED(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('y'))) {
				mOSTYLE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('b')) && (LA(4) == static_cast<unsigned char>('i'))) {
				mCBIG(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('m'))) {
				mCSMALL(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('u')) && (LA(4) == static_cast<unsigned char>('b'))) {
				mOSUB(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('u')) && (LA(4) == static_cast<unsigned char>('p'))) {
				mOSUP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('u'))) {
				mCSUB_OR_CSUP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('d')) && (LA(4) == static_cast<unsigned char>('f'))) {
				mCDFN(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('c')) && (LA(4) == static_cast<unsigned char>('o'))) {
				mCCODE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('a'))) {
				mCSAMP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('c')) && (LA(4) == static_cast<unsigned char>('i'))) {
				mCCITE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('s')) && (LA(4) == static_cast<unsigned char>('e'))) {
				mCSELECT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('e'))) {
				mCTAREA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('a')) && (LA(4) == static_cast<unsigned char>('>'))) {
				mCANCHOR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('a')) && (LA(4) == static_cast<unsigned char>('p'))) {
				mCAPPLET(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('f')) && (LA(3) == static_cast<unsigned char>('o')) && (LA(4) == static_cast<unsigned char>('r'))) {
				mOFORM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('f')) && (LA(3) == static_cast<unsigned char>('o')) && (LA(4) == static_cast<unsigned char>('n'))) {
				mOFONT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('m')) && (LA(4) == static_cast<unsigned char>('a'))) {
				mCMAP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('!')) && (LA(3) == static_cast<unsigned char>('d'))) {
				mDOCTYPE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('t'))) {
				mOHTML(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('e'))) {
				mOHEAD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('o'))) {
				mOBODY(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('i'))) {
				mOTITLE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('c'))) {
				mOSCRIPT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('i')) && (LA(3) == static_cast<unsigned char>('s'))) {
				mISINDEX(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('1'))) {
				mOH1(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('2'))) {
				mOH2(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('3'))) {
				mOH3(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('4'))) {
				mOH4(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('5'))) {
				mOH5(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('6'))) {
				mOH6(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('a')) && (LA(3) == static_cast<unsigned char>('d'))) {
				mOADDRESS(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('p')) && (_tokenSet_0.member(LA(3)))) {
				mOPARA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('u')) && (LA(3) == static_cast<unsigned char>('l'))) {
				mOULIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('o')) && (LA(3) == static_cast<unsigned char>('l'))) {
				mOOLIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('o'))) {
				mCOLIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('l'))) {
				mCLITEM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('l'))) {
				mODLIST(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('t'))) {
				mODTERM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('d'))) {
				mODDEF(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('p') || LA(2) == static_cast<unsigned char>('x')) && (LA(3) == static_cast<unsigned char>('m') || LA(3) == static_cast<unsigned char>('r'))) {
				mOPRE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('c')) && (LA(3) == static_cast<unsigned char>('e'))) {
				mOCENTER(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('l'))) {
				mOBQUOTE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('h')) && (LA(3) == static_cast<unsigned char>('r'))) {
				mHR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mOTABLE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('c')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mOCAP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('r'))) {
				mO_TR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('d') || LA(3) == static_cast<unsigned char>('h'))) {
				mO_TH_OR_TD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('t'))) {
				mOTTYPE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('i')) && (LA(3) == static_cast<unsigned char>('>'))) {
				mOITALIC(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('i'))) {
				mCITALIC(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('>'))) {
				mOBOLD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('u')) && (LA(3) == static_cast<unsigned char>('>'))) {
				mOUNDER(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('i'))) {
				mOBIG(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('m'))) {
				mOSMALL(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('e'))) {
				mCEM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('d')) && (LA(3) == static_cast<unsigned char>('f'))) {
				mODFN(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('c')) && (LA(3) == static_cast<unsigned char>('o'))) {
				mOCODE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mOSAMP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('k'))) {
				mCKBD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('v'))) {
				mCVAR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('c')) && (LA(3) == static_cast<unsigned char>('i'))) {
				mOCITE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('i')) && (LA(3) == static_cast<unsigned char>('n'))) {
				mINPUT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('s')) && (LA(3) == static_cast<unsigned char>('e'))) {
				mOSELECT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('e'))) {
				mOTAREA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('o')) && (LA(3) == static_cast<unsigned char>('p'))) {
				mSELOPT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('a')) && (_tokenSet_1.member(LA(3)))) {
				mOANCHOR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('i')) && (LA(3) == static_cast<unsigned char>('m'))) {
				mIMG(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('a')) && (LA(3) == static_cast<unsigned char>('p'))) {
				mOAPPLET(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('p')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mAPARM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('f'))) {
				mCFORM_OR_CFONT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mBFONT_OR_BASE(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('b')) && (LA(3) == static_cast<unsigned char>('r'))) {
				mBR(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('m')) && (LA(3) == static_cast<unsigned char>('a'))) {
				mOMAP(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('a')) && (LA(3) == static_cast<unsigned char>('r'))) {
				mAREA(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('!')) && (LA(3) == static_cast<unsigned char>('-'))) {
				mCOMMENT(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('e'))) {
				mOEM(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('k'))) {
				mOKBD(true);
				theRetToken=_returnToken;
			}
			else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('v'))) {
				mOVAR(true);
				theRetToken=_returnToken;
			}
			else if ((_tokenSet_2.member(LA(1)))) {
				mPCDATA(true);
				theRetToken=_returnToken;
			}
			else {
				if (LA(1)==EOF_CHAR)
				{
					uponEOF();
					_returnToken = makeToken(ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE);
				}
				else {
					commit();
					try {mUNDEFINED_TOKEN(false);}
					catch(ANTLR_USE_NAMESPACE(antlr)RecognitionException& e) {
						// catastrophic failure
						reportError(e);
						consume();
					}
					goto tryAgain;
				}
			}
			
			commit();
			if ( !_returnToken )
				goto tryAgain; // found SKIP token

			_ttype = _returnToken->getType();
			_ttype = testLiteralsTable(_ttype);
			_returnToken->setType(_ttype);
			return _returnToken;
		}
		catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& e) {
			if ( !getCommitToPath() ) {
				rewind(_m);
				resetText();
				try {mUNDEFINED_TOKEN(false);}
				catch(ANTLR_USE_NAMESPACE(antlr)RecognitionException& ee) {
					// horrendous failure: error in filter rule
					reportError(ee);
					consume();
				}
			}
			else
				throw ANTLR_USE_NAMESPACE(antlr)TokenStreamRecognitionException(e);
		}
		catch (ANTLR_USE_NAMESPACE(antlr)CharStreamIOException& csie) {
			throw ANTLR_USE_NAMESPACE(antlr)TokenStreamIOException(csie.io);
		}
		catch (ANTLR_USE_NAMESPACE(antlr)CharStreamException& cse) {
			throw ANTLR_USE_NAMESPACE(antlr)TokenStreamException(cse.getMessage());
		}
tryAgain:;
	}
}

void HTMLLexer::mDOCTYPE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = DOCTYPE;
	int _saveIndex;
	
	match("<!doctype");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('h'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match("html");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('p'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match("public");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('"'):
	case static_cast<unsigned char>('\''):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	mSTRING(false);
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mWS_(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = WS_;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt20765=0;
	for (;;) {
		switch ( LA(1)) {
		case static_cast<unsigned char>(' '):
		{
			match(static_cast<unsigned char>(' '));
			break;
		}
		case static_cast<unsigned char>('\t'):
		{
			match(static_cast<unsigned char>('\t'));
			break;
		}
		case static_cast<unsigned char>('\n'):
		{
			match(static_cast<unsigned char>('\n'));
#line 951 "html.g"
			newline();
#line 693 "HTMLLexer.cpp"
			break;
		}
		default:
			if ((LA(1) == static_cast<unsigned char>('\r')) && (LA(2) == static_cast<unsigned char>('\n')) && (_tokenSet_3.member(LA(3))) && (true)) {
				match("\r\n");
#line 952 "html.g"
				newline();
#line 701 "HTMLLexer.cpp"
			}
			else if ((LA(1) == static_cast<unsigned char>('\r')) && (_tokenSet_3.member(LA(2))) && (true) && (true)) {
				match(static_cast<unsigned char>('\r'));
#line 953 "html.g"
				newline();
#line 707 "HTMLLexer.cpp"
			}
		else {
			if ( _cnt20765>=1 ) { goto _loop20765; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		}
		_cnt20765++;
	}
	_loop20765:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mSTRING(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = STRING;
	int _saveIndex;
	
	switch ( LA(1)) {
	case static_cast<unsigned char>('"'):
	{
		match(static_cast<unsigned char>('"'));
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_4.member(LA(1)))) {
				matchNot(static_cast<unsigned char>('"'));
			}
			else {
				goto _loop20785;
			}
			
		}
		_loop20785:;
		} // ( ... )*
		match(static_cast<unsigned char>('"'));
		break;
	}
	case static_cast<unsigned char>('\''):
	{
		match(static_cast<unsigned char>('\''));
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_5.member(LA(1)))) {
				matchNot(static_cast<unsigned char>('\''));
			}
			else {
				goto _loop20787;
			}
			
		}
		_loop20787:;
		} // ( ... )*
		match(static_cast<unsigned char>('\''));
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOHTML(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OHTML;
	int _saveIndex;
	
	match("<html>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCHTML(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CHTML;
	int _saveIndex;
	
	match("</html>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOHEAD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OHEAD;
	int _saveIndex;
	
	match("<head>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCHEAD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CHEAD;
	int _saveIndex;
	
	match("</head>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOBODY(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OBODY;
	int _saveIndex;
	
	match("<body");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20578;
			}
			
		}
		_loop20578:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mATTR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ATTR;
	int _saveIndex;
	
	mWORD(false);
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('.'):
	case static_cast<unsigned char>('='):
	case static_cast<unsigned char>('>'):
	case static_cast<unsigned char>('a'):
	case static_cast<unsigned char>('b'):
	case static_cast<unsigned char>('c'):
	case static_cast<unsigned char>('d'):
	case static_cast<unsigned char>('e'):
	case static_cast<unsigned char>('f'):
	case static_cast<unsigned char>('g'):
	case static_cast<unsigned char>('h'):
	case static_cast<unsigned char>('i'):
	case static_cast<unsigned char>('j'):
	case static_cast<unsigned char>('k'):
	case static_cast<unsigned char>('l'):
	case static_cast<unsigned char>('m'):
	case static_cast<unsigned char>('n'):
	case static_cast<unsigned char>('o'):
	case static_cast<unsigned char>('p'):
	case static_cast<unsigned char>('q'):
	case static_cast<unsigned char>('r'):
	case static_cast<unsigned char>('s'):
	case static_cast<unsigned char>('t'):
	case static_cast<unsigned char>('u'):
	case static_cast<unsigned char>('v'):
	case static_cast<unsigned char>('w'):
	case static_cast<unsigned char>('x'):
	case static_cast<unsigned char>('y'):
	case static_cast<unsigned char>('z'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('='):
	{
		match(static_cast<unsigned char>('='));
		{
		switch ( LA(1)) {
		case static_cast<unsigned char>('\t'):
		case static_cast<unsigned char>('\n'):
		case static_cast<unsigned char>('\r'):
		case static_cast<unsigned char>(' '):
		{
			_saveIndex = text.length();
			mWS_(false);
			text.erase(_saveIndex);
			break;
		}
		case static_cast<unsigned char>('"'):
		case static_cast<unsigned char>('#'):
		case static_cast<unsigned char>('\''):
		case static_cast<unsigned char>('-'):
		case static_cast<unsigned char>('.'):
		case static_cast<unsigned char>('0'):
		case static_cast<unsigned char>('1'):
		case static_cast<unsigned char>('2'):
		case static_cast<unsigned char>('3'):
		case static_cast<unsigned char>('4'):
		case static_cast<unsigned char>('5'):
		case static_cast<unsigned char>('6'):
		case static_cast<unsigned char>('7'):
		case static_cast<unsigned char>('8'):
		case static_cast<unsigned char>('9'):
		case static_cast<unsigned char>('a'):
		case static_cast<unsigned char>('b'):
		case static_cast<unsigned char>('c'):
		case static_cast<unsigned char>('d'):
		case static_cast<unsigned char>('e'):
		case static_cast<unsigned char>('f'):
		case static_cast<unsigned char>('g'):
		case static_cast<unsigned char>('h'):
		case static_cast<unsigned char>('i'):
		case static_cast<unsigned char>('j'):
		case static_cast<unsigned char>('k'):
		case static_cast<unsigned char>('l'):
		case static_cast<unsigned char>('m'):
		case static_cast<unsigned char>('n'):
		case static_cast<unsigned char>('o'):
		case static_cast<unsigned char>('p'):
		case static_cast<unsigned char>('q'):
		case static_cast<unsigned char>('r'):
		case static_cast<unsigned char>('s'):
		case static_cast<unsigned char>('t'):
		case static_cast<unsigned char>('u'):
		case static_cast<unsigned char>('v'):
		case static_cast<unsigned char>('w'):
		case static_cast<unsigned char>('x'):
		case static_cast<unsigned char>('y'):
		case static_cast<unsigned char>('z'):
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case static_cast<unsigned char>('.'):
		case static_cast<unsigned char>('a'):
		case static_cast<unsigned char>('b'):
		case static_cast<unsigned char>('c'):
		case static_cast<unsigned char>('d'):
		case static_cast<unsigned char>('e'):
		case static_cast<unsigned char>('f'):
		case static_cast<unsigned char>('g'):
		case static_cast<unsigned char>('h'):
		case static_cast<unsigned char>('i'):
		case static_cast<unsigned char>('j'):
		case static_cast<unsigned char>('k'):
		case static_cast<unsigned char>('l'):
		case static_cast<unsigned char>('m'):
		case static_cast<unsigned char>('n'):
		case static_cast<unsigned char>('o'):
		case static_cast<unsigned char>('p'):
		case static_cast<unsigned char>('q'):
		case static_cast<unsigned char>('r'):
		case static_cast<unsigned char>('s'):
		case static_cast<unsigned char>('t'):
		case static_cast<unsigned char>('u'):
		case static_cast<unsigned char>('v'):
		case static_cast<unsigned char>('w'):
		case static_cast<unsigned char>('x'):
		case static_cast<unsigned char>('y'):
		case static_cast<unsigned char>('z'):
		{
			mWORD(false);
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('\t'):
			case static_cast<unsigned char>('\n'):
			case static_cast<unsigned char>('\r'):
			case static_cast<unsigned char>(' '):
			{
				_saveIndex = text.length();
				mWS_(false);
				text.erase(_saveIndex);
				break;
			}
			case static_cast<unsigned char>('%'):
			case static_cast<unsigned char>('.'):
			case static_cast<unsigned char>('>'):
			case static_cast<unsigned char>('a'):
			case static_cast<unsigned char>('b'):
			case static_cast<unsigned char>('c'):
			case static_cast<unsigned char>('d'):
			case static_cast<unsigned char>('e'):
			case static_cast<unsigned char>('f'):
			case static_cast<unsigned char>('g'):
			case static_cast<unsigned char>('h'):
			case static_cast<unsigned char>('i'):
			case static_cast<unsigned char>('j'):
			case static_cast<unsigned char>('k'):
			case static_cast<unsigned char>('l'):
			case static_cast<unsigned char>('m'):
			case static_cast<unsigned char>('n'):
			case static_cast<unsigned char>('o'):
			case static_cast<unsigned char>('p'):
			case static_cast<unsigned char>('q'):
			case static_cast<unsigned char>('r'):
			case static_cast<unsigned char>('s'):
			case static_cast<unsigned char>('t'):
			case static_cast<unsigned char>('u'):
			case static_cast<unsigned char>('v'):
			case static_cast<unsigned char>('w'):
			case static_cast<unsigned char>('x'):
			case static_cast<unsigned char>('y'):
			case static_cast<unsigned char>('z'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('%'):
			{
				match(static_cast<unsigned char>('%'));
				{
				switch ( LA(1)) {
				case static_cast<unsigned char>('\t'):
				case static_cast<unsigned char>('\n'):
				case static_cast<unsigned char>('\r'):
				case static_cast<unsigned char>(' '):
				{
					_saveIndex = text.length();
					mWS_(false);
					text.erase(_saveIndex);
					break;
				}
				case static_cast<unsigned char>('.'):
				case static_cast<unsigned char>('>'):
				case static_cast<unsigned char>('a'):
				case static_cast<unsigned char>('b'):
				case static_cast<unsigned char>('c'):
				case static_cast<unsigned char>('d'):
				case static_cast<unsigned char>('e'):
				case static_cast<unsigned char>('f'):
				case static_cast<unsigned char>('g'):
				case static_cast<unsigned char>('h'):
				case static_cast<unsigned char>('i'):
				case static_cast<unsigned char>('j'):
				case static_cast<unsigned char>('k'):
				case static_cast<unsigned char>('l'):
				case static_cast<unsigned char>('m'):
				case static_cast<unsigned char>('n'):
				case static_cast<unsigned char>('o'):
				case static_cast<unsigned char>('p'):
				case static_cast<unsigned char>('q'):
				case static_cast<unsigned char>('r'):
				case static_cast<unsigned char>('s'):
				case static_cast<unsigned char>('t'):
				case static_cast<unsigned char>('u'):
				case static_cast<unsigned char>('v'):
				case static_cast<unsigned char>('w'):
				case static_cast<unsigned char>('x'):
				case static_cast<unsigned char>('y'):
				case static_cast<unsigned char>('z'):
				{
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				break;
			}
			case static_cast<unsigned char>('.'):
			case static_cast<unsigned char>('>'):
			case static_cast<unsigned char>('a'):
			case static_cast<unsigned char>('b'):
			case static_cast<unsigned char>('c'):
			case static_cast<unsigned char>('d'):
			case static_cast<unsigned char>('e'):
			case static_cast<unsigned char>('f'):
			case static_cast<unsigned char>('g'):
			case static_cast<unsigned char>('h'):
			case static_cast<unsigned char>('i'):
			case static_cast<unsigned char>('j'):
			case static_cast<unsigned char>('k'):
			case static_cast<unsigned char>('l'):
			case static_cast<unsigned char>('m'):
			case static_cast<unsigned char>('n'):
			case static_cast<unsigned char>('o'):
			case static_cast<unsigned char>('p'):
			case static_cast<unsigned char>('q'):
			case static_cast<unsigned char>('r'):
			case static_cast<unsigned char>('s'):
			case static_cast<unsigned char>('t'):
			case static_cast<unsigned char>('u'):
			case static_cast<unsigned char>('v'):
			case static_cast<unsigned char>('w'):
			case static_cast<unsigned char>('x'):
			case static_cast<unsigned char>('y'):
			case static_cast<unsigned char>('z'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			break;
		}
		case static_cast<unsigned char>('-'):
		case static_cast<unsigned char>('0'):
		case static_cast<unsigned char>('1'):
		case static_cast<unsigned char>('2'):
		case static_cast<unsigned char>('3'):
		case static_cast<unsigned char>('4'):
		case static_cast<unsigned char>('5'):
		case static_cast<unsigned char>('6'):
		case static_cast<unsigned char>('7'):
		case static_cast<unsigned char>('8'):
		case static_cast<unsigned char>('9'):
		{
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('-'):
			{
				match(static_cast<unsigned char>('-'));
				{
				switch ( LA(1)) {
				case static_cast<unsigned char>('\t'):
				case static_cast<unsigned char>('\n'):
				case static_cast<unsigned char>('\r'):
				case static_cast<unsigned char>(' '):
				{
					_saveIndex = text.length();
					mWS_(false);
					text.erase(_saveIndex);
					break;
				}
				case static_cast<unsigned char>('0'):
				case static_cast<unsigned char>('1'):
				case static_cast<unsigned char>('2'):
				case static_cast<unsigned char>('3'):
				case static_cast<unsigned char>('4'):
				case static_cast<unsigned char>('5'):
				case static_cast<unsigned char>('6'):
				case static_cast<unsigned char>('7'):
				case static_cast<unsigned char>('8'):
				case static_cast<unsigned char>('9'):
				{
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				break;
			}
			case static_cast<unsigned char>('0'):
			case static_cast<unsigned char>('1'):
			case static_cast<unsigned char>('2'):
			case static_cast<unsigned char>('3'):
			case static_cast<unsigned char>('4'):
			case static_cast<unsigned char>('5'):
			case static_cast<unsigned char>('6'):
			case static_cast<unsigned char>('7'):
			case static_cast<unsigned char>('8'):
			case static_cast<unsigned char>('9'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			mINT(false);
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('\t'):
			case static_cast<unsigned char>('\n'):
			case static_cast<unsigned char>('\r'):
			case static_cast<unsigned char>(' '):
			{
				_saveIndex = text.length();
				mWS_(false);
				text.erase(_saveIndex);
				break;
			}
			case static_cast<unsigned char>('.'):
			case static_cast<unsigned char>('>'):
			case static_cast<unsigned char>('a'):
			case static_cast<unsigned char>('b'):
			case static_cast<unsigned char>('c'):
			case static_cast<unsigned char>('d'):
			case static_cast<unsigned char>('e'):
			case static_cast<unsigned char>('f'):
			case static_cast<unsigned char>('g'):
			case static_cast<unsigned char>('h'):
			case static_cast<unsigned char>('i'):
			case static_cast<unsigned char>('j'):
			case static_cast<unsigned char>('k'):
			case static_cast<unsigned char>('l'):
			case static_cast<unsigned char>('m'):
			case static_cast<unsigned char>('n'):
			case static_cast<unsigned char>('o'):
			case static_cast<unsigned char>('p'):
			case static_cast<unsigned char>('q'):
			case static_cast<unsigned char>('r'):
			case static_cast<unsigned char>('s'):
			case static_cast<unsigned char>('t'):
			case static_cast<unsigned char>('u'):
			case static_cast<unsigned char>('v'):
			case static_cast<unsigned char>('w'):
			case static_cast<unsigned char>('x'):
			case static_cast<unsigned char>('y'):
			case static_cast<unsigned char>('z'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			break;
		}
		case static_cast<unsigned char>('"'):
		case static_cast<unsigned char>('\''):
		{
			mSTRING(false);
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('\t'):
			case static_cast<unsigned char>('\n'):
			case static_cast<unsigned char>('\r'):
			case static_cast<unsigned char>(' '):
			{
				_saveIndex = text.length();
				mWS_(false);
				text.erase(_saveIndex);
				break;
			}
			case static_cast<unsigned char>('.'):
			case static_cast<unsigned char>('>'):
			case static_cast<unsigned char>('a'):
			case static_cast<unsigned char>('b'):
			case static_cast<unsigned char>('c'):
			case static_cast<unsigned char>('d'):
			case static_cast<unsigned char>('e'):
			case static_cast<unsigned char>('f'):
			case static_cast<unsigned char>('g'):
			case static_cast<unsigned char>('h'):
			case static_cast<unsigned char>('i'):
			case static_cast<unsigned char>('j'):
			case static_cast<unsigned char>('k'):
			case static_cast<unsigned char>('l'):
			case static_cast<unsigned char>('m'):
			case static_cast<unsigned char>('n'):
			case static_cast<unsigned char>('o'):
			case static_cast<unsigned char>('p'):
			case static_cast<unsigned char>('q'):
			case static_cast<unsigned char>('r'):
			case static_cast<unsigned char>('s'):
			case static_cast<unsigned char>('t'):
			case static_cast<unsigned char>('u'):
			case static_cast<unsigned char>('v'):
			case static_cast<unsigned char>('w'):
			case static_cast<unsigned char>('x'):
			case static_cast<unsigned char>('y'):
			case static_cast<unsigned char>('z'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			break;
		}
		case static_cast<unsigned char>('#'):
		{
			mHEXNUM(false);
			{
			switch ( LA(1)) {
			case static_cast<unsigned char>('\t'):
			case static_cast<unsigned char>('\n'):
			case static_cast<unsigned char>('\r'):
			case static_cast<unsigned char>(' '):
			{
				_saveIndex = text.length();
				mWS_(false);
				text.erase(_saveIndex);
				break;
			}
			case static_cast<unsigned char>('.'):
			case static_cast<unsigned char>('>'):
			case static_cast<unsigned char>('a'):
			case static_cast<unsigned char>('b'):
			case static_cast<unsigned char>('c'):
			case static_cast<unsigned char>('d'):
			case static_cast<unsigned char>('e'):
			case static_cast<unsigned char>('f'):
			case static_cast<unsigned char>('g'):
			case static_cast<unsigned char>('h'):
			case static_cast<unsigned char>('i'):
			case static_cast<unsigned char>('j'):
			case static_cast<unsigned char>('k'):
			case static_cast<unsigned char>('l'):
			case static_cast<unsigned char>('m'):
			case static_cast<unsigned char>('n'):
			case static_cast<unsigned char>('o'):
			case static_cast<unsigned char>('p'):
			case static_cast<unsigned char>('q'):
			case static_cast<unsigned char>('r'):
			case static_cast<unsigned char>('s'):
			case static_cast<unsigned char>('t'):
			case static_cast<unsigned char>('u'):
			case static_cast<unsigned char>('v'):
			case static_cast<unsigned char>('w'):
			case static_cast<unsigned char>('x'):
			case static_cast<unsigned char>('y'):
			case static_cast<unsigned char>('z'):
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		break;
	}
	case static_cast<unsigned char>('.'):
	case static_cast<unsigned char>('>'):
	case static_cast<unsigned char>('a'):
	case static_cast<unsigned char>('b'):
	case static_cast<unsigned char>('c'):
	case static_cast<unsigned char>('d'):
	case static_cast<unsigned char>('e'):
	case static_cast<unsigned char>('f'):
	case static_cast<unsigned char>('g'):
	case static_cast<unsigned char>('h'):
	case static_cast<unsigned char>('i'):
	case static_cast<unsigned char>('j'):
	case static_cast<unsigned char>('k'):
	case static_cast<unsigned char>('l'):
	case static_cast<unsigned char>('m'):
	case static_cast<unsigned char>('n'):
	case static_cast<unsigned char>('o'):
	case static_cast<unsigned char>('p'):
	case static_cast<unsigned char>('q'):
	case static_cast<unsigned char>('r'):
	case static_cast<unsigned char>('s'):
	case static_cast<unsigned char>('t'):
	case static_cast<unsigned char>('u'):
	case static_cast<unsigned char>('v'):
	case static_cast<unsigned char>('w'):
	case static_cast<unsigned char>('x'):
	case static_cast<unsigned char>('y'):
	case static_cast<unsigned char>('z'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCBODY(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CBODY;
	int _saveIndex;
	
	match("</body>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOTITLE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OTITLE;
	int _saveIndex;
	
	match("<title>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCTITLE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CTITLE;
	int _saveIndex;
	
	match("</title>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSCRIPT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSCRIPT;
	int _saveIndex;
	
	match("<script>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCSCRIPT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CSCRIPT;
	int _saveIndex;
	
	match("</script>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mISINDEX(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ISINDEX;
	int _saveIndex;
	
	match("<isindex");
	mWS_(false);
	mATTR(false);
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mMETA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = META;
	int _saveIndex;
	
	match("<meta");
	mWS_(false);
	{ // ( ... )+
	int _cnt20587=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20587>=1 ) { goto _loop20587; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20587++;
	}
	_loop20587:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mLINK(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = LINK;
	int _saveIndex;
	
	match("<link");
	mWS_(false);
	{ // ( ... )+
	int _cnt20590=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20590>=1 ) { goto _loop20590; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20590++;
	}
	_loop20590:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH1(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH1;
	int _saveIndex;
	
	match("<h1");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH1(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH1;
	int _saveIndex;
	
	match("</h1>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH2(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH2;
	int _saveIndex;
	
	match("<h2");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH2(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH2;
	int _saveIndex;
	
	match("</h2>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH3(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH3;
	int _saveIndex;
	
	match("<h3");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH3(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH3;
	int _saveIndex;
	
	match("</h3>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH4(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH4;
	int _saveIndex;
	
	match("<h4");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH4(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH4;
	int _saveIndex;
	
	match("</h4>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH5(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH5;
	int _saveIndex;
	
	match("<h5");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH5(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH5;
	int _saveIndex;
	
	match("</h5>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOH6(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OH6;
	int _saveIndex;
	
	match("<h6");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCH6(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CH6;
	int _saveIndex;
	
	match("</h6>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOADDRESS(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OADDRESS;
	int _saveIndex;
	
	match("<address>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCADDRESS(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CADDRESS;
	int _saveIndex;
	
	match("</address>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOPARA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OPARA;
	int _saveIndex;
	
	match("<p");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCPARA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CPARA;
	int _saveIndex;
	
	match("</p>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOULIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OULIST;
	int _saveIndex;
	
	match("<ul");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCULIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CULIST;
	int _saveIndex;
	
	match("</ul>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOOLIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OOLIST;
	int _saveIndex;
	
	match("<ol");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCOLIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = COLIST;
	int _saveIndex;
	
	match("</ol>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOLITEM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OLITEM;
	int _saveIndex;
	
	match("<li");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCLITEM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CLITEM;
	int _saveIndex;
	
	match("</li>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODLIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODLIST;
	int _saveIndex;
	
	match("<dl");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCDLIST(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CDLIST;
	int _saveIndex;
	
	match("</dl>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODTERM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODTERM;
	int _saveIndex;
	
	match("<dt>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCDTERM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CDTERM;
	int _saveIndex;
	
	match("</dt>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODDEF(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODDEF;
	int _saveIndex;
	
	match("<dd>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCDDEF(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CDDEF;
	int _saveIndex;
	
	match("</dd>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODIR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODIR;
	int _saveIndex;
	
	match("<dir>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCDIR_OR_CDIV(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CDIR_OR_CDIV;
	int _saveIndex;
	
	match("</di");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('r'):
	{
		match(static_cast<unsigned char>('r'));
#line 569 "html.g"
		_ttype = CDIR;
#line 2273 "HTMLLexer.cpp"
		break;
	}
	case static_cast<unsigned char>('v'):
	{
		match(static_cast<unsigned char>('v'));
#line 570 "html.g"
		_ttype = CDIV;
#line 2281 "HTMLLexer.cpp"
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODIV(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODIV;
	int _saveIndex;
	
	match("<div");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOMENU(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OMENU;
	int _saveIndex;
	
	match("<menu>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCMENU(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CMENU;
	int _saveIndex;
	
	match("</menu>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOPRE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OPRE;
	int _saveIndex;
	
	{
	if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('p'))) {
		match("<pre>");
	}
	else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('x'))) {
		match("<xmp>");
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	}
	{
	if ((LA(1) == static_cast<unsigned char>('\n'))) {
		match(static_cast<unsigned char>('\n'));
	}
	else {
	}
	
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCPRE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CPRE;
	int _saveIndex;
	
	if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('p'))) {
		match("</pre>");
	}
	else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('x'))) {
		match("</xmp>");
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOCENTER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OCENTER;
	int _saveIndex;
	
	match("<center>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCCENTER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CCENTER;
	int _saveIndex;
	
	match("</center>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOBQUOTE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OBQUOTE;
	int _saveIndex;
	
	match("<blockquote>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCBQUOTE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CBQUOTE;
	int _saveIndex;
	
	match("</blockquote>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mHR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = HR;
	int _saveIndex;
	
	match("<hr");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20648;
			}
			
		}
		_loop20648:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOTABLE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OTABLE;
	int _saveIndex;
	
	match("<table");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20652;
			}
			
		}
		_loop20652:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCTABLE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CTABLE;
	int _saveIndex;
	
	match("</table>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOCAP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OCAP;
	int _saveIndex;
	
	match("<caption");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20657;
			}
			
		}
		_loop20657:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCCAP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CCAP;
	int _saveIndex;
	
	match("</caption>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mO_TR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = O_TR;
	int _saveIndex;
	
	match("<tr");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20662;
			}
			
		}
		_loop20662:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mC_TR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = C_TR;
	int _saveIndex;
	
	match("</tr>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mO_TH_OR_TD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = O_TH_OR_TD;
	int _saveIndex;
	
	{
	if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('h'))) {
		match("<th");
	}
	else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('t')) && (LA(3) == static_cast<unsigned char>('d'))) {
		match("<td");
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	}
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20668;
			}
			
		}
		_loop20668:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mC_TH_OR_TD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = C_TH_OR_TD;
	int _saveIndex;
	
	if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('h'))) {
		match("</th>");
	}
	else if ((LA(1) == static_cast<unsigned char>('<')) && (LA(2) == static_cast<unsigned char>('/')) && (LA(3) == static_cast<unsigned char>('t')) && (LA(4) == static_cast<unsigned char>('d'))) {
		match("</td>");
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOTTYPE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OTTYPE;
	int _saveIndex;
	
	match("<tt>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCTTYPE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CTTYPE;
	int _saveIndex;
	
	match("</tt>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOITALIC(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OITALIC;
	int _saveIndex;
	
	match("<i>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCITALIC(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CITALIC;
	int _saveIndex;
	
	match("</i>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOBOLD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OBOLD;
	int _saveIndex;
	
	match("<b>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCBOLD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CBOLD;
	int _saveIndex;
	
	match("</b>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOUNDER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OUNDER;
	int _saveIndex;
	
	match("<u>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCUNDER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CUNDER;
	int _saveIndex;
	
	match("</u>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

/** Left-factor <strike> and <strong> to reduce lookahead */
void HTMLLexer::mOSTRIKE_OR_OSTRONG(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSTRIKE_OR_OSTRONG;
	int _saveIndex;
	
	match("<str");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('i'):
	{
		match("ike");
#line 685 "html.g"
		_ttype = OSTRIKE;
#line 2912 "HTMLLexer.cpp"
		break;
	}
	case static_cast<unsigned char>('o'):
	{
		match("ong");
#line 686 "html.g"
		_ttype = OSTRONG;
#line 2920 "HTMLLexer.cpp"
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCST_LEFT_FACTORED(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CST_LEFT_FACTORED;
	int _saveIndex;
	
	match("</st");
	{
	if ((LA(1) == static_cast<unsigned char>('r')) && (LA(2) == static_cast<unsigned char>('i'))) {
		match("rike");
#line 693 "html.g"
		_ttype = CSTRIKE;
#line 2949 "HTMLLexer.cpp"
	}
	else if ((LA(1) == static_cast<unsigned char>('r')) && (LA(2) == static_cast<unsigned char>('o'))) {
		match("rong");
#line 694 "html.g"
		_ttype = CSTRONG;
#line 2955 "HTMLLexer.cpp"
	}
	else if ((LA(1) == static_cast<unsigned char>('y'))) {
		match("yle");
#line 695 "html.g"
		_ttype = CSTYLE;
#line 2961 "HTMLLexer.cpp"
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSTYLE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSTYLE;
	int _saveIndex;
	
	match("<style>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOBIG(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OBIG;
	int _saveIndex;
	
	match("<big>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCBIG(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CBIG;
	int _saveIndex;
	
	match("</big>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSMALL(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSMALL;
	int _saveIndex;
	
	match("<small>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCSMALL(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CSMALL;
	int _saveIndex;
	
	match("</small>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSUB(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSUB;
	int _saveIndex;
	
	match("<sub>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSUP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSUP;
	int _saveIndex;
	
	match("<sup>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCSUB_OR_CSUP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CSUB_OR_CSUP;
	int _saveIndex;
	
	match("</su");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('b'):
	{
		match(static_cast<unsigned char>('b'));
#line 726 "html.g"
		_ttype = CSUB;
#line 3088 "HTMLLexer.cpp"
		break;
	}
	case static_cast<unsigned char>('p'):
	{
		match(static_cast<unsigned char>('p'));
#line 727 "html.g"
		_ttype = CSUP;
#line 3096 "HTMLLexer.cpp"
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOEM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OEM;
	int _saveIndex;
	
	match("<em>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCEM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CEM;
	int _saveIndex;
	
	match("</em>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mODFN(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ODFN;
	int _saveIndex;
	
	match("<dfn>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCDFN(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CDFN;
	int _saveIndex;
	
	match("</dfn>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOCODE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OCODE;
	int _saveIndex;
	
	match("<code>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCCODE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CCODE;
	int _saveIndex;
	
	match("</code>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSAMP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSAMP;
	int _saveIndex;
	
	match("<samp>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCSAMP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CSAMP;
	int _saveIndex;
	
	match("</samp>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOKBD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OKBD;
	int _saveIndex;
	
	match("<kbd>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCKBD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CKBD;
	int _saveIndex;
	
	match("</kbd>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOVAR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OVAR;
	int _saveIndex;
	
	match("<var>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCVAR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CVAR;
	int _saveIndex;
	
	match("</var>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOCITE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OCITE;
	int _saveIndex;
	
	match("<cite>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCCITE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CCITE;
	int _saveIndex;
	
	match("</cite>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mINPUT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = INPUT;
	int _saveIndex;
	
	match("<input");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20708;
			}
			
		}
		_loop20708:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOSELECT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OSELECT;
	int _saveIndex;
	
	match("<select");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20712;
			}
			
		}
		_loop20712:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCSELECT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CSELECT;
	int _saveIndex;
	
	match("</select>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOTAREA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OTAREA;
	int _saveIndex;
	
	match("<textarea");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20717;
			}
			
		}
		_loop20717:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCTAREA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CTAREA;
	int _saveIndex;
	
	match("</textarea>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mSELOPT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = SELOPT;
	int _saveIndex;
	
	match("<option");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				mATTR(false);
			}
			else {
				goto _loop20722;
			}
			
		}
		_loop20722:;
		} // ( ... )*
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOANCHOR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OANCHOR;
	int _saveIndex;
	
	match("<a");
	mWS_(false);
	{ // ( ... )+
	int _cnt20725=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20725>=1 ) { goto _loop20725; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20725++;
	}
	_loop20725:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCANCHOR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CANCHOR;
	int _saveIndex;
	
	match("</a>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mIMG(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = IMG;
	int _saveIndex;
	
	match("<img");
	mWS_(false);
	{ // ( ... )+
	int _cnt20729=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20729>=1 ) { goto _loop20729; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20729++;
	}
	_loop20729:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOAPPLET(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OAPPLET;
	int _saveIndex;
	
	match("<applet");
	mWS_(false);
	{ // ( ... )+
	int _cnt20732=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20732>=1 ) { goto _loop20732; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20732++;
	}
	_loop20732:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCAPPLET(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CAPPLET;
	int _saveIndex;
	
	match("</applet>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mAPARM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = APARM;
	int _saveIndex;
	
	match("<param");
	mWS_(false);
	{ // ( ... )+
	int _cnt20736=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20736>=1 ) { goto _loop20736; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20736++;
	}
	_loop20736:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOFORM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OFORM;
	int _saveIndex;
	
	match("<form");
	mWS_(false);
	{ // ( ... )+
	int _cnt20739=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20739>=1 ) { goto _loop20739; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20739++;
	}
	_loop20739:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOFONT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OFONT;
	int _saveIndex;
	
	match("<font");
	mWS_(false);
	{ // ( ... )+
	int _cnt20742=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20742>=1 ) { goto _loop20742; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20742++;
	}
	_loop20742:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCFORM_OR_CFONT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CFORM_OR_CFONT;
	int _saveIndex;
	
	match("</fo");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('r'):
	{
		match("rm");
#line 842 "html.g"
		_ttype = CFORM;
#line 3747 "HTMLLexer.cpp"
		break;
	}
	case static_cast<unsigned char>('n'):
	{
		match("nt");
#line 843 "html.g"
		_ttype = CFONT;
#line 3755 "HTMLLexer.cpp"
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mBFONT_OR_BASE(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = BFONT_OR_BASE;
	int _saveIndex;
	
	match("<base");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('f'):
	{
		match("font");
		mWS_(false);
		mATTR(false);
#line 860 "html.g"
		_ttype = BFONT;
#line 3788 "HTMLLexer.cpp"
		break;
	}
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
#line 861 "html.g"
		_ttype = BASE;
#line 3800 "HTMLLexer.cpp"
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mBR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = BR;
	int _saveIndex;
	
	match("<br");
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>('\r'):
	case static_cast<unsigned char>(' '):
	{
		mWS_(false);
		mATTR(false);
		break;
	}
	case static_cast<unsigned char>('>'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mOMAP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = OMAP;
	int _saveIndex;
	
	match("<map");
	mWS_(false);
	mATTR(false);
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCMAP(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = CMAP;
	int _saveIndex;
	
	match("</map>");
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mAREA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = AREA;
	int _saveIndex;
	
	match("<area");
	mWS_(false);
	{ // ( ... )+
	int _cnt20753=0;
	for (;;) {
		if ((_tokenSet_6.member(LA(1)))) {
			mATTR(false);
		}
		else {
			if ( _cnt20753>=1 ) { goto _loop20753; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20753++;
	}
	_loop20753:;
	}  // ( ... )+
	match(static_cast<unsigned char>('>'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mPCDATA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = PCDATA;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt20757=0;
	for (;;) {
		if ((LA(1) == static_cast<unsigned char>('\r')) && (LA(2) == static_cast<unsigned char>('\n')) && (true) && (true)) {
			match(static_cast<unsigned char>('\r'));
			match(static_cast<unsigned char>('\n'));
#line 899 "html.g"
			newline();
#line 3928 "HTMLLexer.cpp"
		}
		else if ((LA(1) == static_cast<unsigned char>('\r')) && (true) && (true) && (true)) {
			match(static_cast<unsigned char>('\r'));
#line 900 "html.g"
			newline();
#line 3934 "HTMLLexer.cpp"
		}
		else if ((LA(1) == static_cast<unsigned char>('\n'))) {
			match(static_cast<unsigned char>('\n'));
#line 901 "html.g"
			newline();
#line 3940 "HTMLLexer.cpp"
		}
		else if ((_tokenSet_7.member(LA(1)))) {
			{
			match(_tokenSet_7);
			}
		}
		else {
			if ( _cnt20757>=1 ) { goto _loop20757; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20757++;
	}
	_loop20757:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCOMMENT_DATA(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = COMMENT_DATA;
	int _saveIndex;
	
	{ // ( ... )*
	for (;;) {
		if (((LA(1) == static_cast<unsigned char>('-')) && ((LA(2) >= static_cast<unsigned char>('\3') && LA(2) <= static_cast<unsigned char>('\377'))) && ((LA(3) >= static_cast<unsigned char>('\3') && LA(3) <= static_cast<unsigned char>('\377'))) && ((LA(4) >= static_cast<unsigned char>('\3') && LA(4) <= static_cast<unsigned char>('\377'))))&&(LA(2)!='-' && LA(3)!='>')) {
			match(static_cast<unsigned char>('-'));
		}
		else if ((LA(1) == static_cast<unsigned char>('\r')) && (LA(2) == static_cast<unsigned char>('\n')) && ((LA(3) >= static_cast<unsigned char>('\3') && LA(3) <= static_cast<unsigned char>('\377'))) && ((LA(4) >= static_cast<unsigned char>('\3') && LA(4) <= static_cast<unsigned char>('\377')))) {
			match(static_cast<unsigned char>('\r'));
			match(static_cast<unsigned char>('\n'));
#line 921 "html.g"
			newline();
#line 3978 "HTMLLexer.cpp"
		}
		else if ((LA(1) == static_cast<unsigned char>('\r')) && ((LA(2) >= static_cast<unsigned char>('\3') && LA(2) <= static_cast<unsigned char>('\377'))) && ((LA(3) >= static_cast<unsigned char>('\3') && LA(3) <= static_cast<unsigned char>('\377'))) && ((LA(4) >= static_cast<unsigned char>('\3') && LA(4) <= static_cast<unsigned char>('\377')))) {
			match(static_cast<unsigned char>('\r'));
#line 922 "html.g"
			newline();
#line 3984 "HTMLLexer.cpp"
		}
		else if ((LA(1) == static_cast<unsigned char>('\n'))) {
			match(static_cast<unsigned char>('\n'));
#line 923 "html.g"
			newline();
#line 3990 "HTMLLexer.cpp"
		}
		else if ((_tokenSet_8.member(LA(1)))) {
			{
			match(_tokenSet_8);
			}
		}
		else {
			goto _loop20761;
		}
		
	}
	_loop20761:;
	} // ( ... )*
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mCOMMENT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = COMMENT;
	int _saveIndex;
	
	match("<!--");
	mCOMMENT_DATA(false);
	match("-->");
#line 930 "html.g"
	_ttype = ANTLR_USE_NAMESPACE(antlr)Token::SKIP;
#line 4022 "HTMLLexer.cpp"
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mWORD(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = WORD;
	int _saveIndex;
	
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('a'):
	case static_cast<unsigned char>('b'):
	case static_cast<unsigned char>('c'):
	case static_cast<unsigned char>('d'):
	case static_cast<unsigned char>('e'):
	case static_cast<unsigned char>('f'):
	case static_cast<unsigned char>('g'):
	case static_cast<unsigned char>('h'):
	case static_cast<unsigned char>('i'):
	case static_cast<unsigned char>('j'):
	case static_cast<unsigned char>('k'):
	case static_cast<unsigned char>('l'):
	case static_cast<unsigned char>('m'):
	case static_cast<unsigned char>('n'):
	case static_cast<unsigned char>('o'):
	case static_cast<unsigned char>('p'):
	case static_cast<unsigned char>('q'):
	case static_cast<unsigned char>('r'):
	case static_cast<unsigned char>('s'):
	case static_cast<unsigned char>('t'):
	case static_cast<unsigned char>('u'):
	case static_cast<unsigned char>('v'):
	case static_cast<unsigned char>('w'):
	case static_cast<unsigned char>('x'):
	case static_cast<unsigned char>('y'):
	case static_cast<unsigned char>('z'):
	{
		mLCLETTER(false);
		break;
	}
	case static_cast<unsigned char>('.'):
	{
		match(static_cast<unsigned char>('.'));
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	{ // ( ... )+
	int _cnt20782=0;
	for (;;) {
		if (((LA(1) >= static_cast<unsigned char>('a') && LA(1) <= static_cast<unsigned char>('z'))) && (_tokenSet_9.member(LA(2))) && (true) && (true)) {
			mLCLETTER(false);
		}
		else if ((LA(1) == static_cast<unsigned char>('.')) && (_tokenSet_9.member(LA(2))) && (true) && (true)) {
			match(static_cast<unsigned char>('.'));
		}
		else if (((LA(1) >= static_cast<unsigned char>('0') && LA(1) <= static_cast<unsigned char>('9')))) {
			mDIGIT(false);
		}
		else {
			if ( _cnt20782>=1 ) { goto _loop20782; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20782++;
	}
	_loop20782:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mINT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = INT;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt20793=0;
	for (;;) {
		if (((LA(1) >= static_cast<unsigned char>('0') && LA(1) <= static_cast<unsigned char>('9')))) {
			mDIGIT(false);
		}
		else {
			if ( _cnt20793>=1 ) { goto _loop20793; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20793++;
	}
	_loop20793:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mHEXNUM(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = HEXNUM;
	int _saveIndex;
	
	match(static_cast<unsigned char>('#'));
	mHEXINT(false);
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mLCLETTER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = LCLETTER;
	int _saveIndex;
	
	matchRange(static_cast<unsigned char>('a'),static_cast<unsigned char>('z'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mDIGIT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = DIGIT;
	int _saveIndex;
	
	matchRange(static_cast<unsigned char>('0'),static_cast<unsigned char>('9'));
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mWSCHARS(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = WSCHARS;
	int _saveIndex;
	
	switch ( LA(1)) {
	case static_cast<unsigned char>(' '):
	{
		match(static_cast<unsigned char>(' '));
		break;
	}
	case static_cast<unsigned char>('\t'):
	{
		match(static_cast<unsigned char>('\t'));
		break;
	}
	case static_cast<unsigned char>('\n'):
	{
		match(static_cast<unsigned char>('\n'));
		break;
	}
	case static_cast<unsigned char>('\r'):
	{
		match(static_cast<unsigned char>('\r'));
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mSPECIAL(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = SPECIAL;
	int _saveIndex;
	
	switch ( LA(1)) {
	case static_cast<unsigned char>('<'):
	{
		match(static_cast<unsigned char>('<'));
		break;
	}
	case static_cast<unsigned char>('~'):
	{
		match(static_cast<unsigned char>('~'));
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mHEXINT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = HEXINT;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt20796=0;
	for (;;) {
		if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2))) && (true) && (true)) {
			mHEXDIGIT(false);
		}
		else {
			if ( _cnt20796>=1 ) { goto _loop20796; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt20796++;
	}
	_loop20796:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mHEXDIGIT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = HEXDIGIT;
	int _saveIndex;
	
	switch ( LA(1)) {
	case static_cast<unsigned char>('0'):
	case static_cast<unsigned char>('1'):
	case static_cast<unsigned char>('2'):
	case static_cast<unsigned char>('3'):
	case static_cast<unsigned char>('4'):
	case static_cast<unsigned char>('5'):
	case static_cast<unsigned char>('6'):
	case static_cast<unsigned char>('7'):
	case static_cast<unsigned char>('8'):
	case static_cast<unsigned char>('9'):
	{
		matchRange(static_cast<unsigned char>('0'),static_cast<unsigned char>('9'));
		break;
	}
	case static_cast<unsigned char>('a'):
	case static_cast<unsigned char>('b'):
	case static_cast<unsigned char>('c'):
	case static_cast<unsigned char>('d'):
	case static_cast<unsigned char>('e'):
	case static_cast<unsigned char>('f'):
	{
		matchRange(static_cast<unsigned char>('a'),static_cast<unsigned char>('f'));
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void HTMLLexer::mUNDEFINED_TOKEN(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = UNDEFINED_TOKEN;
	int _saveIndex;
	
	if ((LA(1) == static_cast<unsigned char>('<')) && ((LA(2) >= static_cast<unsigned char>('\3') && LA(2) <= static_cast<unsigned char>('\377')))) {
		match(static_cast<unsigned char>('<'));
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_12.member(LA(1)))) {
				matchNot(static_cast<unsigned char>('>'));
			}
			else {
				goto _loop20802;
			}
			
		}
		_loop20802:;
		} // ( ... )*
		match(static_cast<unsigned char>('>'));
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == static_cast<unsigned char>('\n') || LA(1) == static_cast<unsigned char>('\r'))) {
				{
				if ((LA(1) == static_cast<unsigned char>('\r')) && (LA(2) == static_cast<unsigned char>('\n')) && (true) && (true)) {
					match("\r\n");
				}
				else if ((LA(1) == static_cast<unsigned char>('\r')) && (true) && (true) && (true)) {
					match(static_cast<unsigned char>('\r'));
				}
				else if ((LA(1) == static_cast<unsigned char>('\n'))) {
					match(static_cast<unsigned char>('\n'));
				}
				else {
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
#line 1068 "html.g"
				newline();
#line 4355 "HTMLLexer.cpp"
			}
			else {
				goto _loop20805;
			}
			
		}
		_loop20805:;
		} // ( ... )*
#line 1070 "html.g"
		std::cerr << "invalid tag: " << text.substr(_begin,text.length()-_begin) << std::endl;
#line 4366 "HTMLLexer.cpp"
	}
	else if ((LA(1) == static_cast<unsigned char>('\n') || LA(1) == static_cast<unsigned char>('\r')) && (true) && (true) && (true)) {
		{
		if ((LA(1) == static_cast<unsigned char>('\r')) && (LA(2) == static_cast<unsigned char>('\n'))) {
			match("\r\n");
		}
		else if ((LA(1) == static_cast<unsigned char>('\r')) && (true)) {
			match(static_cast<unsigned char>('\r'));
		}
		else if ((LA(1) == static_cast<unsigned char>('\n'))) {
			match(static_cast<unsigned char>('\n'));
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
#line 1071 "html.g"
		newline();
#line 4386 "HTMLLexer.cpp"
	}
	else if (((LA(1) >= static_cast<unsigned char>('\3') && LA(1) <= static_cast<unsigned char>('\377'))) && (true) && (true) && (true)) {
		matchNot(EOF/*_CHAR*/);
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}


const unsigned long HTMLLexer::_tokenSet_0_data_[] = { 9728UL, 1073741825UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CHEAD ISINDEX LINK CH3 OCENTER 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_0(_tokenSet_0_data_,10);
const unsigned long HTMLLexer::_tokenSet_1_data_[] = { 9728UL, 1UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CHEAD ISINDEX LINK CH3 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_1(_tokenSet_1_data_,10);
const unsigned long HTMLLexer::_tokenSet_2_data_[] = { 4294967288UL, 2952790011UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE 
// META LINK OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS 
// HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 OH5 CH5 OH6 CH6 OADDRESS 
// CADDRESS OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM 
// CLITEM ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE CDIV CCENTER 
// OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP O_TR C_TR O_TH_OR_TD 
// C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER CUNDER OSTRIKE 
// CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM CEM OSTRONG 
// CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE 
// CCITE INPUT OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR CANCHOR OAPPLET 
// APARAM CAPPLET OFONT CFONT OMAP AREA CMAP CDDEF CDIR_OR_CDIV OSTRIKE_OR_OSTRONG 
// CST_LEFT_FACTORED CSUB_OR_CSUP APARM CFORM_OR_CFONT BFONT_OR_BASE COMMENT_DATA 
// COMMENT WS_ ATTR WORD STRING WSCHARS SPECIAL HEXNUM INT HEXINT DIGIT 
// HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_2(_tokenSet_2_data_,16);
const unsigned long HTMLLexer::_tokenSet_3_data_[] = { 9728UL, 1073758209UL, 0UL, 134217726UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CHEAD ISINDEX LINK CH3 COLIST OCENTER CSTRONG ODFN CDFN OCODE CCODE 
// OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT 
// OTAREA CTAREA OANCHOR CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_3(_tokenSet_3_data_,10);
const unsigned long HTMLLexer::_tokenSet_4_data_[] = { 4294967288UL, 4294967291UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE 
// META LINK OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS 
// HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 OH5 CH5 OH6 CH6 OADDRESS 
// CADDRESS OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM 
// CLITEM ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE ODIV CDIV 
// OCENTER CCENTER OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP 
// O_TR C_TR O_TH_OR_TD C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD 
// CBOLD OUNDER CUNDER OSTRIKE CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB 
// OSUP CSUP OEM CEM OSTRONG CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP 
// OKBD CKBD OVAR CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT OTAREA 
// CTAREA OANCHOR CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT OMAP AREA 
// CMAP CDDEF CDIR_OR_CDIV OSTRIKE_OR_OSTRONG CST_LEFT_FACTORED CSUB_OR_CSUP 
// APARM CFORM_OR_CFONT BFONT_OR_BASE COMMENT_DATA COMMENT WS_ ATTR WORD 
// STRING WSCHARS SPECIAL HEXNUM INT HEXINT DIGIT HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_4(_tokenSet_4_data_,16);
const unsigned long HTMLLexer::_tokenSet_5_data_[] = { 4294967288UL, 4294967167UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE 
// META LINK OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS 
// HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 CH4 OH5 CH5 OH6 CH6 CADDRESS 
// OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM CLITEM 
// ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE ODIV CDIV OCENTER 
// CCENTER OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP O_TR C_TR 
// O_TH_OR_TD C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER 
// CUNDER OSTRIKE CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM 
// CEM OSTRONG CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR 
// CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR 
// CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT OMAP AREA CMAP CDDEF CDIR_OR_CDIV 
// OSTRIKE_OR_OSTRONG CST_LEFT_FACTORED CSUB_OR_CSUP APARM CFORM_OR_CFONT 
// BFONT_OR_BASE COMMENT_DATA COMMENT WS_ ATTR WORD STRING WSCHARS SPECIAL 
// HEXNUM INT HEXINT DIGIT HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_5(_tokenSet_5_data_,16);
const unsigned long HTMLLexer::_tokenSet_6_data_[] = { 0UL, 16384UL, 0UL, 134217726UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// COLIST CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR CVAR 
// OCITE CCITE INPUT OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR CANCHOR 
// OAPPLET APARAM CAPPLET OFONT CFONT 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_6(_tokenSet_6_data_,10);
const unsigned long HTMLLexer::_tokenSet_7_data_[] = { 4294958072UL, 2952790011UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD BASE META 
// OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS HR IMG 
// BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 OH5 CH5 OH6 CH6 OADDRESS CADDRESS 
// OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM CLITEM 
// ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE CDIV CCENTER OBQUOTE 
// CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP O_TR C_TR O_TH_OR_TD C_TH_OR_TD 
// OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER CUNDER OSTRIKE CSTRIKE 
// OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM CEM OSTRONG CSTRONG 
// ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE CCITE INPUT 
// OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR CANCHOR OAPPLET APARAM 
// CAPPLET OFONT CFONT OMAP AREA CMAP CDDEF CDIR_OR_CDIV OSTRIKE_OR_OSTRONG 
// CST_LEFT_FACTORED CSUB_OR_CSUP APARM CFORM_OR_CFONT BFONT_OR_BASE COMMENT_DATA 
// COMMENT WS_ ATTR WORD STRING WSCHARS SPECIAL HEXNUM INT HEXINT DIGIT 
// HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_7(_tokenSet_7_data_,16);
const unsigned long HTMLLexer::_tokenSet_8_data_[] = { 4294958072UL, 4294959103UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD BASE META 
// OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS HR IMG 
// BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 CH4 OH5 CH5 OH6 CH6 OADDRESS CADDRESS 
// OPARA CPARA OULIST CULIST COLIST ODLIST CDLIST OLITEM CLITEM ODTERM 
// CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE ODIV CDIV OCENTER CCENTER 
// OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP O_TR C_TR O_TH_OR_TD 
// C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER CUNDER OSTRIKE 
// CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM CEM OSTRONG 
// CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE 
// CCITE INPUT OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR CANCHOR OAPPLET 
// APARAM CAPPLET OFONT CFONT OMAP AREA CMAP CDDEF CDIR_OR_CDIV OSTRIKE_OR_OSTRONG 
// CST_LEFT_FACTORED CSUB_OR_CSUP APARM CFORM_OR_CFONT BFONT_OR_BASE COMMENT_DATA 
// COMMENT WS_ ATTR WORD STRING WSCHARS SPECIAL HEXNUM INT HEXINT DIGIT 
// HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_8(_tokenSet_8_data_,16);
const unsigned long HTMLLexer::_tokenSet_9_data_[] = { 9728UL, 1677672481UL, 0UL, 134217726UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CHEAD ISINDEX LINK CH3 OH6 COLIST CDLIST OLITEM CLITEM ODTERM CDTERM 
// ODDEF ODIR CDIR OMENU CMENU CDIV OCENTER CSTRONG ODFN CDFN OCODE CCODE 
// OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT 
// OTAREA CTAREA OANCHOR CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_9(_tokenSet_9_data_,10);
const unsigned long HTMLLexer::_tokenSet_10_data_[] = { 0UL, 67043328UL, 0UL, 126UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CDLIST OLITEM CLITEM ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU CSTRONG 
// ODFN CDFN OCODE CCODE OSAMP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_10(_tokenSet_10_data_,10);
const unsigned long HTMLLexer::_tokenSet_11_data_[] = { 9728UL, 1140801537UL, 0UL, 134217726UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CHEAD ISINDEX LINK CH3 COLIST CDLIST OLITEM CLITEM ODTERM CDTERM ODDEF 
// ODIR CDIR OMENU CMENU OCENTER CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP 
// OKBD CKBD OVAR CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT OTAREA 
// CTAREA OANCHOR CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_11(_tokenSet_11_data_,10);
const unsigned long HTMLLexer::_tokenSet_12_data_[] = { 4294967288UL, 3221225471UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 4294967295UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// NULL_TREE_LOOKAHEAD PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE 
// META LINK OTITLE CTITLE OSCRIPT CSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS 
// HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 OH4 CH4 OH5 CH5 OH6 CH6 OADDRESS 
// CADDRESS OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM 
// CLITEM ODTERM CDTERM ODDEF ODIR CDIR OMENU CMENU OPRE CPRE ODIV CDIV 
// CCENTER OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE OCAP CCAP O_TR C_TR 
// O_TH_OR_TD C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER 
// CUNDER OSTRIKE CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM 
// CEM OSTRONG CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR 
// CVAR OCITE CCITE INPUT OSELECT CSELECT SELOPT OTAREA CTAREA OANCHOR 
// CANCHOR OAPPLET APARAM CAPPLET OFONT CFONT OMAP AREA CMAP CDDEF CDIR_OR_CDIV 
// OSTRIKE_OR_OSTRONG CST_LEFT_FACTORED CSUB_OR_CSUP APARM CFORM_OR_CFONT 
// BFONT_OR_BASE COMMENT_DATA COMMENT WS_ ATTR WORD STRING WSCHARS SPECIAL 
// HEXNUM INT HEXINT DIGIT HEXDIGIT LCLETTER UNDEFINED_TOKEN 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLLexer::_tokenSet_12(_tokenSet_12_data_,16);

