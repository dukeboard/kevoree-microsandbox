// $ANTLR 2.7.2: "java.g" -> "JavaRecognizer.cs"$

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
	using AST                      = antlr.collections.AST;
	using ASTPair                  = antlr.ASTPair;
	using ASTFactory               = antlr.ASTFactory;
	using ASTArray                 = antlr.collections.impl.ASTArray;
	
/** Java 1.3 Recognizer
 *
 * Run 'java Main [-showtree] directory-full-of-java-files'
 *
 * [The -showtree option pops up a Swing frame that shows
 *  the AST constructed from the parser.]
 *
 * Run 'java Main <directory full of java files>'
 *
 * Contributing authors:
 *		John Mitchell		johnm@non.net
 *		Terence Parr		parrt@magelang.com
 *		John Lilley			jlilley@empathy.com
 *		Scott Stanchfield	thetick@magelang.com
 *		Markus Mohnen       mohnen@informatik.rwth-aachen.de
 *      Peter Williams      pete.williams@sun.com
 *      Allan Jacobs        Allan.Jacobs@eng.sun.com
 *      Steve Messick       messick@redhills.com
 *      John Pybus			john@pybus.org
 *
 * Version 1.00 December 9, 1997 -- initial release
 * Version 1.01 December 10, 1997
 *		fixed bug in octal def (0..7 not 0..8)
 * Version 1.10 August 1998 (parrt)
 *		added tree construction
 *		fixed definition of WS,comments for mac,pc,unix newlines
 *		added unary plus
 * Version 1.11 (Nov 20, 1998)
 *		Added "shutup" option to turn off last ambig warning.
 *		Fixed inner class def to allow named class defs as statements
 *		synchronized requires compound not simple statement
 *		add [] after builtInType DOT class in primaryExpression
 *		"const" is reserved but not valid..removed from modifiers
 * Version 1.12 (Feb 2, 1999)
 *		Changed LITERAL_xxx to xxx in tree grammar.
 *		Updated java.g to use tokens {...} now for 2.6.0 (new feature).
 *
 * Version 1.13 (Apr 23, 1999)
 *		Didn't have (stat)? for else clause in tree parser.
 *		Didn't gen ASTs for interface extends.  Updated tree parser too.
 *		Updated to 2.6.0.
 * Version 1.14 (Jun 20, 1999)
 *		Allowed final/abstract on local classes.
 *		Removed local interfaces from methods
 *		Put instanceof precedence where it belongs...in relationalExpr
 *			It also had expr not type as arg; fixed it.
 *		Missing ! on SEMI in classBlock
 *		fixed: (expr) + "string" was parsed incorrectly (+ as unary plus).
 *		fixed: didn't like Object[].class in parser or tree parser
 * Version 1.15 (Jun 26, 1999)
 *		Screwed up rule with instanceof in it. :(  Fixed.
 *		Tree parser didn't like (expr).something; fixed.
 *		Allowed multiple inheritance in tree grammar. oops.
 * Version 1.16 (August 22, 1999)
 *		Extending an interface built a wacky tree: had extra EXTENDS.
 *		Tree grammar didn't allow multiple superinterfaces.
 *		Tree grammar didn't allow empty var initializer: {}
 * Version 1.17 (October 12, 1999)
 *		ESC lexer rule allowed 399 max not 377 max.
 *		java.tree.g didn't handle the expression of synchronized
 *			statements.
 * Version 1.18 (August 12, 2001)
 *      	Terence updated to Java 2 Version 1.3 by
 *		observing/combining work of Allan Jacobs and Steve
 *		Messick.  Handles 1.3 src.  Summary:
 *		o  primary didn't include boolean.class kind of thing
 *      o  constructor calls parsed explicitly now:
 * 		   see explicitConstructorInvocation
 *		o  add strictfp modifier
 *      o  missing objBlock after new expression in tree grammar
 *		o  merged local class definition alternatives, moved after declaration
 *		o  fixed problem with ClassName.super.field
 *      o  reordered some alternatives to make things more efficient
 *		o  long and double constants were not differentiated from int/float
 *		o  whitespace rule was inefficient: matched only one char
 *		o  add an examples directory with some nasty 1.3 cases
 *		o  made Main.java use buffered IO and a Reader for Unicode support
 *		o  supports UNICODE?
 *		   Using Unicode charVocabulay makes code file big, but only
 *		   in the bitsets at the end. I need to make ANTLR generate
 *		   unicode bitsets more efficiently.
 * Version 1.19 (April 25, 2002)
 *		Terence added in nice fixes by John Pybus concerning floating
 *		constants and problems with super() calls.  John did a nice
 *		reorg of the primary/postfix expression stuff to read better
 *		and makes f.g.super() parse properly (it was METHOD_CALL not
 *		a SUPER_CTOR_CALL).  Also:
 *
 *		o  "finally" clause was a root...made it a child of "try"
 *		o  Added stuff for asserts too for Java 1.4, but *commented out*
 *		   as it is not backward compatible.
 *
 * Version 1.20 (October 27, 2002)
 *
 *      Terence ended up reorging John Pybus' stuff to
 *      remove some nondeterminisms and some syntactic predicates.
 *      Note that the grammar is stricter now; e.g., this(...) must
 *	be the first statement.
 *
 *      Trinary ?: operator wasn't working as array name:
 *          (isBig ? bigDigits : digits)[i];
 *
 *      Checked parser/tree parser on source for
 *          Resin-2.0.5, jive-2.1.1, jdk 1.3.1, Lucene, antlr 2.7.2a4,
 *	    and the 110k jGuru server source.
 *
 * This grammar is in the PUBLIC DOMAIN
 */
	public 	class JavaRecognizer : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int BLOCK = 4;
		public const int MODIFIERS = 5;
		public const int OBJBLOCK = 6;
		public const int SLIST = 7;
		public const int CTOR_DEF = 8;
		public const int METHOD_DEF = 9;
		public const int VARIABLE_DEF = 10;
		public const int INSTANCE_INIT = 11;
		public const int STATIC_INIT = 12;
		public const int TYPE = 13;
		public const int CLASS_DEF = 14;
		public const int INTERFACE_DEF = 15;
		public const int PACKAGE_DEF = 16;
		public const int ARRAY_DECLARATOR = 17;
		public const int EXTENDS_CLAUSE = 18;
		public const int IMPLEMENTS_CLAUSE = 19;
		public const int PARAMETERS = 20;
		public const int PARAMETER_DEF = 21;
		public const int LABELED_STAT = 22;
		public const int TYPECAST = 23;
		public const int INDEX_OP = 24;
		public const int POST_INC = 25;
		public const int POST_DEC = 26;
		public const int METHOD_CALL = 27;
		public const int EXPR = 28;
		public const int ARRAY_INIT = 29;
		public const int IMPORT = 30;
		public const int UNARY_MINUS = 31;
		public const int UNARY_PLUS = 32;
		public const int CASE_GROUP = 33;
		public const int ELIST = 34;
		public const int FOR_INIT = 35;
		public const int FOR_CONDITION = 36;
		public const int FOR_ITERATOR = 37;
		public const int EMPTY_STAT = 38;
		public const int FINAL = 39;
		public const int ABSTRACT = 40;
		public const int STRICTFP = 41;
		public const int SUPER_CTOR_CALL = 42;
		public const int CTOR_CALL = 43;
		public const int TK_package = 44;
		public const int SEMI = 45;
		public const int TK_import = 46;
		public const int LBRACK = 47;
		public const int RBRACK = 48;
		public const int TK_void = 49;
		public const int TK_boolean = 50;
		public const int TK_byte = 51;
		public const int TK_char = 52;
		public const int TK_short = 53;
		public const int TK_int = 54;
		public const int TK_float = 55;
		public const int TK_long = 56;
		public const int TK_double = 57;
		public const int IDENT = 58;
		public const int DOT = 59;
		public const int STAR = 60;
		public const int TK_private = 61;
		public const int TK_public = 62;
		public const int TK_protected = 63;
		public const int TK_static = 64;
		public const int TK_transient = 65;
		public const int TK_native = 66;
		public const int TK_threadsafe = 67;
		public const int TK_synchronized = 68;
		public const int TK_volatile = 69;
		public const int TK_class = 70;
		public const int TK_extends = 71;
		public const int TK_interface = 72;
		public const int LCURLY = 73;
		public const int RCURLY = 74;
		public const int COMMA = 75;
		public const int TK_implements = 76;
		public const int LPAREN = 77;
		public const int RPAREN = 78;
		public const int TK_this = 79;
		public const int TK_super = 80;
		public const int ASSIGN = 81;
		public const int TK_throws = 82;
		public const int COLON = 83;
		public const int TK_if = 84;
		public const int TK_else = 85;
		public const int TK_for = 86;
		public const int TK_while = 87;
		public const int TK_do = 88;
		public const int TK_break = 89;
		public const int TK_continue = 90;
		public const int TK_return = 91;
		public const int TK_switch = 92;
		public const int TK_throw = 93;
		public const int TK_case = 94;
		public const int TK_default = 95;
		public const int TK_try = 96;
		public const int TK_finally = 97;
		public const int TK_catch = 98;
		public const int PLUS_ASSIGN = 99;
		public const int MINUS_ASSIGN = 100;
		public const int STAR_ASSIGN = 101;
		public const int DIV_ASSIGN = 102;
		public const int MOD_ASSIGN = 103;
		public const int SR_ASSIGN = 104;
		public const int BSR_ASSIGN = 105;
		public const int SL_ASSIGN = 106;
		public const int BAND_ASSIGN = 107;
		public const int BXOR_ASSIGN = 108;
		public const int BOR_ASSIGN = 109;
		public const int QUESTION = 110;
		public const int LOR = 111;
		public const int LAND = 112;
		public const int BOR = 113;
		public const int BXOR = 114;
		public const int BAND = 115;
		public const int NOT_EQUAL = 116;
		public const int EQUAL = 117;
		public const int LTHAN = 118;
		public const int GTHAN = 119;
		public const int LTE = 120;
		public const int GTE = 121;
		public const int TK_instanceof = 122;
		public const int SL = 123;
		public const int SR = 124;
		public const int BSR = 125;
		public const int PLUS = 126;
		public const int MINUS = 127;
		public const int DIV = 128;
		public const int MOD = 129;
		public const int INC = 130;
		public const int DEC = 131;
		public const int BNOT = 132;
		public const int LNOT = 133;
		public const int TK_true = 134;
		public const int TK_false = 135;
		public const int TK_null = 136;
		public const int TK_new = 137;
		public const int NUM_INT = 138;
		public const int CHAR_LITERAL = 139;
		public const int STRING_LITERAL = 140;
		public const int NUM_FLOAT = 141;
		public const int NUM_LONG = 142;
		public const int NUM_DOUBLE = 143;
		public const int WS = 144;
		public const int SL_COMMENT = 145;
		public const int ML_COMMENT = 146;
		public const int ESC = 147;
		public const int HEX_DIGIT = 148;
		public const int VOCAB = 149;
		public const int EXPONENT = 150;
		public const int FLOAT_SUFFIX = 151;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
			initializeFactory();
		}
		
		
		protected JavaRecognizer(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public JavaRecognizer(TokenBuffer tokenBuf) : this(tokenBuf,2)
		{
		}
		
		protected JavaRecognizer(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public JavaRecognizer(TokenStream lexer) : this(lexer,2)
		{
		}
		
		public JavaRecognizer(ParserSharedInputState state) : base(state,2)
		{
			initialize();
		}
		
	public void compilationUnit() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compilationUnit_AST = null;
		
		{
			switch ( LA(1) )
			{
			case TK_package:
			{
				packageDefinition();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case EOF:
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case SEMI:
			case TK_import:
			case TK_private:
			case TK_public:
			case TK_protected:
			case TK_static:
			case TK_transient:
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==TK_import))
				{
					importDefinition();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22434_breakloop;
				}
				
			}
_loop22434_breakloop:			;
		}    // ( ... )*
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_0_.member(LA(1))))
				{
					typeDefinition();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22436_breakloop;
				}
				
			}
