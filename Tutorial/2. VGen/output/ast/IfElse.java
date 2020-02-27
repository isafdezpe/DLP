/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	ifElse:sentence -> expression:expression  if_s:sentence*  else_s:sentence*

public class IfElse extends AbstractSentence {

	public IfElse(Expression expression, List<Sentence> if_s, List<Sentence> else_s) {
		this.expression = expression;
		this.if_s = if_s;
		this.else_s = else_s;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, if_s, else_s);
	}

	public IfElse(Object expression, Object if_s, Object else_s) {
		this.expression = (Expression) getAST(expression);
		this.if_s = this.<Sentence>getAstFromContexts(if_s);
		this.else_s = this.<Sentence>getAstFromContexts(else_s);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, if_s, else_s);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<Sentence> getIf_s() {
		return if_s;
	}
	public void setIf_s(List<Sentence> if_s) {
		this.if_s = if_s;
	}

	public List<Sentence> getElse_s() {
		return else_s;
	}
	public void setElse_s(List<Sentence> else_s) {
		this.else_s = else_s;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private List<Sentence> if_s;
	private List<Sentence> else_s;

	public String toString() {
       return "{expression:" + getExpression() + ", if_s:" + getIf_s() + ", else_s:" + getElse_s() + "}";
   }
}
