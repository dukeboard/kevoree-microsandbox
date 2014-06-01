// $ANTLR 2.7.2: "java.tree.g" -> "JavaTreeParser.cs"$

	// Generate header specific to the tree-parser CSharp file
	using System;
	
	using TreeParser = antlr.TreeParser;
	using Token                    = antlr.Token;
	using AST                      = antlr.collections.AST;
	using RecognitionException     = antlr.RecognitionException;
	using ANTLRException           = antlr.ANTLRException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using BitSet                   = antlr.collections.impl.BitSet;
	using ASTPair                  = antlr.ASTPair;
	using ASTFactory               = antlr.ASTFactory;
	using ASTArray                 = antlr.collections.impl.ASTArray;
	
	
/** Java 1.3 AST Recognizer Grammar
 *
 * Author: (see java.g preamble)
 *
 * This grammar is in the PUBLIC DOMAIN
 *
 */
	public 	class JavaTreeParser : antlr.TreeParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int JAVADOC_OPEN = 4;
		public const int JAVADOC_CLOSE = 5;
		public const int INT = 6;
		public const int ID = 7;
		public const int SEMI = 8;
		public const int WS = 9;
		public const int PACKAGE_DEF = 10;
		public const int IMPORT = 11;
		public const int CLASS_DEF = 12;
		public const int IDENT = 13;
		public const int INTERFACE_DEF = 14;
		public const int TYPE = 15;
		public const int ARRAY_DECLARATOR = 16;
		public const int TK_void = 17;
		public const int TK_boolean = 18;
		public const int TK_byte = 19;
		public const int TK_char = 20;
		public const int TK_short = 21;
		public const int TK_float = 22;
		public const int TK_long = 23;
		public const int TK_double = 24;
		public const int MODIFIERS = 25;
		public const int TK_private = 26;
		public const int TK_public = 27;
		public const int TK_protected = 28;
		public const int TK_static = 29;
		public const int TK_transient = 30;
		public const int TK_final = 31;
		public const int TK_abstract = 32;
		public const int TK_native = 33;
		public const int TK_threadsafe = 34;
		public const int TK_synchronized = 35;
		public const int TK_const = 36;
		public const int TK_volatile = 37;
		public const int TK_strictfp = 38;
		public const int EXTENDS_CLAUSE = 39;
		public const int IMPLEMENTS_CLAUSE = 40;
		public const int OBJBLOCK = 41;
		public const int STATIC_INIT = 42;
		public const int INSTANCE_INIT = 43;
		public const int CTOR_DEF = 44;
		public const int METHOD_DEF = 45;
		public const int VARIABLE_DEF = 46;
		public const int PARAMETER_DEF = 47;
		public const int LBRACK = 48;
		public const int ASSIGN = 49;
		public const int ARRAY_INIT = 50;
		public const int PARAMETERS = 51;
		public const int TK_throws = 52;
		public const int DOT = 53;
		public const int STAR = 54;
		public const int SLIST = 55;
		public const int LABELED_STAT = 56;
		public const int TK_if = 57;
		public const int TK_for = 58;
		public const int FOR_INIT = 59;
		public const int FOR_CONDITION = 60;
		public const int FOR_ITERATOR = 61;
		public const int TK_while = 62;
		public const int TK_do = 63;
		public const int TK_break = 64;
		public const int TK_continue = 65;
		public const int TK_return = 66;
		public const int TK_switch = 67;
		public const int TK_throw = 68;
		public const int EMPTY_STAT = 69;
		public const int CASE_GROUP = 70;
		public const int TK_case = 71;
		public const int TK_default = 72;
		public const int TK_try = 73;
		public const int TK_finally = 74;
		public const int TK_catch = 75;
		public const int ELIST = 76;
		public const int EXPR = 77;
		public const int QUESTION = 78;
		public const int PLUS_ASSIGN = 79;
		public const int MINUS_ASSIGN = 80;
		public const int STAR_ASSIGN = 81;
		public const int DIV_ASSIGN = 82;
		public const int MOD_ASSIGN = 83;
		public const int SR_ASSIGN = 84;
		public const int BSR_ASSIGN = 85;
		public const int SL_ASSIGN = 86;
		public const int BAND_ASSIGN = 87;
		public const int BXOR_ASSIGN = 88;
		public const int BOR_ASSIGN = 89;
		public const int LOR = 90;
		public const int LAND = 91;
		public const int BOR = 92;
		public const int BXOR = 93;
		public const int BAND = 94;
		public const int NOT_EQUAL = 95;
		public const int EQUAL = 96;
		public const int LTHAN = 97;
		public const int GTHAN = 98;
		public const int LTE = 99;
		public const int GTE = 100;
		public const int SL = 101;
		public const int SR = 102;
		public const int BSR = 103;
		public const int PLUS = 104;
		public const int MINUS = 105;
		public const int DIV = 106;
		public const int MOD = 107;
		public const int INC = 108;
		public const int DEC = 109;
		public const int POST_INC = 110;
		public const int POST_DEC = 111;
		public const int BNOT = 112;
		public const int LNOT = 113;
		public const int TK_instanceof = 114;
		public const int UNARY_MINUS = 115;
		public const int UNARY_PLUS = 116;
		public const int TK_this = 117;
		public const int TK_class = 118;
		public const int TK_new = 119;
		public const int TK_super = 120;
		public const int METHOD_CALL = 121;
		public const int TYPECAST = 122;
		public const int TK_true = 123;
		public const int TK_false = 124;
		public const int TK_null = 125;
		public const int CTOR_CALL = 126;
		public const int SUPER_CTOR_CALL = 127;
		public const int INDEX_OP = 128;
		public const int NUM_INT = 129;
		public const int CHAR_LITERAL = 130;
		public const int STRING_LITERAL = 131;
		public const int NUM_FLOAT = 132;
		public const int NUM_DOUBLE = 133;
		public const int NUM_LONG = 134;
		
		public JavaTreeParser()
		{
			tokenNames = tokenNames_;
		}
		
	public void compilationUnit(AST _t) //throws RecognitionException
{
		
		AST compilationUnit_AST_in = (AST)_t;
		
		try {      // for error handling
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case PACKAGE_DEF:
				{
					packageDefinition(_t);
					_t = retTree_;
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
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==IMPORT))
					{
						importDefinition(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17691_breakloop;
					}
					
				}
_loop17691_breakloop:				;
			}    // ( ... )*
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==CLASS_DEF||_t.Type==INTERFACE_DEF))
					{
						typeDefinition(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17693_breakloop;
					}
					
				}
