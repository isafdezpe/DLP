package visitor;

import ast.*;

public class MiVisitor extends DefaultVisitor {

    //	class VarDefinition { String name;  Type type; }
    public Object visit(VarDefinition node, Object param) {
        System.out.print("var " + node.getName() + ":");

        if (node.getType() != null)
            node.getType().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class StructDefinition { VarType name;  List<StructField> definitions; }
    public Object visit(StructDefinition node, Object param) {
        System.out.print("struct ");

        if (node.getName() != null)
            node.getName().accept(this, param);

        System.out.println("{");

        if (node.getDefinitions() != null)
            for (StructField child : node.getDefinitions())
                child.accept(this, param);

        System.out.println("};");
        return null;
    }

    //	class FunDefinition { String name;  List<Definition> params;  Type return_t;  List<VarDefinition> definitions;  List<Sentence> sentences; }
    public Object visit(FunDefinition node, Object param) {
        System.out.print(node.getName() + "(");

        if (node.getParams() != null)
            for (Definition child : node.getParams())
                child.accept(this, param);

        System.out.print(")");

        if (node.getReturn_t() != null)
            node.getReturn_t().accept(this, param);

        System.out.println("{");

        if (node.getDefinitions() != null)
            for (VarDefinition child : node.getDefinitions())
                child.accept(this, param);

        if (node.getSentences() != null)
            for (Sentence child : node.getSentences())
                child.accept(this, param);

        System.out.println("}");
        return null;
    }

    //	class StructField { String name;  Type type; }
    public Object visit(StructField node, Object param) {
        System.out.print(node.getName() + ":");

        if (node.getType() != null)
            node.getType().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class IntType {  }
    public Object visit(IntType node, Object param) {
        System.out.print("int");
        return null;
    }

    //	class RealType {  }
    public Object visit(RealType node, Object param) {
        System.out.print("real");
        return null;
    }

    //	class CharType {  }
    public Object visit(CharType node, Object param) {
        System.out.print("char");
        return null;
    }

    //	class VarType { String type; }
    public Object visit(VarType node, Object param) {
        System.out.print(node.getType());
        return null;
    }

    //	class ArrayType { IntConstant size;  Type type; }
    public Object visit(ArrayType node, Object param) {

        // super.visit(node, param);

        if (node.getSize() != null) {
            System.out.print("[");
            node.getSize().accept(this, param);
            System.out.print("]");
        }

        if (node.getType() != null)
            node.getType().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class StructType { List<StructField> fields; }
    public Object visit(StructType node, Object param) {
        //TODO
        // super.visit(node, param);

        if (node.getFields() != null)
            for (StructField child : node.getFields())
                child.accept(this, param);

        return null;
    }

    //	class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        System.out.print("print ");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {
        System.out.print("printsp ");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class Println { Expression expression; }
    public Object visit(Println node, Object param) {
        System.out.print("println ");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class Read { Expression expression; }
    public Object visit(Read node, Object param) {
        System.out.print("read ");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        System.out.print("=");

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class Return { Expression expression; }
    public Object visit(Return node, Object param) {
        System.out.print("return ");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        System.out.println(";");
        return null;
    }

    //	class IfElse { Expression expression;  List<Sentence> if_s;  List<Sentence> else_s; }
    public Object visit(IfElse node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        if (node.getIf_s() != null)
            for (Sentence child : node.getIf_s())
                child.accept(this, param);

        if (node.getElse_s() != null)
            for (Sentence child : node.getElse_s())
                child.accept(this, param);

        return null;
    }

    //	class While { Expression expression;  List<Sentence> sentence; }
    public Object visit(While node, Object param) {

        // super.visit(node, param);

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        if (node.getSentence() != null)
            for (Sentence child : node.getSentence())
                child.accept(this, param);

        return null;
    }

    //	class FuncInvocation { String name;  List<Expression> params; }
    public Object visit(FuncInvocation node, Object param) {

        // super.visit(node, param);

        if (node.getArgs() != null)
            for (Expression child : node.getArgs())
                child.accept(this, param);

        return null;
    }

    //	class Variable { String name; }
    public Object visit(Variable node, Object param) {
        return null;
    }

    //	class IntConstant { String value; }
    public Object visit(IntConstant node, Object param) {
        return null;
    }

    //	class RealConstant { String value; }
    public Object visit(RealConstant node, Object param) {
        return null;
    }

    //	class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
        return null;
    }

    //	class VoidConstant {  }
    public Object visit(VoidConstant node, Object param) {
        return null;
    }

    //	class FuncInvocationExpression { String name;  List<Expression> params; }
    public Object visit(FuncInvocationExpression node, Object param) {

        // super.visit(node, param);

        if (node.getArgs() != null)
            for (Expression child : node.getArgs())
                child.accept(this, param);

        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class LogicalExpression { Expression left;  String operator;  Expression right; }
    public Object visit(LogicalExpression node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class UnaryExpression { String operator;  Expression expr; }
    public Object visit(UnaryExpression node, Object param) {

        // super.visit(node, param);

        if (node.getExpr() != null)
            node.getExpr().accept(this, param);

        return null;
    }

    //	class ComparableExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ComparableExpression node, Object param) {

        // super.visit(node, param);

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    //	class CastExpression { Type type;  Expression expr; }
    public Object visit(CastExpression node, Object param) {

        // super.visit(node, param);

        if (node.getType() != null)
            node.getType().accept(this, param);

        if (node.getExpr() != null)
            node.getExpr().accept(this, param);

        return null;
    }

    //	class FieldAccessExpression { Expression expr;  String name; }
    public Object visit(FieldAccessExpression node, Object param) {

        // super.visit(node, param);

        if (node.getExpr() != null)
            node.getExpr().accept(this, param);

        return null;
    }

    //	class IndexExpression { Expression expr;  Expression index; }
    public Object visit(IndexExpression node, Object param) {

        // super.visit(node, param);

        if (node.getExpr() != null)
            node.getExpr().accept(this, param);

        if (node.getIndex() != null)
            node.getIndex().accept(this, param);

        return null;
    }
}
