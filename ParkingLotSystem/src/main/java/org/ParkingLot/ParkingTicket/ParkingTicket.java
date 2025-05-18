package org.ParkingLot.ParkingTicket;

import org.ParkingLot.ParkingSpot.ParkingSpot;

public interface ParkingTicket {
    public ParkingTicket generateAndReturnParkingTicket(ParkingSpot parkingSpot, String vehicleNumber);
}
