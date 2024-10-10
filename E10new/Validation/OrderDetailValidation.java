package E10new.Validation;

import E10new.Entity.OrderDetails;
import E10new.Entity.Product;
import E10new.Exception.NotEnoughInventoryNumberException;
import E10new.IGeneral.Validator;

public class OrderDetailValidation implements Validator<OrderDetails> {
  private Product product;

  public OrderDetailValidation(Product product) {
    this.product = product;
  }

  public void validate(OrderDetails orderDetails) throws Exception {
    if (orderDetails.getQuantity() > this.product.getQuantity()) {
      throw new NotEnoughInventoryNumberException("Not enough inventory for Product ID: " + this.product.getId());
    }
  }
}
