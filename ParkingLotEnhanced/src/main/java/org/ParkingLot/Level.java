package org.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {
    private final List<ParkingSpot> parkingSpotList;
    private final Map<ParkingSpotType, List<ParkingSpot>> spotTypeLocMap;

    public Level(Integer numParkingSpotsPerLevel){
        parkingSpotList = new ArrayList<>(numParkingSpotsPerLevel);
        int eachSpotTypeAllotment = numParkingSpotsPerLevel/3;
        spotTypeLocMap = new HashMap<>(eachSpotTypeAllotment);
        int spotId = 0; List<ParkingSpotType> spotTypes = new ArrayList<>(3);
        spotTypes.add(0, ParkingSpotType.CAR);
        spotTypes.add(1, ParkingSpotType.BIKE);
        spotTypes.add(2, ParkingSpotType.TRUCK);
        for(int i=0; i<3; i++){
            ParkingSpotType type = spotTypes.get(i);
            ArrayList<ParkingSpot> spots = new ArrayList<>(eachSpotTypeAllotment);
            for(int j=0; j<eachSpotTypeAllotment; j++){
                ParkingSpot spot = new ParkingSpot(spotId, type);
                spots.add(j, spot);
                parkingSpotList.add(spot);
                spotId++;
            }
            spotTypeLocMap.put(type, spots);
        }
    }

    public ParkingSpot getNextParkingSpot(){

    }
}
