// $ANTLR 2.7.2: "idl.g" -> "IDLParser.cs"$

	// Generate the header common to all output files.
	using System;
	
	using TokenBuffer              = antlr.TokenBuffer;
	using TokenStreamException     = antlr.TokenStreamException;
	using TokenStreamIOException   = antlr.TokenStreamIOException;
	using ANTLRException           = antlr.ANTLRException;
	using LLkParser = antlr.LLkParser;
	using Token                    = antlr.Token;
	using TokenStream              = antlr.TokenStream;
	using RecognitionException     = antlr.RecognitionException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using ParserSharedInputState   = antlr.ParserSharedInputState;
	using BitSet                   = antlr.collections.impl.BitSet;
	
/**
 *  This is a complete parser for the IDL language as defined
 *  by the CORBA 2.0 specification.  It will allow those who
 *  need an IDL parser to get up-and-running very quickly.
 *  Though IDL's syntax is very similar to C++, it is also
 *  much simpler, due in large part to the fact that it is
 *  a declarative-only language.
 *  
 *  Some things that are not included are: Symbol table construction
 *  (it is not necessary for parsing, btw) and preprocessing (for
 *  IDL compiler #pragma directives). You can use just about any
 *  C or C++ preprocessor, but there is an interesting semantic
 *  issue if you are going to generate code: In C, #include is
 *  a literal include, in IDL, #include is more like Java's import:
 *  It adds definitions to the scope of the parse, but included
 *  definitions are not generated.
 *
 *  Jim Coker, jcoker@magelang.com
 */
	public 	class IDLParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int SEMI = 4;
		public const int TK_module = 5;
		public const int LCURLY = 6;
		public const int RCURLY = 7;
		public const int TK_interface = 8;
		public const int COLON = 9;
		public const int COMMA = 10;
		public const int SCOPEOP = 11;
		public const int TK_const = 12;
		public const int ASSIGN = 13;
		public const int OR = 14;
		public const int XOR = 15;
		public const int AND = 16;
		public const int LSHIFT = 17;
		public const int RSHIFT = 18;
		public const int PLUS = 19;
		public const int MINUS = 20;
		public const int STAR = 21;
		public const int DIV = 22;
		public const int MOD = 23;
		public const int TILDE = 24;
		public const int LPAREN = 25;
		public const int RPAREN = 26;
		public const int TK_TRUE = 27;
		public const int TK_FALSE = 28;
		public const int TK_typedef = 29;
		public const int TK_native = 30;
		public const int TK_octet = 31;
		public const int TK_any = 32;
		public const int TK_unsigned = 33;
		public const int TK_short = 34;
		public const int TK_long = 35;
		public const int TK_char = 36;
		public const int TK_float = 37;
		public const int TK_double = 38;
		public const int TK_boolean = 39;
		public const int TK_struct = 40;
		public const int TK_union = 41;
		public const int TK_switch = 42;
		public const int TK_case = 43;
		public const int TK_default = 44;
		public const int TK_enum = 45;
		public const int TK_sequence = 46;
		public const int LTHAN = 47;
		public const int GTHAN = 48;
		public const int TK_string = 49;
		public const int LBRACK = 50;
		public const int RBRACK = 51;
		public const int TK_readonly = 52;
		public const int TK_attribute = 53;
		public const int TK_exception = 54;
		public const int TK_oneway = 55;
		public const int TK_void = 56;
		public const int TK_in = 57;
		public const int TK_out = 58;
		public const int TK_inout = 59;
		public const int TK_raises = 60;
		public const int TK_context = 61;
		public const int INT = 62;
		public const int OCTAL = 63;
		public const int HEX = 64;
		public const int STRING_LITERAL = 65;
		public const int CHAR_LITERAL = 66;
		public const int FLOAT = 67;
		public const int IDENT = 68;
		public const int QUESTION = 69;
		public const int DOT = 70;
		public const int NOT = 71;
		public const int WS = 72;
		public const int PREPROC_DIRECTIVE = 73;
		public const int SL_COMMENT = 74;
		public const int ML_COMMENT = 75;
		public const int ESC = 76;
		public const int VOCAB = 77;
		public const int DIGIT = 78;
		public const int OCTDIGIT = 79;
		public const int HEXDIGIT = 80;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected IDLParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public IDLParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected IDLParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public IDLParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public IDLParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public void specification() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22129=0;
			for (;;)
			{
				if ((tokenSet_0_.member(LA(1))))
				{
					definition();
				}
				else
				{
					if (_cnt22129 >= 1) { goto _loop22129_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22129++;
			}
_loop22129_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_1_);
		}
	}
	
	public void definition() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_2_);
		}
	}
	
	public void type_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void const_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_const);
			const_type();
			identifier();
			match(ASSIGN);
			const_exp();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void except_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_exception);
			identifier();
			match(LCURLY);
			opt_member_list();
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void interf() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_interface);
			identifier();
			inheritance_spec();
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void module() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_module);
			identifier();
			match(LCURLY);
			definition_list();
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void identifier() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(IDENT);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_4_);
		}
	}
	
	public void definition_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22135=0;
			for (;;)
			{
				if ((tokenSet_0_.member(LA(1))))
				{
					definition();
				}
				else
				{
					if (_cnt22135 >= 1) { goto _loop22135_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22135++;
			}
_loop22135_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void inheritance_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_6_);
		}
	}
	
	public void interface_body() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(LCURLY);
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_7_.member(LA(1))))
					{
						export();
					}
					else
					{
						goto _loop22140_breakloop;
					}
					
				}
