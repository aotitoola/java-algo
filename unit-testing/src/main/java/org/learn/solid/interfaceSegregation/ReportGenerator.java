package org.learn.solid.interfaceSegregation;

public class ReportGenerator {

    private Reporting transaction;

    public ReportGenerator(Reporting transaction) {
        this.transaction = transaction;
    }

    public void generateReport(){
        System.out.println(transaction.getName() + " " + transaction.getClass() + " " + transaction.productBreakdown());
    }
}
