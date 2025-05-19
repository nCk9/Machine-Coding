package org.ElevatorSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ElevatorManager{

    private static ElevatorManager elevatorManagerInstance;
//    ArrayList<Elevator> elevatorsList;
    public static Map<Integer, ElevatorStats> currentStats;
    ElevatorAssignmentStrategy elevatorAssignmentStrategy;

    private ElevatorManager(){
//        elevatorsList = new ArrayList<>(4);
        currentStats = new HashMap<>(4);
        for(int i=0; i<4; i++)
            currentStats.put(i, new ElevatorStats());
        elevatorAssignmentStrategy = new VerticalDistanceAssignmentStrategy();
    }

    public static synchronized ElevatorManager getInstance(){
        if(elevatorManagerInstance == null)
            elevatorManagerInstance  = new ElevatorManager();
        return elevatorManagerInstance;
    }

    public int assignElevator(int userCurrentFloor, int userDestinationFloor){
        return elevatorAssignmentStrategy.assignElevator(userCurrentFloor, userDestinationFloor, currentStats);
    }

    public void updatePositions(){
        for(int key : currentStats.keySet()){

        }
    }
}
