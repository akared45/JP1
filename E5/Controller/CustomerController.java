package E5.Controller;

import E5.Entity.Account;
import E5.Entity.Customer;
import E5.Entity.Invoice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerController {
    private static List<Customer> customers;
    private static List<Account> accounts; // Add accounts list
    private static List<Invoice> invoices; // Add invoices list

    public CustomerController(List<Customer> customers, List<Account> accounts, List<Invoice> invoices) {
        CustomerController.customers = customers;
        CustomerController.accounts = accounts;
        CustomerController.invoices = invoices;
    }

    public List<Customer> sortByName() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
    }

    public List<Customer> sortById() {
        return customers.stream()
                .sorted(Comparator.comparingInt(Customer::getId_Customer))
                .toList();
    }

    public List<Customer> searchByIDorName(String keyword) {
        return customers.stream()
                .filter(customer -> String.valueOf(customer.getId_Customer()).contains(keyword) ||
                        customer.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    private Account findAccountByCustomerId(int customerId) {
        for (Account account : accounts) {
            if (account.getId_Customer() == customerId) {
                return account;
            }
        }
        return null;
    }

    private Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId_Customer() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> canPay() {
        List<Customer> payableCustomers = new ArrayList<>();
        for (Invoice invoice : invoices) {
            Account account = findAccountByCustomerId(invoice.getId_Customer());
            if (account != null) {
                if (account.getBalance() >= invoice.amountAfterDiscount()) {
                    Customer customer = findCustomerById(invoice.getId_Customer());
                    if (customer != null) {
                        payableCustomers.add(customer);
                    }
                }
            }
        }
        return payableCustomers;
    }

    public List<Customer> notPay() {
        List<Customer> unPayableCustomers = new ArrayList<>();
        for (Invoice invoice : invoices) {
            Account account = findAccountByCustomerId(invoice.getId_Customer());
            if (account != null) {
                if (account.getBalance() < invoice.amountAfterDiscount()) {
                    Customer customer = findCustomerById(invoice.getId_Customer());
                    if (customer != null) {
                        unPayableCustomers.add(customer);
                    }
                }
            }
        }
        return unPayableCustomers;
    }

}
