/* $ANTLR 2.7.2: "html.g" -> "HTMLParser.cpp"$ */
#include "HTMLParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "html.g"
#line 8 "HTMLParser.cpp"
HTMLParser::HTMLParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

HTMLParser::HTMLParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

HTMLParser::HTMLParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

HTMLParser::HTMLParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

HTMLParser::HTMLParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void HTMLParser::document() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case PCDATA:
		{
			match(PCDATA);
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case DOCTYPE:
		case OHTML:
		case CHTML:
		case OHEAD:
		case ISINDEX:
		case BASE:
		case META:
		case LINK:
		case OTITLE:
		case OSCRIPT:
		case OSTYLE:
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case DOCTYPE:
		{
			match(DOCTYPE);
			{
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
			case OHTML:
			case CHTML:
			case OHEAD:
			case ISINDEX:
			case BASE:
			case META:
			case LINK:
			case OTITLE:
			case OSCRIPT:
			case OSTYLE:
			case OBODY:
			case ADDRESS:
			case HR:
			case IMG:
			case BFONT:
			case BR:
			case OH1:
			case OH2:
			case OH3:
			case OH4:
			case OH5:
			case OH6:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OFORM:
			case OTABLE:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case OHTML:
		case CHTML:
		case OHEAD:
		case ISINDEX:
		case BASE:
		case META:
		case LINK:
		case OTITLE:
		case OSCRIPT:
		case OSTYLE:
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case OHTML:
		{
			match(OHTML);
			{
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
			case CHTML:
			case OHEAD:
			case ISINDEX:
			case BASE:
			case META:
			case LINK:
			case OTITLE:
			case OSCRIPT:
			case OSTYLE:
			case OBODY:
			case ADDRESS:
			case HR:
			case IMG:
			case BFONT:
			case BR:
			case OH1:
			case OH2:
			case OH3:
			case OH4:
			case OH5:
			case OH6:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OFORM:
			case OTABLE:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case CHTML:
		case OHEAD:
		case ISINDEX:
		case BASE:
		case META:
		case LINK:
		case OTITLE:
		case OSCRIPT:
		case OSTYLE:
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case OHEAD:
		case ISINDEX:
		case BASE:
		case META:
		case LINK:
		case OTITLE:
		case OSCRIPT:
		case OSTYLE:
		{
			head();
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case CHTML:
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			body();
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case CHTML:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case CHTML:
		{
			match(CHTML);
			{
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void HTMLParser::head() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case OHEAD:
		{
			match(OHEAD);
			{
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ISINDEX:
			case BASE:
			case META:
			case LINK:
			case OTITLE:
			case OSCRIPT:
			case OSTYLE:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case ISINDEX:
		case BASE:
		case META:
		case LINK:
		case OTITLE:
		case OSCRIPT:
		case OSTYLE:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		head_element();
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ISINDEX:
			case BASE:
			case META:
			case LINK:
			case OTITLE:
			case OSCRIPT:
			case OSTYLE:
			{
				head_element();
				break;
			}
			default:
			{
				goto _loop20357;
			}
			}
		}
		_loop20357:;
		} // ( ... )*
		{
		switch ( LA(1)) {
		case CHEAD:
		{
			match(CHEAD);
			{
			switch ( LA(1)) {
			case PCDATA:
			{
				match(PCDATA);
				break;
			}
			case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
			case CHTML:
			case OBODY:
			case ADDRESS:
			case HR:
			case IMG:
			case BFONT:
			case BR:
			case OH1:
			case OH2:
			case OH3:
			case OH4:
			case OH5:
			case OH6:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OFORM:
			case OTABLE:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case CHTML:
		case OBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void HTMLParser::body() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case OBODY:
		{
			match(OBODY);
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == PCDATA)) {
					match(PCDATA);
				}
				else {
					goto _loop20372;
				}
				
			}
			_loop20372:;
			} // ( ... )*
			break;
		}
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OFORM:
		case OTABLE:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		body_content_no_PCDATA();
		{ // ( ... )+
		int _cnt20374=0;
		for (;;) {
			if ((_tokenSet_2.member(LA(1)))) {
				body_content();
			}
			else {
				if ( _cnt20374>=1 ) { goto _loop20374; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20374++;
		}
		_loop20374:;
		}  // ( ... )+
		{
		switch ( LA(1)) {
		case CBODY:
		{
			match(CBODY);
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == PCDATA)) {
					match(PCDATA);
				}
				else {
					goto _loop20377;
				}
				
			}
			_loop20377:;
			} // ( ... )*
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case CHTML:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void HTMLParser::head_element() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OTITLE:
		{
			title();
			break;
		}
		case OSCRIPT:
		{
			script();
			break;
		}
		case OSTYLE:
		{
			style();
			break;
		}
		case ISINDEX:
		{
			match(ISINDEX);
			break;
		}
		case BASE:
		{
			match(BASE);
			break;
		}
		case META:
		{
			match(META);
			break;
		}
		case LINK:
		{
			match(LINK);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
}

void HTMLParser::title() {
	
	try {      // for error handling
		match(OTITLE);
		{
		switch ( LA(1)) {
		case PCDATA:
		{
			match(PCDATA);
			break;
		}
		case CTITLE:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(CTITLE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
}

void HTMLParser::script() {
	
	try {      // for error handling
		match(OSCRIPT);
		{ // ( ... )+
		int _cnt20365=0;
		for (;;) {
			if ((_tokenSet_5.member(LA(1)))) {
				matchNot(CSCRIPT);
			}
			else {
				if ( _cnt20365>=1 ) { goto _loop20365; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20365++;
		}
		_loop20365:;
		}  // ( ... )+
		match(CSCRIPT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
}

void HTMLParser::style() {
	
	try {      // for error handling
		match(OSTYLE);
		{ // ( ... )+
		int _cnt20368=0;
		for (;;) {
			if ((_tokenSet_6.member(LA(1)))) {
				matchNot(CSTYLE);
			}
			else {
				if ( _cnt20368>=1 ) { goto _loop20368; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20368++;
		}
		_loop20368:;
		}  // ( ... )+
		match(CSTYLE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
}

void HTMLParser::body_content_no_PCDATA() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case ADDRESS:
		case HR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OTABLE:
		{
			body_tag();
			break;
		}
		case IMG:
		case BFONT:
		case BR:
		case OFORM:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			text_tag();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_2);
	}
}

void HTMLParser::body_content() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case ADDRESS:
		case HR:
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OTABLE:
		{
			body_tag();
			break;
		}
		case PCDATA:
		case IMG:
		case BFONT:
		case BR:
		case OFORM:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			text();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::body_tag() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OH1:
		case OH2:
		case OH3:
		case OH4:
		case OH5:
		case OH6:
		{
			heading();
			break;
		}
		case HR:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case OPRE:
		case ODIV:
		case OCENTER:
		case OBQUOTE:
		case OTABLE:
		{
			block();
			break;
		}
		case ADDRESS:
		{
			match(ADDRESS);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::text_tag() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		{
			font();
			break;
		}
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		{
			phrase();
			break;
		}
		case IMG:
		case BFONT:
		case BR:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			special();
			break;
		}
		case OFORM:
		{
			form();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::heading() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OH1:
		{
			h1();
			break;
		}
		case OH2:
		{
			h2();
			break;
		}
		case OH3:
		{
			h3();
			break;
		}
		case OH4:
		{
			h4();
			break;
		}
		case OH5:
		{
			h5();
			break;
		}
		case OH6:
		{
			h6();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::block() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OPARA:
		{
			paragraph();
			break;
		}
		case OULIST:
		case OOLIST:
		case ODLIST:
		{
			list();
			break;
		}
		case OPRE:
		{
			preformatted();
			break;
		}
		case ODIV:
		{
			div();
			break;
		}
		case OCENTER:
		{
			center();
			break;
		}
		case OBQUOTE:
		{
			blockquote();
			break;
		}
		case HR:
		{
			match(HR);
			break;
		}
		case OTABLE:
		{
			table();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::text() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case PCDATA:
		{
			match(PCDATA);
			break;
		}
		case IMG:
		case BFONT:
		case BR:
		case OFORM:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			text_tag();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::h1() {
	
	try {      // for error handling
		match(OH1);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20390;
			}
			}
		}
		_loop20390:;
		} // ( ... )*
		match(CH1);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::h2() {
	
	try {      // for error handling
		match(OH2);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20393;
			}
			}
		}
		_loop20393:;
		} // ( ... )*
		match(CH2);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::h3() {
	
	try {      // for error handling
		match(OH3);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20396;
			}
			}
		}
		_loop20396:;
		} // ( ... )*
		match(CH3);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::h4() {
	
	try {      // for error handling
		match(OH4);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20399;
			}
			}
		}
		_loop20399:;
		} // ( ... )*
		match(CH4);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::h5() {
	
	try {      // for error handling
		match(OH5);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20402;
			}
			}
		}
		_loop20402:;
		} // ( ... )*
		match(CH5);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::h6() {
	
	try {      // for error handling
		match(OH6);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			default:
			{
				goto _loop20405;
			}
			}
		}
		_loop20405:;
		} // ( ... )*
		match(CH6);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_7);
	}
}

void HTMLParser::paragraph() {
	
	try {      // for error handling
		match(OPARA);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				goto _loop20411;
			}
			
		}
		_loop20411:;
		} // ( ... )*
		{
		switch ( LA(1)) {
		case CPARA:
		{
			match(CPARA);
			break;
		}
		case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
		case PCDATA:
		case CHTML:
		case CBODY:
		case ADDRESS:
		case HR:
		case IMG:
		case BFONT:
		case BR:
		case OH1:
		case CH1:
		case OH2:
		case CH2:
		case OH3:
		case CH3:
		case OH4:
		case CH4:
		case OH5:
		case CH5:
		case OH6:
		case CH6:
		case OPARA:
		case OULIST:
		case OOLIST:
		case ODLIST:
		case CDTERM:
		case OPRE:
		case ODIV:
		case CDIV:
		case OCENTER:
		case CCENTER:
		case OBQUOTE:
		case CBQUOTE:
		case OFORM:
		case CFORM:
		case OTABLE:
		case CTABLE:
		case O_TR:
		case C_TR:
		case O_TH_OR_TD:
		case C_TH_OR_TD:
		case OTTYPE:
		case OITALIC:
		case OBOLD:
		case OUNDER:
		case OSTRIKE:
		case OBIG:
		case OSMALL:
		case OSUB:
		case OSUP:
		case OEM:
		case OSTRONG:
		case ODFN:
		case OCODE:
		case OSAMP:
		case OKBD:
		case OVAR:
		case OCITE:
		case INPUT:
		case OSELECT:
		case OTAREA:
		case OANCHOR:
		case OAPPLET:
		case OFONT:
		case OMAP:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::list() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OULIST:
		{
			unordered_list();
			break;
		}
		case OOLIST:
		{
			ordered_list();
			break;
		}
		case ODLIST:
		{
			def_list();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void HTMLParser::preformatted() {
	
	try {      // for error handling
		match(OPRE);
		{ // ( ... )+
		int _cnt20454=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20454>=1 ) { goto _loop20454; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20454++;
		}
		_loop20454:;
		}  // ( ... )+
		match(CPRE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::div() {
	
	try {      // for error handling
		match(ODIV);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_2.member(LA(1)))) {
				body_content();
			}
			else {
				goto _loop20457;
			}
			
		}
		_loop20457:;
		} // ( ... )*
		match(CDIV);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::center() {
	
	try {      // for error handling
		match(OCENTER);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_2.member(LA(1)))) {
				body_content();
			}
			else {
				goto _loop20460;
			}
			
		}
		_loop20460:;
		} // ( ... )*
		match(CCENTER);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::blockquote() {
	
	try {      // for error handling
		match(OBQUOTE);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_2.member(LA(1)))) {
				body_content();
			}
			else {
				goto _loop20463;
			}
			
		}
		_loop20463:;
		} // ( ... )*
		match(CBQUOTE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::table() {
	
	try {      // for error handling
		match(OTABLE);
		{
		switch ( LA(1)) {
		case OCAP:
		{
			caption();
			break;
		}
		case PCDATA:
		case O_TR:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20470;
			}
			
		}
		_loop20470:;
		} // ( ... )*
		{ // ( ... )+
		int _cnt20472=0;
		for (;;) {
			if ((LA(1) == O_TR)) {
				tr();
			}
			else {
				if ( _cnt20472>=1 ) { goto _loop20472; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20472++;
		}
		_loop20472:;
		}  // ( ... )+
		match(CTABLE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void HTMLParser::font() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OTTYPE:
		{
			teletype();
			break;
		}
		case OITALIC:
		{
			italic();
			break;
		}
		case OBOLD:
		{
			bold();
			break;
		}
		case OUNDER:
		{
			underline();
			break;
		}
		case OSTRIKE:
		{
			strike();
			break;
		}
		case OBIG:
		{
			big();
			break;
		}
		case OSMALL:
		{
			small();
			break;
		}
		case OSUB:
		{
			subscript();
			break;
		}
		case OSUP:
		{
			superscript();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::teletype() {
	
	try {      // for error handling
		match(OTTYPE);
		{ // ( ... )+
		int _cnt20492=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20492>=1 ) { goto _loop20492; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20492++;
		}
		_loop20492:;
		}  // ( ... )+
		match(CTTYPE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::italic() {
	
	try {      // for error handling
		match(OITALIC);
		{ // ( ... )+
		int _cnt20495=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20495>=1 ) { goto _loop20495; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20495++;
		}
		_loop20495:;
		}  // ( ... )+
		match(CITALIC);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::bold() {
	
	try {      // for error handling
		match(OBOLD);
		{ // ( ... )+
		int _cnt20498=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20498>=1 ) { goto _loop20498; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20498++;
		}
		_loop20498:;
		}  // ( ... )+
		match(CBOLD);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::underline() {
	
	try {      // for error handling
		match(OUNDER);
		{ // ( ... )+
		int _cnt20501=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20501>=1 ) { goto _loop20501; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20501++;
		}
		_loop20501:;
		}  // ( ... )+
		match(CUNDER);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::strike() {
	
	try {      // for error handling
		match(OSTRIKE);
		{ // ( ... )+
		int _cnt20504=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20504>=1 ) { goto _loop20504; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20504++;
		}
		_loop20504:;
		}  // ( ... )+
		match(CSTRIKE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::big() {
	
	try {      // for error handling
		match(OBIG);
		{ // ( ... )+
		int _cnt20507=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20507>=1 ) { goto _loop20507; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20507++;
		}
		_loop20507:;
		}  // ( ... )+
		match(CBIG);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::small() {
	
	try {      // for error handling
		match(OSMALL);
		{ // ( ... )+
		int _cnt20510=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20510>=1 ) { goto _loop20510; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20510++;
		}
		_loop20510:;
		}  // ( ... )+
		match(CSMALL);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::subscript() {
	
	try {      // for error handling
		match(OSUB);
		{ // ( ... )+
		int _cnt20513=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20513>=1 ) { goto _loop20513; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20513++;
		}
		_loop20513:;
		}  // ( ... )+
		match(CSUB);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::superscript() {
	
	try {      // for error handling
		match(OSUP);
		{ // ( ... )+
		int _cnt20516=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20516>=1 ) { goto _loop20516; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20516++;
		}
		_loop20516:;
		}  // ( ... )+
		match(CSUP);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::phrase() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OEM:
		{
			emphasize();
			break;
		}
		case OSTRONG:
		{
			strong();
			break;
		}
		case ODFN:
		{
			definition();
			break;
		}
		case OCODE:
		{
			code();
			break;
		}
		case OSAMP:
		{
			sample_output();
			break;
		}
		case OKBD:
		{
			keyboard_text();
			break;
		}
		case OVAR:
		{
			variable();
			break;
		}
		case OCITE:
		{
			citation();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::emphasize() {
	
	try {      // for error handling
		match(OEM);
		{ // ( ... )+
		int _cnt20519=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20519>=1 ) { goto _loop20519; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20519++;
		}
		_loop20519:;
		}  // ( ... )+
		match(CEM);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::strong() {
	
	try {      // for error handling
		match(OSTRONG);
		{ // ( ... )+
		int _cnt20522=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20522>=1 ) { goto _loop20522; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20522++;
		}
		_loop20522:;
		}  // ( ... )+
		match(CSTRONG);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::definition() {
	
	try {      // for error handling
		match(ODFN);
		{ // ( ... )+
		int _cnt20525=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20525>=1 ) { goto _loop20525; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20525++;
		}
		_loop20525:;
		}  // ( ... )+
		match(CDFN);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::code() {
	
	try {      // for error handling
		match(OCODE);
		{ // ( ... )+
		int _cnt20528=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20528>=1 ) { goto _loop20528; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20528++;
		}
		_loop20528:;
		}  // ( ... )+
		match(CCODE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::sample_output() {
	
	try {      // for error handling
		match(OSAMP);
		{ // ( ... )+
		int _cnt20531=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20531>=1 ) { goto _loop20531; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20531++;
		}
		_loop20531:;
		}  // ( ... )+
		match(CSAMP);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::keyboard_text() {
	
	try {      // for error handling
		match(OKBD);
		{ // ( ... )+
		int _cnt20534=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20534>=1 ) { goto _loop20534; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20534++;
		}
		_loop20534:;
		}  // ( ... )+
		match(CKBD);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::variable() {
	
	try {      // for error handling
		match(OVAR);
		{ // ( ... )+
		int _cnt20537=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20537>=1 ) { goto _loop20537; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20537++;
		}
		_loop20537:;
		}  // ( ... )+
		match(CVAR);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::citation() {
	
	try {      // for error handling
		match(OCITE);
		{ // ( ... )+
		int _cnt20540=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20540>=1 ) { goto _loop20540; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20540++;
		}
		_loop20540:;
		}  // ( ... )+
		match(CCITE);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::special() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case OANCHOR:
		{
			anchor();
			break;
		}
		case IMG:
		{
			match(IMG);
			break;
		}
		case OAPPLET:
		{
			applet();
			break;
		}
		case OFONT:
		{
			font_dfn();
			break;
		}
		case BFONT:
		{
			match(BFONT);
			break;
		}
		case OMAP:
		{
			map();
			break;
		}
		case BR:
		{
			match(BR);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::anchor() {
	
	try {      // for error handling
		match(OANCHOR);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				goto _loop20555;
			}
			
		}
		_loop20555:;
		} // ( ... )*
		match(CANCHOR);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::applet() {
	
	try {      // for error handling
		match(OAPPLET);
		{
		switch ( LA(1)) {
		case APARAM:
		{
			match(APARAM);
			break;
		}
		case PCDATA:
		case CAPPLET:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20559;
			}
			
		}
		_loop20559:;
		} // ( ... )*
		match(CAPPLET);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::font_dfn() {
	
	try {      // for error handling
		match(OFONT);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				goto _loop20562;
			}
			
		}
		_loop20562:;
		} // ( ... )*
		match(CFONT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::map() {
	
	try {      // for error handling
		match(OMAP);
		{ // ( ... )+
		int _cnt20565=0;
		for (;;) {
			if ((LA(1) == AREA)) {
				match(AREA);
			}
			else {
				if ( _cnt20565>=1 ) { goto _loop20565; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20565++;
		}
		_loop20565:;
		}  // ( ... )+
		match(CMAP);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::form() {
	
	try {      // for error handling
		match(OFORM);
		{ // ( ... )*
		for (;;) {
			switch ( LA(1)) {
			case INPUT:
			case OSELECT:
			case OTAREA:
			{
				form_field();
				break;
			}
			case PCDATA:
			case ADDRESS:
			case HR:
			case IMG:
			case BFONT:
			case BR:
			case OH1:
			case OH2:
			case OH3:
			case OH4:
			case OH5:
			case OH6:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OFORM:
			case OTABLE:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				body_content();
				break;
			}
			default:
			{
				goto _loop20466;
			}
			}
		}
		_loop20466:;
		} // ( ... )*
		match(CFORM);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void HTMLParser::address() {
	
	try {      // for error handling
		match(OADDRESS);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20408;
			}
			
		}
		_loop20408:;
		} // ( ... )*
		match(CADDRESS);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void HTMLParser::unordered_list() {
	
	try {      // for error handling
		match(OULIST);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20416;
			}
			
		}
		_loop20416:;
		} // ( ... )*
		{ // ( ... )+
		int _cnt20418=0;
		for (;;) {
			if ((LA(1) == OLITEM)) {
				list_item();
			}
			else {
				if ( _cnt20418>=1 ) { goto _loop20418; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20418++;
		}
		_loop20418:;
		}  // ( ... )+
		match(CULIST);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void HTMLParser::ordered_list() {
	
	try {      // for error handling
		match(OOLIST);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20421;
			}
			
		}
		_loop20421:;
		} // ( ... )*
		{ // ( ... )+
		int _cnt20423=0;
		for (;;) {
			if ((LA(1) == OLITEM)) {
				list_item();
			}
			else {
				if ( _cnt20423>=1 ) { goto _loop20423; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20423++;
		}
		_loop20423:;
		}  // ( ... )+
		match(COLIST);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void HTMLParser::def_list() {
	
	try {      // for error handling
		match(ODLIST);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20426;
			}
			
		}
		_loop20426:;
		} // ( ... )*
		{ // ( ... )+
		int _cnt20428=0;
		for (;;) {
			if ((LA(1) == ODTERM || LA(1) == ODDEF)) {
				def_list_item();
			}
			else {
				if ( _cnt20428>=1 ) { goto _loop20428; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20428++;
		}
		_loop20428:;
		}  // ( ... )+
		match(CDLIST);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void HTMLParser::list_item() {
	
	try {      // for error handling
		match(OLITEM);
		{ // ( ... )+
		int _cnt20431=0;
		for (;;) {
			switch ( LA(1)) {
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			case OULIST:
			case OOLIST:
			case ODLIST:
			{
				list();
				break;
			}
			default:
			{
				if ( _cnt20431>=1 ) { goto _loop20431; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			}
			_cnt20431++;
		}
		_loop20431:;
		}  // ( ... )+
		{
		switch ( LA(1)) {
		case CLITEM:
		{
			match(CLITEM);
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == PCDATA)) {
					match(PCDATA);
				}
				else {
					goto _loop20434;
				}
				
			}
			_loop20434:;
			} // ( ... )*
			break;
		}
		case CULIST:
		case COLIST:
		case OLITEM:
		case CDIR:
		case CMENU:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_12);
	}
}

void HTMLParser::def_list_item() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case ODTERM:
		{
			dt();
			break;
		}
		case ODDEF:
		{
			dd();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void HTMLParser::dt() {
	
	try {      // for error handling
		match(ODTERM);
		{ // ( ... )+
		int _cnt20438=0;
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				if ( _cnt20438>=1 ) { goto _loop20438; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20438++;
		}
		_loop20438:;
		}  // ( ... )+
		match(CDTERM);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20440;
			}
			
		}
		_loop20440:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void HTMLParser::dd() {
	
	try {      // for error handling
		match(ODDEF);
		{ // ( ... )+
		int _cnt20443=0;
		for (;;) {
			switch ( LA(1)) {
			case PCDATA:
			case IMG:
			case BFONT:
			case BR:
			case OFORM:
			case OTTYPE:
			case OITALIC:
			case OBOLD:
			case OUNDER:
			case OSTRIKE:
			case OBIG:
			case OSMALL:
			case OSUB:
			case OSUP:
			case OEM:
			case OSTRONG:
			case ODFN:
			case OCODE:
			case OSAMP:
			case OKBD:
			case OVAR:
			case OCITE:
			case OANCHOR:
			case OAPPLET:
			case OFONT:
			case OMAP:
			{
				text();
				break;
			}
			case HR:
			case OPARA:
			case OULIST:
			case OOLIST:
			case ODLIST:
			case OPRE:
			case ODIV:
			case OCENTER:
			case OBQUOTE:
			case OTABLE:
			{
				block();
				break;
			}
			default:
			{
				if ( _cnt20443>=1 ) { goto _loop20443; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			}
			_cnt20443++;
		}
		_loop20443:;
		}  // ( ... )+
		match(CDTERM);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20445;
			}
			
		}
		_loop20445:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void HTMLParser::dir() {
	
	try {      // for error handling
		match(ODIR);
		{ // ( ... )+
		int _cnt20448=0;
		for (;;) {
			if ((LA(1) == OLITEM)) {
				list_item();
			}
			else {
				if ( _cnt20448>=1 ) { goto _loop20448; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20448++;
		}
		_loop20448:;
		}  // ( ... )+
		match(CDIR);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void HTMLParser::menu() {
	
	try {      // for error handling
		match(OMENU);
		{ // ( ... )+
		int _cnt20451=0;
		for (;;) {
			if ((LA(1) == OLITEM)) {
				list_item();
			}
			else {
				if ( _cnt20451>=1 ) { goto _loop20451; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20451++;
		}
		_loop20451:;
		}  // ( ... )+
		match(CMENU);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_0);
	}
}

void HTMLParser::form_field() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case INPUT:
		{
			match(INPUT);
			break;
		}
		case OSELECT:
		{
			select();
			break;
		}
		case OTAREA:
		{
			textarea();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void HTMLParser::caption() {
	
	try {      // for error handling
		match(OCAP);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_10.member(LA(1)))) {
				text();
			}
			else {
				goto _loop20475;
			}
			
		}
		_loop20475:;
		} // ( ... )*
		match(CCAP);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_15);
	}
}

void HTMLParser::tr() {
	
	try {      // for error handling
		match(O_TR);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20478;
			}
			
		}
		_loop20478:;
		} // ( ... )*
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == O_TH_OR_TD)) {
				th_or_td();
			}
			else {
				goto _loop20480;
			}
			
		}
		_loop20480:;
		} // ( ... )*
		{
		switch ( LA(1)) {
		case C_TR:
		{
			match(C_TR);
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == PCDATA)) {
					match(PCDATA);
				}
				else {
					goto _loop20483;
				}
				
			}
			_loop20483:;
			} // ( ... )*
			break;
		}
		case CTABLE:
		case O_TR:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void HTMLParser::th_or_td() {
	
	try {      // for error handling
		match(O_TH_OR_TD);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_2.member(LA(1)))) {
				body_content();
			}
			else {
				goto _loop20486;
			}
			
		}
		_loop20486:;
		} // ( ... )*
		{
		switch ( LA(1)) {
		case C_TH_OR_TD:
		{
			match(C_TH_OR_TD);
			{ // ( ... )*
			for (;;) {
				if ((LA(1) == PCDATA)) {
					match(PCDATA);
				}
				else {
					goto _loop20489;
				}
				
			}
			_loop20489:;
			} // ( ... )*
			break;
		}
		case CTABLE:
		case O_TR:
		case C_TR:
		case O_TH_OR_TD:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_17);
	}
}

void HTMLParser::select() {
	
	try {      // for error handling
		match(OSELECT);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20544;
			}
			
		}
		_loop20544:;
		} // ( ... )*
		{ // ( ... )+
		int _cnt20546=0;
		for (;;) {
			if ((LA(1) == SELOPT)) {
				select_option();
			}
			else {
				if ( _cnt20546>=1 ) { goto _loop20546; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20546++;
		}
		_loop20546:;
		}  // ( ... )+
		match(CSELECT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void HTMLParser::textarea() {
	
	try {      // for error handling
		match(OTAREA);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20552;
			}
			
		}
		_loop20552:;
		} // ( ... )*
		match(CTAREA);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void HTMLParser::select_option() {
	
	try {      // for error handling
		match(SELOPT);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PCDATA)) {
				match(PCDATA);
			}
			else {
				goto _loop20549;
			}
			
		}
		_loop20549:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_18);
	}
}

void HTMLParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* HTMLParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"PCDATA",
	"DOCTYPE",
	"OHTML",
	"CHTML",
	"OHEAD",
	"CHEAD",
	"ISINDEX",
	"BASE",
	"META",
	"LINK",
	"OTITLE",
	"CTITLE",
	"OSCRIPT",
	"CSCRIPT",
	"OSTYLE",
	"CSTYLE",
	"OBODY",
	"CBODY",
	"ADDRESS",
	"HR",
	"IMG",
	"BFONT",
	"BR",
	"OH1",
	"CH1",
	"OH2",
	"CH2",
	"OH3",
	"CH3",
	"OH4",
	"CH4",
	"OH5",
	"CH5",
	"OH6",
	"CH6",
	"OADDRESS",
	"CADDRESS",
	"OPARA",
	"CPARA",
	"OULIST",
	"CULIST",
	"OOLIST",
	"COLIST",
	"ODLIST",
	"CDLIST",
	"OLITEM",
	"CLITEM",
	"ODTERM",
	"CDTERM",
	"ODDEF",
	"ODIR",
	"CDIR",
	"OMENU",
	"CMENU",
	"OPRE",
	"CPRE",
	"ODIV",
	"CDIV",
	"OCENTER",
	"CCENTER",
	"OBQUOTE",
	"CBQUOTE",
	"OFORM",
	"CFORM",
	"OTABLE",
	"CTABLE",
	"OCAP",
	"CCAP",
	"O_TR",
	"C_TR",
	"O_TH_OR_TD",
	"C_TH_OR_TD",
	"OTTYPE",
	"CTTYPE",
	"OITALIC",
	"CITALIC",
	"OBOLD",
	"CBOLD",
	"OUNDER",
	"CUNDER",
	"OSTRIKE",
	"CSTRIKE",
	"OBIG",
	"CBIG",
	"OSMALL",
	"CSMALL",
	"OSUB",
	"CSUB",
	"OSUP",
	"CSUP",
	"OEM",
	"CEM",
	"OSTRONG",
	"CSTRONG",
	"ODFN",
	"CDFN",
	"OCODE",
	"CCODE",
	"OSAMP",
	"CSAMP",
	"OKBD",
	"CKBD",
	"OVAR",
	"CVAR",
	"OCITE",
	"CCITE",
	"INPUT",
	"OSELECT",
	"CSELECT",
	"SELOPT",
	"OTAREA",
	"CTAREA",
	"OANCHOR",
	"CANCHOR",
	"OAPPLET",
	"APARAM",
	"CAPPLET",
	"OFONT",
	"CFONT",
	"OMAP",
	"AREA",
	"CMAP",
	"CDDEF",
	"CDIR_OR_CDIV",
	"OSTRIKE_OR_OSTRONG",
	"CST_LEFT_FACTORED",
	"CSUB_OR_CSUP",
	"APARM",
	"CFORM_OR_CFONT",
	"BFONT_OR_BASE",
	"COMMENT_DATA",
	"COMMENT",
	"WS_",
	"ATTR",
	"WORD",
	"STRING",
	"WSCHARS",
	"SPECIAL",
	"HEXNUM",
	"INT",
	"HEXINT",
	"DIGIT",
	"HEXDIGIT",
	"LCLETTER",
	"UNDEFINED_TOKEN",
	0
};

const unsigned long HTMLParser::_tokenSet_0_data_[] = { 2UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_0(_tokenSet_0_data_,6);
const unsigned long HTMLParser::_tokenSet_1_data_[] = { 2949644418UL, 1409329706UL, 1431654421UL, 173020501UL, 0UL, 0UL, 0UL, 0UL };
// EOF CHTML OBODY ADDRESS HR IMG BFONT BR OH1 OH2 OH3 OH4 OH5 OH6 OPARA 
// OULIST OOLIST ODLIST OPRE ODIV OCENTER OBQUOTE OFORM OTABLE OTTYPE OITALIC 
// OBOLD OUNDER OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP 
// OKBD OVAR OCITE OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_1(_tokenSet_1_data_,8);
const unsigned long HTMLParser::_tokenSet_2_data_[] = { 2948595728UL, 1409329706UL, 1431654421UL, 173020501UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA ADDRESS HR IMG BFONT BR OH1 OH2 OH3 OH4 OH5 OH6 OPARA OULIST 
// OOLIST ODLIST OPRE ODIV OCENTER OBQUOTE OFORM OTABLE OTTYPE OITALIC 
// OBOLD OUNDER OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP 
// OKBD OVAR OCITE OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_2(_tokenSet_2_data_,8);
const unsigned long HTMLParser::_tokenSet_3_data_[] = { 130UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// EOF CHTML 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_3(_tokenSet_3_data_,6);
const unsigned long HTMLParser::_tokenSet_4_data_[] = { 2950004370UL, 1409329706UL, 1431654421UL, 173020501UL, 0UL, 0UL, 0UL, 0UL };
// EOF PCDATA CHTML CHEAD ISINDEX BASE META LINK OTITLE OSCRIPT OSTYLE 
// OBODY ADDRESS HR IMG BFONT BR OH1 OH2 OH3 OH4 OH5 OH6 OPARA OULIST OOLIST 
// ODLIST OPRE ODIV OCENTER OBQUOTE OFORM OTABLE OTTYPE OITALIC OBOLD OUNDER 
// OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP OKBD OVAR 
// OCITE OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_4(_tokenSet_4_data_,8);
const unsigned long HTMLParser::_tokenSet_5_data_[] = { 4294836208UL, 4294967295UL, 4294967295UL, 4294967295UL, 2097151UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE META LINK OTITLE 
// CTITLE OSCRIPT OSTYLE CSTYLE OBODY CBODY ADDRESS HR IMG BFONT BR OH1 
// CH1 OH2 CH2 OH3 CH3 OH4 CH4 OH5 CH5 OH6 CH6 OADDRESS CADDRESS OPARA 
// CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM CLITEM ODTERM 
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
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_5(_tokenSet_5_data_,12);
const unsigned long HTMLParser::_tokenSet_6_data_[] = { 4294442992UL, 4294967295UL, 4294967295UL, 4294967295UL, 2097151UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA DOCTYPE OHTML CHTML OHEAD CHEAD ISINDEX BASE META LINK OTITLE 
// CTITLE OSCRIPT CSCRIPT OSTYLE OBODY CBODY ADDRESS HR IMG BFONT BR OH1 
// CH1 OH2 CH2 OH3 CH3 OH4 CH4 OH5 CH5 OH6 CH6 OADDRESS CADDRESS OPARA 
// CPARA OULIST CULIST OOLIST COLIST ODLIST CDLIST OLITEM CLITEM ODTERM 
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
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_6(_tokenSet_6_data_,12);
const unsigned long HTMLParser::_tokenSet_7_data_[] = { 2950693010UL, 4093684266UL, 1431658303UL, 173331797UL, 0UL, 0UL, 0UL, 0UL };
// EOF PCDATA CHTML CBODY ADDRESS HR IMG BFONT BR OH1 OH2 OH3 OH4 OH5 OH6 
// OPARA OULIST OOLIST ODLIST OPRE ODIV CDIV OCENTER CCENTER OBQUOTE CBQUOTE 
// OFORM CFORM OTABLE CTABLE O_TR C_TR O_TH_OR_TD C_TH_OR_TD OTTYPE OITALIC 
// OBOLD OUNDER OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP 
// OKBD OVAR OCITE INPUT OSELECT OTAREA OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_7(_tokenSet_7_data_,8);
const unsigned long HTMLParser::_tokenSet_8_data_[] = { 4292870290UL, 4271308415UL, 4294967231UL, 242548735UL, 0UL, 0UL, 0UL, 0UL };
// EOF PCDATA CHTML CBODY ADDRESS HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 
// OH4 CH4 OH5 CH5 OH6 CH6 OPARA CPARA OULIST CULIST OOLIST COLIST ODLIST 
// OLITEM CLITEM CDTERM CDIR CMENU OPRE CPRE ODIV CDIV OCENTER CCENTER 
// OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE CCAP O_TR C_TR O_TH_OR_TD 
// C_TH_OR_TD OTTYPE CTTYPE OITALIC CITALIC OBOLD CBOLD OUNDER CUNDER OSTRIKE 
// CSTRIKE OBIG CBIG OSMALL CSMALL OSUB CSUB OSUP CSUP OEM CEM OSTRONG 
// CSTRONG ODFN CDFN OCODE CCODE OSAMP CSAMP OKBD CKBD OVAR CVAR OCITE 
// CCITE INPUT OSELECT OTAREA OANCHOR CANCHOR OAPPLET OFONT CFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_8(_tokenSet_8_data_,8);
const unsigned long HTMLParser::_tokenSet_9_data_[] = { 4292870290UL, 4094732927UL, 1431658303UL, 173331797UL, 0UL, 0UL, 0UL, 0UL };
// EOF PCDATA CHTML CBODY ADDRESS HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 
// OH4 CH4 OH5 CH5 OH6 CH6 OPARA OULIST OOLIST ODLIST CDTERM OPRE ODIV 
// CDIV OCENTER CCENTER OBQUOTE CBQUOTE OFORM CFORM OTABLE CTABLE O_TR 
// C_TR O_TH_OR_TD C_TH_OR_TD OTTYPE OITALIC OBOLD OUNDER OSTRIKE OBIG 
// OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP OKBD OVAR OCITE INPUT 
// OSELECT OTAREA OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_9(_tokenSet_9_data_,8);
const unsigned long HTMLParser::_tokenSet_10_data_[] = { 117440528UL, 0UL, 1431654404UL, 173020501UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA IMG BFONT BR OFORM OTTYPE OITALIC OBOLD OUNDER OSTRIKE OBIG OSMALL 
// OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP OKBD OVAR OCITE OANCHOR OAPPLET 
// OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_10(_tokenSet_10_data_,8);
const unsigned long HTMLParser::_tokenSet_11_data_[] = { 4292870290UL, 4137089663UL, 1431658303UL, 173331797UL, 0UL, 0UL, 0UL, 0UL };
// EOF PCDATA CHTML CBODY ADDRESS HR IMG BFONT BR OH1 CH1 OH2 CH2 OH3 CH3 
// OH4 CH4 OH5 CH5 OH6 CH6 OPARA OULIST CULIST OOLIST COLIST ODLIST OLITEM 
// CLITEM CDTERM CDIR CMENU OPRE ODIV CDIV OCENTER CCENTER OBQUOTE CBQUOTE 
// OFORM CFORM OTABLE CTABLE O_TR C_TR O_TH_OR_TD C_TH_OR_TD OTTYPE OITALIC 
// OBOLD OUNDER OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP 
// OKBD OVAR OCITE INPUT OSELECT OTAREA OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_11(_tokenSet_11_data_,8);
const unsigned long HTMLParser::_tokenSet_12_data_[] = { 0UL, 42094592UL, 0UL, 0UL, 0UL, 0UL };
// CULIST COLIST OLITEM CDIR CMENU 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_12(_tokenSet_12_data_,6);
const unsigned long HTMLParser::_tokenSet_13_data_[] = { 0UL, 2686976UL, 0UL, 0UL, 0UL, 0UL };
// CDLIST ODTERM ODDEF 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_13(_tokenSet_13_data_,6);
const unsigned long HTMLParser::_tokenSet_14_data_[] = { 2948595728UL, 1409329706UL, 1431654429UL, 173331797UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA ADDRESS HR IMG BFONT BR OH1 OH2 OH3 OH4 OH5 OH6 OPARA OULIST 
// OOLIST ODLIST OPRE ODIV OCENTER OBQUOTE OFORM CFORM OTABLE OTTYPE OITALIC 
// OBOLD OUNDER OSTRIKE OBIG OSMALL OSUB OSUP OEM OSTRONG ODFN OCODE OSAMP 
// OKBD OVAR OCITE INPUT OSELECT OTAREA OANCHOR OAPPLET OFONT OMAP 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_14(_tokenSet_14_data_,8);
const unsigned long HTMLParser::_tokenSet_15_data_[] = { 16UL, 0UL, 256UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// PCDATA O_TR 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_15(_tokenSet_15_data_,8);
const unsigned long HTMLParser::_tokenSet_16_data_[] = { 0UL, 0UL, 288UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CTABLE O_TR 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_16(_tokenSet_16_data_,8);
const unsigned long HTMLParser::_tokenSet_17_data_[] = { 0UL, 0UL, 1824UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CTABLE O_TR C_TR O_TH_OR_TD 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_17(_tokenSet_17_data_,8);
const unsigned long HTMLParser::_tokenSet_18_data_[] = { 0UL, 0UL, 0UL, 196608UL, 0UL, 0UL, 0UL, 0UL };
// CSELECT SELOPT 
const ANTLR_USE_NAMESPACE(antlr)BitSet HTMLParser::_tokenSet_18(_tokenSet_18_data_,8);


