package AST.SymbolTable;

import AST.SymbolTable.dscp.DSCP;
import AST.SymbolTable.dscp.DSCP_DYNAMIC;
import AST.declaration.function.ExternalFunctionDcl;
import AST.declaration.function.FuncDcl;
import AST.declaration.function.StaticVarsExtern;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// TODO: 28/06/2018 pop scope
public class SymbolTable {
    public static int FUNCTION = 0;
    public static int LOOP = 0;
    public static int SWITCH = 0;
    public static int COND_OTHER_THAN_SWITCH = 0;
    private static FuncDcl LastSeenFunction;
    private static int labelCounter = 0;
    private static SymbolTable instance = new SymbolTable();
    private ArrayList<HashMapOurs<String, DSCP>> stackScopes = new ArrayList<HashMapOurs<String, DSCP>>();
    private HashMap<String, ArrayList<FuncDcl>> funcDcls = new HashMap<String, ArrayList<FuncDcl>>();

    private SymbolTable() {
        HashMapOurs<String, DSCP> mainFrame = new HashMapOurs<>();
        mainFrame.setIndex(1); //There is Always a (String... args) in main Function.
        stackScopes.add(mainFrame);
    }
    public Set<String> getKeySet(){
        return funcDcls.keySet();
    }
    public static FuncDcl getLastSeenFunction() {
        return LastSeenFunction;
    }

    public static void setLastSeenFunction(FuncDcl lastSeenFunction) {
        LastSeenFunction = lastSeenFunction;
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
            case "void":
                type = Type.VOID_TYPE;
                break;
            case "short":
                type = Type.SHORT_TYPE;
                break;
            default:
                type = Type.getType(varType);
//                throw new InvalidDeclaration("Type is not Valid");

        }
        return type;
    }

    public static SymbolTable getInstance() {
        return instance;
    }

    public void popScope() {
        stackScopes.remove(stackScopes.size() - 1);
    }

    /**
     * @param name name of type
     * @return int
     * @throws IllegalArgumentException at the seeing of class names which do not exist
     */
    public int getSize(String name) {
        int size;
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

    public void addFunction(FuncDcl funcDcl) {
        if (funcDcls.containsKey(funcDcl.getName())) {
            funcDcls.get(funcDcl.getName()).add(funcDcl);
        } else {
            ArrayList<FuncDcl> funcDclMapper = new ArrayList<>();
            funcDclMapper.add(funcDcl);
            funcDcls.put(funcDcl.getName(), funcDclMapper);
        }
    }

    public FuncDcl getFunction(String name, Type[] inputs) {
//        System.out.println(name);
//        for(Type t:inputs){
//            System.out.println(t);
//        }
//        System.out.println();
        if (funcDcls.containsKey(name)) {
            ArrayList<FuncDcl> funcDclMapper = funcDcls.get(name);
            for (FuncDcl f : funcDclMapper) {
                if (f.checkIfEqual(inputs, name)) {
                    return f;
                }
            }
//          TODO make this go away in case of saying something later
            throw new RuntimeException("no such function was found");
        } else {
//          TODO make this go away in case of saying something later
            throw new RuntimeException("no such function was found");
        }
    }

    public String getNewLabel() {
        return "L" + labelCounter++;
    }

    /**
     * only call this method during compile
     * @param name
     * @return
     */
    public boolean externOrNot(String name){
        if(!funcDcls.containsKey(name)){
            throw new RuntimeException("no such funciton");
        }
        return funcDcls.get(name).get(0) instanceof ExternalFunctionDcl;
    }

    public void addVariable(DSCP dscp, String name) {
        if (getLastFrame().containsKey(name)) {
            throw new VariableNotFound();
        }
        getLastFrame().put(name, dscp);
        if (dscp instanceof DSCP_DYNAMIC)
            getLastFrame().addIndex(dscp.getType().getSize() - 1);
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


    public void addScope(int typeOfScope) {
        HashMapOurs<String, DSCP> frame = new HashMapOurs<>();
        frame.setLabelStart();
        frame.setLabelLast();
        frame.setTypeOfScope(typeOfScope);
        if(typeOfScope!=FUNCTION)
            frame.setIndex(getLastFrame().getIndex());
        stackScopes.add(frame);
    }

    public boolean canHaveBreak() {
        return getLastFrame().getTypeOfScope() == LOOP || getLastFrame().getTypeOfScope() == SWITCH;
    }

    /**
     * @return the first empty slot on the last local variable scope
     */


    public int returnNewIndex() {
        return getLastFrame().getAndAddIndex();
    }

    public void setLabelFirst(Label label) {
        getLastFrame().setLabelStart(label);
    }

    public Label getLabelLast() {
        return getLastFrame().getLabelLast();
    }

    public void setLabelLast(Label label) {
        getLastFrame().setLabelLast(label);
    }

    public Label getLabelStart() {
        return getLastFrame().getLabelStart();
    }


    public HashMapOurs<String, DSCP> getLastFrame() {
        if (stackScopes.size() == 0)
            throw new RuntimeException("Something Goes Wrong");

        return stackScopes.get(stackScopes.size() - 1);
    }
}

