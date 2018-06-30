package AST.exp.binaryExp;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;




public abstract class BinaryExp extends Exp {
    protected Exp exp1, exp2 ;
    Type conv1, conv2;
//    TODO do something with conv1, conv2
    static Type computeType(Type type1, Type type2){
        return null;
    }

    @Override
    public Type getType() {
        if (type != null) return type;
        if (exp1.getType() != exp2.getType())
            throw new IllegalArgumentException("Two Operands must be of the same type");
        return type = exp1.getType();
    }

    public BinaryExp SetBinaryExp(Exp exp1, Exp exp2){
        if(DefinedValues.DEBUG){
            System.out.println("hey");
        }
        this.exp1=exp1;
        this.exp2=exp2;
        return this;
    }
}
