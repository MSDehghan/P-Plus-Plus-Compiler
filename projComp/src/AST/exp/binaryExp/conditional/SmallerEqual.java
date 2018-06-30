package AST.exp.binaryExp.conditional;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SmallerEqual extends Conditional {
    public SmallerEqual(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();
        // TODO: 30/06/2018 Exception for Record

        exp1.compile(mv, cv);
        exp2.compile(mv, cv);

        notIntCompare(mv, type, null);

        Label l1 = new Label();
        Label l2 = new Label();
        mv.visitJumpInsn(IFGE, l1); // TODO: 30/06/2018 Greater is Not Okay
        mv.visitInsn(ICONST_1);
        mv.visitJumpInsn(GOTO,l2);
        mv.visitLabel(l1);
        mv.visitInsn(ICONST_0);
        mv.visitLabel(l2);
    }
}

