/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	unaryExpression:expression -> operator:String  expr:expression

public class UnaryExpression extends AbstractExpression {

    public UnaryExpression(String operator, Expression expr) {
        this.operator = operator;
        this.expr = expr;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expr);
    }

    public UnaryExpression(Object operator, Object expr) {
        this.operator = (operator instanceof Token) ? ((Token) operator).getText() : (String) operator;
        this.expr = (Expression) getAST(expr);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(operator, expr);
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String operator;
    private Expression expr;

    public String toString() {
        return "{operator:" + getOperator() + ", expr:" + getExpr() + "}";
    }
}
