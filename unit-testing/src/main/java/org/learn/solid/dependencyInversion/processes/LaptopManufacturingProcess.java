package org.learn.solid.dependencyInversion.processes;

public class LaptopManufacturingProcess extends GeneralManufacturingProcess{
    public LaptopManufacturingProcess(String processName) {
        super(processName);
    }

    @Override
    public void assembleDevice() {
        System.out.println("assemble laptop.");
    }

    @Override
    public void testDevice() {
        System.out.println("test laptop.");
    }

    @Override
    public void packageDevice() {
        System.out.println("package laptop.");
    }

    @Override
    public void storeDevice() {
        System.out.println("store laptop.");
    }
}
