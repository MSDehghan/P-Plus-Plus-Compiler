package AST.statement.cond;

import AST.SymbolTable.SymbolTable;
import AST.block.Block;
import AST.exp.Exp;
import AST.exp.binaryExp.conditional.NotEqual;
import AST.exp.consts.IntConstExp;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


public class If extends Statement{
    Exp exp;
    Block block1, block2;
    //TODO keep in mind that block2 can be empty (if we don't have an else)
    public If(Exp exp, Block block1, Block block2){
        this.exp = exp;
        this.block1 = block1;
        this.block2 = block2;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        SymbolTable.getInstance().addScope(SymbolTable.COND_OTHER_THAN_SWITCH);
        NotEqual notEqual = new NotEqual ();
        notEqual.setBinaryExp(exp,new IntConstExp (0));
        notEqual.compile(mv,cv);
        Label startElse = new Label();
        Label endElse = new Label();
//      if 0 : false : else
        mv.visitJumpInsn(Opcodes.IFEQ,startElse);
        mv.visitLabel(SymbolTable.getInstance().getLabelStart());
        block1.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.GOTO,endElse);
        mv.visitLabel(SymbolTable.getInstance().getLabelLast());
        if(block2!=null){
            SymbolTable.getInstance().popScope();
            SymbolTable.getInstance().addScope(SymbolTable.COND_OTHER_THAN_SWITCH);
            SymbolTable.getInstance().setLabelFirst(startElse);
            SymbolTable.getInstance().setLabelLast(endElse);
            mv.visitLabel(startElse);
            block2.compile(mv,cv);
            mv.visitLabel(endElse);
        }else{

        }
    }
}