_loop22436_breakloop:			;
		}    // ( ... )*
		match(Token.EOF_TYPE);
		compilationUnit_AST = currentAST.root;
		returnAST = compilationUnit_AST;
	}
	
	public void packageDefinition() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST packageDefinition_AST = null;
		Token  p = null;
		AST p_AST = null;
		
		try {      // for error handling
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.makeASTRoot(currentAST, p_AST);
			match(TK_package);
			if (0==inputState.guessing)
			{
				p_AST.setType(PACKAGE_DEF);
			}
			identifier();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			packageDefinition_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
		returnAST = packageDefinition_AST;
	}
	
	public void importDefinition() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST importDefinition_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		try {      // for error handling
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.makeASTRoot(currentAST, i_AST);
			match(TK_import);
			if (0==inputState.guessing)
			{
				i_AST.setType(IMPORT);
			}
			identifierStar();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			importDefinition_AST = currentAST.root;
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_1_);
			}
			else
			{
				throw;
			}
		}
		returnAST = importDefinition_AST;
	}
	
	public void typeDefinition() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeDefinition_AST = null;
		AST m_AST = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case TK_private:
			case TK_public:
			case TK_protected:
			case TK_static:
			case TK_transient:
			case TK_native:
			case TK_threadsafe:
			case TK_synchronized:
			case TK_volatile:
			case TK_class:
			case TK_interface:
			{
				modifiers();
				if (0 == inputState.guessing)
				{
					m_AST = (AST)returnAST;
				}
				{
					switch ( LA(1) )
					{
					case TK_class:
					{
						classDefinition(m_AST);
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
						break;
					}
					case TK_interface:
					{
						interfaceDefinition(m_AST);
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			if (0 == inputState.guessing)
			{
				reportError(ex);
				consume();
				consumeUntil(tokenSet_2_);
			}
			else
			{
				throw;
			}
		}
		returnAST = typeDefinition_AST;
	}
	
	public void identifier() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifier_AST = null;
		
		AST tmp5_AST = null;
		tmp5_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp5_AST);
		match(IDENT);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==DOT))
				{
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp6_AST);
					match(DOT);
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp7_AST);
					match(IDENT);
				}
				else
				{
					goto _loop22453_breakloop;
				}
				
			}
_loop22453_breakloop:			;
		}    // ( ... )*
		identifier_AST = currentAST.root;
		returnAST = identifier_AST;
	}
	
	public void identifierStar() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifierStar_AST = null;
		
		AST tmp8_AST = null;
		tmp8_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp8_AST);
		match(IDENT);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==DOT) && (LA(2)==IDENT))
				{
					AST tmp9_AST = null;
					tmp9_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp9_AST);
					match(DOT);
					AST tmp10_AST = null;
					tmp10_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp10_AST);
					match(IDENT);
				}
				else
				{
					goto _loop22456_breakloop;
				}
				
			}
_loop22456_breakloop:			;
		}    // ( ... )*
		{
			switch ( LA(1) )
			{
			case DOT:
			{
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp11_AST);
				match(DOT);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(STAR);
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
		identifierStar_AST = currentAST.root;
		returnAST = identifierStar_AST;
	}
	
	public void modifiers() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST modifiers_AST = null;
		
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_3_.member(LA(1))))
				{
					modifier();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22460_breakloop;
				}
				
			}
_loop22460_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			modifiers_AST = (AST)currentAST.root;
			modifiers_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MODIFIERS,"MODIFIERS")).add(modifiers_AST));
			currentAST.root = modifiers_AST;
			if ( (null != modifiers_AST) && (null != modifiers_AST.getFirstChild()) )
				currentAST.child = modifiers_AST.getFirstChild();
			else
				currentAST.child = modifiers_AST;
			currentAST.advanceChildToEnd();
		}
		modifiers_AST = currentAST.root;
		returnAST = modifiers_AST;
	}
	
	public void classDefinition(
		AST modifiers
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classDefinition_AST = null;
		AST sc_AST = null;
		AST ic_AST = null;
		AST cb_AST = null;
		
		match(TK_class);
		AST tmp14_AST = null;
		tmp14_AST = astFactory.create(LT(1));
		match(IDENT);
		superClassClause();
		if (0 == inputState.guessing)
		{
			sc_AST = (AST)returnAST;
		}
		implementsClause();
		if (0 == inputState.guessing)
		{
			ic_AST = (AST)returnAST;
		}
		classBlock();
		if (0 == inputState.guessing)
		{
			cb_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			classDefinition_AST = (AST)currentAST.root;
			classDefinition_AST = (AST)astFactory.make( (new ASTArray(6)).add(astFactory.create(CLASS_DEF,"CLASS_DEF")).add(modifiers).add(tmp14_AST).add(sc_AST).add(ic_AST).add(cb_AST));
			currentAST.root = classDefinition_AST;
			if ( (null != classDefinition_AST) && (null != classDefinition_AST.getFirstChild()) )
				currentAST.child = classDefinition_AST.getFirstChild();
			else
				currentAST.child = classDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = classDefinition_AST;
	}
	
	public void interfaceDefinition(
		AST modifiers
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceDefinition_AST = null;
		AST ie_AST = null;
		AST cb_AST = null;
		
		match(TK_interface);
		AST tmp16_AST = null;
		tmp16_AST = astFactory.create(LT(1));
		match(IDENT);
		interfaceExtends();
		if (0 == inputState.guessing)
		{
			ie_AST = (AST)returnAST;
		}
		classBlock();
		if (0 == inputState.guessing)
		{
			cb_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			interfaceDefinition_AST = (AST)currentAST.root;
			interfaceDefinition_AST = (AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(INTERFACE_DEF,"INTERFACE_DEF")).add(modifiers).add(tmp16_AST).add(ie_AST).add(cb_AST));
			currentAST.root = interfaceDefinition_AST;
			if ( (null != interfaceDefinition_AST) && (null != interfaceDefinition_AST.getFirstChild()) )
				currentAST.child = interfaceDefinition_AST.getFirstChild();
			else
				currentAST.child = interfaceDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = interfaceDefinition_AST;
	}
	
/** A declaration is the creation of a reference or primitive-type variable
 *  Create a separate Type/Var tree for each var in the var list.
 */
	public void declaration() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaration_AST = null;
		AST m_AST = null;
		AST t_AST = null;
		AST v_AST = null;
		
		modifiers();
		if (0 == inputState.guessing)
		{
			m_AST = (AST)returnAST;
		}
		typeSpec(false);
		if (0 == inputState.guessing)
		{
			t_AST = (AST)returnAST;
		}
		variableDefinitions(m_AST,t_AST);
		if (0 == inputState.guessing)
		{
			v_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			declaration_AST = (AST)currentAST.root;
			declaration_AST = v_AST;
			currentAST.root = declaration_AST;
			if ( (null != declaration_AST) && (null != declaration_AST.getFirstChild()) )
				currentAST.child = declaration_AST.getFirstChild();
			else
				currentAST.child = declaration_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = declaration_AST;
	}
	
	public void typeSpec(
		bool addImagNode
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeSpec_AST = null;
		
		switch ( LA(1) )
		{
		case IDENT:
		{
			classTypeSpec(addImagNode);
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			typeSpec_AST = currentAST.root;
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
			builtInTypeSpec(addImagNode);
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			typeSpec_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = typeSpec_AST;
	}
	
	public void variableDefinitions(
		AST mods, AST t
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variableDefinitions_AST = null;
		
		variableDeclarator(getASTFactory().dupTree(mods),
						   getASTFactory().dupTree(t));
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					variableDeclarator(getASTFactory().dupTree(mods),
							   getASTFactory().dupTree(t));
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22489_breakloop;
				}
				
			}
_loop22489_breakloop:			;
		}    // ( ... )*
		variableDefinitions_AST = currentAST.root;
		returnAST = variableDefinitions_AST;
	}
	
	public void classTypeSpec(
		bool addImagNode
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classTypeSpec_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		identifier();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LBRACK))
				{
					lb = LT(1);
					lb_AST = astFactory.create(lb);
					astFactory.makeASTRoot(currentAST, lb_AST);
					match(LBRACK);
					if (0==inputState.guessing)
					{
						lb_AST.setType(ARRAY_DECLARATOR);
					}
					match(RBRACK);
				}
				else
				{
					goto _loop22445_breakloop;
				}
				
			}
_loop22445_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			classTypeSpec_AST = (AST)currentAST.root;
			
						if ( addImagNode ) {
							classTypeSpec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(classTypeSpec_AST));
						}
					
			currentAST.root = classTypeSpec_AST;
			if ( (null != classTypeSpec_AST) && (null != classTypeSpec_AST.getFirstChild()) )
				currentAST.child = classTypeSpec_AST.getFirstChild();
			else
				currentAST.child = classTypeSpec_AST;
			currentAST.advanceChildToEnd();
		}
		classTypeSpec_AST = currentAST.root;
		returnAST = classTypeSpec_AST;
	}
	
	public void builtInTypeSpec(
		bool addImagNode
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST builtInTypeSpec_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		builtInType();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LBRACK))
				{
					lb = LT(1);
					lb_AST = astFactory.create(lb);
					astFactory.makeASTRoot(currentAST, lb_AST);
					match(LBRACK);
					if (0==inputState.guessing)
					{
						lb_AST.setType(ARRAY_DECLARATOR);
					}
					match(RBRACK);
				}
				else
				{
					goto _loop22448_breakloop;
				}
				
			}
