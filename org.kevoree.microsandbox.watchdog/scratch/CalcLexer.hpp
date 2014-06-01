#ifndef INC_CalcLexer_hpp_
#define INC_CalcLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "calc.g" -> "CalcLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "CalcParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class CalcLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public CalcParserTokenTypes
{
#line 1 "calc.g"
#line 15 "CalcLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	CalcLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	CalcLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	CalcLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mWS_(bool _createToken);
	public: void mLPAREN(bool _createToken);
	public: void mRPAREN(bool _createToken);
	public: void mSTAR(bool _createToken);
	public: void mPLUS(bool _createToken);
	public: void mSEMI(bool _createToken);
	protected: void mDIGIT(bool _createToken);
	public: void mINT(bool _createToken);
private:
	
};

#endif /*INC_CalcLexer_hpp_*/