_loop17693_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void packageDefinition(AST _t) //throws RecognitionException
{
		
		AST packageDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17695 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,PACKAGE_DEF);
			_t = _t.getFirstChild();
			identifier(_t);
			_t = retTree_;
			_t = __t17695;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void importDefinition(AST _t) //throws RecognitionException
{
		
		AST importDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17697 = _t;
			AST tmp2_AST_in = (AST)_t;
			match(_t,IMPORT);
			_t = _t.getFirstChild();
			identifierStar(_t);
			_t = retTree_;
			_t = __t17697;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void typeDefinition(AST _t) //throws RecognitionException
{
		
		AST typeDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case CLASS_DEF:
			{
				AST __t17699 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,CLASS_DEF);
				_t = _t.getFirstChild();
				modifiers(_t);
				_t = retTree_;
				AST tmp4_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				extendsClause(_t);
				_t = retTree_;
				implementsClause(_t);
				_t = retTree_;
				objBlock(_t);
				_t = retTree_;
				_t = __t17699;
				_t = _t.getNextSibling();
				break;
			}
			case INTERFACE_DEF:
			{
				AST __t17700 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,INTERFACE_DEF);
				_t = _t.getFirstChild();
				modifiers(_t);
				_t = retTree_;
				AST tmp6_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				extendsClause(_t);
				_t = retTree_;
				interfaceBlock(_t);
				_t = retTree_;
				_t = __t17700;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void identifier(AST _t) //throws RecognitionException
{
		
		AST identifier_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case IDENT:
			{
				AST tmp7_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t17762 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				identifier(_t);
				_t = retTree_;
				AST tmp9_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				_t = __t17762;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void identifierStar(AST _t) //throws RecognitionException
{
		
		AST identifierStar_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case IDENT:
			{
				AST tmp10_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t17764 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				identifier(_t);
				_t = retTree_;
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
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
				_t = __t17764;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void modifiers(AST _t) //throws RecognitionException
{
		
		AST modifiers_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17708 = _t;
			AST tmp14_AST_in = (AST)_t;
			match(_t,MODIFIERS);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if (((_t.Type >= TK_private && _t.Type <= TK_strictfp)))
					{
						modifier(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17710_breakloop;
					}
					
				}
_loop17710_breakloop:				;
			}    // ( ... )*
			_t = __t17708;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void extendsClause(AST _t) //throws RecognitionException
{
		
		AST extendsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17713 = _t;
			AST tmp15_AST_in = (AST)_t;
			match(_t,EXTENDS_CLAUSE);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==IDENT||_t.Type==DOT))
					{
						identifier(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17715_breakloop;
					}
					
				}
_loop17715_breakloop:				;
			}    // ( ... )*
			_t = __t17713;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void implementsClause(AST _t) //throws RecognitionException
{
		
		AST implementsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17717 = _t;
			AST tmp16_AST_in = (AST)_t;
			match(_t,IMPLEMENTS_CLAUSE);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==IDENT||_t.Type==DOT))
					{
						identifier(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17719_breakloop;
					}
					
				}
_loop17719_breakloop:				;
			}    // ( ... )*
			_t = __t17717;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void objBlock(AST _t) //throws RecognitionException
{
		
		AST objBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17725 = _t;
			AST tmp17_AST_in = (AST)_t;
			match(_t,OBJBLOCK);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case CTOR_DEF:
					{
						ctorDef(_t);
						_t = retTree_;
						break;
					}
					case METHOD_DEF:
					{
						methodDef(_t);
						_t = retTree_;
						break;
					}
					case VARIABLE_DEF:
					{
						variableDef(_t);
						_t = retTree_;
						break;
					}
					case CLASS_DEF:
					case INTERFACE_DEF:
					{
						typeDefinition(_t);
						_t = retTree_;
						break;
					}
					case STATIC_INIT:
					{
						AST __t17727 = _t;
						AST tmp18_AST_in = (AST)_t;
						match(_t,STATIC_INIT);
						_t = _t.getFirstChild();
						slist(_t);
						_t = retTree_;
						_t = __t17727;
						_t = _t.getNextSibling();
						break;
					}
					case INSTANCE_INIT:
					{
						AST __t17728 = _t;
						AST tmp19_AST_in = (AST)_t;
						match(_t,INSTANCE_INIT);
						_t = _t.getFirstChild();
						slist(_t);
						_t = retTree_;
						_t = __t17728;
						_t = _t.getNextSibling();
						break;
					}
					default:
					{
						goto _loop17729_breakloop;
					}
					 }
				}
