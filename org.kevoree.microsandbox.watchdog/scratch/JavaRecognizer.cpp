/* $ANTLR 2.7.2: "java.g" -> "JavaRecognizer.cpp"$ */
#include "JavaRecognizer.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "java.g"
#line 8 "JavaRecognizer.cpp"
JavaRecognizer::JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

JavaRecognizer::JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,2)
{
}

JavaRecognizer::JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

JavaRecognizer::JavaRecognizer(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,2)
{
}

JavaRecognizer::JavaRecognizer(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,2)
{
}

void JavaRecognizer::imaginaryTokenDefinitions() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST imaginaryTokenDefinitions_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp1_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp1_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp1_AST);
	}
	match(BLOCK);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp2_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp2_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp2_AST);
	}
	match(MODIFIERS);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp3_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp3_AST);
	}
	match(OBJBLOCK);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp4_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp4_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp4_AST);
	}
	match(SLIST);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp5_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp5_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp5_AST);
	}
	match(CTOR_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp6_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp6_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp6_AST);
	}
	match(METHOD_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp7_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp7_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp7_AST);
	}
	match(VARIABLE_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp8_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp8_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp8_AST);
	}
	match(INSTANCE_INIT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp9_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp9_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp9_AST);
	}
	match(STATIC_INIT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp10_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp10_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp10_AST);
	}
	match(TYPE);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp11_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp11_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp11_AST);
	}
	match(CLASS_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp12_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp12_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp12_AST);
	}
	match(INTERFACE_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp13_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp13_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp13_AST);
	}
	match(PACKAGE_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp14_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp14_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp14_AST);
	}
	match(ARRAY_DECLARATOR);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp15_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp15_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp15_AST);
	}
	match(EXTENDS_CLAUSE);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp16_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp16_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp16_AST);
	}
	match(IMPLEMENTS_CLAUSE);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp17_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp17_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp17_AST);
	}
	match(PARAMETERS);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp18_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp18_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp18_AST);
	}
	match(PARAMETER_DEF);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp19_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp19_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp19_AST);
	}
	match(LABELED_STAT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp20_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp20_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp20_AST);
	}
	match(TYPECAST);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp21_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp21_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp21_AST);
	}
	match(INDEX_OP);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp22_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp22_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp22_AST);
	}
	match(POST_INC);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp23_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp23_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp23_AST);
	}
	match(POST_DEC);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp24_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp24_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp24_AST);
	}
	match(METHOD_CALL);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp25_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp25_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp25_AST);
	}
	match(EXPR);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp26_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp26_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp26_AST);
	}
	match(ARRAY_INIT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp27_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp27_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp27_AST);
	}
	match(IMPORT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp28_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp28_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp28_AST);
	}
	match(UNARY_MINUS);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp29_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp29_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp29_AST);
	}
	match(UNARY_PLUS);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp30_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp30_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp30_AST);
	}
	match(CASE_GROUP);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp31_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp31_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp31_AST);
	}
	match(ELIST);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp32_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp32_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp32_AST);
	}
	match(FOR_INIT);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp33_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp33_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp33_AST);
	}
	match(FOR_CONDITION);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp34_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp34_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp34_AST);
	}
	match(FOR_ITERATOR);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp35_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp35_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp35_AST);
	}
	match(EMPTY_STAT);
	imaginaryTokenDefinitions_AST = currentAST.root;
	returnAST = imaginaryTokenDefinitions_AST;
}

void JavaRecognizer::compilationUnit() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST compilationUnit_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_package:
	{
		packageDefinition();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE:
	case SEMI:
	case TK_import:
	case TK_private:
	case TK_public:
	case TK_protected:
	case TK_static:
	case TK_transient:
	case TK_final:
	case TK_abstract:
	case TK_native:
	case TK_threadsafe:
	case TK_synchronized:
	case TK_volatile:
	case TK_class:
	case TK_interface:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == TK_import)) {
			importDefinition();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21116;
		}
		
	}
	_loop21116:;
	} // ( ... )*
	{ // ( ... )*
	for (;;) {
		if ((_tokenSet_0.member(LA(1)))) {
			typeDefinition();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21118;
		}
		
	}
	_loop21118:;
	} // ( ... )*
	match(ANTLR_USE_NAMESPACE(antlr)Token::EOF_TYPE);
	compilationUnit_AST = currentAST.root;
	returnAST = compilationUnit_AST;
}

void JavaRecognizer::packageDefinition() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST packageDefinition_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  p = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST p_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		p = LT(1);
		if ( inputState->guessing == 0 ) {
			p_AST = astFactory->create(p);
			astFactory->makeASTRoot(currentAST, p_AST);
		}
		match(TK_package);
		if ( inputState->guessing==0 ) {
#line 78 "java.g"
			p_AST->setType(PACKAGE_DEF);
#line 345 "JavaRecognizer.cpp"
		}
		identifier();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(SEMI);
		packageDefinition_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
	returnAST = packageDefinition_AST;
}

void JavaRecognizer::importDefinition() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST importDefinition_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  i = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST i_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		i = LT(1);
		if ( inputState->guessing == 0 ) {
			i_AST = astFactory->create(i);
			astFactory->makeASTRoot(currentAST, i_AST);
		}
		match(TK_import);
		if ( inputState->guessing==0 ) {
#line 85 "java.g"
			i_AST->setType(IMPORT);
#line 383 "JavaRecognizer.cpp"
		}
		identifierStar();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(SEMI);
		importDefinition_AST = currentAST.root;
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		} else {
			throw;
		}
	}
	returnAST = importDefinition_AST;
}

void JavaRecognizer::typeDefinition() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST typeDefinition_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST m_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_private:
		case TK_public:
		case TK_protected:
		case TK_static:
		case TK_transient:
		case TK_final:
		case TK_abstract:
		case TK_native:
		case TK_threadsafe:
		case TK_synchronized:
		case TK_volatile:
		case TK_class:
		case TK_interface:
		{
			modifiers();
			if (inputState->guessing==0) {
				m_AST = returnAST;
			}
			{
			switch ( LA(1)) {
			case TK_class:
			{
				classDefinition(m_AST);
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
				break;
			}
			case TK_interface:
			{
				interfaceDefinition(m_AST);
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			typeDefinition_AST = currentAST.root;
			break;
		}
		case SEMI:
		{
			match(SEMI);
			typeDefinition_AST = currentAST.root;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		if( inputState->guessing == 0 ) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_2);
		} else {
			throw;
		}
	}
	returnAST = typeDefinition_AST;
}

void JavaRecognizer::identifier() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST identifier_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp40_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp40_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp40_AST);
	}
	match(IDENT);
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == DOT)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp41_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp41_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp41_AST);
			}
			match(DOT);
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp42_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp42_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp42_AST);
			}
			match(IDENT);
		}
		else {
			goto _loop21134;
		}
		
	}
	_loop21134:;
	} // ( ... )*
	identifier_AST = currentAST.root;
	returnAST = identifier_AST;
}

void JavaRecognizer::identifierStar() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST identifierStar_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp43_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp43_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp43_AST);
	}
	match(IDENT);
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == DOT) && (LA(2) == IDENT)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp44_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp44_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp44_AST);
			}
			match(DOT);
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp45_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp45_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp45_AST);
			}
			match(IDENT);
		}
		else {
			goto _loop21137;
		}
		
	}
	_loop21137:;
	} // ( ... )*
	{
	switch ( LA(1)) {
	case DOT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp46_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp46_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp46_AST);
		}
		match(DOT);
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp47_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp47_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp47_AST);
		}
		match(STAR);
		break;
	}
	case SEMI:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	identifierStar_AST = currentAST.root;
	returnAST = identifierStar_AST;
}

void JavaRecognizer::modifiers() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST modifiers_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{ // ( ... )*
	for (;;) {
		if (((LA(1) >= TK_private && LA(1) <= TK_volatile))) {
			modifier();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21126;
		}
		
	}
	_loop21126:;
	} // ( ... )*
	if ( inputState->guessing==0 ) {
		modifiers_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 119 "java.g"
		modifiers_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(MODIFIERS,"MODIFIERS"))->add(modifiers_AST)));
#line 609 "JavaRecognizer.cpp"
		currentAST.root = modifiers_AST;
		if ( modifiers_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			modifiers_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = modifiers_AST->getFirstChild();
		else
			currentAST.child = modifiers_AST;
		currentAST.advanceChildToEnd();
	}
	modifiers_AST = currentAST.root;
	returnAST = modifiers_AST;
}

void JavaRecognizer::classDefinition(
	ANTLR_USE_NAMESPACE(antlr)RefAST modifiers
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST classDefinition_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST sc_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST ic_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST cb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	match(TK_class);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp49_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp49_AST = astFactory->create(LT(1));
	}
	match(IDENT);
	superClassClause();
	if (inputState->guessing==0) {
		sc_AST = returnAST;
	}
	implementsClause();
	if (inputState->guessing==0) {
		ic_AST = returnAST;
	}
	classBlock();
	if (inputState->guessing==0) {
		cb_AST = returnAST;
	}
	if ( inputState->guessing==0 ) {
		classDefinition_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 193 "java.g"
		classDefinition_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(6))->add(astFactory->create(CLASS_DEF,"CLASS_DEF"))->add(modifiers)->add(tmp49_AST)->add(sc_AST)->add(ic_AST)->add(cb_AST)));
#line 654 "JavaRecognizer.cpp"
		currentAST.root = classDefinition_AST;
		if ( classDefinition_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			classDefinition_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = classDefinition_AST->getFirstChild();
		else
			currentAST.child = classDefinition_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = classDefinition_AST;
}

void JavaRecognizer::interfaceDefinition(
	ANTLR_USE_NAMESPACE(antlr)RefAST modifiers
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST interfaceDefinition_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST ie_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST cb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	match(TK_interface);
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp51_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp51_AST = astFactory->create(LT(1));
	}
	match(IDENT);
	{
	switch ( LA(1)) {
	case TK_extends:
	{
		interfaceExtends();
		if (inputState->guessing==0) {
			ie_AST = returnAST;
		}
		break;
	}
	case LCURLY:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	classBlock();
	if (inputState->guessing==0) {
		cb_AST = returnAST;
	}
	if ( inputState->guessing==0 ) {
		interfaceDefinition_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 209 "java.g"
		interfaceDefinition_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(5))->add(astFactory->create(INTERFACE_DEF,"INTERFACE_DEF"))->add(modifiers)->add(tmp51_AST)->add(ie_AST)->add(cb_AST)));
#line 709 "JavaRecognizer.cpp"
		currentAST.root = interfaceDefinition_AST;
		if ( interfaceDefinition_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			interfaceDefinition_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = interfaceDefinition_AST->getFirstChild();
		else
			currentAST.child = interfaceDefinition_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = interfaceDefinition_AST;
}

