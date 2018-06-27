package AST.exp.binaryExp;

import AST.exp.Exp;

/**
 * Created by pooria on 6/27/2018.
 */
public class BinaryExp {
    Exp exp1, exp2 ;
    BinaryExp(Exp exp1, Exp exp2){
        this.exp1=exp1;
        this.exp2=exp2;
    }
}
