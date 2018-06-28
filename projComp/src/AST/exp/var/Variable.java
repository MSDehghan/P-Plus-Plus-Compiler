package AST.exp.var;

import AST.SymbolTable.SymbolTable;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

public abstract class Variable extends Exp {
    String name;



    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return SymbolTable.getInstance().getDescriptor(name).getType();
    }
}
