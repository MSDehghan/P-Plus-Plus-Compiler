package AST.SymbolTable.dscp;

import java.util.ArrayList;


// TODO: 28/06/2018 This is not Complete
public class DSCP_RECORD_DYNAMIC extends DSCP_DYNAMIC {

    ArrayList<String> listNames = new ArrayList<String>();

    DSCP_RECORD_DYNAMIC(String name, Class<?> clazz, int index, String... names) {
        super(name, clazz, index);
        for (String a : names) {
            listNames.add(a);
        }
    }

    DSCP_RECORD_DYNAMIC(String name, String typeS, int index, String... names) {
        super(name, typeS, index);
        this.index = index;
        for (String a : names) {
            listNames.add(a);
        }

    }

}
