#ifndef INC_Rewrite_hpp_
#define INC_Rewrite_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "rewrite.g" -> "Rewrite.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "RewriteTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class Rewrite : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public RewriteTokenTypes
{
#line 1 "rewrite.g"
#line 15 "Rewrite.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	Rewrite(ANTLR_USE_NAMESPACE(std)istream& in);
	Rewrite(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	Rewrite(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mSTART(bool _createToken);
	protected: void mID(bool _createToken);
	protected: void mWS_(bool _createToken);
	protected: void mEXPR(bool _createToken);
	protected: void mLETTER(bool _createToken);
	protected: void mINT(bool _createToken);
private:
	
};

#endif /*INC_Rewrite_hpp_*/
