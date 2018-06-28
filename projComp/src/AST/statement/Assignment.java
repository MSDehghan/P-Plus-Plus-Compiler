package AST.statement;

import AST.exp.Exp;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class Assignment extends Statement {
    Variable var;
    Exp exp;
    Assignment(Variable var, Exp exp){
        this.var = var;
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
