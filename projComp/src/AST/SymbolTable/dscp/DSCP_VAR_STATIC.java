package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public class DSCP_VAR_STATIC extends DSCP_STATIC {

    public DSCP_VAR_STATIC(String name, Type type, boolean constant) {
        super(name, type, constant);
    }

    public DSCP_VAR_STATIC(String name, Class<?> clazz, boolean constant) {
        super(name, clazz, constant);
    }

    public DSCP_VAR_STATIC(String name, String typeS, boolean constant) {
        super(name, typeS, constant);
    }
}
