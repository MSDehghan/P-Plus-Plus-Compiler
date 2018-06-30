package AST.exp.var;

import AST.SymbolTable.VariableNotFound;
import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.ILOAD;

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
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) dscp).getIndex();
            mv.visitVarInsn(getType().getOpcode(ILOAD), index);
        } else {
            // TODO: 29/06/2018 For Static Variables
            throw new RuntimeException();
        }
    }

}
