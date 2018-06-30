package AST.declaration;

public class InvalidVariableType extends RuntimeException {
    public InvalidVariableType() {
        super();
    }

    public InvalidVariableType(String message) {
        super(message);
    }
}
