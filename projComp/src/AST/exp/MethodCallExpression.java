package AST.exp;

import AST.mehtodCall.MethodCall;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/28/2018.
 */
public class MethodCallExpression extends Exp {
    MethodCall methodCall ;
    MethodCallExpression(MethodCall methodCall){
        this.methodCall = methodCall;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
