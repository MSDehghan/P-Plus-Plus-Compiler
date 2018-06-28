package AST.exp;

import AST.Node;
import jdk.internal.org.objectweb.asm.Type;

abstract public class Exp extends Node {
    protected Type type;
    public Exp(Type type){
        this.type=type;
    }
    public Type getType() {
        return type;
    }
}
