package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;


public class ExpressionStatement extends Statement {
    Exp exp;
    //TODO just remember to pop the top value
    public ExpressionStatement(Exp exp){
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        exp.compile(mv,cv);
        if(exp.getType()!= Type.VOID_TYPE){
//            TODO check for other combinations
            if(!exp.getType().equals(Type.DOUBLE_TYPE)&&!exp.getType().equals(Type.LONG_TYPE))
            mv.visitInsn(Opcodes.POP);
            else
                mv.visitInsn(Opcodes.POP2);
        }
    }
}
