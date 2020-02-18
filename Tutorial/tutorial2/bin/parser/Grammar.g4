grammar Grammar
	;
import Lexicon
	;

start
	: DATA definition+ CODE sentence+ EOF
	;

definition
	: type IDENT SEMICOLON
	;
	
type
	: INT
	| FLOAT
	;

sentence
	: IDENT ASSIGN expr SEMICOLON
	| PRINT expr SEMICOLON
	;
	
expr
	: INT_CONSTANT
	| REAL_CONSTANT
	| IDENT
	| expr PLUS expr
	| expr SUB expr
	| expr MULT expr
	| expr DIV expr
	| OPEN_PAREN expr CLOSE_PAREN
	;
	
	
	
	