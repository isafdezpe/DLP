/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(VarDefinition node, Object param);
	public Object visit(StructDefinition node, Object param);
	public Object visit(FunDefinition node, Object param);
	public Object visit(StructField node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(RealType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(VarType node, Object param);
	public Object visit(VoidType node, Object param);
	public Object visit(ArrayType node, Object param);
	public Object visit(StructType node, Object param);
	public Object visit(ErrorType node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Printsp node, Object param);
	public Object visit(Println node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(IfElse node, Object param);
	public Object visit(While node, Object param);
	public Object visit(FuncInvocation node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
	public Object visit(CharConstant node, Object param);
	public Object visit(VoidConstant node, Object param);
	public Object visit(FuncInvocationExpression node, Object param);
	public Object visit(ArithmeticExpression node, Object param);
	public Object visit(LogicalExpression node, Object param);
	public Object visit(UnaryExpression node, Object param);
	public Object visit(ComparableExpression node, Object param);
	public Object visit(CastExpression node, Object param);
	public Object visit(FieldAccessExpression node, Object param);
	public Object visit(IndexExpression node, Object param);
}
