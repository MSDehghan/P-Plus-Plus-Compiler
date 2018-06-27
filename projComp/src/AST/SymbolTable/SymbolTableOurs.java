package AST.SymbolTable;

import AST.SymbolTable.DSCP;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pooria on 6/27/2018.
 */
public class SymbolTableOurs {
    private ArrayList <HashMapOurs <String,DSCP> > stackScopes = new ArrayList<HashMapOurs <String,DSCP>>();

    SymbolTableOurs(){
        stackScopes.add(new HashMapOurs<String,DSCP>());
    }




    void addVariable (DSCP dscp, String name) throws Exception {
        if(stackScopes.get(stackScopes.size() - 1).containsKey(name)){
            throw new Exception("variable was found");
        }
        stackScopes.get(stackScopes.size()-1).put(name, dscp);
        stackScopes.get(stackScopes.size()-1).index += dscp.type.getSize();
    }

    /**
     *
     * @param name
     * @return returns the dscp for the variable on the first found scope and if there is none , null is returned
     */
    DSCP getDescriptor (String name) throws Exception { //todo we shall check that we never get all of the stacks out
        int from = stackScopes.size();
        while (from!=0){

            from--;


            if(stackScopes.get(from).containsKey(name)){
                return stackScopes.get(from).get(name);
            }


        }
        throw new Exception("variable not found");
    }


    void addScope(){
        stackScopes.add(new HashMapOurs<String,DSCP>());
    }

    /**
     *can be used for making DSCP's
     * @return the first empty slot on the last local variable scope
     */
    int returnTheFirstEmpty(){
        return stackScopes.get(stackScopes.size()-1).index;
    }


}
