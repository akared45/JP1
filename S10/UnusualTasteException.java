package S10;

public class UnusualTasteException extends Exception {
    private String message;
    public UnusualTasteException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
