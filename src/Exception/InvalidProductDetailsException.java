package Exception;

public class InvalidProductDetailsException extends RuntimeException {
  public InvalidProductDetailsException() {
  }

  public InvalidProductDetailsException(String message) {
    super(message);
  }

  public InvalidProductDetailsException(String message, Throwable cause) {
    super(message, cause);
  }
}
