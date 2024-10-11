package E10.Service;

import E10.Entity.Product;
import E10.Exception.InvalidProductIdException;
import E10.Exception.InvalidProductNameException;
import E10.Exception.InvalidQuantityException;
import E10.Exception.NotFoundOrderIdException;
import E10.Validation.ProductValidation;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public Product getProductById(String id) {
        try {
            Optional<Product> product = products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
            if (!product.isPresent()) {
                throw new NotFoundOrderIdException("Product ID: " + id + " not found");
            }
            return product.get();
        } catch (Exception e) {
            System.err.println("An error occurred while finding product: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Completed search operation for product ID: " + id);
        }
    }

    public void addProduct(String id,String name, int quantity) {
        try{
            if (!ProductValidation.validateId(id)) {
                throw new InvalidProductIdException("Invalid Product ID: " + id);
            }
            if (!ProductValidation.validateName(name)) {
                throw new InvalidProductNameException("Invalid Product Name: " + name);
            }
            if (!ProductValidation.validateQuantity(quantity)) {
                throw new InvalidQuantityException("Invalid Quantity: " + quantity);
            }

            Product product = new Product(id, name, quantity);
            products.add(product);
            System.out.println("Product added successfully.");
            printProductList();
        }catch (InvalidProductIdException | InvalidProductNameException | InvalidQuantityException e) {
            System.err.println("Error adding product: " + e.getMessage());
        }
    }
    public void printProductList() {
        if (products.isEmpty()) {
            System.out.println("No products in the list.");
        } else {
            System.out.println("Product List:");
            products.stream()
                    .forEach(System.out::println);
        }
    }
}
