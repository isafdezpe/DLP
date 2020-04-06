/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	realType:type ->

public class RealType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public int getSize() {
        return 4;
    }

    public String toString() {
        return "{RealType}";
    }
}
