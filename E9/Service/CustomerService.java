package E9.Service;

import E9.Entity.Customer;
import E9.Entity.Gender;
import E9.Entity.Invoice;
import E9.General.IGeneric;

import java.util.Comparator;
import java.util.List;

public class CustomerService implements IGeneric<Customer> {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void update(Customer newCustomer) {
        customers.stream()
                .filter(customer -> customer.getId() == newCustomer.getId())
                .findFirst()
                .ifPresentOrElse(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setGender(newCustomer.getGender());
                    customer.setDiscount(newCustomer.getDiscount());
                    System.out.println("Customer updated: " + customer.getName() + " - Discount: " + customer.getDiscount() + "%");
                }, () -> {
                    System.out.println("No customer found with ID: " + newCustomer.getId());
                });
    }

    @Override
    public List<Customer> sort(List<Customer> items) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getId))
                .toList();
    }

    @Override
    public Customer findById(int id) {
        return customers.stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void printCustomer() {
        customers.forEach(System.out::println);
    }
}