_loop17729_breakloop:				;
			}    // ( ... )*
			_t = __t17725;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void interfaceBlock(AST _t) //throws RecognitionException
{
		
		AST interfaceBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17721 = _t;
			AST tmp20_AST_in = (AST)_t;
			match(_t,OBJBLOCK);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case METHOD_DEF:
					{
						methodDecl(_t);
						_t = retTree_;
						break;
					}
					case VARIABLE_DEF:
					{
						variableDef(_t);
						_t = retTree_;
						break;
					}
					default:
					{
						goto _loop17723_breakloop;
					}
					 }
				}
_loop17723_breakloop:				;
			}    // ( ... )*
			_t = __t17721;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void typeSpec(AST _t) //throws RecognitionException
{
		
		AST typeSpec_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17702 = _t;
			AST tmp21_AST_in = (AST)_t;
			match(_t,TYPE);
			_t = _t.getFirstChild();
			typeSpecArray(_t);
			_t = retTree_;
			_t = __t17702;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void typeSpecArray(AST _t) //throws RecognitionException
{
		
		AST typeSpecArray_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case ARRAY_DECLARATOR:
			{
				AST __t17704 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,ARRAY_DECLARATOR);
				_t = _t.getFirstChild();
				typeSpecArray(_t);
				_t = retTree_;
				_t = __t17704;
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
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void type(AST _t) //throws RecognitionException
{
		
		AST type_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case IDENT:
			case DOT:
			{
				identifier(_t);
				_t = retTree_;
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
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void builtInType(AST _t) //throws RecognitionException
{
		
		AST builtInType_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void modifier(AST _t) //throws RecognitionException
{
		
		AST modifier_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void methodDecl(AST _t) //throws RecognitionException
{
		
		AST methodDecl_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17734 = _t;
			AST tmp45_AST_in = (AST)_t;
			match(_t,METHOD_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = retTree_;
			typeSpec(_t);
			_t = retTree_;
			methodHead(_t);
			_t = retTree_;
			_t = __t17734;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void variableDef(AST _t) //throws RecognitionException
{
		
		AST variableDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17739 = _t;
			AST tmp46_AST_in = (AST)_t;
			match(_t,VARIABLE_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = retTree_;
			typeSpec(_t);
			_t = retTree_;
			variableDeclarator(_t);
			_t = retTree_;
			varInitializer(_t);
			_t = retTree_;
			_t = __t17739;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void ctorDef(AST _t) //throws RecognitionException
{
		
		AST ctorDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17731 = _t;
			AST tmp47_AST_in = (AST)_t;
			match(_t,CTOR_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = retTree_;
			methodHead(_t);
			_t = retTree_;
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case SLIST:
				{
					slist(_t);
					_t = retTree_;
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
			_t = __t17731;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void methodDef(AST _t) //throws RecognitionException
{
		
		AST methodDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17736 = _t;
			AST tmp48_AST_in = (AST)_t;
			match(_t,METHOD_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = retTree_;
			typeSpec(_t);
			_t = retTree_;
			methodHead(_t);
			_t = retTree_;
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case SLIST:
				{
					slist(_t);
					_t = retTree_;
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
			_t = __t17736;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void slist(AST _t) //throws RecognitionException
{
		
		AST slist_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17767 = _t;
			AST tmp49_AST_in = (AST)_t;
			match(_t,SLIST);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((tokenSet_0_.member(_t.Type)))
					{
						stat(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17769_breakloop;
					}
					
				}
_loop17769_breakloop:				;
			}    // ( ... )*
			_t = __t17767;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void methodHead(AST _t) //throws RecognitionException
{
		
		AST methodHead_AST_in = (AST)_t;
		
		try {      // for error handling
			AST tmp50_AST_in = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			AST __t17753 = _t;
			AST tmp51_AST_in = (AST)_t;
			match(_t,PARAMETERS);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==PARAMETER_DEF))
					{
						parameterDef(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17755_breakloop;
					}
					
				}
_loop17755_breakloop:				;
			}    // ( ... )*
			_t = __t17753;
			_t = _t.getNextSibling();
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case TK_throws:
				{
					throwsClause(_t);
					_t = retTree_;
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void variableDeclarator(AST _t) //throws RecognitionException
{
		
		AST variableDeclarator_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
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
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void varInitializer(AST _t) //throws RecognitionException
{
		
		AST varInitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case ASSIGN:
			{
				AST __t17746 = _t;
				AST tmp54_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				initializer(_t);
				_t = retTree_;
				_t = __t17746;
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void parameterDef(AST _t) //throws RecognitionException
{
		
		AST parameterDef_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17741 = _t;
			AST tmp55_AST_in = (AST)_t;
			match(_t,PARAMETER_DEF);
			_t = _t.getFirstChild();
			modifiers(_t);
			_t = retTree_;
			typeSpec(_t);
			_t = retTree_;
			AST tmp56_AST_in = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			_t = __t17741;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void objectinitializer(AST _t) //throws RecognitionException
{
		
		AST objectinitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17743 = _t;
			AST tmp57_AST_in = (AST)_t;
			match(_t,INSTANCE_INIT);
			_t = _t.getFirstChild();
			slist(_t);
			_t = retTree_;
			_t = __t17743;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void initializer(AST _t) //throws RecognitionException
{
		
		AST initializer_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case EXPR:
			{
				expression(_t);
				_t = retTree_;
				break;
			}
			case ARRAY_INIT:
			{
				arrayInitializer(_t);
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void expression(AST _t) //throws RecognitionException
{
		
		AST expression_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17812 = _t;
			AST tmp58_AST_in = (AST)_t;
			match(_t,EXPR);
			_t = _t.getFirstChild();
			expr(_t);
			_t = retTree_;
			_t = __t17812;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void arrayInitializer(AST _t) //throws RecognitionException
{
		
		AST arrayInitializer_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17749 = _t;
			AST tmp59_AST_in = (AST)_t;
			match(_t,ARRAY_INIT);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==ARRAY_INIT||_t.Type==EXPR))
					{
						initializer(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17751_breakloop;
					}
					
				}
_loop17751_breakloop:				;
			}    // ( ... )*
			_t = __t17749;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void throwsClause(AST _t) //throws RecognitionException
{
		
		AST throwsClause_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17758 = _t;
			AST tmp60_AST_in = (AST)_t;
			match(_t,TK_throws);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==IDENT||_t.Type==DOT))
					{
						identifier(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17760_breakloop;
					}
					
				}
_loop17760_breakloop:				;
			}    // ( ... )*
			_t = __t17758;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void stat(AST _t) //throws RecognitionException
{
		
		AST stat_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case CLASS_DEF:
			case INTERFACE_DEF:
			{
				typeDefinition(_t);
				_t = retTree_;
				break;
			}
			case VARIABLE_DEF:
			{
				variableDef(_t);
				_t = retTree_;
				break;
			}
			case EXPR:
			{
				expression(_t);
				_t = retTree_;
				break;
			}
			case LABELED_STAT:
			{
				AST __t17771 = _t;
				AST tmp61_AST_in = (AST)_t;
				match(_t,LABELED_STAT);
				_t = _t.getFirstChild();
				AST tmp62_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				stat(_t);
				_t = retTree_;
				_t = __t17771;
				_t = _t.getNextSibling();
				break;
			}
			case TK_if:
			{
				AST __t17772 = _t;
				AST tmp63_AST_in = (AST)_t;
				match(_t,TK_if);
				_t = _t.getFirstChild();
				expression(_t);
				_t = retTree_;
				stat(_t);
				_t = retTree_;
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
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
						_t = retTree_;
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
				_t = __t17772;
				_t = _t.getNextSibling();
				break;
			}
			case TK_for:
			{
				AST __t17774 = _t;
				AST tmp64_AST_in = (AST)_t;
				match(_t,TK_for);
				_t = _t.getFirstChild();
				AST __t17775 = _t;
				AST tmp65_AST_in = (AST)_t;
				match(_t,FOR_INIT);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case VARIABLE_DEF:
					{
						variableDef(_t);
						_t = retTree_;
						break;
					}
					case ELIST:
					{
						elist(_t);
						_t = retTree_;
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
				_t = __t17775;
				_t = _t.getNextSibling();
				AST __t17777 = _t;
				AST tmp66_AST_in = (AST)_t;
				match(_t,FOR_CONDITION);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case EXPR:
					{
						expression(_t);
						_t = retTree_;
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
				_t = __t17777;
				_t = _t.getNextSibling();
				AST __t17779 = _t;
				AST tmp67_AST_in = (AST)_t;
				match(_t,FOR_ITERATOR);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case ELIST:
					{
						elist(_t);
						_t = retTree_;
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
				_t = __t17779;
				_t = _t.getNextSibling();
				stat(_t);
				_t = retTree_;
				_t = __t17774;
				_t = _t.getNextSibling();
				break;
			}
			case TK_while:
			{
				AST __t17781 = _t;
				AST tmp68_AST_in = (AST)_t;
				match(_t,TK_while);
				_t = _t.getFirstChild();
				expression(_t);
				_t = retTree_;
				stat(_t);
				_t = retTree_;
				_t = __t17781;
				_t = _t.getNextSibling();
				break;
			}
			case TK_do:
			{
				AST __t17782 = _t;
				AST tmp69_AST_in = (AST)_t;
				match(_t,TK_do);
				_t = _t.getFirstChild();
				stat(_t);
				_t = retTree_;
				expression(_t);
				_t = retTree_;
				_t = __t17782;
				_t = _t.getNextSibling();
				break;
			}
			case TK_break:
			{
				AST __t17783 = _t;
				AST tmp70_AST_in = (AST)_t;
				match(_t,TK_break);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
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
				_t = __t17783;
				_t = _t.getNextSibling();
				break;
			}
			case TK_continue:
			{
				AST __t17785 = _t;
				AST tmp72_AST_in = (AST)_t;
				match(_t,TK_continue);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
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
				_t = __t17785;
				_t = _t.getNextSibling();
				break;
			}
			case TK_return:
			{
				AST __t17787 = _t;
				AST tmp74_AST_in = (AST)_t;
				match(_t,TK_return);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case EXPR:
					{
						expression(_t);
						_t = retTree_;
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
				_t = __t17787;
				_t = _t.getNextSibling();
				break;
			}
			case TK_switch:
			{
				AST __t17789 = _t;
				AST tmp75_AST_in = (AST)_t;
				match(_t,TK_switch);
				_t = _t.getFirstChild();
				expression(_t);
				_t = retTree_;
				{    // ( ... )*
					for (;;)
					{
						if (_t == null)
							_t = ASTNULL;
						if ((_t.Type==CASE_GROUP))
						{
							caseGroup(_t);
							_t = retTree_;
						}
						else
						{
							goto _loop17791_breakloop;
						}
						
					}
_loop17791_breakloop:					;
				}    // ( ... )*
				_t = __t17789;
				_t = _t.getNextSibling();
				break;
			}
			case TK_throw:
			{
				AST __t17792 = _t;
				AST tmp76_AST_in = (AST)_t;
				match(_t,TK_throw);
				_t = _t.getFirstChild();
				expression(_t);
				_t = retTree_;
				_t = __t17792;
				_t = _t.getNextSibling();
				break;
			}
			case TK_synchronized:
			{
				AST __t17793 = _t;
				AST tmp77_AST_in = (AST)_t;
				match(_t,TK_synchronized);
				_t = _t.getFirstChild();
				expression(_t);
				_t = retTree_;
				stat(_t);
				_t = retTree_;
				_t = __t17793;
				_t = _t.getNextSibling();
				break;
			}
			case TK_try:
			{
				tryBlock(_t);
				_t = retTree_;
				break;
			}
			case SLIST:
			{
				slist(_t);
				_t = retTree_;
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void elist(AST _t) //throws RecognitionException
{
		
		AST elist_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17808 = _t;
			AST tmp79_AST_in = (AST)_t;
			match(_t,ELIST);
			_t = _t.getFirstChild();
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==EXPR))
					{
						expression(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17810_breakloop;
					}
					
				}
_loop17810_breakloop:				;
			}    // ( ... )*
			_t = __t17808;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void caseGroup(AST _t) //throws RecognitionException
{
		
		AST caseGroup_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17795 = _t;
			AST tmp80_AST_in = (AST)_t;
			match(_t,CASE_GROUP);
			_t = _t.getFirstChild();
			{ // ( ... )+
			int _cnt17798=0;
			for (;;)
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case TK_case:
				{
					AST __t17797 = _t;
					AST tmp81_AST_in = (AST)_t;
					match(_t,TK_case);
					_t = _t.getFirstChild();
					expression(_t);
					_t = retTree_;
					_t = __t17797;
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
					if (_cnt17798 >= 1) { goto _loop17798_breakloop; } else { throw new NoViableAltException(_t);; }
				}
				break; }
				_cnt17798++;
			}
_loop17798_breakloop:			;
			}    // ( ... )+
			slist(_t);
			_t = retTree_;
			_t = __t17795;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void tryBlock(AST _t) //throws RecognitionException
{
		
		AST tryBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17800 = _t;
			AST tmp83_AST_in = (AST)_t;
			match(_t,TK_try);
			_t = _t.getFirstChild();
			slist(_t);
			_t = retTree_;
			{    // ( ... )*
				for (;;)
				{
					if (_t == null)
						_t = ASTNULL;
					if ((_t.Type==TK_catch))
					{
						handler(_t);
						_t = retTree_;
					}
					else
					{
						goto _loop17802_breakloop;
					}
					
				}
_loop17802_breakloop:				;
			}    // ( ... )*
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case TK_finally:
				{
					AST __t17804 = _t;
					AST tmp84_AST_in = (AST)_t;
					match(_t,TK_finally);
					_t = _t.getFirstChild();
					slist(_t);
					_t = retTree_;
					_t = __t17804;
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
			_t = __t17800;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void handler(AST _t) //throws RecognitionException
{
		
		AST handler_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17806 = _t;
			AST tmp85_AST_in = (AST)_t;
			match(_t,TK_catch);
			_t = _t.getFirstChild();
			parameterDef(_t);
			_t = retTree_;
			slist(_t);
			_t = retTree_;
			_t = __t17806;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void expr(AST _t) //throws RecognitionException
{
		
		AST expr_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case QUESTION:
			{
				AST __t17814 = _t;
				AST tmp86_AST_in = (AST)_t;
				match(_t,QUESTION);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17814;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t17815 = _t;
				AST tmp87_AST_in = (AST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17815;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS_ASSIGN:
			{
				AST __t17816 = _t;
				AST tmp88_AST_in = (AST)_t;
				match(_t,PLUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17816;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS_ASSIGN:
			{
				AST __t17817 = _t;
				AST tmp89_AST_in = (AST)_t;
				match(_t,MINUS_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17817;
				_t = _t.getNextSibling();
				break;
			}
			case STAR_ASSIGN:
			{
				AST __t17818 = _t;
				AST tmp90_AST_in = (AST)_t;
				match(_t,STAR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17818;
				_t = _t.getNextSibling();
				break;
			}
			case DIV_ASSIGN:
			{
				AST __t17819 = _t;
				AST tmp91_AST_in = (AST)_t;
				match(_t,DIV_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17819;
				_t = _t.getNextSibling();
				break;
			}
			case MOD_ASSIGN:
			{
				AST __t17820 = _t;
				AST tmp92_AST_in = (AST)_t;
				match(_t,MOD_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17820;
				_t = _t.getNextSibling();
				break;
			}
			case SR_ASSIGN:
			{
				AST __t17821 = _t;
				AST tmp93_AST_in = (AST)_t;
				match(_t,SR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17821;
				_t = _t.getNextSibling();
				break;
			}
			case BSR_ASSIGN:
			{
				AST __t17822 = _t;
				AST tmp94_AST_in = (AST)_t;
				match(_t,BSR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17822;
				_t = _t.getNextSibling();
				break;
			}
			case SL_ASSIGN:
			{
				AST __t17823 = _t;
				AST tmp95_AST_in = (AST)_t;
				match(_t,SL_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17823;
				_t = _t.getNextSibling();
				break;
			}
			case BAND_ASSIGN:
			{
				AST __t17824 = _t;
				AST tmp96_AST_in = (AST)_t;
				match(_t,BAND_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17824;
				_t = _t.getNextSibling();
				break;
			}
			case BXOR_ASSIGN:
			{
				AST __t17825 = _t;
				AST tmp97_AST_in = (AST)_t;
				match(_t,BXOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17825;
				_t = _t.getNextSibling();
				break;
			}
			case BOR_ASSIGN:
			{
				AST __t17826 = _t;
				AST tmp98_AST_in = (AST)_t;
				match(_t,BOR_ASSIGN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17826;
				_t = _t.getNextSibling();
				break;
			}
			case LOR:
			{
				AST __t17827 = _t;
				AST tmp99_AST_in = (AST)_t;
				match(_t,LOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17827;
				_t = _t.getNextSibling();
				break;
			}
			case LAND:
			{
				AST __t17828 = _t;
				AST tmp100_AST_in = (AST)_t;
				match(_t,LAND);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17828;
				_t = _t.getNextSibling();
				break;
			}
			case BOR:
			{
				AST __t17829 = _t;
				AST tmp101_AST_in = (AST)_t;
				match(_t,BOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17829;
				_t = _t.getNextSibling();
				break;
			}
			case BXOR:
			{
				AST __t17830 = _t;
				AST tmp102_AST_in = (AST)_t;
				match(_t,BXOR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17830;
				_t = _t.getNextSibling();
				break;
			}
			case BAND:
			{
				AST __t17831 = _t;
				AST tmp103_AST_in = (AST)_t;
				match(_t,BAND);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17831;
				_t = _t.getNextSibling();
				break;
			}
			case NOT_EQUAL:
			{
				AST __t17832 = _t;
				AST tmp104_AST_in = (AST)_t;
				match(_t,NOT_EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17832;
				_t = _t.getNextSibling();
				break;
			}
			case EQUAL:
			{
				AST __t17833 = _t;
				AST tmp105_AST_in = (AST)_t;
				match(_t,EQUAL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17833;
				_t = _t.getNextSibling();
				break;
			}
			case LTHAN:
			{
				AST __t17834 = _t;
				AST tmp106_AST_in = (AST)_t;
				match(_t,LTHAN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17834;
				_t = _t.getNextSibling();
				break;
			}
			case GTHAN:
			{
				AST __t17835 = _t;
				AST tmp107_AST_in = (AST)_t;
				match(_t,GTHAN);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17835;
				_t = _t.getNextSibling();
				break;
			}
			case LTE:
			{
				AST __t17836 = _t;
				AST tmp108_AST_in = (AST)_t;
				match(_t,LTE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17836;
				_t = _t.getNextSibling();
				break;
			}
			case GTE:
			{
				AST __t17837 = _t;
				AST tmp109_AST_in = (AST)_t;
				match(_t,GTE);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17837;
				_t = _t.getNextSibling();
				break;
			}
			case SL:
			{
				AST __t17838 = _t;
				AST tmp110_AST_in = (AST)_t;
				match(_t,SL);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17838;
				_t = _t.getNextSibling();
				break;
			}
			case SR:
			{
				AST __t17839 = _t;
				AST tmp111_AST_in = (AST)_t;
				match(_t,SR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17839;
				_t = _t.getNextSibling();
				break;
			}
			case BSR:
			{
				AST __t17840 = _t;
				AST tmp112_AST_in = (AST)_t;
				match(_t,BSR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17840;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS:
			{
				AST __t17841 = _t;
				AST tmp113_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17841;
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST __t17842 = _t;
				AST tmp114_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17842;
				_t = _t.getNextSibling();
				break;
			}
			case DIV:
			{
				AST __t17843 = _t;
				AST tmp115_AST_in = (AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17843;
				_t = _t.getNextSibling();
				break;
			}
			case MOD:
			{
				AST __t17844 = _t;
				AST tmp116_AST_in = (AST)_t;
				match(_t,MOD);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17844;
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST __t17845 = _t;
				AST tmp117_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17845;
				_t = _t.getNextSibling();
				break;
			}
			case INC:
			{
				AST __t17846 = _t;
				AST tmp118_AST_in = (AST)_t;
				match(_t,INC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17846;
				_t = _t.getNextSibling();
				break;
			}
			case DEC:
			{
				AST __t17847 = _t;
				AST tmp119_AST_in = (AST)_t;
				match(_t,DEC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17847;
				_t = _t.getNextSibling();
				break;
			}
			case POST_INC:
			{
				AST __t17848 = _t;
				AST tmp120_AST_in = (AST)_t;
				match(_t,POST_INC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17848;
				_t = _t.getNextSibling();
				break;
			}
			case POST_DEC:
			{
				AST __t17849 = _t;
				AST tmp121_AST_in = (AST)_t;
				match(_t,POST_DEC);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17849;
				_t = _t.getNextSibling();
				break;
			}
			case BNOT:
			{
				AST __t17850 = _t;
				AST tmp122_AST_in = (AST)_t;
				match(_t,BNOT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17850;
				_t = _t.getNextSibling();
				break;
			}
			case LNOT:
			{
				AST __t17851 = _t;
				AST tmp123_AST_in = (AST)_t;
				match(_t,LNOT);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17851;
				_t = _t.getNextSibling();
				break;
			}
			case TK_instanceof:
			{
				AST __t17852 = _t;
				AST tmp124_AST_in = (AST)_t;
				match(_t,TK_instanceof);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17852;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_MINUS:
			{
				AST __t17853 = _t;
				AST tmp125_AST_in = (AST)_t;
				match(_t,UNARY_MINUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17853;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_PLUS:
			{
				AST __t17854 = _t;
				AST tmp126_AST_in = (AST)_t;
				match(_t,UNARY_PLUS);
				_t = _t.getFirstChild();
				expr(_t);
				_t = retTree_;
				_t = __t17854;
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
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void primaryExpression(AST _t) //throws RecognitionException
{
		
		AST primaryExpression_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case IDENT:
			{
				AST tmp127_AST_in = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				break;
			}
			case DOT:
			{
				AST __t17856 = _t;
				AST tmp128_AST_in = (AST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
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
					case LTHAN:
					case GTHAN:
					case LTE:
					case GTE:
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
						_t = retTree_;
						{
							if (null == _t)
								_t = ASTNULL;
							switch ( _t.Type )
							{
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
								_t = retTree_;
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
								AST __t17859 = _t;
								AST tmp132_AST_in = (AST)_t;
								match(_t,TK_new);
								_t = _t.getFirstChild();
								AST tmp133_AST_in = (AST)_t;
								match(_t,IDENT);
								_t = _t.getNextSibling();
								elist(_t);
								_t = retTree_;
								_t = __t17859;
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
						AST __t17860 = _t;
						AST tmp135_AST_in = (AST)_t;
						match(_t,ARRAY_DECLARATOR);
						_t = _t.getFirstChild();
						typeSpecArray(_t);
						_t = retTree_;
						_t = __t17860;
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
						_t = retTree_;
						{
							if (null == _t)
								_t = ASTNULL;
							switch ( _t.Type )
							{
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
				_t = __t17856;
				_t = _t.getNextSibling();
				break;
			}
			case INDEX_OP:
			{
				arrayIndex(_t);
				_t = retTree_;
				break;
			}
			case METHOD_CALL:
			{
				AST __t17862 = _t;
				AST tmp137_AST_in = (AST)_t;
				match(_t,METHOD_CALL);
				_t = _t.getFirstChild();
				primaryExpression(_t);
				_t = retTree_;
				elist(_t);
				_t = retTree_;
				_t = __t17862;
				_t = _t.getNextSibling();
				break;
			}
			case CTOR_CALL:
			case SUPER_CTOR_CALL:
			{
				ctorCall(_t);
				_t = retTree_;
				break;
			}
			case TYPECAST:
			{
				AST __t17863 = _t;
				AST tmp138_AST_in = (AST)_t;
				match(_t,TYPECAST);
				_t = _t.getFirstChild();
				typeSpec(_t);
				_t = retTree_;
				expr(_t);
				_t = retTree_;
				_t = __t17863;
				_t = _t.getNextSibling();
				break;
			}
			case TK_new:
			{
				newExpression(_t);
				_t = retTree_;
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
				_t = retTree_;
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
				_t = retTree_;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void arrayIndex(AST _t) //throws RecognitionException
{
		
		AST arrayIndex_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17869 = _t;
			AST tmp144_AST_in = (AST)_t;
			match(_t,INDEX_OP);
			_t = _t.getFirstChild();
			expr(_t);
			_t = retTree_;
			expression(_t);
			_t = retTree_;
			_t = __t17869;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void ctorCall(AST _t) //throws RecognitionException
{
		
		AST ctorCall_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
			case CTOR_CALL:
			{
				AST __t17865 = _t;
				AST tmp145_AST_in = (AST)_t;
				match(_t,CTOR_CALL);
				_t = _t.getFirstChild();
				elist(_t);
				_t = retTree_;
				_t = __t17865;
				_t = _t.getNextSibling();
				break;
			}
			case SUPER_CTOR_CALL:
			{
				AST __t17866 = _t;
				AST tmp146_AST_in = (AST)_t;
				match(_t,SUPER_CTOR_CALL);
				_t = _t.getFirstChild();
				{
					if (null == _t)
						_t = ASTNULL;
					switch ( _t.Type )
					{
					case ELIST:
					{
						elist(_t);
						_t = retTree_;
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
						_t = retTree_;
						elist(_t);
						_t = retTree_;
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					 }
				}
				_t = __t17866;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void newExpression(AST _t) //throws RecognitionException
{
		
		AST newExpression_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17872 = _t;
			AST tmp147_AST_in = (AST)_t;
			match(_t,TK_new);
			_t = _t.getFirstChild();
			type(_t);
			_t = retTree_;
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case ARRAY_DECLARATOR:
				{
					newArrayDeclarator(_t);
					_t = retTree_;
					{
						if (null == _t)
							_t = ASTNULL;
						switch ( _t.Type )
						{
						case ARRAY_INIT:
						{
							arrayInitializer(_t);
							_t = retTree_;
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
					_t = retTree_;
					{
						if (null == _t)
							_t = ASTNULL;
						switch ( _t.Type )
						{
						case OBJBLOCK:
						{
							objBlock(_t);
							_t = retTree_;
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
			_t = __t17872;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void constant(AST _t) //throws RecognitionException
{
		
		AST constant_AST_in = (AST)_t;
		
		try {      // for error handling
			if (null == _t)
				_t = ASTNULL;
			switch ( _t.Type )
			{
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	public void newArrayDeclarator(AST _t) //throws RecognitionException
{
		
		AST newArrayDeclarator_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t17877 = _t;
			AST tmp154_AST_in = (AST)_t;
			match(_t,ARRAY_DECLARATOR);
			_t = _t.getFirstChild();
			{
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case ARRAY_DECLARATOR:
				{
					newArrayDeclarator(_t);
					_t = retTree_;
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
				if (null == _t)
					_t = ASTNULL;
				switch ( _t.Type )
				{
				case EXPR:
				{
					expression(_t);
					_t = retTree_;
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
			_t = __t17877;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			if (null != _t)
			{
				_t = _t.getNextSibling();
			}
		}
		retTree_ = _t;
	}
	
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""JAVADOC_OPEN""",
		@"""JAVADOC_CLOSE""",
		@"""int""",
		@"""ID""",
		@"""SEMI""",
		@"""WS""",
		@"""PACKAGE_DEF""",
		@"""IMPORT""",
		@"""CLASS_DEF""",
		@"""IDENT""",
		@"""INTERFACE_DEF""",
		@"""TYPE""",
		@"""ARRAY_DECLARATOR""",
		@"""void""",
		@"""boolean""",
		@"""byte""",
		@"""char""",
		@"""short""",
		@"""float""",
		@"""long""",
		@"""double""",
		@"""MODIFIERS""",
		@"""private""",
		@"""public""",
		@"""protected""",
		@"""static""",
		@"""transient""",
		@"""final""",
		@"""abstract""",
		@"""native""",
		@"""threadsafe""",
		@"""synchronized""",
		@"""const""",
		@"""volatile""",
		@"""strictfp""",
		@"""EXTENDS_CLAUSE""",
		@"""IMPLEMENTS_CLAUSE""",
		@"""OBJBLOCK""",
		@"""STATIC_INIT""",
		@"""INSTANCE_INIT""",
		@"""CTOR_DEF""",
		@"""METHOD_DEF""",
		@"""VARIABLE_DEF""",
		@"""PARAMETER_DEF""",
		@"""LBRACK""",
		@"""ASSIGN""",
		@"""ARRAY_INIT""",
		@"""PARAMETERS""",
		@"""throws""",
		@"""DOT""",
		@"""STAR""",
		@"""SLIST""",
		@"""LABELED_STAT""",
		@"""if""",
		@"""for""",
		@"""FOR_INIT""",
		@"""FOR_CONDITION""",
		@"""FOR_ITERATOR""",
		@"""while""",
		@"""do""",
		@"""break""",
		@"""continue""",
		@"""return""",
		@"""switch""",
		@"""throw""",
		@"""EMPTY_STAT""",
		@"""CASE_GROUP""",
		@"""case""",
		@"""default""",
		@"""try""",
		@"""finally""",
		@"""catch""",
		@"""ELIST""",
		@"""EXPR""",
		@"""QUESTION""",
		@"""PLUS_ASSIGN""",
		@"""MINUS_ASSIGN""",
		@"""STAR_ASSIGN""",
		@"""DIV_ASSIGN""",
		@"""MOD_ASSIGN""",
		@"""SR_ASSIGN""",
		@"""BSR_ASSIGN""",
		@"""SL_ASSIGN""",
		@"""BAND_ASSIGN""",
		@"""BXOR_ASSIGN""",
		@"""BOR_ASSIGN""",
		@"""LOR""",
		@"""LAND""",
		@"""BOR""",
		@"""BXOR""",
		@"""BAND""",
		@"""NOT_EQUAL""",
		@"""EQUAL""",
		@"""LTHAN""",
		@"""GTHAN""",
		@"""LTE""",
		@"""GTE""",
		@"""SL""",
		@"""SR""",
		@"""BSR""",
		@"""PLUS""",
		@"""MINUS""",
		@"""DIV""",
		@"""MOD""",
		@"""INC""",
		@"""DEC""",
		@"""POST_INC""",
		@"""POST_DEC""",
		@"""BNOT""",
		@"""LNOT""",
		@"""instanceof""",
		@"""UNARY_MINUS""",
		@"""UNARY_PLUS""",
		@"""this""",
		@"""class""",
		@"""new""",
		@"""super""",
		@"""METHOD_CALL""",
		@"""TYPECAST""",
		@"""true""",
		@"""false""",
		@"""null""",
		@"""CTOR_CALL""",
		@"""SUPER_CTOR_CALL""",
		@"""INDEX_OP""",
		@"""NUM_INT""",
		@"""CHAR_LITERAL""",
		@"""STRING_LITERAL""",
		@"""NUM_FLOAT""",
		@"""NUM_DOUBLE""",
		@"""NUM_LONG"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { -4071183660038991872L, 8767L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
}

