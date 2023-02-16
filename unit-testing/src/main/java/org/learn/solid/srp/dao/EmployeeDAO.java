package org.learn.solid.srp.dao;


import org.learn.solid.srp.domain.Employee;

// DAO stands for Data Access Objects - for data storage and data deletion
public class EmployeeDAO {

    public void saveEmployee(Employee employee) {
        System.out.println("save employee to the database.");
    }

    public void deleteEmployee(Employee employee) {
        System.out.println("delete employee from the database.");
    }


}