/** A declaration is the creation of a reference or primitive-type variable
 *  Create a separate Type/Var tree for each var in the var list.
 */
void JavaRecognizer::declaration() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST declaration_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST m_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST t_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST v_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	modifiers();
	if (inputState->guessing==0) {
		m_AST = returnAST;
	}
	typeSpec(false);
	if (inputState->guessing==0) {
		t_AST = returnAST;
	}
	variableDefinitions(m_AST,t_AST);
	if (inputState->guessing==0) {
		v_AST = returnAST;
	}
	if ( inputState->guessing==0 ) {
		declaration_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 103 "java.g"
		declaration_AST = v_AST;
#line 748 "JavaRecognizer.cpp"
		currentAST.root = declaration_AST;
		if ( declaration_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			declaration_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = declaration_AST->getFirstChild();
		else
			currentAST.child = declaration_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = declaration_AST;
}

void JavaRecognizer::typeSpec(
	bool addImagNode
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST typeSpec_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	type();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LBRACK)) {
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 126 "java.g"
				lb_AST->setType(ARRAY_DECLARATOR);
#line 785 "JavaRecognizer.cpp"
			}
			match(RBRACK);
		}
		else {
			goto _loop21129;
		}
		
	}
	_loop21129:;
	} // ( ... )*
	if ( inputState->guessing==0 ) {
		typeSpec_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 127 "java.g"
		
					if ( addImagNode ) {
						typeSpec_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(TYPE,"TYPE"))->add(typeSpec_AST)));
					}
				
#line 804 "JavaRecognizer.cpp"
		currentAST.root = typeSpec_AST;
		if ( typeSpec_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			typeSpec_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = typeSpec_AST->getFirstChild();
		else
			currentAST.child = typeSpec_AST;
		currentAST.advanceChildToEnd();
	}
	typeSpec_AST = currentAST.root;
	returnAST = typeSpec_AST;
}

void JavaRecognizer::variableDefinitions(
	ANTLR_USE_NAMESPACE(antlr)RefAST mods, ANTLR_USE_NAMESPACE(antlr)RefAST t
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST variableDefinitions_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	variableDeclarator(getASTFactory()->dupTree(mods),
						   getASTFactory()->dupTree(t));
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == COMMA)) {
			match(COMMA);
			variableDeclarator(getASTFactory()->dupTree(mods),
							   getASTFactory()->dupTree(t));
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21162;
		}
		
	}
	_loop21162:;
	} // ( ... )*
	variableDefinitions_AST = currentAST.root;
	returnAST = variableDefinitions_AST;
}

void JavaRecognizer::modifier() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST modifier_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case TK_private:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp54_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp54_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp54_AST);
		}
		match(TK_private);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_public:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp55_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp55_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp55_AST);
		}
		match(TK_public);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_protected:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp56_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp56_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp56_AST);
		}
		match(TK_protected);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_static:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp57_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp57_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp57_AST);
		}
		match(TK_static);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_transient:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp58_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp58_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp58_AST);
		}
		match(TK_transient);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_final:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp59_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp59_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp59_AST);
		}
		match(TK_final);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_abstract:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp60_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp60_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp60_AST);
		}
		match(TK_abstract);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_native:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp61_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp61_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp61_AST);
		}
		match(TK_native);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_threadsafe:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp62_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp62_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp62_AST);
		}
		match(TK_threadsafe);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_synchronized:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp63_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp63_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp63_AST);
		}
		match(TK_synchronized);
		modifier_AST = currentAST.root;
		break;
	}
	case TK_volatile:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp64_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp64_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp64_AST);
		}
		match(TK_volatile);
		modifier_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = modifier_AST;
}

void JavaRecognizer::type() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST type_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case IDENT:
	{
		identifier();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		type_AST = currentAST.root;
		break;
	}
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	{
		builtInType();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		type_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = type_AST;
}

void JavaRecognizer::builtInType() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST builtInType_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case TK_void:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp65_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp65_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp65_AST);
		}
		match(TK_void);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_boolean:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp66_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp66_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp66_AST);
		}
		match(TK_boolean);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_byte:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp67_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp67_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp67_AST);
		}
		match(TK_byte);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_char:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp68_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp68_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp68_AST);
		}
		match(TK_char);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_short:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp69_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp69_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp69_AST);
		}
		match(TK_short);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_int:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp70_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp70_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp70_AST);
		}
		match(TK_int);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_float:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp71_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp71_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp71_AST);
		}
		match(TK_float);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_long:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp72_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp72_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp72_AST);
		}
		match(TK_long);
		builtInType_AST = currentAST.root;
		break;
	}
	case TK_double:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp73_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp73_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp73_AST);
		}
		match(TK_double);
		builtInType_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = builtInType_AST;
}

void JavaRecognizer::superClassClause() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST superClassClause_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_extends:
	{
		match(TK_extends);
		identifier();
		if (inputState->guessing==0) {
			id_AST = returnAST;
		}
		break;
	}
	case LCURLY:
	case TK_implements:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		superClassClause_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 199 "java.g"
		superClassClause_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(EXTENDS_CLAUSE,"EXTENDS_CLAUSE"))->add(id_AST)));
#line 1170 "JavaRecognizer.cpp"
		currentAST.root = superClassClause_AST;
		if ( superClassClause_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			superClassClause_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = superClassClause_AST->getFirstChild();
		else
			currentAST.child = superClassClause_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = superClassClause_AST;
}

void JavaRecognizer::implementsClause() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST implementsClause_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  i = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST i_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_implements:
	{
		i = LT(1);
		if ( inputState->guessing == 0 ) {
			i_AST = astFactory->create(i);
		}
		match(TK_implements);
		identifier();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				identifier();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else {
				goto _loop21154;
			}
			
		}
		_loop21154:;
		} // ( ... )*
		break;
	}
	case LCURLY:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		implementsClause_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 234 "java.g"
		implementsClause_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(IMPLEMENTS_CLAUSE,"IMPLEMENTS_CLAUSE"))->add(implementsClause_AST)));
#line 1234 "JavaRecognizer.cpp"
		currentAST.root = implementsClause_AST;
		if ( implementsClause_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			implementsClause_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = implementsClause_AST->getFirstChild();
		else
			currentAST.child = implementsClause_AST;
		currentAST.advanceChildToEnd();
	}
	implementsClause_AST = currentAST.root;
	returnAST = implementsClause_AST;
}

void JavaRecognizer::classBlock() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST classBlock_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	match(LCURLY);
	{ // ( ... )*
	for (;;) {
		switch ( LA(1)) {
		case TK_void:
		case TK_boolean:
		case TK_byte:
		case TK_char:
		case TK_short:
		case TK_int:
		case TK_float:
		case TK_long:
		case TK_double:
		case IDENT:
		case TK_private:
		case TK_public:
		case TK_protected:
		case TK_static:
		case TK_transient:
		case TK_final:
		case TK_abstract:
		case TK_native:
		case TK_threadsafe:
		case TK_synchronized:
		case TK_volatile:
		case TK_class:
		case TK_interface:
		case LCURLY:
		{
			field();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			break;
		}
		case SEMI:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp77_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp77_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp77_AST);
			}
			match(SEMI);
			break;
		}
		default:
		{
			goto _loop21147;
		}
		}
	}
	_loop21147:;
	} // ( ... )*
	match(RCURLY);
	if ( inputState->guessing==0 ) {
		classBlock_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 220 "java.g"
		classBlock_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(OBJBLOCK,"OBJBLOCK"))->add(classBlock_AST)));
#line 1310 "JavaRecognizer.cpp"
		currentAST.root = classBlock_AST;
		if ( classBlock_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			classBlock_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = classBlock_AST->getFirstChild();
		else
			currentAST.child = classBlock_AST;
		currentAST.advanceChildToEnd();
	}
	classBlock_AST = currentAST.root;
	returnAST = classBlock_AST;
}

void JavaRecognizer::interfaceExtends() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST interfaceExtends_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  e = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST e_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	e = LT(1);
	if ( inputState->guessing == 0 ) {
		e_AST = astFactory->create(e);
		astFactory->addASTChild(currentAST, e_AST);
	}
	match(TK_extends);
	if ( inputState->guessing==0 ) {
#line 225 "java.g"
		e_AST->setType(EXTENDS_CLAUSE);
#line 1339 "JavaRecognizer.cpp"
	}
	identifier();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == COMMA)) {
			match(COMMA);
			identifier();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21150;
		}
		
	}
	_loop21150:;
	} // ( ... )*
	interfaceExtends_AST = currentAST.root;
	returnAST = interfaceExtends_AST;
}

