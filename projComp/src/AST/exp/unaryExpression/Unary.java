package AST.exp.unaryExpression;

import AST.exp.Exp;

/**
 * Created by pooria on 6/28/2018.
 */
public abstract class Unary extends Exp{
    Exp exp1;
    Unary(Exp exp1){
        this.exp1 = exp1;
    }
}
