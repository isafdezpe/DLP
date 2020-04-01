/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	read:sentence -> expression:expression

public class Read extends AbstractSentence {

    public Read(Expression expression) {
        this.expression = expression;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expression);
    }

    public Read(Object expression) {
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

    public FunDefinition getFunDefinition() {
        return definition;
    }

    public void setFunDefinition(FunDefinition definition) {
        this.definition = definition;
    }

    public VarDefinition getVarDefinition() {
        return varDefinition;
    }

    public void setVarDefinition(VarDefinition definition) {
        this.varDefinition = definition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private Expression expression;
    private FunDefinition definition;
    private VarDefinition varDefinition;

    public String toString() {
        return "{expression:" + getExpression() + "}";
    }
}
