package org.learn.solid.interfaceSegregation;

import java.util.Date;
import java.util.List;

public class CustomerTransaction implements Accounting, Reporting {

    private List<Product> products;
    private Customer customer;

    public CustomerTransaction(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }

    @Override
    public String getName() {
        return customer.getName();
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public String productBreakdown() {

        StringBuilder reportList = new StringBuilder();

        for (Product product : products) {
            reportList.append(product.getProductName());
        }

        return reportList.toString();
    }

    @Override
    public void prepareInvoice() {
        System.out.println("invoice prepared");
    }

    @Override
    public String chargeCustomer() {
        return "charged the customer";
    }
}
