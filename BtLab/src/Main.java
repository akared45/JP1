import Entity.CurrentAccount;
import Entity.SavingAcount;

public class Main {
  public static void main(String[] args){
    double ibal,damt,wamt;
    ibal=1000.00;
    SavingAcount savingAcount=new SavingAcount("SA001",ibal);
    System.out.println("Savings A/c: Initial Balance: $ " +ibal);
    damt=500.00;
    savingAcount.deposit(damt);
    wamt=250.00;
    System.out.println("\nTry to withdraw: $ "+wamt);
    savingAcount.withdraw(wamt);
    System.out.println("");
    ibal=5000.00;

    CurrentAccount currentAccount=new CurrentAccount("CA001",ibal);
    System.out.println("Current A/c: Initial Balance $ " + currentAccount);
    damt=2500.00;
    currentAccount.deposit(1000.0);
    wamt=1250.00;
    currentAccount.withdraw(3000.0);
    wamt=6000.00;
    System.out.println("\nTry to withdraw: $ "+wamt);
    savingAcount.withdraw(wamt);
  }
}
