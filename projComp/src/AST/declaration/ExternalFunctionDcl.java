package AST.declaration;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/29/2018.
 */
public class ExternalFunctionDcl extends FuncDcl {
    String type;
    String name;
    public ExternalFunctionDcl(String type, String name){
        this.name = name;
        this.type = type;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
