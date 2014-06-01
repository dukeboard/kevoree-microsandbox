#ifndef INC_ExprLexer_hpp_
#define INC_ExprLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "expr.g" -> "ExprLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "ExprParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class ExprLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public ExprParserTokenTypes
{
#line 1 "expr.g"
#line 15 "ExprLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	ExprLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	ExprLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	ExprLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mWS_(bool _createToken);
	public: void mLPAREN(bool _createToken);
	public: void mRPAREN(bool _createToken);
	public: void mPLUS_MINUS(bool _createToken);
	public: void mMULT_DIV(bool _createToken);
	public: void mASSIGN(bool _createToken);
	public: void mCOMMA(bool _createToken);
	public: void mCHAR_LITERAL(bool _createToken);
	protected: void mESC(bool _createToken);
	public: void mSTRING_LITERAL(bool _createToken);
	protected: void mDIGIT(bool _createToken);
	public: void mINT(bool _createToken);
	public: void mID(bool _createToken);
private:
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_ExprLexer_hpp_*/
