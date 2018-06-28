package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public abstract class DSCP_DYNAMIC extends DSCP {
    int index = -1;

    DSCP_DYNAMIC(String name, Type type, int index) {
        super(name, type);
        this.index = index;
    }

    DSCP_DYNAMIC(String name, Class<?> clazz, int index) {
        super(name, clazz);
        this.index = index;
    }

    DSCP_DYNAMIC(String name, String typeS, int index) {
        super(name, typeS);
        this.index = index;
    }
}
