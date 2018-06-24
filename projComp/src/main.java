import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by pooria on 6/24/2018.
 */
public class main {
    public static void main(String[] args) throws Exception {
        parser p = new parser(new Yylex(new FileReader("input.txt")));
        Object result = p.parse().value;

    }
}
