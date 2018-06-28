package AST.SymbolTable.dscp;


import jdk.internal.org.objectweb.asm.Type;

public class DSCP_VAR_DYNAMIC extends DSCP_DYNAMIC {
     public DSCP_VAR_DYNAMIC(String name, Class<?> clazz, int index) {
        super(name, clazz, index);
    }

    public DSCP_VAR_DYNAMIC(String name, Type type, int index) {
        super(name, type, index);
    }

    public DSCP_VAR_DYNAMIC(String name, String typeS, int index) {
        super(name, typeS, index);
    }
}
