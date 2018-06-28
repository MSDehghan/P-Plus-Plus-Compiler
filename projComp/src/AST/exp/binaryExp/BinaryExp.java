package AST.exp.binaryExp;

import AST.exp.Exp;

/**
 * Created by pooria on 6/27/2018.
 */
public abstract class BinaryExp extends Exp {
    protected Exp exp1, exp2 ;
    protected BinaryExp(Exp exp1, Exp exp2){
        this.exp1=exp1;
        this.exp2=exp2;
    }
}
