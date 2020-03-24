/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	varDefinition:definition -> name:String  type:type

public class VarDefinition extends AbstractDefinition {

    public enum VarScope {
        GLOBAL, LOCAL, PARAM
    };

    public VarDefinition(String name, Type type, VarScope scope) {
        this.name = name;
        this.type = type;
        this.scope = scope;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type);
    }

    public VarDefinition(Object name, Object type, VarScope scope) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
        this.type = (Type) getAST(type);
        this.scope = scope;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
    private Type type;
    private VarScope scope;

    public String toString() {
        return "{name:" + getName() + ", type:" + getType() + ", scope:" + getScope() + "}";
    }
}
