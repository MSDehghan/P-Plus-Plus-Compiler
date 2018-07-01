package AST.declaration.function;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;


public class ExternalFunctionDcl extends FuncDcl {
    ArrayList<StaticVarsExtern> vars;
    String address;
    String functionSignature ;

   public ArrayList<StaticVarsExtern> getVars(){
        return vars;
    }
    public String getAddress(){
        return address;
    }public String getFunctionSignature(){
        return functionSignature;
    }

    //TODO keep in mind that the arguments and the block part may be null
    public ExternalFunctionDcl(String address, ArrayList<StaticVarsExtern> vars, String id, String functionSignature){

        super(functionSignature,id);
        this.vars = vars;
        this.address = address;
        this.functionSignature = functionSignature;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
