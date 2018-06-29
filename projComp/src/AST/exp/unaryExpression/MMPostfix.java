package AST.exp.unaryExpression;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.exp.var.SimpleVariable;
import AST.exp.var.Variable;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class MMPostfix extends Unary {

    public MMPostfix() {

    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        {
            {
                Type type = exp.getType();
                if (!(exp instanceof Variable) || (type != Type.INT_TYPE && type != Type.DOUBLE_TYPE && type != Type.LONG_TYPE && type != Type.CHAR_TYPE))
                    throw new IllegalArgumentException();


                Variable var = (Variable) exp;

                // TODO: 29/06/2018 For Array And Records Should Be Added !!
                if (exp instanceof SimpleVariable) {
                    DSCP dscp = var.getDSCP();

                    if (dscp instanceof DSCP_DYNAMIC) {
                        int index = ((DSCP_DYNAMIC) dscp).getIndex();
                        if (type == Type.INT_TYPE || type == Type.CHAR_TYPE)
                            mv.visitIincInsn(index, -1);
                        else {
                            var.compile(mv,cv);//Postfix

                            var.compile(mv,cv);

                            if (type == Type.DOUBLE_TYPE) {
                                mv.visitInsn(DCONST_1);
                            }
                            else {
                                mv.visitInsn(LCONST_1);
                            }

                            mv.visitInsn(type.getOpcode(ISUB));
                            mv.visitVarInsn(type.getOpcode(ISTORE), index);
                        }

                    } else {
                        // TODO: 29/06/2018 For Static Variables
                        throw new RuntimeException();
                    }
                }
            }
        }
    }
}
