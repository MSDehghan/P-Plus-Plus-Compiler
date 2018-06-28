package AST.statement.loop;

import AST.block.Block;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class For extends Loop {
    For(Block block){
        super(block);
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
