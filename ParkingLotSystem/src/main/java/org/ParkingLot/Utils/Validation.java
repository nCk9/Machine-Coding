package org.ParkingLot.Utils;

import org.ParkingLot.ParkingSpot.ParkingSpotType;

public class Validation {
    public static boolean validateInput(String inputString){
        return inputString.equalsIgnoreCase(ParkingSpotType.FOUR_WHEELER.toString()) || inputString.equalsIgnoreCase(ParkingSpotType.TWO_WHEELER.toString());
    }
}
