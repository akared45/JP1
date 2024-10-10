package E10new.Validation;

import E10new.Entity.Customer;
import E10new.Exception.InvalidIdException;
import E10new.Exception.InvalidNameException;
import E10new.IGeneral.Validator;
import java.util.regex.Pattern;

public class CustomerValidation implements Validator<Customer> {
  public CustomerValidation() {
  }

  public void validate(Customer customer) throws Exception {
    Pattern namePattern = Pattern.compile("[a-zA-Z ]{3,50}");
    if (!namePattern.matcher(customer.getName()).matches()) {
      throw new InvalidNameException("Tên khách hàng không hợp lệ. Tên này chỉ được chứa chữ cái và khoảng trắng, dài từ 3 đến 50 ký tự.");
    } else if (customer.getId() <= 0) {
      throw new InvalidIdException("Mã khách hàng không hợp lệ. Phải là số nguyên dương.");
    }
  }
}