grammar Grammar
	;

import Lexicon
	;

@parser::header {
    import ast.*;
}

// --------------------------------------------------------------------
// Solución 1. Versión básica original.
// - No guarda posiciones de línea.
// - Usa '$IDENT.text' y '$l.ast'
/*
start returns[Program ast]
	: 'DATA' variables 'CODE' sentences EOF { $ast = new Program($variables.list, $sentences.list); }
	;

variables returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
	: (variable { $list.add($variable.ast); })*
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

tipo returns[Type ast]
	: 'float'	{  $ast = new RealType(); }
	| 'int'		{  $ast = new IntType(); }
	;

variable returns[VarDefinition ast]
	: tipo IDENT ';' { $ast = new VarDefinition($tipo.ast, $IDENT.text); }
	;

sentence returns[Sentence ast]
	: 'print' expr ';'		{ $ast = new Print($expr.ast); }
	| l=expr '=' r=expr ';'	{ $ast = new Assignment($l.ast, $r.ast); }
	;

expr returns[Expression ast]
	: l=expr op=('*' | '/') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op.text, $r.ast); }
	| l=expr op=('+' | '-') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op.text, $r.ast); }
	| '(' expr ')'					{ $ast = $expr.ast; }
	| IDENT							{ $ast = new Variable($IDENT.text); }
	| INT_CONSTANT					{ $ast = new IntConstant($INT_CONSTANT.text); }
	| REAL_CONSTANT					{ $ast = new RealConstant($REAL_CONSTANT.text); }
	;
*/
// --------------------------------------------------------------------
// Solución 2. Añade información de fila/columna en cada nodo (Requiere VGen).
// Ello se consigue pasando a los nodos $TOKEN en vez de $TOKEN.text (ver 'variable' y 'expr).
/*
start returns[Program ast]
	: 'DATA' variables 'CODE' sentences EOF { $ast = new Program($variables.list, $sentences.list); }
	;

variables returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
	: (variable { $list.add($variable.ast); })*
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

tipo returns[Type ast]
	: 'float'	{  $ast = new RealType(); }
	| 'int'		{  $ast = new IntType(); }
	;

variable returns[VarDefinition ast]
	: tipo IDENT ';' { $ast = new VarDefinition($tipo.ast, $IDENT); }
	;

sentence returns[Sentence ast]
	: 'print' expr ';'		{ $ast = new Print($expr.ast); }
	| l=expr '=' r=expr ';'	{ $ast = new Assignment($l.ast, $r.ast); }
	;

expr returns[Expression ast]
	: l=expr op=('*' | '/') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op, $r.ast); }
	| l=expr op=('+' | '-') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op, $r.ast); }
	| '(' expr ')'					{ $ast = $expr.ast; }
	| IDENT							{ $ast = new Variable($IDENT); }
	| INT_CONSTANT					{ $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT					{ $ast = new RealConstant($REAL_CONSTANT); }
	;
*/
// --------------------------------------------------------------------
// Solución 3. Elimina reglas usando `+=` (Requiere VGen).
// Permite eliminar los no-terminales creados únicamente para listas.
// En este caso, elimina las reglas 'variables' y 'sentences' al usar en la regla 'start' el operador '+='

start returns[Program ast]
	: 'DATA' lv+=variable* 'CODE' ls+=sentence* EOF { $ast = new Program($lv, $ls); }
	;

tipo returns[Type ast]
	: 'float'	{  $ast = new RealType(); }
	| 'int'		{  $ast = new IntType(); }
	;

variable returns[VarDefinition ast]
	: tipo IDENT ';' { $ast = new VarDefinition($tipo.ast, $IDENT); }
	;

sentence returns[Sentence ast]
	: 'print' expr ';'		{ $ast = new Print($expr.ast); }
	| l=expr '=' r=expr ';'	{ $ast = new Assignment($l.ast, $r.ast); }
	;

expr returns[Expression ast]
	: l=expr op=('*' | '/') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op, $r.ast); }
	| l=expr op=('+' | '-') r=expr	{ $ast = new ArithmeticExpression($l.ast, $op, $r.ast); }
	| '(' expr ')'					{ $ast = $expr.ast; }
	| IDENT							{ $ast = new Variable($IDENT); }
	| INT_CONSTANT					{ $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT					{ $ast = new RealConstant($REAL_CONSTANT); }
	;
