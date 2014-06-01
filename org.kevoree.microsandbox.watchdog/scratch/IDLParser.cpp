/* $ANTLR 2.7.2: "idl.g" -> "IDLParser.cpp"$ */
#include "IDLParser.hpp"
#include <antlr/NoViableAltException.hpp>
#include <antlr/SemanticException.hpp>
#include <antlr/ASTFactory.hpp>
#line 1 "idl.g"
#line 8 "IDLParser.cpp"
IDLParser::IDLParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,k)
{
}

IDLParser::IDLParser(ANTLR_USE_NAMESPACE(antlr)TokenBuffer& tokenBuf)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(tokenBuf,1)
{
}

IDLParser::IDLParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer, int k)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,k)
{
}

IDLParser::IDLParser(ANTLR_USE_NAMESPACE(antlr)TokenStream& lexer)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(lexer,1)
{
}

IDLParser::IDLParser(const ANTLR_USE_NAMESPACE(antlr)ParserSharedInputState& state)
: ANTLR_USE_NAMESPACE(antlr)LLkParser(state,1)
{
}

void IDLParser::specification() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20810=0;
		for (;;) {
			if ((_tokenSet_0.member(LA(1)))) {
				definition();
			}
			else {
				if ( _cnt20810>=1 ) { goto _loop20810; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20810++;
		}
		_loop20810:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_1);
	}
}

void IDLParser::definition() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case SEMI:
		case TK_typedef:
		case TK_native:
		case TK_struct:
		case TK_union:
		case TK_enum:
		{
			type_dcl();
			match(SEMI);
			break;
		}
		case TK_const:
		{
			const_dcl();
			match(SEMI);
			break;
		}
		case TK_exception:
		{
			except_dcl();
			match(SEMI);
			break;
		}
		case TK_interface:
		{
			interf();
			match(SEMI);
			break;
		}
		case TK_module:
		{
			module();
			match(SEMI);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_2);
	}
}

