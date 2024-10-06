package E5.Controller;

import E5.Entity.Account;
import E5.Entity.Customer;
import E5.Entity.Invoice;

import java.util.Comparator;
import java.util.List;

public class CustomerController {
    private static List<Customer> customers;
    private static List<Account> accounts;
    private static List<Invoice> invoices;

    public CustomerController(List<Customer> customers,List<Account> accounts,List<Invoice> invoices) {
        CustomerController.customers = customers;
        CustomerController.accounts = accounts;
        CustomerController.invoices = invoices;
    }


    public List<Customer> sortCustomersByName() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
    }

    public List<Customer> getCustomersAbleToPay() {
        return invoices.stream()
                .filter(invoice -> {
                    Account account = accounts.stream()
                            .filter(acc -> acc.getCustomer().getId() == invoice.getCustomer().getId())
                            .findFirst()
                            .orElse(null);
                    return account != null && account.getBalance() >= invoice.getMountAfterDiscount();
                })
                .map(Invoice::getCustomer)
                .toList();
    }
    public List<Customer> getCustomersUnableToPay() {
        return invoices.stream()
                .filter(invoice -> {
                    Account account = accounts.stream()
                            .filter(acc -> acc.getCustomer().getId() == invoice.getCustomer().getId())
                            .findFirst()
                            .orElse(null);
                    return account != null && account.getBalance() < invoice.getAmount();
                })
                .map(Invoice::getCustomer)
                .toList();
    }

}
