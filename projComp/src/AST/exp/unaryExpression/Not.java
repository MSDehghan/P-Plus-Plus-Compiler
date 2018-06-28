package AST.exp.unaryExpression;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Not extends Unary {

    Not(Exp exp1) {
        super(exp1);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
