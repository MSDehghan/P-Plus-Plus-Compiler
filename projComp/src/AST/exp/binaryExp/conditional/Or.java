package AST.exp.binaryExp.conditional;

import AST.declaration.InvalidVariableType;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class Or extends Conditional {
    public Or() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        AndOr(false,mv, cv);
    }

}

