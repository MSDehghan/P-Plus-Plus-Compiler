package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public abstract class DSCP_STATIC extends DSCP {
    DSCP_STATIC(String name, Type type) {
        super(name, type);
    }

    DSCP_STATIC(String name, Class<?> clazz) {
        super(name, clazz);
    }

    DSCP_STATIC(String name, String typeS) {
        super(name, typeS);
    }
}
