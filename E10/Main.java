package E10;

import E10.Controller.CustomerController;
import E10.Controller.OrderController;
import E10.Controller.OrderDetailController;
import E10.Controller.ProductController;
import E10.Entity.*;
import E10.Service.CustomerService;
import E10.Service.OrderDetailService;
import E10.Service.OrderService;
import E10.Service.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John1 Doe"));
        customers.add(new Customer(2, "Jane Smith"));
        customers.add(new Customer(3, "Alice Johnson"));

        List<Product> products = new ArrayList<>();
        products.add(new Product("MS123456", "Laptop", 10));
        products.add(new Product("NE654321", "Smartphone", 20));
        products.add(new Product("SE987654", "Tablet", 15));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORDPM00000001", customers.get(0), LocalDateTime.now()));
        orders.add(new Order("ORDPM00000002", customers.get(1), LocalDateTime.now()));

        List<OrderDetails> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetails(1, orders.get(0), products.get(0), 2, Status.PENDING));
        orderDetails.add(new OrderDetails(2, orders.get(0), products.get(1), 1, Status.COMPLETED));
        orderDetails.add(new OrderDetails(3, orders.get(1), products.get(0), 3, Status.PAID));

        CustomerService customerService = new CustomerService(customers);
        CustomerController customerController = new CustomerController(customerService);

        ProductService productService = new ProductService(products);
        ProductController productController = new ProductController(productService);

        OrderService orderService = new OrderService(orders);
        OrderController orderController = new OrderController(orderService);

        OrderDetailService orderDetailService=new OrderDetailService(products);
        OrderDetailController orderDetailController = new OrderDetailController(orderDetailService);

        customerController.getCustomerById(1);

        Product product = new Product("MS123456", "Laptop", 10);
        OrderDetails orderDetail = new OrderDetails(1,orders.get(0),product, 8,Status.PAID);
        orderDetailController.processOrder(orderDetail);
        orderDetailController.printProductList();

        productController.getProductById("MS123456");
        productController.addProduct("MS123333","a",1);
        orderController.getOrderById("ORDPM00000001");
    }
}
