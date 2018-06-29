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
        HashMapOurs<String, DSCP> mainFrame = new HashMapOurs<>();
        mainFrame.setIndex(1); //There is Always a (String... args) in main Function.
        stackScopes.add(mainFrame);
    }


    /**
     *
     * @param name name of type
     * @return int
     * @throws IllegalArgumentException at the seeing of class names which do not exist
     */
    public int getSize(String name){
        int  size;
        switch (name) {
            case "int":
                size = Integer.SIZE;
                break;
            case "long":
                size = Long.SIZE;
                break;
            case "char":
                size = Character.SIZE;
                break;
            case "bool":
                size = 1;
                break;
            case "double":
                size = Double.SIZE;
                break;
            case "float":
                size = Float.SIZE;
                break;
            case "string":
                size = Integer.SIZE;
                break;
            default:
                throw new IllegalArgumentException("Type is not Valid");

        }
        return size;
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

    public static SymbolTable getInstance() {
        return instance;
    }

    public String getNewLabel() {
        return "L" + labelCounter++;
    }

    public void addVariable(DSCP dscp, String name) {
        if (getLastFrame().containsKey(name)) {
            throw new VariableNotFound();
        }
        getLastFrame().put(name, dscp);
        if (dscp instanceof DSCP_DYNAMIC)
            getLastFrame().addIndex(dscp.getType().getSize());
    }

    /**
     * @param name name of variable
     * @return returns the DSCP for the variable on the first found scope and if there is none
     * @throws VariableNotFound if variable is not found
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
        HashMapOurs<String, DSCP> frame = new HashMapOurs<>();
        frame.setIndex(getLastFrame().getIndex());
        stackScopes.add(frame);
    }

    /**
     * @return the first empty slot on the last local variable scope
     */
    public int returnNewIndex() {
        return getLastFrame().getAndAddIndex();
    }

    private HashMapOurs<String, DSCP> getLastFrame() {
        if (stackScopes.size() == 0)
            throw new RuntimeException("Something Goes Wrong");

        return stackScopes.get(stackScopes.size() - 1);
    }
}
