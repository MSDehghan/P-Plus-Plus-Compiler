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
    public SimpleVariable(String varName, String varType,boolean staticDec) {
        name = varName;
        type = getTypeFromName(varType);
        declare(staticDec);
    }

    /**
     * @throws IllegalArgumentException if type and name is not set!
     * @param staticDec check if it is static or not
     */
    private void declare(boolean staticDec) {
        if(name == null || type == null)
            throw new IllegalArgumentException();

        DSCP dscp;

        if(staticDec){
            dscp = new DSCP_VAR_STATIC(name,type);
        }else{
            dscp = new DSCP_VAR_DYNAMIC(name,type,SymbolTable.getInstance().returnNewIndex());
        }

        SymbolTable.getInstance().addVariable(dscp,name);
    }

    /**
     * @param varName variable name
     * @throws VariableNotFound if variable is not defined before
     */
    public SimpleVariable(String varName) {
        name = varName;
        type = SymbolTable.getInstance().getDescriptor(name).getType();
    }


    public SimpleVariable(String varName, String varType, Exp value,boolean staticDec) {
        name = varName;
        if (varType.equals("auto")) {
            type = value.getType();
        } else {
            type = getTypeFromName(varType);
        }
        declare(staticDec);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }

}
