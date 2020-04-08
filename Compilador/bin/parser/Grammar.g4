grammar Grammar
	;

import Lexicon
	;

@parser::header {
    import ast.*;
	import ast.VarDefinition.VarScope;
}

start returns[Program ast]
	: definitions { $ast = new Program($definitions.list); } EOF
	;

definitions returns[List<Definition> list = new ArrayList<Definition>();]
	: (definition { $list.add($definition.ast); })*
	;

definition returns[Definition ast]
	: defVar													{ $ast = $defVar.ast; }
	| 'struct' IDENT '{' defFields '}' ';'						{ $ast = new StructDefinition(new VarType($IDENT),$defFields.list); }
	| IDENT '(' params ')' ':' type '{' defVars sentences '}'	{ $ast = new FunDefinition($IDENT,$params.list,$type.ast,$defVars.list,$sentences.list); }
	| IDENT '(' params ')' '{' defVars sentences '}'			{ $ast = new FunDefinition($IDENT,$params.list,new VoidType(),$defVars.list,$sentences.list); }
	;

defVars returns[List<Definition> list = new ArrayList<Definition>();]
	: ('var' IDENT ':' type ';' { $list.add(new VarDefinition($IDENT,$type.ast,VarScope.LOCAL)); })*
	;

defVar returns[Definition ast]
	: 'var' IDENT ':' type ';' { $ast = new VarDefinition($IDENT,$type.ast,VarScope.GLOBAL); }
	;

defFields returns[List<StructField> list = new ArrayList<StructField>();]
	: (IDENT ':' type ';' { $list.add(new StructField($IDENT,$type.ast)); })+
	;

type returns[Type ast]
	: i='int'					{ $ast = new IntType(); $ast.setPositions($i); }
	| f='float'					{ $ast = new RealType(); $ast.setPositions($f); }
	| c='char'					{ $ast = new CharType(); $ast.setPositions($c); }
	| IDENT						{ $ast = new VarType($IDENT); }
	| '[' INT_CONSTANT ']' type	{ $ast = new ArrayType(new IntConstant($INT_CONSTANT),$type.ast); }
	;

params returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
	: (param { $list.add($param.ast); } (',' param { $list.add($param.ast); })*)?
	;

param returns[VarDefinition ast]
	: IDENT ':' type { $ast = new VarDefinition($IDENT,$type.ast,VarScope.PARAM); }
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

sentence returns[Sentence ast]
	: expr '=' expr ';'												{ $ast = new Assignment($ctx.expr(0),$ctx.expr(1)); }
	| 'read' expr ';'												{ $ast = new Read($expr.ast); }
	| 'print' expr ';'												{ $ast = new Print($expr.ast); }
	| 'printsp' expr ';'											{ $ast = new Printsp($expr.ast); }
	| 'println' expr ';'											{ $ast = new Println($expr.ast); }
	| 'println' ';'													{ $ast = new Println(new VoidConstant()); }
	| 'return' ';'													{ $ast = new Return(new VoidConstant()); }
	| 'return' expr ';'												{ $ast = new Return($expr.ast); }
	| 'if' '(' expr ')' '{' sentences '}'							{ $ast = new IfElse($expr.ast, $ctx.sentences(0).list, null); }
	| 'if' '(' expr ')' '{' sentences '}' 'else' '{' sentences '}'	{ $ast = new IfElse($expr.ast, $ctx.sentences(0).list, $ctx.sentences(1).list); }
	| 'while' '(' expr ')' '{' sentences '}'						{ $ast = new While($expr.ast, $sentences.list); }
	| IDENT '(' args ')' ';'										{ $ast = new FuncInvocation($IDENT, $args.list); }
	;

expr returns[Expression ast]
	: IDENT													{ $ast = new Variable($IDENT); }
	| INT_CONSTANT											{ $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT											{ $ast = new RealConstant($REAL_CONSTANT); }
	| CHAR_CONSTANT											{ $ast = new CharConstant($CHAR_CONSTANT); }
	| IDENT '(' args ')'									{ $ast = new FuncInvocationExpression($IDENT,$args.list); }
	| expr '.' IDENT										{ $ast = new FieldAccessExpression($ctx.expr(0),$IDENT); }
	| expr '[' expr ']'										{ $ast = new IndexExpression($ctx.expr(0),$ctx.expr(1)); }
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
	: (expr { $list.add($expr.ast); } (',' expr { $list.add($expr.ast); })*)?
	;
