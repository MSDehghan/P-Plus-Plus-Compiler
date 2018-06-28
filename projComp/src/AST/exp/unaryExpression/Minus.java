package AST.exp.unaryExpression;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Minus extends Unary {

    Minus(Exp exp1) {
        super(exp1);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
