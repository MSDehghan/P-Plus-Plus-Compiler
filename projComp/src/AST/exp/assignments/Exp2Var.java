package AST.exp.assignments;

import AST.Node;
import AST.exp.Exp;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.Type;


public abstract class Exp2Var extends Exp {
    Variable var;
    Exp exp;
    //TODO do something with and set the cast
    Type conv1, conv2;

}
