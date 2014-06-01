// $ANTLR 2.7.2: "pascal.g" -> "PascalParser.java"$

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

  import java.io.*;

public class PascalParser extends antlr.LLkParser       implements PascalTokenTypes
 {

  // Define a main
  public static void main(String[] args) {
    // Use a try/catch block for parser exceptions
    try {
      // if we have at least one command-line argument
      if (args.length > 0 ) {
        System.err.println("Parsing...");

        // for each directory/file specified on the command line
        for(int i=0; i< args.length;i++)
          doFile(new File(args[i])); // parse it
      }
      else
        System.err.println("Usage: java PascalParser <file/directory name>");

    }
    catch(Exception e) {
      System.err.println("exception: "+e);
      e.printStackTrace(System.err);   // so we can get stack trace
    }
  }


  // This method decides what action to take based on the type of
  //   file we are looking at
  public static void doFile(File f) throws Exception {
    // If this is a directory, walk each file/dir in that directory
    if (f.isDirectory()) {
      String files[] = f.list();
      for(int i=0; i < files.length; i++)
        doFile(new File(f, files[i]));
    }

    // otherwise, if this is a Pascal file, parse it!
    else if ((f.getName().length()>4) &&
             f.getName().substring(f.getName().length()-4).equals(".pas")) {
      System.err.println("   "+f.getAbsolutePath());
      parseFile(new FileInputStream(f));
    }
  }

  // Here's where we do the real work...
  public static void parseFile(InputStream s) throws Exception {
    try {
      // Create a scanner that reads from the input stream passed to us
      PascalLexer lexer = new PascalLexer(s);

      // Create a parser that reads from the scanner
      PascalParser parser = new PascalParser(lexer);

      // start parsing at the program rule
	parser.program(); 
    }
    catch (Exception e) {
      System.err.println("parser exception: "+e);
      e.printStackTrace();   // so we can get stack trace
    }
  }

protected PascalParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public PascalParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected PascalParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public PascalParser(TokenStream lexer) {
  this(lexer,2);
}

public PascalParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final void program() throws RecognitionException, TokenStreamException {
		
		
		programHeading();
		block();
		match(DOT);
	}
	
	public final void programHeading() throws RecognitionException, TokenStreamException {
		
		
		match(PROGRAM);
		identifier();
		match(LPAREN);
		fileIdentifier();
		{
		_loop19390:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				fileIdentifier();
			}
			else {
				break _loop19390;
			}
			
		} while (true);
		}
		match(RPAREN);
		match(SEMI);
	}
	
	public final void block() throws RecognitionException, TokenStreamException {
		
		
		{
		_loop19395:
		do {
			switch ( LA(1)) {
			case LABEL:
			{
				labelDeclarationPart();
				break;
			}
			case CONST:
			{
				constantDefinitionPart();
				break;
			}
			case TYPE:
			{
				typeDefinitionPart();
				break;
			}
			case VAR:
			{
				variableDeclarationPart();
				break;
			}
			case PROCEDURE:
			case FUNCTION:
			{
				procedureAndFunctionDeclarationPart();
				break;
			}
			default:
			{
				break _loop19395;
			}
			}
		} while (true);
		}
		statementPart();
	}
	
	public final void identifier() throws RecognitionException, TokenStreamException {
		
		
		match(IDENT);
	}
	
	public final void fileIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void labelDeclarationPart() throws RecognitionException, TokenStreamException {
		
		
		match(LABEL);
		label();
		{
		_loop19398:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				label();
			}
			else {
				break _loop19398;
			}
			
		} while (true);
		}
		match(SEMI);
	}
	
	public final void constantDefinitionPart() throws RecognitionException, TokenStreamException {
		
		
		match(CONST);
		constantDefinition();
		{
		_loop19402:
		do {
			if ((LA(1)==SEMI) && (LA(2)==IDENT)) {
				match(SEMI);
				constantDefinition();
			}
			else {
				break _loop19402;
			}
			
		} while (true);
		}
		match(SEMI);
	}
	
	public final void typeDefinitionPart() throws RecognitionException, TokenStreamException {
		
		
		match(TYPE);
		typeDefinition();
		{
		_loop19413:
		do {
			if ((LA(1)==SEMI) && (LA(2)==IDENT)) {
				match(SEMI);
				typeDefinition();
			}
			else {
				break _loop19413;
			}
			
		} while (true);
		}
		match(SEMI);
	}
	
	public final void variableDeclarationPart() throws RecognitionException, TokenStreamException {
		
		
		match(VAR);
		variableDeclaration();
		{
		_loop19454:
		do {
			if ((LA(1)==SEMI) && (LA(2)==IDENT)) {
				match(SEMI);
				variableDeclaration();
			}
			else {
				break _loop19454;
			}
			
		} while (true);
		}
		match(SEMI);
	}
	
	public final void procedureAndFunctionDeclarationPart() throws RecognitionException, TokenStreamException {
		
		
		procedureOrFunctionDeclaration();
		match(SEMI);
	}
	
	public final void statementPart() throws RecognitionException, TokenStreamException {
		
		
		compoundStatement();
	}
	
	public final void label() throws RecognitionException, TokenStreamException {
		
		
		unsignedInteger();
	}
	
	public final void unsignedInteger() throws RecognitionException, TokenStreamException {
		
		
		match(NUM_INT);
	}
	
	public final void constantDefinition() throws RecognitionException, TokenStreamException {
		
		
		identifier();
		match(EQUAL);
		constant();
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case NUM_INT:
		case NUM_REAL:
		{
			unsignedNumber();
			break;
		}
		case IDENT:
		{
			constantIdentifier();
			break;
		}
		case STRING_LITERAL:
		{
			string();
			break;
		}
		default:
			if ((LA(1)==PLUS||LA(1)==MINUS) && (LA(2)==NUM_INT||LA(2)==NUM_REAL)) {
				sign();
				unsignedNumber();
			}
			else if ((LA(1)==PLUS||LA(1)==MINUS) && (LA(2)==IDENT)) {
				sign();
				constantIdentifier();
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void unsignedNumber() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case NUM_INT:
		{
			unsignedInteger();
			break;
		}
		case NUM_REAL:
		{
			unsignedReal();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void sign() throws RecognitionException, TokenStreamException {
		
		
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
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void constantIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void string() throws RecognitionException, TokenStreamException {
		
		
		match(STRING_LITERAL);
	}
	
	public final void unsignedReal() throws RecognitionException, TokenStreamException {
		
		
		match(NUM_REAL);
	}
	
	public final void typeDefinition() throws RecognitionException, TokenStreamException {
		
		
		identifier();
		match(EQUAL);
		type();
	}
	
	public final void type() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case LPAREN:
		case IDENT:
		case NUM_INT:
		case NUM_REAL:
		case PLUS:
		case MINUS:
		case STRING_LITERAL:
		case CHAR:
		case BOOLEAN:
		case INTEGER:
		case REAL:
		{
			simpleType();
			break;
		}
		case PACKED:
		case ARRAY:
		case RECORD:
		case SET:
		case FILE:
		{
			structuredType();
			break;
		}
		case POINTER:
		{
			pointerType();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void simpleType() throws RecognitionException, TokenStreamException {
		
		
		if ((LA(1)==LPAREN)) {
			scalarType();
		}
		else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
			subrangeType();
		}
		else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_3.member(LA(2)))) {
			typeIdentifier();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void structuredType() throws RecognitionException, TokenStreamException {
		
		
		{
		switch ( LA(1)) {
		case PACKED:
		{
			match(PACKED);
			break;
		}
		case ARRAY:
		case RECORD:
		case SET:
		case FILE:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		unpackedStructuredType();
	}
	
	public final void pointerType() throws RecognitionException, TokenStreamException {
		
		
		match(POINTER);
		typeIdentifier();
	}
	
	public final void scalarType() throws RecognitionException, TokenStreamException {
		
		
		match(LPAREN);
		identifier();
		{
		_loop19419:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				identifier();
			}
			else {
				break _loop19419;
			}
			
		} while (true);
		}
		match(RPAREN);
	}
	
	public final void subrangeType() throws RecognitionException, TokenStreamException {
		
		
		constant();
		match(DOTDOT);
		constant();
	}
	
	public final void typeIdentifier() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IDENT:
		{
			identifier();
			break;
		}
		case CHAR:
		{
			match(CHAR);
			break;
		}
		case BOOLEAN:
		{
			match(BOOLEAN);
			break;
		}
		case INTEGER:
		{
			match(INTEGER);
			break;
		}
		case REAL:
		{
			match(REAL);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void empty() throws RecognitionException, TokenStreamException {
		
		
	}
	
	public final void unpackedStructuredType() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case ARRAY:
		{
			arrayType();
			break;
		}
		case RECORD:
		{
			recordType();
			break;
		}
		case SET:
		{
			setType();
			break;
		}
		case FILE:
		{
			fileType();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void arrayType() throws RecognitionException, TokenStreamException {
		
		
		match(ARRAY);
		match(LBRACK);
		indexType();
		{
		_loop19427:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				indexType();
			}
			else {
				break _loop19427;
			}
			
		} while (true);
		}
		match(RBRACK);
		match(OF);
		componentType();
	}
	
	public final void recordType() throws RecognitionException, TokenStreamException {
		
		
		match(RECORD);
		fieldList();
		match(END);
	}
	
	public final void setType() throws RecognitionException, TokenStreamException {
		
		
		match(SET);
		match(OF);
		baseType();
	}
	
	public final void fileType() throws RecognitionException, TokenStreamException {
		
		
		match(FILE);
		match(OF);
		type();
	}
	
	public final void indexType() throws RecognitionException, TokenStreamException {
		
		
		simpleType();
	}
	
	public final void componentType() throws RecognitionException, TokenStreamException {
		
		
		type();
	}
	
	public final void fieldList() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case RPAREN:
		case SEMI:
		case IDENT:
		case END:
		{
			fixedPart();
			{
			switch ( LA(1)) {
			case SEMI:
			{
				match(SEMI);
				variantPart();
				break;
			}
			case RPAREN:
			case END:
			{
				empty();
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
		case CASE:
		{
			variantPart();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void fixedPart() throws RecognitionException, TokenStreamException {
		
		
		recordSection();
		{
		_loop19435:
		do {
			if ((LA(1)==SEMI) && (_tokenSet_4.member(LA(2)))) {
				match(SEMI);
				recordSection();
			}
			else {
				break _loop19435;
			}
			
		} while (true);
		}
	}
	
	public final void variantPart() throws RecognitionException, TokenStreamException {
		
		
		match(CASE);
		tagField();
		typeIdentifier();
		match(OF);
		variant();
		{
		_loop19441:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				variant();
			}
			else {
				break _loop19441;
			}
			
		} while (true);
		}
	}
	
	public final void recordSection() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IDENT:
		{
			fieldIdentifier();
			{
			_loop19438:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					fieldIdentifier();
				}
				else {
					break _loop19438;
				}
				
			} while (true);
			}
			match(COLON);
			type();
			break;
		}
		case RPAREN:
		case SEMI:
		case END:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void fieldIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void tagField() throws RecognitionException, TokenStreamException {
		
		
		if ((LA(1)==IDENT) && (LA(2)==COLON)) {
			fieldIdentifier();
			match(COLON);
		}
		else if ((_tokenSet_2.member(LA(1))) && (LA(2)==OF)) {
			empty();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void variant() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IDENT:
		case NUM_INT:
		case NUM_REAL:
		case PLUS:
		case MINUS:
		case STRING_LITERAL:
		{
			caseLabelList();
			match(COLON);
			match(LPAREN);
			fieldList();
			match(RPAREN);
			break;
		}
		case RPAREN:
		case SEMI:
		case END:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void caseLabelList() throws RecognitionException, TokenStreamException {
		
		
		caseLabel();
		{
		_loop19446:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				caseLabel();
			}
			else {
				break _loop19446;
			}
			
		} while (true);
		}
	}
	
	public final void caseLabel() throws RecognitionException, TokenStreamException {
		
		
		constant();
	}
	
	public final void baseType() throws RecognitionException, TokenStreamException {
		
		
		simpleType();
	}
	
	public final void variableDeclaration() throws RecognitionException, TokenStreamException {
		
		
		identifier();
		{
		_loop19457:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				identifier();
			}
			else {
				break _loop19457;
			}
			
		} while (true);
		}
		match(COLON);
		type();
	}
	
	public final void procedureOrFunctionDeclaration() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case PROCEDURE:
		{
			procedureDeclaration();
			break;
		}
		case FUNCTION:
		{
			functionDeclaration();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void procedureDeclaration() throws RecognitionException, TokenStreamException {
		
		
		procedureHeading();
		block();
	}
	
	public final void functionDeclaration() throws RecognitionException, TokenStreamException {
		
		
		functionHeading();
		block();
	}
	
	public final void procedureHeading() throws RecognitionException, TokenStreamException {
		
		
		match(PROCEDURE);
		identifier();
		parameterList();
		match(SEMI);
	}
	
	public final void parameterList() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case SEMI:
		case COLON:
		{
			empty();
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			formalParameterSection();
			{
			_loop19464:
			do {
				if ((LA(1)==SEMI)) {
					match(SEMI);
					formalParameterSection();
				}
				else {
					break _loop19464;
				}
				
			} while (true);
			}
			match(RPAREN);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void formalParameterSection() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IDENT:
		{
			parameterGroup();
			break;
		}
		case VAR:
		{
			match(VAR);
			parameterGroup();
			break;
		}
		case FUNCTION:
		{
			match(FUNCTION);
			parameterGroup();
			break;
		}
		case PROCEDURE:
		{
			match(PROCEDURE);
			identifier();
			{
			_loop19467:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					identifier();
				}
				else {
					break _loop19467;
				}
				
			} while (true);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void parameterGroup() throws RecognitionException, TokenStreamException {
		
		
		identifier();
		{
		_loop19470:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				identifier();
			}
			else {
				break _loop19470;
			}
			
		} while (true);
		}
		match(COLON);
		typeIdentifier();
	}
	
	public final void functionHeading() throws RecognitionException, TokenStreamException {
		
		
		match(FUNCTION);
		identifier();
		parameterList();
		match(COLON);
		resultType();
		match(SEMI);
	}
	
	public final void resultType() throws RecognitionException, TokenStreamException {
		
		
		typeIdentifier();
	}
	
	public final void compoundStatement() throws RecognitionException, TokenStreamException {
		
		
		match(BEGIN);
		statement();
		{
		_loop19532:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				statement();
			}
			else {
				break _loop19532;
			}
			
		} while (true);
		}
		match(END);
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		
		{
		switch ( LA(1)) {
		case NUM_INT:
		{
			label();
			match(COLON);
			break;
		}
		case SEMI:
		case IDENT:
		case END:
		case CASE:
		case GOTO:
		case BEGIN:
		case IF:
		case ELSE:
		case WHILE:
		case REPEAT:
		case UNTIL:
		case FOR:
		case WITH:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		unlabelledStatement();
	}
	
	public final void unlabelledStatement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case SEMI:
		case IDENT:
		case END:
		case GOTO:
		case ELSE:
		case UNTIL:
		{
			simpleStatement();
			break;
		}
		case CASE:
		case BEGIN:
		case IF:
		case WHILE:
		case REPEAT:
		case FOR:
		case WITH:
		{
			structuredStatement();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void simpleStatement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case GOTO:
		{
			gotoStatement();
			break;
		}
		case SEMI:
		case END:
		case ELSE:
		case UNTIL:
		{
			emptyStatement();
			break;
		}
		default:
			if ((LA(1)==IDENT) && (_tokenSet_5.member(LA(2)))) {
				assignmentStatement();
			}
			else if ((LA(1)==IDENT) && (_tokenSet_6.member(LA(2)))) {
				procedureStatement();
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void structuredStatement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case BEGIN:
		{
			compoundStatement();
			break;
		}
		case CASE:
		case IF:
		{
			conditionalStatement();
			break;
		}
		case WHILE:
		case REPEAT:
		case FOR:
		{
			repetetiveStatement();
			break;
		}
		case WITH:
		{
			withStatement();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void assignmentStatement() throws RecognitionException, TokenStreamException {
		
		
		if ((LA(1)==IDENT) && (_tokenSet_5.member(LA(2)))) {
			variable();
			match(ASSIGN);
			expression();
		}
		else if ((LA(1)==IDENT) && (LA(2)==ASSIGN)) {
			functionIdentifier();
			match(ASSIGN);
			expression();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void procedureStatement() throws RecognitionException, TokenStreamException {
		
		
		procedureIdentifier();
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			actualParameter();
			{
			_loop19523:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					actualParameter();
				}
				else {
					break _loop19523;
				}
				
			} while (true);
			}
			match(RPAREN);
			break;
		}
		case SEMI:
		case END:
		case ELSE:
		case UNTIL:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final void gotoStatement() throws RecognitionException, TokenStreamException {
		
		
		match(GOTO);
		label();
	}
	
	public final void emptyStatement() throws RecognitionException, TokenStreamException {
		
		
		empty();
	}
	
	public final void variable() throws RecognitionException, TokenStreamException {
		
		
		if ((LA(1)==IDENT) && (_tokenSet_7.member(LA(2)))) {
			entireVariable();
		}
		else if ((LA(1)==IDENT) && (_tokenSet_8.member(LA(2)))) {
			componentVariable();
		}
		else if ((LA(1)==IDENT) && (LA(2)==POINTER)) {
			referencedVariable();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		
		simpleExpression();
		{
		switch ( LA(1)) {
		case COMMA:
		case RPAREN:
		case SEMI:
		case DOTDOT:
		case RBRACK:
		case OF:
		case END:
		case THEN:
		case ELSE:
		case DO:
		case UNTIL:
		case TO:
		case DOWNTO:
		{
			empty();
			break;
		}
		case EQUAL:
		case NOT_EQUAL:
		case LT:
		case LE:
		case GE:
		case GT:
		case IN:
		{
			relationalOperator();
			simpleExpression();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final void functionIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void entireVariable() throws RecognitionException, TokenStreamException {
		
		
		variableIdentifier();
	}
	
	public final void componentVariable() throws RecognitionException, TokenStreamException {
		
		
		if ((LA(1)==IDENT) && (LA(2)==LBRACK)) {
			indexedVariable();
		}
		else if ((LA(1)==IDENT) && (LA(2)==DOT)) {
			fieldDesignator();
		}
		else if ((LA(1)==IDENT) && (LA(2)==POINTER)) {
			fileBuffer();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void referencedVariable() throws RecognitionException, TokenStreamException {
		
		
		pointerVariable();
		match(POINTER);
	}
	
	public final void variableIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void indexedVariable() throws RecognitionException, TokenStreamException {
		
		
		arrayVariable();
		match(LBRACK);
		expression();
		{
		_loop19486:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				expression();
			}
			else {
				break _loop19486;
			}
			
		} while (true);
		}
		match(RBRACK);
	}
	
	public final void fieldDesignator() throws RecognitionException, TokenStreamException {
		
		
		recordVariable();
		match(DOT);
		fieldIdentifier();
	}
	
	public final void fileBuffer() throws RecognitionException, TokenStreamException {
		
		
		fileVariable();
		match(POINTER);
	}
	
	public final void arrayVariable() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void recordVariable() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void fileVariable() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void pointerVariable() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void simpleExpression() throws RecognitionException, TokenStreamException {
		
		
		{
		switch ( LA(1)) {
		case PLUS:
		case MINUS:
		{
			sign();
			break;
		}
		case LPAREN:
		case IDENT:
		case NUM_INT:
		case NUM_REAL:
		case STRING_LITERAL:
		case LBRACK:
		case NOT:
		case NIL:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		term();
		{
		_loop19501:
		do {
			if ((_tokenSet_9.member(LA(1)))) {
				addingOperator();
				term();
			}
			else {
				break _loop19501;
			}
			
		} while (true);
		}
	}
	
	public final void relationalOperator() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case EQUAL:
		{
			match(EQUAL);
			break;
		}
		case NOT_EQUAL:
		{
			match(NOT_EQUAL);
			break;
		}
		case LT:
		{
			match(LT);
			break;
		}
		case LE:
		{
			match(LE);
			break;
		}
		case GE:
		{
			match(GE);
			break;
		}
		case GT:
		{
			match(GT);
			break;
		}
		case IN:
		{
			match(IN);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void term() throws RecognitionException, TokenStreamException {
		
		
		factor();
		{
		_loop19505:
		do {
			if (((LA(1) >= STAR && LA(1) <= AND))) {
				multiplyingOperator();
				factor();
			}
			else {
				break _loop19505;
			}
			
		} while (true);
		}
	}
	
	public final void addingOperator() throws RecognitionException, TokenStreamException {
		
		
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
		case OR:
		{
			match(OR);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void factor() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			expression();
			match(RPAREN);
			break;
		}
		case LBRACK:
		{
			set();
			break;
		}
		case NOT:
		{
			match(NOT);
			factor();
			break;
		}
		default:
			if ((LA(1)==IDENT) && (_tokenSet_10.member(LA(2)))) {
				variable();
			}
			else if ((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2)))) {
				unsignedConstant();
			}
			else if ((LA(1)==IDENT) && (_tokenSet_13.member(LA(2)))) {
				functionDesignator();
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void multiplyingOperator() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case STAR:
		{
			match(STAR);
			break;
		}
		case SLASH:
		{
			match(SLASH);
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
		case AND:
		{
			match(AND);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void unsignedConstant() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case NUM_INT:
		case NUM_REAL:
		{
			unsignedNumber();
			break;
		}
		case STRING_LITERAL:
		{
			string();
			break;
		}
		case IDENT:
		{
			constantIdentifier();
			break;
		}
		case NIL:
		{
			match(NIL);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void functionDesignator() throws RecognitionException, TokenStreamException {
		
		
		functionIdentifier();
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			actualParameter();
			{
			_loop19512:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					actualParameter();
				}
				else {
					break _loop19512;
				}
				
			} while (true);
			}
			match(RPAREN);
			break;
		}
		case COMMA:
		case RPAREN:
		case SEMI:
		case EQUAL:
		case PLUS:
		case MINUS:
		case DOTDOT:
		case RBRACK:
		case OF:
		case END:
		case NOT_EQUAL:
		case LT:
		case LE:
		case GE:
		case GT:
		case IN:
		case OR:
		case STAR:
		case SLASH:
		case DIV:
		case MOD:
		case AND:
		case THEN:
		case ELSE:
		case DO:
		case UNTIL:
		case TO:
		case DOWNTO:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final void set() throws RecognitionException, TokenStreamException {
		
		
		match(LBRACK);
		elementList();
		match(RBRACK);
	}
	
	public final void actualParameter() throws RecognitionException, TokenStreamException {
		
		
		if ((_tokenSet_14.member(LA(1))) && (_tokenSet_15.member(LA(2)))) {
			expression();
		}
		else if ((LA(1)==IDENT) && (_tokenSet_16.member(LA(2)))) {
			variable();
		}
		else if ((LA(1)==IDENT) && (LA(2)==COMMA||LA(2)==RPAREN)) {
			procedureIdentifier();
		}
		else if ((LA(1)==IDENT) && (LA(2)==COMMA||LA(2)==RPAREN)) {
			functionIdentifier();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
	}
	
	public final void elementList() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case LPAREN:
		case IDENT:
		case NUM_INT:
		case NUM_REAL:
		case PLUS:
		case MINUS:
		case STRING_LITERAL:
		case LBRACK:
		case NOT:
		case NIL:
		{
			element();
			{
			_loop19517:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					element();
				}
				else {
					break _loop19517;
				}
				
			} while (true);
			}
			break;
		}
		case RBRACK:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void element() throws RecognitionException, TokenStreamException {
		
		
		expression();
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			match(DOTDOT);
			expression();
			break;
		}
		case COMMA:
		case RBRACK:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final void procedureIdentifier() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void conditionalStatement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IF:
		{
			ifStatement();
			break;
		}
		case CASE:
		{
			caseStatement();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void repetetiveStatement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case WHILE:
		{
			whileStatement();
			break;
		}
		case REPEAT:
		{
			repeatStatement();
			break;
		}
		case FOR:
		{
			forStatement();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void withStatement() throws RecognitionException, TokenStreamException {
		
		
		match(WITH);
		recordVariableList();
		match(DO);
		statement();
	}
	
	public final void ifStatement() throws RecognitionException, TokenStreamException {
		
		
		match(IF);
		expression();
		match(THEN);
		statement();
		{
		if ((LA(1)==ELSE) && (_tokenSet_17.member(LA(2)))) {
			match(ELSE);
			statement();
		}
		else if ((_tokenSet_18.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
			empty();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
	}
	
	public final void caseStatement() throws RecognitionException, TokenStreamException {
		
		
		match(CASE);
		expression();
		match(OF);
		caseListElement();
		{
		_loop19538:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				caseListElement();
			}
			else {
				break _loop19538;
			}
			
		} while (true);
		}
		match(END);
	}
	
	public final void caseListElement() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case IDENT:
		case NUM_INT:
		case NUM_REAL:
		case PLUS:
		case MINUS:
		case STRING_LITERAL:
		{
			caseLabelList();
			match(COLON);
			statement();
			break;
		}
		case SEMI:
		case END:
		{
			empty();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void whileStatement() throws RecognitionException, TokenStreamException {
		
		
		match(WHILE);
		expression();
		match(DO);
		statement();
	}
	
	public final void repeatStatement() throws RecognitionException, TokenStreamException {
		
		
		match(REPEAT);
		statement();
		{
		_loop19544:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				statement();
			}
			else {
				break _loop19544;
			}
			
		} while (true);
		}
		match(UNTIL);
		expression();
	}
	
	public final void forStatement() throws RecognitionException, TokenStreamException {
		
		
		match(FOR);
		controlVariable();
		match(ASSIGN);
		forList();
		match(DO);
		statement();
	}
	
	public final void controlVariable() throws RecognitionException, TokenStreamException {
		
		
		identifier();
	}
	
	public final void forList() throws RecognitionException, TokenStreamException {
		
		
		initialValue();
		{
		switch ( LA(1)) {
		case TO:
		{
			match(TO);
			break;
		}
		case DOWNTO:
		{
			match(DOWNTO);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		finalValue();
	}
	
	public final void initialValue() throws RecognitionException, TokenStreamException {
		
		
		expression();
	}
	
	public final void finalValue() throws RecognitionException, TokenStreamException {
		
		
		expression();
	}
	
	public final void recordVariableList() throws RecognitionException, TokenStreamException {
		
		
		recordVariable();
		{
		_loop19554:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				recordVariable();
			}
			else {
				break _loop19554;
			}
			
		} while (true);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"DOT",
		"\"program\"",
		"LPAREN",
		"COMMA",
		"RPAREN",
		"SEMI",
		"IDENT",
		"\"label\"",
		"\"const\"",
		"EQUAL",
		"NUM_INT",
		"NUM_REAL",
		"PLUS",
		"MINUS",
		"STRING_LITERAL",
		"\"type\"",
		"DOTDOT",
		"\"char\"",
		"\"boolean\"",
		"\"integer\"",
		"\"real\"",
		"\"packed\"",
		"\"array\"",
		"LBRACK",
		"RBRACK",
		"\"of\"",
		"\"record\"",
		"\"end\"",
		"COLON",
		"\"case\"",
		"\"set\"",
		"\"file\"",
		"POINTER",
		"\"var\"",
		"\"procedure\"",
		"\"function\"",
		"ASSIGN",
		"NOT_EQUAL",
		"LT",
		"LE",
		"GE",
		"GT",
		"\"in\"",
		"\"or\"",
		"STAR",
		"SLASH",
		"\"div\"",
		"\"mod\"",
		"\"and\"",
		"\"not\"",
		"\"nil\"",
		"\"goto\"",
		"\"begin\"",
		"\"if\"",
		"\"then\"",
		"\"else\"",
		"\"while\"",
		"\"do\"",
		"\"repeat\"",
		"\"until\"",
		"\"for\"",
		"\"to\"",
		"\"downto\"",
		"\"with\"",
		"WS",
		"COMMENT_1",
		"COMMENT_2",
		"EXPONENT"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 508928L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 1098752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 31458304L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 2415920000L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 2147485440L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 1168365322256L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { -8646911282403868096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { -6043831796488789120L, 6L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 68853694480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 140737488551936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { -6043832827146722416L, 6L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 18014398509794304L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { -6043832896000416896L, 6L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { -6043832896000416832L, 6L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 27021597898949696L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 36026667118355920L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 68853694864L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { -2630102171646933504L, 9L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { -8646911282403868160L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { -2603080573748001200L, 9L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	
	}
