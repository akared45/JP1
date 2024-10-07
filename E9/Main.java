package E9;
import E9.Controller.*;
import E9.Entity.Customer;
import E9.Entity.Account;
import E9.Entity.Invoice;
import E9.Entity.Gender;
import E9.Service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(4, "Bob", Gender.Female, 5));   // Khách hàng nữ với 5% giảm giá
        customers.add(new Customer(1, "Charlie", Gender.Female, 10)); // Khách hàng nam với 10% giảm giá
        customers.add(new Customer(3, "Alice", Gender.Female, 0));   // Khách hàng nam không có giảm giá
        customers.add(new Customer(2, "Diana", Gender.Female, 15)); // Khách hàng nữ với 15% giảm giá

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1004, customers.get(0), 500)); // Bob: 500
        accounts.add(new Account(1003, customers.get(1), 300)); // Charlie: 300
        accounts.add(new Account(1001, customers.get(2), 0));   // Alice: 0
        accounts.add(new Account(1002, customers.get(3), 1000)); // Diana: 1000

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(5, customers.get(0), 200, LocalDate.of(2024, 10, 6)));  // Bob: Hóa đơn không trong tháng 8
        invoices.add(new Invoice(2, customers.get(1), 400, LocalDate.of(2024, 9, 15)));  // Charlie: Hóa đơn không trong tháng 8
        invoices.add(new Invoice(1, customers.get(2), 100, LocalDate.now()));            // Alice: Hóa đơn hôm nay
        invoices.add(new Invoice(4, customers.get(3), 300, LocalDate.of(2024, 8, 10)));  // Diana: Hóa đơn trong tháng 8
        invoices.add(new Invoice(2, customers.get(0), 150, LocalDate.of(2024, 8, 5)));

        CustomerService customerService = new CustomerService(customers);
        CustomerController customerController = new CustomerController(customerService);

        AccountService accountService = new AccountService(accounts);
        AccountController accountController = new AccountController(accountService);

        InvoiceService invoiceService = new InvoiceService(invoices);
        InvoiceController invoiceController = new InvoiceController(invoiceService);

        PayService payService = new PayService(accounts);
        PayController payController = new PayController(payService);

        DiscountService discountService = new DiscountService();
        DiscountController discountController = new DiscountController(discountService);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Update customer");
            System.out.println("2. Update account");
            System.out.println("3. Update invoice");
            System.out.println("4. Sort by id customer");
            System.out.println("5. Sort by id account");
            System.out.println("6. Sort by id invoice");
            System.out.println("7. Find customer by id");
            System.out.println("8. Find account by id");
            System.out.println("9. Find invoice by id");
            System.out.println("10. Account can pay");
            System.out.println("11. Account can not pay");
            System.out.println("12. Extra discount August");
            System.out.println("0. Exit");
            System.out.print("Select method:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Customer updatedCustomer1 = new Customer(1, "Alice Smith", Gender.Female,100);
                    customerController.updateCustomer(updatedCustomer1);
                    System.out.println("Customers after update:");
                    customerController.printCustomers();
                    break;
                case 2:
                    Account updatedAccount1 = new Account(1001, customers.get(0), 20000000);
                    accountController.updateAccount(updatedAccount1);
                    System.out.println("Accounts after update:");
                    accountController.printAccount();
                    break;
                case 3:
                    Invoice updatedInvoice = new Invoice(3, customers.get(2), 200, LocalDate.now());
                    invoiceController.updateInvoice(updatedInvoice);
                    System.out.println("Invoices after update:");
                    invoiceController.printInvoice();
                    break;
                case 4:
                    List<Customer> sortedCustomers = customerController.sortCustomer(customers);
                    System.out.println("\nCustomer sort:");
                    sortedCustomers.forEach(System.out::println);
                    break;
                case 5:
                    List<Account> sortedAccounts = accountController.sortAccounts(accounts);
                    System.out.println("\nAccounts sort:");
                    sortedAccounts.forEach(System.out::println);
                    break;
                case 6:
                    List<Invoice> sortedInvoices = invoiceController.sortInvoice(invoices);
                    System.out.println("\nInvoices sort:");
                    sortedInvoices.forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("Enter customer ID to find: ");
                    int idC = sc.nextInt();
                    Customer foundCustomer=customerController.findById(idC);
                    if (foundCustomer != null) {
                        System.out.println("Found: " + foundCustomer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter account ID to find: ");
                    int idA = sc.nextInt();
                    Account foundAccount=accountController.findById(idA);
                    if (foundAccount != null) {
                        System.out.println("Found: " + foundAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 9:
                    System.out.print("Enter invoice ID to find: ");
                    int idI = sc.nextInt();
                    Invoice foundInvoice=invoiceController.findById(idI);
                    if (foundInvoice != null) {
                        System.out.println("Found: " + foundInvoice);
                    } else {
                        System.out.println("Invoice not found.");
                    }
                    break;
                case 10:
                    payController.printAccountCanPay(invoices);
                    break;
                case 11:
                    payController.printAccountNotPay(invoices);
                    break;
                case 12:
                    discountController.applyExtraDiscount(invoices);
                    break;
                default:
                    break;
            }
        }

    }
}
