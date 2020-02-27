/**
 * @generated VGen (for ANTLR) 1.6.0
 */

package ast;

import visitor.*;

//	intType:type ->

public class IntType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public int getSize() {
        return 2;
    }

    public String toString() {
        return "{IntType}";
    }
}
