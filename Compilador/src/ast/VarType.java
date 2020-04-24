/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	varType:type -> type:String

public class VarType extends AbstractType {

    public VarType(String type) {
        this.type = type;
    }

    public VarType(Object type) {
        this.type = (type instanceof Token) ? ((Token) type).getText() : (String) type;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StructDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(StructDefinition definition) {
        this.definition = definition;
    }

    public StructField getField(String name) {
        for (StructField field : definition.getDefinitions()) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return null;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String type;
    private StructDefinition definition;

    public String toString() {
        return "{type:" + getType() + "}";
    }

    @Override
    public int getSize() {
        int size = 0;
        for (StructField child : definition.getDefinitions()) {
            size += child.getType().getSize();
        }

        return size;
    }

    @Override
    public char getSuffix() {
        return ' ';
    }

    @Override
    public String getMAPLName() {
        return type;
    }
}
