package AST.exp;

import AST.Node;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class MethodCall extends Node {
    String id;
//    Parameters parameters;
    //TODO alos should check the signature of the function
    ArrayList <Exp> parameters ;
    public MethodCall(String id, ArrayList <Exp> parameters){
        this.id = id ;
        this.parameters = parameters ;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
