package AST.declaration;


import AST.block.Block;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import preDefinedValues.PairPooria;

import java.util.ArrayList;

/**
 * Created by pooria on 6/29/2018.
 */
public class FunctionDeclaration extends FuncDcl {
    ArrayList <PairPooria <String,Integer> >  pairs ;
    String type;
    String name;
    Block block;
    /**
     *
     * @param paris contains pairs of String type and also an integer for dims
     * @param type  the type that the function returns
     */
    public FunctionDeclaration(ArrayList <PairPooria <String,Integer> > paris, String type, String name, Block block){
        //TODO keep in mind that the pairs and the block part may be null
        this.pairs = paris;
        this.type = type;
        this.name = name;
        this.block = block;
    }


    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }

}
