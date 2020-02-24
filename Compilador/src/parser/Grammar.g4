grammar Grammar
	;

import Lexicon
	;

start
	: definition* EOF
	;

definition
	: defVar
	| defStruct
	| defFunc
	;
	
defVar
	: 'var' IDENT ':' type ';'
	| 'struct' IDENT '{' defStruct+ '}' ';'
	;

type
	: 'int'
	| 'float'
	| 'char'
	| IDENT
	| '[' INT_CONSTANT ']' type
	;
	
defStruct
	: IDENT ':' type ';'
	;
	
defFunc
	: IDENT '(' params? ')' (':' type)? '{' defVar* sentence* '}'
	;
	
params
	: IDENT ':' type | IDENT ':' type ',' params
	;
	
sentence
	: expr '=' expr
	| 'read' expr ';'
	| ('print' | 'printsp' | 'println') expr ';'
	| 'return' expr ';'
	;
	
expr
	: '(' expr ')'
	| expr ('*'|'/') expr
	| expr ('+'|'-') expr
	| expr '.' IDENT
	;
