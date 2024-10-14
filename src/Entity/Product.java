package Entity;

public class Product {
  private int id;
  private String name;
  private String code;
  private int quantity;

  public Product() {
  }

  public Product(int id, String code,String name, int quantity) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Product update(Product product){
    this.setName(product.getName());
    this.setQuantity(product.getQuantity());
    return this;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", quantity=" + quantity +
            '}';
  }
}
