package AST.statement.loop;

import AST.block.Block;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/29/2018.
 */
public class Repeat extends Loop {
    Exp exp;
    public  Repeat(Block block, Exp exp){
        super(block);
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
