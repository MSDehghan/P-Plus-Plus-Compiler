package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class ExpressionStatement extends Statement {
    Exp exp;
    //TODO just remember to pop the top value
    public ExpressionStatement(Exp exp){
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
