/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.*;
import ast.VarDefinition.VarScope;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------

    public Object visit(FunDefinition node, Object param) {
        predicado(funciones.get(node.getName()) == null, "Función ya definida: " + node.getName(), node);
        funciones.put(node.getName(), node);

        variables.set();

        for (VarDefinition p : node.getParams())
            p.accept(this, VarScope.PARAM);

        for (VarDefinition d : node.getDefinitions())
            d.accept(this, VarScope.LOCAL);

        for (Sentence s : node.getSentences())
            s.accept(this, node);

        node.getReturn_t().accept(this, param);

        variables.reset();

        return null;
    }

    public Object visit(FuncInvocation node, Object param) {
        super.visit(node, param);

        FunDefinition definition = funciones.get(node.getName());

        predicado(definition != null, "Procedimiento no definido: " + node.getName(), node);

        node.setDefinition(definition);

        return null;
    }

    public Object visit(FuncInvocationExpression node, Object param) {
        super.visit(node, param);

        FunDefinition definition = funciones.get(node.getName());

        predicado(definition != null, "Función no definida: " + node.getName(), node);

        node.setDefinition(definition);

        return null;
    }

    public Object visit(StructDefinition node, Object param) {
        predicado(variables.getFromAny(node.getName().getType()) == null,
                "Estructura ya definida: " + node.getName().getType(), node);

        variables.put(node.getName().getType(), node);
        structs.put(node.getName().getType(), node);

        variables.set();

        for (StructField d : node.getDefinitions())
            d.accept(this, node);

        variables.reset();

        return null;
    }

    public Object visit(StructField node, Object param) {
        super.visit(node, param);

        Definition definition = variables.getFromTop(node.getName());

        predicado(definition == null, "Campo ya definido en la estructura: " + node.getName(), node);

        node.setDefinition((StructDefinition) param);

        variables.put(node.getName(), node);

        return null;
    }

    public Object visit(VarType node, Object param) {
        super.visit(node, param);

        StructDefinition definition = structs.get(node.getType());
        predicado(definition != null, "Struct no definido: " + node.getType(), node);

        node.setDefinition(definition);

        return null;
    }

    public Object visit(VarDefinition node, Object param) {
        super.visit(node, param);

        predicado(variables.getFromTop(node.getName()) == null, "Variable ya definida: " + node.getName(), node);

        node.setScope(param instanceof VarScope ? (VarScope) param : VarScope.GLOBAL);

        variables.put(node.getName(), node);

        return null;
    }

    public Object visit(Variable node, Object param) {
        Definition definition = variables.getFromAny(node.getName());

        predicado(definition != null, "Variable no definida: " + node.getName(), node);

        node.setDefinition((VarDefinition) definition);

        return null;
    }

    public Object visit(Return node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(Print node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(Printsp node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(Println node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(Read node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setFunDefinition((FunDefinition) param);

        if (node.getExpression() instanceof Variable) {
            Definition definition = variables.getFromAny(((Variable) node.getExpression()).getName());
            predicado(definition != null, "Variable no definida: " + ((Variable) node.getExpression()).getName(), node);
            node.setVarDefinition((VarDefinition) definition);
        }

        return null;
    }

    public Object visit(Assignment node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(IfElse node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    public Object visit(While node, Object param) {
        super.visit(node, param);

        if (param instanceof FunDefinition)
            node.setDefinition((FunDefinition) param);

        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Identification", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private ErrorManager errorManager;
    private Map<String, FunDefinition> funciones = new HashMap<String, FunDefinition>();
    private ContextMap<String, Definition> variables = new ContextMap();
    private Map<String, StructDefinition> structs = new HashMap<String, StructDefinition>();
}