_loop22448_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			builtInTypeSpec_AST = (AST)currentAST.root;
			
						if ( addImagNode ) {
							builtInTypeSpec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(builtInTypeSpec_AST));
						}
					
			currentAST.root = builtInTypeSpec_AST;
			if ( (null != builtInTypeSpec_AST) && (null != builtInTypeSpec_AST.getFirstChild()) )
				currentAST.child = builtInTypeSpec_AST.getFirstChild();
			else
				currentAST.child = builtInTypeSpec_AST;
			currentAST.advanceChildToEnd();
		}
		builtInTypeSpec_AST = currentAST.root;
		returnAST = builtInTypeSpec_AST;
	}
	
	public void builtInType() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST builtInType_AST = null;
		
		switch ( LA(1) )
		{
		case TK_void:
		{
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp20_AST);
			match(TK_void);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_boolean:
		{
			AST tmp21_AST = null;
			tmp21_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp21_AST);
			match(TK_boolean);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_byte:
		{
			AST tmp22_AST = null;
			tmp22_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp22_AST);
			match(TK_byte);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_char:
		{
			AST tmp23_AST = null;
			tmp23_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp23_AST);
			match(TK_char);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_short:
		{
			AST tmp24_AST = null;
			tmp24_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp24_AST);
			match(TK_short);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_int:
		{
			AST tmp25_AST = null;
			tmp25_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp25_AST);
			match(TK_int);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_float:
		{
			AST tmp26_AST = null;
			tmp26_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp26_AST);
			match(TK_float);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_long:
		{
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp27_AST);
			match(TK_long);
			builtInType_AST = currentAST.root;
			break;
		}
		case TK_double:
		{
			AST tmp28_AST = null;
			tmp28_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp28_AST);
			match(TK_double);
			builtInType_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = builtInType_AST;
	}
	
	public void type() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_AST = null;
		
		switch ( LA(1) )
		{
		case IDENT:
		{
			identifier();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
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
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			type_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = type_AST;
	}
	
	public void modifier() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST modifier_AST = null;
		
		switch ( LA(1) )
		{
		case TK_private:
		{
			AST tmp29_AST = null;
			tmp29_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp29_AST);
			match(TK_private);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_public:
		{
			AST tmp30_AST = null;
			tmp30_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp30_AST);
			match(TK_public);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_protected:
		{
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(TK_protected);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_static:
		{
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(TK_static);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_transient:
		{
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(TK_transient);
			modifier_AST = currentAST.root;
			break;
		}
		case FINAL:
		{
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(FINAL);
			modifier_AST = currentAST.root;
			break;
		}
		case ABSTRACT:
		{
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(ABSTRACT);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_native:
		{
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(TK_native);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_threadsafe:
		{
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(TK_threadsafe);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_synchronized:
		{
			AST tmp38_AST = null;
			tmp38_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp38_AST);
			match(TK_synchronized);
			modifier_AST = currentAST.root;
			break;
		}
		case TK_volatile:
		{
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(TK_volatile);
			modifier_AST = currentAST.root;
			break;
		}
		case STRICTFP:
		{
			AST tmp40_AST = null;
			tmp40_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp40_AST);
			match(STRICTFP);
			modifier_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = modifier_AST;
	}
	
	public void superClassClause() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST superClassClause_AST = null;
		AST id_AST = null;
		
		{
			switch ( LA(1) )
			{
			case TK_extends:
			{
				match(TK_extends);
				identifier();
				if (0 == inputState.guessing)
				{
					id_AST = (AST)returnAST;
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		if (0==inputState.guessing)
		{
			superClassClause_AST = (AST)currentAST.root;
			superClassClause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE,"EXTENDS_CLAUSE")).add(id_AST));
			currentAST.root = superClassClause_AST;
			if ( (null != superClassClause_AST) && (null != superClassClause_AST.getFirstChild()) )
				currentAST.child = superClassClause_AST.getFirstChild();
			else
				currentAST.child = superClassClause_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = superClassClause_AST;
	}
	
	public void implementsClause() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST implementsClause_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		{
			switch ( LA(1) )
			{
			case TK_implements:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				match(TK_implements);
				identifier();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{    // ( ... )*
					for (;;)
					{
						if ((LA(1)==COMMA))
						{
							match(COMMA);
							identifier();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop22476_breakloop;
						}
						
					}
_loop22476_breakloop:					;
				}    // ( ... )*
				break;
			}
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
		if (0==inputState.guessing)
		{
			implementsClause_AST = (AST)currentAST.root;
			implementsClause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IMPLEMENTS_CLAUSE,"IMPLEMENTS_CLAUSE")).add(implementsClause_AST));
			currentAST.root = implementsClause_AST;
			if ( (null != implementsClause_AST) && (null != implementsClause_AST.getFirstChild()) )
				currentAST.child = implementsClause_AST.getFirstChild();
			else
				currentAST.child = implementsClause_AST;
			currentAST.advanceChildToEnd();
		}
		implementsClause_AST = currentAST.root;
		returnAST = implementsClause_AST;
	}
	
	public void classBlock() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classBlock_AST = null;
		
		match(LCURLY);
		{    // ( ... )*
			for (;;)
			{
				switch ( LA(1) )
				{
				case FINAL:
				case ABSTRACT:
				case STRICTFP:
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
				case TK_native:
				case TK_threadsafe:
				case TK_synchronized:
				case TK_volatile:
				case TK_class:
				case TK_interface:
				case LCURLY:
				{
					field();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
					break;
				}
				case SEMI:
				{
					match(SEMI);
					break;
				}
				default:
				{
					goto _loop22468_breakloop;
				}
				 }
			}
_loop22468_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		if (0==inputState.guessing)
		{
			classBlock_AST = (AST)currentAST.root;
			classBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(classBlock_AST));
			currentAST.root = classBlock_AST;
			if ( (null != classBlock_AST) && (null != classBlock_AST.getFirstChild()) )
				currentAST.child = classBlock_AST.getFirstChild();
			else
				currentAST.child = classBlock_AST;
			currentAST.advanceChildToEnd();
		}
		classBlock_AST = currentAST.root;
		returnAST = classBlock_AST;
	}
	
	public void interfaceExtends() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceExtends_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		{
			switch ( LA(1) )
			{
			case TK_extends:
			{
				e = LT(1);
				e_AST = astFactory.create(e);
				match(TK_extends);
				identifier();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{    // ( ... )*
					for (;;)
					{
						if ((LA(1)==COMMA))
						{
							match(COMMA);
							identifier();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop22472_breakloop;
						}
						
					}
_loop22472_breakloop:					;
				}    // ( ... )*
				break;
			}
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
		if (0==inputState.guessing)
		{
			interfaceExtends_AST = (AST)currentAST.root;
			interfaceExtends_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE,"EXTENDS_CLAUSE")).add(interfaceExtends_AST));
			currentAST.root = interfaceExtends_AST;
			if ( (null != interfaceExtends_AST) && (null != interfaceExtends_AST.getFirstChild()) )
				currentAST.child = interfaceExtends_AST.getFirstChild();
			else
				currentAST.child = interfaceExtends_AST;
			currentAST.advanceChildToEnd();
		}
		interfaceExtends_AST = currentAST.root;
		returnAST = interfaceExtends_AST;
	}
	
	public void field() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_AST = null;
		AST mods_AST = null;
		AST h_AST = null;
		AST s_AST = null;
		AST cd_AST = null;
		AST id_AST = null;
		AST t_AST = null;
		AST param_AST = null;
		AST rt_AST = null;
		AST tc_AST = null;
		AST s2_AST = null;
		AST v_AST = null;
		AST s3_AST = null;
		AST s4_AST = null;
		
		if ((tokenSet_4_.member(LA(1))) && (tokenSet_5_.member(LA(2))))
		{
			modifiers();
			if (0 == inputState.guessing)
			{
				mods_AST = (AST)returnAST;
			}
			{
				switch ( LA(1) )
				{
				case TK_class:
				{
					classDefinition(mods_AST);
					if (0 == inputState.guessing)
					{
						cd_AST = (AST)returnAST;
					}
					if (0==inputState.guessing)
					{
						field_AST = (AST)currentAST.root;
						field_AST = cd_AST;
						currentAST.root = field_AST;
						if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
							currentAST.child = field_AST.getFirstChild();
						else
							currentAST.child = field_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case TK_interface:
				{
					interfaceDefinition(mods_AST);
					if (0 == inputState.guessing)
					{
						id_AST = (AST)returnAST;
					}
					if (0==inputState.guessing)
					{
						field_AST = (AST)currentAST.root;
						field_AST = id_AST;
						currentAST.root = field_AST;
						if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
							currentAST.child = field_AST.getFirstChild();
						else
							currentAST.child = field_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				default:
					if ((LA(1)==IDENT) && (LA(2)==LPAREN))
					{
						ctorHead();
						if (0 == inputState.guessing)
						{
							h_AST = (AST)returnAST;
						}
						constructorBody();
						if (0 == inputState.guessing)
						{
							s_AST = (AST)returnAST;
						}
						if (0==inputState.guessing)
						{
							field_AST = (AST)currentAST.root;
							field_AST = (AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(CTOR_DEF,"CTOR_DEF")).add(mods_AST).add(h_AST).add(s_AST));
							currentAST.root = field_AST;
							if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
								currentAST.child = field_AST.getFirstChild();
							else
								currentAST.child = field_AST;
							currentAST.advanceChildToEnd();
						}
					}
					else if (((LA(1) >= TK_void && LA(1) <= IDENT)) && (tokenSet_6_.member(LA(2)))) {
						typeSpec(false);
						if (0 == inputState.guessing)
						{
							t_AST = (AST)returnAST;
						}
						{
							if ((LA(1)==IDENT) && (LA(2)==LPAREN))
							{
								AST tmp47_AST = null;
								tmp47_AST = astFactory.create(LT(1));
								match(IDENT);
								match(LPAREN);
								parameterDeclarationList();
								if (0 == inputState.guessing)
								{
									param_AST = (AST)returnAST;
								}
								match(RPAREN);
								declaratorBrackets(t_AST);
								if (0 == inputState.guessing)
								{
									rt_AST = (AST)returnAST;
								}
								{
									switch ( LA(1) )
									{
									case TK_throws:
									{
										throwsClause();
										if (0 == inputState.guessing)
										{
											tc_AST = (AST)returnAST;
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
										throw new NoViableAltException(LT(1), getFilename());
									}
									 }
								}
								{
									switch ( LA(1) )
									{
									case LCURLY:
									{
										compoundStatement();
										if (0 == inputState.guessing)
										{
											s2_AST = (AST)returnAST;
										}
										break;
									}
									case SEMI:
									{
										AST tmp50_AST = null;
										tmp50_AST = astFactory.create(LT(1));
										match(SEMI);
										break;
									}
									default:
									{
										throw new NoViableAltException(LT(1), getFilename());
									}
									 }
								}
								if (0==inputState.guessing)
								{
									field_AST = (AST)currentAST.root;
									field_AST = (AST)astFactory.make( (new ASTArray(7)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(tmp47_AST).add(param_AST).add(tc_AST).add(s2_AST));
									currentAST.root = field_AST;
									if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
										currentAST.child = field_AST.getFirstChild();
									else
										currentAST.child = field_AST;
									currentAST.advanceChildToEnd();
								}
							}
							else if ((LA(1)==IDENT) && (tokenSet_7_.member(LA(2)))) {
								variableDefinitions(mods_AST,t_AST);
								if (0 == inputState.guessing)
								{
									v_AST = (AST)returnAST;
								}
								AST tmp51_AST = null;
								tmp51_AST = astFactory.create(LT(1));
								match(SEMI);
								if (0==inputState.guessing)
								{
									field_AST = (AST)currentAST.root;
									field_AST = v_AST;
									currentAST.root = field_AST;
									if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
										currentAST.child = field_AST.getFirstChild();
									else
										currentAST.child = field_AST;
									currentAST.advanceChildToEnd();
								}
							}
							else
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							
						}
					}
				else
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				break; }
			}
		}
		else if ((LA(1)==TK_static) && (LA(2)==LCURLY)) {
			match(TK_static);
			compoundStatement();
			if (0 == inputState.guessing)
			{
				s3_AST = (AST)returnAST;
			}
			if (0==inputState.guessing)
			{
				field_AST = (AST)currentAST.root;
				field_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STATIC_INIT,"STATIC_INIT")).add(s3_AST));
				currentAST.root = field_AST;
				if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
					currentAST.child = field_AST.getFirstChild();
				else
					currentAST.child = field_AST;
				currentAST.advanceChildToEnd();
			}
		}
		else if ((LA(1)==LCURLY)) {
			compoundStatement();
			if (0 == inputState.guessing)
			{
				s4_AST = (AST)returnAST;
			}
			if (0==inputState.guessing)
			{
				field_AST = (AST)currentAST.root;
				field_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INSTANCE_INIT,"INSTANCE_INIT")).add(s4_AST));
				currentAST.root = field_AST;
				if ( (null != field_AST) && (null != field_AST.getFirstChild()) )
					currentAST.child = field_AST.getFirstChild();
				else
					currentAST.child = field_AST;
				currentAST.advanceChildToEnd();
			}
		}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = field_AST;
	}
	
	public void ctorHead() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ctorHead_AST = null;
		
		AST tmp53_AST = null;
		tmp53_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp53_AST);
		match(IDENT);
		match(LPAREN);
		parameterDeclarationList();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(RPAREN);
		{
			switch ( LA(1) )
			{
			case TK_throws:
			{
				throwsClause();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
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
		ctorHead_AST = currentAST.root;
		returnAST = ctorHead_AST;
	}
	
	public void constructorBody() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructorBody_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if (0==inputState.guessing)
		{
			lc_AST.setType(SLIST);
		}
		{
			if ((LA(1)==TK_this||LA(1)==TK_super) && (LA(2)==LPAREN))
			{
				explicitConstructorInvocation();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else if ((tokenSet_8_.member(LA(1))) && (tokenSet_9_.member(LA(2)))) {
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_10_.member(LA(1))))
				{
					statement();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22485_breakloop;
				}
				
			}
_loop22485_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		constructorBody_AST = currentAST.root;
		returnAST = constructorBody_AST;
	}
	
	public void parameterDeclarationList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclarationList_AST = null;
		
		{
			switch ( LA(1) )
			{
			case FINAL:
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
				parameterDeclaration();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{    // ( ... )*
					for (;;)
					{
						if ((LA(1)==COMMA))
						{
							match(COMMA);
							parameterDeclaration();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop22510_breakloop;
						}
						
					}
_loop22510_breakloop:					;
				}    // ( ... )*
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
		if (0==inputState.guessing)
		{
			parameterDeclarationList_AST = (AST)currentAST.root;
			parameterDeclarationList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETERS,"PARAMETERS")).add(parameterDeclarationList_AST));
			currentAST.root = parameterDeclarationList_AST;
			if ( (null != parameterDeclarationList_AST) && (null != parameterDeclarationList_AST.getFirstChild()) )
				currentAST.child = parameterDeclarationList_AST.getFirstChild();
			else
				currentAST.child = parameterDeclarationList_AST;
			currentAST.advanceChildToEnd();
		}
		parameterDeclarationList_AST = currentAST.root;
		returnAST = parameterDeclarationList_AST;
	}
	
	public void declaratorBrackets(
		AST typ
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaratorBrackets_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		if (0==inputState.guessing)
		{
			declaratorBrackets_AST = (AST)currentAST.root;
			declaratorBrackets_AST=typ;
			currentAST.root = declaratorBrackets_AST;
			if ( (null != declaratorBrackets_AST) && (null != declaratorBrackets_AST.getFirstChild()) )
				currentAST.child = declaratorBrackets_AST.getFirstChild();
			else
				currentAST.child = declaratorBrackets_AST;
			currentAST.advanceChildToEnd();
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LBRACK))
				{
					lb = LT(1);
					lb_AST = astFactory.create(lb);
					astFactory.makeASTRoot(currentAST, lb_AST);
					match(LBRACK);
					if (0==inputState.guessing)
					{
						lb_AST.setType(ARRAY_DECLARATOR);
					}
					match(RBRACK);
				}
				else
				{
					goto _loop22493_breakloop;
				}
				
			}
