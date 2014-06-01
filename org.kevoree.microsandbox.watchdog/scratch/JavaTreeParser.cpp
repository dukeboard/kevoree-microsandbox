/* $ANTLR 2.7.2: "java.tree.g" -> "JavaTreeParser.cpp"$ */
#include "JavaTreeParser.hpp"
#include <antlr/Token.hpp>
#include <antlr/AST.hpp>
#include <antlr/NoViableAltException.hpp>
#include <antlr/MismatchedTokenException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/BitSet.hpp>
#line 1 "java.tree.g"
#line 11 "JavaTreeParser.cpp"
JavaTreeParser::JavaTreeParser()
	: ANTLR_USE_NAMESPACE(antlr)TreeParser() {
}

void JavaTreeParser::compilationUnit(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST compilationUnit_AST_in = _t;
	
	try {      // for error handling
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case PACKAGE_DEF:
		{
			packageDefinition(_t);
			_t = _retTree;
			break;
		}
		case 3:
		case IMPORT:
		case CLASS_DEF:
		case INTERFACE_DEF:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == IMPORT)) {
				importDefinition(_t);
				_t = _retTree;
			}
			else {
				goto _loop21311;
			}
			
		}
		_loop21311:;
		} // ( ... )*
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == CLASS_DEF || _t->getType() == INTERFACE_DEF)) {
				typeDefinition(_t);
				_t = _retTree;
			}
			else {
				goto _loop21313;
			}
			
		}
		_loop21313:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::packageDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST packageDefinition_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21315 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp1_AST_in = _t;
		match(_t,PACKAGE_DEF);
		_t = _t->getFirstChild();
		identifier(_t);
		_t = _retTree;
		_t = __t21315;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::importDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST importDefinition_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21317 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp2_AST_in = _t;
		match(_t,IMPORT);
		_t = _t->getFirstChild();
		identifierStar(_t);
		_t = _retTree;
		_t = __t21317;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::typeDefinition(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST typeDefinition_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case CLASS_DEF:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21319 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp3_AST_in = _t;
			match(_t,CLASS_DEF);
			_t = _t->getFirstChild();
			modifiers(_t);
			_t = _retTree;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp4_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			extendsClause(_t);
			_t = _retTree;
			implementsClause(_t);
			_t = _retTree;
			objBlock(_t);
			_t = _retTree;
			_t = __t21319;
			_t = _t->getNextSibling();
			break;
		}
		case INTERFACE_DEF:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21320 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp5_AST_in = _t;
			match(_t,INTERFACE_DEF);
			_t = _t->getFirstChild();
			modifiers(_t);
			_t = _retTree;
			_t = __t21320;
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::identifier(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST identifier_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp6_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			break;
		}
		case DOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21375 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp7_AST_in = _t;
			match(_t,DOT);
			_t = _t->getFirstChild();
			identifier(_t);
			_t = _retTree;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp8_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			_t = __t21375;
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::identifierStar(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST identifierStar_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp9_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			break;
		}
		case DOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21377 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp10_AST_in = _t;
			match(_t,DOT);
			_t = _t->getFirstChild();
			identifier(_t);
			_t = _retTree;
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case STAR:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp11_AST_in = _t;
				match(_t,STAR);
				_t = _t->getNextSibling();
				break;
			}
			case IDENT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp12_AST_in = _t;
				match(_t,IDENT);
				_t = _t->getNextSibling();
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21377;
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::modifiers(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST modifiers_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21328 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp13_AST_in = _t;
		match(_t,MODIFIERS);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if (((_t->getType() >= LITERAL_private && _t->getType() <= LITERAL_volatile))) {
				modifier(_t);
				_t = _retTree;
			}
			else {
				goto _loop21330;
			}
			
		}
		_loop21330:;
		} // ( ... )*
		_t = __t21328;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::extendsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST extendsClause_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21333 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp14_AST_in = _t;
		match(_t,EXTENDS_CLAUSE);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == IDENT || _t->getType() == DOT)) {
				identifier(_t);
				_t = _retTree;
			}
			else {
				goto _loop21335;
			}
			
		}
		_loop21335:;
		} // ( ... )*
		_t = __t21333;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::implementsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST implementsClause_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21337 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp15_AST_in = _t;
		match(_t,IMPLEMENTS_CLAUSE);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == IDENT || _t->getType() == DOT)) {
				identifier(_t);
				_t = _retTree;
			}
			else {
				goto _loop21339;
			}
			
		}
		_loop21339:;
		} // ( ... )*
		_t = __t21337;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::objBlock(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST objBlock_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21341 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp16_AST_in = _t;
		match(_t,OBJBLOCK);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case CTOR_DEF:
			{
				ctorDef(_t);
				_t = _retTree;
				break;
			}
			case METHOD_DEF:
			{
				methodDef(_t);
				_t = _retTree;
				break;
			}
			case VARIABLE_DEF:
			{
				variableDef(_t);
				_t = _retTree;
				break;
			}
			case CLASS_DEF:
			case INTERFACE_DEF:
			{
				typeDefinition(_t);
				_t = _retTree;
				break;
			}
			case STATIC_INIT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST __t21343 = _t;
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp17_AST_in = _t;
				match(_t,STATIC_INIT);
				_t = _t->getFirstChild();
				slist(_t);
				_t = _retTree;
				_t = __t21343;
				_t = _t->getNextSibling();
				break;
			}
			case INSTANCE_INIT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST __t21344 = _t;
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp18_AST_in = _t;
				match(_t,INSTANCE_INIT);
				_t = _t->getFirstChild();
				slist(_t);
				_t = _retTree;
				_t = __t21344;
				_t = _t->getNextSibling();
				break;
			}
			default:
			{
				goto _loop21345;
			}
			}
		}
		_loop21345:;
		} // ( ... )*
		_t = __t21341;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::typeSpec(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST typeSpec_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21322 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp19_AST_in = _t;
		match(_t,TYPE);
		_t = _t->getFirstChild();
		typeSpecArray(_t);
		_t = _retTree;
		_t = __t21322;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::typeSpecArray(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST typeSpecArray_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ARRAY_DECLARATOR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21324 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp20_AST_in = _t;
			match(_t,ARRAY_DECLARATOR);
			_t = _t->getFirstChild();
			typeSpecArray(_t);
			_t = _retTree;
			_t = __t21324;
			_t = _t->getNextSibling();
			break;
		}
		case IDENT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case DOT:
		{
			type(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::type(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST type_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case IDENT:
		case DOT:
		{
			identifier(_t);
			_t = _retTree;
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		{
			builtInType(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::builtInType(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST builtInType_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case LITERAL_void:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp21_AST_in = _t;
			match(_t,LITERAL_void);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_boolean:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp22_AST_in = _t;
			match(_t,LITERAL_boolean);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_byte:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp23_AST_in = _t;
			match(_t,LITERAL_byte);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_char:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp24_AST_in = _t;
			match(_t,LITERAL_char);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_short:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp25_AST_in = _t;
			match(_t,LITERAL_short);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_int:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp26_AST_in = _t;
			match(_t,LITERAL_int);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_float:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp27_AST_in = _t;
			match(_t,LITERAL_float);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_long:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp28_AST_in = _t;
			match(_t,LITERAL_long);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_double:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp29_AST_in = _t;
			match(_t,LITERAL_double);
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::modifier(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST modifier_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case LITERAL_private:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp30_AST_in = _t;
			match(_t,LITERAL_private);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_public:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp31_AST_in = _t;
			match(_t,LITERAL_public);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_protected:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp32_AST_in = _t;
			match(_t,LITERAL_protected);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_static:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp33_AST_in = _t;
			match(_t,LITERAL_static);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_transient:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp34_AST_in = _t;
			match(_t,LITERAL_transient);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_final:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp35_AST_in = _t;
			match(_t,LITERAL_final);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_abstract:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp36_AST_in = _t;
			match(_t,LITERAL_abstract);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_native:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp37_AST_in = _t;
			match(_t,LITERAL_native);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_threadsafe:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp38_AST_in = _t;
			match(_t,LITERAL_threadsafe);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_synchronized:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp39_AST_in = _t;
			match(_t,LITERAL_synchronized);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_const:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp40_AST_in = _t;
			match(_t,LITERAL_const);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_volatile:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp41_AST_in = _t;
			match(_t,LITERAL_volatile);
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::ctorDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST ctorDef_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21347 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp42_AST_in = _t;
		match(_t,CTOR_DEF);
		_t = _t->getFirstChild();
		modifiers(_t);
		_t = _retTree;
		methodHead(_t);
		_t = _retTree;
		slist(_t);
		_t = _retTree;
		_t = __t21347;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::methodDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST methodDef_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21349 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp43_AST_in = _t;
		match(_t,METHOD_DEF);
		_t = _t->getFirstChild();
		modifiers(_t);
		_t = _retTree;
		typeSpec(_t);
		_t = _retTree;
		methodHead(_t);
		_t = _retTree;
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case SLIST:
		{
			slist(_t);
			_t = _retTree;
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		_t = __t21349;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::variableDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST variableDef_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21352 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp44_AST_in = _t;
		match(_t,VARIABLE_DEF);
		_t = _t->getFirstChild();
		modifiers(_t);
		_t = _retTree;
		typeSpec(_t);
		_t = _retTree;
		variableDeclarator(_t);
		_t = _retTree;
		varInitializer(_t);
		_t = _retTree;
		_t = __t21352;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::slist(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST slist_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21380 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp45_AST_in = _t;
		match(_t,SLIST);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_tokenSet_0.member(_t->getType()))) {
				stat(_t);
				_t = _retTree;
			}
			else {
				goto _loop21382;
			}
			
		}
		_loop21382:;
		} // ( ... )*
		_t = __t21380;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::methodHead(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST methodHead_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp46_AST_in = _t;
		match(_t,IDENT);
		_t = _t->getNextSibling();
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21366 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp47_AST_in = _t;
		match(_t,PARAMETERS);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == PARAMETER_DEF)) {
				parameterDef(_t);
				_t = _retTree;
			}
			else {
				goto _loop21368;
			}
			
		}
		_loop21368:;
		} // ( ... )*
		_t = __t21366;
		_t = _t->getNextSibling();
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case LITERAL_throws:
		{
			throwsClause(_t);
			_t = _retTree;
			break;
		}
		case 3:
		case SLIST:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::variableDeclarator(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST variableDeclarator_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp48_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			break;
		}
		case LBRACK:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp49_AST_in = _t;
			match(_t,LBRACK);
			_t = _t->getNextSibling();
			variableDeclarator(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::varInitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST varInitializer_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21359 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp50_AST_in = _t;
			match(_t,ASSIGN);
			_t = _t->getFirstChild();
			initializer(_t);
			_t = _retTree;
			_t = __t21359;
			_t = _t->getNextSibling();
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::parameterDef(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST parameterDef_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21354 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp51_AST_in = _t;
		match(_t,PARAMETER_DEF);
		_t = _t->getFirstChild();
		modifiers(_t);
		_t = _retTree;
		typeSpec(_t);
		_t = _retTree;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp52_AST_in = _t;
		match(_t,IDENT);
		_t = _t->getNextSibling();
		_t = __t21354;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::objectinitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST objectinitializer_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21356 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp53_AST_in = _t;
		match(_t,INSTANCE_INIT);
		_t = _t->getFirstChild();
		slist(_t);
		_t = _retTree;
		_t = __t21356;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::initializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST initializer_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case EXPR:
		{
			expression(_t);
			_t = _retTree;
			break;
		}
		case ARRAY_INIT:
		{
			arrayInitializer(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::expression(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST expression_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21424 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp54_AST_in = _t;
		match(_t,EXPR);
		_t = _t->getFirstChild();
		expr(_t);
		_t = _retTree;
		_t = __t21424;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::arrayInitializer(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST arrayInitializer_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21362 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp55_AST_in = _t;
		match(_t,ARRAY_INIT);
		_t = _t->getFirstChild();
		{ // ( ... )+
		int _cnt21364=0;
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == ARRAY_INIT || _t->getType() == EXPR)) {
				initializer(_t);
				_t = _retTree;
			}
			else {
				if ( _cnt21364>=1 ) { goto _loop21364; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);}
			}
			
			_cnt21364++;
		}
		_loop21364:;
		}  // ( ... )+
		_t = __t21362;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::throwsClause(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST throwsClause_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21371 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp56_AST_in = _t;
		match(_t,LITERAL_throws);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == IDENT || _t->getType() == DOT)) {
				identifier(_t);
				_t = _retTree;
			}
			else {
				goto _loop21373;
			}
			
		}
		_loop21373:;
		} // ( ... )*
		_t = __t21371;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::stat(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST stat_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case CLASS_DEF:
		case INTERFACE_DEF:
		{
			typeDefinition(_t);
			_t = _retTree;
			break;
		}
		case VARIABLE_DEF:
		{
			variableDef(_t);
			_t = _retTree;
			break;
		}
		case EXPR:
		{
			expression(_t);
			_t = _retTree;
			break;
		}
		case LABELED_STAT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21384 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp57_AST_in = _t;
			match(_t,LABELED_STAT);
			_t = _t->getFirstChild();
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp58_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			stat(_t);
			_t = _retTree;
			_t = __t21384;
			_t = _t->getNextSibling();
			break;
		}
		case TK_if:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21385 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp59_AST_in = _t;
			match(_t,TK_if);
			_t = _t->getFirstChild();
			expression(_t);
			_t = _retTree;
			stat(_t);
			_t = _retTree;
			_t = __t21385;
			_t = _t->getNextSibling();
			break;
		}
		case TK_for:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21386 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp60_AST_in = _t;
			match(_t,TK_for);
			_t = _t->getFirstChild();
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21387 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp61_AST_in = _t;
			match(_t,FOR_INIT);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case VARIABLE_DEF:
			{
				variableDef(_t);
				_t = _retTree;
				break;
			}
			case ELIST:
			{
				elist(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21387;
			_t = _t->getNextSibling();
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21389 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp62_AST_in = _t;
			match(_t,FOR_CONDITION);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case EXPR:
			{
				expression(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21389;
			_t = _t->getNextSibling();
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21391 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp63_AST_in = _t;
			match(_t,FOR_ITERATOR);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case ELIST:
			{
				elist(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21391;
			_t = _t->getNextSibling();
			stat(_t);
			_t = _retTree;
			_t = __t21386;
			_t = _t->getNextSibling();
			break;
		}
		case TK_while:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21393 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp64_AST_in = _t;
			match(_t,TK_while);
			_t = _t->getFirstChild();
			expression(_t);
			_t = _retTree;
			stat(_t);
			_t = _retTree;
			_t = __t21393;
			_t = _t->getNextSibling();
			break;
		}
		case TK_do:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21394 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp65_AST_in = _t;
			match(_t,TK_do);
			_t = _t->getFirstChild();
			stat(_t);
			_t = _retTree;
			expression(_t);
			_t = _retTree;
			_t = __t21394;
			_t = _t->getNextSibling();
			break;
		}
		case TK_break:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21395 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp66_AST_in = _t;
			match(_t,TK_break);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case IDENT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp67_AST_in = _t;
				match(_t,IDENT);
				_t = _t->getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21395;
			_t = _t->getNextSibling();
			break;
		}
		case TK_continue:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21397 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp68_AST_in = _t;
			match(_t,TK_continue);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case IDENT:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp69_AST_in = _t;
				match(_t,IDENT);
				_t = _t->getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21397;
			_t = _t->getNextSibling();
			break;
		}
		case TK_return:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21399 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp70_AST_in = _t;
			match(_t,TK_return);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case EXPR:
			{
				expression(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21399;
			_t = _t->getNextSibling();
			break;
		}
		case TK_switch:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21401 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp71_AST_in = _t;
			match(_t,TK_switch);
			_t = _t->getFirstChild();
			expression(_t);
			_t = _retTree;
			{ // ( ... )*
			for (;;) {
				if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
					_t = ASTNULL;
				if ((_t->getType() == CASE_GROUP)) {
					caseGroup(_t);
					_t = _retTree;
				}
				else {
					goto _loop21403;
				}
				
			}
			_loop21403:;
			} // ( ... )*
			_t = __t21401;
			_t = _t->getNextSibling();
			break;
		}
		case TK_throw:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21404 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp72_AST_in = _t;
			match(_t,TK_throw);
			_t = _t->getFirstChild();
			expression(_t);
			_t = _retTree;
			_t = __t21404;
			_t = _t->getNextSibling();
			break;
		}
		case TK_synchronized:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21405 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp73_AST_in = _t;
			match(_t,TK_synchronized);
			_t = _t->getFirstChild();
			stat(_t);
			_t = _retTree;
			_t = __t21405;
			_t = _t->getNextSibling();
			break;
		}
		case TK_try:
		{
			tryBlock(_t);
			_t = _retTree;
			break;
		}
		case SLIST:
		{
			slist(_t);
			_t = _retTree;
			break;
		}
		case EMPTY_STAT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp74_AST_in = _t;
			match(_t,EMPTY_STAT);
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::elist(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST elist_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21420 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp75_AST_in = _t;
		match(_t,ELIST);
		_t = _t->getFirstChild();
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == EXPR)) {
				expression(_t);
				_t = _retTree;
			}
			else {
				goto _loop21422;
			}
			
		}
		_loop21422:;
		} // ( ... )*
		_t = __t21420;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::caseGroup(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST caseGroup_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21407 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp76_AST_in = _t;
		match(_t,CASE_GROUP);
		_t = _t->getFirstChild();
		{ // ( ... )+
		int _cnt21410=0;
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case TK_case:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST __t21409 = _t;
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp77_AST_in = _t;
				match(_t,TK_case);
				_t = _t->getFirstChild();
				expression(_t);
				_t = _retTree;
				_t = __t21409;
				_t = _t->getNextSibling();
				break;
			}
			case TK_default:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp78_AST_in = _t;
				match(_t,TK_default);
				_t = _t->getNextSibling();
				break;
			}
			default:
			{
				if ( _cnt21410>=1 ) { goto _loop21410; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);}
			}
			}
			_cnt21410++;
		}
		_loop21410:;
		}  // ( ... )+
		slist(_t);
		_t = _retTree;
		_t = __t21407;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::tryBlock(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST tryBlock_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21412 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp79_AST_in = _t;
		match(_t,TK_try);
		_t = _t->getFirstChild();
		slist(_t);
		_t = _retTree;
		{ // ( ... )*
		for (;;) {
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			if ((_t->getType() == TK_catch)) {
				handler(_t);
				_t = _retTree;
			}
			else {
				goto _loop21414;
			}
			
		}
		_loop21414:;
		} // ( ... )*
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case TK_finally:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21416 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp80_AST_in = _t;
			match(_t,TK_finally);
			_t = _t->getFirstChild();
			slist(_t);
			_t = _retTree;
			_t = __t21416;
			_t = _t->getNextSibling();
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		_t = __t21412;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::handler(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST handler_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21418 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp81_AST_in = _t;
		match(_t,TK_catch);
		_t = _t->getFirstChild();
		parameterDef(_t);
		_t = _retTree;
		slist(_t);
		_t = _retTree;
		_t = __t21418;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::expr(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST expr_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case QUESTION:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21426 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp82_AST_in = _t;
			match(_t,QUESTION);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21426;
			_t = _t->getNextSibling();
			break;
		}
		case ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21427 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp83_AST_in = _t;
			match(_t,ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21427;
			_t = _t->getNextSibling();
			break;
		}
		case PLUS_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21428 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp84_AST_in = _t;
			match(_t,PLUS_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21428;
			_t = _t->getNextSibling();
			break;
		}
		case MINUS_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21429 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp85_AST_in = _t;
			match(_t,MINUS_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21429;
			_t = _t->getNextSibling();
			break;
		}
		case STAR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21430 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp86_AST_in = _t;
			match(_t,STAR_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21430;
			_t = _t->getNextSibling();
			break;
		}
		case DIV_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21431 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp87_AST_in = _t;
			match(_t,DIV_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21431;
			_t = _t->getNextSibling();
			break;
		}
		case MOD_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21432 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp88_AST_in = _t;
			match(_t,MOD_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21432;
			_t = _t->getNextSibling();
			break;
		}
		case SR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21433 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp89_AST_in = _t;
			match(_t,SR_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21433;
			_t = _t->getNextSibling();
			break;
		}
		case BSR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21434 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp90_AST_in = _t;
			match(_t,BSR_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21434;
			_t = _t->getNextSibling();
			break;
		}
		case SL_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21435 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp91_AST_in = _t;
			match(_t,SL_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21435;
			_t = _t->getNextSibling();
			break;
		}
		case BAND_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21436 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp92_AST_in = _t;
			match(_t,BAND_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21436;
			_t = _t->getNextSibling();
			break;
		}
		case BXOR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21437 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp93_AST_in = _t;
			match(_t,BXOR_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21437;
			_t = _t->getNextSibling();
			break;
		}
		case BOR_ASSIGN:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21438 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp94_AST_in = _t;
			match(_t,BOR_ASSIGN);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21438;
			_t = _t->getNextSibling();
			break;
		}
		case LOR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21439 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp95_AST_in = _t;
			match(_t,LOR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21439;
			_t = _t->getNextSibling();
			break;
		}
		case LAND:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21440 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp96_AST_in = _t;
			match(_t,LAND);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21440;
			_t = _t->getNextSibling();
			break;
		}
		case BOR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21441 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp97_AST_in = _t;
			match(_t,BOR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21441;
			_t = _t->getNextSibling();
			break;
		}
		case BXOR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21442 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp98_AST_in = _t;
			match(_t,BXOR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21442;
			_t = _t->getNextSibling();
			break;
		}
		case BAND:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21443 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp99_AST_in = _t;
			match(_t,BAND);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21443;
			_t = _t->getNextSibling();
			break;
		}
		case NOT_EQUAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21444 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp100_AST_in = _t;
			match(_t,NOT_EQUAL);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21444;
			_t = _t->getNextSibling();
			break;
		}
		case EQUAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21445 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp101_AST_in = _t;
			match(_t,EQUAL);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21445;
			_t = _t->getNextSibling();
			break;
		}
		case LT_:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21446 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp102_AST_in = _t;
			match(_t,LT_);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21446;
			_t = _t->getNextSibling();
			break;
		}
		case GT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21447 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp103_AST_in = _t;
			match(_t,GT);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21447;
			_t = _t->getNextSibling();
			break;
		}
		case LE:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21448 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp104_AST_in = _t;
			match(_t,LE);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21448;
			_t = _t->getNextSibling();
			break;
		}
		case GE:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21449 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp105_AST_in = _t;
			match(_t,GE);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21449;
			_t = _t->getNextSibling();
			break;
		}
		case SL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21450 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp106_AST_in = _t;
			match(_t,SL);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21450;
			_t = _t->getNextSibling();
			break;
		}
		case SR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21451 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp107_AST_in = _t;
			match(_t,SR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21451;
			_t = _t->getNextSibling();
			break;
		}
		case BSR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21452 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp108_AST_in = _t;
			match(_t,BSR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21452;
			_t = _t->getNextSibling();
			break;
		}
		case PLUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21453 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp109_AST_in = _t;
			match(_t,PLUS);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21453;
			_t = _t->getNextSibling();
			break;
		}
		case MINUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21454 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp110_AST_in = _t;
			match(_t,MINUS);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21454;
			_t = _t->getNextSibling();
			break;
		}
		case DIV:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21455 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp111_AST_in = _t;
			match(_t,DIV);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21455;
			_t = _t->getNextSibling();
			break;
		}
		case MOD:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21456 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp112_AST_in = _t;
			match(_t,MOD);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21456;
			_t = _t->getNextSibling();
			break;
		}
		case STAR:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21457 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp113_AST_in = _t;
			match(_t,STAR);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21457;
			_t = _t->getNextSibling();
			break;
		}
		case INC:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21458 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp114_AST_in = _t;
			match(_t,INC);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21458;
			_t = _t->getNextSibling();
			break;
		}
		case DEC:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21459 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp115_AST_in = _t;
			match(_t,DEC);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21459;
			_t = _t->getNextSibling();
			break;
		}
		case POST_INC:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21460 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp116_AST_in = _t;
			match(_t,POST_INC);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21460;
			_t = _t->getNextSibling();
			break;
		}
		case POST_DEC:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21461 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp117_AST_in = _t;
			match(_t,POST_DEC);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21461;
			_t = _t->getNextSibling();
			break;
		}
		case BNOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21462 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp118_AST_in = _t;
			match(_t,BNOT);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21462;
			_t = _t->getNextSibling();
			break;
		}
		case LNOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21463 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp119_AST_in = _t;
			match(_t,LNOT);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21463;
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_instanceof:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21464 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp120_AST_in = _t;
			match(_t,LITERAL_instanceof);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21464;
			_t = _t->getNextSibling();
			break;
		}
		case UNARY_MINUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21465 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp121_AST_in = _t;
			match(_t,UNARY_MINUS);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21465;
			_t = _t->getNextSibling();
			break;
		}
		case UNARY_PLUS:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21466 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp122_AST_in = _t;
			match(_t,UNARY_PLUS);
			_t = _t->getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t21466;
			_t = _t->getNextSibling();
			break;
		}
		case IDENT:
		case TYPE:
		case DOT:
		case LITERAL_this:
		case TK_new:
		case METHOD_CALL:
		case TYPECAST:
		case LITERAL_super:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case INDEX_OP:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		{
			primaryExpression(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::primaryExpression(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST primaryExpression_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case IDENT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp123_AST_in = _t;
			match(_t,IDENT);
			_t = _t->getNextSibling();
			break;
		}
		case DOT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21468 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp124_AST_in = _t;
			match(_t,DOT);
			_t = _t->getFirstChild();
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case IDENT:
			case TYPE:
			case DOT:
			case LITERAL_this:
			case TK_new:
			case METHOD_CALL:
			case TYPECAST:
			case LITERAL_super:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_null:
			case INDEX_OP:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			{
				primaryExpression(_t);
				_t = _retTree;
				{
				if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
					_t = ASTNULL;
				switch ( _t->getType()) {
				case IDENT:
				{
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp125_AST_in = _t;
					match(_t,IDENT);
					_t = _t->getNextSibling();
					break;
				}
				case INDEX_OP:
				{
					arrayIndex(_t);
					_t = _retTree;
					break;
				}
				case LITERAL_this:
				{
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp126_AST_in = _t;
					match(_t,LITERAL_this);
					_t = _t->getNextSibling();
					break;
				}
				case LITERAL_class:
				{
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp127_AST_in = _t;
					match(_t,LITERAL_class);
					_t = _t->getNextSibling();
					break;
				}
				case TK_new:
				{
					ANTLR_USE_NAMESPACE(antlr)RefAST __t21471 = _t;
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp128_AST_in = _t;
					match(_t,TK_new);
					_t = _t->getFirstChild();
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp129_AST_in = _t;
					match(_t,IDENT);
					_t = _t->getNextSibling();
					elist(_t);
					_t = _retTree;
					_t = __t21471;
					_t = _t->getNextSibling();
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
				}
				}
				}
				break;
			}
			case ARRAY_DECLARATOR:
			{
				ANTLR_USE_NAMESPACE(antlr)RefAST __t21472 = _t;
				ANTLR_USE_NAMESPACE(antlr)RefAST tmp130_AST_in = _t;
				match(_t,ARRAY_DECLARATOR);
				_t = _t->getFirstChild();
				builtInType(_t);
				_t = _retTree;
				_t = __t21472;
				_t = _t->getNextSibling();
				break;
			}
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			{
				builtInType(_t);
				_t = _retTree;
				{
				if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
					_t = ASTNULL;
				switch ( _t->getType()) {
				case TK_class:
				{
					ANTLR_USE_NAMESPACE(antlr)RefAST tmp131_AST_in = _t;
					match(_t,TK_class);
					_t = _t->getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
				}
				}
				}
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			_t = __t21468;
			_t = _t->getNextSibling();
			break;
		}
		case INDEX_OP:
		{
			arrayIndex(_t);
			_t = _retTree;
			break;
		}
		case METHOD_CALL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21474 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp132_AST_in = _t;
			match(_t,METHOD_CALL);
			_t = _t->getFirstChild();
			primaryExpression(_t);
			_t = _retTree;
			elist(_t);
			_t = _retTree;
			_t = __t21474;
			_t = _t->getNextSibling();
			break;
		}
		case TYPECAST:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST __t21475 = _t;
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp133_AST_in = _t;
			match(_t,TYPECAST);
			_t = _t->getFirstChild();
			typeSpec(_t);
			_t = _retTree;
			expr(_t);
			_t = _retTree;
			_t = __t21475;
			_t = _t->getNextSibling();
			break;
		}
		case TK_new:
		{
			newExpression(_t);
			_t = _retTree;
			break;
		}
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		{
			constant(_t);
			_t = _retTree;
			break;
		}
		case LITERAL_super:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp134_AST_in = _t;
			match(_t,LITERAL_super);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_true:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp135_AST_in = _t;
			match(_t,LITERAL_true);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_false:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp136_AST_in = _t;
			match(_t,LITERAL_false);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_this:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp137_AST_in = _t;
			match(_t,LITERAL_this);
			_t = _t->getNextSibling();
			break;
		}
		case LITERAL_null:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp138_AST_in = _t;
			match(_t,LITERAL_null);
			_t = _t->getNextSibling();
			break;
		}
		case TYPE:
		{
			typeSpec(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::arrayIndex(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST arrayIndex_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21477 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp139_AST_in = _t;
		match(_t,INDEX_OP);
		_t = _t->getFirstChild();
		primaryExpression(_t);
		_t = _retTree;
		expression(_t);
		_t = _retTree;
		_t = __t21477;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::newExpression(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST newExpression_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21480 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp140_AST_in = _t;
		match(_t,TK_new);
		_t = _t->getFirstChild();
		type(_t);
		_t = _retTree;
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ARRAY_DECLARATOR:
		{
			newArrayDeclarator(_t);
			_t = _retTree;
			{
			if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
				_t = ASTNULL;
			switch ( _t->getType()) {
			case ARRAY_INIT:
			{
				arrayInitializer(_t);
				_t = _retTree;
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
			}
			}
			}
			break;
		}
		case ELIST:
		{
			elist(_t);
			_t = _retTree;
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		_t = __t21480;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::constant(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST constant_AST_in = _t;
	
	try {      // for error handling
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case NUM_INT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp141_AST_in = _t;
			match(_t,NUM_INT);
			_t = _t->getNextSibling();
			break;
		}
		case CHAR_LITERAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp142_AST_in = _t;
			match(_t,CHAR_LITERAL);
			_t = _t->getNextSibling();
			break;
		}
		case STRING_LITERAL:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp143_AST_in = _t;
			match(_t,STRING_LITERAL);
			_t = _t->getNextSibling();
			break;
		}
		case NUM_FLOAT:
		{
			ANTLR_USE_NAMESPACE(antlr)RefAST tmp144_AST_in = _t;
			match(_t,NUM_FLOAT);
			_t = _t->getNextSibling();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::newArrayDeclarator(ANTLR_USE_NAMESPACE(antlr)RefAST _t) {
	ANTLR_USE_NAMESPACE(antlr)RefAST newArrayDeclarator_AST_in = _t;
	
	try {      // for error handling
		ANTLR_USE_NAMESPACE(antlr)RefAST __t21484 = _t;
		ANTLR_USE_NAMESPACE(antlr)RefAST tmp145_AST_in = _t;
		match(_t,ARRAY_DECLARATOR);
		_t = _t->getFirstChild();
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case ARRAY_DECLARATOR:
		{
			newArrayDeclarator(_t);
			_t = _retTree;
			break;
		}
		case 3:
		case EXPR:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		{
		if (_t == ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = ASTNULL;
		switch ( _t->getType()) {
		case EXPR:
		{
			expression(_t);
			_t = _retTree;
			break;
		}
		case 3:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(_t);
		}
		}
		}
		_t = __t21484;
		_t = _t->getNextSibling();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		if ( _t != ANTLR_USE_NAMESPACE(antlr)nullAST )
			_t = _t->getNextSibling();
	}
	_retTree = _t;
}

void JavaTreeParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* JavaTreeParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	"JAVADOC_OPEN",
	"JAVADOC_CLOSE",
	"\"int\"",
	"ID",
	"SEMI",
	"WS_",
	"PACKAGE_DEF",
	"IMPORT",
	"CLASS_DEF",
	"IDENT",
	"INTERFACE_DEF",
	"TYPE",
	"ARRAY_DECLARATOR",
	"LITERAL_void",
	"LITERAL_boolean",
	"LITERAL_byte",
	"LITERAL_char",
	"LITERAL_short",
	"LITERAL_int",
	"LITERAL_float",
	"LITERAL_long",
	"LITERAL_double",
	"MODIFIERS",
	"LITERAL_private",
	"LITERAL_public",
	"LITERAL_protected",
	"LITERAL_static",
	"LITERAL_transient",
	"LITERAL_final",
	"LITERAL_abstract",
	"LITERAL_native",
	"LITERAL_threadsafe",
	"LITERAL_synchronized",
	"LITERAL_const",
	"LITERAL_volatile",
	"EXTENDS_CLAUSE",
	"IMPLEMENTS_CLAUSE",
	"OBJBLOCK",
	"STATIC_INIT",
	"INSTANCE_INIT",
	"CTOR_DEF",
	"METHOD_DEF",
	"VARIABLE_DEF",
	"PARAMETER_DEF",
	"LBRACK",
	"ASSIGN",
	"ARRAY_INIT",
	"PARAMETERS",
	"LITERAL_throws",
	"DOT",
	"STAR",
	"SLIST",
	"LABELED_STAT",
	"\"if\"",
	"\"for\"",
	"FOR_INIT",
	"FOR_CONDITION",
	"FOR_ITERATOR",
	"\"while\"",
	"\"do\"",
	"\"break\"",
	"\"continue\"",
	"\"return\"",
	"\"switch\"",
	"\"throw\"",
	"\"synchronized\"",
	"EMPTY_STAT",
	"CASE_GROUP",
	"\"case\"",
	"\"default\"",
	"\"try\"",
	"\"finally\"",
	"\"catch\"",
	"ELIST",
	"EXPR",
	"QUESTION",
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
	"POST_INC",
	"POST_DEC",
	"BNOT",
	"LNOT",
	"LITERAL_instanceof",
	"UNARY_MINUS",
	"UNARY_PLUS",
	"LITERAL_this",
	"LITERAL_class",
	"\"new\"",
	"\"class\"",
	"METHOD_CALL",
	"TYPECAST",
	"LITERAL_super",
	"LITERAL_true",
	"LITERAL_false",
	"LITERAL_null",
	"INDEX_OP",
	"NUM_INT",
	"CHAR_LITERAL",
	"STRING_LITERAL",
	"NUM_FLOAT",
	0
};

const unsigned long JavaTreeParser::_tokenSet_0_data_[] = { 20480UL, 3347070976UL, 17535UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// CLASS_DEF INTERFACE_DEF VARIABLE_DEF SLIST LABELED_STAT "if" "for" "while" 
// "do" "break" "continue" "return" "switch" "throw" "synchronized" EMPTY_STAT 
// "try" EXPR 
const ANTLR_USE_NAMESPACE(antlr)BitSet JavaTreeParser::_tokenSet_0(_tokenSet_0_data_,8);


