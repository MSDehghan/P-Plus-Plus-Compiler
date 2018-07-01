package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

public class DSCP_ARR_DYNAMIC extends DSCP_DYNAMIC {
    private int dimensions;

    public DSCP_ARR_DYNAMIC(String name, Type type, int index, int dims,boolean constant) {
        super(name, type, index,constant);

        this.dimensions = dims;
    }

    DSCP_ARR_DYNAMIC(String name, Class<?> clazz, int index, int dims,boolean constant) {
        super(name, clazz, index,constant);

        this.dimensions = dims;
    }

    DSCP_ARR_DYNAMIC(String name, String typeS, int index, int dims,boolean constant) {
        super(name, typeS, index,constant);

        this.dimensions = dims;
    }

    public int getDimensions() {
        return dimensions;
    }
}
