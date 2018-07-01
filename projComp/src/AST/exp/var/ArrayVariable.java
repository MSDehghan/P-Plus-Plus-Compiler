
package AST.exp.var;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import preDefinedValues.DefinedValues;
import preDefinedValues.HelperFunctions;

import java.util.List;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ArrayVariable extends Variable {
    private List<Exp> arguments;

    public ArrayVariable(String varName, List<Exp> arguments) {
        name = varName;
        this.arguments = arguments;
    }

    public void loadReferenceAndIndex(MethodVisitor mv,ClassVisitor cv){
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) getDSCP()).getIndex();
            mv.visitVarInsn(ALOAD, index);
        } else {
            mv.visitFieldInsn(GETSTATIC, DefinedValues.nameClass, getName(), getType().getDescriptor());
        }


        for (int i = 0; i < arguments.size() - 1; i++) {
            arguments.get(i).compile(mv, cv);
            if (!HelperFunctions.isInteger(arguments.get(i).getType())) {
                throw new RuntimeException("Bad Index Type");
            }
            mv.visitInsn(AALOAD);
        }
        arguments.get(arguments.size()-1).compile(mv,cv);
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        loadReferenceAndIndex(mv,cv);
        mv.visitInsn(getType().getElementType().getOpcode(IALOAD));
    }

    public void compileStoreValue(Exp exp, MethodVisitor mv, ClassVisitor cv) {
        if(exp.getType() != getType().getElementType())
            throw new RuntimeException("Bad Store Type");

        loadReferenceAndIndex(mv,cv);
        exp.compile(mv,cv);
        mv.visitInsn(getType().getElementType().getOpcode(IASTORE));
    }
}
