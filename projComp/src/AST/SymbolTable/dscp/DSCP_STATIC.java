package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public abstract class DSCP_STATIC extends DSCP {
    DSCP_STATIC(String name, Type type,boolean constant) {
        super(name, type,constant);
    }

    DSCP_STATIC(String name, Class<?> clazz,boolean constant) {
        super(name, clazz,constant);
    }

    DSCP_STATIC(String name, String typeS,boolean constant) {
        super(name, typeS,constant);
    }
}
