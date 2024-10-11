package E10.Controller;

import E10.Entity.Customer;
import E10.Service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void getCustomerById(int id) {
        Customer customer = customerService.getCustomerById(id);
        System.out.println(customer.toString());
    }
}
