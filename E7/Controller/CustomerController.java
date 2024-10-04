package E7.Controller;

import E7.Entity.Customer;
import E7.Service.CustomerService;
import java.util.List;

public class CustomerController {
    private CustomerService cs;

    public CustomerController( CustomerService cs) {
        this.cs = cs;
    }

    public Customer getById(int id) {
        return this.cs.getById(id);
    }

    public Customer getByCode(String code) {
        return this.cs.getByCode(code);
    }

    public List<Customer> getByName(String keyword) {
        return this.cs.getByName(keyword);
    }
}