void JavaRecognizer::field() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST field_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST mods_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST h_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST s_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST cd_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST t_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST param_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST rt_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST tc_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST s2_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST v_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST s3_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
		modifiers();
		if (inputState->guessing==0) {
			mods_AST = returnAST;
		}
		{
		switch ( LA(1)) {
		case TK_class:
		{
			classDefinition(mods_AST);
			if (inputState->guessing==0) {
				cd_AST = returnAST;
			}
			if ( inputState->guessing==0 ) {
				field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 249 "java.g"
				field_AST = cd_AST;
#line 1399 "JavaRecognizer.cpp"
				currentAST.root = field_AST;
				if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
					field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
					  currentAST.child = field_AST->getFirstChild();
				else
					currentAST.child = field_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case TK_interface:
		{
			interfaceDefinition(mods_AST);
			if (inputState->guessing==0) {
				id_AST = returnAST;
			}
			if ( inputState->guessing==0 ) {
				field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 252 "java.g"
				field_AST = id_AST;
#line 1420 "JavaRecognizer.cpp"
				currentAST.root = field_AST;
				if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
					field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
					  currentAST.child = field_AST->getFirstChild();
				else
					currentAST.child = field_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		default:
			if ((LA(1) == IDENT) && (LA(2) == LPAREN)) {
				ctorHead();
				if (inputState->guessing==0) {
					h_AST = returnAST;
				}
				compoundStatement();
				if (inputState->guessing==0) {
					s_AST = returnAST;
				}
				if ( inputState->guessing==0 ) {
					field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 246 "java.g"
					field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(4))->add(astFactory->create(CTOR_DEF,"CTOR_DEF"))->add(mods_AST)->add(h_AST)->add(s_AST)));
#line 1445 "JavaRecognizer.cpp"
					currentAST.root = field_AST;
					if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
						field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
						  currentAST.child = field_AST->getFirstChild();
					else
						currentAST.child = field_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if (((LA(1) >= TK_void && LA(1) <= IDENT)) && (_tokenSet_5.member(LA(2)))) {
				typeSpec(false);
				if (inputState->guessing==0) {
					t_AST = returnAST;
				}
				{
				if ((LA(1) == IDENT) && (LA(2) == LPAREN)) {
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp80_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
					if ( inputState->guessing == 0 ) {
						tmp80_AST = astFactory->create(LT(1));
					}
					match(IDENT);
					match(LPAREN);
					parameterDeclarationList();
					if (inputState->guessing==0) {
						param_AST = returnAST;
					}
					match(RPAREN);
					returnTypeBrackersOnEndOfMethodHead(t_AST);
					if (inputState->guessing==0) {
						rt_AST = returnAST;
					}
					{
					switch ( LA(1)) {
					case TK_throws:
					{
						throwsClause();
						if (inputState->guessing==0) {
							tc_AST = returnAST;
						}
						break;
					}
					case SEMI:
					case LCURLY:
					{
						break;
					}
					default:
					{
						throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LCURLY:
					{
						compoundStatement();
						if (inputState->guessing==0) {
							s2_AST = returnAST;
						}
						break;
					}
					case SEMI:
					{
						ANTLR_USE_NAMESPACE(antlr)RefAST tmp83_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
						if ( inputState->guessing == 0 ) {
							tmp83_AST = astFactory->create(LT(1));
						}
						match(SEMI);
						break;
					}
					default:
					{
						throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState->guessing==0 ) {
						field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 266 "java.g"
						field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(7))->add(astFactory->create(METHOD_DEF,"METHOD_DEF"))->add(mods_AST)->add(ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(TYPE,"TYPE"))->add(rt_AST))))->add(tmp80_AST)->add(param_AST)->add(tc_AST)->add(s2_AST)));
#line 1527 "JavaRecognizer.cpp"
						currentAST.root = field_AST;
						if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
							field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
							  currentAST.child = field_AST->getFirstChild();
						else
							currentAST.child = field_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else if ((LA(1) == IDENT) && (_tokenSet_6.member(LA(2)))) {
					variableDefinitions(mods_AST,t_AST);
					if (inputState->guessing==0) {
						v_AST = returnAST;
					}
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp84_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
					if ( inputState->guessing == 0 ) {
						tmp84_AST = astFactory->create(LT(1));
					}
					match(SEMI);
					if ( inputState->guessing==0 ) {
						field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 275 "java.g"
						field_AST = v_AST;
#line 1551 "JavaRecognizer.cpp"
						currentAST.root = field_AST;
						if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
							field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
							  currentAST.child = field_AST->getFirstChild();
						else
							currentAST.child = field_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else {
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
				}
				
				}
			}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	else if ((LA(1) == TK_static) && (LA(2) == LCURLY)) {
		match(TK_static);
		compoundStatement();
		if (inputState->guessing==0) {
			s3_AST = returnAST;
		}
		if ( inputState->guessing==0 ) {
			field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 281 "java.g"
			field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(STATIC_INIT,"STATIC_INIT"))->add(s3_AST)));
#line 1583 "JavaRecognizer.cpp"
			currentAST.root = field_AST;
			if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
				field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
				  currentAST.child = field_AST->getFirstChild();
			else
				currentAST.child = field_AST;
			currentAST.advanceChildToEnd();
		}
	}
	else if ((LA(1) == LCURLY)) {
		compoundStatement();
		if ( inputState->guessing==0 ) {
			field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 285 "java.g"
			field_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(INSTANCE_INIT,"INSTANCE_INIT"))->add(s3_AST)));
#line 1599 "JavaRecognizer.cpp"
			currentAST.root = field_AST;
			if ( field_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
				field_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
				  currentAST.child = field_AST->getFirstChild();
			else
				currentAST.child = field_AST;
			currentAST.advanceChildToEnd();
		}
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	
	returnAST = field_AST;
}

void JavaRecognizer::ctorHead() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST ctorHead_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp86_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp86_AST = astFactory->create(LT(1));
		astFactory->addASTChild(currentAST, tmp86_AST);
	}
	match(IDENT);
	match(LPAREN);
	parameterDeclarationList();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	match(RPAREN);
	{
	switch ( LA(1)) {
	case TK_throws:
	{
		throwsClause();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case LCURLY:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	ctorHead_AST = currentAST.root;
	returnAST = ctorHead_AST;
}

void JavaRecognizer::compoundStatement() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST compoundStatement_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lc = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lc_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	lc = LT(1);
	if ( inputState->guessing == 0 ) {
		lc_AST = astFactory->create(lc);
		astFactory->makeASTRoot(currentAST, lc_AST);
	}
	match(LCURLY);
	if ( inputState->guessing==0 ) {
#line 402 "java.g"
		lc_AST->setType(SLIST);
#line 1673 "JavaRecognizer.cpp"
	}
	{ // ( ... )*
	for (;;) {
		if ((_tokenSet_7.member(LA(1)))) {
			statement();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21195;
		}
		
	}
	_loop21195:;
	} // ( ... )*
	match(RCURLY);
	compoundStatement_AST = currentAST.root;
	returnAST = compoundStatement_AST;
}

void JavaRecognizer::parameterDeclarationList() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST parameterDeclarationList_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case TK_final:
	{
		parameterDeclaration();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				parameterDeclaration();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else {
				goto _loop21186;
			}
			
		}
		_loop21186:;
		} // ( ... )*
		break;
	}
	case RPAREN:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		parameterDeclarationList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 370 "java.g"
		parameterDeclarationList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(PARAMETERS,"PARAMETERS"))->add(parameterDeclarationList_AST)));
#line 1750 "JavaRecognizer.cpp"
		currentAST.root = parameterDeclarationList_AST;
		if ( parameterDeclarationList_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			parameterDeclarationList_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = parameterDeclarationList_AST->getFirstChild();
		else
			currentAST.child = parameterDeclarationList_AST;
		currentAST.advanceChildToEnd();
	}
	parameterDeclarationList_AST = currentAST.root;
	returnAST = parameterDeclarationList_AST;
}

void JavaRecognizer::returnTypeBrackersOnEndOfMethodHead(
	ANTLR_USE_NAMESPACE(antlr)RefAST typ
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST returnTypeBrackersOnEndOfMethodHead_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	if ( inputState->guessing==0 ) {
		returnTypeBrackersOnEndOfMethodHead_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 363 "java.g"
		returnTypeBrackersOnEndOfMethodHead_AST = typ;
#line 1776 "JavaRecognizer.cpp"
		currentAST.root = returnTypeBrackersOnEndOfMethodHead_AST;
		if ( returnTypeBrackersOnEndOfMethodHead_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			returnTypeBrackersOnEndOfMethodHead_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = returnTypeBrackersOnEndOfMethodHead_AST->getFirstChild();
		else
			currentAST.child = returnTypeBrackersOnEndOfMethodHead_AST;
		currentAST.advanceChildToEnd();
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LBRACK)) {
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 364 "java.g"
				lb_AST->setType(ARRAY_DECLARATOR);
#line 1797 "JavaRecognizer.cpp"
			}
			match(RBRACK);
		}
		else {
			goto _loop21182;
		}
		
	}
	_loop21182:;
	} // ( ... )*
	returnTypeBrackersOnEndOfMethodHead_AST = currentAST.root;
	returnAST = returnTypeBrackersOnEndOfMethodHead_AST;
}

void JavaRecognizer::throwsClause() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST throwsClause_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp92_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp92_AST = astFactory->create(LT(1));
		astFactory->makeASTRoot(currentAST, tmp92_AST);
	}
	match(TK_throws);
	identifier();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == COMMA)) {
			match(COMMA);
			identifier();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21179;
		}
		
	}
	_loop21179:;
	} // ( ... )*
	throwsClause_AST = currentAST.root;
	returnAST = throwsClause_AST;
}

/** Declaration of a variable.  This can be a class/instance variable,
 *   or a local variable in a method
 * It can also include possible initialization.
 */
void JavaRecognizer::variableDeclarator(
	ANTLR_USE_NAMESPACE(antlr)RefAST mods, ANTLR_USE_NAMESPACE(antlr)RefAST t
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST variableDeclarator_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  id = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST d_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST v_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	id = LT(1);
	if ( inputState->guessing == 0 ) {
		id_AST = astFactory->create(id);
	}
	match(IDENT);
	declaratorBrackets(t);
	if (inputState->guessing==0) {
		d_AST = returnAST;
	}
	varInitializer();
	if (inputState->guessing==0) {
		v_AST = returnAST;
	}
	if ( inputState->guessing==0 ) {
		variableDeclarator_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 303 "java.g"
		variableDeclarator_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(5))->add(astFactory->create(VARIABLE_DEF,"VARIABLE_DEF"))->add(mods)->add(ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(TYPE,"TYPE"))->add(d_AST))))->add(id_AST)->add(v_AST)));
#line 1879 "JavaRecognizer.cpp"
		currentAST.root = variableDeclarator_AST;
		if ( variableDeclarator_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			variableDeclarator_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = variableDeclarator_AST->getFirstChild();
		else
			currentAST.child = variableDeclarator_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = variableDeclarator_AST;
}

void JavaRecognizer::declaratorBrackets(
	ANTLR_USE_NAMESPACE(antlr)RefAST typ
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST declaratorBrackets_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	if ( inputState->guessing==0 ) {
		declaratorBrackets_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 307 "java.g"
		declaratorBrackets_AST=typ;
#line 1904 "JavaRecognizer.cpp"
		currentAST.root = declaratorBrackets_AST;
		if ( declaratorBrackets_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			declaratorBrackets_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = declaratorBrackets_AST->getFirstChild();
		else
			currentAST.child = declaratorBrackets_AST;
		currentAST.advanceChildToEnd();
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LBRACK)) {
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 308 "java.g"
				lb_AST->setType(ARRAY_DECLARATOR);
#line 1925 "JavaRecognizer.cpp"
			}
			match(RBRACK);
		}
		else {
			goto _loop21166;
		}
		
	}
	_loop21166:;
	} // ( ... )*
	declaratorBrackets_AST = currentAST.root;
	returnAST = declaratorBrackets_AST;
}

void JavaRecognizer::varInitializer() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST varInitializer_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case ASSIGN:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp95_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp95_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp95_AST);
		}
		match(ASSIGN);
		initializer();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case SEMI:
	case COMMA:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	varInitializer_AST = currentAST.root;
	returnAST = varInitializer_AST;
}

void JavaRecognizer::initializer() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST initializer_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case LPAREN:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		initializer_AST = currentAST.root;
		break;
	}
	case LCURLY:
	{
		arrayInitializer();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		initializer_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = initializer_AST;
}

void JavaRecognizer::arrayInitializer() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST arrayInitializer_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lc = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lc_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	lc = LT(1);
	if ( inputState->guessing == 0 ) {
		lc_AST = astFactory->create(lc);
		astFactory->makeASTRoot(currentAST, lc_AST);
	}
	match(LCURLY);
	if ( inputState->guessing==0 ) {
#line 317 "java.g"
		lc_AST->setType(ARRAY_INIT);
#line 2050 "JavaRecognizer.cpp"
	}
	{
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case LCURLY:
	case LPAREN:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		initializer();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA) && (_tokenSet_8.member(LA(2)))) {
				match(COMMA);
				initializer();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else {
				goto _loop21172;
			}
			
		}
		_loop21172:;
		} // ( ... )*
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			break;
		}
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		break;
	}
	case RCURLY:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	match(RCURLY);
	arrayInitializer_AST = currentAST.root;
	returnAST = arrayInitializer_AST;
}

