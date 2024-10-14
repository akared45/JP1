package Exception;

public class InvalidProductQuantityException extends RuntimeException {
  public InvalidProductQuantityException() {
  }

  public InvalidProductQuantityException(String message) {
    super(message);
  }

  public InvalidProductQuantityException(String message, Throwable cause) {
    super(message, cause);
  }
}