void IDLParser::type_dcl() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_typedef:
		{
			match(TK_typedef);
			type_declarator();
			break;
		}
		case TK_struct:
		{
			struct_type();
			break;
		}
		case TK_union:
		{
			union_type();
			break;
		}
		case TK_enum:
		{
			enum_type();
			break;
		}
		case SEMI:
		{
			break;
		}
		case TK_native:
		{
			match(TK_native);
			simple_declarator();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::const_dcl() {
	
	try {      // for error handling
		match(TK_const);
		const_type();
		identifier();
		match(ASSIGN);
		const_exp();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::except_dcl() {
	
	try {      // for error handling
		match(TK_exception);
		identifier();
		match(LCURLY);
		opt_member_list();
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::interf() {
	
	try {      // for error handling
		match(TK_interface);
		identifier();
		inheritance_spec();
		{
		switch ( LA(1)) {
		case LCURLY:
		{
			interface_body();
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
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::module() {
	
	try {      // for error handling
		match(TK_module);
		identifier();
		match(LCURLY);
		definition_list();
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::identifier() {
	
	try {      // for error handling
		match(IDENT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_4);
	}
}

void IDLParser::definition_list() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20816=0;
		for (;;) {
			if ((_tokenSet_0.member(LA(1)))) {
				definition();
			}
			else {
				if ( _cnt20816>=1 ) { goto _loop20816; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20816++;
		}
		_loop20816:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::inheritance_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case COLON:
		{
			match(COLON);
			scoped_name_list();
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
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_6);
	}
}

void IDLParser::interface_body() {
	
	try {      // for error handling
		match(LCURLY);
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_7.member(LA(1)))) {
				export_spec();
			}
			else {
				goto _loop20821;
			}
			
		}
		_loop20821:;
		} // ( ... )*
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::export_spec() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case SEMI:
		case TK_typedef:
		case TK_native:
		case TK_struct:
		case TK_union:
		case TK_enum:
		{
			type_dcl();
			match(SEMI);
			break;
		}
		case TK_const:
		{
			const_dcl();
			match(SEMI);
			break;
		}
		case TK_exception:
		{
			except_dcl();
			match(SEMI);
			break;
		}
		case TK_readonly:
		case TK_attribute:
		{
			attr_dcl();
			match(SEMI);
			break;
		}
		case SCOPEOP:
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		case TK_string:
		case TK_oneway:
		case TK_void:
		case IDENT:
		{
			op_dcl();
			match(SEMI);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_8);
	}
}

void IDLParser::attr_dcl() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case TK_readonly:
		{
			match(TK_readonly);
			break;
		}
		case TK_attribute:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(TK_attribute);
		param_type_spec();
		simple_declarator_list();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::op_dcl() {
	
	try {      // for error handling
		op_attribute();
		op_type_spec();
		identifier();
		parameter_dcls();
		opt_raises_expr();
		opt_context_expr();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::scoped_name_list() {
	
	try {      // for error handling
		scoped_name();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				scoped_name();
			}
			else {
				goto _loop20827;
			}
			
		}
		_loop20827:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_9);
	}
}

void IDLParser::scoped_name() {
	
	try {      // for error handling
		opt_scope_op();
		identifier();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == SCOPEOP)) {
				match(SCOPEOP);
				identifier();
			}
			else {
				goto _loop20830;
			}
			
		}
		_loop20830:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_10);
	}
}

void IDLParser::opt_scope_op() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case SCOPEOP:
		{
			match(SCOPEOP);
			break;
		}
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
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::const_type() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_unsigned:
		case TK_short:
		case TK_long:
		{
			integer_type();
			break;
		}
		case TK_char:
		{
			char_type();
			break;
		}
		case TK_boolean:
		{
			boolean_type();
			break;
		}
		case TK_float:
		case TK_double:
		{
			floating_pt_type();
			break;
		}
		case TK_string:
		{
			string_type();
			break;
		}
		case SCOPEOP:
		case IDENT:
		{
			scoped_name();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::const_exp() {
	
	try {      // for error handling
		or_expr();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_12);
	}
}

void IDLParser::integer_type() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case TK_unsigned:
		{
			match(TK_unsigned);
			break;
		}
		case TK_short:
		case TK_long:
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
		case TK_short:
		{
			match(TK_short);
			break;
		}
		case TK_long:
		{
			match(TK_long);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void IDLParser::char_type() {
	
	try {      // for error handling
		match(TK_char);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void IDLParser::boolean_type() {
	
	try {      // for error handling
		match(TK_boolean);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_13);
	}
}

void IDLParser::floating_pt_type() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_float:
		{
			match(TK_float);
			break;
		}
		case TK_double:
		{
			match(TK_double);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::string_type() {
	
	try {      // for error handling
		match(TK_string);
		opt_pos_int_br();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::or_expr() {
	
	try {      // for error handling
		xor_expr();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == OR)) {
				or_op();
				xor_expr();
			}
			else {
				goto _loop20837;
			}
			
		}
		_loop20837:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_12);
	}
}

void IDLParser::xor_expr() {
	
	try {      // for error handling
		and_expr();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == XOR)) {
				xor_op();
				and_expr();
			}
			else {
				goto _loop20841;
			}
			
		}
		_loop20841:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_15);
	}
}

void IDLParser::or_op() {
	
	try {      // for error handling
		match(OR);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::and_expr() {
	
	try {      // for error handling
		shift_expr();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == AND)) {
				and_op();
				shift_expr();
			}
			else {
				goto _loop20845;
			}
			
		}
		_loop20845:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_17);
	}
}

void IDLParser::xor_op() {
	
	try {      // for error handling
		match(XOR);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::shift_expr() {
	
	try {      // for error handling
		add_expr();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == LSHIFT || LA(1) == RSHIFT)) {
				shift_op();
				add_expr();
			}
			else {
				goto _loop20849;
			}
			
		}
		_loop20849:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_18);
	}
}

void IDLParser::and_op() {
	
	try {      // for error handling
		match(AND);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::add_expr() {
	
	try {      // for error handling
		mult_expr();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == PLUS || LA(1) == MINUS)) {
				add_op();
				mult_expr();
			}
			else {
				goto _loop20853;
			}
			
		}
		_loop20853:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_19);
	}
}

