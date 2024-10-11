package E10.Controller;

import E10.Entity.Order;
import E10.Service.OrderService;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void getOrderById(String id) {
        Order order = orderService.getOrderById(id);
        System.out.println(order.toString());
    }
}
