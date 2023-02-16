package org.learn.solid.interfaceSegregation;

public class AccountsReceivable {

    private Accounting transaction;

    public AccountsReceivable(Accounting transaction) {
        this.transaction = transaction;
    }

    public void postPayment() {
        transaction.chargeCustomer();
    }

    public void sendInvoice() {
        transaction.prepareInvoice();
        // sends the invoice
    }
}
