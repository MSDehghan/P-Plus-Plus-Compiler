package AST.declaration.variable;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.List;

public class ArrayVariableDeclaration extends VariableDeclaration {
    private List<Exp> dimensions;

    public ArrayVariableDeclaration(String varName, String type,List<Exp> dimensions, boolean Static,boolean Constant) {
        name = varName;
        this.dimensions = dimensions;
//TODO do something with constant
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
