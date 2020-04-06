/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import ast.VarDefinition.VarScope;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    private int currentAddress = 0;

    public Object visit(VarDefinition node, Object param) {
        super.visit(node, param);

        if (node.getScope().equals(VarScope.GLOBAL)) {
            node.setAddress(currentAddress);
            currentAddress += node.getType().getSize();
        }

        return null;
    }

}
