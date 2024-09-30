package Entity;

public class SavingAcount extends BankAccount {
  public SavingAcount(String accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    setBalance(getBalance() + amount);
    System.out.println("Deposit of $ " + amount + " \nSuccessful\nCurrent balance $ " + getBalance());
  }

  @Override
  public void withdraw(double amount) {
    if(getBalance() >= amount){
      setBalance(getBalance() - amount);
      System.out.println("Withdrawing $ " + amount + " \nSuccessful\nCurrent balance $ " + getBalance());
    }else {
      System.out.println("Insuffcient funds\nWithdrawal failed");
    }
  }
}
