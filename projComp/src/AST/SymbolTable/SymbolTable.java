package AST.SymbolTable;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.declaration.InvalidDeclaration;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;

// TODO: 28/06/2018 pop scope
public class SymbolTable {
    private static int labelCounter = 0;
    private static SymbolTable instance = new SymbolTable();
    private ArrayList<HashMapOurs<String, DSCP>> stackScopes = new ArrayList<HashMapOurs<String, DSCP>>();
    private SymbolTable() {
        stackScopes.add(new HashMapOurs<String, DSCP>());
    }

    public static Type getTypeFromName(String varType) {
        Type type;
        switch (varType) {
            case "int":
                type = Type.INT_TYPE;
                break;
            case "long":
                type = Type.LONG_TYPE;
                break;
            case "char":
                type = Type.CHAR_TYPE;
                break;
            case "bool":
                type = Type.BOOLEAN_TYPE;
                break;
            case "double":
                type = Type.DOUBLE_TYPE;
                break;
            case "float":
                type = Type.FLOAT_TYPE;
                break;
            case "string":
                type = Type.getType(String.class);
                break;
            default:
                throw new InvalidDeclaration("Type is not Valid");

        }
        return type;
    }

    public String getNewLabel() {
        return "L" + labelCounter++;
    }

    public static SymbolTable getInstance() {
        return instance;
    }

    public void addVariable(DSCP dscp, String name) {
        if (stackScopes.get(stackScopes.size() - 1).containsKey(name)) {
            throw new VariableNotFound();
        }
        stackScopes.get(stackScopes.size() - 1).put(name, dscp);
        if(dscp instanceof DSCP_DYNAMIC)
            stackScopes.get(stackScopes.size() - 1).index += dscp.getType().getSize();
    }

    /**
     * @param name name of variable
     * @return returns the DSCP for the variable on the first found scope and if there is none
     * @throws Exception if variable is not found
     */
    public DSCP getDescriptor(String name) { //todo we shall check that we never get all of the stacks out
        int from = stackScopes.size();
        while (from != 0) {

            from--;


            if (stackScopes.get(from).containsKey(name)) {
                return stackScopes.get(from).get(name);
            }


        }
        throw new VariableNotFound();
    }


    public void addScope() {
        stackScopes.add(new HashMapOurs<String, DSCP>());
    }

    /**
     * can be used for making DSCP's
     *
     * @return the first empty slot on the last local variable scope
     */
    // TODO: 28/06/2018
    public int returnNewIndex() {
        return stackScopes.get(stackScopes.size() - 1).index;
    }


}
