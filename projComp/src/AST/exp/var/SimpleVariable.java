package AST.exp.var;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class SimpleVariable extends Variable {

    public SimpleVariable(String varName, String varType) {
        name = varName;
        type = Type.getType(varType);
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
