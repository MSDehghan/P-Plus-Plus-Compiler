package AST.declaration.function;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;


public class ExternalFunctionDcl extends FuncDcl {

    public ExternalFunctionDcl(String type, String name){
        super(type,name);
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
