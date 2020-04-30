/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import ast.VarDefinition.VarScope;
import visitor.*;

enum CodeFunction {
    ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

    private Map<String, String> instruction = new HashMap<String, String>();
    private int ifCount = 0;
    private int whileCount = 0;

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;

        instruction.put("+", "add");
        instruction.put("-", "sub");
        instruction.put("*", "mul");
        instruction.put("/", "div");
        instruction.put("&&", "and");
        instruction.put("||", "or");
        instruction.put("!", "not");
        instruction.put(">", "gt");
        instruction.put("<", "lt");
        instruction.put(">=", "ge");
        instruction.put("<=", "le");
        instruction.put("==", "eq");
        instruction.put("!=", "ne");
    }

    // # ----------------------------------------------------------
    public Object visit(Program node, Object param) {
        out("#source \"" + sourceFile + "\"");
        out("call main");
        out("halt");
        visitChildren(node.getDefinitions(), param);
        return null;
    }

    public Object visit(VarDefinition node, Object param) {
        out("#" + node.getScope().toString() + " " + node.getName() + ":" + node.getType().getMAPLName());
        return null;
    }

    public Object visit(StructDefinition node, Object param) {
        out("#type " + node.getName().getType() + " :{");
        visitChildren(node.getDefinitions(), param);
        out("}");
        return null;
    }

    public Object visit(FunDefinition node, Object param) {
        line(node);
        out(node.getName() + ":");
        out("#FUNC " + node.getName());
        out("#RET " + node.getReturn_t().getMAPLName());
        visitChildren(node.getParams(), CodeFunction.ADDRESS);
        node.getReturn_t().accept(this, CodeFunction.VALUE);
        visitChildren(node.getDefinitions(), CodeFunction.ADDRESS);

        int localsSize = 0;
        for (VarDefinition v : node.getDefinitions())
            localsSize += v.getType().getSize();

        out("enter " + localsSize);

        visitChildren(node.getSentences(), param);

        if (node.getReturn_t() instanceof VoidType) {
            int paramsSize = 0;
            for (VarDefinition p : node.getParams())
                paramsSize += p.getType().getSize();
            out("ret " + node.getReturn_t().getSize() + "," + localsSize + "," + paramsSize);
        }

        return null;
    }

    public Object visit(StructField node, Object param) {
        out("\t" + node.getName() + ":" + node.getType().getMAPLName());
        return null;
    }

    public Object visit(Print node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        return null;
    }

    public Object visit(Printsp node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        out("pushb 32");
        out("outb");
        return null;
    }

    public Object visit(Println node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("out", node.getExpression().getType());
        out("pushb 10");
        out("outb");
        return null;
    }

    public Object visit(Read node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.ADDRESS);
        out("in", node.getExpression().getType());
        out("store", node.getExpression().getType());
        return null;
    }

    public Object visit(Assignment node, Object param) {
        line(node);
        node.getLeft().accept(this, CodeFunction.ADDRESS);
        node.getRight().accept(this, CodeFunction.VALUE);
        out("store", node.getLeft().getType());
        return null;
    }

    public Object visit(Return node, Object param) {
        line(node);
        node.getExpression().accept(this, CodeFunction.VALUE);

        int paramsSize = 0;
        for (VarDefinition p : node.getFunDefinition().getParams())
            paramsSize += p.getType().getSize();

        int localsSize = 0;
        for (VarDefinition v : node.getFunDefinition().getDefinitions())
            localsSize += v.getType().getSize();

        out("ret " + node.getExpression().getType().getSize() + "," + localsSize + "," + paramsSize);

        return null;
    }

    public Object visit(IfElse node, Object param) {
        line(node);
        int n = ifCount++;
        node.getExpression().accept(this, CodeFunction.VALUE);
        if (node.getElse_s() != null)
            out("jz else_" + n);
        else
            out("jz end_if_else_" + n);

        if (node.getIf_s() != null)
            visitChildren(node.getIf_s(), param);
        out("jmp end_if_else_" + n);

        if (node.getElse_s() != null) {
            out("else_" + n + ":");
            visitChildren(node.getElse_s(), param);
        }

        out("end_if_else_" + n + ":");
        return null;
    }

    public Object visit(While node, Object param) {
        line(node);
        int n = whileCount++;
        out("while_" + n + ":");
        node.getExpression().accept(this, CodeFunction.VALUE);
        out("jz end_while_" + n);

        if (node.getSentence() != null)
            visitChildren(node.getSentence(), param);
        out("jmp while_" + n);

        out("end_while_" + n + ":");
        return null;
    }

    public Object visit(FuncInvocation node, Object param) {
        line(node);
        visitChildren(node.getArgs(), CodeFunction.VALUE);
        out("call " + node.getName());
        if (!(node.getFunDefinition().getReturn_t() instanceof VoidType))
            out("pop", node.getFunDefinition().getReturn_t());
        return null;
    }

    public Object visit(Variable node, Object param) {
        if (((CodeFunction) param) == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else {
            assert (param == CodeFunction.ADDRESS);
            if (node.getDefinition().getScope().equals(VarScope.GLOBAL))
                out("pusha " + node.getDefinition().getAddress());
            else {
                out("pusha BP");
                out("push " + node.getDefinition().getAddress());
                out("add");
            }
        }
        return null;
    }

    public Object visit(IntConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("push " + node.getValue());
        return null;
    }

    public Object visit(RealConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        out("pushf " + node.getValue());
        return null;
    }

    public Object visit(CharConstant node, Object param) {
        assert (param == CodeFunction.VALUE);
        int character = (int) node.getValue().charAt(1);
        if (character == '\\' && node.getValue().charAt(2) == 'n')
            character = 10;
        out("pushb " + character);
        return null;
    }

    public Object visit(FuncInvocationExpression node, Object param) {
        visitChildren(node.getArgs(), CodeFunction.VALUE);
        out("call " + node.getName());
        return null;
    }

    public Object visit(ArithmeticExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()), node.getType());
        return null;
    }

    public Object visit(LogicalExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()));
        return null;
    }

    public Object visit(UnaryExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getExpr().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()));

        return null;
    }

    public Object visit(UnarySumExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getExpr().accept(this, CodeFunction.VALUE);
        node.getExpr().accept(this, CodeFunction.ADDRESS);
        node.getExpr().accept(this, CodeFunction.VALUE);
        out("push 1");
        out("add");
        out("store");
        return null;
    }

    public Object visit(ComparableExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getLeft().accept(this, CodeFunction.VALUE);
        node.getRight().accept(this, CodeFunction.VALUE);
        out(instruction.get(node.getOperator()), node.getType());
        return null;
    }

    public Object visit(CastExpression node, Object param) {
        assert (param == CodeFunction.VALUE);
        node.getExpr().accept(this, CodeFunction.VALUE);
        out(node.getExpr().getType().getSuffix() + "2" + node.getCastType().getSuffix());
        return null;
    }

    public Object visit(FieldAccessExpression node, Object param) {
        if (((CodeFunction) param) == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else {
            assert (param == CodeFunction.ADDRESS);
            node.getExpr().accept(this, CodeFunction.ADDRESS);
            out("push " + ((VarType) node.getExpr().getType()).getField(node.getName()).getAddress());
            out("add");
        }
        return null;
    }

    public Object visit(IndexExpression node, Object param) {
        if (((CodeFunction) param) == CodeFunction.VALUE) {
            visit(node, CodeFunction.ADDRESS);
            out("load", node.getType());
        } else {
            assert (param == CodeFunction.ADDRESS);
            node.getExpr().accept(this, CodeFunction.ADDRESS);
            node.getIndex().accept(this, CodeFunction.VALUE);
            out("push " + node.getType().getSize());
            out("mul");
            out("add");
        }
        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    // Imprime una línea en el fichero de salida
    private void out(String instruction) {
        writer.println(instruction);
    }

    private void out(String instruccion, Type tipo) {
        out(instruccion + tipo.getSuffix());
    }

    // Imprime la directiva `#line` junto con la línea del fichero de entrada donde estaba el nodo
    // indicado
    private void line(AST node) {
        line(node.getEnd());
    }

    private void line(Position pos) {
        out("\n#line " + pos.getLine());
    }

    private PrintWriter writer;
    private String sourceFile;
}
