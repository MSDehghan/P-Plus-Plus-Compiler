package AST.exp;

import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.List;

public class ArrayVariable extends Variable {
    private List<Integer> arguments = new ArrayList<>();

    public ArrayVariable(String varName, List<Integer> arguments) {
        name = varName;
        this.arguments = arguments;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
