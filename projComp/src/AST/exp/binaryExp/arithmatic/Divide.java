package AST.exp.binaryExp.arithmatic;

import AST.exp.binaryExp.BinaryExp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.IADD;
import static jdk.internal.org.objectweb.asm.Opcodes.IDIV;

/**
 * Created by pooria on 6/27/2018.
 */
public class Divide extends BinaryExp {
    public Divide(){

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        Type type = getType();

        exp1.compile(mv,cv);
        exp2.compile(mv,cv);
        mv.visitInsn(type.getOpcode(IDIV));

    }
}
