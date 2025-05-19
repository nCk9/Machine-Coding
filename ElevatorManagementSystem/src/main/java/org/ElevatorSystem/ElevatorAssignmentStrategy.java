package org.ElevatorSystem;

import java.util.Map;

public interface ElevatorAssignmentStrategy {
    public int assignElevator(int userCurrentFloor, int userDestinationFloor, Map<Integer, ElevatorStats> currentStats);
}
