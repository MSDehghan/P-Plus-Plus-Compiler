import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

public class HelperFunctions {
    public static int parseInt(String in){
        if(in.length()>=3   ){
            if(in.charAt(1)=='x'){
                return Integer.parseInt(in.substring(2),16);
            }else if(in.charAt(2)=='x') {
                return Integer.parseInt(in.substring(0,1)+in.substring(3),16);
            }else {
                return Integer.parseInt(in,10);
            }
        }else{
            return Integer.parseInt(in,10);
        }
    }
    public static boolean isRecord(Type type){
        if(type==Type.BOOLEAN_TYPE||type==Type.INT_TYPE||type==Type.CHAR_TYPE||type==Type.LONG_TYPE||type==Type.FLOAT_TYPE||type==Type.DOUBLE_TYPE||type==Type.SHORT_TYPE){
            return false;
        }
        return true;
    }
    public static boolean isInteger(Type type){
        if(type==Type.BOOLEAN_TYPE||type==Type.INT_TYPE||type==Type.CHAR_TYPE||type==Type.SHORT_TYPE){
            return true;
        }
        return false;
    }
    private static boolean checkForDouble(Type type1,Type type2,MethodVisitor mv, ClassVisitor cv){
        if(type2==Type.DOUBLE_TYPE){
            if(isInteger(type1)){
                mv.visitInsn(Opcodes.I2D);
            }else if(type1==Type.LONG_TYPE){
                mv.visitInsn(Opcodes.L2D);
            }
            return true;
        }
        return false;
    }
    private static boolean checkForLong(Type type1,Type type2,MethodVisitor mv, ClassVisitor cv){
        if(type2==Type.LONG_TYPE){
            if(isInteger(type1)){
                mv.visitInsn(Opcodes.I2L);
            }
            return true;
        }
        return false;
    }
    public static void cast(Type type1, Type type2,MethodVisitor mv, ClassVisitor cv){
        if(isRecord(type1)||isRecord(type2)){
            if(type1!=type2){
                throw new RuntimeException("we don't have operator overloading ... yet");
            }
        }else {
            if(!checkForDouble(type1,type2,mv,cv)){
                checkForLong(type1,type2,mv,cv);
            }
        }

    }
}
