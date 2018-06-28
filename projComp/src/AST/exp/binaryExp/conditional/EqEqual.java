package AST.exp.binaryExp.conditional;

import AST.exp.Exp;
import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class EqEqual extends BinaryExp {
    EqEqual(Exp exp1, Exp exp2){
        super(exp1, exp2);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}

