package AST.statement.cond;

import AST.block.Block;
import AST.exp.Exp;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/29/2018.
 */
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
    public void compile(MethodVisitor mv) {

    }
}
