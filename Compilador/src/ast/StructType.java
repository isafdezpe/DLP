/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import visitor.*;

//	structType:type -> fields:structField*

public class StructType extends AbstractType {

    public StructType(List<StructField> fields) {
        this.fields = fields;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(fields);
    }

    public StructType(Object fields) {
        this.fields = this.<StructField>getAstFromContexts(fields);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(fields);
    }

    public List<StructField> getFields() {
        return fields;
    }

    public void setFields(List<StructField> fields) {
        this.fields = fields;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private List<StructField> fields;

    public String toString() {
        return "{fields:" + getFields() + "}";
    }

    @Override
    public int getSize() {
        int size = 0;
        for (StructField child : getFields()) {
            size += child.getType().getSize();
        }
        return size;
    }
}
