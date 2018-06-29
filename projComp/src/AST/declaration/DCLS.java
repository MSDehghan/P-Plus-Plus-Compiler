package AST.declaration;

import AST.OperationCode;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class DCLS extends OperationCode{
    boolean Constant;
    public ArrayList <SpecClass> specClasses;
    public String type ;
    ArrayList <VariableDeclaration> dcls;
    public DCLS(ArrayList<SpecClass> specClasses, String type, boolean Constant){
        this.specClasses = specClasses;
        this.type = type;
        this.Constant = Constant;

//        for(SpecClass c : this.specClasses){
//            if(c.dims==null){
//                if(c.value==null){
//                    dcls.add(new SimpleVariableDeclaration(c.name,type,Constant));
//                }
//            }
//        }


    }
    //TODO keep in mind that the type maybe of struct
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
