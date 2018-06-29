package AST;

import AST.declaration.DCLS;
import AST.declaration.FuncDcl;
import AST.declaration.StructDeclaration;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class Program extends Node {
    public ArrayList<Node> nodes = new ArrayList<Node>();
    public Program(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        for (Node c : nodes){
            if(c instanceof StructDeclaration){
                c.compile(mv, cv);
            }
        }
        for(Node c : nodes){
            if(c instanceof DCLS){
                c.compile(mv,cv);
            }
        }
        for (Node c : nodes){
            if(c instanceof FuncDcl){
                c.compile(mv, cv);
            }
        }

    }

}
