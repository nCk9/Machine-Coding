package org.ParkingLot.ParkingSpot;
import java.util.ArrayList;

//consider making this singleton as well. In concurrent environment, it'll be required.
public class FloorWiseParkingSpotAssigner extends ParkingSpotAssigner{
    Integer numberOfSpots;
    Integer numFloors;
    Integer spotsPerFloor;
    ArrayList<ArrayList<ParkingSpot>> spots;

    public FloorWiseParkingSpotAssigner(){
        numberOfSpots = 100;
        numFloors = 4;
        spotsPerFloor = numberOfSpots/numFloors;
        spots = new ArrayList<ArrayList<ParkingSpot>>(numFloors);
        for(int i=0; i<numFloors; i++){
            ArrayList<ParkingSpot> floorSpots = new ArrayList<>(spotsPerFloor);
            for(int j=0; j<spotsPerFloor; j++)
                floorSpots.add(new ParkingSpot());
            spots.add(i, floorSpots);
        }

        System.out.println(spots);
    }

    @Override
    public ParkingSpot getParkingSpot(String vehicleType, String vehicleNumber){
        int floor = 0;
        int spot = 0;
        for(int i=0; i<numFloors; i++){
            for(int j=0; j<spotsPerFloor; j++)
                if(spots.get(i).get(j).getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                        floor = i;
                        spot = j;
                        spots.get(i).get(j).setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
                        break;
                }
        }
         spots.get(floor).get(spot).setParkingSpotId(floor*spotsPerFloor + spot + 1);
//        notifyAll();
        return spots.get(floor).get(spot);
    }
}
