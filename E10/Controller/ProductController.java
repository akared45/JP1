package E10.Controller;

import E10.Entity.Product;
import E10.Service.ProductService;

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void getProductById(String id) {
        Product product=productService.getProductById(id);
        System.out.println(product);
    }
    public void addProduct(String id, String name, int quantity) {
        productService.addProduct(id,name,quantity);
    }
}
