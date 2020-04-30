/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	fieldAccessExpression:expression -> expr:expression  name:String

public class FieldAccessExpression extends AbstractExpression {

    public FieldAccessExpression(Expression expr, String name) {
        this.expr = expr;
        this.name = name;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expr);
    }

    public FieldAccessExpression(Object expr, Object name) {
        this.expr = (Expression) getAST(expr);
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expr, name);
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private Expression expr;
    private String name;

    public String toString() {
        return "{expr:" + getExpr() + ", name:" + getName() + "}";
    }
}
