package org.ParkingLot;

import org.ParkingLot.ParkingSpot.FloorWiseParkingSpotAssigner;
import org.ParkingLot.ParkingSpot.ParkingSpot;
import org.ParkingLot.ParkingSpot.ParkingSpotAssigner;
import org.ParkingLot.ParkingTicket.ParkingTicket;
import org.ParkingLot.ParkingTicket.ParkingTicketFactory;

public class ParkingLot {
    private static ParkingLot instance;
    public Integer numberOfParkingSpots;
    public ParkingTicketFactory ticketFactory;
//    public SpotAssigningStrategyFactory spotAssigningStrategyFactory;
    public ParkingSpotAssigner spotAssigner;

    private ParkingLot(){
        numberOfParkingSpots = 81;
        ticketFactory = new ParkingTicketFactory();
        spotAssigner = new FloorWiseParkingSpotAssigner();
    }

    public static ParkingLot getInstance(){
        if(instance == null)
            instance = new ParkingLot();
        return instance;
    }

    public ParkingSpot assignParkingSpot(String vehicleType, String vehicleNumber){
        return spotAssigner.getParkingSpot(vehicleType, vehicleNumber);
    }

    public ParkingTicket getParkingTicket(ParkingSpot parkingSpot, String vehicleNumber){
        ParkingTicket parkingTicketInstance =  ticketFactory.getParkingTicket("General");
        return parkingTicketInstance.generateAndReturnParkingTicket(parkingSpot, vehicleNumber);
    }
}
