#ifndef INC_SimpleLexer_hpp_
#define INC_SimpleLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "lexer.g" -> "SimpleLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "SimpleTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 5 "lexer.g"

/* empty header */

#line 16 "SimpleLexer.hpp"
class SimpleLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public SimpleTokenTypes
{
#line 1 "lexer.g"
#line 20 "SimpleLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	SimpleLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	SimpleLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	SimpleLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mWS_(bool _createToken);
	public: void mA(bool _createToken);
	public: void mB(bool _createToken);
	public: void mC(bool _createToken);
	public: void mD(bool _createToken);
private:
	
};

#endif /*INC_SimpleLexer_hpp_*/
