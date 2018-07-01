package AST.exp;

import AST.Node;
import AST.SymbolTable.SymbolTable;
import AST.declaration.function.ExternalFunctionDcl;
import AST.declaration.function.FuncDcl;
import AST.declaration.function.StaticVarsExtern;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;

import static jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL;


public class MethodCall extends Exp {
    String id;
//    Parameters parameters;
    //TODO alos should check the signature of the function
    ArrayList <Exp> parameters ;
    FuncDcl funcDcl;
    public MethodCall(String id, ArrayList <Exp> parameters){
        this.id = id ;
        this.parameters = parameters ;
        Type [] typesInComped = new Type[parameters.size()];
        for (int i = 0; i < parameters.size(); i++) {
            typesInComped[i] = parameters.get(i).type;
        }
        //        TODO handle how to make it so that it won't give us an error if we name it later
        this.funcDcl = SymbolTable.getInstance().getFunction(id, typesInComped);
        this.type = funcDcl.getType();

    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

        if(funcDcl instanceof ExternalFunctionDcl){
            ExternalFunctionDcl e = (ExternalFunctionDcl) funcDcl;
            if(e.getVars().size()!=0) {
                mv.visitFieldInsn(GETSTATIC, e.getVars().get(0).address, e.getVars().get(0).name, e.getVars().get(0).type);
                if (e.getVars().size() > 1) {
                    for (int i = 1; i < e.getVars().size(); i++) {
                        mv.visitFieldInsn(Opcodes.GETFIELD, e.getVars().get(i).address, e.getVars().get(i).name, e.getVars().get(i).type);
                    }
                }
                for (Exp exp : parameters) {
                    exp.compile(mv, cv);
                }
//            TODO what is this false
                String s = funcDcl.getType().toString();
                if (s.charAt(0) == 'L') {
                    s = s.substring(1, s.length() - 1);
                }
//            else do nothing
                mv.visitMethodInsn(INVOKEVIRTUAL, e.getAddress(), id, e.getFunctionSignature(), false);
            }else {
                mv.visitMethodInsn(Opcodes.INVOKESTATIC,e.getAddress(),e.getName(),e.getFunctionSignature(),false);
            }
        }else {

        }
    }
}
