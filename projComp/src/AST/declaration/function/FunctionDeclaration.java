package AST.declaration.function;


import AST.SymbolTable.SymbolTable;
import AST.block.Block;
import AST.declaration.variable.ArrayVariableDeclaration;
import AST.declaration.variable.SimpleVariableDeclaration;
import AST.declaration.variable.VariableDeclaration;
import AST.exp.consts.IntConstExp;
import AST.exp.var.Variable;
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
        MethodVisitor newMv = cv.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC,name,this.signature,null,null);

        newMv.visitCode();
//        System.out.println(SymbolTable.getInstance().getLastFrame().keySet());
        SymbolTable.getInstance().addScope(SymbolTable.FUNCTION);
//        System.out.println(SymbolTable.getInstance().getLastFrame().keySet());

        SymbolTable.setLastSeenFunction(this);

//        this part shall be for declaring new variables

            for (FunctionArgument f : arguments){
                if(f.getDimensions()==0){
//                   TODO we can add constant to the function too
                    VariableDeclaration v = new SimpleVariableDeclaration(f.getName(),f.getType().getClassName(),false,false);
                    v.compile(newMv,cv);
                }else{
//                   TODO we can add constant to the function too
                    VariableDeclaration v = new ArrayVariableDeclaration(f.getName(),f.getType().getClassName(),f.getDimensions(),false,false);
                    v.compile(newMv,cv);
                }
            }


//
        block.compile(newMv,cv);

        if(returns.size()==0){
            if (type.equals(Type.VOID_TYPE)){
                newMv.visitInsn(Opcodes.RETURN);
            }else{
                throw new RuntimeException("no return type seen , but should have seen one");
            }
        }
        newMv.visitMaxs(1, 1);
        newMv.visitEnd();
        SymbolTable.getInstance().popScope();

    }

}
