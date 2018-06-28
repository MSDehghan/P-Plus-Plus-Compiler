package AST.exp.consts;

import AST.SymbolTable.SymbolTable;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by pooria on 6/29/2018.
 */
public class SizeOf extends Exp{
    Integer value;
    public SizeOf(String id){
        this.value = SymbolTable.getSize(id);
    }
    @Override
    public void compile(MethodVisitor mv) {

    }
}
