package AST;

import AST.declaration.variable.DCLS;
import AST.declaration.function.FuncDcl;
import AST.declaration.variable.StructDeclaration;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;

import static jdk.internal.org.objectweb.asm.Opcodes.*;


public class Program {
    public ArrayList<Node> nodes = new ArrayList<Node>();

    public Program() {

    }

    public Program add(Node e) {
        nodes.add(e);
        return this;
    }

    public void compile(String whereToSave) throws FileNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

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

        for (Node c : nodes){
            if(c instanceof StructDeclaration){
                c.compile(mv, cv);
            }
        }
        for(Node c : nodes){
            if(c instanceof DCLS){
                c.compile(mv,cv);
            }
        }

        for (Node c : nodes){
            if(c instanceof FuncDcl){
                FuncDcl funcDcl = (FuncDcl) c;

                c.compile(mv, cv);
            }
        }

        mv = cv.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

//        init().compile(mv);

        mv.visitInsn(RETURN);

        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cv.visitEnd();
        byte[] bytes = cw.toByteArray();
        MainClassLoader loader = new MainClassLoader();
        Class<?> clazz = loader.defineClass("$Main", bytes);
        Method main = clazz.getMethod("main", String[].class);
        String[] b = new String[0];
        main.invoke(null, (Object) b);
    }

}

class MainClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}
