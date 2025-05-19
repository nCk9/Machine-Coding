package org.ElevatorSystem;

import java.util.Scanner;

public class ElevatorManagementApplication {
    public static long globalTime = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to nCk elevator management system!");

        System.out.print("All lifts are initialized at 0th floor (max is 4th floor).\n Enter your current floor and destination floor: ");

//        int totalFloors = 5;
//        int totalElevators = 4;

        Scanner inputScanner = new Scanner(System.in);
        int currentFloor = inputScanner.nextInt();
        int destinationFloor = inputScanner.nextInt();
        ElevatorManager elevatorManager = ElevatorManager.getInstance();
        int elevatorId = elevatorManager.assignElevator(currentFloor, destinationFloor);
        System.out.println("Assigned elevator is: " + elevatorId); //TODO: make assignElevatorResponse class that returns ETA of the lift as well
//
//        while (true){
//
//            Thread updater = new Thread(elevatorManager::updatePositions);
//            updater.start();
//            updater.wait(5000);
//        }
    }
}