package AST.declaration.variable;

import AST.OperationCode;
import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

public abstract class VariableDeclaration extends OperationCode {
    protected String name;
    protected Exp exp = null;

    public Exp getExp() {
        return exp;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return getDSCP().getType();
    }

    public DSCP getDSCP() {
        return SymbolTable.getInstance().getDescriptor(name);
    }
    public boolean isConstant(){
        return getDSCP().isConstant();
    }
}
