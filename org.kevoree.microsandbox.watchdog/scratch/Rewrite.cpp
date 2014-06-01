/* $ANTLR 2.7.2: "rewrite.g" -> "Rewrite.cpp"$ */
#include "Rewrite.hpp"
#include <antlr/CharBuffer.hpp>
#include <antlr/TokenStreamException.hpp>
#include <antlr/TokenStreamIOException.hpp>
#include <antlr/TokenStreamRecognitionException.hpp>
#include <antlr/CharStreamException.hpp>
#include <antlr/CharStreamIOException.hpp>
#include <antlr/NoViableAltForCharException.hpp>

#line 5 "rewrite.g"

#include <iostream>

#line 16 "Rewrite.cpp"
Rewrite::Rewrite(ANTLR_USE_NAMESPACE(std)istream& in)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(new ANTLR_USE_NAMESPACE(antlr)CharBuffer(in),true)
{
	initLiterals();
}

Rewrite::Rewrite(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(ib,true)
{
	initLiterals();
}

Rewrite::Rewrite(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state)
	: ANTLR_USE_NAMESPACE(antlr)CharScanner(state,true)
{
	initLiterals();
}

void Rewrite::initLiterals()
{
}

ANTLR_USE_NAMESPACE(antlr)RefToken Rewrite::nextToken()
{
	ANTLR_USE_NAMESPACE(antlr)RefToken theRetToken;
	for (;;) {
		ANTLR_USE_NAMESPACE(antlr)RefToken theRetToken;
		int _ttype = ANTLR_USE_NAMESPACE(antlr)Token::INVALID_TYPE;
		resetText();
		try {   // for lexical and char stream error handling
			if (((LA(1) >= static_cast<unsigned char>('a') && LA(1) <= static_cast<unsigned char>('z')))) {
				mSTART(true);
				theRetToken=_returnToken;
			}
			else {
				if (LA(1)==EOF_CHAR)
				{
					uponEOF();
					_returnToken = makeToken(ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE);
				}
				else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
			}
			
			if ( !_returnToken )
				goto tryAgain; // found SKIP token

			_ttype = _returnToken->getType();
			_ttype = testLiteralsTable(_ttype);
			_returnToken->setType(_ttype);
			return _returnToken;
		}
		catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& e) {
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

void Rewrite::mSTART(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = START;
	int _saveIndex;
	ANTLR_USE_NAMESPACE(antlr)RefToken id;
	ANTLR_USE_NAMESPACE(antlr)RefToken expr;
	
	mID(true);
	id=_returnToken;
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>(':'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	_saveIndex=text.length();
	match(":=");
	text.erase(_saveIndex);
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>('('):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	_saveIndex=text.length();
	match(static_cast<unsigned char>('('));
	text.erase(_saveIndex);
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
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
	mEXPR(true);
	expr=_returnToken;
	{
	switch ( LA(1)) {
	case static_cast<unsigned char>('\t'):
	case static_cast<unsigned char>('\n'):
	case static_cast<unsigned char>(' '):
	{
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
		break;
	}
	case static_cast<unsigned char>(')'):
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
	}
	}
	}
	_saveIndex=text.length();
	match(static_cast<unsigned char>(')'));
	text.erase(_saveIndex);
	{
	if ((LA(1) == static_cast<unsigned char>('\t') || LA(1) == static_cast<unsigned char>('\n') || LA(1) == static_cast<unsigned char>(' '))) {
		_saveIndex = text.length();
		mWS_(false);
		text.erase(_saveIndex);
	}
	else {
	}
	
	}
#line 17 "rewrite.g"
	
				// can access text matched for any rule
				std::cout << "found " << id->getText() << "," << expr->getText() << std::endl;
				// text will be ID+EXPR minus whitespace
			
#line 236 "Rewrite.cpp"
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void Rewrite::mID(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = ID;
	int _saveIndex;
	ANTLR_USE_NAMESPACE(antlr)RefToken let;
	
	{ // ( ... )+
	int _cnt21538=0;
	for (;;) {
		if (((LA(1) >= static_cast<unsigned char>('a') && LA(1) <= static_cast<unsigned char>('z')))) {
			mLETTER(true);
			let=_returnToken;
#line 25 "rewrite.g"
			std::cout << "letter " << let->getText() << std::endl;
#line 259 "Rewrite.cpp"
		}
		else {
			if ( _cnt21538>=1 ) { goto _loop21538; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt21538++;
	}
	_loop21538:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void Rewrite::mWS_(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = WS_;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt21546=0;
	for (;;) {
		switch ( LA(1)) {
		case static_cast<unsigned char>(' '):
		{
			_saveIndex=text.length();
			match(static_cast<unsigned char>(' '));
			text.erase(_saveIndex);
			break;
		}
		case static_cast<unsigned char>('\t'):
		{
			_saveIndex=text.length();
			match(static_cast<unsigned char>('\t'));
			text.erase(_saveIndex);
			break;
		}
		case static_cast<unsigned char>('\n'):
		{
			_saveIndex=text.length();
			match(static_cast<unsigned char>('\n'));
			text.erase(_saveIndex);
#line 55 "rewrite.g"
			newline();
#line 307 "Rewrite.cpp"
			break;
		}
		default:
		{
			if ( _cnt21546>=1 ) { goto _loop21546; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		}
		_cnt21546++;
	}
	_loop21546:;
	}  // ( ... )+
#line 57 "rewrite.g"
	_ttype = ANTLR_USE_NAMESPACE(antlr)Token::SKIP;
#line 321 "Rewrite.cpp"
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void Rewrite::mEXPR(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = EXPR;
	int _saveIndex;
	ANTLR_USE_NAMESPACE(antlr)RefToken i;
	
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
		_saveIndex = text.length();
		mINT(true);
		text.erase(_saveIndex);
		i=_returnToken;
#line 40 "rewrite.g"
		{ text.erase(_begin); text += i->getText(); };
#line 354 "Rewrite.cpp"
		break;
	}
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
		mID(false);
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

void Rewrite::mLETTER(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = LETTER;
	int _saveIndex;
	
	matchRange(static_cast<unsigned char>('a'),static_cast<unsigned char>('z'));
#line 31 "rewrite.g"
	
			std::string s = text.substr(_begin,text.length()-_begin);		// get access text of this rule
	//		$setText(s.toUpperCase());	// can reset it too
			{ text.erase(_begin); text += s; };	// can reset it too
			
#line 412 "Rewrite.cpp"
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}

void Rewrite::mINT(bool _createToken) {
	int _ttype; ANTLR_USE_NAMESPACE(antlr)RefToken _token; int _begin=text.length();
	_ttype = INT;
	int _saveIndex;
	
	{ // ( ... )+
	int _cnt21543=0;
	for (;;) {
		if (((LA(1) >= static_cast<unsigned char>('0') && LA(1) <= static_cast<unsigned char>('9')))) {
			matchRange(static_cast<unsigned char>('0'),static_cast<unsigned char>('9'));
		}
		else {
			if ( _cnt21543>=1 ) { goto _loop21543; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());}
		}
		
		_cnt21543++;
	}
	_loop21543:;
	}  // ( ... )+
	if ( _createToken && _token==ANTLR_USE_NAMESPACE(antlr)nullToken && _ttype!=ANTLR_USE_NAMESPACE(antlr)Token::SKIP ) {
	   _token = makeToken(_ttype);
	   _token->setText(text.substr(_begin, text.length()-_begin));
	}
	_returnToken = _token;
	_saveIndex=0;
}



