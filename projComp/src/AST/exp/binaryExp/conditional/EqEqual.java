package AST.exp.binaryExp.conditional;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.IFEQ;
import static jdk.internal.org.objectweb.asm.Opcodes.IF_ICMPEQ;

public class EqEqual extends Conditional {
    public EqEqual() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        compare(IFEQ, IF_ICMPEQ, mv, cv);
    }
}

