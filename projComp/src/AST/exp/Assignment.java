package AST.exp;

import AST.Node;
import AST.exp.Exp;
import AST.exp.var.Variable;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class Assignment extends Exp {
    Variable var;
    Exp exp;
    //TODO do something with
    Type conv1,conv2;
    Assignment(Variable var, Exp exp){
        this.var = var;
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
