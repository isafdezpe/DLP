/**
 * @generated VGen (for ANTLR) 1.6.0
 */

package ast;

import visitor.*;

//	realType:type ->

public class RealType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public int getSize() {
        return 4;
    }

    public String toString() {
        return "{RealType}";
    }
}
