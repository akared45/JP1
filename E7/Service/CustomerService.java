package E7.Service;

import E7.Entity.Customer;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.List;

public class CustomerService implements IGeneral<Customer> {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Customer getByCode(String code) {
        return customers.stream()
                .filter(customer -> customer.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getByName(String keyword) {
        return customers.stream()
                .filter(customer -> Global.ignoreCase(customer.getName(), keyword))
                .toList();
    }
}
