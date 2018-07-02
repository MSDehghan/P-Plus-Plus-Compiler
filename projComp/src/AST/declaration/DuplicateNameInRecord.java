package AST.declaration;

public class DuplicateNameInRecord extends RuntimeException {
    public DuplicateNameInRecord() {
        super();
    }

    public DuplicateNameInRecord(String message) {
        super(message);
    }
}
