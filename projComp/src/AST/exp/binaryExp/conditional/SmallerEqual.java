package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.*;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SmallerEqual extends Conditional {
    public SmallerEqual(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        compare(Opcodes.IFGT, Opcodes.IF_ICMPGT, mv, cv);
    }
}

