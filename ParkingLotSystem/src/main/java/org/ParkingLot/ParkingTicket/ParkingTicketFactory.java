package org.ParkingLot.ParkingTicket;

import org.ParkingLot.ParkingSpot.ParkingSpot;

public class ParkingTicketFactory {

    public ParkingTicket getParkingTicket(String ticketType){
        if(ticketType.equalsIgnoreCase("general"))
            return new GeneralParkingTicket();
        return new VIPParkingTicket();
    }
}
