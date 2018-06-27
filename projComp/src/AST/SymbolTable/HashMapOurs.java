package AST.SymbolTable;

import java.util.HashMap;

/**
 * Created by pooria on 6/27/2018.
 */
public class HashMapOurs <K,V> extends  HashMap <K,V> {
    int index;
    HashMapOurs(){
        super();
        index=0;
    }
}
