package org.learn.solid.srp.reporting;

import org.learn.solid.srp.domain.Employee;

public class EmployeeReportFormater extends ReportFormatter {

    public EmployeeReportFormater (Employee employee, FormatType formatType) {
        super(employee, formatType);
    }

    public String getFormattedEmployee() {
        return getFormattedValue();
    }
}
