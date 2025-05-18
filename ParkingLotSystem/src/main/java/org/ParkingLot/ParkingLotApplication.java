package org.ParkingLot;

import org.ParkingLot.ParkingSpot.ParkingSpot;
import org.ParkingLot.ParkingTicket.ParkingTicket;

import java.util.Scanner;

public class ParkingLotApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to nCk ParkingLot!");
        System.out.print("Please enter your vehicle type: ");
        Scanner inputScanner = new Scanner(System.in);
        String vehicleType = inputScanner.next();

        System.out.print("Please enter your vehicle number: ");
        String vehicleNumber = inputScanner.next();
        ParkingLot parkingLotInstance = ParkingLot.getInstance();
        ParkingSpot parkingSpot =  parkingLotInstance.assignParkingSpot(vehicleType, vehicleNumber);

        ParkingTicket parkingTicket = parkingLotInstance.getParkingTicket(parkingSpot, vehicleNumber);
        System.out.println("Please refer to your parking ticket below!");
        System.out.println(parkingTicket);


    }
}