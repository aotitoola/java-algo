package org.learn.solid.dependencyInversion.processes;

public class SmartphoneManufacturingProcess extends GeneralManufacturingProcess{

    public SmartphoneManufacturingProcess(String processName) {
        super(processName);
    }

    @Override
   public void assembleDevice() {
        System.out.println("assemble device.");
    }

    @Override
    public void testDevice() {
        System.out.println("test device.");
    }

    @Override
    public void packageDevice() {
        System.out.println("package device.");
    }

    @Override
    public void storeDevice() {
        System.out.println("store device.");
    }
}
