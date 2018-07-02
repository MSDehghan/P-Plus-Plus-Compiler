package AST.exp.var;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public abstract class Variable extends Exp {
    String name;
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return getDSCP().getType();
    }

    public DSCP getDSCP() {
        return SymbolTable.getInstance().getDescriptor(name);
    }

}
