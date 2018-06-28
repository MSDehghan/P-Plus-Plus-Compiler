package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;

public class DSCP_ARR_DYNAMIC extends DSCP_DYNAMIC {
    int up;
    ArrayList<Integer> dims = new ArrayList<Integer>();

    DSCP_ARR_DYNAMIC(String name, Type type, int up, int index, int... dims) {
        super(name, type, index);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }

    DSCP_ARR_DYNAMIC(String name, Class<?> clazz, int up, int index, int... dims) {
        super(name, clazz, index);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }

    DSCP_ARR_DYNAMIC(String name, String typeS, int index, int up, int... dims) {
        super(name, typeS, index);

        for (int i : dims) {
            this.dims.add(i);
        }
        this.up = up;
    }
}
