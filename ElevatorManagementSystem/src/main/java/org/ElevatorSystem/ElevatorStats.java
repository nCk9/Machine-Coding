package org.ElevatorSystem;

public class ElevatorStats {
    public int currentFloor;
    public int destinationFloor;

    public ElevatorStats(){
        currentFloor = 0;
        destinationFloor = 0;
    }

    int getCurrentFloor(){
        return currentFloor;
    }

    void setCurrentFloor(int currFloor){
        currentFloor = currFloor;
    }

    int getDestinationFloor(){
        return destinationFloor;
    }

    void setDestinationFloor(int destFloor){
        destinationFloor = destFloor;
    }
}

