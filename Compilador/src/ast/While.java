/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	while:sentence -> expression:expression  sentence:sentence*

public class While extends AbstractSentence {

    public While(Expression expression, List<Sentence> sentence) {
        this.expression = expression;
        this.sentence = sentence;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expression, sentence);
    }

    public While(Object expression, Object sentence) {
        this.expression = (Expression) getAST(expression);
        this.sentence = this.<Sentence>getAstFromContexts(sentence);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expression, sentence);
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

    public List<Sentence> getSentence() {
        return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
        this.sentence = sentence;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private Expression expression;
    private List<Sentence> sentence;
    private FunDefinition definition;

    public String toString() {
        return "{expression:" + getExpression() + ", sentence:" + getSentence() + "}";
    }
}
