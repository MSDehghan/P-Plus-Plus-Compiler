package AST.exp.binaryExp.arithmatic;

import AST.exp.Exp;
import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/27/2018.
 */
public class And extends BinaryExp {
    And(Exp exp1, Exp exp2){
        super(exp1, exp2);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}

