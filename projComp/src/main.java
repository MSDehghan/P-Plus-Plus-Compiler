import AST.Program;
import java_cup.runtime.Symbol;

import java.io.FileReader;
import java.util.ArrayList;

public class main {
    public static Program program =new Program() ;



    public static void main(String[] args) throws Exception {
//        program.nodes.add();

//        Long a = new Long("-12L");
//        System.out.println(a.substring(0,a.length()-1));


//        ArrayList <OperationCode> codes =new ArrayList<>();
//        Assignment a = new Assignment(new SimpleVariable(),new IntConstExp(10));

//        Yylex y = new Yylex(new FileReader("input.txt"));
//        Symbol s = y.next_token();
//        Object s1 = s.value;
//        Object s2 = s.sym;
//
//
//        while(s1!=null){
//            System.out.println(s1);
//            System.out.println(s2);
//            s = y.next_token();
//            s1 = s.value;
//            s2 = s.sym;
//
//        }


//        int a=1,b=2,c=3;
//        a=(b/=c);


//        System.out.println(Integer.parseInt("-0x1f"));


        parser p = new parser(new Yylex(new FileReader("input.txt")));
        Object result = p.parse().value;
//        System.out.println(result);
    }
}
