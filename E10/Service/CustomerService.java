package E10.Service;

import E10.Entity.Customer;
import E10.Exception.InvalidCustomerIdException;
import E10.Exception.NotFoundCustomerIdException;
import E10.Validation.CustomerValidation;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomerById(int id)  {
        try {
            if (!CustomerValidation.validateId(id)) {
                throw new InvalidCustomerIdException("Customer ID invalid: " + id);
            }
            Optional<Customer> customer = customers.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst();
            if (!customer.isPresent()) {
                throw new NotFoundCustomerIdException("Customer ID: " + id + " not found");
            }
            return customer.get();
        } catch (Exception e) {
            System.err.println("An error occurred while finding customer: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Completed search operation for customer ID: " + id);
        }
    }

}
