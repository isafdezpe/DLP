/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	return:sentence -> expression:expression

public class Return extends AbstractSentence {

    public Return(Expression expression) {
        this.expression = expression;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expression);
    }

    public Return(Object expression) {
        this.expression = (Expression) getAST(expression);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expression);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public FunDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(FunDefinition definition) {
        this.definition = definition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private Expression expression;
    private FunDefinition definition;

    public String toString() {
        return "{expression:" + getExpression() + "}";
    }
}
