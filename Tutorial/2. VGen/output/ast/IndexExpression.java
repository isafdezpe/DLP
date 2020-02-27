/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	indexExpression:expression -> expr:expression  index:expression

public class IndexExpression extends AbstractExpression {

	public IndexExpression(Expression expr, Expression index) {
		this.expr = expr;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr, index);
	}

	public IndexExpression(Object expr, Object index) {
		this.expr = (Expression) getAST(expr);
		this.index = (Expression) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr, index);
	}

	public Expression getExpr() {
		return expr;
	}
	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	public Expression getIndex() {
		return index;
	}
	public void setIndex(Expression index) {
		this.index = index;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expr;
	private Expression index;

	public String toString() {
       return "{expr:" + getExpr() + ", index:" + getIndex() + "}";
   }
}