void JavaRecognizer::expression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	assignmentExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	if ( inputState->guessing==0 ) {
		expression_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 585 "java.g"
		expression_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(EXPR,"EXPR"))->add(expression_AST)));
#line 2150 "JavaRecognizer.cpp"
		currentAST.root = expression_AST;
		if ( expression_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			expression_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = expression_AST->getFirstChild();
		else
			currentAST.child = expression_AST;
		currentAST.advanceChildToEnd();
	}
	expression_AST = currentAST.root;
	returnAST = expression_AST;
}

void JavaRecognizer::parameterDeclaration() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST parameterDeclaration_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST pm_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST t_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  id = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST id_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST pd_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	parameterModifier();
	if (inputState->guessing==0) {
		pm_AST = returnAST;
	}
	typeSpec(false);
	if (inputState->guessing==0) {
		t_AST = returnAST;
	}
	id = LT(1);
	if ( inputState->guessing == 0 ) {
		id_AST = astFactory->create(id);
	}
	match(IDENT);
	parameterDeclaratorBrackets(t_AST);
	if (inputState->guessing==0) {
		pd_AST = returnAST;
	}
	if ( inputState->guessing==0 ) {
		parameterDeclaration_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 378 "java.g"
		parameterDeclaration_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(4))->add(astFactory->create(PARAMETER_DEF,"PARAMETER_DEF"))->add(pm_AST)->add(ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(TYPE,"TYPE"))->add(pd_AST))))->add(id_AST)));
#line 2194 "JavaRecognizer.cpp"
		currentAST.root = parameterDeclaration_AST;
		if ( parameterDeclaration_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			parameterDeclaration_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = parameterDeclaration_AST->getFirstChild();
		else
			currentAST.child = parameterDeclaration_AST;
		currentAST.advanceChildToEnd();
	}
	returnAST = parameterDeclaration_AST;
}

void JavaRecognizer::parameterModifier() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST parameterModifier_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  f = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST f_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_final:
	{
		f = LT(1);
		if ( inputState->guessing == 0 ) {
			f_AST = astFactory->create(f);
			astFactory->addASTChild(currentAST, f_AST);
		}
		match(TK_final);
		break;
	}
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		parameterModifier_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 389 "java.g"
		parameterModifier_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(MODIFIERS,"MODIFIERS"))->add(f_AST)));
#line 2248 "JavaRecognizer.cpp"
		currentAST.root = parameterModifier_AST;
		if ( parameterModifier_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			parameterModifier_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = parameterModifier_AST->getFirstChild();
		else
			currentAST.child = parameterModifier_AST;
		currentAST.advanceChildToEnd();
	}
	parameterModifier_AST = currentAST.root;
	returnAST = parameterModifier_AST;
}

void JavaRecognizer::parameterDeclaratorBrackets(
	ANTLR_USE_NAMESPACE(antlr)RefAST t
) {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST parameterDeclaratorBrackets_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	if ( inputState->guessing==0 ) {
		parameterDeclaratorBrackets_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 383 "java.g"
		parameterDeclaratorBrackets_AST = t;
#line 2274 "JavaRecognizer.cpp"
		currentAST.root = parameterDeclaratorBrackets_AST;
		if ( parameterDeclaratorBrackets_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			parameterDeclaratorBrackets_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = parameterDeclaratorBrackets_AST->getFirstChild();
		else
			currentAST.child = parameterDeclaratorBrackets_AST;
		currentAST.advanceChildToEnd();
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LBRACK)) {
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 384 "java.g"
				lb_AST->setType(ARRAY_DECLARATOR);
#line 2295 "JavaRecognizer.cpp"
			}
			match(RBRACK);
		}
		else {
			goto _loop21190;
		}
		
	}
	_loop21190:;
	} // ( ... )*
	parameterDeclaratorBrackets_AST = currentAST.root;
	returnAST = parameterDeclaratorBrackets_AST;
}

void JavaRecognizer::statement() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST statement_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  c = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST c_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  s = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST s_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case LCURLY:
	{
		compoundStatement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_class:
	{
		classDefinition(astFactory->create(MODIFIERS,"MODIFIERS"));
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_interface:
	{
		interfaceDefinition(astFactory->create(MODIFIERS,"MODIFIERS"));
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_if:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp100_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp100_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp100_AST);
		}
		match(TK_if);
		match(LPAREN);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		statement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{
		if ((LA(1) == TK_else) && (_tokenSet_7.member(LA(2)))) {
			match(TK_else);
			statement();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else if ((_tokenSet_9.member(LA(1))) && (_tokenSet_10.member(LA(2)))) {
		}
		else {
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_for:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp104_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp104_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp104_AST);
		}
		match(TK_for);
		match(LPAREN);
		forInit();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(SEMI);
		forCond();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(SEMI);
		forIter();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		statement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_while:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp109_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp109_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp109_AST);
		}
		match(TK_while);
		match(LPAREN);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		statement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_do:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp112_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp112_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp112_AST);
		}
		match(TK_do);
		statement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(TK_while);
		match(LPAREN);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		match(SEMI);
		statement_AST = currentAST.root;
		break;
	}
	case TK_break:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp117_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp117_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp117_AST);
		}
		match(TK_break);
		{
		switch ( LA(1)) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp118_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp118_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp118_AST);
			}
			match(IDENT);
			break;
		}
		case SEMI:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(SEMI);
		statement_AST = currentAST.root;
		break;
	}
	case TK_continue:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp120_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp120_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp120_AST);
		}
		match(TK_continue);
		{
		switch ( LA(1)) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp121_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp121_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp121_AST);
			}
			match(IDENT);
			break;
		}
		case SEMI:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(SEMI);
		statement_AST = currentAST.root;
		break;
	}
	case TK_return:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp123_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp123_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp123_AST);
		}
		match(TK_return);
		{
		switch ( LA(1)) {
		case TK_void:
		case TK_boolean:
		case TK_byte:
		case TK_char:
		case TK_short:
		case TK_int:
		case TK_float:
		case TK_long:
		case TK_double:
		case IDENT:
		case LPAREN:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case TK_this:
		case TK_super:
		case TK_true:
		case TK_false:
		case TK_null:
		case TK_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		{
			expression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			break;
		}
		case SEMI:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(SEMI);
		statement_AST = currentAST.root;
		break;
	}
	case TK_switch:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp125_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp125_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp125_AST);
		}
		match(TK_switch);
		match(LPAREN);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		match(LCURLY);
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == TK_case || LA(1) == TK_default)) {
				casesGroup();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
			}
			else {
				goto _loop21204;
			}
			
		}
		_loop21204:;
		} // ( ... )*
		match(RCURLY);
		statement_AST = currentAST.root;
		break;
	}
	case TK_try:
	{
		tryBlock();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		statement_AST = currentAST.root;
		break;
	}
	case TK_throw:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp130_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp130_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp130_AST);
		}
		match(TK_throw);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(SEMI);
		statement_AST = currentAST.root;
		break;
	}
	case SEMI:
	{
		s = LT(1);
		if ( inputState->guessing == 0 ) {
			s_AST = astFactory->create(s);
			astFactory->addASTChild(currentAST, s_AST);
		}
		match(SEMI);
		if ( inputState->guessing==0 ) {
#line 486 "java.g"
			s_AST->setType(EMPTY_STAT);
#line 2654 "JavaRecognizer.cpp"
		}
		statement_AST = currentAST.root;
		break;
	}
	default:
		bool synPredMatched21198 = false;
		if (((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2))))) {
			int _m21198 = mark();
			synPredMatched21198 = true;
			inputState->guessing++;
			try {
				{
				declaration();
				}
			}
			catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& pe) {
				synPredMatched21198 = false;
			}
			rewind(_m21198);
			inputState->guessing--;
		}
		if ( synPredMatched21198 ) {
			declaration();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(SEMI);
			statement_AST = currentAST.root;
		}
		else if ((_tokenSet_13.member(LA(1))) && (_tokenSet_14.member(LA(2)))) {
			expression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(SEMI);
			statement_AST = currentAST.root;
		}
		else if ((LA(1) == IDENT) && (LA(2) == COLON)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp134_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp134_AST = astFactory->create(LT(1));
				astFactory->addASTChild(currentAST, tmp134_AST);
			}
			match(IDENT);
			c = LT(1);
			if ( inputState->guessing == 0 ) {
				c_AST = astFactory->create(c);
				astFactory->makeASTRoot(currentAST, c_AST);
			}
			match(COLON);
			if ( inputState->guessing==0 ) {
#line 432 "java.g"
				c_AST->setType(LABELED_STAT);
#line 2708 "JavaRecognizer.cpp"
			}
			statement();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			statement_AST = currentAST.root;
		}
		else if ((LA(1) == TK_synchronized) && (LA(2) == LPAREN)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp135_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp135_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp135_AST);
			}
			match(TK_synchronized);
			match(LPAREN);
			expression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(RPAREN);
			compoundStatement();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			statement_AST = currentAST.root;
		}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = statement_AST;
}

void JavaRecognizer::forInit() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST forInit_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	bool synPredMatched21216 = false;
	if (((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2))))) {
		int _m21216 = mark();
		synPredMatched21216 = true;
		inputState->guessing++;
		try {
			{
			declaration();
			}
		}
		catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& pe) {
			synPredMatched21216 = false;
		}
		rewind(_m21216);
		inputState->guessing--;
	}
	if ( synPredMatched21216 ) {
		declaration();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
	}
	else if ((_tokenSet_13.member(LA(1))) && (_tokenSet_15.member(LA(2)))) {
		expressionList();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
	}
	else if ((LA(1) == SEMI)) {
	}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	
	}
	if ( inputState->guessing==0 ) {
		forInit_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 521 "java.g"
		forInit_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(FOR_INIT,"FOR_INIT"))->add(forInit_AST)));
#line 2787 "JavaRecognizer.cpp"
		currentAST.root = forInit_AST;
		if ( forInit_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			forInit_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = forInit_AST->getFirstChild();
		else
			currentAST.child = forInit_AST;
		currentAST.advanceChildToEnd();
	}
	forInit_AST = currentAST.root;
	returnAST = forInit_AST;
}

void JavaRecognizer::forCond() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST forCond_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case LPAREN:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case SEMI:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		forCond_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 526 "java.g"
		forCond_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(FOR_CONDITION,"FOR_CONDITION"))->add(forCond_AST)));
