package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class Return extends Statement{
    Exp exp1;
    Return(){
        exp1=null;
    }
    Return(Exp exp1){
        this.exp1 = exp1;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
