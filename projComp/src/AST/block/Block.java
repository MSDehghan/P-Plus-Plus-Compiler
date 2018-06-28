package AST.block;

import AST.Node;
import AST.OperationCode;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/28/2018.
 */
public class Block extends Node{
    ArrayList <OperationCode> operationCodes = new ArrayList<>();
    Block(OperationCode ... codes){
        for (OperationCode code : codes){
            this.operationCodes.add(code);
        }
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}

