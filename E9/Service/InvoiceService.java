package E9.Service;

import E9.Entity.Account;
import E9.Entity.Invoice;
import E9.General.IGeneric;

import java.util.Comparator;
import java.util.List;

public class InvoiceService implements IGeneric<Invoice> {
    private List<Invoice> invoices;

    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public void update(Invoice newInvoice) {
        invoices.stream()
                .filter(invoice -> invoice.getId() == newInvoice.getId())
                .findFirst()
                .ifPresentOrElse(invoice -> {
                    invoice.setCustomer(newInvoice.getCustomer());
                    invoice.setAmount(newInvoice.getAmount());
                    invoice.setDate(newInvoice.getDate());
                    System.out.println("Customer updated: " + invoice);
                }, () -> {
                    System.out.println("No customer found with ID: " + newInvoice.getId());
                });
    }

    @Override
    public List<Invoice> sort(List<Invoice> items) {
        return invoices.stream()
                .sorted(Comparator.comparing(Invoice::getId))
                .toList();
    }

    @Override
    public Invoice findById(int id) {
        return invoices.stream()
                .filter(i->i.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void printInvoices() {
        invoices.forEach(invoice -> System.out.println(invoice));
    }
}
