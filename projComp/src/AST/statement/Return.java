package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;


public class Return extends Statement{
    Exp exp1;
    public Return(){
        exp1=null;
    }
    public Return(Exp exp1){
        this.exp1 = exp1;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