void IDLParser::shift_op() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case LSHIFT:
		{
			match(LSHIFT);
			break;
		}
		case RSHIFT:
		{
			match(RSHIFT);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::mult_expr() {
	
	try {      // for error handling
		unary_expr();
		{ // ( ... )*
		for (;;) {
			if (((LA(1) >= STAR && LA(1) <= MOD))) {
				mult_op();
				unary_expr();
			}
			else {
				goto _loop20857;
			}
			
		}
		_loop20857:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_20);
	}
}

void IDLParser::add_op() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case PLUS:
		{
			match(PLUS);
			break;
		}
		case MINUS:
		{
			match(MINUS);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::unary_expr() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case PLUS:
		case MINUS:
		case TILDE:
		{
			unary_operator();
			primary_expr();
			break;
		}
		case SCOPEOP:
		case LPAREN:
		case TK_TRUE:
		case TK_FALSE:
		case INT:
		case OCTAL:
		case HEX:
		case STRING_LITERAL:
		case CHAR_LITERAL:
		case FLOAT:
		case IDENT:
		{
			primary_expr();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::mult_op() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case STAR:
		{
			match(STAR);
			break;
		}
		case DIV:
		{
			match(DIV);
			break;
		}
		case MOD:
		{
			match(MOD);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_16);
	}
}

void IDLParser::unary_operator() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case MINUS:
		{
			match(MINUS);
			break;
		}
		case PLUS:
		{
			match(PLUS);
			break;
		}
		case TILDE:
		{
			match(TILDE);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_22);
	}
}

