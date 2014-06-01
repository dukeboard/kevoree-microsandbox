#ifndef INC_InstrTreeWalker_hpp_
#define INC_InstrTreeWalker_hpp_

#include <antlr/config.hpp>
#include "InstrParserTokenTypes.hpp"
/* $ANTLR 2.7.2: "instr.g" -> "InstrTreeWalker.hpp"$ */
#include <antlr/TreeParser.hpp>

#line 1 "instr.g"

#include "antlr/CommonASTWithHiddenTokens.hpp"
#include "antlr/TokenStreamHiddenTokenFilter.hpp"
#include <iostream>

#line 16 "InstrTreeWalker.hpp"
class InstrTreeWalker : public ANTLR_USE_NAMESPACE(antlr)TreeParser, public InstrParserTokenTypes
{
#line 106 "instr.g"

public:
	void setFilter(ANTLR_USE_NAMESPACE(antlr)TokenStreamHiddenTokenFilter& filter);
private:
	ANTLR_USE_NAMESPACE(antlr)TokenStreamHiddenTokenFilter* filter;

	void dumpHidden(ANTLR_USE_NAMESPACE(antlr)RefToken t);
	void pr(ANTLR_USE_NAMESPACE(antlr)RefAST p);
#line 20 "InstrTreeWalker.hpp"
public:
	InstrTreeWalker();
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
	int getNumTokens() const
	{
		return InstrTreeWalker::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return InstrTreeWalker::tokenNames[type];
	}
	public: void slist(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void call(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void callDumpInstrumentation(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 21;
#else
	enum {
		NUM_TOKENS = 21
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_InstrTreeWalker_hpp_*/
