package cc.conyli.test;

public class CustomerNotfoundError extends RuntimeException {

    public CustomerNotfoundError(String message) {
        super(message);
    }

    public CustomerNotfoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotfoundError(Throwable cause) {
        super(cause);
    }

}