#line 2855 "JavaRecognizer.cpp"
		currentAST.root = forCond_AST;
		if ( forCond_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			forCond_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = forCond_AST->getFirstChild();
		else
			currentAST.child = forCond_AST;
		currentAST.advanceChildToEnd();
	}
	forCond_AST = currentAST.root;
	returnAST = forCond_AST;
}

void JavaRecognizer::forIter() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST forIter_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case LPAREN:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		expressionList();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case RPAREN:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	if ( inputState->guessing==0 ) {
		forIter_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 531 "java.g"
		forIter_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(FOR_ITERATOR,"FOR_ITERATOR"))->add(forIter_AST)));
#line 2923 "JavaRecognizer.cpp"
		currentAST.root = forIter_AST;
		if ( forIter_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			forIter_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = forIter_AST->getFirstChild();
		else
			currentAST.child = forIter_AST;
		currentAST.advanceChildToEnd();
	}
	forIter_AST = currentAST.root;
	returnAST = forIter_AST;
}

void JavaRecognizer::casesGroup() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST casesGroup_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{ // ( ... )+
	int _cnt21207=0;
	for (;;) {
		if ((LA(1) == TK_case || LA(1) == TK_default) && (_tokenSet_16.member(LA(2)))) {
			aCase();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			if ( _cnt21207>=1 ) { goto _loop21207; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
		}
		
		_cnt21207++;
	}
	_loop21207:;
	}  // ( ... )+
	caseSList();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	if ( inputState->guessing==0 ) {
		casesGroup_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 502 "java.g"
		casesGroup_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(CASE_GROUP,"CASE_GROUP"))->add(casesGroup_AST)));
#line 2966 "JavaRecognizer.cpp"
		currentAST.root = casesGroup_AST;
		if ( casesGroup_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			casesGroup_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = casesGroup_AST->getFirstChild();
		else
			currentAST.child = casesGroup_AST;
		currentAST.advanceChildToEnd();
	}
	casesGroup_AST = currentAST.root;
	returnAST = casesGroup_AST;
}

void JavaRecognizer::tryBlock() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST tryBlock_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp138_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp138_AST = astFactory->create(LT(1));
		astFactory->makeASTRoot(currentAST, tmp138_AST);
	}
	match(TK_try);
	compoundStatement();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == TK_catch)) {
			handler();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21223;
		}
		
	}
	_loop21223:;
	} // ( ... )*
	{
	switch ( LA(1)) {
	case TK_finally:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp139_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp139_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp139_AST);
		}
		match(TK_finally);
		compoundStatement();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case SEMI:
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case TK_private:
	case TK_public:
	case TK_protected:
	case TK_static:
	case TK_transient:
	case TK_final:
	case TK_abstract:
	case TK_native:
	case TK_threadsafe:
	case TK_synchronized:
	case TK_volatile:
	case TK_class:
	case TK_interface:
	case LCURLY:
	case RCURLY:
	case LPAREN:
	case TK_if:
	case TK_else:
	case TK_for:
	case TK_while:
	case TK_do:
	case TK_break:
	case TK_continue:
	case TK_return:
	case TK_switch:
	case TK_throw:
	case TK_case:
	case TK_default:
	case TK_try:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	tryBlock_AST = currentAST.root;
	returnAST = tryBlock_AST;
}

void JavaRecognizer::aCase() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST aCase_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_case:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp140_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp140_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp140_AST);
		}
		match(TK_case);
		expression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case TK_default:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp141_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp141_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp141_AST);
		}
		match(TK_default);
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	match(COLON);
	aCase_AST = currentAST.root;
	returnAST = aCase_AST;
}

void JavaRecognizer::caseSList() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST caseSList_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{ // ( ... )*
	for (;;) {
		if ((_tokenSet_7.member(LA(1)))) {
			statement();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21212;
		}
		
	}
	_loop21212:;
	} // ( ... )*
	if ( inputState->guessing==0 ) {
		caseSList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 511 "java.g"
		caseSList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(SLIST,"SLIST"))->add(caseSList_AST)));
#line 3160 "JavaRecognizer.cpp"
		currentAST.root = caseSList_AST;
		if ( caseSList_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			caseSList_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = caseSList_AST->getFirstChild();
		else
			currentAST.child = caseSList_AST;
		currentAST.advanceChildToEnd();
	}
	caseSList_AST = currentAST.root;
	returnAST = caseSList_AST;
}

void JavaRecognizer::expressionList() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST expressionList_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	expression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == COMMA)) {
			match(COMMA);
			expression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21229;
		}
		
	}
	_loop21229:;
	} // ( ... )*
	if ( inputState->guessing==0 ) {
		expressionList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 592 "java.g"
		expressionList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(astFactory->make((new ANTLR_USE_NAMESPACE(antlr)ASTArray(2))->add(astFactory->create(ELIST,"ELIST"))->add(expressionList_AST)));
#line 3202 "JavaRecognizer.cpp"
		currentAST.root = expressionList_AST;
		if ( expressionList_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
			expressionList_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
			  currentAST.child = expressionList_AST->getFirstChild();
		else
			currentAST.child = expressionList_AST;
		currentAST.advanceChildToEnd();
	}
	expressionList_AST = currentAST.root;
	returnAST = expressionList_AST;
}

void JavaRecognizer::handler() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST handler_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp144_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp144_AST = astFactory->create(LT(1));
		astFactory->makeASTRoot(currentAST, tmp144_AST);
	}
	match(TK_catch);
	match(LPAREN);
	parameterDeclaration();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	match(RPAREN);
	compoundStatement();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	handler_AST = currentAST.root;
	returnAST = handler_AST;
}

void JavaRecognizer::assignmentExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST assignmentExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	conditionalExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{
	switch ( LA(1)) {
	case ASSIGN:
	case PLUS_ASSIGN:
	case MINUS_ASSIGN:
	case STAR_ASSIGN:
	case DIV_ASSIGN:
	case MOD_ASSIGN:
	case SR_ASSIGN:
	case BSR_ASSIGN:
	case SL_ASSIGN:
	case BAND_ASSIGN:
	case BXOR_ASSIGN:
	case BOR_ASSIGN:
	{
		{
		switch ( LA(1)) {
		case ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp147_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp147_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp147_AST);
			}
			match(ASSIGN);
			break;
		}
		case PLUS_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp148_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp148_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp148_AST);
			}
			match(PLUS_ASSIGN);
			break;
		}
		case MINUS_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp149_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp149_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp149_AST);
			}
			match(MINUS_ASSIGN);
			break;
		}
		case STAR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp150_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp150_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp150_AST);
			}
			match(STAR_ASSIGN);
			break;
		}
		case DIV_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp151_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp151_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp151_AST);
			}
			match(DIV_ASSIGN);
			break;
		}
		case MOD_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp152_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp152_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp152_AST);
			}
			match(MOD_ASSIGN);
			break;
		}
		case SR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp153_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp153_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp153_AST);
			}
			match(SR_ASSIGN);
			break;
		}
		case BSR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp154_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp154_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp154_AST);
			}
			match(BSR_ASSIGN);
			break;
		}
		case SL_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp155_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp155_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp155_AST);
			}
			match(SL_ASSIGN);
			break;
		}
		case BAND_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp156_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp156_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp156_AST);
			}
			match(BAND_ASSIGN);
			break;
		}
		case BXOR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp157_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp157_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp157_AST);
			}
			match(BXOR_ASSIGN);
			break;
		}
		case BOR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp158_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp158_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp158_AST);
			}
			match(BOR_ASSIGN);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		assignmentExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case SEMI:
	case RBRACK:
	case RCURLY:
	case COMMA:
	case RPAREN:
	case COLON:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	assignmentExpression_AST = currentAST.root;
	returnAST = assignmentExpression_AST;
}

void JavaRecognizer::conditionalExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST conditionalExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	logicalOrExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{
	switch ( LA(1)) {
	case QUESTION:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp159_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp159_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp159_AST);
		}
		match(QUESTION);
		conditionalExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(COLON);
		conditionalExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case SEMI:
	case RBRACK:
	case RCURLY:
	case COMMA:
	case RPAREN:
	case ASSIGN:
	case COLON:
	case PLUS_ASSIGN:
	case MINUS_ASSIGN:
	case STAR_ASSIGN:
	case DIV_ASSIGN:
	case MOD_ASSIGN:
	case SR_ASSIGN:
	case BSR_ASSIGN:
	case SL_ASSIGN:
	case BAND_ASSIGN:
	case BXOR_ASSIGN:
	case BOR_ASSIGN:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	conditionalExpression_AST = currentAST.root;
	returnAST = conditionalExpression_AST;
}

void JavaRecognizer::logicalOrExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST logicalOrExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	logicalAndExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LOR)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp161_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp161_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp161_AST);
			}
			match(LOR);
			logicalAndExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21237;
		}
		
	}
	_loop21237:;
	} // ( ... )*
	logicalOrExpression_AST = currentAST.root;
	returnAST = logicalOrExpression_AST;
}

void JavaRecognizer::logicalAndExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST logicalAndExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	inclusiveOrExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == LAND)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp162_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp162_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp162_AST);
			}
			match(LAND);
			inclusiveOrExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21240;
		}
		
	}
	_loop21240:;
	} // ( ... )*
	logicalAndExpression_AST = currentAST.root;
	returnAST = logicalAndExpression_AST;
}

void JavaRecognizer::inclusiveOrExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST inclusiveOrExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	exclusiveOrExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == BOR)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp163_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp163_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp163_AST);
			}
			match(BOR);
			exclusiveOrExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21243;
		}
		
	}
	_loop21243:;
	} // ( ... )*
	inclusiveOrExpression_AST = currentAST.root;
	returnAST = inclusiveOrExpression_AST;
}

void JavaRecognizer::exclusiveOrExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST exclusiveOrExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	andExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == BXOR)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp164_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp164_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp164_AST);
			}
			match(BXOR);
			andExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21246;
		}
		
	}
	_loop21246:;
	} // ( ... )*
	exclusiveOrExpression_AST = currentAST.root;
	returnAST = exclusiveOrExpression_AST;
}

void JavaRecognizer::andExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST andExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	equalityExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == BAND)) {
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp165_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp165_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp165_AST);
			}
			match(BAND);
			equalityExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21249;
		}
		
	}
	_loop21249:;
	} // ( ... )*
	andExpression_AST = currentAST.root;
	returnAST = andExpression_AST;
}

void JavaRecognizer::equalityExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST equalityExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	relationalExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == NOT_EQUAL || LA(1) == EQUAL)) {
			{
			switch ( LA(1)) {
			case NOT_EQUAL:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp166_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp166_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp166_AST);
				}
				match(NOT_EQUAL);
				break;
			}
			case EQUAL:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp167_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp167_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp167_AST);
				}
				match(EQUAL);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			relationalExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21253;
		}
		
	}
	_loop21253:;
	} // ( ... )*
	equalityExpression_AST = currentAST.root;
	returnAST = equalityExpression_AST;
}

