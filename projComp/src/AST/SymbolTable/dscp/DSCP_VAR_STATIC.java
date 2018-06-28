package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public class DSCP_VAR_STATIC extends DSCP_STATIC {

    public DSCP_VAR_STATIC(String name, Type type) {
        super(name, type);
    }

    public DSCP_VAR_STATIC(String name, Class<?> clazz) {
        super(name, clazz);
    }

    public DSCP_VAR_STATIC(String name, String typeS) {
        super(name, typeS);
    }
}
