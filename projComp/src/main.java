import AST.Program;
import AST.SymbolTable.SymbolTable;
import AST.declaration.function.ExternalFunctionDcl;
import AST.declaration.function.StaticVarsExtern;
import java_cup.runtime.Symbol;
import preDefinedValues.DefinedValues;

import java.io.FileReader;
import java.util.ArrayList;

public class main {
    public static Program program =new Program() ;



    public static void main(String[] args) throws Exception {


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

        ArrayList<StaticVarsExtern> ins = new ArrayList<StaticVarsExtern>();
        ins.add(new StaticVarsExtern("Ljava/io/PrintStream;","out","java/lang/System"));
        ExternalFunctionDcl a = new ExternalFunctionDcl("java/io/PrintStream",ins,"println","(I)V");

        parser p = new parser(new Yylex(new FileReader("input.txt")));
        Object result = p.parse().value;
        Program pr = (Program) result;
        pr.compile(DefinedValues.nameClass);

//        System.out.println(!true);
    }
}
