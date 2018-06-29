package AST.exp.assignments;

import AST.exp.Exp;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import preDefinedValues.DefinedValues;

public class MinusAssign extends Exp2Var {

    public MinusAssign(Variable var, Exp exp) {
        if (DefinedValues.DEBUG) {
            System.out.println("plus assignment added to AST");
        }
        this.var = var;
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
