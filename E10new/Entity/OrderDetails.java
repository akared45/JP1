//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package E10new.Entity;

import E10new.Entity.Product;
public class OrderDetails {
  private int id;
  private Order order;
  private Product product;
  private int quantity;
  private String status;

  public OrderDetails() {
  }

  public OrderDetails(int id, Order order, Product product, int quantity, String status) {
    this.id = id;
    this.order = order;
    this.product = product;
    this.quantity = quantity;
    this.status = status;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Order getOrder() {
    return this.order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String toString() {
    int var10000 = this.id;
    return "OrderDetails{id=" + var10000 + ", order=" + String.valueOf(this.order) + ", product=" + String.valueOf(this.product) + ", quantity=" + this.quantity + ", status='" + this.status + "'}";
  }
}
