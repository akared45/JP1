
package E10new.Validation;

import E10new.Entity.Order;
import E10new.Exception.InvalidIdException;
import E10new.IGeneral.Validator;
import java.util.regex.Pattern;

public class OrderValidation implements Validator<Order> {
  public OrderValidation() {
  }

  public void validate(Order order) throws Exception {
    Pattern idPattern = Pattern.compile("(ORDPM)[0-9]{8}");
    if (!idPattern.matcher(order.getId()).matches()) {
      throw new InvalidIdException("Mã đơn hàng không hợp lệ. Định dạng hợp lệ là ORDPM theo sau bởi 8 chữ số.");
    }
  }
}