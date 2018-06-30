package AST.exp.binaryExp.conditional;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class And extends Conditional {
    public And() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        AndOr(true, mv, cv);
    }
}

