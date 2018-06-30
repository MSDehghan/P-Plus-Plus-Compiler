package AST.declaration.variable;

import AST.Node;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class StructDeclaration extends Node {
    ArrayList <DCLS> dclses ;
    String name ;

    public StructDeclaration(ArrayList<DCLS> dclses, String name){
        this.dclses = dclses ;
        this.name = name ;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