_loop22140_breakloop:				;
			}    // ( ... )*
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void export() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_8_);
		}
	}
	
	public void attr_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			match(TK_attribute);
			param_type_spec();
			simple_declarator_list();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void op_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			op_attribute();
			op_type_spec();
			identifier();
			parameter_dcls();
			opt_raises_expr();
			opt_context_expr();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void scoped_name_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			scoped_name();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						scoped_name();
					}
					else
					{
						goto _loop22146_breakloop;
					}
					
				}
_loop22146_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_9_);
		}
	}
	
	public void scoped_name() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			opt_scope_op();
			identifier();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==SCOPEOP))
					{
						match(SCOPEOP);
						identifier();
					}
					else
					{
						goto _loop22149_breakloop;
					}
					
				}
_loop22149_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_10_);
		}
	}
	
	public void opt_scope_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void const_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void const_exp() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			or_expr();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_12_);
		}
	}
	
	public void integer_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_13_);
		}
	}
	
	public void char_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_char);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_13_);
		}
	}
	
	public void boolean_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_boolean);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_13_);
		}
	}
	
	public void floating_pt_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void string_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_string);
			opt_pos_int_br();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void or_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			xor_expr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==OR))
					{
						or_op();
						xor_expr();
					}
					else
					{
						goto _loop22156_breakloop;
					}
					
				}
_loop22156_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_12_);
		}
	}
	
	public void xor_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			and_expr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==XOR))
					{
						xor_op();
						and_expr();
					}
					else
					{
						goto _loop22160_breakloop;
					}
					
				}
_loop22160_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_15_);
		}
	}
	
	public void or_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(OR);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void and_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			shift_expr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==AND))
					{
						and_op();
						shift_expr();
					}
					else
					{
						goto _loop22164_breakloop;
					}
					
				}
_loop22164_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_17_);
		}
	}
	
	public void xor_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(XOR);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void shift_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			add_expr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==LSHIFT||LA(1)==RSHIFT))
					{
						shift_op();
						add_expr();
					}
					else
					{
						goto _loop22168_breakloop;
					}
					
				}
_loop22168_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_18_);
		}
	}
	
	public void and_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(AND);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void add_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			mult_expr();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==PLUS||LA(1)==MINUS))
					{
						add_op();
						mult_expr();
					}
					else
					{
						goto _loop22172_breakloop;
					}
					
				}
