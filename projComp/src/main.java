import java_cup.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by pooria on 6/24/2018.
 */
public class main {
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


        parser p = new parser(new Yylex(new FileReader("input.txt")));
        Object result = p.parse().value;
    }
}
