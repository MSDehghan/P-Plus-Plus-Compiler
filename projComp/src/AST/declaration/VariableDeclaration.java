package AST.declaration;

import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.Type;

public class VariableDeclaration {
    String name;

    public String getName() {
        return name;
    }

    public Type getType() {
        return SymbolTable.getInstance().getDescriptor(name).getType();
    }
}