_loop22172_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_19_);
		}
	}
	
	public void shift_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void mult_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			unary_expr();
			{    // ( ... )*
				for (;;)
				{
					if (((LA(1) >= STAR && LA(1) <= MOD)))
					{
						mult_op();
						unary_expr();
					}
					else
					{
						goto _loop22176_breakloop;
					}
					
				}
_loop22176_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_20_);
		}
	}
	
	public void add_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void unary_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void mult_op() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_16_);
		}
	}
	
	public void unary_operator() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_22_);
		}
	}
	
	public void primary_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void literal() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void integer_literal() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void string_literal() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22266=0;
			for (;;)
			{
				if ((LA(1)==STRING_LITERAL))
				{
					match(STRING_LITERAL);
				}
				else
				{
					if (_cnt22266 >= 1) { goto _loop22266_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22266++;
			}
_loop22266_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_23_);
		}
	}
	
	public void character_literal() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(CHAR_LITERAL);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void floating_pt_literal() //throws RecognitionException, TokenStreamException
{
		
		Token  f = null;
		
		try {      // for error handling
			f = LT(1);
			match(FLOAT);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void boolean_literal() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_21_);
		}
	}
	
	public void positive_int_const() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			const_exp();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_24_);
		}
	}
	
	public void type_declarator() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			type_spec();
			declarators();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void struct_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_struct);
			identifier();
			match(LCURLY);
			member_list();
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_25_);
		}
	}
	
	public void union_type() //throws RecognitionException, TokenStreamException
{
		
		
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
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_25_);
		}
	}
	
	public void enum_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_enum);
			identifier();
			match(LCURLY);
			enumerator_list();
			match(RCURLY);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_26_);
		}
	}
	
	public void simple_declarator() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			identifier();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_27_);
		}
	}
	
	public void type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void declarators() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			declarator();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						declarator();
					}
					else
					{
						goto _loop22199_breakloop;
					}
					
				}
_loop22199_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void simple_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void constr_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void base_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void template_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void sequence_type() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_sequence);
			match(LTHAN);
			simple_type_spec();
			opt_pos_int();
			match(GTHAN);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void declarator() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			identifier();
			opt_fixed_array_size();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_28_);
		}
	}
	
	public void opt_fixed_array_size() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==LBRACK))
					{
						fixed_array_size();
					}
					else
					{
						goto _loop22203_breakloop;
					}
					
				}
_loop22203_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_28_);
		}
	}
	
	public void fixed_array_size() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(LBRACK);
			positive_int_const();
			match(RBRACK);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_29_);
		}
	}
	
	public void member_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22208=0;
			for (;;)
			{
				if ((tokenSet_30_.member(LA(1))))
				{
					member();
				}
				else
				{
					if (_cnt22208 >= 1) { goto _loop22208_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22208++;
			}
_loop22208_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void member() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			type_spec();
			declarators();
			match(SEMI);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_31_);
		}
	}
	
	public void switch_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_32_);
		}
	}
	
	public void switch_body() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			case_stmt_list();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void case_stmt_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22215=0;
			for (;;)
			{
				if ((LA(1)==TK_case||LA(1)==TK_default))
				{
					case_stmt();
				}
				else
				{
					if (_cnt22215 >= 1) { goto _loop22215_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22215++;
			}
_loop22215_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void case_stmt() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			case_label_list();
			element_spec();
			match(SEMI);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_33_);
		}
	}
	
	public void case_label_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{ // ( ... )+
			int _cnt22219=0;
			for (;;)
			{
				if ((LA(1)==TK_case||LA(1)==TK_default))
				{
					case_label();
				}
				else
				{
					if (_cnt22219 >= 1) { goto _loop22219_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
				}
				
				_cnt22219++;
			}
_loop22219_breakloop:			;
			}    // ( ... )+
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_30_);
		}
	}
	
	public void element_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			type_spec();
			declarator();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void case_label() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_34_);
		}
	}
	
	public void enumerator_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			enumerator();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						enumerator();
					}
					else
					{
						goto _loop22225_breakloop;
					}
					
				}
_loop22225_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void enumerator() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			identifier();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_35_);
		}
	}
	
	public void opt_pos_int() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
				case COMMA:
				{
					match(COMMA);
					positive_int_const();
					break;
				}
				case GTHAN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_36_);
		}
	}
	
	public void opt_pos_int_br() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
				case LTHAN:
				{
					match(LTHAN);
					positive_int_const();
					match(GTHAN);
					break;
				}
				case COMMA:
				case GTHAN:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_14_);
		}
	}
	
	public void param_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void simple_declarator_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			simple_declarator();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						simple_declarator();
					}
					else
					{
						goto _loop22238_breakloop;
					}
					
				}
