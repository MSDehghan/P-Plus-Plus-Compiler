package AST.declaration.function;

import AST.Node;
import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.Type;


public abstract class FuncDcl extends Node {
    protected Type type;
    protected String name;

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public FuncDcl(String type, String name) {
        this.type = SymbolTable.getTypeFromName(type);
        this.name = name;
    }
}
