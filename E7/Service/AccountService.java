package E7.Service;

import E7.Entity.Account;
import E7.Entity.Gender;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService{
    private List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountByCustomerCode(String code) {
        return accounts.stream()
                .filter(a->a.getCustomer().getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public List<Account> getAccountByCustomerName(String keyword) {
        return accounts.stream()
                .filter(a->Global.ignoreCase(a.getCustomer().getName(),keyword))
                .toList();
    }

    public List<Account> getAccountByCustomer() {
        return accounts.stream()
                .filter(account -> account.getBalance() > 1000000)
                .filter(account -> account.getCustomer().getGender() == Gender.Male)
                .toList();
    }

    public long countAccountByCustomer() {
        return accounts.stream()
                .filter(account -> account.getBalance() > 100000)
                .filter(account -> account.getCustomer().getGender() == Gender.Female)
                .count();
    }

    public Optional<Account> getMaxBalance() {
        return accounts.stream()
                .filter(account -> account.getCustomer().getGender() == Gender.Female)
                .max(Comparator.comparing(Account::getBalance));
    }
}
