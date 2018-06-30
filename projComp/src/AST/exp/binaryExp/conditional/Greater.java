package AST.exp.binaryExp.conditional;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class Greater extends Conditional {
    public Greater() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        compare(Opcodes.IFLE, Opcodes.IF_ICMPLE, mv, cv);
    }
}