_loop22493_breakloop:			;
		}    // ( ... )*
		declaratorBrackets_AST = currentAST.root;
		returnAST = declaratorBrackets_AST;
	}
	
	public void throwsClause() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST throwsClause_AST = null;
		
		AST tmp59_AST = null;
		tmp59_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp59_AST);
		match(TK_throws);
		identifier();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					identifier();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22506_breakloop;
				}
				
			}
_loop22506_breakloop:			;
		}    // ( ... )*
		throwsClause_AST = currentAST.root;
		returnAST = throwsClause_AST;
	}
	
	public void compoundStatement() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compoundStatement_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if (0==inputState.guessing)
		{
			lc_AST.setType(SLIST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_10_.member(LA(1))))
				{
					statement();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22516_breakloop;
				}
				
			}
_loop22516_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		compoundStatement_AST = currentAST.root;
		returnAST = compoundStatement_AST;
	}
	
/** Catch obvious constructor calls, but not the expr.super(...) calls */
	public void explicitConstructorInvocation() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST explicitConstructorInvocation_AST = null;
		Token  lp1 = null;
		AST lp1_AST = null;
		Token  lp2 = null;
		AST lp2_AST = null;
		
		switch ( LA(1) )
		{
		case TK_this:
		{
			match(TK_this);
			lp1 = LT(1);
			lp1_AST = astFactory.create(lp1);
			astFactory.makeASTRoot(currentAST, lp1_AST);
			match(LPAREN);
			argList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			match(SEMI);
			if (0==inputState.guessing)
			{
				lp1_AST.setType(CTOR_CALL);
			}
			explicitConstructorInvocation_AST = currentAST.root;
			break;
		}
		case TK_super:
		{
			match(TK_super);
			lp2 = LT(1);
			lp2_AST = astFactory.create(lp2);
			astFactory.makeASTRoot(currentAST, lp2_AST);
			match(LPAREN);
			argList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			match(SEMI);
			if (0==inputState.guessing)
			{
				lp2_AST.setType(SUPER_CTOR_CALL);
			}
			explicitConstructorInvocation_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = explicitConstructorInvocation_AST;
	}
	
	public void statement() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		AST m_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  s = null;
		AST s_AST = null;
		
		switch ( LA(1) )
		{
		case LCURLY:
		{
			compoundStatement();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_if:
		{
			AST tmp68_AST = null;
			tmp68_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp68_AST);
			match(TK_if);
			match(LPAREN);
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			statement();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			{
				if ((LA(1)==TK_else) && (tokenSet_10_.member(LA(2))))
				{
					match(TK_else);
					statement();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else if ((tokenSet_11_.member(LA(1))) && (tokenSet_12_.member(LA(2)))) {
				}
				else
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_for:
		{
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp72_AST);
			match(TK_for);
			match(LPAREN);
			forInit();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			forCond();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			forIter();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			statement();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_while:
		{
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp77_AST);
			match(TK_while);
			match(LPAREN);
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			statement();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_do:
		{
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp80_AST);
			match(TK_do);
			statement();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(TK_while);
			match(LPAREN);
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case TK_break:
		{
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp85_AST);
			match(TK_break);
			{
				switch ( LA(1) )
				{
				case IDENT:
				{
					AST tmp86_AST = null;
					tmp86_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp86_AST);
					match(IDENT);
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
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case TK_continue:
		{
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp88_AST);
			match(TK_continue);
			{
				switch ( LA(1) )
				{
				case IDENT:
				{
					AST tmp89_AST = null;
					tmp89_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp89_AST);
					match(IDENT);
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
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case TK_return:
		{
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp91_AST);
			match(TK_return);
			{
				switch ( LA(1) )
				{
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
				case TK_this:
				case TK_super:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case TK_true:
				case TK_false:
				case TK_null:
				case TK_new:
				case NUM_INT:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case NUM_FLOAT:
				case NUM_LONG:
				case NUM_DOUBLE:
				{
					expression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
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
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case TK_switch:
		{
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp93_AST);
			match(TK_switch);
			match(LPAREN);
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
			match(LCURLY);
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==TK_case||LA(1)==TK_default))
					{
						casesGroup();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
					}
					else
					{
						goto _loop22525_breakloop;
					}
					
				}
_loop22525_breakloop:				;
			}    // ( ... )*
			match(RCURLY);
			statement_AST = currentAST.root;
			break;
		}
		case TK_try:
		{
			tryBlock();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			statement_AST = currentAST.root;
			break;
		}
		case TK_throw:
		{
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp98_AST);
			match(TK_throw);
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			statement_AST = currentAST.root;
			break;
		}
		case SEMI:
		{
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(SEMI);
			if (0==inputState.guessing)
			{
				s_AST.setType(EMPTY_STAT);
			}
			statement_AST = currentAST.root;
			break;
		}
		default:
			bool synPredMatched22519 = false;
			if (((tokenSet_13_.member(LA(1))) && (tokenSet_14_.member(LA(2)))))
			{
				int _m22519 = mark();
				synPredMatched22519 = true;
				inputState.guessing++;
				try {
					{
						declaration();
					}
				}
				catch (RecognitionException)
				{
					synPredMatched22519 = false;
				}
				rewind(_m22519);
				inputState.guessing--;
			}
			if ( synPredMatched22519 )
			{
				declaration();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				match(SEMI);
				statement_AST = currentAST.root;
			}
			else if ((tokenSet_15_.member(LA(1))) && (tokenSet_16_.member(LA(2)))) {
				expression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				match(SEMI);
				statement_AST = currentAST.root;
			}
			else if ((tokenSet_17_.member(LA(1))) && (tokenSet_18_.member(LA(2)))) {
				modifiers();
				if (0 == inputState.guessing)
				{
					m_AST = (AST)returnAST;
				}
				classDefinition(m_AST);
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				statement_AST = currentAST.root;
			}
			else if ((LA(1)==IDENT) && (LA(2)==COLON)) {
				AST tmp102_AST = null;
				tmp102_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp102_AST);
				match(IDENT);
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.makeASTRoot(currentAST, c_AST);
				match(COLON);
				if (0==inputState.guessing)
				{
					c_AST.setType(LABELED_STAT);
				}
				statement();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				statement_AST = currentAST.root;
			}
			else if ((LA(1)==TK_synchronized) && (LA(2)==LPAREN)) {
				AST tmp103_AST = null;
				tmp103_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp103_AST);
				match(TK_synchronized);
				match(LPAREN);
				expression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				match(RPAREN);
				compoundStatement();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				statement_AST = currentAST.root;
			}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		break; }
		returnAST = statement_AST;
	}
	
	public void argList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST argList_AST = null;
		
		{
			switch ( LA(1) )
			{
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
			case TK_this:
			case TK_super:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				expressionList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case RPAREN:
			{
				if (0==inputState.guessing)
				{
					argList_AST = (AST)currentAST.root;
					argList_AST = astFactory.create(ELIST,"ELIST");
					currentAST.root = argList_AST;
					if ( (null != argList_AST) && (null != argList_AST.getFirstChild()) )
						currentAST.child = argList_AST.getFirstChild();
					else
						currentAST.child = argList_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		argList_AST = currentAST.root;
		returnAST = argList_AST;
	}
	
/** Declaration of a variable.  This can be a class/instance variable,
 *   or a local variable in a method
 * It can also include possible initialization.
 */
	public void variableDeclarator(
		AST mods, AST t
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variableDeclarator_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST d_AST = null;
		AST v_AST = null;
		
		id = LT(1);
		id_AST = astFactory.create(id);
		match(IDENT);
		declaratorBrackets(t);
		if (0 == inputState.guessing)
		{
			d_AST = (AST)returnAST;
		}
		varInitializer();
		if (0 == inputState.guessing)
		{
			v_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			variableDeclarator_AST = (AST)currentAST.root;
			variableDeclarator_AST = (AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(VARIABLE_DEF,"VARIABLE_DEF")).add(mods).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(d_AST))).add(id_AST).add(v_AST));
			currentAST.root = variableDeclarator_AST;
			if ( (null != variableDeclarator_AST) && (null != variableDeclarator_AST.getFirstChild()) )
				currentAST.child = variableDeclarator_AST.getFirstChild();
			else
				currentAST.child = variableDeclarator_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = variableDeclarator_AST;
	}
	
	public void varInitializer() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST varInitializer_AST = null;
		
		{
			switch ( LA(1) )
			{
			case ASSIGN:
			{
				AST tmp106_AST = null;
				tmp106_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp106_AST);
				match(ASSIGN);
				initializer();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		varInitializer_AST = currentAST.root;
		returnAST = varInitializer_AST;
	}
	
	public void initializer() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST initializer_AST = null;
		
		switch ( LA(1) )
		{
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
		case TK_this:
		case TK_super:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case TK_true:
		case TK_false:
		case TK_null:
		case TK_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			expression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			initializer_AST = currentAST.root;
			break;
		}
		case LCURLY:
		{
			arrayInitializer();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			initializer_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = initializer_AST;
	}
	
	public void arrayInitializer() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arrayInitializer_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if (0==inputState.guessing)
		{
			lc_AST.setType(ARRAY_INIT);
		}
		{
			switch ( LA(1) )
			{
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
			case TK_this:
			case TK_super:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				initializer();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{    // ( ... )*
					for (;;)
					{
						if ((LA(1)==COMMA) && (tokenSet_19_.member(LA(2))))
						{
							match(COMMA);
							initializer();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop22499_breakloop;
						}
						
					}
_loop22499_breakloop:					;
				}    // ( ... )*
				{
					switch ( LA(1) )
					{
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
						throw new NoViableAltException(LT(1), getFilename());
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		match(RCURLY);
		arrayInitializer_AST = currentAST.root;
		returnAST = arrayInitializer_AST;
	}
	
	public void expression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		assignmentExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		if (0==inputState.guessing)
		{
			expression_AST = (AST)currentAST.root;
			expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXPR,"EXPR")).add(expression_AST));
			currentAST.root = expression_AST;
			if ( (null != expression_AST) && (null != expression_AST.getFirstChild()) )
				currentAST.child = expression_AST.getFirstChild();
			else
				currentAST.child = expression_AST;
			currentAST.advanceChildToEnd();
		}
		expression_AST = currentAST.root;
		returnAST = expression_AST;
	}
	
	public void parameterDeclaration() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclaration_AST = null;
		AST pm_AST = null;
		AST t_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST pd_AST = null;
		
		parameterModifier();
		if (0 == inputState.guessing)
		{
			pm_AST = (AST)returnAST;
		}
		typeSpec(false);
		if (0 == inputState.guessing)
		{
			t_AST = (AST)returnAST;
		}
		id = LT(1);
		id_AST = astFactory.create(id);
		match(IDENT);
		declaratorBrackets(t_AST);
		if (0 == inputState.guessing)
		{
			pd_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			parameterDeclaration_AST = (AST)currentAST.root;
			parameterDeclaration_AST = (AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(PARAMETER_DEF,"PARAMETER_DEF")).add(pm_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(pd_AST))).add(id_AST));
			currentAST.root = parameterDeclaration_AST;
			if ( (null != parameterDeclaration_AST) && (null != parameterDeclaration_AST.getFirstChild()) )
				currentAST.child = parameterDeclaration_AST.getFirstChild();
			else
				currentAST.child = parameterDeclaration_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = parameterDeclaration_AST;
	}
	
	public void parameterModifier() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterModifier_AST = null;
		Token  f = null;
		AST f_AST = null;
		
		{
			switch ( LA(1) )
			{
			case FINAL:
			{
				f = LT(1);
				f_AST = astFactory.create(f);
				astFactory.addASTChild(currentAST, f_AST);
				match(FINAL);
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		if (0==inputState.guessing)
		{
			parameterModifier_AST = (AST)currentAST.root;
			parameterModifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MODIFIERS,"MODIFIERS")).add(f_AST));
			currentAST.root = parameterModifier_AST;
			if ( (null != parameterModifier_AST) && (null != parameterModifier_AST.getFirstChild()) )
				currentAST.child = parameterModifier_AST.getFirstChild();
			else
				currentAST.child = parameterModifier_AST;
			currentAST.advanceChildToEnd();
		}
		parameterModifier_AST = currentAST.root;
		returnAST = parameterModifier_AST;
	}
	
	public void forInit() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forInit_AST = null;
		
		{
			bool synPredMatched22537 = false;
			if (((tokenSet_13_.member(LA(1))) && (tokenSet_14_.member(LA(2)))))
			{
				int _m22537 = mark();
				synPredMatched22537 = true;
				inputState.guessing++;
				try {
					{
						declaration();
					}
				}
				catch (RecognitionException)
				{
					synPredMatched22537 = false;
				}
				rewind(_m22537);
				inputState.guessing--;
			}
			if ( synPredMatched22537 )
			{
				declaration();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else if ((tokenSet_15_.member(LA(1))) && (tokenSet_20_.member(LA(2)))) {
				expressionList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else if ((LA(1)==SEMI)) {
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		if (0==inputState.guessing)
		{
			forInit_AST = (AST)currentAST.root;
			forInit_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_INIT,"FOR_INIT")).add(forInit_AST));
			currentAST.root = forInit_AST;
			if ( (null != forInit_AST) && (null != forInit_AST.getFirstChild()) )
				currentAST.child = forInit_AST.getFirstChild();
			else
				currentAST.child = forInit_AST;
			currentAST.advanceChildToEnd();
		}
		forInit_AST = currentAST.root;
		returnAST = forInit_AST;
	}
	
	public void forCond() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forCond_AST = null;
		
		{
			switch ( LA(1) )
			{
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
			case TK_this:
			case TK_super:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				expression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
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
		if (0==inputState.guessing)
		{
			forCond_AST = (AST)currentAST.root;
			forCond_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_CONDITION,"FOR_CONDITION")).add(forCond_AST));
			currentAST.root = forCond_AST;
			if ( (null != forCond_AST) && (null != forCond_AST.getFirstChild()) )
				currentAST.child = forCond_AST.getFirstChild();
			else
				currentAST.child = forCond_AST;
			currentAST.advanceChildToEnd();
		}
		forCond_AST = currentAST.root;
		returnAST = forCond_AST;
	}
	
	public void forIter() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forIter_AST = null;
		
		{
			switch ( LA(1) )
			{
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
			case TK_this:
			case TK_super:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				expressionList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
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
		if (0==inputState.guessing)
		{
			forIter_AST = (AST)currentAST.root;
			forIter_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_ITERATOR,"FOR_ITERATOR")).add(forIter_AST));
			currentAST.root = forIter_AST;
			if ( (null != forIter_AST) && (null != forIter_AST.getFirstChild()) )
				currentAST.child = forIter_AST.getFirstChild();
			else
				currentAST.child = forIter_AST;
			currentAST.advanceChildToEnd();
		}
		forIter_AST = currentAST.root;
		returnAST = forIter_AST;
	}
	
	public void casesGroup() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST casesGroup_AST = null;
		
		{ // ( ... )+
		int _cnt22528=0;
		for (;;)
		{
			if ((LA(1)==TK_case||LA(1)==TK_default) && (tokenSet_21_.member(LA(2))))
			{
				aCase();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else
			{
				if (_cnt22528 >= 1) { goto _loop22528_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
			}
			
			_cnt22528++;
		}
_loop22528_breakloop:		;
		}    // ( ... )+
		caseSList();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		if (0==inputState.guessing)
		{
			casesGroup_AST = (AST)currentAST.root;
			casesGroup_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_GROUP,"CASE_GROUP")).add(casesGroup_AST));
			currentAST.root = casesGroup_AST;
			if ( (null != casesGroup_AST) && (null != casesGroup_AST.getFirstChild()) )
				currentAST.child = casesGroup_AST.getFirstChild();
			else
				currentAST.child = casesGroup_AST;
			currentAST.advanceChildToEnd();
		}
		casesGroup_AST = currentAST.root;
		returnAST = casesGroup_AST;
	}
	
	public void tryBlock() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tryBlock_AST = null;
		
		AST tmp110_AST = null;
		tmp110_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp110_AST);
		match(TK_try);
		compoundStatement();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==TK_catch))
				{
					handler();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22544_breakloop;
				}
				
			}
