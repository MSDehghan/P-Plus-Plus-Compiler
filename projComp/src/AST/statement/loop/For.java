package AST.statement.loop;

import AST.block.Block;
import AST.declaration.VariableDeclaration;
import AST.exp.Assignment;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class For extends Loop {
    Assignment assignment ;
    Exp exp1;
    Exp exp2;
    //TODO just remember that for exp2 we have to pop the top value

    /**
     *
     * @param block this is the block that the for will be implementing
     * @param assignment this is the assignment for the first part of the for
     * @param exp1 this is the expression for the middle part of the for
     * @param exp2 this is the expression for the third part of the for
     */
    public For(Block block, Assignment assignment,Exp exp1, Exp exp2){
        //TODO be careful that some parts may be null
        super(block) ;
        this.assignment = assignment ;
        this.exp1 = exp1 ;
        this.exp2 = exp2 ;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
