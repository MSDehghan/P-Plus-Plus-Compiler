package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class CharConstExp extends Exp {
    private Character value;

    public CharConstExp(Character value) {
        if(DefinedValues.DEBUG)
        System.out.println(value);
        this.value = value;
        type = Type.CHAR_TYPE;
    }

    public Character getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        IntConstExp.storeIntValue(mv, (int) value);
    }
}
