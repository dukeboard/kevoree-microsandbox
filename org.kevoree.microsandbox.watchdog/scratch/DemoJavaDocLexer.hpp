#ifndef INC_DemoJavaDocLexer_hpp_
#define INC_DemoJavaDocLexer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "javadoclex.g" -> "DemoJavaDocLexer.hpp"$ */
#include <antlr/CommonToken.hpp>
#include <antlr/InputBuffer.hpp>
#include <antlr/BitSet.hpp>
#include "JavaDocTokenTypes.hpp"
#include <antlr/CharScanner.hpp>
#line 1 "javadoclex.g"

#include "antlr/TokenStreamSelector.hpp"

#line 16 "DemoJavaDocLexer.hpp"
class DemoJavaDocLexer : public ANTLR_USE_NAMESPACE(antlr)CharScanner, public JavaDocTokenTypes
{
#line 17 "javadoclex.g"

private:
	ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector;
public:
	void setSelector(ANTLR_USE_NAMESPACE(antlr)TokenStreamSelector* selector_) {
		selector=selector_;
	}
#line 20 "DemoJavaDocLexer.hpp"
private:
	void initLiterals();
public:
	bool getCaseSensitiveLiterals() const
	{
		return true;
	}
public:
	DemoJavaDocLexer(ANTLR_USE_NAMESPACE(std)istream& in);
	DemoJavaDocLexer(ANTLR_USE_NAMESPACE(antlr)InputBuffer& ib);
	DemoJavaDocLexer(const ANTLR_USE_NAMESPACE(antlr)LexerSharedInputState& state);
	ANTLR_USE_NAMESPACE(antlr)RefToken nextToken();
	public: void mPARAM(bool _createToken);
	protected: void mID(bool _createToken);
	public: void mEXCEPTION(bool _createToken);
	public: void mSTAR(bool _createToken);
	public: void mJAVADOC_CLOSE(bool _createToken);
	public: void mNEWLINE(bool _createToken);
private:
	
};

#endif /*INC_DemoJavaDocLexer_hpp_*/
