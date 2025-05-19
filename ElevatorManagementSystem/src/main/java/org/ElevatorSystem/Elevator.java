package org.ElevatorSystem;

import java.util.UUID;

public class Elevator {
    UUID elevatorId;
    int capacity;

    Elevator(){
        elevatorId = new UUID((long)(Math.random()*100), 4);
        capacity = 800;
    }
}
