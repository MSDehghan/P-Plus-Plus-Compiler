package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Not extends Conditional {
    public Not(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        throw new UnsupportedOperationException();
    }
}

