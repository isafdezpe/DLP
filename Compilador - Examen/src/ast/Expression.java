/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

public interface Expression extends AST {

    public Type getType();

    public void setType(Type type);

    public boolean isModificable();

    public void setModificable(boolean modificable);
}
