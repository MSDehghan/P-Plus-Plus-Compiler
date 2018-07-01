package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public class DSCP_ARR_STATIC extends DSCP_STATIC {
    private int dimensions;

    public DSCP_ARR_STATIC(String name, Type type, int dimensions) {
        super(name, type);
        this.dimensions = dimensions;
    }

    DSCP_ARR_STATIC(String name, Class<?> clazz, int dimensions) {
        super(name, clazz);
        this.dimensions = dimensions;
    }

    DSCP_ARR_STATIC(String name, String typeS, int dimensions) {
        super(name, typeS);
        this.dimensions = dimensions;
    }

    public int getDimensions() {
        return dimensions;
    }
}
