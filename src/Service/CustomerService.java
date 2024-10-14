package Service;

import Entity.Customer;
import IGeneral.IGeneric;

import java.util.List;

public class CustomerService implements IGeneric<Customer> {
  private List<Customer> customerList;

  public CustomerService(List<Customer> customerList) {
    this.customerList = customerList;
  }

  @Override
  public Customer getById(int id) {
    return customerList.stream()
            .filter(c -> c.getId()==id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public List<Customer> getByName(String name) {
    return null;
  }

  @Override
  public List<Customer> getAll() {
    return null;
  }

  @Override
  public void add(Customer customer) {

  }

  @Override
  public Customer update(Customer customer) {
    return null;
  }

  @Override
  public void delete(Customer customer) {

  }
}
