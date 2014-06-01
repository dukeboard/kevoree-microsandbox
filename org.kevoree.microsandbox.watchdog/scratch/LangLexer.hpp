#ifndef INC_LangLexer_hpp_
#define INC_LangLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "treewalk.g" -> "LangLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "LangParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 1 "treewalk.g"

#include <iostream>

#line 16 "LangLexer.hpp"
class LangLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public LangParserTokenTypes
{
#line 1 "treewalk.g"
#line 20 "LangLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	LangLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	LangLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	LangLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mWS_(bool _createToken);
	public: void mLPAREN(bool _createToken);
	public: void mRPAREN(bool _createToken);
	public: void mLCURLY(bool _createToken);
	public: void mRCURLY(bool _createToken);
	public: void mASSIGN(bool _createToken);
	public: void mSEMI(bool _createToken);
	protected: void mDIGIT(bool _createToken);
	public: void mINT(bool _createToken);
	public: void mID(bool _createToken);
private:
	
};

#endif /*INC_LangLexer_hpp_*/
