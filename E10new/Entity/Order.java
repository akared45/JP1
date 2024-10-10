//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package E10new.Entity;

import java.time.LocalDateTime;

public class Order {
  private String id;
  private Customer customer;
  private LocalDateTime dateTime;

  public Order() {
  }

  public Order(String id, Customer customer, LocalDateTime dateTime) {
    this.id = id;
    this.customer = customer;
    this.dateTime = dateTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public LocalDateTime getDateTime() {
    return this.dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String toString() {
    String var10000 = this.id;
    return "Order{id=" + var10000 + ", customer=" + String.valueOf(this.customer) + ", dateTime=" + String.valueOf(this.dateTime) + "}";
  }
}
