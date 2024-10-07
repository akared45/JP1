package E9.Controller;

import E9.Entity.Account;
import E9.Entity.Customer;
import E9.Entity.Invoice;
import E9.Service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void updateAccount(Account newAccount) {
        accountService.update(newAccount);
    }

    public void printAccount() {
        accountService.printAccounts();
    }

    public List<Account> sortAccounts(List<Account> accounts) {
        return accountService.sort(accounts);
    }

    public Account findById(int id) {
        return accountService.findById(id);
    }
}
