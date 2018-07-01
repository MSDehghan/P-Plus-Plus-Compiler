package AST.SymbolTable.dscp;


import jdk.internal.org.objectweb.asm.Type;

public class DSCP_VAR_DYNAMIC extends DSCP_DYNAMIC {
     public DSCP_VAR_DYNAMIC(String name, Class<?> clazz, int index,boolean constant) {
        super(name, clazz, index,constant);
    }

    public DSCP_VAR_DYNAMIC(String name, Type type, int index,boolean constant) {
        super(name, type, index,constant);
    }

    public DSCP_VAR_DYNAMIC(String name, String typeS, int index,boolean constant) {
        super(name, typeS, index,constant);
    }
}
