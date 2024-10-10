package E10new.Service;

import E10new.Entity.Customer;
import E10new.IGeneral.Validator;

public class CustomerService {
  private Validator<Customer> customerValidator;

  public CustomerService(Validator<Customer> customerValidator) {
    this.customerValidator = customerValidator;
  }

  public void validateCustomer(Customer customer) throws Exception {
    this.customerValidator.validate(customer);
    System.out.println("Customer: " + customer.toString());
  }
}