void JavaRecognizer::relationalExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST relationalExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	shiftExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if (((LA(1) >= LT_ && LA(1) <= GE))) {
			{
			switch ( LA(1)) {
			case LT_:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp168_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp168_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp168_AST);
				}
				match(LT_);
				break;
			}
			case GT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp169_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp169_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp169_AST);
				}
				match(GT);
				break;
			}
			case LE:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp170_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp170_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp170_AST);
				}
				match(LE);
				break;
			}
			case GE:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp171_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp171_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp171_AST);
				}
				match(GE);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			shiftExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21257;
		}
		
	}
	_loop21257:;
	} // ( ... )*
	relationalExpression_AST = currentAST.root;
	returnAST = relationalExpression_AST;
}

void JavaRecognizer::shiftExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST shiftExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	additiveExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if (((LA(1) >= SL && LA(1) <= BSR))) {
			{
			switch ( LA(1)) {
			case SL:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp172_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp172_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp172_AST);
				}
				match(SL);
				break;
			}
			case SR:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp173_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp173_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp173_AST);
				}
				match(SR);
				break;
			}
			case BSR:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp174_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp174_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp174_AST);
				}
				match(BSR);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			additiveExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21261;
		}
		
	}
	_loop21261:;
	} // ( ... )*
	shiftExpression_AST = currentAST.root;
	returnAST = shiftExpression_AST;
}

void JavaRecognizer::additiveExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST additiveExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	multiplicativeExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((LA(1) == PLUS || LA(1) == MINUS)) {
			{
			switch ( LA(1)) {
			case PLUS:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp175_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp175_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp175_AST);
				}
				match(PLUS);
				break;
			}
			case MINUS:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp176_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp176_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp176_AST);
				}
				match(MINUS);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			multiplicativeExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21265;
		}
		
	}
	_loop21265:;
	} // ( ... )*
	additiveExpression_AST = currentAST.root;
	returnAST = additiveExpression_AST;
}

void JavaRecognizer::multiplicativeExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST multiplicativeExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	castExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		if ((_tokenSet_17.member(LA(1)))) {
			{
			switch ( LA(1)) {
			case STAR:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp177_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp177_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp177_AST);
				}
				match(STAR);
				break;
			}
			case DIV:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp178_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp178_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp178_AST);
				}
				match(DIV);
				break;
			}
			case MOD:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp179_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp179_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp179_AST);
				}
				match(MOD);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			castExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
		}
		else {
			goto _loop21269;
		}
		
	}
	_loop21269:;
	} // ( ... )*
	multiplicativeExpression_AST = currentAST.root;
	returnAST = multiplicativeExpression_AST;
}

void JavaRecognizer::castExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST castExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lp = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lp_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST c_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case INC:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp180_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp180_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp180_AST);
		}
		match(INC);
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	case DEC:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp181_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp181_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp181_AST);
		}
		match(DEC);
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	case MINUS:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp182_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp182_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp182_AST);
		}
		match(MINUS);
		if ( inputState->guessing==0 ) {
#line 700 "java.g"
			tmp182_AST->setType(UNARY_MINUS);
#line 4018 "JavaRecognizer.cpp"
		}
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	case PLUS:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp183_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp183_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp183_AST);
		}
		match(PLUS);
		if ( inputState->guessing==0 ) {
#line 701 "java.g"
			tmp183_AST->setType(UNARY_PLUS);
#line 4038 "JavaRecognizer.cpp"
		}
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	case BNOT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp184_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp184_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp184_AST);
		}
		match(BNOT);
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	case LNOT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp185_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp185_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp185_AST);
		}
		match(LNOT);
		castExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		castExpression_AST = currentAST.root;
		break;
	}
	default:
		bool synPredMatched21272 = false;
		if (((LA(1) == LPAREN) && ((LA(2) >= TK_void && LA(2) <= IDENT)))) {
			int _m21272 = mark();
			synPredMatched21272 = true;
			inputState->guessing++;
			try {
				{
				match(LPAREN);
				typeSpec(true);
				match(RPAREN);
				castExpression();
				}
			}
			catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& pe) {
				synPredMatched21272 = false;
			}
			rewind(_m21272);
			inputState->guessing--;
		}
		if ( synPredMatched21272 ) {
			lp = LT(1);
			if ( inputState->guessing == 0 ) {
				lp_AST = astFactory->create(lp);
				astFactory->makeASTRoot(currentAST, lp_AST);
			}
			match(LPAREN);
			if ( inputState->guessing==0 ) {
#line 694 "java.g"
				lp_AST->setType(TYPECAST);
#line 4107 "JavaRecognizer.cpp"
			}
			typeSpec(true);
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(RPAREN);
			castExpression();
			if (inputState->guessing==0) {
				c_AST = returnAST;
				astFactory->addASTChild( currentAST, returnAST );
			}
			castExpression_AST = currentAST.root;
		}
		else if ((_tokenSet_18.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
			postfixExpression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			{
			switch ( LA(1)) {
			case TK_instanceof:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp187_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp187_AST = astFactory->create(LT(1));
					astFactory->makeASTRoot(currentAST, tmp187_AST);
				}
				match(TK_instanceof);
				typeSpec(true);
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
				break;
			}
			case SEMI:
			case RBRACK:
			case STAR:
			case RCURLY:
			case COMMA:
			case RPAREN:
			case ASSIGN:
			case COLON:
			case PLUS_ASSIGN:
			case MINUS_ASSIGN:
			case STAR_ASSIGN:
			case DIV_ASSIGN:
			case MOD_ASSIGN:
			case SR_ASSIGN:
			case BSR_ASSIGN:
			case SL_ASSIGN:
			case BAND_ASSIGN:
			case BXOR_ASSIGN:
			case BOR_ASSIGN:
			case QUESTION:
			case LOR:
			case LAND:
			case BOR:
			case BXOR:
			case BAND:
			case NOT_EQUAL:
			case EQUAL:
			case LT_:
			case GT:
			case LE:
			case GE:
			case SL:
			case SR:
			case BSR:
			case PLUS:
			case MINUS:
			case DIV:
			case MOD:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			castExpression_AST = currentAST.root;
		}
	else {
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = castExpression_AST;
}

void JavaRecognizer::postfixExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST postfixExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lp = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lp_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  in = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST in_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  de = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST de_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	primaryExpression();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{ // ( ... )*
	for (;;) {
		switch ( LA(1)) {
		case DOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp188_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
			if ( inputState->guessing == 0 ) {
				tmp188_AST = astFactory->create(LT(1));
				astFactory->makeASTRoot(currentAST, tmp188_AST);
			}
			match(DOT);
			{
			switch ( LA(1)) {
			case IDENT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp189_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp189_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp189_AST);
				}
				match(IDENT);
				break;
			}
			case TK_this:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp190_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp190_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp190_AST);
				}
				match(TK_this);
				break;
			}
			case TK_class:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp191_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp191_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp191_AST);
				}
				match(TK_class);
				break;
			}
			case TK_new:
			{
				newExpression();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
				break;
			}
			case TK_super:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp192_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp192_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp192_AST);
				}
				match(TK_super);
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp193_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp193_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp193_AST);
				}
				match(LPAREN);
				{
				switch ( LA(1)) {
				case TK_void:
				case TK_boolean:
				case TK_byte:
				case TK_char:
				case TK_short:
				case TK_int:
				case TK_float:
				case TK_long:
				case TK_double:
				case IDENT:
				case LPAREN:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case TK_this:
				case TK_super:
				case TK_true:
				case TK_false:
				case TK_null:
				case TK_new:
				case NUM_INT:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case NUM_FLOAT:
				{
					expressionList();
					if (inputState->guessing==0) {
						astFactory->addASTChild( currentAST, returnAST );
					}
					break;
				}
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
				}
				}
				}
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp194_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
				if ( inputState->guessing == 0 ) {
					tmp194_AST = astFactory->create(LT(1));
					astFactory->addASTChild(currentAST, tmp194_AST);
				}
				match(RPAREN);
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case LBRACK:
		{
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 725 "java.g"
				lb_AST->setType(INDEX_OP);
#line 4353 "JavaRecognizer.cpp"
			}
			expression();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(RBRACK);
			break;
		}
		case LPAREN:
		{
			lp = LT(1);
			if ( inputState->guessing == 0 ) {
				lp_AST = astFactory->create(lp);
				astFactory->makeASTRoot(currentAST, lp_AST);
			}
			match(LPAREN);
			if ( inputState->guessing==0 ) {
#line 732 "java.g"
				lp_AST->setType(METHOD_CALL);
#line 4373 "JavaRecognizer.cpp"
			}
			argList();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			match(RPAREN);
			break;
		}
		default:
		{
			goto _loop21278;
		}
		}
	}
	_loop21278:;
	} // ( ... )*
	{
	switch ( LA(1)) {
	case INC:
	{
		in = LT(1);
		if ( inputState->guessing == 0 ) {
			in_AST = astFactory->create(in);
			astFactory->makeASTRoot(currentAST, in_AST);
		}
		match(INC);
		if ( inputState->guessing==0 ) {
#line 738 "java.g"
			in_AST->setType(POST_INC);
#line 4403 "JavaRecognizer.cpp"
		}
		break;
	}
	case DEC:
	{
		de = LT(1);
		if ( inputState->guessing == 0 ) {
			de_AST = astFactory->create(de);
			astFactory->makeASTRoot(currentAST, de_AST);
		}
		match(DEC);
		if ( inputState->guessing==0 ) {
#line 739 "java.g"
			de_AST->setType(POST_DEC);
#line 4418 "JavaRecognizer.cpp"
		}
		break;
	}
	case SEMI:
	case RBRACK:
	case STAR:
	case RCURLY:
	case COMMA:
	case RPAREN:
	case ASSIGN:
	case COLON:
	case PLUS_ASSIGN:
	case MINUS_ASSIGN:
	case STAR_ASSIGN:
	case DIV_ASSIGN:
	case MOD_ASSIGN:
	case SR_ASSIGN:
	case BSR_ASSIGN:
	case SL_ASSIGN:
	case BAND_ASSIGN:
	case BXOR_ASSIGN:
	case BOR_ASSIGN:
	case QUESTION:
	case LOR:
	case LAND:
	case BOR:
	case BXOR:
	case BAND:
	case NOT_EQUAL:
	case EQUAL:
	case LT_:
	case GT:
	case LE:
	case GE:
	case SL:
	case SR:
	case BSR:
	case PLUS:
	case MINUS:
	case DIV:
	case MOD:
	case TK_instanceof:
	{
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	postfixExpression_AST = currentAST.root;
	returnAST = postfixExpression_AST;
}

void JavaRecognizer::primaryExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST primaryExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case IDENT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp197_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp197_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp197_AST);
		}
		match(IDENT);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	{
		builtInType();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == LBRACK)) {
				lb = LT(1);
				if ( inputState->guessing == 0 ) {
					lb_AST = astFactory->create(lb);
					astFactory->makeASTRoot(currentAST, lb_AST);
				}
				match(LBRACK);
				if ( inputState->guessing==0 ) {
#line 748 "java.g"
					lb_AST->setType(ARRAY_DECLARATOR);
#line 4519 "JavaRecognizer.cpp"
				}
				match(RBRACK);
			}
			else {
				goto _loop21282;
			}
			
		}
		_loop21282:;
		} // ( ... )*
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp199_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp199_AST = astFactory->create(LT(1));
			astFactory->makeASTRoot(currentAST, tmp199_AST);
		}
		match(DOT);
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp200_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp200_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp200_AST);
		}
		match(TK_class);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_new:
	{
		newExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		primaryExpression_AST = currentAST.root;
		break;
	}
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		constant();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_super:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp201_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp201_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp201_AST);
		}
		match(TK_super);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_true:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp202_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp202_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp202_AST);
		}
		match(TK_true);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_false:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp203_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp203_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp203_AST);
		}
		match(TK_false);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_this:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp204_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp204_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp204_AST);
		}
		match(TK_this);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case TK_null:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp205_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp205_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp205_AST);
		}
		match(TK_null);
		primaryExpression_AST = currentAST.root;
		break;
	}
	case LPAREN:
	{
		match(LPAREN);
		assignmentExpression();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		primaryExpression_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = primaryExpression_AST;
}

