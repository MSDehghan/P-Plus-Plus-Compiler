package AST.exp.var;

import AST.SymbolTable.SymbolTable;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

public abstract class Variable extends Exp {
    String name;

    public static Type getTypeFromName(String varType) {
        Type type;
        switch (varType) {
            case "int":
                type = Type.INT_TYPE;
                break;
            case "long":
                type = Type.LONG_TYPE;
                break;
            case "char":
                type = Type.CHAR_TYPE;
                break;
            case "bool":
                type = Type.BOOLEAN_TYPE;
                break;
            case "double":
                type = Type.DOUBLE_TYPE;
                break;
            case "float":
                type = Type.FLOAT_TYPE;
                break;
            case "string":
                type = Type.getType(String.class);
                break;
            default:
                throw new InvalidDeclaration("Type is not Valid");

        }
        return type;
    }

    @Override
    public Type getType() {
        return SymbolTable.getInstance().getDescriptor(name).getType();
    }
}
