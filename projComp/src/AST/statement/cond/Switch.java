package AST.statement.cond;

import AST.SymbolTable.SymbolTable;
import AST.block.Block;
import AST.exp.Exp;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.ArrayList;


public class Switch extends Statement {
    Exp exp;
    ArrayList <Case> cases;
    Block blockDefault;
    Label labelDefault=new Label();
    Label end =new Label();
    Label lookUpTable = new Label();
    Label start = new Label();
    //TODO keep in mind that the array list can be empty
    public Switch(Exp exp, ArrayList <Case> cases, Block blockDefault){
        this.exp = exp ;
        this.cases = cases;
        this.blockDefault = blockDefault;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        SymbolTable.getInstance().addScope(SymbolTable.SWITCH);
        Label [] labels = new Label[cases.size()];
        int [] ints = new int[cases.size()];
        int i = 0 ;
        mv.visitLabel(start);
        exp.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.GOTO,lookUpTable);
        for(Case c : cases){
            c.jump = end;
            c.start = start;
            c.compile(mv,cv);
            labels[i]=c.labelStartCase;
            ints[i++]=c.exp.getValue();
        }
        mv.visitLabel(labelDefault);
        blockDefault.compile(mv,cv);
        mv.visitJumpInsn(Opcodes.GOTO,end);
        mv.visitLabel(lookUpTable);
        mv.visitLookupSwitchInsn(labelDefault,ints,labels);
        mv.visitLabel(end);
        SymbolTable.getInstance().popScope();
    }
}
