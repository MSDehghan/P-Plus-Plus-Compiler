package AST.exp.var;

import AST.SymbolTable.VariableNotFound;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class SimpleVariable extends Variable {


    /**
     * @param varName variable name
     * @throws VariableNotFound if variable is not defined before
     */
    public SimpleVariable(String varName) {
        name = varName;
        type = this.getType();
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }

}
