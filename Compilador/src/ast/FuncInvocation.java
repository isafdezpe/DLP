/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	funcInvocation:sentence -> name:String  params:expression*

public class FuncInvocation extends AbstractSentence {

    public FuncInvocation(String name, List<Expression> args) {
        this.name = name;
        this.args = args;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(args);
    }

    public FuncInvocation(Object name, Object args) {
        this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
        this.args = this.<Expression>getAstFromContexts(args);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(name, args);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expression> getArgs() {
        return args;
    }

    public void setArgs(List<Expression> args) {
        this.args = args;
    }

    public FunDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(FunDefinition definition) {
        this.definition = definition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String name;
    private List<Expression> args;
    private FunDefinition definition;

    public String toString() {
        return "{name:" + getName() + ", args:" + getArgs() + "}";
    }
}
