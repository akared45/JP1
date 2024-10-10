//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package E10new.Entity;

public class Product {
  private String id;
  private String name;
  private int quantity;

  public Product() {
  }

  public Product(String id, String name, int quantity) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String toString() {
    return "Product{id=" + this.id + ", name='" + this.name + "', quantity=" + this.quantity + "}";
  }
}
