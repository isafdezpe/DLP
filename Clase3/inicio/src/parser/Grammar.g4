grammar Grammar;
import Lexicon;

start
	: 'DATA' definition+ 'CODE' sentence+ EOF;

definition
	: type IDENT ';';
	
type
	: 'int'
	| 'real';

sentence
	: read
	| print
	| asign
	| if_sentence
	| while_sentence;
	
expression
	: INT_CONSTANT
	| REAL_CONSTANT
	| IDENT
	| cast;
	
read
	: 'read' IDENT ';';
	
print
	: 'print' expression | sum ';';
	
asign
	: IDENT '=' expression ';';
	
if_sentence
	: 'if' '(' condition ')' '{' sentence+ '}' else_sentence?;
	
else_sentence
	: 'else' '{' sentence+ '}';
	
while_sentence
	: 'while' '(' condition ')' '{' sentence+ '}';
	
condition
	: INT_CONSTANT
	| IDENT
	| expression '!=' expression;
	
sum
	: expression '+' expression ';';
	
cast
	: '<' type '>' '(' (IDENT | sum) ')'; 
	
	