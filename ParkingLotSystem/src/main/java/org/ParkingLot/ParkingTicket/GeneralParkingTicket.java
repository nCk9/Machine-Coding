package org.ParkingLot.ParkingTicket;

import com.sun.beans.editors.DoubleEditor;
import org.ParkingLot.ParkingSpot.ParkingSpot;

import java.sql.Time;

public class GeneralParkingTicket implements ParkingTicket{

    public ParkingSpot parkingSpot;
    public String vehicleNumber;
    public long arrivalTime;
    public Time departureTime;
    public Integer parkingSpotNumber;
    public Double amount;

    GeneralParkingTicket(){
    }

    @Override
    public GeneralParkingTicket generateAndReturnParkingTicket(ParkingSpot parkingSpot1, String vehicleNumber1){
        (this).parkingSpot = parkingSpot1;
        (this).vehicleNumber = vehicleNumber1;
        (this).arrivalTime = System.currentTimeMillis();

        return this;
    }
}
