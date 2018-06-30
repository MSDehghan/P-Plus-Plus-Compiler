package AST.declaration.variable;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.SymbolTable.dscp.DSCP_VAR_DYNAMIC;
import AST.SymbolTable.dscp.DSCP_VAR_STATIC;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

import static AST.SymbolTable.SymbolTable.getTypeFromName;

public class SimpleVariableDeclaration extends VariableDeclaration {
    public SimpleVariableDeclaration(String varName, String varType, boolean staticDec, boolean Constant) {
        name = varName;
        Type type = getTypeFromName(varType);
        declare(staticDec, type, Constant);
    }

    //TODO do something with constant
    public SimpleVariableDeclaration(String varName, String varType, Exp value, boolean staticDec, boolean Constant) {
        name = varName;
        Type type;
        if (varType.equals("auto")) {
            type = value.getType();
        } else {
            type = getTypeFromName(varType);
        }
        this.exp = value;
        declare(staticDec, type, Constant);
    }

    /**
     * @param staticDec check if it is static or not
     * @param type      Type of Variable
     * @throws IllegalArgumentException if type and name is not set!
     */
    private void declare(boolean staticDec, Type type, boolean Constant) {
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

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        // TODO: 30/06/2018 check type and also do it diffrent types static and dynamic
        exp.compile(mv, cv);
        int index = ((DSCP_DYNAMIC) SymbolTable.getInstance().getDescriptor(getName())).getIndex();
        mv.visitVarInsn(exp.getType().getOpcode(Opcodes.ISTORE), index);
    }
}
