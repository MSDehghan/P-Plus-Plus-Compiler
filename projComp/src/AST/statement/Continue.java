package AST.statement;

import AST.SymbolTable.SymbolTable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;


public class Continue extends Statement {
    public Continue(){

    }

//    TODO this asserts that you have pushed the right
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        mv.visitJumpInsn(Opcodes.GOTO, SymbolTable.getInstance().getLabelStart());
    }
}
