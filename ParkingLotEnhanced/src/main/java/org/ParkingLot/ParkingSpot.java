package org.ParkingLot;

public class ParkingSpot {

    private final Integer spotId;
    private final ParkingSpotType parkingSpotType;
    private boolean isOccupied;
    public ParkingSpot(Integer spotId_, ParkingSpotType spotType){
        spotId = spotId_;
        parkingSpotType = spotType;
        isOccupied = false;
    }

    public Integer getSpotId(){
        return spotId;
    }
    public ParkingSpotType getParkingSpotType(){
        return parkingSpotType;
    }
    public boolean getSpotStatus(){
        return isOccupied;
    }
    public void setIsOccupied(boolean spotStatus){
        isOccupied = spotStatus;
    }
}
