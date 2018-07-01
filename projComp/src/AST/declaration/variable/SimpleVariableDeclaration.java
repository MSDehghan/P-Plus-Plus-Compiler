package AST.declaration.variable;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.*;
import AST.exp.Exp;
import AST.exp.consts.Constant;
import jdk.internal.org.objectweb.asm.*;

import javax.sound.midi.Soundbank;

import static AST.SymbolTable.SymbolTable.getInstance;
import static AST.SymbolTable.SymbolTable.getTypeFromName;
import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SimpleVariableDeclaration extends VariableDeclaration {
    boolean staticDec;
    boolean Constant;
    String  varType;
    public SimpleVariableDeclaration(String varName, String varType, boolean staticDec, boolean Constant) {
        name = varName;
        this.varType = varType;
        this.staticDec = staticDec;
        this.Constant = Constant;

    }
    //TODO do something with constant
    public SimpleVariableDeclaration(String varName, String varType, Exp value, boolean staticDec, boolean Constant) {
        name = varName;
        this.varType = varType ;
        this.exp = value;
        this.staticDec = staticDec;
        this.Constant = Constant;
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
        Type type = getTypeFromName(varType);
        declare(staticDec, type, Constant);
        DSCP dscp = getDSCP();
        if (dscp instanceof DSCP_STATIC) {
            DSCP_STATIC dscpStatic = (DSCP_STATIC) dscp;
            Object value = null;
            // TODO: 01/07/2018 Handle Not Constant
            if (getExp() instanceof Constant && getExp().getType().equals(getType())) {
                value = ((Constant) getExp()).getValue();
            }
            int access = ACC_STATIC + ACC_PUBLIC;
            access += isConstant() ? Opcodes.ACC_FINAL : 0;

            FieldVisitor fv = cv.visitField(access, dscp.getName(), dscp.getType().getDescriptor(), null, value);
            fv.visitEnd();
        } else {
            DSCP_DYNAMIC dscpDynamic = (DSCP_DYNAMIC) dscp;
            if (getExp() != null && getExp().getType().equals(getType()) ) {
                getExp().compile(mv, cv);
                mv.visitVarInsn(getType().getOpcode(ISTORE), dscpDynamic.getIndex());
            }
//            else{
//                mv.visitInsn(getType().getOpcode(Opcodes.ICONST_0));
//                mv.visitVarInsn(getType().getOpcode(ISTORE), dscpDynamic.getIndex());
//            }
        }
    }
}
