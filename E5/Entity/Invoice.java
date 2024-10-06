package E5.Entity;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;
    private LocalDate date;

    public Invoice() {
    }

    public Invoice(int id, Customer customer, double amount, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_Invoice) {
        this.id = id_Invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMountAfterDiscount() {
        return amount - (amount * customer.getDiscount() / 100);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id_Invoice=" + id +
                ", customer=" + customer +
                ", amount=" + amount +
                ", amountDiscount=" + getMountAfterDiscount() +
                ", date=" + date +
                '}';
    }
}
