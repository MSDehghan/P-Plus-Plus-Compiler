package AST;

import AST.declaration.DCLS;
import AST.declaration.FuncDcl;
import AST.declaration.StructDeclaration;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class Program {
    public ArrayList<Node> nodes = new ArrayList<Node>();
    public Program(){

    }

    public Program add(Node e){
        nodes.add(e);
        return this;
    }

    public void compile(String whereToSave) {
//        for (Node c : nodes){
//            if(c instanceof StructDeclaration){
//                c.compile(mv, cv);
//            }
//        }
//        for(Node c : nodes){
//            if(c instanceof DCLS){
//                c.compile(mv,cv);
//            }
//        }
//        for (Node c : nodes){
//            if(c instanceof FuncDcl){
//                c.compile(mv, cv);
//            }
//        }

    }

}
