package AST.exp.consts;

import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

public class CharConstExp extends Exp {
    private Character value;

    public CharConstExp(Character value) {
        this.value = value;
        type = Type.CHAR_TYPE;
    }

    public Character getValue() {
        return value;
    }

    @Override
    public void compile(MethodVisitor mv) {

    }
}
