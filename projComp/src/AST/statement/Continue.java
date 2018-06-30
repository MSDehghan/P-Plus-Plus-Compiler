package AST.statement;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;


public class Continue extends Statement {
    public Continue(){

    }
//    TODO this asserts that you have pushed the right
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        
    }
}
