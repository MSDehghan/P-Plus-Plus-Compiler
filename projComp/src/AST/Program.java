package AST;

import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class Program extends Node {
    public ArrayList<Node> nodes = new ArrayList<Node>();
    public Program(){

    }

    @Override
    public void compile(MethodVisitor mv) {

    }

}
