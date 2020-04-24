/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	charType:type ->

public class CharType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{CharType}";
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public char getSuffix() {
        return 'b';
    }

    @Override
    public String getMAPLName() {
        return "char";
    }
}
