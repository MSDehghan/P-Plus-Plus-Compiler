package AST.declaration;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.List;

public class ArrayVariableDeclaration extends VariableDeclaration {
    private List<Exp> dimensions;

    public ArrayVariableDeclaration(String varName,List<Exp> dimensions) {
        name = varName;
        this.dimensions = dimensions;

    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
