package AST.declaration.variable;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.*;
import AST.exp.Exp;
import AST.exp.consts.Constant;
import jdk.internal.org.objectweb.asm.*;

import static AST.SymbolTable.SymbolTable.getTypeFromName;
import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SimpleVariableDeclaration extends VariableDeclaration {
    public SimpleVariableDeclaration(String varName, String varType, boolean staticDec, boolean Constant) {
        name = varName;
        Type type = getTypeFromName(varType);
        declare(staticDec, type, Constant);
    }

    //TODO do something with constant
    public SimpleVariableDeclaration(String varName, String varType, Exp value, boolean staticDec, boolean Constant) {
        name = varName;
        Type type;
        if (varType.equals("auto")) {
            type = value.getType();
        } else {
            type = getTypeFromName(varType);
        }
        this.exp = value;
        declare(staticDec, type, Constant);
    }

    /**
     * @param staticDec check if it is static or not
     * @param type      Type of Variable
     * @throws IllegalArgumentException if type and name is not set!
     */
    private void declare(boolean staticDec, Type type, boolean Constant) {
        // TODO: 01/07/2018 SymbolTable Should Change
        if (name == null || type == null)
            throw new IllegalArgumentException();

        DSCP dscp;

        if (staticDec) {
            dscp = new DSCP_VAR_STATIC(name, type, Constant);
        } else {
            dscp = new DSCP_VAR_DYNAMIC(name, type, SymbolTable.getInstance().returnNewIndex(), Constant);
        }

        SymbolTable.getInstance().addVariable(dscp, name);
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_STATIC) {
            DSCP_STATIC dscpStatic = (DSCP_STATIC) dscp;
            Object value = null;
            // TODO: 01/07/2018 Handle Not Constant
            if (getExp() instanceof Constant && getExp().getType() == getType()) {
                value = ((Constant) getExp()).getValue();
            }
            int access = ACC_STATIC + ACC_PUBLIC;
            access += isConstant() ? Opcodes.ACC_FINAL : 0;
            FieldVisitor fv = cv.visitField(access, dscp.getName(), dscp.getType().getDescriptor(), null, value);
            fv.visitEnd();
        } else {
            DSCP_DYNAMIC dscpDynamic = (DSCP_DYNAMIC) dscp;
            if (getExp() != null && getExp().getType() == getType()) {
                getExp().compile(mv, cv);
                mv.visitVarInsn(getType().getOpcode(ISTORE), dscpDynamic.getIndex());
            }
        }
    }
}
