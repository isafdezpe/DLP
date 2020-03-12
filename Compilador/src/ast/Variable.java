/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import ast.VarDefinition.VarScope;
import visitor.*;

//	variable:expression -> name:String

public class Variable extends AbstractExpression {

    public Variable(String name) {
        this.name = name;
    }

    public Variable(Object name) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VarScope getScope() {
        return scope;
    }

    public void setScope(VarScope scope) {
        this.scope = scope;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String name;
    private VarScope scope;

    public String toString() {
        return "{name:" + getName() + "}";
    }
}
