package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;

public class StringConstExp extends Exp {
    private String value;

    public StringConstExp(String value) {
        if(DefinedValues.DEBUG)
        System.out.println(value);
        type = Type.getType(String.class);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        mv.visitLdcInsn(value);
    }
}
