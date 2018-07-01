package AST.declaration.function;

import AST.Node;
import AST.SymbolTable.SymbolTable;
import AST.exp.Exp;
import com.sun.org.apache.xpath.internal.operations.Equals;
import jdk.internal.org.objectweb.asm.Type;

import java.util.ArrayList;


public abstract class FuncDcl extends Node {
    protected Type type;
    protected String name;
    protected String signature;
    public Type [] inputs;
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public FuncDcl(String type, String name, ArrayList<FunctionArgument > arguments) {
        this.type = SymbolTable.getTypeFromName(type);
        this.name = name;
        inputs = new Type[arguments.size()];
        int i = 0;
        for(FunctionArgument f : arguments){
            inputs[i++]=f.getType();
        }
        SymbolTable.getInstance().addFunction(this);


        String signature = "";
        signature = signature + "(";
        for(Type typeIn : inputs){
            signature = signature+typeIn.toString();
        }
        signature = signature + ")";
        signature = signature + type;
        this.signature = signature;


    }

    public FuncDcl(String functionSignature, String name) {
        this.signature = functionSignature;
        Type[] types = Type.getArgumentTypes(functionSignature);
        Type [] arguments = types;
        this.type = Type.getType(functionSignature.substring(functionSignature.indexOf(')')+1));
        this.name = name;
        inputs = new Type[arguments.length];
        int i = 0;
        for(Type t : arguments){
            inputs[i++]=t;
        }



        try {
            SymbolTable.getInstance().getFunction(name,inputs);
        }catch (RuntimeException r){
            SymbolTable.getInstance().addFunction(this);
        }

    }

    public boolean checkIfEqual(Type [] inputs, String name){
        if (this.name!=name){
            return false;
        }else if (this.inputs.length!=inputs.length){
            return false;
        }else {
            int i = 0;
            for(Type t : inputs){
                if(this.inputs[i++]!=t){
                    return false;
                }
            }
            return true;
        }
    }

}
