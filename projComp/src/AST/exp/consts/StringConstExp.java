package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class StringConstExp extends Exp {
    private StringConstExp value;

    public StringConstExp(StringConstExp value) {
        type = Type.getType(StringConstExp.class);
        this.value = value;
    }

    public StringConstExp getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
