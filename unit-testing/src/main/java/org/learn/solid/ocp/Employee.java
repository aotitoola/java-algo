package org.learn.solid.ocp;


// all derivatives of this class must implement the abstract methods
// The approach to fix this is called the Strategy design pattern
// Strategy Design Pattern - is defined as a pattern that enables an algorithm's behaviour to be selected at runtime
// we encapsulated the details of the kind of work an employee does. clients can now use a consistent interface to tell
// employees to perform their respective activities without getting into the details of what they are and how specific
// employees perform them

// we could also use an interface for this, we could have defined an interface e.g. EmployeeWork and
// added the performDuties behaviour and have all our employees implement that interface
// both approaches allows for extraction.
public abstract class Employee {

    // making these private prevents clients from being able
    // to modify these objects internal state directly
    private int id;
    private String name;
    private String department;
    private boolean working;

    public Employee(int id, String name, String department, boolean working) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.working = working;
    }

    public abstract void performDuties();

    // present the object in a readable format
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", working=" + working +
                '}';
    }



}
