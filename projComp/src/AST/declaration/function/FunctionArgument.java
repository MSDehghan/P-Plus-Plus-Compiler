package AST.declaration.function;

import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.Type;

public class FunctionArgument {
    private Type type;
    private String name;
    private Integer dimensions;

    public FunctionArgument(String type, String name, Integer dimensions) {
        this.type = SymbolTable.getTypeFromName(type);
        this.name = name;
        this.dimensions = dimensions;
    }
    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getDimensions() {
        return dimensions;
    }
}
