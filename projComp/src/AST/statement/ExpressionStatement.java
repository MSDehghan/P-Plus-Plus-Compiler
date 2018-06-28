package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class ExpressionStatement extends Statement {
    Exp exp;
    ExpressionStatement(){

    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
