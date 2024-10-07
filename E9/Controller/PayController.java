package E9.Controller;

import E9.Entity.Account;
import E9.Entity.Invoice;
import E9.Service.PayService;

import java.util.List;

public class PayController {
    private PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    public void printAccountCanPay(List<Invoice> invoices) {
        payService.printAccountsCanPay(invoices);
    }

    public void printAccountNotPay(List<Invoice> invoices) {
        payService.printAccountsNotPay(invoices);
    }
}
