package AST.exp.binaryExp;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;

/**
 * Created by pooria on 6/27/2018.
 */

public abstract class BinaryExp extends Exp {
    protected Exp exp1, exp2 ;
    Type conv1, conv2;
//    TODO do something with conv1, conv2
    static Type computeType(Type type1, Type type2){
        return null;
    }


    public BinaryExp SetBinaryExp(Exp exp1, Exp exp2){
        this.exp1=exp1;
        this.exp2=exp2;
        return this;
    }


    protected Exp setExp(Exp exp1, Exp exp2){
        this.exp1=exp1;
        this.exp2=exp2;
        return this;
    }
}
