package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;

public class DSCP_ARR_STATIC extends DSCP_STATIC {
    ArrayList<Integer> dims = new ArrayList<Integer>();
    int up;

    DSCP_ARR_STATIC(String name, Type type, int index, int up, int... dims) {
        super(name, type);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }

    DSCP_ARR_STATIC(String name, Class<?> clazz, int index, int up, int... dims) {
        super(name, clazz);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }

    DSCP_ARR_STATIC(String name, String typeS, int index, int up, int... dims) {
        super(name, typeS);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }
}
