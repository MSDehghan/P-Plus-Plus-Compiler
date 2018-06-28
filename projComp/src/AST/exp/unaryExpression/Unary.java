package AST.exp.unaryExpression;

import AST.exp.Exp;
import preDefinedValues.DefinedValues;

/**
 * Created by pooria on 6/28/2018.
 */
public abstract class Unary extends Exp{
    Exp exp1;
    public Unary(){

    }
    public Unary setUnary(Exp exp1){
        if(DefinedValues.DEBUG){
            System.out.println("unary was made in ast");
        }
        this.exp1 = exp1;
        return this;
    }
}
