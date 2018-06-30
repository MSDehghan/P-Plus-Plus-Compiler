package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import AST.exp.consts.IntConstExp;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

public abstract class Conditional extends BinaryExp {
    public static void notIntCompare(MethodVisitor mv, Type type, Integer pushInteger) {
        if (type == Type.DOUBLE_TYPE) {
            mv.visitInsn(Opcodes.DCMPG);
            if (pushInteger != null) IntConstExp.storeIntValue(mv, pushInteger);
        } else if (type == Type.LONG_TYPE) {
            mv.visitInsn(Opcodes.LCMP);
            if (pushInteger != null) IntConstExp.storeIntValue(mv, pushInteger);
        }
    }
}
