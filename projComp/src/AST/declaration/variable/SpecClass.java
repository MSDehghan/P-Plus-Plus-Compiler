package AST.declaration.variable;

import AST.exp.Exp;

import java.util.ArrayList;


public class SpecClass {
    public ArrayList <Exp> dims;
    public String name ;
    public Exp value ;
    public SpecClass(String name,ArrayList<Exp> dims, Exp value){
        this.dims = dims;
        this.name = name;
        this.value = value;
    }
}
