package AST.exp.assignments;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.exp.Exp;
import AST.exp.var.SimpleVariable;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import preDefinedValues.DefinedValues;
import preDefinedValues.HelperFunctions;

import static jdk.internal.org.objectweb.asm.Opcodes.ISTORE;

public class MultAssign extends Exp2Var {

    public MultAssign(Variable var, Exp exp) {
        if (DefinedValues.DEBUG) {
            System.out.println("plus assignment added to AST");
        }
        this.var = var;
        this.exp = exp;
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        this.type = var.getType();
        // TODO: 29/06/2018 handle Arrays
        if (!(var instanceof SimpleVariable))
            throw new RuntimeException();

        DSCP dscp = var.getDSCP();
        var.compile(mv,cv);
        exp.compile(mv,cv);
        if (var.getType() != exp.getType())
            HelperFunctions.cast(exp.getType(), var.getType(), mv, cv);
        mv.visitInsn(var.getType().getOpcode(Opcodes.IMUL));
        if(dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) dscp).getIndex();
            mv.visitVarInsn(var.getType().getOpcode(ISTORE), index);
            var.compile(mv,cv);
        }else{
            // TODO: 29/06/2018 For Static Variables;
            mv.visitFieldInsn(Opcodes.PUTSTATIC, DefinedValues.nameClass, dscp.getName(), dscp.getType().toString());
//            throw new RuntimeException();
        }
    }
}
