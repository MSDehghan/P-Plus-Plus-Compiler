package AST.exp.binaryExp.conditional;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class EqEqual extends Conditional {
    public EqEqual() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        compare(IFNE, IF_ICMPNE, mv, cv);
    }
}

