package E7.Service;

import E7.Entity.Account;
import E7.Entity.Gender;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService implements IGeneral<Account> {
    private final List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account getById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Account getByCode(String code) {
        for (Account account : accounts) {
            if (account.getCustomer().getCode().equalsIgnoreCase(code)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public List<Account> getByName(String keyword) {
        return this.accounts.stream()
                .filter(account -> Global.ignoreCase(account.getCustomer().getName(), keyword))
                .toList();
    }

    public Account getAccountByCustomerCode(String code) {
        return getByCode(code);
    }

    public List<Account> getAccountByCustomerName(String keyword) {
        return getByName(keyword);
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
