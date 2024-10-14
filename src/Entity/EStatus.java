package Entity;

public enum EStatus {
  PENDING("Pending"),
  PAID("Paid"),
  COMPLETED("Completed"),
  CANCELLED("Cancelled"),;
  private final String labelStatus;

  private EStatus(String labelStatus) {
    this.labelStatus = labelStatus;
  }

  public String getLabelStatus() {
    return labelStatus;
  }

}
