package E10new.Service;

import E10new.Entity.Order;
import E10new.IGeneral.Validator;

public class OrderService {
  private Validator<Order> orderValidator;

  public OrderService(Validator<Order> orderValidator) {
    this.orderValidator = orderValidator;
  }

  public void validateOrder(Order order) throws Exception {
    this.orderValidator.validate(order);
    System.out.println(order);
  }
}