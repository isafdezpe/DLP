/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	castExpression:expression -> type:type  expr:expression

public class CastExpression extends AbstractExpression {

    public CastExpression(Type castType, Expression expr) {
        this.castType = castType;
        this.expr = expr;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type, expr);
    }

    public CastExpression(Object castType, Object expr) {
        this.castType = (Type) getAST(castType);
        this.expr = (Expression) getAST(expr);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(castType, expr);
    }

    public Type getCastType() {
        return castType;
    }

    public void setCastType(Type castType) {
        this.castType = castType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    private Type castType;
    private Expression expr;
    private Type type;

    public String toString() {
        return "{type:" + getCastType() + ", expr:" + getExpr() + "}";
    }
}
