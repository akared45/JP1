package Entity;

public class BankAccount {
  private String accountNumber;
  private double balance;

  public BankAccount() {
  }

  public BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
  }

  public void withdraw(double amount){

  }
  @Override
  public String toString() {
    return "BankAccount{" +
            "accountNumber='" + accountNumber + '\'' +
            ", balance=" + balance +
            '}';
  }
}