_loop22238_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void opt_member_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{    // ( ... )*
				for (;;)
				{
					if ((tokenSet_30_.member(LA(1))))
					{
						member();
					}
					else
					{
						goto _loop22242_breakloop;
					}
					
				}
_loop22242_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_5_);
		}
	}
	
	public void op_attribute() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_37_);
		}
	}
	
	public void op_type_spec() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_11_);
		}
	}
	
	public void parameter_dcls() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(LPAREN);
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			match(RPAREN);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_38_);
		}
	}
	
	public void opt_raises_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_39_);
		}
	}
	
	public void opt_context_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			{
				switch ( LA(1) )
				{
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
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void raises_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_raises);
			match(LPAREN);
			scoped_name_list();
			match(RPAREN);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_39_);
		}
	}
	
	public void context_expr() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			match(TK_context);
			match(LPAREN);
			string_literal_list();
			match(RPAREN);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
	}
	
	public void param_dcl_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			param_dcl();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						param_dcl();
					}
					else
					{
						goto _loop22254_breakloop;
					}
					
				}
_loop22254_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_32_);
		}
	}
	
	public void param_dcl() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			param_attribute();
			param_type_spec();
			simple_declarator();
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_40_);
		}
	}
	
	public void param_attribute() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_41_);
		}
	}
	
	public void string_literal_list() //throws RecognitionException, TokenStreamException
{
		
		
		try {      // for error handling
			string_literal();
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==COMMA))
					{
						match(COMMA);
						string_literal();
					}
					else
					{
						goto _loop22261_breakloop;
					}
					
				}
