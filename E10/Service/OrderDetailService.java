package E10.Service;
import E10.Entity.OrderDetails;
import E10.Entity.Product;
import E10.Exception.NotEnoughInventoryNumberException;

import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    private List<Product> products;

    public OrderDetailService(List<Product> products) {
        this.products = products;
    }

    public void processOrder(OrderDetails orderDetail) throws NotEnoughInventoryNumberException {
        Product product = orderDetail.getProduct();
        int orderQuantity = orderDetail.getQuantity();

        Optional<Product> productInStockOpt = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst();
        if (!productInStockOpt.isPresent()) {
            throw new IllegalArgumentException("Product not found: " + product.getId());
        }

        Product productInStock = productInStockOpt.get();

        if (productInStock.getQuantity() < orderQuantity) {
            throw new NotEnoughInventoryNumberException("Not enough inventory for product: " + productInStock.getName());
        }

        productInStock.setQuantity(productInStock.getQuantity() - orderQuantity);
        System.out.println("Processed order for " + orderQuantity + " of " + productInStock.getName() + ". Remaining stock: " + productInStock.getQuantity());
    }

    public void printProductList() {
        if (products.isEmpty()) {
            System.out.println("No products in the list.");
        } else {
            System.out.println("Product List:");
            products.stream()
                    .forEach(product -> System.out.println(product));
        }
    }
}
