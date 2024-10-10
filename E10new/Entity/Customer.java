package E10new.Entity;

public class Customer {
  private int id;
  private String name;

  public Customer() {
  }

  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return "Customer{id=" + this.id + ", name='" + this.name + "'}";
  }
}
