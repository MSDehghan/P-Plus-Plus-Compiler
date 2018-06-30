package AST.statement.cond;

import AST.block.Block;
import AST.exp.binaryExp.conditional.Not;
import AST.exp.binaryExp.conditional.NotEqual;
import AST.exp.consts.IntConstExp;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


public class Case extends Statement{
    IntConstExp exp;
    Block block;
    /**
     * labelStartCase is set during the compile so we'll use it in the final look up table
     */
    Label labelStartCase;
    /**
     * jump is for making it like pascal cause it has a better design
     */
    Label jump;
    public Case(IntConstExp exp, Block block){
        this.exp = exp;
        this.block = block;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        labelStartCase = new Label();
        mv.visitLabel(labelStartCase);
        NotEqual notEqual = new NotEqual();
        notEqual.setBinaryExp(new IntConstExp(0),exp);
        // 0 : 0 : false
        mv.visitJumpInsn(Opcodes.IFEQ,jump);
        exp.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.GOTO,jump);

    }
}
