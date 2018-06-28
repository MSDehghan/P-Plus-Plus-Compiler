package AST.exp;

import AST.mehtodCall.MethodCall;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class MethodCallExpression extends Exp {
    MethodCall methodCall ;
    MethodCallExpression(MethodCall methodCall){
        this.methodCall = methodCall;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
