/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------

    public Object visit(FunDefinition node, Object param) {
        super.visit(node, param);

        for (VarDefinition p : node.getParams())
            predicado(esPrimitivo(p.getType()),
                    "El tipo de los parámetros de " + node.getName() + " debe ser de tipo simple", node);

        if (!mismoTipo(node.getReturn_t(), VoidType.class))
            predicado(esPrimitivo(node.getReturn_t()),
                    "El tipo de retorno de " + node.getName() + " debe ser de tipo simple", node);

        return null;
    }

    public Object visit(ArrayType node, Object param) {
        super.visit(node, param);

        predicado(Integer.parseInt(node.getSize().getValue()) > 0, "El tamaño del array debe ser mayor que cero", node);

        return null;
    }

    public Object visit(Print node, Object param) {
        super.visit(node, param);

        if (!mismoTipo(node.getExpression().getType(), ErrorType.class))
            predicado(esPrimitivo(node.getExpression().getType()), "La expresión a imprimir debe ser de tipo simple",
                    node);

        return null;
    }

    public Object visit(Printsp node, Object param) {
        super.visit(node, param);

        if (!mismoTipo(node.getExpression().getType(), ErrorType.class))
            predicado(esPrimitivo(node.getExpression().getType()), "La expresión a imprimir debe ser de tipo simple",
                    node);

        return null;
    }

    public Object visit(Println node, Object param) {
        super.visit(node, param);

        if (!mismoTipo(node.getExpression().getType(), ErrorType.class)
                && !node.getExpression().getClass().equals(VoidConstant.class))
            predicado(esPrimitivo(node.getExpression().getType()), "La expresión a imprimir debe ser de tipo simple",
                    node);

        return null;
    }

    public Object visit(Read node, Object param) {
        super.visit(node, param);

        if (!mismoTipo(node.getExpression().getType(), ErrorType.class)) {
            predicado(esPrimitivo(node.getExpression().getType()), "La expresión a leer debe ser de tipo simple", node);

            predicado(node.getExpression().isModificable(), "La expresión a leer debe ser modificable", node);
        }

        return null;
    }

    public Object visit(Return node, Object param) {
        super.visit(node, param);

        if (!(node.getExpression().getType() instanceof VoidType))
            predicado(esPrimitivo(node.getExpression().getType()), "La expresión a retornar debe ser de tipo simple",
                    node);

        predicado(mismoTipo(node.getDefinition().getReturn_t(), node.getExpression().getType().getClass()),
                "La expresión a retornar debe ser de tipo " + node.getDefinition().getReturn_t(), node);

        return null;
    }

    public Object visit(Assignment node, Object param) {
        super.visit(node, param);

        predicado(esPrimitivo(node.getLeft().getType()), "La expresión " + node.getLeft() + " debe ser de tipo simple",
                node);

        predicado(node.getLeft().isModificable(), "No se puede asignar un valor a " + node.getLeft(), node);

        if (node.getLeft().isModificable() && esPrimitivo(node.getLeft().getType())) {
            predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType().getClass()),
                    "No se puede asignar el tipo " + node.getRight().getType() + " a " + node.getLeft().getType(),
                    node);
        }

        return null;
    }

    public Object visit(IfElse node, Object param) {
        super.visit(node, param);

        predicado(node.getExpression().getType() instanceof IntType, "La condición debe ser de tipo entero", node);

        return null;
    }

    public Object visit(While node, Object param) {
        super.visit(node, param);

        predicado(node.getExpression().getType() instanceof IntType, "La condición debe ser de tipo entero", node);

        return null;
    }

    public Object visit(FuncInvocation node, Object param) {
        super.visit(node, param);

        predicado(node.getArgs().size() == node.getDefinition().getParams().size(),
                "El número de argumentos de " + node.getName() + " no se corresponde con la definición", node);

        if (node.getArgs().size() == node.getDefinition().getParams().size()) {
            for (int i = 0; i < node.getArgs().size(); i++) {
                predicado(
                        node.getArgs().get(i).getType().getClass()
                                .equals(node.getDefinition().getParams().get(i).getType().getClass()),
                        "El tipo del argumento " + node.getArgs().get(i) + " no se corresponde con su definición",
                        node);
            }
        }

        return null;
    }

    public Object visit(Variable node, Object param) {
        node.setType(node.getDefinition().getType());
        node.setModificable(true);

        return null;
    }

    public Object visit(IntConstant node, Object param) {
        node.setType(new IntType());
        node.setModificable(false);

        return null;
    }

    public Object visit(RealConstant node, Object param) {
        node.setType(new RealType());
        node.setModificable(false);

        return null;
    }

    public Object visit(CharConstant node, Object param) {
        node.setType(new CharType());
        node.setModificable(false);

        return null;
    }

    public Object visit(VoidConstant node, Object param) {
        node.setType(new VoidType());
        node.setModificable(false);

        return null;
    }

    public Object visit(FuncInvocationExpression node, Object param) {
        super.visit(node, param);

        predicado(node.getArgs().size() == node.getDefinition().getParams().size(),
                "El número de argumentos de " + node.getName() + " no se corresponde con la definición", node);

        if (node.getArgs().size() == node.getDefinition().getParams().size()) {
            for (int i = 0; i < node.getArgs().size(); i++) {
                predicado(
                        node.getArgs().get(i).getType().getClass()
                                .equals(node.getDefinition().getParams().get(i).getType().getClass()),
                        "El tipo del argumento " + node.getArgs().get(i) + " no se corresponde con su definición",
                        node);
            }
        }

        node.setType(node.getDefinition().getReturn_t());
        node.setModificable(false);

        return null;
    }

    public Object visit(ArithmeticExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType().getClass()),
                "Los operandos deben ser del mismo tipo", node);

        predicado(
                mismoTipo(node.getLeft().getType(), IntType.class)
                        || mismoTipo(node.getLeft().getType(), RealType.class),
                "Los operandos deben ser de tipo entero o real", node);

        node.setType(node.getLeft().getType());
        node.setModificable(false);

        return null;
    }

    public Object visit(LogicalExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType().getClass()),
                "Los operandos deben ser del mismo tipo", node);

        predicado(mismoTipo(node.getLeft().getType(), IntType.class), "Los operandos deben ser de tipo entero", node);

        node.setType(new IntType());
        node.setModificable(false);

        return null;
    }

    public Object visit(UnaryExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getExpr().getType(), IntType.class), "Los operandos deben ser de tipo entero", node);

        node.setType(new IntType());
        node.setModificable(false);

        return null;
    }

    public Object visit(ComparableExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType().getClass()),
                "Los operandos deben ser del mismo tipo", node);

        predicado(
                mismoTipo(node.getLeft().getType(), IntType.class)
                        || mismoTipo(node.getLeft().getType(), RealType.class),
                "Los operandos deben ser de tipo entero o real", node);

        node.setType(new IntType());
        node.setModificable(false);

        return null;
    }

    public Object visit(CastExpression node, Object param) {
        super.visit(node, param);

        predicado(!(mismoTipo(node.getCastType(), node.getExpr().getType().getClass())),
                "El tipo de la expresión debe ser diferente del tipo del cast", node);

        predicado(esPrimitivo(node.getExpr().getType()), "La expresión a castear debe ser de tipo simple", node);

        predicado(esPrimitivo(node.getCastType()), "El tipo del cast debe ser de tipo simple", node);

        node.setType(node.getCastType());
        node.setModificable(false);

        return null;
    }

    public Object visit(FieldAccessExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getExpr().getType(), VarType.class), "La expresión debe ser tipo struct", node);

        if (!mismoTipo(node.getExpr().getType(), VarType.class)) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        StructField field = ((VarType) node.getExpr().getType()).getField(node.getName());

        predicado(field != null, "La estructura no contiene el campo " + node.getName(), node);

        if (field == null) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(field.getType());
        node.setModificable(true);

        return null;
    }

    public Object visit(IndexExpression node, Object param) {
        super.visit(node, param);

        predicado(mismoTipo(node.getExpr().getType(), ArrayType.class),
                "La expresión a la que se accede debe ser de tipo array", node);

        predicado(mismoTipo(node.getIndex().getType(), IntType.class), "El índice debe ser de tipo entero");

        if (!mismoTipo(node.getExpr().getType(), ArrayType.class)
                || !mismoTipo(node.getIndex().getType(), IntType.class)) {
            node.setType(new ErrorType());
            node.setModificable(false);
            return null;
        }

        node.setType(((ArrayType) node.getExpr().getType()).getType());
        node.setModificable(true);

        return null;
    }

    /*
    visit(Nodo padre) {
        Para cada hijoi { // Los hijos deben recorrerse de izquierda a derecha
            Asignar valor a los atributos de hijoi que sean heredados
            visitar(hijoi) // Al volver, el hijo tendrá ya asignados todos sus atributos sintetizados
        }
        Comprobar los predicados asociados a la regla p (B(p))
        Asignar valor a los atributos sintetizados de padre (R(p))
    }
     */

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
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private boolean esPrimitivo(Type type) {
        return (type.getClass().equals(new IntType().getClass()) || type.getClass().equals(new RealType().getClass())
                || type.getClass().equals(new CharType().getClass()));
    }

    private boolean mismoTipo(Type type1, Class type2) {
        return type1.getClass().equals(type2);
    }

    private ErrorManager errorManager;
}
