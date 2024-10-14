import Controller.ProductController;
import Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.InvalidProductCodeException;
import Service.ProductService;

public class Main {
  public static void main(String[] args){
    List<Product> products = new ArrayList<Product>();
    ProductService productService = new ProductService(products);
    ProductController productController=new ProductController(productService);

    Scanner sc=new Scanner(System.in);
    boolean quit=false;
    while (!quit){
      try {
        Product product=new Product();
        System.out.print("Enter product code");
        String productCode = sc.nextLine();
        System.out.print("Enter product name");
        String productName = sc.nextLine();
        System.out.print("Enter product quantity");
        int productQuantity = sc.nextInt();

        product.setId(products.size()+1);
        product.setName(productName);
        product.setCode(productCode);
        product.setQuantity(productQuantity);

        productController.addProduct(product);
        products.forEach(System.out::println);
        quit=true;
      }catch (InvalidProductCodeException invalidProductCodeException){
        System.out.println(invalidProductCodeException.getMessage());
      }
    }

  }
}
