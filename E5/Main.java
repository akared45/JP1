package E5;

import E5.Controller.AccountController;
import E5.Controller.CustomerController;
import E5.Controller.InvoiceController;
import E5.Entity.Account;
import E5.Entity.Customer;
import E5.Entity.Gender;
import E5.Entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Bob", Gender.Female, 5));   // Khách hàng nữ với 5% giảm giá
        customers.add(new Customer(2, "Charlie", Gender.Male, 10)); // Khách hàng nam với 10% giảm giá
        customers.add(new Customer(3, "Alice", Gender.Male, 0));   // Khách hàng nam không có giảm giá
        customers.add(new Customer(4, "Diana", Gender.Female, 15)); // Khách hàng nữ với 15% giảm giá

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1001, customers.get(0), 500)); // Bob: 500
        accounts.add(new Account(1002, customers.get(1), 300)); // Charlie: 300
        accounts.add(new Account(1003, customers.get(2), 0));   // Alice: 0
        accounts.add(new Account(1004, customers.get(3), 1000)); // Diana: 1000

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 200, LocalDate.of(2024, 10, 6)));  // Bob: Hóa đơn không trong tháng 8
        invoices.add(new Invoice(2, customers.get(1), 400, LocalDate.of(2024, 9, 15)));  // Charlie: Hóa đơn không trong tháng 8
        invoices.add(new Invoice(3, customers.get(2), 100, LocalDate.now()));            // Alice: Hóa đơn hôm nay
        invoices.add(new Invoice(4, customers.get(3), 300, LocalDate.of(2024, 8, 10)));  // Diana: Hóa đơn trong tháng 8
        invoices.add(new Invoice(5, customers.get(0), 150, LocalDate.of(2024, 8, 5)));

        CustomerController customerController = new CustomerController(customers, accounts, invoices);
        AccountController accountController = new AccountController(accounts);
        InvoiceController invoiceController = new InvoiceController(invoices);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Sort by name");
            System.out.println("2. Search Account by ID or name");
            System.out.println("3. Search Invoice by ID or name");
            System.out.println("4. Customer can pay");
            System.out.println("5. Customer not pay");
            System.out.println("6. Discount August");
            System.out.println("0. Exit");
            System.out.print("Select method:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    List<Customer> sortedCustomersByName = customerController.sortCustomersByName();
                    System.out.println("Customers sorted by name:");
                    sortedCustomersByName.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter Id or Name for search account customer: ");
                    String keyword = sc.nextLine();
                    List<Account> foundAccountCustomers = accountController.searchCustomerByNameOrId(keyword);
                    if (foundAccountCustomers.isEmpty()) {
                        System.out.println("Customer not found.");
                    } else {
                        System.out.println("Customer found:");
                        foundAccountCustomers.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Enter Id or Name for search invoice customer: ");
                    String keyword1 = sc.nextLine();
                    List<Invoice> foundInvoiceCustomers = invoiceController.searchCustomerByNameOrId(keyword1);
                    if (foundInvoiceCustomers.isEmpty()) {
                        System.out.println("Customer not found.");
                    } else {
                        System.out.println("Customer found:");
                        foundInvoiceCustomers.forEach(System.out::println);
                    }
                    break;
                case 4:
                    List<Customer> customerCanPay = customerController.getCustomersAbleToPay();
                    if (customerCanPay.isEmpty()) {
                        System.out.println("No customers have sufficient balance to pay the invoice.");
                    } else {
                        System.out.println("List of customers who can pay the invoice:");
                        customerCanPay.forEach(System.out::println);
                    }
                    break;
                case 5:
                    List<Customer> customerNotPay = customerController.getCustomersUnableToPay();
                    if (customerNotPay.isEmpty()) {
                        System.out.println("All customers have sufficient balance to pay the invoice.");
                    } else {
                        System.out.println("List of customers who cannot pay the invoice:");
                        customerNotPay.forEach(System.out::println);
                    }
                    break;
                case 6:
                    List<Invoice> discountAugust = invoiceController.discount();
                    if (discountAugust.isEmpty()) {
                        System.out.println("No customers have discount.");
                    }else{
                        System.out.println("Discount August for customer:");
                        discountAugust.forEach(System.out::println);
                    }
                    break;
            }
        }

    }
}
