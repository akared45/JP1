package Entity;

import java.time.LocalDateTime;

public class Order {
  private int id;
  private String code;
  private Customer customer;
  private LocalDateTime localDateTime;

  public Order() {
  }

  public Order(int id,String code, Customer customer, LocalDateTime localDateTime) {
    this.id = id;
    this.code = code;
    this.customer = customer;
    this.localDateTime = localDateTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", customer=" + customer +
            ", localDateTime=" + localDateTime +
            '}';
  }
}
