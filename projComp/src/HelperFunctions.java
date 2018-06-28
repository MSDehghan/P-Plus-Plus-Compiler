/**
 * Created by pooria on 6/28/2018.
 */
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
}
