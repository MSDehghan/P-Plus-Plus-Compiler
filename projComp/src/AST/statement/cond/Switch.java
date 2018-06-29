package AST.statement.cond;

import AST.block.Block;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class Switch extends Statement {
    String id;
    ArrayList <Case> cases;
    Block blockDefault;
    //TODO keep in mind that the array list can be empty
    public Switch(String id, ArrayList <Case> cases, Block blockDefault){
        this.id = id ;
        this.cases = cases;
        this.blockDefault = blockDefault;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
