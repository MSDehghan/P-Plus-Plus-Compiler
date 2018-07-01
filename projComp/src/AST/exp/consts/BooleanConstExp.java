package AST.exp.consts;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class BooleanConstExp extends Constant {
    private Boolean value;

    public BooleanConstExp(Boolean value) {
        if (DefinedValues.DEBUG)
            System.out.println(value);
        this.value = value;
        type = Type.BOOLEAN_TYPE;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        IntConstExp.storeIntValue(mv, value ? 1 : 0);
    }
}
