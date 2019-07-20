package exceptions;

public class EtalonElementNotFoundException extends RuntimeException {
    String message;

    public EtalonElementNotFoundException(String message) {
        this.message = message;
    }
}
