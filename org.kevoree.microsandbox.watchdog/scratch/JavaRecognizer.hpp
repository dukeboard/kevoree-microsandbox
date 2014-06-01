#ifndef INC_JavaRecognizer_hpp_
#define INC_JavaRecognizer_hpp_

#include <antlr/config.hpp>
/* $ANTLR 2.7.2: "java.g" -> "JavaRecognizer.hpp"$ */
#include <antlr/TokenStream.hpp>
#include <antlr/TokenBuffer.hpp>
#include "JavaTokenTypes.hpp"
#include <antlr/LLkParser.hpp>

/** Java 1.1 Recognizer Grammar
 *
 * Run 'java JavaRecognizer <directory full of java files>'
 *
 * Authors:
 *		John Mitchell		johnm@non.net
 *		Terence Parr		parrt@magelang.com
 *		John Lilley			jlilley@empathy.com
 *		Scott Stanchfield	thetick@magelang.com
 *
 * Version 1.00 December 9, 1997 -- initial release
 * Version 1.01 December 10, 1997
 *		fixed bug in octal def (0..7 not 0..8)
 * Version 1.10 August 1998 (parrt)
 *		added tree construction
 *		fixed definition of WS_,comments for mac,pc,unix newlines
 *		added unary plus
 * Version 1.11 (Nov 20, 1998)
 *		Added "shutup" option to turn off last ambig warning.
 *		Fixed inner class def to allow named class defs as statements
 *		synchronized requires compound not simple statement
 *		add [] after builtInType DOT class in primaryExpression
 *		"const" is reserved but not valid..removed from modifiers
 *
 * This grammar is in the PUBLIC DOMAIN
 *
 * BUGS
 *		(expression) + "string" is parsed incorrectly (+ as unary plus).
 *
 */
class JavaRecognizer : public ANTLR_USE_NAMESPACE(antlr)LLkParser, public JavaTokenTypes
{
#line 1 "java.g"
#line 45 "JavaRecognizer.hpp"
public:
	void initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory );
protected:
	JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k);
public:
	JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf);
protected:
	JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k);
public:
	JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer);
	JavaRecognizer(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state);
	int getNumTokens() const
	{
		return JavaRecognizer::NUM_TOKENS;
	}
	const char* getTokenName( int type ) const
	{
		if( type > getNumTokens() ) return 0;
		return JavaRecognizer::tokenNames[type];
	}
	const char* const* getTokenNames() const
	{
		return JavaRecognizer::tokenNames;
	}
	public: void imaginaryTokenDefinitions();
	public: void compilationUnit();
	public: void packageDefinition();
	public: void importDefinition();
	public: void typeDefinition();
	public: void identifier();
	public: void identifierStar();
	public: void modifiers();
	public: void classDefinition(
		ANTLR_USE_NAMESPACE(antlr)RefAST modifiers
	);
	public: void interfaceDefinition(
		ANTLR_USE_NAMESPACE(antlr)RefAST modifiers
	);
	public: void declaration();
	public: void typeSpec(
		bool addImagNode
	);
	public: void variableDefinitions(
		ANTLR_USE_NAMESPACE(antlr)RefAST mods, ANTLR_USE_NAMESPACE(antlr)RefAST t
	);
	public: void modifier();
	public: void type();
	public: void builtInType();
	public: void superClassClause();
	public: void implementsClause();
	public: void classBlock();
	public: void interfaceExtends();
	public: void field();
	public: void ctorHead();
	public: void compoundStatement();
	public: void parameterDeclarationList();
	public: void returnTypeBrackersOnEndOfMethodHead(
		ANTLR_USE_NAMESPACE(antlr)RefAST typ
	);
	public: void throwsClause();
	public: void variableDeclarator(
		ANTLR_USE_NAMESPACE(antlr)RefAST mods, ANTLR_USE_NAMESPACE(antlr)RefAST t
	);
	public: void declaratorBrackets(
		ANTLR_USE_NAMESPACE(antlr)RefAST typ
	);
	public: void varInitializer();
	public: void initializer();
	public: void arrayInitializer();
	public: void expression();
	public: void parameterDeclaration();
	public: void parameterModifier();
	public: void parameterDeclaratorBrackets(
		ANTLR_USE_NAMESPACE(antlr)RefAST t
	);
	public: void statement();
	public: void forInit();
	public: void forCond();
	public: void forIter();
	public: void casesGroup();
	public: void tryBlock();
	public: void aCase();
	public: void caseSList();
	public: void expressionList();
	public: void handler();
	public: void assignmentExpression();
	public: void conditionalExpression();
	public: void logicalOrExpression();
	public: void logicalAndExpression();
	public: void inclusiveOrExpression();
	public: void exclusiveOrExpression();
	public: void andExpression();
	public: void equalityExpression();
	public: void relationalExpression();
	public: void shiftExpression();
	public: void additiveExpression();
	public: void multiplicativeExpression();
	public: void castExpression();
	public: void postfixExpression();
	public: void primaryExpression();
	public: void newExpression();
	public: void argList();
	public: void constant();
	public: void newArrayDeclarator();
private:
	static const char* tokenNames[];
#ifndef NO_STATIC_CONSTS
	static const int NUM_TOKENS = 139;
#else
	enum {
		NUM_TOKENS = 139
	};
#endif
	
	static const unsigned long _tokenSet_0_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_0;
	static const unsigned long _tokenSet_1_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_1;
	static const unsigned long _tokenSet_2_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_2;
	static const unsigned long _tokenSet_3_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_3;
	static const unsigned long _tokenSet_4_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_4;
	static const unsigned long _tokenSet_5_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_5;
	static const unsigned long _tokenSet_6_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_6;
	static const unsigned long _tokenSet_7_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_7;
	static const unsigned long _tokenSet_8_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_8;
	static const unsigned long _tokenSet_9_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_9;
	static const unsigned long _tokenSet_10_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_10;
	static const unsigned long _tokenSet_11_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_11;
	static const unsigned long _tokenSet_12_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_12;
	static const unsigned long _tokenSet_13_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_13;
	static const unsigned long _tokenSet_14_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_14;
	static const unsigned long _tokenSet_15_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_15;
	static const unsigned long _tokenSet_16_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_16;
	static const unsigned long _tokenSet_17_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_17;
	static const unsigned long _tokenSet_18_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_18;
	static const unsigned long _tokenSet_19_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_19;
	static const unsigned long _tokenSet_20_data_[];
	static const ANTLR_USE_NAMESPACE(antlr)BitSet _tokenSet_20;
};

#endif /*INC_JavaRecognizer_hpp_*/
