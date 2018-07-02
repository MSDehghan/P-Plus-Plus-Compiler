package AST.declaration.variable;

import AST.Node;
import AST.SymbolTable.SymbolTable;
import AST.declaration.DuplicateNameInRecord;
import AST.declaration.InvalidVariableType;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import preDefinedValues.DefinedValues;
import preDefinedValues.HelperFunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import static jdk.internal.org.objectweb.asm.Opcodes.*;


public class StructDeclaration extends Node {
    private HashMap<String, VariableDeclaration> variables = new HashMap<>();
    private String name;
    private Type type;

    public StructDeclaration(ArrayList<DCLS> dclses, String name) {
        this.name = name;

        for (DCLS dcls : dclses) {
            ArrayList<VariableDeclaration> vars = dcls.getVariables();
            for (VariableDeclaration var : vars) {
                if (variables.containsKey(var.getName())) throw new DuplicateNameInRecord();
                variables.put(var.getName(), var);
            }
        }
        type = Type.getType("L" + name + ";");
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }


    private void declare() {
        SymbolTable.getInstance().addRecord(this);
    }

    @Override
    public void compile(MethodVisitor MV, ClassVisitor CV) {
        declare();
        ClassWriter cw;
        TraceClassVisitor cv;



        cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        try {
            cv = new TraceClassVisitor(cw, new PrintWriter(Paths.get(DefinedValues.compilePath, getName() + ".txt").toFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        cv.visit(V1_8, ACC_PUBLIC + ACC_SUPER, getName(), null, Type.getInternalName(Object.class), null);
        for (VariableDeclaration var : variables.values()) {
            var.calculateType(null, null);
            if (HelperFunctions.isRecord(var.getType()) && !SymbolTable.getInstance().isRecordDefined(var.getType().getClassName()))
                throw new InvalidVariableType("Record Type Is Not Defined");

            var.addFieldToClass(cv, false);
        }


        MethodVisitor mv; mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        cv.visitEnd();
        byte[] bytes = cw.toByteArray();
        try {
            Files.write(Paths.get(DefinedValues.compilePath,  getName() + ".class"), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
