package E9.Controller;

import E9.Entity.Account;
import E9.Entity.Customer;
import E9.Entity.Invoice;
import E9.Service.InvoiceService;

import java.util.List;

public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void updateInvoice(Invoice newInvoice) {
        invoiceService.update(newInvoice);
    }

    public void printInvoice() {
        invoiceService.printInvoices();
    }

    public List<Invoice> sortInvoice(List<Invoice> invoices) {
        return invoiceService.sort(invoices);
    }
    public Invoice findById(int id) {
        return invoiceService.findById(id);
    }
}
