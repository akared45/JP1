package E4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Vinh",10));
        customers.add(new Customer(2,"Thanh",20));
        customers.add(new Customer(3,"Le",30));

        List<Invoice> invoices=new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 500));
        invoices.add(new Invoice(2, customers.get(1), 10000));
        invoices.add(new Invoice(3, customers.get(2), 6000));

//        1) Display info Invoice by ID of Customer
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Id customer : ");
        int customerID=sc.nextInt();
        System.out.println("Infor customer ID : " + customerID);
        invoices.stream()
                .filter(invoice -> invoice.getCustomer().getID() == customerID)
                .forEach(System.out::println);
//        2) Get Info of Customer has total getAmount() is MAX
        Optional<Invoice> amountMax = invoices.stream()
                .max(Comparator.comparingDouble(Invoice::getAmountAfterDiscount));
        System.out.println(amountMax);
//        3) Get info Customer has setDiscount is MIN
        Optional<Invoice> discountMin = invoices.stream()
                .min(Comparator.comparing(invoice->invoice.getCustomer().getDiscount()));
        System.out.println(discountMin);
//        4) Search and display Customer via Invoice(Id) or Customer(Name)
        System.out.println("Enter Invoice ID : ");
        int invoiceID=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Customer Name : ");
        String customerName=sc.nextLine();
        invoices.stream()
                .filter(invoice -> invoice.getId() == invoiceID)
                .forEach(System.out::println);
        customers.stream()
                .filter(customer -> customer.getName().toLowerCase().contains(customerName))
                .forEach(System.out::println);

    }
}
