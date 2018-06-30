package AST.exp.binaryExp.conditional;

import AST.declaration.InvalidVariableType;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class And extends Conditional {
    public And() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();
        if (type != Type.INT_TYPE)
            throw new InvalidVariableType("Only Int Types Can Be Operands Of Conditional And");

        Label label = new Label();
        Label EndLabel = new Label();

        exp1.compile(mv, cv);
        mv.visitJumpInsn(IFEQ, label);
        exp2.compile(mv, cv);
        mv.visitJumpInsn(IFEQ, label);
        mv.visitInsn(ICONST_1);
        mv.visitJumpInsn(GOTO, EndLabel);
        mv.visitLabel(label);
        mv.visitInsn(ICONST_0);
        mv.visitLabel(EndLabel);
    }
}

