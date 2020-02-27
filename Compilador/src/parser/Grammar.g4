grammar Grammar
	;

import Lexicon
	;

@parser::header {
    import ast.*;
}

start
	: definition* EOF
	;

definition
	: defVar
	| 'struct' IDENT '{' defFields '}' ';'
	| defFunc
	;

defVars
	: defVar*
	;

defVar
	: 'var' IDENT ':' type ';'
	;

defFields
	: (IDENT ':' type ';')+
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
	: param
	| params ',' param
	;

param
	: IDENT ':' type
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

sentence returns[Sentence ast]
	: expr '=' expr ';'													{ $ast = new Assignment($ctx.expr(0),$ctx.expr(1)); }
	| 'read' expr ';'													{ $ast = new Read($expr.ast); }
	| 'print' expr? ';'													{ $ast = new Print($expr.ast); }
	| 'printsp' expr? ';'												{ $ast = new Printsp($expr.ast); }
	| 'println' expr? ';'												{ $ast = new Println($expr.ast); }
	| 'return' expr ';'													{ $ast = new Return($expr.ast); }
	| 'if' '(' expr ')' '{' sentences '}' ('else' '{' sentences '}')?	{ $ast = new IfElse($expr.ast, $ctx.sentences(0), $ctx.sentences(1)); }
	| 'while' '(' expr ')' '{' sentences '}'							{ $ast = new While($expr.ast, $sentences.ast); }
	| IDENT '(' args? ')' ';'											{ $ast = new FuncInvocation($IDENT, $args.ast); }
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
