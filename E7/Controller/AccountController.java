package E7.Controller;

import E7.Entity.Account;
import E7.Service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account getAccountByCustomerCode(String code) {
        return accountService.getAccountByCustomerCode(code);
    }

    public List<Account> getAccountByCustomerName(String keyword) {
        return accountService.getAccountByCustomerName(keyword);
    }

    public List<Account> getAccountByCustomer(){
        return accountService.getAccountByCustomer();
    }

    public long countAccountByCustomer(){
        return accountService.countAccountByCustomer();
    }

    public Optional<Account> getMaxBalance() {
        return accountService.getMaxBalance();
    }
}
