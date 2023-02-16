package org.learn.solid.dependencyInversion.processes;

// Template Method Design Pattern:
// used in abstracting workflows common across many types of objects
// the abstract methods are implemented in the subclasses but are called in the abstract class itself
// as part of generally defined process or flow. More formally it is classified as a behavioural design pattern
// that defines the project skeleton in a method called the template method
public abstract class GeneralManufacturingProcess {

    private String processName;

    public GeneralManufacturingProcess(String processName){
        this.processName = processName;
    }

    // this is the template method
    // defines a general flow without getting into the details
    public void launchProcess() {
        if (processName != null && !processName.isEmpty()) {
            assembleDevice();
            testDevice();
            packageDevice();
            storeDevice();
        } else {
            System.out.println("No process name was specified!");
        }
    };

    protected abstract void assembleDevice();
    protected abstract void testDevice();
    protected abstract void packageDevice();
    protected abstract void storeDevice();


}