/** object instantiation.
 *  Trees are built as illustrated by the following input/tree pairs:
 *  
 *  new T()
 *  
 *  new
 *   |
 *   T --  ELIST
 *           |
 *          arg1 -- arg2 -- .. -- argn
 *  
 *  new int[]
 *
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *  
 *  new int[] {1,2}
 *
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR -- ARRAY_INIT
 *                                  |
 *                                EXPR -- EXPR
 *                                  |      |
 *                                  1      2
 *  
 *  new int[3]
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *                |
 *              EXPR
 *                |
 *                3
 *  
 *  new int[1][2]
 *  
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *               |
 *         ARRAY_DECLARATOR -- EXPR
 *               |              |
 *             EXPR             1
 *               |
 *               2
 *  
 */
void JavaRecognizer::newExpression() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST newExpression_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	ANTLR_USE_NAMESPACE(antlr)RefAST tmp208_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	if ( inputState->guessing == 0 ) {
		tmp208_AST = astFactory->create(LT(1));
		astFactory->makeASTRoot(currentAST, tmp208_AST);
	}
	match(TK_new);
	type();
	if (inputState->guessing==0) {
		astFactory->addASTChild( currentAST, returnAST );
	}
	{
	switch ( LA(1)) {
	case LPAREN:
	{
		match(LPAREN);
		argList();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		match(RPAREN);
		{
		switch ( LA(1)) {
		case LCURLY:
		{
			classBlock();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			break;
		}
		case SEMI:
		case LBRACK:
		case RBRACK:
		case DOT:
		case STAR:
		case RCURLY:
		case COMMA:
		case LPAREN:
		case RPAREN:
		case ASSIGN:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		case QUESTION:
		case LOR:
		case LAND:
		case BOR:
		case BXOR:
		case BAND:
		case NOT_EQUAL:
		case EQUAL:
		case LT_:
		case GT:
		case LE:
		case GE:
		case SL:
		case SR:
		case BSR:
		case PLUS:
		case MINUS:
		case DIV:
		case MOD:
		case INC:
		case DEC:
		case TK_instanceof:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		break;
	}
	case LBRACK:
	{
		newArrayDeclarator();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		{
		switch ( LA(1)) {
		case LCURLY:
		{
			arrayInitializer();
			if (inputState->guessing==0) {
				astFactory->addASTChild( currentAST, returnAST );
			}
			break;
		}
		case SEMI:
		case LBRACK:
		case RBRACK:
		case DOT:
		case STAR:
		case RCURLY:
		case COMMA:
		case LPAREN:
		case RPAREN:
		case ASSIGN:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		case QUESTION:
		case LOR:
		case LAND:
		case BOR:
		case BXOR:
		case BAND:
		case NOT_EQUAL:
		case EQUAL:
		case LT_:
		case GT:
		case LE:
		case GE:
		case SL:
		case SR:
		case BSR:
		case PLUS:
		case MINUS:
		case DIV:
		case MOD:
		case INC:
		case DEC:
		case TK_instanceof:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	newExpression_AST = currentAST.root;
	returnAST = newExpression_AST;
}

void JavaRecognizer::argList() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST argList_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{
	switch ( LA(1)) {
	case TK_void:
	case TK_boolean:
	case TK_byte:
	case TK_char:
	case TK_short:
	case TK_int:
	case TK_float:
	case TK_long:
	case TK_double:
	case IDENT:
	case LPAREN:
	case PLUS:
	case MINUS:
	case INC:
	case DEC:
	case BNOT:
	case LNOT:
	case TK_this:
	case TK_super:
	case TK_true:
	case TK_false:
	case TK_null:
	case TK_new:
	case NUM_INT:
	case CHAR_LITERAL:
	case STRING_LITERAL:
	case NUM_FLOAT:
	{
		expressionList();
		if (inputState->guessing==0) {
			astFactory->addASTChild( currentAST, returnAST );
		}
		break;
	}
	case RPAREN:
	{
		if ( inputState->guessing==0 ) {
			argList_AST = ANTLR_USE_NAMESPACE(antlr)RefAST(currentAST.root);
#line 829 "java.g"
			argList_AST = astFactory->create(ELIST,"ELIST");
#line 4907 "JavaRecognizer.cpp"
			currentAST.root = argList_AST;
			if ( argList_AST!=ANTLR_USE_NAMESPACE(antlr)nullAST &&
				argList_AST->getFirstChild() != ANTLR_USE_NAMESPACE(antlr)nullAST )
				  currentAST.child = argList_AST->getFirstChild();
			else
				currentAST.child = argList_AST;
			currentAST.advanceChildToEnd();
		}
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	}
	argList_AST = currentAST.root;
	returnAST = argList_AST;
}

void JavaRecognizer::constant() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST constant_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	switch ( LA(1)) {
	case NUM_INT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp211_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp211_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp211_AST);
		}
		match(NUM_INT);
		constant_AST = currentAST.root;
		break;
	}
	case CHAR_LITERAL:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp212_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp212_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp212_AST);
		}
		match(CHAR_LITERAL);
		constant_AST = currentAST.root;
		break;
	}
	case STRING_LITERAL:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp213_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp213_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp213_AST);
		}
		match(STRING_LITERAL);
		constant_AST = currentAST.root;
		break;
	}
	case NUM_FLOAT:
	{
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp214_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
		if ( inputState->guessing == 0 ) {
			tmp214_AST = astFactory->create(LT(1));
			astFactory->addASTChild(currentAST, tmp214_AST);
		}
		match(NUM_FLOAT);
		constant_AST = currentAST.root;
		break;
	}
	default:
	{
		throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
	}
	}
	returnAST = constant_AST;
}

void JavaRecognizer::newArrayDeclarator() {
	returnAST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)ASTPair currentAST;
	ANTLR_USE_NAMESPACE(antlr)RefAST newArrayDeclarator_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	ANTLR_USE_NAMESPACE(antlr)RefToken  lb = ANTLR_USE_NAMESPACE(antlr)nullToken;
	ANTLR_USE_NAMESPACE(antlr)RefAST lb_AST = ANTLR_USE_NAMESPACE(antlr)nullAST;
	
	{ // ( ... )+
	int _cnt21292=0;
	for (;;) {
		if ((LA(1) == LBRACK) && (_tokenSet_20.member(LA(2)))) {
			lb = LT(1);
			if ( inputState->guessing == 0 ) {
				lb_AST = astFactory->create(lb);
				astFactory->makeASTRoot(currentAST, lb_AST);
			}
			match(LBRACK);
			if ( inputState->guessing==0 ) {
#line 844 "java.g"
				lb_AST->setType(ARRAY_DECLARATOR);
#line 5006 "JavaRecognizer.cpp"
			}
			{
			switch ( LA(1)) {
			case TK_void:
			case TK_boolean:
			case TK_byte:
			case TK_char:
			case TK_short:
			case TK_int:
			case TK_float:
			case TK_long:
			case TK_double:
			case IDENT:
			case LPAREN:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case TK_this:
			case TK_super:
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			{
				expression();
				if (inputState->guessing==0) {
					astFactory->addASTChild( currentAST, returnAST );
				}
				break;
			}
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RBRACK);
		}
		else {
			if ( _cnt21292>=1 ) { goto _loop21292; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
		}
		
		_cnt21292++;
	}
	_loop21292:;
	}  // ( ... )+
	newArrayDeclarator_AST = currentAST.root;
	returnAST = newArrayDeclarator_AST;
}

void JavaRecognizer::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
	factory.setMaxNodeType(138);
}
const char* JavaRecognizer::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"BLOCK",
	"MODIFIERS",
	"OBJBLOCK",
	"SLIST",
	"CTOR_DEF",
	"METHOD_DEF",
	"VARIABLE_DEF",
	"INSTANCE_INIT",
	"STATIC_INIT",
	"TYPE",
	"CLASS_DEF",
	"INTERFACE_DEF",
	"PACKAGE_DEF",
	"ARRAY_DECLARATOR",
	"EXTENDS_CLAUSE",
	"IMPLEMENTS_CLAUSE",
	"PARAMETERS",
	"PARAMETER_DEF",
	"LABELED_STAT",
	"TYPECAST",
	"INDEX_OP",
	"POST_INC",
	"POST_DEC",
	"METHOD_CALL",
	"EXPR",
	"ARRAY_INIT",
	"IMPORT",
	"UNARY_MINUS",
	"UNARY_PLUS",
	"CASE_GROUP",
	"ELIST",
	"FOR_INIT",
	"FOR_CONDITION",
	"FOR_ITERATOR",
	"EMPTY_STAT",
	"\"package\"",
	"SEMI",
	"\"import\"",
	"LBRACK",
	"RBRACK",
	"\"void\"",
	"\"boolean\"",
	"\"byte\"",
	"\"char\"",
	"\"short\"",
	"\"int\"",
	"\"float\"",
	"\"long\"",
	"\"double\"",
	"IDENT",
	"DOT",
	"STAR",
	"\"private\"",
	"\"public\"",
	"\"protected\"",
	"\"static\"",
	"\"transient\"",
	"\"final\"",
	"\"abstract\"",
	"\"native\"",
	"\"threadsafe\"",
	"\"synchronized\"",
	"\"volatile\"",
	"\"class\"",
	"\"extends\"",
	"\"interface\"",
	"LCURLY",
	"RCURLY",
	"COMMA",
	"\"implements\"",
	"LPAREN",
	"RPAREN",
	"ASSIGN",
	"\"throws\"",
	"COLON",
	"\"if\"",
	"\"else\"",
	"\"for\"",
	"\"while\"",
	"\"do\"",
	"\"break\"",
	"\"continue\"",
	"\"return\"",
	"\"switch\"",
	"\"throw\"",
	"\"case\"",
	"\"default\"",
	"\"try\"",
	"\"finally\"",
	"\"catch\"",
	"PLUS_ASSIGN",
	"MINUS_ASSIGN",
	"STAR_ASSIGN",
	"DIV_ASSIGN",
	"MOD_ASSIGN",
	"SR_ASSIGN",
	"BSR_ASSIGN",
	"SL_ASSIGN",
	"BAND_ASSIGN",
	"BXOR_ASSIGN",
	"BOR_ASSIGN",
	"QUESTION",
	"LOR",
	"LAND",
	"BOR",
	"BXOR",
	"BAND",
	"NOT_EQUAL",
	"EQUAL",
	"LT_",
	"GT",
	"LE",
	"GE",
	"SL",
	"SR",
	"BSR",
	"PLUS",
	"MINUS",
	"DIV",
	"MOD",
	"INC",
	"DEC",
	"BNOT",
	"LNOT",
	"\"instanceof\"",
	"\"this\"",
	"\"super\"",
	"\"true\"",
	"\"false\"",
	"\"null\"",
	"\"new\"",
	"NUM_INT",
	"CHAR_LITERAL",
	"STRING_LITERAL",
	"NUM_FLOAT",
	0
};

