package AST.statement.loop;

import AST.SymbolTable.SymbolTable;
import AST.block.Block;
import AST.exp.Exp;
import AST.exp.binaryExp.conditional.NotEqual;
import AST.exp.consts.IntConstExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


public class Repeat extends Loop {
    Exp exp;
    public  Repeat(Block block, Exp exp){
        super(block);
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        SymbolTable.getInstance().addScope();
        mv.visitLabel(SymbolTable.getInstance().getLabelStart());
        NotEqual notEqual = new NotEqual();
        notEqual.setBinaryExp(exp,new IntConstExp(0));
        // 0 : 0 : false
        notEqual.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.IFEQ,SymbolTable.getInstance().getLabelLast());
        block.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.GOTO,SymbolTable.getInstance().getLabelStart());
        mv.visitLabel(SymbolTable.getInstance().getLabelLast());
        SymbolTable.getInstance().popScope();
    }
}
