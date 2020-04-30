/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

public abstract class AbstractExpression extends AbstractAST implements Expression {

    protected Type type;
    protected boolean modificable;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isModificable() {
        return modificable;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }
}
