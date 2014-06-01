// $ANTLR 2.7.2: "TinyBasicTreeWalker.g" -> "TinyBasicTreeWalker.java"$

	package tinybasic;

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


public class TinyBasicTreeWalker extends antlr.TreeParser       implements TinyBasicTreeWalkerTokenTypes
 {

	Context theContext=null;
	DTDataType zero=null,posOne=null,negOne=null ;
	
	//protected void blah() throws DTExecException{
	//	throw new DTExecException("oops");
	//}


public TinyBasicTreeWalker() {
	tokenNames = _tokenNames;
}

	public final void compilationUnit(AST _t,
		Context context
	) throws RecognitionException {
		
		AST compilationUnit_AST_in = (AST)_t;
		AST pd = null;
		
				theContext=context;
				theContext.initialize();
				zero	= new DTInteger(theContext.getCurrentScope(),0);
				posOne	= new DTInteger(theContext.getCurrentScope(),1);
				negOne	= new DTInteger(theContext.getCurrentScope(),-1);
			
		
		try {      // for error handling
			pd = (AST)_t;
			match(_t,PROGRAM_DEF);
			_t = _t.getNextSibling();
			
						try{
							programDefinition(pd);
						} catch(DTExecException didit){
							System.out.println("Yes it works!"+didit);
						}
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void programDefinition(AST _t) throws RecognitionException {
		
		AST programDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20006 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,PROGRAM_DEF);
			_t = _t.getFirstChild();
			moduleBody(_t);
			_t = _retTree;
			_t = __t20006;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void moduleBody(AST _t) throws RecognitionException {
		
		AST moduleBody_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20010 = _t;
			AST tmp2_AST_in = (AST)_t;
			match(_t,PARAMETERS);
			_t = _t.getFirstChild();
			parameters(_t);
			_t = _retTree;
			_t = __t20010;
			_t = _t.getNextSibling();
			AST __t20011 = _t;
			AST tmp3_AST_in = (AST)_t;
			match(_t,CODE_BLOCK);
			_t = _t.getFirstChild();
			{
			int _cnt20013=0;
			_loop20013:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					statement(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt20013>=1 ) { break _loop20013; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt20013++;
			} while (true);
			}
			_t = __t20011;
			_t = _t.getNextSibling();
			AST tmp4_AST_in = (AST)_t;
			match(_t,EXIT_MODULE);
			_t = _t.getNextSibling();
			
						throw new DTExitModuleException("Done folks");
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void subroutineDefinition(AST _t) throws RecognitionException {
		
		AST subroutineDefinition_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20008 = _t;
			AST tmp5_AST_in = (AST)_t;
			match(_t,SUBROUTINE_DEF);
			_t = _t.getFirstChild();
			AST tmp6_AST_in = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			moduleBody(_t);
			_t = _retTree;
			_t = __t20008;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void parameters(AST _t) throws RecognitionException {
		
		AST parameters_AST_in = (AST)_t;
		
		try {      // for error handling
			{
			_loop20016:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==VAR_PROXY)) {
					parameter(_t);
					_t = _retTree;
				}
				else {
					break _loop20016;
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
	
	public final void statement(AST _t) throws RecognitionException {
		
		AST statement_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case WHEN_ERROR_CALL:
			{
				when_error_call_statement(_t);
				_t = _retTree;
				break;
			}
			case TK_dim:
			{
				dim_statement(_t);
				_t = _retTree;
				break;
			}
			case EQ:
			{
				assign_statement(_t);
				_t = _retTree;
				break;
			}
			case FOR_LOOP:
			{
				forNextStatement(_t);
				_t = _retTree;
				break;
			}
			case PRINT_ASCII:
			{
				printAsciiStatement(_t);
				_t = _retTree;
				break;
			}
			case IF_THEN_BLOCK:
			{
				ifThenBlock(_t);
				_t = _retTree;
				break;
			}
			case TK_until:
			{
				doUntilLoop(_t);
				_t = _retTree;
				break;
			}
			case TK_do:
			{
				doLoopUntil(_t);
				_t = _retTree;
				break;
			}
			case SUB_EXECUTE:
			{
				subExecuteStatement(_t);
				_t = _retTree;
				break;
			}
			case EXIT_MODULE:
			{
				exitModuleStatement(_t);
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
	
	public final void parameter(AST _t) throws RecognitionException {
		
		AST parameter_AST_in = (AST)_t;
		int argNum=0;
		
		try {      // for error handling
			AST __t20018 = _t;
			AST tmp7_AST_in = (AST)_t;
			match(_t,VAR_PROXY);
			_t = _t.getFirstChild();
			arg(_t,argNum);
			_t = _retTree;
			argNum++;
			_t = __t20018;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void arg(AST _t,
		int argNum
	) throws RecognitionException {
		
		AST arg_AST_in = (AST)_t;
		AST s = null;
		AST i = null;
		AST f = null;
		DTDataType v=null;
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STR_VAR:
			{
				s = (AST)_t;
				match(_t,STR_VAR);
				_t = _t.getNextSibling();
				break;
			}
			case INT_VAR:
			{
				i = (AST)_t;
				match(_t,INT_VAR);
				_t = _t.getNextSibling();
				break;
			}
			case FLT_VAR:
			{
				f = (AST)_t;
				match(_t,FLT_VAR);
				_t = _t.getNextSibling();
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
	
	public final void when_error_call_statement(AST _t) throws RecognitionException {
		
		AST when_error_call_statement_AST_in = (AST)_t;
		AST i = null;
		
		try {      // for error handling
			AST __t20087 = _t;
			AST tmp8_AST_in = (AST)_t;
			match(_t,WHEN_ERROR_CALL);
			_t = _t.getFirstChild();
			AST tmp9_AST_in = (AST)_t;
			match(_t,TK_call);
			_t = _t.getNextSibling();
			i = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			System.out.println(" Attaching error:"+i.getText());
			_t = __t20087;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void dim_statement(AST _t) throws RecognitionException {
		
		AST dim_statement_AST_in = (AST)_t;
		AST dv1 = null;
		AST dv2 = null;
		AST dv3 = null;
		DTDataType i1=null,i2=null,i3=null;
		
		try {      // for error handling
			AST __t20089 = _t;
			AST tmp10_AST_in = (AST)_t;
			match(_t,TK_dim);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARRAY1D:
			{
				AST __t20091 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,ARRAY1D);
				_t = _t.getFirstChild();
				dv1 = _t==ASTNULL ? null : (AST)_t;
				dimension_variable(_t);
				_t = _retTree;
				i1=expr(_t);
				_t = _retTree;
				theContext.setDimension(dv1.getText(),i1);
				_t = __t20091;
				_t = _t.getNextSibling();
				break;
			}
			case ARRAY2D:
			{
				AST __t20092 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,ARRAY2D);
				_t = _t.getFirstChild();
				dv2 = _t==ASTNULL ? null : (AST)_t;
				dimension_variable(_t);
				_t = _retTree;
				i1=expr(_t);
				_t = _retTree;
				i2=expr(_t);
				_t = _retTree;
				theContext.setDimension(dv2.getText(),i1,i2);
				_t = __t20092;
				_t = _t.getNextSibling();
				break;
			}
			case ARRAY3D:
			{
				AST __t20093 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,ARRAY3D);
				_t = _t.getFirstChild();
				dv3 = _t==ASTNULL ? null : (AST)_t;
				dimension_variable(_t);
				_t = _retTree;
				i1=expr(_t);
				_t = _retTree;
				i2=expr(_t);
				_t = _retTree;
				i3=expr(_t);
				_t = _retTree;
				theContext.setDimension(dv3.getText(),i1,i2,i3);
				_t = __t20093;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t20089;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final DTDataType  assign_statement(AST _t) throws RecognitionException {
		DTDataType d;
		
		AST assign_statement_AST_in = (AST)_t;
		DTDataType e=null;d=null;
		
		try {      // for error handling
			AST __t20038 = _t;
			AST tmp14_AST_in = (AST)_t;
			match(_t,EQ);
			_t = _t.getFirstChild();
			d=data_store(_t);
			_t = _retTree;
			e=expr(_t);
			_t = _retTree;
			
							d.assign(e);
						
			_t = __t20038;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return d;
	}
	
	public final void forNextStatement(AST _t) throws RecognitionException {
		
		AST forNextStatement_AST_in = (AST)_t;
		AST b = null;
		DTDataType ff=null,ft=null,fb=null;
		
		try {      // for error handling
			AST __t20066 = _t;
			AST tmp15_AST_in = (AST)_t;
			match(_t,FOR_LOOP);
			_t = _t.getFirstChild();
			ff=forFrom(_t);
			_t = _retTree;
			ft=forTo(_t);
			_t = _retTree;
			fb=forBy(_t);
			_t = _retTree;
			b = (AST)_t;
			match(_t,FOR_BODY);
			_t = _t.getNextSibling();
			
							//DTDataType zero=new DTInteger(null,0);
							while( ff.compareTo(ft) != fb.compareTo(zero)  ) {
								try {
									forBody(b);
									ff.assign(ff.add(fb));
								}
								catch (ANTLRException ex) {
									//reportError(ex);
								}
							}
						
						
						
			_t = __t20066;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void printAsciiStatement(AST _t) throws RecognitionException {
		
		AST printAsciiStatement_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20030 = _t;
			AST tmp16_AST_in = (AST)_t;
			match(_t,PRINT_ASCII);
			_t = _t.getFirstChild();
			{
			_loop20032:
			do {
				if (_t==null) _t=ASTNULL;
				if (((_t.getType() >= PRINT_TAB && _t.getType() <= PRINT_SEMI))) {
					printField(_t);
					_t = _retTree;
				}
				else {
					break _loop20032;
				}
				
			} while (true);
			}
			System.out.println();
			_t = __t20030;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void ifThenBlock(AST _t) throws RecognitionException {
		
		AST ifThenBlock_AST_in = (AST)_t;
		int done=0;
		
		try {      // for error handling
			AST __t20074 = _t;
			AST tmp17_AST_in = (AST)_t;
			match(_t,IF_THEN_BLOCK);
			_t = _t.getFirstChild();
			{
			int _cnt20076=0;
			_loop20076:
			do {
				if (_t==null) _t=ASTNULL;
				if ((((_t.getType() >= IF_BLOCK && _t.getType() <= ELSE_BLOCK)))&&(done==0)) {
					done=ifThenBody(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt20076>=1 ) { break _loop20076; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt20076++;
			} while (true);
			}
			_t = __t20074;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void doUntilLoop(AST _t) throws RecognitionException {
		
		AST doUntilLoop_AST_in = (AST)_t;
		AST c = null;
		
		try {      // for error handling
			AST __t20083 = _t;
			AST tmp18_AST_in = (AST)_t;
			match(_t,TK_until);
			_t = _t.getFirstChild();
			c = (AST)_t;
			match(_t,CONDITION);
			_t = _t.getNextSibling();
			
							while(0==conditional(c,0)){};
						
			_t = __t20083;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void doLoopUntil(AST _t) throws RecognitionException {
		
		AST doLoopUntil_AST_in = (AST)_t;
		AST cb = null;
		AST c = null;
		
		try {      // for error handling
			AST __t20085 = _t;
			AST tmp19_AST_in = (AST)_t;
			match(_t,TK_do);
			_t = _t.getFirstChild();
			cb = (AST)_t;
			match(_t,CODE_BLOCK);
			_t = _t.getNextSibling();
			c = (AST)_t;
			match(_t,CONDITION);
			_t = _t.getNextSibling();
			
							do{
								codeBlock(cb);
							} while (0==condition(c).getInteger());
						
			_t = __t20085;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void subExecuteStatement(AST _t) throws RecognitionException {
		
		AST subExecuteStatement_AST_in = (AST)_t;
		AST i = null;
		DTCodeType sub=null; int argNum=0;DTDataType tbd=null;
		
		try {      // for error handling
			AST __t20024 = _t;
			AST tmp20_AST_in = (AST)_t;
			match(_t,SUB_EXECUTE);
			_t = _t.getFirstChild();
			i = (AST)_t;
			match(_t,IDENT);
			_t = _t.getNextSibling();
			
							sub=theContext.getSubroutine(i.getText());
						
			AST __t20025 = _t;
			AST tmp21_AST_in = (AST)_t;
			match(_t,ARGLIST);
			_t = _t.getFirstChild();
			{
			_loop20027:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_1.member(_t.getType()))) {
					tbd=argExpr(_t);
					_t = _retTree;
					sub.attachArg(argNum++,tbd);
				}
				else {
					break _loop20027;
				}
				
			} while (true);
			}
			_t = __t20025;
			_t = _t.getNextSibling();
			
							try {
								sub.newCall(theContext);
								try{
									subroutineDefinition(sub.getAST());
								} catch(DTExitModuleException didit){
									System.out.println("Yes it works!"+didit);
								}
							} catch(ANTLRException ex){
							}
						
			_t = __t20024;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void exitModuleStatement(AST _t) throws RecognitionException {
		
		AST exitModuleStatement_AST_in = (AST)_t;
		
		try {      // for error handling
			AST tmp22_AST_in = (AST)_t;
			match(_t,EXIT_MODULE);
			_t = _t.getNextSibling();
			
					throw new DTExitModuleException("Asnychronous return");
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final DTDataType  argExpr(AST _t) throws RecognitionException {
		DTDataType tbd;
		
		AST argExpr_AST_in = (AST)_t;
		AST a1d = null;
		AST a2d = null;
		AST a3d = null;
		tbd=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARRAY1D:
			{
				a1d = (AST)_t;
				match(_t,ARRAY1D);
				_t = _t.getNextSibling();
				tbd=theContext.getVariable(a1d.getText());
				break;
			}
			case ARRAY2D:
			{
				a2d = (AST)_t;
				match(_t,ARRAY2D);
				_t = _t.getNextSibling();
				tbd=theContext.getVariable(a2d.getText());
				break;
			}
			case ARRAY3D:
			{
				a3d = (AST)_t;
				match(_t,ARRAY3D);
				_t = _t.getNextSibling();
				tbd=theContext.getVariable(a3d.getText());
				break;
			}
			case UNARY_MINUS:
			case UNARY_PLUS:
			case EQ_COMP:
			case INDEX_OP:
			case SUBSTRING_OP:
			case STR_CONST:
			case INT_CONST:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			case TK_xor:
			case TK_or:
			case TK_and:
			case TK_not:
			case LT:
			case GT:
			case LE:
			case GE:
			case NE_COMP:
			case PLUS:
			case STAR:
			case TK_div:
			case TK_mod:
			case SLASH:
			case FLT_CONST:
			{
				tbd=expr(_t);
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
		return tbd;
	}
	
	public final DTDataType  expr(AST _t) throws RecognitionException {
		DTDataType e;
		
		AST expr_AST_in = (AST)_t;
		DTDataType c=null,d=null,e1=null,e2=null,e3=null;e=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STAR:
			{
				AST __t20040 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=e1.multiply(e2);
				_t = __t20040;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS:
			{
				AST __t20041 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=e1.add(e2);
				_t = __t20041;
				_t = _t.getNextSibling();
				break;
			}
			case SLASH:
			{
				AST __t20042 = _t;
				AST tmp25_AST_in = (AST)_t;
				match(_t,SLASH);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=e1.multiply(e2);
				_t = __t20042;
				_t = _t.getNextSibling();
				break;
			}
			case TK_div:
			{
				AST __t20043 = _t;
				AST tmp26_AST_in = (AST)_t;
				match(_t,TK_div);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=e1.divide(e2);
				_t = __t20043;
				_t = _t.getNextSibling();
				break;
			}
			case TK_mod:
			{
				AST __t20044 = _t;
				AST tmp27_AST_in = (AST)_t;
				match(_t,TK_mod);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=e1.mod(e2);
				_t = __t20044;
				_t = _t.getNextSibling();
				break;
			}
			case EQ_COMP:
			{
				AST __t20045 = _t;
				AST tmp28_AST_in = (AST)_t;
				match(_t,EQ_COMP);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2)==0 ? 1:0);
				_t = __t20045;
				_t = _t.getNextSibling();
				break;
			}
			case NE_COMP:
			{
				AST __t20046 = _t;
				AST tmp29_AST_in = (AST)_t;
				match(_t,NE_COMP);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2)==0 ? 0:1);
				_t = __t20046;
				_t = _t.getNextSibling();
				break;
			}
			case LE:
			{
				AST __t20047 = _t;
				AST tmp30_AST_in = (AST)_t;
				match(_t,LE);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2)<=0 ? 1:0);
				_t = __t20047;
				_t = _t.getNextSibling();
				break;
			}
			case LT:
			{
				AST __t20048 = _t;
				AST tmp31_AST_in = (AST)_t;
				match(_t,LT);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2) <0 ? 1:0);
				_t = __t20048;
				_t = _t.getNextSibling();
				break;
			}
			case GE:
			{
				AST __t20049 = _t;
				AST tmp32_AST_in = (AST)_t;
				match(_t,GE);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2)>=0 ? 1:0);
				_t = __t20049;
				_t = _t.getNextSibling();
				break;
			}
			case GT:
			{
				AST __t20050 = _t;
				AST tmp33_AST_in = (AST)_t;
				match(_t,GT);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null, e1.compareTo(e2) >0 ? 1:0);
				_t = __t20050;
				_t = _t.getNextSibling();
				break;
			}
			case TK_xor:
			{
				AST __t20051 = _t;
				AST tmp34_AST_in = (AST)_t;
				match(_t,TK_xor);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null,(e1.getInteger()!=e2.getInteger()) ? 1:0 );
				_t = __t20051;
				_t = _t.getNextSibling();
				break;
			}
			case TK_and:
			{
				AST __t20052 = _t;
				AST tmp35_AST_in = (AST)_t;
				match(_t,TK_and);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null,(e1.getInteger()==1&&e2.getInteger()==1) ? 1:0 );
				_t = __t20052;
				_t = _t.getNextSibling();
				break;
			}
			case TK_or:
			{
				AST __t20053 = _t;
				AST tmp36_AST_in = (AST)_t;
				match(_t,TK_or);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e=new DTInteger(null,(e1.getInteger()==1||e2.getInteger()==1) ? 1:0 );
				_t = __t20053;
				_t = _t.getNextSibling();
				break;
			}
			case TK_not:
			{
				AST __t20054 = _t;
				AST tmp37_AST_in = (AST)_t;
				match(_t,TK_not);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e=new DTInteger(null,e1.getInteger()==0 ? 1:0 );
				_t = __t20054;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_PLUS:
			{
				AST __t20055 = _t;
				AST tmp38_AST_in = (AST)_t;
				match(_t,UNARY_PLUS);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e=e1;
				_t = __t20055;
				_t = _t.getNextSibling();
				break;
			}
			case UNARY_MINUS:
			{
				AST __t20056 = _t;
				AST tmp39_AST_in = (AST)_t;
				match(_t,UNARY_MINUS);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e=e1.multiply(negOne);
				_t = __t20056;
				_t = _t.getNextSibling();
				break;
			}
			case SUBSTRING_OP:
			{
				AST __t20057 = _t;
				AST tmp40_AST_in = (AST)_t;
				match(_t,SUBSTRING_OP);
				_t = _t.getFirstChild();
				e1=expr(_t);
				_t = _retTree;
				e2=expr(_t);
				_t = _retTree;
				e3=expr(_t);
				_t = _retTree;
				e=e1.getDTDataType(e2,e3);
				_t = __t20057;
				_t = _t.getNextSibling();
				break;
			}
			case INDEX_OP:
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			{
				d=data_store(_t);
				_t = _retTree;
				e=d;
				break;
			}
			case STR_CONST:
			case INT_CONST:
			case FLT_CONST:
			{
				c=con(_t);
				_t = _retTree;
				e=c;
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
		return e;
	}
	
	public final void printField(AST _t) throws RecognitionException {
		
		AST printField_AST_in = (AST)_t;
		DTDataType d=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PRINT_NUMERIC:
			{
				AST __t20034 = _t;
				AST tmp41_AST_in = (AST)_t;
				match(_t,PRINT_NUMERIC);
				_t = _t.getFirstChild();
				d=expr(_t);
				_t = _retTree;
				System.out.print(d);
				_t = __t20034;
				_t = _t.getNextSibling();
				break;
			}
			case PRINT_STRING:
			{
				AST __t20035 = _t;
				AST tmp42_AST_in = (AST)_t;
				match(_t,PRINT_STRING);
				_t = _t.getFirstChild();
				d=expr(_t);
				_t = _retTree;
				System.out.print(d);
				_t = __t20035;
				_t = _t.getNextSibling();
				break;
			}
			case PRINT_TAB:
			{
				AST __t20036 = _t;
				AST tmp43_AST_in = (AST)_t;
				match(_t,PRINT_TAB);
				_t = _t.getFirstChild();
				d=expr(_t);
				_t = _retTree;
				_t = __t20036;
				_t = _t.getNextSibling();
				break;
			}
			case PRINT_COMMA:
			{
				AST tmp44_AST_in = (AST)_t;
				match(_t,PRINT_COMMA);
				_t = _t.getNextSibling();
				System.out.print("\t");
				break;
			}
			case PRINT_SEMI:
			{
				AST tmp45_AST_in = (AST)_t;
				match(_t,PRINT_SEMI);
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
	
	public final DTDataType  data_store(AST _t) throws RecognitionException {
		DTDataType tbd;
		
		AST data_store_AST_in = (AST)_t;
		AST v = null;
		DTDataType i1=null,i2=null,i3=null;tbd=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case INDEX_OP:
			{
				AST __t20062 = _t;
				AST tmp46_AST_in = (AST)_t;
				match(_t,INDEX_OP);
				_t = _t.getFirstChild();
				v = _t==ASTNULL ? null : (AST)_t;
				dimension_variable(_t);
				_t = _retTree;
				i1=expr(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case UNARY_MINUS:
				case UNARY_PLUS:
				case EQ_COMP:
				case INDEX_OP:
				case SUBSTRING_OP:
				case STR_CONST:
				case INT_CONST:
				case STR_VAR:
				case INT_VAR:
				case FLT_VAR:
				case TK_xor:
				case TK_or:
				case TK_and:
				case TK_not:
				case LT:
				case GT:
				case LE:
				case GE:
				case NE_COMP:
				case PLUS:
				case STAR:
				case TK_div:
				case TK_mod:
				case SLASH:
				case FLT_CONST:
				{
					i2=expr(_t);
					_t = _retTree;
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case UNARY_MINUS:
					case UNARY_PLUS:
					case EQ_COMP:
					case INDEX_OP:
					case SUBSTRING_OP:
					case STR_CONST:
					case INT_CONST:
					case STR_VAR:
					case INT_VAR:
					case FLT_VAR:
					case TK_xor:
					case TK_or:
					case TK_and:
					case TK_not:
					case LT:
					case GT:
					case LE:
					case GE:
					case NE_COMP:
					case PLUS:
					case STAR:
					case TK_div:
					case TK_mod:
					case SLASH:
					case FLT_CONST:
					{
						i3=expr(_t);
						_t = _retTree;
						tbd=theContext.getDTDataType(v.getText(),i1,i2,i3);
						break;
					}
					case 3:
					{
						tbd=theContext.getDTDataType(v.getText(),i1,i2);
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
				case 3:
				{
					tbd=theContext.getDTDataType(v.getText(),i1);
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t20062;
				_t = _t.getNextSibling();
				break;
			}
			case STR_VAR:
			case INT_VAR:
			case FLT_VAR:
			{
				tbd=id(_t);
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
		return tbd;
	}
	
	public final DTDataType  con(AST _t) throws RecognitionException {
		DTDataType c;
		
		AST con_AST_in = (AST)_t;
		AST s = null;
		AST i = null;
		AST f = null;
		c=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STR_CONST:
			{
				s = (AST)_t;
				match(_t,STR_CONST);
				_t = _t.getNextSibling();
				c=new DTString	(theContext.getCurrentScope(),s.getText());
				break;
			}
			case INT_CONST:
			{
				i = (AST)_t;
				match(_t,INT_CONST);
				_t = _t.getNextSibling();
				c=new DTInteger(theContext.getCurrentScope(),i.getText());
				break;
			}
			case FLT_CONST:
			{
				f = (AST)_t;
				match(_t,FLT_CONST);
				_t = _t.getNextSibling();
				c=new DTFloat	(theContext.getCurrentScope(),f.getText());
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
		return c;
	}
	
	public final DTDataType  id(AST _t) throws RecognitionException {
		DTDataType v;
		
		AST id_AST_in = (AST)_t;
		AST s = null;
		AST i = null;
		AST f = null;
		v=null;
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STR_VAR:
			{
				s = (AST)_t;
				match(_t,STR_VAR);
				_t = _t.getNextSibling();
				v=theContext.ensureVariable(s.getText(),STR_VAR);
				break;
			}
			case INT_VAR:
			{
				i = (AST)_t;
				match(_t,INT_VAR);
				_t = _t.getNextSibling();
				v=theContext.ensureVariable(i.getText(),INT_VAR);
				break;
			}
			case FLT_VAR:
			{
				f = (AST)_t;
				match(_t,FLT_VAR);
				_t = _t.getNextSibling();
				v=theContext.ensureVariable(f.getText(),FLT_VAR);
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
		return v;
	}
	
	public final void dimension_variable(AST _t) throws RecognitionException {
		
		AST dimension_variable_AST_in = (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STR_VAR:
			{
				AST tmp47_AST_in = (AST)_t;
				match(_t,STR_VAR);
				_t = _t.getNextSibling();
				break;
			}
			case FLT_VAR:
			{
				AST tmp48_AST_in = (AST)_t;
				match(_t,FLT_VAR);
				_t = _t.getNextSibling();
				break;
			}
			case INT_VAR:
			{
				AST tmp49_AST_in = (AST)_t;
				match(_t,INT_VAR);
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
	
	public final DTDataType  forFrom(AST _t) throws RecognitionException {
		DTDataType d;
		
		AST forFrom_AST_in = (AST)_t;
		d=null;
		
		try {      // for error handling
			AST __t20068 = _t;
			AST tmp50_AST_in = (AST)_t;
			match(_t,FOR_FROM);
			_t = _t.getFirstChild();
			d=assign_statement(_t);
			_t = _retTree;
			_t = __t20068;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return d;
	}
	
	public final DTDataType  forTo(AST _t) throws RecognitionException {
		DTDataType d;
		
		AST forTo_AST_in = (AST)_t;
		d=null;
		
		try {      // for error handling
			AST __t20070 = _t;
			AST tmp51_AST_in = (AST)_t;
			match(_t,FOR_TO);
			_t = _t.getFirstChild();
			d=expr(_t);
			_t = _retTree;
			_t = __t20070;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return d;
	}
	
	public final DTDataType  forBy(AST _t) throws RecognitionException {
		DTDataType d;
		
		AST forBy_AST_in = (AST)_t;
		d=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FOR_BY:
			{
				AST __t20072 = _t;
				AST tmp52_AST_in = (AST)_t;
				match(_t,FOR_BY);
				_t = _t.getFirstChild();
				d=expr(_t);
				_t = _retTree;
				_t = __t20072;
				_t = _t.getNextSibling();
				break;
			}
			case FOR_BY_ONE:
			{
				AST tmp53_AST_in = (AST)_t;
				match(_t,FOR_BY_ONE);
				_t = _t.getNextSibling();
				d=new DTInteger(theContext.getCurrentScope(),1);
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
		return d;
	}
	
	public final int  ifThenBody(AST _t) throws RecognitionException {
		int done;
		
		AST ifThenBody_AST_in = (AST)_t;
		AST cb = null;
		done=0;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IF_BLOCK:
			{
				AST __t20078 = _t;
				AST tmp54_AST_in = (AST)_t;
				match(_t,IF_BLOCK);
				_t = _t.getFirstChild();
				done=conditional(_t,1);
				_t = _retTree;
				_t = __t20078;
				_t = _t.getNextSibling();
				break;
			}
			case ELSE_IF_BLOCK:
			{
				AST __t20079 = _t;
				AST tmp55_AST_in = (AST)_t;
				match(_t,ELSE_IF_BLOCK);
				_t = _t.getFirstChild();
				done=conditional(_t,1);
				_t = _retTree;
				_t = __t20079;
				_t = _t.getNextSibling();
				break;
			}
			case ELSE_BLOCK:
			{
				AST __t20080 = _t;
				AST tmp56_AST_in = (AST)_t;
				match(_t,ELSE_BLOCK);
				_t = _t.getFirstChild();
				cb = (AST)_t;
				match(_t,CODE_BLOCK);
				_t = _t.getNextSibling();
				codeBlock(cb);
				_t = __t20080;
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
		return done;
	}
	
	public final int  conditional(AST _t,
		int forWhat
	) throws RecognitionException {
		int yes;
		
		AST conditional_AST_in = (AST)_t;
		AST c = null;
		AST cb = null;
		yes=0;
		
		try {      // for error handling
			c = (AST)_t;
			match(_t,CONDITION);
			_t = _t.getNextSibling();
			cb = (AST)_t;
			match(_t,CODE_BLOCK);
			_t = _t.getNextSibling();
			
						yes= condition(c).getInteger();
						if(forWhat==yes){
							codeBlock(cb);
						}
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return yes;
	}
	
	public final DTDataType	 doubleFunctions(AST _t) throws RecognitionException {
		DTDataType	tbd;
		
		AST doubleFunctions_AST_in = (AST)_t;
		tbd=null;DTDataType n=null,i=null,s=null;
		
		try {      // for error handling
			AST __t20096 = _t;
			AST tmp57_AST_in = (AST)_t;
			match(_t,TK_abs);
			_t = _t.getFirstChild();
			n=expr(_t);
			_t = _retTree;
			tbd=new	DTFloat(null,Math.abs(n.getFloat()));
			_t = __t20096;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return tbd;
	}
	
	public final DTDataType  condition(AST _t) throws RecognitionException {
		DTDataType e;
		
		AST condition_AST_in = (AST)_t;
		e=null;
		
		try {      // for error handling
			AST __t20098 = _t;
			AST tmp58_AST_in = (AST)_t;
			match(_t,CONDITION);
			_t = _t.getFirstChild();
			e=expr(_t);
			_t = _retTree;
			_t = __t20098;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return e;
	}
	
	public final void forBody(AST _t) throws RecognitionException {
		
		AST forBody_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20100 = _t;
			AST tmp59_AST_in = (AST)_t;
			match(_t,FOR_BODY);
			_t = _t.getFirstChild();
			codeBlock(_t);
			_t = _retTree;
			_t = __t20100;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void codeBlock(AST _t) throws RecognitionException {
		
		AST codeBlock_AST_in = (AST)_t;
		
		try {      // for error handling
			AST __t20102 = _t;
			AST tmp60_AST_in = (AST)_t;
			match(_t,CODE_BLOCK);
			_t = _t.getFirstChild();
			{
			_loop20104:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					statement(_t);
					_t = _retTree;
				}
				else {
					break _loop20104;
				}
				
			} while (true);
			}
			_t = __t20102;
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
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 143486401905152L, 67104L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=31943868416L;
		data[1]=536903680L;
		data[2]=72040001851883520L;
		data[3]=52226802319360L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	}
	
