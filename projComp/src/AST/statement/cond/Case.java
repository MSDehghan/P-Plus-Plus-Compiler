package AST.statement.cond;

import AST.block.Block;
import AST.exp.consts.IntConstExp;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/29/2018.
 */
public class Case extends Statement{
    IntConstExp exp;
    Block block;
    public Case(IntConstExp exp, Block block){
        this.exp = exp;
        this.block = block;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
