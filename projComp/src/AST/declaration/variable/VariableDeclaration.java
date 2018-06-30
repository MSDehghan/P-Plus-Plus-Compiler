package AST.declaration.variable;

import AST.OperationCode;
import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.Type;

public abstract class VariableDeclaration extends OperationCode {
    String name;

    public String getName() {
        return name;
    }

    public Type getType() {
        return SymbolTable.getInstance().getDescriptor(name).getType();
    }
}
