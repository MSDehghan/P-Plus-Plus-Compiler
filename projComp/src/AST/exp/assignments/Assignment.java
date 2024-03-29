package AST.exp.assignments;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.exp.Exp;
import AST.exp.var.SimpleVariable;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.DefinedValues;
import preDefinedValues.HelperFunctions;

import static jdk.internal.org.objectweb.asm.Opcodes.ISTORE;

public class Assignment extends Exp2Var {

    //TODO we should make something for assigning records to records
    public Assignment(Variable var, Exp exp) {
        if (DefinedValues.DEBUG) {
            System.out.println("assignment added to AST");
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
        exp.compile(mv,cv);
        if (var.getType() != exp.getType())
            HelperFunctions.cast(exp.getType(), var.getType(), mv, cv);
        if(dscp instanceof DSCP_DYNAMIC) {
            int index = ((DSCP_DYNAMIC) dscp).getIndex();
            if(var.getType().equals(Type.DOUBLE_TYPE)){
                mv.visitVarInsn(var.getType().getOpcode(ISTORE), index);
                var.compile(mv,cv);
            }else{
                mv.visitVarInsn(var.getType().getOpcode(ISTORE), index);
                var.compile(mv,cv);
            }
        }else{
            // TODO: 29/06/2018 For Static Variables;
            mv.visitFieldInsn(Opcodes.PUTSTATIC, DefinedValues.nameClass, dscp.getName(), dscp.getType().toString());
//            throw new RuntimeException();
        }


    }
}
