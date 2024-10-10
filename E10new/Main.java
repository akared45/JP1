package E10new;

import E10new.Entity.Customer;
import E10new.Entity.Order;
import E10new.Entity.OrderDetails;
import E10new.Entity.Product;
import E10new.IGeneral.Validator;
import E10new.Service.CustomerService;
import E10new.Service.OrderDetailsService;
import E10new.Service.OrderService;
import E10new.Service.ProductService;
import E10new.Validation.CustomerValidation;
import E10new.Validation.OrderDetailValidation;
import E10new.Validation.OrderValidation;
import E10new.Validation.ProductValidation;
import java.time.LocalDateTime;

public class Main {
  public Main() {
  }

  public static void main(String[] args) {

    try {
      Customer customer = new Customer(1, "John Doe");
      Product product = new Product("MS123456", "Laptop", 10);
      Order order = new Order("ORDPM12345678", customer, LocalDateTime.now());
      OrderDetails orderDetail = new OrderDetails(1, order, product, 2, "Pending");

      Validator<Customer> customerValidator = new CustomerValidation();
      Validator<Product> productValidator = new ProductValidation();
      Validator<Order> orderValidator = new OrderValidation();
      Validator<OrderDetails> orderDetailsValidator = new OrderDetailValidation(product);

      CustomerService customerService = new CustomerService(customerValidator);
      ProductService productService = new ProductService(productValidator);
      OrderService orderService = new OrderService(orderValidator);
      OrderDetailsService orderDetailsService = new OrderDetailsService(productValidator, orderDetailsValidator);

      customerService.validateCustomer(customer);
      productService.validateProduct(product);
      orderService.validateOrder(order);
      orderDetailsService.validateOrderDetails(product, orderDetail);

    } catch (Exception var13) {
      System.out.println("Error: " + var13.getMessage());
    }

  }
}
