package AST.exp;

import AST.Node;
import jdk.internal.org.objectweb.asm.MethodVisitor;


public class MethodCall extends Node {
    String id;
    Parameters parameters;
    public MethodCall(String id, Parameters parameters){
        this.id = id ;
        this.parameters = parameters ;
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
