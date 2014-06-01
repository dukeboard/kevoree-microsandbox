// $ANTLR 2.7.2: "java.tree.g" -> "JavaTreeParser.java"$

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


/** Java 1.3 AST Recognizer Grammar
 *
 * Author: (see java.g preamble)
 *
 * This grammar is in the PUBLIC DOMAIN
 */
public class JavaTreeParser extends antlr.TreeParser       implements JavaTreeParserTokenTypes
 {
public JavaTreeParser() {
	tokenNames = _tokenNames;
}

	public final void compilationUnit(AST _t) throws RecognitionException {
		
		AST compilationUnit_AST_in = (AST)_t;
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop19136:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==IMPORT)) {
					importDefinition(_t);
					_t = _retTree;
				}
				else {
					break _loop19136;
				}
				
			} while (true);
			}
			{
			_loop19138:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==CLASS_DEF||_t.getType()==INTERFACE_DEF)) {
					typeDefinition(_t);
					_t = _retTree;
				}
				else {
					break _loop19138;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void packageDefinition(AST _t) throws RecognitionException {
		
		AST packageDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19140 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,PACKAGE_DEF);
			_t = _t.getFirstChild();
			identifier(_t);
			_t = _retTree;
			_t = __t19140;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void importDefinition(AST _t) throws RecognitionException {
		
		AST importDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19142 = _t;
			AST tmp2_AST_in = (AST)_t;
			match(_t,IMPORT);
			_t = _t.getFirstChild();
			identifierStar(_t);
			_t = _retTree;
			_t = __t19142;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void typeDefinition(AST _t) throws RecognitionException {
		
		AST typeDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CLASS_DEF:
			{
				AST __t19144 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,CLASS_DEF);
				_t = _t.getFirstChild();
				modifiers(_t);
				_t = _retTree;
				AST tmp4_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				extendsClause(_t);
				_t = _retTree;
				implementsClause(_t);
				_t = _retTree;
				objBlock(_t);
				_t = _retTree;
				_t = __t19144;
				_t = _t.getNextSibling();
				break;
			}
			case INTERFACE_DEF:
			{
				AST __t19145 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,INTERFACE_DEF);
				_t = _t.getFirstChild();
				modifiers(_t);
				_t = _retTree;
				AST tmp6_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				extendsClause(_t);
				_t = _retTree;
				interfaceBlock(_t);
				_t = _retTree;
				_t = __t19145;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void identifier(AST _t) throws RecognitionException {
		
		AST identifier_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			{
				AST tmp7_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t19207 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				identifier(_t);
				_t = _retTree;
				AST tmp9_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				_t = __t19207;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void identifierStar(AST _t) throws RecognitionException {
		
		AST identifierStar_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			{
				AST tmp10_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t19209 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				identifier(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case STAR:
				{
					AST tmp12_AST_in = (AST)_t;
					match(_t,STAR);
					_t = _t.getNextSibling();
					break;
				}
				case IDENT:
				{
					AST tmp13_AST_in = (AST)_t;
					match(_t,IDENT);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19209;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void modifiers(AST _t) throws RecognitionException {
		
		AST modifiers_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19153 = _t;
			AST tmp14_AST_in = (AST)_t;
			match(_t,MODIFIERS);
			_t = _t.getFirstChild();
			{
			_loop19155:
			do {
				if (_t==null) _t=ASTNULL;
				if (((_t.getType() >= TK_private && _t.getType() <= TK_strictfp))) {
					modifier(_t);
					_t = _retTree;
				}
				else {
					break _loop19155;
				}
				
			} while (true);
			}
			_t = __t19153;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void extendsClause(AST _t) throws RecognitionException {
		
		AST extendsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19158 = _t;
			AST tmp15_AST_in = (AST)_t;
			match(_t,EXTENDS_CLAUSE);
			_t = _t.getFirstChild();
			{
			_loop19160:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==IDENT||_t.getType()==DOT)) {
					identifier(_t);
					_t = _retTree;
				}
				else {
					break _loop19160;
				}
				
			} while (true);
			}
			_t = __t19158;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void implementsClause(AST _t) throws RecognitionException {
		
		AST implementsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19162 = _t;
			AST tmp16_AST_in = (AST)_t;
			match(_t,IMPLEMENTS_CLAUSE);
			_t = _t.getFirstChild();
			{
			_loop19164:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==IDENT||_t.getType()==DOT)) {
					identifier(_t);
					_t = _retTree;
				}
				else {
					break _loop19164;
				}
				
			} while (true);
			}
			_t = __t19162;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void objBlock(AST _t) throws RecognitionException {
		
		AST objBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19170 = _t;
			AST tmp17_AST_in = (AST)_t;
			match(_t,OBJBLOCK);
			_t = _t.getFirstChild();
			{
			_loop19174:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					AST __t19172 = _t;
					AST tmp18_AST_in = (AST)_t;
					match(_t,STATIC_INIT);
					_t = _t.getFirstChild();
					slist(_t);
					_t = _retTree;
					_t = __t19172;
					_t = _t.getNextSibling();
					break;
				}
				case INSTANCE_INIT:
				{
					AST __t19173 = _t;
					AST tmp19_AST_in = (AST)_t;
					match(_t,INSTANCE_INIT);
					_t = _t.getFirstChild();
					slist(_t);
					_t = _retTree;
					_t = __t19173;
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					break _loop19174;
				}
				}
			} while (true);
			}
			_t = __t19170;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void interfaceBlock(AST _t) throws RecognitionException {
		
		AST interfaceBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19166 = _t;
			AST tmp20_AST_in = (AST)_t;
			match(_t,OBJBLOCK);
			_t = _t.getFirstChild();
			{
			_loop19168:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case METHOD_DEF:
				{
					methodDecl(_t);
					_t = _retTree;
					break;
				}
				case VARIABLE_DEF:
				{
					variableDef(_t);
					_t = _retTree;
					break;
				}
				default:
				{
					break _loop19168;
				}
				}
			} while (true);
			}
			_t = __t19166;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void typeSpec(AST _t) throws RecognitionException {
		
		AST typeSpec_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19147 = _t;
			AST tmp21_AST_in = (AST)_t;
			match(_t,TYPE);
			_t = _t.getFirstChild();
			typeSpecArray(_t);
			_t = _retTree;
			_t = __t19147;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void typeSpecArray(AST _t) throws RecognitionException {
		
		AST typeSpecArray_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARRAY_DECLARATOR:
			{
				AST __t19149 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,ARRAY_DECLARATOR);
				_t = _t.getFirstChild();
				typeSpecArray(_t);
				_t = _retTree;
				_t = __t19149;
				_t = _t.getNextSibling();
				break;
			}
			case INT:
			case IDENT:
			case TK_void:
			case TK_boolean:
			case TK_byte:
			case TK_char:
			case TK_short:
			case TK_float:
			case TK_long:
			case TK_double:
			case DOT:
			{
				type(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void type(AST _t) throws RecognitionException {
		
		AST type_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			case DOT:
			{
				identifier(_t);
				_t = _retTree;
				break;
			}
			case INT:
			case TK_void:
			case TK_boolean:
			case TK_byte:
			case TK_char:
			case TK_short:
			case TK_float:
			case TK_long:
			case TK_double:
			{
				builtInType(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void builtInType(AST _t) throws RecognitionException {
		
		AST builtInType_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TK_void:
			{
				AST tmp23_AST_in = (AST)_t;
				match(_t,TK_void);
				_t = _t.getNextSibling();
				break;
			}
			case TK_boolean:
			{
				AST tmp24_AST_in = (AST)_t;
				match(_t,TK_boolean);
				_t = _t.getNextSibling();
				break;
			}
			case TK_byte:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,TK_byte);
				_t = _t.getNextSibling();
				break;
			}
			case TK_char:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,TK_char);
				_t = _t.getNextSibling();
				break;
			}
			case TK_short:
			{
				AST tmp27_AST_in = (AST)_t;
				match(_t,TK_short);
				_t = _t.getNextSibling();
				break;
			}
			case INT:
			{
				AST tmp28_AST_in = (AST)_t;
				match(_t,INT);
				_t = _t.getNextSibling();
				break;
			}
			case TK_float:
			{
				AST tmp29_AST_in = (AST)_t;
				match(_t,TK_float);
				_t = _t.getNextSibling();
				break;
			}
			case TK_long:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,TK_long);
				_t = _t.getNextSibling();
				break;
			}
			case TK_double:
			{
				AST tmp31_AST_in = (AST)_t;
				match(_t,TK_double);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void modifier(AST _t) throws RecognitionException {
		
		AST modifier_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TK_private:
			{
				AST tmp32_AST_in = (AST)_t;
				match(_t,TK_private);
				_t = _t.getNextSibling();
				break;
			}
			case TK_public:
			{
				AST tmp33_AST_in = (AST)_t;
				match(_t,TK_public);
				_t = _t.getNextSibling();
				break;
			}
			case TK_protected:
			{
				AST tmp34_AST_in = (AST)_t;
				match(_t,TK_protected);
				_t = _t.getNextSibling();
				break;
			}
			case TK_static:
			{
				AST tmp35_AST_in = (AST)_t;
				match(_t,TK_static);
				_t = _t.getNextSibling();
				break;
			}
			case TK_transient:
			{
				AST tmp36_AST_in = (AST)_t;
				match(_t,TK_transient);
				_t = _t.getNextSibling();
				break;
			}
			case TK_final:
			{
				AST tmp37_AST_in = (AST)_t;
				match(_t,TK_final);
				_t = _t.getNextSibling();
				break;
			}
			case TK_abstract:
			{
				AST tmp38_AST_in = (AST)_t;
				match(_t,TK_abstract);
				_t = _t.getNextSibling();
				break;
			}
			case TK_native:
			{
				AST tmp39_AST_in = (AST)_t;
				match(_t,TK_native);
				_t = _t.getNextSibling();
				break;
			}
			case TK_threadsafe:
			{
				AST tmp40_AST_in = (AST)_t;
				match(_t,TK_threadsafe);
				_t = _t.getNextSibling();
				break;
			}
			case TK_synchronized:
			{
				AST tmp41_AST_in = (AST)_t;
				match(_t,TK_synchronized);
				_t = _t.getNextSibling();
				break;
			}
			case TK_const:
			{
				AST tmp42_AST_in = (AST)_t;
				match(_t,TK_const);
				_t = _t.getNextSibling();
				break;
			}
			case TK_volatile:
			{
				AST tmp43_AST_in = (AST)_t;
				match(_t,TK_volatile);
				_t = _t.getNextSibling();
				break;
			}
			case TK_strictfp:
			{
				AST tmp44_AST_in = (AST)_t;
				match(_t,TK_strictfp);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void methodDecl(AST _t) throws RecognitionException {
		
		AST methodDecl_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19179 = _t;
			AST tmp45_AST_in = (AST)_t;
			match(_t,METHOD_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = _retTree;
			typeSpec(_t);
			_t = _retTree;
			methodHead(_t);
			_t = _retTree;
			_t = __t19179;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void variableDef(AST _t) throws RecognitionException {
		
		AST variableDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19184 = _t;
			AST tmp46_AST_in = (AST)_t;
			match(_t,VARIABLE_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = _retTree;
			typeSpec(_t);
			_t = _retTree;
			variableDeclarator(_t);
			_t = _retTree;
			varInitializer(_t);
			_t = _retTree;
			_t = __t19184;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void ctorDef(AST _t) throws RecognitionException {
		
		AST ctorDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19176 = _t;
			AST tmp47_AST_in = (AST)_t;
			match(_t,CTOR_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = _retTree;
			methodHead(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t19176;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void methodDef(AST _t) throws RecognitionException {
		
		AST methodDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19181 = _t;
			AST tmp48_AST_in = (AST)_t;
			match(_t,METHOD_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = _retTree;
			typeSpec(_t);
			_t = _retTree;
			methodHead(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t19181;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void slist(AST _t) throws RecognitionException {
		
		AST slist_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19212 = _t;
			AST tmp49_AST_in = (AST)_t;
			match(_t,SLIST);
			_t = _t.getFirstChild();
			{
			_loop19214:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					stat(_t);
					_t = _retTree;
				}
				else {
					break _loop19214;
				}
				
			} while (true);
			}
			_t = __t19212;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void methodHead(AST _t) throws RecognitionException {
		
		AST methodHead_AST_in = (AST)_t;
		
		try {      // for error handling
			AST tmp50_AST_in = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			AST __t19198 = _t;
			AST tmp51_AST_in = (AST)_t;
			match(_t,PARAMETERS);
			_t = _t.getFirstChild();
			{
			_loop19200:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==PARAMETER_DEF)) {
					parameterDef(_t);
					_t = _retTree;
				}
				else {
					break _loop19200;
				}
				
			} while (true);
			}
			_t = __t19198;
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TK_throws:
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
				throw new NoViableAltException(_t);
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void variableDeclarator(AST _t) throws RecognitionException {
		
		AST variableDeclarator_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			{
				AST tmp52_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case LBRACK:
			{
				AST tmp53_AST_in = (AST)_t;
				match(_t,LBRACK);
				_t = _t.getNextSibling();
				variableDeclarator(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void varInitializer(AST _t) throws RecognitionException {
		
		AST varInitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			{
				AST __t19191 = _t;
				AST tmp54_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				initializer(_t);
				_t = _retTree;
				_t = __t19191;
				_t = _t.getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void parameterDef(AST _t) throws RecognitionException {
		
		AST parameterDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19186 = _t;
			AST tmp55_AST_in = (AST)_t;
			match(_t,PARAMETER_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = _retTree;
			typeSpec(_t);
			_t = _retTree;
			AST tmp56_AST_in = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			_t = __t19186;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void objectinitializer(AST _t) throws RecognitionException {
		
		AST objectinitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19188 = _t;
			AST tmp57_AST_in = (AST)_t;
			match(_t,INSTANCE_INIT);
			_t = _t.getFirstChild();
			slist(_t);
			_t = _retTree;
			_t = __t19188;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void initializer(AST _t) throws RecognitionException {
		
		AST initializer_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void expression(AST _t) throws RecognitionException {
		
		AST expression_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19257 = _t;
			AST tmp58_AST_in = (AST)_t;
			match(_t,EXPR);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			_t = __t19257;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void arrayInitializer(AST _t) throws RecognitionException {
		
		AST arrayInitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19194 = _t;
			AST tmp59_AST_in = (AST)_t;
			match(_t,ARRAY_INIT);
			_t = _t.getFirstChild();
			{
			_loop19196:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ARRAY_INIT||_t.getType()==EXPR)) {
					initializer(_t);
					_t = _retTree;
				}
				else {
					break _loop19196;
				}
				
			} while (true);
			}
			_t = __t19194;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void throwsClause(AST _t) throws RecognitionException {
		
		AST throwsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19203 = _t;
			AST tmp60_AST_in = (AST)_t;
			match(_t,TK_throws);
			_t = _t.getFirstChild();
			{
			_loop19205:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==IDENT||_t.getType()==DOT)) {
					identifier(_t);
					_t = _retTree;
				}
				else {
					break _loop19205;
				}
				
			} while (true);
			}
			_t = __t19203;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void stat(AST _t) throws RecognitionException {
		
		AST stat_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				AST __t19216 = _t;
				AST tmp61_AST_in = (AST)_t;
				match(_t,LABELED_STAT);
				_t = _t.getFirstChild();
				AST tmp62_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				stat(_t);
				_t = _retTree;
				_t = __t19216;
				_t = _t.getNextSibling();
				break;
			}
			case TK_if:
			{
				AST __t19217 = _t;
				AST tmp63_AST_in = (AST)_t;
				match(_t,TK_if);
				_t = _t.getFirstChild();
				expression(_t);
				_t = _retTree;
				stat(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case CLASS_DEF:
				case INTERFACE_DEF:
				case TK_synchronized:
				case VARIABLE_DEF:
				case SLIST:
				case LABELED_STAT:
				case TK_if:
				case TK_for:
				case TK_while:
				case TK_do:
				case TK_break:
				case TK_continue:
				case TK_return:
				case TK_switch:
				case TK_throw:
				case EMPTY_STAT:
				case TK_try:
				case EXPR:
				{
					stat(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19217;
				_t = _t.getNextSibling();
				break;
			}
			case TK_for:
			{
				AST __t19219 = _t;
				AST tmp64_AST_in = (AST)_t;
				match(_t,TK_for);
				_t = _t.getFirstChild();
				AST __t19220 = _t;
				AST tmp65_AST_in = (AST)_t;
				match(_t,FOR_INIT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19220;
				_t = _t.getNextSibling();
				AST __t19222 = _t;
				AST tmp66_AST_in = (AST)_t;
				match(_t,FOR_CONDITION);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19222;
				_t = _t.getNextSibling();
				AST __t19224 = _t;
				AST tmp67_AST_in = (AST)_t;
				match(_t,FOR_ITERATOR);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19224;
				_t = _t.getNextSibling();
				stat(_t);
				_t = _retTree;
				_t = __t19219;
				_t = _t.getNextSibling();
				break;
			}
			case TK_while:
			{
				AST __t19226 = _t;
				AST tmp68_AST_in = (AST)_t;
				match(_t,TK_while);
				_t = _t.getFirstChild();
				expression(_t);
				_t = _retTree;
				stat(_t);
				_t = _retTree;
				_t = __t19226;
				_t = _t.getNextSibling();
				break;
			}
			case TK_do:
			{
				AST __t19227 = _t;
				AST tmp69_AST_in = (AST)_t;
				match(_t,TK_do);
				_t = _t.getFirstChild();
				stat(_t);
				_t = _retTree;
				expression(_t);
				_t = _retTree;
				_t = __t19227;
				_t = _t.getNextSibling();
				break;
			}
			case TK_break:
			{
				AST __t19228 = _t;
				AST tmp70_AST_in = (AST)_t;
				match(_t,TK_break);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case IDENT:
				{
					AST tmp71_AST_in = (AST)_t;
					match(_t,IDENT);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19228;
				_t = _t.getNextSibling();
				break;
			}
			case TK_continue:
			{
				AST __t19230 = _t;
				AST tmp72_AST_in = (AST)_t;
				match(_t,TK_continue);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case IDENT:
				{
					AST tmp73_AST_in = (AST)_t;
					match(_t,IDENT);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19230;
				_t = _t.getNextSibling();
				break;
			}
			case TK_return:
			{
				AST __t19232 = _t;
				AST tmp74_AST_in = (AST)_t;
				match(_t,TK_return);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19232;
				_t = _t.getNextSibling();
				break;
			}
			case TK_switch:
			{
				AST __t19234 = _t;
				AST tmp75_AST_in = (AST)_t;
				match(_t,TK_switch);
				_t = _t.getFirstChild();
				expression(_t);
				_t = _retTree;
				{
				_loop19236:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==CASE_GROUP)) {
						caseGroup(_t);
						_t = _retTree;
					}
					else {
						break _loop19236;
					}
					
				} while (true);
				}
				_t = __t19234;
				_t = _t.getNextSibling();
				break;
			}
			case TK_throw:
			{
				AST __t19237 = _t;
				AST tmp76_AST_in = (AST)_t;
				match(_t,TK_throw);
				_t = _t.getFirstChild();
				expression(_t);
				_t = _retTree;
				_t = __t19237;
				_t = _t.getNextSibling();
				break;
			}
			case TK_synchronized:
			{
				AST __t19238 = _t;
				AST tmp77_AST_in = (AST)_t;
				match(_t,TK_synchronized);
				_t = _t.getFirstChild();
				expression(_t);
				_t = _retTree;
				stat(_t);
				_t = _retTree;
				_t = __t19238;
				_t = _t.getNextSibling();
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
				AST tmp78_AST_in = (AST)_t;
				match(_t,EMPTY_STAT);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void elist(AST _t) throws RecognitionException {
		
		AST elist_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19253 = _t;
			AST tmp79_AST_in = (AST)_t;
			match(_t,ELIST);
			_t = _t.getFirstChild();
			{
			_loop19255:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==EXPR)) {
					expression(_t);
					_t = _retTree;
				}
				else {
					break _loop19255;
				}
				
			} while (true);
			}
			_t = __t19253;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void caseGroup(AST _t) throws RecognitionException {
		
		AST caseGroup_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19240 = _t;
			AST tmp80_AST_in = (AST)_t;
			match(_t,CASE_GROUP);
			_t = _t.getFirstChild();
			{
			int _cnt19243=0;
			_loop19243:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TK_case:
				{
					AST __t19242 = _t;
					AST tmp81_AST_in = (AST)_t;
					match(_t,TK_case);
					_t = _t.getFirstChild();
					expression(_t);
					_t = _retTree;
					_t = __t19242;
					_t = _t.getNextSibling();
					break;
				}
				case TK_default:
				{
					AST tmp82_AST_in = (AST)_t;
					match(_t,TK_default);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					if ( _cnt19243>=1 ) { break _loop19243; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt19243++;
			} while (true);
			}
			slist(_t);
			_t = _retTree;
			_t = __t19240;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void tryBlock(AST _t) throws RecognitionException {
		
		AST tryBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19245 = _t;
			AST tmp83_AST_in = (AST)_t;
			match(_t,TK_try);
			_t = _t.getFirstChild();
			slist(_t);
			_t = _retTree;
			{
			_loop19247:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==TK_catch)) {
					handler(_t);
					_t = _retTree;
				}
				else {
					break _loop19247;
				}
				
			} while (true);
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TK_finally:
			{
				AST __t19249 = _t;
				AST tmp84_AST_in = (AST)_t;
				match(_t,TK_finally);
				_t = _t.getFirstChild();
				slist(_t);
				_t = _retTree;
				_t = __t19249;
				_t = _t.getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t19245;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void handler(AST _t) throws RecognitionException {
		
		AST handler_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19251 = _t;
			AST tmp85_AST_in = (AST)_t;
			match(_t,TK_catch);
			_t = _t.getFirstChild();
			parameterDef(_t);
			_t = _retTree;
			slist(_t);
			_t = _retTree;
			_t = __t19251;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void expr(AST _t) throws RecognitionException {
		
		AST expr_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case QUESTION:
			{
				AST __t19259 = _t;
				AST tmp86_AST_in = (AST)_t;
				match(_t,QUESTION);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19259;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t19260 = _t;
				AST tmp87_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19260;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS_ASSIGN:
			{
				AST __t19261 = _t;
				AST tmp88_AST_in = (AST)_t;
				match(_t,PLUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19261;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS_ASSIGN:
			{
				AST __t19262 = _t;
				AST tmp89_AST_in = (AST)_t;
				match(_t,MINUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19262;
				_t = _t.getNextSibling();
				break;
			}
			case STAR_ASSIGN:
			{
				AST __t19263 = _t;
				AST tmp90_AST_in = (AST)_t;
				match(_t,STAR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19263;
				_t = _t.getNextSibling();
				break;
			}
			case DIV_ASSIGN:
			{
				AST __t19264 = _t;
				AST tmp91_AST_in = (AST)_t;
				match(_t,DIV_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19264;
				_t = _t.getNextSibling();
				break;
			}
			case MOD_ASSIGN:
			{
				AST __t19265 = _t;
				AST tmp92_AST_in = (AST)_t;
				match(_t,MOD_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19265;
				_t = _t.getNextSibling();
				break;
			}
			case SR_ASSIGN:
			{
				AST __t19266 = _t;
				AST tmp93_AST_in = (AST)_t;
				match(_t,SR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19266;
				_t = _t.getNextSibling();
				break;
			}
			case BSR_ASSIGN:
			{
				AST __t19267 = _t;
				AST tmp94_AST_in = (AST)_t;
				match(_t,BSR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19267;
				_t = _t.getNextSibling();
				break;
			}
			case SL_ASSIGN:
			{
				AST __t19268 = _t;
				AST tmp95_AST_in = (AST)_t;
				match(_t,SL_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19268;
				_t = _t.getNextSibling();
				break;
			}
			case BAND_ASSIGN:
			{
				AST __t19269 = _t;
				AST tmp96_AST_in = (AST)_t;
				match(_t,BAND_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19269;
				_t = _t.getNextSibling();
				break;
			}
			case BXOR_ASSIGN:
			{
				AST __t19270 = _t;
				AST tmp97_AST_in = (AST)_t;
				match(_t,BXOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19270;
				_t = _t.getNextSibling();
				break;
			}
			case BOR_ASSIGN:
			{
				AST __t19271 = _t;
				AST tmp98_AST_in = (AST)_t;
				match(_t,BOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19271;
				_t = _t.getNextSibling();
				break;
			}
			case LOR:
			{
				AST __t19272 = _t;
				AST tmp99_AST_in = (AST)_t;
				match(_t,LOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19272;
				_t = _t.getNextSibling();
				break;
			}
			case LAND:
			{
				AST __t19273 = _t;
				AST tmp100_AST_in = (AST)_t;
				match(_t,LAND);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19273;
				_t = _t.getNextSibling();
				break;
			}
			case BOR:
			{
				AST __t19274 = _t;
				AST tmp101_AST_in = (AST)_t;
				match(_t,BOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19274;
				_t = _t.getNextSibling();
				break;
			}
			case BXOR:
			{
				AST __t19275 = _t;
				AST tmp102_AST_in = (AST)_t;
				match(_t,BXOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19275;
				_t = _t.getNextSibling();
				break;
			}
			case BAND:
			{
				AST __t19276 = _t;
				AST tmp103_AST_in = (AST)_t;
				match(_t,BAND);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19276;
				_t = _t.getNextSibling();
				break;
			}
			case NOT_EQUAL:
			{
				AST __t19277 = _t;
				AST tmp104_AST_in = (AST)_t;
				match(_t,NOT_EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19277;
				_t = _t.getNextSibling();
				break;
			}
			case EQUAL:
			{
				AST __t19278 = _t;
				AST tmp105_AST_in = (AST)_t;
				match(_t,EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19278;
				_t = _t.getNextSibling();
				break;
			}
			case LT:
			{
				AST __t19279 = _t;
				AST tmp106_AST_in = (AST)_t;
				match(_t,LT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19279;
				_t = _t.getNextSibling();
				break;
			}
			case GT:
			{
				AST __t19280 = _t;
				AST tmp107_AST_in = (AST)_t;
				match(_t,GT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19280;
				_t = _t.getNextSibling();
				break;
			}
			case LE:
			{
				AST __t19281 = _t;
				AST tmp108_AST_in = (AST)_t;
				match(_t,LE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19281;
				_t = _t.getNextSibling();
				break;
			}
			case GE:
			{
				AST __t19282 = _t;
				AST tmp109_AST_in = (AST)_t;
				match(_t,GE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19282;
				_t = _t.getNextSibling();
				break;
			}
			case SL:
			{
				AST __t19283 = _t;
				AST tmp110_AST_in = (AST)_t;
				match(_t,SL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19283;
				_t = _t.getNextSibling();
				break;
			}
			case SR:
			{
				AST __t19284 = _t;
				AST tmp111_AST_in = (AST)_t;
				match(_t,SR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19284;
				_t = _t.getNextSibling();
				break;
			}
			case BSR:
			{
				AST __t19285 = _t;
				AST tmp112_AST_in = (AST)_t;
				match(_t,BSR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19285;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS:
			{
				AST __t19286 = _t;
				AST tmp113_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19286;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST __t19287 = _t;
				AST tmp114_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19287;
				_t = _t.getNextSibling();
				break;
			}
			case DIV:
			{
				AST __t19288 = _t;
				AST tmp115_AST_in = (AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19288;
				_t = _t.getNextSibling();
				break;
			}
			case MOD:
			{
				AST __t19289 = _t;
				AST tmp116_AST_in = (AST)_t;
				match(_t,MOD);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19289;
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST __t19290 = _t;
				AST tmp117_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19290;
				_t = _t.getNextSibling();
				break;
			}
			case INC:
			{
				AST __t19291 = _t;
				AST tmp118_AST_in = (AST)_t;
				match(_t,INC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19291;
				_t = _t.getNextSibling();
				break;
			}
			case DEC:
			{
				AST __t19292 = _t;
				AST tmp119_AST_in = (AST)_t;
				match(_t,DEC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19292;
				_t = _t.getNextSibling();
				break;
			}
			case POST_INC:
			{
				AST __t19293 = _t;
				AST tmp120_AST_in = (AST)_t;
				match(_t,POST_INC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19293;
				_t = _t.getNextSibling();
				break;
			}
			case POST_DEC:
			{
				AST __t19294 = _t;
				AST tmp121_AST_in = (AST)_t;
				match(_t,POST_DEC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19294;
				_t = _t.getNextSibling();
				break;
			}
			case BNOT:
			{
				AST __t19295 = _t;
				AST tmp122_AST_in = (AST)_t;
				match(_t,BNOT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19295;
				_t = _t.getNextSibling();
				break;
			}
			case LNOT:
			{
				AST __t19296 = _t;
				AST tmp123_AST_in = (AST)_t;
				match(_t,LNOT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19296;
				_t = _t.getNextSibling();
				break;
			}
			case TK_instanceof:
			{
				AST __t19297 = _t;
				AST tmp124_AST_in = (AST)_t;
				match(_t,TK_instanceof);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19297;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_MINUS:
			{
				AST __t19298 = _t;
				AST tmp125_AST_in = (AST)_t;
				match(_t,UNARY_MINUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19298;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_PLUS:
			{
				AST __t19299 = _t;
				AST tmp126_AST_in = (AST)_t;
				match(_t,UNARY_PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = _retTree;
				_t = __t19299;
				_t = _t.getNextSibling();
				break;
			}
			case IDENT:
			case TYPE:
			case DOT:
			case TK_this:
			case TK_new:
			case TK_super:
			case METHOD_CALL:
			case TYPECAST:
			case TK_true:
			case TK_false:
			case TK_null:
			case CTOR_CALL:
			case SUPER_CTOR_CALL:
			case INDEX_OP:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_DOUBLE:
			case NUM_LONG:
			{
				primaryExpression(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void primaryExpression(AST _t) throws RecognitionException {
		
		AST primaryExpression_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			{
				AST tmp127_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t19301 = _t;
				AST tmp128_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case IDENT:
				case TYPE:
				case ASSIGN:
				case DOT:
				case STAR:
				case QUESTION:
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
				case LOR:
				case LAND:
				case BOR:
				case BXOR:
				case BAND:
				case NOT_EQUAL:
				case EQUAL:
				case LT:
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
				case POST_INC:
				case POST_DEC:
				case BNOT:
				case LNOT:
				case TK_instanceof:
				case UNARY_MINUS:
				case UNARY_PLUS:
				case TK_this:
				case TK_new:
				case TK_super:
				case METHOD_CALL:
				case TYPECAST:
				case TK_true:
				case TK_false:
				case TK_null:
				case CTOR_CALL:
				case SUPER_CTOR_CALL:
				case INDEX_OP:
				case NUM_INT:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case NUM_FLOAT:
				case NUM_DOUBLE:
				case NUM_LONG:
				{
					expr(_t);
					_t = _retTree;
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case IDENT:
					{
						AST tmp129_AST_in = (AST)_t;
						match(_t,IDENT);
						_t = _t.getNextSibling();
						break;
					}
					case INDEX_OP:
					{
						arrayIndex(_t);
						_t = _retTree;
						break;
					}
					case TK_this:
					{
						AST tmp130_AST_in = (AST)_t;
						match(_t,TK_this);
						_t = _t.getNextSibling();
						break;
					}
					case TK_class:
					{
						AST tmp131_AST_in = (AST)_t;
						match(_t,TK_class);
						_t = _t.getNextSibling();
						break;
					}
					case TK_new:
					{
						AST __t19304 = _t;
						AST tmp132_AST_in = (AST)_t;
						match(_t,TK_new);
						_t = _t.getFirstChild();
						AST tmp133_AST_in = (AST)_t;
						match(_t,IDENT);
						_t = _t.getNextSibling();
						elist(_t);
						_t = _retTree;
						_t = __t19304;
						_t = _t.getNextSibling();
						break;
					}
					case TK_super:
					{
						AST tmp134_AST_in = (AST)_t;
						match(_t,TK_super);
						_t = _t.getNextSibling();
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					break;
				}
				case ARRAY_DECLARATOR:
				{
					AST __t19305 = _t;
					AST tmp135_AST_in = (AST)_t;
					match(_t,ARRAY_DECLARATOR);
					_t = _t.getFirstChild();
					typeSpecArray(_t);
					_t = _retTree;
					_t = __t19305;
					_t = _t.getNextSibling();
					break;
				}
				case INT:
				case TK_void:
				case TK_boolean:
				case TK_byte:
				case TK_char:
				case TK_short:
				case TK_float:
				case TK_long:
				case TK_double:
				{
					builtInType(_t);
					_t = _retTree;
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case TK_class:
					{
						AST tmp136_AST_in = (AST)_t;
						match(_t,TK_class);
						_t = _t.getNextSibling();
						break;
					}
					case 3:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19301;
				_t = _t.getNextSibling();
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
				AST __t19307 = _t;
				AST tmp137_AST_in = (AST)_t;
				match(_t,METHOD_CALL);
				_t = _t.getFirstChild();
				primaryExpression(_t);
				_t = _retTree;
				elist(_t);
				_t = _retTree;
				_t = __t19307;
				_t = _t.getNextSibling();
				break;
			}
			case CTOR_CALL:
			case SUPER_CTOR_CALL:
			{
				ctorCall(_t);
				_t = _retTree;
				break;
			}
			case TYPECAST:
			{
				AST __t19308 = _t;
				AST tmp138_AST_in = (AST)_t;
				match(_t,TYPECAST);
				_t = _t.getFirstChild();
				typeSpec(_t);
				_t = _retTree;
				expr(_t);
				_t = _retTree;
				_t = __t19308;
				_t = _t.getNextSibling();
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
			case NUM_DOUBLE:
			case NUM_LONG:
			{
				constant(_t);
				_t = _retTree;
				break;
			}
			case TK_super:
			{
				AST tmp139_AST_in = (AST)_t;
				match(_t,TK_super);
				_t = _t.getNextSibling();
				break;
			}
			case TK_true:
			{
				AST tmp140_AST_in = (AST)_t;
				match(_t,TK_true);
				_t = _t.getNextSibling();
				break;
			}
			case TK_false:
			{
				AST tmp141_AST_in = (AST)_t;
				match(_t,TK_false);
				_t = _t.getNextSibling();
				break;
			}
			case TK_this:
			{
				AST tmp142_AST_in = (AST)_t;
				match(_t,TK_this);
				_t = _t.getNextSibling();
				break;
			}
			case TK_null:
			{
				AST tmp143_AST_in = (AST)_t;
				match(_t,TK_null);
				_t = _t.getNextSibling();
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
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void arrayIndex(AST _t) throws RecognitionException {
		
		AST arrayIndex_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19314 = _t;
			AST tmp144_AST_in = (AST)_t;
			match(_t,INDEX_OP);
			_t = _t.getFirstChild();
			expr(_t);
			_t = _retTree;
			expression(_t);
			_t = _retTree;
			_t = __t19314;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void ctorCall(AST _t) throws RecognitionException {
		
		AST ctorCall_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CTOR_CALL:
			{
				AST __t19310 = _t;
				AST tmp145_AST_in = (AST)_t;
				match(_t,CTOR_CALL);
				_t = _t.getFirstChild();
				elist(_t);
				_t = _retTree;
				_t = __t19310;
				_t = _t.getNextSibling();
				break;
			}
			case SUPER_CTOR_CALL:
			{
				AST __t19311 = _t;
				AST tmp146_AST_in = (AST)_t;
				match(_t,SUPER_CTOR_CALL);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ELIST:
				{
					elist(_t);
					_t = _retTree;
					break;
				}
				case IDENT:
				case TYPE:
				case DOT:
				case TK_this:
				case TK_new:
				case TK_super:
				case METHOD_CALL:
				case TYPECAST:
				case TK_true:
				case TK_false:
				case TK_null:
				case CTOR_CALL:
				case SUPER_CTOR_CALL:
				case INDEX_OP:
				case NUM_INT:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case NUM_FLOAT:
				case NUM_DOUBLE:
				case NUM_LONG:
				{
					primaryExpression(_t);
					_t = _retTree;
					elist(_t);
					_t = _retTree;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t19311;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void newExpression(AST _t) throws RecognitionException {
		
		AST newExpression_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19317 = _t;
			AST tmp147_AST_in = (AST)_t;
			match(_t,TK_new);
			_t = _t.getFirstChild();
			type(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARRAY_DECLARATOR:
			{
				newArrayDeclarator(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
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
					throw new NoViableAltException(_t);
				}
				}
				}
				break;
			}
			case ELIST:
			{
				elist(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case OBJBLOCK:
				{
					objBlock(_t);
					_t = _retTree;
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t19317;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void constant(AST _t) throws RecognitionException {
		
		AST constant_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case NUM_INT:
			{
				AST tmp148_AST_in = (AST)_t;
				match(_t,NUM_INT);
				_t = _t.getNextSibling();
				break;
			}
			case CHAR_LITERAL:
			{
				AST tmp149_AST_in = (AST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				break;
			}
			case STRING_LITERAL:
			{
				AST tmp150_AST_in = (AST)_t;
				match(_t,STRING_LITERAL);
				_t = _t.getNextSibling();
				break;
			}
			case NUM_FLOAT:
			{
				AST tmp151_AST_in = (AST)_t;
				match(_t,NUM_FLOAT);
				_t = _t.getNextSibling();
				break;
			}
			case NUM_DOUBLE:
			{
				AST tmp152_AST_in = (AST)_t;
				match(_t,NUM_DOUBLE);
				_t = _t.getNextSibling();
				break;
			}
			case NUM_LONG:
			{
				AST tmp153_AST_in = (AST)_t;
				match(_t,NUM_LONG);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void newArrayDeclarator(AST _t) throws RecognitionException {
		
		AST newArrayDeclarator_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t19322 = _t;
			AST tmp154_AST_in = (AST)_t;
			match(_t,ARRAY_DECLARATOR);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
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
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t19322;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"JAVADOC_OPEN",
		"JAVADOC_CLOSE",
		"\"int\"",
		"ID",
		"SEMI",
		"WS",
		"PACKAGE_DEF",
		"IMPORT",
		"CLASS_DEF",
		"IDENT",
		"INTERFACE_DEF",
		"TYPE",
		"ARRAY_DECLARATOR",
		"\"void\"",
		"\"boolean\"",
		"\"byte\"",
		"\"char\"",
		"\"short\"",
		"\"float\"",
		"\"long\"",
		"\"double\"",
		"MODIFIERS",
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
		"\"const\"",
		"\"volatile\"",
		"\"strictfp\"",
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
		"\"throws\"",
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
		"LT",
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
		"\"instanceof\"",
		"UNARY_MINUS",
		"UNARY_PLUS",
		"\"this\"",
		"\"class\"",
		"\"new\"",
		"\"super\"",
		"METHOD_CALL",
		"TYPECAST",
		"\"true\"",
		"\"false\"",
		"\"null\"",
		"CTOR_CALL",
		"SUPER_CTOR_CALL",
		"INDEX_OP",
		"NUM_INT",
		"CHAR_LITERAL",
		"STRING_LITERAL",
		"NUM_FLOAT",
		"NUM_DOUBLE",
		"NUM_LONG"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { -4071183660038991872L, 8767L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	
