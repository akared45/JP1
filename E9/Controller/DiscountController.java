package E9.Controller;

import E9.Entity.Invoice;
import E9.Service.DiscountService;

import java.util.List;

public class DiscountController {
    private DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void applyExtraDiscount(List<Invoice> invoices) {
        discountService.printInvoices(invoices);
    }
}
