package tests;

import AST.OperationCode;
import AST.block.Block;
import AST.declaration.function.ExternalFunctionDcl;
import AST.declaration.function.FunctionArgument;
import AST.declaration.function.FunctionDeclaration;
import AST.declaration.function.StaticVarsExtern;
import AST.exp.Exp;
import AST.exp.MethodCall;
import AST.exp.consts.IntConstExp;
import AST.statement.ExpressionStatement;
import AST.statement.Statement;
import AST.statement.loop.For;
import jdk.internal.org.objectweb.asm.ClassVisitor;
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
import static jdk.internal.org.objectweb.asm.Opcodes.RETURN;

/**
 * Created by pooria on 7/1/2018.
 */
public class Test {
    static ClassWriter cw;
    static TraceClassVisitor cv;
    static MethodVisitor mv;
    static void definePrint(){



        ArrayList<StaticVarsExtern> ins = new ArrayList<StaticVarsExtern>();
        ins.add(new StaticVarsExtern("Ljava/io/PrintStream;","out","java/lang/System"));
        ExternalFunctionDcl a = new ExternalFunctionDcl("java/io/PrintStream",ins,"println","(I)V");






    }
    static void test1(){


        ArrayList <Exp> exps = new ArrayList<Exp>();
        exps.add(new IntConstExp(10));
        MethodCall methodCall = new MethodCall("println",exps);
        methodCall.compile(mv,cv);





    }


    static void test2(){


        ArrayList <Exp> exps = new ArrayList<Exp>();
        exps.add(new IntConstExp(10));
        MethodCall methodCall = new MethodCall("println",exps);
        Statement st = new ExpressionStatement(methodCall);
        ArrayList <OperationCode> statementsBlockFor = new ArrayList<OperationCode>();
        statementsBlockFor.add(st);
        Block blockFor = new Block(statementsBlockFor);
        For f = new For(blockFor,null,new IntConstExp(1),null);
//        f.compile(mv,cv);
        Statement mainState = f;
        ArrayList<OperationCode> funcMainSts = new ArrayList<>();
        funcMainSts.add(mainState);
        Block blockFunctionMain = new Block(funcMainSts);
        FunctionDeclaration funcMain = new FunctionDeclaration(new ArrayList<FunctionArgument>(),Type.VOID_TYPE.toString(),"funcMain",blockFunctionMain);
        funcMain.compile(mv,cv);

        //




    }

    static void test3(){
        MethodCall mc = new MethodCall("funcMain",new ArrayList<Exp>());
        mc.compile(mv,cv);
    }

    public static void firstPart() throws FileNotFoundException {
        cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cv = new TraceClassVisitor(cw, new PrintWriter(Paths.get("./CodeOut.txt").toFile()));

        cv.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "$Main", null, Type.getInternalName(Object.class), null);
        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        mv = cv.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
    }

    public static void endPart() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, FileNotFoundException {







        firstPart();

        definePrint();
        test2();
        test3();

        endPart();




    }
}
