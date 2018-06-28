package AST.statement.loop;

import AST.block.Block;
import AST.declaration.VariableDeclaration;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class For extends Loop {
    VariableDeclaration variableDeclaration ;
    Exp exp;
    For(Block block, Exp exp){
        super(block);
        this.exp = exp ;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
