package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.*;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class NotEqual extends Conditional {
    public NotEqual(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        compare(IFNE,IF_ICMPNE, mv, cv);
    }
}

