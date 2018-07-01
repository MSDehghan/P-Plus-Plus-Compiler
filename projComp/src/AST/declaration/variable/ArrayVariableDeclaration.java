package AST.declaration.variable;

import AST.SymbolTable.SymbolTable;
import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_ARR_DYNAMIC;
import AST.SymbolTable.dscp.DSCP_ARR_STATIC;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.exp.Exp;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;
import preDefinedValues.HelperFunctions;

import java.util.List;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ArrayVariableDeclaration extends VariableDeclaration {
    private List<Exp> dimensions;

    public ArrayVariableDeclaration(String varName, String type, int dims, boolean Static, boolean Constant) {
        name = varName;
        this.dimensions = dimensions;
        declare(Static, SymbolTable.getTypeFromName(type), Constant);
        //TODO do something with constant
    }


    public ArrayVariableDeclaration(String varName, String type, List<Exp> dimensions, boolean Static, boolean Constant) {
        name = varName;
        this.dimensions = dimensions;
        declare(Static, SymbolTable.getTypeFromName(type), Constant);
        //TODO do something with constant
    }

    private void declare(boolean staticDec, Type type, boolean Constant) {
        // TODO: 01/07/2018 SymbolTable Should Change
        if (name == null || type == null)
            throw new IllegalArgumentException();


        dimensions.forEach(exp -> {
            if (!HelperFunctions.isInteger(exp.getType()))
                throw new RuntimeException("Bad Index Type"); // TODO: 01/07/2018 Write Good Exception
        });

        String repeatedArray = new String(new char[dimensions.size()]).replace("\0", "[");
        Type arrayType = Type.getType(repeatedArray + type.getDescriptor()); // TODO: 01/07/2018 PLease Testtttttt!
        DSCP dscp;

        if (staticDec) {
            dscp = new DSCP_ARR_STATIC(name, arrayType, dimensions.size(), Constant);
        } else {
            dscp = new DSCP_ARR_DYNAMIC(name, arrayType, SymbolTable.getInstance().returnNewIndex(), dimensions.size(), Constant);
        }

        SymbolTable.getInstance().addVariable(dscp, name);
    }

    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {
        if (getDSCP() instanceof DSCP_DYNAMIC) {
            for (Exp dimension : dimensions) {
                dimension.compile(mv, cv);
            }

            if (dimensions.size() == 1) {
                if (!HelperFunctions.isRecord(getType().getElementType())) {
                    mv.visitIntInsn(NEWARRAY, HelperFunctions.getTType(getType().getElementType()));
                } else {
                    mv.visitTypeInsn(ANEWARRAY, getType().getElementType().getInternalName());
                }
            } else {
                mv.visitMultiANewArrayInsn(getType().getDescriptor(), dimensions.size());
            }

            mv.visitVarInsn(ASTORE, ((DSCP_DYNAMIC) getDSCP()).getIndex());
        } else {
            int access = ACC_STATIC + ACC_PUBLIC;
            access += isConstant() ? Opcodes.ACC_FINAL : 0;
            cv.visitField(access, getName(), getType().getDescriptor(), null, null);
        }
    }
}
