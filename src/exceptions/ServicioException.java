package exceptions;

public class ServicioException extends Exception {

    public ServicioException() {
    }

    public ServicioException(String message) {
        super(message);
    }

    public ServicioException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicioException(Throwable cause) {
        super(cause);
    }

    public ServicioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}