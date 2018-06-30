package AST.statement;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


public class ExpressionStatement extends Statement {
    Exp exp;
    //TODO just remember to pop the top value
    public ExpressionStatement(Exp exp){
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        exp.compile(mv,cv);
        mv.visitInsn(Opcodes.POP);
    }
}
