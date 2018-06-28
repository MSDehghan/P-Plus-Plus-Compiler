package AST.declaration;

import AST.exp.Exp;

import java.util.List;

public class ArrayVariableDeclaration extends VariableDeclaration {
    private List<Exp> dimensions;

    public ArrayVariableDeclaration(String varName,List<Exp> dimensions) {
        name = varName;
        this.dimensions = dimensions;

    }
}
