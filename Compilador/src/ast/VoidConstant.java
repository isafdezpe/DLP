/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	voidConstant:expression -> 

public class VoidConstant extends AbstractExpression {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{VoidConstant}";
   }
}
