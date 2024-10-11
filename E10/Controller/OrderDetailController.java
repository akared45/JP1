package E10.Controller;

import E10.Entity.OrderDetails;
import E10.Service.OrderDetailService;
import E10.Service.ProductService;

public class OrderDetailController {
    private OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    public void processOrder(OrderDetails orderDetails) {
            orderDetailService.processOrder(orderDetails);
    }

    public void printProductList() {
        orderDetailService.printProductList();
    }


}
