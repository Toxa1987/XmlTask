package by.anton.xmltask.exception;

public class GemEntityException extends Exception {
    public GemEntityException() {
    }

    public GemEntityException(String message) {
        super(message);
    }

    public GemEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public GemEntityException(Throwable cause) {
        super(cause);
    }
}
