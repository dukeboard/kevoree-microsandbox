#ifndef INC_T_hpp_
#define INC_T_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "t.g" -> "T.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "TTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class T : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public TTokenTypes
{
#line 1 "t.g"
#line 15 "T.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	T(ANTLR_USE_NAMESPACE(std)istream& in);
	T(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	T(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mP(bool _createToken);
	public: void mBR(bool _createToken);
	public: void mNEWLINE(bool _createToken);
	public: void mTAB(bool _createToken);
private:
	
};

#endif /*INC_T_hpp_*/