_loop22544_breakloop:			;
		}    // ( ... )*
		{
			switch ( LA(1) )
			{
			case TK_finally:
			{
				finallyClause();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
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
			case TK_native:
			case TK_threadsafe:
			case TK_synchronized:
			case TK_volatile:
			case TK_class:
			case LCURLY:
			case RCURLY:
			case LPAREN:
			case TK_this:
			case TK_super:
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
			case TK_true:
			case TK_false:
			case TK_null:
			case TK_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		tryBlock_AST = currentAST.root;
		returnAST = tryBlock_AST;
	}
	
	public void aCase() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aCase_AST = null;
		
		{
			switch ( LA(1) )
			{
			case TK_case:
			{
				AST tmp111_AST = null;
				tmp111_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp111_AST);
				match(TK_case);
				expression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case TK_default:
			{
				AST tmp112_AST = null;
				tmp112_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp112_AST);
				match(TK_default);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		match(COLON);
		aCase_AST = currentAST.root;
		returnAST = aCase_AST;
	}
	
	public void caseSList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST caseSList_AST = null;
		
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_10_.member(LA(1))))
				{
					statement();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22533_breakloop;
				}
				
			}
_loop22533_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			caseSList_AST = (AST)currentAST.root;
			caseSList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SLIST,"SLIST")).add(caseSList_AST));
			currentAST.root = caseSList_AST;
			if ( (null != caseSList_AST) && (null != caseSList_AST.getFirstChild()) )
				currentAST.child = caseSList_AST.getFirstChild();
			else
				currentAST.child = caseSList_AST;
			currentAST.advanceChildToEnd();
		}
		caseSList_AST = currentAST.root;
		returnAST = caseSList_AST;
	}
	
	public void expressionList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expressionList_AST = null;
		
		expression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					expression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22551_breakloop;
				}
				
			}
