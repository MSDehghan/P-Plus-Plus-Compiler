package AST.block;

import AST.Node;
import AST.OperationCode;
import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class Block extends Node{
    ArrayList <OperationCode> operationCodes = new ArrayList<>();
    public Block(ArrayList <OperationCode> operationCodes){
        this.operationCodes = operationCodes;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        for(OperationCode oc : operationCodes){
            oc.compile(mv,cv);
        }
    }
}

