package AST.statement;

import AST.exp.Exp;
import com.sun.org.apache.bcel.internal.generic.IRETURN;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


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
        if(exp1!=null){
            exp1.compile(mv,cv);
            exp1.getType().getOpcode(Opcodes.IRETURN);
        }else
            mv.visitInsn(Opcodes.RETURN);
    }
}
