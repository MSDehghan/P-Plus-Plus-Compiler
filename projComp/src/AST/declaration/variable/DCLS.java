package AST.declaration.variable;

import AST.OperationCode;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import preDefinedValues.DefinedValues;

import java.util.ArrayList;


public class DCLS extends OperationCode{
    boolean Constant;
    public ArrayList <SpecClass> specClasses;
    public String type ;
    ArrayList <VariableDeclaration> dcls = new ArrayList<VariableDeclaration>();
    public DCLS(ArrayList<SpecClass> specClasses, String type, boolean Constant){
        this.specClasses = specClasses;
        this.type = type;
        this.Constant = Constant;

        for(SpecClass c : this.specClasses){
            if(c.dims.size()==0){
                if(c.value==null){
                    dcls.add(new SimpleVariableDeclaration(c.name,type, DefinedValues.getScope(),Constant));
                }else{
                    dcls.add(new SimpleVariableDeclaration(c.name,type, c.value, DefinedValues.getScope(),Constant));
                }
            }else {
                dcls.add(new ArrayVariableDeclaration(c.name, type, c.dims,DefinedValues.getScope(),Constant));
            }   
        }


    }
    //TODO keep in mind that the type maybe of struct
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
