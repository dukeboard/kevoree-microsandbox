#ifndef INC_DemoJavaLexer_hpp_
#define INC_DemoJavaLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "javalex.g" -> "DemoJavaLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "JavaTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 1 "javalex.g"

#include "antlr/TokenStreamSelector.hpp"

#line 16 "DemoJavaLexer.hpp"
class DemoJavaLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public JavaTokenTypes
{
#line 20 "javalex.g"

private:
	ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector;
public:
	void setSelector(ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector_) {
		selector=selector_;
	}
#line 20 "DemoJavaLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	DemoJavaLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	DemoJavaLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	DemoJavaLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mJAVADOC_OPEN(bool _createToken);
	public: void mID(bool _createToken);
	public: void mSEMI(bool _createToken);
	public: void mWS_(bool _createToken);
private:
	
};

#endif /*INC_DemoJavaLexer_hpp_*/
