package AST.exp.var;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.List;

public class ArrayVariable extends Variable {
    private List<Exp> arguments;

    public ArrayVariable(String varName, List<Exp> arguments) {
        name = varName;
        this.arguments = arguments;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
