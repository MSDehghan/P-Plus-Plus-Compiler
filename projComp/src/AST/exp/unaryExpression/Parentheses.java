package AST.exp.unaryExpression;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Parentheses extends Unary {

    Parentheses(Exp exp1) {
        super(exp1);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
