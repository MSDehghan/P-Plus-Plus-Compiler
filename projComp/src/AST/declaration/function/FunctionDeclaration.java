package AST.declaration.function;


import AST.block.Block;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;


public class FunctionDeclaration extends FuncDcl {
    ArrayList <FunctionArgument > arguments;
    Block block;
    /**
     *
     * @param arguments contains arguments of String type and also an integer for dims
     * @param type  the type that the function returns
     */
    public FunctionDeclaration(ArrayList <FunctionArgument> arguments, String type, String name, Block block){
        super(type, name);
        //TODO keep in mind that the arguments and the block part may be null
        this.arguments = arguments;
        this.block = block;
    }


    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }

}
