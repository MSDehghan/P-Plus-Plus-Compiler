package AST.declaration.function;


import AST.SymbolTable.SymbolTable;
import AST.block.Block;
import AST.statement.Return;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;


public class FunctionDeclaration extends FuncDcl {
    ArrayList <FunctionArgument > arguments;
    public ArrayList <Return> returns = new ArrayList<Return>();
    Block block;
    /**
     *
     * @param arguments contains arguments of String type and also an integer for dims
     * @param type  the type that the function returns
     */
    public FunctionDeclaration(ArrayList <FunctionArgument> arguments, String type, String name, Block block){
        super(type, name, arguments);
        //TODO keep in mind that the arguments and the block part may be null
        this.arguments = arguments;
        this.block = block;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
//        TODO we can add generics and others later (that's why the last two are null)
        MethodVisitor newMv = cv.visitMethod(Opcodes.ACC_PUBLIC,name,this.signature,null,null);

        newMv.visitCode();

        SymbolTable.getInstance().addScope(SymbolTable.FUNCTION);
        SymbolTable.setLastSeenFunction(this);
        newMv.visitLabel(SymbolTable.getInstance().getLabelStart());
        block.compile(newMv,cv);

        if(returns.size()==0){
            if (type==Type.VOID_TYPE){
                newMv.visitInsn(Opcodes.RETURN);
            }else{
                throw new RuntimeException("no return type seen , but should have seen one");
            }
        }

        newMv.visitLabel(SymbolTable.getInstance().getLabelLast());

        SymbolTable.getInstance().popScope();


    }

}
