package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public class DSCP_ARR_STATIC extends DSCP_STATIC {
    private int dimensions;

    public DSCP_ARR_STATIC(String name, Type type, int dimensions,boolean constant) {
        super(name, type,constant);
        this.dimensions = dimensions;
    }

    DSCP_ARR_STATIC(String name, Class<?> clazz, int dimensions,boolean constant) {
        super(name, clazz,constant);
        this.dimensions = dimensions;
    }

    DSCP_ARR_STATIC(String name, String typeS, int dimensions,boolean constant) {
        super(name, typeS,constant);
        this.dimensions = dimensions;
    }

    public int getDimensions() {
        return dimensions;
    }
}
