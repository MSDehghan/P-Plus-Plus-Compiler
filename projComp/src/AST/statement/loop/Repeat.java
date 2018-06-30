package AST.statement.loop;

import AST.block.Block;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;


public class Repeat extends Loop {
    Exp exp;
    public  Repeat(Block block, Exp exp){
        super(block);
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
