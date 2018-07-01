package AST.exp.var;

import AST.SymbolTable.VariableNotFound;
import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import preDefinedValues.DefinedValues;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SimpleVariable extends Variable {


    /**
     * @param varName variable name
     * @throws VariableNotFound if variable is not defined before
     */
    public SimpleVariable(String varName) {
        name = varName;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        type = this.getType();
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) dscp).getIndex();
            mv.visitVarInsn(getType().getOpcode(ILOAD), index);
        } else {
            mv.visitFieldInsn(GETSTATIC, DefinedValues.nameClass, getName(), getType().getDescriptor());
        }
    }

    /*
    * Store Value From Stack;
    */
    public void compileStoreValue(MethodVisitor mv, ClassVisitor cv) {
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) dscp).getIndex();
            mv.visitVarInsn(getType().getOpcode(ISTORE), index);
        } else {
            mv.visitFieldInsn(PUTSTATIC, DefinedValues.nameClass, getName(), getType().getDescriptor());
        }
    }
}
