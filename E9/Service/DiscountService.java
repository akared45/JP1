package E9.Service;

import E9.Entity.Gender;
import E9.Entity.Invoice;

import java.util.List;

public class DiscountService {
    public void applyExtraDiscount(List<Invoice> invoices) {
        invoices.stream()
                .filter(invoice -> invoice.getCustomer().getGender() == Gender.Female)
                .filter(invoice -> invoice.getDate().getMonthValue() == 8)
                .forEach(invoice -> {
                    int discount = invoice.getCustomer().getDiscount();
                    int discountAugust = discount +10 ;
                    double amount=invoice.getAmount();
                    double amountDiscountAugust=amount-(amount*discountAugust/100);
                    invoice.setAmount(amountDiscountAugust);
                });
    }
    public void printInvoices(List<Invoice> invoices) {
        System.out.println("Invoices after applying extra discount for female customers in August:");
        invoices.forEach(System.out::println);
    }
}
