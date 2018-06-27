package AST.exp.consts;

import jdk.internal.org.objectweb.asm.Type;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

public class IntConstExp extends Exp {
    private Integer value;

    public IntConstExp(Integer value) {
        type = Type.INT_TYPE;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
