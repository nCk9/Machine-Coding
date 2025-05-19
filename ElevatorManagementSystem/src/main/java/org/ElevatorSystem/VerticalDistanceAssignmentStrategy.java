package org.ElevatorSystem;

import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class VerticalDistanceAssignmentStrategy implements ElevatorAssignmentStrategy{
    @Override
    public synchronized int assignElevator(int userCurrentFloor, int userDestinationFloor, Map<Integer, ElevatorStats> currentStats){
        int assignedElevatorId = -1;
        int eta = 123456789;
        for(int key: currentStats.keySet()){
            int timeOfETA = getTimeOfArrival(currentStats.get(key), userCurrentFloor, userDestinationFloor);
            if(timeOfETA < eta) {
                eta = timeOfETA;
                assignedElevatorId = key;
            }
        }
        return assignedElevatorId;
    }

    private synchronized int getTimeOfArrival(ElevatorStats elevatorStats, int userCurrentFloor, int userDestinationFloor) {
        int liftCurrentFloor = elevatorStats.getCurrentFloor();
        return abs(liftCurrentFloor - userCurrentFloor);
    }
}