_loop22551_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			expressionList_AST = (AST)currentAST.root;
			expressionList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELIST,"ELIST")).add(expressionList_AST));
			currentAST.root = expressionList_AST;
			if ( (null != expressionList_AST) && (null != expressionList_AST.getFirstChild()) )
				currentAST.child = expressionList_AST.getFirstChild();
			else
				currentAST.child = expressionList_AST;
			currentAST.advanceChildToEnd();
		}
		expressionList_AST = currentAST.root;
		returnAST = expressionList_AST;
	}
	
	public void handler() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST handler_AST = null;
		
		AST tmp115_AST = null;
		tmp115_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp115_AST);
		match(TK_catch);
		match(LPAREN);
		parameterDeclaration();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(RPAREN);
		compoundStatement();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		handler_AST = currentAST.root;
		returnAST = handler_AST;
	}
	
	public void finallyClause() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST finallyClause_AST = null;
		
		AST tmp118_AST = null;
		tmp118_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp118_AST);
		match(TK_finally);
		compoundStatement();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		finallyClause_AST = currentAST.root;
		returnAST = finallyClause_AST;
	}
	
	public void assignmentExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignmentExpression_AST = null;
		
		conditionalExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
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
					switch ( LA(1) )
					{
					case ASSIGN:
					{
						AST tmp119_AST = null;
						tmp119_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp119_AST);
						match(ASSIGN);
						break;
					}
					case PLUS_ASSIGN:
					{
						AST tmp120_AST = null;
						tmp120_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp120_AST);
						match(PLUS_ASSIGN);
						break;
					}
					case MINUS_ASSIGN:
					{
						AST tmp121_AST = null;
						tmp121_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp121_AST);
						match(MINUS_ASSIGN);
						break;
					}
					case STAR_ASSIGN:
					{
						AST tmp122_AST = null;
						tmp122_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp122_AST);
						match(STAR_ASSIGN);
						break;
					}
					case DIV_ASSIGN:
					{
						AST tmp123_AST = null;
						tmp123_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp123_AST);
						match(DIV_ASSIGN);
						break;
					}
					case MOD_ASSIGN:
					{
						AST tmp124_AST = null;
						tmp124_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp124_AST);
						match(MOD_ASSIGN);
						break;
					}
					case SR_ASSIGN:
					{
						AST tmp125_AST = null;
						tmp125_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp125_AST);
						match(SR_ASSIGN);
						break;
					}
					case BSR_ASSIGN:
					{
						AST tmp126_AST = null;
						tmp126_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp126_AST);
						match(BSR_ASSIGN);
						break;
					}
					case SL_ASSIGN:
					{
						AST tmp127_AST = null;
						tmp127_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp127_AST);
						match(SL_ASSIGN);
						break;
					}
					case BAND_ASSIGN:
					{
						AST tmp128_AST = null;
						tmp128_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp128_AST);
						match(BAND_ASSIGN);
						break;
					}
					case BXOR_ASSIGN:
					{
						AST tmp129_AST = null;
						tmp129_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp129_AST);
						match(BXOR_ASSIGN);
						break;
					}
					case BOR_ASSIGN:
					{
						AST tmp130_AST = null;
						tmp130_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp130_AST);
						match(BOR_ASSIGN);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					 }
				}
				assignmentExpression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		assignmentExpression_AST = currentAST.root;
		returnAST = assignmentExpression_AST;
	}
	
	public void conditionalExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conditionalExpression_AST = null;
		
		logicalOrExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
			case QUESTION:
			{
				AST tmp131_AST = null;
				tmp131_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp131_AST);
				match(QUESTION);
				assignmentExpression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				match(COLON);
				conditionalExpression();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		conditionalExpression_AST = currentAST.root;
		returnAST = conditionalExpression_AST;
	}
	
	public void logicalOrExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logicalOrExpression_AST = null;
		
		logicalAndExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LOR))
				{
					AST tmp133_AST = null;
					tmp133_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp133_AST);
					match(LOR);
					logicalAndExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22559_breakloop;
				}
				
			}
_loop22559_breakloop:			;
		}    // ( ... )*
		logicalOrExpression_AST = currentAST.root;
		returnAST = logicalOrExpression_AST;
	}
	
	public void logicalAndExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logicalAndExpression_AST = null;
		
		inclusiveOrExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LAND))
				{
					AST tmp134_AST = null;
					tmp134_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp134_AST);
					match(LAND);
					inclusiveOrExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22562_breakloop;
				}
				
			}
_loop22562_breakloop:			;
		}    // ( ... )*
		logicalAndExpression_AST = currentAST.root;
		returnAST = logicalAndExpression_AST;
	}
	
	public void inclusiveOrExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inclusiveOrExpression_AST = null;
		
		exclusiveOrExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==BOR))
				{
					AST tmp135_AST = null;
					tmp135_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp135_AST);
					match(BOR);
					exclusiveOrExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22565_breakloop;
				}
				
			}
_loop22565_breakloop:			;
		}    // ( ... )*
		inclusiveOrExpression_AST = currentAST.root;
		returnAST = inclusiveOrExpression_AST;
	}
	
	public void exclusiveOrExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exclusiveOrExpression_AST = null;
		
		andExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==BXOR))
				{
					AST tmp136_AST = null;
					tmp136_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp136_AST);
					match(BXOR);
					andExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22568_breakloop;
				}
				
			}
_loop22568_breakloop:			;
		}    // ( ... )*
		exclusiveOrExpression_AST = currentAST.root;
		returnAST = exclusiveOrExpression_AST;
	}
	
	public void andExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST andExpression_AST = null;
		
		equalityExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==BAND))
				{
					AST tmp137_AST = null;
					tmp137_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp137_AST);
					match(BAND);
					equalityExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22571_breakloop;
				}
				
			}
_loop22571_breakloop:			;
		}    // ( ... )*
		andExpression_AST = currentAST.root;
		returnAST = andExpression_AST;
	}
	
	public void equalityExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equalityExpression_AST = null;
		
		relationalExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==NOT_EQUAL||LA(1)==EQUAL))
				{
					{
						switch ( LA(1) )
						{
						case NOT_EQUAL:
						{
							AST tmp138_AST = null;
							tmp138_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp138_AST);
							match(NOT_EQUAL);
							break;
						}
						case EQUAL:
						{
							AST tmp139_AST = null;
							tmp139_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp139_AST);
							match(EQUAL);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						 }
					}
					relationalExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22575_breakloop;
				}
				
			}
_loop22575_breakloop:			;
		}    // ( ... )*
		equalityExpression_AST = currentAST.root;
		returnAST = equalityExpression_AST;
	}
	
	public void relationalExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalExpression_AST = null;
		
		shiftExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
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
			case QUESTION:
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
			{
				{    // ( ... )*
					for (;;)
					{
						if (((LA(1) >= LTHAN && LA(1) <= GTE)))
						{
							{
								switch ( LA(1) )
								{
								case LTHAN:
								{
									AST tmp140_AST = null;
									tmp140_AST = astFactory.create(LT(1));
									astFactory.makeASTRoot(currentAST, tmp140_AST);
									match(LTHAN);
									break;
								}
								case GTHAN:
								{
									AST tmp141_AST = null;
									tmp141_AST = astFactory.create(LT(1));
									astFactory.makeASTRoot(currentAST, tmp141_AST);
									match(GTHAN);
									break;
								}
								case LTE:
								{
									AST tmp142_AST = null;
									tmp142_AST = astFactory.create(LT(1));
									astFactory.makeASTRoot(currentAST, tmp142_AST);
									match(LTE);
									break;
								}
								case GTE:
								{
									AST tmp143_AST = null;
									tmp143_AST = astFactory.create(LT(1));
									astFactory.makeASTRoot(currentAST, tmp143_AST);
									match(GTE);
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								 }
							}
							shiftExpression();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop22580_breakloop;
						}
						
					}
_loop22580_breakloop:					;
				}    // ( ... )*
				break;
			}
			case TK_instanceof:
			{
				AST tmp144_AST = null;
				tmp144_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp144_AST);
				match(TK_instanceof);
				typeSpec(true);
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		relationalExpression_AST = currentAST.root;
		returnAST = relationalExpression_AST;
	}
	
	public void shiftExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST shiftExpression_AST = null;
		
		additiveExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if (((LA(1) >= SL && LA(1) <= BSR)))
				{
					{
						switch ( LA(1) )
						{
						case SL:
						{
							AST tmp145_AST = null;
							tmp145_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp145_AST);
							match(SL);
							break;
						}
						case SR:
						{
							AST tmp146_AST = null;
							tmp146_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp146_AST);
							match(SR);
							break;
						}
						case BSR:
						{
							AST tmp147_AST = null;
							tmp147_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp147_AST);
							match(BSR);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						 }
					}
					additiveExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22584_breakloop;
				}
				
			}
_loop22584_breakloop:			;
		}    // ( ... )*
		shiftExpression_AST = currentAST.root;
		returnAST = shiftExpression_AST;
	}
	
	public void additiveExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST additiveExpression_AST = null;
		
		multiplicativeExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==PLUS||LA(1)==MINUS))
				{
					{
						switch ( LA(1) )
						{
						case PLUS:
						{
							AST tmp148_AST = null;
							tmp148_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp148_AST);
							match(PLUS);
							break;
						}
						case MINUS:
						{
							AST tmp149_AST = null;
							tmp149_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp149_AST);
							match(MINUS);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						 }
					}
					multiplicativeExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22588_breakloop;
				}
				
			}
_loop22588_breakloop:			;
		}    // ( ... )*
		additiveExpression_AST = currentAST.root;
		returnAST = additiveExpression_AST;
	}
	
	public void multiplicativeExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplicativeExpression_AST = null;
		
		unaryExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_22_.member(LA(1))))
				{
					{
						switch ( LA(1) )
						{
						case STAR:
						{
							AST tmp150_AST = null;
							tmp150_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp150_AST);
							match(STAR);
							break;
						}
						case DIV:
						{
							AST tmp151_AST = null;
							tmp151_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp151_AST);
							match(DIV);
							break;
						}
						case MOD:
						{
							AST tmp152_AST = null;
							tmp152_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp152_AST);
							match(MOD);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						 }
					}
					unaryExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop22592_breakloop;
				}
				
			}
