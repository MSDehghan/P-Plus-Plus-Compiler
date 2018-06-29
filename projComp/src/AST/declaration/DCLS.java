package AST.declaration;

import AST.Node;
import AST.OperationCode;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class DCLS extends OperationCode{
    boolean Constant;
    public ArrayList <SpecClass> specClasses;
    public String type ;
    public DCLS(ArrayList<SpecClass> specClasses, String type, boolean Constant){
        this.specClasses = specClasses;
        this.type = type;
        this.Constant = Constant;
    }
    //TODO keep in mind that the type maybe of struct
    @Override
    public void compile(MethodVisitor mv) {

    }
}
