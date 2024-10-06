package E5.Controller;

import E5.Entity.Customer;
import E5.Entity.Gender;
import E5.Entity.Invoice;
import E5.Global.Global;

import java.time.Month;
import java.util.List;

public class InvoiceController {
    private static List<Invoice> invoices;

    public InvoiceController(List<Invoice> invoices) {
        InvoiceController.invoices = invoices;
    }

    public List<Invoice> searchCustomerByNameOrId(String keyword) {
        return invoices.stream()
                .filter(invoice -> Global.ignoreCase(keyword, invoice.getCustomer().getName()) ||
                                String.valueOf(invoice.getId()).contains(keyword))
                .toList();
    }
    public List<Invoice> discount() {
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getGender()== Gender.Female)
                .filter(invoice -> invoice.getDate().getMonth() == Month.AUGUST)
                .map(invoice -> {
                    Customer customer = invoice.getCustomer();
                    int discount = customer.getDiscount();
                    int totalDiscount = discount + 10;
                    customer.setDiscount(totalDiscount);
                    return invoice;
                })
                .toList();
    }

}
