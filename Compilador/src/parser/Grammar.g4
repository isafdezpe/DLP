grammar Grammar
	;

import Lexicon
	;

@parser::header {
    import ast.*;
}

start returns[Program ast]
	: definitions { $ast = new Program($definitions.list); } EOF
	;

definitions returns[List<Definition> list = new ArrayList<Definition>();]
	: (definition { $list.add($definition.ast); })*
	;

definition returns[Definition ast]
	: defVar								{ $ast = $defVar.ast; }
	| 'struct' IDENT '{' defFields '}' ';'	{ $ast = new StructDefinition($IDENT,$defFields.list); }
	| defFunc								{ $ast = $defFunc.ast; }
	;

defVars returns[List<Definition> list = new ArrayList<Definition>();]
	: (defVar { $list.add($defVar.ast); })*
	;

defVar returns[Definition ast]
	: 'var' IDENT ':' type ';' { $ast = new VarDefinition($IDENT,$type.ast); }
	;

defFields returns[List<StructField> list = new ArrayList<StructField>();]
	: (IDENT ':' type ';' { $list.add(new StructField($IDENT,$type.ast)); })+
	;

type returns[Type ast]
	: 'int'						{ $ast = new IntType(); }
	| 'float'					{ $ast = new RealType(); }
	| 'char'					{ $ast = new CharType(); }
	| IDENT						{ $ast = new VarType($IDENT); }
	| '[' INT_CONSTANT ']' type	{ $ast = new ArrayType($INT_CONSTANT,$type.ast); }
	;

defFunc returns[Definition ast]
	: IDENT '(' params ')' (':' type)? '{' defVars sentences '}' { $ast = new FunDefinition($IDENT,$params.list,$type.ast,$defVars.list,$sentences.list); }
	;

params returns[List<Definition> list = new ArrayList<Definition>()]
	: (param { $list.add($param.ast); } (',' param { $list.add($param.ast); })*)?
	;

param returns[Definition ast]
	: IDENT ':' type { $ast = new VarDefinition($IDENT,$type.ast); }
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
	| 'while' '(' expr ')' '{' sentences '}'							{ $ast = new While($expr.ast, $sentences.list); }
	| IDENT '(' args ')' ';'											{ $ast = new FuncInvocation($IDENT, $args.list); }
	;

expr returns[Expression ast]
	: IDENT													{ $ast = new Variable($IDENT); }
	| INT_CONSTANT											{ $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT											{ $ast = new RealConstant($REAL_CONSTANT); }
	| CHAR_CONSTANT											{ $ast = new CharConstant($CHAR_CONSTANT); }
	| IDENT '(' args ')'									{ $ast = new FuncInvocationExpression($IDENT,$args.list); }
	| expr '[' expr ']'										{ $ast = new IndexExpression($ctx.expr(0),$ctx.expr(1)); }
	| expr '.' IDENT										{ $ast = new FieldAccessExpression($expr.ast,$IDENT); }
	| 'cast' '<' type '>' '(' expr ')'						{ $ast = new CastExpression($type.ast,$expr.ast); }
	| '(' expr ')'											{ $ast = $expr.ast; }
	| expr op=('*' | '/') expr								{ $ast = new ArithmeticExpression($ctx.expr(0),$op,$ctx.expr(1)); }
	| expr op=('+' | '-') expr								{ $ast = new ArithmeticExpression($ctx.expr(0),$op,$ctx.expr(1)); }
	| expr op=('<' | '>' | '<=' | '>=' | '==' | '!=') expr	{ $ast = new ComparableExpression($ctx.expr(0),$op,$ctx.expr(1)); }
	| op='!' expr											{ $ast = new UnaryExpression($op,$expr.ast); }
	| expr op='&&' expr										{ $ast = new LogicalExpression($ctx.expr(0),$op,$ctx.expr(1)); }
	| expr op='||' expr										{ $ast = new LogicalExpression($ctx.expr(0),$op,$ctx.expr(1)); }
	;

args returns[List<Expression> list = new ArrayList<Expression>()]
	: (expr { $list.add($expr.ast); } (',' expr { $list.add($expr.ast); })*)
	;
