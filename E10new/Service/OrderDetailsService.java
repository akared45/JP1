package E10new.Service;

import E10new.Entity.OrderDetails;
import E10new.Entity.Product;
import E10new.IGeneral.Validator;

public class OrderDetailsService {
  private Validator<Product> productValidator;
  private Validator<OrderDetails> orderDetailValidator;

  public OrderDetailsService(Validator<Product> productValidator, Validator<OrderDetails> orderDetailValidator) {
    this.productValidator = productValidator;
    this.orderDetailValidator = orderDetailValidator;
  }

  public void validateOrderDetails(Product product, OrderDetails orderDetails) throws Exception {
    this.productValidator.validate(product);
    this.orderDetailValidator.validate(orderDetails);
    product.setQuantity(product.getQuantity() - orderDetails.getQuantity());
    System.out.println("Order processed successfully. Updated product quantity: " + product.getQuantity());
  }
}
