package E10new.Service;

import E10new.Entity.Product;
import E10new.IGeneral.Validator;

public class ProductService {
  private final Validator<Product> productValidator;

  public ProductService(Validator<Product> productValidator) {
    this.productValidator = productValidator;
  }

  public void validateProduct(Product product) throws Exception {
    this.productValidator.validate(product);
    System.out.println("Product: " + product.toString());
  }
}
