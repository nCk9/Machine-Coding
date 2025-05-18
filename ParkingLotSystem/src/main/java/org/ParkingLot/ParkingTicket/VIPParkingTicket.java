package org.ParkingLot.ParkingTicket;

import org.ParkingLot.ParkingLot;
import org.ParkingLot.ParkingSpot.ParkingSpot;

import java.sql.Time;

public class VIPParkingTicket implements ParkingTicket{

    public ParkingSpot parkingSpot;
    public String vehicleNumber;
    public Time arrivalTime;
    public Time departureTime;
    public Integer parkingSpotNumber;
    public Double amount;
    public Double totalRunningAmount;
    public String badge;

    @Override
    public VIPParkingTicket generateAndReturnParkingTicket(ParkingSpot parkingSpot, String vehicleNumber){

        return this;
    }
}
