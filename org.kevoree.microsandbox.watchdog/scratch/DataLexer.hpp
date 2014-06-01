#ifndef INC_DataLexer_hpp_
#define INC_DataLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "data.g" -> "DataLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "DataParserTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
class DataLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public DataParserTokenTypes
{
#line 1 "data.g"
#line 15 "DataLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	DataLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	DataLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	DataLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mSHORT(bool _createToken);
	public: void mSTRING(bool _createToken);
private:
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_DataLexer_hpp_*/
