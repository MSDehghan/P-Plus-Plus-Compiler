package AST.exp;

import AST.Node;
import AST.exp.Exp;
import AST.exp.var.Variable;
import AST.statement.Statement;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class Assignment extends Exp {
    Variable var;
    Exp exp;
    //TODO do something with
    Type conv1,conv2;
    public Assignment(Variable var, Exp exp){
        if (DefinedValues.DEBUG){
            System.out.println("assignment added to AST");
        }
        this.var = var;
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
