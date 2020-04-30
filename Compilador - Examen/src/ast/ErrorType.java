/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	errorType:type ->

public class ErrorType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{ErrorType}";
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public char getSuffix() {
        return ' ';
    }

    @Override
    public String getMAPLName() {
        return "";
    }
}
