#ifndef INC_InstrLexer_hpp_
#define INC_InstrLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "instr.g" -> "InstrLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "InstrParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 1 "instr.g"

#include "antlr/CommonASTWithHiddenTokens.hpp"
#include "antlr/TokenStreamHiddenTokenFilter.hpp"
#include <iostream>

#line 18 "InstrLexer.hpp"
class InstrLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public InstrParserTokenTypes
{
#line 1 "instr.g"
#line 22 "InstrLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	InstrLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	InstrLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	InstrLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mWS_(bool _createToken);
	public: void mSL_COMMENT(bool _createToken);
	public: void mLBRACE(bool _createToken);
	public: void mRBRACE(bool _createToken);
	public: void mLPAREN(bool _createToken);
	public: void mRPAREN(bool _createToken);
	public: void mSTAR(bool _createToken);
	public: void mPLUS(bool _createToken);
	public: void mSEMI(bool _createToken);
	public: void mASSIGN(bool _createToken);
	protected: void mDIGIT(bool _createToken);
	public: void mINT(bool _createToken);
	public: void mID(bool _createToken);
private:
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_InstrLexer_hpp_*/
