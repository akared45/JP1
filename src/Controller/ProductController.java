package Controller;

import Entity.Product;
import Service.ProductService;
import Validation.Validation;
import Exception.InvalidProductDetailsException;
public class ProductController {
  private ProductService productService;

  public ProductController() {
  }

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  public void addProduct(Product product) {
    boolean isCodeValid = Validation.isProductCode(product.getCode());
    boolean isNameValid = Validation.isProductName(product.getName());
    boolean isQuantityValid = Validation.isNumberInteger(String.valueOf(product.getQuantity()));

    if (isCodeValid && isNameValid && isQuantityValid) {
      productService.add(product);

    } else {
      StringBuilder errorMessage = new StringBuilder("Invalid product details: ");
      if (!isCodeValid) {
        errorMessage.append("Product code is not valid. ");
      }
      if (!isNameValid) {
        errorMessage.append("Product name is not valid. ");
      }
      if (!isQuantityValid) {
        errorMessage.append("Product quantity is not valid. ");
      }
      throw new InvalidProductDetailsException(errorMessage.toString());
    }
  }
}
