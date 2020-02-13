lexer grammar Lexicon;

INT_CONSTANT
	: [0-9]+;
	
REAL_CONSTANT
	: INT_CONSTANT '.' INT_CONSTANT;
	
IDENT
	: [a-zA-Z][a-zA-Z0-9_]*;

LINE_COMMENT
	: '//' .*? '\n' -> skip;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip;
	
WHITESPACE
	: [ \t\r\n]+ -> skip;
