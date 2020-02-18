lexer grammar Lexicon
	;

INT_CONSTANT
	: [0-9]+
	;
	
REAL_CONSTANT
	: [0-9]+ '.' [0-9]+
	;
	
INT
	: 'int'
	;
	
REAL
	: 'float'
	;
	
CODE
	: 'CODE'
	;
	
DATA
	: 'DATA'
	;
	
PRINT
	: 'print'
	;
	
IDENT
	: [a-zA-Z_][a-zA-Z0-9_]*
	;
	
PCOMA
	: ';'
	;
	
IGUAL
	: '='
	;
	
MULT
	: '*'
	;
	
SUMA
	: '+'
	;
	
RESTA
	: '-'
	;
	
DIV
	: '/'
	;
	
OPEN_BRACKET
	: '('
	;
	
CLOSE_BRACKET
	: ')'
	;

LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