void IDLParser::primary_expr() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case SCOPEOP:
		case IDENT:
		{
			scoped_name();
			break;
		}
		case TK_TRUE:
		case TK_FALSE:
		case INT:
		case OCTAL:
		case HEX:
		case STRING_LITERAL:
		case CHAR_LITERAL:
		case FLOAT:
		{
			literal();
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			const_exp();
			match(RPAREN);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::literal() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case INT:
		case OCTAL:
		case HEX:
		{
			integer_literal();
			break;
		}
		case STRING_LITERAL:
		{
			string_literal();
			break;
		}
		case CHAR_LITERAL:
		{
			character_literal();
			break;
		}
		case FLOAT:
		{
			floating_pt_literal();
			break;
		}
		case TK_TRUE:
		case TK_FALSE:
		{
			boolean_literal();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::integer_literal() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case INT:
		{
			match(INT);
			break;
		}
		case OCTAL:
		{
			match(OCTAL);
			break;
		}
		case HEX:
		{
			match(HEX);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::string_literal() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20947=0;
		for (;;) {
			if ((LA(1) == STRING_LITERAL)) {
				match(STRING_LITERAL);
			}
			else {
				if ( _cnt20947>=1 ) { goto _loop20947; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20947++;
		}
		_loop20947:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_23);
	}
}

void IDLParser::character_literal() {
	
	try {      // for error handling
		match(CHAR_LITERAL);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::floating_pt_literal() {
	ANTLR_USE_NAMESPACE(antlr)RefToken  f = ANTLR_USE_NAMESPACE(antlr)nullToken;
	
	try {      // for error handling
		f = LT(1);
		match(FLOAT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::boolean_literal() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_TRUE:
		{
			match(TK_TRUE);
			break;
		}
		case TK_FALSE:
		{
			match(TK_FALSE);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_21);
	}
}

void IDLParser::positive_int_const() {
	
	try {      // for error handling
		const_exp();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_24);
	}
}

void IDLParser::type_declarator() {
	
	try {      // for error handling
		type_spec();
		declarators();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::struct_type() {
	
	try {      // for error handling
		match(TK_struct);
		identifier();
		match(LCURLY);
		member_list();
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_25);
	}
}

void IDLParser::union_type() {
	
	try {      // for error handling
		match(TK_union);
		identifier();
		match(TK_switch);
		match(LPAREN);
		switch_type_spec();
		match(RPAREN);
		match(LCURLY);
		switch_body();
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_25);
	}
}

void IDLParser::enum_type() {
	
	try {      // for error handling
		match(TK_enum);
		identifier();
		match(LCURLY);
		enumerator_list();
		match(RCURLY);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_26);
	}
}

void IDLParser::simple_declarator() {
	
	try {      // for error handling
		identifier();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_27);
	}
}

void IDLParser::type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case SCOPEOP:
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		case TK_sequence:
		case TK_string:
		case IDENT:
		{
			simple_type_spec();
			break;
		}
		case TK_struct:
		case TK_union:
		case TK_enum:
		{
			constr_type_spec();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::declarators() {
	
	try {      // for error handling
		declarator();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				declarator();
			}
			else {
				goto _loop20880;
			}
			
		}
		_loop20880:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::simple_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		{
			base_type_spec();
			break;
		}
		case TK_sequence:
		case TK_string:
		{
			template_type_spec();
			break;
		}
		case SCOPEOP:
		case IDENT:
		{
			scoped_name();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::constr_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_struct:
		{
			struct_type();
			break;
		}
		case TK_union:
		{
			union_type();
			break;
		}
		case TK_enum:
		{
			enum_type();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::base_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_unsigned:
		case TK_short:
		case TK_long:
		{
			integer_type();
			break;
		}
		case TK_char:
		{
			char_type();
			break;
		}
		case TK_boolean:
		{
			boolean_type();
			break;
		}
		case TK_float:
		case TK_double:
		{
			floating_pt_type();
			break;
		}
		case TK_octet:
		{
			match(TK_octet);
			break;
		}
		case TK_any:
		{
			match(TK_any);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::template_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_sequence:
		{
			sequence_type();
			break;
		}
		case TK_string:
		{
			string_type();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::sequence_type() {
	
	try {      // for error handling
		match(TK_sequence);
		match(LT_);
		simple_type_spec();
		opt_pos_int();
		match(GT);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::declarator() {
	
	try {      // for error handling
		identifier();
		opt_fixed_array_size();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_28);
	}
}

void IDLParser::opt_fixed_array_size() {
	
	try {      // for error handling
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == LBRACK)) {
				fixed_array_size();
			}
			else {
				goto _loop20884;
			}
			
		}
		_loop20884:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_28);
	}
}

void IDLParser::fixed_array_size() {
	
	try {      // for error handling
		match(LBRACK);
		positive_int_const();
		match(RBRACK);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_29);
	}
}

void IDLParser::member_list() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20889=0;
		for (;;) {
			if ((_tokenSet_30.member(LA(1)))) {
				member();
			}
			else {
				if ( _cnt20889>=1 ) { goto _loop20889; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20889++;
		}
		_loop20889:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::member() {
	
	try {      // for error handling
		type_spec();
		declarators();
		match(SEMI);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_31);
	}
}

void IDLParser::switch_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_unsigned:
		case TK_short:
		case TK_long:
		{
			integer_type();
			break;
		}
		case TK_char:
		{
			char_type();
			break;
		}
		case TK_boolean:
		{
			boolean_type();
			break;
		}
		case TK_enum:
		{
			enum_type();
			break;
		}
		case SCOPEOP:
		case IDENT:
		{
			scoped_name();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_32);
	}
}

void IDLParser::switch_body() {
	
	try {      // for error handling
		case_stmt_list();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::case_stmt_list() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20896=0;
		for (;;) {
			if ((LA(1) == TK_case || LA(1) == TK_default)) {
				case_stmt();
			}
			else {
				if ( _cnt20896>=1 ) { goto _loop20896; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20896++;
		}
		_loop20896:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::case_stmt() {
	
	try {      // for error handling
		case_label_list();
		element_spec();
		match(SEMI);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_33);
	}
}

void IDLParser::case_label_list() {
	
	try {      // for error handling
		{ // ( ... )+
		int _cnt20900=0;
		for (;;) {
			if ((LA(1) == TK_case || LA(1) == TK_default)) {
				case_label();
			}
			else {
				if ( _cnt20900>=1 ) { goto _loop20900; } else {throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt20900++;
		}
		_loop20900:;
		}  // ( ... )+
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_30);
	}
}

void IDLParser::element_spec() {
	
	try {      // for error handling
		type_spec();
		declarator();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::case_label() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_case:
		{
			match(TK_case);
			const_exp();
			match(COLON);
			break;
		}
		case TK_default:
		{
			match(TK_default);
			match(COLON);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_34);
	}
}

void IDLParser::enumerator_list() {
	
	try {      // for error handling
		enumerator();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				enumerator();
			}
			else {
				goto _loop20906;
			}
			
		}
		_loop20906:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::enumerator() {
	
	try {      // for error handling
		identifier();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_35);
	}
}

void IDLParser::opt_pos_int() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			positive_int_const();
			break;
		}
		case GT:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_36);
	}
}

void IDLParser::opt_pos_int_br() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case LT_:
		{
			match(LT_);
			positive_int_const();
			match(GT);
			break;
		}
		case COMMA:
		case GT:
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
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_14);
	}
}

