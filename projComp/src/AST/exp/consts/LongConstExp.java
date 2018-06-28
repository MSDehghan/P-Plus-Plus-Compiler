package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class LongConstExp extends Exp {
    private Long value;

    public LongConstExp(Long value) {
        if(DefinedValues.DEBUG)
        System.out.println(value);
        this.value = value;
        type = Type.LONG_TYPE;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
