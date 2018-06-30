package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.*;

import static jdk.internal.org.objectweb.asm.Opcodes.GOTO;
import static jdk.internal.org.objectweb.asm.Opcodes.ICONST_0;
import static jdk.internal.org.objectweb.asm.Opcodes.ICONST_1;

public class NotEqual extends Conditional {
    public NotEqual(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();
        // TODO: 30/06/2018 Exception for Record

        exp1.compile(mv, cv);
        exp2.compile(mv, cv);

        notIntCompare(mv,type,0);

        Label l1 = new Label();
        Label l2 = new Label();
        mv.visitJumpInsn(Opcodes.IF_ICMPNE, l1);
        mv.visitInsn(ICONST_0);
        mv.visitJumpInsn(GOTO, l2);
        mv.visitLabel(l1);
        mv.visitInsn(ICONST_1);
        mv.visitLabel(l2);
    }
}

