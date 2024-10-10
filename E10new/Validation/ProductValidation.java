package E10new.Validation;

import E10new.Entity.Product;
import E10new.Exception.InvalidIdException;
import E10new.Exception.InvalidNameException;
import E10new.Exception.InvalidQuantityException;
import E10new.IGeneral.Validator;
import java.util.regex.Pattern;

public class ProductValidation implements Validator<Product> {
  public ProductValidation() {
  }

  public void validate(Product product) throws Exception {
    Pattern idPattern = Pattern.compile("(MS|NE|SE)[0-9]{6}");
    if (!idPattern.matcher(product.getId()).matches()) {
      throw new InvalidIdException("Định dạng ID sản phẩm không hợp lệ.");
    } else {
      Pattern namePattern = Pattern.compile("[a-zA-Z ]{3,50}");
      if (!namePattern.matcher(product.getName()).matches()) {
        throw new InvalidNameException("Tên sản phẩm không hợp lệ.");
      } else if (product.getQuantity() < 0) {
        throw new InvalidQuantityException("Số lượng không thể dưới 0.");
      }
    }
  }
}
