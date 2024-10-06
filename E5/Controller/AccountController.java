package E5.Controller;

import E5.Entity.Account;
import E5.Global.Global;

import java.util.List;

public class AccountController {
    private static List<Account> accounts;

    public AccountController(List<Account> accounts) {
        AccountController.accounts = accounts;
    }

    public List<Account> searchCustomerByNameOrId(String keyword) {
        return accounts.stream()
                .filter(account -> Global.ignoreCase(keyword, account.getCustomer().getName()) ||
                        String.valueOf(account.getId()).contains(keyword))
                .toList();
    }

}
