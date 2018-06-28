package AST.SymbolTable.dscp;

import jdk.internal.org.objectweb.asm.Type;

/**
 * Created by pooria on 6/27/2018.
 */
// TODO: 28/06/2018 method must be done
public abstract class DSCP {
    Type type;
    String name;

    public DSCP(String name, Type type) {
        this.type = type;
        this.name = name;
    }

    DSCP(String name, Class<?> clazz) {
        this.type = Type.getType(clazz);
        this.name = name;
    }

    DSCP(String name, String typeS) {
        this.type = Type.getType(typeS);
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}




