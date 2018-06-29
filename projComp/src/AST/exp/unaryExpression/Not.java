package AST.exp.unaryExpression;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.ICONST_M1;
import static jdk.internal.org.objectweb.asm.Opcodes.IXOR;

public class Not extends Unary {

    public Not() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();
        if (type != Type.INT_TYPE)
            throw new RuntimeException("Invalid Type");

        exp.compile(mv, cv);
        mv.visitInsn(ICONST_M1);
        mv.visitInsn(type.getOpcode(IXOR));
    }
}