void IDLParser::param_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		{
			base_type_spec();
			break;
		}
		case TK_string:
		{
			string_type();
			break;
		}
		case SCOPEOP:
		case IDENT:
		{
			scoped_name();
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::simple_declarator_list() {
	
	try {      // for error handling
		simple_declarator();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				simple_declarator();
			}
			else {
				goto _loop20919;
			}
			
		}
		_loop20919:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::opt_member_list() {
	
	try {      // for error handling
		{ // ( ... )*
		for (;;) {
			if ((_tokenSet_30.member(LA(1)))) {
				member();
			}
			else {
				goto _loop20923;
			}
			
		}
		_loop20923:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_5);
	}
}

void IDLParser::op_attribute() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_oneway:
		{
			match(TK_oneway);
			break;
		}
		case SCOPEOP:
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		case TK_string:
		case TK_void:
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
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_37);
	}
}

void IDLParser::op_type_spec() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case SCOPEOP:
		case TK_octet:
		case TK_any:
		case TK_unsigned:
		case TK_short:
		case TK_long:
		case TK_char:
		case TK_float:
		case TK_double:
		case TK_boolean:
		case TK_string:
		case IDENT:
		{
			param_type_spec();
			break;
		}
		case TK_void:
		{
			match(TK_void);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_11);
	}
}

void IDLParser::parameter_dcls() {
	
	try {      // for error handling
		match(LPAREN);
		{
		switch ( LA(1)) {
		case TK_in:
		case TK_out:
		case TK_inout:
		{
			param_dcl_list();
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
		match(RPAREN);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_38);
	}
}

void IDLParser::opt_raises_expr() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case TK_raises:
		{
			raises_expr();
			break;
		}
		case SEMI:
		case TK_context:
		{
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_39);
	}
}

void IDLParser::opt_context_expr() {
	
	try {      // for error handling
		{
		switch ( LA(1)) {
		case TK_context:
		{
			context_expr();
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
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::raises_expr() {
	
	try {      // for error handling
		match(TK_raises);
		match(LPAREN);
		scoped_name_list();
		match(RPAREN);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_39);
	}
}

void IDLParser::context_expr() {
	
	try {      // for error handling
		match(TK_context);
		match(LPAREN);
		string_literal_list();
		match(RPAREN);
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_3);
	}
}

void IDLParser::param_dcl_list() {
	
	try {      // for error handling
		param_dcl();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				param_dcl();
			}
			else {
				goto _loop20935;
			}
			
		}
		_loop20935:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_32);
	}
}

void IDLParser::param_dcl() {
	
	try {      // for error handling
		param_attribute();
		param_type_spec();
		simple_declarator();
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_40);
	}
}

void IDLParser::param_attribute() {
	
	try {      // for error handling
		switch ( LA(1)) {
		case TK_in:
		{
			match(TK_in);
			break;
		}
		case TK_out:
		{
			match(TK_out);
			break;
		}
		case TK_inout:
		{
			match(TK_inout);
			break;
		}
		default:
		{
			throw ANTLR_USE_NAMESPACE(antlr)NoViableAltException(LT(1), getFilename());
		}
		}
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_41);
	}
}

