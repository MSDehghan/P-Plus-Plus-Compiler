package AST.declaration.variable;

import AST.OperationCode;
import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public abstract class VariableDeclaration extends OperationCode {
    protected String name;
    protected Exp exp = null;
    protected Type type = null;

    public Exp getExp() {
        return exp;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        if(type == null)
            throw new RuntimeException("Type is not Set!!!");

        return type;
    }


    abstract public void addFieldToClass(ClassVisitor cv);

    public DSCP getDSCP() {
        return SymbolTable.getInstance().getDescriptor(name);
    }
    public boolean isConstant(){
        return getDSCP().isConstant();
    }
    abstract void calculateType(MethodVisitor mv, ClassVisitor cv);
}
