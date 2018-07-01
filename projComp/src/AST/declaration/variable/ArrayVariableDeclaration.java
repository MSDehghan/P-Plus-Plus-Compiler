package AST.declaration.variable;

import AST.exp.Exp;
import AST.exp.consts.IntConstExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.List;

public class ArrayVariableDeclaration extends VariableDeclaration {
    private List<Exp> dimensions;
//  TODO we should add arrays for both records and primitive and also every where we should add refrence even if we are making it , after making it we should add refrence
    public ArrayVariableDeclaration(String varName, String type,int dims, boolean Constant) {
        name = varName;
        boolean Static = false;
        //TODO do something with constant and dimms
        this.dimensions = dimensions;
    }
    public ArrayVariableDeclaration(String varName, String type,List<Exp> dimensions, boolean Static,boolean Constant) {
        name = varName;
        this.dimensions = dimensions;
//TODO do something with constant
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
