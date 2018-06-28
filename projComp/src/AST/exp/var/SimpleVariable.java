package AST.exp.var;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.VariableNotFound;
import AST.SymbolTable.dscp.DSCP_VAR_DYNAMIC;
import AST.SymbolTable.dscp.DSCP_VAR_STATIC;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class SimpleVariable extends Variable {


    /**
     * @param varName variable name
     * @throws VariableNotFound if variable is not defined before
     */
    public SimpleVariable(String varName) {
        name = varName;
        type = this.getType();
    }

    @Override
    public void compile(MethodVisitor mv) {

    }

}