_loop22261_breakloop:				;
			}    // ( ... )*
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_32_);
		}
	}
	
	private void initializeFactory()
	{
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@""";""",
		@"""module""",
		@"""{""",
		@"""}""",
		@"""interface""",
		@""":""",
		@""",""",
		@"""::""",
		@"""const""",
		@"""=""",
		@"""|""",
		@"""^""",
		@"""&""",
		@"""<<""",
		@""">>""",
		@"""+""",
		@"""-""",
		@"""*""",
		@"""/""",
		@"""%""",
		@"""~""",
		@"""(""",
		@""")""",
		@"""TRUE""",
		@"""FALSE""",
		@"""typedef""",
		@"""native""",
		@"""octet""",
		@"""any""",
		@"""unsigned""",
		@"""short""",
		@"""long""",
		@"""char""",
		@"""float""",
		@"""double""",
		@"""boolean""",
		@"""struct""",
		@"""union""",
		@"""switch""",
		@"""case""",
		@"""default""",
		@"""enum""",
		@"""sequence""",
		@"""<""",
		@""">""",
		@"""string""",
		@"""[""",
		@"""]""",
		@"""readonly""",
		@"""attribute""",
		@"""exception""",
		@"""oneway""",
		@"""void""",
		@"""in""",
		@"""out""",
		@"""inout""",
		@"""raises""",
		@"""context""",
		@"""an integer value""",
		@"""OCTAL""",
		@"""a hexadecimal value value""",
		@"""a string literal""",
		@"""a character literal""",
		@"""an floating point value""",
		@"""an identifer""",
		@"""?""",
		@""".""",
		@"""!""",
		@"""white space""",
		@"""a preprocessor directive""",
		@"""a comment""",
		@"""a comment""",
		@"""an escape sequence""",
		@"""an escaped character value""",
		@"""a digit""",
		@"""an octal digit""",
		@"""a hexadecimal digit"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 18052883027071280L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { 18052883027071410L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { 16L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { 3663572861185744L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { 128L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	private static long[] mk_tokenSet_6_()
	{
		long[] data = { 80L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_6_ = new BitSet(mk_tokenSet_6_());
	private static long[] mk_tokenSet_7_()
	{
		long[] data = { 140214120283641872L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_7_ = new BitSet(mk_tokenSet_7_());
	private static long[] mk_tokenSet_8_()
	{
		long[] data = { 140214120283642000L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_8_ = new BitSet(mk_tokenSet_8_());
	private static long[] mk_tokenSet_9_()
	{
		long[] data = { 67108944L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_9_ = new BitSet(mk_tokenSet_9_());
	private static long[] mk_tokenSet_10_()
	{
		long[] data = { 2533274874267216L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_10_ = new BitSet(mk_tokenSet_10_());
	private static long[] mk_tokenSet_11_()
	{
		long[] data = { 0L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_11_ = new BitSet(mk_tokenSet_11_());
	private static long[] mk_tokenSet_12_()
	{
		long[] data = { 2533274857505296L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_12_ = new BitSet(mk_tokenSet_12_());
	private static long[] mk_tokenSet_13_()
	{
		long[] data = { 281475043820544L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_13_ = new BitSet(mk_tokenSet_13_());
	private static long[] mk_tokenSet_14_()
	{
		long[] data = { 281474976711680L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_14_ = new BitSet(mk_tokenSet_14_());
	private static long[] mk_tokenSet_15_()
	{
		long[] data = { 2533274857521680L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_15_ = new BitSet(mk_tokenSet_15_());
	private static long[] mk_tokenSet_16_()
	{
		long[] data = { -4611686017972828160L, 31L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_16_ = new BitSet(mk_tokenSet_16_());
	private static long[] mk_tokenSet_17_()
	{
		long[] data = { 2533274857554448L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_17_ = new BitSet(mk_tokenSet_17_());
	private static long[] mk_tokenSet_18_()
	{
		long[] data = { 2533274857619984L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_18_ = new BitSet(mk_tokenSet_18_());
	private static long[] mk_tokenSet_19_()
	{
		long[] data = { 2533274858013200L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_19_ = new BitSet(mk_tokenSet_19_());
	private static long[] mk_tokenSet_20_()
	{
		long[] data = { 2533274859586064L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_20_ = new BitSet(mk_tokenSet_20_());
	private static long[] mk_tokenSet_21_()
	{
		long[] data = { 2533274874266128L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_21_ = new BitSet(mk_tokenSet_21_());
	private static long[] mk_tokenSet_22_()
	{
		long[] data = { -4611686017991178240L, 31L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_22_ = new BitSet(mk_tokenSet_22_());
	private static long[] mk_tokenSet_23_()
	{
		long[] data = { 2533274874267152L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_23_ = new BitSet(mk_tokenSet_23_());
	private static long[] mk_tokenSet_24_()
	{
		long[] data = { 2533274790395904L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_24_ = new BitSet(mk_tokenSet_24_());
	private static long[] mk_tokenSet_25_()
	{
		long[] data = { 16L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_25_ = new BitSet(mk_tokenSet_25_());
	private static long[] mk_tokenSet_26_()
	{
		long[] data = { 67108880L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_26_ = new BitSet(mk_tokenSet_26_());
	private static long[] mk_tokenSet_27_()
	{
		long[] data = { 67109904L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_27_ = new BitSet(mk_tokenSet_27_());
	private static long[] mk_tokenSet_28_()
	{
		long[] data = { 1040L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_28_ = new BitSet(mk_tokenSet_28_());
	private static long[] mk_tokenSet_29_()
	{
		long[] data = { 1125899906843664L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_29_ = new BitSet(mk_tokenSet_29_());
	private static long[] mk_tokenSet_30_()
	{
		long[] data = { 672898968717312L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_30_ = new BitSet(mk_tokenSet_30_());
	private static long[] mk_tokenSet_31_()
	{
		long[] data = { 672898968717440L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_31_ = new BitSet(mk_tokenSet_31_());
	private static long[] mk_tokenSet_32_()
	{
		long[] data = { 67108864L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_32_ = new BitSet(mk_tokenSet_32_());
	private static long[] mk_tokenSet_33_()
	{
		long[] data = { 26388279066752L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_33_ = new BitSet(mk_tokenSet_33_());
	private static long[] mk_tokenSet_34_()
	{
		long[] data = { 699287247783936L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_34_ = new BitSet(mk_tokenSet_34_());
	private static long[] mk_tokenSet_35_()
	{
		long[] data = { 1152L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_35_ = new BitSet(mk_tokenSet_35_());
	private static long[] mk_tokenSet_36_()
	{
		long[] data = { 281474976710656L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_36_ = new BitSet(mk_tokenSet_36_());
	private static long[] mk_tokenSet_37_()
	{
		long[] data = { 72621641355495424L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_37_ = new BitSet(mk_tokenSet_37_());
	private static long[] mk_tokenSet_38_()
	{
		long[] data = { 3458764513820540944L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_38_ = new BitSet(mk_tokenSet_38_());
	private static long[] mk_tokenSet_39_()
	{
		long[] data = { 2305843009213693968L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_39_ = new BitSet(mk_tokenSet_39_());
	private static long[] mk_tokenSet_40_()
	{
		long[] data = { 67109888L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_40_ = new BitSet(mk_tokenSet_40_());
	private static long[] mk_tokenSet_41_()
	{
		long[] data = { 564047317567488L, 16L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_41_ = new BitSet(mk_tokenSet_41_());
	
}
