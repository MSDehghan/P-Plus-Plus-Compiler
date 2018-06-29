package preDefinedValues;

/**
 * Created by pooria on 6/28/2018.
 */
public class DefinedValues {
    private static boolean GLOBAL = true;
    public static boolean getScope(){
        return DefinedValues.GLOBAL;
    }
    public static void changeScope(){
        DefinedValues.GLOBAL = !DefinedValues.GLOBAL;
    }
    public static boolean DEBUG =  true;
}
