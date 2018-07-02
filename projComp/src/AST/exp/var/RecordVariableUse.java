package AST.exp.var;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;


//TODO keep in mind this is only for the use of Variable . Variable other uses shall be constructed in other classes
public class RecordVariableUse extends Variable {
    Variable v1;
    String id;
    public RecordVariableUse(Variable v1, String v2){
        name = v1.getName() + id;
        this.v1 = v1;
        this.id = v2;
    }
    @Override
    public void compile(MethodVisitor mv, ClassVisitor cv) {

    }
}
