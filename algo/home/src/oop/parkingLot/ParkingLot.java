package oop.parkingLot;

public class ParkingLot {

    // Both the Entrance and Exit classes use this class to create and close parking tickets
    private static ParkingLot parkingLot = null;

    private ParkingLot() {
        // Call the name, address, parking_rate elements of the customer in the parking lot from the database
        // Create initial entrance and exit hashmaps respectively
    }

    public static ParkingLot GetInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

}
