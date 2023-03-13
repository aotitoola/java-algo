package oop.parkingLot;


public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle vehicle;


    public boolean getIsFree() {
        return isFree;
    };
    public abstract boolean AssignVehicle(Vehicle vehicle);
    public abstract boolean RemoveVehicle();
}
