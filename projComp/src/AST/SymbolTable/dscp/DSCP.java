package AST.SymbolTable.dscp;

import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.Type;


// TODO: 28/06/2018 method must be done
public abstract class DSCP {
    Type type;
    String name;
    boolean isConstant = false;

    public DSCP(String name, Type type,boolean constant) {
        this.type = type;
        this.name = name;
        this.isConstant= constant;
    }

    DSCP(String name, Class<?> clazz,boolean constant) {
        this.type = Type.getType(clazz);
        this.name = name;
        this.isConstant= constant;

    }

    DSCP(String name, String typeS,boolean constant) {
        this.type = SymbolTable.getTypeFromName(typeS);
        this.name = name;
        this.isConstant= constant;
    }

    public Type getType() {
        return type;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public String getName() {
        return name;
    }
}




