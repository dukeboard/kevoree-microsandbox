#ifndef INC_PLexer_hpp_
#define INC_PLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "P.g" -> "PLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "PParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 1 "P.g"

#include "Main.hpp"
#include <string>
#include <iostream>

#line 18 "PLexer.hpp"
class PLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public PParserTokenTypes
{
#line 55 "P.g"

public:
	void uponEOF() /*throws TokenStreamException, CharStreamException*/ {
		if ( selector.getCurrentStream() != mainLexer ) {
			// don't allow EOF until main lexer.  Force the
			// selector to retry for another token.
			selector.pop(); // return to old lexer/stream
			selector.retry();
		}
		else {
			ANTLR_USE_NAMESPACE(std)cout << "Hit EOF of main file" << ANTLR_USE_NAMESPACE(std)endl;
		}
	}
#line 22 "PLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	PLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	PLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	PLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mSEMI(bool _createToken);
	public: void mCOMMA(bool _createToken);
	public: void mID(bool _createToken);
	public: void mINCLUDE(bool _createToken);
	public: void mWS_(bool _createToken);
	public: void mSTRING(bool _createToken);
private:
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_PLexer_hpp_*/
