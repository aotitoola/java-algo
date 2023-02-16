package org.learn.solid.srp.clients;

import org.learn.solid.srp.domain.Employee;
import org.learn.solid.srp.reporting.EmployeeReportFormater;
import org.learn.solid.srp.reporting.FormatType;
import org.learn.solid.srp.dao.EmployeeDAO;

public class ClientModule {

    public static void main(String[] args) {
        Employee peggy = new Employee(1, "peggy", "accounting", true);
        ClientModule.hireNewEmployee(peggy);
        printEmployeeReport(peggy, FormatType.XML);
    }

    public static void hireNewEmployee(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.saveEmployee(employee);
    }

    public static void terminateEmployee(Employee employee) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteEmployee(employee);
    }

    public static void printEmployeeReport(Employee employee, FormatType formatType) {
        EmployeeReportFormater formater = new EmployeeReportFormater(employee, formatType);
        System.out.println(formater.getFormattedEmployee());
    }


}
