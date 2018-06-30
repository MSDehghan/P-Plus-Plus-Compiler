import AST.declaration.variable.SimpleVariableDeclaration;
import AST.exp.binaryExp.conditional.Greater;
import AST.exp.consts.IntConstExp;
import AST.exp.var.SimpleVariable;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import org.junit.Test;
import static jdk.internal.org.objectweb.asm.Opcodes.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;

public class MainUnitTest {
    @Test
    public void testMain() throws FileNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(Paths.get("./CodeOut.txt").toFile()));

        cv.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "$Main", null, Type.getInternalName(Object.class), null);
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        mv = cv.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();


        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

        SimpleVariableDeclaration a = new SimpleVariableDeclaration("a","int",false,false);
        SimpleVariableDeclaration b = new SimpleVariableDeclaration("b","int",false,false);
        IntConstExp i1 = new IntConstExp(5);
        i1.compile(mv,cv);
        mv.visitVarInsn(ISTORE,1);

        IntConstExp i2 = new IntConstExp(6);
        i1.compile(mv,cv);
        mv.visitVarInsn(ISTORE,2);

        SimpleVariable aV = new SimpleVariable("a");
        SimpleVariable bV = new SimpleVariable("b");

        Greater g = new Greater();
        g.setBinaryExp(aV, bV);
        g.compile(mv,cv);

        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        mv.visitInsn(RETURN);

        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cv.visitEnd();
        byte[] bytes = cw.toByteArray();
        MainClassLoader loader = new MainClassLoader();
        Class<?> clazz = loader.defineClass("$Main", bytes);
        Method main = clazz.getMethod("main", String[].class);
        String[] arguments = new String[0];
        main.invoke(null, (Object) arguments);
    }
}
class MainClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}