_loop22592_breakloop:			;
		}    // ( ... )*
		multiplicativeExpression_AST = currentAST.root;
		returnAST = multiplicativeExpression_AST;
	}
	
	public void unaryExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unaryExpression_AST = null;
		
		switch ( LA(1) )
		{
		case INC:
		{
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp153_AST);
			match(INC);
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpression_AST = currentAST.root;
			break;
		}
		case DEC:
		{
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp154_AST);
			match(DEC);
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpression_AST = currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp155_AST = null;
			tmp155_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp155_AST);
			match(MINUS);
			if (0==inputState.guessing)
			{
				tmp155_AST.setType(UNARY_MINUS);
			}
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpression_AST = currentAST.root;
			break;
		}
		case PLUS:
		{
			AST tmp156_AST = null;
			tmp156_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp156_AST);
			match(PLUS);
			if (0==inputState.guessing)
			{
				tmp156_AST.setType(UNARY_PLUS);
			}
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpression_AST = currentAST.root;
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
		case LPAREN:
		case TK_this:
		case TK_super:
		case BNOT:
		case LNOT:
		case TK_true:
		case TK_false:
		case TK_null:
		case TK_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			unaryExpressionNotPlusMinus();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpression_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = unaryExpression_AST;
	}
	
	public void unaryExpressionNotPlusMinus() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unaryExpressionNotPlusMinus_AST = null;
		Token  lpb = null;
		AST lpb_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		
		switch ( LA(1) )
		{
		case BNOT:
		{
			AST tmp157_AST = null;
			tmp157_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp157_AST);
			match(BNOT);
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpressionNotPlusMinus_AST = currentAST.root;
			break;
		}
		case LNOT:
		{
			AST tmp158_AST = null;
			tmp158_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp158_AST);
			match(LNOT);
			unaryExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			unaryExpressionNotPlusMinus_AST = currentAST.root;
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
		case LPAREN:
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
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			{
				if ((LA(1)==LPAREN) && ((LA(2) >= TK_void && LA(2) <= TK_double)))
				{
					lpb = LT(1);
					lpb_AST = astFactory.create(lpb);
					astFactory.makeASTRoot(currentAST, lpb_AST);
					match(LPAREN);
					if (0==inputState.guessing)
					{
						lpb_AST.setType(TYPECAST);
					}
					builtInTypeSpec(true);
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
					match(RPAREN);
					unaryExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else {
					bool synPredMatched22597 = false;
					if (((LA(1)==LPAREN) && (LA(2)==IDENT)))
					{
						int _m22597 = mark();
						synPredMatched22597 = true;
						inputState.guessing++;
						try {
							{
								match(LPAREN);
								classTypeSpec(true);
								match(RPAREN);
								unaryExpressionNotPlusMinus();
							}
						}
						catch (RecognitionException)
						{
							synPredMatched22597 = false;
						}
						rewind(_m22597);
						inputState.guessing--;
					}
					if ( synPredMatched22597 )
					{
						lp = LT(1);
						lp_AST = astFactory.create(lp);
						astFactory.makeASTRoot(currentAST, lp_AST);
						match(LPAREN);
						if (0==inputState.guessing)
						{
							lp_AST.setType(TYPECAST);
						}
						classTypeSpec(true);
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
						match(RPAREN);
						unaryExpressionNotPlusMinus();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
					}
					else if ((tokenSet_23_.member(LA(1))) && (tokenSet_24_.member(LA(2)))) {
						postfixExpression();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
					}
					else
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				unaryExpressionNotPlusMinus_AST = currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
			returnAST = unaryExpressionNotPlusMinus_AST;
		}
		
	public void postfixExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST postfixExpression_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		Token  lp3 = null;
		AST lp3_AST = null;
		Token  lps = null;
		AST lps_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		Token  incrmt = null;
		AST incrmt_AST = null;
		Token  decrmt = null;
		AST decrmt_AST = null;
		
		primaryExpression();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==DOT) && (LA(2)==IDENT))
				{
					AST tmp161_AST = null;
					tmp161_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp161_AST);
					match(DOT);
					AST tmp162_AST = null;
					tmp162_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp162_AST);
					match(IDENT);
					{
						switch ( LA(1) )
						{
						case LPAREN:
						{
							lp = LT(1);
							lp_AST = astFactory.create(lp);
							astFactory.makeASTRoot(currentAST, lp_AST);
							match(LPAREN);
							if (0==inputState.guessing)
							{
								lp_AST.setType(METHOD_CALL);
							}
							argList();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
							match(RPAREN);
							break;
						}
						case SEMI:
						case LBRACK:
						case RBRACK:
						case DOT:
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
						case LTHAN:
						case GTHAN:
						case LTE:
						case GTE:
						case TK_instanceof:
						case SL:
						case SR:
						case BSR:
						case PLUS:
						case MINUS:
						case DIV:
						case MOD:
						case INC:
						case DEC:
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
				else if ((LA(1)==DOT) && (LA(2)==TK_this)) {
					AST tmp164_AST = null;
					tmp164_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp164_AST);
					match(DOT);
					AST tmp165_AST = null;
					tmp165_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp165_AST);
					match(TK_this);
				}
				else if ((LA(1)==DOT) && (LA(2)==TK_super)) {
					AST tmp166_AST = null;
					tmp166_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp166_AST);
					match(DOT);
					AST tmp167_AST = null;
					tmp167_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(TK_super);
					{
						switch ( LA(1) )
						{
						case LPAREN:
						{
							lp3 = LT(1);
							lp3_AST = astFactory.create(lp3);
							astFactory.makeASTRoot(currentAST, lp3_AST);
							match(LPAREN);
							argList();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
							match(RPAREN);
							if (0==inputState.guessing)
							{
								lp3_AST.setType(SUPER_CTOR_CALL);
							}
							break;
						}
						case DOT:
						{
							AST tmp169_AST = null;
							tmp169_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp169_AST);
							match(DOT);
							AST tmp170_AST = null;
							tmp170_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp170_AST);
							match(IDENT);
							{
								switch ( LA(1) )
								{
								case LPAREN:
								{
									lps = LT(1);
									lps_AST = astFactory.create(lps);
									astFactory.makeASTRoot(currentAST, lps_AST);
									match(LPAREN);
									if (0==inputState.guessing)
									{
										lps_AST.setType(METHOD_CALL);
									}
									argList();
									if (0 == inputState.guessing)
									{
										astFactory.addASTChild(currentAST, returnAST);
									}
									match(RPAREN);
									break;
								}
								case SEMI:
								case LBRACK:
								case RBRACK:
								case DOT:
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
								case LTHAN:
								case GTHAN:
								case LTE:
								case GTE:
								case TK_instanceof:
								case SL:
								case SR:
								case BSR:
								case PLUS:
								case MINUS:
								case DIV:
								case MOD:
								case INC:
								case DEC:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								 }
							}
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						 }
					}
				}
				else if ((LA(1)==DOT) && (LA(2)==TK_new)) {
					AST tmp172_AST = null;
					tmp172_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp172_AST);
					match(DOT);
					newExpression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else if ((LA(1)==LBRACK)) {
					lb = LT(1);
					lb_AST = astFactory.create(lb);
					astFactory.makeASTRoot(currentAST, lb_AST);
					match(LBRACK);
					if (0==inputState.guessing)
					{
						lb_AST.setType(INDEX_OP);
					}
					expression();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
					match(RBRACK);
				}
				else
				{
					goto _loop22603_breakloop;
				}
				
			}
_loop22603_breakloop:			;
		}    // ( ... )*
		{
			switch ( LA(1) )
			{
			case INC:
			{
				incrmt = LT(1);
				incrmt_AST = astFactory.create(incrmt);
				astFactory.makeASTRoot(currentAST, incrmt_AST);
				match(INC);
				if (0==inputState.guessing)
				{
					incrmt_AST.setType(POST_INC);
				}
				break;
			}
			case DEC:
			{
				decrmt = LT(1);
				decrmt_AST = astFactory.create(decrmt);
				astFactory.makeASTRoot(currentAST, decrmt_AST);
				match(DEC);
				if (0==inputState.guessing)
				{
					decrmt_AST.setType(POST_DEC);
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
			case LTHAN:
			case GTHAN:
			case LTE:
			case GTE:
			case TK_instanceof:
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
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		postfixExpression_AST = currentAST.root;
		returnAST = postfixExpression_AST;
	}
	
	public void primaryExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primaryExpression_AST = null;
		Token  lbt = null;
		AST lbt_AST = null;
		
		switch ( LA(1) )
		{
		case IDENT:
		{
			identPrimary();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			{
				if ((LA(1)==DOT) && (LA(2)==TK_class))
				{
					AST tmp174_AST = null;
					tmp174_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp174_AST);
					match(DOT);
					AST tmp175_AST = null;
					tmp175_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp175_AST);
					match(TK_class);
				}
				else if ((tokenSet_25_.member(LA(1))) && (tokenSet_26_.member(LA(2)))) {
				}
				else
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			primaryExpression_AST = currentAST.root;
			break;
		}
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			constant();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_true:
		{
			AST tmp176_AST = null;
			tmp176_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp176_AST);
			match(TK_true);
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_false:
		{
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp177_AST);
			match(TK_false);
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_null:
		{
			AST tmp178_AST = null;
			tmp178_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp178_AST);
			match(TK_null);
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_new:
		{
			newExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_this:
		{
			AST tmp179_AST = null;
			tmp179_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp179_AST);
			match(TK_this);
			primaryExpression_AST = currentAST.root;
			break;
		}
		case TK_super:
		{
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
			match(TK_super);
			primaryExpression_AST = currentAST.root;
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			assignmentExpression();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RPAREN);
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
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==LBRACK))
					{
						lbt = LT(1);
						lbt_AST = astFactory.create(lbt);
						astFactory.makeASTRoot(currentAST, lbt_AST);
						match(LBRACK);
						if (0==inputState.guessing)
						{
							lbt_AST.setType(ARRAY_DECLARATOR);
						}
						match(RBRACK);
					}
					else
					{
						goto _loop22608_breakloop;
					}
					
				}
_loop22608_breakloop:				;
			}    // ( ... )*
			AST tmp184_AST = null;
			tmp184_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp184_AST);
			match(DOT);
			AST tmp185_AST = null;
			tmp185_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp185_AST);
			match(TK_class);
			primaryExpression_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
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
	public void newExpression() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newExpression_AST = null;
		
		AST tmp186_AST = null;
		tmp186_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp186_AST);
		match(TK_new);
		type();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
			case LPAREN:
			{
				match(LPAREN);
				argList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				match(RPAREN);
				{
					switch ( LA(1) )
					{
					case LCURLY:
					{
						classBlock();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
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
					case LTHAN:
					case GTHAN:
					case LTE:
					case GTE:
					case TK_instanceof:
					case SL:
					case SR:
					case BSR:
					case PLUS:
					case MINUS:
					case DIV:
					case MOD:
					case INC:
					case DEC:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					 }
				}
				break;
			}
			case LBRACK:
			{
				newArrayDeclarator();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{
					switch ( LA(1) )
					{
					case LCURLY:
					{
						arrayInitializer();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
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
					case LTHAN:
					case GTHAN:
					case LTE:
					case GTE:
					case TK_instanceof:
					case SL:
					case SR:
					case BSR:
					case PLUS:
					case MINUS:
					case DIV:
					case MOD:
					case INC:
					case DEC:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					 }
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		newExpression_AST = currentAST.root;
		returnAST = newExpression_AST;
	}
	
/** Match a, a.b.c refs, a.b.c(...) refs, a.b.c[], a.b.c[].class,
 *  and a.b.c.class refs.  Also this(...) and super(...).  Match
 *  this or super.
 */
	public void identPrimary() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identPrimary_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		Token  lbc = null;
		AST lbc_AST = null;
		
		AST tmp189_AST = null;
		tmp189_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp189_AST);
		match(IDENT);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==DOT) && (LA(2)==IDENT))
				{
					AST tmp190_AST = null;
					tmp190_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp190_AST);
					match(DOT);
					AST tmp191_AST = null;
					tmp191_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp191_AST);
					match(IDENT);
				}
				else
				{
					goto _loop22611_breakloop;
				}
				
			}
