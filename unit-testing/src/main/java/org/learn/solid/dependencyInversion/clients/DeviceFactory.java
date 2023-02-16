package org.learn.solid.dependencyInversion.clients;

import org.learn.solid.dependencyInversion.processes.GeneralManufacturingProcess;
import org.learn.solid.dependencyInversion.processes.LaptopManufacturingProcess;
import org.learn.solid.dependencyInversion.processes.SmartphoneManufacturingProcess;

public class DeviceFactory {

    public static void main(String[] args) {
       // GeneralManufacturingProcess manufacturer = new SmartphoneManufacturingProcess("iPhone");
        GeneralManufacturingProcess manufacturer = new LaptopManufacturingProcess("Macbook");
        manufacturer.launchProcess();
    }

}
