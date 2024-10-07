package E9.Controller;

import E9.Entity.Customer;
import E9.Entity.Invoice;
import E9.Service.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void updateCustomer(Customer newCustomer) {
        customerService.update(newCustomer);
    }

    public void printCustomers() {
        customerService.printCustomer();
    }

    public List<Customer> sortCustomer(List<Customer> customers) {
        return customerService.sort(customers);
    }

    public Customer findById(int id) {
        return customerService.findById(id);
    }
}
