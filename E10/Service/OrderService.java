package E10.Service;

import E10.Entity.Order;
import E10.Exception.NotFoundCustomerIdException;
import E10.Exception.NotFoundOrderIdException;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private final List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }
    public Order getOrderById(String id) {
        try {
            Optional<Order> order = orders.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
            if (!order.isPresent()) {
                throw new NotFoundOrderIdException("Order ID: " + id + " not found");
            }
            return order.get();
        } catch (Exception e) {
            System.err.println("An error occurred while finding order: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Completed search operation for order ID: " + id);
        }
    }
}
