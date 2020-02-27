grammar Grammar
	;

import Lexicon
	;

start
	: definition* EOF
	;

definition
	: defVar
	| defFunc
	;

defVars
	: defVar*
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
	: IDENT '(' params? ')' (':' type)? '{' defVars sentences '}'
	;

params
	: IDENT ':' type
	| params ',' IDENT ':' type
	;

sentences
	: sentence*
	;

sentence
	: expr '=' expr ';'
	| 'read' expr ';'
	| 'print' expr? ';'
	| 'printsp' expr? ';'
	| 'println' expr? ';'
	| 'return' expr ';'
	| 'if' '(' expr ')' '{' sentences '}' ('else' '{' sentences '}')?
	| 'while' '(' expr ')' '{' sentences '}'
	| IDENT '(' args? ')' ';'
	;

expr
	: IDENT
	| INT_CONSTANT
	| REAL_CONSTANT
	| CHAR_CONSTANT
	| IDENT '(' args? ')'
	| expr '[' expr ']'
	| expr '.' IDENT
	| 'cast' '<' type '>' '(' expr ')'
	| '(' expr ')'
	| expr ('*' | '/') expr
	| expr ('+' | '-') expr
	| expr ('<' | '>' | '<=' | '>=' | '==' | '!=') expr
	| '!' expr
	| expr '&&' expr
	| expr '||' expr
	;

args
	: expr
	| args ',' expr
	;
