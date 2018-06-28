package AST.declaration;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_VAR_DYNAMIC;
import AST.SymbolTable.dscp.DSCP_VAR_STATIC;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

import static AST.SymbolTable.SymbolTable.getTypeFromName;

public class SimpleVariableDeclaration extends VariableDeclaration {
    public SimpleVariableDeclaration(String varName, String varType, boolean staticDec) {
        name = varName;
        Type type = getTypeFromName(varType);
        declare(staticDec, type);
    }

    public SimpleVariableDeclaration(String varName, String varType, Exp value, boolean staticDec) {
        name = varName;
        Type type;
        if (varType.equals("auto")) {
            type = value.getType();
        } else {
            type = getTypeFromName(varType);
        }
        declare(staticDec, type);
    }

    /**
     * @param staticDec check if it is static or not
     * @param type Type of Variable
     * @throws IllegalArgumentException if type and name is not set!
     */
    private void declare(boolean staticDec, Type type) {
        if (name == null || type == null)
            throw new IllegalArgumentException();

        DSCP dscp;

        if (staticDec) {
            dscp = new DSCP_VAR_STATIC(name, type);
        } else {
            dscp = new DSCP_VAR_DYNAMIC(name, type, SymbolTable.getInstance().returnNewIndex());
        }

        SymbolTable.getInstance().addVariable(dscp, name);
    }
}
