/**
 * @generated VGen (for ANTLR) 1.7.1
 */

package ast;

import visitor.*;

public interface AST {

    public Object accept(Visitor visitor, Object param);

    Position getStart();

    Position getEnd();

    public void setPositions(Object... children);

}
