package AST.exp.unaryExpression;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Parentheses extends Unary {

    public Parentheses() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv)
    {
        exp.compile(mv,cv);
        type = exp.getType();

    }
}
