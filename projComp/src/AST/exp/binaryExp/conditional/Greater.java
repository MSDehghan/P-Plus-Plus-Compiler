package AST.exp.binaryExp.conditional;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.IF_ICMPLT;

public class Greater extends Conditional {
    public Greater() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();
        // TODO: 30/06/2018 Exception for Record

        exp1.compile(mv, cv);
        exp2.compile(mv, cv);

        notIntCompare(mv, type, 0);

        Label l5 = new Label();
        mv.visitJumpInsn(IF_ICMPLT, l5);

        


    }
}

