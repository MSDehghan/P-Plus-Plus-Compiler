package preDefinedValues;


public class DefinedValues {
    public  static String nameClass = "$Main";
    private static boolean GLOBAL = true;
    public  static boolean getScope(){
        return DefinedValues.GLOBAL;
    }
    public  static void changeScope(){
        DefinedValues.GLOBAL = !DefinedValues.GLOBAL;
    }
    public  static boolean DEBUG =  true;
}