void IDLParser::string_literal_list() {
	
	try {      // for error handling
		string_literal();
		{ // ( ... )*
		for (;;) {
			if ((LA(1) == COMMA)) {
				match(COMMA);
				string_literal();
			}
			else {
				goto _loop20942;
			}
			
		}
		_loop20942:;
		} // ( ... )*
	}
	catch (ANTLR_USE_NAMESPACE(antlr)RecognitionException& ex) {
		reportError(ex);
		consume();
		consumeUntil(_tokenSet_32);
	}
}

void IDLParser::initializeASTFactory( ANTLR_USE_NAMESPACE(antlr)ASTFactory& factory )
{
}
const char* IDLParser::tokenNames[] = {
	"<0>",
	"EOF",
	"<2>",
	"NULL_TREE_LOOKAHEAD",
	";",
	"\"module\"",
	"{",
	"}",
	"\"interface\"",
	":",
	",",
	"::",
	"\"const\"",
	"=",
	"|",
	"^",
	"&",
	"<<",
	">>",
	"+",
	"-",
	"*",
	"/",
	"%",
	"~",
	"(",
	")",
	"\"TRUE\"",
	"\"FALSE\"",
	"\"typedef\"",
	"\"native\"",
	"\"octet\"",
	"\"any\"",
	"\"unsigned\"",
	"\"short\"",
	"\"long\"",
	"\"char\"",
	"\"float\"",
	"\"double\"",
	"\"boolean\"",
	"\"struct\"",
	"\"union\"",
	"\"switch\"",
	"\"case\"",
	"\"default\"",
	"\"enum\"",
	"\"sequence\"",
	"<",
	">",
	"\"string\"",
	"[",
	"]",
	"\"readonly\"",
	"\"attribute\"",
	"\"exception\"",
	"\"oneway\"",
	"\"void\"",
	"\"in\"",
	"\"out\"",
	"\"inout\"",
	"\"raises\"",
	"\"context\"",
	"an integer value",
	"OCTAL",
	"a hexadecimal value value",
	"a string literal",
	"a character literal",
	"an floating point value",
	"an identifer",
	"?",
	".",
	"!",
	"white space",
	"a preprocessor directive",
	"a comment",
	"a comment",
	"an escape sequence",
	"an escaped character value",
	"a digit",
	"an octal digit",
	"a hexadecimal digit",
	0
};

