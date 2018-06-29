package AST.exp.unaryExpression;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.IMUL;
import static jdk.internal.org.objectweb.asm.Opcodes.INEG;

public class Minus extends Unary {

    public Minus() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        exp.compile(mv,cv);
        mv.visitInsn(exp.getType().getOpcode(INEG));
    }
}
