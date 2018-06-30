package AST.exp.unaryExpression;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;


public abstract class Unary extends Exp{
    Exp exp;
    public Unary(){

    }

    @Override
    public Type getType() {
        if (type != null) return type;
        return type = exp.getType();
    }

    public Unary setUnary(Exp exp1){
        if(DefinedValues.DEBUG){
            System.out.println("unary was made in ast");
        }
        this.exp = exp1;
        return this;
    }
}
