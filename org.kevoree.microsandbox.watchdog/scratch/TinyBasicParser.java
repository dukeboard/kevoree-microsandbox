// $ANTLR 2.7.2: "TinyBasic.g" -> "TinyBasicParser.java"$

	package tinybasic;
	import java.util.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class TinyBasicParser extends antlr.LLkParser       implements TinyBasicTokenTypes
 {

	Context theContext=null;


protected TinyBasicParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public TinyBasicParser(TokenBuffer tokenBuf) {
  this(tokenBuf,4);
}

protected TinyBasicParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public TinyBasicParser(TokenStream lexer) {
  this(lexer,4);
}

public TinyBasicParser(ParserSharedInputState state) {
  super(state,4);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void imaginaryTokenDefinitions() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST imaginaryTokenDefinitions_AST = null;
		
		AST tmp1_AST = null;
		tmp1_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp1_AST);
		match(SLIST);
		AST tmp2_AST = null;
		tmp2_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp2_AST);
		match(TYPE);
		AST tmp3_AST = null;
		tmp3_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp3_AST);
		match(PROGRAM_DEF);
		AST tmp4_AST = null;
		tmp4_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp4_AST);
		match(SUBROUTINE_DEF);
		AST tmp5_AST = null;
		tmp5_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp5_AST);
		match(FUNCTION_DEF);
		AST tmp6_AST = null;
		tmp6_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp6_AST);
		match(EXIT_MODULE);
		AST tmp7_AST = null;
		tmp7_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp7_AST);
		match(PARAMETERS);
		AST tmp8_AST = null;
		tmp8_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp8_AST);
		match(PARAMETER_DEF);
		AST tmp9_AST = null;
		tmp9_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp9_AST);
		match(LABELED_STAT);
		AST tmp10_AST = null;
		tmp10_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp10_AST);
		match(NUMBERED_STAT);
		AST tmp11_AST = null;
		tmp11_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp11_AST);
		match(UNARY_MINUS);
		AST tmp12_AST = null;
		tmp12_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp12_AST);
		match(UNARY_PLUS);
		AST tmp13_AST = null;
		tmp13_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp13_AST);
		match(CASE_GROUP);
		AST tmp14_AST = null;
		tmp14_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp14_AST);
		match(ARGLIST);
		AST tmp15_AST = null;
		tmp15_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp15_AST);
		match(FOR_LOOP);
		AST tmp16_AST = null;
		tmp16_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp16_AST);
		match(FOR_FROM);
		AST tmp17_AST = null;
		tmp17_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp17_AST);
		match(FOR_TO);
		AST tmp18_AST = null;
		tmp18_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp18_AST);
		match(FOR_BY);
		AST tmp19_AST = null;
		tmp19_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp19_AST);
		match(FOR_BY_ONE);
		AST tmp20_AST = null;
		tmp20_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp20_AST);
		match(FOR_BODY);
		AST tmp21_AST = null;
		tmp21_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp21_AST);
		match(INT_FN_EXECUTE);
		AST tmp22_AST = null;
		tmp22_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp22_AST);
		match(FLT_FN_EXECUTE);
		AST tmp23_AST = null;
		tmp23_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp23_AST);
		match(STR_FN_EXECUTE);
		AST tmp24_AST = null;
		tmp24_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp24_AST);
		match(SUB_EXECUTE);
		AST tmp25_AST = null;
		tmp25_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp25_AST);
		match(EQ_COMP);
		AST tmp26_AST = null;
		tmp26_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp26_AST);
		match(INDEX_OP);
		AST tmp27_AST = null;
		tmp27_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp27_AST);
		match(SUBSTRING_OP);
		AST tmp28_AST = null;
		tmp28_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp28_AST);
		match(DOT);
		AST tmp29_AST = null;
		tmp29_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp29_AST);
		match(ARRAY1D);
		AST tmp30_AST = null;
		tmp30_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp30_AST);
		match(ARRAY2D);
		AST tmp31_AST = null;
		tmp31_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp31_AST);
		match(ARRAY3D);
		AST tmp32_AST = null;
		tmp32_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp32_AST);
		match(ARRAY1D_PROXY);
		AST tmp33_AST = null;
		tmp33_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp33_AST);
		match(ARRAY2D_PROXY);
		AST tmp34_AST = null;
		tmp34_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp34_AST);
		match(ARRAY3D_PROXY);
		AST tmp35_AST = null;
		tmp35_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp35_AST);
		match(VAR_PROXY);
		AST tmp36_AST = null;
		tmp36_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp36_AST);
		match(WHEN_ERROR_CALL);
		AST tmp37_AST = null;
		tmp37_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp37_AST);
		match(WHEN_ERROR_IN);
		AST tmp38_AST = null;
		tmp38_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp38_AST);
		match(PRINT_ASCII);
		AST tmp39_AST = null;
		tmp39_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp39_AST);
		match(PRINT_TAB);
		AST tmp40_AST = null;
		tmp40_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp40_AST);
		match(PRINT_NUMERIC);
		AST tmp41_AST = null;
		tmp41_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp41_AST);
		match(PRINT_STRING);
		AST tmp42_AST = null;
		tmp42_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp42_AST);
		match(PRINT_COMMA);
		AST tmp43_AST = null;
		tmp43_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp43_AST);
		match(PRINT_SEMI);
		AST tmp44_AST = null;
		tmp44_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp44_AST);
		match(IF_THEN_BLOCK);
		AST tmp45_AST = null;
		tmp45_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp45_AST);
		match(IF_BLOCK);
		AST tmp46_AST = null;
		tmp46_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp46_AST);
		match(ELSE_IF_BLOCK);
		AST tmp47_AST = null;
		tmp47_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp47_AST);
		match(ELSE_BLOCK);
		AST tmp48_AST = null;
		tmp48_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp48_AST);
		match(CODE_BLOCK);
		AST tmp49_AST = null;
		tmp49_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp49_AST);
		match(CONDITION);
		imaginaryTokenDefinitions_AST = (AST)currentAST.root;
		returnAST = imaginaryTokenDefinitions_AST;
	}
	
	public final void compilationUnit(
		Context context
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compilationUnit_AST = null;
		
				theContext=context; //new Context();
			
		
		{
		switch ( LA(1)) {
		case TK_program:
		{
			programDefinition();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case TK_sub:
		case TK_function:
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
		_loop19658:
		do {
			switch ( LA(1)) {
			case TK_sub:
			{
				subroutineDefinition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case TK_function:
			{
				functionDefinition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				break _loop19658;
			}
			}
		} while (true);
		}
		match(Token.EOF_TYPE);
		compilationUnit_AST = (AST)currentAST.root;
		returnAST = compilationUnit_AST;
	}
	
	public final void programDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST programDefinition_AST = null;
		AST cb_AST = null;
		Token  quit = null;
		AST quit_AST = null;
		Vector pVector=null;
		
		try {      // for error handling
			match(TK_program);
			if ( inputState.guessing==0 ) {
				
								//#p.setType(PROGRAM_DEF,"PROGRAM_DEF");
								theContext.setProgramScope(new ProgramScope(theContext.getCurrentScope()));
				
							
			}
			pVector=parameters();
			astFactory.addASTChild(currentAST, returnAST);
			eol();
			procedureBlock();
			cb_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			quit = LT(1);
			quit_AST = astFactory.create(quit);
			astFactory.addASTChild(currentAST, quit_AST);
			match(TK_end);
			eol();
			if ( inputState.guessing==0 ) {
				programDefinition_AST = (AST)currentAST.root;
				
								quit_AST.setType(EXIT_MODULE);
								programDefinition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROGRAM_DEF,"PROGRAM_DEF")).add(programDefinition_AST));
								theContext.popScope();
							
				currentAST.root = programDefinition_AST;
				currentAST.child = programDefinition_AST!=null &&programDefinition_AST.getFirstChild()!=null ?
					programDefinition_AST.getFirstChild() : programDefinition_AST;
				currentAST.advanceChildToEnd();
			}
			programDefinition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = programDefinition_AST;
	}
	
	public final void subroutineDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subroutineDefinition_AST = null;
		Token  p = null;
		AST p_AST = null;
		AST n_AST = null;
		AST params_AST = null;
		AST cb_AST = null;
		Token  quit = null;
		AST quit_AST = null;
		Vector pVector=null;
		
		try {      // for error handling
			p = LT(1);
			p_AST = astFactory.create(p);
			match(TK_sub);
			subName();
			n_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
								theContext.pushScope(new SubroutineScope(theContext.getCurrentScope()));
							
			}
			pVector=parameters();
			params_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			eol();
			procedureBlock();
			cb_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			quit = LT(1);
			quit_AST = astFactory.create(quit);
			astFactory.addASTChild(currentAST, quit_AST);
			match(TK_end);
			match(TK_sub);
			eol();
			if ( inputState.guessing==0 ) {
				subroutineDefinition_AST = (AST)currentAST.root;
				
							quit_AST.setType(EXIT_MODULE);
							DTCodeType sub;
							subroutineDefinition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBROUTINE_DEF,"SUBROUTINE_DEF")).add(subroutineDefinition_AST));
							sub=new DTSubroutine(subroutineDefinition_AST,
										cb_AST,theContext.getCurrentScope(),pVector,n_AST.getText());
							theContext.popScope();
							theContext.insertSubroutine(n_AST.getText(),sub);
						
				currentAST.root = subroutineDefinition_AST;
				currentAST.child = subroutineDefinition_AST!=null &&subroutineDefinition_AST.getFirstChild()!=null ?
					subroutineDefinition_AST.getFirstChild() : subroutineDefinition_AST;
				currentAST.advanceChildToEnd();
			}
			subroutineDefinition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = subroutineDefinition_AST;
	}
	
	public final void functionDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST functionDefinition_AST = null;
		Token  p = null;
		AST p_AST = null;
		AST n_AST = null;
		AST params_AST = null;
		AST cb_AST = null;
		Token  quit = null;
		AST quit_AST = null;
		
				int fnType=0;
				Vector pVector=null;
			
		
		try {      // for error handling
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.makeASTRoot(currentAST, p_AST);
			match(TK_function);
			fnType=newFunction();
			n_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				p_AST.setType(FUNCTION_DEF);
			}
			if ( inputState.guessing==0 ) {
				
								theContext.pushScope(new FunctionScope(theContext.getCurrentScope()));
							
			}
			pVector=parameters();
			params_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			eol();
			procedureBlock();
			cb_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			quit = LT(1);
			quit_AST = astFactory.create(quit);
			astFactory.addASTChild(currentAST, quit_AST);
			match(TK_end);
			match(TK_function);
			eol();
			if ( inputState.guessing==0 ) {
				functionDefinition_AST = (AST)currentAST.root;
				
							quit_AST.setType(EXIT_MODULE);
							DTCodeType fnc;
							fnc=new DTFunction(fnType,params_AST,cb_AST,theContext.getCurrentScope(),pVector,n_AST.getText());
							functionDefinition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_DEF,"FUNCTION_DEF")).add(functionDefinition_AST));
							theContext.popScope();
							theContext.insertFunction(n_AST.getText(),fnc);
						
				currentAST.root = functionDefinition_AST;
				currentAST.child = functionDefinition_AST!=null &&functionDefinition_AST.getFirstChild()!=null ?
					functionDefinition_AST.getFirstChild() : functionDefinition_AST;
				currentAST.advanceChildToEnd();
			}
			functionDefinition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = functionDefinition_AST;
	}
	
	public final  Vector  parameters() throws RecognitionException, TokenStreamException {
		 Vector v ;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameters_AST = null;
		v=new Vector();
		
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			parameterDeclarationList(v);
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			break;
		}
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		parameters_AST = (AST)currentAST.root;
		returnAST = parameters_AST;
		return v ;
	}
	
	public final void eol() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST eol_AST = null;
		
		{
		int _cnt19909=0;
		_loop19909:
		do {
			if ((LA(1)==EOL) && (_tokenSet_1.member(LA(2))) && (_tokenSet_2.member(LA(3))) && (_tokenSet_3.member(LA(4)))) {
				match(EOL);
			}
			else {
				if ( _cnt19909>=1 ) { break _loop19909; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt19909++;
		} while (true);
		}
		returnAST = eol_AST;
	}
	
	public final void procedureBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST procedureBlock_AST = null;
		
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		procedureBlock_AST = (AST)currentAST.root;
		returnAST = procedureBlock_AST;
	}
	
	public final void subName() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subName_AST = null;
		
		AST tmp57_AST = null;
		tmp57_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp57_AST);
		match(IDENT);
		subName_AST = (AST)currentAST.root;
		returnAST = subName_AST;
	}
	
	public final int  newFunction() throws RecognitionException, TokenStreamException {
		int t;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newFunction_AST = null;
		t=0;
		
		switch ( LA(1)) {
		case INT_FN:
		{
			AST tmp58_AST = null;
			tmp58_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp58_AST);
			match(INT_FN);
			if ( inputState.guessing==0 ) {
				t=INT_FN;
			}
			newFunction_AST = (AST)currentAST.root;
			break;
		}
		case STR_FN:
		{
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(STR_FN);
			if ( inputState.guessing==0 ) {
				t=STR_FN;
			}
			newFunction_AST = (AST)currentAST.root;
			break;
		}
		case FLT_FN:
		{
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(FLT_FN);
			if ( inputState.guessing==0 ) {
				t=FLT_FN;
			}
			newFunction_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = newFunction_AST;
		return t;
	}
	
	public final void codeBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST codeBlock_AST = null;
		
		{
		_loop19695:
		do {
			if ((_tokenSet_4.member(LA(1))) && (_tokenSet_5.member(LA(2))) && (_tokenSet_6.member(LA(3))) && (_tokenSet_7.member(LA(4)))) {
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19695;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			codeBlock_AST = (AST)currentAST.root;
			codeBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CODE_BLOCK,"CODE_BLOCK")).add(codeBlock_AST));
			currentAST.root = codeBlock_AST;
			currentAST.child = codeBlock_AST!=null &&codeBlock_AST.getFirstChild()!=null ?
				codeBlock_AST.getFirstChild() : codeBlock_AST;
			currentAST.advanceChildToEnd();
		}
		codeBlock_AST = (AST)currentAST.root;
		returnAST = codeBlock_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case TK_library:
		case TK_dim:
		case TK_global:
		case TK_beep:
		case TK_chain:
		case TK_gosub:
		case TK_goto:
		case TK_return:
		case TK_exit:
		case TK_let:
		case TK_on:
		case TK_option:
		case TK_out:
		case TK_pause:
		case TK_redim:
		case TK_poke:
		case TK_randomize:
		case TK_call:
		case IDENT:
		case TK_close:
		case TK_data:
		case TK_deletefile:
		case TK_input:
		case TK_open:
		case TK_print:
		case TK_read:
		case TK_restore:
		case TK_set:
		case TK_loc:
		case TK_brush:
		case TK_circle:
		case TK_clear:
		case TK_ellipse:
		case TK_font:
		case TK_pen:
		case TK_picture:
		case TK_polyline:
		case TK_rectangle:
		case TK_screen:
		case TK_line:
		case TK_cause:
		case TK_error:
		case TK_disable:
		case TK_enable:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		{
			singleStatement();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_if:
		{
			ifStatements();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_for:
		case TK_do:
		case TK_select:
		case TK_when:
		{
			compoundStatement();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		statement_AST = (AST)currentAST.root;
		returnAST = statement_AST;
	}
	
	public final void nl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nl_AST = null;
		Token  c = null;
		AST c_AST = null;
		
		{
		if ((LA(1)==IDENT) && (LA(2)==COLON)) {
			AST tmp61_AST = null;
			tmp61_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp61_AST);
			match(IDENT);
			c = LT(1);
			c_AST = astFactory.create(c);
			match(COLON);
			if ( inputState.guessing==0 ) {
				c_AST.setType(LABELED_STAT);
			}
		}
		else if ((LA(1)==INT_CONST)) {
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp62_AST);
			match(INT_CONST);
			if ( inputState.guessing==0 ) {
				c_AST.setType(NUMBERED_STAT);
			}
		}
		else if ((_tokenSet_8.member(LA(1))) && (_tokenSet_9.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		nl_AST = (AST)currentAST.root;
		returnAST = nl_AST;
	}
	
	public final void singleStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST singleStatement_AST = null;
		Token  ex = null;
		AST ex_AST = null;
		
		{
		switch ( LA(1)) {
		case TK_library:
		{
			AST tmp63_AST = null;
			tmp63_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp63_AST);
			match(TK_library);
			AST tmp64_AST = null;
			tmp64_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp64_AST);
			match(STR_CONST);
			break;
		}
		case TK_dim:
		{
			AST tmp65_AST = null;
			tmp65_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp65_AST);
			match(TK_dim);
			dimensionedVariables();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_global:
		{
			AST tmp66_AST = null;
			tmp66_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp66_AST);
			match(TK_global);
			parameterDeclarationList(new Vector());
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_beep:
		{
			AST tmp67_AST = null;
			tmp67_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp67_AST);
			match(TK_beep);
			break;
		}
		case TK_chain:
		{
			AST tmp68_AST = null;
			tmp68_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp68_AST);
			match(TK_chain);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case TK_with:
			{
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(TK_with);
				match(LPAREN);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				break;
			}
			case EOL:
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
		case TK_gosub:
		{
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp72_AST);
			match(TK_gosub);
			lineLabel();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_goto:
		{
			AST tmp73_AST = null;
			tmp73_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp73_AST);
			match(TK_goto);
			lineLabel();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_call:
		{
			callSubroutineStatement();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_return:
		{
			AST tmp74_AST = null;
			tmp74_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp74_AST);
			match(TK_return);
			{
			switch ( LA(1)) {
			case INT_FN:
			case STR_FN:
			case FLT_FN:
			case LPAREN:
			case STR_CONST:
			case INT_CONST:
			case IDENT:
			case MINUS:
			case TK_in:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			case TK_abs:
			case TK_acos:
			case TK_asc:
			case TK_atn:
			case TK_cos:
			case TK_dround:
			case TK_errl:
			case TK_errn:
			case TK_exp:
			case TK_fract:
			case TK_get_event:
			case TK_instr:
			case TK_int:
			case TK_ival:
			case TK_len:
			case TK_lgt:
			case TK_log:
			case TK_max:
			case TK_min:
			case TK_peek:
			case TK_pi:
			case TK_rnd:
			case TK_sgn:
			case TK_signed:
			case TK_sin:
			case TK_sqr:
			case TK_tan:
			case TK_time:
			case TK_ubound:
			case TK_val:
			case TK_andb:
			case TK_orb:
			case TK_notb:
			case TK_shiftb:
			case TK_xorb:
			case 219:
			case 220:
			case 221:
			case 222:
			case 223:
			case 224:
			case 225:
			case 226:
			case 227:
			case 228:
			case 229:
			case 230:
			case PLUS:
			case FLT_CONST:
			case BINARY_INTEGER:
			case OCTAL_INTEGER:
			case HEXADECIMAL_INTEGER:
			{
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
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
		case TK_exit:
		{
			ex = LT(1);
			ex_AST = astFactory.create(ex);
			astFactory.makeASTRoot(currentAST, ex_AST);
			match(TK_exit);
			match(TK_sub);
			if ( inputState.guessing==0 ) {
				ex_AST.setType(EXIT_MODULE);
			}
			break;
		}
		case TK_let:
		case IDENT:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		{
			{
			switch ( LA(1)) {
			case TK_let:
			{
				match(TK_let);
				break;
			}
			case IDENT:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			assignmentExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_option:
		{
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp77_AST);
			match(TK_option);
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(TK_base);
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(INT_CONST);
			break;
		}
		case TK_out:
		{
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp80_AST);
			match(TK_out);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_pause:
		{
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp82_AST);
			match(TK_pause);
			{
			switch ( LA(1)) {
			case INT_FN:
			case FLT_FN:
			case LPAREN:
			case INT_CONST:
			case IDENT:
			case MINUS:
			case TK_in:
			case INT_VAR:
			case FLT_VAR:
			case TK_abs:
			case TK_acos:
			case TK_asc:
			case TK_atn:
			case TK_cos:
			case TK_dround:
			case TK_errl:
			case TK_errn:
			case TK_exp:
			case TK_fract:
			case TK_get_event:
			case TK_instr:
			case TK_int:
			case TK_ival:
			case TK_len:
			case TK_lgt:
			case TK_log:
			case TK_max:
			case TK_min:
			case TK_peek:
			case TK_pi:
			case TK_rnd:
			case TK_sgn:
			case TK_signed:
			case TK_sin:
			case TK_sqr:
			case TK_tan:
			case TK_time:
			case TK_ubound:
			case TK_val:
			case TK_andb:
			case TK_orb:
			case TK_notb:
			case TK_shiftb:
			case TK_xorb:
			case PLUS:
			case FLT_CONST:
			case BINARY_INTEGER:
			case OCTAL_INTEGER:
			case HEXADECIMAL_INTEGER:
			{
				numericExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
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
		case TK_redim:
		{
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp83_AST);
			match(TK_redim);
			dimensionedVariables();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_poke:
		{
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp84_AST);
			match(TK_poke);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_randomize:
		{
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp87_AST);
			match(TK_randomize);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_loc:
		case TK_brush:
		case TK_circle:
		case TK_clear:
		case TK_ellipse:
		case TK_font:
		case TK_pen:
		case TK_picture:
		case TK_polyline:
		case TK_rectangle:
		case TK_screen:
		{
			graphicsOutput();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_close:
		case TK_data:
		case TK_deletefile:
		case TK_input:
		case TK_open:
		case TK_print:
		case TK_read:
		case TK_restore:
		{
			inputOutput();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_line:
		{
			line_stuff();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_set:
		{
			set_stuff();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
			boolean synPredMatched19715 = false;
			if (((LA(1)==TK_on) && (_tokenSet_10.member(LA(2))) && (_tokenSet_11.member(LA(3))) && (_tokenSet_12.member(LA(4))))) {
				int _m19715 = mark();
				synPredMatched19715 = true;
				inputState.guessing++;
				try {
					{
					match(TK_on);
					numericExpression();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched19715 = false;
				}
				rewind(_m19715);
				inputState.guessing--;
			}
			if ( synPredMatched19715 ) {
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp88_AST);
				match(TK_on);
				numericExpression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case TK_goto:
				{
					AST tmp89_AST = null;
					tmp89_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp89_AST);
					match(TK_goto);
					break;
				}
				case TK_gosub:
				{
					AST tmp90_AST = null;
					tmp90_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp90_AST);
					match(TK_gosub);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				lineLabel();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop19718:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						lineLabel();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop19718;
					}
					
				} while (true);
				}
			}
			else if ((_tokenSet_13.member(LA(1))) && (_tokenSet_14.member(LA(2))) && (_tokenSet_15.member(LA(3))) && (_tokenSet_16.member(LA(4)))) {
				eventSingleStatements();
				astFactory.addASTChild(currentAST, returnAST);
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		eol();
		singleStatement_AST = (AST)currentAST.root;
		returnAST = singleStatement_AST;
	}
	
	public final void ifStatements() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ifStatements_AST = null;
		
		boolean synPredMatched19684 = false;
		if (((LA(1)==TK_if) && (_tokenSet_17.member(LA(2))) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4))))) {
			int _m19684 = mark();
			synPredMatched19684 = true;
			inputState.guessing++;
			try {
				{
				ifStatement();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19684 = false;
			}
			rewind(_m19684);
			inputState.guessing--;
		}
		if ( synPredMatched19684 ) {
			ifStatement();
			astFactory.addASTChild(currentAST, returnAST);
			ifStatements_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==TK_if) && (_tokenSet_17.member(LA(2))) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4)))) {
			ifThenBlock();
			astFactory.addASTChild(currentAST, returnAST);
			ifStatements_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = ifStatements_AST;
	}
	
	public final void compoundStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compoundStatement_AST = null;
		
		switch ( LA(1)) {
		case TK_for:
		{
			forNextBlock();
			astFactory.addASTChild(currentAST, returnAST);
			compoundStatement_AST = (AST)currentAST.root;
			break;
		}
		case TK_select:
		{
			selectCaseBlock();
			astFactory.addASTChild(currentAST, returnAST);
			compoundStatement_AST = (AST)currentAST.root;
			break;
		}
		case TK_when:
		{
			eventCompoundStatements();
			astFactory.addASTChild(currentAST, returnAST);
			compoundStatement_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((LA(1)==TK_do) && (LA(2)==TK_until)) {
				doUntilLoopBlock();
				astFactory.addASTChild(currentAST, returnAST);
				compoundStatement_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TK_do) && (LA(2)==EOL)) {
				doLoopUntilBlock();
				astFactory.addASTChild(currentAST, returnAST);
				compoundStatement_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = compoundStatement_AST;
	}
	
	public final void parameterDeclarationList(
		 Vector v
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclarationList_AST = null;
		DTDataType tbd=null;
		
		tbd=parameterDeclaration();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			
							v.addElement(tbd);
						
		}
		{
		_loop19672:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				tbd=parameterDeclaration();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					
										v.addElement(tbd);
									
				}
			}
			else {
				break _loop19672;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			parameterDeclarationList_AST = (AST)currentAST.root;
			parameterDeclarationList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETERS,"PARAMETERS")).add(parameterDeclarationList_AST));
			currentAST.root = parameterDeclarationList_AST;
			currentAST.child = parameterDeclarationList_AST!=null &&parameterDeclarationList_AST.getFirstChild()!=null ?
				parameterDeclarationList_AST.getFirstChild() : parameterDeclarationList_AST;
			currentAST.advanceChildToEnd();
		}
		parameterDeclarationList_AST = (AST)currentAST.root;
		returnAST = parameterDeclarationList_AST;
	}
	
	public final DTDataType  parameterDeclaration() throws RecognitionException, TokenStreamException {
		DTDataType arg;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclaration_AST = null;
		AST v_AST = null;
		
					int varType=0;
					arg=null;
				
		
		varType=newVariable();
		v_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				{
				switch ( LA(1)) {
				case COMMA:
				{
					match(COMMA);
					if ( inputState.guessing==0 ) {
						
													arg=new DTDataTypeProxy(varType,theContext.getCurrentScope(),3);
													//arg=new DTArray3DProxy(varType,theContext.getCurrentScope());
													//#parameterDeclaration = #([ARRAY3D_PROXY], #parameterDeclaration);
												
					}
					break;
				}
				case RPAREN:
				{
					if ( inputState.guessing==0 ) {
						
													arg=new DTDataTypeProxy(varType,theContext.getCurrentScope(),2);
													//arg=new DTArray2DProxy(varType,theContext.getCurrentScope());
													//#parameterDeclaration = #([ARRAY2D_PROXY], #parameterDeclaration);
												
					}
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
			case RPAREN:
			{
				if ( inputState.guessing==0 ) {
					
											arg=new DTDataTypeProxy(varType,theContext.getCurrentScope(),1);
											//arg=new DTArray1DProxy(varType,theContext.getCurrentScope());
											//#parameterDeclaration = #([ARRAY1D_PROXY], #parameterDeclaration);
										
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			break;
		}
		case RPAREN:
		case COMMA:
		case EOL:
		{
			if ( inputState.guessing==0 ) {
				
									arg=new DTDataTypeProxy(varType,theContext.getCurrentScope(),0);
									//#parameterDeclaration = #([VAR_PROXY], #parameterDeclaration);
								
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			parameterDeclaration_AST = (AST)currentAST.root;
			
							parameterDeclaration_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VAR_PROXY)).add(parameterDeclaration_AST));
							theContext.insertVariable(v_AST.getText(),arg);
						
			currentAST.root = parameterDeclaration_AST;
			currentAST.child = parameterDeclaration_AST!=null &&parameterDeclaration_AST.getFirstChild()!=null ?
				parameterDeclaration_AST.getFirstChild() : parameterDeclaration_AST;
			currentAST.advanceChildToEnd();
		}
		parameterDeclaration_AST = (AST)currentAST.root;
		returnAST = parameterDeclaration_AST;
		return arg;
	}
	
	public final int  newVariable() throws RecognitionException, TokenStreamException {
		int t;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newVariable_AST = null;
		t=0;
		
		switch ( LA(1)) {
		case INT_VAR:
		{
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
			match(INT_VAR);
			if ( inputState.guessing==0 ) {
				t=INT_VAR;
			}
			newVariable_AST = (AST)currentAST.root;
			break;
		}
		case STR_VAR:
		{
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(STR_VAR);
			if ( inputState.guessing==0 ) {
				t=STR_VAR;
			}
			newVariable_AST = (AST)currentAST.root;
			break;
		}
		case FLT_VAR:
		{
			AST tmp99_AST = null;
			tmp99_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp99_AST);
			match(FLT_VAR);
			if ( inputState.guessing==0 ) {
				t=FLT_VAR;
			}
			newVariable_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		{
			AST tmp100_AST = null;
			tmp100_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp100_AST);
			match(IDENT);
			if ( inputState.guessing==0 ) {
				t=FLT_VAR;
			}
			newVariable_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = newVariable_AST;
		return t;
	}
	
	public final void forNextBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forNextBlock_AST = null;
		
		match(TK_for);
		{
		forFrom();
		astFactory.addASTChild(currentAST, returnAST);
		forTo();
		astFactory.addASTChild(currentAST, returnAST);
		forBy();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		forBody();
		astFactory.addASTChild(currentAST, returnAST);
		}
		if ( inputState.guessing==0 ) {
			forNextBlock_AST = (AST)currentAST.root;
			forNextBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_LOOP,"FOR_LOOP")).add(forNextBlock_AST));
			currentAST.root = forNextBlock_AST;
			currentAST.child = forNextBlock_AST!=null &&forNextBlock_AST.getFirstChild()!=null ?
				forNextBlock_AST.getFirstChild() : forNextBlock_AST;
			currentAST.advanceChildToEnd();
		}
		forNextBlock_AST = (AST)currentAST.root;
		returnAST = forNextBlock_AST;
	}
	
	public final void doUntilLoopBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST doUntilLoopBlock_AST = null;
		
		match(TK_do);
		AST tmp103_AST = null;
		tmp103_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp103_AST);
		match(TK_until);
		condition();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_loop);
		eol();
		doUntilLoopBlock_AST = (AST)currentAST.root;
		returnAST = doUntilLoopBlock_AST;
	}
	
	public final void doLoopUntilBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST doLoopUntilBlock_AST = null;
		
		AST tmp105_AST = null;
		tmp105_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp105_AST);
		match(TK_do);
		eol();
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_loop);
		match(TK_until);
		condition();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		doLoopUntilBlock_AST = (AST)currentAST.root;
		returnAST = doLoopUntilBlock_AST;
	}
	
	public final void selectCaseBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selectCaseBlock_AST = null;
		
		AST tmp108_AST = null;
		tmp108_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp108_AST);
		match(TK_select);
		match(TK_case);
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19708:
		do {
			if ((LA(1)==TK_case)) {
				casesGroup();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19708;
			}
			
		} while (true);
		}
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp110_AST = null;
		tmp110_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp110_AST);
		match(TK_end);
		AST tmp111_AST = null;
		tmp111_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp111_AST);
		match(TK_select);
		eol();
		selectCaseBlock_AST = (AST)currentAST.root;
		returnAST = selectCaseBlock_AST;
	}
	
	public final void eventCompoundStatements() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST eventCompoundStatements_AST = null;
		Token  w = null;
		AST w_AST = null;
		
		w = LT(1);
		w_AST = astFactory.create(w);
		astFactory.makeASTRoot(currentAST, w_AST);
		match(TK_when);
		AST tmp112_AST = null;
		tmp112_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp112_AST);
		match(TK_error);
		{
		switch ( LA(1)) {
		case TK_call:
		{
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp113_AST);
			match(TK_call);
			subName();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			eol();
			if ( inputState.guessing==0 ) {
				w_AST.setType(WHEN_ERROR_CALL);
			}
			break;
		}
		case TK_in:
		{
			match(TK_in);
			eol();
			if ( inputState.guessing==0 ) {
				w_AST.setType(WHEN_ERROR_IN);
			}
			{
			int _cnt19818=0;
			_loop19818:
			do {
				if ((_tokenSet_20.member(LA(1)))) {
					singleStatement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt19818>=1 ) { break _loop19818; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19818++;
			} while (true);
			}
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp117_AST);
			match(TK_use);
			eol();
			{
			int _cnt19820=0;
			_loop19820:
			do {
				if ((_tokenSet_20.member(LA(1)))) {
					singleStatement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt19820>=1 ) { break _loop19820; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19820++;
			} while (true);
			}
			{
			switch ( LA(1)) {
			case TK_end:
			{
				match(TK_end);
				match(TK_when);
				break;
			}
			case TK_endwhen:
			{
				match(TK_endwhen);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			eol();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		eventCompoundStatements_AST = (AST)currentAST.root;
		returnAST = eventCompoundStatements_AST;
	}
	
	public final void ifThenBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ifThenBlock_AST = null;
		
		ifBlock();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19680:
		do {
			if ((_tokenSet_21.member(LA(1))) && (_tokenSet_22.member(LA(2))) && (_tokenSet_23.member(LA(3))) && (_tokenSet_24.member(LA(4)))) {
				elseIfBlock();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19680;
			}
			
		} while (true);
		}
		{
		if ((LA(1)==TK_else||LA(1)==INT_CONST||LA(1)==IDENT) && (LA(2)==TK_else||LA(2)==COLON||LA(2)==EOL) && (_tokenSet_25.member(LA(3))) && (_tokenSet_26.member(LA(4)))) {
			elseBlock();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_27.member(LA(1))) && (_tokenSet_28.member(LA(2))) && (_tokenSet_29.member(LA(3))) && (_tokenSet_30.member(LA(4)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		endIfBlock();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			ifThenBlock_AST = (AST)currentAST.root;
			ifThenBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IF_THEN_BLOCK,"IF_THEN_BLOCK")).add(ifThenBlock_AST));
			currentAST.root = ifThenBlock_AST;
			currentAST.child = ifThenBlock_AST!=null &&ifThenBlock_AST.getFirstChild()!=null ?
				ifThenBlock_AST.getFirstChild() : ifThenBlock_AST;
			currentAST.advanceChildToEnd();
		}
		ifThenBlock_AST = (AST)currentAST.root;
		returnAST = ifThenBlock_AST;
	}
	
	public final void ifBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ifBlock_AST = null;
		
		match(TK_if);
		condition();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_then);
		eol();
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			ifBlock_AST = (AST)currentAST.root;
			ifBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IF_BLOCK,"IF_BLOCK")).add(ifBlock_AST));
			currentAST.root = ifBlock_AST;
			currentAST.child = ifBlock_AST!=null &&ifBlock_AST.getFirstChild()!=null ?
				ifBlock_AST.getFirstChild() : ifBlock_AST;
			currentAST.advanceChildToEnd();
		}
		ifBlock_AST = (AST)currentAST.root;
		returnAST = ifBlock_AST;
	}
	
	public final void elseIfBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elseIfBlock_AST = null;
		
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case TK_else:
		{
			match(TK_else);
			match(TK_if);
			break;
		}
		case TK_elseif:
		{
			match(TK_elseif);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		condition();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_then);
		eol();
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			elseIfBlock_AST = (AST)currentAST.root;
			elseIfBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELSE_IF_BLOCK,"ELSE_IF_BLOCK")).add(elseIfBlock_AST));
			currentAST.root = elseIfBlock_AST;
			currentAST.child = elseIfBlock_AST!=null &&elseIfBlock_AST.getFirstChild()!=null ?
				elseIfBlock_AST.getFirstChild() : elseIfBlock_AST;
			currentAST.advanceChildToEnd();
		}
		elseIfBlock_AST = (AST)currentAST.root;
		returnAST = elseIfBlock_AST;
	}
	
	public final void elseBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elseBlock_AST = null;
		
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_else);
		eol();
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			elseBlock_AST = (AST)currentAST.root;
			elseBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELSE_BLOCK,"ELSE_BLOCK")).add(elseBlock_AST));
			currentAST.root = elseBlock_AST;
			currentAST.child = elseBlock_AST!=null &&elseBlock_AST.getFirstChild()!=null ?
				elseBlock_AST.getFirstChild() : elseBlock_AST;
			currentAST.advanceChildToEnd();
		}
		elseBlock_AST = (AST)currentAST.root;
		returnAST = elseBlock_AST;
	}
	
	public final void endIfBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST endIfBlock_AST = null;
		
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case TK_end:
		{
			match(TK_end);
			match(TK_if);
			break;
		}
		case TK_endif:
		{
			match(TK_endif);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		eol();
		endIfBlock_AST = (AST)currentAST.root;
		returnAST = endIfBlock_AST;
	}
	
	public final void ifStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ifStatement_AST = null;
		
		match(TK_if);
		condition();
		astFactory.addASTChild(currentAST, returnAST);
		match(TK_then);
		singleStatement();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		ifStatement_AST = (AST)currentAST.root;
		returnAST = ifStatement_AST;
	}
	
	public final void condition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST condition_AST = null;
		
		relationalExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			condition_AST = (AST)currentAST.root;
			condition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONDITION,"CONDITION")).add(condition_AST));
			currentAST.root = condition_AST;
			currentAST.child = condition_AST!=null &&condition_AST.getFirstChild()!=null ?
				condition_AST.getFirstChild() : condition_AST;
			currentAST.advanceChildToEnd();
		}
		condition_AST = (AST)currentAST.root;
		returnAST = condition_AST;
	}
	
	public final void relationalExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalExpression_AST = null;
		
		relationalXORExpression();
		astFactory.addASTChild(currentAST, returnAST);
		relationalExpression_AST = (AST)currentAST.root;
		returnAST = relationalExpression_AST;
	}
	
	public final void forFrom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forFrom_AST = null;
		
		numericStore();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp133_AST = null;
		tmp133_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp133_AST);
		match(EQ);
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			forFrom_AST = (AST)currentAST.root;
			forFrom_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_FROM,"FOR_FROM")).add(forFrom_AST));
			currentAST.root = forFrom_AST;
			currentAST.child = forFrom_AST!=null &&forFrom_AST.getFirstChild()!=null ?
				forFrom_AST.getFirstChild() : forFrom_AST;
			currentAST.advanceChildToEnd();
		}
		forFrom_AST = (AST)currentAST.root;
		returnAST = forFrom_AST;
	}
	
	public final void forTo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forTo_AST = null;
		
		match(TK_to);
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			forTo_AST = (AST)currentAST.root;
			forTo_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_TO,"FOR_TO")).add(forTo_AST));
			currentAST.root = forTo_AST;
			currentAST.child = forTo_AST!=null &&forTo_AST.getFirstChild()!=null ?
				forTo_AST.getFirstChild() : forTo_AST;
			currentAST.advanceChildToEnd();
		}
		forTo_AST = (AST)currentAST.root;
		returnAST = forTo_AST;
	}
	
	public final void forBy() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forBy_AST = null;
		
		{
		switch ( LA(1)) {
		case TK_by:
		{
			match(TK_by);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				forBy_AST = (AST)currentAST.root;
				forBy_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_BY,"FOR_BY")).add(forBy_AST));
				currentAST.root = forBy_AST;
				currentAST.child = forBy_AST!=null &&forBy_AST.getFirstChild()!=null ?
					forBy_AST.getFirstChild() : forBy_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case EOL:
		{
			if ( inputState.guessing==0 ) {
				forBy_AST = (AST)currentAST.root;
				forBy_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_BY_ONE,"FOR_BY_ONE")).add(forBy_AST));
				currentAST.root = forBy_AST;
				currentAST.child = forBy_AST!=null &&forBy_AST.getFirstChild()!=null ?
					forBy_AST.getFirstChild() : forBy_AST;
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
		forBy_AST = (AST)currentAST.root;
		returnAST = forBy_AST;
	}
	
	public final void forBody() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forBody_AST = null;
		
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		nextStatement();
		if ( inputState.guessing==0 ) {
			forBody_AST = (AST)currentAST.root;
			forBody_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_BODY,"FOR_BODY")).add(forBody_AST));
			currentAST.root = forBody_AST;
			currentAST.child = forBody_AST!=null &&forBody_AST.getFirstChild()!=null ?
				forBody_AST.getFirstChild() : forBody_AST;
			currentAST.advanceChildToEnd();
		}
		forBody_AST = (AST)currentAST.root;
		returnAST = forBody_AST;
	}
	
	public final void numericStore() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericStore_AST = null;
		
		switch ( LA(1)) {
		case INT_VAR:
		{
			integerStore();
			astFactory.addASTChild(currentAST, returnAST);
			numericStore_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		case FLT_VAR:
		{
			floatStore();
			astFactory.addASTChild(currentAST, returnAST);
			numericStore_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = numericStore_AST;
	}
	
	public final void numericExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericExpression_AST = null;
		
		numericMultiplicativeExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19878:
		do {
			if ((LA(1)==MINUS||LA(1)==PLUS) && (_tokenSet_10.member(LA(2))) && (_tokenSet_31.member(LA(3))) && (_tokenSet_32.member(LA(4)))) {
				{
				switch ( LA(1)) {
				case PLUS:
				{
					AST tmp136_AST = null;
					tmp136_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp136_AST);
					match(PLUS);
					break;
				}
				case MINUS:
				{
					AST tmp137_AST = null;
					tmp137_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp137_AST);
					match(MINUS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				numericMultiplicativeExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19878;
			}
			
		} while (true);
		}
		numericExpression_AST = (AST)currentAST.root;
		returnAST = numericExpression_AST;
	}
	
	public final void nextStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nextStatement_AST = null;
		
		nl();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp138_AST = null;
		tmp138_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp138_AST);
		match(TK_next);
		numericStore();
		astFactory.addASTChild(currentAST, returnAST);
		eol();
		nextStatement_AST = (AST)currentAST.root;
		returnAST = nextStatement_AST;
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		switch ( LA(1)) {
		case INT_FN:
		case FLT_FN:
		case LPAREN:
		case INT_CONST:
		case IDENT:
		case MINUS:
		case TK_in:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			expression_AST = (AST)currentAST.root;
			break;
		}
		case STR_FN:
		case STR_CONST:
		case STR_VAR:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		{
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			expression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = expression_AST;
	}
	
	public final void casesGroup() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST casesGroup_AST = null;
		
		aCase();
		astFactory.addASTChild(currentAST, returnAST);
		codeBlock();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			casesGroup_AST = (AST)currentAST.root;
			casesGroup_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_GROUP,"CASE_GROUP")).add(casesGroup_AST));
			currentAST.root = casesGroup_AST;
			currentAST.child = casesGroup_AST!=null &&casesGroup_AST.getFirstChild()!=null ?
				casesGroup_AST.getFirstChild() : casesGroup_AST;
			currentAST.advanceChildToEnd();
		}
		casesGroup_AST = (AST)currentAST.root;
		returnAST = casesGroup_AST;
	}
	
	public final void dimensionedVariables() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST dimensionedVariables_AST = null;
		AST v_AST = null;
		AST d1_AST = null;
		AST d2_AST = null;
		AST d3_AST = null;
		DTDataType av=null; int varType=0;
		
		{
		varType=newVariable();
		v_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		match(LPAREN);
		integerExpression();
		d1_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			integerExpression();
			d2_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				integerExpression();
				d3_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					dimensionedVariables_AST = (AST)currentAST.root;
					
											av=new DTArray3D(varType,theContext.getCurrentScope());
											dimensionedVariables_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY3D,"ARRAY3D")).add(dimensionedVariables_AST));
										
					currentAST.root = dimensionedVariables_AST;
					currentAST.child = dimensionedVariables_AST!=null &&dimensionedVariables_AST.getFirstChild()!=null ?
						dimensionedVariables_AST.getFirstChild() : dimensionedVariables_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			case RPAREN:
			{
				if ( inputState.guessing==0 ) {
					dimensionedVariables_AST = (AST)currentAST.root;
					
											av=new DTArray2D(varType,theContext.getCurrentScope());
											dimensionedVariables_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY2D,"ARRAY2D")).add(dimensionedVariables_AST));
										
					currentAST.root = dimensionedVariables_AST;
					currentAST.child = dimensionedVariables_AST!=null &&dimensionedVariables_AST.getFirstChild()!=null ?
						dimensionedVariables_AST.getFirstChild() : dimensionedVariables_AST;
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
			break;
		}
		case RPAREN:
		{
			if ( inputState.guessing==0 ) {
				dimensionedVariables_AST = (AST)currentAST.root;
				
									av=new DTArray1D(varType,theContext.getCurrentScope());
									dimensionedVariables_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY1D,"ARRAY1D")).add(dimensionedVariables_AST));
								
				currentAST.root = dimensionedVariables_AST;
				currentAST.child = dimensionedVariables_AST!=null &&dimensionedVariables_AST.getFirstChild()!=null ?
					dimensionedVariables_AST.getFirstChild() : dimensionedVariables_AST;
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
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			theContext.insertVariable(v_AST.getText(),av);
		}
		}
		{
		switch ( LA(1)) {
		case COMMA:
		{
			AST tmp143_AST = null;
			tmp143_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp143_AST);
			match(COMMA);
			dimensionedVariables();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		dimensionedVariables_AST = (AST)currentAST.root;
		returnAST = dimensionedVariables_AST;
	}
	
	public final void stringExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringExpression_AST = null;
		
		stringConcatanateExpression();
		astFactory.addASTChild(currentAST, returnAST);
		stringExpression_AST = (AST)currentAST.root;
		returnAST = stringExpression_AST;
	}
	
	public final void argList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST argList_AST = null;
		
		arg();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19826:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				arg();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19826;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			argList_AST = (AST)currentAST.root;
			argList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARGLIST,"ARGLIST")).add(argList_AST));
			currentAST.root = argList_AST;
			currentAST.child = argList_AST!=null &&argList_AST.getFirstChild()!=null ?
				argList_AST.getFirstChild() : argList_AST;
			currentAST.advanceChildToEnd();
		}
		argList_AST = (AST)currentAST.root;
		returnAST = argList_AST;
	}
	
	public final void lineLabel() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST lineLabel_AST = null;
		
		switch ( LA(1)) {
		case INT_CONST:
		{
			AST tmp145_AST = null;
			tmp145_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp145_AST);
			match(INT_CONST);
			lineLabel_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		{
			AST tmp146_AST = null;
			tmp146_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp146_AST);
			match(IDENT);
			lineLabel_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = lineLabel_AST;
	}
	
	public final void callSubroutineStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST callSubroutineStatement_AST = null;
		Token  call = null;
		AST call_AST = null;
		
		call = LT(1);
		call_AST = astFactory.create(call);
		astFactory.makeASTRoot(currentAST, call_AST);
		match(TK_call);
		subName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			argList();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			break;
		}
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			call_AST.setType(SUB_EXECUTE);
		}
		callSubroutineStatement_AST = (AST)currentAST.root;
		returnAST = callSubroutineStatement_AST;
	}
	
	public final void assignmentExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignmentExpression_AST = null;
		
		switch ( LA(1)) {
		case STR_VAR:
		{
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp149_AST = null;
			tmp149_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp149_AST);
			match(EQ);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			assignmentExpression_AST = (AST)currentAST.root;
			break;
		}
		case INT_VAR:
		{
			integerStore();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp150_AST);
			match(EQ);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			assignmentExpression_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		case FLT_VAR:
		{
			floatStore();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp151_AST);
			match(EQ);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			assignmentExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = assignmentExpression_AST;
	}
	
	public final void eventSingleStatements() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST eventSingleStatements_AST = null;
		
		switch ( LA(1)) {
		case TK_error:
		{
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(TK_error);
			{
			switch ( LA(1)) {
			case TK_abort:
			{
				AST tmp153_AST = null;
				tmp153_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp153_AST);
				match(TK_abort);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case TK_retry:
			{
				AST tmp154_AST = null;
				tmp154_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp154_AST);
				match(TK_retry);
				break;
			}
			case TK_continue:
			{
				AST tmp155_AST = null;
				tmp155_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp155_AST);
				match(TK_continue);
				break;
			}
			case TK_stop:
			{
				AST tmp156_AST = null;
				tmp156_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp156_AST);
				match(TK_stop);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			eventSingleStatements_AST = (AST)currentAST.root;
			break;
		}
		case TK_on:
		{
			AST tmp157_AST = null;
			tmp157_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp157_AST);
			match(TK_on);
			{
			switch ( LA(1)) {
			case TK_event:
			{
				AST tmp158_AST = null;
				tmp158_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp158_AST);
				match(TK_event);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case TK_srq:
			{
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp159_AST);
				match(TK_srq);
				break;
			}
			case TK_timer:
			{
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp160_AST);
				match(TK_timer);
				break;
			}
			case TK_gpib:
			{
				AST tmp161_AST = null;
				tmp161_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp161_AST);
				match(TK_gpib);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp162_AST = null;
			tmp162_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp162_AST);
			match(TK_call);
			subName();
			astFactory.addASTChild(currentAST, returnAST);
			eventSingleStatements_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((LA(1)==TK_cause) && (_tokenSet_33.member(LA(2)))) {
				AST tmp163_AST = null;
				tmp163_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp163_AST);
				match(TK_cause);
				{
				switch ( LA(1)) {
				case TK_error:
				{
					AST tmp164_AST = null;
					tmp164_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp164_AST);
					match(TK_error);
					break;
				}
				case INT_FN:
				case FLT_FN:
				case LPAREN:
				case INT_CONST:
				case IDENT:
				case MINUS:
				case TK_in:
				case INT_VAR:
				case FLT_VAR:
				case TK_abs:
				case TK_acos:
				case TK_asc:
				case TK_atn:
				case TK_cos:
				case TK_dround:
				case TK_errl:
				case TK_errn:
				case TK_exp:
				case TK_fract:
				case TK_get_event:
				case TK_instr:
				case TK_int:
				case TK_ival:
				case TK_len:
				case TK_lgt:
				case TK_log:
				case TK_max:
				case TK_min:
				case TK_peek:
				case TK_pi:
				case TK_rnd:
				case TK_sgn:
				case TK_signed:
				case TK_sin:
				case TK_sqr:
				case TK_tan:
				case TK_time:
				case TK_ubound:
				case TK_val:
				case TK_andb:
				case TK_orb:
				case TK_notb:
				case TK_shiftb:
				case TK_xorb:
				case PLUS:
				case FLT_CONST:
				case BINARY_INTEGER:
				case OCTAL_INTEGER:
				case HEXADECIMAL_INTEGER:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				eventSingleStatements_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TK_cause) && (LA(2)==TK_event)) {
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp165_AST);
				match(TK_cause);
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp166_AST);
				match(TK_event);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				eventSingleStatements_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TK_disable||LA(1)==TK_enable) && (LA(2)==TK_timer||LA(2)==TK_srq||LA(2)==TK_gpib)) {
				{
				switch ( LA(1)) {
				case TK_disable:
				{
					AST tmp167_AST = null;
					tmp167_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(TK_disable);
					break;
				}
				case TK_enable:
				{
					AST tmp168_AST = null;
					tmp168_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp168_AST);
					match(TK_enable);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case TK_srq:
				{
					AST tmp169_AST = null;
					tmp169_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp169_AST);
					match(TK_srq);
					break;
				}
				case TK_timer:
				{
					AST tmp170_AST = null;
					tmp170_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp170_AST);
					match(TK_timer);
					break;
				}
				case TK_gpib:
				{
					AST tmp171_AST = null;
					tmp171_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp171_AST);
					match(TK_gpib);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case TK_discard:
				{
					AST tmp172_AST = null;
					tmp172_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp172_AST);
					match(TK_discard);
					break;
				}
				case EOL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				eventSingleStatements_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TK_disable||LA(1)==TK_enable) && (LA(2)==TK_event)) {
				{
				switch ( LA(1)) {
				case TK_disable:
				{
					AST tmp173_AST = null;
					tmp173_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp173_AST);
					match(TK_disable);
					break;
				}
				case TK_enable:
				{
					AST tmp174_AST = null;
					tmp174_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp174_AST);
					match(TK_enable);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp175_AST);
				match(TK_event);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case TK_discard:
				{
					AST tmp176_AST = null;
					tmp176_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp176_AST);
					match(TK_discard);
					break;
				}
				case EOL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				eventSingleStatements_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = eventSingleStatements_AST;
	}
	
	public final void integerExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerExpression_AST = null;
		
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		integerExpression_AST = (AST)currentAST.root;
		returnAST = integerExpression_AST;
	}
	
	public final void graphicsOutput() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST graphicsOutput_AST = null;
		
		switch ( LA(1)) {
		case TK_brush:
		{
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp177_AST);
			match(TK_brush);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_circle:
		{
			AST tmp178_AST = null;
			tmp178_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp178_AST);
			match(TK_circle);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			AST tmp182_AST = null;
			tmp182_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp182_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp183_AST = null;
				tmp183_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp183_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_clear:
		{
			AST tmp184_AST = null;
			tmp184_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp184_AST);
			match(TK_clear);
			{
			switch ( LA(1)) {
			case TK_metafileon:
			{
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp185_AST);
				match(TK_metafileon);
				break;
			}
			case TK_metafileoff:
			{
				AST tmp186_AST = null;
				tmp186_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp186_AST);
				match(TK_metafileoff);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_ellipse:
		{
			AST tmp187_AST = null;
			tmp187_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp187_AST);
			match(TK_ellipse);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp189_AST = null;
			tmp189_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp189_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			AST tmp191_AST = null;
			tmp191_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp191_AST);
			match(MINUS);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp193_AST = null;
			tmp193_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp193_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp195_AST = null;
				tmp195_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp195_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_font:
		{
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp196_AST);
			match(TK_font);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp197_AST = null;
				tmp197_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp197_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case COMMA:
				{
					AST tmp198_AST = null;
					tmp198_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp198_AST);
					match(COMMA);
					integerExpression();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case EOL:
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
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_loc:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp199_AST);
			match(TK_loc);
			integerStore();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp200_AST = null;
			tmp200_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp200_AST);
			match(COMMA);
			integerStore();
			astFactory.addASTChild(currentAST, returnAST);
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_pen:
		{
			AST tmp201_AST = null;
			tmp201_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp201_AST);
			match(TK_pen);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp202_AST = null;
			tmp202_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp202_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_picture:
		{
			AST tmp204_AST = null;
			tmp204_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp204_AST);
			match(TK_picture);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(COMMA);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp209_AST = null;
				tmp209_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp209_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_polyline:
		{
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp210_AST);
			match(TK_polyline);
			integerArrayVariable();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(LPAREN);
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(COMMA);
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp214_AST = null;
				tmp214_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp214_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_rectangle:
		{
			AST tmp215_AST = null;
			tmp215_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp215_AST);
			match(TK_rectangle);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp217_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp219_AST);
			match(MINUS);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp221_AST = null;
			tmp221_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp221_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp223_AST = null;
				tmp223_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp223_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_screen:
		{
			AST tmp224_AST = null;
			tmp224_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp224_AST);
			match(TK_screen);
			{
			switch ( LA(1)) {
			case TK_normal:
			{
				AST tmp225_AST = null;
				tmp225_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp225_AST);
				match(TK_normal);
				break;
			}
			case TK_condensed:
			{
				AST tmp226_AST = null;
				tmp226_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp226_AST);
				match(TK_condensed);
				break;
			}
			case TK_display:
			{
				AST tmp227_AST = null;
				tmp227_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp227_AST);
				match(TK_display);
				break;
			}
			case TK_zoom:
			{
				AST tmp228_AST = null;
				tmp228_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp228_AST);
				match(TK_zoom);
				break;
			}
			case TK_unzoom:
			{
				AST tmp229_AST = null;
				tmp229_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp229_AST);
				match(TK_unzoom);
				break;
			}
			case TK_close_basic:
			{
				AST tmp230_AST = null;
				tmp230_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp230_AST);
				match(TK_close_basic);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			graphicsOutput_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = graphicsOutput_AST;
	}
	
	public final void inputOutput() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inputOutput_AST = null;
		
		switch ( LA(1)) {
		case TK_close:
		{
			AST tmp231_AST = null;
			tmp231_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp231_AST);
			match(TK_close);
			{
			switch ( LA(1)) {
			case POUND:
			{
				match(POUND);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_data:
		{
			AST tmp233_AST = null;
			tmp233_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp233_AST);
			match(TK_data);
			constant();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop19748:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					constant();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop19748;
				}
				
			} while (true);
			}
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_deletefile:
		{
			AST tmp235_AST = null;
			tmp235_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(TK_deletefile);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_input:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(TK_input);
			{
			switch ( LA(1)) {
			case TK_binary:
			{
				AST tmp237_AST = null;
				tmp237_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp237_AST);
				match(TK_binary);
				{
				switch ( LA(1)) {
				case POUND:
				{
					chanNumber();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case IDENT:
				case STR_VAR:
				case INT_VAR:
				case FLT_VAR:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				binaryReadVariables();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case IDENT:
			case POUND:
			case TK_prompt:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			{
				chanAndPrompt();
				astFactory.addASTChild(currentAST, returnAST);
				inputList();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_open:
		{
			AST tmp238_AST = null;
			tmp238_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp238_AST);
			match(TK_open);
			chanNumber();
			astFactory.addASTChild(currentAST, returnAST);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt19755=0;
			_loop19755:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp239_AST = null;
					tmp239_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp239_AST);
					match(COMMA);
					{
					switch ( LA(1)) {
					case TK_access:
					{
						AST tmp240_AST = null;
						tmp240_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp240_AST);
						match(TK_access);
						{
						switch ( LA(1)) {
						case TK_input:
						{
							AST tmp241_AST = null;
							tmp241_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp241_AST);
							match(TK_input);
							break;
						}
						case TK_output:
						{
							AST tmp242_AST = null;
							tmp242_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp242_AST);
							match(TK_output);
							break;
						}
						case TK_outin:
						{
							AST tmp243_AST = null;
							tmp243_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp243_AST);
							match(TK_outin);
							break;
						}
						case TK_append:
						{
							AST tmp244_AST = null;
							tmp244_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp244_AST);
							match(TK_append);
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
					case TK_organization:
					{
						AST tmp245_AST = null;
						tmp245_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp245_AST);
						match(TK_organization);
						{
						switch ( LA(1)) {
						case TK_sequential:
						{
							AST tmp246_AST = null;
							tmp246_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp246_AST);
							match(TK_sequential);
							break;
						}
						case TK_random:
						{
							AST tmp247_AST = null;
							tmp247_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp247_AST);
							match(TK_random);
							break;
						}
						case TK_stream:
						{
							AST tmp248_AST = null;
							tmp248_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp248_AST);
							match(TK_stream);
							break;
						}
						case TK_append:
						{
							AST tmp249_AST = null;
							tmp249_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp249_AST);
							match(TK_append);
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
					case TK_recsize:
					{
						AST tmp250_AST = null;
						tmp250_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp250_AST);
						match(TK_recsize);
						integerExpression();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					if ( _cnt19755>=1 ) { break _loop19755; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19755++;
			} while (true);
			}
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_read:
		{
			AST tmp251_AST = null;
			tmp251_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp251_AST);
			match(TK_read);
			inputList();
			astFactory.addASTChild(currentAST, returnAST);
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		case TK_restore:
		{
			AST tmp252_AST = null;
			tmp252_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp252_AST);
			match(TK_restore);
			inputOutput_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((LA(1)==TK_print) && (_tokenSet_34.member(LA(2)))) {
				print_ascii();
				astFactory.addASTChild(currentAST, returnAST);
				inputOutput_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==TK_print) && (LA(2)==TK_binary)) {
				AST tmp253_AST = null;
				tmp253_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp253_AST);
				match(TK_print);
				AST tmp254_AST = null;
				tmp254_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp254_AST);
				match(TK_binary);
				{
				switch ( LA(1)) {
				case POUND:
				{
					chanNumber();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case INT_FN:
				case STR_FN:
				case FLT_FN:
				case LPAREN:
				case STR_CONST:
				case INT_CONST:
				case IDENT:
				case TK_tab:
				case MINUS:
				case TK_in:
				case STR_VAR:
				case INT_VAR:
				case FLT_VAR:
				case TK_abs:
				case TK_acos:
				case TK_asc:
				case TK_atn:
				case TK_cos:
				case TK_dround:
				case TK_errl:
				case TK_errn:
				case TK_exp:
				case TK_fract:
				case TK_get_event:
				case TK_instr:
				case TK_int:
				case TK_ival:
				case TK_len:
				case TK_lgt:
				case TK_log:
				case TK_max:
				case TK_min:
				case TK_peek:
				case TK_pi:
				case TK_rnd:
				case TK_sgn:
				case TK_signed:
				case TK_sin:
				case TK_sqr:
				case TK_tan:
				case TK_time:
				case TK_ubound:
				case TK_val:
				case TK_andb:
				case TK_orb:
				case TK_notb:
				case TK_shiftb:
				case TK_xorb:
				case 219:
				case 220:
				case 221:
				case 222:
				case 223:
				case 224:
				case 225:
				case 226:
				case 227:
				case 228:
				case 229:
				case 230:
				case PLUS:
				case FLT_CONST:
				case BINARY_INTEGER:
				case OCTAL_INTEGER:
				case HEXADECIMAL_INTEGER:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				printList();
				astFactory.addASTChild(currentAST, returnAST);
				inputOutput_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = inputOutput_AST;
	}
	
	public final void line_stuff() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST line_stuff_AST = null;
		
		AST tmp255_AST = null;
		tmp255_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp255_AST);
		match(TK_line);
		{
		switch ( LA(1)) {
		case TK_input:
		{
			AST tmp256_AST = null;
			tmp256_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp256_AST);
			match(TK_input);
			{
			switch ( LA(1)) {
			case POUND:
			{
				chanNumber();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STR_VAR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_enter:
		{
			AST tmp257_AST = null;
			tmp257_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp257_AST);
			match(TK_enter);
			combinationAddress();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case TK_prompt:
			{
				prompt();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STR_VAR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case TK_until:
			{
				AST tmp258_AST = null;
				tmp258_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp258_AST);
				match(TK_until);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
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
		case LPAREN:
		case MINUS:
		{
			{
			switch ( LA(1)) {
			case LPAREN:
			{
				match(LPAREN);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp260_AST = null;
				tmp260_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp260_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				break;
			}
			case MINUS:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp262_AST = null;
			tmp262_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp262_AST);
			match(MINUS);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp264_AST = null;
			tmp264_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp264_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				AST tmp266_AST = null;
				tmp266_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp266_AST);
				match(COMMA);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
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
		line_stuff_AST = (AST)currentAST.root;
		returnAST = line_stuff_AST;
	}
	
	public final void set_stuff() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST set_stuff_AST = null;
		
		AST tmp267_AST = null;
		tmp267_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp267_AST);
		match(TK_set);
		{
		switch ( LA(1)) {
		case TK_timer:
		{
			AST tmp268_AST = null;
			tmp268_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp268_AST);
			match(TK_timer);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_loc:
		{
			AST tmp269_AST = null;
			tmp269_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp269_AST);
			match(TK_loc);
			AST tmp270_AST = null;
			tmp270_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp270_AST);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp271_AST = null;
			tmp271_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp271_AST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp272_AST = null;
			tmp272_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp272_AST);
			match(RPAREN);
			break;
		}
		case POUND:
		case TK_margin:
		case TK_zonewidth:
		case TK_address:
		case TK_record:
		{
			{
			switch ( LA(1)) {
			case POUND:
			{
				chanNumber();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case TK_margin:
			case TK_zonewidth:
			case TK_address:
			case TK_record:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			specifier();
			astFactory.addASTChild(currentAST, returnAST);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		set_stuff_AST = (AST)currentAST.root;
		returnAST = set_stuff_AST;
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case STR_CONST:
		{
			stringConstant();
			astFactory.addASTChild(currentAST, returnAST);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case INT_CONST:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			floatNumber();
			astFactory.addASTChild(currentAST, returnAST);
			constant_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = constant_AST;
	}
	
	public final void stringConstant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringConstant_AST = null;
		
		AST tmp273_AST = null;
		tmp273_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp273_AST);
		match(STR_CONST);
		stringConstant_AST = (AST)currentAST.root;
		returnAST = stringConstant_AST;
	}
	
	public final void floatNumber() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST floatNumber_AST = null;
		
		switch ( LA(1)) {
		case INT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			integerNumber();
			astFactory.addASTChild(currentAST, returnAST);
			floatNumber_AST = (AST)currentAST.root;
			break;
		}
		case FLT_CONST:
		{
			AST tmp274_AST = null;
			tmp274_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp274_AST);
			match(FLT_CONST);
			floatNumber_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = floatNumber_AST;
	}
	
	public final void binaryReadVariables() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST binaryReadVariables_AST = null;
		
		{
		switch ( LA(1)) {
		case IDENT:
		case INT_VAR:
		case FLT_VAR:
		{
			numericStore();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case STR_VAR:
		{
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp275_AST = null;
			tmp275_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp275_AST);
			match(TK_until);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case COMMA:
		{
			AST tmp276_AST = null;
			tmp276_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp276_AST);
			match(COMMA);
			binaryReadVariables();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		binaryReadVariables_AST = (AST)currentAST.root;
		returnAST = binaryReadVariables_AST;
	}
	
	public final void stringStore() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringStore_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		boolean synPredMatched19837 = false;
		if ((((LA(1)==STR_VAR) && (LA(2)==LPAREN) && (_tokenSet_10.member(LA(3))) && (_tokenSet_35.member(LA(4))))&&(theContext.isArrayVariable(LT(1).getText())))) {
			int _m19837 = mark();
			synPredMatched19837 = true;
			inputState.guessing++;
			try {
				{
				stringVariable();
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19837 = false;
			}
			rewind(_m19837);
			inputState.guessing--;
		}
		if ( synPredMatched19837 ) {
			stringVariable();
			astFactory.addASTChild(currentAST, returnAST);
			lp = LT(1);
			lp_AST = astFactory.create(lp);
			astFactory.makeASTRoot(currentAST, lp_AST);
			match(LPAREN);
			if ( inputState.guessing==0 ) {
				lp_AST.setType(INDEX_OP);
			}
			indices();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp277_AST = null;
			tmp277_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp277_AST);
			match(RPAREN);
			stringStore_AST = (AST)currentAST.root;
		}
		else {
			boolean synPredMatched19839 = false;
			if (((LA(1)==STR_VAR) && (LA(2)==LBRACK))) {
				int _m19839 = mark();
				synPredMatched19839 = true;
				inputState.guessing++;
				try {
					{
					stringVariable();
					match(LBRACK);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched19839 = false;
				}
				rewind(_m19839);
				inputState.guessing--;
			}
			if ( synPredMatched19839 ) {
				stringVariable();
				astFactory.addASTChild(currentAST, returnAST);
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(SUBSTRING_OP);
				}
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				match(COLON);
				integerExpression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RBRACK);
				stringStore_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==STR_VAR) && (_tokenSet_36.member(LA(2))) && (_tokenSet_37.member(LA(3))) && (_tokenSet_38.member(LA(4)))) {
				stringVariable();
				astFactory.addASTChild(currentAST, returnAST);
				stringStore_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = stringStore_AST;
		}
		
	public final void printList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST printList_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  s = null;
		AST s_AST = null;
		
		{
		switch ( LA(1)) {
		case TK_tab:
		{
			tabExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case STR_FN:
		case STR_CONST:
		case STR_VAR:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		{
			printString();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case INT_FN:
		case FLT_FN:
		case LPAREN:
		case INT_CONST:
		case IDENT:
		case MINUS:
		case TK_in:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			printNumeric();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case COMMA:
		case SEMI:
		{
			{
			switch ( LA(1)) {
			case COMMA:
			{
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				match(COMMA);
				if ( inputState.guessing==0 ) {
					c_AST.setType(PRINT_COMMA);
				}
				break;
			}
			case SEMI:
			{
				s = LT(1);
				s_AST = astFactory.create(s);
				astFactory.addASTChild(currentAST, s_AST);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					s_AST.setType(PRINT_SEMI);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case INT_FN:
			case STR_FN:
			case FLT_FN:
			case LPAREN:
			case STR_CONST:
			case INT_CONST:
			case IDENT:
			case TK_tab:
			case MINUS:
			case TK_in:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			case TK_abs:
			case TK_acos:
			case TK_asc:
			case TK_atn:
			case TK_cos:
			case TK_dround:
			case TK_errl:
			case TK_errn:
			case TK_exp:
			case TK_fract:
			case TK_get_event:
			case TK_instr:
			case TK_int:
			case TK_ival:
			case TK_len:
			case TK_lgt:
			case TK_log:
			case TK_max:
			case TK_min:
			case TK_peek:
			case TK_pi:
			case TK_rnd:
			case TK_sgn:
			case TK_signed:
			case TK_sin:
			case TK_sqr:
			case TK_tan:
			case TK_time:
			case TK_ubound:
			case TK_val:
			case TK_andb:
			case TK_orb:
			case TK_notb:
			case TK_shiftb:
			case TK_xorb:
			case 219:
			case 220:
			case 221:
			case 222:
			case 223:
			case 224:
			case 225:
			case 226:
			case 227:
			case 228:
			case 229:
			case 230:
			case PLUS:
			case FLT_CONST:
			case BINARY_INTEGER:
			case OCTAL_INTEGER:
			case HEXADECIMAL_INTEGER:
			{
				printList();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOL:
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
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		printList_AST = (AST)currentAST.root;
		returnAST = printList_AST;
	}
	
	public final void tabExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tabExpression_AST = null;
		
		match(TK_tab);
		match(LPAREN);
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			tabExpression_AST = (AST)currentAST.root;
			tabExpression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRINT_TAB,"PRINT_TAB")).add(tabExpression_AST));
			currentAST.root = tabExpression_AST;
			currentAST.child = tabExpression_AST!=null &&tabExpression_AST.getFirstChild()!=null ?
				tabExpression_AST.getFirstChild() : tabExpression_AST;
			currentAST.advanceChildToEnd();
		}
		tabExpression_AST = (AST)currentAST.root;
		returnAST = tabExpression_AST;
	}
	
	public final void printString() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST printString_AST = null;
		
		stringExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			printString_AST = (AST)currentAST.root;
			printString_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRINT_STRING,"PRINT_STRING")).add(printString_AST));
			currentAST.root = printString_AST;
			currentAST.child = printString_AST!=null &&printString_AST.getFirstChild()!=null ?
				printString_AST.getFirstChild() : printString_AST;
			currentAST.advanceChildToEnd();
		}
		printString_AST = (AST)currentAST.root;
		returnAST = printString_AST;
	}
	
	public final void printNumeric() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST printNumeric_AST = null;
		
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			printNumeric_AST = (AST)currentAST.root;
			printNumeric_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRINT_NUMERIC,"PRINT_NUMERIC")).add(printNumeric_AST));
			currentAST.root = printNumeric_AST;
			currentAST.child = printNumeric_AST!=null &&printNumeric_AST.getFirstChild()!=null ?
				printNumeric_AST.getFirstChild() : printNumeric_AST;
			currentAST.advanceChildToEnd();
		}
		printNumeric_AST = (AST)currentAST.root;
		returnAST = printNumeric_AST;
	}
	
	public final void inputList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inputList_AST = null;
		
		{
		switch ( LA(1)) {
		case IDENT:
		case INT_VAR:
		case FLT_VAR:
		{
			numericStore();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case STR_VAR:
		{
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case COMMA:
		{
			AST tmp283_AST = null;
			tmp283_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp283_AST);
			match(COMMA);
			inputList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		inputList_AST = (AST)currentAST.root;
		returnAST = inputList_AST;
	}
	
	public final void chanNumber() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST chanNumber_AST = null;
		
		AST tmp284_AST = null;
		tmp284_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp284_AST);
		match(POUND);
		integerExpression();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp285_AST = null;
		tmp285_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp285_AST);
		match(COLON);
		chanNumber_AST = (AST)currentAST.root;
		returnAST = chanNumber_AST;
	}
	
	public final void chanAndPrompt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST chanAndPrompt_AST = null;
		
		{
		switch ( LA(1)) {
		case POUND:
		{
			chanNumber();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case IDENT:
		case TK_prompt:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
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
		switch ( LA(1)) {
		case TK_prompt:
		{
			prompt();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case IDENT:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		chanAndPrompt_AST = (AST)currentAST.root;
		returnAST = chanAndPrompt_AST;
	}
	
	public final void print_ascii() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST print_ascii_AST = null;
		
		match(TK_print);
		{
		switch ( LA(1)) {
		case POUND:
		{
			chanNumber();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case INT_FN:
		case STR_FN:
		case FLT_FN:
		case LPAREN:
		case STR_CONST:
		case INT_CONST:
		case IDENT:
		case TK_tab:
		case TK_using:
		case MINUS:
		case TK_in:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
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
		switch ( LA(1)) {
		case TK_using:
		{
			AST tmp287_AST = null;
			tmp287_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp287_AST);
			match(TK_using);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case INT_FN:
		case STR_FN:
		case FLT_FN:
		case LPAREN:
		case STR_CONST:
		case INT_CONST:
		case IDENT:
		case TK_tab:
		case MINUS:
		case TK_in:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		printList();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			print_ascii_AST = (AST)currentAST.root;
			print_ascii_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PRINT_ASCII,"PRINT_ASCII")).add(print_ascii_AST));
			currentAST.root = print_ascii_AST;
			currentAST.child = print_ascii_AST!=null &&print_ascii_AST.getFirstChild()!=null ?
				print_ascii_AST.getFirstChild() : print_ascii_AST;
			currentAST.advanceChildToEnd();
		}
		print_ascii_AST = (AST)currentAST.root;
		returnAST = print_ascii_AST;
	}
	
	public final void specifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST specifier_AST = null;
		
		switch ( LA(1)) {
		case TK_margin:
		{
			AST tmp288_AST = null;
			tmp288_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp288_AST);
			match(TK_margin);
			specifier_AST = (AST)currentAST.root;
			break;
		}
		case TK_zonewidth:
		{
			AST tmp289_AST = null;
			tmp289_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp289_AST);
			match(TK_zonewidth);
			specifier_AST = (AST)currentAST.root;
			break;
		}
		case TK_address:
		{
			AST tmp290_AST = null;
			tmp290_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp290_AST);
			match(TK_address);
			specifier_AST = (AST)currentAST.root;
			break;
		}
		case TK_record:
		{
			AST tmp291_AST = null;
			tmp291_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp291_AST);
			match(TK_record);
			specifier_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = specifier_AST;
	}
	
	public final void prompt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST prompt_AST = null;
		
		AST tmp292_AST = null;
		tmp292_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp292_AST);
		match(TK_prompt);
		stringExpression();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp293_AST = null;
		tmp293_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp293_AST);
		match(COLON);
		prompt_AST = (AST)currentAST.root;
		returnAST = prompt_AST;
	}
	
	public final void aCase() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aCase_AST = null;
		
		AST tmp294_AST = null;
		tmp294_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp294_AST);
		match(TK_case);
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19783:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19783;
			}
			
		} while (true);
		}
		eol();
		aCase_AST = (AST)currentAST.root;
		returnAST = aCase_AST;
	}
	
	public final void integerArray() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerArray_AST = null;
		
		argArray();
		astFactory.addASTChild(currentAST, returnAST);
		integerArray_AST = (AST)currentAST.root;
		returnAST = integerArray_AST;
	}
	
	public final void argArray() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST argArray_AST = null;
		AST v23_AST = null;
		AST v1_AST = null;
		
		boolean synPredMatched19832 = false;
		if (((_tokenSet_39.member(LA(1))) && (LA(2)==LPAREN||LA(2)==LBRACK) && (_tokenSet_40.member(LA(3))) && (_tokenSet_41.member(LA(4))))) {
			int _m19832 = mark();
			synPredMatched19832 = true;
			inputState.guessing++;
			try {
				{
				variable();
				match(LPAREN);
				match(COMMA);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19832 = false;
			}
			rewind(_m19832);
			inputState.guessing--;
		}
		if ( synPredMatched19832 ) {
			variable();
			v23_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			match(COMMA);
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				if ( inputState.guessing==0 ) {
					v23_AST.setType(ARRAY3D);
				}
				break;
			}
			case RPAREN:
			{
				if ( inputState.guessing==0 ) {
					v23_AST.setType(ARRAY2D);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			argArray_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_39.member(LA(1))) && (LA(2)==LPAREN||LA(2)==LBRACK) && (_tokenSet_42.member(LA(3))) && (_tokenSet_43.member(LA(4)))) {
			variable();
			v1_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp300_AST = null;
			tmp300_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp300_AST);
			match(LPAREN);
			AST tmp301_AST = null;
			tmp301_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp301_AST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				v1_AST.setType(ARRAY1D);
			}
			argArray_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = argArray_AST;
	}
	
	public final void symbolicAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST symbolicAddress_AST = null;
		
		stringExpression();
		astFactory.addASTChild(currentAST, returnAST);
		symbolicAddress_AST = (AST)currentAST.root;
		returnAST = symbolicAddress_AST;
	}
	
	public final void deviceAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST deviceAddress_AST = null;
		
		{
		switch ( LA(1)) {
		case STR_FN:
		case STR_CONST:
		case 132:
		case STR_VAR:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		{
			adapterAddress();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			break;
		}
		case INT_FN:
		case FLT_FN:
		case LPAREN:
		case INT_CONST:
		case IDENT:
		case MINUS:
		case TK_in:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		primaryAddress();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			secondaryAddress();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TK_prompt:
		case STR_VAR:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		deviceAddress_AST = (AST)currentAST.root;
		returnAST = deviceAddress_AST;
	}
	
	public final void adapterAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST adapterAddress_AST = null;
		
		switch ( LA(1)) {
		case STR_FN:
		case STR_CONST:
		case STR_VAR:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		{
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			adapterAddress_AST = (AST)currentAST.root;
			break;
		}
		case 132:
		{
			AST tmp304_AST = null;
			tmp304_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp304_AST);
			match(132);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			adapterAddress_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = adapterAddress_AST;
	}
	
	public final void primaryAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primaryAddress_AST = null;
		
		integerExpression();
		astFactory.addASTChild(currentAST, returnAST);
		primaryAddress_AST = (AST)currentAST.root;
		returnAST = primaryAddress_AST;
	}
	
	public final void secondaryAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST secondaryAddress_AST = null;
		
		integerExpression();
		astFactory.addASTChild(currentAST, returnAST);
		secondaryAddress_AST = (AST)currentAST.root;
		returnAST = secondaryAddress_AST;
	}
	
	public final void combinationAddress() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST combinationAddress_AST = null;
		
		boolean synPredMatched19780 = false;
		if (((_tokenSet_44.member(LA(1))) && (_tokenSet_45.member(LA(2))) && (_tokenSet_46.member(LA(3))) && (_tokenSet_47.member(LA(4))))) {
			int _m19780 = mark();
			synPredMatched19780 = true;
			inputState.guessing++;
			try {
				{
				deviceAddress();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19780 = false;
			}
			rewind(_m19780);
			inputState.guessing--;
		}
		if ( synPredMatched19780 ) {
			deviceAddress();
			astFactory.addASTChild(currentAST, returnAST);
			combinationAddress_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_48.member(LA(1))) && (_tokenSet_49.member(LA(2))) && (_tokenSet_50.member(LA(3))) && (_tokenSet_47.member(LA(4)))) {
			adapterAddress();
			astFactory.addASTChild(currentAST, returnAST);
			combinationAddress_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = combinationAddress_AST;
	}
	
	public final void integerArrayVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerArrayVariable_AST = null;
		
		integerVariable();
		astFactory.addASTChild(currentAST, returnAST);
		integerArrayVariable_AST = (AST)currentAST.root;
		returnAST = integerArrayVariable_AST;
	}
	
	public final void integerVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerVariable_AST = null;
		
		AST tmp305_AST = null;
		tmp305_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp305_AST);
		match(INT_VAR);
		integerVariable_AST = (AST)currentAST.root;
		returnAST = integerVariable_AST;
	}
	
	public final void stringArrayVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringArrayVariable_AST = null;
		
		stringVariable();
		astFactory.addASTChild(currentAST, returnAST);
		stringArrayVariable_AST = (AST)currentAST.root;
		returnAST = stringArrayVariable_AST;
	}
	
	public final void stringVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringVariable_AST = null;
		
		AST tmp306_AST = null;
		tmp306_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp306_AST);
		match(STR_VAR);
		stringVariable_AST = (AST)currentAST.root;
		returnAST = stringVariable_AST;
	}
	
	public final void floatArrayVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST floatArrayVariable_AST = null;
		
		floatVariable();
		astFactory.addASTChild(currentAST, returnAST);
		floatArrayVariable_AST = (AST)currentAST.root;
		returnAST = floatArrayVariable_AST;
	}
	
	public final void floatVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST floatVariable_AST = null;
		
		{
		switch ( LA(1)) {
		case FLT_VAR:
		{
			AST tmp307_AST = null;
			tmp307_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp307_AST);
			match(FLT_VAR);
			break;
		}
		case IDENT:
		{
			AST tmp308_AST = null;
			tmp308_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp308_AST);
			match(IDENT);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		floatVariable_AST = (AST)currentAST.root;
		returnAST = floatVariable_AST;
	}
	
	public final void arrayVariable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arrayVariable_AST = null;
		
		switch ( LA(1)) {
		case INT_VAR:
		{
			integerArrayVariable();
			astFactory.addASTChild(currentAST, returnAST);
			arrayVariable_AST = (AST)currentAST.root;
			break;
		}
		case STR_VAR:
		{
			stringArrayVariable();
			astFactory.addASTChild(currentAST, returnAST);
			arrayVariable_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		case FLT_VAR:
		{
			floatArrayVariable();
			astFactory.addASTChild(currentAST, returnAST);
			arrayVariable_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = arrayVariable_AST;
	}
	
	public final void integerStore() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerStore_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		
		boolean synPredMatched19842 = false;
		if ((((LA(1)==INT_VAR) && (LA(2)==LPAREN) && (_tokenSet_10.member(LA(3))) && (_tokenSet_35.member(LA(4))))&&(theContext.isArrayVariable(LT(1).getText())))) {
			int _m19842 = mark();
			synPredMatched19842 = true;
			inputState.guessing++;
			try {
				{
				integerVariable();
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19842 = false;
			}
			rewind(_m19842);
			inputState.guessing--;
		}
		if ( synPredMatched19842 ) {
			integerVariable();
			astFactory.addASTChild(currentAST, returnAST);
			lp = LT(1);
			lp_AST = astFactory.create(lp);
			astFactory.makeASTRoot(currentAST, lp_AST);
			match(LPAREN);
			if ( inputState.guessing==0 ) {
				lp_AST.setType(INDEX_OP);
			}
			indices();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			integerStore_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==INT_VAR) && (_tokenSet_31.member(LA(2))) && (_tokenSet_32.member(LA(3))) && (_tokenSet_38.member(LA(4)))) {
			integerVariable();
			astFactory.addASTChild(currentAST, returnAST);
			integerStore_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = integerStore_AST;
	}
	
	public final void arg() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arg_AST = null;
		
		boolean synPredMatched19829 = false;
		if (((_tokenSet_39.member(LA(1))) && (LA(2)==LPAREN||LA(2)==LBRACK) && (_tokenSet_51.member(LA(3))) && (_tokenSet_41.member(LA(4))))) {
			int _m19829 = mark();
			synPredMatched19829 = true;
			inputState.guessing++;
			try {
				{
				argArray();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19829 = false;
			}
			rewind(_m19829);
			inputState.guessing--;
		}
		if ( synPredMatched19829 ) {
			argArray();
			astFactory.addASTChild(currentAST, returnAST);
			arg_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_52.member(LA(1))) && (_tokenSet_53.member(LA(2))) && (_tokenSet_54.member(LA(3))) && (_tokenSet_32.member(LA(4)))) {
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			arg_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = arg_AST;
	}
	
	public final void variable() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variable_AST = null;
		
		switch ( LA(1)) {
		case IDENT:
		case INT_VAR:
		case FLT_VAR:
		{
			numericStore();
			astFactory.addASTChild(currentAST, returnAST);
			variable_AST = (AST)currentAST.root;
			break;
		}
		case STR_VAR:
		{
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			variable_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = variable_AST;
	}
	
	public final void floatStore() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST floatStore_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		
		boolean synPredMatched19845 = false;
		if ((((LA(1)==IDENT||LA(1)==FLT_VAR) && (LA(2)==LPAREN) && (_tokenSet_10.member(LA(3))) && (_tokenSet_35.member(LA(4))))&&(theContext.isArrayVariable(LT(1).getText())))) {
			int _m19845 = mark();
			synPredMatched19845 = true;
			inputState.guessing++;
			try {
				{
				floatVariable();
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19845 = false;
			}
			rewind(_m19845);
			inputState.guessing--;
		}
		if ( synPredMatched19845 ) {
			floatVariable();
			astFactory.addASTChild(currentAST, returnAST);
			lp = LT(1);
			lp_AST = astFactory.create(lp);
			astFactory.makeASTRoot(currentAST, lp_AST);
			match(LPAREN);
			if ( inputState.guessing==0 ) {
				lp_AST.setType(INDEX_OP);
			}
			indices();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			floatStore_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==IDENT||LA(1)==FLT_VAR) && (_tokenSet_31.member(LA(2))) && (_tokenSet_32.member(LA(3))) && (_tokenSet_38.member(LA(4)))) {
			floatVariable();
			astFactory.addASTChild(currentAST, returnAST);
			floatStore_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = floatStore_AST;
	}
	
	public final void indices() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST indices_AST = null;
		
		numericExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			indices();
			astFactory.addASTChild(currentAST, returnAST);
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
		indices_AST = (AST)currentAST.root;
		returnAST = indices_AST;
	}
	
	public final void relationalXORExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalXORExpression_AST = null;
		
		relationalORExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19854:
		do {
			if ((LA(1)==TK_xor)) {
				AST tmp312_AST = null;
				tmp312_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp312_AST);
				match(TK_xor);
				relationalORExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19854;
			}
			
		} while (true);
		}
		relationalXORExpression_AST = (AST)currentAST.root;
		returnAST = relationalXORExpression_AST;
	}
	
	public final void relationalORExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalORExpression_AST = null;
		
		relationalANDExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19857:
		do {
			if ((LA(1)==TK_or)) {
				AST tmp313_AST = null;
				tmp313_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp313_AST);
				match(TK_or);
				relationalANDExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19857;
			}
			
		} while (true);
		}
		relationalORExpression_AST = (AST)currentAST.root;
		returnAST = relationalORExpression_AST;
	}
	
	public final void relationalANDExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalANDExpression_AST = null;
		
		relationalNOTExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19860:
		do {
			if ((LA(1)==TK_and)) {
				AST tmp314_AST = null;
				tmp314_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp314_AST);
				match(TK_and);
				relationalNOTExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19860;
			}
			
		} while (true);
		}
		relationalANDExpression_AST = (AST)currentAST.root;
		returnAST = relationalANDExpression_AST;
	}
	
	public final void relationalNOTExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalNOTExpression_AST = null;
		
		{
		switch ( LA(1)) {
		case TK_not:
		{
			AST tmp315_AST = null;
			tmp315_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp315_AST);
			match(TK_not);
			break;
		}
		case INT_FN:
		case STR_FN:
		case FLT_FN:
		case LPAREN:
		case STR_CONST:
		case INT_CONST:
		case IDENT:
		case MINUS:
		case TK_in:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		primaryRelationalExpression();
		astFactory.addASTChild(currentAST, returnAST);
		relationalNOTExpression_AST = (AST)currentAST.root;
		returnAST = relationalNOTExpression_AST;
	}
	
	public final void primaryRelationalExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primaryRelationalExpression_AST = null;
		Token  e1 = null;
		AST e1_AST = null;
		Token  e2 = null;
		AST e2_AST = null;
		
		boolean synPredMatched19865 = false;
		if (((_tokenSet_10.member(LA(1))) && (_tokenSet_55.member(LA(2))) && (_tokenSet_56.member(LA(3))) && (_tokenSet_57.member(LA(4))))) {
			int _m19865 = mark();
			synPredMatched19865 = true;
			inputState.guessing++;
			try {
				{
				numericExpression();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched19865 = false;
			}
			rewind(_m19865);
			inputState.guessing--;
		}
		if ( synPredMatched19865 ) {
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LT:
			{
				AST tmp316_AST = null;
				tmp316_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp316_AST);
				match(LT);
				break;
			}
			case GT:
			{
				AST tmp317_AST = null;
				tmp317_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp317_AST);
				match(GT);
				break;
			}
			case LE:
			{
				AST tmp318_AST = null;
				tmp318_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp318_AST);
				match(LE);
				break;
			}
			case GE:
			{
				AST tmp319_AST = null;
				tmp319_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp319_AST);
				match(GE);
				break;
			}
			case EQ:
			{
				e1 = LT(1);
				e1_AST = astFactory.create(e1);
				astFactory.makeASTRoot(currentAST, e1_AST);
				match(EQ);
				if ( inputState.guessing==0 ) {
					e1_AST.setType( EQ_COMP );
				}
				break;
			}
			case NE_COMP:
			{
				AST tmp320_AST = null;
				tmp320_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp320_AST);
				match(NE_COMP);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			primaryRelationalExpression_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_58.member(LA(1)))) {
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LT:
			{
				AST tmp321_AST = null;
				tmp321_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp321_AST);
				match(LT);
				break;
			}
			case GT:
			{
				AST tmp322_AST = null;
				tmp322_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp322_AST);
				match(GT);
				break;
			}
			case LE:
			{
				AST tmp323_AST = null;
				tmp323_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp323_AST);
				match(LE);
				break;
			}
			case GE:
			{
				AST tmp324_AST = null;
				tmp324_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp324_AST);
				match(GE);
				break;
			}
			case EQ:
			{
				e2 = LT(1);
				e2_AST = astFactory.create(e2);
				astFactory.makeASTRoot(currentAST, e2_AST);
				match(EQ);
				if ( inputState.guessing==0 ) {
					e2_AST.setType( EQ_COMP );
				}
				break;
			}
			case NE_COMP:
			{
				AST tmp325_AST = null;
				tmp325_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp325_AST);
				match(NE_COMP);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			primaryRelationalExpression_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LPAREN) && (_tokenSet_17.member(LA(2))) && (_tokenSet_18.member(LA(3))) && (_tokenSet_19.member(LA(4)))) {
			match(LPAREN);
			relationalExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			primaryRelationalExpression_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = primaryRelationalExpression_AST;
	}
	
	public final void numericValuedFunctionExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericValuedFunctionExpression_AST = null;
		
		switch ( LA(1)) {
		case TK_abs:
		{
			AST tmp328_AST = null;
			tmp328_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp328_AST);
			match(TK_abs);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_acos:
		{
			AST tmp331_AST = null;
			tmp331_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp331_AST);
			match(TK_acos);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_asc:
		{
			AST tmp334_AST = null;
			tmp334_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp334_AST);
			match(TK_asc);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_atn:
		{
			AST tmp337_AST = null;
			tmp337_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp337_AST);
			match(TK_atn);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_cos:
		{
			AST tmp340_AST = null;
			tmp340_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp340_AST);
			match(TK_cos);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_dround:
		{
			AST tmp343_AST = null;
			tmp343_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp343_AST);
			match(TK_dround);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_errl:
		{
			AST tmp347_AST = null;
			tmp347_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp347_AST);
			match(TK_errl);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_errn:
		{
			AST tmp348_AST = null;
			tmp348_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp348_AST);
			match(TK_errn);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_exp:
		{
			AST tmp349_AST = null;
			tmp349_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp349_AST);
			match(TK_exp);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_fract:
		{
			AST tmp352_AST = null;
			tmp352_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp352_AST);
			match(TK_fract);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_get_event:
		{
			AST tmp355_AST = null;
			tmp355_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp355_AST);
			match(TK_get_event);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_in:
		{
			AST tmp358_AST = null;
			tmp358_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp358_AST);
			match(TK_in);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_instr:
		{
			AST tmp361_AST = null;
			tmp361_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp361_AST);
			match(TK_instr);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_int:
		{
			AST tmp365_AST = null;
			tmp365_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp365_AST);
			match(TK_int);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_ival:
		{
			AST tmp368_AST = null;
			tmp368_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp368_AST);
			match(TK_ival);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_len:
		{
			AST tmp371_AST = null;
			tmp371_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp371_AST);
			match(TK_len);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_lgt:
		{
			AST tmp374_AST = null;
			tmp374_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp374_AST);
			match(TK_lgt);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_log:
		{
			AST tmp377_AST = null;
			tmp377_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp377_AST);
			match(TK_log);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_max:
		{
			AST tmp380_AST = null;
			tmp380_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp380_AST);
			match(TK_max);
			match(LPAREN);
			{
			int _cnt19870=0;
			_loop19870:
			do {
				if ((_tokenSet_10.member(LA(1)))) {
					numericExpression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt19870>=1 ) { break _loop19870; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19870++;
			} while (true);
			}
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_min:
		{
			AST tmp383_AST = null;
			tmp383_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp383_AST);
			match(TK_min);
			match(LPAREN);
			{
			int _cnt19872=0;
			_loop19872:
			do {
				if ((_tokenSet_10.member(LA(1)))) {
					numericExpression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt19872>=1 ) { break _loop19872; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt19872++;
			} while (true);
			}
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_peek:
		{
			AST tmp386_AST = null;
			tmp386_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp386_AST);
			match(TK_peek);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_pi:
		{
			AST tmp390_AST = null;
			tmp390_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp390_AST);
			match(TK_pi);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_rnd:
		{
			AST tmp391_AST = null;
			tmp391_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp391_AST);
			match(TK_rnd);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_sgn:
		{
			AST tmp392_AST = null;
			tmp392_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp392_AST);
			match(TK_sgn);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_signed:
		{
			AST tmp395_AST = null;
			tmp395_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp395_AST);
			match(TK_signed);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_sin:
		{
			AST tmp398_AST = null;
			tmp398_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp398_AST);
			match(TK_sin);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_sqr:
		{
			AST tmp401_AST = null;
			tmp401_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp401_AST);
			match(TK_sqr);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_tan:
		{
			AST tmp404_AST = null;
			tmp404_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp404_AST);
			match(TK_tan);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_time:
		{
			AST tmp407_AST = null;
			tmp407_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp407_AST);
			match(TK_time);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_ubound:
		{
			AST tmp408_AST = null;
			tmp408_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp408_AST);
			match(TK_ubound);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_val:
		{
			AST tmp412_AST = null;
			tmp412_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp412_AST);
			match(TK_val);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_andb:
		{
			AST tmp415_AST = null;
			tmp415_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp415_AST);
			match(TK_andb);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_orb:
		{
			AST tmp419_AST = null;
			tmp419_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp419_AST);
			match(TK_orb);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_notb:
		{
			AST tmp423_AST = null;
			tmp423_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp423_AST);
			match(TK_notb);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_shiftb:
		{
			AST tmp426_AST = null;
			tmp426_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp426_AST);
			match(TK_shiftb);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_xorb:
		{
			AST tmp430_AST = null;
			tmp430_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp430_AST);
			match(TK_xorb);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = numericValuedFunctionExpression_AST;
	}
	
	public final void stringValuedFunctionExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringValuedFunctionExpression_AST = null;
		
		switch ( LA(1)) {
		case 219:
		{
			AST tmp434_AST = null;
			tmp434_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp434_AST);
			match(219);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 220:
		{
			AST tmp437_AST = null;
			tmp437_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp437_AST);
			match(220);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 221:
		{
			AST tmp438_AST = null;
			tmp438_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp438_AST);
			match(221);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 222:
		{
			AST tmp442_AST = null;
			tmp442_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp442_AST);
			match(222);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 223:
		{
			AST tmp443_AST = null;
			tmp443_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp443_AST);
			match(223);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 224:
		{
			AST tmp446_AST = null;
			tmp446_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp446_AST);
			match(224);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 225:
		{
			AST tmp447_AST = null;
			tmp447_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp447_AST);
			match(225);
			match(LPAREN);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 226:
		{
			AST tmp451_AST = null;
			tmp451_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp451_AST);
			match(226);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 227:
		{
			AST tmp454_AST = null;
			tmp454_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp454_AST);
			match(227);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COMMA);
			integerExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 228:
		{
			AST tmp458_AST = null;
			tmp458_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp458_AST);
			match(228);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 229:
		{
			AST tmp459_AST = null;
			tmp459_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp459_AST);
			match(229);
			match(LPAREN);
			stringExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		case 230:
		{
			AST tmp462_AST = null;
			tmp462_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp462_AST);
			match(230);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			stringValuedFunctionExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = stringValuedFunctionExpression_AST;
	}
	
	public final void numericMultiplicativeExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericMultiplicativeExpression_AST = null;
		
		numericExponentialExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19882:
		do {
			if (((LA(1) >= STAR && LA(1) <= SLASH))) {
				{
				switch ( LA(1)) {
				case STAR:
				{
					AST tmp465_AST = null;
					tmp465_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp465_AST);
					match(STAR);
					break;
				}
				case TK_div:
				{
					AST tmp466_AST = null;
					tmp466_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp466_AST);
					match(TK_div);
					break;
				}
				case TK_mod:
				{
					AST tmp467_AST = null;
					tmp467_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp467_AST);
					match(TK_mod);
					break;
				}
				case SLASH:
				{
					AST tmp468_AST = null;
					tmp468_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp468_AST);
					match(SLASH);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				numericExponentialExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19882;
			}
			
		} while (true);
		}
		numericMultiplicativeExpression_AST = (AST)currentAST.root;
		returnAST = numericMultiplicativeExpression_AST;
	}
	
	public final void numericExponentialExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericExponentialExpression_AST = null;
		
		numericUnaryExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19885:
		do {
			if ((LA(1)==EXPO)) {
				AST tmp469_AST = null;
				tmp469_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp469_AST);
				match(EXPO);
				numericUnaryExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19885;
			}
			
		} while (true);
		}
		numericExponentialExpression_AST = (AST)currentAST.root;
		returnAST = numericExponentialExpression_AST;
	}
	
	public final void numericUnaryExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericUnaryExpression_AST = null;
		Token  p = null;
		AST p_AST = null;
		Token  m = null;
		AST m_AST = null;
		
		{
		switch ( LA(1)) {
		case PLUS:
		{
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.makeASTRoot(currentAST, p_AST);
			match(PLUS);
			if ( inputState.guessing==0 ) {
				p_AST.setType(UNARY_PLUS);
			}
			break;
		}
		case MINUS:
		{
			m = LT(1);
			m_AST = astFactory.create(m);
			astFactory.makeASTRoot(currentAST, m_AST);
			match(MINUS);
			if ( inputState.guessing==0 ) {
				m_AST.setType(UNARY_PLUS);
			}
			break;
		}
		case INT_FN:
		case FLT_FN:
		case LPAREN:
		case INT_CONST:
		case IDENT:
		case TK_in:
		case INT_VAR:
		case FLT_VAR:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		numericPrimaryExpression();
		astFactory.addASTChild(currentAST, returnAST);
		numericUnaryExpression_AST = (AST)currentAST.root;
		returnAST = numericUnaryExpression_AST;
	}
	
	public final void numericPrimaryExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericPrimaryExpression_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		switch ( LA(1)) {
		case INT_CONST:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		{
			floatNumber();
			astFactory.addASTChild(currentAST, returnAST);
			numericPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case IDENT:
		case INT_VAR:
		case FLT_VAR:
		{
			numericStore();
			astFactory.addASTChild(currentAST, returnAST);
			numericPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case INT_FN:
		case FLT_FN:
		{
			{
			switch ( LA(1)) {
			case FLT_FN:
			{
				AST tmp470_AST = null;
				tmp470_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp470_AST);
				match(FLT_FN);
				if ( inputState.guessing==0 ) {
					tmp470_AST.setType(FLT_FN_EXECUTE);
				}
				break;
			}
			case INT_FN:
			{
				AST tmp471_AST = null;
				tmp471_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp471_AST);
				match(INT_FN);
				if ( inputState.guessing==0 ) {
					tmp471_AST.setType(INT_FN_EXECUTE);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			boolean synPredMatched19892 = false;
			if (((LA(1)==LPAREN) && (_tokenSet_52.member(LA(2))) && (_tokenSet_53.member(LA(3))) && (_tokenSet_59.member(LA(4))))) {
				int _m19892 = mark();
				synPredMatched19892 = true;
				inputState.guessing++;
				try {
					{
					match(LPAREN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched19892 = false;
				}
				rewind(_m19892);
				inputState.guessing--;
			}
			if ( synPredMatched19892 ) {
				AST tmp472_AST = null;
				tmp472_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp472_AST);
				match(LPAREN);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp473_AST = null;
				tmp473_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp473_AST);
				match(RPAREN);
			}
			else if ((_tokenSet_31.member(LA(1))) && (_tokenSet_32.member(LA(2))) && (_tokenSet_38.member(LA(3))) && (_tokenSet_60.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			numericPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case TK_in:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		{
			numericValuedFunctionExpression();
			astFactory.addASTChild(currentAST, returnAST);
			numericPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			e = LT(1);
			e_AST = astFactory.create(e);
			match(LPAREN);
			numericExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			numericPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = numericPrimaryExpression_AST;
	}
	
	public final void integerNumber() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integerNumber_AST = null;
		
		switch ( LA(1)) {
		case INT_CONST:
		{
			AST tmp475_AST = null;
			tmp475_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp475_AST);
			match(INT_CONST);
			integerNumber_AST = (AST)currentAST.root;
			break;
		}
		case BINARY_INTEGER:
		{
			AST tmp476_AST = null;
			tmp476_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp476_AST);
			match(BINARY_INTEGER);
			integerNumber_AST = (AST)currentAST.root;
			break;
		}
		case OCTAL_INTEGER:
		{
			AST tmp477_AST = null;
			tmp477_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp477_AST);
			match(OCTAL_INTEGER);
			integerNumber_AST = (AST)currentAST.root;
			break;
		}
		case HEXADECIMAL_INTEGER:
		{
			AST tmp478_AST = null;
			tmp478_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp478_AST);
			match(HEXADECIMAL_INTEGER);
			integerNumber_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = integerNumber_AST;
	}
	
	public final void stringConcatanateExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringConcatanateExpression_AST = null;
		
		stringPrimaryExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case AMPERSAND:
		{
			AST tmp479_AST = null;
			tmp479_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp479_AST);
			match(AMPERSAND);
			stringConcatanateExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case INT_FN:
		case STR_FN:
		case FLT_FN:
		case LPAREN:
		case RPAREN:
		case COMMA:
		case TK_then:
		case EQ:
		case STR_CONST:
		case TK_with:
		case INT_CONST:
		case IDENT:
		case COLON:
		case SEMI:
		case TK_tab:
		case TK_prompt:
		case MINUS:
		case TK_in:
		case STR_VAR:
		case INT_VAR:
		case FLT_VAR:
		case TK_xor:
		case TK_or:
		case TK_and:
		case LT:
		case GT:
		case LE:
		case GE:
		case NE_COMP:
		case TK_abs:
		case TK_acos:
		case TK_asc:
		case TK_atn:
		case TK_cos:
		case TK_dround:
		case TK_errl:
		case TK_errn:
		case TK_exp:
		case TK_fract:
		case TK_get_event:
		case TK_instr:
		case TK_int:
		case TK_ival:
		case TK_len:
		case TK_lgt:
		case TK_log:
		case TK_max:
		case TK_min:
		case TK_peek:
		case TK_pi:
		case TK_rnd:
		case TK_sgn:
		case TK_signed:
		case TK_sin:
		case TK_sqr:
		case TK_tan:
		case TK_time:
		case TK_ubound:
		case TK_val:
		case TK_andb:
		case TK_orb:
		case TK_notb:
		case TK_shiftb:
		case TK_xorb:
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		case PLUS:
		case FLT_CONST:
		case BINARY_INTEGER:
		case OCTAL_INTEGER:
		case HEXADECIMAL_INTEGER:
		case EOL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		stringConcatanateExpression_AST = (AST)currentAST.root;
		returnAST = stringConcatanateExpression_AST;
	}
	
	public final void stringPrimaryExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stringPrimaryExpression_AST = null;
		
		switch ( LA(1)) {
		case STR_VAR:
		{
			stringStore();
			astFactory.addASTChild(currentAST, returnAST);
			stringPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case STR_CONST:
		{
			stringConstant();
			astFactory.addASTChild(currentAST, returnAST);
			stringPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case STR_FN:
		{
			AST tmp480_AST = null;
			tmp480_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp480_AST);
			match(STR_FN);
			{
			boolean synPredMatched19900 = false;
			if (((LA(1)==LPAREN) && (_tokenSet_52.member(LA(2))) && (_tokenSet_53.member(LA(3))) && (_tokenSet_61.member(LA(4))))) {
				int _m19900 = mark();
				synPredMatched19900 = true;
				inputState.guessing++;
				try {
					{
					match(LPAREN);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched19900 = false;
				}
				rewind(_m19900);
				inputState.guessing--;
			}
			if ( synPredMatched19900 ) {
				match(LPAREN);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
			}
			else if ((_tokenSet_62.member(LA(1))) && (_tokenSet_37.member(LA(2))) && (_tokenSet_38.member(LA(3))) && (_tokenSet_60.member(LA(4)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			if ( inputState.guessing==0 ) {
				tmp480_AST.setType(STR_FN_EXECUTE);
			}
			stringPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case 219:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		case 227:
		case 228:
		case 229:
		case 230:
		{
			stringValuedFunctionExpression();
			astFactory.addASTChild(currentAST, returnAST);
			stringPrimaryExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = stringPrimaryExpression_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SLIST",
		"TYPE",
		"PROGRAM_DEF",
		"SUBROUTINE_DEF",
		"FUNCTION_DEF",
		"EXIT_MODULE",
		"PARAMETERS",
		"PARAMETER_DEF",
		"LABELED_STAT",
		"NUMBERED_STAT",
		"UNARY_MINUS",
		"UNARY_PLUS",
		"CASE_GROUP",
		"ARGLIST",
		"FOR_LOOP",
		"FOR_FROM",
		"FOR_TO",
		"FOR_BY",
		"FOR_BY_ONE",
		"FOR_BODY",
		"INT_FN_EXECUTE",
		"FLT_FN_EXECUTE",
		"STR_FN_EXECUTE",
		"SUB_EXECUTE",
		"EQ_COMP",
		"INDEX_OP",
		"SUBSTRING_OP",
		"DOT",
		"ARRAY1D",
		"ARRAY2D",
		"ARRAY3D",
		"ARRAY1D_PROXY",
		"ARRAY2D_PROXY",
		"ARRAY3D_PROXY",
		"VAR_PROXY",
		"WHEN_ERROR_CALL",
		"WHEN_ERROR_IN",
		"PRINT_ASCII",
		"PRINT_TAB",
		"PRINT_NUMERIC",
		"PRINT_STRING",
		"PRINT_COMMA",
		"PRINT_SEMI",
		"IF_THEN_BLOCK",
		"IF_BLOCK",
		"ELSE_IF_BLOCK",
		"ELSE_BLOCK",
		"CODE_BLOCK",
		"CONDITION",
		"\"program\"",
		"\"end\"",
		"\"sub\"",
		"\"function\"",
		"INT_FN",
		"STR_FN",
		"FLT_FN",
		"LPAREN",
		"RPAREN",
		"COMMA",
		"\"if\"",
		"\"then\"",
		"\"else\"",
		"\"elseif\"",
		"\"endif\"",
		"\"for\"",
		"EQ",
		"\"to\"",
		"\"by\"",
		"\"next\"",
		"\"do\"",
		"\"until\"",
		"\"loop\"",
		"\"select\"",
		"\"case\"",
		"\"library\"",
		"STR_CONST",
		"\"dim\"",
		"\"global\"",
		"\"beep\"",
		"\"chain\"",
		"\"with\"",
		"\"gosub\"",
		"\"goto\"",
		"\"return\"",
		"\"exit\"",
		"\"let\"",
		"\"on\"",
		"\"option\"",
		"\"base\"",
		"INT_CONST",
		"\"out\"",
		"\"pause\"",
		"\"redim\"",
		"\"poke\"",
		"\"randomize\"",
		"\"call\"",
		"IDENT",
		"COLON",
		"SEMI",
		"\"tab\"",
		"\"close\"",
		"POUND",
		"\"data\"",
		"\"deletefile\"",
		"\"input\"",
		"\"binary\"",
		"\"open\"",
		"\"access\"",
		"\"output\"",
		"\"outin\"",
		"\"append\"",
		"\"organization\"",
		"\"sequential\"",
		"\"random\"",
		"\"stream\"",
		"\"recsize\"",
		"\"print\"",
		"\"read\"",
		"\"restore\"",
		"\"set\"",
		"\"timer\"",
		"\"loc\"",
		"\"using\"",
		"\"margin\"",
		"\"zonewidth\"",
		"\"address\"",
		"\"record\"",
		"\"prompt\"",
		"\"@\"",
		"\"brush\"",
		"\"circle\"",
		"\"clear\"",
		"\"metafileon\"",
		"\"metafileoff\"",
		"\"ellipse\"",
		"MINUS",
		"\"font\"",
		"\"pen\"",
		"\"picture\"",
		"\"polyline\"",
		"\"rectangle\"",
		"\"screen\"",
		"\"normal\"",
		"\"condensed\"",
		"\"display\"",
		"\"zoom\"",
		"\"unzoom\"",
		"\"close_basic\"",
		"\"line\"",
		"\"enter\"",
		"\"cause\"",
		"\"error\"",
		"\"event\"",
		"\"disable\"",
		"\"enable\"",
		"\"srq\"",
		"\"gpib\"",
		"\"discard\"",
		"\"abort\"",
		"\"retry\"",
		"\"continue\"",
		"\"stop\"",
		"\"when\"",
		"\"in\"",
		"\"use\"",
		"\"endwhen\"",
		"LBRACK",
		"RBRACK",
		"STR_VAR",
		"INT_VAR",
		"FLT_VAR",
		"\"xor\"",
		"\"or\"",
		"\"and\"",
		"\"not\"",
		"LT",
		"GT",
		"LE",
		"GE",
		"NE_COMP",
		"\"abs\"",
		"\"acos\"",
		"\"asc\"",
		"\"atn\"",
		"\"cos\"",
		"\"dround\"",
		"\"errl\"",
		"\"errn\"",
		"\"exp\"",
		"\"fract\"",
		"\"get_event\"",
		"\"instr\"",
		"\"int\"",
		"\"ival\"",
		"\"len\"",
		"\"lgt\"",
		"\"log\"",
		"\"max\"",
		"\"min\"",
		"\"peek\"",
		"\"pi\"",
		"\"rnd\"",
		"\"sgn\"",
		"\"signed\"",
		"\"sin\"",
		"\"sqr\"",
		"\"tan\"",
		"\"time\"",
		"\"ubound\"",
		"\"val\"",
		"\"andb\"",
		"\"orb\"",
		"\"notb\"",
		"\"shiftb\"",
		"\"xorb\"",
		"\"chr$\"",
		"\"date$\"",
		"\"dround$\"",
		"\"errl$\"",
		"\"errn$\"",
		"\"inchr$\"",
		"\"ival$\"",
		"\"lwc$\"",
		"\"rpt$\"",
		"\"time$\"",
		"\"upc$\"",
		"\"val$\"",
		"PLUS",
		"STAR",
		"\"div\"",
		"\"mod\"",
		"SLASH",
		"EXPO",
		"FLT_CONST",
		"AMPERSAND",
		"BINARY_INTEGER",
		"OCTAL_INTEGER",
		"HEXADECIMAL_INTEGER",
		"EOL"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 108086391056891906L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-9097271247288401918L;
		data[1]=3386809311533431582L;
		data[2]=126720544077024L;
		data[3]=1125899906842624L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=-6935543426150563838L;
		data[1]=-71917131428528322L;
		data[2]=-70799761325686801L;
		data[3]=2147346209046527L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-2323857407723175934L;
		data[1]=-71916856549572802L;
		data[2]=-993958511509505L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { -9223372036854775808L, 3386809311533421072L, 123422009193696L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[8];
		data[0]=-7025615418697973760L;
		data[1]=-71917131428530640L;
		data[2]=-70803059860570129L;
		data[3]=2147346209046527L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[8];
		data[0]=-2395915001761103872L;
		data[1]=-71916993988526274L;
		data[2]=-997257046392833L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[8];
		data[0]=-18014398509481984L;
		data[1]=-71916856549572802L;
		data[2]=-997257046392833L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { -9205357638345293824L, 3386809310996552478L, 123422009193696L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[8];
		data[0]=-7025615418697973760L;
		data[1]=-1152865909744815072L;
		data[2]=-70803336433235185L;
		data[3]=2147346209046527L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=69256347648L;
		data[2]=-71951491165845504L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=69262639104L;
		data[2]=-71951491165845504L;
		data[3]=1054981541068799L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[8];
		data[0]=4467570830351532032L;
		data[1]=69262671872L;
		data[2]=-71933898979801088L;
		data[3]=1055531162664959L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 0L, 67108864L, 1811939328L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=1152921573863194624L;
		data[2]=-71951226622703616L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=103616086016L;
		data[2]=-71951482575910912L;
		data[3]=2180881447911423L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[8];
		data[0]=-4737786807993761792L;
		data[1]=3386809311533464350L;
		data[2]=-71930315148100384L;
		data[3]=2181431069507583L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=69256380416L;
		data[2]=-70807999072958464L;
		data[3]=1021446302203903L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=69256380448L;
		data[2]=-997806802204672L;
		data[3]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[8];
		data[0]=4467570830351532032L;
		data[1]=69256380448L;
		data[2]=-997806802204672L;
		data[3]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 0L, 3386809310996545536L, 123147131286752L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 0L, 69256347654L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[8];
		data[0]=-7061644215716937728L;
		data[1]=206695333894L;
		data[2]=-70807999072958464L;
		data[3]=1021446302203903L;
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[8];
		data[0]=-7061644215716937728L;
		data[1]=69256380454L;
		data[2]=-997806802204672L;
		data[3]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[8];
		data[0]=-4755801206503243776L;
		data[1]=69256380448L;
		data[2]=-997806802204672L;
		data[3]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[8];
		data[0]=-9205357638345293824L;
		data[1]=3386809311533421082L;
		data[2]=123422009193696L;
		data[3]=1125899906842624L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[8];
		data[0]=-7007601020188491776L;
		data[1]=-71917131428530632L;
		data[2]=-70803059860570129L;
		data[3]=2147346209046527L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 18014398509481984L, 69256347656L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = new long[8];
		data[0]=-9205357638345293824L;
		data[1]=137438953480L;
		data[3]=1125899906842624L;
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = new long[8];
		data[0]=-9205357638345293824L;
		data[1]=3386809311533431582L;
		data[2]=123422009193696L;
		data[3]=1125899906842624L;
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = new long[8];
		data[0]=-6935543426150563840L;
		data[1]=-71917131428528322L;
		data[2]=-70803059860570129L;
		data[3]=2147346209046527L;
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[8];
		data[0]=8791026472627208192L;
		data[1]=515939238113L;
		data[2]=-1134137654114296L;
		data[3]=2180881447911423L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = new long[8];
		data[0]=-126100789566373886L;
		data[1]=-1186454410499194881L;
		data[2]=-264458994449L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=69256347648L;
		data[2]=-71951491031627776L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=4611688836462837760L;
		data[2]=-71933898979801088L;
		data[3]=1021446302203903L;
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = new long[8];
		data[0]=8791026472627208192L;
		data[1]=69256347648L;
		data[2]=-71951491165845504L;
		data[3]=1054981541068799L;
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = new long[8];
		data[0]=9079256848778919938L;
		data[1]=1031330104353L;
		data[2]=-1142942337071096L;
		data[3]=2217714953224191L;
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = new long[8];
		data[0]=-126100789566373886L;
		data[1]=3425231607928193023L;
		data[2]=-264458994456L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = new long[8];
		data[0]=-18014398509481982L;
		data[1]=-1L;
		data[2]=-17L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 0L, 68719476736L, 123145302310912L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = new long[8];
		data[0]=6485183463413514240L;
		data[1]=69256347648L;
		data[2]=-71951491165845504L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = new long[8];
		data[0]=8791026472627208192L;
		data[1]=206695301120L;
		data[2]=-71951491165845504L;
		data[3]=1054981541068799L;
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = new long[8];
		data[0]=4179340454199820288L;
		data[1]=69256347648L;
		data[2]=-71951491165845504L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = new long[8];
		data[0]=8791026472627208194L;
		data[1]=206695301120L;
		data[2]=-71951491165845504L;
		data[3]=1054981541068799L;
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=69256380416L;
		data[2]=-71933898979801072L;
		data[3]=1021446302203903L;
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = new long[8];
		data[0]=6485183463413514240L;
		data[1]=69256347648L;
		data[2]=-71929500933289976L;
		data[3]=1125350285246463L;
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = new long[8];
		data[0]=9079256848778919936L;
		data[1]=69256381440L;
		data[2]=-71929500933289976L;
		data[3]=2181431069507583L;
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = new long[8];
		data[0]=-126100789566373888L;
		data[1]=3386809448972418846L;
		data[2]=-71925925691523864L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = new long[8];
		data[0]=288230376151711744L;
		data[1]=32768L;
		data[2]=17592186044432L;
		data[3]=549621596160L;
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=69256347648L;
		data[2]=-71929500933289976L;
		data[3]=1091265424785407L;
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=69256381440L;
		data[2]=-71929500933289976L;
		data[3]=2181431069507583L;
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = new long[8];
		data[0]=8791026472627208192L;
		data[1]=69256347648L;
		data[2]=-71951491165845504L;
		data[3]=1020896680607743L;
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = new long[8];
		data[0]=2161727821137838080L;
		data[1]=69256380416L;
		data[2]=-71933898979801088L;
		data[3]=1021446302203903L;
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = new long[8];
		data[0]=8791026472627208192L;
		data[1]=69256347648L;
		data[2]=-71947093119334400L;
		data[3]=1125350285246463L;
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = new long[8];
		data[0]=9079256848778919938L;
		data[1]=1065696133345L;
		data[2]=-1134137654114296L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = new long[8];
		data[0]=1873497444986126336L;
		data[1]=69256347680L;
		data[2]=-2145696941602816L;
		data[3]=1054981541068799L;
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = new long[8];
		data[0]=4467570830351532032L;
		data[1]=69256380448L;
		data[2]=-2128104755558400L;
		data[3]=1055531162664959L;
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = new long[8];
		data[0]=9079256848778919936L;
		data[1]=69256380449L;
		data[2]=-1138544290560000L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = new long[8];
		data[0]=288230376151711744L;
		data[1]=32768L;
		data[2]=17592186044416L;
		data[3]=549621596160L;
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = new long[8];
		data[0]=9079256848778919936L;
		data[1]=515939270881L;
		data[2]=-1134137654114296L;
		data[3]=2181431069507583L;
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = new long[8];
		data[0]=-18014398509481982L;
		for (int i = 1; i<=2; i++) { data[i]=-1L; }
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = new long[8];
		data[0]=9079256848778919938L;
		data[1]=1031330103329L;
		data[2]=-1142942337071096L;
		data[3]=2251799813685247L;
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = new long[8];
		data[0]=9079256848778919938L;
		data[1]=1031330103329L;
		data[2]=-1142942337071096L;
		data[3]=2217714953224191L;
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	
	}
