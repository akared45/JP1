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
        customers.add(new Customer("Chi", 1003, Gender.Male, 10));
        customers.add(new Customer("An", 1001, Gender.Female, 20));
        customers.add(new Customer("Binh", 1005, Gender.Female, 20));
        customers.add(new Customer("Lan", 1006, Gender.Female, 15));
        customers.add(new Customer("Minh", 1002, Gender.Male, 5));

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "An", 1001, Gender.Female, 20, 1000));
        accounts.add(new Account(2, "Chi", 1003, Gender.Male, 10, 2000));
        accounts.add(new Account(3, "Binh", 1005, Gender.Female, 20, 3000));
        accounts.add(new Account(4, "Lan", 1006, Gender.Female, 15, 4000));
        accounts.add(new Account(5, "Minh", 1002, Gender.Male, 5, 500));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "Chi", 1003, Gender.Male, 10, 3000, LocalDate.of(2023, 1, 15)));
        invoices.add(new Invoice(2, "Minh", 1002, Gender.Male, 5, 4000, LocalDate.of(2023, 8, 20)));
        invoices.add(new Invoice(3, "Binh", 1005, Gender.Female, 20, 2500, LocalDate.of(2023, 8, 10)));
        invoices.add(new Invoice(4, "An", 1001, Gender.Female, 20, 5000, LocalDate.of(2023, 4, 5)));
        invoices.add(new Invoice(5, "Lan", 1006, Gender.Female, 15, 3500, LocalDate.of(2023, 5, 25)));

        CustomerController customerController = new CustomerController(customers,accounts,invoices);
        AccountController  accountController=new AccountController(accounts);
        InvoiceController invoiceController=new InvoiceController(invoices);
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Menu");
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by ID");
            System.out.println("3. Search Account by ID or name");
            System.out.println("4. Search Invoice by ID or name");
            System.out.println("5. Customer can pay");
            System.out.println("6. Customer not pay");
            System.out.println("7. Discount August");
            System.out.println("0. Exit");
            System.out.print("Select method:");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    List<Customer> sortedCustomersByName=customerController.sortByName();
                    System.out.println("Customers sorted by name:");
                    sortedCustomersByName.forEach(System.out::println);
                    break;
                case 2:
                    List<Customer> sortedCustomersById=customerController.sortById();
                    System.out.println("Customers sorted by Id:");
                    sortedCustomersById.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Id or Name for search account customer: ");
                    String keywordAccount = sc.nextLine();
                    List<Account> searchAccount= accountController.searchByIDorName(keywordAccount);
                    System.out.println("Account found:");
                    searchAccount.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter Id or Name for search invoice customer: ");
                    String keywordInvoice = sc.nextLine();
                    List<Invoice> searchInvoice= invoiceController.searchByIDorName(keywordInvoice);
                    System.out.println("Invoice found: ");
                    searchInvoice.forEach(System.out::println);
                    break;
                case 5:
                    List<Customer> canPay=customerController.canPay();
                    System.out.println("Customers can pay:");
                    canPay.forEach(System.out::println);
                    break;
                case 6:
                    List<Customer> notPay=customerController.notPay();
                    System.out.println("Customers not pay (excluding discounts) :");
                    notPay.forEach(System.out::println);
                    break;
                case 7:
                    List<Invoice> discountAugust = invoiceController.discount();
                    System.out.println("Discount August for customer:");
                    discountAugust.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Exit!");
                    sc.close();
                    return;
                default:
                    System.out.println("Error!");
                    return;
            }

        }

    }
}
