#ifndef INC_JavaTreeParser_hpp_
#define INC_JavaTreeParser_hpp_

#include <antlr/config.hpp>
#include "JavaTreeParserTokenTypes.hpp"
/* $ANTLR 2.7.2: "java.tree.g" -> "JavaTreeParser.hpp"$ */
#include <antlr/TreeParser.hpp>

/** Java 1.1 AST Recognizer Grammar
 *
 * Author:
 *		Terence Parr	parrt@magelang.com
 *
 * This grammar is in the PUBLIC DOMAIN
 *
 * BUGS
 */
class JavaTreeParser : public ANTLR_USE_NAMESPACE(antlr)TreeParser, public JavaTreeParserTokenTypes
{
#line 1 "java.tree.g"
#line 22 "JavaTreeParser.hpp"
public:
	JavaTreeParser();
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
	int getNumTokens() const
	{
		return JavaTreeParser::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return JavaTreeParser::tokenNames[type];
	}
	public: void compilationUnit(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void packageDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void importDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void typeDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void identifier(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void identifierStar(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void modifiers(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void extendsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void implementsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void objBlock(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void typeSpec(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void typeSpecArray(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void type(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void builtInType(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void modifier(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void ctorDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void methodDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void variableDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void slist(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void methodHead(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void variableDeclarator(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void varInitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void parameterDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void objectinitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void initializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void expression(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void arrayInitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void throwsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void elist(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void caseGroup(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void tryBlock(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void handler(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void primaryExpression(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void arrayIndex(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void newExpression(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void constant(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
	public: void newArrayDeclarator(ANTLR_USE_NAMESPACE(antlr)RefAST _t);
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 133;
#else
	enum {
		NUM_TOKENS = 133
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
};

#endif /*INC_JavaTreeParser_hpp_*/
