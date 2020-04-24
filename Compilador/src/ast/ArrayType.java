/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayType:type -> size:intConstant  type:type

public class ArrayType extends AbstractType {

    public ArrayType(IntConstant arraySize, Type type) {
        this.arraySize = arraySize;
        this.type = type;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(arraySize, type);
    }

    public ArrayType(Object size, Object type) {
        this.arraySize = (IntConstant) getAST(size);
        this.type = (Type) getAST(type);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(size, type);
    }

    public int getSize() {
        return this.type.getSize() * Integer.parseInt(this.arraySize.getValue());
    }

    public IntConstant getArraySize() {
        return arraySize;
    }

    public void setArraySize(IntConstant arraySize) {
        this.arraySize = arraySize;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private IntConstant arraySize;
    private Type type;

    public String toString() {
        return "{size:" + getSize() + ", type:" + getType() + "}";
    }

    @Override
    public char getSuffix() {
        return ' ';
    }

    @Override
    public String getMAPLName() {
        return arraySize.getValue() + "*" + type.getMAPLName();
    }
}
