package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public abstract class DSCP_DYNAMIC extends DSCP {
    int index = -1;

    DSCP_DYNAMIC(String name, Type type, int index, boolean constant) {
        super(name, type, constant);
        this.index = index;
    }

    DSCP_DYNAMIC(String name, Class<?> clazz, int index, boolean constant) {
        super(name, clazz, constant);
        this.index = index;
    }

    DSCP_DYNAMIC(String name, String typeS, int index, boolean constant) {
        super(name, typeS, constant);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
