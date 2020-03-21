/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    //	class VarDefinition { Type type;  String name; }
    public Object visit(VarDefinition node, Object param) {
        node.getType().accept(this, param); // No es necesario realmente

        VarDefinition definicion = variables.get(node.getName());
        predicado(definicion == null, "Variable ya definida: " + node.getName(), node);
        variables.put(node.getName(), node);
        return null;
    }

    //	class Variable { String name; }
    public Object visit(Variable node, Object param) {
        VarDefinition definicion = variables.get(node.getName());
        predicado(definicion != null, "Variable no definida: " + node.getName(), node);
        node.setDefinicion(definicion); // Enlazar referencia con definición
        return null;
    }

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        if (!condition)
            error(errorMessage, node.getStart());
    }

    private ErrorManager errorManager;
    private Map<String, VarDefinition> variables = new HashMap<String, VarDefinition>();
}
