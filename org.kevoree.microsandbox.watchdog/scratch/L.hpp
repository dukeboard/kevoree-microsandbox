#ifndef INC_L_hpp_
#define INC_L_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "column.g" -> "L.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "PTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class L : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public PTokenTypes
{
#line 56 "column.g"

	// these get inserted into the generated class
public:
	/** handles encountered tabs (it is called from the consume method in
	 * CharScanner (superclass of lexers)
	 * the default version increases the column by 1
	 */
	void tab( void );
	/// set tabsize, returns previous value
	unsigned int set_tabsize( unsigned int tab );
protected:
	unsigned int tabsize;
#line 15 "L.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	L(ANTLR_USE_NAMESPACE(std)istream& in);
	L(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	L(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mNL(bool _createToken);
	public: void mWS(bool _createToken);
	public: void mNB(bool _createToken);
private:
	
};

#endif /*INC_L_hpp_*/
