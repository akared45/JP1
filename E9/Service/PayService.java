package E9.Service;

import E9.Entity.Account;
import E9.Entity.Invoice;

import java.util.List;

public class PayService {
    private List<Account> accounts;

    public PayService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccountsCanPay(List<Invoice> invoices) {
        return accounts.stream()
                .filter(account -> invoices.stream()
                        .anyMatch(invoice ->
                                account.getCustomer().getId()==invoice.getCustomer().getId() &&
                                account.getBalance()>= invoice.getMountAfterDiscount()
                        ))
                .toList();
    }

    public void printAccountsCanPay(List<Invoice> invoices) {
        List<Account> accountsCanPay = getAccountsCanPay(invoices);
        if (!accountsCanPay.isEmpty()) {
            System.out.println("Accounts with enough balance to pay the invoice:");
            accountsCanPay.forEach(account -> {
                System.out.println("Account ID: " + account.getId() +
                        ", Customer: " + account.getCustomer().getName() +
                        ", Balance: " + account.getBalance());
            });
        } else {
            System.out.println("No accounts have enough balance to pay the invoice.");
        }
    }

    public List<Account> getAccountsNotPay(List<Invoice> invoices) {
        return accounts.stream()
                .filter(account -> invoices.stream()
                        .anyMatch(invoice ->
                                account.getCustomer().getId()==invoice.getCustomer().getId() &&
                                        account.getBalance()< invoice.getAmount()
                        ))
                .toList();
    }

    public void printAccountsNotPay(List<Invoice> invoices) {
        List<Account> accountsNotPay = getAccountsNotPay(invoices);
        if (!accountsNotPay.isEmpty()) {
            System.out.println("Accounts with not enough balance to pay the invoice:");
            accountsNotPay.forEach(account -> {
                System.out.println("Account ID: " + account.getId() +
                        ", Customer: " + account.getCustomer().getName() +
                        ", Balance: " + account.getBalance());
            });
        } else {
            System.out.println("All accounts have enough balance to pay the invoice.");
        }
    }
}
