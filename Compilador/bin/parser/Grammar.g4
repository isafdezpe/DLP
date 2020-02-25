grammar Grammar
	;

import Lexicon
	;

start
	: instruction* EOF
	;

instruction
	: defVar
	| defFunc
	;

defVar
	: 'var' IDENT ':' type ';'
	| 'struct' IDENT '{' (IDENT ':' type ';')+ '}' ';'
	;

type
	: 'int'
	| 'float'
	| 'char'
	| IDENT
	| '[' INT_CONSTANT ']' type
	;

defFunc
	: IDENT '(' params? ')' (':' type)? '{' defVar* sentences '}'
	;

params
	: param
	| params ',' param
	;

param
	: IDENT ':' type
	;

sentences
	: sentence*
	;

sentence
	: expr '=' expr ';'
	| 'read' expr ';'
	| ('print' | 'printsp' | 'println') expr ';'
	| 'return' expr ';'
	| 'if' '(' expr ')' '{' sentences '}' ('else' '{' sentences '}')?
	| 'while' '(' expr ')' '{' sentences '}'
	;

expr
	: IDENT
	| INT_CONSTANT
	| REAL_CONSTANT
	| CHAR_CONSTANT
	| IDENT '(' args? ')'
	| '(' expr ')'
	| expr ('*' | '/') expr
	| expr ('+' | '-') expr
	| expr '[' expr ']'
	| expr '.' IDENT
	| expr ('<' | '>' | '<=' | '>=' | '==' | '!=') expr
	| '!' expr
	| expr '&&' expr
	| expr '||' expr
	| 'cast' '<' type '>' '(' expr ')'
	;

args
	: expr
	| args ',' expr
	;
