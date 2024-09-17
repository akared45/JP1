import Entity.Customer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer=new Customer();
        //Customer customer1=new Customer(1,"Vinh undercut");
        //System.out.println("ID:"+customer1.getId()+ "\nName:"+customer1.getName());
        //customer1.setName("abc");
        //System.out.println("ID:"+customer1.getId()+ "\nName:"+customer1.getName());
        //System.out.println(customer1);

        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        customer.setId(id);
        customer.setName(name);

        System.out.println(customer);

    }
}