const unsigned long IDLParser::_tokenSet_0_data_[] = { 1610617136UL, 4203264UL, 0UL, 0UL };
// SEMI "module" "interface" "const" "typedef" "native" "struct" "union" 
// "enum" "exception" 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_0(_tokenSet_0_data_,4);
const unsigned long IDLParser::_tokenSet_1_data_[] = { 2UL, 0UL, 0UL, 0UL };
// EOF 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_1(_tokenSet_1_data_,4);
const unsigned long IDLParser::_tokenSet_2_data_[] = { 1610617266UL, 4203264UL, 0UL, 0UL };
// EOF SEMI "module" RCURLY "interface" "const" "typedef" "native" "struct" 
// "union" "enum" "exception" 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_2(_tokenSet_2_data_,4);
const unsigned long IDLParser::_tokenSet_3_data_[] = { 16UL, 0UL, 0UL, 0UL };
// SEMI 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_3(_tokenSet_3_data_,4);
const unsigned long IDLParser::_tokenSet_4_data_[] = { 117436112UL, 852992UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LCURLY RCURLY COLON COMMA SCOPEOP ASSIGN OR XOR AND LSHIFT RSHIFT 
// PLUS MINUS STAR DIV MOD LPAREN RPAREN "switch" GT LBRACK RBRACK IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_4(_tokenSet_4_data_,8);
const unsigned long IDLParser::_tokenSet_5_data_[] = { 128UL, 0UL, 0UL, 0UL };
// RCURLY 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_5(_tokenSet_5_data_,4);
const unsigned long IDLParser::_tokenSet_6_data_[] = { 80UL, 0UL, 0UL, 0UL };
// SEMI LCURLY 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_6(_tokenSet_6_data_,4);
const unsigned long IDLParser::_tokenSet_7_data_[] = { 3758102544UL, 32646143UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI SCOPEOP "const" "typedef" "native" "octet" "any" "unsigned" "short" 
// "long" "char" "float" "double" "boolean" "struct" "union" "enum" "string" 
// "readonly" "attribute" "exception" "oneway" "void" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_7(_tokenSet_7_data_,8);
const unsigned long IDLParser::_tokenSet_8_data_[] = { 3758102672UL, 32646143UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI RCURLY SCOPEOP "const" "typedef" "native" "octet" "any" "unsigned" 
// "short" "long" "char" "float" "double" "boolean" "struct" "union" "enum" 
// "string" "readonly" "attribute" "exception" "oneway" "void" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_8(_tokenSet_8_data_,8);
const unsigned long IDLParser::_tokenSet_9_data_[] = { 67108944UL, 0UL, 0UL, 0UL };
// SEMI LCURLY RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_9(_tokenSet_9_data_,4);
const unsigned long IDLParser::_tokenSet_10_data_[] = { 83871312UL, 589824UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI LCURLY COLON COMMA OR XOR AND LSHIFT RSHIFT PLUS MINUS STAR DIV 
// MOD RPAREN GT RBRACK IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_10(_tokenSet_10_data_,8);
const unsigned long IDLParser::_tokenSet_11_data_[] = { 0UL, 0UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_11(_tokenSet_11_data_,8);
const unsigned long IDLParser::_tokenSet_12_data_[] = { 67109392UL, 589824UL, 0UL, 0UL };
// SEMI COLON RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_12(_tokenSet_12_data_,4);
const unsigned long IDLParser::_tokenSet_13_data_[] = { 67109888UL, 65536UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// COMMA RPAREN GT IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_13(_tokenSet_13_data_,8);
const unsigned long IDLParser::_tokenSet_14_data_[] = { 1024UL, 65536UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// COMMA GT IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_14(_tokenSet_14_data_,8);
const unsigned long IDLParser::_tokenSet_15_data_[] = { 67125776UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_15(_tokenSet_15_data_,4);
const unsigned long IDLParser::_tokenSet_16_data_[] = { 454559744UL, 3221225472UL, 31UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP PLUS MINUS TILDE LPAREN "TRUE" "FALSE" INT OCTAL HEX STRING_LITERAL 
// CHAR_LITERAL FLOAT IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_16(_tokenSet_16_data_,8);
const unsigned long IDLParser::_tokenSet_17_data_[] = { 67158544UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR XOR RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_17(_tokenSet_17_data_,4);
const unsigned long IDLParser::_tokenSet_18_data_[] = { 67224080UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR XOR AND RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_18(_tokenSet_18_data_,4);
const unsigned long IDLParser::_tokenSet_19_data_[] = { 67617296UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR XOR AND LSHIFT RSHIFT RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_19(_tokenSet_19_data_,4);
const unsigned long IDLParser::_tokenSet_20_data_[] = { 69190160UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR XOR AND LSHIFT RSHIFT PLUS MINUS RPAREN GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_20(_tokenSet_20_data_,4);
const unsigned long IDLParser::_tokenSet_21_data_[] = { 83870224UL, 589824UL, 0UL, 0UL };
// SEMI COLON OR XOR AND LSHIFT RSHIFT PLUS MINUS STAR DIV MOD RPAREN GT 
// RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_21(_tokenSet_21_data_,4);
const unsigned long IDLParser::_tokenSet_22_data_[] = { 436209664UL, 3221225472UL, 31UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP LPAREN "TRUE" "FALSE" INT OCTAL HEX STRING_LITERAL CHAR_LITERAL 
// FLOAT IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_22(_tokenSet_22_data_,8);
const unsigned long IDLParser::_tokenSet_23_data_[] = { 83871248UL, 589824UL, 0UL, 0UL };
// SEMI COLON COMMA OR XOR AND LSHIFT RSHIFT PLUS MINUS STAR DIV MOD RPAREN 
// GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_23(_tokenSet_23_data_,4);
const unsigned long IDLParser::_tokenSet_24_data_[] = { 0UL, 589824UL, 0UL, 0UL };
// GT RBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_24(_tokenSet_24_data_,4);
const unsigned long IDLParser::_tokenSet_25_data_[] = { 16UL, 0UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_25(_tokenSet_25_data_,8);
const unsigned long IDLParser::_tokenSet_26_data_[] = { 67108880UL, 0UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SEMI RPAREN IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_26(_tokenSet_26_data_,8);
const unsigned long IDLParser::_tokenSet_27_data_[] = { 67109904UL, 0UL, 0UL, 0UL };
// SEMI COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_27(_tokenSet_27_data_,4);
const unsigned long IDLParser::_tokenSet_28_data_[] = { 1040UL, 0UL, 0UL, 0UL };
// SEMI COMMA 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_28(_tokenSet_28_data_,4);
const unsigned long IDLParser::_tokenSet_29_data_[] = { 1040UL, 262144UL, 0UL, 0UL };
// SEMI COMMA LBRACK 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_29(_tokenSet_29_data_,4);
const unsigned long IDLParser::_tokenSet_30_data_[] = { 2147485696UL, 156671UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP "octet" "any" "unsigned" "short" "long" "char" "float" "double" 
// "boolean" "struct" "union" "enum" "sequence" "string" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_30(_tokenSet_30_data_,8);
const unsigned long IDLParser::_tokenSet_31_data_[] = { 2147485824UL, 156671UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// RCURLY SCOPEOP "octet" "any" "unsigned" "short" "long" "char" "float" 
// "double" "boolean" "struct" "union" "enum" "sequence" "string" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_31(_tokenSet_31_data_,8);
const unsigned long IDLParser::_tokenSet_32_data_[] = { 67108864UL, 0UL, 0UL, 0UL };
// RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_32(_tokenSet_32_data_,4);
const unsigned long IDLParser::_tokenSet_33_data_[] = { 128UL, 6144UL, 0UL, 0UL };
// RCURLY "case" "default" 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_33(_tokenSet_33_data_,4);
const unsigned long IDLParser::_tokenSet_34_data_[] = { 2147485696UL, 162815UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP "octet" "any" "unsigned" "short" "long" "char" "float" "double" 
// "boolean" "struct" "union" "case" "default" "enum" "sequence" "string" 
// IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_34(_tokenSet_34_data_,8);
const unsigned long IDLParser::_tokenSet_35_data_[] = { 1152UL, 0UL, 0UL, 0UL };
// RCURLY COMMA 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_35(_tokenSet_35_data_,4);
const unsigned long IDLParser::_tokenSet_36_data_[] = { 0UL, 65536UL, 0UL, 0UL };
// GT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_36(_tokenSet_36_data_,4);
const unsigned long IDLParser::_tokenSet_37_data_[] = { 2147485696UL, 16908543UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP "octet" "any" "unsigned" "short" "long" "char" "float" "double" 
// "boolean" "string" "void" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_37(_tokenSet_37_data_,8);
const unsigned long IDLParser::_tokenSet_38_data_[] = { 16UL, 805306368UL, 0UL, 0UL };
// SEMI "raises" "context" 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_38(_tokenSet_38_data_,4);
const unsigned long IDLParser::_tokenSet_39_data_[] = { 16UL, 536870912UL, 0UL, 0UL };
// SEMI "context" 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_39(_tokenSet_39_data_,4);
const unsigned long IDLParser::_tokenSet_40_data_[] = { 67109888UL, 0UL, 0UL, 0UL };
// COMMA RPAREN 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_40(_tokenSet_40_data_,4);
const unsigned long IDLParser::_tokenSet_41_data_[] = { 2147485696UL, 131327UL, 16UL, 0UL, 0UL, 0UL, 0UL, 0UL };
// SCOPEOP "octet" "any" "unsigned" "short" "long" "char" "float" "double" 
// "boolean" "string" IDENT 
const ANTLR_USE_NAMESPACE(antlr)BitSet IDLParser::_tokenSet_41(_tokenSet_41_data_,8);


