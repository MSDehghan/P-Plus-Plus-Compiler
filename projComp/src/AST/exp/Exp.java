package AST.exp;

import AST.Node;
import jdk.internal.org.objectweb.asm.Type;

abstract public class Exp extends Node {
    protected Type type = null;
    public Exp(){
    }
    //TODO should do more and over ride for type checking
    public Type getType() {
        if(type == null)
            throw new RuntimeException("Type is Not Set!!!");

        return type;
    }
}
