package AST.exp;

import AST.Node;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

/**
 * Created by pooria on 6/28/2018.
 */
public class Parameters extends Node {
    ArrayList <Exp> expressions = new ArrayList<Exp>();

    @Override
    public void compile(MethodVisitor mv) {

    }


    Parameters(Exp exp, ArrayList<Exp> expressions){
        this.expressions = expressions;
        this.expressions.add(exp);
    }

    Parameters(Exp ... exps){
        for (Exp e : exps){
            expressions.add(e);
        }
    }

}
