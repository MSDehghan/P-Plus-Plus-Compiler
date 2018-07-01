package AST.exp.binaryExp.arithmatic;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.IADD;
import static jdk.internal.org.objectweb.asm.Opcodes.ISUB;


public class Minus extends BinaryExp {
    public Minus(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {


        exp1.compile(mv,cv);
        exp2.compile(mv,cv);

        Type type = getType();

        mv.visitInsn(type.getOpcode(ISUB));

    }
}
