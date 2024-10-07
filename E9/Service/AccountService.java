package E9.Service;

import E9.Entity.Account;
import E9.General.IGeneric;

import java.util.Comparator;
import java.util.List;

public class AccountService implements IGeneric<Account> {
    private List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void update(Account newAccount) {
        accounts.stream()
                .filter(account -> account.getId() == newAccount.getId())
                .findFirst()
                .ifPresent(account -> {
                    account.setBalance(newAccount.getBalance());
                    account.setCustomer(newAccount.getCustomer());
                    System.out.println("Account updated: " + account.getId() + " - New Balance: " + account.getBalance());
                });
    }

    @Override
    public List<Account> sort(List<Account> items) {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getId))
                .toList();
    }

    @Override
    public Account findById(int id) {
        return accounts.stream()
                .filter(i->i.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void printAccounts() {
        accounts.forEach(System.out::println);
    }
}
