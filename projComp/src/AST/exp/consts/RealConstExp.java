package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class RealConstExp extends Exp {
    private Double value;

    public RealConstExp(Double value) {
        this.value = value;
        type = Type.DOUBLE_TYPE;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
