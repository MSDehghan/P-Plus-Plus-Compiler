package AST.statement.cond;

import AST.block.Block;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class Switch extends Statement {
    ArrayList <Case> cases;
    Block blockDefault;
    //TODO keep in mind that the array list can be empty
    public Switch(ArrayList <Case> cases, Block blockDefault){
        this.cases = cases;
        this.blockDefault = blockDefault;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
