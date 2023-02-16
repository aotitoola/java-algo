package org.learn.solid.ocp;

public class Doctor extends Employee {
    public Doctor(int id, String name, String department, boolean working) {
        super(id, name, department, working);
        System.out.println("Doctor in action...");
    }

    @Override
    public void performDuties() {
        diagnosePatient();
        prescribeMedicine();
    }

    // Doctors
    private void prescribeMedicine() {
        System.out.println("Prescribe Medicine...");
    }

    private void diagnosePatient() {
        System.out.println("Diagnosing patient...");
    }
}
