package E7;

import E7.Controller.CustomerController;
import E7.Controller.StaffController;
import E7.Entity.Account;
import E7.Entity.Customer;
import E7.Entity.Gender;
import E7.Entity.Staff;
import E7.Service.AccountService;
import E7.Service.CustomerService;
import E7.Service.StaffService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Staff> staffList = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();

        CustomerService cs = new CustomerService(customers);
        CustomerController customerController = new CustomerController(cs);

        StaffService staffService = new StaffService(staffList);
        StaffController staffController = new StaffController(staffService);

        AccountService accountService = new AccountService(accounts);

        customers.add(new Customer(1, "ABCD123", "John", Gender.Male));
        customers.add(new Customer(2, "ASASAS12121", "Week", Gender.Female));
        customers.add(new Customer(3, "VDGVS323", "Unmei", Gender.Female));

        staffList.add(new Staff(1, "STF001", "Alice", LocalDateTime.of(1990, 1, 1, 0, 0)));
        staffList.add(new Staff(2, "STF002", "Bob", LocalDateTime.of(1985, 5, 20, 0, 0)));
        staffList.add(new Staff(3, "STF003", "Charlie", LocalDateTime.of(1992, 12, 30, 0, 0)));

        accounts.add(new Account(1, "ACC001", 1500000, LocalDateTime.now(), customers.get(0)));
        accounts.add(new Account(2, "ACC002", 2000000, LocalDateTime.now(), customers.get(1)));
        accounts.add(new Account(3, "ACC003", 150000, LocalDateTime.now(), customers.get(2)));
        accounts.add(new Account(4, "ACC004", 2000000, LocalDateTime.now(), customers.get(1)));

        System.out.println("===== Customers =====");
        Customer customerById = customerController.getById(5);
        if (customerById != null) {
            System.out.println("Customer by ID 5: " + customerById);
        } else {
            System.out.println("Customer not found by ID 5");
        }

        Customer customerByCode = customerController.getByCode("ABCD123");
        if (customerByCode != null) {
            System.out.println("Customer by code 'ABCD123': " + customerByCode);
        } else {
            System.out.println("Customer not found by code 'ABCD123'");
        }

        List<Customer> customersByName = customerController.getByName("Week");
        if (!customersByName.isEmpty()) {
            System.out.println("List of customers by name 'Week': " + customersByName);
        } else {
            System.out.println("Customer not found by name 'Week'");
        }

        System.out.println("\n===== Staff =====");
        Staff staffById = staffController.getById(4);
        if (staffById != null) {
            System.out.println("Staff by ID 4: " + staffById);
        } else {
            System.out.println("Staff not found by ID 4");
        }

        Staff staffByCode = staffController.getByCode("STF001");
        if (staffByCode != null) {
            System.out.println("Staff by code 'STF001': " + staffByCode);
        } else {
            System.out.println("Staff not found by code 'STF001'");
        }

        List<Staff> staffByName = staffController.getByName("Bob");
        if (!staffByName.isEmpty()) {
            System.out.println("List of staff by name 'Bob': " + staffByName);
        } else {
            System.out.println("Staff not found by name 'Bob'");
        }

        System.out.println("\n===== Accounts =====");
        Account accountByCode = accountService.getAccountByCustomerCode("ABCD123");
        if (accountByCode != null) {
            System.out.println("Account by customer code 'ABCD123': " + accountByCode);
        } else {
            System.out.println("Account not found by customer code 'ABCD123'");
        }

        List<Account> accountsByName = accountService.getAccountByCustomerName("Week");
        if (!accountsByName.isEmpty()) {
            System.out.println("List of accounts by customer name 'Week': " + accountsByName);
        } else {
            System.out.println("Account not found by customer name 'Week'");
        }

        List<Account> maleAccounts = accountService.getAccountByCustomer();
        if (!maleAccounts.isEmpty()) {
            System.out.println("Male accounts with balance > 1,000,000: " + maleAccounts);
        } else {
            System.out.println("No male accounts found with balance > 1,000,000");
        }

        long femaleCount = accountService.countAccountByCustomer();
        if (femaleCount > 0) {
            System.out.println("Total number of female customers with balance > 100,000: " + femaleCount);
        } else {
            System.out.println("No female customers found with balance greater than 100,000.");
        }

        Optional<Account> maxBalanceAccount = accountService.getMaxBalance();
        if (maxBalanceAccount.isPresent()) {
            System.out.println("Female customer with the highest balance: " + maxBalanceAccount.get());
        } else {
            System.out.println("No female customers found.");
        }

    }
}
