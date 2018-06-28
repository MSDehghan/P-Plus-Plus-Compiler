package AST.exp.consts;

import AST.exp.Exp;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class BooleanConstExp extends Exp {
    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public BooleanConstExp(Boolean value) {
        if(DefinedValues.DEBUG)
        System.out.println(value);
        this.value = value;
        type = Type.BOOLEAN_TYPE;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
