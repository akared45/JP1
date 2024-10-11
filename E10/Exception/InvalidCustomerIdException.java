package E10.Exception;

public class InvalidCustomerIdException extends RuntimeException {
  public InvalidCustomerIdException() {
  }

  public InvalidCustomerIdException(String message) {
        super(message);
    }

  public InvalidCustomerIdException(String message, Throwable cause) {
    super(message, cause);
  }
}
