import java_cup.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
    static int parseInt(String in){
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
    public static void main(String[] args) throws Exception {
//        Yylex y = new Yylex(new FileReader("input.txt"));
//        Symbol s = y.next_token();
//        Object s1 = s.value;
//        Object s2 = s.sym;
//
//        while(s1!=null){
//            System.out.println(s1);
//            System.out.println(s2);
//            s = y.next_token();
//            s1 = s.value;
//            s2 = s.sym;
//
//        }


        System.out.println(parseInt("-0x1f"));


//        parser p = new parser(new Yylex(new FileReader("input.txt")));
//        Object result = p.parse().value;
//        System.out.println(result);
    }
}