_loop22611_breakloop:			;
		}    // ( ... )*
		{
			if ((LA(1)==LPAREN))
			{
				{
					lp = LT(1);
					lp_AST = astFactory.create(lp);
					astFactory.makeASTRoot(currentAST, lp_AST);
					match(LPAREN);
					if (0==inputState.guessing)
					{
						lp_AST.setType(METHOD_CALL);
					}
					argList();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
					match(RPAREN);
				}
			}
			else if ((LA(1)==LBRACK) && (LA(2)==RBRACK)) {
				{ // ( ... )+
				int _cnt22615=0;
				for (;;)
				{
					if ((LA(1)==LBRACK) && (LA(2)==RBRACK))
					{
						lbc = LT(1);
						lbc_AST = astFactory.create(lbc);
						astFactory.makeASTRoot(currentAST, lbc_AST);
						match(LBRACK);
						if (0==inputState.guessing)
						{
							lbc_AST.setType(ARRAY_DECLARATOR);
						}
						match(RBRACK);
					}
					else
					{
						if (_cnt22615 >= 1) { goto _loop22615_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
					}
					
					_cnt22615++;
				}
_loop22615_breakloop:				;
				}    // ( ... )+
			}
			else if ((tokenSet_25_.member(LA(1))) && (tokenSet_26_.member(LA(2)))) {
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		identPrimary_AST = currentAST.root;
		returnAST = identPrimary_AST;
	}
	
	public void constant() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1) )
		{
		case NUM_INT:
		{
			AST tmp194_AST = null;
			tmp194_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp194_AST);
			match(NUM_INT);
			constant_AST = currentAST.root;
			break;
		}
		case CHAR_LITERAL:
		{
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp195_AST);
			match(CHAR_LITERAL);
			constant_AST = currentAST.root;
			break;
		}
		case STRING_LITERAL:
		{
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp196_AST);
			match(STRING_LITERAL);
			constant_AST = currentAST.root;
			break;
		}
		case NUM_FLOAT:
		{
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp197_AST);
			match(NUM_FLOAT);
			constant_AST = currentAST.root;
			break;
		}
		case NUM_LONG:
		{
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp198_AST);
			match(NUM_LONG);
			constant_AST = currentAST.root;
			break;
		}
		case NUM_DOUBLE:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp199_AST);
			match(NUM_DOUBLE);
			constant_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = constant_AST;
	}
	
	public void newArrayDeclarator() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newArrayDeclarator_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		{ // ( ... )+
		int _cnt22625=0;
		for (;;)
		{
			if ((LA(1)==LBRACK) && (tokenSet_27_.member(LA(2))))
			{
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if (0==inputState.guessing)
				{
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				{
					switch ( LA(1) )
					{
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
					case TK_this:
					case TK_super:
					case PLUS:
					case MINUS:
					case INC:
					case DEC:
					case BNOT:
					case LNOT:
					case TK_true:
					case TK_false:
					case TK_null:
					case TK_new:
					case NUM_INT:
					case CHAR_LITERAL:
					case STRING_LITERAL:
					case NUM_FLOAT:
					case NUM_LONG:
					case NUM_DOUBLE:
					{
						expression();
						if (0 == inputState.guessing)
						{
							astFactory.addASTChild(currentAST, returnAST);
						}
						break;
					}
					case RBRACK:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					 }
				}
				match(RBRACK);
			}
			else
			{
				if (_cnt22625 >= 1) { goto _loop22625_breakloop; } else { throw new NoViableAltException(LT(1), getFilename());; }
			}
			
			_cnt22625++;
		}
_loop22625_breakloop:		;
		}    // ( ... )+
		newArrayDeclarator_AST = currentAST.root;
		returnAST = newArrayDeclarator_AST;
	}
	
	private void initializeFactory()
	{
		if (astFactory == null)
		{
			astFactory = new ASTFactory();
		}
		initializeASTFactory( astFactory );
	}
	static public void initializeASTFactory( ASTFactory factory )
	{
		factory.setMaxNodeType(151);
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""BLOCK""",
		@"""MODIFIERS""",
		@"""OBJBLOCK""",
		@"""SLIST""",
		@"""CTOR_DEF""",
		@"""METHOD_DEF""",
		@"""VARIABLE_DEF""",
		@"""INSTANCE_INIT""",
		@"""STATIC_INIT""",
		@"""TYPE""",
		@"""CLASS_DEF""",
		@"""INTERFACE_DEF""",
		@"""PACKAGE_DEF""",
		@"""ARRAY_DECLARATOR""",
		@"""EXTENDS_CLAUSE""",
		@"""IMPLEMENTS_CLAUSE""",
		@"""PARAMETERS""",
		@"""PARAMETER_DEF""",
		@"""LABELED_STAT""",
		@"""TYPECAST""",
		@"""INDEX_OP""",
		@"""POST_INC""",
		@"""POST_DEC""",
		@"""METHOD_CALL""",
		@"""EXPR""",
		@"""ARRAY_INIT""",
		@"""IMPORT""",
		@"""UNARY_MINUS""",
		@"""UNARY_PLUS""",
		@"""CASE_GROUP""",
		@"""ELIST""",
		@"""FOR_INIT""",
		@"""FOR_CONDITION""",
		@"""FOR_ITERATOR""",
		@"""EMPTY_STAT""",
		@"""final""",
		@"""abstract""",
		@"""strictfp""",
		@"""SUPER_CTOR_CALL""",
		@"""CTOR_CALL""",
		@"""package""",
		@"""SEMI""",
		@"""import""",
		@"""LBRACK""",
		@"""RBRACK""",
		@"""void""",
		@"""boolean""",
		@"""byte""",
		@"""char""",
		@"""short""",
		@"""int""",
		@"""float""",
		@"""long""",
		@"""double""",
		@"""IDENT""",
		@"""DOT""",
		@"""STAR""",
		@"""private""",
		@"""public""",
		@"""protected""",
		@"""static""",
		@"""transient""",
		@"""native""",
		@"""threadsafe""",
		@"""synchronized""",
		@"""volatile""",
		@"""class""",
		@"""extends""",
		@"""interface""",
		@"""LCURLY""",
		@"""RCURLY""",
		@"""COMMA""",
		@"""implements""",
		@"""LPAREN""",
		@"""RPAREN""",
		@"""this""",
		@"""super""",
		@"""ASSIGN""",
		@"""throws""",
		@"""COLON""",
		@"""if""",
		@"""else""",
		@"""for""",
		@"""while""",
		@"""do""",
		@"""break""",
		@"""continue""",
		@"""return""",
		@"""switch""",
		@"""throw""",
		@"""case""",
		@"""default""",
		@"""try""",
		@"""finally""",
		@"""catch""",
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
		@"""QUESTION""",
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
		@"""instanceof""",
		@"""SL""",
		@"""SR""",
		@"""BSR""",
		@"""PLUS""",
		@"""MINUS""",
		@"""DIV""",
		@"""MOD""",
		@"""INC""",
		@"""DEC""",
		@"""BNOT""",
		@"""LNOT""",
		@"""true""",
		@"""false""",
		@"""null""",
		@"""new""",
		@"""NUM_INT""",
		@"""CHAR_LITERAL""",
		@"""STRING_LITERAL""",
		@"""NUM_FLOAT""",
		@"""NUM_LONG""",
		@"""NUM_DOUBLE""",
		@"""WS""",
		@"""SL_COMMENT""",
		@"""ML_COMMENT""",
		@"""ESC""",
		@"""HEX_DIGIT""",
		@"""VOCAB""",
		@"""EXPONENT""",
		@"""FLOAT_SUFFIX"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { -2305803976550907904L, 383L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { -2305733607806730238L, 383L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { -2305803976550907902L, 383L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { -2305839160922996736L, 63L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { -1729941358572994560L, 383L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = { -1153339868781215744L, 8575L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	private static long[] mk_tokenSet_6_()
	{
		long[] data = { 864831865943490560L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_6_ = new BitSet(mk_tokenSet_6_());
	private static long[] mk_tokenSet_7_()
	{
		long[] data = { 175921860444160L, 133120L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_7_ = new BitSet(mk_tokenSet_7_());
	private static long[] mk_tokenSet_8_()
	{
		long[] data = { -1729906174200905728L, -4611686013061716353L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_8_ = new BitSet(mk_tokenSet_8_());
	private static long[] mk_tokenSet_9_()
	{
		long[] data = { -383179802279936L, -28993411201L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_9_ = new BitSet(mk_tokenSet_9_());
	private static long[] mk_tokenSet_10_()
	{
		long[] data = { -1729906174200905728L, -4611686013061717377L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_10_ = new BitSet(mk_tokenSet_10_());
	private static long[] mk_tokenSet_11_()
	{
		long[] data = { -1729906174200905728L, -4611686009838393729L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_11_ = new BitSet(mk_tokenSet_11_());
	private static long[] mk_tokenSet_12_()
	{
		long[] data = { -383179802279936L, -284801L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_12_ = new BitSet(mk_tokenSet_12_());
	private static long[] mk_tokenSet_13_()
	{
		long[] data = { -1729941358572994560L, 63L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_13_ = new BitSet(mk_tokenSet_13_());
	private static long[] mk_tokenSet_14_()
	{
		long[] data = { -1153339868781215744L, 63L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_14_ = new BitSet(mk_tokenSet_14_());
	private static long[] mk_tokenSet_15_()
	{
		long[] data = { 575897802350002176L, -4611686018427281408L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_15_ = new BitSet(mk_tokenSet_15_());
	private static long[] mk_tokenSet_16_()
	{
		long[] data = { 2305455981120716800L, -34359500800L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_16_ = new BitSet(mk_tokenSet_16_());
	private static long[] mk_tokenSet_17_()
	{
		long[] data = { -2305839160922996736L, 127L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_17_ = new BitSet(mk_tokenSet_17_());
	private static long[] mk_tokenSet_18_()
	{
		long[] data = { -2017608784771284992L, 127L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_18_ = new BitSet(mk_tokenSet_18_());
	private static long[] mk_tokenSet_19_()
	{
		long[] data = { 575897802350002176L, -4611686018427280896L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_19_ = new BitSet(mk_tokenSet_19_());
	private static long[] mk_tokenSet_20_()
	{
		long[] data = { 2305455981120716800L, -34359498752L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_20_ = new BitSet(mk_tokenSet_20_());
	private static long[] mk_tokenSet_21_()
	{
		long[] data = { 575897802350002176L, -4611686018426757120L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_21_ = new BitSet(mk_tokenSet_21_());
	private static long[] mk_tokenSet_22_()
	{
		long[] data = { 1152921504606846976L, 0L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_22_ = new BitSet(mk_tokenSet_22_());
	private static long[] mk_tokenSet_23_()
	{
		long[] data = { 575897802350002176L, 106496L, 65472L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_23_ = new BitSet(mk_tokenSet_23_());
	private static long[] mk_tokenSet_24_()
	{
		long[] data = { 2305737456097427456L, -34358957056L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_24_ = new BitSet(mk_tokenSet_24_());
	private static long[] mk_tokenSet_25_()
	{
		long[] data = { 1729839653747425280L, -34359063552L, 15L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_25_ = new BitSet(mk_tokenSet_25_());
	private static long[] mk_tokenSet_26_()
	{
		long[] data = { -101704825569280L, -25770070145L, 65535L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_26_ = new BitSet(mk_tokenSet_26_());
	private static long[] mk_tokenSet_27_()
	{
		long[] data = { 576179277326712832L, -4611686018427281408L, 65532L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_27_ = new BitSet(mk_tokenSet_27_());
	
}
