package E7.Service;

import E7.Entity.Customer;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.List;

public class CustomerService implements IGeneral<Customer> {
    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Customer getByCode(String code) {
        for (Customer customer : customers) {
            if (customer.getCode().equalsIgnoreCase(code)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getByName(String keyword) {
        return this.customers.stream().filter((c) -> {
            return Global.ignoreCase(c.getName(), keyword);
        }).toList();
    }
}
