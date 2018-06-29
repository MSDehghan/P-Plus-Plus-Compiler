package AST.declaration;

public class InvalidDeclaration extends RuntimeException {
    public InvalidDeclaration(String message) {
        super(message);
    }
    public InvalidDeclaration(String message, Throwable cause) {
        super(message, cause);
    }
}