const unsigned long JavaRecognizer::_tokenSet_0_data_[] = { 0UL, 4278190336UL, 47UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI "private" "public" "protected" "static" "transient" "final" "abstract" 
// "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_0(_tokenSet_0_data_,8);
const unsigned long JavaRecognizer::_tokenSet_1_data_[] = { 2UL, 4278190848UL, 47UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// EOF SEMI "import" "private" "public" "protected" "static" "transient" 
// "final" "abstract" "native" "threadsafe" "synchronized" "volatile" "class" 
// "interface" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_1(_tokenSet_1_data_,8);
const unsigned long JavaRecognizer::_tokenSet_2_data_[] = { 2UL, 4278190336UL, 47UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// EOF SEMI "private" "public" "protected" "static" "transient" "final" 
// "abstract" "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_2(_tokenSet_2_data_,8);
const unsigned long JavaRecognizer::_tokenSet_3_data_[] = { 0UL, 4282380288UL, 47UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT "private" "public" "protected" "static" "transient" "final" "abstract" 
// "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_3(_tokenSet_3_data_,8);
const unsigned long JavaRecognizer::_tokenSet_4_data_[] = { 0UL, 4286575616UL, 1071UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// LBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT DOT "private" "public" "protected" "static" "transient" "final" 
// "abstract" "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
// LPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_4(_tokenSet_4_data_,8);
const unsigned long JavaRecognizer::_tokenSet_5_data_[] = { 0UL, 6292480UL, 0UL, 0UL, 0UL, 0UL };
// LBRACK IDENT DOT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_5(_tokenSet_5_data_,6);
const unsigned long JavaRecognizer::_tokenSet_6_data_[] = { 0UL, 1280UL, 4352UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LBRACK COMMA ASSIGN 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_6(_tokenSet_6_data_,8);
const unsigned long JavaRecognizer::_tokenSet_7_data_[] = { 0UL, 4282380544UL, 167674991UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT "private" "public" "protected" "static" "transient" "final" "abstract" 
// "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
// LCURLY LPAREN "if" "for" "while" "do" "break" "continue" "return" "switch" 
// "throw" "try" PLUS MINUS INC DEC BNOT LNOT "this" "super" "true" "false" 
// "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_7(_tokenSet_7_data_,12);
const unsigned long JavaRecognizer::_tokenSet_8_data_[] = { 0UL, 4190208UL, 1088UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT LCURLY LPAREN PLUS MINUS INC DEC BNOT LNOT "this" "super" "true" 
// "false" "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_8(_tokenSet_8_data_,12);
const unsigned long JavaRecognizer::_tokenSet_9_data_[] = { 0UL, 4282380544UL, 268403951UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT "private" "public" "protected" "static" "transient" "final" "abstract" 
// "native" "threadsafe" "synchronized" "volatile" "class" "interface" 
// LCURLY RCURLY LPAREN "if" "else" "for" "while" "do" "break" "continue" 
// "return" "switch" "throw" "case" "default" "try" PLUS MINUS INC DEC 
// BNOT LNOT "this" "super" "true" "false" "null" "new" NUM_INT CHAR_LITERAL 
// STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_9(_tokenSet_9_data_,12);
const unsigned long JavaRecognizer::_tokenSet_10_data_[] = { 0UL, 4294964480UL, 4294956271UL, 4294967295UL, 2047UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" 
// "double" IDENT DOT STAR "private" "public" "protected" "static" "transient" 
// "final" "abstract" "native" "threadsafe" "synchronized" "volatile" "class" 
// "interface" LCURLY RCURLY LPAREN ASSIGN COLON "if" "else" "for" "while" 
// "do" "break" "continue" "return" "switch" "throw" "case" "default" "try" 
// "finally" "catch" PLUS_ASSIGN MINUS_ASSIGN STAR_ASSIGN DIV_ASSIGN MOD_ASSIGN 
// SR_ASSIGN BSR_ASSIGN SL_ASSIGN BAND_ASSIGN BXOR_ASSIGN BOR_ASSIGN QUESTION 
// LOR LAND BOR BXOR BAND NOT_EQUAL EQUAL LT_ GT LE GE SL SR BSR PLUS MINUS 
// DIV MOD INC DEC BNOT LNOT "instanceof" "this" "super" "true" "false" 
// "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_10(_tokenSet_10_data_,12);
const unsigned long JavaRecognizer::_tokenSet_11_data_[] = { 0UL, 4282380288UL, 7UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT "private" "public" "protected" "static" "transient" "final" "abstract" 
// "native" "threadsafe" "synchronized" "volatile" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_11(_tokenSet_11_data_,8);
const unsigned long JavaRecognizer::_tokenSet_12_data_[] = { 0UL, 4286575616UL, 7UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// LBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT DOT "private" "public" "protected" "static" "transient" "final" 
// "abstract" "native" "threadsafe" "synchronized" "volatile" 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_12(_tokenSet_12_data_,8);
const unsigned long JavaRecognizer::_tokenSet_13_data_[] = { 0UL, 4190208UL, 1024UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT LPAREN PLUS MINUS INC DEC BNOT LNOT "this" "super" "true" "false" 
// "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_13(_tokenSet_13_data_,12);
const unsigned long JavaRecognizer::_tokenSet_14_data_[] = { 0UL, 16774400UL, 3221230592UL, 4294967295UL, 2047UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" 
// "double" IDENT DOT STAR LPAREN ASSIGN PLUS_ASSIGN MINUS_ASSIGN STAR_ASSIGN 
// DIV_ASSIGN MOD_ASSIGN SR_ASSIGN BSR_ASSIGN SL_ASSIGN BAND_ASSIGN BXOR_ASSIGN 
// BOR_ASSIGN QUESTION LOR LAND BOR BXOR BAND NOT_EQUAL EQUAL LT_ GT LE 
// GE SL SR BSR PLUS MINUS DIV MOD INC DEC BNOT LNOT "instanceof" "this" 
// "super" "true" "false" "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL 
// NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_14(_tokenSet_14_data_,12);
const unsigned long JavaRecognizer::_tokenSet_15_data_[] = { 0UL, 16774400UL, 3221230848UL, 4294967295UL, 2047UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" 
// "double" IDENT DOT STAR COMMA LPAREN ASSIGN PLUS_ASSIGN MINUS_ASSIGN 
// STAR_ASSIGN DIV_ASSIGN MOD_ASSIGN SR_ASSIGN BSR_ASSIGN SL_ASSIGN BAND_ASSIGN 
// BXOR_ASSIGN BOR_ASSIGN QUESTION LOR LAND BOR BXOR BAND NOT_EQUAL EQUAL 
// LT_ GT LE GE SL SR BSR PLUS MINUS DIV MOD INC DEC BNOT LNOT "instanceof" 
// "this" "super" "true" "false" "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL 
// NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_15(_tokenSet_15_data_,12);
const unsigned long JavaRecognizer::_tokenSet_16_data_[] = { 0UL, 4190208UL, 17408UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT LPAREN COLON PLUS MINUS INC DEC BNOT LNOT "this" "super" "true" 
// "false" "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_16(_tokenSet_16_data_,12);
const unsigned long JavaRecognizer::_tokenSet_17_data_[] = { 0UL, 8388608UL, 0UL, 201326592UL, 0UL, 0UL, 0UL, 0UL };
// STAR DIV MOD 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_17(_tokenSet_17_data_,8);
const unsigned long JavaRecognizer::_tokenSet_18_data_[] = { 0UL, 4190208UL, 1024UL, 0UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT LPAREN "this" "super" "true" "false" "null" "new" NUM_INT CHAR_LITERAL 
// STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_18(_tokenSet_18_data_,12);
const unsigned long JavaRecognizer::_tokenSet_19_data_[] = { 0UL, 16776448UL, 3221249408UL, 4294967295UL, 2047UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LBRACK RBRACK "void" "boolean" "byte" "char" "short" "int" "float" 
// "long" "double" IDENT DOT STAR RCURLY COMMA LPAREN RPAREN ASSIGN COLON 
// PLUS_ASSIGN MINUS_ASSIGN STAR_ASSIGN DIV_ASSIGN MOD_ASSIGN SR_ASSIGN 
// BSR_ASSIGN SL_ASSIGN BAND_ASSIGN BXOR_ASSIGN BOR_ASSIGN QUESTION LOR 
// LAND BOR BXOR BAND NOT_EQUAL EQUAL LT_ GT LE GE SL SR BSR PLUS MINUS 
// DIV MOD INC DEC BNOT LNOT "instanceof" "this" "super" "true" "false" 
// "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_19(_tokenSet_19_data_,12);
const unsigned long JavaRecognizer::_tokenSet_20_data_[] = { 0UL, 4192256UL, 1024UL, 4076863488UL, 2046UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// RBRACK "void" "boolean" "byte" "char" "short" "int" "float" "long" "double" 
// IDENT LPAREN PLUS MINUS INC DEC BNOT LNOT "this" "super" "true" "false" 
// "null" "new" NUM_INT CHAR_LITERAL STRING_LITERAL NUM_FLOAT 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaRecognizer::_tokenSet_20(_tokenSet_20_data_,12);


