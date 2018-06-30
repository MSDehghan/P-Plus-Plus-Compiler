package AST.declaration.function;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class ExternalFunctionDcl extends FuncDcl {
    ArrayList<FunctionArgument > arguments;
    String address;
    //TODO keep in mind that the arguments and the block part may be null
    public ExternalFunctionDcl(String address,String type, String name,ArrayList <FunctionArgument > arguments){
        super(type,name);
        this.arguments = arguments;
        this.address = address;

    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
