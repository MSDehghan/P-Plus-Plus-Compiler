package AST.SymbolTable.dscp;

import java.util.ArrayList;


// TODO: 28/06/2018 This is not Complete
public class DSCP_RECORD_STATIC extends DSCP_STATIC {


    ArrayList<String> listNames = new ArrayList<String>();

    DSCP_RECORD_STATIC(String name, Class<?> clazz,boolean constant, String... names) {
        super(name, clazz,constant);
        for (String a : names) {
            listNames.add(a);
        }
    }

    DSCP_RECORD_STATIC(String name, String typeS,boolean constant, String... names) {
        super(name, typeS,constant);
        for (String a : names) {
            listNames.add(a);
        }
    }
}
