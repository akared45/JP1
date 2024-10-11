
package E10.Entity;

public enum Status {
    PENDING("Male"),
    COMPLETED("Female"),
    CANCEL("Other"),
    PAID("Paid");

    private String statusLabel;

    Status(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }
}
