package AST.declaration;

import AST.Node;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class StructDeclaration extends Node {
    ArrayList <DCLS> dclses ;
    String name ;

    public StructDeclaration(ArrayList<DCLS> dclses, String name){
        this.dclses = dclses ;
        this.name = name ;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
