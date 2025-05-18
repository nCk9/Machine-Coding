package org.ParkingLot.ParkingSpot;

public abstract class ParkingSpotAssigner {
      //TODO -> assign a parking spot, make a call to parkingTicketGenerator, return the ticket.
    public abstract ParkingSpot getParkingSpot(String vehicleType, String vehicleNumber);

}
