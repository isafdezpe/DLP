/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import visitor.*;

enum CodeFunction {
    ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

    private Map<String, String> instruccion = new HashMap<String, String>();

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;

        instruccion.put("+", "add");
        instruccion.put("-", "sub");
        instruccion.put("*", "mul");
        instruccion.put("/", "div");

    }

    //	class Program { List<VarDefinition> definitions;  List<Sentence> sentences; }
    public Object visit(Program node, Object param) {
        out("#source \"" + sourceFile + "\"");
        visitChildren(node.getDefinitions(), param);
        visitChildren(node.getSentences(), param);
        out("halt");
        return null;
    }

    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {
        out("#GLOBAL " + node.getName() + ":" + node.getType().getMAPLName());
        return null;
    }

    //	class Print { Expression expression; }
    public Object visit(Print node, Object param) {
        out("#line " + node.getEnd().getLine());
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    //	class Assignment { Expression left;  Expression right; }
    public Object visit(Assignment node, Object param) {
        out("#line " + node.getEnd().getLine());
        node.getLeft().accept(this, CodeFunction.ADDRESS);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("store", node.getLeft().getType());
        return null;
    }

    //	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
    public Object visit(ArithmeticExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruccion.get(node.getOperator()), node.getType());
        return null;
    }

    //	class Variable { String name; }
    public Object visit(Variable node, Object param) {

        if (((CodeFunction) param) == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else { // Funcion.DIRECCION
            assert (param == CodeFunction.ADDRESS);
            out("pusha " + node.getDefinicion().getAddress());
        }
        return null;
    }

    //	class IntConstant { String valor; }
    public Object visit(IntConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("push " + node.getValue());
        return null;
    }

    //	class RealConstant { String valor; }
    public Object visit(RealConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("pushf " + node.getValue());
        return null;
    }

    // Método auxiliar
    private void out(String instruccion, Type tipo) {
        out(instruccion + tipo.getSuffix());
    }

    // Métodos auxiliares recomendados (opcionales) -------------
    private void out(String instruction) {
        writer.println(instruction);
    }

    private void line(Position pos) {
        out("\n#line " + pos.getLine());
    }

    private PrintWriter writer;
    private String sourceFile;
}
